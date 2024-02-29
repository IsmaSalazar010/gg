package ariketak_5_1_DB_FutbolaModeloa;

public class Futbolaria {
	private String dni;
	private String izena;
	private String abizena;
	private int soldata;
	private int idTaldea;
	
	public Futbolaria(String dni, String izena, String abizena, int soldata, int idTaldea) {
		this.dni = dni;
		this.izena = izena;
		this.abizena = abizena;
		this.soldata = soldata;
		this.idTaldea = idTaldea;
	}
	
	public Futbolaria() {
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public int getSoldata() {
		return soldata;
	}

	public void setSoldata(int soldata) {
		this.soldata = soldata;
	}

	public int getidTaldea() {
		return idTaldea;
	}

	public void setidTaldea(int idTaldea) {
		this.idTaldea = idTaldea;
	}

	@Override
	public String toString() {
		return "Futbolaria [dni=" + dni + ", izena=" + izena + ", abizena=" + abizena + ", soldata=" + soldata
				+ ", idTaldea=" + idTaldea + "]";
	}
		
}
