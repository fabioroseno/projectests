package com.teste;

/** 
 * SOAPClient4XG. Read the SOAP envelope file passed as the second
 * parameter, pass it to the SOAP endpoint passed as the first parameter, and
 * print out the SOAP envelope passed as a response.  with help from Michael
 * Brennan 03/09/01
 * 
 * @author  Bob DuCharme
 * @version 1.1
 * @param   SOAPUrl      URL of SOAP Endpoint to send request.
 * @param   xmlFile2Send A file with an XML document of the request.  
 *
 * 5/23/01 revision: SOAPAction added
*/

import java.io.*;
import java.net.*;

public class ClientSoapIBM {
    public static void main(String[] args) throws Exception {

        String SOAPUrl      = "http://187.94.60.130:12201/ws/OWS001.apw";
        String xmlFile2Send = "soap.xml";
		  String SOAPAction = "SALDOPROD";
				
        URL url = new URL(SOAPUrl);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;

        FileInputStream fin = new FileInputStream(xmlFile2Send);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
    
        copy(fin,bout);
        fin.close();

        byte[] b = bout.toByteArray();

        httpConn.setRequestProperty("Content-Length", String.valueOf( b.length ));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		  httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod( "POST" );
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        OutputStream out = httpConn.getOutputStream();
        out.write( b );    
        out.close();

        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);

        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);

        in.close();
    }

  public static void copy(InputStream in, OutputStream out) 
   throws IOException {

    synchronized (in) {
      synchronized (out) {

        byte[] buffer = new byte[256];
        while (true) {
          int bytesRead = in.read(buffer);
          if (bytesRead == -1) break;
          out.write(buffer, 0, bytesRead);
        }
      }
    }
  } 
}