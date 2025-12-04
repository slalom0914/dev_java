package ch05.aobject2.design;

public class JFrame01View {
    JFrame01Event jevent = new JFrame01Event();
    JFrame01Logic jlogic = new JFrame01Logic();
    public JFrame01View(){
        initDisplay();
    }
    public void initDisplay(){
        System.out.println("initDisplay호출 성공");
    }
    public static void main(String[] args) {
        JFrame01View jv = new JFrame01View();
    }
}
