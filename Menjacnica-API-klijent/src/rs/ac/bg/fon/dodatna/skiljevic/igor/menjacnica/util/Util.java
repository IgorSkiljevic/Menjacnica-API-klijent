package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.domen.Zemlja;

public class Util {

	public static <T> T[] konvertujIzListeUNiz(List<T> lista) {
		Object[] niz = new Object[lista.size()];
		for (int i = 0; i < niz.length; i++) {
			niz[i] = (T) lista.get(i);
		}
		return (T[]) niz;
	}

	public static String [] izvuciImenaZemalja(ArrayList<Zemlja> listaZemalja) {
		String [] imena = new String[listaZemalja.size()];
		
		for (int i = 0; i < imena.length; i++) {
			imena[i] = listaZemalja.get(i).getName();
		}
		
		return imena;
	}

}
