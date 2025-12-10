package jdbc;

import java.util.StringTokenizer;

public class StringTest {
    public static void main(String[] args) {
        String msg = 200+"#"+"키위나무"+"#"+"오늘 점심메뉴는?";
        StringTokenizer st = new StringTokenizer(msg,"#");
        String protocol = st.nextToken();
        String nickName = st.nextToken();
        String message = st.nextToken();
        System.out.println(message);
        String other = st.nextToken();
        System.out.println(other);
    }
}
