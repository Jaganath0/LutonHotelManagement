package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Receptionist extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=47,-36
	 */
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receptionist frame = new Receptionist();
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
	public Receptionist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Manage Booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageBooking form = new ManageBooking();
				desktopPane.add(form).setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 20, 210, 49);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login form = new Login();
				form.setVisible(true);
				Receptionist.this.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(1321, 58, 111, 85);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Check in");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(255, 20, 179, 49);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Check out");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBounds(484, 20, 186, 49);
		desktopPane.add(btnNewButton_3);
		
		JButton btnNewButton_2_1 = new JButton("Billing");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2_1.setBounds(710, 20, 179, 49);
		desktopPane.add(btnNewButton_2_1);
		setLocationRelativeTo(null);
	}
}
