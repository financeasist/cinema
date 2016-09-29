package ua.com.cinema;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CinemaAddNewFilm {

	static JFrame frame;
	private JPanel contentPaneRemoveSeance;
	private JTextField textFieldFilmName;
	private JTextField textFieldCountSeance;
	private JTextField textFieldDurationFilmHH;
	private JTextField textFieldDurationFilmMm;
	private JTextField textFieldStartTimeHH;
	private JTextField textFieldStartTimeFilmMm;

	Cinema palace = CinemaGuiWindow.palace;
	String titleCin;
	Integer durationCinH;
	Integer durationCinM;
	static Integer startH1;
	static Integer startH2;
	static Integer startH3;

	static Integer startM1;
	static Integer startM2;
	static Integer startM3;
	Integer keyCheck;
	//
	// Integer seanceH;
	// Integer seanceM;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaAddNewFilm frame = new CinemaAddNewFilm();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public CinemaAddNewFilm() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 396, 252);
		contentPaneRemoveSeance = new JPanel();
		contentPaneRemoveSeance.setToolTipText("");
		contentPaneRemoveSeance.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPaneRemoveSeance);
		contentPaneRemoveSeance.setLayout(null);

		JLabel labelFilmName = new JLabel("Введіть назву фільму :");
		labelFilmName.setBounds(10, 11, 240, 25);
		contentPaneRemoveSeance.add(labelFilmName);

		textFieldFilmName = new JTextField();
		textFieldFilmName.setBounds(209, 11, 143, 25);
		contentPaneRemoveSeance.add(textFieldFilmName);
		textFieldFilmName.setColumns(10);

		JLabel lblCountSeance = new JLabel(
				"Введіть  кількість сеансів (max 3):");
		lblCountSeance.setBounds(10, 83, 215, 25);
		contentPaneRemoveSeance.add(lblCountSeance);

		textFieldCountSeance = new JTextField();
		textFieldCountSeance.setBounds(209, 83, 40, 25);
		contentPaneRemoveSeance.add(textFieldCountSeance);
		textFieldCountSeance.setColumns(10);

		JLabel lblDurationFilmtoRemoveSeanceHH = new JLabel(
				"Введіть тривалість фільму :");
		lblDurationFilmtoRemoveSeanceHH.setBounds(10, 47, 215, 25);
		contentPaneRemoveSeance.add(lblDurationFilmtoRemoveSeanceHH);

		textFieldDurationFilmHH = new JTextField();
		textFieldDurationFilmHH.setBounds(209, 47, 40, 25);
		contentPaneRemoveSeance.add(textFieldDurationFilmHH);
		textFieldDurationFilmHH.setColumns(10);

		textFieldDurationFilmMm = new JTextField();
		textFieldDurationFilmMm.setBounds(292, 47, 40, 25);
		contentPaneRemoveSeance.add(textFieldDurationFilmMm);
		textFieldDurationFilmMm.setColumns(10);

		JLabel lblTimeStart = new JLabel("Введіть час початку сеансу:");
		lblTimeStart.setBounds(10, 119, 176, 25);
		contentPaneRemoveSeance.add(lblTimeStart);

		textFieldStartTimeHH = new JTextField();
		textFieldStartTimeHH.setBounds(209, 119, 40, 25);
		contentPaneRemoveSeance.add(textFieldStartTimeHH);
		textFieldStartTimeHH.setColumns(10);

		textFieldStartTimeFilmMm = new JTextField();
		textFieldStartTimeFilmMm.setBounds(292, 119, 40, 25);
		contentPaneRemoveSeance.add(textFieldStartTimeFilmMm);
		textFieldStartTimeFilmMm.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					titleCin = textFieldFilmName.getText();

					// = textFieldTitleFilmToRemove.getText();

					durationCinH = Integer.parseInt(textFieldFilmName.getText());

					durationCinM = Integer.parseInt(textFieldDurationFilmMm
							.getText());
					keyCheck = Integer.parseInt(textFieldCountSeance.getText());

					switch (keyCheck) {
					case 1:

						palace.addMovie(new Movie(titleCin, new Time(
								durationCinH, durationCinM)), new Time(startH1,
								startM1));
						JOptionPane.showMessageDialog(null,
								" фільм із сенсами додано до розкладу!");
						break;

					case 2:
						CinemaAddNewFilm2 cinemaAddNewFilm2 = new CinemaAddNewFilm2();
						CinemaAddNewFilm2.frame.setVisible(true);

						palace.addMovie(new Movie(titleCin, new Time(
								durationCinH, durationCinM)), new Time(startH1,
								startM1), new Time(startH2, startM2));
						JOptionPane.showMessageDialog(null,
								" фільм із сенсами додано до розкладу!");
						break;
					case 3:
						// addMultSeances = new Scanner (System.in);
						// System.out.println("Введіть годину початку фільму :");
						// startH1 = addMultSeances.nextInt();
						// System.out.println("Введіть  хвилини початку фільму :");
						// startM1 = addMultSeances.nextInt();
						// System.out.println("Введіть годину початку фільму :");
						// startH2 = addMultSeances.nextInt();
						// System.out.println("Введіть  хвилини початку фільму :");
						// startM2 = addMultSeances.nextInt();
						// System.out.println("Введіть годину початку фільму :");
						// int startH3 = addMultSeances.nextInt();
						// System.out.println("Введіть  хвилини початку фільму :");
						// int startM3 = addMultSeances.nextInt();
						// palace.addMovie(new Movie (titleCin, new
						// Time(durationCinH,durationCinM)), new Time(startH1,
						// startM1), new Time(startH2,startM2), new
						// Time(startH3,startM3));
						// System.out.println(" фільм із сенсами додано до розкладу!");
						// break;

					default:
						JOptionPane.showMessageDialog(null,"Введіть 1, 2 або 3!");
						break;
					// startH1 =
					// Integer.parseInt(textFieldStartTimeHH.getText());
					//
					// startM1 =
					// Integer.parseInt(textFieldStartTimeFilmMm.getText());
					//

					// palace.removeSeance( new Seance(new Movie(titleCin, new
					// Time(durationCinH, durationCinM)), new Time(seanceH,
					// seanceM)));
					// JOptionPane.showMessageDialog(null,"сеанс  фільму " +
					// titleCin + " в " + " видалено!");
				// frame.dispose();

					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSubmit.setBounds(101, 158, 184, 41);
		contentPaneRemoveSeance.add(btnSubmit);

		label = new JLabel("  :");
		label.setBounds(272, 47, 19, 25);
		contentPaneRemoveSeance.add(label);

		label_1 = new JLabel("   год");
		label_1.setBounds(247, 58, 40, 14);
		contentPaneRemoveSeance.add(label_1);

		lblNewLabel = new JLabel("   хв");
		lblNewLabel.setBounds(327, 58, 31, 14);
		contentPaneRemoveSeance.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("   год");
		lblNewLabel_1.setBounds(247, 130, 46, 14);
		contentPaneRemoveSeance.add(lblNewLabel_1);

		label_2 = new JLabel("   :");
		label_2.setBounds(272, 124, 31, 14);
		contentPaneRemoveSeance.add(label_2);

		label_3 = new JLabel("   хв");
		label_3.setBounds(327, 130, 31, 14);
		contentPaneRemoveSeance.add(label_3);
		frame.setVisible(true);
	}
}
