package FrontendLayer;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Models.connbooking;
import Models.connroom;
import Models.modelbooking;
import Models.modelroom;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageBooking extends JFrame {
	JTextField textField;
	 JTextField textField_1;
	 JTable table;
	 JTextField textField_3;
	 JTextField textField_4;
	 JTable table_1;
	 DefaultTableModel model;
	 Object[] addcolumn;
	 private JTextField roomnumber;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageBooking frame = new ManageBooking();
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
	public ManageBooking() {
		
		setBounds(100, 100, 1523, 762);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1509, 47);
		desktopPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Check Booking");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" checkout date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(364, 114, 139, 25);
		desktopPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(541, 114, 167, 25);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Booking ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(53, 57, 116, 25);
		desktopPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 57, 175, 25);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("allocate room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelroom room= new modelroom();
				int roomno=Integer.parseInt(roomnumber.getText());
				room.setRoomnumber(roomno);
				room.setRoomstatus("booked");
				connroom croom = new connroom();
				boolean output= croom.update(room);
				
				int customerid= Integer.parseInt(textField_1.getText());
				String bookstatus= textField_4.getText();
				
				int roomid= Integer.parseInt(roomnumber.getText());
				
				modelbooking book= new modelbooking();
				book.setBookingid(customerid);
				book.setRoomnumber(roomno);
				book.setBookingstatus(bookstatus);
				
				connbooking cbook= new connbooking();
				boolean result = cbook.booking_update(book);
				if(result==true) {
					roomtable();
					JOptionPane.showMessageDialog(null, "success");
				}
				
//				String 
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(474, 211, 147, 33);
		desktopPane.add(btnNewButton);
		
		JButton btnDeleteBooking = new JButton("available room");
		
		btnDeleteBooking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteBooking.setBounds(1127, 211, 167, 33);
		desktopPane.add(btnDeleteBooking);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(0, 266, 858, 427);
		desktopPane.add(scrollPane);
		
		addcolumn= new Object[7];
		addcolumn[0]="bookingId";
		addcolumn[1]="customerId";
		addcolumn[2]="checkindate";
		addcolumn[3]="checkoutdate";
		addcolumn[4]="roomnumber";
		addcolumn[5]="roomtype";
		addcolumn[6]="bookingstatus";
		
		
		
		
		
		table = new JTable();
		
//		table.addMouseListener(this);
	
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(addcolumn);
		scrollPane.setViewportView(table);
		table();
		table.addMouseListener(new MouseAdapter() {
			@Override
		
				public void mouseClicked(MouseEvent e) {
					if(e.getSource()==table) {
						try {
							int h2= table.getSelectedRow();
							
							TableModel model= table.getModel();
							String id= model.getValueAt(h2, 0).toString();
							textField_1.setText(id);
							
							String checki=model.getValueAt(h2, 2).toString();
							textField_3.setText(checki);
							String checko=model.getValueAt(h2,3 ).toString();
							textField .setText(checko);
							String books=model.getValueAt(h2, 6).toString();
							textField_4.setText(books);
						}
						catch(Exception ex) {
							System.out.println("errr"+ex.getMessage());
						}
					}
				
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(188, 114, 175, 25);
		desktopPane.add(textField_3);
		
		JLabel lblNewLabel_1_1 = new JLabel(" checkin date");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(53, 110, 125, 25);
		desktopPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("booking status");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(364, 163, 139, 25);
		desktopPane.add(lblNewLabel_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(541, 163, 167, 25);
		desktopPane.add(textField_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(947, 267, 533, 428);
		desktopPane.add(scrollPane_1);
		
		table_1 = new JTable();
		btnDeleteBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addcolumn = new Object[4];
				addcolumn[0]= "roomnumber";
				addcolumn[1]="typeofroom";
				addcolumn[2]="room price";
				addcolumn[3]="room status";
				
				model= (DefaultTableModel) table_1.getModel();
				model.setColumnIdentifiers(addcolumn);
				
				roomtable();
				
				
				
			}
		});
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		roomnumber = new JTextField();
		roomnumber.setColumns(10);
		roomnumber.setBounds(179, 167, 175, 25);
		desktopPane.add(roomnumber);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("room number");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(44, 163, 125, 25);
		desktopPane.add(lblNewLabel_1_1_1);
		
		JButton logout = new JButton("logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg= new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		logout.setBounds(10, 703, 85, 21);
		desktopPane.add(logout);
		setLocationRelativeTo(null);

	}
	public void table() {
		connbooking connbook= new connbooking();
		ArrayList array= connbook.manager_table();
		model.setRowCount(0);
		if(array.size()>0) {
			for (int i=0;i<array.size();i++) {
				modelbooking modelbook= (modelbooking) array.get(i);
				Vector vc= new Vector();
				vc.add(modelbook.getBookingid());
				vc.add(modelbook.getId());
				
				vc.add(modelbook.getCheckin());
				vc.add(modelbook.getCheckout());
				vc.add(modelbook.getRoomnumber());
				vc.add(modelbook.getRoomtype());
				vc.add(modelbook.getBookingstatus());
				model.addRow(vc);
			}
		}
	}
	
	public void roomtable() {
		connroom room= new connroom();
		ArrayList array= room.roomdata();
		model.setRowCount(0);
		if(array.size()>0) {
			for (int i= 0;i<array.size();i++) {
				modelroom mdroom= (modelroom) array.get(i);
				Vector vector = new Vector();
				vector.add(mdroom.getRoomnumber());
				vector.add(mdroom.getTypeofroom());
				vector.add(mdroom.getRoomprice());
				vector.add(mdroom.getRoomstatus());
				model.addRow(vector);
			}
		}
	}
	
	
}
