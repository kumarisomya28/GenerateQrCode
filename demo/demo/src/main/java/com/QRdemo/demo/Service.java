package com.QRdemo.demo;

import com.QRdemo.demo.Repositories.StudentRepository;
import com.QRdemo.demo.model.Student;
import lombok.RequiredArgsConstructor;

import java.util.List;
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    private final StudentRepository studentRepository;

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
     public Student findById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student not found"));
     }

}
