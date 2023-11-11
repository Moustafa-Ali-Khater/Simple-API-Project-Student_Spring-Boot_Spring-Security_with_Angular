package com.spring.student.service;

import com.spring.student.dao.StudentRepository;
import com.spring.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getallStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable).getContent();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudentById(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findByFullname(String fullname, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.studentRepository.findByFullNameContaining(fullname, pageable);
    }

    public Long getStudentLength() {
        return studentRepository.getStudentsLength();
    }

    public Long getStudentLengthByname(String name) {
        //return studentRepository.findByFullnameContaining(name).size();
        return studentRepository.getStudentsLengthByname(name);
    }
}