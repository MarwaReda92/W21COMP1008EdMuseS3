package utlities;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneBuilder {

    /**
     * This method will allow us to change scenes
     */
    public static void changeScenes(ActionEvent event, String viewName, String title) throws IOException {
        Parent root = FXMLLoader.load(new Object().getClass().getResource(viewName));
        Scene scene = new Scene(root);

        //get the Stage object from the ActionEvent that is triggered when the button is pushed
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
