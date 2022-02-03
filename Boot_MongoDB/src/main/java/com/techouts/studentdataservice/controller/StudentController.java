package com.techouts.studentdataservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techouts.studentdataservice.entity.Student;
import com.techouts.studentdataservice.exceptions.StudentServiceException;
import com.techouts.studentdataservice.service.StudentServiceImpl;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentServiceImpl studentService;

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> data = studentService.getAllStudents();
		ResponseEntity<List<Student>> entity = new ResponseEntity<List<Student>>(data, HttpStatus.OK);
		return entity;
	}

	@PostMapping("/create")
	public Student createStudent(@Valid @RequestBody Student student, BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			throw new StudentServiceException("please provide valid json data");
		}
		return studentService.createStudent(student);
	}

	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable String id) {
		return studentService.getStudentbyId(id);
	}

	/*
	 * @GetMapping("/all") public List<Student> getAllStudents() { return
	 * studentService.getAllStudents(); }
	 */

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("/studentsByName/{name}")
	public List<Student> studentsByName(@PathVariable String name) {
		return studentService.getStudentsByName(name);
	}

	@GetMapping("/studentsByNameAndMail")
	public List<Student> studentsByNameAndMail(@RequestParam String name, @RequestParam String email) {
		return studentService.studentsByNameAndMail(name, email);
	}

	@GetMapping("/studentsByNameOrMail")
	public List<Student> studentsByNameOrMail(@RequestParam String name, @RequestParam String email) {
		return studentService.studentsByNameOrMail(name, email);
	}

	@GetMapping("/byDepartmentName")
	public List<Student> byDepartmentName(@RequestParam String deptName) {
		return studentService.byDepartmentName(deptName);
	}

	@GetMapping("/bySubjectName")
	public List<Student> bySubjectName(@RequestParam String subName) {
		return studentService.bySubjectName(subName);
	}

	@GetMapping("/emailLike")
	public List<Student> emailLike(@RequestParam String email) {
		return studentService.emailLike(email);
	}

	@GetMapping("/nameStartsWith")
	public List<Student> nameStartsWith(@RequestParam String name) {
		return studentService.nameStartsWith(name);
	}

}
