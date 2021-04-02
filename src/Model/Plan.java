package Model;

public class Plan {

    String Sport;
    int Times;
    long Start_time, End_time;

    public Plan(String sport, int times, long start_time, long end_time) {
        Sport = sport;
        Times = times;
        Start_time = start_time;
        End_time = end_time;
    }

    public String getSport() {
        return Sport;
    }

    public int getTimes() {
        return Times;
    }

    public long getStart_time() {
        return Start_time;
    }

    public long getEnd_time() {
        return End_time;
    }

    public void setSport(String sport) {
        Sport = sport;
    }

    public void setTimes(int times) {
        Times = times;
    }

    public void setStart_time(long start_time) {
        Start_time = start_time;
    }

    public void setEnd_time(long end_time) {
        End_time = end_time;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "Sport='" + Sport + '\'' +
                ", Times=" + Times +
                ", Start_time=" + Start_time +
                ", End_time=" + End_time +
                '}';
    }
}
