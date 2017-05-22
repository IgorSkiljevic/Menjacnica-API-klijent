package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.domen;

public class Zemlja {

	private String alpha3;
	private String currencyID;
	private String currencyName;
	private String currencySimbol;
	private String id;
	private String name;

	public Zemlja() {
	}

	public Zemlja(String alpha3, String currencyID, String currencyName, String currencySimbol, String id,
			String name) {
		super();
		this.alpha3 = alpha3;
		this.currencyID = currencyID;
		this.currencyName = currencyName;
		this.currencySimbol = currencySimbol;
		this.id = id;
		this.name = name;
	}

	public String getAlpha3() {
		return alpha3;
	}

	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}

	public String getCurrencyID() {
		return currencyID;
	}

	public void setCurrencyID(String currencyID) {
		this.currencyID = currencyID;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencySimbol() {
		return currencySimbol;
	}

	public void setCurrencySimbol(String currencySimbol) {
		this.currencySimbol = currencySimbol;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
