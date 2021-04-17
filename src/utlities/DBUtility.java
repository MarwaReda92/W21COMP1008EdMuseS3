package utlities;

import models.Course;
import models.Professor;
import models.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class will simulate getting information from a database
 */
public class DBUtility {
    private static String user = "root";
    private static String password = "";
    private static String connString = "jdbc:mysql://localhost:3306/edmuse";

    public static List<String> getAvailableCourseCodes() {
        return Arrays.asList("COMP 1002", "COMP 1030", "COMP 1035", "COMP 1045",
                "COMP 1045", "COMP 1003", "COMP 1006", "COMP 1008",
                "COMP 1098", "COMP 2003", "ENTR 1002", "COMP 1009",
                "COMP 1011", "COMP 1073", "COMP 2084", "COMP 3002", "COMP 2068");
    }

    public static ArrayList<Student> getStudentsFromDB() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student("Rose","Ruffner","3846 St. Paul StreetSt Catharines ON L2S 3A1", LocalDate.of(1975,8,27)));
//        students.add(new Student("Jack","Bradbury","867 rue des Églises Est Ste Cecile De Masham QC J0X 2W0", LocalDate.of(1979,10,14)));
//        students.add(new Student("Elanore","Sanders","1145 47th Avenue Grassland AB T0A 1V0", LocalDate.of(1940,9,25)));
//        students.add(new Student("Nancy","Walsh","1459 Harvest Moon Dr Unionville ON L3R 0L7", LocalDate.of(1999,1,12)));
//        students.add(new Student("Greta","Tolbert","642 Front Street Toronto ON M5J 2N1", LocalDate.of(1957,12,18)));
//        students.add(new Student("Marla","Reba","1459 Harvest Moon Dr Doodoo ON L3R 0L7", LocalDate.of(1992,2,8)));

        //create objects to access and read from the DB
        Connection conn = null;  //connects to db
        Statement statement = null;  //use statement to query it
        ResultSet resultSet = null;  //results come from resultset object that we will loop over to create student objects

        try {
            //1. connect to the DB
            conn = DriverManager.getConnection(connString, user, password);

            //2. Create statement object
            statement = conn.createStatement();

            //3. Create/execute the query
            resultSet = statement.executeQuery("SELECT * FROM students");

            //4. Loop over the results, even if there is only 1 record you have to loop through them, use column label instead of index
            while (resultSet.next()) {
                Student newStudent = new Student(resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("address"),
                        resultSet.getDate("birthday").toLocalDate());
                students.add(newStudent);
            }
        } catch (SQLException e)
        {
            System.out.println("Database access issue: " + e.getMessage());

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                conn.close();  //had to add the method exception
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }


        return students;
    }

    public static ArrayList<Professor> getProfessorsFromDB() {
        ArrayList<Professor> professors = new ArrayList<>();
        professors.add(new Professor("Lois", "Parker", "674 Goyeau Ave Windsor ON N9A 1H9", LocalDate.of(1987, 3, 21)));
        professors.add(new Professor("Ginger", "Harris", "1453 Yonge St Toronto ON M4W 1J7", LocalDate.of(1967, 11, 12)));
        professors.add(new Professor("Winchester", "Solomon", "3099 Balmy Beach Road Owen Sound ON N4K 2N7", LocalDate.of(1977, 12, 18)));
        professors.add(new Professor("John", "Pressley", "1101 Eglinton Avenue Toronto ON M4P 1A6", LocalDate.of(1973, 11, 29)));
        return professors;
    }

    public static ArrayList<Course> getCoursesFromDB() throws SQLException {
        ArrayList<Professor> professors = getProfessorsFromDB();
        ArrayList<Student> students = getStudentsFromDB();
        Course course1 = new Course("COMP 1008", "21109", "Intro to Objects", professors.get(0));
        course1.addStudent(students.get(0));
        course1.addStudent(students.get(1));
        course1.addStudent(students.get(2));

        Course course2 = new Course("COMP 1011", "21110", "Advanced Java", professors.get(1));
        course2.addStudent(students.get(2));
        course2.addStudent(students.get(3));
        course2.addStudent(students.get(4));
        course2.addStudent(students.get(5));

        Course course3 = new Course("COMP 1030", "21111", "Programming Fundamentals", professors.get(1));
        course2.addStudent(students.get(2));
        course2.addStudent(students.get(3));
        course2.addStudent(students.get(4));
        course2.addStudent(students.get(5));

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        return courses;
    }

    public static int insertNewStudent(Student student) throws SQLException {

        int studentNum = -1;
        String sql = "INSERT INTO students (firstName, lastName, address, birthday) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try (
                Connection conn = DriverManager.getConnection(connString, user, password);
                )
        {
            preparedStatement = conn.prepareStatement(sql, new String[]{"studentNum"});

            //bind the values
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setDate(4, Date.valueOf(student.getBirthday()));

            //execute the insert statement
            preparedStatement.executeUpdate();

            //loop over the resultset and get the student number
            rs = preparedStatement.getGeneratedKeys();
            while (rs.next())
                studentNum = rs.getInt(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            if (rs != null)
                rs.close();
            if (preparedStatement != null)
                preparedStatement.close();
        }
        return studentNum;
    }
}
