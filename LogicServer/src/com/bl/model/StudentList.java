package com.bl.model;

import java.util.ArrayList;

public class StudentList {
	private ArrayList<Student> studentList;
	
	public StudentList() {
		studentList = new ArrayList<Student>();
	}
	
	public boolean addStudent(Student s) {
		if(s != null) {
			studentList.add(s);
			return true;
		}
		return false;
	}
	
	public Student findStudentById(int index) {
		if(index > 0 && index < studentList.size()) {
			Student s = studentList.get(index);
			return s;
		}
		return null;
	}
	
	public boolean removeStudentById(int index) {
		if(index > 0 && index < studentList.size()) {
			studentList.remove(index);
			return true;
		}
		return false;
	}
	
	public int size() {
		return studentList.size();
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < studentList.size(); i++) {
			result = studentList.get(i).toString() + "\n";
		}
		
		return result;
	}
}
