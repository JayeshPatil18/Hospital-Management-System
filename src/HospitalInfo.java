import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HospitalInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
	public HospitalInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(5, 5, 440, 493);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1);
		contentPane_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 10, 440, 483);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jp747\\eclipse-workspace\\Hospital Managment System\\img\\img_dash1.jpg"));
		contentPane_1.add(lblNewLabel);
		
		JTextField lblNewLabel_1 = new JTextField("Hospital Name");
		lblNewLabel_1.setFont(new Font("Trajan Pro", Font.BOLD, 28));
		lblNewLabel_1.setBounds(468, 22, 492, 49);
		contentPane.add(lblNewLabel_1);
		
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
		
		JTextArea lblNewLabel_1_1_2 = new JTextArea();
		lblNewLabel_1_1_2.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(468, 116, 492, 76);
		contentPane.add(lblNewLabel_1_1_2);
		
		JTextArea lblNewLabel_1_1_2_1 = new JTextArea();
		lblNewLabel_1_1_2_1.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		lblNewLabel_1_1_2_1.setBounds(468, 237, 492, 41);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		JTextArea lblNewLabel_1_1_2_1_1 = new JTextArea();
		lblNewLabel_1_1_2_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 20));
		lblNewLabel_1_1_2_1_1.setBounds(468, 323, 492, 49);
		contentPane.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Hospital Username:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(468, 382, 249, 41);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Hospital Password:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2.setBounds(723, 382, 237, 41);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		JButton lblNewLabel_1_1_1_1_1_1 = new JButton("Save");
		lblNewLabel_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(468, 482, 223, 41);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JButton lblNewLabel_1_1_1_1_2_1 = new JButton("Close");
		lblNewLabel_1_1_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2_1.setBounds(723, 482, 241, 41);
		contentPane.add(lblNewLabel_1_1_1_1_2_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		textField.setBounds(468, 420, 223, 41);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Trajan Pro", Font.BOLD, 15));
		passwordField.setBounds(723, 420, 237, 41);
		contentPane.add(passwordField);
	}
}
