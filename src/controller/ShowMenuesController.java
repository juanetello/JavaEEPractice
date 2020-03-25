package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import model.ShowMenues;
import view.AplicationFrame;

public class ShowMenuesController extends WindowAdapter {

	ShowMenues showMenues = new ShowMenues();

	private AplicationFrame aplicationFrame;

	public ShowMenuesController(AplicationFrame aplicationFrame) {
		this.aplicationFrame = aplicationFrame;
	}

	@SuppressWarnings("unchecked")
	public void windowOpened(WindowEvent windowEvent) {
		showMenues.runQuery();

		try {
			while (showMenues.resultSet.next()) {

				aplicationFrame.secciones.addItem(showMenues.resultSet.getString(1));

			}

			while (showMenues.resultSet2.next()) {

				aplicationFrame.countries.addItem(showMenues.resultSet2.getString(1));

			}

		} catch (Exception e) {
			System.out.println("Have some problem with conection like... ");
			e.printStackTrace();
		}

	}

}
