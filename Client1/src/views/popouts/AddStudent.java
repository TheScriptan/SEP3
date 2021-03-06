package views.popouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.EmployeeStudentsController;
import models.Student;
import serverConnection.Connection;
import serverConnection.StudentHandler;
import utils.Utils;

public class AddStudent extends JFrame {

	private EmployeeStudentsController empCon;
	private JTextField txtStudentCPR;
	private JTextField txtStudentPassword;
	private JTextField txtStudentName;
	private JTextField txtStudentAddress;
	private JTextField txtStudentPhone;
	private JTextField txtStudentEmail;
	private JTextField txtStudentBankAccount;
	public Connection connection;
	
	public AddStudent(EmployeeStudentsController empCon, Connection c)
	{
		this.connection = c;
		this.empCon = empCon;
		getContentPane().setLayout(null);
		GenerateView();
		
	}
	
	public void GenerateView()
	{
		JPanel AddStudentPanel = new JPanel();
		AddStudentPanel.setBounds(0, 0, 434, 341);
		getContentPane().add(AddStudentPanel);
		AddStudentPanel.setLayout(null);
		
		JLabel lblStudentCpr = new JLabel("Student CPR:");
		lblStudentCpr.setBounds(36, 49, 123, 14);
		AddStudentPanel.add(lblStudentCpr);
		
		JLabel lblStudentPassword = new JLabel("Student Password:");
		lblStudentPassword.setBounds(36, 74, 123, 14);
		AddStudentPanel.add(lblStudentPassword);
		
		JLabel lblStudentName = new JLabel("Name:");
		lblStudentName.setBounds(36, 99, 123, 14);
		AddStudentPanel.add(lblStudentName);
		
		JLabel lblStudentAddress = new JLabel("Address:");
		lblStudentAddress.setBounds(36, 124, 123, 14);
		AddStudentPanel.add(lblStudentAddress);
		
		JLabel lblStudentPhone = new JLabel("Phone:");
		lblStudentPhone.setBounds(36, 149, 123, 14);
		AddStudentPanel.add(lblStudentPhone);
		
		JLabel lblStudentEmail = new JLabel("E-mail:");
		lblStudentEmail.setBounds(36, 174, 123, 14);
		AddStudentPanel.add(lblStudentEmail);
		
		JLabel lblStudentBankAcc = new JLabel("Bank Account:");
		lblStudentBankAcc.setBounds(36, 199, 123, 14);
		AddStudentPanel.add(lblStudentBankAcc);
		
		txtStudentCPR = new JTextField();
		txtStudentCPR.setToolTipText("Please enter the students CPR number.");
		txtStudentCPR.setBounds(169, 46, 152, 20);
		AddStudentPanel.add(txtStudentCPR);
		txtStudentCPR.setColumns(10);
		
		txtStudentPassword = new JTextField();
		txtStudentPassword.setToolTipText("Please enter the students log in password.");
		txtStudentPassword.setColumns(10);
		txtStudentPassword.setBounds(169, 71, 152, 20);
		AddStudentPanel.add(txtStudentPassword);
		
		txtStudentName = new JTextField();
		txtStudentName.setToolTipText("Please enter the students name.");
		txtStudentName.setColumns(10);
		txtStudentName.setBounds(169, 96, 152, 20);
		AddStudentPanel.add(txtStudentName);
		
		txtStudentAddress = new JTextField();
		txtStudentAddress.setToolTipText("Please enter the studens address.");
		txtStudentAddress.setColumns(10);
		txtStudentAddress.setBounds(169, 121, 152, 20);
		AddStudentPanel.add(txtStudentAddress);
		
		txtStudentPhone = new JTextField();
		txtStudentPhone.setToolTipText("Please enter the studens phone number.");
		txtStudentPhone.setColumns(10);
		txtStudentPhone.setBounds(169, 146, 152, 20);
		AddStudentPanel.add(txtStudentPhone);
		
		txtStudentEmail = new JTextField();
		txtStudentEmail.setToolTipText("Please enter the studens E-mail address.");
		txtStudentEmail.setColumns(10);
		txtStudentEmail.setBounds(169, 171, 152, 20);
		AddStudentPanel.add(txtStudentEmail);
		
		txtStudentBankAccount = new JTextField();
		txtStudentBankAccount.setToolTipText("Please enter the studens bank account number.");
		txtStudentBankAccount.setColumns(10);
		txtStudentBankAccount.setBounds(169, 196, 152, 20);
		AddStudentPanel.add(txtStudentBankAccount);
		
		JButton btnStudentConfirm = new JButton("Confirm");
		btnStudentConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				Student student = new Student(txtStudentCPR.getText(),
												txtStudentPassword.getText(),
												txtStudentName.getText(),
												txtStudentAddress.getText(),
												txtStudentPhone.getText(),
												txtStudentEmail.getText(),
												txtStudentBankAccount.getText(),
												0.0);

				StudentHandler sh = new StudentHandler();
				System.out.println("response =" + sh.addStudent(connection, student).getResponseCode());
				dispose();
			}
		});
		btnStudentConfirm.setToolTipText("Adds the student to the database.");
		btnStudentConfirm.setBounds(166, 248, 89, 23);
		AddStudentPanel.add(btnStudentConfirm);
		
		
		setBounds(150, 50, 450, 380);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
