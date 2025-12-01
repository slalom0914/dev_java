package ch03;
class Y{
    int ival;
}
public class Oper082 {
    public static void main(String[] args) {
        Y y1 = new Y();
        Y y2 = y1;
        y2.ival = 100;
        System.out.println(y1 == y2);//true출력됨
        System.out.println(y1.ival+", "+y2.ival);//100, 100출력됨

    }
}
