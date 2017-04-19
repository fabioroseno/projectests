package com.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTestes {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//		sdf.setLenient(false);
		try {
			//if not valid, it will throw ParseException
			Date date = sdf.parse("99/99/9999");
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
