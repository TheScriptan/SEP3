package views;

import javax.swing.JFrame;

import controllers.AdminController;
import controllers.BaseController;


/**
 * AppFrame object that extends JFrame for use with a MVC GUI.
 * @author Aleksandr Zorin
 *
 */
public class AppFrame extends JFrame {
	
	/**
	 * Reference to the AppPanel class.
	 */
	
	private LogInPanel basePanel;
	private AdminPanel shiftPanel;
	
	/**
	 * Create a frame object passing a reference the UserController for use by the AppFrame object.
	 */
	
	public AppFrame(BaseController LogInController)
	{
		basePanel = new LogInPanel(LogInController);
		setupFrame();
	}
	
	public AppFrame(AdminController adminController)
   {
      shiftPanel = new AdminPanel(adminController);
            setupFrame();
   }

   /**
	 * Sets up the content pane, size and visibility.
	 */
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setBounds(150, 50, 720, 480);
		this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
