package com.abhinandre.studentsystem.service;

import com.abhinandre.studentsystem.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    ResponseEntity<List<Student>> getStudentById(int id);

    ResponseEntity<Student> updateStudent(int id, Student studentDetails);
}
