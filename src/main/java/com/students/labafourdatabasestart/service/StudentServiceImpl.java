package com.students.labafourdatabasestart.service;

import com.students.labafourdatabasestart.dao.StudentDAO;
import com.students.labafourdatabasestart.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;
    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
    @Override
    @Transactional
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }
    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }
    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
