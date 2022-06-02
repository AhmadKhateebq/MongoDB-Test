package com.example.mongodbproject.model;

import com.example.mongodbproject.controllers.dto.CourseDto;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
@Data
@ToString(exclude = {"id"},includeFieldNames = false)
public class Course {
    @Id
    public String id;
    public String code;
    public String name;

    public Course() {}

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public static Course DTO(CourseDto courseDto){
        return new Course (courseDto.getCode (),courseDto.getName ());
    }

}
