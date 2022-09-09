package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLayer.BLUser;
import Helper.InputException;
import Models.User;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField address;
	private JTextField email;
	private JTextField mobile;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		password = new JPasswordField();
		password.setBounds(369, 311, 484, 34);
		desktopPane.add(password);
		
		name = new JTextField();
		name.setBounds(369, 117, 484, 34);
		desktopPane.add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setBounds(369, 161, 484, 34);
		desktopPane.add(address);
		address.setColumns(10);
		
		email = new JTextField();
		email.setBounds(369, 213, 484, 34);
		desktopPane.add(email);
		email.setColumns(10);
		
		mobile = new JTextField();
		mobile.setBounds(369, 257, 484, 34);
		desktopPane.add(mobile);
		mobile.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BLUser bluser= new BLUser();
				try {
					User user = new User();
					user.setName(name.getText());
					user.setAddress(address.getText());
					user.setEmail(email.getText());
					user.setMobile(mobile.getText());
					user.setPassword(password.getText());
					bluser.setUser(user);
					user=bluser.save();
				} catch (InputException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(301, 465, 123, 45);
		desktopPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(183, 129, 160, 24);
		desktopPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(183, 169, 160, 24);
		desktopPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Email Address");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(183, 225, 160, 24);
		desktopPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Mobile Number");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(183, 269, 160, 24);
		desktopPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("New Password");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(183, 321, 160, 24);
		desktopPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login form = new Login();
				form.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(505, 465, 104, 45);
		desktopPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\simple-background-backgrounds-passion-simple-1-5c9b95cc94f92 (1).png"));
		lblNewLabel_11.setBounds(-12, -58, 946, 617);
		desktopPane.add(lblNewLabel_11);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
}
