package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.PopupWindow;

import java.io.IOException;

public class ClassSceneController {
    public Tab introTag;
    public TabPane tabPane;
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


    }
}
