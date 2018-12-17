package views.popouts;

import javax.swing.JFrame;

import controllers.EmployeeController;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddStudent extends JFrame {

	private EmployeeController empCon;
	private JTextField txtStudentCPR;
	private JTextField txtStudentPassword;
	private JTextField txtStudentName;
	private JTextField txtStudentAddress;
	private JTextField txtStudentPhone;
	private JTextField txtStudentEmail;
	private JTextField txtStudentBankAccount;
	
	public AddStudent(EmployeeController empCon)
	{
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
		btnStudentConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
			}
		});
		btnStudentConfirm.setToolTipText("Adds the student to the database.");
		btnStudentConfirm.setBounds(85, 249, 89, 23);
		AddStudentPanel.add(btnStudentConfirm);
		
		JButton btnStudentCancel = new JButton("Cancel");
		btnStudentCancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				
			}
		});
		btnStudentCancel.setToolTipText("");
		btnStudentCancel.setBounds(232, 249, 89, 23);
		AddStudentPanel.add(btnStudentCancel);
		
		
		setBounds(150, 50, 450, 380);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
