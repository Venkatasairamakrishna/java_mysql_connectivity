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
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class reg {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg window = new reg();
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
	public reg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 742, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel n1 = new JLabel("Name");
		n1.setFont(new Font("Tahoma", Font.BOLD, 15));
		n1.setBounds(71, 146, 95, 34);
		frame.getContentPane().add(n1);
		
		JLabel n2 = new JLabel("Email");
		n2.setFont(new Font("Tahoma", Font.BOLD, 15));
		n2.setBounds(71, 179, 62, 34);
		frame.getContentPane().add(n2);
		
		JLabel roll = new JLabel("Roll No");
		roll.setFont(new Font("Tahoma", Font.BOLD, 15));
		roll.setBounds(71, 224, 95, 34);
		frame.getContentPane().add(roll);
		
		JLabel m1 = new JLabel("Marks");
		m1.setFont(new Font("Tahoma", Font.BOLD, 15));
		m1.setBounds(71, 264, 95, 34);
		frame.getContentPane().add(m1);
		
		t1 = new JTextField();
		t1.setBounds(150, 155, 160, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(150, 193, 160, 20);
		frame.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(150, 233, 160, 20);
		frame.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(150, 269, 160, 20);
		frame.getContentPane().add(t4);
		
		JButton b1 = new JButton("Submite");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=t1.getText();
				String Email=t2.getText();
				String Roll=t3.getText();
				String marks=t4.getText();
				int m=Integer.parseInt(marks);
				
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","mrec");
					String q="Insert into reg1 values('"+Name+"','"+Email+"','"+Roll+"','"+m+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(b1,"Done!");
           
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b1.setBounds(479, 187, 115, 54);
		frame.getContentPane().add(b1);
		
		JLabel lblNewLabel = new JLabel("REG");
		lblNewLabel.setBounds(322, 56, 46, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
