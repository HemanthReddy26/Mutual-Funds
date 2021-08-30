package com.hcl.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {

	private int employeeId;

	private String employeeName;

	private int age;

	private double salary;

	private String designation;

	private Long phoneNo;

}
