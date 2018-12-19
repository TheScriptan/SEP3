package views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controllers.AdminController;
import controllers.EmployeeShiftsController;
import models.Shift;
import serverConnection.Connection;

public class AdminPanel extends JPanel
{
	
	private static final long serialVersionUID = 1235725270692792593L;
	private AdminController adminController;
	EmployeeShiftsController empShiftController;
   private JTable ShiftTable;
   
   
   JScrollPane ShiftInformationPane = new JScrollPane();
   JScrollPane StudentInformationPane = new JScrollPane();
   private JTable StudentTable;
   Connection connection;
   /**
    * Create the panel.
    */
   public AdminPanel(AdminController adminController, Connection c)
   {
      this.adminController = adminController;
      this.connection = c;
      
      empShiftController = new EmployeeShiftsController(); 
      setLayout(null);
      GenerateView();
   }
   
   /**
    * Generating the view in the Shift Panel.
    */
   public void GenerateView()
   {
	   
	   /**
	    * Creating tabs for the admin to access.
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
      btnEditShift.setBounds(547, 36, 126, 23);
      ShiftPanel.add(btnEditShift);
      
      /**
       * Creating the a scrollable view for the table in shifts tab.
       */
      
      JScrollPane ShiftTableScrollPane = new JScrollPane();
      ShiftTableScrollPane.setBounds(0, 0, 490, 391);
      ShiftPanel.add(ShiftTableScrollPane);
      
      /**
       * Generating table in Shifts Tab.
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
      ShiftTable.setModel(new DefaultTableModel(
      	populateShiftTable(),
      	new String[] {
      		"Location", "Company", "Time", "Date", "Status", "Released"
      	}
      ) {
      	/**
		 * 
		 */
		private static final long serialVersionUID = 3835326094011969126L;
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
      
      JTextArea ShiftInformationShiftTxt = new JTextArea();
      ShiftInformationShiftTxt.setBounds(0, 0, 178, 246);
      ShiftInformationPanel.add(ShiftInformationShiftTxt);
      
      /**
       * Creating a panel for the Students tab for the admin to view.
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
      
      StudentTable = new JTable();
      StudentTable.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		StudentInformationPane.setVisible(true); //////////////////////////////////////////////////////
      	}
      });
      /**
       * Populating StudentTable with null objects.
       */
      StudentTable.setModel(new DefaultTableModel(
      	new Object[][] {
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      		{null, null, null, null},
      	},
      	new String[] {
      		"Name", "CPR", "Phone", "Address"
      	}
      ) {
      	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		boolean[] columnEditables = new boolean[] {
      		false, false, false, false
      	};
      	public boolean isCellEditable(int row, int column) {
      		return columnEditables[column];
      	}
      });
      StudentTable.getColumnModel().getColumn(0).setResizable(false);
      StudentTable.getColumnModel().getColumn(0).setPreferredWidth(125);
      StudentTable.getColumnModel().getColumn(1).setResizable(false);
      StudentTable.getColumnModel().getColumn(1).setPreferredWidth(110);
      StudentTable.getColumnModel().getColumn(2).setResizable(false);
      StudentTable.getColumnModel().getColumn(2).setPreferredWidth(100);
      StudentTable.getColumnModel().getColumn(2).setMinWidth(0);
      StudentTable.getColumnModel().getColumn(3).setResizable(false);
      StudentTable.getColumnModel().getColumn(3).setPreferredWidth(125);
      StudentTable.getColumnModel().getColumn(3).setMinWidth(0);
      StudentTableScrollPane.setViewportView(StudentTable);
      
      JButton btnAddStudent = new JButton("Add Student");
      btnAddStudent.setBounds(550, 11, 126, 23);
      StudentPanel.add(btnAddStudent);
      
      JButton btnEditStudent = new JButton("Edit Student");
      btnEditStudent.setBounds(550, 45, 126, 23);
      StudentPanel.add(btnEditStudent);
      
      JButton btnDeleteStudent = new JButton("Delete Student");
      btnDeleteStudent.setBounds(550, 79, 126, 23);
      StudentPanel.add(btnDeleteStudent);
      
      JButton btnFindStudent = new JButton("Find Student");
      btnFindStudent.setBounds(550, 113, 126, 23);
      StudentPanel.add(btnFindStudent);
      
      
      StudentInformationPane.setBounds(500, 152, 190, 239);
      StudentPanel.add(StudentInformationPane);
      StudentInformationPane.setVisible(false); ///////////////////////////////////////
      
      JPanel StudentInformationPanel = new JPanel();
      StudentInformationPane.setViewportView(StudentInformationPanel);
      StudentInformationPanel.setLayout(null);
      
      JTextArea StudentInformationTxt = new JTextArea();
      StudentInformationTxt.setBounds(0, 0, 188, 237);
      StudentInformationPanel.add(StudentInformationTxt);
      
      /**
       * Getting panel so it would follow the JFrame.
       */
   }

   
   public String[][] populateShiftTable(){

	     List<Shift> shifts = empShiftController.getAllShifts(connection);
	     String[][] toTable = new String[shifts.size()][6]; 
	     //Location", "Company", "Time", "Date", "Status", "Released
	    for(int i = 0; i < shifts.size(); i++) {
	    	toTable[i][0] = "a";
	    	toTable[i][1] = "b";
	    	toTable[i][2] = "c";
	    	toTable[i][3] = "d";
	    	toTable[i][4] = "e";
	    	toTable[i][5] = "f";
	    }
	     
	   return toTable;
 }
}

