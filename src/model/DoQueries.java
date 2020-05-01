package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoQueries {
	
	

	private ConnectionDataBase myConnection;
	private ResultSet resultSet;// 
	private PreparedStatement sendQuerySection;// consulta preparada
	private final String querySection = "SELECT CODIGOARTICULO, SECCION, NOMBREARTICULO, PRECIO, PAISORIGEN FROM PRODUCTOS WHERE SECCION = ?";
	
	public DoQueries() {
		myConnection = new ConnectionDataBase();
	}
	
	public String filterDB(String section, String country) {
		
//		String pruebas = "";
		Connection connect = myConnection.giveMeConection(); 
		resultSet = null;
		 
		try {
			if (!section.equals("Todos") && country.equals("Todos")) {
				sendQuerySection = connect.prepareStatement(querySection);
				
				sendQuerySection.setString(1, section);// significa que en el ? de la consulta 'querySection' le va a meter el valor de 'section'
				
				resultSet = sendQuerySection.executeQuery();
//			pruebas = "Seccion si pais no";
			} else if (section.equals("Todos") && !country.equals("Todos")) {
//			pruebas = "Seccion no, pais si";
			} else {
//			pruebas = "Seccion si, pais si";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return country;
		
		
//		return resultSet;
		
	}

}
