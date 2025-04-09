package com.example.Spring_mapStruct_demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/**
 * Custom query method to find a student by their roll number.
 * Spring Data JPA will automatically implement this method based on the method name.
 *
 * @param rollNo - Unique roll number of the student
 * @return Optional containing StudentModel if found, otherwise empty
 */
public interface StudentRepo extends JpaRepository<StudentModel,Integer> {
    Optional<StudentModel> findByRollNo(String rollNo);
}
