package com.example.mongodbproject.services.impl;

import com.example.mongodbproject.model.Course;
import com.example.mongodbproject.repoistory.CourseRepository;
import com.example.mongodbproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CourseRepository repository;

    @Override
    public void addCourse(Course course) {
        repository.save (course);
    }

    @Override
    public List<Course> getAllUsers() {
        return repository.findAll ();
    }

    @Override
    public Course getByCode(String code) {
        return repository.findAllByCode (code);
    }

    @Override
    public List<Course> getAllByName(String name) {
        return repository.findAllByName (name);
    }

    @Override
    public void deleteCourse(Course course) {
        repository.delete (course);
    }

    @Override
    public void deleteByCode(String code) {
        System.out.println (repository.deleteByCode (code));
    }

    @Override
    public void deleteAllByName(String name) {
        System.out.println (repository.deleteAllByName (name));
    }
}
