package ConectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ModifyBBDD {

	public static void main(String[] arg) {

		try {

			String url = "jdbc:mysql://localhost:3306/pizza";
			String username = "pizza";
			String password = "pizza";

			Connection conection = DriverManager.getConnection(url, username, password);

			Statement statement = conection.createStatement();
			String deleteSql = "DELETE FROM ingrediente where codigo = '123145'";
			
			statement.executeUpdate(deleteSql);
			
			System.out.println("Delete data OK...");
			
			/*String updateSql = "UPDATE ingrediente SET stock = '888' where codigo = '123145'";
			
			statement.executeUpdate(updateSql);
			
			System.out.println("Update data OK...");*/
			
			/*String insertSql = "INSERT INTO ingrediente (id, codigo, descripcion, nombre, stock) VALUES('45612', '123145', 'fiambrin', 'the best fiambrin', '555')";

			statement.executeUpdate(insertSql);

			System.out.println("Insert data OK..."); */

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Have some problem with conection like... ");

			e.printStackTrace();
		}
	}

}
