package com.hcl.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="employee_name",nullable=false)
	private String employeeName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="phone_no")
	private Long phoneNo;

}
