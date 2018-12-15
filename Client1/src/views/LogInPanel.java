package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controllers.BaseController;
import controllers.StudentController;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * AppPanel object that extends JPanel for use with a MVC GUI.
 * @author Aleksandr Zorin
 *
 */

public class LogInPanel extends JPanel{
	
	/**
	 * Reference to the UserController class.
	 */
	
	private BaseController baseController;
	private JTextField username;
	private JPasswordField password;
	private StudentController userController;
	
	/**
	 * Create a panel object passing a reference the UserController for use by the AppPanel object.
	 */
	
	public LogInPanel(BaseController baseController)
	{
		this.baseController = baseController;
		setLayout(null);
		GenerateView();
		
	}
	
	public void GenerateView()
	{
		/**
		 * Create a Username object.
		 */
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(197, 96, 63, 33);
		add(lblUsername);
		
		/**
		 * Create a Password object.
		 */
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(197, 140, 63, 27);
		add(lblPassword);
		
		/**
		 * Create a text field username for user input.
		 */
		
		username = new JTextField();
		username.setBounds(292, 104, 118, 20);
		add(username);
		username.setColumns(10);
		
		/**
		 * Create a password field for user input.
		 */
		
		password = new JPasswordField();
		password.setBounds(292, 145, 118, 20);
		add(password);
		
		/**
		 *  Create company name in the login screen.
		 */
		
		JEditorPane dtrpnViaVikar = new JEditorPane();
		dtrpnViaVikar.setEditable(false);
		dtrpnViaVikar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dtrpnViaVikar.setText("VIA VIKAR");
		dtrpnViaVikar.setBackground(UIManager.getColor("Button.background"));
		dtrpnViaVikar.setBounds(260, 44, 289, 49);
		add(dtrpnViaVikar);
		
		/**
		 * Create login button.
		 */
		
		JButton login = new JButton("Login");
		login.setBounds(308, 201, 89, 23);
		add(login);
		
		JCheckBox chckbxAdmin = new JCheckBox("Admin ");
		chckbxAdmin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				
			}
		});
		chckbxAdmin.setBounds(292, 242, 97, 23);
		add(chckbxAdmin);
		
		/**
		 * Login button Event listener.
		 */
		
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
					getPanel().setVisible(false);
					baseController.getFrame().setContentPane(new EmployeePanel(null));
					
			}
		});
		
	}
	
	public JPanel getPanel()
	{
		return this;
	}
}
