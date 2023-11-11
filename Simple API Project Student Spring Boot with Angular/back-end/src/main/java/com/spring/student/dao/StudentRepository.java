package com.spring.student.dao;

import com.spring.student.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@RepositoryRestResource
//@RepositoryRestResource(collectionResourceRel = "stud", path = "faculty")
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFullNameContaining(String fullname, Pageable pageable);

    //public List<Student> findByFullnameContaining(String fullname);

    @Query("select COUNT(id) from Student")
    public Long getStudentsLength();

    @Query("select COUNT(id) from Student where fullName like %?1%")
    public Long getStudentsLengthByname(String name);
}
