package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class DeleteStudent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudent frame = new DeleteStudent();
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
	public DeleteStudent() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 544, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteStudent = new JLabel("Delete ");
		lblDeleteStudent.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblDeleteStudent.setBackground(Color.GRAY);
		lblDeleteStudent.setBounds(212, 44, 119, 17);
		contentPane.add(lblDeleteStudent);
		
		JLabel lblNewLabel_1 = new JLabel("Delete ID");
		lblNewLabel_1.setBounds(137, 90, 65, 13);
		contentPane.add(lblNewLabel_1);
		
		dfield = new JTextField();
		dfield.setColumns(10);
		dfield.setBounds(212, 87, 96, 19);
		contentPane.add(dfield);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query =  "DELETE FROM auth WHERE id = ?";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1, dfield.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Sucessfully deleted. Refresh to see changes");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});
		btnDelete.setBounds(222, 125, 85, 21);
		contentPane.add(btnDelete);
	}

}
