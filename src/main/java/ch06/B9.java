package ch06;

import java.util.StringTokenizer;

class Protocol{
    private static final int ROOM_IN    = 100;
    private static final int MSG        = 200;
    private static final int WHISPER    = 300;
    private static final int ROOM_OUT   = 500;
}
public class B9 {

    public static void main(String[] args) {
        String msg = "200#kiwi#오늘 스터디할까?";
        String msg2 = "300|kiwi|apple|오늘 스터디할까?";
        StringTokenizer st = new StringTokenizer(msg,"#");
        String room_in = st.nextToken();//200 - 다자간 대화
        String from = st.nextToken();
        String message = st.nextToken();
        System.out.println(room_in+","+from+","+message);
        StringTokenizer st2 = new StringTokenizer(msg2,"|");
        String room_in2 = st2.nextToken();//200 - 다자간 대화
        String from2 = st2.nextToken();
        String to = st2.nextToken();
        String message2 = st2.nextToken();
        System.out.println(room_in2+","+from2+","+to+","+message2);

    }
}
