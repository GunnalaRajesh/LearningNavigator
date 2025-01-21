package com.example.LearningNavigator.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import com.example.LearningNavigator.Entity.Exam;
import com.example.LearningNavigator.Entity.Student;
import com.example.LearningNavigator.Repository.ExamRepository;
import com.example.LearningNavigator.Repository.StudentRepository;
import com.example.LearningNavigator.Repository.SubjectRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamRepository examRepository;

    public Student registerForExam(Long studentId, Long examId)
    {
       
        if (studentId == null || examId == null) {
            throw new IllegalArgumentException("Student ID and Exam ID must not be null");
        }

       
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + studentId));

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() -> new EntityNotFoundException("Exam not found with ID: " + examId));

        
        if (!student.getEnrolledSubjects().contains(exam.getSubject())) {
            throw new IllegalStateException("Student not enrolled in the subject");
        }


        student.getRegisteredExams().add(exam);
        exam.getEnrolledStudents().add(student);

    
        studentRepository.save(student);
        examRepository.save(exam);

        return student;
    }
}