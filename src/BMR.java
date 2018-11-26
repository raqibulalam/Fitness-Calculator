import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class BMR extends JFrame {

	private JPanel contentPane;
	private JTextField agetf;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField Heighttf;
	private JTextField Weighttf;
	private JRadioButton Femalerb;
	private AbstractButton Malerb;
	private JLabel label;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMR frame = new BMR();
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
	public BMR() {
		design();
		center();
	}
	private void calculator() {
		double wei= Double.parseDouble(Weighttf.getText());
		double age=Double.parseDouble(agetf.getText());
		double feet=Double.parseDouble(Heighttf.getText());
		double centi=feet*30.48;
		if(Malerb.isSelected()) {
			double BMR=((10*wei)+(6.25*centi)-(5*age)+5);
			label.setText(String.format("BMR= %.2f Calories/day",BMR));
		}else {
			double BMR=((10*wei)+(6.25*centi)-(5*age)-161);
			label.setText(String.format("BMR= %.2f Calories/day",BMR));
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
		setTitle("BMR Calculator");
		setBounds(100, 100, 1029, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToBmr = new JLabel("Welcome to BMR Calculator");
		lblWelcomeToBmr.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 29));
		lblWelcomeToBmr.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToBmr.setBounds(0, 0, 1011, 71);
		contentPane.add(lblWelcomeToBmr);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAge.setBounds(12, 84, 101, 35);
		contentPane.add(lblAge);
		
		agetf = new JTextField();
		agetf.setFont(new Font("Tahoma", Font.BOLD, 20));
		agetf.setBounds(148, 84, 196, 35);
		contentPane.add(agetf);
		agetf.setColumns(10);
		
 Malerb = new JRadioButton("Male");
		buttonGroup.add(Malerb);
		Malerb.setFont(new Font("Tahoma", Font.BOLD, 20));
		Malerb.setBounds(119, 147, 127, 25);
		contentPane.add(Malerb);
		
		 Femalerb = new JRadioButton("Female");
		buttonGroup.add(Femalerb);
		Femalerb.setFont(new Font("Tahoma", Font.BOLD, 20));
		Femalerb.setBounds(278, 147, 127, 25);
		contentPane.add(Femalerb);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setBounds(12, 216, 101, 40);
		contentPane.add(lblHeight);
		
		Heighttf = new JTextField();
		Heighttf.setFont(new Font("Tahoma", Font.BOLD, 20));
		Heighttf.setBounds(148, 219, 223, 37);
		contentPane.add(Heighttf);
		Heighttf.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWeight.setBounds(12, 299, 101, 40);
		contentPane.add(lblWeight);
		
		Weighttf = new JTextField();
		Weighttf.setFont(new Font("Tahoma", Font.BOLD, 20));
		Weighttf.setColumns(10);
		Weighttf.setBounds(148, 299, 223, 37);
		contentPane.add(Weighttf);
		
		 label = new JLabel("");
		 label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		label.setBounds(532, 84, 436, 250);
		contentPane.add(label);
		
		btnNewButton = new JButton("Calculate");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setIcon(new ImageIcon(BMR.class.getResource("/images/Calculator-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Weighttf.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Enter Weight");
				}else if(Heighttf.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter your Height");
				}else if(agetf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter your Age");
				}
				else {
						calculator();
				}
				
			}
		
			
		});
		btnNewButton.setBounds(161, 378, 210, 64);
		contentPane.add(btnNewButton);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHome.setIcon(new ImageIcon(BMR.class.getResource("/images/user-red-home-icon.png")));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mainpage m= new Mainpage();
				m.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(721, 378, 210, 64);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(BMR.class.getResource("/images/mobile-background-images-11.jpg")));
		lblNewLabel.setBounds(0, 0, 1011, 455);
		contentPane.add(lblNewLabel);
	}
}
