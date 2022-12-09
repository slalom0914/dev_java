package dev_java.grade1208;

public class Test3 {
  void 메소드이름() {
    System.out.println("메소드이름 호출 성공");
    int arr[] = { 0, 0, 0, 0 };// 0 0 0 0
    for (int i = 0; i <= arr.length; i++) {
      try {
        arr[i] += (10 + i);
        System.out.println(arr[i]);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(e.toString());
      } // end of try
    } /// end of for
    System.out.println("여기....");
  }

  public static void main(String[] args) {
    Test3 t3 = new Test3();
    t3.메소드이름();
  }
}
