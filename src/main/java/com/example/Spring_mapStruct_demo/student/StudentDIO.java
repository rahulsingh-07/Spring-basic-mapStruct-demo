package com.example.Spring_mapStruct_demo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDIO {
    private String name;
    private String rollNo;
    private String email;
    private Date birthdate;
    private String department;

}
