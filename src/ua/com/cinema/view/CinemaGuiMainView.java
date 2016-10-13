package ua.com.cinema.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CinemaGuiMainView {
	

	private JFrame frame;
	private ImageIcon img;

	public CinemaGuiMainView() {
		
		frame = new JFrame();
	frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
	frame.setTitle("**@author RomanGrupskyi");
	frame.setBounds(100, 100, 758, 468);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("");
	img = new ImageIcon(this.getClass().getResource("/img/oscar.png").getFile());
	lblNewLabel.setIcon(img);
	lblNewLabel.setBounds(245, 11, 487, 408);
	frame.getContentPane().add(lblNewLabel);
	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
	
	
	

}
