import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HospitalInfo extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private static JPasswordField password;
	private static JTextArea hContact;
	private static JTextArea hAddress;
	private static JTextArea hDoctors;
	private static JTextField hName;
	
	private static String h_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HospitalInfo frame = new HospitalInfo();
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
	public HospitalInfo(String h_table) {
		this.h_table = h_table;
	}
	
	public HospitalInfo() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(260,100);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(5, 5, 440, 493);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1);
		contentPane_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 10, 440, 483);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jp747\\eclipse-workspace\\Hospital Managment System\\img\\img_dash1.jpg"));
		contentPane_1.add(lblNewLabel);
		
		hName = new JTextField();
		hName.setFont(new Font("Trajan Pro", Font.BOLD, 28));
		hName.setBounds(468, 22, 492, 49);
		contentPane.add(hName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Our Doctors:");
		lblNewLabel_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(468, 77, 492, 41);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hospital Address:");
		lblNewLabel_1_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(468, 202, 492, 41);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Hospital Contact Number:");
		lblNewLabel_1_1_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(468, 288, 492, 41);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		hDoctors = new JTextArea();
		hDoctors.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		hDoctors.setBounds(468, 116, 492, 76);
		contentPane.add(hDoctors);
		
		hAddress = new JTextArea();
		hAddress.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		hAddress.setBounds(468, 237, 492, 41);
		contentPane.add(hAddress);
		
		hContact = new JTextArea();
		hContact.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		hContact.setBounds(468, 323, 492, 49);
		contentPane.add(hContact);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Hospital Username:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(468, 382, 249, 41);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Hospital Password:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2.setBounds(723, 382, 237, 41);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		JButton lblNewLabel_1_1_1_1_1_1 = new JButton("Save");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE hospitals SET h_name = ?, h_doctors = ?, h_address = ?, h_contact = ?, h_password = ? WHERE h_table = '" + h_table + "'";
				Connection con = ConnectionProvider.createCon();
				PreparedStatement ps = null;
				try {
					ps = con.prepareStatement(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ps.setString(1, hName.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ps.setString(2, hDoctors.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ps.setString(3, hAddress.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ps.setString(4, hContact.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					ps.setString(5, password.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					ps.execute();
					JOptionPane.showMessageDialog(null, "Hospital Details Updated");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(468, 482, 223, 41);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JButton lblNewLabel_1_1_1_1_2_1 = new JButton("Close");
		lblNewLabel_1_1_1_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_2_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2_1.setBounds(723, 482, 241, 41);
		contentPane.add(lblNewLabel_1_1_1_1_2_1);
		
		username = new JTextField(h_table);
		username.setEditable(false);
		username.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		username.setBounds(468, 420, 223, 41);
		contentPane.add(username);
		
		password = new JPasswordField();
		password.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		password.setBounds(723, 420, 237, 41);
		contentPane.add(password);
	

		String query = "select * from hospitals where h_table = '"+ h_table +"'";
		Connection con = ConnectionProvider.createCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs = ps.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		rs.next();
		
		String hName = null;
		try {
			hName = rs.getString("h_name");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String hDoctors = null;
		try {
			hDoctors = rs.getString("h_doctors");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String hAddress = null;
		try {
			hAddress = rs.getString("h_address");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String hContact = null;
		try {
			hContact = rs.getString("h_contact");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String hPassword = null;
		try {
			hPassword = rs.getString("h_password");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HospitalInfo.updateValues(hName, hDoctors, hAddress, hContact, hPassword);
	}
	
	public static void updateValues(String hNameStr, String hDoctorsStr, String hAddressStr, String hContactStr, String passwordStr) {
		hName.setText(hNameStr);
		hDoctors.setText(hDoctorsStr);
		hAddress.setText(hAddressStr);
		hContact.setText(hContactStr);
		password.setText(passwordStr);
	}
}
