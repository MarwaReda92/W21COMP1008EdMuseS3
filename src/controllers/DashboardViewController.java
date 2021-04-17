package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Course;
import models.Professor;
import models.Student;
import utlities.DBUtility;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardViewController implements Initializable {

    @FXML
    private ImageView logoImageView;

    @FXML
    private Label studentsLabel;

    @FXML
    private ListView<Student> studentListView;

    @FXML
    private Label coursesLabel;

    @FXML
    private ListView<Course> coursesListView;

    @FXML
    private Label professorLabel;

    @FXML
    private ListView<Professor> professorsListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            studentListView.getItems().addAll(DBUtility.getStudentsFromDB());  //asking the db to get all the students so that it can populate the listview object
            studentsLabel.setText(String.format("Students: %d", studentListView.getItems().size()));

            professorsListView.getItems().addAll(DBUtility.getProfessorsFromDB());
            professorLabel.setText(String.format("Professors: %d", professorsListView.getItems().size()));

            coursesListView.getItems().addAll(DBUtility.getCoursesFromDB());
            coursesLabel.setText(String.format("Courses: %d", coursesListView.getItems().size()));
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @FXML
    private void createNewStudent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/createStudentView.fxml"));
        Scene scene = new Scene(root);

        //get the Stage object from the ActionEvent that is triggered when the button is pushed
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("EdMuse-Create Student");
        stage.show();
    }
}