package com.mycompany.app.common;
 

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class DataSourceAspect {
	@Pointcut("execution(* com.mycompany.app..*.service.*.*(..))")
    public void pointCut() {
    };
    
    @Before(value = "pointCut")
    public void before(JoinPoint point) {
        Object target = point.getTarget();
        System.out.println(target.toString());
        String method = point.getSignature().getName();
        System.out.println(method);
        Class<?>[] classz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            System.out.println(m.getName());
            if (m != null && m.isAnnotationPresent(DataSourcer.class)) {
                DataSourcer data = m.getAnnotation(DataSourcer.class);
                HandleDataSource.putDataSource(data.value());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
