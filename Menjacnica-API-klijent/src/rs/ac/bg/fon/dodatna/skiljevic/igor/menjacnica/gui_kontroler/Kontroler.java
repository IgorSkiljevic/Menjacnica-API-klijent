package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.gui_kontroler;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.api_communication.MenjacnicaAPICommunication;
import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.domen.Zemlja;
import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.domen.Zemlje;
import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.exceptions.Count0Exception;
import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.gui.MenjacnicaGUI;
import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.util.Util;

public class Kontroler {
	private static MenjacnicaGUI menjacnicaGui;

	public static void postaviComboBox(JComboBox c, String[] niz) {

		DefaultComboBoxModel model = new DefaultComboBoxModel<>(niz);

		c.setModel(model);
	}

	public static void main(String[] args) {
		menjacnicaGui = new MenjacnicaGUI();
		menjacnicaGui.setVisible(true);

		Kontroler.postaviComboBox(menjacnicaGui.getComboBoxIz(), Util.izvuciImenaZemalja(Zemlje.proslediNizZemalja()));
		Kontroler.postaviComboBox(menjacnicaGui.getComboBoxU(), Util.izvuciImenaZemalja(Zemlje.proslediNizZemalja()));

	}

	public static void izvrsiKonverziju(String cifra, String iz, String u) {
		int iznos = 0;
		try {
			ArrayList<Zemlja> zemlje = Zemlje.proslediNizZemalja();

			String izKonverzija = Util.vratiSkracenicuValute(zemlje, iz);
			String uKonverzija = Util.vratiSkracenicuValute(zemlje, u);

			iznos = Integer.parseInt(cifra);

			double odnos = MenjacnicaAPICommunication.zamena(izKonverzija, uKonverzija);

			DecimalFormat df = new DecimalFormat("####0.00");

			menjacnicaGui.getTxtIznosU().setText(df.format((odnos * iznos)) + "");

		} catch (Count0Exception e1) {
			JOptionPane.showMessageDialog(menjacnicaGui, "Nemoguce izvrsiti konverziju datih valuta", "Greska",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(menjacnicaGui, "Los unos", "Greska", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void ugasiAplikaciju() {
		MenjacnicaAPICommunication.upisiSveTransakcijeUFile();
		System.exit(0);
	}
}
