import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.net.*;
import java.io.*;

public class LoginFrame
{

   private JFrame frame;
   private JTextField textField;
   private JPasswordField passwordField;
   private String username = null;
   private String password = null;

   /**
    * Launch the application.
    */
   public static void main(String[] args)
   {
      
      /// GUI code
      EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            try
            {
               LoginFrame window = new LoginFrame();
               window.frame.setVisible(true);
               
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      });
      
   }

   /**
    * Create the application.
    */
   public LoginFrame()
   {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize()
   {
      frame = new JFrame();
      frame.setBounds(150, 50, 800, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      ServerHandler serverHandler = new ServerHandler();
      
      JLabel lblLogin = new JLabel("Login:");
      lblLogin.setBounds(304, 301, 46, 14);
      frame.getContentPane().add(lblLogin);
      
      JLabel lblPassword = new JLabel("Password:");
      lblPassword.setBounds(304, 342, 71, 14);
      frame.getContentPane().add(lblPassword);
      
      textField = new JTextField();
      textField.setBounds(380, 298, 86, 20);
      frame.getContentPane().add(textField);
      textField.setColumns(10);
      
      passwordField = new JPasswordField();
      passwordField.setBounds(380, 339, 86, 20);
      frame.getContentPane().add(passwordField);
      
      JLabel lblViaVikar = new JLabel("VIA-VIKAR");
      lblViaVikar.setBounds(346, 257, 79, 14);
      frame.getContentPane().add(lblViaVikar);
      
      
   
         // GUI code continued
      
      JButton btnLogin = new JButton("Login");
      btnLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) 
         {
            username = textField.getText();
            password = String.valueOf(passwordField.getPassword());
            
            if(serverHandler.CheckLogin(username, password))
            {
               JOptionPane.showMessageDialog(frame, "you are successfully logged in");
               AdminShiftGUI shift = new AdminShiftGUI();
               shift.setVisible(true);
               dispose();
            }
            else
            {
               JOptionPane.showMessageDialog(frame, "invalid name or password");
            }
         }

         private void dispose()
         {
            frame.setVisible(false);
         }
      });
      btnLogin.setBounds(336, 374, 89, 23);
      frame.getContentPane().add(btnLogin);
   }
}
