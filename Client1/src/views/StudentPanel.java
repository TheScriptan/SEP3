package views;

import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import controllers.StudentController;
import serverConnection.Connection;

public class StudentPanel extends JPanel
{
   private JTable studentSchoolTable;
   private StudentController userController;
   Connection c;

   /**
    * Create the panel.
    */
   public StudentPanel(StudentController userController, Connection c)
   {
	   this.userController = userController;
	   this.c = c;
	      setLayout(null);
      GenerateView();

   }
   public void GenerateView()
   {
      setLayout(null);
      /**
       * Creating the ScrollPane for the Table
       */
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(10, 189, 300, 200);
      add(scrollPane);
      /**
       * Creating StudentSchoolTable
       */
      studentSchoolTable = new JTable();
      studentSchoolTable.setModel(new DefaultTableModel(
         new Object[][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
         },
         new String[] {
            "Date", "City", "Time"
         }
      ));
      scrollPane.setViewportView(studentSchoolTable);
      /**
       * Creating the calendar
       */
      JCalendar calendar = new JCalendar();
      calendar.setBounds(10, 25, 580, 122);
      add(calendar);
      /**
       * Creating a button for the available shifts
       */
      JButton btnAvalaibleShifts = new JButton("Avalaible Shifts");
      btnAvalaibleShifts.setBounds(20, 155, 105, 23);
      add(btnAvalaibleShifts);
      /**
       * Creating a button for My Shifts
       */
      JButton btnMyShifts = new JButton("My Shifts");
      btnMyShifts.setBounds(178, 155, 89, 23);
      add(btnMyShifts);
      /**
       * Creating a Student Schedule ScrollPane
       */
      JScrollPane StudentScheduleScrollPane = new JScrollPane();
      StudentScheduleScrollPane.setBounds(316, 189, 133, 200);
      add(StudentScheduleScrollPane);
      /**
       * Creating a Panel for the Student Schedule
       */
      Panel StudentScheduleTablePanel = new Panel();
      StudentScheduleScrollPane.setViewportView(StudentScheduleTablePanel);
      StudentScheduleTablePanel.setLayout(null);
      /**
       * Creating a Text Area for the Panel
       */
      JTextArea StudentScheduleTableTextArea = new JTextArea();
      StudentScheduleTableTextArea.setBounds(0, 0, 159, 198);
      StudentScheduleTablePanel.add(StudentScheduleTableTextArea);
      /**
       * Creating a button for Requesting Shifts
       */
      JButton btnRequestshift = new JButton("Request Shift");
      btnRequestshift.setBounds(468, 186, 105, 23);
      add(btnRequestshift);
      /**
       * Creating a button for Sickness report
       */
      JButton btnReportSickness = new JButton("Report Sickness");
      btnReportSickness.setBounds(464, 218, 109, 23);
      add(btnReportSickness);
      /**
       * Creating a checkbox that shows the School Calendar when checked
       */
      JCheckBox chckbxShowSchoolCalendar = new JCheckBox("Show school calendar");
      chckbxShowSchoolCalendar.setBounds(452, 248, 138, 28);
      add(chckbxShowSchoolCalendar);
      /**
       * Creating a checkbox that shows the Calendar when checked
       */
      JCheckBox chckbxShowWorkCalendar = new JCheckBox("Show work calendar");
      chckbxShowWorkCalendar.setBounds(452, 279, 121, 23);
      add(chckbxShowWorkCalendar);

   }
   
   public JPanel getPanel()
   {
      return this;
   }

   
   public void fillStudentTable(JTable table) {
   }
}
