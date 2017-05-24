package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.api_communication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.exceptions.Count0Exception;
import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.util.Util;

public class MenjacnicaAPICommunication {

	private static String o = "";
	private static JsonArray jsonLista;

	public static final String url = "http://free.currencyconverterapi.com/api/v3/countries";
	private static final String urlZamena = "http://free.currencyconverterapi.com/api/v3/convert?q=";
	public static final String putanjaDoTxt = "data/log.json";

	public static JsonObject vratiZemlje() {

		JsonObject job = null;

		try {

			String result = sendGet(url);

			Gson gson = new GsonBuilder().create();

			job = gson.fromJson(result, JsonObject.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return job;
	}

	public static double zamena(String iz, String u) throws Count0Exception {
		String urlZ = urlZamena + iz + "_" + u;
		double iznos = 0;

		try {
			String result = sendGet(urlZ);
			Gson gson = new GsonBuilder().create();
			JsonObject job = gson.fromJson(result, JsonObject.class);

			JsonObject query = (JsonObject) job.get("query");
			int count = query.get("count").getAsInt();
			if (count == 0) {
				throw new Count0Exception();
			}

			JsonObject results = (JsonObject) job.get("results");

			JsonObject name = (JsonObject) results.get(iz + "_" + u);
			iznos = name.get("val").getAsDouble();

			dodajUListuZaKonverziju(iz, u, iznos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return iznos;
	}

	private static void dodajUListuZaKonverziju(String iz, String u, double iznos) {
		if (jsonLista == null) {
			jsonLista = new JsonArray();
		}
		SimpleDateFormat datumFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		String datum = datumFormat.format(new Date());

		JsonObject transakcija = new JsonObject();
		transakcija.addProperty("datumVreme", datum);
		transakcija.addProperty("izValuta", iz);
		transakcija.addProperty("uValuta", u);
		if (iznos == 0) {
			transakcija.addProperty("kurs", "null");

		} else {
			transakcija.addProperty("kurs", iznos);
		}
		jsonLista.add(transakcija);
	}

	public static void upisiSveTransakcijeUFile() {
		if (jsonLista == null) {
			return;
		}
		try {
			JsonArray dosadasnji = Util.izvuciIzFajla(putanjaDoTxt);

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			PrintWriter out = new PrintWriter(new FileWriter(putanjaDoTxt));

			if (dosadasnji != null) {
				dosadasnji.addAll(jsonLista);
				out.write(gson.toJson(dosadasnji));

			} else {
				out.write(gson.toJson(jsonLista));
			}
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String sendGet(String adresa) throws IOException {

		if (adresa.equalsIgnoreCase(url) && !o.isEmpty()) {
			return o;
		}

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
		if (adresa.equalsIgnoreCase(url)) {
			o = output;
		}
		return output;
	}
}
