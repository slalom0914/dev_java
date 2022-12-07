package dev_java.week2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomGameTest {
  @DisplayName("입력받은 값이 숫자니?")
  //@ValueSource(strings = {"5", "안녕"}) 터짐
  //@ValueSource(strings = {"5", "100", "-5"}) 터짐
  @ValueSource(strings = {"512", "115", "100"})
  @ParameterizedTest
  void 정수인지(String input){
    //assertTrue(input.chars().allMatch(Character::isDigit));양의정수인지도체크
    assertTrue(isNumeric(input));
    assertTrue(자리수(input));
  }

  

  public static boolean 자리수(String s){
    boolean isOk = false;
    if(s.length()==3) {
      isOk = true;
      return isOk;
    }else{
      return isOk;
    }
  }
  public static boolean isNumeric(String s) {
    try {
        Double.parseDouble(s);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
  
}
