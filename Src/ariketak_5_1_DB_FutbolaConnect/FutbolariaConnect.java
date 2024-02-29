package ariketak_5_1_DB_FutbolaConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ariketak_5_1_DB_FutbolaModeloa.Futbolaria;

public class FutbolariaConnect {

	private Connection konexioa() {
		String url = "jdbc:mysql://localhost:3306/futbolito";
		String username = "root";
		String password = "";
		Connection kon = null;
		try {
			kon = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("ERROREA: " + e.getMessage());

		}
		return kon;
	}

	public ArrayList<Futbolaria> futbolariGuztiak() throws SQLException {
		ArrayList<Futbolaria> futbolariList = new ArrayList<Futbolaria>();
		Connection kon = konexioa();
		Statement st = kon.createStatement();
		String consulta = "SELECT * FROM futbolistas;";
		ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
		Futbolaria futbolaria;
		while (resultSet.next()) {
			futbolaria = new Futbolaria();
			futbolaria.setDni(resultSet.getString(1));
			futbolaria.setIzena(resultSet.getString(2));
			futbolaria.setAbizena(resultSet.getString(3));
			futbolaria.setSoldata(resultSet.getInt(4));
			futbolaria.setidTaldea(resultSet.getInt(5));
			futbolariList.add(futbolaria);

		}

		return futbolariList;
	}

	public Futbolaria futbolariaIDtik(int dni) throws SQLException {
		Futbolaria futbolaria = new Futbolaria();
		Connection kon = konexioa();
		Statement st = kon.createStatement();
		String consulta = "SELECT * FROM futbolistas WHERE dni = '"+dni+"';";
		ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
		while (resultSet.next()) {
			futbolaria = new Futbolaria();
			futbolaria.setDni(resultSet.getString(1));
			futbolaria.setIzena(resultSet.getString(2));
			futbolaria.setAbizena(resultSet.getString(3));
			futbolaria.setSoldata(resultSet.getInt(4));
			futbolaria.setidTaldea(resultSet.getInt(5));

		}

		return futbolaria;
	}

	public void futbolariaSortu(Futbolaria futbolaria) throws SQLException {
		String dni = futbolaria.getDni();
		String nombre = futbolaria.getIzena();
		String apellido = futbolaria.getAbizena();
		int salario = futbolaria.getSoldata();
		int idEquipo = futbolaria.getidTaldea();
		Connection kon = konexioa();
		Statement st = kon.createStatement(); 
		String consulta = "INSERT INTO futbolistas VALUES ('" + dni + "','" + nombre + "','" + apellido + "'," + salario
				+ "," + idEquipo + ");";
		st.execute(consulta);
		
		
		
		
	}
}
