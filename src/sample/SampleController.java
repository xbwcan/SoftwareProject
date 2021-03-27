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

public class SampleController {

    public TextField nameTextField;
    public TextField passwordTextField;

    public void loginButtionClicked(ActionEvent actionEvent) throws IOException {
        String name = nameTextField.getText();
        String password = passwordTextField.getText();
       if(true){

           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("test.fxml"));
           Parent afterLoginParent = loader.load();
           Scene afterLoginScene = new Scene(afterLoginParent);
           Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
           window.setScene(afterLoginScene);


           TestController controller = loader.getController();
            for(int i=0;i<100;i++){



            }


           window.show();
       }

    }
}
