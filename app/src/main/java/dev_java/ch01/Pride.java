package dev_java.ch01;

// static은 메소드 이름 앞에도 올 수 있고
// 변수명 앞에도 올 수 있다.
// 그렇다면 인스턴스화 하는 것과 뭐가 다르지?
public class Pride {
  // 자동차 이름
  static String carName = "2023년형 프라이드";
  // 자동차 색상
  String carColor = "흰색";
  // 바퀴수를 담는 변수 선언
  int wheelNum = 4;

  // 에러에는 두 가지가 있어요
  // 문법에러 , 런타임 에러(Exception)
  public static void main(String[] args) {
    // 변수이름 앞에 static이 있으면 인스턴스화 없이도 호출이 가능함.
    // 이 말은 같은 객체를 복제하지 않는다는 의미 포함(납득)
    System.out.println(carName);//
    // 인스턴스화 라고 함 - Pride객체가 메모리 상주 -> 호출이 가능한 상태
    Pride myCar = new Pride();// myCar를 인스턴스 변수라 한다.
    // insert here
    System.out.println("22번 라인 에서 ====> " + myCar);
    myCar.carColor = "보라색";
    myCar = null;// 주소번지가 가리키는 객체가 사라졌다. 그러나 타입은 남았다
    // myCar.carColor = "보라색";
    // insert here - 여기서는 자동차 색상을출력할 수 있나요???
    myCar = new Pride();// 새로운 주소번지를 갖는다
    System.out.println("28번 라인 에서 ====> " + myCar);
    System.out.println(myCar == myCar);//무엇을 비교하는 문장 인가요? true가 출력되는 이유를 말해보세요
    // insert here

    // myCar.carColor = "검정색";
    System.out.println(myCar.carColor);//
    myCar.carColor = "검정색";
  }
}
