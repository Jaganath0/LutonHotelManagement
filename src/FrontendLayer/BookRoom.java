package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Models.connbooking;
import Models.modelbooking;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class BookRoom extends JFrame {
	private JTextField checkin;
	private JTextField checkout;
	
	private JTextField bdate;
	JComboBox type;
	private JTable table;
	DefaultTableModel dt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookRoom frame = new BookRoom();
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
	public BookRoom() {
		setBounds(100, 100, 1064, 774);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("Room Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(77, 146, 85, 21);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Check In Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(370, 79, 127, 13);
		desktopPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Check Out Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(715, 79, 127, 13);
		desktopPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Request Booking");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String date=bdate.getText();
				String checkindate=checkin.getText();
				String checkoutdate=checkout.getText();
				String roomtype= type.getSelectedItem().toString();
				if(date.equals("yyyy/mm/dd")||checkindate.equals("yyyy/mm/dd")||checkoutdate.equals("yyyy/mm/dd")) {
					JOptionPane.showInternalMessageDialog(btnNewButton, "fill the fields properly");
				}else {
				
				
				modelbooking md= new modelbooking();
				md.setDate(date);
				md.setCheckin(checkindate);
				md.setCheckout(checkoutdate);
				md.setRoomtype(roomtype);
				md.setBookingstatus("pending");
				
				connbooking book= new connbooking();
				boolean output = book.bookinginsert(md);
				if(output==true) {
					JOptionPane.showInternalMessageDialog(null, "successfull");
				}
				}
			}
		});
				
				
				
		btnNewButton.setBounds(823, 670, 176, 32);
		desktopPane.add(btnNewButton);
		
		checkin = new JTextField();
		checkin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkin.setText("yyyy/mm/dd");
		checkin.setBounds(507, 65, 145, 32);
		desktopPane.add(checkin);
		checkin.setColumns(10);
		
		checkout = new JTextField();
		checkout.setText("yyyy/mm/dd");
		checkout.setBounds(854, 65, 145, 32);
		desktopPane.add(checkout);
		checkout.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage form = new HomePage();
				form.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(38, 681, 85, 21);
		desktopPane.add(btnNewButton_1);
		
		type = new JComboBox();
		type.setFont(new Font("Tahoma", Font.PLAIN, 13));
		type.setModel(new DefaultComboBoxModel(new String[] {"Single", "Double"}));
		type.setBounds(172, 148, 145, 21);
		desktopPane.add(type);
		
		bdate = new JTextField();
		bdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bdate.setText("yyyy/mm/dd");
		bdate.setColumns(10);
		bdate.setBounds(169, 65, 145, 32);
		desktopPane.add(bdate);
		
		JLabel date = new JLabel("Date");
		date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		date.setBounds(77, 79, 127, 13);
		desktopPane.add(date);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 240, 950, 339);
		desktopPane.add(scrollPane);
		dt=new DefaultTableModel();
		
		dt.addColumn("bookingID");
		dt.addColumn("date");
		dt.addColumn("checkindate");
		dt.addColumn("checkoutDate");
		dt.addColumn("roomtype");
		dt.addColumn("bookingstatus");
		
		
		table = new JTable(dt);
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(333, 670, 176, 32);
		desktopPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(549, 670, 176, 32);
		desktopPane.add(btnCancel);
		setLocationRelativeTo(null);
		connbooking connbook= new connbooking();
		ArrayList array = connbook.show_table();
		if(array.size()>0) {
			for(int i=0;i<array.size();i++) {
				modelbooking modelbook=(modelbooking)array.get(i);
				Object [] obj = {
						modelbook.getBookingid(),
						modelbook.getDate(),
						modelbook.getCheckin(),
						modelbook.getCheckout(),
						modelbook.getRoomtype(),
						modelbook.getBookingstatus()
						
				};
				dt.addRow(obj);
			}
	}
	
	}
}
