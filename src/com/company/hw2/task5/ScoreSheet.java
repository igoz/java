package com.company.hw2.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreSheet <T extends Number> {
    private Map<Student, List<T>> scores = new HashMap<>();

    public void addScore(Student student, T score) {
        if (scores.containsKey(student)) {
            if (scores.get(student) == null) {
                List<T> list = new ArrayList<T>();
                list.add(score);
                scores.put(student, list);
            } else {
                scores.get(student).add(score);
            }
        } else {
            List<T> list = new ArrayList<T>();
            list.add(score);
            scores.put(student, list);
        }
    }

    public Map<Student, List<T>> getScores() {
        return scores;
    }

    public void setScores(Map<Student, List<T>> scores) {
        this.scores = scores;
    }
}
