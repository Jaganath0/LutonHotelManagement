package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.GlobalVariable;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1515, 882);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(562, 250, 1, 1);
		contentPane.add(desktopPane);
		
		JButton btnNewButton_4 = new JButton("Log out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login form = new Login();
				form .setVisible(true);
				/////////desktopPane.add(form);
				HomePage.this.dispose();
			}
		});
		btnNewButton_4.setForeground(Color.RED);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.setBounds(1247, 134, 109, 55);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Book Room");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookRoom form = new BookRoom();
				form.setVisible(true);
//				HomePage.this.dispose();
				
			}
		});
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5.setBounds(399, 190, 164, 46);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Luton Hotel");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 55));
		lblNewLabel_1.setBounds(345, 71, 579, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("HI");
		lblNewLabel_2.setText(GlobalVariable.lglobal.getName());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(62, 10, 164, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\simple-background-backgrounds-passion-simple-1-5c9b95cc94f92 (1).png"));
		lblNewLabel.setBounds(0, 0, 1501, 845);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
}
