package ua.com.cinema;

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

public class CinemaAddSeance {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaAddSeance cinemaSeance = new CinemaAddSeance();
					cinemaSeance.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldDayToAddSeance;
	private JTextField textFieldTitleFilm;
	private JTextField textFieldDurationSeanceHH;
	private JTextField textFieldDurationSeanceMm;
	private JTextField textFieldSeanceStartTimeHH;
	private JTextField textFieldStartTimeFilmSeanceMm;

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
	public CinemaAddSeance() {

		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 473, 281);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelDayForSeance = new JLabel("Введіть день в який хочете додати сеанс (англ!):");
		labelDayForSeance.setBounds(10, 11, 302, 25);
		contentPane.add(labelDayForSeance);

		textFieldDayToAddSeance = new JTextField();
		textFieldDayToAddSeance.setBounds(322, 11, 121, 25);
		contentPane.add(textFieldDayToAddSeance);
		textFieldDayToAddSeance.setColumns(10);

		JLabel lblTitlefilmSeance = new JLabel("Введіть  назву фільму (сеансу) :");
		lblTitlefilmSeance.setBounds(10, 47, 215, 25);
		contentPane.add(lblTitlefilmSeance);

		textFieldTitleFilm = new JTextField();
		textFieldTitleFilm.setBounds(322, 47, 121, 25);
		contentPane.add(textFieldTitleFilm);
		textFieldTitleFilm.setColumns(10);

		JLabel lblDurationFilmtoSeanceHH = new JLabel("Введіть тривалість фільму :");
		lblDurationFilmtoSeanceHH.setBounds(10, 83, 215, 25);
		contentPane.add(lblDurationFilmtoSeanceHH);

		textFieldDurationSeanceHH = new JTextField();
		textFieldDurationSeanceHH.setBounds(272, 83, 40, 25);
		contentPane.add(textFieldDurationSeanceHH);
		textFieldDurationSeanceHH.setColumns(10);

		textFieldDurationSeanceMm = new JTextField();
		textFieldDurationSeanceMm.setBounds(375, 83, 40, 25);
		contentPane.add(textFieldDurationSeanceMm);
		textFieldDurationSeanceMm.setColumns(10);

		JLabel lblSeanceTimeStartHH = new JLabel("Введіть час початку сеансу:");
		lblSeanceTimeStartHH.setBounds(10, 119, 176, 25);
		contentPane.add(lblSeanceTimeStartHH);

		textFieldSeanceStartTimeHH = new JTextField();
		textFieldSeanceStartTimeHH.setBounds(272, 119, 40, 25);
		contentPane.add(textFieldSeanceStartTimeHH);
		textFieldSeanceStartTimeHH.setColumns(10);

		textFieldStartTimeFilmSeanceMm = new JTextField();
		textFieldStartTimeFilmSeanceMm.setBounds(375, 119, 40, 25);
		contentPane.add(textFieldStartTimeFilmSeanceMm);
		textFieldStartTimeFilmSeanceMm.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					day = textFieldDayToAddSeance.getText();
					titleCin = textFieldTitleFilm.getText();
					durationCinH = Integer.parseInt(textFieldDurationSeanceHH.getText());
					durationCinM = Integer.parseInt(textFieldDurationSeanceMm.getText());
					seanceH = Integer.parseInt(textFieldSeanceStartTimeHH.getText());
					seanceM = Integer.parseInt(textFieldStartTimeFilmSeanceMm.getText());

					Time durationTime = new Time(durationCinH, durationCinM);
					Time seancestartTime = new Time(seanceH, seanceM);
					
					CinemaGuiMain.palace.addSeance(day,
							new Seance(new Movie(titleCin, durationTime), seancestartTime));
					JOptionPane.showMessageDialog(null,
							"сеанс  фільму '" + titleCin + "' в " + day + " o " + seancestartTime.toString()
									+ " додано до розкладу!\n"
									+ "щоб побачити розклад, натисніть кнопку: 'вивести розклад на екран'");

					frame.dispose();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSubmit.setBounds(122, 169, 200, 50);
		contentPane.add(btnSubmit);

		label = new JLabel("     :");
		label.setBounds(339, 88, 46, 14);
		contentPane.add(label);

		label_1 = new JLabel("   год");
		label_1.setBounds(312, 94, 46, 14);
		contentPane.add(label_1);

		lblNewLabel = new JLabel("   хв");
		lblNewLabel.setBounds(416, 94, 46, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("   год");
		lblNewLabel_1.setBounds(312, 130, 46, 14);
		contentPane.add(lblNewLabel_1);

		label_2 = new JLabel("     :");
		label_2.setBounds(339, 119, 46, 14);
		contentPane.add(label_2);

		label_3 = new JLabel("   хв");
		label_3.setBounds(416, 130, 46, 14);
		contentPane.add(label_3);
		frame.setVisible(true);
	}

}
