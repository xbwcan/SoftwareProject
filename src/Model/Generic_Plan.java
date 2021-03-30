package Model;


import java.util.ArrayList;

public class Generic_Plan {

    ArrayList<String> Train_Plan_Sports = new ArrayList<>();
    ArrayList<Integer> Train_Plan_times = new ArrayList<>();
    ArrayList<Long> Train_Plan_time = new ArrayList<>();

    public Generic_Plan(ArrayList<String> train_Plan_Sports, ArrayList<Integer> train_Plan_times,
                        ArrayList<Long> train_Plan_time)
    {
        this.Train_Plan_Sports = train_Plan_Sports;
        this.Train_Plan_times = train_Plan_times;
        this.Train_Plan_time = train_Plan_time;
    }

    public void setTrain_Plan_Sports(ArrayList<String> train_Plan_Sports) {
        this.Train_Plan_Sports = train_Plan_Sports;
    }

    public void setTrain_Plan_times(ArrayList<Integer> train_Plan_times) {
        this.Train_Plan_times = train_Plan_times;
    }

    public ArrayList<Integer> getTrain_Plan_times() {
        return Train_Plan_times;
    }

    public ArrayList<String> getTrain_Plan_Sports() {
        return Train_Plan_Sports;
    }

    public ArrayList<Long> getTrain_Plan_time() {
        return Train_Plan_time;
    }

    public void setTrain_Plan_time(ArrayList<Long> train_Plan_time) {
        this.Train_Plan_time = train_Plan_time;
    }
}


