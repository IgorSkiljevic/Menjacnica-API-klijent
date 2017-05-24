package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.domen.Zemlja;

public class Util {

	public static <T> T[] konvertujIzListeUNiz(List<T> lista) {
		Object[] niz = new Object[lista.size()];
		for (int i = 0; i < niz.length; i++) {
			niz[i] = (T) lista.get(i);
		}
		return (T[]) niz;
	}

	public static String[] izvuciImenaZemalja(ArrayList<Zemlja> listaZemalja) {
		String[] imena = new String[listaZemalja.size()];

		for (int i = 0; i < imena.length; i++) {
			imena[i] = listaZemalja.get(i).getName();
		}

		return imena;
	}

	public static String vratiSkracenicuValute(ArrayList<Zemlja> zemlje, String iz) {
		for (Zemlja zemlja : zemlje) {
			if (zemlja.getName().equalsIgnoreCase(iz)) {
				return zemlja.getCurrencyId();
			}
		}
		return null;
	}

	public static JsonArray izvuciIzFajla(String putanjadotxt) {
		JsonArray ja = null;
		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			FileReader in = new FileReader(putanjadotxt);

			ja = gson.fromJson(in, JsonArray.class);

			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ja;
	}

}
