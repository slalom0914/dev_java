package ch06.timer;

public class TimerTest {
    public static void main(String[] args) {
        TimeServer ts = new TimeServer(null);
        System.out.println(ts.getTime());
    }
}
