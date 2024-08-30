package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class DeleteCourse extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCourse frame = new DeleteCourse();
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
	public DeleteCourse() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 544, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteCourse = new JLabel("Delete Course");
		lblDeleteCourse.setBackground(Color.GRAY);
		lblDeleteCourse.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblDeleteCourse.setBounds(155, 40, 119, 17);
		contentPane.add(lblDeleteCourse);
		
		JLabel lblNewLabel_1 = new JLabel("Edit the ID You want to Delete");
		lblNewLabel_1.setBounds(69, 107, 171, 13);
		contentPane.add(lblNewLabel_1);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(239, 104, 96, 19);
		contentPane.add(idField);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String query = "DELETE FROM courses WHERE id = ?";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1, idField.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Sucessfully deleted. Refresh to see changes");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});
		btnDelete.setBounds(250, 148, 85, 21);
		contentPane.add(btnDelete);
	}

}
