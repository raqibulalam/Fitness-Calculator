import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Index extends JFrame {

	private JPanel contentPane;
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rst=null;
	
	
	private JTextField UsernameTF;
	private JPasswordField passwordTf;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Index.class.getResource("/images/Gym-Mark.jpg")));
		setTitle("One Stop Fitness Tracker");
		setResizable(false);
		design();
		conn=SQLConnection.ConnecrDB();
		center();
	}
	private void Login() {
		try {
			String query = "SELECT * FROM userdata WHERE Username=? AND Password=?";
			pst=conn.prepareStatement(query);
			pst.setString(1,UsernameTF.getText());
			pst.setString(2, passwordTf.getText());
			rst=pst.executeQuery();
			
			if(rst.next())
			{
				JOptionPane.showMessageDialog(null, "Login Successfull");
				Mainpage m= new Mainpage();
				m.setVisible(true);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null, "Login Failed");
			}
			pst.close();
			rst.close();
		}
		catch(Exception e){
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
		conn=SQLConnection.ConnecrDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon(Index.class.getResource("/images/Apps-Computer-Login-icon.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login();
			}
		});
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("Stencil", Font.PLAIN, 26));
		btnLogin.setBounds(250, 208, 316, 56);
		contentPane.add(btnLogin);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.setIcon(new ImageIcon(Index.class.getResource("/images/signup-icon (1).png")));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Signup s=new Signup();
				s.setVisible(true);
				dispose();
			}
		});
		btnSignup.setBackground(Color.WHITE);
		btnSignup.setFont(new Font("Stencil", Font.PLAIN, 24));
		btnSignup.setBounds(250, 298, 318, 62);
		contentPane.add(btnSignup);
		
		UsernameTF = new JTextField();
		UsernameTF.setBackground(new Color(51, 204, 255));
		UsernameTF.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameTF.setFont(new Font("Tahoma", Font.PLAIN, 23));
		UsernameTF.setBounds(167, 13, 498, 69);
		contentPane.add(UsernameTF);
		UsernameTF.setColumns(10);
		
		passwordTf = new JPasswordField();
		passwordTf.setBackground(new Color(51, 204, 255));
		passwordTf.setHorizontalAlignment(SwingConstants.CENTER);
		passwordTf.setFont(new Font("Tahoma", Font.PLAIN, 23));
		passwordTf.setBounds(167, 117, 498, 69);
		contentPane.add(passwordTf);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(Index.class.getResource("/images/Login-icon.png")));
		btnExit.setFont(new Font("Stencil", Font.PLAIN, 26));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(250, 384, 316, 56);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Index.class.getResource("/images/Key-icon.png")));
		lblNewLabel.setBounds(12, 117, 109, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Index.class.getResource("/images/App-login-manager-icon.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 26, 109, 56);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Index.class.getResource("/images/16585a957f4553c.jpg")));
		lblNewLabel_2.setBounds(0, 0, 811, 470);
		contentPane.add(lblNewLabel_2);
	}
}