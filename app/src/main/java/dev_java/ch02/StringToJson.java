package dev_java.ch02;

import java.util.HashMap;
import java.util.Map;

public class StringToJson {
  public static void main(String[] args) {
    Map<String,Object> map = new HashMap  <>();
    map.put("name", "김유신");
    Gson g = new Gson();
  }
}
