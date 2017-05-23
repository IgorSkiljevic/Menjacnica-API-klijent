package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.domen;

import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.api_communication.MenjacnicaAPICommunication;

public class Zemlje {
	Map<String, Zemlja> results;
	private static ArrayList<Zemlja> countries;

	public Map<String, Zemlja> getResults() {
		return results;
	}

	public void setResults(Map<String, Zemlja> results) {
		this.results = results;
	}

	public static ArrayList<Zemlja> proslediNizZemalja() {
		if (countries == null) {
			Gson gson = new GsonBuilder().create();

			Zemlje z = gson.fromJson(MenjacnicaAPICommunication.vratiZemlje(), Zemlje.class);

			countries = new ArrayList<Zemlja>(z.getResults().values());
		}
		return countries;
	}

}
