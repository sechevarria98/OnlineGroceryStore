import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class Worker extends JFrame {

	private JPanel contentPane;
	private JTextField Calories;
	private JTextField Protein;
	private JTextField Sodium;
	private JTextField FatContent;
	
	
	Login lg = new Login();	
	String user = lg.user;
	String password = lg.password;
	String url = lg.url;
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Worker frame = new Worker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Worker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(10, 11, 827, 515);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 827, 54);
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome");
		lblNewLabel_2.setFont(new Font("MS Gothic", Font.BOLD, 32));
		lblNewLabel_2.setBounds(222, 11, 318, 32);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 121, 274, 420);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAddProducts = new JLabel("Add Products");
		lblAddProducts.setFont(new Font("MS Gothic", Font.BOLD, 15));
		lblAddProducts.setBounds(69, 11, 114, 14);
		panel_2.add(lblAddProducts);
		
		JLabel lblProductId = new JLabel("Product ID:");
		lblProductId.setBounds(10, 37, 88, 14);
		panel_2.add(lblProductId);
		
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setBounds(10, 62, 88, 14);
		panel_2.add(lblProductName);
		
		JLabel lblPackagingSize = new JLabel("Packaging Size:");
		lblPackagingSize.setBounds(10, 87, 88, 14);
		panel_2.add(lblPackagingSize);
		
		JTextField pid = new JTextField();
		pid.addKeyListener(new KeyAdapter() {
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
		pid.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		pid.setHorizontalAlignment(SwingConstants.CENTER);
		pid.setBounds(108, 34, 86, 20);
		panel_2.add(pid);
		pid.setColumns(10);
		
		JTextField pname = new JTextField();
		pname.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		pname.setHorizontalAlignment(SwingConstants.CENTER);
		pname.setBounds(108, 59, 86, 20);
		panel_2.add(pname);
		pname.setColumns(10);
		
		JTextField size = new JTextField();
		size.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		size.setHorizontalAlignment(SwingConstants.CENTER);
		size.setBounds(108, 84, 86, 20);
		panel_2.add(size);
		size.setColumns(10);
		
		JLabel lblDeleteProdcuts = new JLabel("Delete Products");
		lblDeleteProdcuts.setFont(new Font("MS Gothic", Font.BOLD, 15));
		lblDeleteProdcuts.setBounds(69, 265, 133, 14);
		panel_2.add(lblDeleteProdcuts);
		
		JLabel lblProductId_1 = new JLabel("Product ID:");
		lblProductId_1.setBounds(10, 290, 88, 14);
		panel_2.add(lblProductId_1);
		
		JTextField delid = new JTextField();
		delid.addKeyListener(new KeyAdapter() {
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
		delid.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		delid.setHorizontalAlignment(SwingConstants.CENTER);
		delid.setBounds(108, 287, 86, 20);
		panel_2.add(delid);
		delid.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(294, 121, 274, 420);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modify Products");
		lblNewLabel.setFont(new Font("MS Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(80, 11, 128, 14);
		panel_3.add(lblNewLabel);
		
		JLabel lblProductId_2 = new JLabel("Product ID:");
		lblProductId_2.setBounds(10, 30, 79, 14);
		panel_3.add(lblProductId_2);
		
		JLabel lblState = new JLabel("State:");
		lblState.setBounds(10, 55, 46, 14);
		panel_3.add(lblState);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 80, 46, 14);
		panel_3.add(lblPrice);
		
		JTextField modpid = new JTextField();
		modpid.addKeyListener(new KeyAdapter() {
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
		modpid.setBounds(132, 27, 86, 20);
		modpid.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(modpid);
		modpid.setColumns(10);
		
		JTextField state = new JTextField();
		state.setBounds(132, 52, 86, 20);
		state.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(state);
		state.setColumns(10);
		
		JTextField price = new JTextField();
		price.setBounds(132, 77, 86, 20);
		price.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(price);
		price.setColumns(10);
		
		JLabel lblWarehouse = new JLabel("Warehouse");
		lblWarehouse.setFont(new Font("MS Gothic", Font.BOLD, 15));
		lblWarehouse.setBounds(80, 139, 128, 14);
		panel_3.add(lblWarehouse);
		
		JLabel lblProductId_3 = new JLabel("Product ID:");
		lblProductId_3.setBounds(10, 169, 79, 14);
		panel_3.add(lblProductId_3);
		
		JLabel lblWarehouseNumber = new JLabel("Warehouse Number:");
		lblWarehouseNumber.setBounds(10, 194, 99, 14);
		panel_3.add(lblWarehouseNumber);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		lblNewLabel_1.setBounds(10, 219, 79, 14);
		panel_3.add(lblNewLabel_1);
		
		JTextField wareid = new JTextField();
		wareid.addKeyListener(new KeyAdapter() {
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
		wareid.setBounds(132, 166, 86, 20);
		wareid.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(wareid);
		wareid.setColumns(10);
		
		JTextField warenum = new JTextField();
		warenum.addKeyListener(new KeyAdapter() {
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
		warenum.setBounds(132, 191, 86, 20);
		warenum.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(warenum);
		warenum.setColumns(10);
		
		JTextField amount = new JTextField();
		amount.addKeyListener(new KeyAdapter() {
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
		amount.setBounds(132, 216, 86, 20);
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(amount);
		amount.setColumns(10);
		
		JLabel lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setBounds(10, 112, 88, 14);
		panel_2.add(lblPrice_1);
		
		JLabel lblState_1 = new JLabel("State:");
		lblState_1.setBounds(10, 137, 88, 14);
		panel_2.add(lblState_1);
		
		JTextField newPrice = new JTextField();
		newPrice.setBounds(108, 109, 86, 20);
		newPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(newPrice);
		newPrice.setColumns(10);
		
		JTextField priceState = new JTextField();
		priceState.setBounds(108, 134, 86, 20);
		priceState.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(priceState);
		priceState.setColumns(10);
		
		JTable dataTable = new JTable();
		dataTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Name", "Packaging Size"
			}
		));
		dataTable.getColumnModel().getColumn(2).setPreferredWidth(97);
		
		JLabel lblCalories = new JLabel("Calories:");
		lblCalories.setBounds(10, 162, 88, 14);
		panel_2.add(lblCalories);
		
		JLabel lblProtein = new JLabel("Protein:");
		lblProtein.setBounds(10, 187, 88, 14);
		panel_2.add(lblProtein);
		
		JLabel lblSodium = new JLabel("Sodium:");
		lblSodium.setBounds(10, 212, 88, 14);
		panel_2.add(lblSodium);
		
		JLabel lblFatContent = new JLabel("Fat Content:");
		lblFatContent.setBounds(10, 237, 88, 14);
		panel_2.add(lblFatContent);
		
		Calories = new JTextField();
		Calories.setHorizontalAlignment(SwingConstants.CENTER);
		Calories.setBackground(Color.WHITE);
		Calories.setBounds(108, 159, 86, 20);
		panel_2.add(Calories);
		Calories.setColumns(10);
		
		Protein = new JTextField();
		Protein.setBackground(Color.WHITE);
		Protein.setHorizontalAlignment(SwingConstants.CENTER);
		Protein.setBounds(108, 184, 86, 20);
		panel_2.add(Protein);
		Protein.setColumns(10);
		
		Sodium = new JTextField();
		Sodium.setHorizontalAlignment(SwingConstants.CENTER);
		Sodium.setBackground(Color.WHITE);
		Sodium.setBounds(108, 209, 86, 20);
		panel_2.add(Sodium);
		Sodium.setColumns(10);
		
		FatContent = new JTextField();
		FatContent.setHorizontalAlignment(SwingConstants.CENTER);
		FatContent.setBackground(Color.WHITE);
		FatContent.setBounds(108, 234, 86, 20);
		panel_2.add(FatContent);
		FatContent.setColumns(10);
		
		/*
		 * Buttons
		 */
		
		
		JButton addBtn = new JButton("Add");
		addBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)){
		    		 
					 String query = "INSERT INTO Product VALUES(?,?,?)";
					 
					 PreparedStatement statement = conn.prepareStatement(query);
					 
					 statement.setInt(1, Integer.parseInt(pid.getText()));
					 statement.setString(2, pname.getText());
					 statement.setDouble(3, Double.parseDouble(size.getText()));
					 
					 statement.execute();
					 
					 String Sql = "INSERT INTO pricing Values(?,?,?)";
					 
					 PreparedStatement stmt = conn.prepareStatement(Sql);

					 stmt.setInt(1, Integer.parseInt(pid.getText()));
					 stmt.setString(2, priceState.getText());
					 stmt.setDouble(3, Double.parseDouble(newPrice.getText()));
					 
					 stmt.execute();
					 
					 String Sql1 = "Insert Into nutrition Values(?,?,?,?,?)";
					 
					 PreparedStatement st = conn.prepareStatement(Sql1);
					 
					 st.setInt(1, Integer.parseInt(pid.getText()));
					 st.setInt(2, Integer.parseInt(Calories.getText()));
					 st.setDouble(3, Double.parseDouble(Protein.getText()));
					 st.setDouble(4, Double.parseDouble(Sodium.getText()));
					 st.setDouble(5, Double.parseDouble(FatContent.getText()));
					 
					 st.execute();
					 
					 pid.setText("");
					 pname.setText("");
					 size.setText("");
					 priceState.setText("");
					 newPrice.setText("");
					 Calories.setText("");
					 Protein.setText("");
					 Sodium.setText("");
					 FatContent.setText("");
					 
					 JOptionPane.showMessageDialog(null, "Product Added");
					 
					 
		    		 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		addBtn.setBackground(Color.WHITE);
		addBtn.setBounds(10, 379, 99, 32);
		panel_2.add(addBtn);
		
		JButton delBtn = new JButton("Delete");
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)){
		    		 
					 String query = "DELETE FROM Pricing WHERE p_id = ?";
					 
					 PreparedStatement statement = conn.prepareStatement(query);
					 
					 statement.setInt(1, Integer.parseInt(delid.getText()));

					 statement.execute();
					 
					 
					 String Sql1 = "Delete From nutrition Where p_id = ?";
					 
					 PreparedStatement st = conn.prepareStatement(Sql1);
					 
					 st.setInt(1, Integer.parseInt(delid.getText()));
					 
					 st.execute();
					 
					 String Sql = "DELETE FROM Product WHERE p_id = ?";
					 
					 PreparedStatement stmt = conn.prepareStatement(Sql);
					 
					 stmt.setInt(1, Integer.parseInt(delid.getText()));
					 
					 stmt.execute();
		    		 
					 delid.setText("");
					 
					 
					 JOptionPane.showMessageDialog(null, "Product Deleted");
		    		 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		delBtn.setBackground(Color.WHITE);
		delBtn.setBounds(10, 336, 99, 32);
		panel_2.add(delBtn);
		delBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		
		JButton btnAddSt = new JButton("Add Stock");
		btnAddSt.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnAddSt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)){
		    		 
					 String query = "UPDATE Stock SET amount = ? WHERE p_id = ? AND w_number = ?";
					 
					 PreparedStatement statement = conn.prepareStatement(query);
					 
					 statement.setInt(1, Integer.parseInt(amount.getText()));
					 statement.setInt(2, Integer.parseInt(wareid.getText()));
					 statement.setInt(3, Integer.parseInt(warenum.getText()));
					 
					 statement.executeUpdate();
					 
					 
					 amount.setText("");
					 wareid.setText("");
					 warenum.setText("");
		    		 
					 JOptionPane.showMessageDialog(null, "Stock added");
		    		 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		btnAddSt.setBackground(Color.WHITE);
		btnAddSt.setBounds(165, 377, 99, 32);
		panel_3.add(btnAddSt);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection conn = DriverManager.getConnection(url, user, password)){
		    		 
					 String query = "UPDATE Pricing SET price = ? WHERE p_id = ? AND st = ?";
					 
					 PreparedStatement statement = conn.prepareStatement(query);
					 
					 statement.setDouble(1, Double.parseDouble(price.getText()));
					 statement.setInt(2, Integer.parseInt(modpid.getText()));
					 statement.setString(3, state.getText());
					 
					 statement.executeUpdate();
		    		 
					 JOptionPane.showMessageDialog(null, "Price Modified");
		    		 
					 price.setText("");
					 state.setText("");
					 modpid.setText("");
					 
		    	 }catch (SQLException ev) {
		    		 System.out.println(ev.getMessage());
		    	}
			}
		});
		btnModify.setBackground(Color.WHITE);
		btnModify.setBounds(10, 377, 99, 32);
		panel_3.add(btnModify);
		
		JButton DisplayBtn = new JButton("Display");
		DisplayBtn.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		DisplayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel table = new DefaultTableModel();
				
				table.addColumn("Product ID");
				table.addColumn("Name");
				table.addColumn("Packaging Size");
				table.addColumn("State");
				table.addColumn("Price");
				table.addColumn("Calories");
				table.addColumn("Protein");
				table.addColumn("Sodium");
				table.addColumn("Fat Content");
				
				try (Connection conn = DriverManager.getConnection(url, user, password))
				{
					String query = "Select product.p_id, product_name, packaging_size, st, price, calorie, protein, sodium, fat_content\r\n" + 
							"From Product, pricing, nutrition\r\n" + 
							"Where product.p_id = pricing.p_id\r\n" + 
							"And product.p_id = nutrition.p_id";
					Statement s = conn.createStatement();
					ResultSet r = s.executeQuery(query);
					while (r.next()) {
						table.addRow(new Object[] {
								r.getString(1),
								r.getString(2),
								r.getString(3),
								r.getString(4),
								r.getString(5),
								r.getString(6),
								r.getString(7),
								r.getString(8),
								r.getString(9),
						});
					}
					dataTable.setModel(table);
				}
				catch(SQLException ev) {
					System.out.println(ev.getMessage());
				}
				JFrame jFrame = new JFrame();
				jFrame.setVisible(true);
				jFrame.getContentPane().add(new JScrollPane(dataTable));
				jFrame.pack();
			}
		});
		DisplayBtn.setBackground(Color.WHITE);
		DisplayBtn.setBounds(165, 351, 99, 32);
		panel_2.add(DisplayBtn);
		
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnDisplay.setBackground(Color.WHITE);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel table = new DefaultTableModel();
				
				table.addColumn("Product ID");
				table.addColumn("Name");
				table.addColumn("State");
				table.addColumn("price");
				
				
				try (Connection conn = DriverManager.getConnection(url, user, password))
				{
					String query = "Select product.p_id, product_name, st, price\r\n" + 
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
					dataTable.setModel(table);
				}
				catch(SQLException ev) {
					System.out.println(ev.getMessage());
				}
				JFrame jFrame = new JFrame();
				jFrame.setVisible(true);
				jFrame.getContentPane().add(new JScrollPane(dataTable));
				jFrame.pack();
			}
		});
		btnDisplay.setBounds(10, 334, 99, 32);
		panel_3.add(btnDisplay);
		
		JButton btnDisplay_1 = new JButton("Display");
		btnDisplay_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnDisplay_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel table = new DefaultTableModel();
				
				table.addColumn("Product ID");
				table.addColumn("Warehouse Number");
				table.addColumn("Amount");
				
				
				try (Connection conn = DriverManager.getConnection(url, user, password))
				{
					String query = "SELECT * FROM Stock";
					Statement s = conn.createStatement();
					ResultSet r = s.executeQuery(query);
					while (r.next()) {
						table.addRow(new Object[] {
								r.getString(1),
								r.getString(2),
								r.getString(3),
						});
					}
					dataTable.setModel(table);
				}
				catch(SQLException ev) {
					System.out.println(ev.getMessage());
				}
				JFrame jFrame = new JFrame();
				jFrame.setVisible(true);
				jFrame.getContentPane().add(new JScrollPane(dataTable));
				jFrame.pack();
			}
		});
		btnDisplay_1.setBackground(Color.WHITE);
		btnDisplay_1.setBounds(165, 334, 99, 32);
		panel_3.add(btnDisplay_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(578, 511, 71, 41);
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		panel.add(btnLogOut);
	}
}
