import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class exercise extends JFrame {

	private JPanel contentPane;
	private JTextField wighttf;
	private JTextField disttf;
	private JLabel label;
	private JLabel lblNewLabel_2;
	private JButton btnHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exercise frame = new exercise();
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
	public exercise() {
		setTitle("Exercise Calculator");
		design();
	}
	private void calculate() {
		double dis= Double.parseDouble(disttf.getText());
		double cal=dis*140;
		label.setText(String.format("Your total burnt calories are %.2f",cal));
	}
	
	private void design()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1093, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Exercise Calculator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 978, 77);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your Weight");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(27, 160, 227, 52);
		contentPane.add(lblNewLabel_1);
		
		wighttf = new JTextField();
		wighttf.setBounds(319, 172, 239, 34);
		contentPane.add(wighttf);
		wighttf.setColumns(10);
		
		JLabel lblDistanceOfWalkmiles = new JLabel("Distance of walk(Miles)");
		lblDistanceOfWalkmiles.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistanceOfWalkmiles.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDistanceOfWalkmiles.setBounds(27, 243, 261, 64);
		contentPane.add(lblDistanceOfWalkmiles);
		
		disttf = new JTextField();
		disttf.setColumns(10);
		disttf.setBounds(319, 261, 239, 34);
		contentPane.add(disttf);
		
		JButton calculate = new JButton("Calculate");
		calculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculate();
			}
		});
		calculate.setIcon(new ImageIcon(exercise.class.getResource("/images/Calculator-icon.png")));
		calculate.setFont(new Font("Tahoma", Font.BOLD, 20));
		calculate.setBounds(27, 429, 233, 64);
		contentPane.add(calculate);
		
		 label = new JLabel("");
		 label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(594, 158, 442, 149);
		contentPane.add(label);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpage m=new Mainpage();
				m.setVisible(true);
				dispose();
			}
		});
		btnHome.setIcon(new ImageIcon(exercise.class.getResource("/images/user-red-home-icon.png")));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHome.setBounds(747, 429, 233, 64);
		contentPane.add(btnHome);
		
		lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.setIcon(new ImageIcon(exercise.class.getResource("/images/mobile-background-image.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1075, 537);
		contentPane.add(lblNewLabel_2);
	}
}
