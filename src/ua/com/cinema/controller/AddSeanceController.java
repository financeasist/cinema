package ua.com.cinema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.Seance;
import ua.com.cinema.model.Time;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.util.SeanceUtil;
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
	 * this method describe what will happend when user enter a buttton
	 * 'додати сеанс'. exactly he adds a new seance to schedule;
	 */
	public void initController() {

		btnSubmit = view.getBtnSubmit();
		btnSubmit.addActionListener(new ActionListener() {
			CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);

			public void actionPerformed(ActionEvent e) {
				try {

					day = view.getDay();
					titleMovie = view.getTitle();
					durationTime = view.getDurationTime();
					seanceH = Integer.parseInt(view.getTextFieldSeanceStartTimeHH().getText());
					seanceM = Integer.parseInt(view.getTextFieldStartTimeFilmSeanceMm().getText());
					Time seanceStartTime = new Time(seanceH, seanceM);
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
						} else
							JOptionPane.showMessageDialog(null,
									"Ви ввели не вірний час сеансу! Будь-ласка, узгодьте його з годинами роботи кінотеатру!");

					} else
						JOptionPane.showMessageDialog(null,
								"Ви ввели не вірний час сеансу! Будь-ласка, узгодьте його з годинами роботи кінотеатру!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
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
