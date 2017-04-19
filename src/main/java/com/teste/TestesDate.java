package com.teste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestesDate {

	public static void main(String[] args) throws ParseException {
		
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        String horaAtual = sdf.format(new Date());
        
//        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");    
//        Date dMin = formatador.parse("15:30");  
//        Date dMax = formatador.parse("16:30");
//        
//        System.out.println(dMin);
//        System.out.println(dMax);
//        
//        if(dMin.before(dMax)) {
//        	System.out.println("Sim");
//        } else {
//        	System.out.println("Não");
//        }
        
//		Calendar dataAtualCalendar = Calendar.getInstance();
//		Calendar horaCorteAtualCalendar = Calendar.getInstance();
//		
//		horaCorteAtualCalendar.set(Calendar.HOUR_OF_DAY, 11);
//		horaCorteAtualCalendar.set(Calendar.MINUTE, 30);
//		horaCorteAtualCalendar.set(Calendar.SECOND, 0);
//		
//		Date horaAtual = dataAtualCalendar.getTime();
//		Date horacorte = horaCorteAtualCalendar.getTime();
//		
//		
//		if (horaAtual.before(horacorte)) {
//			System.out.println("Sim");
//		} else {
//			System.out.println("Não");
//		}
//
//		System.out.println(horaAtual);
//		System.out.println(horacorte);
		
		
		
		
		
		
	
      //creating Date from millisecond
      Date currentDate = new Date();
     
      SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
      String dataFormatada = formatador.format(currentDate);
      System.out.println(dataFormatada);
      
      currentDate = formatador.parse(dataFormatada);
//     
//      currentDate = new Date(dataFormatada);
//      //printing value of Date
      System.out.println("current Date: " + currentDate);
//     
//      DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
//     
//      //formatted value of current Date
//      System.out.println("Milliseconds to Date: " + df.format(currentDate));
//     
//      //Converting milliseconds to Date using Calendar
//      Calendar cal = Calendar.getInstance();
//      cal.setTimeInMillis(currentDateTime);
//      System.out.println("Milliseconds to Date using Calendar:"
//              + df.format(cal.getTime()));
//     
//      //copying one Date's value into another Date in Java
//      Date now = new Date();
//      Date copiedDate = new Date(now.getTime());
//     
//      System.out.println("original Date: " + df.format(now));
//      System.out.println("copied Date: " + df.format(copiedDate));


	}

}
