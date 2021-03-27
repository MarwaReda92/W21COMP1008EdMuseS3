package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;
    @BeforeEach
    void setUp() {
        student = new Student("Molly","Malone","1 Bedrock Lane", LocalDate.of(1990,01,01));
    }

    @Test
    void addGrade() {
        student.addGrade("21106", 98);
        assertEquals(98, student.getGradeForCourse("21106"));
    }

    @Test
    void addGradeInvalidCRN(){
        assertThrows(IllegalArgumentException.class, ()->
                student.addGrade("ABC123", 98));
    }

    @Test
    void addGradeInvalidLow(){
        assertThrows(IllegalArgumentException.class, ()->
                student.addGrade("21106", -1));
    }

    @Test
    void addGradeInvalidHigh(){
        assertThrows(IllegalArgumentException.class, ()->
                student.addGrade("21106", 101));
    }

    @Test
    void getNumCoursesPassed() {
    }

    @Test
    void getAvgGrade() {
    }
}