package com.mycompany.app.common;
 

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
@Component 
@Aspect
public class DataSourcerAspect {
	@Pointcut(value="execution(* com.mycompany.app.service..*.*(..))")
    public void pointCut() {
    };
    
    /**
     * aop 反射  切换数据源
     * @param point
     */
    
    private static String defultDataSource = "dataSource_sys";
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Before(value = "pointCut()")
    public void before(JoinPoint point) {
        Object target = point.getTarget();
        System.out.println(target.toString());
        String method = point.getSignature().getName();
        System.out.println(method);
        Class  classz = target.getClass();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = classz.getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSourcer.class)) {
            	System.out.println(m.getName());
                DataSourcer data = m.getAnnotation(DataSourcer.class);
                HandleDataSource.putDataSource(data.value());
            }else {
            	HandleDataSource.putDataSource(defultDataSource);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
