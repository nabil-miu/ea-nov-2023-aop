package edu.miu.cs544.labs.lab3.aspects;

import edu.miu.cs544.labs.lab3.entity.ActivityLog;
import edu.miu.cs544.labs.lab3.exceptions.AopIsAwesomeHeaderException;
import edu.miu.cs544.labs.lab3.service.ActivityLogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class LoggerAspect {
    private final HttpServletRequest request;
    private final ActivityLogService activityLogService;

    @Around("@annotation(edu.miu.cs544.labs.lab3.aspects.annotations.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long executionTime = end - start;
        activityLogService.save(new ActivityLog(joinPoint.getSignature().getName(), executionTime));
        return result;
    }

    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object checkHeader(ProceedingJoinPoint pjp) throws Throwable {
        String header = request.getHeader("AOP-IS-AWESOME");
        if (header == null) {
            throw new AopIsAwesomeHeaderException("The AOP-IS-AWESOME header is required");
        }
        return pjp.proceed();
    }
}
