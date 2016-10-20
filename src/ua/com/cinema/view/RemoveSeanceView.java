package ua.com.cinema.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import ua.com.cinema.enums.Days;
import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.model.Cinema;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.Schedule;
import ua.com.cinema.model.Seance;
import ua.com.cinema.model.Time;
import ua.com.cinema.service.CinemaService;

/**
 * This class - it's a view for 'RemoveSeanceController.java'. Creates a start
 * window with components (view) for remove seance from schedule. Here user can
 * select day and which exactly seance he want to remove;
 * 
 * @version 1.3 18 Oct 2016
 * @author RomanGrupskyi
 *
 */
public class RemoveSeanceView {

	private final static Logger logger = Logger.getLogger(RemoveSeanceView.class);
	private static String day = "MONDAY";
	private static String titleFilmtoRemove;
	private static Time durationTime;
	private static Time seanceStartTime;
	private CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);
	private Set<Seance> seancess = null;
	private JFrame frame;
	private JPanel contentPane;
	private JButton btnSubmit;

	/**
	 * creates a Window for RemoveSeanceView;
	 */
	public RemoveSeanceView() {
		initWindow();
		initWindowComponents();
	}

	public void initWindow() {
		logger.debug("start's Window for 'RemoveSeance' was started!");
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

	}

	/**
	 * adds a view components to frame. here user selects day and which exactly
	 * seance he want to remove;
	 */
	private void initWindowComponents() {
		logger.debug("init window's components for 'RemoveSeance' was started!");
		Days[] days = Days.values();
		final JComboBox<Object> comboBoxDays = new JComboBox<Object>(days);
		comboBoxDays.setEditable(true);
		comboBoxDays.setBackground(Color.WHITE);
		comboBoxDays.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				logger.debug(" itemState in 'comboBoxDays' was chenged!");
				if (event.getStateChange() == ItemEvent.SELECTED) {
					day = comboBoxDays.getSelectedItem().toString();
					logger.info("user selected day: '" + day + "' !");
				}
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
		Set<Seance> seances1 = seances.getSeances();
		seancess = new TreeSet<Seance>();
		/**
		 * here I added default value for comboBoxSchedule (it will be needs for
		 * 'itemStateChanged(ItemEvent event)' method);
		 */
		seancess.add(new Seance(new Movie("-- please choose a seance --", new Time(0, 0)), new Time(0, 0)));
		for (Seance seance : seances1) {
			seancess.add(seance);
		}
		Object[] schedules = seancess.toArray();
		JComboBox<Object> comboBoxSchedule = new JComboBox<Object>(schedules);
		comboBoxSchedule.setBackground(Color.WHITE);
		comboBoxSchedule.setEditable(true);

		comboBoxSchedule.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				logger.debug(" itemState in 'comboBoxSchedule' was chenged!");
				try {
					if (event.getStateChange() == ItemEvent.SELECTED) {
						Object selectedSeance = comboBoxSchedule.getSelectedItem();
						Seance seance = (Seance) selectedSeance;
						Movie movie = seance.getMovie();

						seanceStartTime = seance.getStartTime();
						durationTime = movie.getDurationTime();
						titleFilmtoRemove = movie.getTitle();
						logger.info("user selected to remove seance: '" + seance.toString() + "'!");
					}
				} catch (Exception e) {
					logger.error(e);
				}
			}
		});
		comboBoxSchedule.setBounds(248, 47, 196, 25);
		contentPane.add(comboBoxSchedule);

		JLabel lblTitlefilmSeanceToRemove = new JLabel("Виберіть  сеанс який хочете видалити :");
		lblTitlefilmSeanceToRemove.setBounds(10, 47, 255, 25);
		contentPane.add(lblTitlefilmSeanceToRemove);

		btnSubmit = new JButton("Видалити сеанс");
		btnSubmit.setBounds(132, 93, 196, 31);
		contentPane.add(btnSubmit);

		JList<Object> list = new JList<Object>();
		list.setBounds(356, 11, 29, 17);
		contentPane.add(list);

		frame.setVisible(true);

	}

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
