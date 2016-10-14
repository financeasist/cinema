package ua.com.cinema.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ua.com.cinema.controller.AddMovieController;
import ua.com.cinema.controller.AddSeanceController;
import ua.com.cinema.controller.RemoveMovieController;
import ua.com.cinema.controller.RemoveSeanceController;
import ua.com.cinema.models.Cinema;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Time;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.view.CinemaGuiMainView;
import ua.com.cinema.view.ShowScheduleView;

/**
 * This is the main class for GUI application; The main JFraime calls from
 * 'CinemaGuiMainView'. This class creates bunnons with appropriate
 * classes, which calls appropriate methods.
 * 
 * @version 1.2 12 Oct 2016
 * @author RomanGrupskiy
 */

public class CinemaGuiMain {

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
		view = new CinemaGuiMainView();
		frame = view.getFrame();
		initialize();
	}

	/**
	 * adds a view components to frame.
	 * Here user selects what he wants to do.
	 */
	private void initialize() {

		JButton btnAddnewFilm = new JButton("Додати фільм з сеансами");
		btnAddnewFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMovieController cinemaAddNewFilm = new AddMovieController();
				cinemaAddNewFilm.getFrame().setVisible(true);
			}
		});
		btnAddnewFilm.setBounds(35, 39, 200, 50);
		frame.getContentPane().add(btnAddnewFilm);

		JButton btnAddNewSeance = new JButton("Додати сеанс");
		btnAddNewSeance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSeanceController addSeanceController = new AddSeanceController();
				addSeanceController.getFrame().setVisible(true);
			}
		});
		btnAddNewSeance.setBounds(35, 100, 200, 50);
		frame.getContentPane().add(btnAddNewSeance);

		JButton btnRemoveFilmFromList = new JButton("Видалити фільм ");
		btnRemoveFilmFromList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RemoveMovieController removeMovieController = new RemoveMovieController();
					removeMovieController.getFrame().setVisible(true);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});

		btnRemoveFilmFromList.setBounds(35, 171, 200, 50);
		frame.getContentPane().add(btnRemoveFilmFromList);

		JButton btnRemoveSeance = new JButton("Видалити сеанс");
		btnRemoveSeance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					RemoveSeanceController cinGuiRemoveSeance = new RemoveSeanceController();
					cinGuiRemoveSeance.getFrame().setVisible(true);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnRemoveSeance.setBounds(35, 232, 200, 50);
		frame.getContentPane().add(btnRemoveSeance);

		JButton btnSetPrepaireSchedule = new JButton("Заповнити розклад улюбленими фільмами");
		btnSetPrepaireSchedule.addActionListener(new ActionListener() {
			CinemaService cinemaService = new CinemaService(palace);

			public void actionPerformed(ActionEvent e) {
				try {
					cinemaService.addMovie(new Movie("Transformers 2", new Time(2, 34)), new Time(10, 20),
							new Time(20, 10));
					cinemaService.addMovie(new Movie("Heaven's kingdom", new Time(2, 12)), new Time(9, 10));
					cinemaService.addMovie(new Movie("Lion King", new Time(1, 36)), new Time(14, 50), new Time(16, 0),
							new Time(8, 30));
					cinemaService.addMovie(new Movie("Hobbit 2", new Time(2, 48)), new Time(12, 45), new Time(22, 15));
					JOptionPane.showMessageDialog(null, "films succsessfully edded to schedule!" + "\n"
							+ "натисніть 'показати розклад' щоб вивести розклад на екран!");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnSetPrepaireSchedule.setBounds(35, 298, 200, 50);
		frame.getContentPane().add(btnSetPrepaireSchedule);

		JButton btnShowSchedule = new JButton("Вивести розклад на екран");
		btnShowSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					ShowScheduleView showScheduleView = new ShowScheduleView();
					showScheduleView.getFrame().setVisible(true);

					ShowScheduleView.textArea.setText(palace.toString());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnShowSchedule.setBounds(35, 362, 200, 50);
		frame.getContentPane().add(btnShowSchedule);

	}
}
