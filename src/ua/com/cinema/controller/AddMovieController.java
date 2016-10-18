package ua.com.cinema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ua.com.cinema.util.ViewUtil;
import ua.com.cinema.view.AddMovieView;

/**
 * This class use AddMovieView for start window (view) for add new movie, and
 * checks how many seances user wants to create for every day. and creates
 * appropriate 'TransformMovie2SeanceController' for this count.
 * 
 * @version 1.2 10 Oct 2016
 * @author RomanGupskyi
 *
 */

public class AddMovieController {

	static String titleFilm;
	static Integer durationCinH;
	static Integer durationCinM;
	private JFrame frame;
	static Integer keyCheck;
	private AddMovieView view;
	private JButton btnSubmit;

	/**
	 * Creates the frame.
	 */
	public AddMovieController() {
		this.view = new AddMovieView();
		this.frame = view.getFrame();
		initController();
	}

	/**
	 * checks how many seances user wants to create for every day, and creates
	 * appropriate TransformMovie2SeanceController for this count.
	 */
	private void initController() {

		btnSubmit = view.getBtnSubmit();
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					titleFilm = view.getTextFieldFilmName().getText();
					durationCinH = ViewUtil.textField2Integer(view.getTextFieldDurationFilmHH());
					durationCinM = ViewUtil.textField2Integer(view.getTextFieldDurationFilmMm());
					keyCheck = Integer.parseInt(view.getTextFieldCountSeance().getText());
					TransformMovie2SeanceController addNewFilmController;
					switch (keyCheck) {
					case 1:
						addNewFilmController = new TransformMovie2SeanceController(keyCheck);
						addNewFilmController.getFrame().setVisible(true);

						break;

					case 2:
						addNewFilmController = new TransformMovie2SeanceController(keyCheck);
						addNewFilmController.getFrame().setVisible(true);

						break;
					case 3:
						addNewFilmController = new TransformMovie2SeanceController(keyCheck);
						addNewFilmController.getFrame().setVisible(true);

						break;

					default:
						JOptionPane.showMessageDialog(null, "Введіть 1, 2 або 3!");
						break;
					}

					frame.dispose();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
