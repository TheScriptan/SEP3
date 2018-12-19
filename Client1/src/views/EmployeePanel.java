package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controllers.BaseController;
import controllers.EmployeeShiftsController;
import controllers.EmployeeStudentsController;
import models.Shift;
import models.Student;
import serverConnection.Connection;
import views.popouts.AddShift;
import views.popouts.AddStudent;

public class EmployeePanel extends JPanel
{
	private static final long serialVersionUID = 3300283553589562880L;
	
   private EmployeeShiftsController employeeShiftsController;
   private EmployeeStudentsController employeeStudentsController;
   @SuppressWarnings("unused")
   private BaseController baseController;
   
   
   private JScrollPane shiftInformationPane = new JScrollPane();
   private JScrollPane studentInformationScrollPanel = new JScrollPane();
   private JTable shiftTable;
   private JTable studentTable;
   private DefaultTableModel studentTableModel;
   private DefaultTableModel shiftTableModel;
   
   public Connection connection;
   /**
    * Create the panel.
    */
   public EmployeePanel(BaseController baseController, Connection connection)
   {
	  this.baseController = baseController;
	  this.connection = connection;
	  
	  employeeStudentsController = new EmployeeStudentsController();
	  employeeShiftsController = new EmployeeShiftsController();
	  
      setLayout(null);
      GenerateView();
   }
   
   
   public void GenerateView()
   {
	   
	  // Admin tabs for changing views between shifts and students
      JTabbedPane adminTabs = new JTabbedPane(JTabbedPane.TOP);
      adminTabs.setBounds(10, 11, 705, 440);
      add(adminTabs);
      
      // SHIFTS view ===========================================
      JPanel shiftPanel = new JPanel();
      adminTabs.addTab("Shift", null, shiftPanel, null);
      adminTabs.setEnabledAt(0, true);
      shiftPanel.setLayout(null);
   
      JButton btnRemoveShift = new JButton("Remove Shift");
      btnRemoveShift.setBounds(547, 86, 126, 23);
      btnRemoveShift.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
      		employeeShiftsController.deleteShift(connection,Long.parseLong(shiftTable.getValueAt(shiftTable.getSelectedRow(), 0)+""));
		}
	});     
      shiftPanel.add(btnRemoveShift);
     
      JButton btnReleaseShift = new JButton("Release Shift");
      btnReleaseShift.setBounds(547, 109, 126, 23);
      shiftPanel.add(btnReleaseShift);
    
      JButton btnNewShift = new JButton("New Shift");
      btnNewShift.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) 
      	{
      		new AddShift(employeeShiftsController, connection);
      	}
      });
      btnNewShift.setBounds(547, 11, 126, 23);
      shiftPanel.add(btnNewShift);
   
      JButton btnRefreshShiftTable = new JButton("Refresh Table");
      btnRefreshShiftTable.setBounds(547, 59, 126, 23);
      btnRefreshShiftTable.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			refreshShiftTable();
		}
	});
      shiftPanel.add(btnRefreshShiftTable);
         
      JButton btnEditShift = new JButton("Edit Shift");
      btnEditShift.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) 
      	{
      		new AddShift(employeeShiftsController, connection);
      	}
      });
      btnEditShift.setBounds(547, 36, 126, 23);
      shiftPanel.add(btnEditShift);

      JScrollPane shiftTableScrollPane = new JScrollPane();
      shiftTableScrollPane.setBounds(0, 0, 490, 391);
      shiftPanel.add(shiftTableScrollPane);
      
      String[] columnNamesShift = {
        		"ShiftID" ,"Comapny ID", "Location", "Shift Date", "Time", "Status", "Released"
        	};
      shiftTableModel = new DefaultTableModel(columnNamesShift, 0);
      
      shiftTable = new JTable(shiftTableModel){
 
		private static final long serialVersionUID = 1L;

      	boolean[] columnEditables = new boolean[] {
      		false, false, false, false, false, false
      	};
      	public boolean isCellEditable(int row, int column) {
      		return columnEditables[column];
      	}
      };
      shiftTable.getColumnModel().getColumn(0).setResizable(false);
      shiftTable.getColumnModel().getColumn(1).setResizable(false);
      shiftTable.getColumnModel().getColumn(2).setResizable(false);
      shiftTable.getColumnModel().getColumn(3).setResizable(false);
      shiftTable.getColumnModel().getColumn(4).setResizable(false);
      shiftTable.getColumnModel().getColumn(5).setResizable(false);
      shiftTable.getColumnModel().getColumn(6).setResizable(false);
      shiftTable.getColumnModel().getColumn(6).setPreferredWidth(78);
      shiftTableScrollPane.setViewportView(shiftTable);
      refreshShiftTable();
      
      shiftInformationPane.setVisible(false);
      shiftInformationPane.setBounds(510, 143, 180, 248);
      shiftPanel.add(shiftInformationPane);
      
      JPanel shiftInformationPanel = new JPanel();
      shiftInformationPane.setViewportView(shiftInformationPanel);
      shiftInformationPanel.setLayout(null);
      
      JTextArea shiftInformationShiftTxt = new JTextArea();
      shiftInformationShiftTxt.setBounds(0, 0, 178, 246);
      shiftInformationPanel.add(shiftInformationShiftTxt);
      

      // STUDENTS view ===========================================
      JPanel studentPanel = new JPanel();
      adminTabs.addTab("Students", null, studentPanel, null);
      studentPanel.setLayout(null);
   
      JScrollPane studentTableScrollPane = new JScrollPane();
      studentTableScrollPane.setBounds(0, 0, 490, 391);
      studentPanel.add(studentTableScrollPane);
 
      String[] columnNames = {"Student CPR", "Student Password", "Name", "Address", "Phone Nr.", "E-mail", "Bank Account"};
      studentTableModel = new DefaultTableModel(columnNames, 0);
      studentTable = new JTable(studentTableModel){
    	  
  		private static final long serialVersionUID = 1L;

        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        };
      studentTable.getColumnModel().getColumn(0).setPreferredWidth(79);
      studentTable.getColumnModel().getColumn(1).setPreferredWidth(110);
      studentTable.getColumnModel().getColumn(2).setPreferredWidth(96);
      studentTable.getColumnModel().getColumn(2).setMinWidth(0);
      studentTable.getColumnModel().getColumn(3).setPreferredWidth(132);
      studentTable.getColumnModel().getColumn(3).setMinWidth(0);
      studentTable.getColumnModel().getColumn(4).setPreferredWidth(84);
      studentTableScrollPane.setViewportView(studentTable);
      refreshStudentTable();
      
      
      JButton btnAddStudent = new JButton("Add Student");
      btnAddStudent.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) 
      	{
      		new AddStudent(employeeStudentsController, connection);
      		
      	}
      });
      btnAddStudent.setBounds(550, 11, 126, 23);
      studentPanel.add(btnAddStudent);

      JButton btnEditStudent = new JButton("Edit Student");
      btnEditStudent.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
          	{
          		new AddStudent(employeeStudentsController, connection);
          		
          	}
          });
      btnEditStudent.setBounds(550, 45, 126, 23);
      studentPanel.add(btnEditStudent);

      JButton btnDeleteStudent = new JButton("Delete Student");
      btnDeleteStudent.setBounds(550, 79, 126, 23);
      btnDeleteStudent.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) 
      	{
      		employeeStudentsController.deleteStudent(connection,(String)studentTable.getValueAt(studentTable.getSelectedRow(), 0));
      	}
      });
      studentPanel.add(btnDeleteStudent);

      JButton btnRefreshTable = new JButton("Refresh Table");
      btnRefreshTable.setBounds(550, 113, 126, 23);
      btnRefreshTable.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			refreshStudentTable();
		}
	});
      studentPanel.add(btnRefreshTable);

      studentInformationScrollPanel.setBounds(500, 152, 190, 239);
      studentPanel.add(studentInformationScrollPanel);
      
      
       // Making the panel not visible until an interaction with the table occurs.
      studentInformationScrollPanel.setVisible(false); ///////////////////////////////////////
      
 
      //Creating a panel inside the scroll panel in student information.
      JPanel studentInformationPanel = new JPanel();
      studentInformationScrollPanel.setViewportView(studentInformationPanel);
      studentInformationPanel.setLayout(null);
      
      
      //Creating a text area inside the student information panel which will reference the student table content.
      JTextArea studentInformationTxt = new JTextArea();
      studentInformationTxt.setBounds(0, 0, 188, 237);
      studentInformationPanel.add(studentInformationTxt);
      
   }
   
   private void refreshStudentTable() {
//"Student CPR", "Student Password", "Name", "Address", "Phone Nr.", "E-mail", "Bank Account"
	   List<Student> studentList = employeeStudentsController.getAllStudents(connection);
	   String[][] toTable = new String[studentList.size()][7];
	   // Clear table
	   if(studentTable != null) {
		   	studentTableModel.setRowCount(0);
	   }
	   // Refill
	   for(int i = 0; i < studentList.size(); i++) {
		   toTable[i][0] = studentList.get(i).getStudentId();
		   toTable[i][1] = studentList.get(i).getPassword();
		   toTable[i][2] = studentList.get(i).getStudentName();
		   toTable[i][3] = studentList.get(i).getStudentAdress();
		   toTable[i][4] = studentList.get(i).getStudentPhoneNo();
		   toTable[i][5] = studentList.get(i).getStudentEmail();
		   toTable[i][6] = studentList.get(i).getStudentBankAcc();
		   studentTableModel.addRow(toTable[i]);
	   }
	   
}

   
   public void refreshShiftTable(){

	     List<Shift> shifts = employeeShiftsController.getAllShifts(connection);
	     String[][] toTable = new String[shifts.size()][7]; 
	     //Location", "Company", "Time", "Date", "Status", "Released
	     if(shiftTable != null) {
			   	shiftTableModel.setRowCount(0);
		   }
	     
	    for(int i = 0; i < shifts.size(); i++) {
	    	toTable[i][0] = shifts.get(i).getshiftId()+"";
	    	toTable[i][1] = "not implemented";
	    	toTable[i][2] = "not implemented";
	    	toTable[i][3] = shifts.get(i).getShiftDate()+"";
	    	toTable[i][4] = shifts.get(i).getShiftTime()+"";
	    	toTable[i][5] = "not implemented";
	    	toTable[i][6] = shifts.get(i).released+"";
			shiftTableModel.addRow(toTable[i]);
	    }
	     
}


   public JPanel getPanel()
	{
		return this;
	}
}

