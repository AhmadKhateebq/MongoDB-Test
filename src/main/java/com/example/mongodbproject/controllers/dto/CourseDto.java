package com.example.mongodbproject.controllers.dto;

import lombok.Data;

@Data
public class CourseDto {
    String code;
    String name;

    @Override
    public String toString(){
        return code +" : "+name;
    }
}
