package dev_java.pattern;

public class HintPart1 {
  //선언부
  //컴터가 채번한 숫자를 담을 1차배열 선언
  int com[] = new int[3];
  //사용자가 입력한 문자열 쪼개서 담을 1차배열 선언
  int my[] = new int[3];
  //회차를 담을 변수 선언
  int cnt = 0;
  //새 게임 버튼을 누르면 3자리의 서로 다른 숫자를 채번한다
  public void ranCom(){
    com[0] = (int)(Math.random()*10);
    //중복된 숫자를 제거하는 목적으로 do..while선택함
    do{
      com[1] = (int)(Math.random()*10);
    }while(com[0] == com[1]);
    do{
      com[1] = (int)(Math.random()*10);
    }while(com[0] == com[2] || com[1] == com[2]);
  }

  //3자리 숫자를 입력 받아서 힌트문을 작성해주는 메소드 구현
  public String account(String user){
    if(user.length() !=3){
      return "세자리 숫자만 입력하세요.";//account메소드 탈출하기
    }
    int imsi = 0;//파라미터로 넘어온 사용자가 입력한 문자열 값을 정수형으로 변환 담기
    int strike = 0;
    int ball = 0;
    try {
      imsi = Integer.parseInt(user);
    } catch (NumberFormatException e) {
      return "숫자만 입력하세요.";
    }
    my[0] = imsi/100;// 256/100 -> 2.56 int/int -> 2만 남음
    my[1] = (imsi%100)/10; //256%100 -> 56/10 -> 5.6 -> 5남음
    my[2] = imsi%10;//256%10 -> 몫은 25이고 나머지는 6이다
    for(int i=0;i<com.length;i++){//입력받은 숫자가 com배열에 존재하니? 네-볼 , 아니오-제외
      for(int j=0;j<com.length;j++){//만일 위에서 네 라면 스트라잌인지를 검사한다 com 배열의 i자리와 my배열의 j 자리가 같니
        //숫자가 있어?
        if(com[i] == my[j]){//같은 숫자가 있는지만 비교하고 자리가 달라도 참이다.
          //볼은 확보 되었다. 자리가 같은지 비교하자
          //숫자의 자리도 같아?
          if(i == j){//42번에서 비교한 숫자의 자리가 사용자가 입력받은 자리까지도 같은거야? 네-스, 노-볼
            strike ++;
          }else{
            ball++;
          }
        }//입력받은 숫자가 컴터채번한 숫자와 일치하는 경우
      }//////////end of inner for문
    }///////////end of outter for문
    //strike변수값이 3이면 55번은 실행될 기회를 못 갖는다.
    if(strike == 3) return "정답입니다.";
    return strike+"스 "+ ball +"볼";
  }////////////end of account
  public static void main(String[] args) {
    
  }
}
