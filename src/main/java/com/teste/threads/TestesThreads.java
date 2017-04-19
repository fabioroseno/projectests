package com.teste.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestesThreads {

	public static void main(String[] args) {
		
//		Programa p1 = new Programa(1);
//		Thread t1 = new Thread(p1);
//		t1.start();
//		
//		Programa p2 = new Programa(2);
//		Thread t2 = new Thread(p2);
//		t2.start();
		
//		Runnable r = () -> {
//			System.out.println("Programa 1");
//			for (int i = 0; i <= 10000; i++) 
//				System.out.print(i + " - ");
//		};
//		Thread t = new Thread(r);
//		t.start();
//		
//		Runnable r1 = () -> {
//			System.out.println("Programa 2");
//			for (int i = 0; i <= 10000; i++) 
//				System.out.print(i + " - ");
//		};
//		Thread t1 = new Thread(r1);
//		t1.start();
		
		Integer cdVendedor = 0;
		long baseMovimento = 3L;
		baseMovimento *= 10000000000L;
		System.out.println(baseMovimento);
		baseMovimento += cdVendedor;
		System.out.println(baseMovimento);
		
		
//		int a = 2, b = 5, c = 2, d = 5;
//
//		System.out.println(a*=b);
//		System.out.println(c+=d);
		
//		SimpleDateFormat dataHoje1 = new SimpleDateFormat("yyMMdd");
//
//		System.out.println(dataHoje1.format(new Date()) + "1");

	}

}
