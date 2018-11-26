import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class BMI extends JFrame {

	private JPanel contentPane;
	private JTextField WeightTF;
	private JTextField HeightTF;
	private JLabel output;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMI frame = new BMI();
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
	public BMI() {
		design();
		center();
	}
	private void calculator() {
		double wei=Double.parseDouble(WeightTF.getText());
		double feet=Double.parseDouble(HeightTF.getText());
		double hei=feet/3.2808;
		
		double bmi=(wei/(hei*hei));
		if(bmi<16) {
		output.setText(String.format("BMI= %.2f Severe Thinness",bmi));	
		}else if(bmi>=16 && bmi<=17) {
			output.setText(String.format("BMI= %.2f Moderate Thinness",bmi));	
		}else if(bmi>=17 && bmi<=18.5) {
			output.setText(String.format("BMI= %.2f MIld Thinness",bmi));
			}else if(bmi>=18.5 && bmi<=25) {
				output.setText(String.format("BMI= %.2f Normal",bmi));
			}else if(bmi>=25 && bmi<=30) {
				output.setText(String.format("BMI= %.2f Over Weight",bmi));
			}else if(bmi>=25 && bmi<=30) {
				output.setText(String.format("BMI= %.2f Normal",bmi));
			}else if(bmi>=30 && bmi<=35) {
				output.setText(String.format("BMI= %.2f Obese Class I",bmi));
			}else if(bmi>=35 && bmi<=40) {
				output.setText(String.format("BMI= %.2f Obese Class II",bmi));
			}else if(bmi>=40) {
				output.setText(String.format("BMI= %.2f Obese Class III",bmi));
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(BMI.class.getResource("/images/Gym-Mark.jpg")));
		setTitle("BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to BMI calculator");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 859, 52);
		contentPane.add(lblNewLabel);
		
		WeightTF = new JTextField();
		WeightTF.setBounds(193, 79, 156, 33);
		contentPane.add(WeightTF);
		WeightTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Weight(KG)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(22, 65, 119, 58);
		contentPane.add(lblNewLabel_1);
		
		HeightTF = new JTextField();
		HeightTF.setColumns(10);
		HeightTF.setBounds(193, 147, 156, 33);
		contentPane.add(HeightTF);
		
		JLabel lblHeight = new JLabel("Height(Feet)");
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHeight.setBounds(10, 136, 144, 52);
		contentPane.add(lblHeight);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.setIcon(new ImageIcon(BMI.class.getResource("/images/Calculator-icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(WeightTF.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Enter Weight");
				}else if(HeightTF.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter your Height");
				}else {
						calculator();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(22, 229, 192, 64);
		contentPane.add(btnNewButton);
		
		 output = new JLabel("");
		 output.setForeground(Color.WHITE);
		 output.setFont(new Font("Tahoma", Font.PLAIN, 25));
		 output.setBackground(Color.GRAY);
		output.setBounds(457, 56, 378, 158);
		contentPane.add(output);
		
		btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setIcon(new ImageIcon(BMI.class.getResource("/images/user-red-home-icon.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpage m= new Mainpage();
				m.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(643, 229, 192, 64);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(BMI.class.getResource("/images/banner-data-calculator-background.jpg")));
		lblNewLabel_2.setBounds(0, 0, 864, 317);
		contentPane.add(lblNewLabel_2);
	}

	
}
