package rs.ac.bg.fon.dodatna.skiljevic.igor.menjacnica.domen;

public class Zemlja {

	private String alpha3;
	private String currencyName;
	private String id;
	private String name;
	private String currencySymbol;
	private String currencyId;

	public Zemlja(String alpha3, String currencyName, String id, String name, String currencySymbol,
			String currencyId) {
		super();
		this.alpha3 = alpha3;
		this.currencyName = currencyName;
		this.id = id;
		this.name = name;
		this.currencySymbol = currencySymbol;
		this.currencyId = currencyId;
	}

	public Zemlja() {
	}

	public String getAlpha3() {
		return alpha3;
	}

	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
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

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

}
