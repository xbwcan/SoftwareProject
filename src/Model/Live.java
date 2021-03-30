package Model;

import Model.Plan;

import java.util.ArrayList;

public class Live {

    String Trainer, State, Info, Type;
    int Rate_of_Process, Start_time, End_time;
    ArrayList<String> Video_Path = new ArrayList<String>();
    ArrayList<Plan> Day_Plans = new ArrayList<Plan>();

    public Live(String trainer, String state, String info, String type,
                int rate_of_Process, int start_time, int end_time,
                ArrayList<String> video_Path, ArrayList<Plan> day_Plans) {
        Trainer = trainer;
        State = state;
        Info = info;
        Type = type;
        Rate_of_Process = rate_of_Process;
        Start_time = start_time;
        End_time = end_time;
        Video_Path = video_Path;
        Day_Plans = day_Plans;
    }

    public String getTrainer() {
        return Trainer;
    }

    public String getState() {
        return State;
    }

    public String getInfo() {
        return Info;
    }

    public String getType() {
        return Type;
    }

    public int getRate_of_Process() {
        return Rate_of_Process;
    }

    public int getStart_time() {
        return Start_time;
    }

    public int getEnd_time() {
        return End_time;
    }

    public ArrayList<String> getVideo_Path() {
        return Video_Path;
    }

    public ArrayList<Plan> getDay_Plans() {
        return Day_Plans;
    }

    public void setTrainer(String trainer) {
        Trainer = trainer;
    }

    public void setState(String state) {
        State = state;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setRate_of_Process(int rate_of_Process) {
        Rate_of_Process = rate_of_Process;
    }

    public void setStart_time(int start_time) {
        Start_time = start_time;
    }

    public void setEnd_time(int end_time) {
        End_time = end_time;
    }

    public void setVideo_Path(ArrayList<String> video_Path) {
        Video_Path = video_Path;
    }

    public void setDay_Plans(ArrayList<Plan> day_Plans) {
        Day_Plans = day_Plans;
    }
}
