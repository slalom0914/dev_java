package ch06;
// 문자열 찾기
public class P164 {
    public static void main(String[] args) {
        String title = "Hello Java";
        int index = title.indexOf("Hello");
        System.out.println(index);
        if(index == -1){
            System.out.println("당신이 찾는 문자열은 존재하지 않습니다.");
        }else{
            System.out.println("당신이 찾는 문자열이 발견되었습니다.");
        }
    }
}
