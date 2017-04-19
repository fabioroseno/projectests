package com.teste;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TesteGPS {

	public static void main(String[] args) throws Exception {

		int i = 0;

		while (true) {

			if (i++ == 1000) {
				Thread.sleep(10000);
				i = 0;
			}

			Thread thread = new Thread() {

				public void run() {

					URL yahoo;
					try {
						yahoo = new URL(
								"http://localhost:8081/ssm-services/gps/getConfiguration/rbdistribuidora&111");

						URLConnection yc = yahoo.openConnection();
						BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
						
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
