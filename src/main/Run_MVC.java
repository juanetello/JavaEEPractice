package main;

import javax.swing.JFrame;

import view.*;

public class Run_MVC {

	public static void main(String[] args) {
		
		AplicationFrame aplicationFrame = new AplicationFrame();
		
		aplicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aplicationFrame.setVisible(true);
	}

}
