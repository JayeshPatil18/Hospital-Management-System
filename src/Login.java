import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JLabel lblPassword;
	private JPasswordField password;
	private JButton btnNewButton;
	private JButton btnClose;
	private JButton btnCreateAccount;
	private JLabel lblWeclomeToHosptial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(135, 123, 106, 32);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		username.setBounds(270, 123, 323, 32);
		contentPane.add(username);
		username.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(135, 194, 106, 32);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setBounds(270, 196, 323, 32);
		password.setColumns(10);
		contentPane.add(password);
		
		btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
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
					if(rs.getInt(1) != 1) {
						JOptionPane.showMessageDialog(null, "Username is not exist!");
						isExist = false;
					}
				} catch (HeadlessException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(isExist) {
						String query = "select * from hospitals where h_username = " + username.getText();
						try {
							PreparedStatement pstmt = con.prepareStatement(query);
							ResultSet rst = pstmt.executeQuery();
							
							rst.next();
							if(rst.getString("h_password").equals(password.getText())) {
								String t_name = "h" + username.getText().toString();
								
								new Home(t_name);
								new Home().setVisible(true);
								
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Wrong Password!");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		btnNewButton.setBounds(342, 294, 106, 32);
		contentPane.add(btnNewButton);
		
		btnClose = new JButton("Close");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(0, 0, 0));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClose.setBounds(493, 292, 100, 34);
		contentPane.add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setForeground(new Color(255, 255, 255));
		btnCreateAccount.setBackground(new Color(0, 0, 0));
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCreateAccount.setBounds(135, 292, 168, 34);
		contentPane.add(btnCreateAccount);
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAccount().setVisible(true);
			}
		});
		
		lblWeclomeToHosptial = new JLabel("Weclome to Hosptial Managment System");
		lblWeclomeToHosptial.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeclomeToHosptial.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		lblWeclomeToHosptial.setBounds(107, 46, 522, 32);
		contentPane.add(lblWeclomeToHosptial);
	}
}
