package com.teste;

import java.math.BigDecimal;

public class TestesBigDecimal {

	public static void main(String[] args) {

		BigDecimal x = new BigDecimal(10.1);
		BigDecimal y = new BigDecimal(10);
		
		String confirm = x.compareTo(y) > 0 ? "Sim" : "Não";
		
		System.out.println(confirm);
		
	}

}
