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

import org.apache.log4j.Logger;

import ua.com.cinema.enums.Days;
import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.model.Cinema;
import ua.com.cinema.model.Schedule;
import ua.com.cinema.model.Seance;
import ua.com.cinema.service.CinemaService;

/**
 * This class - it's a start window (view) for 'RemoveMovieController.java'.
 * Creates a start window for remove movie, where user can write a title of
 * movie, which he wants to remove;
 * 
 * @version 1.3 18 Oct 2016
 * @author RomanGupskyi
 */
public class RemoveMovieView {
	
	private final static Logger logger = Logger.getLogger(RemoveMovieView .class);
	private JFrame frame;
	private JButton buttonSubmit;
	private CinemaService cinemaService;
	private Seance seance=null;
	private String title="--choose a movie--";

	/**
	 * Creates the start window with components for RemoveMovie
	 */
	public RemoveMovieView() {
		initWindow();
		initWindowComponents();	
	}
	
	public void initWindow(){
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setBounds(100, 100, 440, 149);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		}

	/**
	 * Adds a view components to frame
	 */
	private void initWindowComponents() {
		logger.info("initWindowComponents() for RemoveMovieView was started!");
		JLabel lblFilmName = new JLabel("виберіть фільм який хочете видалити :");
		lblFilmName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblFilmName.setBounds(10, 23, 261, 20);
		frame.getContentPane().add(lblFilmName);
		
		cinemaService = new CinemaService(CinemaGuiMain.palace);
		Cinema cinema = cinemaService.getCinema();
		Map<Days, Schedule> weeklySchedule = cinema.getWeeklySchedule();
		Set<String> titleset = new LinkedHashSet<String>();
		titleset.add(title);
		String movieTitle;
		
		for (Days day : Days.values()) {
			Schedule seances = weeklySchedule.get(day);
			Set<Seance> seances2 = seances.getSeances();
			Iterator<Seance> iter = seances2.iterator();
			while (iter.hasNext()) {
				seance = (Seance) iter.next();
				movieTitle = seance.getMovie().getTitle();
				titleset.add(movieTitle);
			}
		}
			Object[] titles = titleset.toArray();
			JComboBox<Object> comboBoxTitles = new JComboBox<Object>(titles);
			comboBoxTitles.setBackground(Color.WHITE);
			comboBoxTitles.setEditable(true);
			/**
			 * Here user select movie
			 */
			comboBoxTitles.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent event) {
					if (event.getStateChange() == ItemEvent.SELECTED) {
						Object selectedTitle = comboBoxTitles.getSelectedItem();
						title = (String) selectedTitle;
						logger.info("user selected '"+title+"' !");
					}
				}
			});
			comboBoxTitles.setBounds(256, 23, 158, 20);
			frame.getContentPane().add(comboBoxTitles);

			buttonSubmit = new JButton("Delete");
			buttonSubmit.setBounds(160, 67, 122, 32);
			frame.getContentPane().add(buttonSubmit);
			frame.setVisible(true);
		}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public JButton getButtonSubmit() {
		return buttonSubmit;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.buttonSubmit = btnNewButton;
	}

}
