package controllers;

import javax.swing.JFrame;

import views.AppFrame;

public class AdminController {

   private AppFrame appFrame;

	/**
	 * Creating JFrame object for reference that returns appFrame. This allows us to carry our main JFrame throughout the JPanels.
	 */
   
public JFrame getFrame()
{
   return appFrame;
}
}
