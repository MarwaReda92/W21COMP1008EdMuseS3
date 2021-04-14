package models;

import java.time.LocalDate;
import java.util.TreeMap;

public class Student extends Person {

    private TreeMap<String, Integer> grades; //must be an object for the value so we must use the wrapper class Integer instead of primitive int

    /**
     *This is the constructor for the Student class. Since a Student is also a Person object
     * we need to pass the firstName, lastName, address and birthday to the super class! (Person)
     */
    public Student(String firstName, String lastName, String address, LocalDate birthday) {
        super(firstName, lastName, address, birthday);
        grades = new TreeMap<>();
    }

    /**
     * This method will validate that there is a valid course code and that the grade is in the range
     * of 0-100. If the combination is valid, it will be added to the grades.
     */
    public void addGrade(String courseCRN, int grade){
        //means the number starts with a 2, followed by 4 more numbers between 0-9
        if(!courseCRN.matches("2[0-9]{4}"))
            throw new IllegalArgumentException("CRN must have the pattern 2xxxx - where x is 0-9");

        if (grade >= 0 && grade <= 100)
            grades.put(courseCRN,grade);
        else
            throw new IllegalArgumentException("Grade must be between 0-100 inclusive");
    }

    /**
     * This method will return a grade for a specific course. If the course is not listed
     * for the student, it will return a value of -1
     */
    public int getGradeForCourse(String courseCRN){
        if (grades.get(courseCRN) == null)
            return -1;

        return grades.get(courseCRN);
    }

    /**
     * This method will return the number of courses that had a grade at or above 50%
     */
    public int getNumCoursesPassed(){
        int count = 0;
        for (Integer grade : grades.values()) //asking for the values directly instead of the keys
            if (grade >= 50)
                count++;
        return count;
    }

    /**
     * This method will return the average grade for a student.
     * @return - if a student does not have any grades registered, a value of -1 will be returned
     */
    public double getAvgGrade(){
        if (grades.size() == 0)
            return -1;

        double sum = 0;
        for (Integer grade: grades.values())
            sum += grade;
        return sum/grades.size();
    }
}
