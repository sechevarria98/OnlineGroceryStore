import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private JPanel contentPane;

	static String url;
	static String user;
	static String password;
	
	private JTextField url1;
	private JTextField usr;
	private JPasswordField pass;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}
	
	@SuppressWarnings("deprecation")
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(75, 0, 130));
		panel.setBounds(0, 0, 68, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(67, 133, 639, 309);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		usr = new JTextField();
		usr.setBackground(Color.WHITE);
		usr.setHorizontalAlignment(SwingConstants.CENTER);
		usr.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		usr.setBounds(10, 36, 86, 20);
		panel_1.add(usr);
		usr.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBackground(Color.WHITE);
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setBounds(10, 80, 86, 20);
		panel_1.add(pass);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Candara", Font.BOLD, 13));
		lblUsername.setBounds(10, 25, 86, 14);
		panel_1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Candara", Font.BOLD, 13));
		lblPassword.setBounds(10, 67, 86, 14);
		panel_1.add(lblPassword);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(67, 72, 639, 61);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblLogin.setBounds(10, 11, 102, 31);
		panel_2.add(lblLogin);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLUE);
		panel_3.setBounds(67, 0, 639, 72);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblUrl = new JLabel("Url:");
		lblUrl.setFont(new Font("Candara", Font.BOLD, 13));
		lblUrl.setBounds(10, 114, 86, 14);
		panel_1.add(lblUrl);
		
		url1 = new JTextField();
		url1.setHorizontalAlignment(SwingConstants.CENTER);
		url1.setBounds(10, 129, 86, 20);
		panel_1.add(url1);
		url1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ex. postgres");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 55, 76, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblExPassword = new JLabel("Ex. password");
		lblExPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		lblExPassword.setBounds(10, 99, 76, 14);
		panel_1.add(lblExPassword);
		
		JLabel lblEx = new JLabel("Ex. jdbc:postgresql://localhost/OnlineGroceryStore");
		lblEx.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		lblEx.setBounds(10, 151, 255, 14);
		panel_1.add(lblEx);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Customer", "Staff"}));
		comboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		comboBox.setBounds(136, 35, 86, 22);
		panel_1.add(comboBox);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usType = comboBox.getSelectedItem().toString();
				
				url = url1.getText();
				user = usr.getText();
				password = pass.getText();
				
				try (Connection conn = DriverManager.getConnection(url, user, password)){
					System.out.println("Connected to the PostgreSQL server successfully.");
					
					if(usType.equals("Customer")) {
						Customer cstm = new Customer();
						cstm.setVisible(true);
						dispose();
					}
					else if(usType.equals("Staff")) {
						Worker work = new Worker();
						work.setVisible(true);
						dispose();
					}
				}catch (SQLException ev) {
					System.out.println(ev.getMessage());
			   	}
			}
		});
		btnLogin.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnLogin.setBounds(10, 182, 89, 37);
		panel_1.add(btnLogin);
		
	}	
}
