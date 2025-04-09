package com.example.Spring_mapStruct_demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller to handle HTTP requests
public class StudentController {

    @Autowired // Automatically injects the StudentService bean
    private StudentService studentService;

    /**
     * GET endpoint to retrieve all students.
     * URL: /allStudents
     * @return List of StudentDIO (DTOs) for all students
     */
    @GetMapping("/allStudents")
    public List<StudentDIO> gatAllStudent() {
        return studentService.getStudents();
    }

    /**
     * GET endpoint to retrieve a student by their roll number.
     * URL: /student/{rollNo}
     * @param rollNo - The unique roll number of the student
     * @return StudentDIO object of the student
     */
    @GetMapping("/student/{rollNo}")
    public StudentDIO getStudent(@PathVariable String rollNo) {
        return studentService.getStudentByRollNo(rollNo);
    }

    /**
     * POST endpoint to create/save a new student.
     * URL: /saveStudent
     * @param student - The StudentModel entity object from the request body
     * @return The saved StudentModel object
     */
    @PostMapping("/saveStudent")
    public StudentModel createStudent(@RequestBody StudentModel student) {
        return studentService.saveStudent(student);
    }
}
