package ch05.aobject3;
// DEMain.java -> DE1.class, DE2.class, DEMain.class
class DE1{

}
class DE2{

}
public class DEMain {
    public static void main(String[] args) {
        DE1 de1 = new DE1();
        DE1 de11 = new DE1();
        System.out.println(de1 == de11);//false
        System.out.println(de1.equals(de11));//false
    }
}
