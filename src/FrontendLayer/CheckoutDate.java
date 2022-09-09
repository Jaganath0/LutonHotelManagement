package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CheckoutDate extends JFrame {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutDate frame = new CheckoutDate();
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
	public CheckoutDate() {
		setBounds(100, 100, 756, 427);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 744, 49);
		desktopPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Check Out ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 209, 744, 189);
		desktopPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 59, 73, 29);
		desktopPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(70, 59, 207, 27);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Room Number");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(399, 59, 122, 29);
		desktopPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(531, 59, 207, 27);
		desktopPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Booking ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 105, 134, 29);
		desktopPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 109, 207, 27);
		desktopPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Check out");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(608, 166, 113, 29);
		desktopPane.add(btnNewButton);

	}

}
