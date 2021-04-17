package models;

import java.util.ArrayList;

public class Course {
    private String courseCode, crn, courseName;
    private Professor prof;
    private ArrayList<Student> students;

    public Course(String courseCode, String crn, String courseName, Professor prof) {
        setCourseCode(courseCode);
        setCrn(crn);
        setCourseName(courseName);
        setProf(prof);
        students = new ArrayList<>();
    }

    /**
     * This method will add a Student to the course list called students if there is space in the class
     * class sizes are capped at 40
     */
    public void addStudent(Student newStudent){
        if (students.size()<40)
            students.add(newStudent);
        else
            throw new IllegalArgumentException("Course is full");
    }

    public String getCourseCode() {
        return courseCode;
    }

    /**
     * This method will validate that the course code matches the correct pattern of COMP XXXX and sets the instance variables
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        //if wanted regex for X2XXX5 it would be ("[0-9]2[0-9]{3}5")
        if (courseCode.matches("COMP [0-9]{4}"))
            this.courseCode = courseCode;
        else
            throw new IllegalArgumentException("Course code must match the pattern COMP XXXX where x is a number");
    }

    public String getCrn() {
        return crn;
    }

    public int getNumOfStudents(){
        return students.size();
    }

    public void setCrn(String crn) {
        crn = crn.trim();
        if (crn.matches("2[0-9]{4}"))
            this.crn = crn;
        else
            throw new IllegalArgumentException("CRN must match the pattern 2XXXX where x is a number");
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        courseName = courseName.trim();
        if (courseName.length()>=2 && courseName.length()<=50)
            this.courseName = courseName;
        else
            throw new IllegalArgumentException("Name must be 2-50 characters long");
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

    public String toString() {
        return String.format("%s-%s %s-%d students", crn, courseCode, courseName, students.size());
    }
}
