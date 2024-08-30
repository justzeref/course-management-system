package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.PreparedStatement;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class SeeResult extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sfield;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeResult frame = new SeeResult();
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
	public SeeResult() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 764, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeeReasult = new JLabel("See Reasult");
		lblSeeReasult.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblSeeReasult.setBackground(Color.GRAY);
		lblSeeReasult.setBounds(10, 10, 119, 17);
		contentPane.add(lblSeeReasult);
		
		sfield = new JTextField();
		sfield.setBounds(535, 60, 180, 39);
		contentPane.add(sfield);
		sfield.setColumns(10);
		
		JLabel lblSearch = new JLabel("search");
		lblSearch.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblSearch.setBackground(Color.GRAY);
		lblSearch.setBounds(528, 39, 119, 17);
		contentPane.add(lblSearch);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  query = "SELECT * FROM `studentresult` WHERE student_id=?";
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
					pst.setString(1, sfield.getText());
					ResultSet rs=pst.executeQuery();
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0); // Clear the table model
					int column = rsmd.getColumnCount();
					String[] columnName = new String[column];

					for (int i = 0; i < column; i++) {
						columnName[i] = rsmd.getColumnName(i + 1);

					}
					model.setColumnIdentifiers(columnName);
					String  id, modulename,gpa,grade;
					

					List<String> myList = new ArrayList<>();

					while (rs.next()) {
						id = rs.getString(1);
						modulename = rs.getString(2);
						gpa = rs.getString(3);
						grade = rs.getString(4);
						myList = new ArrayList<>();
						myList.add(id);
						myList.add(modulename);
						myList.add(gpa);
						myList.add(grade);
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
		btnNewButton.setBounds(632, 111, 85, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 730, 273);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
