package ua.com.cinema.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Seance;
import ua.com.cinema.models.Time;
import ua.com.cinema.service.CinemaService;
import ua.com.cinema.view.RemoveSeanceView;

public class RemoveSeanceController {

	private RemoveSeanceView view;
	private JFrame frame;
	private JPanel contentPane;

	private String titleCin;
	private Integer durationCinH;
	private Integer durationCinM;
	private static String day;
	private Integer seanceH;
	private Integer seanceM;


	/**
	 * Create the frame.
	 */
	public RemoveSeanceController() {
		this.view = new RemoveSeanceView();
		this.frame = view.getFrame();
		initController();
	}

	/**
	 * init Controller
	 */
	private void initController() {
		this.contentPane = view.getContentPane();
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);

			public void actionPerformed(ActionEvent e) {
				try {
					day = RemoveSeanceView.getDay();
					titleCin = view.getTextFieldTitleFilmToRemove().getText();
					durationCinH = Integer.parseInt(view.getTextFieldDurationFilmHH().getText());
					durationCinM = Integer.parseInt(view.getTextFieldDurationFilmMm().getText());

					seanceH = Integer.parseInt(view.getTextFieldStartTimeHH().getText());
					seanceM = Integer.parseInt(view.getTextFieldStartTimeMm().getText());
					Time seancestartTime = new Time(seanceH, seanceM);
					cinemaService.removeSeance(day,
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
		contentPane.add(btnSubmit);

		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
