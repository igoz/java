package com.company.hw2.task5;

import java.util.ArrayList;
import java.util.List;

public class StudentGroup<T extends Number> {
    Course course;
    List<Student> attenders;
    ScoreSheet<T> scores = new ScoreSheet<>();

    public StudentGroup(Course course) {
        this.course = course;
        attenders = new ArrayList<>();
    }

    public StudentGroup(Course course, List<Student> attenders) {
        this.course = course;
        this.attenders = attenders;
    }

    public StudentGroup(Course course, List<Student> attenders, ScoreSheet<T> scores) {
        this.course = course;
        this.attenders = attenders;
        this.scores = scores;
    }

    public void addStudent(Student student) {
        attenders.add(student);
    }

    public void addScore(Student student, T score) {
        scores.addScore(student, score);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getAttenders() {
        return attenders;
    }

    public void setAttenders(List<Student> attenders) {
        this.attenders = attenders;
    }

    public ScoreSheet getScores() {
        return scores;
    }

    public void setScores(ScoreSheet<T> scores) {
        this.scores = scores;
    }
}
