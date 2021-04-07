package Model;


import java.util.ArrayList;

public class Class {

    String Trainer, State, Info, Type;
    int Rate_of_Process;
    ArrayList<Plan> Day_Plans = new ArrayList<>();
    public Class(String trainer, String state, String info, String type,
                 int rate_of_Process,
                 ArrayList<Plan> day_Plans) {
        Trainer = trainer;
        State = state;
        Info = info;
        Type = type;
        Rate_of_Process = rate_of_Process;
        Day_Plans = day_Plans;
    }

    public String getTrainer() {
        return Trainer;
    }

    public void setTrainer(String trainer) {
        this.Trainer = trainer;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = state;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        this.Info = info;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public int getRate_of_Process() {
        return Rate_of_Process;
    }

    public void setRate_of_Process(int rate_of_Process) {
        this.Rate_of_Process = rate_of_Process;
    }

    public ArrayList<Plan> getDay_Plans() {
        return Day_Plans;
    }

    public void setDay_Plans(ArrayList<Plan> day_Plans) {
        this.Day_Plans = day_Plans;
    }

}