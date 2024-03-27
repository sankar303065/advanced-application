package com.yoga.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoga.backend.model.*;
import com.yoga.backend.repository.courselistRepository;
import com.yoga.backend.dto.request.courselistRequest;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class courselistService {
    private final courselistRepository repository;

    public boolean registerCourse(courselistRequest request) {
        // Creating a new course object from the request
        var course = courselist.builder()
                .pid(request.getPid())
                .courseName(request.getCourseName())
                .academyName(request.getAcademyName())
                .description(request.getDescription())
                .imgUrl(request.getImgUrl())
                .build();
        
        // Saving the course to the repository
        repository.save(course);

        return true;
    }

    public List<courselist> getAllCourses() {
        // Retrieve all courses from the repository
        return repository.findAll();
    }

    public boolean updateCourse(courselistRequest request, Long pid) {
        Optional<courselist> optionalCourse = repository.findById(pid);

        if (optionalCourse.isPresent()) {
            courselist course = optionalCourse.get();
            // Update the fields of the course with the new values from the request
            course.setCourseName(request.getCourseName());
            course.setAcademyName(request.getAcademyName());
            course.setDescription(request.getDescription());
            course.setImgUrl(request.getImgUrl());

            // Save the updated course to the repository
            repository.save(course);

            return true;
        } else {
            // Throw an exception if the course with the specified ID is not found
            throw new EntityNotFoundException("Course with id " + pid + " not found");
        }
    }

    public boolean deleteCourse(Long pid) {
        // Delete the course with the specified ID from the repository
        repository.deleteById(pid);
        return true;
    }
}
