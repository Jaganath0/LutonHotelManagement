package FrontendLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class managerdashboard extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerdashboard frame = new managerdashboard();
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
	public managerdashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton manage = new JButton("manage bookings");
		manage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageBooking mb = new ManageBooking();
				mb.setVisible(true);
			}
		});
		manage.setBounds(71, 30, 139, 36);
		contentPane.add(manage);
		
		 desktopPane = new JDesktopPane();
		desktopPane.setBounds(79, 93, 1192, 555);
		contentPane.add(desktopPane);
	}
}
