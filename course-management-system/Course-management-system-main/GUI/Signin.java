package GUI;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signin extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public Signin(JFrame frame) {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 663, 412);
		add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(37, 153, 221, 32);
		panel.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(37, 131, 45, 13);
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(37, 230, 221, 32);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(37, 207, 67, 13);
		panel.add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(37, 295, 221, 32);
		panel.add(passwordField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(" Confirm password");
		lblNewLabel_2_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2_1.setBounds(37, 272, 120, 13);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Signup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Auth.addCredential(textField.getText(), new String( passwordField.getPassword()));
					JOptionPane.showMessageDialog(null, "Signed up Successfully!");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton.setBounds(37, 348, 85, 21);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(347, 0, 316, 412);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(158, 5, 0, 0);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(getClass().getResource("../images/cafeterai.png")));
		lblNewLabel_3.setBounds(0, 0, 512, 412);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(37, 60, 169, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Already a member?");
		lblNewLabel_4.setForeground(new Color(64, 0, 64));
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_4.setBounds(37, 379, 120, 23);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Login");
		lblNewLabel_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login(frame);
				panel.setVisible(false);
			}
		});
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_4_1.setBounds(167, 379, 103, 23);
		panel.add(lblNewLabel_4_1);

	}

}
