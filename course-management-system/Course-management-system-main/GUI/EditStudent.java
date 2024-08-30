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

public class EditStudent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nfield;
	private JTextField efield;
	private JTextField ifield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent frame = new EditStudent();
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
	public EditStudent() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 544, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditStudent = new JLabel("Edit Student");
		lblEditStudent.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblEditStudent.setBackground(Color.GRAY);
		lblEditStudent.setBounds(136, 30, 119, 17);
		contentPane.add(lblEditStudent);
		
		nfield = new JTextField();
		nfield.setColumns(10);
		nfield.setBounds(170, 104, 96, 19);
		contentPane.add(nfield);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(115, 107, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(115, 142, 45, 13);
		contentPane.add(lblEmail);
		
		efield = new JTextField();
		efield.setColumns(10);
		efield.setBounds(170, 139, 96, 19);
		contentPane.add(efield);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE auth SET name = ?, email = ? WHERE id = ?";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1, nfield.getText());
					pst.setString(2, efield.getText());
					pst.setString(3, ifield.getText());
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Sucessfully edited. Refresh to see changes");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});
		btnNewButton.setBounds(181, 175, 85, 21);
		contentPane.add(btnNewButton);
		
		ifield = new JTextField();
		ifield.setColumns(10);
		ifield.setBounds(170, 68, 96, 19);
		contentPane.add(ifield);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(115, 71, 45, 13);
		contentPane.add(lblId);
	}

}
