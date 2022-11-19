import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class addNewPatientRecord extends JFrame {

	private JPanel contentPane;
	private JTextField pId;
	private JTextField pName;
	private JTextField pNo;
	private JTextField pAge;
	private JComboBox pGender;
	private JTextField pBGroup;
	private JTextField pAddress;
	private JTextField pDisease;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addNewPatientRecord frame = new addNewPatientRecord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			};
		});
	}

	/**
	 * Create the frame.
	 */
	public addNewPatientRecord() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(451, 512, 122, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(115, 40, 106, 27);
		contentPane.add(lblNewLabel);
		
		pId = new JTextField();
		pId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pId.setColumns(10);
		pId.setBounds(250, 40, 323, 27);
		contentPane.add(pId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(115, 90, 106, 27);
		contentPane.add(lblName);
		
		pName = new JTextField();
		pName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pName.setColumns(10);
		pName.setBounds(250, 90, 323, 27);
		contentPane.add(pName);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNo.setBounds(115, 139, 106, 27);
		contentPane.add(lblContactNo);
		
		pNo = new JTextField();
		pNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pNo.setColumns(10);
		pNo.setBounds(250, 139, 323, 27);
		contentPane.add(pNo);
		
		pAge = new JTextField();
		pAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pAge.setColumns(10);
		pAge.setBounds(250, 189, 323, 27);
		contentPane.add(pAge);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(115, 189, 106, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(115, 238, 106, 27);
		contentPane.add(lblGender);
		
		String[] str = {"Male", "Female", "Other"};
		pGender = new JComboBox(str);
		pGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pGender.setBounds(250, 238, 323, 27);
		contentPane.add(pGender);
		
		JLabel lblNewLabel_1_2 = new JLabel("Glood Group");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(115, 288, 106, 27);
		contentPane.add(lblNewLabel_1_2);
		
		pBGroup = new JTextField();
		pBGroup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pBGroup.setColumns(10);
		pBGroup.setBounds(250, 288, 323, 27);
		contentPane.add(pBGroup);
		
		JLabel lblNewLabel_2_1 = new JLabel("Address");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(115, 337, 106, 27);
		contentPane.add(lblNewLabel_2_1);
		
		pAddress = new JTextField();
		pAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pAddress.setColumns(10);
		pAddress.setBounds(250, 337, 323, 27);
		contentPane.add(pAddress);
		
		pDisease = new JTextField();
		pDisease.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pDisease.setColumns(10);
		pDisease.setBounds(115, 438, 458, 27);
		contentPane.add(pDisease);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Any Major Disease Suffered Earlier");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(115, 389, 458, 27);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.createCon();
				
				String checkQ = "SELECT COUNT(p_id) FROM patients WHERE p_id = " + pId.getText();
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
					if(pId.getText().equals("0")) {
						JOptionPane.showMessageDialog(null, "Id should not be '0', Please use another Id!");
						isExist = false;
					}else if(rs.getInt(1) != 0) {
						JOptionPane.showMessageDialog(null, "This Id is already in use, Please use another Id!");
						isExist = false;
					}
				} catch (HeadlessException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(isExist) {
						String query = "insert into patients(p_id,p_name,p_no,p_age,p_gender,p_bGroup,p_address,p_disease) values(?,?,?,?,?,?,?,?)";
						try {
							PreparedStatement pstmt = con.prepareStatement(query);
							
							int p_id = Integer.parseInt(pId.getText());
							String p_name = pName.getText();
							String p_no = pName.getText();
							int p_age = Integer.parseInt(pAge.getText());
							String p_gender = String.valueOf(pGender.getSelectedItem());
							String p_bGroup = pBGroup.getText();
							String p_address = pAddress.getText();
							String p_disease = pDisease.getText();
							
							pstmt.setInt(1, p_id);
							pstmt.setString(2, p_name);
							pstmt.setString(3, p_no);
							pstmt.setInt(4, p_age);
							pstmt.setString(5, p_gender);
							pstmt.setString(6, p_bGroup);
							pstmt.setString(7, p_address);
							pstmt.setString(8, p_disease);
							
							pstmt.executeUpdate();
							JOptionPane.showMessageDialog(null, "Patient Added!");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.setBounds(115, 512, 122, 38);
		contentPane.add(btnSave);
	}
}
