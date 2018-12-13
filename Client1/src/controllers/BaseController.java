package controllers;

import javax.swing.JFrame;

import views.AppFrame;

public class BaseController {
	
		private AppFrame appFrame;
		
		
		
		/**
		 * Launches the graphical user interface.
		 */
		
		
	public void start()
	{
		appFrame = new AppFrame(this);
		appFrame.setLocationRelativeTo(null);
	}
	
	/**
	 * Creating JFrame object for reference that returns appFrame. This allows us to carry our main JFrame throughout the JPanels.
	 */
   
		
	public JFrame getFrame()
	{
		return appFrame;
	}
		
	
}
