package ariketak_5_1_DB_FutbolaModeloa;

public class Taldea {
	private int idTaldea;
	private String izena;
	private String herria;
	
	public Taldea() {
	}
	
	public Taldea(int idTaldea, String izena, String herria) {
		this.idTaldea = idTaldea;
		this.izena = izena;
		this.herria = herria;
	}

	public int getIdTaldea() {
		return idTaldea;
	}

	public void setIdTaldea(int idTaldea) {
		this.idTaldea = idTaldea;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getHerria() {
		return herria;
	}

	public void setHerria(String herria) {
		this.herria = herria;
	}

	@Override
	public String toString() {
		return "Taldea [idTaldea=" + idTaldea + ", izena=" + izena + ", herria=" + herria + "]";
	}
	
}
