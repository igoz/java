package hw2.task5;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String secondName;
    private List<Course> courses;

    public Student(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        courses = new ArrayList<>();
    }

    public Student(String firstName, String secondName, List<Course> courses) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
