package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javafx.application.Application;


import java.io.IOException;
import java.util.ArrayList;

public class ClientMainSceneController {

   // public Client client.
    @FXML

    public Label premiumLabel;
    public ChoiceBox myAccountAgeField;//this field is about body information in my account
    public TextField myAccountWeightField;//this field is about body information in my account
    public TextField myAccountBMIField;//this field is about body information in my account
    public TextField myAccountHeightField;//this field is about body information in my account
    public TextField myAccountFattyField;//this field is about body information in my account
    public FlowPane mainPageFlowPane;//this plan hold classes in main page
    public TextArea mainPageNoticeTextArea;//this field provide notice on main page
    public FlowPane myClassFlowPane;//this plan hold classes in my class
    public TextArea mainPageOverviewText;
    public TextArea myClassOverviewText;
    public ChoiceBox mainPageFilterType;
    public Button mainPageSearchButton;
    public RadioButton mainPageClassButton;
    public RadioButton mainPageLiveButton;
    public Button myClassSearchButton;
    public ChoiceBox myClassFilterType;
    public RadioButton myClassClassButton;
    public RadioButton myClassLiveButton;

    // public Label premiumLabel;
    @FXML
    public void initialize(){
        for(int i=8;i<=100;i++)
            myAccountAgeField.getItems().add(i);
        myAccountAgeField.setValue(20);
        mainPageFilterType.getItems().add("Yoga");
        mainPageFilterType.getItems().add("Swim");
        myClassFilterType.getItems().add("Yoga");
        myClassFilterType.getItems().add("Swim");

        final ToggleGroup group1 = new ToggleGroup();
        mainPageClassButton.setToggleGroup(group1);
        mainPageLiveButton.setToggleGroup(group1);

        final ToggleGroup group2 = new ToggleGroup();
        myClassClassButton.setToggleGroup(group2);
        myClassLiveButton.setToggleGroup(group2);

        updateClassesInMainPage();
        updateClassesInMyClass();

        updateNotice();
    }

    public void updateClassesInMainPage(){
        ArrayList<Button> buttons = getClassesButtonsForMainPage();
        for(Button button:buttons)
            mainPageFlowPane.getChildren().add(button);
    }
    public void updateClassesInMyClass(){
        ArrayList<Button> buttons = getClassesButtonsForMyClass();
        for(Button button:buttons)
            myClassFlowPane.getChildren().add(button);
    }

    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        /**
         * this function change to the course page according to the class button clicked.
         * @param actionEvent
         */
        @Override
        public void handle(ActionEvent actionEvent) {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ClassScene.fxml"));
            Parent classSceneParent = null;

            try {
                classSceneParent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene classScene = new Scene(classSceneParent);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(classScene);


            ClassSceneController controller = loader.getController();
            ArrayList <String> plan = new ArrayList<String>();
            plan.add("Day1's plan.");
            plan.add("Day2's plan.");
            plan.add("Day3's:plan");
            Course course = new Course("YOGA","PZ",2,plan);

            controller.course = course;
            try {
                controller.buildScene();//build course scene dynamically according to the course information
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    public ArrayList<Button> getClassesButtonsForMainPage() {
        ArrayList<Button> buttons =new ArrayList<Button>();

        for(int i=0;i<20;i++){
            Button button = new Button("Class: "+i);
            button.setPrefSize(120,120);
            //mainPageFlowPane.getChildren().add(button);
            button.setOnAction(event);

            //add action on class button to show over view
            button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            mainPageOverviewText.setText(button.getText());
                        }
                    });
            buttons.add(button);
        }
        return buttons;
    }
    public ArrayList<Button> getClassesButtonsForMyClassPage() {
        ArrayList<Button> buttons =new ArrayList<Button>();

        for(int i=0;i<20;i++){
            Button button = new Button("Class: "+i);
            button.setPrefSize(120,120);
            //mainPageFlowPane.getChildren().add(button);
            button.setOnAction(event);

            //add action on class button to show over view
            button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            myClassOverviewText.setText(button.getText());
                        }
                    });
            buttons.add(button);
        }
        return buttons;
    }
    public ArrayList<Button> getClassesButtonsForMyClass() {
        ArrayList<Button> buttons =new ArrayList<Button>();

        for(int i=0;i<20;i++){
            Button button = new Button("Class: "+i);
            button.setPrefSize(120,120);
            //mainPageFlowPane.getChildren().add(button);
            button.setOnAction(event);

            button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            myClassOverviewText.setText(button.getText());
                        }
                    });
            buttons.add(button);

        }
        return buttons;
    }

    public void updateNotice() {
        String s = new String();
        for(int i=0;i<=100;i++)
            s+=("Line"+i+"\n");
        mainPageNoticeTextArea.setText(s);
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
        Stage stage = new Stage();


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ChangePassword.fxml"));
        Parent changePassWordParent = loader.load();
        Scene changePassWordScene = new Scene(changePassWordParent);

        stage.setScene(changePassWordScene);

        stage.show();
    }

    /**
     * this method save changes of client's body information's changes, and generate generic plan
     * @param actionEvent
     */
    public void myAccountSaveButtonClicked(ActionEvent actionEvent) {

    }

    /**
     * this method get what lessons and types user choose, and show them. It's in MainPage.
     * @param actionEvent
     */
    public void mainPageSearchClicked(ActionEvent actionEvent) {
    }

    /**
     * this method get what lessons and types user choose, and show them. It's in MyClasses&Live.
     * @param actionEvent
     */
    public void myClassSearchClicked(ActionEvent actionEvent) {
    }
    /**
     *
     * 1351
     */








}
