package com.abhinandre.studentsystem.service;

import com.abhinandre.studentsystem.model.Student;
import com.abhinandre.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<List<Student>> getStudentById(int id){
        try {
            return new ResponseEntity<>(studentRepository.findById(id),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);
    }

    @Override
    public ResponseEntity<Student> updateStudent(int id,Student studentDetails){
        Student student = studentRepository.findByid(id);

        student.setName(studentDetails.getName());
        student.setAddress(studentDetails.getAddress());

        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }


}
