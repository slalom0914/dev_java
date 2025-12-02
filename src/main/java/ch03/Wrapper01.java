package ch03;
//원시형 타입에 대응하는 클래스가 필요하다.
//원시형 타입은 변수나 메서드를 가질 수 없다.
public class Wrapper01 {
    public static void main(String[] args) {
        Integer i = new Integer(10);
        int j = i;
        System.out.println(i);
        System.out.println(j);
        //인스턴스변수 i는 Integer타입이야? - true
        if(i instanceof Integer){
            System.out.println("i는 Integer타입 입니다.");
        }
        //변수 i는 본래 Integer이었는데 String타입으로 전환됨
        String x = String.valueOf(i);
        if(x instanceof String){
            System.out.println("변수 x는 String 타입 입니다.");
        }
    }
}
