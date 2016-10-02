package ua.com.cinema;
/**
*
* @author RomanGrupskyi;
*/
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CinemaGuiMain {

	static Cinema palace = new Cinema(new Time(8, 30), new Time(23, 30));

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

	private JFrame frame;

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
				CinemaAddNewFilmStartWindow cinemaAddNewFilm = new CinemaAddNewFilmStartWindow();
				cinemaAddNewFilm.getFrame().setVisible(true);
			}
		});
		btnAddnewFilm.setBounds(35, 39, 200, 50);
		frame.getContentPane().add(btnAddnewFilm);

		JButton btnAddNewSeance = new JButton("Додати сеанс");
		btnAddNewSeance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CinemaAddSeance cinemaAddSeance = new CinemaAddSeance();
				cinemaAddSeance.getFrame().setVisible(true);
			}
		});
		btnAddNewSeance.setBounds(35, 100, 200, 50);
		frame.getContentPane().add(btnAddNewSeance);

		JButton btnRemoveFilmFromList = new JButton("Видалити фільм зі списку");
		btnRemoveFilmFromList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CinemaRemoveMovie cinemaRemoveMovie = new CinemaRemoveMovie();
					cinemaRemoveMovie.getFrame().setVisible(true);

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
					
					CinemaRemoveSeance cinGuiRemoveSeance = new CinemaRemoveSeance();
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
			public void actionPerformed(ActionEvent e) {
				try {
					palace.addMovie(new Movie("Transformers 2", new Time(2, 34)), new Time(10, 20), new Time(20, 10));
					palace.addMovie(new Movie("Heaven's kingdom", new Time(2, 12)), new Time(9, 10));
					palace.addMovie(new Movie("Lion King", new Time(1, 36)), new Time(14, 50), new Time(16, 0),
							new Time(8, 30));
					palace.addMovie(new Movie("Hobbit 2", new Time(2, 48)), new Time(12, 45), new Time(22, 15));
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

					CinemaShowSchedule cinemaShowSchedule = new CinemaShowSchedule();
					cinemaShowSchedule.getFrame().setVisible(true);

					CinemaShowSchedule.textArea.setText(palace.toString());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnShowSchedule.setBounds(35, 362, 200, 50);
		frame.getContentPane().add(btnShowSchedule);

		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/oscar.png").getFile());
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(245, 11, 487, 408);
		frame.getContentPane().add(lblNewLabel);
		

	}
}
