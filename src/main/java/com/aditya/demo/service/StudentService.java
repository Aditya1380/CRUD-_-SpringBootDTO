package com.aditya.demo.service;

import java.util.List;

import com.aditya.demo.dto.StudentDto;
import com.aditya.demo.entity.Student;

public interface StudentService {

    StudentDto mapToDTO(Student student);

    Student DtoToEntity(StudentDto studentDto);

    StudentDto createStudent(StudentDto studentDto);//CREATE STUDENT

    List<StudentDto> getAllStudent();//GET ALL STUDENT

    StudentDto getStudentByID(long id);//GET STUDENT BY ID

    StudentDto updateStudentById(long id,StudentDto studentDto);//UPDATE STUDENT BY ID

    void deleteStudentByID(long id);
}
