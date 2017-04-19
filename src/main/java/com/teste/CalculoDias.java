package com.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CalculoDias {

	public static void main(String[] args) {
		
		int mesAtual = 6;
		int diaAtual = 14;

		Calendar dataAtualCalendar = Calendar.getInstance();
		dataAtualCalendar.set(Calendar.MONTH, mesAtual);
		dataAtualCalendar.set(Calendar.DAY_OF_MONTH, diaAtual);
		
		Calendar horaAtualCalendar = Calendar.getInstance();
		Calendar horaCorteCalendar = Calendar.getInstance();
				
		Calendar dataEntregaCalendar = Calendar.getInstance();
		dataEntregaCalendar.set(Calendar.MONTH, mesAtual);
		dataEntregaCalendar.set(Calendar.DAY_OF_MONTH, diaAtual);
		dataEntregaCalendar.set(Calendar.MINUTE, 0);
		dataEntregaCalendar.set(Calendar.SECOND, 0);
		
		int diaSemanaAtual = dataAtualCalendar.get(Calendar.DAY_OF_WEEK);
		int qtdeAcrescimo = 1;
		int qtdeDiasAdicionados = 0;
		
		String horaCorte = "12:30";
		if(!"".equals(horaCorte) && horaCorte.contains(":")) {
			
			String[] horaMinutoCorte = horaCorte.split(":");
			horaCorteCalendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(horaMinutoCorte[0]));
			horaCorteCalendar.set(Calendar.MINUTE, Integer.valueOf(horaMinutoCorte[1]));
			horaCorteCalendar.set(Calendar.SECOND, 0);
			
		}
		
		String expedicoes = "3;4;2";
		String[] diasEpedicao = expedicoes.split(";");
		
		List<Integer> diasEpedicaoList = new ArrayList<Integer>();
		
		for (String num : diasEpedicao) {
			diasEpedicaoList.add(Integer.valueOf(num));
		}
		
		Collections.sort(diasEpedicaoList);
		
		for (Integer diaEpedicao : diasEpedicaoList) {
			
			int diaExpedicaoInt = Integer.valueOf(diaEpedicao);
			
			if(diaExpedicaoInt == diaSemanaAtual) {
				
				if(!"".equals(horaCorte)) {
					if(horaAtualCalendar.before(horaCorteCalendar)) {
						qtdeDiasAdicionados = qtdeAcrescimo;
						break;
					} else {
						if(diaExpedicaoInt == diasEpedicaoList.get(diasEpedicaoList.size()-1)) {
							qtdeDiasAdicionados = ( 7 - ( diaSemanaAtual - diasEpedicaoList.get(0))) + qtdeAcrescimo;
						} else {
							continue;
						}
					}
				} else {
					qtdeDiasAdicionados = qtdeAcrescimo;
					break;
				}
				
			} else if(diaExpedicaoInt < diaSemanaAtual) {
				if(diasEpedicaoList.size() == 1 || diaExpedicaoInt == diasEpedicaoList.get(diasEpedicaoList.size()-1)) {
					int diaExpedicao = diaExpedicaoInt;
					
					if(diaExpedicaoInt == diasEpedicaoList.get(diasEpedicaoList.size()-1) && diasEpedicaoList.size() > 1) {
						diaExpedicao = diasEpedicaoList.get(0);
					}
					
					qtdeDiasAdicionados = ( 7 - ( diaSemanaAtual - diaExpedicao)) + qtdeAcrescimo;
				} else {
					continue;
				}
			} else if(diaExpedicaoInt > diaSemanaAtual) {
				qtdeDiasAdicionados = (diaExpedicaoInt - diaSemanaAtual) + qtdeAcrescimo;
				break;
			}
			
		}

		dataEntregaCalendar.add(Calendar.DAY_OF_MONTH, qtdeDiasAdicionados);
		
		if(dataEntregaCalendar.get(Calendar.DAY_OF_WEEK) == 1) {
			dataEntregaCalendar.add(Calendar.DAY_OF_MONTH, 1);
		} else if(dataEntregaCalendar.get(Calendar.DAY_OF_WEEK) == 7) {
			dataEntregaCalendar.add(Calendar.DAY_OF_MONTH, 2);
		}

		System.out.println(dataEntregaCalendar.getTime());

	}

}
