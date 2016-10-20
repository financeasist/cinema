package ua.com.cinema.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
 * This class creates a start window (view)to add new seance to schedule in day
 * witch user selected.
 * 
 * @version 1.2 10 Oct 2016
 * @author RomanGupskyi
 */
public class AddSeanceView {
	private final static Logger logger = Logger.getLogger(AddSeanceView.class);
	private String day = "MONDAY";
	private String title = "--choose a movie--";
	private JFrame frame;
	private JPanel contentPane;

	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_5;
	private JButton btnSubmit;

	private JTextField textFieldSeanceStartTimeHH;
	private JTextField textFieldStartTimeFilmSeanceMm;
	private JComboBox<Object> comboBoxDays;
	private CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);
	private Seance seance = null;
	private Time durationTime;

	/**
	 * Creates window for addSeance;
	 */
	public AddSeanceView() {
		initWindow();
		initWindowComponents();
		
	}

	/**
	 * Creates a frame;
	 */
	public void initWindow() {
		logger.info("Init start window for AddSeanceView was started!");
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 445, 199);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * adds a view components to frame. here user can choose which movie and
	 * when he wants to add.
	 */
	private void initWindowComponents() {
		logger.info("Init initWindowComponents() for AddSeanceView was started!");
		Days[] days = Days.values();
		comboBoxDays = new JComboBox<Object>(days);
		comboBoxDays.setEditable(true);
		comboBoxDays.setBackground(Color.WHITE);
		/**
		 * here user can select a day;
		 */
		comboBoxDays.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent event) {
				logger.info("started ItemListener for 'comboBoxDays'!");
				if (event.getStateChange() == ItemEvent.SELECTED)
					day = comboBoxDays.getSelectedItem().toString();
				logger.info("user choosed " + day + "!");
			}
		});
		comboBoxDays.setBounds(273, 13, 125, 20);
		contentPane.add(comboBoxDays);
		JLabel labelDayForSeance = new JLabel("Виберіть день в який хочете додати сеанс :");
		labelDayForSeance.setBounds(10, 11, 258, 25);
		contentPane.add(labelDayForSeance);
		
		Cinema cinema = cinemaService.getCinema();
		Map<Days, Schedule> weeklySchedule = cinema.getWeeklySchedule();
		Days valueOfDay = Days.valueOf(day);
		Schedule seances = weeklySchedule.get(valueOfDay);
		Set<Seance> seances2 = seances.getSeances();
		Iterator<Seance> iter = seances2.iterator();
		Set<String> setTitles = new LinkedHashSet<String>();
		setTitles.add(title);

		while (iter.hasNext()) {
			seance = (Seance) iter.next();
			title = seance.getMovie().getTitle();
			setTitles.add(title);
		}
		Object[] titles = setTitles.toArray();
		
		JComboBox<Object> comboBoxTitles = new JComboBox<Object>(titles);
		comboBoxTitles.setBackground(Color.WHITE);
		comboBoxTitles.setEditable(true);
		/**
		 * here user chooses a title;
		 */
		comboBoxTitles.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				logger.info("started ItemListener for 'comboBoxTitles'!");
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Object selectedTitle = comboBoxTitles.getSelectedItem();
					title = (String) selectedTitle;
					logger.info("user choosed " + title + "!");
					Movie movie = seance.getMovie();
					durationTime = movie.getDurationTime();
				}
			}
		});
		comboBoxTitles.setBounds(273, 49, 125, 20);
		contentPane.add(comboBoxTitles);

		JLabel lblTitlefilmSeance = new JLabel("Оберіть фільм якому хочете додати сеанс:");
		lblTitlefilmSeance.setBounds(10, 47, 251, 25);
		contentPane.add(lblTitlefilmSeance);

		JLabel lblSeanceTimeStartHH = new JLabel("Введіть час початку сеансу:");
		lblSeanceTimeStartHH.setBounds(10, 85, 176, 25);
		contentPane.add(lblSeanceTimeStartHH);

		textFieldSeanceStartTimeHH = new JTextField();
		textFieldSeanceStartTimeHH.setBounds(253, 90, 27, 20);
		contentPane.add(textFieldSeanceStartTimeHH);
		textFieldSeanceStartTimeHH.setColumns(10);

		textFieldStartTimeFilmSeanceMm = new JTextField();
		textFieldStartTimeFilmSeanceMm.setBounds(344, 87, 27, 20);
		contentPane.add(textFieldStartTimeFilmSeanceMm);
		textFieldStartTimeFilmSeanceMm.setColumns(10);

		label_5 = new JLabel("   год");
		label_5.setBounds(283, 90, 40, 14);
		contentPane.add(label_5);

		label_2 = new JLabel("     :");
		label_2.setBounds(307, 90, 27, 14);
		contentPane.add(label_2);

		label_3 = new JLabel("   хв");
		label_3.setBounds(371, 90, 27, 14);
		contentPane.add(label_3);
		frame.setVisible(true);

		btnSubmit = new JButton("додати сеанс");
		btnSubmit.setBounds(146, 121, 151, 25);
		contentPane.add(btnSubmit);

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

	public JTextField getTextFieldSeanceStartTimeHH() {
		return textFieldSeanceStartTimeHH;
	}

	public void setTextFieldSeanceStartTimeHH(JTextField textFieldSeanceStartTimeHH) {
		this.textFieldSeanceStartTimeHH = textFieldSeanceStartTimeHH;
	}

	public JTextField getTextFieldStartTimeFilmSeanceMm() {
		return textFieldStartTimeFilmSeanceMm;
	}

	public void setTextFieldStartTimeFilmSeanceMm(JTextField textFieldStartTimeFilmSeanceMm) {
		this.textFieldStartTimeFilmSeanceMm = textFieldStartTimeFilmSeanceMm;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(Time durationTime) {
		this.durationTime = durationTime;
	}

}
