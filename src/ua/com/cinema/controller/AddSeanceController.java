package ua.com.cinema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.Seance;
import ua.com.cinema.model.Time;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.util.SeanceUtil;
import ua.com.cinema.util.ViewUtil;
import ua.com.cinema.view.AddSeanceView;

/**
 * This class uses a start window (view), and takes values from
 * 'AddSeanceView.java'. and adds a new seance for movie, in day which user had
 * selected in this view.
 * 
 * @version 1.2 10 Oct 2016
 * @author RomanGupskyi
 */
public class AddSeanceController {
	private final static Logger logger = Logger.getLogger(AddSeanceController.class);
	static JFrame frame;
	static AddSeanceView view;

	private String day;
	private String titleMovie;
	private Time durationTime;
	private Integer seanceH;
	private Integer seanceM;
	private AbstractButton btnSubmit;

	/**
	 * Creates the view for user using 'AddSeanceView' class; .
	 */
	public AddSeanceController() {
		view = new AddSeanceView();
		frame = view.getFrame();
		initController();
	}

	/**
	 * this method describe what will happend when user enter a buttton 'додати
	 * сеанс'. exactly he adds a new seance to schedule;
	 */
	public void initController() {
		logger.info("initController() was started!");
		btnSubmit = view.getBtnSubmit();
		btnSubmit.addActionListener(new ActionListener() {
			CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);

			public void actionPerformed(ActionEvent e) {
				
				try {
					logger.info(" Button 'додати сеанс' was perfomed!");
					day = view.getDay();
					titleMovie = view.getTitle();
					durationTime = view.getDurationTime();
					seanceH = ViewUtil.textField2Integer(view.getTextFieldSeanceStartTimeHH());
					seanceM = ViewUtil.textField2Integer(view.getTextFieldStartTimeFilmSeanceMm());
					Time seanceStartTime = new Time(seanceH, seanceM);
					logger.info(" user entered Time for seance " + seanceStartTime + " !");
					Time seanceEndTime = SeanceUtil.calculateEndTime(seanceStartTime, durationTime);
					boolean isCorrectTime = cinemaService.compareWithCinemaWorkingTime(seanceStartTime, seanceEndTime);
					/**
					 * checks seance time
					 */
					if (isCorrectTime) {
						boolean isAdded = cinemaService.addSeance(day,
								new Seance(new Movie(titleMovie, durationTime), seanceStartTime));
						if (isAdded) {
							JOptionPane.showMessageDialog(null,
									"сеанс  фільму '" + titleMovie + "' в " + day + " o " + seanceStartTime.toString()
											+ " додано до розкладу!\n"
											+ "щоб побачити розклад, натисніть кнопку: 'вивести розклад на екран'");

							frame.dispose();
							logger.info(
									"new seance '" + titleMovie + "' at :" + seanceStartTime + " succssesfully added!");
						}
					} else{
						JOptionPane.showMessageDialog(null,
								"Ви ввели не вірний час сеансу! Будь-ласка, узгодьте його з годинами роботи кінотеатру!");
					logger.info("user entered wrong time for seance!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					logger.log(Level.INFO, e1.getMessage());
				}
			}
		});

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame framee) {
		frame = framee;
	}
}
