package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;


import controllers.BaseController;
import controllers.LogInController;
import serverConnection.Connection;

/**
 * AppPanel object that extends JPanel for use with a MVC GUI.
 * @author Aleksandr Zorin
 *
 */

public class LogInPanel extends JPanel{

	private static final long serialVersionUID = -1558137183789380872L;
	
	// Variables declaration
	// Swing----------------
	private JTextField username;
	private JPasswordField password;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JEditorPane dtrpnViaVikar;
	private JLabel errorLabel;
	private JButton login;
	//-----------------------
	// Others
	private LogInController loginController;
	private BaseController baseController;
	public Connection connection;

	
	public LogInPanel(BaseController baseController, Connection c)
	{
		this.baseController = baseController;
		this.connection = c;
		
		loginController = new LogInController();
		
		setLayout(null);
		GenerateView();	
	}
	
	public void GenerateView()
	{
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(197, 96, 63, 33);
		add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(197, 140, 63, 27);
		add(lblPassword);
	
		username = new JTextField();
		username.setBounds(292, 104, 118, 20);
		add(username);
		username.setColumns(10);
	
		password = new JPasswordField();
		password.setBounds(292, 145, 118, 20);
		add(password);
	
		dtrpnViaVikar = new JEditorPane();
		dtrpnViaVikar.setEditable(false);
		dtrpnViaVikar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dtrpnViaVikar.setText("VIA VIKAR");
		dtrpnViaVikar.setBackground(UIManager.getColor("Button.background"));
		dtrpnViaVikar.setBounds(260, 44, 289, 49);
		add(dtrpnViaVikar);

		errorLabel = new JLabel("STATUS = OK");
		errorLabel.setBounds(10, 400, 400, 20);
		add(errorLabel);

		login = new JButton("Login");
		login.setBounds(308, 201, 89, 23);
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String prefix = username.getText().split("-")[0];
				 
				if(prefix.equals("A"))
				{
					if(loginController.validateLogin(connection,
													username.getText().split("-")[1],
													String.valueOf(password.getPassword()),
													"employee")) 
					{
						baseController.changePanel(new EmployeePanel(baseController, connection));;
					}
					else 
					{
						errorLabel.setText("Invalid login -> wrong CPR or Password");
					}
				} 
				else if(prefix.equals("S"))
				{
					if(loginController.validateLogin(connection, 
													username.getText().split("-")[1],
													String.valueOf(password.getPassword()),
													"student")) 
					{	
						baseController.changePanel(new StudentPanel(baseController,connection));
					}
					else 
					{
						errorLabel.setText("Invalid login -> wrong CPR or Password");
					}
				}
				else 
				{
					errorLabel.setText("Invalid login -> Use A-[cpr] to login as admin S-[cpr] as student.");
				}
			}
		});
		add(login);
	}
	
	public JPanel getPanel()
	{
		return this;
	}
}
