package com.crudapi.crudapi;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="EmpTable")
public class EmployeeEntity {
    private String Name;
    private String Email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
