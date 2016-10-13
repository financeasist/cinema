package ua.com.cinema.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import ua.com.cinema.enums.Days;
import ua.com.cinema.main.CinemaGuiMain;
import ua.com.cinema.models.Cinema;
import ua.com.cinema.models.Schedule;
import ua.com.cinema.service.CinemaService;

public class RemoveSeanceView {
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldTitleFilmToRemove;
	private JTextField textFieldDurationFilmHH;
	private JTextField textFieldDurationFilmMm;
	private JTextField textFieldStartTimeHH;
	private JTextField textFieldStartTimeMm;

	private static String day;
	
	private CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);
	
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label_2;

	private JLabel label_3;
	private JComboBox<Days> comboBoxDays;
	
;
	public RemoveSeanceView() {
		
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
	
	private void initViewConponents() {
		
		Days[] days = Days.values();
		comboBoxDays = new JComboBox<Days>(days);
		comboBoxDays.setEditable(true);
		comboBoxDays.setBackground(Color.WHITE);
		comboBoxDays.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					day = comboBoxDays.getSelectedItem().toString();
			}
		});
		comboBoxDays.setBounds(322, 11, 122, 25);
		contentPane.add(comboBoxDays);

		JLabel labelDayForRemoveSeance = new JLabel("Виберіть день сеансу для видаленя з розкладу:");
		labelDayForRemoveSeance.setBounds(10, 11, 302, 25);
		contentPane.add(labelDayForRemoveSeance);
		
		Cinema cinema = cinemaService.getCinema();
		HashMap<Days, Schedule> weeklySchedule = cinema.getWeeklySchedule();
		Schedule schedule =  weeklySchedule.get(Days.valueOf(day));
		// if (schedule == null) JOptionPane.showMessageDialog(null, "Ви ще не добавили жодного сеансу! Будьласка, заповніть розклад сеансами!");
		Schedule[] schedules = (Schedule[]) schedule.getSchedule().toArray();
		
		JComboBox<Schedule> comboBoxSchedule = new JComboBox<Schedule>(schedules);
		
		comboBoxSchedule.setBackground(Color.WHITE);
		comboBoxSchedule.setEditable(true);
		comboBoxSchedule.setBounds(322, 47, 122, 25);
		contentPane.add(comboBoxSchedule);
		frame.setVisible(true);

		JLabel lblTitlefilmSeanceToRemove = new JLabel("Введіть  назву фільму (сеансу) :");
		lblTitlefilmSeanceToRemove.setBounds(10, 47, 215, 25);
		contentPane.add(lblTitlefilmSeanceToRemove);
		
//		textFieldTitleFilmToRemove = new JTextField();
//		textFieldTitleFilmToRemove.setBounds(322, 47, 122, 25);
//		contentPane.add(textFieldTitleFilmToRemove);
//		textFieldTitleFilmToRemove.setColumns(10);

		JLabel lblDurationFilmtoRemoveSeanceHH = new JLabel("Введіть тривалість фільму :");
		lblDurationFilmtoRemoveSeanceHH.setBounds(10, 83, 215, 25);
		contentPane.add(lblDurationFilmtoRemoveSeanceHH);

		textFieldDurationFilmHH = new JTextField();
		textFieldDurationFilmHH.setBounds(272, 83, 40, 25);
		contentPane.add(textFieldDurationFilmHH);
		textFieldDurationFilmHH.setColumns(10);

		textFieldDurationFilmMm = new JTextField();
		textFieldDurationFilmMm.setBounds(375, 83, 40, 25);
		contentPane.add(textFieldDurationFilmMm);
		textFieldDurationFilmMm.setColumns(10);

		JLabel lblRemoveSeanceTimeStartHH = new JLabel("Введіть час початку сеансу:");
		lblRemoveSeanceTimeStartHH.setBounds(10, 119, 176, 25);
		contentPane.add(lblRemoveSeanceTimeStartHH);

		textFieldStartTimeHH = new JTextField();
		textFieldStartTimeHH.setBounds(272, 119, 40, 25);
		contentPane.add(textFieldStartTimeHH);
		textFieldStartTimeHH.setColumns(10);

		textFieldStartTimeMm = new JTextField();
		textFieldStartTimeMm.setBounds(375, 119, 40, 25);
		contentPane.add(textFieldStartTimeMm);
		textFieldStartTimeMm.setColumns(10);

		
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

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(328, 11, 87, 16);
		contentPane.add(toolBar);

		JList<Days> list = new JList<Days>();
		list.setBounds(356, 11, 29, 17);
		contentPane.add(list);
		
		
		
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

	
	public JComboBox<Days> getComboBoxDays() {
		return comboBoxDays;
	}

	public void setComboBox(JComboBox<Days> comboBox) {
		this.comboBoxDays = comboBox;
	}

	public JTextField getTextFieldTitleFilmToRemove() {
		return textFieldTitleFilmToRemove;
	}

	public void setTextFieldTitleFilmToRemove(JTextField textFieldTitleFilmToRemove) {
		this.textFieldTitleFilmToRemove = textFieldTitleFilmToRemove;
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

	public JTextField getTextFieldStartTimeHH() {
		return textFieldStartTimeHH;
	}

	public void setTextFieldStartTimeHH(JTextField textFieldStartTimeHH) {
		this.textFieldStartTimeHH = textFieldStartTimeHH;
	}

	public JTextField getTextFieldStartTimeMm() {
		return textFieldStartTimeMm;
	}

	public void setTextFieldStartTimeMm(JTextField textFieldStartTimeMm) {
		this.textFieldStartTimeMm = textFieldStartTimeMm;
	}

	public static String getDay() {
		return day;
	}

	public static void setDay(String day) {
		RemoveSeanceView.day = day;
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
