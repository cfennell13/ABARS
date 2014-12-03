
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import jxl.read.biff.File;

@SuppressWarnings("serial")
public class LoginGUI extends JFrame{

	private Starter start;
	private Student student=null;
	private JTextField userField=null;
	private JPasswordField passField=null;
	private LoginGUI thisLogin=this;

	/**This Class is a JFrame object that prompts the user for username and password
	 * 
	 * @author William Merritt
	 * @version 1.0
	 * 
	 * 
	 */
	/**Main Constructor: Creates and displays the Frame of the login
	 * 
	 * Edited Dec 2 by Courtney Fennell: added image to login screen
	 */
	public LoginGUI(Starter start){
		this.start=start;

		JButton button=new JButton("Submit");
		JPanel panel=new JPanel();
		JPanel superPanel=new JPanel();

		superPanel.setLayout(new BorderLayout());
		panel.setLayout(new BoxLayout( panel, BoxLayout.Y_AXIS));

		userField=new JTextField();
		passField=new JPasswordField();

		button.addActionListener(new LoginButtonListener());
		passField.addActionListener(new LoginButtonListener());

		try{
			BufferedImage image = ImageIO.read(this.getClass().getResource("erau.jpg"));
			JLabel icon = new JLabel(new ImageIcon(image));
			panel.add(icon);
		}catch(IOException e ){
			
		}
		panel.add(new JLabel("Enter Username"));
		panel.add(userField);
		panel.add(new JLabel("Password"));
		panel.add(passField);
		//panel.add(button);

		superPanel.add(panel,BorderLayout.CENTER);
		superPanel.add(button,BorderLayout.SOUTH);

		this.add(superPanel);
		this.setSize(200,180);
		this.setTitle("Student Login");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
	public void addComponent(JPanel panel,JComponent comp){

	}

	public Student getStudent(){
		return student;
	}

	/**
	 * Private Listener Class for the login Button
	 * 
	 * @author William Merritt
	 *
	 */
	private class LoginButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Student tempStudent;

			Login login=new Login(userField.getText(),new String(passField.getPassword()));

			tempStudent=login.ValidateLoginStudent();

			if(tempStudent!=null){
				start.startMain(tempStudent);
				thisLogin.dispose();
			}
			else{
				ImageIcon image = new ImageIcon(getClass().getResource("youshallnotpass.jpg"));
				JOptionPane.showMessageDialog(null, "Incorrect Username/Password", "Invalid Login attempt", DISPOSE_ON_CLOSE, image);
			}
		}




	}
}


