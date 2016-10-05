package ua.com.cinema.action;

/**
*
* @author RomanGrupskyi;
*/
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ua.com.cinema.models.Cinema;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Seance;
import ua.com.cinema.models.Time;

public class CinemaRemoveSeance {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaRemoveSeance cinemaRemoveSeance = new CinemaRemoveSeance();
					cinemaRemoveSeance.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrame frame;
	private JPanel contentPaneRemoveSeance;
	private JTextField textFieldDayToRemoveSeance;
	private JTextField textFieldTitleFilmToRemove;
	private JTextField textFieldDurationFilmToRemoveSeanceHH;
	private JTextField textFieldDurationFilmToRemoveSeanceMm;
	private JTextField textFieldRemoveSeanceStartTimeHH;
	private JTextField textFieldStartTimeFilmToRemoveSeanceMm;

	Cinema palace = CinemaGuiMain.palace;
	private String titleCin;
	private Integer durationCinH;
	private Integer durationCinM;
	private String day;
	private Integer seanceH;
	private Integer seanceM;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label_2;

	private JLabel label_3;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Create the frame.
	 */
	public CinemaRemoveSeance() {

		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 473, 281);
		contentPaneRemoveSeance = new JPanel();
		contentPaneRemoveSeance.setToolTipText("");
		contentPaneRemoveSeance.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPaneRemoveSeance);
		contentPaneRemoveSeance.setLayout(null);

		JLabel labelDayForRemoveSeance = new JLabel("Введіть день сеансу для видаленя з розкладу:");
		labelDayForRemoveSeance.setBounds(10, 11, 302, 25);
		contentPaneRemoveSeance.add(labelDayForRemoveSeance);

		textFieldDayToRemoveSeance = new JTextField();
		textFieldDayToRemoveSeance.setBounds(322, 11, 121, 25);
		contentPaneRemoveSeance.add(textFieldDayToRemoveSeance);
		textFieldDayToRemoveSeance.setColumns(10);

		JLabel lblTitlefilmSeanceToRemove = new JLabel("Введіть  назву фільму (сеансу) :");
		lblTitlefilmSeanceToRemove.setBounds(10, 47, 215, 25);
		contentPaneRemoveSeance.add(lblTitlefilmSeanceToRemove);

		textFieldTitleFilmToRemove = new JTextField();
		textFieldTitleFilmToRemove.setBounds(322, 47, 121, 25);
		contentPaneRemoveSeance.add(textFieldTitleFilmToRemove);
		textFieldTitleFilmToRemove.setColumns(10);

		JLabel lblDurationFilmtoRemoveSeanceHH = new JLabel("Введіть тривалість фільму :");
		lblDurationFilmtoRemoveSeanceHH.setBounds(10, 83, 215, 25);
		contentPaneRemoveSeance.add(lblDurationFilmtoRemoveSeanceHH);

		textFieldDurationFilmToRemoveSeanceHH = new JTextField();
		textFieldDurationFilmToRemoveSeanceHH.setBounds(272, 83, 40, 25);
		contentPaneRemoveSeance.add(textFieldDurationFilmToRemoveSeanceHH);
		textFieldDurationFilmToRemoveSeanceHH.setColumns(10);

		textFieldDurationFilmToRemoveSeanceMm = new JTextField();
		textFieldDurationFilmToRemoveSeanceMm.setBounds(375, 83, 40, 25);
		contentPaneRemoveSeance.add(textFieldDurationFilmToRemoveSeanceMm);
		textFieldDurationFilmToRemoveSeanceMm.setColumns(10);

		JLabel lblRemoveSeanceTimeStartHH = new JLabel("Введіть час початку сеансу:");
		lblRemoveSeanceTimeStartHH.setBounds(10, 119, 176, 25);
		contentPaneRemoveSeance.add(lblRemoveSeanceTimeStartHH);

		textFieldRemoveSeanceStartTimeHH = new JTextField();
		textFieldRemoveSeanceStartTimeHH.setBounds(272, 119, 40, 25);
		contentPaneRemoveSeance.add(textFieldRemoveSeanceStartTimeHH);
		textFieldRemoveSeanceStartTimeHH.setColumns(10);

		textFieldStartTimeFilmToRemoveSeanceMm = new JTextField();
		textFieldStartTimeFilmToRemoveSeanceMm.setBounds(375, 119, 40, 25);
		contentPaneRemoveSeance.add(textFieldStartTimeFilmToRemoveSeanceMm);
		textFieldStartTimeFilmToRemoveSeanceMm.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					day = textFieldDayToRemoveSeance.getText();

					titleCin = textFieldTitleFilmToRemove.getText();

					durationCinH = Integer.parseInt(textFieldDurationFilmToRemoveSeanceHH.getText());

					durationCinM = Integer.parseInt(textFieldDurationFilmToRemoveSeanceMm.getText());

					seanceH = Integer.parseInt(textFieldRemoveSeanceStartTimeHH.getText());
					seanceM = Integer.parseInt(textFieldStartTimeFilmToRemoveSeanceMm.getText());
					Time seancestartTime = new Time(seanceH, seanceM);
					palace.removeSeance(day,
							new Seance(new Movie(titleCin, new Time(durationCinH, durationCinM)), seancestartTime));
					JOptionPane.showMessageDialog(null, "сеанс  фільму '" + titleCin + "' в " + day + " o "
							+ seancestartTime.toString() + " видалено!");

					frame.dispose();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSubmit.setBounds(122, 169, 200, 50);
		contentPaneRemoveSeance.add(btnSubmit);

		label = new JLabel("     :");
		label.setBounds(339, 88, 46, 14);
		contentPaneRemoveSeance.add(label);

		label_1 = new JLabel("   год");
		label_1.setBounds(312, 94, 46, 14);
		contentPaneRemoveSeance.add(label_1);

		lblNewLabel = new JLabel("   хв");
		lblNewLabel.setBounds(416, 94, 46, 14);
		contentPaneRemoveSeance.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("   год");
		lblNewLabel_1.setBounds(312, 130, 46, 14);
		contentPaneRemoveSeance.add(lblNewLabel_1);

		label_2 = new JLabel("     :");
		label_2.setBounds(339, 119, 46, 14);
		contentPaneRemoveSeance.add(label_2);

		label_3 = new JLabel("   хв");
		label_3.setBounds(416, 130, 46, 14);
		contentPaneRemoveSeance.add(label_3);
		frame.setVisible(true);
	}

}
