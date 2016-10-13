package ua.com.cinema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ua.com.cinema.view.AddMovieView;

/**
 * This class creates a start window for add new movie and checks how many
 * seances user wants to create for every day. and creates appropriate
 * 'addNewFilmController' for this count.
 * 
 * version 1.2 10 Oct 2016
 * @author RomanGupskyi
 *
 */

public class AddMovieController {

	static String titleFilm;
	static Integer durationCinH;
	static Integer durationCinM;
	private JFrame frame;
	private JPanel contentPane;
	static Integer keyCheck;
	private AddMovieView view;

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
	 * appropriate addMovieController for this count.
	 */

	private void initController() {
		this.contentPane = view.getContentPane();
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					titleFilm = view.getTextFieldFilmName().getText();
					durationCinH = Integer.parseInt(view.getTextFieldDurationFilmHH().getText());
					durationCinM = Integer.parseInt(view.getTextFieldDurationFilmMm().getText());
					keyCheck = Integer.parseInt(view.getTextFieldCountSeance().getText());

					switch (keyCheck) {
					case 1:
						TransformMovie2SeanceController addNewFilmController = new TransformMovie2SeanceController(
								keyCheck);
						addNewFilmController.getFrame().setVisible(true);

						break;

					case 2:
						TransformMovie2SeanceController addNewFilmController2 = new TransformMovie2SeanceController(
								keyCheck);
						addNewFilmController2.getFrame().setVisible(true);

						break;
					case 3:
						TransformMovie2SeanceController addNewFilmController3 = new TransformMovie2SeanceController(
								keyCheck);
						addNewFilmController3.getFrame().setVisible(true);

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
		btnSubmit.setBounds(107, 129, 184, 41);
		contentPane.add(btnSubmit);

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
