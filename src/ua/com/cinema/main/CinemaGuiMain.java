package ua.com.cinema.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ua.com.cinema.controller.AddNewFilmStartWindowController;
import ua.com.cinema.controller.AddSeanceController;
import ua.com.cinema.controller.RemoveMovieController;
import ua.com.cinema.controller.RemoveSeanceController;
import ua.com.cinema.controller.ShowSchedule;
import ua.com.cinema.models.Cinema;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Time;
import ua.com.cinema.service.CinemaService;

public class CinemaGuiMain {

	private JFrame frame;
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
	 * Create the application.
	 */
	public CinemaGuiMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setBounds(100, 100, 758, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnAddnewFilm = new JButton("Додати фільм з сеансами");
		btnAddnewFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewFilmStartWindowController cinemaAddNewFilm = new AddNewFilmStartWindowController();
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

		JButton btnRemoveFilmFromList = new JButton("Видалити фільм зі списку");
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

					ShowSchedule showSchedule = new ShowSchedule();
					showSchedule.getFrame().setVisible(true);

					ShowSchedule.textArea.setText(palace.toString());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnShowSchedule.setBounds(35, 362, 200, 50);
		frame.getContentPane().add(btnShowSchedule);

		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/img/oscar.png").getFile());
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(245, 11, 487, 408);
		frame.getContentPane().add(lblNewLabel);

	}
}
