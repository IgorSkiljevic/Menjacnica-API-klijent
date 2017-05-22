package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblIzValuteZemlje;
	private JLabel lblUValutuZemlje;
	private JComboBox comboBoxIz;
	private JComboBox comboBoxU;
	private JLabel lblIznos;
	private JLabel lblIznos_1;
	private JTextField txtIznosIz;
	private JTextField txtIznosU;
	private JButton btnKonvertuj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setTitle("Menjacnica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIzValuteZemlje());
		contentPane.add(getLblUValutuZemlje());
		contentPane.add(getComboBoxIz());
		contentPane.add(getComboBoxU());
		contentPane.add(getLblIznos());
		contentPane.add(getLblIznos_1());
		contentPane.add(getTxtIznosIz());
		contentPane.add(getTxtIznosU());
		contentPane.add(getBtnKonvertuj());
		setLocationRelativeTo(null);
	}
	private JLabel getLblIzValuteZemlje() {
		if (lblIzValuteZemlje == null) {
			lblIzValuteZemlje = new JLabel("Iz valute zemlje");
			lblIzValuteZemlje.setBounds(38, 41, 148, 14);
		}
		return lblIzValuteZemlje;
	}
	private JLabel getLblUValutuZemlje() {
		if (lblUValutuZemlje == null) {
			lblUValutuZemlje = new JLabel("U valutu zemlje");
			lblUValutuZemlje.setBounds(239, 41, 141, 14);
		}
		return lblUValutuZemlje;
	}
	public JComboBox getComboBoxIz() {
		if (comboBoxIz == null) {
			comboBoxIz = new JComboBox();
			comboBoxIz.setBounds(38, 66, 112, 20);
		}
		return comboBoxIz;
	}
	public JComboBox getComboBoxU() {
		if (comboBoxU == null) {
			comboBoxU = new JComboBox();
			comboBoxU.setBounds(239, 64, 112, 20);
		}
		return comboBoxU;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos:");
			lblIznos.setBounds(38, 112, 112, 14);
		}
		return lblIznos;
	}
	private JLabel getLblIznos_1() {
		if (lblIznos_1 == null) {
			lblIznos_1 = new JLabel("Iznos:");
			lblIznos_1.setBounds(239, 112, 112, 14);
		}
		return lblIznos_1;
	}
	private JTextField getTxtIznosIz() {
		if (txtIznosIz == null) {
			txtIznosIz = new JTextField();
			txtIznosIz.setBounds(38, 137, 112, 20);
			txtIznosIz.setColumns(10);
		}
		return txtIznosIz;
	}
	private JTextField getTxtIznosU() {
		if (txtIznosU == null) {
			txtIznosU = new JTextField();
			txtIznosU.setEditable(false);
			txtIznosU.setBounds(239, 137, 112, 20);
			txtIznosU.setColumns(10);
		}
		return txtIznosU;
	}
	private JButton getBtnKonvertuj() {
		if (btnKonvertuj == null) {
			btnKonvertuj = new JButton("Konvertuj");
			btnKonvertuj.setBounds(153, 213, 89, 23);
		}
		return btnKonvertuj;
	}
}
