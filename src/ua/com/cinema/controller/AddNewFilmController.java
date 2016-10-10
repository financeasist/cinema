package ua.com.cinema.controller;

/**
 *
 * @author RomanGrupskyi;
 */
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

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Time;
import ua.com.cinema.service.CinemaService;

public class AddNewFilmController {

	private JFrame frame;
	private Integer startH1;
	private Integer startM1;
	private Integer startH2;
	private Integer startM2;
	private Integer startH3;
	private Integer startM3;

	private JLabel label_1;
	private JLabel lblNewLabel;
	private JPanel contentPane;

	private JTextField textFieldStartTime1HH;
	private JTextField textFieldStartTime1Mm;
	private JTextField textFieldStartTime2HH;
	private JTextField textFieldStartTime2Mm;
	private JTextField textFieldStartTime3HH;
	private JTextField textFieldStartTime3Mm;
	private String titleCin = AddNewFilmStartWindowController.titleFilm;
	private Integer durationCinH = AddNewFilmStartWindowController.durationCinH;
	private Integer durationCinM = AddNewFilmStartWindowController.durationCinM;

	private CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);

	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public AddNewFilmController(int countSeances) {
		buildFrame();
		initController(AddNewFilmStartWindowController.keyCheck);
	}

	private void buildFrame() {
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 345, 162);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	private void initController(int countOfSeances) {
		JLabel labelInfo = new JLabel("Ви вибрали кількість сеансів : " + countOfSeances);
		labelInfo.setBounds(65, 11, 254, 25);
		labelInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(labelInfo);

		if (countOfSeances >= 1) {
			JLabel lblTimeStart1 = new JLabel("Введіть час початку сеансу 1:");
			lblTimeStart1.setBounds(10, 47, 190, 25);
			contentPane.add(lblTimeStart1);

			textFieldStartTime1HH = new JTextField();
			textFieldStartTime1HH.setBounds(199, 47, 26, 25);
			contentPane.add(textFieldStartTime1HH);
			textFieldStartTime1HH.setColumns(10);

			textFieldStartTime1Mm = new JTextField();
			textFieldStartTime1Mm.setBounds(261, 47, 31, 25);
			contentPane.add(textFieldStartTime1Mm);
			textFieldStartTime1Mm.setColumns(10);

			label_1 = new JLabel("  год :");
			label_1.setBounds(221, 52, 43, 14);
			contentPane.add(label_1);

			lblNewLabel = new JLabel("   хв");
			lblNewLabel.setBounds(285, 52, 31, 14);
			contentPane.add(lblNewLabel);

		}

		if (countOfSeances >= 2) {
			frame.setBounds(100, 100, 351, 216);
			JLabel lblTimeStart2 = new JLabel("Введіть час початку сеансу 2:");
			lblTimeStart2.setBounds(10, 95, 190, 25);
			contentPane.add(lblTimeStart2);

			textFieldStartTime1HH = new JTextField();
			textFieldStartTime1HH.setBounds(199, 97, 26, 25);
			contentPane.add(textFieldStartTime1HH);
			textFieldStartTime1HH.setColumns(10);

			textFieldStartTime1Mm = new JTextField();
			textFieldStartTime1Mm.setBounds(261, 95, 31, 25);
			contentPane.add(textFieldStartTime1Mm);
			textFieldStartTime1Mm.setColumns(10);

			label_1 = new JLabel("  год :");
			label_1.setBounds(221, 100, 43, 14);
			contentPane.add(label_1);

			lblNewLabel = new JLabel("   хв");
			lblNewLabel.setBounds(285, 100, 31, 14);
			contentPane.add(lblNewLabel);

		}

		if (countOfSeances == 3) {
			frame.setBounds(100, 100, 351, 260);
			JLabel lblTimeStart2 = new JLabel("Введіть час початку сеансу 3:");
			lblTimeStart2.setBounds(10, 147, 190, 25);
			contentPane.add(lblTimeStart2);

			textFieldStartTime2HH = new JTextField();
			textFieldStartTime2HH.setBounds(199, 147, 26, 25);
			contentPane.add(textFieldStartTime1HH);
			textFieldStartTime2HH.setColumns(10);

			textFieldStartTime2Mm = new JTextField();
			textFieldStartTime2Mm.setBounds(261, 147, 31, 25);
			contentPane.add(textFieldStartTime1Mm);
			textFieldStartTime1Mm.setColumns(10);

			textFieldStartTime3HH = new JTextField();
			textFieldStartTime3HH.setBounds(199, 147, 26, 25);
			contentPane.add(textFieldStartTime3HH);
			textFieldStartTime3HH.setColumns(10);

			textFieldStartTime3Mm = new JTextField();
			textFieldStartTime3Mm.setBounds(261, 147, 31, 25);
			contentPane.add(textFieldStartTime3Mm);
			textFieldStartTime3Mm.setColumns(10);

			label_1 = new JLabel("  год :");
			label_1.setBounds(221, 148, 43, 14);
			contentPane.add(label_1);

			lblNewLabel = new JLabel("   хв");
			lblNewLabel.setBounds(285, 148, 31, 14);
			contentPane.add(lblNewLabel);
		}

		JButton btnSubmit = new JButton("Submit");
		if (countOfSeances == 1) {
			btnSubmit.setBounds(96, 83, 156, 25);
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {

						startH1 = Integer.parseInt(textFieldStartTime1HH.getText());
						startM1 = Integer.parseInt(textFieldStartTime1Mm.getText());
						Time startTime1 = new Time(startH1, startM1);
						cinemaService.addMovie(new Movie(titleCin, new Time(durationCinH, durationCinM)), startTime1);
						JOptionPane.showMessageDialog(null,
								" фільм :'" + titleCin + "' із щоденними сенсами o '" + startTime1.toString()
										+ "' додано до розкладу!\n"
										+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

						frame.dispose();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}

				}
			});
		}
		if (countOfSeances == 2) {
			btnSubmit.setBounds(69, 132, 156, 25);
			btnSubmit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {

						startH1 = Integer.parseInt(textFieldStartTime1HH.getText());
						startM1 = Integer.parseInt(textFieldStartTime1Mm.getText());
						startH2 = Integer.parseInt(textFieldStartTime2HH.getText());
						startM2 = Integer.parseInt(textFieldStartTime2Mm.getText());
						Time startTime1 = new Time(startH1, startM1);
						Time startTime2 = new Time(startH2, startM2);
						cinemaService.addMovie(new Movie(titleCin, new Time(durationCinH, durationCinM)), startTime1,
								startTime2);

						JOptionPane.showMessageDialog(null,
								" фільм :'" + titleCin + "' із щоденними сенсами o '" + startTime1.toString() + "' та "
										+ startTime2.toString() + "' додано до розкладу!\n"
										+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

						frame.dispose();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			});
		}
		if (countOfSeances >= 3) {
			btnSubmit.setBounds(88, 185, 156, 25);
			btnSubmit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						startH1 = Integer.parseInt(textFieldStartTime1HH.getText());
						startM1 = Integer.parseInt(textFieldStartTime1Mm.getText());
						startH2 = Integer.parseInt(textFieldStartTime2HH.getText());
						startM2 = Integer.parseInt(textFieldStartTime2Mm.getText());
						startH3 = Integer.parseInt(textFieldStartTime3HH.getText());
						startM3 = Integer.parseInt(textFieldStartTime3Mm.getText());
						Time startTime1 = new Time(startH1, startM1);
						Time startTime2 = new Time(startH2, startM2);
						Time startTime3 = new Time(startH3, startM3);
						cinemaService.addMovie(new Movie(titleCin, new Time(durationCinH, durationCinM)), startTime1,
								startTime2, startTime3);

						JOptionPane.showMessageDialog(null,
								" фільм :'" + titleCin + "' із щоденними сенсами o '" + startTime1.toString() + "', '"
										+ startTime2.toString() + "' та " + startTime3.toString()
										+ "' додано до розкладу!\n"
										+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

						frame.dispose();

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			});

		}

		contentPane.add(btnSubmit);

		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
