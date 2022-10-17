package com.example.springcrudapilivesession;

import com.example.springcrudapilivesession.course.dto.CourseReqDto;
import com.example.springcrudapilivesession.course.entity.Course;
import com.example.springcrudapilivesession.course.reposiotry.CourseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringCrudApiLiveSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCrudApiLiveSessionApplication.class, args);
    }

    @Resource
    private CourseRepository courseRepository;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            File json = ResourceUtils.getFile("classpath:CourseData.json");

            List<CourseReqDto> list = new ObjectMapper().readValue(json,new TypeReference<List<CourseReqDto>>(){});
            List<Course> courses = list.stream().map(Course::new).collect(Collectors.toCollection(ArrayList::new));

            courseRepository.saveAll(courses);
        };
    }

}
