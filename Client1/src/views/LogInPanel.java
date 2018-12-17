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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import controllers.BaseController;
import controllers.StudentController;
import serverConnection.Connection;
import utils.Utils;

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
	public Connection c;
	/**
	 * Create a panel object passing a reference the UserController for use by the AppPanel object.
	 */
	
	public LogInPanel(BaseController baseController, Connection c)
	{
		this.baseController = baseController;
		this.c = c;
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
		
		
		
		//------------------
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(10, 400, 400, 20);
		add(errorLabel);
		
		/**
		 * Create login button.
		 */
		
		JButton login = new JButton("Login");
		login.setBounds(308, 201, 89, 23);
		add(login);
		
		
		/**
		 * Login button Event listener.
		 */
		
		login.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				 String check = username.getText().split("-")[0];
				 //System.out.println(String.valueOf(password.getPassword()));
				if(check.equals("A"))
				{
					Utils.SendRequest(c.getOutput(), Utils.Requests.LOGIN, username.getText().split("-")[1], String.valueOf(password.getPassword()), "employee");
					if(Utils.AcceptResponse(c.getInput()).getResponseCode().equals(Utils.Responses.LOGIN_VALID.toString())){
						getPanel().setVisible(false);
						baseController.getFrame().setContentPane(new EmployeePanel(null,c));
						}
					else {
						errorLabel.setText("Invalid login -> wrong CPR or Password");
					}
				} else if(check.equals("S")){
					Utils.SendRequest(c.getOutput(), Utils.Requests.LOGIN, username.getText().split("-")[1], String.valueOf(password.getPassword()), "student");
					if(Utils.AcceptResponse(c.getInput()).getResponseCode().equals(Utils.Responses.LOGIN_VALID.toString())) {
						getPanel().setVisible(false);
						baseController.getFrame().setContentPane(new StudentPanel(null,c));
					}
					else {
						errorLabel.setText("Invalid login -> wrong CPR or Password");
					}
				}
				else {
					errorLabel.setText("Invalid login -> Use A-[cpr] to login as admin S-[cpr] as student.");
				}
			}
		});
		
	}
	
	public JPanel getPanel()
	{
		return this;
	}
}
