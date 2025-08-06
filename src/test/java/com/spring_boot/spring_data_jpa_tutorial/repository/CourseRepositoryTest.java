package com.spring_boot.spring_data_jpa_tutorial.repository;

import com.spring_boot.spring_data_jpa_tutorial.entity.Course;
import com.spring_boot.spring_data_jpa_tutorial.entity.CourseMaterial;
import com.spring_boot.spring_data_jpa_tutorial.entity.Student;
import com.spring_boot.spring_data_jpa_tutorial.entity.Teacher;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse(){
        List<Course> courses =
                courseRepository.findAll();


        System.out.println("course = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Manoj")
                .lastName("Builder")
                .build();

        Course course =
                Course.builder()
                        .title("Python")
                        .credit(4)
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable fistPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                 PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords).getContent();

        Long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        Long totalPages = (long) courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("Total pages: "+totalPages);

        System.out.println("Total Elements: "+totalElements);

        System.out.println("Course = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );

        Pageable sortByCredit =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Page<Course> page =
                courseRepository.findAll(sortByTitle);
        List<Course> courses = page.getContent();
        System.out.println("Couses = "+ courses);
    }

    @Test
    public void  saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .lastName("Mistri")
                .firstName("Pankaj")
                .build();

        Student student = Student.builder()
                .firstName("Abhi")
                .lastname("Baramashi")
                .emailId("abhi@gmail.com")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(7)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}