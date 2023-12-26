package ApartmanTemizlik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlSakinleriBaglama {
	
	static Connection myConn;
	static Statement myState;
	static ResultSet myResultSet;
	
	static ResultSet kullanici_yap() {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apartmansakinleri","root","1379");
			myState = myConn.createStatement();
			myResultSet = myState.executeQuery("SELECT * FROM apartman_sakini ");
			return myResultSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myResultSet; 
	}
	
	static ResultSet gorevli_yap() {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apartmansakinleri","root","1379");
			myState = myConn.createStatement();
			myResultSet = myState.executeQuery("SELECT * FROM temizlik_gorevli");
			return myResultSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myResultSet;
	}
	
	static ResultSet oy_yap() {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apartmansakinleri","root","1379");
			myState = myConn.createStatement();
			myResultSet = myState.executeQuery("SELECT * FROM oylama_tablosu");
			return myResultSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myResultSet;
	}
	
	static void ekle(String sql_sorgu) throws SQLException {
		myState.executeUpdate(sql_sorgu);
	}
	
	static void update(String sql_sorgu) throws SQLException {
		myState.executeUpdate(sql_sorgu);
	}
	
	static void sil(String sql_sorgu) throws SQLException {
		myState.executeUpdate(sql_sorgu);
	}
	
	
	static ResultSet bul(String sql) throws SQLException {
		ResultSet myResultSet = null;
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/apartmansakinleri","root","1379");
		myState = myConn.createStatement();
		myResultSet = myState.executeQuery(sql);
		return myResultSet;

	}
	
}