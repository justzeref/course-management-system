package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.mysql.cj.jdbc.PreparedStatement;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class AddTeacher extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField efield;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher frame = new AddTeacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddTeacher() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 436, 263);
		getContentPane().add(layeredPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 253);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddTeacher = new JLabel("Add Teacher");
		lblAddTeacher.setBackground(Color.GRAY);
		lblAddTeacher.setForeground(Color.BLACK);
		lblAddTeacher.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblAddTeacher.setBounds(166, 30, 106, 24);
		panel.add(lblAddTeacher);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(98, 83, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel emailField = new JLabel("email");
		emailField.setBounds(98, 118, 45, 13);
		panel.add(emailField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setBounds(78, 153, 65, 13);
		panel.add(lblNewLabel_1_2);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(153, 80, 96, 19);
		panel.add(nameField);
		
		efield = new JTextField();
		efield.setColumns(10);
		efield.setBounds(153, 115, 96, 19);
		panel.add(efield);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(153, 150, 96, 19);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="INSERT INTO `auth` ( `email`, `password`, `role`, `name`) VALUES (?,?, ?, ?);";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1,efield.getText());
					pst.setString(2,passwordField.getText());
					pst.setString(3,"teacher");
					pst.setString(4,nameField.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Sucessfully added");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			
			}});
		btnNewButton.setBounds(164, 205, 85, 21);
		panel.add(btnNewButton);
	}
}
