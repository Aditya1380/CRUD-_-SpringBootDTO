package com.aditya.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aditya.demo.dto.StudentDto;
import com.aditya.demo.entity.Student;
import com.aditya.demo.repository.StudentRepository;
import com.aditya.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto mapToDTO(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setStandard(student.getStandard());
        return studentDto;
    }

    @Override
    public Student DtoToEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setStandard(studentDto.getStandard());
        return student;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = DtoToEntity(studentDto);
        if (student.getId() != null && studentRepository.existsById(student.getId())) {
            Student existingStudent = studentRepository.findById(student.getId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setStandard(student.getStandard());
            student = existingStudent;
        }

        return mapToDTO(studentRepository.save(student));
    }

    @Override
    public List<StudentDto> getAllStudent() {
        return studentRepository.findAll()// Find All Student
                .stream() // Stream Data
                .map(this::mapToDTO)// Maps Data To student DTO
                .collect(Collectors.toList());// converts Data processed Data into List
    }

    @Override
    public StudentDto getStudentByID(long id) {
        return studentRepository.findById(id)
        .map(this::mapToDTO)
        .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public StudentDto updateStudentById(long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id)
            .orElseThrow(()->new RuntimeException("Student Not found"));
            student.setName(studentDto.getName());
            student.setEmail(studentDto.getEmail());
            student.setStandard(studentDto.getStandard());
            return mapToDTO(studentRepository.save(student));
    }

    @Override
    public void deleteStudentByID(long id) {
        Student student = studentRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Student Not found"));
        studentRepository.delete(student);        
    }



    

}
