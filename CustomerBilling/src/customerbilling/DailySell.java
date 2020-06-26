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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DailySell extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField txtSearch;
	private JButton btnSearch1;

	/**
	 * Launch the application.
	 */
	public static void DailyFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DailySell frame = new DailySell();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DailySell() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 778, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0, 64, 96));

		JPanel panel = new JPanel();
		panel.setBounds(15, 16, 726, 572);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblRateChart = new JLabel("Daily Sell Record");
		lblRateChart.setForeground(Color.BLUE);
		lblRateChart.setFont(new Font("Aparajita", Font.BOLD, 40));
		lblRateChart.setBounds(15, 16, 255, 39);
		panel.add(lblRateChart);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 57, 696, 499);
		panel.add(scrollPane);

		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setForeground(Color.BLACK);

		table.setFont(new Font("Aparajita", Font.BOLD, 18));
		scrollPane.setViewportView(table);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root",
					"Prince@123");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM customer_detail");
			
			ResultSet rs = pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JLabel lblSearchBy = new JLabel("Search By ");
			lblSearchBy.setFont(new Font("Aparajita", Font.PLAIN, 24));
			lblSearchBy.setBounds(270, 23, 87, 20);
			panel.add(lblSearchBy);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setForeground(UIManager.getColor("ComboBox.foreground"));
			comboBox.setFont(new Font("Cambria", Font.PLAIN, 14));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"BillNumber", "CustomerName"}));
			comboBox.setBounds(360, 23, 109, 20);
			panel.add(comboBox);
			
			txtSearch = new JTextField();
			txtSearch.setBounds(475, 20, 146, 26);
			panel.add(txtSearch);
			txtSearch.setColumns(10);
			
			btnSearch1 = new JButton("Search");
			btnSearch1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root","Prince@123");
					
					String selection = (String)comboBox.getSelectedItem();
					String query = "SELECT * from customer_detail where "+selection+" = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, txtSearch.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch (Exception p) {
						p.printStackTrace();
					}
				}
			});
			btnSearch1.setBounds(632, 22, 80, 25);
			panel.add(btnSearch1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}