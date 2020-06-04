package com.satish.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.satish.dto.StudentDto;
import com.satish.entity.Student;

@Component
public class StudentConverter {
	
	public StudentDto entityToDto(Student student) {
		StudentDto dto = new StudentDto();
		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setUsername(student.getUsername());
		dto.setPassword(student.getPassword());
		return dto;
	}
	
	public List<StudentDto> entityToDto(List<Student> student){
		return student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public Student dtoToEntity(StudentDto dto) {
		Student student = new Student();
		student.setId(dto.getId());
		student.setName(dto.getName());
		student.setUsername(dto.getUsername());
		student.setPassword(dto.getPassword());
		return student;
	}
	
	public List<Student> dtoToEntity(List<StudentDto> dto){
		return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
