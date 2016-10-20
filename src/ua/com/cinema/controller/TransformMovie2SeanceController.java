package ua.com.cinema.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.Time;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.util.SeanceUtil;
import ua.com.cinema.util.ViewUtil;
import ua.com.cinema.view.TransformMovie2SeanceView;

/**
 * This class calls by 'addMovieController'. In the constructor he takes param
 * 'countSeances' and adds new movie to schedule with this seances.
 * 
 * @version 1.3 18 Oct 2016
 * @author RomanGupskyi
 */
public class TransformMovie2SeanceController {

	private final static Logger logger = Logger.getLogger(TransformMovie2SeanceController.class);
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
		logger.info(" User entered countOfSeances ='" + countSeancess + "'! \n"
				+ " Initialize TransformMovie2SeanceController for ('" + countSeancess + "') seances was started!");
		countSeances = countSeancess;
		view = new TransformMovie2SeanceView();
		frame = view.getFrame();
		contentPane = view.getContentPane();
		Time durationTime = new Time(durationCinH, durationCinM);
		JButton btnSubmit = new JButton("Додати фільм");

		if (countSeances == 1) {
			btnSubmit.setBounds(96, 83, 156, 25);
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logger.info(" Button 'Додати фільм' with '" + countSeances + "' seances was perfomed!");
					try {
						startH1 = ViewUtil.textField2Integer(view.getTextFieldStartTime1HH());
						startM1 = ViewUtil.textField2Integer(view.getTextFieldStartTime1Mm());
						Time startTime1 = new Time(startH1, startM1);
						Time endTime1 = SeanceUtil.calculateEndTime(startTime1, durationTime);
						/**
						 * checks time is correct and add movie
						 */
						boolean isCorrectTime1 = cinemaService.compareWithCinemaWorkingTime(startTime1, endTime1);
						if (isCorrectTime1) {
							boolean isAdded = cinemaService.addMovie(new Movie(titleCin, durationTime), startTime1);
							if (isAdded) {
								JOptionPane.showMessageDialog(null, " фільм :'" + titleCin
										+ "' із щоденними сенсами o '" + startTime1.toString()
										+ "' додано до розкладу!\n"
										+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

								frame.dispose();
								logger.info("New movie '" + titleCin + "' with '" + countSeances + "' seances at "
										+ startTime1.toString() + " was succsessfully edded!");
							} else {
								JOptionPane.showMessageDialog(null,
										"Ви ввели не вірний час сеансу! Будь-ласка, узгодьте його з годинами роботи кінотеатру!");
								logger.info("User entered wrong time for seance!");
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Ви ввели не вірний час сеансу! Будь-ласка, узгодьте його з годинами роботи кінотеатру!");
							logger.info("User entered wrong time for seance!");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
						logger.log(Level.INFO, e1.getMessage().toUpperCase());
					}

				}
			});
		}
		if (countSeances == 2) {
			btnSubmit.setBounds(69, 132, 156, 25);
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						logger.info(" Button 'Додати фільм' with '" + countSeances + "' seances was perfomed!");
						startH1 = ViewUtil.textField2Integer(view.getTextFieldStartTime1HH());
						startM1 = ViewUtil.textField2Integer(view.getTextFieldStartTime1Mm());
						startH2 = ViewUtil.textField2Integer(view.getTextFieldStartTime2HH());
						startM2 = ViewUtil.textField2Integer(view.getTextFieldStartTime2Mm());

						Time startTime1 = new Time(startH1, startM1);
						Time endTime1 = SeanceUtil.calculateEndTime(startTime1, durationTime);
						Time startTime2 = new Time(startH2, startM2);
						Time endTime2 = SeanceUtil.calculateEndTime(startTime2, durationTime);
						boolean isCorrectTime1 = cinemaService.compareWithCinemaWorkingTime(startTime1, endTime1);
						boolean isCorrectTime2 = cinemaService.compareWithCinemaWorkingTime(startTime2, endTime2);
						/**
						 * checks time is correct:
						 */
						if (isCorrectTime1 && isCorrectTime2) {
							/**
							 * trys to add movie
							 */
							boolean isAdded = cinemaService.addMovie(new Movie(titleCin, durationTime), startTime1,
									startTime2);
							if (isAdded) {
								JOptionPane.showMessageDialog(null, " фільм :'" + titleCin
										+ "' із щоденними сенсами o '" + startTime1.toString() + "' та "
										+ startTime2.toString() + "' додано до розкладу!\n"
										+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

								frame.dispose();

								logger.info("new movie '" + titleCin + "' with '" + countSeances + "' seances at "
										+ startTime1.toString() + " and " + startTime2.toString()
										+ " was succsessfully edded!");
							} else {
								JOptionPane.showMessageDialog(null,
										"Ви ввели не вірний час сеансу! Будь-ласка, узгодьте його з годинами роботи кінотеатру!");
								logger.info("User entered wrong time for seance!");
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Ви ввели не вірний час сеансу! Будь-ласка, узгодьте його з годинами роботи кінотеатру!");
							logger.info("User entered wrong time for seance!");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
						logger.log(Level.INFO, e1.getMessage().toUpperCase());
					}
				}
			});
		}
		if (countSeances >= 3) {
			btnSubmit.setBounds(88, 185, 156, 25);
			btnSubmit.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					logger.info(" Button 'Додати фільм' with " + countSeances + " seances was perfomed!");
					try {
						startH1 = ViewUtil.textField2Integer(view.getTextFieldStartTime1HH());
						startM1 = ViewUtil.textField2Integer(view.getTextFieldStartTime1Mm());
						startH2 = ViewUtil.textField2Integer(view.getTextFieldStartTime2HH());
						startM2 = ViewUtil.textField2Integer(view.getTextFieldStartTime2Mm());
						startH3 = ViewUtil.textField2Integer(view.getTextFieldStartTime3HH());
						startM3 = ViewUtil.textField2Integer(view.getTextFieldStartTime3Mm());
						Time startTime1 = new Time(startH1, startM1);
						Time endTime1 = SeanceUtil.calculateEndTime(startTime1, durationTime);
						Time startTime2 = new Time(startH2, startM2);
						Time endTime2 = SeanceUtil.calculateEndTime(startTime2, durationTime);
						Time startTime3 = new Time(startH3, startM3);
						Time endTime3 = SeanceUtil.calculateEndTime(startTime3, durationTime);
						boolean isCorrectTime1 = cinemaService.compareWithCinemaWorkingTime(startTime1, endTime1);
						boolean isCorrectTime2 = cinemaService.compareWithCinemaWorkingTime(startTime2, endTime2);
						boolean isCorrectTime3 = cinemaService.compareWithCinemaWorkingTime(startTime3, endTime3);
						if (isCorrectTime1 && isCorrectTime2 && isCorrectTime3) {
							boolean isAdded = cinemaService.addMovie(new Movie(titleCin, durationTime), startTime1,
									startTime2, startTime3);
							if (isAdded) {
								JOptionPane.showMessageDialog(null, " фільм :'" + titleCin
										+ "' із щоденними сенсами o '" + startTime1.toString() + "', '"
										+ startTime2.toString() + "' та " + startTime3.toString()
										+ "' додано до розкладу!\n"
										+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

								frame.dispose();
								logger.info("New movie '" + titleCin + "' with '" + countSeances + "' seances at "
										+ startTime1.toString() + " ; " + startTime2.toString() + " and "
										+ startTime3.toString() + " was succsessfully edded!");
							} else {
								JOptionPane.showMessageDialog(null,
										"Ви ввели не вірний час сеансу! Будь-ласка, узгодьте його з годинами роботи кінотеатру!");
								logger.info("User entered wrong time for seance!");
							}

						} else {
							JOptionPane.showMessageDialog(null,
									"Ви ввели не вірний час сеансу! Будь-ласка, узгодьте його з годинами роботи кінотеатру!");
							logger.info("User entered wrong time for seance!");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
						logger.log(Level.INFO, e1.getMessage());
					}
				}
			});

		}

		contentPane.add(btnSubmit);

		frame.setVisible(true);
	}

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
