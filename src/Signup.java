import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

public class Signup extends JFrame {
	private JTextField nametf;
	private JTextField usernametf;
	private JTextField contacttf;
	private JTextField heightTf;
	private JTextField ageTf;
	private JLabel lblUuername;
	private JLabel lblPassword;
	private JLabel lblContact;
	private JLabel lblGender;
	private JLabel lblHeight;
	private JLabel lblAge;
	private JRadioButton male,female;
	private JCheckBox chckbxIAccpt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rst=null;
	String v=null;
	private JPasswordField passtf;
	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setResizable(false);
		design();
		conn=SQLConnection.ConnecrDB();
		center();
	}
	private void regester() {
		try {
		String query="INSERT INTO userdata(Name,Username,Password,Age,gender,Height,weight) VALUES(?,?,?,?,?,?,?)";
		pst=conn.prepareStatement(query);
		pst.setString(1, nametf.getText());
		pst.setString(2, usernametf.getText());
		pst.setString(3, passtf.getText());
		pst.setString(4, contacttf.getText());
		if(male.isSelected())
		{
			v=male.getText().toString();
		}else if(female.isSelected())
		{
			v=female.getText().toString();
		}else {
			JOptionPane.showMessageDialog(null, "Enter your Gender");
		}
		pst.setString(5, v);
		pst.setString(6, heightTf.getText());
		pst.setString(7, ageTf.getText());
		//pst.setString(9, addressCB.getSelectedItem().toString());
		pst.execute();
		pst.close();
		JOptionPane.showMessageDialog(null, "Signup Successfull");
		Index  ind = new Index ();
		ind.setVisible(true);
		dispose();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void center() {
		Dimension screensize,framesize;
		int x,y;
		screensize=Toolkit.getDefaultToolkit().getScreenSize();
		framesize =getSize();
		x=(screensize.width-framesize.width)/2;
		y=(screensize.height-framesize.height)/2;
		setLocation(x,y);
	}
	
	
	
	
	
	private void design()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Signup Here");
		setBounds(100, 100, 931, 989);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignupHere = new JLabel("Signup Here");
		lblSignupHere.setForeground(Color.BLACK);
		lblSignupHere.setFont(new Font("Blade Runner Movie Font", Font.PLAIN, 45));
		lblSignupHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignupHere.setBounds(25, 13, 849, 90);
		contentPane.add(lblSignupHere);
		
		nametf = new JTextField();
		nametf.setBounds(206, 116, 679, 54);
		contentPane.add(nametf);
		nametf.setColumns(10);
		
		usernametf = new JTextField();
		usernametf.setColumns(10);
		usernametf.setBounds(206, 200, 679, 54);
		contentPane.add(usernametf);
		
		contacttf = new JTextField();
		contacttf.setColumns(10);
		contacttf.setBounds(206, 387, 679, 54);
		contentPane.add(contacttf);
		
		heightTf = new JTextField();
		heightTf.setColumns(10);
		heightTf.setBounds(206, 593, 679, 54);
		contentPane.add(heightTf);
		
		ageTf = new JTextField();
		ageTf.setColumns(10);
		ageTf.setBounds(206, 672, 679, 54);
		contentPane.add(ageTf);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblName.setBounds(12, 116, 134, 54);
		contentPane.add(lblName);
		
		lblUuername = new JLabel("Username");
		lblUuername.setForeground(Color.BLACK);
		lblUuername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUuername.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblUuername.setBounds(12, 200, 134, 54);
		contentPane.add(lblUuername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(12, 278, 134, 54);
		contentPane.add(lblPassword);
		
		lblContact = new JLabel("Contact");
		lblContact.setForeground(Color.BLACK);
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblContact.setBounds(12, 382, 134, 54);
		contentPane.add(lblContact);
		
		lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.BLACK);
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGender.setBounds(12, 490, 134, 54);
		contentPane.add(lblGender);
		
		lblHeight = new JLabel("Height");
		lblHeight.setForeground(Color.BLACK);
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHeight.setBounds(12, 593, 134, 54);
		contentPane.add(lblHeight);
		
		lblAge = new JLabel("Age");
		lblAge.setForeground(Color.BLACK);
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAge.setBounds(12, 672, 134, 54);
		contentPane.add(lblAge);
		
		 male = new JRadioButton("Male");
		buttonGroup.add(male);
		male.setHorizontalAlignment(SwingConstants.CENTER);
		male.setFont(new Font("Tahoma", Font.PLAIN, 22));
		male.setBounds(206, 496, 214, 44);
		contentPane.add(male);
		
		 female = new JRadioButton("Female");
		buttonGroup.add(female);
		female.setFont(new Font("Tahoma", Font.PLAIN, 22));
		female.setBounds(498, 491, 156, 54);
		contentPane.add(female);
		
		JButton btnRegester = new JButton("signup now");
		btnRegester.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxIAccpt.isSelected()) {
					regester();
				}else {
					JOptionPane.showMessageDialog(null, "Read T&C");
				}
			}
		});
		btnRegester.setFont(new Font("Blade Runner Movie Font", Font.PLAIN, 45));
		btnRegester.setBounds(206, 852, 515, 59);
		contentPane.add(btnRegester);
		
	  chckbxIAccpt = new JCheckBox("I accpet all the T&C");
		chckbxIAccpt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		chckbxIAccpt.setBounds(206, 787, 522, 37);
		contentPane.add(chckbxIAccpt);
		
		passtf = new JPasswordField();
		passtf.setBounds(206, 281, 679, 62);
		contentPane.add(passtf);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon(Signup.class.getResource("/images/889af296ac050480731159c8899fe87e.jpg")));
		lblNewLabel.setBounds(0, 0, 925, 951);
		contentPane.add(lblNewLabel);
	}
}
