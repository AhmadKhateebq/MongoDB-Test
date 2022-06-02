package com.example.mongodbproject.controllers;

import com.example.mongodbproject.controllers.dto.CourseDto;
import com.example.mongodbproject.controllers.mapper.MapStruct;
import com.example.mongodbproject.model.Course;
import com.example.mongodbproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    UserService service;

    MapStruct mapper = MapStruct.INSTANCE;

    @GetMapping("/")
    public List<CourseDto> getAll() {
        return service.getAllUsers ()
                .stream ()
                .map (mapper::COURSE_DTO)
                .collect (Collectors.toList ());
    }

    @PostMapping("/{code}/{name}")
    public String addCourse(@PathVariable String code, @PathVariable String name) {
        service.addCourse (new Course (code, name));
        return code + " : " + name + " added";
    }

    @PostMapping("/")
    public String addCourse(@RequestBody CourseDto courseDto) {
        service.addCourse (Course.DTO (courseDto));
        return courseDto + " added";
    }

    @GetMapping("/c/{code}")
    public CourseDto getByCode(@PathVariable String code) {
        return mapper.COURSE_DTO (service.getByCode (code));
    }

    @GetMapping("/n/{name}")
    public List<CourseDto> getByName(@PathVariable String name) {
        return service.getAllByName (name)
                .stream ()
                .map (mapper::COURSE_DTO)
                .collect (Collectors.toList ());
    }

    @DeleteMapping("/c/{code}")
    public String deleteByCode(@PathVariable String code) {
//        if (service.deleteByCode (code))
//            return "Course with code " + code + " deleted";
//         else
//            return "Course not found";
        service.deleteByCode (code);
        return "Deleted";
    }

    @DeleteMapping("/n/{name}")
    public String deleteAllByName(@PathVariable String name) {
//        if (service.deleteAllByName (name))
//            return "all Course with code " + name + " deleted";
//        else
//            return "Course not found";
        service.deleteAllByName (name);
        return "deleted";
    }

}
