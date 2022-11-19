import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import java.awt.SystemColor;
import javax.swing.JTextArea;

public class CreateAccount extends JFrame {

	private JPanel contentPane;

	private JTextField username;
	private JLabel lblPassword;
	private JPasswordField password;
	private JButton createBtn;
	private JButton cancelBtn;
	private JLabel lblWeclomeToHosptial;
	private JTextField hName;
	private JTextArea hDoctors;
	private JTextArea hAddress;
	private JTextArea hContact;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 782);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(135, 123, 139, 32);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		username.setBounds(287, 123, 339, 32);
		contentPane.add(username);
		username.setColumns(10);
		
		lblPassword = new JLabel("Create Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(135, 184, 139, 32);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setBounds(287, 184, 339, 32);
		password.setColumns(10);
		contentPane.add(password);
		
		createBtn = new JButton("Create Account");
		createBtn.setForeground(new Color(255, 255, 255));
		createBtn.setBackground(new Color(0, 0, 0));
		createBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.createCon();
				
				String checkQ = "SELECT COUNT(h_username) FROM hospitals WHERE h_username = " + username.getText();
				PreparedStatement ps = null;
				try {
					ps = con.prepareStatement(checkQ);
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				ResultSet rs = null;
				
				try {
					rs = ps.executeQuery();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				boolean isExist = true;
				try {
					rs.next();
					if(username.getText().equals("0")) {
						JOptionPane.showMessageDialog(null, "Username should not be '0', Please use another Username!");
						isExist = false;
					}else if(rs.getInt(1) != 0) {
						JOptionPane.showMessageDialog(null, "Username is already in use, Please use another Username!");
						isExist = false;
					}
				} catch (HeadlessException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(isExist) {
						String query = "INSERT INTO hospitals (h_username, h_password, h_name, h_doctors, h_address, h_contact) values(?,?,?,?,?,?)";
						try {
							PreparedStatement pstmt = con.prepareStatement(query);
							
							int h_username = Integer.parseInt(username.getText());
							String h_password = password.getText();
							String h_name = hName.getText();
							String h_doctors = hDoctors.getText();
							String h_address = hAddress.getText();
							String h_contact = hContact.getText();
							
							pstmt.setInt(1, h_username);
							pstmt.setString(2, h_password);
							pstmt.setString(3, h_name);
							pstmt.setString(4, h_doctors);
							pstmt.setString(5, h_address);
							pstmt.setString(6, h_contact);
							
							pstmt.executeUpdate();
							JOptionPane.showMessageDialog(null, "Hospital Added!");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		createBtn.setBounds(135, 671, 220, 32);
		contentPane.add(createBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setForeground(new Color(255, 255, 255));
		cancelBtn.setBackground(new Color(0, 0, 0));
		cancelBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cancelBtn.setBounds(406, 669, 220, 34);
		contentPane.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		
		lblWeclomeToHosptial = new JLabel("Weclome to Hosptial Managment System");
		lblWeclomeToHosptial.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeclomeToHosptial.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		lblWeclomeToHosptial.setBounds(128, 46, 498, 32);
		contentPane.add(lblWeclomeToHosptial);
		
		hName = new JTextField("");
		hName.setFont(new Font("Trajan Pro", Font.BOLD, 28));
		hName.setBounds(134, 283, 492, 49);
		contentPane.add(hName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Our Doctors:");
		lblNewLabel_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(134, 338, 492, 41);
		contentPane.add(lblNewLabel_1_1);
		
		hDoctors = new JTextArea();
		hDoctors.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		hDoctors.setBounds(134, 377, 492, 76);
		contentPane.add(hDoctors);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hospital Address:");
		lblNewLabel_1_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(134, 463, 492, 41);
		contentPane.add(lblNewLabel_1_1_1);
		
		hAddress = new JTextArea();
		hAddress.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		hAddress.setBounds(134, 498, 492, 41);
		contentPane.add(hAddress);
		
		hContact = new JTextArea();
		hContact.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		hContact.setBounds(134, 584, 492, 49);
		contentPane.add(hContact);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Hospital Contact Number:");
		lblNewLabel_1_1_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(134, 549, 492, 41);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Hospital Name:");
		lblNewLabel_1_1_3.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(134, 249, 492, 41);
		contentPane.add(lblNewLabel_1_1_3);
	}
}
