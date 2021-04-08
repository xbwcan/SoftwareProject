package View;

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
    final ToggleGroup group1 = new ToggleGroup();
    final ToggleGroup group2 = new ToggleGroup();
    public Label Normal;
    public Label FreeFor;
    public Label PayFor;
    public Label Discount;
    public Label Extra;
    public Label All;
    public Label Premier;
    public Label Off;
    public Label discountRatio;
    public Button buy;
    public ComboBox monthChoiceBox;
    public Label premierDiscountPriceLable;
    public Label premierOriginalPriceLabel;

    public Model.Client client;
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
        mainPageFilterType.setValue(mainPageFilterType.getItems().get(0));
        myClassFilterType.setValue(myClassFilterType.getItems().get(0));


        mainPageClassButton.setToggleGroup(group1);
        mainPageLiveButton.setToggleGroup(group1);
        mainPageLiveButton.setUserData("live");
        mainPageClassButton.setUserData("class");



        myClassClassButton.setToggleGroup(group2);
        myClassLiveButton.setToggleGroup(group2);
        myClassLiveButton.setUserData("Live");
        myClassClassButton.setUserData("class");

        group1.selectToggle(mainPageClassButton);
        group2.selectToggle(myClassClassButton);

        updateClassesInMainPage();
        updateClassesInMyClass();

        updateNotice();

        discountRatio.setText("10%");
        for(int i=1;i<=12;i++)
            monthChoiceBox.getItems().add(i);
    }

    public void buildScene(){
        myAccountAgeField.setValue(client.getAge());
        myAccountWeightField.setText(""+client.getWeight());
        myAccountHeightField.setText(""+client.getHeight());
        myAccountBMIField.setText(""+client.getBMI());
        myAccountFattyField.setText(""+client.getFatty_Lipase());
    }

    public void updateClassesInMainPage(){
        mainPageFlowPane.getChildren().clear();
        ArrayList<Button> buttons;
        if(group1.getSelectedToggle().getUserData().equals("class"))
            buttons = getClassesButtonsForMainPage();
        else
            buttons = getLiveButtonsForMainPage();
        for(Button button:buttons)
            mainPageFlowPane.getChildren().add(button);
    }

    public void updateClassesInMyClass(){
        myClassFlowPane.getChildren().clear();
        ArrayList<Button> buttons;
        if(group2.getSelectedToggle().getUserData().equals("class"))
            buttons = getClassesButtonsForMyClass();
        else
            buttons = getLiveButtonsForMyClass();
        for(Button button:buttons)
            myClassFlowPane.getChildren().add(button);
    }

    EventHandler<ActionEvent> classButtonClicked = new EventHandler<ActionEvent>() {
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
            Course course = (Course)(((Node) actionEvent.getSource()).getUserData());
            controller.course = course;
            controller.previousScene = ((Node)actionEvent.getSource()).getScene();
            try {
                controller.buildScene();//build course scene dynamically according to the course information
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    EventHandler<ActionEvent> liveButtonClieked = new EventHandler<ActionEvent>() {
        /**
         * this function change to the live page according to the class button clicked.
         * @param actionEvent
         */
        @Override
        public void handle(ActionEvent actionEvent) {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("LiveScene.fxml"));
            Parent classSceneParent = null;

            try {
                classSceneParent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene classScene = new Scene(classSceneParent);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            LiveSceneController controller = loader.getController();
            controller.course = (Course) (((Node)actionEvent.getSource()).getUserData());
            controller.previousScene = ((Node)actionEvent.getSource()).getScene();
            window.setScene(classScene);
            try {
                controller.buildScene();//build course scene dynamically according to the course information
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };


    /**
     * This method return a set of class buttons for Main pages.
     * details needed to be added --PZ
     * @return
     */
    public ArrayList<Button> getClassesButtonsForMainPage() {
        ArrayList<Button> buttons =new ArrayList<Button>();

        for(int i=0;i<20;i++){
            Button button = new Button("Class: "+i);
            button.setPrefSize(120,120);
            //mainPageFlowPane.getChildren().add(button);
            button.setOnAction(classButtonClicked);

            //add action on class button to show over view
            button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            mainPageOverviewText.setText(((Course)button.getUserData()).getIntro());;
                        }
                    });

            ArrayList <String> plan = new ArrayList<String>();
            plan.add("Day1's plan.");
            plan.add("Day2's plan.");
            plan.add("Day3's:plan");
            Course course = new Course("Class "+i,"PZ",2,plan);

            button.setUserData(course);//add course object to object
            buttons.add(button);

        }
        return buttons;
    }
    /**
     * This method return a set of class buttons for myClass pages.
     * details needed to be added --PZ
     * @return
     */
    public ArrayList<Button> getClassesButtonsForMyClass() {
        ArrayList<Button> buttons =new ArrayList<Button>();

        for(int i=0;i<20;i++){
            Button button = new Button("MyClass: "+i);
            button.setPrefSize(120,120);
            //mainPageFlowPane.getChildren().add(button);
            button.setOnAction(classButtonClicked);

            //add action on class button to show over view
            button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            myClassOverviewText.setText(((Course)button.getUserData()).getIntro());;
                        }
                    });

            ArrayList <String> plan = new ArrayList<String>();
            plan.add("Day1's plan.");
            plan.add("Day2's plan.");
            plan.add("Day3's:plan");
            Course course = new Course("Class "+i,"PZ",2,plan);

            button.setUserData(course);//add course object to object
            buttons.add(button);

        }
        return buttons;
    }
    /**
     * This method return a set of live buttons for MyClass.
     * details needed to be added --PZ
     * @return
     */
    public ArrayList<Button> getLiveButtonsForMyClass() {
        {
            ArrayList<Button> buttons =new ArrayList<Button>();

            for(int i=0;i<20;i++){
                Button button = new Button("MyLive: "+i);
                button.setPrefSize(120,120);
                //mainPageFlowPane.getChildren().add(button);
                button.setOnAction(liveButtonClieked);
                button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent e) {
                                myClassOverviewText.setText(((Course)button.getUserData()).getIntro());
                            }
                        });

                ArrayList <String> plan = new ArrayList<String>();
                plan.add("Day1's plan.");
                plan.add("Day2's plan.");
                plan.add("Day3's:plan");
                Course course = new Course("Live Session "+i,"PZ",2,plan);
                button.setUserData(course);
                buttons.add(button);

            }
            return buttons;
        }
    }
    /**
     * This method return a set of live buttons for Main pages.
     * details needed to be added --PZ
     * @return
     */
    public ArrayList<Button> getLiveButtonsForMainPage() {
        {
            ArrayList<Button> buttons =new ArrayList<Button>();

            for(int i=0;i<20;i++){
                Button button = new Button("Live: "+i);
                button.setPrefSize(120,120);
                //mainPageFlowPane.getChildren().add(button);
                button.setOnAction(liveButtonClieked);
                button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                        new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent e) {
                                mainPageOverviewText.setText(((Course)button.getUserData()).getIntro());
                            }
                        });

                ArrayList <String> plan = new ArrayList<String>();
                plan.add("Day1's plan.");
                plan.add("Day2's plan.");
                plan.add("Day3's:plan");
                Course course = new Course("Live Session "+i,"PZ",2,plan);
                button.setUserData(course);
                buttons.add(button);

            }
            return buttons;
        }
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
        updateClassesInMainPage();
    }


    /**
     * this method get what lessons and types user choose, and show them. It's in MyClasses&Live.
     * @param actionEvent
     */
    public void myClassSearchClicked(ActionEvent actionEvent) {
        updateClassesInMyClass();
    }

    public void premierBuyClicked(ActionEvent actionEvent) throws IOException {
        Integer month = (Integer) (monthChoiceBox.getValue());
        changeToPayment("Premier for "+month+" month",premierDiscountPriceLable.getText());

    }
    public void premierMonthSelected() throws IOException {
        Integer month = (Integer) (monthChoiceBox.getValue());
        //System.out.println(month);
        double originPrice = month * 50;
        double discountPrice = month * 50 * (1-0.1);
        premierOriginalPriceLabel.setText(originPrice+" $ ");
        premierDiscountPriceLable.setText(discountPrice+" $ ");
    }

    public void changeToPayment(String item,String price) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Payment.fxml"));
        Parent PaymentParent = loader.load();
        Scene PaymentScene = new Scene(PaymentParent);
        stage.setScene(PaymentScene);
        Payment controller = loader.getController();
        controller.buildScene(item,price);
        stage.show();
    }








}
