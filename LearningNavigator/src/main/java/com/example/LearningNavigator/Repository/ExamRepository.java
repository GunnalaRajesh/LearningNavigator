package com.example.LearningNavigator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningNavigator.Entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}

