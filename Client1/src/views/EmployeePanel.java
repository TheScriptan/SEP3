package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controllers.EmployeeController;
import serverConnection.Connection;
import views.popouts.AddShift;
import views.popouts.AddStudent;

public class EmployeePanel extends JPanel
{
   private JTable ShiftTable;
   private EmployeeController employeeController;
   private AddShift addShift;
   
   
   JScrollPane ShiftInformationPane = new JScrollPane();
   JScrollPane StudentInformationScrollPanel = new JScrollPane();
   private JTable StudentTable;
   Connection c;
   /**
    * Create the panel.
    */
   public EmployeePanel(EmployeeController employeeController, Connection c)
   {
	  this.employeeController = employeeController;
	  this.c = c;
      setLayout(null);
      GenerateView();
   }
   
   /**
    * Creating the view in the Shift Panel.
    */
   public void GenerateView()
   {
	   
	   /**
	    * Creating tabs for the employee to access.
	    */
      
      JTabbedPane AdminTabs = new JTabbedPane(JTabbedPane.TOP);
      AdminTabs.setBounds(10, 11, 705, 440);
      add(AdminTabs);
      
      /**
       * Creating the shift tab panel.
       */
      
      JPanel ShiftPanel = new JPanel();
      AdminTabs.addTab("Shift", null, ShiftPanel, null);
      AdminTabs.setEnabledAt(0, true);
      ShiftPanel.setLayout(null);
      
      /**
       * Creating button Remove Shift in the shift tab.
       */
      
      
      JButton btnRemoveShift = new JButton("Remove Shift");
      btnRemoveShift.setBounds(547, 86, 126, 23);
      ShiftPanel.add(btnRemoveShift);
      
      /**
       * Creating button Release Shift in the shift tab.
       */
      
      JButton btnReleaseShift = new JButton("Release Shift");
      btnReleaseShift.setBounds(547, 109, 126, 23);
      ShiftPanel.add(btnReleaseShift);
      
      /**
       * Creating button New Shift in the shift tab.
       */
      
      JButton btnNewShift = new JButton("New Shift");
      btnNewShift.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnNewShift.addMouseListener(new MouseAdapter() {
      	
      	public void mouseClicked(MouseEvent e) {
      		
      		new AddShift(employeeController);

      	}
      });
      btnNewShift.setBounds(547, 11, 126, 23);
      ShiftPanel.add(btnNewShift);
      
      /**
       * Creating button Assign Shift in the shift tab.
       */
      
      JButton btnAssignShift = new JButton("Assign Shift");
      btnAssignShift.setBounds(547, 59, 126, 23);
      ShiftPanel.add(btnAssignShift);
      
      /**
       * Creating button Edit Shift in the shift tab.
       */
      
      JButton btnEditShift = new JButton("Edit Shift");
      btnEditShift.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		
      		new AddShift(employeeController);
      		
      	}
      });
      btnEditShift.setBounds(547, 36, 126, 23);
      ShiftPanel.add(btnEditShift);
      
      /**
       * Creating the a scrollable view for the table in shifts tab.
       */
      
      JScrollPane ShiftTableScrollPane = new JScrollPane();
      ShiftTableScrollPane.setBounds(0, 0, 490, 391);
      ShiftPanel.add(ShiftTableScrollPane);
      
      /**
       * Creating a table in Shifts Tab for the employee to view.
       */
      
      
      ShiftTable = new JTable();
      ShiftTable.addMouseListener(new MouseAdapter() {
    	  
    	  /**
    	   * Event handler for Shift Table when clicked on.
    	   */
      	public void mouseClicked(MouseEvent arg0) {
      		ShiftInformationPane.setVisible(true);
      	}
      });
      ShiftTable.getSelectedRow();
      ShiftTable.setModel(new DefaultTableModel(
      	new Object[][] {
      		{null, null, null, null, null, null},
      		{"", null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, ""},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      		{null, null, null, null, null, null},
      	},
      	new String[] {
      		"Comapny ID", "Location", "Shift Date", "Time", "Status", "Released"
      	}
      ) {
    	  
    	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
    	   * Condition for setting the shift table to be editable or not.
    	   */
      	boolean[] columnEditables = new boolean[] {
      		false, false, false, false, false, false
      	};
      	public boolean isCellEditable(int row, int column) {
      		return columnEditables[column];
      	}
      });
      ShiftTable.getColumnModel().getColumn(0).setResizable(false);
      ShiftTable.getColumnModel().getColumn(1).setResizable(false);
      ShiftTable.getColumnModel().getColumn(2).setResizable(false);
      ShiftTable.getColumnModel().getColumn(3).setResizable(false);
      ShiftTable.getColumnModel().getColumn(4).setResizable(false);
      ShiftTable.getColumnModel().getColumn(5).setResizable(false);
      ShiftTable.getColumnModel().getColumn(5).setPreferredWidth(78);
      ShiftTableScrollPane.setViewportView(ShiftTable);
      
      /**
       * Creating a scrollable information tab below the buttons. Will only be visible when the table is clicked.
       */
      
      
      ShiftInformationPane.setVisible(false);
      ShiftInformationPane.setBounds(510, 143, 180, 248);
      ShiftPanel.add(ShiftInformationPane);
      
      /**
       * Creating a panel in the scrollable information tab.
       */
      
      JPanel ShiftInformationPanel = new JPanel();
      ShiftInformationPane.setViewportView(ShiftInformationPanel);
      ShiftInformationPanel.setLayout(null);
      
      /**
       * Creating a text area for the shift information. References the shift table.
       */
      
      JTextArea ShiftInformationShiftTxt = new JTextArea();
      ShiftInformationShiftTxt.setBounds(0, 0, 178, 246);
      ShiftInformationPanel.add(ShiftInformationShiftTxt);
      
      /**
       * Creating a panel for the Students tab for the employee to view.
       */
      JPanel StudentPanel = new JPanel();
      AdminTabs.addTab("Students", null, StudentPanel, null);
      StudentPanel.setLayout(null);
      /**
       * Creating a ScrollPane in the created table.
       */
      JScrollPane StudentTableScrollPane = new JScrollPane();
      StudentTableScrollPane.setBounds(0, 0, 490, 391);
      StudentPanel.add(StudentTableScrollPane);
      /**
       * Creating a table in the students tab for the employee to view.
       */
      StudentTable = new JTable();
      StudentTable.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		StudentInformationScrollPanel.setVisible(true); //////////////////////////////////////////////////////
      	}
      });
      /**
       * Populating StudentTable with null objects.
       */
      StudentTable.setModel(new DefaultTableModel(
      	new Object[][] {
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      		{null, null, null, null, null, null, null},
      	},
      	new String[] {
      		"Student CPR", "Student Password", "Name", "Address", "Phone Nr.", "E-mail", "Bank Account"
      	}
      ));
      StudentTable.getColumnModel().getColumn(0).setPreferredWidth(79);
      StudentTable.getColumnModel().getColumn(1).setPreferredWidth(110);
      StudentTable.getColumnModel().getColumn(2).setPreferredWidth(96);
      StudentTable.getColumnModel().getColumn(2).setMinWidth(0);
      StudentTable.getColumnModel().getColumn(3).setPreferredWidth(132);
      StudentTable.getColumnModel().getColumn(3).setMinWidth(0);
      StudentTable.getColumnModel().getColumn(4).setPreferredWidth(84);
      StudentTableScrollPane.setViewportView(StudentTable);
      /**
       * Create a button Add Student.
       */
      JButton btnAddStudent = new JButton("Add Student");
      btnAddStudent.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		
      	}
      });
      btnAddStudent.addMouseListener(new MouseAdapter() {
      	public void mouseClicked(MouseEvent e) {
      		
      		new AddStudent(employeeController);
      	}
      });
      btnAddStudent.setBounds(550, 11, 126, 23);
      StudentPanel.add(btnAddStudent);
      /**
       * Create a button Edit Student.
       */
      JButton btnEditStudent = new JButton("Edit Student");
      btnEditStudent.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		
      		new AddShift(employeeController);
      	}
      });
      btnEditStudent.setBounds(550, 45, 126, 23);
      StudentPanel.add(btnEditStudent);
      /**
       * Create a button Delete Student.
       */
      JButton btnDeleteStudent = new JButton("Delete Student");
      btnDeleteStudent.setBounds(550, 79, 126, 23);
      StudentPanel.add(btnDeleteStudent);
      /**
       * Create a button Find Student.
       */
      JButton btnFindStudent = new JButton("Find Student");
      btnFindStudent.setBounds(550, 113, 126, 23);
      StudentPanel.add(btnFindStudent);
      
      /**
       * Creating a scroll panel for the student information below the buttons. Panel not visible.
       */
      
      StudentInformationScrollPanel.setBounds(500, 152, 190, 239);
      StudentPanel.add(StudentInformationScrollPanel);
      
      /**
       * Making the panel not visible until an interaction with the table occurs.
       */
      StudentInformationScrollPanel.setVisible(false); ///////////////////////////////////////
      
      /**
       * Creating a panel inside the scroll panel in student information.
       */
      
      JPanel StudentInformationPanel = new JPanel();
      StudentInformationScrollPanel.setViewportView(StudentInformationPanel);
      StudentInformationPanel.setLayout(null);
      
      /**
       * Creating a text area inside the student information panel which will reference the student table content.
       */
      
      JTextArea StudentInformationTxt = new JTextArea();
      StudentInformationTxt.setBounds(0, 0, 188, 237);
      StudentInformationPanel.add(StudentInformationTxt);
      
     
   }
   
   public JPanel getPanel()
	{
		return this;
	}

}

