package com.teste;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Primos {

	public static void main(String[] args) {

//		for (int i = 0; i < 10001; i++) {
////			if()
//		}
		
		Double value = 102.37700000000001;
		Double truncatedDouble = BigDecimal.valueOf(value)
			    .setScale(3, RoundingMode.HALF_EVEN)
			    .doubleValue();
		System.out.println(truncatedDouble);

	}

}
