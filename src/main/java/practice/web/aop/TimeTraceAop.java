package practice.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {
    //@Around: 공통 관심사항을 어디에 적용할 것인가?
    @Around("execution(* practice.web..*(..)) && !target(practice.web.SpringConfig)") //하위 패키지에 다 적용하겠다
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed(); //기존 메소드 진행됨
        } finally {
            long finish = System.currentTimeMillis();
            long timeMS = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMS + "ms");
        }
    }
}
