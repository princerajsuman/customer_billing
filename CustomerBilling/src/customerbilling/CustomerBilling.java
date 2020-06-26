package customerbilling;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.*;

class RateElement {
	ArrayList<Integer> rate = new ArrayList<Integer>();

	public RateElement() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate", "root", "Prince@123");
			PreparedStatement pst = con.prepareStatement("SELECT Price FROM rate_chart");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				rate.add(rs.getInt(1));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

@SuppressWarnings("serial")
public class CustomerBilling extends JFrame {
//	public void Show(Integer a) {
//		System.out.println();
//	}
	static RateElement r = new RateElement();

	int priceOfGb = r.rate.get(0);
	int priceOfGs = r.rate.get(1);
	int priceOfGm = r.rate.get(2);
	int priceOfOr = r.rate.get(3);
	int priceOfMb = r.rate.get(4);
	int priceOfCw = r.rate.get(5);
	int priceOfPs = r.rate.get(6);
	int priceOfMl = r.rate.get(7);
	int priceOfGc = r.rate.get(8);
	int priceOfKp = r.rate.get(9);
	int priceOfLc = r.rate.get(10);
	int priceOfGv = r.rate.get(11);
	int priceOfChapati = r.rate.get(12);
	int priceOfRice = r.rate.get(13);
	int priceOfMw = r.rate.get(14);
	int priceOfCoke = r.rate.get(15);
	int priceOfOj = r.rate.get(16);
	int priceOfCoffee = r.rate.get(17);
	int priceOfCc = r.rate.get(18);
	int priceOfIc = r.rate.get(19);
	int priceOfFs = r.rate.get(20);

	private JPanel contentPane;
	private JTextField txtGb;
	private JTextField txtGs;
	private JTextField txtGm;
	private JTextField txtOr;
	private JTextField txtMb;
	private JTextField txtCw;
	private JTextField txtPs;
	private JTextField txtMl;
	private JTextField txtGc;
	private JTextField txtKp;
	private JTextField txtLc;
	private JTextField txtGv;
	private JTextField txtChapati;
	private JTextField txtRice;
	private JTextField txtMw;
	private JTextField txtCoke;
	private JTextField txtOj;
	private JTextField txtCoffee;
	private JTextField txtCc;
	private JTextField txtIc;
	private JTextField txtFs;
	private JTextField txtName;
	private JTextField txtTotal;
	private JTextField txtNumber;
	private JTextField txtBill;
	private JTextField txtCostsum;
	private JTextArea textArea;
	private JLabel lbDate;
	private JLabel lbTime;
	String Date1;
	String Time1;
	private JRadioButton online;
	private JRadioButton cash;
	static int BillNum = (int) (10000000 * Math.random());
	private JLabel txtlabelBill;
	public void Clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while (true) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);

						int sec = cal.get(Calendar.SECOND);
						int min = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);

						lbDate.setText("" + day + "/" + month + "/" + year);
						lbTime.setText("" + hour + ":" + min + ":" + sec);
						Date1 = "" + day + "/" + month + "/" + year;
						Time1 = "" + hour + ":" + min + ":" + sec;
						sleep(1000);

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();

	}

	public JRadioButton Radio() {
		if (online.isSelected()) {
			return online;
		} else {
			return cash;
		}
	}

//	 Create the frame.

	public CustomerBilling() {

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
//		contentPane.setToolTipText("Billing Software");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

// 		for always maximized windows	
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
		this.setExtendedState(this.getExtendedState() | Frame.MAXIMIZED_BOTH);

//		setting bounds of frame
		setBounds(0, 0, 1280, 760);
		setTitle("Billng Services");
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/icons/p21.png"));
		setIconImage(icon1.getImage());

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('N');
		mnFile.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnFile);

		JMenuItem rateChart = new JMenuItem("Rate Chart");
		rateChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RateCh.NewScreen();
			}
		});
		mnFile.add(rateChart);

		JMenuItem dailySell = new JMenuItem("Daily Sell ");
		dailySell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DailySell.DailyFrame();
			}
		});
		mnFile.add(dailySell);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem editRate = new JMenuItem("Edit Rate ");
		mnEdit.add(editRate);

		JMenu mnContactUs = new JMenu("Contact us");
		menuBar.add(mnContactUs);

		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mnContactUs.add(mntmAboutUs);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 50, 70));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(0, 64, 96));
		panel_1.setBounds(10, 7, 1233, 50);
		panel.add(panel_1);

		JLabel lblBillingSoftware = new JLabel("Billing Software");
		lblBillingSoftware.setBounds(450, 2, 238, 38);
		lblBillingSoftware.setFont(new Font("Century751 No2 BT", Font.BOLD | Font.ITALIC, 30));
		lblBillingSoftware.setForeground(new Color(255, 255, 0));
		panel_1.setLayout(null);

		JLabel lblDate = new JLabel("Date : ");
		lblDate.setFont(new Font("Aparajita", Font.BOLD, 24));
		lblDate.setForeground(Color.YELLOW);
		lblDate.setBounds(821, 15, 60, 20);
		panel_1.add(lblDate);
		panel_1.add(lblBillingSoftware);

		JLabel lblDate_1 = new JLabel("Time : ");
		lblDate_1.setForeground(Color.YELLOW);
		lblDate_1.setFont(new Font("Aparajita", Font.BOLD, 24));
		lblDate_1.setBounds(1034, 14, 60, 20);
		panel_1.add(lblDate_1);

		lbDate = new JLabel("Clock");

		lbDate.setForeground(Color.YELLOW);
		lbDate.setFont(new Font("Aparajita", Font.BOLD, 24));
		lbDate.setBounds(885, 12, 132, 28);
		panel_1.add(lbDate);

		lbTime = new JLabel("Time");

		lbTime.setForeground(Color.YELLOW);
		lbTime.setFont(new Font("Aparajita", Font.BOLD, 24));
		lbTime.setBounds(1091, 10, 127, 28);
		panel_1.add(lbTime);

		JLabel lblBillNumber_1 = new JLabel("Bill Number :");
		lblBillNumber_1.setForeground(Color.YELLOW);
		lblBillNumber_1.setFont(new Font("Aparajita", Font.BOLD, 24));
		lblBillNumber_1.setBounds(31, 15, 114, 20);
		panel_1.add(lblBillNumber_1);

		txtlabelBill = new JLabel("");
		txtlabelBill.setForeground(Color.YELLOW);
		txtlabelBill.setFont(new Font("Aparajita", Font.BOLD, 24));
		txtlabelBill.setBounds(160, 16, 173, 20);
		panel_1.add(txtlabelBill);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Details", TitledBorder.LEFT,
						TitledBorder.TOP, null, new Color(255, 255, 0))));
		panel_2.setBackground(new Color(0, 64, 96));
		panel_2.setBounds(10, 67, 1233, 74);
		panel.add(panel_2);

		JLabel lblCustomerName = new JLabel("Customer Name*");
		lblCustomerName.setForeground(Color.WHITE);
		lblCustomerName.setFont(new Font("Aparajita", Font.BOLD, 26));

		JLabel lblContactNumber = new JLabel("Mobile Number");
		lblContactNumber.setForeground(Color.WHITE);
		lblContactNumber.setFont(new Font("Aparajita", Font.BOLD, 26));

		JLabel lblBillNumber = new JLabel("Bill Number");
		lblBillNumber.setForeground(Color.WHITE);
		lblBillNumber.setFont(new Font("Aparajita", Font.BOLD, 24));

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root",
							"Prince@123");
					String query = "SELECT CustomerName, CustomerMobile from customer_detail where BillNumber = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, txtBill.getText());
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						txtBill.setText("");
						JOptionPane.showMessageDialog(null, "Yes, Bill Number Found in Database");
					} else {
						txtBill.setText("");
						JOptionPane.showMessageDialog(null, "No, Bill Number not Found in Database");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSearch.setToolTipText("Click to Search");
		btnSearch.setForeground(new Color(0, 0, 0));

		btnSearch.setFont(new Font("Cambria", Font.PLAIN, 20));

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtName.getText();
				char c = e.getKeyChar();
				if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}
			}
		});
		txtName.setToolTipText("Enter Bill Number");
		txtName.setColumns(30);

		txtNumber = new JTextField();
		txtNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String mNumber = txtNumber.getText();
				int Length = mNumber.length();
				char c = e.getKeyChar();
				if (Length >= 10 || !Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}
			}
		});
		txtNumber.setToolTipText("Enter Bill Number");
		txtNumber.setColumns(10);

		txtBill = new JTextField();
		txtBill.setToolTipText("Enter Bill Number");
		txtBill.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addGap(6).addComponent(lblCustomerName).addGap(11)
				.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblContactNumber, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE).addGap(7)
				.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(lblBillNumber, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(txtBill, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE).addComponent(btnSearch).addGap(39)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCustomerName, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
						.addGap(15))
				.addGroup(gl_panel_2.createSequentialGroup().addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContactNumber, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBillNumber, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBill, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Billing Menu", TitledBorder.LEFT,
						TitledBorder.TOP, null, new Color(255, 255, 0))));
		panel_3.setBackground(new Color(0, 64, 96));
		panel_3.setBounds(10, 512, 1233, 114);
		panel.add(panel_3);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(317, 25, 62, 33);
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Aparajita", Font.BOLD, 28));

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(597, 30, 621, 68);

		panel_3.setLayout(null);
		panel_3.add(lblTotal);
		panel_3.add(panel_5);
		panel_5.setLayout(null);

		JButton btnTotal = new JButton("Total");
		btnTotal.setToolTipText("Total Amount to be Paid");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Integer costGb = priceOfGb * Integer.parseInt(txtGb.getText());
					Integer costGs = priceOfGs * Integer.parseInt(txtGs.getText());
					Integer costGm = priceOfGm * Integer.parseInt(txtGm.getText());
					Integer costOr = priceOfOr * Integer.parseInt(txtOr.getText());
					Integer costMb = priceOfMb * Integer.parseInt(txtMb.getText());
					Integer costCw = priceOfCw * Integer.parseInt(txtCw.getText());
					Integer costPs = priceOfPs * Integer.parseInt(txtPs.getText());
					Integer costMl = priceOfMl * Integer.parseInt(txtMl.getText());
					Integer costGc = priceOfGc * Integer.parseInt(txtGc.getText());
					Integer costKp = priceOfKp * Integer.parseInt(txtKp.getText());
					Integer costLc = priceOfLc * Integer.parseInt(txtLc.getText());
					Integer costGv = priceOfGv * Integer.parseInt(txtGv.getText());
					Integer costChapati = priceOfChapati * Integer.parseInt(txtChapati.getText());
					Integer costRice = priceOfRice * Integer.parseInt(txtRice.getText());
					Integer costMw = priceOfMw * Integer.parseInt(txtMw.getText());
					Integer costCoke = priceOfCoke * Integer.parseInt(txtCoke.getText());
					Integer costOj = priceOfOj * Integer.parseInt(txtOj.getText());
					Integer costCoffee = priceOfCoffee * Integer.parseInt(txtCoffee.getText());
					Integer costCc = priceOfCc * Integer.parseInt(txtCc.getText());
					Integer costIc = priceOfIc * Integer.parseInt(txtIc.getText());
					Integer costFs = priceOfFs * Integer.parseInt(txtFs.getText());

					Integer TotalCost = costGb + costGs + costGm + costOr + costMb + costPs +costCw+ costMl + costGc + costKp + costLc
							+ costGv + costChapati + costRice + costMw + costCoke + costOj + costCoffee + costCc + costIc
							+ costFs;
					txtCostsum.setText("" + TotalCost);
					Float GST = (Float)(TotalCost * 0.05f);
					Float GSTTotal = (Float)(TotalCost + GST);
					txtTotal.setText(""+GSTTotal);
					}
					catch (Exception r) {
						r.printStackTrace();
					}
			}
		});
		btnTotal.setFont(new Font("Schadow BT", Font.PLAIN, 24));
		btnTotal.setBounds(15, 17, 90, 39);
		panel_5.add(btnTotal);

		JButton btnGenerateBill = new JButton("Generate Bill");

		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					++BillNum;
					txtlabelBill.setText("" + BillNum);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root",
							"Prince@123");
					java.util.Date date = new java.util.Date();
					long num = date.getTime();
					java.sql.Timestamp sqldate = new java.sql.Timestamp(num);
					PreparedStatement ps = con.prepareStatement(
							"insert into customer_detail(BillNumber, CustomerName, CustomerMobile, TotalPurchase, Date_Time) values(?,?,?,?,?)");
					ps.setString(1, "" + BillNum);
					ps.setString(2, txtName.getText());
					ps.setString(3, txtNumber.getText());
					if(txtTotal.getText() == "0") {
						JOptionPane.showMessageDialog(null, "No food items are selected !");
					}
					else {
					ps.setString(4, txtTotal.getText());
					}
					ps.setTimestamp(5, sqldate);
					ps.executeUpdate();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
		
				
				Integer costGb = priceOfGb * Integer.parseInt(txtGb.getText());
				Integer costGs = priceOfGs * Integer.parseInt(txtGs.getText());
				Integer costGm = priceOfGm * Integer.parseInt(txtGm.getText());
				Integer costOr = priceOfOr * Integer.parseInt(txtOr.getText());
				Integer costMb = priceOfMb * Integer.parseInt(txtMb.getText());
				Integer costCw = priceOfCw * Integer.parseInt(txtCw.getText());
				Integer costPs = priceOfPs * Integer.parseInt(txtPs.getText());
				Integer costMl = priceOfMl * Integer.parseInt(txtMl.getText());
				Integer costGc = priceOfGc * Integer.parseInt(txtGc.getText());
				Integer costKp = priceOfKp * Integer.parseInt(txtKp.getText());
				Integer costLc = priceOfLc * Integer.parseInt(txtLc.getText());
				Integer costGv = priceOfGv * Integer.parseInt(txtGv.getText());
				Integer costChapati = priceOfChapati * Integer.parseInt(txtChapati.getText());
				Integer costRice = priceOfRice * Integer.parseInt(txtRice.getText());
				Integer costMw = priceOfMw * Integer.parseInt(txtMw.getText());
				Integer costCoke = priceOfCoke * Integer.parseInt(txtCoke.getText());
				Integer costOj = priceOfOj * Integer.parseInt(txtOj.getText());
				Integer costCoffee = priceOfCoffee * Integer.parseInt(txtCoffee.getText());
				Integer costCc = priceOfCc * Integer.parseInt(txtCc.getText());
				Integer costIc = priceOfIc * Integer.parseInt(txtIc.getText());
				Integer costFs = priceOfFs * Integer.parseInt(txtFs.getText());
				Integer TotalCost = costGb + costGs + costGm + costOr + costMb + costPs +costCw+ costMl + costGc + costKp + costLc
						+ costGv + costChapati + costRice + costMw + costCoke + costOj + costCoffee + costCc + costIc
						+ costFs;
				Float GST = (Float)(TotalCost * 0.05f);
				Float GSTTotal = (Float)(TotalCost + GST);
				
				textArea.setFont(new Font("Schadow BT", Font.PLAIN, 12));
				textArea.append("\tPrince Restaurant\n\n" + "  Date :" + Date1 + "\t" + "        Time :" + Time1 + "\n"
						+ " Customer Name :" + "               " + txtName.getText() + "\n" + "  Bill No. :" + BillNum
						+ "" + "              Payment Mode : " + Radio().getText()
						+ "\n------------------------------------------------------------------\n"
						+"  Food item\t                qty\t                      Price"+"\n"

				);
				if(Integer.parseInt(txtGb.getText())>0) {
		textArea.append("Garlic Bread  "+"\t                  "+txtGb.getText()+"\t                       "+costGb+"\n");
				}
				if(Integer.parseInt(txtGs.getText())>0) {
		textArea.append("Garlic Salad "+"\t                  "+txtGs.getText()+"\t                       "+costGs+"\n");
				}
				if(Integer.parseInt(txtGm.getText())>0) {
		textArea.append("Grilled Mushrooms  "+"         "+txtGm.getText()+"\t                       "+costGm+"\n");
				}
				if(Integer.parseInt(txtOr.getText())>0) {
		textArea.append("Onion Ring  "+"\t                  "+txtOr.getText()+"\t                       "+costOr+"\n");
				}
				if(Integer.parseInt(txtMb.getText())>0) {
		textArea.append("Meatballs  "+"\t                  "+txtMb.getText()+"\t                       "+costMb+"\n");
				}
				if(Integer.parseInt(txtCw.getText())>0) {
		textArea.append("Chicken Wings "+"                  "+txtCw.getText()+"\t                       "+costCw+"\n");
				}
				if(Integer.parseInt(txtPs.getText())>0) {
		textArea.append("Pasta Salad  "+"\t                  "+txtPs.getText()+"\t                        "+costPs+"\n");
				}
				if(Integer.parseInt(txtMl.getText())>0) {
		textArea.append("Meatloaf  "+"\t                  "+txtMl.getText()+"\t                       "+costMl+"\n");
				}
				if(Integer.parseInt(txtGc.getText())>0) {
		textArea.append("Grilled Chicken  "+"                "+txtGc.getText()+"\t                       "+costGc+"\n");
				}
				if(Integer.parseInt(txtKp.getText())>0) {
		textArea.append("King Prawns  "+"\t                  "+txtKp.getText()+"\t                       "+costKp+"\n");
				}
				if(Integer.parseInt(txtLc.getText())>0) {
		textArea.append("Lamb Chops "+"\t                  "+txtLc.getText()+"\t                       "+costLc+"\n");
				}
				if(Integer.parseInt(txtGv.getText())>0) {
		textArea.append("Grilled Vegetables  "+"           "+txtGv.getText()+"\t                       "+costGv+"\n");
				}
				if(Integer.parseInt(txtChapati.getText())>0) {
		textArea.append("Chapati  "+"\t                  "+txtChapati.getText()+"\t                       "+costChapati+"\n");
				}
				if(Integer.parseInt(txtRice.getText())>0) {
		textArea.append("Rice  "+"\t                  "+txtRice.getText()+"\t                       "+costRice+"\n");
				}
				if(Integer.parseInt(txtMw.getText())>0) {
		textArea.append("Mineral Water  "+"                  "+txtMw.getText()+"\t                       "+costMw+"\n");
				}
				if(Integer.parseInt(txtCoke.getText())>0) {
		textArea.append("Coke/Fanta/Sprite  "+"           "+txtCoke.getText()+"\t                       "+costCoke+"\n");
				}
				if(Integer.parseInt(txtOj.getText())>0) {
		textArea.append("Orange Juice  "+"\t                  "+txtOj.getText()+"\t                       "+costOj+"\n");
				}
				if(Integer.parseInt(txtCoffee.getText())>0) {
		textArea.append("Coffee  "+"\t                  "+txtCoffee.getText()+"\t                       "+costCoffee+"\n");
				}
				if(Integer.parseInt(txtCc.getText())>0) {
		textArea.append("Chocolate Cake  "+"                "+txtCc.getText()+"\t                       "+costCc+"\n");
				}
				if(Integer.parseInt(txtIc.getText())>0) {
		textArea.append("Ice Cream  "+"\t                  "+txtIc.getText()+"\t                       "+costIc+"\n");
				}
				if(Integer.parseInt(txtFs.getText())>0) {
		textArea.append("Fruit Salad  "+"\t                  "+txtFs.getText()+"\t                       "+costFs+"\n");
				}
		textArea.append("--------------------------------------------------------------------\n");	
		textArea.append("\t                                     Cost = "+ TotalCost +"\n");
		textArea.append("  \t                                     GST = "+ GST +"\n");
		textArea.append("--------------------------------------------------------------------\n");
		textArea.append("  \t                                  Total = "+ GSTTotal +"\n");
		textArea.append("--------------------------------------------------------------------\n");
		textArea.append("                                 Thank You");
			}
		});

		btnGenerateBill.setFont(new Font("Schadow BT", Font.PLAIN, 22));
		btnGenerateBill.setBounds(120, 17, 169, 39);
		panel_5.add(btnGenerateBill);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtNumber.setText("");
				txtBill.setText("");
				txtCc.setText("0");
				txtChapati.setText("0");
				txtCoffee.setText("0");
				txtCoke.setText("0");
				txtCostsum.setText("0");
				txtCw.setText("0");
				txtFs.setText("0");
				txtGb.setText("0");
				txtGc.setText("0");
				txtGm.setText("0");
				txtGs.setText("0");
				txtGv.setText("0");
				txtIc.setText("0");
				txtKp.setText("0");
				txtLc.setText("0");
				txtMb.setText("0");
				txtMl.setText("0");
				txtMw.setText("0");
				txtOj.setText("0");
				txtOr.setText("0");
				txtPs.setText("0");
				txtRice.setText("0");
				txtTotal.setText("0");
				textArea.setText("");

			}
		});
		btnClear.setFont(new Font("Schadow BT", Font.PLAIN, 24));
		btnClear.setBounds(304, 16, 90, 40);
		panel_5.add(btnClear);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setFont(new Font("Schadow BT", Font.PLAIN, 24));
		btnPrint.setBounds(409, 16, 90, 40);
		panel_5.add(btnPrint);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Schadow BT", Font.PLAIN, 24));
		btnExit.setBounds(514, 16, 90, 40);
		panel_5.add(btnExit);

		JLabel lblTax = new JLabel("GST ");
		lblTax.setForeground(Color.WHITE);
		lblTax.setFont(new Font("Aparajita", Font.BOLD, 28));
		lblTax.setBounds(24, 70, 81, 33);
		panel_3.add(lblTax);

		txtTotal = new JTextField();
		txtTotal.setText("0");
		txtTotal.setToolTipText("Enter Bill Number");
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(298, 56, 98, 42);

		panel_3.add(txtTotal);

		JLabel lblTotalSum = new JLabel("Cost Sum");
		lblTotalSum.setForeground(Color.WHITE);
		lblTotalSum.setFont(new Font("Aparajita", Font.BOLD, 28));
		lblTotalSum.setBounds(24, 30, 107, 33);
		panel_3.add(lblTotalSum);

		txtCostsum = new JTextField();
		txtCostsum.setText("0");
		txtCostsum.setEditable(false);
		txtCostsum.setToolTipText("Enter Bill Number");
		txtCostsum.setColumns(10);
		txtCostsum.setBounds(130, 32, 152, 26);
		panel_3.add(txtCostsum);

		JLabel lblPaymentMode = new JLabel("Payment Mode");
		lblPaymentMode.setForeground(Color.WHITE);
		lblPaymentMode.setFont(new Font("Aparajita", Font.BOLD, 28));
		lblPaymentMode.setBounds(417, 25, 159, 33);
		panel_3.add(lblPaymentMode);

		cash = new JRadioButton("Cash");
		cash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cash.isSelected()) {
					online.setSelected(false);
				}
			}
		});
		cash.setFont(new Font("Aparajita", Font.BOLD, 26));
		cash.setForeground(Color.WHITE);
		cash.setBackground(new Color(0, 64, 96));
		cash.setBounds(410, 63, 88, 28);
		panel_3.add(cash);

		online = new JRadioButton("Online");
		online.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (online.isSelected()) {
					cash.setSelected(false);
				}
			}
		});
		online.setFont(new Font("Aparajita", Font.PLAIN, 26));
		online.setForeground(Color.WHITE);
		online.setBackground(new Color(0, 64, 96));
		online.setBounds(495, 63, 88, 28);
		panel_3.add(online);
		
		JFormattedTextField txtGST = new JFormattedTextField(java.text.NumberFormat.getPercentInstance());
		txtGST.setValue(0.05);
		txtGST.setBounds(130, 72, 152, 26);
		panel_3.add(txtGST);

		JPanel starter = new JPanel();
		starter.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Starter", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(255, 255, 0))));
		starter.setBounds(10, 151, 297, 352);
		starter.setBackground(new Color(0, 64, 96));
		panel.add(starter);
		starter.setLayout(null);

		JLabel lblGarliicBread = new JLabel("Garliic Bread");
		lblGarliicBread.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblGarliicBread.setForeground(Color.WHITE);
		lblGarliicBread.setBounds(15, 30, 149, 30);
		starter.add(lblGarliicBread);

		txtGb = new JTextField();
		txtGb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}

			}

		});
		txtGb.setText("0");
		txtGb.setToolTipText("Enter quantity");
		txtGb.setBounds(214, 31, 68, 26);
		starter.add(txtGb);
		txtGb.setColumns(10);

		JLabel lblGreenSalad = new JLabel("Green Salad");
		lblGreenSalad.setForeground(Color.WHITE);
		lblGreenSalad.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblGreenSalad.setBounds(15, 76, 149, 30);
		starter.add(lblGreenSalad);

		txtGs = new JTextField();
		txtGs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}
			}
		});
		txtGs.setText("0");
		txtGs.setToolTipText("Enter quantity");
		txtGs.setColumns(10);
		txtGs.setBounds(214, 77, 68, 26);
		starter.add(txtGs);

		JLabel lblGrilledMushrooms = new JLabel("Grilled Mushrooms");
		lblGrilledMushrooms.setForeground(Color.WHITE);
		lblGrilledMushrooms.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblGrilledMushrooms.setBounds(15, 122, 184, 30);
		starter.add(lblGrilledMushrooms);

		txtGm = new JTextField();
		txtGm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtGm.setText("0");
		txtGm.setToolTipText("Enter quantity");
		txtGm.setColumns(10);
		txtGm.setBounds(214, 123, 68, 26);
		starter.add(txtGm);

		JLabel lblOnionRing = new JLabel("Onion Ring");
		lblOnionRing.setForeground(Color.WHITE);
		lblOnionRing.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblOnionRing.setBounds(15, 168, 149, 30);
		starter.add(lblOnionRing);

		txtOr = new JTextField();
		txtOr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtOr.setText("0");
		txtOr.setToolTipText("Enter quantity");
		txtOr.setColumns(10);
		txtOr.setBounds(214, 169, 68, 26);
		starter.add(txtOr);

		JLabel lblVegetableSoup = new JLabel("Meatballs");
		lblVegetableSoup.setForeground(Color.WHITE);
		lblVegetableSoup.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblVegetableSoup.setBounds(15, 214, 149, 30);
		starter.add(lblVegetableSoup);

		txtMb = new JTextField();
		txtMb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtMb.setText("0");
		txtMb.setToolTipText("Enter quantity");
		txtMb.setColumns(10);
		txtMb.setBounds(214, 215, 68, 26);
		starter.add(txtMb);

		JLabel lblOnionRings = new JLabel("Chicken Wings");
		lblOnionRings.setForeground(Color.WHITE);
		lblOnionRings.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblOnionRings.setBounds(15, 260, 149, 30);
		starter.add(lblOnionRings);

		txtCw = new JTextField();
		txtCw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtCw.setText("0");
		txtCw.setToolTipText("Enter quantity");
		txtCw.setColumns(10);
		txtCw.setBounds(214, 261, 68, 26);
		starter.add(txtCw);

		JLabel lblPastaSalad = new JLabel("Pasta Salad");
		lblPastaSalad.setForeground(Color.WHITE);
		lblPastaSalad.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblPastaSalad.setBounds(15, 306, 149, 30);
		starter.add(lblPastaSalad);

		txtPs = new JTextField();
		txtPs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtPs.setText("0");
		txtPs.setToolTipText("Enter quantity");
		txtPs.setColumns(10);
		txtPs.setBounds(214, 307, 68, 26);
		starter.add(txtPs);

		JPanel mainCourses = new JPanel();
		mainCourses.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Main Courses/Side Dishes",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 0))));
		mainCourses.setBounds(320, 151, 297, 352);
		mainCourses.setBackground(new Color(0, 64, 96));
		panel.add(mainCourses);
		mainCourses.setLayout(null);

		JLabel lblMeatloaf = new JLabel("Meatloaf");
		lblMeatloaf.setForeground(Color.WHITE);
		lblMeatloaf.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblMeatloaf.setBounds(15, 30, 149, 30);
		mainCourses.add(lblMeatloaf);

		txtMl = new JTextField();
		txtMl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtMl.setText("0");
		txtMl.setToolTipText("Enter quantity");
		txtMl.setColumns(10);
		txtMl.setBounds(214, 31, 68, 26);
		mainCourses.add(txtMl);

		JLabel lblGrilledChicken = new JLabel("Grilled Chicken");
		lblGrilledChicken.setForeground(Color.WHITE);
		lblGrilledChicken.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblGrilledChicken.setBounds(15, 76, 149, 30);
		mainCourses.add(lblGrilledChicken);

		txtGc = new JTextField();
		txtGc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtGc.setText("0");
		txtGc.setToolTipText("Enter quantity");
		txtGc.setColumns(10);
		txtGc.setBounds(214, 77, 68, 26);
		mainCourses.add(txtGc);

		JLabel lblKingPrawns = new JLabel("King Prawns");
		lblKingPrawns.setForeground(Color.WHITE);
		lblKingPrawns.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblKingPrawns.setBounds(15, 122, 149, 30);
		mainCourses.add(lblKingPrawns);

		txtKp = new JTextField();
		txtKp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtKp.setText("0");
		txtKp.setToolTipText("Enter quantity");
		txtKp.setColumns(10);
		txtKp.setBounds(214, 123, 68, 26);
		mainCourses.add(txtKp);

		JLabel lblLambChops = new JLabel("Lamb Chops");
		lblLambChops.setForeground(Color.WHITE);
		lblLambChops.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblLambChops.setBounds(15, 168, 149, 30);
		mainCourses.add(lblLambChops);

		txtLc = new JTextField();
		txtLc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtLc.setText("0");
		txtLc.setToolTipText("Enter quantity");
		txtLc.setColumns(10);
		txtLc.setBounds(214, 169, 68, 26);
		mainCourses.add(txtLc);

		JLabel lblRice = new JLabel("Grilled Vegetables");
		lblRice.setForeground(Color.WHITE);
		lblRice.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblRice.setBounds(15, 214, 167, 30);
		mainCourses.add(lblRice);

		txtGv = new JTextField();
		txtGv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtGv.setText("0");
		txtGv.setToolTipText("Enter quantity");
		txtGv.setColumns(10);
		txtGv.setBounds(214, 215, 68, 26);
		mainCourses.add(txtGv);

		JLabel lblChapati = new JLabel("Chapati");
		lblChapati.setForeground(Color.WHITE);
		lblChapati.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblChapati.setBounds(15, 260, 149, 30);
		mainCourses.add(lblChapati);

		txtChapati = new JTextField();
		txtChapati.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtChapati.setText("0");
		txtChapati.setToolTipText("Enter quantity");
		txtChapati.setColumns(10);
		txtChapati.setBounds(214, 261, 68, 26);
		mainCourses.add(txtChapati);

		JLabel lblRice_1 = new JLabel("Rice");
		lblRice_1.setForeground(Color.WHITE);
		lblRice_1.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblRice_1.setBounds(15, 306, 149, 30);
		mainCourses.add(lblRice_1);

		txtRice = new JTextField();
		txtRice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtRice.setText("0");
		txtRice.setToolTipText("Enter quantity");
		txtRice.setColumns(10);
		txtRice.setBounds(214, 307, 68, 26);
		mainCourses.add(txtRice);

		JPanel drinks = new JPanel();
		drinks.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Desserts/Drinks", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(255, 255, 0))));
		drinks.setBounds(631, 151, 297, 352);
		drinks.setBackground(new Color(0, 64, 96));
		panel.add(drinks);
		drinks.setLayout(null);

		JLabel lblMineralWater = new JLabel("Mineral Water");
		lblMineralWater.setForeground(Color.WHITE);
		lblMineralWater.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblMineralWater.setBounds(15, 30, 149, 30);
		drinks.add(lblMineralWater);

		txtMw = new JTextField();
		txtMw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtMw.setText("0");
		txtMw.setToolTipText("Enter quantity");
		txtMw.setColumns(10);
		txtMw.setBounds(214, 31, 68, 26);
		drinks.add(txtMw);

		JLabel lblCokeFantaSprite = new JLabel("Coke/Fanta/Sprite");
		lblCokeFantaSprite.setForeground(Color.WHITE);
		lblCokeFantaSprite.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblCokeFantaSprite.setBounds(15, 76, 168, 30);
		drinks.add(lblCokeFantaSprite);

		txtCoke = new JTextField();
		txtCoke.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtCoke.setText("0");
		txtCoke.setToolTipText("Enter quantity");
		txtCoke.setColumns(10);
		txtCoke.setBounds(214, 77, 68, 26);
		drinks.add(txtCoke);

		JLabel lblJuiceorange = new JLabel("Orange Juice");
		lblJuiceorange.setForeground(Color.WHITE);
		lblJuiceorange.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblJuiceorange.setBounds(15, 122, 149, 30);
		drinks.add(lblJuiceorange);

		txtOj = new JTextField();
		txtOj.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtOj.setText("0");
		txtOj.setToolTipText("Enter quantity");
		txtOj.setColumns(10);
		txtOj.setBounds(214, 123, 68, 26);
		drinks.add(txtOj);

		JLabel lblCoffee = new JLabel("Coffee");
		lblCoffee.setForeground(Color.WHITE);
		lblCoffee.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblCoffee.setBounds(15, 168, 149, 30);
		drinks.add(lblCoffee);

		txtCoffee = new JTextField();
		txtCoffee.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {

					e.consume();
				}
			}
		});
		txtCoffee.setText("0");
		txtCoffee.setToolTipText("Enter quantity");
		txtCoffee.setColumns(10);
		txtCoffee.setBounds(214, 169, 68, 26);
		drinks.add(txtCoffee);

		JLabel lblChocolateCake = new JLabel("Chocolate Cake");
		lblChocolateCake.setForeground(Color.WHITE);
		lblChocolateCake.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblChocolateCake.setBounds(15, 214, 149, 30);
		drinks.add(lblChocolateCake);

		txtCc = new JTextField();
		txtCc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtCc.setText("0");
		txtCc.setToolTipText("Enter quantity");
		txtCc.setColumns(10);
		txtCc.setBounds(214, 215, 68, 26);
		drinks.add(txtCc);

		JLabel lblIceCream = new JLabel("Ice Cream");
		lblIceCream.setForeground(Color.WHITE);
		lblIceCream.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblIceCream.setBounds(15, 260, 149, 30);
		drinks.add(lblIceCream);

		txtIc = new JTextField();
		txtIc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtIc.setText("0");
		txtIc.setToolTipText("Enter quantity");
		txtIc.setColumns(10);
		txtIc.setBounds(214, 261, 68, 26);
		drinks.add(txtIc);

		JLabel lblFruitSalad = new JLabel("Fruit Salad");
		lblFruitSalad.setForeground(Color.WHITE);
		lblFruitSalad.setFont(new Font("Aparajita", Font.BOLD, 25));
		lblFruitSalad.setBounds(15, 306, 149, 30);
		drinks.add(lblFruitSalad);

		txtFs = new JTextField();
		txtFs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_BACK_SPACE) {

					e.consume();
				}
			}
		});
		txtFs.setText("0");
		txtFs.setToolTipText("Enter quantity");
		txtFs.setColumns(10);
		txtFs.setBounds(214, 307, 68, 26);
		drinks.add(txtFs);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BILL PRINT", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(255, 255, 0))));
		panel_4.setBackground(new Color(0, 64, 96));
		panel_4.setBounds(945, 151, 297, 352);
		panel.add(panel_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 28, 275, 308);
		panel_4.add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		Clock();
		
	}

//	  Launch the application.
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CustomerBilling frame = new CustomerBilling();
//					frame.setVisible(true);
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
}
