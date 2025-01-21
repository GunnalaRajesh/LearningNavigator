package com.example.LearningNavigator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningNavigator.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
