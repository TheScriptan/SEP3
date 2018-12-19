package views;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import controllers.BaseController;
import serverConnection.Connection;


/**
 * AppFrame object that extends JFrame for use with a MVC GUI.
 * @author Aleksandr Zorin
 *
 */
public class AppFrame extends JFrame {
	
	private static final long serialVersionUID = 5725736106705278789L;

	// ! Should be read from args/file ?? !
	private static final int PORT = 1234;
	private static final String IP = "localhost";
	
	// Base panel => login panel, system always starts with login screen
	private LogInPanel basePanel;
	public Connection connection;

	//Create a frame object passing a reference the UserController for use by the AppFrame object.
	public AppFrame(BaseController baseController)
	{
		//Eshablish connection between client and server
		connection = new Connection(IP, PORT);
		
		basePanel = new LogInPanel(baseController, connection);
		setupFrame();
	}
	



	//Sets up the content pane, size and visibility.
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
