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

public class AddReasult extends JFrame {

	private JPanel contentPane;
	private JTextField ifield;
	private JTextField mfield;
	private JTextField gpafield;
	private JTextField gradefield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReasult frame = new AddReasult();
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
	public AddReasult() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGenerateReport = new JLabel("Generate Report");
		lblGenerateReport.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblGenerateReport.setBackground(Color.GRAY);
		lblGenerateReport.setBounds(144, 26, 177, 17);
		contentPane.add(lblGenerateReport);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(112, 56, 45, 13);
		contentPane.add(lblId);
		
		ifield = new JTextField();
		ifield.setColumns(10);
		ifield.setBounds(167, 53, 96, 19);
		contentPane.add(ifield);
		
		JLabel lblNewLabel_1 = new JLabel("Module Name");
		lblNewLabel_1.setBounds(82, 92, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		mfield = new JTextField();
		mfield.setColumns(10);
		mfield.setBounds(167, 89, 96, 19);
		contentPane.add(mfield);
		
		JLabel lblGpa = new JLabel("Gpa");
		lblGpa.setBounds(112, 127, 45, 13);
		contentPane.add(lblGpa);
		
		gpafield = new JTextField();
		gpafield.setColumns(10);
		gpafield.setBounds(167, 124, 96, 19);
		contentPane.add(gpafield);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="INSERT INTO `studentresult`( `student_id`, `moduleName`, `gpa`,`grade`) VALUES (?,?,?,?)";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1,ifield.getText());
					pst.setString(2,mfield.getText());
					pst.setString(3,gpafield.getText());
					pst.setString(4,gradefield.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Sucessfully added");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(178, 180, 85, 21);
		contentPane.add(btnNewButton);
		
		gradefield = new JTextField();
		gradefield.setColumns(10);
		gradefield.setBounds(167, 153, 96, 19);
		contentPane.add(gradefield);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(112, 156, 45, 13);
		contentPane.add(lblGrade);
	}

}
