package com.example.mongodbproject.services;

import com.example.mongodbproject.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    void addCourse(Course course);

    List<Course> getAllUsers();

    Course getByCode(String code);

    List<Course> getAllByName(String name);

    void deleteCourse(Course course);

    void deleteByCode(String code);

    void deleteAllByName(String name);

}
