package FrontendLayer;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BusinessLayer.BLUser;
import Helper.InputException;
import Models.GlobalVariable;
import Models.User;
import Models.connLogin;
import Models.modellogin;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
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
	
	


	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 738);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Luton Hotel");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.BOLD, 56));
		lblNewLabel_1.setBounds(192, 10, 562, 69);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(220, 255, 177, 39);
		desktopPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(220, 330, 177, 39);
		desktopPane.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(404, 255, 350, 40);
		desktopPane.add(name);
		name.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().trim().isEmpty() && password.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter username and password");
				}
				
			
		        

				else{

					modellogin user = new modellogin();
					user.setEmail(name.getText());
					user.setPassword(password.getText());
					
					user = new connLogin().login(user);
					GlobalVariable.lglobal=user;
					if (user.getId() > 0) {
//						
						JOptionPane.showMessageDialog(null, "welcome");
						
						if (user.getName().equals("zacky") && user.getPassword().equals("zacky")){
					         managerdashboard rec= new managerdashboard	();
					         rec.setVisible(true);
					         dispose();}
						else {
							new HomePage().setVisible(true);;
							dispose();}
							
						
					} else {

						JOptionPane.showMessageDialog(null, "Incorrect username and password");
					}

				}
			}
		});
				
				
//					User user = new User();
//					user.setName(());
//					user.setPassword(password.getText());
					
//				HomePage form = new HomePage();
//				form.setVisible(true);
				//desktopPane.add(form);
				
//				Login.this.dispose();
			
	
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnNewButton.setBounds(315, 471, 164, 39);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Registration");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration form = new Registration();
				form.setVisible(true);
				//////desktopPane.add(form); 
				Login.this.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(557, 471, 149, 49);
		desktopPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(207, 596, 45, 13);
		desktopPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\-11595350908k53hnkh2la (1).png"));
		lblNewLabel_4.setBounds(1015, 652, 76, 69);
		desktopPane.add(lblNewLabel_4);
		
		JTextArea txtrlutomHotel = new JTextArea();
		txtrlutomHotel.setFont(new Font("Gloucester MT Extra Condensed", Font.PLAIN, 22));
		txtrlutomHotel.setText("@Lutom hotel");
		txtrlutomHotel.setBounds(953, 733, 158, 39);
		desktopPane.add(txtrlutomHotel);
		
		password = new JPasswordField();
		password.setBounds(404, 330, 350, 40);
		desktopPane.add(password);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\pexels-engin-akyurt-1579253 (1) (1) (1).jpg"));
		lblNewLabel_6.setBounds(0, 10, 976, 671);
		desktopPane.add(lblNewLabel_6);
		setLocationRelativeTo(null);
	}
}

