package views;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import controllers.BaseController;
import controllers.EmployeeController;
import serverConnection.Connection;


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
	public Connection connection;
	
	/**
	 * Create a frame object passing a reference the UserController for use by the AppFrame object.
	 */
	
	public AppFrame(BaseController LogInController)
	{

		connection = new Connection("localhost", 1234);
		
		basePanel = new LogInPanel(LogInController, connection);
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
		this.addWindowListener(new WindowListener() {
			
			
			
			@Override
			public void windowClosing(WindowEvent e) {
				connection.closeConnection();
				System.exit(0);
			}

			@Override
			public void windowActivated(WindowEvent e) {
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
