package com.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarNew {
	
	public static void main(String[] args) {
		
		Calendar cal = new GregorianCalendar();
		
		cal.set(Calendar.MONTH, 3);
		cal.set(Calendar.YEAR, 2015);
		
		System.out.println(cal.getMaximum(Calendar.DAY_OF_MONTH));
		
//		Calendar cal1 = Calendar.getInstance();
//		cal1.roll(Calendar.DAY_OF_MONTH, -3);
//		System.out.println(cal1);
//		System.out.println(cal1.get(Calendar.DAY_OF_MONTH));
//		System.out.println(cal1.getActualMaximum(Calendar.DAY_OF_MONTH));
		
//		Calendar cal1 = Calendar.getInstance();
//		System.out.println(cal1.get(Calendar.DAY_OF_WEEK));
//		System.out.println(cal1.get(Calendar.HOUR));
//		System.out.println(cal1.get(Calendar.HOUR_OF_DAY));
//		System.out.println(cal1.get(Calendar.MINUTE));
//		System.out.println(cal1.get(Calendar.MILLISECOND));
		
	}

}
