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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class AddShift extends JFrame {
	
	private EmployeeController empCon;
	private JTextField txtCompanyID;
	private JTextField txtShiftTime;
	private JTextField txtLocation;
	public AddShift(EmployeeController empCon)
	{
		this.empCon = empCon;
		getContentPane().setLayout(null);
		GenerateView();
		
	}


public void GenerateView()
	{
	JPanel AddShiftPanel = new JPanel();
	AddShiftPanel.setBounds(0, 0, 434, 441);
	getContentPane().add(AddShiftPanel);
	AddShiftPanel.setLayout(null);
	
	JLabel lblCompanyID = new JLabel("Company ID:");
	lblCompanyID.setBounds(49, 25, 99, 26);
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
	txtCompanyID.setBounds(144, 28, 196, 20);
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
	btnShiftConfirm.setBounds(96, 344, 89, 23);
	AddShiftPanel.add(btnShiftConfirm);
	
	JLabel lblLocation = new JLabel("Location:");
	lblLocation.setBounds(49, 62, 85, 14);
	AddShiftPanel.add(lblLocation);
	
	txtLocation = new JTextField();
	txtLocation.setToolTipText("Please write the companies location.");
	txtLocation.setColumns(10);
	txtLocation.setBounds(144, 62, 196, 20);
	AddShiftPanel.add(txtLocation);
	
	JButton btnShiftCancel = new JButton("Cancel");
	btnShiftCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnShiftCancel.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent arg0) {
			
			dispose();
		}
	});
	btnShiftCancel.setToolTipText("");
	btnShiftCancel.setBounds(251, 344, 89, 23);
	AddShiftPanel.add(btnShiftCancel);
	
	JLabel lblReleaseShift = new JLabel("Release Shift:");
	lblReleaseShift.setBounds(49, 306, 99, 14);
	AddShiftPanel.add(lblReleaseShift);
	
	JCheckBox checkBox = new JCheckBox("");
	checkBox.setBounds(144, 302, 97, 23);
	AddShiftPanel.add(checkBox);
	
		setBounds(150, 50, 448, 480);
		setVisible(true);
		setLocationRelativeTo(null);
	
	
	
	}
}