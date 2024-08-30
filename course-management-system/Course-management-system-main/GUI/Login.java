package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.PreparedStatement;

import GUI.Exceptions.InvalidEmailOrPassword;

import java.awt.Font;


public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField emailField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Login(JFrame jframe) {
		setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(10, 0, 714, 439);
		jframe.setBounds(100, 100, 745, 460);
		
		add(mainPanel);
		mainPanel.setLayout(null);
		jframe.getContentPane().add(mainPanel);
		mainPanel.setVisible(true);
		JButton btnNewButton = new JButton("Signup");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signin(jframe);
				mainPanel.setVisible(false);
			}
		});
		btnNewButton.setBounds(439, 392, 85, 21);
		mainPanel.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 324, 439);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(162, 5, 0, 0);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(getClass().getResource("../images/logo.png")));
		lblNewLabel_4.setBounds(35, 155, 266, 85);
		panel.add(lblNewLabel_4);
		
		emailField = new JTextField();
		emailField.setBounds(368, 162, 221, 32);
		mainPanel.add(emailField);
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(368, 229, 221, 32);
		mainPanel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(368, 139, 45, 13);
		mainPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(368, 204, 72, 13);
		mainPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Create a account");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(446, 376, 116, 13);
		mainPanel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=emailField.getText();
				String password=new String(passwordField.getPassword());
				String query="SELECT * FROM `auth` WHERE email=? and password=?";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1, email);
					pst.setString(2,password);
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						new Dashboard(jframe,rs.getString("role"));
						mainPanel.setVisible(false);
					}
                      else 
					{
						throw new InvalidEmailOrPassword("Invalid email or password");
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_1.setBounds(478, 278, 111, 32);
		mainPanel.add(btnNewButton_1);
		
		JLabel lblWelcomeHome = new JLabel("WELCOME HOME");
		lblWelcomeHome.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		lblWelcomeHome.setBounds(368, 32, 221, 37);
		mainPanel.add(lblWelcomeHome);
		

	}
}
