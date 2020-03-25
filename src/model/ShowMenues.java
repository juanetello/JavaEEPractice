package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowMenues {
	public ConnectionDataBase connection;
	public ResultSet resultSet;
	public ResultSet resultSet2;

	public ShowMenues() {
		connection = new ConnectionDataBase();
	}

	public String runQuery() {
		Productos myProducts = null;

		Connection bdAccess = connection.giveMeConection();

		try {

			Statement sections = bdAccess.createStatement();
			
			Statement countries = bdAccess.createStatement();

			resultSet = sections.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");
			
			resultSet2 = countries.executeQuery("SELECT DISTINCTROW PAISORIGEN FROM PRODUCTOS");

			myProducts = new Productos();

			myProducts.setSeccion(resultSet.getString(1));
			
			myProducts.setOrigen(resultSet2.getString(1));

			resultSet.close();

		} catch (Exception e) {
			System.out.println("Have some problem with conection like... ");
			e.printStackTrace();
		}

		return myProducts.getSeccion();
	}

}
