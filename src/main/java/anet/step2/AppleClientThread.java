package anet.step2;

public class AppleClientThread extends Thread {
    AppleClient ac = null;
    private volatile  boolean isRun = false;
    public AppleClientThread(AppleClient ac) {
        this.ac = ac;
    }
    @Override
    public void run() {
        while(!isRun){

        }//end of while
    }//end of run
}//end of AppleClientThread
