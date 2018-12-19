package views;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import controllers.BaseController;
import controllers.EmployeeShiftsController;
import controllers.StudentController;
import models.Shift;
import serverConnection.Connection;

public class StudentPanel extends JPanel
{
	
	private static final long serialVersionUID = -3339712839937225664L;

	private JTable availableShiftsTable;
	private DefaultTableModel dtm;
	private StudentController studentController;
	private EmployeeShiftsController employeeShiftsController;
   private BaseController  baseController;
   public Connection connection;

 
   public StudentPanel(BaseController baseController, Connection c)
   {
	   this.baseController = baseController;
	   this.connection = c;
	  
	   employeeShiftsController = new EmployeeShiftsController();
	   studentController = new StudentController();
	   setLayout(null);
	  GenerateView();

   }
   
  
   
   public void GenerateView()
   {
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 189, 300, 200);
      add(scrollPane);

      Object[] columnNames = {"Date", "Company", "City", "Time"};
      dtm = new DefaultTableModel(columnNames, 0);
      availableShiftsTable = new JTable(dtm)
         {
    			  
    				private static final long serialVersionUID = 1L;

    		      	boolean[] columnEditables = new boolean[] {
    		      		false, false, false, false
    		      	};
    		      	public boolean isCellEditable(int row, int column) {
    		      		return columnEditables[column];
    		      	}}
      ;
      scrollPane.setViewportView(availableShiftsTable);
      fillAvailableShiftTable();
      
      JCalendar calendar = new JCalendar();
      calendar.setBounds(10, 25, 580, 122);
      add(calendar);
 
      JButton btnAvalaibleShifts = new JButton("Avalaible Shifts");
      btnAvalaibleShifts.setBounds(20, 155, 105, 23);
      btnAvalaibleShifts.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	});
      add(btnAvalaibleShifts);

      JButton btnMyShifts = new JButton("My Shifts");
      btnMyShifts.setBounds(178, 155, 89, 23);
      add(btnMyShifts);

      JScrollPane StudentScheduleScrollPane = new JScrollPane();
      StudentScheduleScrollPane.setBounds(316, 189, 133, 200);
      add(StudentScheduleScrollPane);

      Panel StudentScheduleTablePanel = new Panel();
      StudentScheduleScrollPane.setViewportView(StudentScheduleTablePanel);
      StudentScheduleTablePanel.setLayout(null);

      JTextArea StudentScheduleTableTextArea = new JTextArea();
      StudentScheduleTableTextArea.setBounds(0, 0, 159, 198);
      StudentScheduleTablePanel.add(StudentScheduleTableTextArea);

      JButton btnRequestshift = new JButton("Request Shift");
      btnRequestshift.setBounds(468, 186, 105, 23);
      add(btnRequestshift);

      JButton btnReportSickness = new JButton("Report Sickness");
      btnReportSickness.setBounds(464, 218, 109, 23);
      add(btnReportSickness);

      JCheckBox chckbxShowSchoolCalendar = new JCheckBox("Show school calendar");
      chckbxShowSchoolCalendar.setBounds(452, 248, 138, 28);
      add(chckbxShowSchoolCalendar);
  
      JCheckBox chckbxShowWorkCalendar = new JCheckBox("Show work calendar");
      chckbxShowWorkCalendar.setBounds(452, 279, 121, 23);
      add(chckbxShowWorkCalendar);

   }
   
   public JPanel getPanel()
   {
      return this;
   }

   public void fillAvailableShiftTable() {
	   
	   List<Shift> shiftList = employeeShiftsController.getAllShifts(connection);
	   String[][] toTable = new String[shiftList.size()][4];
	   //"Date", "Company", "City", "Time"
	   for(int i = 0; i < shiftList.size(); i++) {
		   toTable[i][0] = shiftList.get(i).getShiftDate().toString();
		   toTable[i][1] = shiftList.get(i).getcompanyId()+"";
		   toTable[i][2] = shiftList.get(i).getcompanyId()+"loc";
		   toTable[i][3] = shiftList.get(i).getShiftTime()+"";
		   dtm.addRow(toTable[i]);
	   }
	   
   }
 
}
