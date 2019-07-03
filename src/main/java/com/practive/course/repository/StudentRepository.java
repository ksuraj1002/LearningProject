package com.practive.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practive.course.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
