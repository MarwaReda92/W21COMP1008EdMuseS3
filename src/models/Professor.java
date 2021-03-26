package models;

import utlities.DBUtility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class Professor extends Person {
    private ArrayList<String> teachables;

    /**
     * This is the constructor for the Professor class because it extends the Person class,
     * we need to pass in the firstName, lastName, address and birthday as arguments and send that
     * information to the Person class's constructor.
     *
     * This method super() is what sends information to the super class.
     */
    public Professor(String firstName, String lastName, String address, LocalDate birthday) {
        super(firstName, lastName, address, birthday);
        teachables = new ArrayList<>(); //this line is critical or else the arraylist will be null
    }

    /**
     * This method will add a course code to the Professor's list of teachable subjects
     */
    public void addTeachable(String newCourseCode){
        if (DBUtility.getAvailableCourseCodes().contains(newCourseCode))
            teachables.add(newCourseCode);
        else
            throw new IllegalArgumentException(newCourseCode + " is not a valid course code");
    }
}
