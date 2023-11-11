package com.spring.student.model;

import com.spring.student.model.enums.Gender;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Full_Name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private Gender gender;

    @Column(name = "Age")
    private String age;

    @Column(name = "Address")
    private String address;

    @Column(name = "phone_number")
    private String phone;

    @CreationTimestamp
    @Column(name = "Date_Created")
    private Date datecreated;

    @UpdateTimestamp
    @Column(name = "Date_Updated")
    private Date dateupdated;
}