package com.teste;

public class TestDouble {
	
	public static void main(String[] args) {
		
		String s = "5,3262";
		
		Double d = new Double(s.replace(",", "."));
		
		String sm = String.format("%.2f", d);
		
		Double n = Double.valueOf(sm.replace(".", ","));
		
		System.out.println(d);
		System.out.println(sm);
		System.out.println(n);

	}

}
