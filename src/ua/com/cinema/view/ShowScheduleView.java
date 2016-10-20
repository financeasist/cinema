package ua.com.cinema.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * This class creates a new window with textArea and other components (view) to
 * show the actual schedule.
 * 
 * @version 1.2 10 Oct 2016
 * @author RomanGupskyi
 */
public class ShowScheduleView {
	private final static Logger logger = Logger.getLogger(ShowScheduleView.class);
	public static JTextArea textArea;
	private JFrame frame;
	private JLabel label_1;
	private JScrollPane scrollPane_1;

	/**
	 * Creates the Window
	 */
	public ShowScheduleView() {
		logger.info("Start window for 'Show Schedule' was started!");
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setBounds(100, 100, 383, 472);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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

		public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
