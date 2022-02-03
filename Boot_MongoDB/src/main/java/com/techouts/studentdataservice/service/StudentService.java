package com.techouts.studentdataservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.techouts.studentdataservice.entity.Student;

public interface StudentService {

	public Student createStudent(Student student);

	public Student getStudentbyId(String id);
	
	public List<Student> getAllStudents();

	//public ResponseEntity<List<Student>> getAllStudents();

	public Student updateStudent(Student student);

	public String deleteStudent(String id);

	public List<Student> getStudentsByName(String name);

	public List<Student> studentsByNameAndMail(String name, String email);

	public List<Student> studentsByNameOrMail(String name, String email);

	public List<Student> byDepartmentName(String deptName);

	public List<Student> bySubjectName(String subName);

	public List<Student> emailLike(String email);

	public List<Student> nameStartsWith(String name);

}
