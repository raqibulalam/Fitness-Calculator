import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class bp extends JFrame {

	private JPanel contentPane;
	private JTextField nametf;
	private JTextField agetf;
	private JTextField weighttf;
	private JTextField bphtf;
	private JTextField bpltf;
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rst=null;
	String v=null;
	private JTextField datetf;
	private JTable datatable;
	private int ID=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bp frame = new bp();
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
	public bp() {
		setResizable(false);
		setAutoRequestFocus(false);
		conn=SQLConnection.ConnecrDB();
		design();
	}
	private void deletedata() {
		
		try {
		//	ID=rst.getInt(ID);
			int action=JOptionPane.showConfirmDialog(null,"Are you sure to Delete?", "Delete",JOptionPane.YES_NO_CANCEL_OPTION);
			if(action==0) {
				//String query="DELETE FROM bloodpressure WHERE ID ='" + ID + "'";
				String query="DELETE FROM bloodpressure WHERE `bloodpressure`.`ID` = ID";
				pst=conn.prepareStatement(query);
				pst.execute();
				JOptionPane.showMessageDialog(null, "Deleted Successfully");
				pst.close();
				loadtable();
				Reset();
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadtable() {
		try {
			String query = "select Name,Age,Weight,Date,BP_High,BP_Low FROM bloodpressure";
			pst = conn.prepareStatement(query);
			rst = pst.executeQuery();
			datatable.setModel(DbUtils.resultSetToTableModel(rst));
			pst.close();
			rst.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	private void Reset() {
		nametf.setText(null);
		agetf.setText(null);
		weighttf.setText(null);
		datetf.setText(null);
		bphtf.setText(null);
		bpltf.setText(null);
		
	}
	public void user() {
		try {
			String query="INSERT INTO bloodpressure(Name,Age,Weight,Date,BP_High,BP_Low) VALUES(?,?,?,?,?,?)";
			pst=conn.prepareStatement(query);
			pst.setString(1, nametf.getText());
			pst.setString(2, agetf.getText());
			pst.setString(3, weighttf.getText());
			pst.setString(4,datetf.getText() );
			pst.setString(5, bphtf.getText());
			pst.setString(6, bpltf.getText());
		pst.execute();
			pst.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void design()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Blood Pressure DataBase");
		setBounds(100, 100, 1080, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 339, 132, 47);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAge.setBounds(12, 418, 132, 47);
		contentPane.add(lblAge);
		
		JLabel lblHeight = new JLabel("Weight");
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHeight.setBounds(12, 501, 132, 47);
		contentPane.add(lblHeight);
		
		JLabel lblBphigh = new JLabel("BP(High)");
		lblBphigh.setHorizontalAlignment(SwingConstants.CENTER);
		lblBphigh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBphigh.setBounds(585, 339, 132, 47);
		contentPane.add(lblBphigh);
		
		JLabel lblBplow = new JLabel("BP(Low)");
		lblBplow.setHorizontalAlignment(SwingConstants.CENTER);
		lblBplow.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBplow.setBounds(585, 432, 132, 47);
		contentPane.add(lblBplow);
		
		nametf = new JTextField();
		nametf.setBounds(156, 348, 254, 33);
		contentPane.add(nametf);
		nametf.setColumns(10);
		
		agetf = new JTextField();
		agetf.setColumns(10);
		agetf.setBounds(156, 427, 254, 33);
		contentPane.add(agetf);
		
		weighttf = new JTextField();
		weighttf.setColumns(10);
		weighttf.setBounds(156, 510, 254, 33);
		contentPane.add(weighttf);
		
		bphtf = new JTextField();
		bphtf.setColumns(10);
		bphtf.setBounds(729, 353, 254, 33);
		contentPane.add(bphtf);
		
		bpltf = new JTextField();
		bpltf.setColumns(10);
		bpltf.setBounds(729, 441, 254, 33);
		contentPane.add(bpltf);
		
		datetf = new JTextField();
		datetf.setColumns(10);
		datetf.setBounds(729, 515, 254, 33);
		contentPane.add(datetf);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDate.setBounds(585, 501, 132, 47);
		contentPane.add(lblDate);
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.setIcon(new ImageIcon(bp.class.getResource("/images/Add-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user();
				loadtable();
			}
		});
		btnNewButton.setBounds(298, 564, 238, 57);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 28, 1038, 290);
		contentPane.add(scrollPane);
		
		datatable = new JTable();
		scrollPane.setViewportView(datatable);
		
		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.setIcon(new ImageIcon(bp.class.getResource("/images/sync-icon.png")));
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadtable();
			}
		});
		btnLoadTable.setBounds(22, 561, 238, 57);
		contentPane.add(btnLoadTable);
		
		JButton btnDeleteData = new JButton("Delete Data");
		btnDeleteData.setIcon(new ImageIcon(bp.class.getResource("/images/Actions-edit-delete-icon.png")));
		btnDeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletedata();
				Reset();
				
			}
		});
		btnDeleteData.setBounds(548, 564, 238, 57);
		contentPane.add(btnDeleteData);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(bp.class.getResource("/images/user-red-home-icon.png")));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpage m= new Mainpage();
				m.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(798, 564, 238, 57);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(bp.class.getResource("/images/mobile-background-image.jpg")));
		lblNewLabel.setBounds(0, 0, 1062, 646);
		contentPane.add(lblNewLabel);
	}
}
