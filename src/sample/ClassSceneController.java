package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import java.io.IOException;

public class ClassSceneController {
    public Tab introTag;
    public TabPane tabPane;
    public Button goBack;
    public TextField accountType;
    public Label freefor;
    public Label forsingle;
    public Button watchVideo;
    public TextField accountPrice;
    public Button delete;
    public Button subscibe;
    Course course;
    public void setCourse(Course course){
        this.course = course;
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
        //accountType
        //accountPrice

    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ClientMainScene.fxml"));
        Parent ClientMainSceneParent = loader.load();
        Scene scene = new Scene(ClientMainSceneParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
    }

    public void watchVideo(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("WatchVideo.fxml"));
        Parent WatchVideoParent = loader.load();
        Scene WatchVideoScene = new Scene(WatchVideoParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(WatchVideoScene);
        window.show();
    }

    public void Payment(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Payment.fxml"));
        Parent PaymentParent = loader.load();
        Scene PaymentScene = new Scene(PaymentParent);

        stage.setScene(PaymentScene);

        stage.show();
    }
}
