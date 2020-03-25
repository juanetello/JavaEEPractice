package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.ShowMenuesController;

@SuppressWarnings("serial")
public class AplicationFrame extends JFrame {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AplicationFrame() {
		
		setTitle("Consulta BBDD");

		setBounds(1000, 500, 1000, 500);

		setLayout(new BorderLayout());

		JPanel menus = new JPanel();

		menus.setLayout(new FlowLayout());

		secciones = new JComboBox();

		secciones.setEditable(false);

		secciones.addItem("Todos");

		countries = new JComboBox();

		countries.setEditable(false);

		countries.addItem("Todos");

		resultado = new JTextArea(4, 50);

		resultado.setEditable(false);

		add(resultado);

		menus.add(secciones);

		menus.add(countries);

		add(menus, BorderLayout.NORTH);

		add(resultado, BorderLayout.CENTER);

		JButton botonConsulta = new JButton("Consulta");

		botonConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				doQuery();

			}
		});

		add(botonConsulta, BorderLayout.SOUTH);
		
		addWindowListener(new ShowMenuesController(this));

		try {

			String url = "jdbc:mysql://localhost:3306/pizza";
			String username = "pizza";
			String password = "pizza";

			conection = DriverManager.getConnection(url, username, password);

			Statement frameStatement = conection.createStatement();

			/* Para secciones */
			String sql = "SELECT DISTINCTROW SECCION FROM PRODUCTOS";

			ResultSet resultSet = frameStatement.executeQuery(sql);

			/* Mientras la consulta tenga algo va a mostrar */
			while (resultSet.next()) {
				secciones.addItem(resultSet.getString(1));
			}

			resultSet.close();

			/* Para paises */
			sql = "SELECT DISTINCTROW PAISORIGEN FROM PRODUCTOS";

			resultSet = frameStatement.executeQuery(sql);

			/* Mientras la consulta tenga algo va a mostrar */
			while (resultSet.next()) {
				countries.addItem(resultSet.getString(1));
			}

			resultSet.close();

		} catch (Exception e) {
			System.out.println("Have some problem with conection like... ");
			e.printStackTrace();
		}

	}

	private void doQuery() {

		ResultSet resultSet = null;

		try {
			
			resultado.setText("");

			String section = (String) secciones.getSelectedItem();

			String country = (String) countries.getSelectedItem();

			String todos = "Todos";

			if (!section.equals(todos) && country.equals(todos)) {

				sendSectionQuery = conection.prepareStatement(sqlSectionsToList);

				sendSectionQuery.setString(1, section);

				resultSet = sendSectionQuery.executeQuery();

			} else if (section.equals(todos) && !country.equals(todos)) {

				sendCountryQuery = conection.prepareStatement(sqlCountriesToList);

				sendCountryQuery.setString(1, country);

				resultSet = sendCountryQuery.executeQuery();

			} else if (!section.equals(todos) && !country.equals(todos)) {

				sendAllQuery = conection.prepareStatement(sqlAll);

				sendAllQuery.setString(1, section);

				sendAllQuery.setString(2, country);

				resultSet = sendAllQuery.executeQuery();

			}

			while (resultSet.next()) {
				resultado.append("Codigo: ");
				resultado.append(resultSet.getString(1));

				resultado.append(", Seccion: ");
				resultado.append(resultSet.getString(2));

				resultado.append(", Articulo: ");
				resultado.append(resultSet.getString(3));

				resultado.append(", Precio: $");
				resultado.append(resultSet.getString(4));

				resultado.append(", Origen: ");
				resultado.append(resultSet.getString(5));

				resultado.append("\n");

			}

		} catch (Exception e) {
			System.out.println("Have some problem with conection like... ");
			e.printStackTrace();
		}

	}

	private Connection conection;

	private PreparedStatement sendSectionQuery;

	private PreparedStatement sendCountryQuery;

	private PreparedStatement sendAllQuery;

	private final String sqlSectionsToList = "SELECT CODIGOARTICULO, SECCION, NOMBREARTICULO, PRECIO, PAISORIGEN FROM PRODUCTOS WHERE SECCION = ?";

	private final String sqlCountriesToList = "SELECT CODIGOARTICULO, SECCION, NOMBREARTICULO, PRECIO, PAISORIGEN FROM PRODUCTOS WHERE PAISORIGEN = ?";

	private final String sqlAll = "SELECT CODIGOARTICULO, SECCION, NOMBREARTICULO, PRECIO, PAISORIGEN FROM PRODUCTOS WHERE SECCION = ? AND PAISORIGEN = ?";

	@SuppressWarnings("rawtypes")
	public JComboBox secciones;

	@SuppressWarnings("rawtypes")
	public JComboBox countries;

	private JTextArea resultado;

}
