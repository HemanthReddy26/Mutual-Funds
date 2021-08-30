package com.hcl.employee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.dto.EmployeeDto;
import com.hcl.employee.dto.EmployeeRequestDto;
import com.hcl.employee.dto.EmployeeResponseDto;
import com.hcl.employee.exception.EmployeeException;
import com.hcl.employee.model.Employee;
import com.hcl.employee.repository.EmployeeRepository;
import com.hcl.employee.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public String saveEmployee(EmployeeRequestDto employeeRequestDto) throws EmployeeException {
		log.info("saveEmployee(): called",employeeRequestDto.getEmployeeName());
		if(employeeRequestDto.getAge()<18) {
			log.warn("Age should not be less than 18");
			throw new EmployeeException("Age should be greater than 18");
		}
		if(((""+employeeRequestDto.getPhoneNo()).length()!=10)) {
			log.warn("Phone number length should be 10");
			throw new EmployeeException("Length of the phone number should be equal to 10");
		}
		
		Employee employee=new Employee();
		BeanUtils.copyProperties(employeeRequestDto,employee);
		employeeRepository.save(employee);
		log.info("Data saved into employee table successfully");
		
		return "Employee added successfully";
	}

	//List of employess those who have greater salary
	@Override
	public List<EmployeeResponseDto> havingGreaterSalary(double salary) throws EmployeeException {
		log.info("Finding the list of employees whose salary is greater than",salary);
		List<Employee> employeeList=(List<Employee>) (employeeRepository.findAll().stream().filter(employee->employee.getSalary()>salary)).
				collect(Collectors.toList());
		if(employeeList.isEmpty()) {
			log.warn("The employee is empty");
			throw new EmployeeException("No employees having salary greater than"+salary);
		}
		return IEmployeeService.convertEmployeeListToEmployeeResponseDtoList(employeeList);
	}

	//list of employees those who have less salary
	@Override
	public List<EmployeeDto> havingLessSalary(double salary) throws EmployeeException {
		log.info("Finding the list of employees whose salary is less than",salary);
		List<Employee> employeeList=(List<Employee>) (employeeRepository.findAll().stream().filter(employee->employee.getSalary()<salary).
				collect(Collectors.toList()));
		if(employeeList.isEmpty()) {
			log.warn("The employee list is empty");
			throw new EmployeeException("No employees having salary less than"+salary);
		}
		return IEmployeeService.convertEmployeeListToEmployeeDtoList(employeeList);
	}
  
	//Providing hike based on the salary
	@Override
	public Map<String, Double> hikeThoseHavinglessSalary(double salary, double providedHike) throws EmployeeException {
		log.info("Giving hike to the list of employees whose salary is less than",salary);
		List<Employee> employeeList=(List<Employee>) (employeeRepository.findAll().stream().filter(employee->employee.getSalary()<salary).
				collect(Collectors.toList()));
		if(employeeList.isEmpty()) {
			log.warn("The employee list is empty");
			throw new EmployeeException("No employees having salary less than"+salary);
		}
		Map<String,Double> map=new HashMap<>();
		employeeList.forEach(emp->{
			emp.setSalary(emp.getSalary()+providedHike);
			map.put(emp.getEmployeeName(),emp.getSalary());
			log.info("Updating the changes on salary column");
			employeeRepository.flush();
			log.info("Changes done successfully");
		});
		return map;
	}
	

}
