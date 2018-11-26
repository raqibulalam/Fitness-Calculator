import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class calorie extends JFrame {

	private JPanel contentPane;
	double fruit=0;
	double veg=0;
	double meat=0;
	double carbs;
	private JTextField agetf;
	private JTextField Heighttf;
	private JTextField Weighttf;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton Femalerb;
	private JRadioButton Malerb;
	
	private JLabel view;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private AbstractButton narb;
	private JRadioButton larb;
	private JRadioButton marb;
	private JRadioButton varb;
	double B=0;
	private JLabel lblNewLabel;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calorie frame = new calorie();
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
	public calorie() {
		design();
		center();
	}
	public void  calculator() {
		double wei= Double.parseDouble(Weighttf.getText());
		double age=Double.parseDouble(agetf.getText());
		double feet=Double.parseDouble(Heighttf.getText());
		double centi=feet*30.48;
		if(Malerb.isSelected()) {
			double BMR=((10*wei)+(6.25*centi)-(5*age)+5);
			//label.setText(String.format("BMR= %.2f Calories/day",BMR));
			B=BMR;
		}else {
			double BMR=((10*wei)+(6.25*centi)-(5*age)-161);
			//label.setText(String.format("BMR= %.2f Calories/day",BMR));
			B=BMR;
		}
		
		if(narb.isSelected()) {
		double	cal=B*1.2;
			view.setText(String.format("You will need %.2f Calories/day to maintain your health",cal));
			label_3.setText(String.format("You need %.2f Calories/day to lose 0.5 kg per week",cal-500));
			label_4.setText(String.format("You need %.2f Calories/day to lose 1 kg per week",cal-1000));
			label_5.setText(String.format("You need %.2f Calories/day to gain 0.5 kg per week",cal+500));
			label_6.setText(String.format("You need %.2f Calories/day to gain 1 kg per week",cal+1000));
			
		}else if(larb.isSelected()) {
	double	cal=B*1.375;	
		view.setText(String.format("You will need %.2f Calories/day to maintain your health ",cal));
		label_3.setText(String.format("You need %.2f Calories/day to lose 0.5 kg per week",cal-500));
		label_4.setText(String.format("You need %.2f Calories/day to lose 1 kg per week",cal-1000));
		label_5.setText(String.format("You need %.2f Calories/day to gain 0.5 kg per week",cal+500));
		label_6.setText(String.format("You need %.2f Calories/day to gain 1 kg per week",cal+1000));
		}else if(marb.isSelected()) {
			double cal=B*1.55;
			view.setText(String.format("You will need %.2f Calories/day to maintain your health ",cal));
			label_3.setText(String.format("You need %.2f Calories/day to lose 0.5 kg per week",cal-500));
			label_4.setText(String.format("You need %.2f Calories/day to lose 1 kg per week",cal-1000));
			label_5.setText(String.format("You need %.2f Calories/day to gain 0.5 kg per week",cal+500));
			label_6.setText(String.format("You need %.2f Calories/day to gain 1 kg per week",cal+1000));
		}else {
		double	cal=B*1.725;
			view.setText(String.format("You will need %.2f Calories/day to maintain your health ",cal));
			label_3.setText(String.format("You need %.2f Calories/day to lose 0.5 kg per week",cal-500));
			label_4.setText(String.format("You need %.2f Calories/day to lose 1 kg per week",cal-1000));
			label_5.setText(String.format("You need %.2f Calories/day to gain 0.5 kg per week",cal+500));
			label_6.setText(String.format("You need %.2f Calories/day to gain 1 kg per week",cal+1000));
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
		setTitle("Calorie Counter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Age");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(12, 120, 101, 35);
		contentPane.add(label);
		
		agetf = new JTextField();
		agetf.setFont(new Font("Tahoma", Font.BOLD, 20));
		agetf.setColumns(10);
		agetf.setBounds(148, 120, 196, 35);
		contentPane.add(agetf);
		
		 Malerb = new JRadioButton("Male");
		buttonGroup.add(Malerb);
		Malerb.setFont(new Font("Tahoma", Font.BOLD, 20));
		Malerb.setBounds(119, 183, 127, 25);
		contentPane.add(Malerb);
		
		 Femalerb = new JRadioButton("Female");
		buttonGroup.add(Femalerb);
		Femalerb.setFont(new Font("Tahoma", Font.BOLD, 20));
		Femalerb.setBounds(278, 183, 127, 25);
		contentPane.add(Femalerb);
		
		JLabel label_1 = new JLabel("Height");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(12, 252, 101, 40);
		contentPane.add(label_1);
		
		Heighttf = new JTextField();
		Heighttf.setFont(new Font("Tahoma", Font.BOLD, 20));
		Heighttf.setColumns(10);
		Heighttf.setBounds(148, 255, 223, 37);
		contentPane.add(Heighttf);
		
		JLabel label_2 = new JLabel("Weight");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(12, 335, 101, 40);
		contentPane.add(label_2);
		
		Weighttf = new JTextField();
		Weighttf.setFont(new Font("Tahoma", Font.BOLD, 20));
		Weighttf.setColumns(10);
		Weighttf.setBounds(148, 335, 223, 37);
		contentPane.add(Weighttf);
		
		JButton calcu = new JButton("Calculate");
		calcu.setIcon(new ImageIcon(calorie.class.getResource("/images/Calculator-icon.png")));
		calcu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		calcu.setFont(new Font("Tahoma", Font.BOLD, 15));
		calcu.setBounds(148, 584, 210, 64);
		contentPane.add(calcu);
		
		JButton home = new JButton("Home");
		home.setIcon(new ImageIcon(calorie.class.getResource("/images/user-red-home-icon.png")));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpage m= new Mainpage();
				m.setVisible(true);
				dispose();
			}
		});
		home.setFont(new Font("Tahoma", Font.BOLD, 15));
		home.setBounds(708, 584, 210, 64);
		contentPane.add(home);
		
		view = new JLabel("");
		view.setFont(new Font("Tahoma", Font.BOLD, 20));
		view.setBounds(413, 120, 610, 71);
		contentPane.add(view);
		 
		 label_3 = new JLabel("");
		 label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		 label_3.setBounds(442, 204, 581, 71);
		 contentPane.add(label_3);
		 
		 label_4 = new JLabel("");
		 label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		 label_4.setBounds(442, 288, 581, 71);
		 contentPane.add(label_4);
		 
		 label_5 = new JLabel("");
		 label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		 label_5.setBounds(442, 372, 581, 71);
		 contentPane.add(label_5);
		 
		 label_6 = new JLabel("");
		 label_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		 label_6.setBounds(442, 456, 581, 71);
		 contentPane.add(label_6);
		
		 narb = new JRadioButton("No Activity");
		 narb.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonGroup_1.add(narb);
		narb.setBounds(23, 442, 175, 35);
		contentPane.add(narb);
		
		 larb = new JRadioButton("Light Activity");
		 larb.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonGroup_1.add(larb);
		larb.setBounds(241, 442, 175, 35);
		contentPane.add(larb);
		
		 marb = new JRadioButton("Moderate Activity");
		 marb.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonGroup_1.add(marb);
		marb.setBounds(23, 512, 196, 35);
		contentPane.add(marb);
		
	 varb = new JRadioButton("Very Active");
	 varb.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonGroup_1.add(varb);
		varb.setBounds(241, 512, 175, 35);
		contentPane.add(varb);
		
		lblNewLabel = new JLabel("Activity level");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 388, 311, 35);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Welcome to calorie Meter");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel_2.setBounds(0, 0, 1035, 92);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(calorie.class.getResource("/images/mobile-background-images.jpg")));
		lblNewLabel_1.setBounds(0, 0, 1035, 677);
		contentPane.add(lblNewLabel_1);
	}
}
