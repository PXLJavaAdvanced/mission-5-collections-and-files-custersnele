package be.pxl.mission5.part4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentServiceTest {

    @Test
    void studentsWithHighestScoreAreServedFirst() {
        StudentService studentService = new StudentService();
        studentService.add(new Student("A", 5.5, 8));
        studentService.add(new Student("B", 6.5, 8));
        studentService.add(new Student("C", 4.5, 8));

        Student served = studentService.serve();
        assertNotNull(served);
        assertEquals(6.5, served.getScore());
        assertEquals(2, studentService.getSize());
    }

    @Test
    void studentsWithSameScoreAreServedByNameAlphabetically() {
        StudentService studentService = new StudentService();
        studentService.add(new Student("B", 5.5, 8));
        studentService.add(new Student("A", 5.5, 8));
        studentService.add(new Student("C", 5.5, 8));

        Student served = studentService.serve();
        assertNotNull(served);
        assertEquals("A", served.getName());
        assertEquals(2, studentService.getSize());
    }

    @Test
    void studentsSameScoreAndNameAreServedByToken() {
        StudentService studentService = new StudentService();
        studentService.add(new Student("A", 5.5, 8));
        studentService.add(new Student("A", 5.5, 5));
        studentService.add(new Student("A", 5.5, 6));

        Student served = studentService.serve();
        assertNotNull(served);
        assertEquals(5, served.getToken());
        assertEquals(2, studentService.getSize());
    }
}
