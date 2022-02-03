package com.techouts.studentdataservice.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Field;

public class Subject {

	@Field(name = "subject_name")
	@NotNull(message = "subject name should not be null")
	@Size(min = 3, message = "subject name string should be more than 3 characters")
	private String subjectName;

	@Field(name = "marks_obtained")
	@NotNull(message = "marks obtained should not be null")
	private int marksObtained;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

}
