package ua.com.cinema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.Seance;
import ua.com.cinema.model.Time;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.view.RemoveSeanceView;

/**
 * This class takes values from RemoveSeanceView.java and remove seance from
 * schedule;
 * 
 * @version 1.3 18 Oct 2016
 * @author RomanGrupskyi
 *
 */
public class RemoveSeanceController {

	private final static Logger logger = Logger.getLogger(RemoveSeanceController.class);
	private RemoveSeanceView view;
	private JFrame frame;
	private JButton btnSubmit;
	private String titleCin;
	private Time durationTime;
	private String day;
	private Time seanceStartTime;
	private CinemaService cinemaService;

	/**
	 * Creates the RemoveSeanceController()
	 */
	public RemoveSeanceController() {
		this.view = new RemoveSeanceView();
		this.frame = view.getFrame();
		initController();
	}

	/**
	 * this method takes selected by user values from RemoveSeanceView and
	 * removes seance;
	 */
	private void initController() {
		cinemaService = new CinemaService(CinemaGuiMain.palace);
		btnSubmit = view.getBtnSubmit();

		btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					logger.info(" Button 'delete seance' was perfomed!");
					day = RemoveSeanceView.getDay();
					titleCin = RemoveSeanceView.getTitleFilmtoRemove();
					durationTime = RemoveSeanceView.getDurationTime();
					seanceStartTime = RemoveSeanceView.getSeanceStartTime();
					cinemaService.removeSeance(day, new Seance(new Movie(titleCin, durationTime), seanceStartTime));
					JOptionPane.showMessageDialog(null, "сеанс  фільму '" + titleCin + "' в " + day + " o "
							+ seanceStartTime.toString() + " видалено!");
					frame.dispose();
					logger.info("seance movie 'titleCin' at " + seanceStartTime + " in " + day
							+ " was succsessfully removed!");

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

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
