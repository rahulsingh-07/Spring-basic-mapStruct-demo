package com.example.Spring_mapStruct_demo.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring") // This allows Spring to manage the mapper as a Bean for dependency injection
public interface StudentMapper {

    // MapStruct will ignore the following fields while mapping from DTO to Entity
    @Mapping(target = "id", ignore = true) // ID is usually auto-generated, so we ignore it
    @Mapping(target = "department", ignore = true) // Ignored since it's not present in the DTO
    @Mapping(target = "password", ignore = true) // Password should not come from DTO directly
    @Mapping(target = "cgpa", ignore = true) // CGPA is also excluded from client-side input
    @Mapping(target = "aadhaarNumber", ignore = true) // Sensitive data not included in DTO

    /**
     * Converts a StudentDIO (DTO) to StudentModel (Entity).
     * Use this method when you want to createStudent new student data coming from the client.
     */
    StudentModel toEntity(StudentDIO studentDIO);

    /**
     * Converts a StudentModel (Entity) to StudentDIO (DTO).
     * Use this method when sending student data from server to client.
     */
    StudentDIO toDTO(StudentModel studentModel);

    /**
     * Converts a list of StudentModel entities to a list of StudentDIO DTOs.
     */
    List<StudentDIO> toDTOList(List<StudentModel> studentModels);
}
