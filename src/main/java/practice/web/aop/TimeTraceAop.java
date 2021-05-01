package practice.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
//@Component 컴포넌트 스캔 이용해도 되지만 직접 등록하는 것을 선호
public class TimeTraceAop {
    //공통 관심사항을 어디에 적용할 것인가?
    @Around("execution(* practice.web..*(..)) && !target(practice.web.SpringConfig)") //하위 패키지에 다 적용하겠다
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed(); //다른 메소드로 진행됨
        } finally {
            long finish = System.currentTimeMillis();
            long timeMS = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMS + "ms");
        }
    }
}
