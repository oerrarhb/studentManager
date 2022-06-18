package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// this annotation is not required
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
