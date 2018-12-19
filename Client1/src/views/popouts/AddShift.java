package views.popouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controllers.EmployeeShiftsController;
import models.Shift;
import serverConnection.Connection;

public class AddShift extends JFrame {
	
	private static final long serialVersionUID = 925654402483065029L;
	
	private EmployeeShiftsController empCon;
	private JTextField txtCompanyID;
	private JTextField txtShiftTime;
	private JTextField txtLocation;
	public Connection connection;
	
	public AddShift(EmployeeShiftsController empCon, Connection c)
	{
		this.empCon = empCon;
		this.connection = c;
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
	lblCompanyID.setBounds(49, 25, 99, 26);
	AddShiftPanel.add(lblCompanyID);

	JLabel lblShiftDate = new JLabel("Shift Date:");
	lblShiftDate.setBounds(49, 94, 99, 26);
	AddShiftPanel.add(lblShiftDate);
	
	JLabel lblShiftDateFormat = new JLabel("(Y-M-D-H-M)");
	lblShiftDateFormat.setBounds(49, 116, 99, 26);
	AddShiftPanel.add(lblShiftDateFormat);
	
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

	String[] year = {"2018", "2019", "2020" };
	String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12", };
	String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
	String[] hours = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23" };
	String[] minutes = {"00", "30" };

	JComboBox<String> yearBox = new JComboBox<String>(year);
	JComboBox<String> monthBox = new JComboBox<String>(month);
	JComboBox<String> dayBox = new JComboBox<String>(day);
	JComboBox<String> hoursBox = new JComboBox<String>(hours);
	JComboBox<String> minutesBox = new JComboBox<String>(minutes);
	yearBox.setBounds(144, 100, 60, 20);
	monthBox.setBounds(214, 100, 40, 20);
	dayBox.setBounds(264, 100, 40, 20);
	hoursBox.setBounds(314, 100, 40, 20);
	minutesBox.setBounds(364, 100, 40, 20);

	AddShiftPanel.add(yearBox);
	AddShiftPanel.add(monthBox);
	AddShiftPanel.add(dayBox);
	AddShiftPanel.add(hoursBox);
	AddShiftPanel.add(minutesBox);
	
	txtShiftTime = new JTextField();
	txtShiftTime.setToolTipText("Please write the time that is required to be at the location.\r\n");
	txtShiftTime.setColumns(10);
	txtShiftTime.setBounds(144, 134, 196, 20);
	AddShiftPanel.add(txtShiftTime);
	
	JLabel lblReleaseShift = new JLabel("Release Shift:");
	lblReleaseShift.setBounds(49, 306, 99, 14);
	AddShiftPanel.add(lblReleaseShift);
	
	JCheckBox checkBox = new JCheckBox("");
	checkBox.setBounds(144, 302, 97, 23);
	AddShiftPanel.add(checkBox);
	
	
	JButton btnShiftConfirm = new JButton("Confirm");
	btnShiftConfirm.setToolTipText("Adds the shift to the database.");
	btnShiftConfirm.addActionListener(new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			@SuppressWarnings("deprecation")
			Shift shift = new Shift(0L,
									Long.parseLong(txtCompanyID.getText()),
									new Date(Integer.parseInt((String)yearBox.getSelectedItem())-1900,
												Integer.parseInt((String)monthBox.getSelectedItem()),
												Integer.parseInt((String)dayBox.getSelectedItem()),
												Integer.parseInt((String)hoursBox.getSelectedItem()),
												Integer.parseInt((String)minutesBox.getSelectedItem()),
												0
											),
									Integer.parseInt(txtShiftTime.getText()),
									txtRequirements.getText(),
									checkBox.isSelected());
			if(empCon.addShift(connection, shift))
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