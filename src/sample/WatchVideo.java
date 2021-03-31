package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;

public class WatchVideo {
    public Circle circle;
    public Label video;
    public TextField videoNumber;
    public Button goback;
    public Polygon triangle;
    public Scene previousScene;

    public void goback(ActionEvent actionEvent) throws IOException {

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(previousScene);
    }
}
