package com.teste.soap;

import java.net.URL;
import javax.wsdl.Service;
import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ServiceFactory;

public class RequestSoapWS {

	static String url = "http://187.94.60.130:12201/ws/OWS001.apw?wsdl";

	public static void main(String[] args) throws Exception {

		System.setProperty("javax.xml.soap.MessageFactory", "weblogic.webservice.core.soap.MessageFactoryImpl");
		System.setProperty("javax.xml.rpc.ServiceFactory", "weblogic.webservice.core.rpc.ServiceFactoryImpl");
		ServiceFactory factory = ServiceFactory.newInstance();

		String targetNamespace = "http://www.themindelectric.com/" + "/SRVCHECK";
		QName serviceName = new QName(targetNamespace, "net.xmethods.services.stockquote.StockQuoteService");
		QName portName = new QName(targetNamespace, "net.xmethods.services.stockquote.StockQuotePort");
		QName operationName = new QName("urn:xmethods-delayed-quotes", "getQuote");
		URL wsdlLocation = new URL(url);
		Service service = (Service) factory.createService(wsdlLocation, serviceName);
		Call call = ((javax.xml.rpc.Service) service).createCall(portName, operationName);
		Float result = (Float) call.invoke(new Object[] { "OWS001SOAP" });
		
		System.out.println("\n");
		System.out.println("This example shows how to create a dynamic client application that invokes a non-WebLogic Web Service.");
		System.out.println("The webservice used was: http://services.xmethods.net/soap/urn:xmethods-delayed-quotes.wsdl");
		System.out.println("The quote for BEAS is: ");
		System.out.println(result);
	}

}
