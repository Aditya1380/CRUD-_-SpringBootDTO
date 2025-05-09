package com.aditya.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aditya.demo.dto.StudentDto;
import com.aditya.demo.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/aditya/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student-created")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<StudentDto>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping("/all-student")
    public ResponseEntity<List<StudentDto>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudentByID(@PathVariable long id) {
        return ResponseEntity.ok(studentService.getStudentByID(id));
    }
    
    @PutMapping("/update-student/{id}")
    public ResponseEntity<StudentDto> updateStudEntity(@PathVariable long id, @RequestBody StudentDto studentDto) {                        
        return ResponseEntity.ok(studentService.updateStudentById(id, studentDto));
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable long id){
        studentService.deleteStudentByID(id);
        return ResponseEntity.noContent().build();
    }

}
