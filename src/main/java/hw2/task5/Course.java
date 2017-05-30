package hw2.task5;

public enum Course {
    MATH(false),
    LANGUAGE(true),
    PHYSICS(false),
    CHEMISTRY(true),
    ALGORITHMS(false);

    private boolean isIntegerScores;

    Course(boolean isIntegerScores) {
        this.isIntegerScores = isIntegerScores;
    }

    public <T extends Number> StudentGroup<T> createGroup() {
        return new StudentGroup<T>(this);
    }

    public boolean isIntegerScores() {
        return isIntegerScores;
    }

    public void setIntegerScores(boolean integerScores) {
        isIntegerScores = integerScores;
    }
}
