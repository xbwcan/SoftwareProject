package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ClientMainSceneController {

   // public Client client.
    public FlowPane box;
    public AnchorPane pane;
   // public Label premiumLabel;

    public void gotoButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SceneForClass.fxml"));
        Parent afterLoginParent = loader.load();
        Scene afterLoginScene = new Scene(afterLoginParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(afterLoginScene);


        SceneForClass controller = loader.getController();
        ArrayList <String> plan = new ArrayList<String>();
        plan.add("Day1's plan.");
        plan.add("Day2's plan.");
        Course course = new Course("YOGA","PZ",2,plan);
        controller.course = course;
        controller.buildScene();
    }

    public void changeEmailButtonCliecked(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ChangeEmailScene.fxml"));
        Parent changeEmailParent = loader.load();
        Scene changeEmailScene = new Scene(changeEmailParent);

        stage.setScene(changeEmailScene);

        stage.show();
    }

    public void changePasswordButtonClicked(ActionEvent actionEvent) throws IOException {




    }
    /**
     *
     * 1351
     */

}
