package com.teste;

public class Split {

	public static void main(String[] args) {

		String s = "1;2;3;4;5;6;7";
		
		String[] array = s.split(";");
		
		for (String num : array) {
			System.out.println(num);
		}
		

	}

}
