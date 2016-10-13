package ua.com.cinema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.view.RemoveMovieView;

/**
 * This class completely removes movie from schedule
 * 
 * version 1.2 10 Oct 2016
 * 
 * @author RomanGupskyi
 */
public class RemoveMovieController {

	private JFrame frame;
	private String filmName;
	private RemoveMovieView view;

	/**
	 * creates window for this class
	 */
	public RemoveMovieController() {
		view = new RemoveMovieView();
		frame = view.getFrame();
		initController();
	}
	/**
	 * it is actually a method that removes movie from schedule
	 */
	private void initController() {
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);

			public void actionPerformed(ActionEvent e) {
				try {
					filmName = view.getTextField().getText();
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
