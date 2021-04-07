package View;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeEmailScene {

    public TextField varify;
    public TextField newemail;
    public String userEmail;
    public Button OkButton;
    public Button sendVarifyButton;
    public Label errorLabel;

    /**
     * This function is called OkButtonclicked, it is clicked once user want to change their e-mail.After being clicked,the new e-mail will replace original data and jump to the success interface.
     * @param actionEvent
     */
    public void OkButtonclicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SuccessScene.fxml"));
        Parent afterChangeEmailParent = loader.load();
        Scene afterChangeEmailScene = new Scene(afterChangeEmailParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(afterChangeEmailScene);
        window.show();
    }

    /**
     * this function is called sendVarifyClicked, once user click it,user will receive a code to varify.
     * @param actionEvent
     */
    public void sendVarifyClicked(ActionEvent actionEvent) {
    }
}
