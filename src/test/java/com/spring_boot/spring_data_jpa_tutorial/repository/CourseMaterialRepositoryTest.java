package com.spring_boot.spring_data_jpa_tutorial.repository;

import com.spring_boot.spring_data_jpa_tutorial.entity.Course;
import com.spring_boot.spring_data_jpa_tutorial.entity.CourseMaterial;
import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){
        Course course = Course.builder()
                .title("CN")
                .credit(4)
                .build();
        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.oracle.com")
                        .course(course)
                        .build();


        repository.save(courseMaterial);
    }

    @Test
    public void printAllCoursesMaterial(){
        List<CourseMaterial> courseMaterials =
                repository.findAll();
        System.out.println("CourseMaterials: " + courseMaterials);
    }
}