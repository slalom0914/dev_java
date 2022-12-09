package dev_java.grade1208;

public class Test2 {

    void 메소드이름() {
        
        for (int i = 1;i <= 10; i++) {
            switch (i % 3) {
                case 0:
                    System.out.println(i+" :  3의 배수입니다.");//3 6 9
                    break;
                case 1: case 2: 
                    System.out.println(i+" :  3의 배수가 아닙니다.");//1 2 4 5 7 8 10
                    break;
            }
           
        } // end of while
    }// end of 메소드 이름()

    public static void main(String[] args) {
        Test2 t2 = new Test2();
        t2.메소드이름();
    }
}
