package com.teste;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class TesteGPSInsertCoord {

	public static void main(String[] args) throws Exception {

		int i = 0;

		while (true) {

			if (i++ == 1000) {
				Thread.sleep(10000);
				i = 0;
			}
			Thread.sleep(100);
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

						JSONObject obj = new JSONObject();
						obj.put("empresa", "alka");
						obj.put("id", "1");
						obj.put("latitude", "-1");
						obj.put("longitude", "-1");
						obj.put("data", "30/01/2015 13:00:00.000");
						obj.put("precisao", "25");
						obj.put("origem", "G");
						obj.put("class", "br.com.softsite.ssmobile.webservices.entity.Coordenada");

						// Send post request
						urlCon.setDoOutput(true);
						DataOutputStream wr = new DataOutputStream(
								urlCon.getOutputStream());
						wr.writeBytes(obj.toString());
						wr.flush();
						wr.close();

						BufferedReader in = new BufferedReader(
								new InputStreamReader(urlCon.getInputStream()));
						StringBuffer response = new StringBuffer();

						while (in.readLine() != null) {
							response.append("\nEnviou...");
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
	}
}
