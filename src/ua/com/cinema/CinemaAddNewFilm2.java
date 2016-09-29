package ua.com.cinema;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class CinemaAddNewFilm2 {

	static JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldStartTime1HH;
	private JTextField textFieldStartTime1Mm;
	private JTextField textFieldStartTime2HH;
	private JTextField textFieldStartTime2Mm;
	
	Cinema palace = CinemaGuiWindow.palace;
	
//	 
//	 Integer  seanceH;
//	 Integer  seanceM;
	 private JLabel label;
	 private JLabel label_1;
	 private JLabel lblNewLabel;
	 private JLabel lblNewLabel_1;
	 private JLabel label_2;
	 private JLabel label_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaGuiRemoveSeance frame = new CinemaGuiRemoveSeance();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @wbp.parser.entryPoint
	 */
	public CinemaAddNewFilm2() {
		
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 311, 206);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelInfo = new JLabel("Ви вибрали кількість сеансів : 2");
		labelInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelInfo.setBounds(49, 11, 254, 25);
		contentPane.add(labelInfo);
		
		JLabel lblTimeStart1 = new JLabel("Введіть час початку сеансу 1:");
		lblTimeStart1.setBounds(10, 47, 165, 25);
		contentPane.add(lblTimeStart1);
		
		textFieldStartTime1HH = new JTextField();
		textFieldStartTime1HH.setBounds(185, 47, 26, 25);
		contentPane.add(textFieldStartTime1HH);
		textFieldStartTime1HH.setColumns(10);
		
		textFieldStartTime1Mm = new JTextField();
		textFieldStartTime1Mm.setBounds(244, 47, 31, 25);
		contentPane.add(textFieldStartTime1Mm);
		textFieldStartTime1Mm.setColumns(10);
		
		JLabel lblTimeStart2 = new JLabel("Введіть час початку сеансу 2:");
		lblTimeStart2.setBounds(10, 95, 165, 25);
		contentPane.add(lblTimeStart2);
		
		textFieldStartTime2HH = new JTextField();
		textFieldStartTime2HH.setBounds(185, 95, 26, 25);
		contentPane.add(textFieldStartTime2HH);
		textFieldStartTime2HH.setColumns(10);
		
		textFieldStartTime2Mm = new JTextField();
		textFieldStartTime2Mm.setBounds(244, 95, 31, 25);
		contentPane.add(textFieldStartTime2Mm);
		textFieldStartTime2Mm.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
                    
                    
                    
					CinemaAddNewFilm.startH1 = Integer.parseInt(textFieldStartTime1HH.getText());
					CinemaAddNewFilm.startM1 = Integer.parseInt(textFieldStartTime1Mm.getText());
                   
					CinemaAddNewFilm.startH2 = Integer.parseInt(textFieldStartTime2HH.getText());
					CinemaAddNewFilm.startM2 = Integer.parseInt(textFieldStartTime2Mm.getText());
                    
                    
                  
                    
                    frame.dispose();
                    
				}catch( Exception e1){
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnSubmit.setBounds(69, 132, 156, 25);
		contentPane.add(btnSubmit);
		
		label = new JLabel("  :");
		label.setBounds(231, 47, 19, 25);
		contentPane.add(label);
		
		label_1 = new JLabel("  год");
		label_1.setBounds(208, 52, 26, 14);
		contentPane.add(label_1);
		
		lblNewLabel = new JLabel("   хв");
		lblNewLabel.setBounds(272, 52, 31, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("  год");
		lblNewLabel_1.setBounds(208, 100, 26, 14);
		contentPane.add(lblNewLabel_1);
		
		label_2 = new JLabel("  :");
		label_2.setBounds(231, 100, 19, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("   хв");
		label_3.setBounds(272, 100, 31, 14);
		contentPane.add(label_3);
		frame.setVisible(true);
	}
}

