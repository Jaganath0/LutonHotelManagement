package FrontendLayer;

import java.sql.*;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewBooking extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBooking frame = new ViewBooking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	Connection con; 
	PreparedStatement st; 
	ResultSet rs;
	
	
	
	public void heloo() {

		try {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanegement", "root", "");
		String sql=" select UserName,ContactNumber,Email,RoomType,ChekIn,CheckOut,BookingStatus from viewbooking ";
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(sql);

		DefaultTableModel tmodel = (DefaultTableModel)table.getModel();
		tmodel.setRowCount(0);
		tmodel.setColumnCount(0);

		tmodel.addColumn("UserName");
		tmodel.addColumn("ContactNumber");
		tmodel.addColumn("Email");
		tmodel.addColumn("RoomType");
		tmodel.addColumn("CheckIn");
		tmodel.addColumn("CheckOut");
		tmodel.addColumn("BookingStatus");

		while(rs.next()) {
		tmodel.addRow( new Object[] { rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
		}


		connection.close();

		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
		}

	}
	
	
	
	/**
	 * Create the frame.
	 */
	public ViewBooking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 45, 509, 331);
		desktopPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		 heloo();
	}
	

}
