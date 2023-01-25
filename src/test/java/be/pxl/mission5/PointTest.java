package be.pxl.mission5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    public void compareToWithDifferentYValues() {
        Point point1 = new Point(5, 3);
        Point point2 = new Point(3, 6);
        assertTrue(point1.compareTo(point2) < 0);
        assertTrue(point2.compareTo(point1) > 0);
    }

    @Test
    public void compareToWithSameYValuesAndDifferentXValues() {
        Point point1 = new Point(5, 6);
        Point point2 = new Point(3, 6);
        assertTrue(point2.compareTo(point1) < 0);
        assertTrue(point1.compareTo(point2) > 0);
    }

    @Test
    public void compareToWithSameXAndYValues() {
        Point point1 = new Point(5, 6);
        Point point2 = new Point(5, 6);
        assertEquals(0, point2.compareTo(point1));
        assertEquals(0, point1.compareTo(point2));
    }

    @Test
    public void equalsReturnsTrueWhenPointsAreSame() {
        Point point1 = new Point(5, 6);
        Point point2 = new Point(5, 6);
        assertEquals(point1, point2);
    }

    @Test
    public void equalsReturnsFalseWhenPointsAreDifferent() {
        Point point1 = new Point(5, 6);
        Point point2 = new Point(5, 7);
        assertNotEquals(point1, point2);
    }

    @Test
    public void toStringTest() {
        Point point1 = new Point(5, 6);
        assertEquals("(5,6)", point1.toString());
    }
}
