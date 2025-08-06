package com.spring_boot.spring_data_jpa_tutorial.repository;

import com.spring_boot.spring_data_jpa_tutorial.entity.Guardian;
import com.spring_boot.spring_data_jpa_tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("praveen@gmail.com")
                .firstName("Praveen")
                .lastname("Verma").
//               // .guardianName("Guardian")
//                .guardianEmail("guardian@gmail.com")
//                .guardianMobile("4567544566").
                build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Kamal")
                .email("kamal@gmail.com")
                .mobile("4353435364")
                .build();

        Student student = Student.builder()
                .firstName("kishan")
                .lastname("Kumar")
                .emailId("kishan@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("Student list: " + studentList);
    }

    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("kishan");
        System.out.println("Studnet: " + students);
    }
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("sh");
        System.out.println("Studnet: " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Kamal");
        System.out.println("Students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "praveen@gmail.com"
                );
        System.out.println("Student: " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative(
                "praveen@gmail.com"
        );
        System.out.println("Student: " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNative(
                "praveen@gmail.com"
        );
        System.out.println("Student: " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "Praveen",
                "praveen@gmail.com"
        );
    }
}