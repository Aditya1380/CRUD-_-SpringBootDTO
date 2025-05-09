package com.aditya.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studentmst_sm")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_sm", nullable = false)
    private String name;

    @Column(name = "email_sm", nullable = false, unique = true)
    private String email;

    @Column(name = "standard_sm")
    private int standard;

    @Version
    @Column(name = "version")
    private Integer version;
}
