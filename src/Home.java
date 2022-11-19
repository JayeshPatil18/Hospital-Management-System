import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Canvas;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(255, 255, 255));
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 392, 656);
		contentPane.add(contentPane_1);
		
		JButton btnNewButton = new JButton("Add Patient");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 160));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addNewPatientRecord().setVisible(true);
			}
		});
		btnNewButton.setBounds(40, 46, 300, 79);
		contentPane_1.add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Update Patient Record");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdatePatientInfo().setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setBackground(new Color(0, 0, 160));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(40, 303, 300, 79);
		contentPane_1.add(btnNewButton_1_1);
		
		JButton btnAdd = new JButton("Full History of Patients");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new HistoryOfPatients().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setBackground(new Color(0, 0, 160));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(40, 176, 300, 79);
		contentPane_1.add(btnAdd);
		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"Do you really want to logout?","SELECT", JOptionPane.YES_NO_OPTION);
				if(i == 0) {
					System.exit(0);
				}
			}
		});
		logoutBtn.setForeground(new Color(0, 0, 0));
		logoutBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		logoutBtn.setBackground(new Color(0, 0, 160));
		logoutBtn.setBounds(40, 556, 150, 61);
		contentPane_1.add(logoutBtn);
		
		JButton btnHospitalInformation = new JButton("Hospital Information");
		btnHospitalInformation.setForeground(new Color(0, 0, 0));
		btnHospitalInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHospitalInformation.setBackground(new Color(0, 0, 160));
		btnHospitalInformation.setBounds(40, 431, 300, 79);
		contentPane_1.add(btnHospitalInformation);
		
		JPanel contentPane_1_1 = new JPanel();
		contentPane_1_1.setLayout(null);
		contentPane_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1_1.setBackground(Color.WHITE);
		contentPane_1_1.setBounds(391, 0, 696, 656);
		contentPane.add(contentPane_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jp747\\eclipse-workspace\\Hospital Managment System\\img\\img_1.png"));
		lblNewLabel.setBounds(0, 0, 696, 667);
		contentPane_1_1.add(lblNewLabel);
	}
}
