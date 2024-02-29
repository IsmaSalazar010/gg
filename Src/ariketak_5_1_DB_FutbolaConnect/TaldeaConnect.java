package ariketak_5_1_DB_FutbolaConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ariketak_5_1_DB_FutbolaModeloa.*;

public class TaldeaConnect {
	public Connection konexioa() {
		String url = "jdbc:mysql://localhost:3306/futbolito";
		String user = "root";
		String password = "";
		Connection kon = null;

		try {
			kon = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("ERROREA: " + e.getMessage());
		}

		return kon;
	}

	public ArrayList<Taldea> taldeGuztiak() throws SQLException {
		ArrayList<Taldea> taldeList = new ArrayList<Taldea>();
		Connection kon = konexioa();
		Statement st = kon.createStatement();
		String consulta = "SELECT * from equipos;";
		ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
		Taldea taldea;
		while (resultSet.next()) {
			taldea = new Taldea();
			taldea.setIdTaldea(resultSet.getInt(1));
			taldea.setIzena(resultSet.getString(2));
			taldea.setHerria(resultSet.getString(3));
			taldeList.add(taldea);
		}

		return taldeList;
	}

	public Taldea taldeaIdtik(int id) throws SQLException {
		Taldea taldea = new Taldea();
		Connection kon = konexioa();
		Statement st = kon.createStatement();
		String consulta = "SELECT * from equipos where id="+id+";";
		ResultSet resultSet = (ResultSet) st.executeQuery(consulta);
		while (resultSet.next()) {
			taldea = new Taldea();
			taldea.setIdTaldea(resultSet.getInt(1));
			taldea.setIzena(resultSet.getString(2));
			taldea.setHerria(resultSet.getString(3));
		}

		return taldea;
	}

	public void taldeaSortu(Taldea taldea) throws SQLException {
		int idEquipo = taldea.getIdTaldea();
		String izena = taldea.getIzena();
		String herria = taldea.getHerria();
		Connection kon = konexioa();
		Statement st = kon.createStatement();
		String consulta = "";
		st.execute(consulta);

	}
}
