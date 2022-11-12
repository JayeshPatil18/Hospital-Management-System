import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class addNewPatientRecord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox gender;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addNewPatientRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(250, 40, 323, 27);
		contentPane.add(textField);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(115, 90, 106, 27);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(250, 90, 323, 27);
		contentPane.add(textField_1);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNo.setBounds(115, 139, 106, 27);
		contentPane.add(lblContactNo);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(250, 139, 323, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(250, 189, 323, 27);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(115, 189, 106, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(115, 238, 106, 27);
		contentPane.add(lblGender);
		
		String[] str = {"Male", "Female", "Other"};
		gender = new JComboBox(str);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gender.setBounds(250, 238, 323, 27);
		contentPane.add(gender);
		
		JLabel lblNewLabel_1_2 = new JLabel("Glood Group");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(115, 288, 106, 27);
		contentPane.add(lblNewLabel_1_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(250, 288, 323, 27);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Address");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(115, 337, 106, 27);
		contentPane.add(lblNewLabel_2_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(250, 337, 323, 27);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(115, 438, 458, 27);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Any Major Disease Suffered Earlier");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(115, 389, 458, 27);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.setBounds(115, 512, 122, 38);
		contentPane.add(btnSave);
	}
}
