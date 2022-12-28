package dev_java.week5;

class StopThread implements Runnable {							
	boolean stopped = false;						
							
							
	@Override						
	public void run() {						
		while(!stopped) {					
			System.out.println("Thread is alive....");				
			try {				
				Thread.sleep(500);			
			} catch (InterruptedException e) {				
				e.printStackTrace();			
			}				
		}					
		System.out.println("Thread is deaded");					
	}						
	public void stop() {						
		stopped = true;					
	}						
}							
													
							
public class StopThreadTest {							
	public static void main(String[] args) {	
		System.out.println("main start");					
		StopThreadTest stt = new StopThreadTest();					
		stt.process();					
		System.out.println("main end");					
	}						
	public void process() {						
		StopThread st = new StopThread();					
		Thread th = new Thread(st);					
		th.start();					
		try {					
			Thread.sleep(1000);				
		} catch (InterruptedException e) {					
			e.printStackTrace();				
		}					
		st.stop();					
	}						
}
