import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Project.ConnectionProvider;

import java.awt.BorderLayout;
import javax.swing.JTable;

public class HistoryOfPatients extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private static String h_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryOfPatients frame = new HistoryOfPatients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public HistoryOfPatients(String h_table) {
		this.h_table = h_table;
	}
	
	public HistoryOfPatients() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 717, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		String []col = {};
//		String [][]row = {{"Patient Id","Patient Name","Patient Name","Patient Phone no.","Patient Age","Patient Gender","Patient Blood Group","Patient Address","Patient Disease"},
//				{"Patient Id","Patient Name","Patient Name","Patient Phone no.","Patient Age","Patient Gender","Patient Blood Group","Patient Address","Patient Disease"}};
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Patient Id");
		model.addColumn("Patient Name");
		model.addColumn("Patient Phone no.");
		model.addColumn("Patient Age");
		model.addColumn("Patient Gender");
		model.addColumn("Patient Blood Group");
		model.addColumn("Patient Address");
		model.addColumn("Patient Disease");
		
		String query = "select * from " + h_table;
		Connection con = ConnectionProvider.createCon();
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			String p_id = rs.getString("p_id");
			String p_name = rs.getString("p_name");
			String p_no = rs.getString("p_no");
			String p_age = rs.getString("p_age");
			String p_gender = rs.getString("p_gender");
			String p_bGroup = rs.getString("p_bGroup");
			String p_address = rs.getString("p_address");
			String p_disease = rs.getString("p_disease");
			
			model.addRow(new Object[]{p_id,p_name,p_no,p_age,p_gender,p_bGroup,p_address,p_disease});
		}
		
		
		
		table = new JTable(model);
		table.enable(false);
		
		JScrollPane sp = new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
	}

}
