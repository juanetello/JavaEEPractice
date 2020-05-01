package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

public class RunButtonController implements ActionListener {
	
	private AplicationFrame aplicationFrame;
	DoQueries doQueries = new DoQueries();

	public RunButtonController(AplicationFrame aplicationFrame) {
		this.aplicationFrame = aplicationFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sectionSelected = (String) aplicationFrame.secciones.getSelectedItem();
		String countrySelected = (String) aplicationFrame.countries.getSelectedItem();
		
		aplicationFrame.resultado.append(doQueries.filterDB(sectionSelected, countrySelected));
		
		aplicationFrame.resultado.append("\n");
		
		
	}

}
