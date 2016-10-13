package ua.com.cinema.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddSeanceView {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldDayToAddSeance;
	private JTextField textFieldTitleFilm;
	private JTextField textFieldDurationSeanceHH;
	private JTextField textFieldDurationSeanceMm;
	private JTextField textFieldSeanceStartTimeHH;
	private JTextField textFieldStartTimeFilmSeanceMm;
	
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * creates a frame
	 */
	public AddSeanceView() {
		
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 473, 281);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initViewConponents();
	}

	private void initViewConponents(){
		
		JLabel labelDayForSeance = new JLabel("Введіть день в який хочете додати сеанс (англ!):");
		labelDayForSeance.setBounds(10, 11, 302, 25);
		contentPane.add(labelDayForSeance);

		textFieldDayToAddSeance = new JTextField();
		textFieldDayToAddSeance.setBounds(322, 11, 121, 25);
		contentPane.add(textFieldDayToAddSeance);
		textFieldDayToAddSeance.setColumns(10);

		JLabel lblTitlefilmSeance = new JLabel("Введіть  назву фільму (сеансу) :");
		lblTitlefilmSeance.setBounds(10, 47, 215, 25);
		contentPane.add(lblTitlefilmSeance);

		textFieldTitleFilm = new JTextField();
		textFieldTitleFilm.setBounds(322, 47, 121, 25);
		contentPane.add(textFieldTitleFilm);
		textFieldTitleFilm.setColumns(10);

		JLabel lblDurationFilmtoSeanceHH = new JLabel("Введіть тривалість фільму :");
		lblDurationFilmtoSeanceHH.setBounds(10, 83, 215, 25);
		contentPane.add(lblDurationFilmtoSeanceHH);

		textFieldDurationSeanceHH = new JTextField();
		textFieldDurationSeanceHH.setBounds(272, 83, 40, 25);
		contentPane.add(textFieldDurationSeanceHH);
		textFieldDurationSeanceHH.setColumns(10);

		textFieldDurationSeanceMm = new JTextField();
		textFieldDurationSeanceMm.setBounds(375, 83, 40, 25);
		contentPane.add(textFieldDurationSeanceMm);
		textFieldDurationSeanceMm.setColumns(10);

		JLabel lblSeanceTimeStartHH = new JLabel("Введіть час початку сеансу:");
		lblSeanceTimeStartHH.setBounds(10, 119, 176, 25);
		contentPane.add(lblSeanceTimeStartHH);

		textFieldSeanceStartTimeHH = new JTextField();
		textFieldSeanceStartTimeHH.setBounds(272, 119, 40, 25);
		contentPane.add(textFieldSeanceStartTimeHH);
		textFieldSeanceStartTimeHH.setColumns(10);

		textFieldStartTimeFilmSeanceMm = new JTextField();
		textFieldStartTimeFilmSeanceMm.setBounds(375, 119, 40, 25);
		contentPane.add(textFieldStartTimeFilmSeanceMm);
		textFieldStartTimeFilmSeanceMm.setColumns(10);
		
		label = new JLabel("     :");
		label.setBounds(339, 88, 46, 14);
		contentPane.add(label);

		label_1 = new JLabel("   год");
		label_1.setBounds(312, 94, 46, 14);
		contentPane.add(label_1);

		lblNewLabel = new JLabel("   хв");
		lblNewLabel.setBounds(416, 94, 46, 14);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("   год");
		lblNewLabel_1.setBounds(312, 130, 46, 14);
		contentPane.add(lblNewLabel_1);

		label_2 = new JLabel("     :");
		label_2.setBounds(339, 119, 46, 14);
		contentPane.add(label_2);

		label_3 = new JLabel("   хв");
		label_3.setBounds(416, 130, 46, 14);
		contentPane.add(label_3);
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

	public JTextField getTextFieldDayToAddSeance() {
		return textFieldDayToAddSeance;
	}

	public void setTextFieldDayToAddSeance(JTextField textFieldDayToAddSeance) {
		this.textFieldDayToAddSeance = textFieldDayToAddSeance;
	}

	public JTextField getTextFieldTitleFilm() {
		return textFieldTitleFilm;
	}

	public void setTextFieldTitleFilm(JTextField textFieldTitleFilm) {
		this.textFieldTitleFilm = textFieldTitleFilm;
	}

	public JTextField getTextFieldDurationSeanceHH() {
		return textFieldDurationSeanceHH;
	}

	public void setTextFieldDurationSeanceHH(JTextField textFieldDurationSeanceHH) {
		this.textFieldDurationSeanceHH = textFieldDurationSeanceHH;
	}

	public JTextField getTextFieldDurationSeanceMm() {
		return textFieldDurationSeanceMm;
	}

	public void setTextFieldDurationSeanceMm(JTextField textFieldDurationSeanceMm) {
		this.textFieldDurationSeanceMm = textFieldDurationSeanceMm;
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

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public void setLblNewLabel_1(JLabel lblNewLabel_1) {
		this.lblNewLabel_1 = lblNewLabel_1;
	}

	public JLabel getLabel_2() {
		return label_2;
	}

	public void setLabel_2(JLabel label_2) {
		this.label_2 = label_2;
	}

	public JLabel getLabel_3() {
		return label_3;
	}

	public void setLabel_3(JLabel label_3) {
		this.label_3 = label_3;
	}
	
}
