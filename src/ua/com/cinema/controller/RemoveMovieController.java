package ua.com.cinema.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.service.CinemaService;

public class RemoveMovieController {

	private JFrame frame;
	private String filmName;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public RemoveMovieController() {
		buildFrame();
		initController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void buildFrame() {
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setBounds(100, 100, 409, 146);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	private void initController() {
		JLabel lblFilmName = new JLabel("введіть назву фільму для видалення :");
		lblFilmName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblFilmName.setBounds(18, 11, 209, 32);
		frame.getContentPane().add(lblFilmName);

		textField = new JTextField();
		textField.setBounds(240, 17, 132, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);
			public void actionPerformed(ActionEvent e) {
				try {
					filmName = textField.getText();
					cinemaService.removeMovie(filmName);
					JOptionPane.showMessageDialog(null, "фільм '" + filmName + "' видалено з розкладу!");
					frame.dispose();
				} catch (Exception e1) {
				}
			}
		});
		btnNewButton.setBounds(139, 54, 122, 32);
		frame.getContentPane().add(btnNewButton);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
