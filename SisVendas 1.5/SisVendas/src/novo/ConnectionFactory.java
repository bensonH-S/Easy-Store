package novo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
	public Connection getConnection(){
		try {
			String host = "jdbc:mysql://localhost:3306/sistemavendas";
			String user = "root";
			String password = "";
			return DriverManager.getConnection(host, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}