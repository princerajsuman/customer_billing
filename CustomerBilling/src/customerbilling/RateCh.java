package customerbilling;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class RateCh extends JFrame {

	private JPanel contentPane;
	private JTable table;
	

	
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RateCh frame = new RateCh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RateCh() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 510, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 64, 96));

		JPanel panel = new JPanel();
		panel.setBounds(15, 16, 454, 572);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblRateChart = new JLabel("Rate Chart");
		lblRateChart.setForeground(Color.BLUE);
		lblRateChart.setFont(new Font("Aparajita", Font.BOLD, 50));
		lblRateChart.setBounds(112, 16, 206, 39);
		panel.add(lblRateChart);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 57, 424, 499);
		panel.add(scrollPane);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setForeground(Color.BLACK);

		table.setFont(new Font("Aparajita", Font.BOLD, 18));
		scrollPane.setViewportView(table);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate", "root",
					"Prince@123");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM rate_chart");
			
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
