package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Checkin extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkin frame = new Checkin();
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
	public Checkin() {
		setBounds(100, 100, 718, 424);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 706, 55);
		desktopPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Check in");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 76, 73, 29);
		desktopPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(70, 76, 207, 27);
		desktopPane.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Booking ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 122, 134, 29);
		desktopPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 126, 207, 27);
		desktopPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Room Number");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(361, 76, 142, 29);
		desktopPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(489, 80, 207, 27);
		desktopPane.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 185, 706, 210);
		desktopPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

}
