package ua.com.cinema.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * this class - it's window design for RemoveMovieController.
 * 
 * version 1.2 10 Oct 2016
 * @author RomanGupskyi
 */
public class RemoveMovieView {

	private JFrame frame;
	private JTextField textField;

	/**
	 * creates frame
	 */
	public RemoveMovieView() {
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setBounds(100, 100, 409, 146);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		initViewConponents();
	}

	/**
	 * adds a view components to frame
	 */
	
	private void initViewConponents() {

		JLabel lblFilmName = new JLabel("введіть назву фільму для видалення :");
		lblFilmName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblFilmName.setBounds(18, 11, 209, 32);
		frame.getContentPane().add(lblFilmName);

		textField = new JTextField();
		textField.setBounds(240, 17, 132, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

}
