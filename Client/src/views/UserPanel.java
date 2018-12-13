package views;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class UserPanel extends JPanel  {
	public UserPanel() {
		setLayout(null);
		GenerateView();
		
		
	}
	
	public void GenerateView()
	{
		JLabel lblSecond = new JLabel("second");
		lblSecond.setBounds(196, 125, 46, 14);
		add(lblSecond);
	}
	
	
	


}
