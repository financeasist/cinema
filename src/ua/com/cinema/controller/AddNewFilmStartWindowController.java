package ua.com.cinema.controller;

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
/**
 * 
 * This class creates a start window for add new movie and checks how many seances 
 * user wants to  create for every day.
 * and creates appropriate 'addNewFilmController' for this count.
 * version 1.2 10 Oct 2016
 * @author RomanGupskyi
 *
 */
public class AddNewFilmStartWindowController {

	static String titleFilm;
	static Integer durationCinH;
	static Integer durationCinM;
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldCountSeance;
	private JTextField textFieldDurationFilmHH;
	private JTextField textFieldDurationFilmMm;
	static Integer keyCheck;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;

	private JTextField textFieldFilmName;

	/**
	 * Creates the frame.
	 */
	public AddNewFilmStartWindowController() {
		buildFrame();
		initController();
	}

	private void buildFrame() {
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
	}

	private void initController() {
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
/**
 * checks how many seances user wants to  create in every day,
 * and creates appropriate addNewFilmController for this count.
 */
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
						AddNewFilmController addNewFilmController = new AddNewFilmController(1);
						addNewFilmController.getFrame().setVisible(true);

						break;

					case 2:
						AddNewFilmController addNewFilmController2 = new AddNewFilmController(2);
						addNewFilmController2.getFrame().setVisible(true);

						break;
					case 3:
						AddNewFilmController addNewFilmController3 = new AddNewFilmController(3);
						addNewFilmController3.getFrame().setVisible(true);

						break;

					default:
						JOptionPane.showMessageDialog(null, "Введіть 1, 2 або 3!");
						break;
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
