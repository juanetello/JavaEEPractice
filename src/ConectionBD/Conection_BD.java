package ConectionBD;

import java.sql.*;

public class Conection_BD {
	
	public static void main (String[] arg) {
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/pizza";
			String username = "pizza";
			String password = "pizza";
			
			
			Connection conection = DriverManager.getConnection(url, username, password);
			
			Statement statement = conection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ingrediente");

			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + ", " + 
								   resultSet.getString("codigo") + ", " + 
								   resultSet.getString("descripcion") + ", " + 
								   resultSet.getString("eliminacion") + ", " + 
								   resultSet.getString("nombre") + ", " + 
								   resultSet.getString("stock") + ".");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Have some problem with conection like... ");
			
			e.printStackTrace();
		}

	}

}
