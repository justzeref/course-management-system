package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.PreparedStatement;
import com.mysql.cj.jdbc.result.ResultSetMetaData;


//inheritance
public class Dashboard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_2;
	private JTable ctable;
	private JTable teacherTable;

	public Dashboard(JFrame frame,String role) {
		setLayout(null);
		
		JPanel mainPanel = new JPanel();
		setVisible(true);
		mainPanel.setBounds(10, 10, 854, 509);
		frame.setBounds(100, 100, 900, 550);
		add(mainPanel);
		mainPanel.setLayout(null);
		frame.getContentPane().add(mainPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setForeground(new Color(0, 255, 0));
		panel.setBounds(0, 0, 235, 509);
		mainPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		
		btnNewButton.setBounds(68, 130, 85, 21);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Course");
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
	
		btnNewButton_1.setBounds(68, 182, 85, 21);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student");
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		
		btnNewButton_2.setBounds(68, 244, 85, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Teacher");
		btnNewButton_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		
		btnNewButton_3.setBounds(68, 311, 85, 21);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Log out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login(frame);
				mainPanel.setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_4.setBounds(68, 436, 85, 21);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Dashboard.class.getResource("/images/logo.png")));
		lblNewLabel_4.setBounds(31, 26, 176, 70);
		panel.add(lblNewLabel_4);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(234, 10, 610, 489);
		mainPanel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel coursePanel = new JPanel();
		coursePanel.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(coursePanel, "name_929318290205600");
		coursePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(257, 10, 127, 31);
		coursePanel.add(lblNewLabel);
		
		JButton addCourse = new JButton("Add");
		addCourse.setBackground(Color.GRAY);
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 new AddCourse();
			}
		});
		addCourse.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		addCourse.setBounds(10, 80, 157, 37);
		
		
		JButton editCourse = new JButton("Edit");
		editCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new EditCourse();
			}
		});
		editCourse.setBackground(Color.GRAY);
		editCourse.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		editCourse.setBounds(192, 80, 157, 37);
		
		
		JButton deleteCourse = new JButton("Delete");
		deleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 new DeleteCourse();
			}
		});
		deleteCourse.setBackground(Color.GRAY);
		deleteCourse.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		deleteCourse.setBounds(377, 80, 157, 37);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 590, 334);
		coursePanel.add(scrollPane);
		
		ctable = new JTable();
		scrollPane.setViewportView(ctable);
		
		
		JPanel student = new JPanel();
		student.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(student, "name_929320737328000");
		student.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student");
		lblNewLabel_1.setForeground(SystemColor.infoText);
		lblNewLabel_1.setLabelFor(this);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_1.setBounds(224, 10, 125, 37);
		student.add(lblNewLabel_1);
		
		JButton editStudent = new JButton("Edit");
		editStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new EditStudent();
			}
		});
		editStudent.setBackground(Color.GRAY);
		editStudent.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		editStudent.setBounds(10, 91, 157, 37);
		
		
		JButton deleteStudent = new JButton("Delete\r\n");
		deleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 new DeleteStudent();
			}
		});
		deleteStudent.setBackground(Color.GRAY);
		deleteStudent.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		deleteStudent.setBounds(192, 91, 157, 37);
		
		
		JButton seeResult = new JButton("See Reasult");
		seeResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new SeeResult();
			}
		});
		seeResult.setBackground(Color.GRAY);
		seeResult.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		seeResult.setBounds(377, 91, 157, 37);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 163, 590, 286);
		student.add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		
		JButton btnNewButton_5 = new JButton("Generate Report");
		btnNewButton_5.setBackground(Color.GRAY);
		btnNewButton_5.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddReasult();
			}
		});
		btnNewButton_5.setBounds(429, 41, 171, 21);
		
		
		JPanel teacher = new JPanel();
		teacher.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(teacher, "name_929322823477400");
		teacher.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setBounds(192, 10, 145, 37);
		teacher.add(lblNewLabel_2);
		
		JButton btnNewButton_5_2_1 = new JButton("Add");
		btnNewButton_5_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new AddTeacher();
			}
		});
		btnNewButton_5_2_1.setBackground(Color.GRAY);
		btnNewButton_5_2_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_5_2_1.setBounds(10, 95, 157, 37);
	
		
		JButton btnNewButton_5_1_2_1 = new JButton("Edit");
		btnNewButton_5_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditStudent();
			}
		});
		btnNewButton_5_1_2_1.setBackground(Color.GRAY);
		btnNewButton_5_1_2_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_5_1_2_1.setBounds(192, 95, 157, 37);
		
		
		JButton btnNewButton_5_1_1_1_1 = new JButton("Delete");
		btnNewButton_5_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStudent();
			}
		});
		btnNewButton_5_1_1_1_1.setBackground(Color.GRAY);
		btnNewButton_5_1_1_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_5_1_1_1_1.setBounds(377, 95, 157, 37);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(29, 169, 571, 310);
		teacher.add(scrollPane_2);
		
		teacherTable = new JTable();
		scrollPane_2.setViewportView(teacherTable);
		
		JPanel home = new JPanel();
		home.setBackground(Color.LIGHT_GRAY);
		layeredPane.add(home, "name_1011321546409100");
		home.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome Nishan!! \r\n\r\nback to HOME.");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(10, 0, 240, 38);
		home.add(lblNewLabel_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(home);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(coursePanel);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				String  query = "SELECT * FROM `courses` ";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
				
					ResultSet rs=pst.executeQuery();
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) ctable.getModel();
					model.setRowCount(0); // Clear the table model
					int column = rsmd.getColumnCount();
					String[] columnName = new String[column];

					for (int i = 0; i < column; i++) {
						columnName[i] = rsmd.getColumnName(i + 1);
					}
					model.setColumnIdentifiers(columnName);
					String  id, coursename, numberofseats, duration;
					List<String> myList = new ArrayList<>();
					while (rs.next()) {
						id = rs.getString(1);
						coursename= rs.getString(2);
						numberofseats= rs.getString(3);
						duration=rs.getString(4);
						myList = new ArrayList<>();
						myList.add(id);
						myList.add(coursename);
						myList.add(numberofseats);
						myList.add(duration);
						Vector<String> row = new Vector<String>(myList);
						model.addRow(row);
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
				
			}
		});
		new JTable();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(student);
				layeredPane.repaint();
				layeredPane.revalidate();
				String role="student";
				String  query = "SELECT id,email FROM `auth` WHERE role=?";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1, role);
					ResultSet rs=pst.executeQuery();
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table_2.getModel();
					model.setRowCount(0); // Clear the table model
					int column = rsmd.getColumnCount();
					String[] columnName = new String[column];

					for (int i = 0; i < column; i++) {
						columnName[i] = rsmd.getColumnName(i + 1);

					}
					model.setColumnIdentifiers(columnName);
					String  email, id;
					

					List<String> myList = new ArrayList<>();

					while (rs.next()) {
						id = rs.getString(1);
						email = rs.getString(2);
						myList = new ArrayList<>();
						myList.add(id);
						myList.add(email);
						Vector<String> row = new Vector<String>(myList);
						model.addRow(row);
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
				
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(teacher);
				layeredPane.repaint();
				layeredPane.revalidate();
				String role="teacher";
				String  query = "SELECT id,email FROM `auth` WHERE role=?";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1, role);
					ResultSet rs=pst.executeQuery();
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) teacherTable.getModel();
					model.setRowCount(0); // Clear the table model
					int column = rsmd.getColumnCount();
					String[] columnName = new String[column];

					for (int i = 0; i < column; i++) {
						columnName[i] = rsmd.getColumnName(i + 1);

					}
					model.setColumnIdentifiers(columnName);
					String  email, id;
					

					List<String> myList = new ArrayList<>();

					while (rs.next()) {
						id = rs.getString(1);
						email = rs.getString(2);
						myList = new ArrayList<>();
						myList.add(id);
						myList.add(email);
						Vector<String> row = new Vector<String>(myList);
						model.addRow(row);
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());
				}
				
			}
		});
		if(role.equals("teacher"))
		{
			
			student.add(btnNewButton_5);
		}
		if(role.equals("admin")) {
			coursePanel.add(addCourse);
			coursePanel.add(editCourse);
			coursePanel.add(deleteCourse);
			student.add(deleteStudent);
			student.add(editStudent);
			student.add(seeResult);
			teacher.add(btnNewButton_5_2_1);
			teacher.add(btnNewButton_5_1_2_1);
			teacher.add(btnNewButton_5_1_1_1_1);
		}

	}
}
