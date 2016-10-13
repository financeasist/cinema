package ua.com.cinema.view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ua.com.cinema.controller.TransformMovie2SeanceController;

public class TransformMovie2SeanceView {

	private JFrame frame;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JPanel contentPane;
	private int countSeances = TransformMovie2SeanceController.countSeances;

	private JTextField textFieldStartTime1HH;
	private JTextField textFieldStartTime1Mm;
	private JTextField textFieldStartTime2HH;
	private JTextField textFieldStartTime2Mm;
	private JTextField textFieldStartTime3HH;
	private JTextField textFieldStartTime3Mm;

	public TransformMovie2SeanceView() {
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
		
		initComponents(countSeances);
	}

	private void initComponents(int countSeances) {
		JLabel labelInfo = new JLabel("Ви вибрали кількість сеансів : " + countSeances);
		labelInfo.setBounds(65, 11, 254, 25);
		labelInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(labelInfo);

		if (countSeances >= 1) {
			JLabel lblTimeStart1 = new JLabel("Введіть час початку сеансу 1:");
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

			label_1 = new JLabel("  год :");
			label_1.setBounds(221, 52, 43, 14);
			contentPane.add(label_1);

			lblNewLabel = new JLabel("   хв");
			lblNewLabel.setBounds(285, 52, 31, 14);
			contentPane.add(lblNewLabel);

		}

		if (countSeances >= 2) {
			frame.setBounds(100, 100, 351, 216);
			JLabel lblTimeStart2 = new JLabel("Введіть час початку сеансу 2:");
			lblTimeStart2.setBounds(10, 95, 190, 25);
			contentPane.add(lblTimeStart2);

			textFieldStartTime2HH = new JTextField();
			textFieldStartTime2HH.setBounds(199, 97, 26, 25);
			contentPane.add(textFieldStartTime2HH);
			textFieldStartTime2HH.setColumns(10);

			textFieldStartTime2Mm = new JTextField();
			textFieldStartTime2Mm.setBounds(261, 95, 31, 25);
			contentPane.add(textFieldStartTime2Mm);
			textFieldStartTime2Mm.setColumns(10);

			label_1 = new JLabel("  год :");
			label_1.setBounds(221, 100, 43, 14);
			contentPane.add(label_1);

			lblNewLabel = new JLabel("   хв");
			lblNewLabel.setBounds(285, 100, 31, 14);
			contentPane.add(lblNewLabel);

		}

		if (countSeances == 3) {
			frame.setBounds(100, 100, 351, 260);
			JLabel lblTimeStart2 = new JLabel("Введіть час початку сеансу 3:");
			lblTimeStart2.setBounds(10, 147, 190, 25);
			contentPane.add(lblTimeStart2);

			textFieldStartTime3HH = new JTextField();
			textFieldStartTime3HH.setBounds(199, 147, 26, 25);
			contentPane.add(textFieldStartTime3HH);
			textFieldStartTime3HH.setColumns(10);

			textFieldStartTime3Mm = new JTextField();
			textFieldStartTime3Mm.setBounds(261, 147, 31, 25);
			contentPane.add(textFieldStartTime3Mm);
			textFieldStartTime3Mm.setColumns(10);

			label_1 = new JLabel("  год :");
			label_1.setBounds(221, 148, 43, 14);
			contentPane.add(label_1);

			lblNewLabel = new JLabel("   хв");
			lblNewLabel.setBounds(285, 148, 31, 14);
			contentPane.add(lblNewLabel);
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
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

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JTextField getTextFieldStartTime1HH() {
		return textFieldStartTime1HH;
	}

	public void setTextFieldStartTime1HH(JTextField textFieldStartTime1HH) {
		this.textFieldStartTime1HH = textFieldStartTime1HH;
	}

	public JTextField getTextFieldStartTime1Mm() {
		return textFieldStartTime1Mm;
	}

	public void setTextFieldStartTime1Mm(JTextField textFieldStartTime1Mm) {
		this.textFieldStartTime1Mm = textFieldStartTime1Mm;
	}

	public JTextField getTextFieldStartTime2HH() {
		return textFieldStartTime2HH;
	}

	public void setTextFieldStartTime2HH(JTextField textFieldStartTime2HH) {
		this.textFieldStartTime2HH = textFieldStartTime2HH;
	}

	public JTextField getTextFieldStartTime2Mm() {
		return textFieldStartTime2Mm;
	}

	public void setTextFieldStartTime2Mm(JTextField textFieldStartTime2Mm) {
		this.textFieldStartTime2Mm = textFieldStartTime2Mm;
	}

	public JTextField getTextFieldStartTime3HH() {
		return textFieldStartTime3HH;
	}

	public void setTextFieldStartTime3HH(JTextField textFieldStartTime3HH) {
		this.textFieldStartTime3HH = textFieldStartTime3HH;
	}

	public JTextField getTextFieldStartTime3Mm() {
		return textFieldStartTime3Mm;
	}

	public void setTextFieldStartTime3Mm(JTextField textFieldStartTime3Mm) {
		this.textFieldStartTime3Mm = textFieldStartTime3Mm;
	}

}
