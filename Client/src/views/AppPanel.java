package views;

import javax.swing.JPanel;

import controllers.UserController;

/**
 * AppPanel object that extends JPanel for use with a MVC GUI.
 * @author Aleksandr Zorin
 *
 */

public class AppPanel extends JPanel{
	
	/**
	 * Reference to the UserController class.
	 */
	
	private UserController baseController;
	
	/**
	 * Create a panel object passing a reference the UserController for use by the AppPanel object.
	 */
	
	public AppPanel(UserController baseController)
	{
		this.baseController = baseController;
	}

}
