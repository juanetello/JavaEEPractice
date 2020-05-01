package ConectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryPresetBD {

	public static void main(String[] args) {

		try {

			String url = "jdbc:mysql://localhost:3306/pizza";
			String username = "pizza";
			String password = "pizza";

			Connection conection = DriverManager.getConnection(url, username, password);

			String sql = "SELECT codigo , descripcion , nombre , stock FROM ingrediente WHERE codigo = ?";

			PreparedStatement preparedStatement = conection.prepareStatement(sql);

			preparedStatement.setString(1, "7");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				System.out.println(resultSet.getString(1) + ", " + resultSet.getString(2) + ", "
						+ resultSet.getString(3) + ", " + resultSet.getString(4) + ".");
			}

			resultSet.close();

			System.out.println("**************** otra consulta.... *******************");
			preparedStatement.setString(1, "5");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				System.out.println(resultSet.getString(1) + ", " + resultSet.getString(2) + ", "
						+ resultSet.getString(3) + ", " + resultSet.getString(4) + ".");
			}

			resultSet.close();

		} catch (Exception e) {
			System.out.println("Have some problem with conection like... ");
			e.printStackTrace();
		}

	}

}
