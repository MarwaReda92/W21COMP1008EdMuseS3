package models;

import java.util.ArrayList;

public class Course {
    private String courseCode, crn, courseName;
    private Professor prof;
    private ArrayList<Student> students;

    public Course(String courseCode, String crn, String courseName, Professor prof) {
        setCourse(courseCode);
        setCrn(crn);
        setCourseName(courseName);
        setProf(prof);
        students = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
