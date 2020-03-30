import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Customer extends JFrame {

	private JPanel contentPane;
	
	
	Login lg = new Login();	
	String user = lg.user;
	String password = lg.password;
	String url = lg.url;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		DefaultTableModel table = new DefaultTableModel();
		
		table.addColumn("Name");
		table.addColumn("Price");
		table.addColumn("State");
		table.addColumn("ID");
		
		try (Connection conn = DriverManager.getConnection(url, user, password))
		{
			String query = "Select product_name, price, st, product.p_id\r\n" + 
					"From product, pricing\r\n" + 
					"Where product.p_id = pricing.p_id";
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(query);
			while (r.next()) {
				table.addRow(new Object[] {
						r.getString(1),
						r.getString(2),
						r.getString(3),
						r.getString(4),
				});
			}
		}
		catch(SQLException ev) {
			System.out.println(ev.getMessage());
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(646, 11, 269, 515);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTable dataTable5 = new JTable();
		dataTable5.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Credit Card", "Payment Address",
			}
		));
		dataTable5.getColumnModel().getColumn(2).setPreferredWidth(97);
		
		JTable dataTable3 = new JTable();
		dataTable3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Credit Card", "Payment Address",
			}
		));
		dataTable3.getColumnModel().getColumn(2).setPreferredWidth(97);
		
		JTable dataTable4 = new JTable();
		dataTable4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Credit Card", "Payment Address",
			}
		));
		dataTable4.getColumnModel().getColumn(2).setPreferredWidth(97);
		
		ArrayList<Double> ar = new ArrayList<Double>();
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBounds(259, 11, 391, 515);
		panel.setLayout(null);
		
		JLabel lblShoppingCart = new JLabel("Shopping Cart");
		lblShoppingCart.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblShoppingCart.setBounds(121, 11, 130, 26);
		panel.add(lblShoppingCart);
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblProductId.setBounds(53, 67, 81, 14);
		panel.add(lblProductId);
		
		JTextField spid = new JTextField();
		spid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		spid.setBackground(Color.WHITE);
		spid.setHorizontalAlignment(SwingConstants.CENTER);
		spid.setBounds(165, 65, 86, 20);
		panel.add(spid);
		spid.setColumns(10);
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblState.setBounds(53, 92, 81, 14);
		panel.add(lblState);
		
		JTextField spst = new JTextField();
		spst.setBackground(Color.WHITE);
		spst.setHorizontalAlignment(SwingConstants.CENTER);
		spst.setBounds(165, 90, 86, 20);
		panel.add(spst);
		spst.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 213, 371, 2);
		panel.add(separator);
		
		JLabel lblEditCreditCard = new JLabel("Edit Credit Card");
		lblEditCreditCard.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblEditCreditCard.setBounds(108, 226, 168, 26);
		panel.add(lblEditCreditCard);
		
		JLabel label = new JLabel("");
		label.setBounds(108, 402, 46, 14);
		panel.add(label);
		
		JLabel lblCutomerId = new JLabel("Cutomer ID:");
		lblCutomerId.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblCutomerId.setBounds(53, 263, 81, 14);
		panel.add(lblCutomerId);
		
		JTextField cid = new JTextField();
		cid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		cid.setBackground(Color.WHITE);
		cid.setHorizontalAlignment(SwingConstants.CENTER);
		cid.setBounds(165, 261, 86, 20);
		panel.add(cid);
		cid.setColumns(10);
		
		JLabel lblCreditCard = new JLabel("Credit Card:");
		lblCreditCard.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblCreditCard.setBounds(53, 288, 81, 14);
		panel.add(lblCreditCard);
		
		JTextField cc = new JTextField();
		cc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		cc.setBackground(Color.WHITE);
		cc.setHorizontalAlignment(SwingConstants.CENTER);
		cc.setBounds(165, 286, 86, 20);
		panel.add(cc);
		cc.setColumns(10);
		
		JLabel lblEditAddress = new JLabel("Edit Address");
		lblEditAddress.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblEditAddress.setBounds(108, 365, 168, 26);
		panel.add(lblEditAddress);
		
		JLabel label_1 = new JLabel("Cutomer ID:");
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label_1.setBounds(53, 402, 81, 14);
		panel.add(label_1);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddress.setBounds(53, 423, 81, 14);
		panel.add(lblAddress);
		
		JTextField acid = new JTextField();
		acid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		acid.setBounds(165, 396, 86, 20);
		panel.add(acid);
		acid.setColumns(10);
		
		JTextField address = new JTextField();
		address.setBounds(165, 421, 86, 20);
		panel.add(address);
		address.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Payment Address", "Delivery Address"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(53, 448, 105, 22);
		panel.add(comboBox);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblName.setBounds(53, 117, 81, 14);
		panel.add(lblName);
		
		JTextField productName = new JTextField();
		productName.setHorizontalAlignment(SwingConstants.CENTER);
		productName.setBounds(165, 115, 86, 20);
		panel.add(productName);
		productName.setColumns(10);
		
		JLabel lblPaymentAddress_1 = new JLabel("Payment Address:");
		lblPaymentAddress_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblPaymentAddress_1.setBounds(53, 313, 103, 14);
		panel.add(lblPaymentAddress_1);
		
		JTextField EditCCpayment = new JTextField();
		EditCCpayment.setBounds(166, 310, 86, 20);
		panel.add(EditCCpayment);
		EditCCpayment.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		scrollPane.setBounds(10, 11, 239, 515);
		
		JTable dataTable = new JTable();
		dataTable.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		dataTable.setBackground(Color.WHITE);
		dataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product Name"
			}
		));
		dataTable.setModel(table);
		scrollPane.setViewportView(dataTable);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(660, 11, 391, 515);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(96, 20, 71, 26);
		panel_2.add(lblPrice);
		lblPrice.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		JLabel lblSubTotal = new JLabel("Sub Total:");
		lblSubTotal.setBounds(23, 57, 81, 14);
		panel_2.add(lblSubTotal);
		lblSubTotal.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
		JLabel lblTax = new JLabel("Tax:");
		lblTax.setBounds(23, 82, 81, 14);
		panel_2.add(lblTax);
		lblTax.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(23, 107, 81, 14);
		panel_2.add(lblTotal);
		lblTotal.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
		JTextField subTotal = new JTextField();
		subTotal.setBounds(228, 55, 86, 20);
		panel_2.add(subTotal);
		subTotal.setHorizontalAlignment(SwingConstants.CENTER);
		subTotal.setBackground(Color.WHITE);
		subTotal.setEditable(false);
		subTotal.setColumns(10);
		
		JTextField Tax = new JTextField();
		Tax.setBounds(228, 80, 86, 20);
		panel_2.add(Tax);
		Tax.setHorizontalAlignment(SwingConstants.CENTER);
		Tax.setBackground(Color.WHITE);
		Tax.setEditable(false);
		Tax.setColumns(10);
		
		JTextField total = new JTextField();
		total.setBounds(228, 105, 86, 20);
		panel_2.add(total);
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setBackground(Color.WHITE);
		total.setEditable(false);
		total.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 136, 371, 2);
		panel_2.add(separator_1);
		
		JLabel lblPaymentMethods = new JLabel("Payment Methods");
		lblPaymentMethods.setBounds(96, 149, 161, 26);
		panel_2.add(lblPaymentMethods);
		lblPaymentMethods.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		JLabel lblCreditCard_1 = new JLabel("Credit Card:");
		lblCreditCard_1.setBounds(23, 186, 81, 14);
		panel_2.add(lblCreditCard_1);
		lblCreditCard_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setBounds(23, 211, 106, 14);
		panel_2.add(lblCustomerId);
		lblCustomerId.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
		JLabel lblPaymentAddress = new JLabel("Payment Address:");
		lblPaymentAddress.setBounds(23, 236, 140, 14);
		panel_2.add(lblPaymentAddress);
		lblPaymentAddress.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
		JTextField ccTextField = new JTextField();
		ccTextField.setBounds(228, 184, 86, 20);
		panel_2.add(ccTextField);
		ccTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		ccTextField.setHorizontalAlignment(SwingConstants.CENTER);
		ccTextField.setBackground(Color.WHITE);
		ccTextField.setColumns(10);
		
		JTextField cidTextField = new JTextField();
		cidTextField.setBounds(228, 209, 86, 20);
		panel_2.add(cidTextField);
		cidTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		cidTextField.setBackground(Color.WHITE);
		cidTextField.setHorizontalAlignment(SwingConstants.CENTER);
		cidTextField.setColumns(10);
		
		JTextField paymentAdd = new JTextField();
		paymentAdd.setBounds(228, 234, 86, 20);
		panel_2.add(paymentAdd);
		paymentAdd.setHorizontalAlignment(SwingConstants.CENTER);
		paymentAdd.setBackground(Color.WHITE);
		paymentAdd.setColumns(10);
		
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 328, 371, 2);
		panel_2.add(separator_2);
		
		JLabel lblCurrentAddress = new JLabel("Current Address");
		lblCurrentAddress.setBounds(96, 341, 161, 26);
		panel_2.add(lblCurrentAddress);
		lblCurrentAddress.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		JLabel label_2 = new JLabel("Customer ID:");
		label_2.setBounds(23, 378, 106, 14);
		panel_2.add(label_2);
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		
		JTextField textField = new JTextField();
		textField.setBounds(228, 376, 86, 20);
		panel_2.add(textField);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if(!(Character.isDigit(num))
						|| (num == KeyEvent.VK_BACK_SPACE)
						|| (num == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.WHITE);
		textField.setColumns(10);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(23, 403, 105, 22);
		panel_2.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Payment Address", "Delivery Address"}));
		comboBox_1.setBackground(Color.WHITE);
		
		JButton displayAddress = new JButton("...");
		displayAddress.setBounds(137, 403, 30, 23);
		panel_2.add(displayAddress);
		displayAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String values = comboBox_1.getSelectedItem().toString();
				
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a Customer ID");
					textField.requestFocus();
					return;
				}
				if(values.equals("Payment Address")) {
					DefaultTableModel table = new DefaultTableModel();
					
					table.addColumn("Customer Address");
					
					try (Connection conn = DriverManager.getConnection(url, user, password))
					{
						String query = "SELECT * FROM customercc where c_id = ?";
						PreparedStatement stmt = conn.prepareStatement(query);
						
						stmt.setInt(1, Integer.parseInt(textField.getText()));
						
						ResultSet r = stmt.executeQuery();
						while (r.next()) {
							table.addRow(new Object[] {
									r.getString(3),
							});
						}
						dataTable4.setModel(table);
					}
					catch(SQLException ev) {
						System.out.println(ev.getMessage());
					}
					JFrame jFrame = new JFrame();
					jFrame.setVisible(true);
					jFrame.getContentPane().add(new JScrollPane(dataTable4));
					jFrame.pack();
				}
				else {
					DefaultTableModel table = new DefaultTableModel();
					
					table.addColumn("Delivery Address");
					
					try (Connection conn = DriverManager.getConnection(url, user, password))
					{
						String query = "SELECT * FROM customer where c_id = ?";
						PreparedStatement stmt = conn.prepareStatement(query);
						
						stmt.setInt(1, Integer.parseInt(textField.getText()));
						
						ResultSet r = stmt.executeQuery();
						while (r.next()) {
							table.addRow(new Object[] {
									r.getString(3),
							});
						}
						dataTable4.setModel(table);
					}
					catch(SQLException ev) {
						System.out.println(ev.getMessage());
					}
					JFrame jFrame = new JFrame();
					jFrame.setVisible(true);
					jFrame.getContentPane().add(new JScrollPane(dataTable4));
					jFrame.pack();
				}
			}
		});
		displayAddress.setBackground(Color.WHITE);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(310, 466, 71, 38);
		panel_2.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)){
		    		 
					 String query = "UPDATE customercc SET credit_card = ? WHERE c_id = ? And payment_address = ?";
					 
					 PreparedStatement statement = conn.prepareStatement(query);
					 
					 statement.setLong(1, Long.parseLong(cc.getText()));
					 statement.setInt(2, Integer.parseInt(cid.getText()));
					 statement.setString(3, EditCCpayment.getText());
					 
					 statement.executeUpdate();
		    		 
					 JOptionPane.showMessageDialog(null, "Credit Card Saved");
		    		 
					 cc.setText("");
					 cid.setText("");
					 EditCCpayment.setText("");
					 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(53, 331, 89, 23);
		panel.add(btnSave);
		
		JButton btnSaveClose = new JButton("Save & Close");
		btnSaveClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)){
		    		 
					 String query = "UPDATE customercc SET credit_card = ? WHERE c_id = ? And payment_address = ?";
					 
					 PreparedStatement statement = conn.prepareStatement(query);
					 
					 statement.setLong(1, Long.parseLong(cc.getText()));
					 statement.setInt(2, Integer.parseInt(cid.getText()));
					 statement.setString(3, EditCCpayment.getText());
					 
					 statement.executeUpdate();
		    		 
					 System.exit(0);
					 
					 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		btnSaveClose.setBackground(Color.WHITE);
		btnSaveClose.setBounds(165, 331, 89, 23);
		panel.add(btnSaveClose);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)){
					String values = comboBox.getSelectedItem().toString();
					if(values.equals("Delivery Address")) {
						String query = "UPDATE customer SET delivery_address = ? WHERE c_id = ?";
						 
						 PreparedStatement statement = conn.prepareStatement(query);
						 
						 statement.setString(1, address.getText());
						 statement.setInt(2, Integer.parseInt(acid.getText()));
						 
						 statement.executeUpdate();
			    		 
						 JOptionPane.showMessageDialog(null, "Delivery Address Changed");
					}
					else {
						String query = "UPDATE customercc SET payment_address = ? WHERE c_id = ?";
						 
						 PreparedStatement statement = conn.prepareStatement(query);
						 
						 statement.setString(1, address.getText());
						 statement.setInt(2, Integer.parseInt(acid.getText()));
						 
						 statement.executeUpdate();
			    		 
						 JOptionPane.showMessageDialog(null, " Payment Address Changed");
					}
					
					address.setText("");
					acid.setText("");
					 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		btnSave_1.setBackground(Color.WHITE);
		btnSave_1.setBounds(53, 481, 89, 23);
		panel.add(btnSave_1);
		
		JButton btnSaveClose_1 = new JButton("Save & Close");
		btnSaveClose_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)){
					String values = comboBox.getSelectedItem().toString();
					if(values.equals("Delivery Address")) {
						String query = "UPDATE customer SET delivery_address = ? WHERE c_id = ?";
						 
						 PreparedStatement statement = conn.prepareStatement(query);
						 
						 statement.setString(1, address.getText());
						 statement.setInt(2, Integer.parseInt(acid.getText()));
						 
						 statement.executeUpdate();
			    		 
						 JOptionPane.showMessageDialog(null, "Delivery Address Changed");
					}
					else {
						String query = "UPDATE customercc SET payment_address = ? WHERE c_id = ?";
						 
						 PreparedStatement statement = conn.prepareStatement(query);
						 
						 statement.setString(1, address.getText());
						 statement.setInt(2, Integer.parseInt(acid.getText()));
						 
						 statement.executeUpdate();
			    		 
						 JOptionPane.showMessageDialog(null, " Payment Address Changed");
					}
					
					System.exit(0);
					 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		btnSaveClose_1.setBackground(Color.WHITE);
		btnSaveClose_1.setBounds(162, 481, 89, 23);
		panel.add(btnSaveClose_1);
		
		
		JButton btnNew = new JButton("Add");
		btnNew.setBackground(Color.WHITE);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(spid.getText().isEmpty() || spst.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a Product ID/State");
					spid.requestFocus();
					return;
				}
				
				
				try (Connection conn = DriverManager.getConnection(url, user, password))
				{
					String Sql = "Select * From pricing Where p_id = ? And st = ?";
					PreparedStatement stmt = conn.prepareStatement(Sql);
					
					stmt.setInt(1, Integer.parseInt(spid.getText()));
					stmt.setString(2, spst.getText());
					
					ResultSet r = stmt.executeQuery();
					
					while (r.next()) {
						ar.add(r.getDouble(3));
					}
					
				}
				catch(SQLException ev) {
					System.out.println(ev.getMessage());
				}
			}
		});
		btnNew.setBounds(75, 148, 89, 23);
		panel.add(btnNew);
		
		
		JButton btnTotal = new JButton("Purchase");
		btnTotal.setBackground(Color.WHITE);
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double sum = 0.0;
				Double taxRate = 1.20;
				
				for (int i = 0; i < ar.size(); i++) {
					sum += ar.get(i);
				}
				String sTotal = String.format("$%.2f", sum);
				subTotal.setText(sTotal);
				
				double taxes = (sum * taxRate)/100;
				
				String sTax = String.format("$%.2f", taxes);
				Tax.setText(sTax);
				
				String sTot = String.format("$%.2f", taxes + sum);
				total.setText(sTot);
				
			}
		});
		btnTotal.setBounds(187, 148, 89, 23);
		panel.add(btnTotal);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.WHITE);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel table = new DefaultTableModel();
				
				table.addColumn("Product ID");
				table.addColumn("Name");
				table.addColumn("State");
				table.addColumn("Price");
				
				
				try (Connection conn = DriverManager.getConnection(url, user, password))
				{
					String query = "Select product.p_id, product_name, st, price\r\n" + 
							"From product, pricing\r\n" + 
							"Where product.p_id = pricing.p_id\r\n" + 
							"And product_name = ?";
					PreparedStatement stmt = conn.prepareStatement(query);
					
					stmt.setString(1, productName.getText());
					
					ResultSet r = stmt.executeQuery();
					while (r.next()) {
						table.addRow(new Object[] {
								r.getInt(1),
								r.getString(2),
								r.getString(3),
								r.getString(4),
						});
					}
					dataTable5.setModel(table);
				}
				catch(SQLException ev) {
					System.out.println(ev.getMessage());
				}
				JFrame jFrame = new JFrame();
				jFrame.setVisible(true);
				jFrame.setPreferredSize(new Dimension(500,500));
				JScrollPane sp = new JScrollPane(dataTable5, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				sp.setPreferredSize(new Dimension(100,100));
				jFrame.getContentPane().add(sp);;				
				jFrame.pack();
			}
		});
		btnSearch.setBounds(75, 179, 89, 23);
		panel.add(btnSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(57, 276, 89, 23);
		panel_2.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cidTextField.getText().isEmpty() || ccTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a Customer ID/CC number");
					cidTextField.requestFocus();
					return;
				}
				
				try (Connection conn = DriverManager.getConnection(url, user, password)){
		    		 
					 String query = "DELETE FROM customercc WHERE c_id = ? and credit_card = ?";
					 
					 PreparedStatement statement = conn.prepareStatement(query);
					 
					 statement.setInt(1, Integer.parseInt(cidTextField.getText()));
					 statement.setLong(2, Long.parseLong(ccTextField.getText()));

					 statement.execute();
		    		 
					 cidTextField.setText("");
					 ccTextField.setText("");
					 
					 
					 JOptionPane.showMessageDialog(null, "Credit Card Deleted");
		    		 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		btnDelete.setBackground(Color.WHITE);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(156, 276, 89, 23);
		panel_2.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(cidTextField.getText().isEmpty() || ccTextField.getText().isEmpty() || paymentAdd.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a Customer ID/New CC number/Payment Address");
					cidTextField.requestFocus();
					return;
				}
				
				try (Connection conn = DriverManager.getConnection(url, user, password)){
		    		 
					 String query = "INSERT INTO customercc Values (?, ?, ?)";
					 
					 PreparedStatement statement = conn.prepareStatement(query);
					 
					 statement.setInt(1, Integer.parseInt(cidTextField.getText()));
					 statement.setLong(2, Long.parseLong(ccTextField.getText()));
					 statement.setString(3, paymentAdd.getText());
					 
					 statement.execute();
					 
					 JOptionPane.showMessageDialog(null, "Credit Card Added");
					 
					 
		    		 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		btnAdd.setBackground(Color.WHITE);
		
		JButton diplayCC = new JButton("...");
		diplayCC.setBounds(262, 276, 30, 23);
		panel_2.add(diplayCC);
		diplayCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel table = new DefaultTableModel();
				
				table.addColumn("Credit Card");
				
				if(cidTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a Customer ID");
					cidTextField.requestFocus();
					return;
				}
				try (Connection conn = DriverManager.getConnection(url, user, password))
				{
					String query = "SELECT * FROM customercc where c_id = ?";
					PreparedStatement stmt = conn.prepareStatement(query);
					
					stmt.setInt(1, Integer.parseInt(cidTextField.getText()));
					
					ResultSet r = stmt.executeQuery();
					while (r.next()) {
						table.addRow(new Object[] {
								r.getString(2),
						});
					}
					dataTable3.setModel(table);
				}
				catch(SQLException ev) {
					System.out.println(ev.getMessage());
				}
				JFrame jFrame = new JFrame();
				jFrame.setVisible(true);
				jFrame.getContentPane().add(new JScrollPane(dataTable3));
				jFrame.pack();
			}
		});
		diplayCC.setBackground(Color.WHITE);
		
		JButton btnAvailability = new JButton("Availability");
		btnAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Sql = "Select * From Stock Where p_id = ? ";
				int i = 0;
				
				if(spid.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a Product ID/Name to check Availability");
					spid.requestFocus();
					return;
				}
				
				try (Connection conn = DriverManager.getConnection(url, user, password))
				{
					PreparedStatement stmt = conn.prepareStatement(Sql);
					
					stmt.setInt(1, Integer.parseInt(spid.getText()));
					
					ResultSet r = stmt.executeQuery();
					
					while (r.next()) {
						i = r.getInt(3);
					}
					
					if (i > 0) {
						JOptionPane.showMessageDialog(null, productName.getText() + " is available");
					}
					
				}
				catch(SQLException ev) {
					System.out.println(ev.getMessage());
				}	
			}
		});
		btnAvailability.setBackground(Color.WHITE);
		btnAvailability.setBounds(187, 179, 89, 23);
		panel.add(btnAvailability);
		
		JButton btnImage = new JButton("image");
		btnImage.setBackground(Color.WHITE);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel lableimg = null;
				String name = productName.getText();
				
				if(productName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter a name for the product to display Image");
					productName.requestFocus();
					return;
				}
				
				/*
				 * Note that images have to be in source folder otherwise
				 * Program will not run. The reason is 'ImageIcon' searches 
				 * for the named .png files in the source folder. Here on 
				 * Eclipse I have the .png files already in the src folder.
				 * 
				 */
				
				if(name.equals("Aquafina")) {
					ImageIcon image1 = new ImageIcon(getClass().getResource("aqua.png"));
					lableimg = new JLabel(image1);
				}
				else if(name.equals("Bud Light: 12 Pack")) {
					ImageIcon image1 = new ImageIcon(getClass().getResource("bud.png"));
					lableimg = new JLabel(image1);
				}
				else if(name.equals("Coke Cola")) {
					ImageIcon image1 = new ImageIcon(getClass().getResource("cocacola.png"));
					lableimg = new JLabel(image1);
				}
				else if(name.equals("Moutain Dew")) {
					ImageIcon image1 = new ImageIcon(getClass().getResource("Moutain.png"));
					lableimg = new JLabel(image1);
				}
				else if(name.equals("Jack Daniels")) {
					ImageIcon image1 = new ImageIcon(getClass().getResource("Jack.png"));
					lableimg = new JLabel(image1);
				}
				else if(name.equals("Rolling Rock")) {
					ImageIcon image1 = new ImageIcon(getClass().getResource("rolling.png"));
					lableimg = new JLabel(image1);
				}
				
				JFrame jFrame = new JFrame();
				jFrame.setVisible(true);
				jFrame.getContentPane().add(lableimg);
				jFrame.pack();
			}
		});
		btnImage.setBounds(261, 114, 74, 23);
		panel.add(btnImage);
	}
}
