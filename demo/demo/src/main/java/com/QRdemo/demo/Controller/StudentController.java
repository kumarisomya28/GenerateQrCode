package com.QRdemo.demo.Controller;

import com.QRdemo.demo.Service;
import com.QRdemo.demo.model.Student;
import com.QRdemo.demo.utils.QRCodeGenerator;
import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final Service service;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() throws IOException, WriterException {
        List<Student> students = service.getStudent();
        if(students.size() != 0) {
            for (Student student : students) {
                QRCodeGenerator.generateQRCode(student);
            }
        }
        return ResponseEntity.ok(service.getStudent());
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);

    }
@GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
}
