import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Dimension;

public class Mainpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage frame = new Mainpage();
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
	public Mainpage() {
		design();
		center();
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
		setAutoRequestFocus(false);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mainpage.class.getResource("/images/Gym-Mark.jpg")));
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWhatWouldYou = new JLabel("What Would You Like To Do?");
		lblWhatWouldYou.setFont(new Font("Source Sans Pro", Font.PLAIN, 42));
		lblWhatWouldYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatWouldYou.setBounds(0, 13, 619, 91);
		contentPane.add(lblWhatWouldYou);
		
		JButton btnMeasureYourBmi = new JButton("Measure your BMI");
		btnMeasureYourBmi.setIcon(new ImageIcon(Mainpage.class.getResource("/images/patient-2-icon.png")));
		btnMeasureYourBmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BMI b=new BMI();
				b.setVisible(true);
				dispose();
			}
		});
		btnMeasureYourBmi.setBounds(164, 139, 286, 55);
		contentPane.add(btnMeasureYourBmi);
		
		JButton btnCountYourCalories = new JButton("Count Your Calories");
		btnCountYourCalories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calorie c=new calorie();
				c.setVisible(true);
				dispose();
			}
		});
		btnCountYourCalories.setIcon(new ImageIcon(Mainpage.class.getResource("/images/doctor-icon.png")));
		btnCountYourCalories.setBounds(164, 402, 286, 55);
		contentPane.add(btnCountYourCalories);
		
		JButton btnAddBloodPressure = new JButton("Add blood Pressure to database");
		btnAddBloodPressure.setIcon(new ImageIcon(Mainpage.class.getResource("/images/heart-beat-icon.png")));
		btnAddBloodPressure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bp m= new bp();
				m.setVisible(true);
				dispose();
			}
		});
		btnAddBloodPressure.setBounds(164, 531, 286, 55);
		contentPane.add(btnAddBloodPressure);
		
		JButton btnMeasureYourExcercise = new JButton("Measure your Excercise");
		btnMeasureYourExcercise.setIcon(new ImageIcon(Mainpage.class.getResource("/images/karate-punch-icon.png")));
		btnMeasureYourExcercise.setBounds(164, 656, 286, 55);
		contentPane.add(btnMeasureYourExcercise);
		
		JButton btnMeasureYourBme = new JButton("Measure your BMR");
		btnMeasureYourBme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BMR m= new BMR();
				m.setVisible(true);
				dispose();
			}
		});
		btnMeasureYourBme.setIcon(new ImageIcon(Mainpage.class.getResource("/images/user-red-home-icon.png")));
		btnMeasureYourBme.setBounds(164, 278, 286, 55);
		contentPane.add(btnMeasureYourBme);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Mainpage.class.getResource("/images/Blurred Background HD Mobile Wallpaper31.png")));
		lblNewLabel.setBounds(-12, 0, 631, 743);
		contentPane.add(lblNewLabel);
	}
}
