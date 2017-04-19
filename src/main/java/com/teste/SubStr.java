package com.teste;

public class SubStr {

	public static void main(String[] args) {
		
		String orgVenda = "0102";//Pre-Tag do Envelope de Requisicao
		
		String idEmp = orgVenda.substring(0, 2);
		String filial = orgVenda.substring(2, 4);
		
		System.out.println(orgVenda.length());
		System.out.println(idEmp);
		System.out.println(filial);
		
//		System.out.println("20/01/2015 00:02:34".substring(11, 16));
		
//		System.out.println(String.format("%08d", 255555233));
		
//		String urlStr = String.format("%s/obterDadosTabela/%s&%s&%s",
//				"http://10.0.0.81:8080/ssmservices/services/PedidoService",
//				"expressav2",
//				"adm",
//				"mUAU08e8+18=").replace("services/PedidoService",
//											"ssservices");
//		System.out.println(urlStr);
		

//		String urlStr = String.format("%s/OWS001.apw?wsdl/%s&%s&%s&%s&%s", "http://187.94.60.130:12201/ws",
//				"f2e986e4b84d194116611d9702ba00b94103f936", "01", "01", "01198", "01");
//		
//		System.out.println(urlStr);

	}

}
