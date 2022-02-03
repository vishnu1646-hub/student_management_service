package com.techouts.studentdataservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techouts.studentdataservice.entity.Student;
import com.techouts.studentdataservice.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		logger.info("adding a new student to the database");
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentbyId(String id) {
		logger.info("getting student by specific id");
		return studentRepository.findById(id).get();
	}

	/*
	 * public List<Student> getAllStudents() { return studentRepository.findAll(); }
	 */

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = studentRepository.findAll();
		logger.info("getting all the list of students from database");
		return list;
	}

	@Override
	public Student updateStudent(Student student) {
		logger.info("updating the existing student in the database");
		return studentRepository.save(student);
	}

	@Override
	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		logger.info("student has been successfully deleted based on id");
		return "Student has been delted...!!!!!!!!!";
	}

	@Override
	public List<Student> getStudentsByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public List<Student> studentsByNameAndMail(String name, String email) {
		return studentRepository.findByNameAndEmail(name, email);
	}

	@Override
	public List<Student> studentsByNameOrMail(String name, String email) {
		return studentRepository.findByNameOrEmail(name, email);
	}

	@Override
	public List<Student> byDepartmentName(String deptName) {
		return studentRepository.findByDepartmentDepartmentName(deptName);
	}

	@Override
	public List<Student> bySubjectName(String subName) {
		return studentRepository.findBySubjectsSubjectName(subName);
	}

	@Override
	public List<Student> emailLike(String email) {
		return studentRepository.findByEmailIsLike(email);
	}

	@Override
	public List<Student> nameStartsWith(String name) {
		return studentRepository.findByNameStartsWith(name);
	}

}
