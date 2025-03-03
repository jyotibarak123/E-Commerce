package com.ducat.dao;

import java.util.List;

import com.ducat.modal.Student;

public interface StudentDao {

	int registerStudent(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(int id);
	List<Student> getAllStudents();
	Student getStudentById(Student student);
	Student getStudentByEmail(String email);
	Student validateUser(String email,String password);
	String[] getColumnsName();
	

}
