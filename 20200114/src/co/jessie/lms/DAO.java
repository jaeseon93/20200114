package co.jessie.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	public Connection conn;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "jessie";
	private String password = "jessie";
	
	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
