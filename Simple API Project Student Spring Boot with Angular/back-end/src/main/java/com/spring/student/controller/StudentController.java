package com.spring.student.controller;

import com.spring.student.model.Student;
import com.spring.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("system/")
@CrossOrigin("http://localhost:4200")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    public List<Student> getallStudents(@RequestParam int page, int size) {
        return studentService.getallStudents(page, size);
    }

    /*@GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }*/

    @GetMapping("student")
    public Student getStudentById(@RequestParam Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    /*@PutMapping("/updatestudent/{id}")
    public Student updateStudentById(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.saveStudent(student);
    }*/

    @PutMapping("students")
    public Student updateStudentById(@RequestParam Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.saveStudent(student);
    }

    /*@DeleteMapping("/deletestudent/{id}")
    public void removeStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }*/

    @DeleteMapping("students")
    public void removeStudent(@RequestParam Long id) {
        studentService.deleteStudentById(id);
    }

    /*@GetMapping("/searchname/{fullname}")
    public List<Student> findByFullname(@PathVariable String fullname) {
        return this.studentService.findByFullname(fullname);
    }*/

    @GetMapping("students/searchname")
    public List<Student> findByFullName(@RequestParam String fullname, @RequestParam int page, int size) {
        return this.studentService.findByFullname(fullname, page, size);
    }

    @GetMapping("students/length")
    public Long getStudentLength() {
        return studentService.getStudentLength();
    }

    @GetMapping("students/lengthname")
    public Long getStudentLengthByName(@RequestParam String name) {
        return studentService.getStudentLengthByname(name);
    }
}