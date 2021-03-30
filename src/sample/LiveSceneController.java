package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LiveSceneController {
    public DatePicker datePicker;
    public ChoiceBox timePicker;
    public Tab introTag;
    public Course course;//should be Live Session
    public TabPane tabPane;
    public Scene previousScene;

    @FXML
    public void initialize() {
        timePicker.getItems().add("8:00 am ~ 10:00 am");
        timePicker.getItems().add("10:00 am ~ 12:00 am");
        timePicker.getItems().add("13:00 pm ~ 15:00 pm");
        timePicker.getItems().add("15:00 pm ~ 17:00 pm");
        timePicker.setValue(timePicker.getItems().get(0));
    }
    public void buildScene() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SceneForClassesPlan.fxml"));
        Parent parent = loader.load();
        Scene sceneForPlan = new Scene(parent);
        SceneForClassesPlan controller = loader.getController();
        introTag.setContent(controller.pane);
        controller.textForPlanInfo.setText(course.getIntro());

        for(int i=0;i<course.plan.size();i++){

            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SceneForClassesPlan.fxml"));
            parent = loader.load();
            sceneForPlan = new Scene(parent);
            controller = loader.getController();

            Tab tab = new Tab("Day"+i);
            AnchorPane pane = controller.pane;
            tab.setContent(pane);//Node
            controller.textForPlanInfo.setText(course.getplan(i));
            tabPane.getTabs().add(tab);

        }
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {


        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        ClientMainSceneController controller = (ClientMainSceneController) previousScene.getUserData();
        controller.updateClassesInMyClass();
        controller.updateClassesInMainPage();
        window.setScene(previousScene);

    }

    public void goLiveButtonClicked(ActionEvent actionEvent) {

    }

    /**
     * this method is called when book button clicked, need check method in future
     * go to payment window.
     * @param actionEvent
     */
    public void bookbuttonClicked(ActionEvent actionEvent) {
    }
}
