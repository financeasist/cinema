package ua.com.cinema;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class CinemaShowSchedule {

	static JFrame frame;
	static JTextArea textArea;
	 
	private JLabel label_1;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaShowSchedule window = new CinemaShowSchedule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Frame
	 */
	public CinemaShowSchedule() {
	
		 frame = new JFrame();
		frame.setBounds(100, 100, 383, 472);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
//	JScrollPane scrollPane=new JScrollPane();
//	frame.getContentPane().add(scrollPane);
	
	scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(10, 23, 347, 400);
	frame.getContentPane().add(scrollPane_1);
	textArea = new JTextArea();
	scrollPane_1.setViewportView(textArea);
	textArea.setWrapStyleWord(true);
	
	
	
	label_1 = new JLabel("РОЗКЛАД :");
	label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
	label_1.setBounds(154, 7, 67, 14);
	frame.getContentPane().add(label_1);
	}
}
	
	

