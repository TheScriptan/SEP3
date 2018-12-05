import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class AdminShiftGUI extends JFrame
{

   private JPanel contentPane;
   private JTable table;

   /**
    * Launch the application.
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            try
            {
               AdminShiftGUI frame = new AdminShiftGUI();
               frame.setVisible(true);
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public AdminShiftGUI()
   {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(150, 50, 800, 600);
      
      JMenuBar menuBar = new JMenuBar();
      setJMenuBar(menuBar);
      
      JMenuItem mntmFile = new JMenuItem("File");
      menuBar.add(mntmFile);

      
      JMenuItem mntmAbout = new JMenuItem("About");

      menuBar.add(mntmAbout);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      table = new JTable();
      table.setBounds(35, 77, 582, 420);
      contentPane.add(table);
      
      JButton btnSelectGroup = new JButton("Select group");
      btnSelectGroup.setBounds(657, 77, 105, 23);
      contentPane.add(btnSelectGroup);
      
      JButton btnAddShift = new JButton("Add shift");
      btnAddShift.setBounds(657, 111, 105, 23);
      contentPane.add(btnAddShift);
      
      JButton btnEditShift = new JButton("Edit shift");
      btnEditShift.setBounds(657, 145, 105, 23);
      contentPane.add(btnEditShift);
      
      JButton btnAssignShift = new JButton("Assign shift");
      btnAssignShift.setBounds(657, 179, 105, 23);
      contentPane.add(btnAssignShift);
      
      JButton btnShiftRequests = new JButton("Shift requests");
      btnShiftRequests.setBounds(657, 213, 105, 23);
      contentPane.add(btnShiftRequests);
      
      JButton btnRemoveShift = new JButton("Remove shift");
      btnRemoveShift.setBounds(657, 247, 105, 23);
      contentPane.add(btnRemoveShift);
      
      //Singleton
      ServerHandler serverHandler = ServerHandler.getInstance();
      ShiftList shiftList = new ShiftList();
      
      btnAddShift.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Shift newShift = new Shift(1, "2018-11-13", "18:00", "Shoes" );
			serverHandler.AddShift(newShift);
		}
    	  
      });
   }
}
