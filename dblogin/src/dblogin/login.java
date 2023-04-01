package dblogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField t5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 812, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(348, 27, 89, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRollNo = new JLabel("Roll no");
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRollNo.setBounds(166, 167, 72, 54);
		frame.getContentPane().add(lblRollNo);
		
		t5 = new JTextField();
		t5.setBounds(248, 186, 153, 20);
		frame.getContentPane().add(t5);
		t5.setColumns(10);
		
		JLabel lb1 = new JLabel("Name :");
		lb1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb1.setBounds(153, 243, 199, 32);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Marks :");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lb2.setBounds(153, 286, 199, 39);
		frame.getContentPane().add(lb2);
		
		JButton btnNewButton = new JButton("check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un=t5.getText();
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","mrec");
					String q="select name,marks from reg1 where rollno=?";
	                PreparedStatement ps=con.prepareStatement(q);
	                ps.setString(1, un);
	                ResultSet rs=ps.executeQuery();
	                rs.next();
	                lb1.setText("Name  : "+rs.getString(1));
	                lb2.setText("Marks : "+rs.getInt(2));
 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(427, 185, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}

}
