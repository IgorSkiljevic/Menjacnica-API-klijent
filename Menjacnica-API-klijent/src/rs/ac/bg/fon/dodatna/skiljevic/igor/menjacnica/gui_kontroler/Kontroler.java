package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.gui_kontroler;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.domen.Zemlje;
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
}
