package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    public TextField nameTextField;
    public TextField passwordTextField;

    public void loginButtionClicked(ActionEvent actionEvent) throws IOException {
        String name = nameTextField.getText();
        String password = passwordTextField.getText();
       if(true){

           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("ClientMainScene.fxml"));
           Parent afterLoginParent = loader.load();
           Scene afterLoginScene = new Scene(afterLoginParent);
           Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
           window.setScene(afterLoginScene);
           ClientMainSceneController controller = loader.getController();
           afterLoginScene.setUserData(controller);
           window.show();
       }

    }
}
