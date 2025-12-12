package anet.step2.thread;

import static util.CustomLogger.logger;

class HelloThread extends Thread {
    @Override
    public void run() {
        logger("run()호출");
    }
}
public class ThreadMain {
    public static void main(String[] args) {
        logger("main() start");
        //main스레드에서 HelloThread인스턴스하기
        //만일 스레드 이름을 부여하지 않으면 Thread-0, Thread-1
        //같이 임의의 이름을 부여함.
        HelloThread ht = new HelloThread();
        logger("start() 호출 전");
        ht.start();
        logger("start() 호출 후");
        logger("main() end");
    }//end of main thread
}
/*
start()메서드 호출하면 Thread-0 스레드가 시작되면서 Thread-0스레드가 run()호출함.
여기서 핵심은 main()스레드가 run()실행하는게 아니라 Thread-0스레드가 run()실행한다는 점이다.

main스레드는 단지 start()메서드를 통해 Thread-0 스레드에게 실행을 지시하는 것임

두 개의 스레드가 공존
스레드 간 실행 순서가 보장되지 않음.
순서는 운영체제에 의해서 결정됨.
같은PC라도 요청할 때마다 순서가 달라질 수도 있다.

CPU코어가 2개일때
: 2개이니까 물리적으로 정말 동시에 실행될 수 도 있고
: 하나의 CPU코더에 시간을 나누어서 실행될 수 도 있는 것임.
한 스레드가 얼마나 오랜 기간을 실행되는지도 보장하지 않음.
한 스레드가 다 수행된 다음에 다른 스레드가 수행될 수도 있고
둘이 완전히 번갈아가면서 수행되는 경우도 있다.

결론
순서와 실행기간을 모두 보장하지 않는다. - 멀티스레드
List(인터페이스) -> ArrayList(단일스레드만 안전),
 Vector(멀티스레드 안전함- 나는 ArrayList보다 읽고쓰기가 느려)

CPU코어가 1개일 때

 */