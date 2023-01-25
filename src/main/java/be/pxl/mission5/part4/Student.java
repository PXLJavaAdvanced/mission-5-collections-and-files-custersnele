package be.pxl.mission5.part4;

public class Student {
    private final String name;
    private final double score;
    private final int token;

    public Student(String name, double score, int token) {
        this.name = name;
        this.score = score;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public int getToken() {
        return token;
    }
}
