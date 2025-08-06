package com.spring_boot.spring_data_jpa_tutorial.repository;

import com.spring_boot.spring_data_jpa_tutorial.entity.Course;
import com.spring_boot.spring_data_jpa_tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course courseDBMS = Course.builder()
                .credit(5)
                .title("DBMS")
                .build();

        Course courseJava = Course.builder()
                .credit(6)
                .title("Java")
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Mayank")
                        .lastName("Dar")
                        //.courses(List.of(courseDBMS, courseJava))
                        .build();
        teacherRepository.save(teacher);
    }
}