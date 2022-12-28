package dev_java.week5;

public class NomalThreadTest {					
	/*					
	 * 자바에서는 애플리케이션 내부의 모든 스레드가 종료되지 않으면 JVM이 종료되지 않는다.					
	 * main메소드의 스레드가 종료되었지만 중간에 생성한 스레드가 종료될때 까지 애플리케이션은 종료되지 않는다.					
	 * 					
	 */					
		public static void main(String[] args) {				
			Thread th = new Thread() {			
				public void run() {		
					try {	
			//5초가 될때까지 빨강버튼이 꺼지지 않는다.			
						Thread.sleep(5000);
						System.out.println("MyThread 종료");
					} catch (InterruptedException e) {	
						
					}	
				}		
			};			
			th.start();			
			System.out.println("main() 종료");			
		}///////////////end of main				
						
	}					
	
