package com.bankonet.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component("logAspect")
public class LogAspect {

	final private String couches= "execution(* com.bankonet.metier.*.*(..)) || execution(* com.bankonet.dao.*.*(..))";
	
	
//	@Before(couches)
//	public void beforeLog(JoinPoint joinPoint)
//	{
//		System.out.println("----AOP----");
//		System.out.println("----BEFORE----");
//		System.out.println("classe appelée : "+ joinPoint.getTarget().getClass());
//		System.out.println("méthode appelée : "+ joinPoint.getSignature().getName());
//		System.out.println("paramètres : "+ joinPoint.getArgs());
//	}
//	
//	@AfterReturning(pointcut = couches, returning = "returning")
//	public void afterLog (JoinPoint jointPoint, Object returning) {
//		System.out.println("----AOP----");
//		System.out.println("----AFTERRETURNING----");
//		System.out.println("Classe : "+jointPoint.getTarget().getClass());
//		System.out.println("méthode : "+jointPoint.getSignature().getName());
//		System.out.println("returning : "+returning.toString());
//	}
	
	@Around(couches)
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("----AOP----\n");
		
		System.out.println("----AROUND : BEFORE----");
		System.out.println("classe appelée : "+ joinPoint.getTarget().getClass());
		System.out.println("méthode appelée : "+ joinPoint.getSignature().getName());
		System.out.println("paramètres : "+ joinPoint.getArgs());
		System.out.println("\n");
		
		try {
			Object returning = joinPoint.proceed();
			
			System.out.println("----AROUND : AFTERRETURNING----");
			System.out.println("Classe : "+joinPoint.getTarget().getClass());
			System.out.println("méthode : "+joinPoint.getSignature().getName());
			System.out.println("returning : "+returning.toString()+"\n");
			return returning;
		} catch (Throwable e) {
			e.printStackTrace();
			throw e;
		}
	
	}
		
	@AfterThrowing(pointcut=couches , throwing = "e")
	public void logAfterThrowing (JoinPoint joinpoint, Throwable e)
	{
		System.out.println("Exception "+ e + "lancée par "+joinpoint.getSignature().getName()+"()");
	}
		
		
		
		
		
	
}
