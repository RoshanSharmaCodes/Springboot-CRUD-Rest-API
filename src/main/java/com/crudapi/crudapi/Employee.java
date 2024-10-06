package com.crudapi.crudapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Employee {
    private String Name;
    private String Email;
    private Long id;
}
