package dev_java.view.array;

public class AccountSample {
	ButtonArray_2 ba2 = null;
	public AccountSample(ButtonArray_2 ba2){
		this.ba2 = ba2;
	}
	public String account(){
		return "낮춰라";
	}
	public void account2(){
		String msg =  "낮춰라";
		//jta_display는 ButtonArray_2에 생성된 객체인데
		//굳이 AccountSample에서 사용하고 싶다고 한다 어떡하지?
		ba2.jta_display.append(msg+"\n");
	}
}
