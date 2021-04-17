package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Student;
import utlities.DBUtility;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateStudentViewController implements Initializable {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private DatePicker birthdayDatePicker;

    @FXML
    private Label errMSGLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errMSGLabel.setText("");
    }

    @FXML
    private void submitButton(){
        try {
            Student newStudent = new Student(firstNameTextField.getText(), lastNameTextField.getText(), addressTextField.getText(), birthdayDatePicker.getValue());

            //1. insert the student into the db
            int studentNum = DBUtility.insertNewStudent(newStudent);

            //2. clear the fields
            clearFields();

            //3. display the new student object
            errMSGLabel.setText("Student Num: " + studentNum + " "+ newStudent.toString());
        }catch (IllegalArgumentException exception)
        {
            errMSGLabel.setText(exception.getMessage()); //this will get the error msg and display it to the user
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void clearFields()
    {
        firstNameTextField.clear();
        lastNameTextField.clear();
        addressTextField.clear();
        birthdayDatePicker.getEditor().clear();
    }

    @FXML
    private void changeToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/createStudentView.fxml"));
        Scene scene = new Scene(root);

        //get the Stage object from the ActionEvent that is triggered when the button is pushed
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("EdMuse-Create Student");
        stage.show();
    }
}