package com.teste;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionExample {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();

		// System.out.println("Testing 1 - Send Http GET request");
		// http.sendGet();

		System.out.println("\nTestando 1 - Enviando Requisi��o Http POST");
		http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String urlStr = "http://www.google.com/search?q=mkyong";

		URL url = new URL(urlStr);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + urlStr);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

	// HTTP POST request
	private void sendPost() throws Exception {

		try {

			String urlStr = "http://10.1.0.250:8081/ssm-services/gps/gpsCoord";
			URL url = new URL(urlStr);
			HttpURLConnection con =  (HttpURLConnection) url.openConnection();

			// add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("User-Agent", "SSManager App");
//			con.setRequestProperty("Accept-Encoding", "gzip");
//			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "empresa=alka&id=1&latitude=-1&longitude=-1&data=30/01/2015 13:00:00.000&precisao=25&origem=G&class=br.com.softsite.ssmobile.webservices.entity.Coordenada";

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nEnviado Requisi��o 'POST' para a URL : " + urlStr);
			System.out.println("Par�metros : " + urlParameters);
			System.out.println("C�digo de Resposta : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}