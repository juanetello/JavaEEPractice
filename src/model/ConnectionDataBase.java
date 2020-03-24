package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDataBase {

	Connection connection = null;

	public ConnectionDataBase() {
		// TODO Auto-generated constructor stub
	}

	public Connection giveMeConection() {
		try {

			String url = "jdbc:mysql://localhost:3306/pizza";
			String username = "pizza";
			String password = "pizza";

			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println("Have some problem with conection like... ");
			e.printStackTrace();
		}

		return connection;
	}

}
