package dev_java.week2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberValidCheck {
  @DisplayName("입력받은값 유효성 체크하기")
  @ParameterizedTest
  //@ValueSource(strings = {"5", "150", "-10"})
  @ValueSource(strings = {"151", "10", "360"})
  void 너정수니(String input){  
    assertTrue(isNumber(input));
    assertTrue(자리수체크(input));
  }
  public static boolean 자리수체크(String s){
    boolean isOk = false;
    if(s.length() == 3){
      isOk = true;
      return isOk;
    }else{
      return isOk;
    }
  }
  public static boolean isNumber(String s){
    try {
      Double.parseDouble(s);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }//end of isNumber
}
