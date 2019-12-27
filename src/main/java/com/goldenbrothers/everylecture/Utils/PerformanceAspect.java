package com.goldenbrothers.everylecture.Utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {
	
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		
		System.out.println("------------------------------------------");
		System.out.println("[log]Before: " + methodName + "() ���� ����");
		System.out.println("------------------------------------------");
		
		long startTime = System.nanoTime();
		
		Object result = null;
		
		try {
			result = joinPoint.proceed(); // �ٽ� ��� ����
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[log]Exception: " + methodName);
		}
		
		long endTime = System.nanoTime();
		
		System.out.println("------------------------------------------");
		System.out.println("[log]After: " + methodName + "() ���� ����");
		System.out.println("[log]: " + methodName + "() ���� �ð�" + (endTime - startTime) + "ns");
		System.out.println("------------------------------------------");
		
		return result;
		
	}

}
