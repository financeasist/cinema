package ua.com.cinema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Seance;
import ua.com.cinema.models.Time;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.view.AddSeanceView;

public class AddSeanceController {

	static JFrame frame;
	static AddSeanceView view;
	
	private String titleCin;
	private Integer durationCinH;
	private Integer durationCinM;
	private String day;
	private Integer seanceH;
	private Integer seanceM;


	/**
	 * Create the frame.
	 */
	public AddSeanceController() {
		view = new AddSeanceView();
		frame = view.getFrame();
		initController();
	}
	
	/**
	 * init Controller
	 */
	public void initController(){

		

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);
			public void actionPerformed(ActionEvent e) {
				try {

					day = view.getTextFieldDayToAddSeance().getText();
					titleCin = view.getTextFieldTitleFilm().getText();
					durationCinH = Integer.parseInt(view.getTextFieldDurationSeanceHH().getText());
					durationCinM = Integer.parseInt(view.getTextFieldDurationSeanceMm().getText());
					seanceH = Integer.parseInt(view.getTextFieldSeanceStartTimeHH().getText());
					seanceM = Integer.parseInt(view.getTextFieldStartTimeFilmSeanceMm().getText());

					Time durationTime = new Time(durationCinH, durationCinM);
					Time seancestartTime = new Time(seanceH, seanceM);
					
					cinemaService.addSeance(day,
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
		view.getContentPane().add(btnSubmit);

		
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame framee) {
		frame = framee;
	}
}
