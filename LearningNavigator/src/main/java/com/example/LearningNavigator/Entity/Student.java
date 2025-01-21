package com.example.LearningNavigator.Entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "enrolledStudents")
    private List<Subject> enrolledSubjects = new ArrayList<>();

    @ManyToAny
    private List<Exam> registeredExams = new ArrayList<>();

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getEnrolledSubjects() {
		return enrolledSubjects;
	}

	public void setEnrolledSubjects(List<Subject> enrolledSubjects) {
		this.enrolledSubjects = enrolledSubjects;
	}

	public List<Exam> getRegisteredExams() {
		return registeredExams;
	}

	public void setRegisteredExams(List<Exam> registeredExams) {
		this.registeredExams = registeredExams;
	}


	

    // Getters and setters
}
