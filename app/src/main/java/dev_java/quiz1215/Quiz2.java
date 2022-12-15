package dev_java.quiz1215;

public class Quiz2 {
	public static void main(String[] args) {
		int users[] = new int[10];
		for(int i=0;i<users.length;i++){
			users[i] = (int)(Math.random()*20)%21-10;
		}
	}
}
