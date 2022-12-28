package dev_java.week5;

class ThreadEx13 {				
	static long startTime = 0;			
	public static void main(String args[]) {			
		A th1 = new A();		
		B th2 = new B();		
		th1.start();		
		th2.start();		
				
		startTime = System.currentTimeMillis();		
				
		try {		
			th1.join();	// th1의 작업이 끝날 때까지 기다린다.
			th2.join();	// th2의 작업이 끝날 때까지 기다린다.
		} catch(InterruptedException e) {}		
				
		System.out.print("소요시간:" + (System.currentTimeMillis() - ThreadEx13.startTime));		
	} // main			
}				
				
				
class A extends Thread {				
	public void run() {			
		for(int i=0; i < 300; i++) {		
			System.out.print("-");	
		}		
		System.out.println("[[[  A스레드 run   ]]]");		
	} // run()			
}				
				
				
				
class B extends Thread {				
	public void run() {			
		for(int i=0; i < 300; i++) {		
			System.out.print("|");	
		}		
		System.out.println("[[[  B스레드 run  ]]]");		
	} // run()			
}				

