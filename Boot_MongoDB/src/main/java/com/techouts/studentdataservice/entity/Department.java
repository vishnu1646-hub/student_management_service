package com.techouts.studentdataservice.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Field;

public class Department {

	@Field(name = "department_name")
	@NotNull(message = "department name should not be null")
	@Size(min = 2, message = "department name should be more than 2 characters")
	private String departmentName;

	@NotNull(message = "location should not be null")
	@Size(min = 4, message = "location string should be more than 4 characters")
	private String location;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
