package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDataBase {

	Connection myConnection = null;

	public ConnectionDataBase() {
	}

	public Connection giveMeConection() {
		try {

			String url = "jdbc:mysql://localhost:3306/pizza";
			String username = "pizza";
			String password = "pizza";

			myConnection = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			System.out.println("Have some problem with conection like... ");
			e.printStackTrace();
		}

		return myConnection;
	}

}
