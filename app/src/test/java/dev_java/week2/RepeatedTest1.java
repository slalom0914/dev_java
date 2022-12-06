package dev_java.week2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RepeatedTest1 {
  @Test // 해당메소드가 테스트 메소드 임을 나타냄
  @DisplayName("파라미터 두 수 비교테스트")
  void methodB(){
    assertEquals(2, 1+1);
  }
  @RepeatedTest(15) // 반복된 테스트를 하기 위해 사용되는 어노테이션
  void methodA(){
    Random r = new Random();
    int i = r.nextInt(10);
    System.out.println(i);
  }
}
