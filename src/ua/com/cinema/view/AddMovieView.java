package ua.com.cinema.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

/**
 * This class creates a start window (view) for add new movie and checks how
 * many seances user wants to create for every day. 
 * 
 * @version 1.3 18 Oct 2016
 * @author RomanGupskyi
 */

public class AddMovieView {
	final static Logger logger = Logger.getLogger(AddMovieView.class); 
	private JFrame frame;
	private JButton btnSubmit;
	private JPanel contentPane;
	private JTextField textFieldCountSeance;
	private JTextField textFieldDurationFilmHH;
	private JTextField textFieldDurationFilmMm;

	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;

	private JTextField textFieldFilmName;

	/**
	 * Creates a start window for addMovie
	 */
	public AddMovieView() {
		initWindow();
		initWindowComponents();
	}
		public void initWindow(){
		logger.info("Init method was started");	
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

	/**
	 * Adds a window's components to frame.
	 */
	private void initWindowComponents() {
		JLabel labelFilmName = new JLabel("Введіть назву фільму :");
		labelFilmName.setBounds(10, 11, 189, 25);
		contentPane.add(labelFilmName);

		JLabel lblCountSeance = new JLabel("Скільки щоденних сеансів додати? (max 3):");
		lblCountSeance.setBounds(10, 83, 313, 25);
		contentPane.add(lblCountSeance);

		textFieldCountSeance = new JTextField();
		textFieldCountSeance.setBounds(327, 84, 31, 23);
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
		textFieldFilmName.setBounds(209, 13, 159, 23);
		contentPane.add(textFieldFilmName);
		textFieldFilmName.setColumns(10);

		btnSubmit = new JButton("Додати фільм");
		btnSubmit.setBounds(107, 129, 184, 41);
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

	public JTextField getTextFieldCountSeance() {
		return textFieldCountSeance;
	}

	public void setTextFieldCountSeance(JTextField textFieldCountSeance) {
		this.textFieldCountSeance = textFieldCountSeance;
	}

	public JTextField getTextFieldDurationFilmHH() {
		return textFieldDurationFilmHH;
	}

	public void setTextFieldDurationFilmHH(JTextField textFieldDurationFilmHH) {
		this.textFieldDurationFilmHH = textFieldDurationFilmHH;
	}

	public JTextField getTextFieldDurationFilmMm() {
		return textFieldDurationFilmMm;
	}

	public void setTextFieldDurationFilmMm(JTextField textFieldDurationFilmMm) {
		this.textFieldDurationFilmMm = textFieldDurationFilmMm;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getLabel_1() {
		return label_1;
	}

	public void setLabel_1(JLabel label_1) {
		this.label_1 = label_1;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JTextField getTextFieldFilmName() {
		return textFieldFilmName;
	}

	public void setTextFieldFilmName(JTextField textFieldFilmName) {
		this.textFieldFilmName = textFieldFilmName;
	}

	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(JButton btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

}
