package com.aditya.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aditya.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

}
