package ua.com.cinema.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ua.com.cinema.enums.Days;
import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.models.Cinema;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Schedule;
import ua.com.cinema.models.Seance;
import ua.com.cinema.models.Time;
import ua.com.cinema.service.CinemaService;

/**
 * This class - it's a view for 'RemoveSeanceController.java'. Creates a start
 * window with components (view) for remove seance from schedule. Here user can
 * select day and which exactly seance he want to remove;
 * 
 * @version 1.2 14 Oct 2016
 * @author RomanGrupskyi
 *
 */
public class RemoveSeanceView {

	private static String day = "MONDAY";
	private static String titleFilmtoRemove;
	private static Time durationTime;
	private static Time seanceStartTime;
	private CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);

	private JFrame frame;
	private JPanel contentPane;
	private JButton btnSubmit;
	private JComboBox<Object> comboBoxDays;

	/**
	 * creates a JFrame
	 */
	public RemoveSeanceView() {

		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 476, 188);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		initViewConponents();
	}

	/**
	 * adds a view components to frame.
	 * here user selects day and which exactly seance he want to remove;
	 */
	private void initViewConponents() {

		Days[] days = Days.values();
		comboBoxDays = new JComboBox<Object>(days);
		comboBoxDays.setEditable(true);
		comboBoxDays.setBackground(Color.WHITE);
		comboBoxDays.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					day = comboBoxDays.getSelectedItem().toString();
			}
		});
		comboBoxDays.setBounds(322, 11, 122, 25);
		contentPane.add(comboBoxDays);

		JLabel labelDayForRemoveSeance = new JLabel("Виберіть день в який ви хочете видалити сеанс:");
		labelDayForRemoveSeance.setBounds(10, 11, 302, 25);
		contentPane.add(labelDayForRemoveSeance);

		Cinema cinema = cinemaService.getCinema();
		Map<Days, Schedule> weeklySchedule = cinema.getWeeklySchedule();
		Days valueOfDay = Days.valueOf(day);
		Schedule seances = weeklySchedule.get(valueOfDay);
		Object[] schedules = seances.getSeances().toArray();
		JComboBox<Object> comboBoxSchedule = new JComboBox<Object>(schedules);
		comboBoxSchedule.setBackground(Color.WHITE);
		comboBoxSchedule.setEditable(true);
		comboBoxSchedule.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Object selectedSeance = comboBoxSchedule.getSelectedItem();
					Seance seance = (Seance) selectedSeance;
					Movie movie = seance.getMovie();

					seanceStartTime = seance.getStartTime();
					durationTime = movie.getDurationTime();
					titleFilmtoRemove = movie.getTitle();
				}
			}
		});
		comboBoxSchedule.setBounds(217, 47, 227, 25);
		contentPane.add(comboBoxSchedule);
		frame.setVisible(true);

		JLabel lblTitlefilmSeanceToRemove = new JLabel("Виберіть  сеанс який хочете видалити :");
		lblTitlefilmSeanceToRemove.setBounds(10, 47, 215, 25);
		contentPane.add(lblTitlefilmSeanceToRemove);

		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(132, 93, 196, 31);
		contentPane.add(btnSubmit);

		JList<Object> list = new JList<Object>();
		list.setBounds(356, 11, 29, 17);
		contentPane.add(list);

	}

	/**
	 * getters and setters:
	 */
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public JComboBox<Object> getComboBoxDays() {
		return comboBoxDays;
	}

	public void setComboBox(JComboBox<Object> comboBox) {
		this.comboBoxDays = comboBox;
	}

	public static String getDay() {
		return day;
	}

	public static void setDay(String day) {
		RemoveSeanceView.day = day;
	}

	public static String getTitleFilmtoRemove() {
		return titleFilmtoRemove;
	}

	public static Time getDurationTime() {
		return durationTime;
	}

	public static Time getSeanceStartTime() {
		return seanceStartTime;
	}

	public static void setSeanceStartTime(Time seanceStartTime) {
		RemoveSeanceView.seanceStartTime = seanceStartTime;
	}

	public static void setDurationTime(Time durationTime) {
		RemoveSeanceView.durationTime = durationTime;
	}

	public static void setTitleFilmtoRemove(String titleFilmtoRemove) {
		RemoveSeanceView.titleFilmtoRemove = titleFilmtoRemove;
	}

}
