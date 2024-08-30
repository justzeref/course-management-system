package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class EditCourse extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nfield;
	private JTextField dfield;
	private JTextField ifield;
	private JTextField sfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCourse frame = new EditCourse();
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
	public EditCourse() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 544, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditCourse = new JLabel("Edit course");
		lblEditCourse.setBackground(Color.GRAY);
		lblEditCourse.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblEditCourse.setBounds(212, 40, 106, 26);
		contentPane.add(lblEditCourse);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(157, 112, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		nfield = new JTextField();
		nfield.setColumns(10);
		nfield.setBounds(212, 109, 96, 19);
		contentPane.add(nfield);
		
		JLabel durationField = new JLabel("duration");
		durationField.setBounds(146, 147, 64, 13);
		contentPane.add(durationField);
		
		dfield = new JTextField();
		dfield.setColumns(10);
		dfield.setBounds(212, 144, 96, 19);
		contentPane.add(dfield);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE courses SET coursename = ?, duration = ?,numberofseats=? WHERE id = ?";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1, nfield.getText());
					pst.setString(2, dfield.getText());
					pst.setString(3, sfield.getText());
					pst.setString(4, ifield.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Sucessfully edited. Refresh to see changes");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});
		btnNewButton.setBounds(223, 200, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Id");
		lblNewLabel_1_2.setBounds(157, 89, 45, 13);
		contentPane.add(lblNewLabel_1_2);
		
		ifield = new JTextField();
		ifield.setColumns(10);
		ifield.setBounds(212, 80, 96, 19);
		contentPane.add(ifield);
		
		sfield = new JTextField();
		sfield.setColumns(10);
		sfield.setBounds(212, 171, 96, 19);
		contentPane.add(sfield);
		
		JLabel seats = new JLabel("seats");
		seats.setBounds(157, 174, 45, 13);
		contentPane.add(seats);
	}

}
