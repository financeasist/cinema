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

public class CinemaAddNewFilm1 {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaAddNewFilm1 frame = new CinemaAddNewFilm1();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrame frame;

	private JPanel contentPane;
	private JTextField textFieldStartTime1HH;
	private JTextField textFieldStartTime1Mm;
	Cinema palace = CinemaGuiMain.palace;

	private String titleCin = CinemaAddNewFilmStartWindow.titleFilm;
	private Integer durationCinH = CinemaAddNewFilmStartWindow.durationCinH;
	private Integer durationCinM = CinemaAddNewFilmStartWindow.durationCinM;
	private Integer startH1;
	private Integer startM1;
	private JLabel label_1;

	private JLabel lblNewLabel;
	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public CinemaAddNewFilm1() {

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

		JLabel labelInfo = new JLabel("Ви вибрали кількість сеансів : 1");
		labelInfo.setBounds(65, 11, 254, 25);
		labelInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(labelInfo);

		JLabel lblTimeStart1 = new JLabel("Введіть час початку сеансу:");
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

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(96, 83, 156, 25);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				
					startH1 = Integer.parseInt(textFieldStartTime1HH.getText());
					startM1 = Integer.parseInt(textFieldStartTime1Mm.getText());
					 Time startTime1 = new Time(startH1,startM1);
					palace.addMovie(new Movie(titleCin, new Time(durationCinH, durationCinM)),
							startTime1);
					JOptionPane.showMessageDialog(null, " фільм :'" + titleCin + "' із щоденними сенсами o '" + startTime1.toString() + "' додано до розкладу!\n"
							+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

					frame.dispose();

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		contentPane.add(btnSubmit);

		label_1 = new JLabel("  год :");
		label_1.setBounds(221, 52, 43, 14);
		contentPane.add(label_1);

		lblNewLabel = new JLabel("   хв");
		lblNewLabel.setBounds(285, 52, 31, 14);
		contentPane.add(lblNewLabel);
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
}
