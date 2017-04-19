package com.teste;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TesteGPSRiomix {

	private final static String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		int i = 0;

		// while (true) {

		if (i++ == 1000) {
			Thread.sleep(10000);
			i = 0;
		}

		Thread thread = new Thread() {

			public void run() {

				URL url;
				try {
					
					url = new URL("http://10.1.0.250:8081/ssm-services/gps/gpsCoord");

					URLConnection urlCon = url.openConnection();

					urlCon.setRequestProperty("Request-Method", "POST");
					urlCon.setRequestProperty("Accept", "application/json");
					urlCon.setRequestProperty("Content-Type", "application/json");
					urlCon.setRequestProperty("User-Agent", "SSManager App");
					urlCon.setRequestProperty("Accept-Encoding", "gzip");

					// urlCon.setRequestProperty("Content-Type",
					// "application/json; charset=utf8");
					// urlCon.setRequestProperty("Request-Method", "POST");
					// urlCon.setRequestProperty("User-Agent", USER_AGENT);
					// urlCon.setRequestProperty("Accept-Language",
					// "en-US,en;q=0.5");

					String urlParameters = "empresa=alka&id=1&latitude=-1&longitude=-1&data=30/01/2015 13:00:00.000&precisao=25&origem=G&class=br.com.softsite.ssmobile.webservices.entity.Coordenada";

					// Send post request
					urlCon.setDoOutput(true);
					DataOutputStream wr = new DataOutputStream(
							urlCon.getOutputStream());
					wr.writeBytes(urlParameters);
					wr.flush();
					wr.close();

//					BufferedReader in = new BufferedReader(
//							new InputStreamReader(urlCon.getInputStream()));
//					System.out.println(in.readLine());

					 BufferedReader in = new BufferedReader(new
					 InputStreamReader(urlCon.getInputStream()));
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

			};
		};

		thread.start();
	}
	// }

}
