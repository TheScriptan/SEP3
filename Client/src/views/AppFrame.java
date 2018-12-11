package views;

import javax.swing.JFrame;

import controllers.UserController;


/**
 * AppFrame object that extends JFrame for use with a MVC GUI.
 * @author Aleksandr Zorin
 *
 */
public class AppFrame extends JFrame {
	
	/**
	 * Reference to the AppPanel class.
	 */
	
	private AppPanel basePanel;
	
	/**
	 * Create a frame object passing a reference the UserController for use by the AppFrame object.
	 */
	
	public AppFrame(UserController userController)
	{
		basePanel = new AppPanel(userController);
		setupFrame();
	}
	
	/**
	 * Sets up the content pane, size and visibility.
	 */
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(1000,500);
		this.setVisible(true);
		
	}

}
