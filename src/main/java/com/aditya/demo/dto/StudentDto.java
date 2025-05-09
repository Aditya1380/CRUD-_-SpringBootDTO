package com.aditya.demo.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;        
    private String name;    
    private String email;
    private int standard;
}
