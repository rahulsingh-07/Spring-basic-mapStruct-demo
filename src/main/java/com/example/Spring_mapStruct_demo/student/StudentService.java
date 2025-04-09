package com.example.Spring_mapStruct_demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    // Injecting the Student repository to interact with the database
    @Autowired
    private StudentRepo studentRepo;

    // Injecting the mapper to convert between DTO and entity
    @Autowired
    private StudentMapper studentMapper;

    /**
     * Fetches all students from the database,
     * converts the list of StudentModel (entity) to StudentDIO (DTO),
     * and returns it to the caller.
     */
    public List<StudentDIO> getStudents() {
        List<StudentModel> list = studentRepo.findAll();
        return studentMapper.toDTOList(list);
    }

    /**
     * Saves a new student using data from a StudentDIO object.
     * Converts DTO to entity before saving to the database.
     */
    public StudentModel saveStudent(StudentDIO studentDIO) {
        return studentRepo.save(studentMapper.toEntity(studentDIO));
    }

    /**
     * Retrieves a student from the database by roll number.
     * Converts the StudentModel to StudentDIO if found,
     * or returns an empty DTO if not present.
     */
    public StudentDIO getStudentByRollNo(String rollNo) {
        return studentRepo.findByRollNo(rollNo)
                .map(studentMapper::toDTO)
                .orElse(new StudentDIO());
    }

    /**
     * Saves a student directly using a StudentModel object.
     * This method skips the DTO conversion step.
     */
    public StudentModel saveStudent(StudentModel student) {
        return studentRepo.save(student);
    }
}
