package com.teste.soap;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.w3c.dom.NodeList;

public class SOAPClientTotvs {

	/*
	<?xml version="1.0" encoding="UTF-8"?>
	<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ows="http://187.94.60.130:12201/ws/">
	  <SOAP-ENV:Header />
	  <SOAP-ENV:Body>
	    <ows:SALDOPROD>
	      <ows:TOKEN>f2e986e4b84d194116611d9702ba00b94103f936</ows:TOKEN>
	      <ows:ID_EMP>01</ows:ID_EMP>
	      <ows:ID_FIL>01</ows:ID_FIL>
	      <ows:PRODID>
	        <ows:PROD_ITENS>
	          <ows:PRODSID2>
	            <ows:ID>01008</ows:ID>
	            <ows:LOCAL>01</ows:LOCAL>
	          </ows:PRODSID2>
	        </ows:PROD_ITENS>
	      </ows:PRODID>
	    </ows:SALDOPROD>
	  </SOAP-ENV:Body>
	</SOAP-ENV:Envelope>
	 */

	public static void main(String args[]) throws Exception {

		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String serverURI = "http://187.94.60.130:12201/ws/";
		String service = "OWS001.apw";
		String preTag = "ows";

		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration(preTag, serverURI);

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElemSaldo = soapBody.addChildElement("SALDOPROD", preTag);
		SOAPElement soapBodyElemToken = soapBodyElemSaldo.addChildElement("TOKEN", preTag);
		soapBodyElemToken.addTextNode("f2e986e4b84d194116611d9702ba00b94103f936");
		SOAPElement soapBodyElemEmpresa = soapBodyElemSaldo.addChildElement("ID_EMP", preTag);
		soapBodyElemEmpresa.addTextNode("01");
		SOAPElement soapBodyElemFilial = soapBodyElemSaldo.addChildElement("ID_FIL", preTag);
		soapBodyElemFilial.addTextNode("01");
		SOAPElement soapBodyElemProdutos = soapBodyElemSaldo.addChildElement("PRODID", preTag);
		SOAPElement soapBodyElemItens = soapBodyElemProdutos.addChildElement("PROD_ITENS", preTag);
		SOAPElement soapBodyElemProd = soapBodyElemItens.addChildElement("PRODSID2", preTag);
		SOAPElement soapBodyElemId = soapBodyElemProd.addChildElement("ID", preTag);
		soapBodyElemId.addTextNode("01008");
		SOAPElement soapBodyElemLocal = soapBodyElemProd.addChildElement("LOCAL", preTag);
		soapBodyElemLocal.addTextNode("01");

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "SALDOPROD");

		soapMessage.saveChanges();

		SOAPMessage soapResponse = soapConnection.call(soapMessage, serverURI + service);

		System.out.print("Request SOAP Message: ");
		soapMessage.writeTo(System.out);
		System.out.println();
		System.out.print("Response SOAP Message: ");
		soapResponse.writeTo(System.out);
		System.out.println();

		/*
		<?xml version="1.0" encoding="UTF-8"?>
		<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
		  <soap:Body>
		    <SALDOPRODRESPONSE xmlns="http://webservices.totvs.com.br/OWS001.apw">
		      <SALDOPRODRESULT>
		        <DTIN>20/03/17 01:53:21</DTIN>
		        <DTOUT>20/03/17 01:53:21</DTOUT>
		        <NITENS>1.00000000</NITENS>
		        <PROD_ITENS>
		          <PRODS01>
		            <LOCAL>01</LOCAL>
		            <PRODUTO>01008</PRODUTO>
		            <SALDO>560.00000000</SALDO>
		          </PRODS01>
		        </PROD_ITENS>
		      </SALDOPRODRESULT>
		    </SALDOPRODRESPONSE>
		  </soap:Body>
		</soap:Envelope>
		 */

		NodeList bodyList = soapResponse.getSOAPBody().getChildNodes();

		System.out.println(bodyList.item(0).getNodeName() + ": " + bodyList.item(0).getNodeValue());
		NodeList saldoProdResponseList = bodyList.item(0).getChildNodes();

		System.out.println(saldoProdResponseList.item(0).getNodeName() + ": " + saldoProdResponseList.item(0).getNodeValue());
		NodeList saldoProdResultList = saldoProdResponseList.item(0).getChildNodes();

		for (int k = 0; k < saldoProdResultList.getLength(); k++) {

			if (saldoProdResultList.item(k).getNodeName().equalsIgnoreCase("PROD_ITENS")) {
				System.out.println(saldoProdResultList.item(k).getNodeName() + ": " + saldoProdResultList.item(0).getNodeValue());
				NodeList prodItensList = saldoProdResultList.item(k).getChildNodes();

				System.out.println(prodItensList.item(0).getNodeName() + ": " + prodItensList.item(0).getNodeValue());
				NodeList prodS01List = prodItensList.item(0).getChildNodes();

				for (int l = 0; l < prodS01List.getLength(); l++) {

					if (prodS01List.item(l).getNodeName().equalsIgnoreCase("SALDO")) {
						System.out.println(prodS01List.item(l).getNodeName() + ": " + prodS01List.item(l).getTextContent());
					}

				}

			}

		}

		soapConnection.close();
	}

}
