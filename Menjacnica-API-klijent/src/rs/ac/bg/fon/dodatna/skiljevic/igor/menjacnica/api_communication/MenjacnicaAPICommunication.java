package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.api_communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class MenjacnicaAPICommunication {

	public final static String url = "http://free.currencyconverterapi.com/api/v3/countries";

	public static JsonObject vratiZemlje() {

		JsonObject job = null;

		try {

			String result = sendGet(url);
			System.out.println(result);

			Gson gson = new GsonBuilder().create();

			job = gson.fromJson(result, JsonObject.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return job;
	}

	private static String sendGet(String adresa) throws IOException {
		URL u = new URL(adresa);
		HttpURLConnection conncetion = (HttpURLConnection) u.openConnection();
		conncetion.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(conncetion.getInputStream()));

		String output = "";
		String line = null;

		while ((line = in.readLine()) != null) {
			output += line;
		}

		in.close();
		return output;
	}
}
