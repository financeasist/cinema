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
 * This class uses values from 'RemoveMovieView.java', and completely removes
 * movie from schedule, which user had written in 'RemoveMovieView'.
 * 
 * @version 1.2 10 Oct 2016
 * @author RomanGupskyi
 */
public class RemoveMovieController {

	private JFrame frame;
	private String filmName;
	private RemoveMovieView view;
	private JButton buttonSubmit;

	/**
	 * creates window for this class
	 */
	public RemoveMovieController() {
		view = new RemoveMovieView();
		frame = view.getFrame();
		initController();
	}

	/**
	 * it is actually a method which removes movie from schedule;
	 */
	private void initController() {
		buttonSubmit = view.getButtonSubmit();
		buttonSubmit.addActionListener(new ActionListener() {
			CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);

			public void actionPerformed(ActionEvent e) {
				try {
					filmName = view.getTextField().getText();
					boolean isRemoved = cinemaService.removeMovie(filmName);
					if (isRemoved)
						JOptionPane.showMessageDialog(null, "фільм '" + filmName + "' видалено з розкладу!");
					else
						JOptionPane.showMessageDialog(null, "фільму '" + filmName + "' в розкладі нема!");
					frame.dispose();
				} catch (Exception e1) {
				}
			}
		});

	}

	/**
	 * here is getters and setters:
	 */
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
