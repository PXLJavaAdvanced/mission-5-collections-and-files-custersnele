package be.pxl.mission5.part4;

import java.util.PriorityQueue;

public class StudentService {
    private PriorityQueue<Student> students;

    public StudentService() {
        this.students = new PriorityQueue<>((s1, s2) -> {
            if (s1.getScore() == s2.getScore()) {
                if (s1.getName().equals(s2.getName())) {
                    return Integer.compare(s1.getToken(), s2.getToken());
                } else {
                    return s1.getName().compareTo(s2.getName());
                }
            } else {
                return Double.compare(s2.getScore(), s1.getScore());
            }
        });
    }

    public void add(Student student) {
        students.add(student);
    }

    public Student serve() {
        return students.poll();
    }

    public int getSize() {
        return students.size();
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }
}
