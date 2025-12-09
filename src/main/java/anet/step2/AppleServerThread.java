package anet.step2;

public class AppleServerThread extends Thread {
    AppleServer as = null;
    private volatile boolean isRun = false;
    public AppleServerThread(AppleServer as) {
        this.as = as;
    }
    @Override
    public void run() {

    }
    public void broadCasting(String msg){

    }//end of broadingCasting
    public void send(String msg){

    }//end of send
}
