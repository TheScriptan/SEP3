package controllers;

import javax.swing.JFrame;
import javax.swing.JPanel;

import views.AppFrame;

public class BaseController {
	
	private AppFrame appFrame;
			
	//Launches the graphical user interface.
	public void start()
	{
		appFrame = new AppFrame(this);
		appFrame.setLocationRelativeTo(null);
	}
	
	public JFrame getFrame()
	{
		return appFrame;
	}
	
	public void changePanel(JPanel panel) {
		appFrame.getContentPane().setVisible(false);
		appFrame.setContentPane(panel);
		appFrame.getContentPane().setVisible(true);	
	}
		
	
}
