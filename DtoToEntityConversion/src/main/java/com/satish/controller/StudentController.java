package com.satish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satish.converter.StudentConverter;
import com.satish.dto.StudentDto;
import com.satish.entity.Student;
import com.satish.entity.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired StudentRepository studentRepository;
	@Autowired StudentConverter converter;
	
	@GetMapping("/All")
	public List<StudentDto> findAll(){
		List<Student> findAll = studentRepository.findAll();
		return converter.entityToDto(findAll);
	}
	
	@GetMapping("/find/{ID}")
	public StudentDto findById(@PathVariable(value = "ID")Long id) {
		Student stud = studentRepository.findById(id).orElseThrow(null);
		return converter.entityToDto(stud);
	}
	@PostMapping("/save")
	public StudentDto save(@RequestBody StudentDto dto) {
		Student student = converter.dtoToEntity(dto);
		student = studentRepository.save(student);
		return converter.entityToDto(student);
	}
}
