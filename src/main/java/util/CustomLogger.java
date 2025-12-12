package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class CustomLogger {
    // ANSI 색상 코드
    private static final String RESET = "\u001B[0m";
    private static final String RED   = "\u001B[31m"; // 빨강
    private static final String GREEN = "\u001B[32m"; // 초록
    private static final String CYAN  = "\u001B[36m"; // 청록
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void logger(Object obj) {
        String time = LocalTime.now().format(formatter);

        // 현재 스레드의 스택 트레이스 가져오기
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement caller = null;
        String className = "UnknownClass";
        String methodName = "unknownMethod";
        String fileName = "UnknownSource";
        int lineNumber = -1;

        // logger()를 호출한 실제 위치(호출자)를 찾기
        for (StackTraceElement element : stackTrace) {
            String cn = element.getClassName();
            // Thread, CustomLogger 자신은 제외하고 처음 나오는 요소를 호출자로 판단
            if (!cn.equals(Thread.class.getName())
                    && !cn.equals(CustomLogger.class.getName())) {
                //className = cn;
                //lineNumber = element.getLineNumber();
                caller = element;
                break;
            }
        }
        if (caller != null) {
            className = caller.getClassName();
            methodName = caller.getMethodName();
            fileName = caller.getFileName();   // 예: MyService.java
            lineNumber = caller.getLineNumber();
        }
        // 시간, 스레드이름, 클래스이름, 라인번호, 메시지 출력
        // 시간, 스레드이름, (IntelliJ가 인식 가능한) 파일명:라인번호 형식으로 출력
        // 형식을 "at 패키지.클래스.메서드(파일명.java:라인번호)" 로 맞춰주면
        // IntelliJ 콘솔에서 (파일명.java:라인번호) 부분이 클릭 가능해진다.
        System.out.printf(
                "[%s%s%s][%10s]%s%s%s.%s%s%s(%s:%d) - %s%n",
                RED, time, RESET,                        // time → 빨강
                Thread.currentThread().getName(),        // 스레드 이름
                GREEN, className, RESET,                 // className → 초록
                CYAN, methodName, RESET,                 // methodName → 청록
                fileName,
                lineNumber,
                obj
        );
    }
}
