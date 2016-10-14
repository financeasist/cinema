package ua.com.cinema.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Time;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.view.TransformMovie2SeanceView;

/**
 * This class calls by 'addMovieController'. In the constructor he takes param
 * 'countSeances' and adds new movie to schedule with this seances.
 * 
 * @version 1.2 10 Oct 2016
 * @author RomanGupskyi
 */ 
public class TransformMovie2SeanceController {

	public static int countSeances;
	private JFrame frame;
	private TransformMovie2SeanceView view;
	private Integer startH1;
	private Integer startM1;
	private Integer startH2;
	private Integer startM2;
	private Integer startH3;
	private Integer startM3;
	private String titleCin = AddMovieController.titleFilm;
	private Integer durationCinH = AddMovieController.durationCinH;
	private Integer durationCinM = AddMovieController.durationCinM;

	private CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);
	private Container contentPane;

	/**
	 * takes param 'countSeances' and adds new movie to schedule with this
	 * seances.
	 * 
	 * @param countSeancess
	 */
	public TransformMovie2SeanceController(int countSeancess) {
		countSeances = countSeancess;
		view = new TransformMovie2SeanceView();
		frame = view.getFrame();
		contentPane = view.getContentPane();

		JButton btnSubmit = new JButton("Submit");
		if (countSeances == 1) {
			btnSubmit.setBounds(96, 83, 156, 25);
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {

						startH1 = Integer.parseInt(view.getTextFieldStartTime1HH().getText());
						startM1 = Integer.parseInt(view.getTextFieldStartTime1Mm().getText());
						Time startTime1 = new Time(startH1, startM1);
						cinemaService.addMovie(new Movie(titleCin, new Time(durationCinH, durationCinM)), startTime1);
						JOptionPane.showMessageDialog(null,
								" фільм :'" + titleCin + "' із щоденними сенсами o '" + startTime1.toString()
										+ "' додано до розкладу!\n"
										+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

						frame.dispose();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}

				}
			});
		}
		if (countSeances == 2) {
			btnSubmit.setBounds(69, 132, 156, 25);
			btnSubmit.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {

						startH1 = Integer.parseInt(view.getTextFieldStartTime1HH().getText());
						startM1 = Integer.parseInt(view.getTextFieldStartTime1Mm().getText());
						startH2 = Integer.parseInt(view.getTextFieldStartTime2HH().getText());
						startM2 = Integer.parseInt(view.getTextFieldStartTime2Mm().getText());
						Time startTime1 = new Time(startH1, startM1);
						Time startTime2 = new Time(startH2, startM2);
						cinemaService.addMovie(new Movie(titleCin, new Time(durationCinH, durationCinM)), startTime1,
								startTime2);

						JOptionPane.showMessageDialog(null,
								" фільм :'" + titleCin + "' із щоденними сенсами o '" + startTime1.toString() + "' та "
										+ startTime2.toString() + "' додано до розкладу!\n"
										+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

						frame.dispose();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			});
		}
		if (countSeances >= 3) {
			btnSubmit.setBounds(88, 185, 156, 25);
			btnSubmit.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						startH1 = Integer.parseInt(view.getTextFieldStartTime1HH().getText());
						startM1 = Integer.parseInt(view.getTextFieldStartTime1Mm().getText());
						startH2 = Integer.parseInt(view.getTextFieldStartTime2HH().getText());
						startM2 = Integer.parseInt(view.getTextFieldStartTime2Mm().getText());
						startH3 = Integer.parseInt(view.getTextFieldStartTime3HH().getText());
						startM3 = Integer.parseInt(view.getTextFieldStartTime3Mm().getText());
						Time startTime1 = new Time(startH1, startM1);
						Time startTime2 = new Time(startH2, startM2);
						Time startTime3 = new Time(startH3, startM3);
						cinemaService.addMovie(new Movie(titleCin, new Time(durationCinH, durationCinM)), startTime1,
								startTime2, startTime3);

						JOptionPane.showMessageDialog(null,
								" фільм :'" + titleCin + "' із щоденними сенсами o '" + startTime1.toString() + "', '"
										+ startTime2.toString() + "' та " + startTime3.toString()
										+ "' додано до розкладу!\n"
										+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

						frame.dispose();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			});

		}

		contentPane.add(btnSubmit);

		frame.setVisible(true);
	}

	/**
	 * getters and setters:
	 */
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getCountSeances() {
		return countSeances;
	}

}
