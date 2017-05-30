package hw2.task5;

public class Main {
    public static void main(String[] args) {
        StudentGroup<Integer> studentGroup = Course.LANGUAGE.createGroup();
        Student student = new Student("Some", "Guy");
        studentGroup.addStudent(student);
        studentGroup.addScore(student, 4);
        studentGroup.addScore(student, 5);
        ScoreSheet test = studentGroup.getScores();
        System.out.println();
    }
}
