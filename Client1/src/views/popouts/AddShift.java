package views.popouts;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controllers.EmployeeController;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddShift extends JFrame {
	
	private EmployeeController empCon;
	private JTextField txtCompanyID;
	private JTextField txtShiftTime;
	public AddShift(EmployeeController empCon)
	{
		this.empCon = empCon;
		getContentPane().setLayout(null);
		GenerateView();
		
	}


public void GenerateView()
	{
	JPanel AddShiftPanel = new JPanel();
	AddShiftPanel.setBounds(0, 0, 434, 355);
	getContentPane().add(AddShiftPanel);
	AddShiftPanel.setLayout(null);
	
	JLabel lblCompanyID = new JLabel("Company ID:");
	lblCompanyID.setBounds(49, 55, 99, 26);
	AddShiftPanel.add(lblCompanyID);
	
	JLabel lblShiftDate = new JLabel("Shift Date:");
	lblShiftDate.setBounds(49, 94, 99, 26);
	AddShiftPanel.add(lblShiftDate);
	
	JLabel lblShiftTime = new JLabel("Shift Time:");
	lblShiftTime.setBounds(49, 131, 99, 26);
	AddShiftPanel.add(lblShiftTime);
	
	JLabel lblRequirements = new JLabel("Requirements:");
	lblRequirements.setBounds(49, 168, 99, 26);
	AddShiftPanel.add(lblRequirements);
	
	txtCompanyID = new JTextField();
	txtCompanyID.setToolTipText("Please write the company ID.");
	txtCompanyID.setBounds(144, 58, 196, 20);
	AddShiftPanel.add(txtCompanyID);
	txtCompanyID.setColumns(10);
	
	JTextArea txtRequirements = new JTextArea();
	txtRequirements.setToolTipText("Please write the requirements needed to apply for the shift.");
	txtRequirements.setBounds(144, 168, 196, 100);
	AddShiftPanel.add(txtRequirements);
	
	JDateChooser ShiftDateChooser = new JDateChooser();
	ShiftDateChooser.setToolTipText("Please pick the date for the shift.");
	ShiftDateChooser.setDateFormatString("yyyy-MM-dd");
	ShiftDateChooser.setBounds(144, 100, 196, 20);
	AddShiftPanel.add(ShiftDateChooser);
	
	txtShiftTime = new JTextField();
	txtShiftTime.setToolTipText("Please write the time that is required to be at the location.\r\n");
	txtShiftTime.setColumns(10);
	txtShiftTime.setBounds(144, 134, 196, 20);
	AddShiftPanel.add(txtShiftTime);
	
	JButton btnShiftConfirm = new JButton("Confirm");
	btnShiftConfirm.setToolTipText("Adds the shift to the database.");
	btnShiftConfirm.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent arg0) {
			
			dispose();
		}
	});
	btnShiftConfirm.setBounds(183, 290, 89, 23);
	AddShiftPanel.add(btnShiftConfirm);
	
		setBounds(150, 50, 450, 380);
		setVisible(true);
		setLocationRelativeTo(null);
	
	
	
	}
}