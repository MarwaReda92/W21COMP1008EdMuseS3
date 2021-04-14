package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course course;
    Professor professor;
    Student student1;
    Student student2;

    @BeforeEach
    void setUp() {
        professor = new Professor("Fred","Flintstone","1 BedRock Lane", LocalDate.of(1956,10,01));
        student1 = new Student("Betty","Rubble", "3 Bedrock Lane", LocalDate.of(2000,8,01));
        student2 = new Student("Barney","Rubble", "3 Bedrock Lane", LocalDate.of(1995,1,20));
        course = new Course("COMP 1008","21106","Intro to OO",professor);
        course.addStudent(student1);
        course.addStudent(student2);
    }

    @Test
    void setCourseCode() {
        course.setCourseCode("COMP 1000");
        assertEquals("COMP 1000", course.getCourseCode());
    }

    @Test
    void setCourseCodeInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseCode("gibberish"));
    }

    @Test
    void setCrn() {
        course.setCrn("21111");
        assertEquals("21111", course.getCrn());
    }

    @Test
    void setCrnInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                course.setCrn("12345"));
    }

    @Test
    void getNumOfStudents() {
        assertEquals(2, course.getNumOfStudents());
    }

    @Test
    void setCourseName() {
        course.setCourseName("the greatest course ever");
        assertEquals("the greatest course ever", course.getCourseName());
    }

    @Test
    void setCourseNameInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                course.setCourseName("   "));
    }

    @Test
    void setProf() {
    }

    @Test
    void setStudents() {
    }
}