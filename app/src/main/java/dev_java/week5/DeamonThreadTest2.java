package dev_java.week5;

public class DeamonThreadTest2 {

	public static void main(String[] args) {
		Thread th = new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
					System.out.println("MyThread 종료");
				} catch (InterruptedException e) {

				}
			}
		};
		// 데몬 스레드로 설정함.
		// 아래와 같이 데몬스레드를 설정하면 내부의 모든 스레드가 종료되지 않아도 어플리케이션이 종료된다.
		th.setDaemon(false);// false로 하면 MyThread 종료가 출력된다. 이문장이 없으면 false와 결과같음.
		th.start();
		System.out.println("main() 종료");
	}/////////////// end of main
}
