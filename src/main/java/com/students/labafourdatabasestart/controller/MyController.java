package com.students.labafourdatabasestart.controller;

import com.students.labafourdatabasestart.entity.Student;
import com.students.labafourdatabasestart.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;
    public MyController(@Qualifier("StudentServiceImpl") StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public List<Student> showAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {

        log.info(student.getName()+" "+student.getId()+" "+student.getSurname());
        return studentService.saveStudent(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }
}
