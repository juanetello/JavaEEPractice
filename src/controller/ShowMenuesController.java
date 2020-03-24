package controller;

import java.awt.event.*;

import model.ShowMenues;
import view.AplicationFrame;

public class ShowMenuesController extends WindowAdapter {

	ShowMenues uploadSections = new ShowMenues();

	private AplicationFrame aplicationFrame;

	public ShowMenuesController(AplicationFrame aplicationFrame) {
		this.aplicationFrame = aplicationFrame;
	}

	@SuppressWarnings("unchecked")
	public void windowOpened(WindowEvent windowEvent) {
		uploadSections.runQuery();
		
		try {
			while (uploadSections.resultSet.next()) {
				
				aplicationFrame.secciones.addItem(uploadSections.resultSet.getString(1));
				
			}
			
		} catch (Exception e) {
			System.out.println("Have some problem with conection like... ");
			e.printStackTrace();
		}

	}

}
