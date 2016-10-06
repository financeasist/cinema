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

import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.models.Cinema;

public class CinemaAddNewFilmStartWindow {

	static String titleFilm;
	static Integer durationCinH;
	static Integer durationCinM;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaAddNewFilmStartWindow cinemaAddNewFilmStartWindow = new CinemaAddNewFilmStartWindow();
					cinemaAddNewFilmStartWindow.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JFrame frame;

	private JPanel contentPane;
	private JTextField textFieldCountSeance;
	private JTextField textFieldDurationFilmHH;
	private JTextField textFieldDurationFilmMm;
	
	Cinema palace = CinemaGuiMain.palace;

	Integer keyCheck;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	
	private JTextField textFieldFilmName;

	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public CinemaAddNewFilmStartWindow() {

		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 400, 228);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelFilmName = new JLabel("Введіть назву фільму :");
		labelFilmName.setBounds(10, 11, 189, 25);
		contentPane.add(labelFilmName);

		JLabel lblCountSeance = new JLabel("Введіть  кількість сеансів (max 3):");
		lblCountSeance.setBounds(10, 83, 215, 25);
		contentPane.add(lblCountSeance);

		textFieldCountSeance = new JTextField();
		textFieldCountSeance.setBounds(209, 83, 40, 25);
		contentPane.add(textFieldCountSeance);
		textFieldCountSeance.setColumns(10);

		JLabel lblDurationFilmtoHH = new JLabel("Введіть тривалість фільму :");
		lblDurationFilmtoHH.setBounds(10, 47, 215, 25);
		contentPane.add(lblDurationFilmtoHH);

		textFieldDurationFilmHH = new JTextField();
		textFieldDurationFilmHH.setBounds(209, 47, 40, 25);
		contentPane.add(textFieldDurationFilmHH);
		textFieldDurationFilmHH.setColumns(10);

		textFieldDurationFilmMm = new JTextField();
		textFieldDurationFilmMm.setBounds(292, 47, 40, 25);
		contentPane.add(textFieldDurationFilmMm);
		textFieldDurationFilmMm.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					titleFilm = textFieldFilmName.getText();
					durationCinH = Integer.parseInt(textFieldDurationFilmHH.getText());
					durationCinM = Integer.parseInt(textFieldDurationFilmMm.getText());
					keyCheck = Integer.parseInt(textFieldCountSeance.getText());

					switch (keyCheck) {
					case 1:
						CinemaAddNewFilm1 cinemaAddNewFilm1 = new CinemaAddNewFilm1();
						cinemaAddNewFilm1.getFrame().setVisible(true);

						break;

					case 2:
						 CinemaAddNewFilm2 cinemaAddNewFilm2 = new CinemaAddNewFilm2();
						 cinemaAddNewFilm2.getFrame().setVisible(true);

						break;
					case 3:
						 CinemaAddNewFilm3 cinemaAddNewFilm3 = new CinemaAddNewFilm3();
						 cinemaAddNewFilm3.getFrame().setVisible(true);

						 break;

					default:
						JOptionPane.showMessageDialog(null, "Введіть 1, 2 або 3!");
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
					// JOptionPane.showMessageDialog(null,"сеанс фільму " +
					// titleCin + " в " + " видалено!");
					// frame.dispose();

					}
					frame.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSubmit.setBounds(107, 129, 184, 41);
		contentPane.add(btnSubmit);

		label = new JLabel("  :");
		label.setBounds(272, 47, 19, 25);
		contentPane.add(label);

		label_1 = new JLabel("   год");
		label_1.setBounds(247, 58, 40, 14);
		contentPane.add(label_1);

		lblNewLabel = new JLabel("   хв");
		lblNewLabel.setBounds(327, 58, 31, 14);
		contentPane.add(lblNewLabel);
		
		textFieldFilmName = new JTextField();
		textFieldFilmName.setBounds(209, 13, 123, 23);
		contentPane.add(textFieldFilmName);
		textFieldFilmName.setColumns(10);

		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
