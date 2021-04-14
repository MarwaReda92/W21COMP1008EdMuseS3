import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args); //this is all thatsrequired in the main method
//        Person p1 = new Person("Molly","Malone","1 Bedrock", LocalDate.of(1986,3,17));
//        Person p2 = new Person("Molly","Malone","1 Bedrock", LocalDate.of(2020,3,27));
//        System.out.println(p1);
//        System.out.println(p2);
//
//        TreeMap<String, Integer> grades = new TreeMap<>();
//        grades.put("COMP 1008", 98);
//        grades.put("COMP 1030", 72);
//        grades.put("COMP 1011", 100);
//        grades.put("COMP 1035", 92);
//
//        ArrayList<Person> people = new ArrayList<>();
//        people.add(p1);
//        people.add(p2);
//        System.out.println("--- Playing with Map's");
//        System.out.println(people.get(0));
//
//        //to get something from a Map object, we provide the key (instead of the index)
//        System.out.println("The grade for COMP1008:" + grades.get("COMP 1008"));
//
//        //loop over an ArrayList
//        for (Person person : people)
//            System.out.println(person);
//
//        //1 way to loop over a Map - this way will show both the key and the values
//        for (String key : grades.keySet())
//            System.out.printf("key: %s value: %d%n",key,grades.get(key));

    }

    @Override
    public void start(Stage stage) throws Exception { //where we put in what files to load
        Parent root = FXMLLoader.load(getClass().getResource("views/dashboardView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("EdMuse");
        stage.show();
    }
}
