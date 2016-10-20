package ua.com.cinema.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import ua.com.cinema.controller.AddMovieController;
import ua.com.cinema.controller.AddSeanceController;
import ua.com.cinema.controller.RemoveMovieController;
import ua.com.cinema.controller.RemoveSeanceController;
import ua.com.cinema.model.Cinema;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.Time;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.view.CinemaGuiMainView;
import ua.com.cinema.view.ShowScheduleView;

/**
 * This is the main class for GUI application; The main JFraime calls from
 * 'CinemaGuiMainView'. This class creates bunnons with appropriate classes,
 * which calls appropriate methods.
 * 
 * @version 1.2 12 Oct 2016
 * @author RomanGrupskiy
 */
public class CinemaGuiMain {
	private static final Logger logger = Logger.getLogger(CinemaGuiMain.class);
	private JFrame frame;
	private CinemaGuiMainView view;
	public static Cinema palace = new Cinema(new Time(8, 30), new Time(23, 30));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaGuiMain window = new CinemaGuiMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Called JFrame from CinemaGuiMainView for this class.
	 */
	public CinemaGuiMain() {
		InitStartWindow();
		initComponentsForWindow();
	}

	public void InitStartWindow() {
		view = new CinemaGuiMainView();
		frame = view.getFrame();
	}

	/**
	 * adds a view components to frame. Here user selects what he wants to do.
	 */
	private void initComponentsForWindow() {
		logger.info(" init components for CinemaGuiMain start's window was started!");
		JButton btnAddnewFilm = new JButton("Додати фільм з сеансами");

		btnAddnewFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("\n ---button 'Додати фільм з сеансами' was perfomed!--- ");
				AddMovieController cinemaAddNewFilm = new AddMovieController();
				cinemaAddNewFilm.getFrame().setVisible(true);
			}
		});
		btnAddnewFilm.setBounds(35, 39, 200, 50);
		frame.getContentPane().add(btnAddnewFilm);

		JButton btnAddNewSeance = new JButton("Додати сеанс");
		btnAddNewSeance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("\n ---button 'Додати сеанс' was perfomed!--- ");
				AddSeanceController addSeanceController = new AddSeanceController();
				addSeanceController.getFrame().setVisible(true);
			}
		});
		btnAddNewSeance.setBounds(35, 100, 200, 50);
		frame.getContentPane().add(btnAddNewSeance);

		JButton btnRemoveFilmFromList = new JButton("Видалити фільм ");
		btnRemoveFilmFromList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info(" \n ---button 'Видалити фільм' was perfomed!--- ");
				try {
					RemoveMovieController removeMovieController = new RemoveMovieController();
					removeMovieController.getFrame().setVisible(true);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					logger.log(Level.WARN, e1.getMessage().toUpperCase());
				}

			}
		});

		btnRemoveFilmFromList.setBounds(35, 171, 200, 50);
		frame.getContentPane().add(btnRemoveFilmFromList);

		JButton btnRemoveSeance = new JButton("Видалити сеанс");
		btnRemoveSeance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("\n ---button 'Видалити сеанс' was perfomed!--- ");
				try {

					RemoveSeanceController cinGuiRemoveSeance = new RemoveSeanceController();
					cinGuiRemoveSeance.getFrame().setVisible(true);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					logger.log(Level.WARN, e1.getMessage().toUpperCase());
				}

			}
		});
		btnRemoveSeance.setBounds(35, 232, 200, 50);
		frame.getContentPane().add(btnRemoveSeance);

		JButton btnSetPrepaireSchedule = new JButton("Заповнити розклад улюбленими фільмами");
		btnSetPrepaireSchedule.addActionListener(new ActionListener() {

			CinemaService cinemaService = new CinemaService(palace);

			public void actionPerformed(ActionEvent e) {
				logger.info("\n ---button 'Заповнити розклад улюбленими фільмами' was perfomed!--- ");
				try {
					cinemaService.addMovie(new Movie("Transformers 2", new Time(2, 34)), new Time(10, 20),
							new Time(20, 10));
					cinemaService.addMovie(new Movie("Heaven's kingdom", new Time(2, 12)), new Time(9, 10));
					cinemaService.addMovie(new Movie("Lion King", new Time(1, 36)), new Time(14, 50), new Time(16, 0),
							new Time(8, 30));
					cinemaService.addMovie(new Movie("Hobbit 2", new Time(2, 48)), new Time(12, 45), new Time(20, 15));
					JOptionPane.showMessageDialog(null, "фільми успішно додані до розкладу!" + "\n"
							+ "натисніть 'показати розклад' щоб вивести розклад на екран!");
					logger.info("films succsessfully edded to schedule!");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					logger.log(Level.WARN, e1.getMessage().toUpperCase());
				}

			}
		});
		btnSetPrepaireSchedule.setBounds(35, 298, 200, 50);
		frame.getContentPane().add(btnSetPrepaireSchedule);

		JButton btnShowSchedule = new JButton("Вивести розклад на екран");
		btnShowSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("\n --- button 'Вивести розклад на екран' was perfomed!--- ");
				ShowScheduleView showScheduleView;
				try {

					showScheduleView = new ShowScheduleView();
					showScheduleView.getFrame().setVisible(true);
					ShowScheduleView.textArea.setText(palace.toString());
					logger.info("Schedule was showed!");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnShowSchedule.setBounds(35, 362, 200, 50);
		frame.getContentPane().add(btnShowSchedule);

	}
}
