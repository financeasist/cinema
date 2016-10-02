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

public class CinemaAddNewFilm2 {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaAddNewFilm2 cinemaAddNewFilm2 = new CinemaAddNewFilm2();
					cinemaAddNewFilm2.frame.setVisible(true);
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
	private JTextField textFieldStartTime2HH;
	
	private JTextField textFieldStartTime2Mm;
	Cinema palace = CinemaGuiMain.palace;
	private String titleCin = CinemaAddNewFilmStartWindow.titleFilm;
	private Integer durationCinH = CinemaAddNewFilmStartWindow.durationCinH;
	private Integer durationCinM = CinemaAddNewFilmStartWindow.durationCinM;
	private Integer startH1;
	private Integer startM1;
	private Integer startH2;


	 private Integer startM2;
	 private JLabel label;
	 private JLabel label_1;
	 private JLabel lblNewLabel;
	 private JLabel lblNewLabel_1;
	 private JLabel label_2;
	 
	 private JLabel label_3;

		/**
		 * Create the frame.
		 * @wbp.parser.entryPoint
		 */
		public CinemaAddNewFilm2() {
			
			
			frame = new JFrame();
			frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
			frame.setTitle("**@author RomanGrupskyi");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setBounds(100, 100, 351, 216);
			contentPane = new JPanel();
			contentPane.setToolTipText("");
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			frame.setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel labelInfo = new JLabel("Ви вибрали кількість сеансів : 2");
			labelInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelInfo.setBounds(49, 11, 254, 25);
			contentPane.add(labelInfo);
			
			JLabel lblTimeStart1 = new JLabel("Введіть час початку сеансу 1:");
			lblTimeStart1.setBounds(10, 47, 200, 25);
			contentPane.add(lblTimeStart1);
			
			textFieldStartTime1HH = new JTextField();
			textFieldStartTime1HH.setBounds(185, 47, 26, 25);
			contentPane.add(textFieldStartTime1HH);
			textFieldStartTime1HH.setColumns(10);
			
			textFieldStartTime1Mm = new JTextField();
			textFieldStartTime1Mm.setBounds(244, 47, 31, 25);
			contentPane.add(textFieldStartTime1Mm);
			textFieldStartTime1Mm.setColumns(10);
			
			JLabel lblTimeStart2 = new JLabel("Введіть час початку сеансу 2:");
			lblTimeStart2.setBounds(10, 95, 200, 25);
			contentPane.add(lblTimeStart2);
			
			textFieldStartTime2HH = new JTextField();
			textFieldStartTime2HH.setBounds(185, 95, 26, 25);
			contentPane.add(textFieldStartTime2HH);
			textFieldStartTime2HH.setColumns(10);
			
			textFieldStartTime2Mm = new JTextField();
			textFieldStartTime2Mm.setBounds(244, 95, 31, 25);
			contentPane.add(textFieldStartTime2Mm);
			textFieldStartTime2Mm.setColumns(10);
			
			JButton btnSubmit = new JButton("Submit");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						
		                
		                
		                
						startH1 = Integer.parseInt(textFieldStartTime1HH.getText());
						startM1 = Integer.parseInt(textFieldStartTime1Mm.getText());
						startH2 = Integer.parseInt(textFieldStartTime2HH.getText());
						startM2 = Integer.parseInt(textFieldStartTime2Mm.getText());
		                Time startTime1 = new Time(startH1,startM1);
		                Time startTime2 = new Time(startH2,startM2);
						palace.addMovie(new Movie(titleCin, new Time(durationCinH, durationCinM)),
								startTime1,startTime2);
						
						JOptionPane.showMessageDialog(null, " фільм :'" + titleCin + "' із щоденними сенсами o '"
						+ startTime1.toString() +"' та "+startTime2.toString() + "' додано до розкладу!\n"
								+ " Щоб побачити розклад, натисніть кнопку 'вивести розклад на екран'!");

		                frame.dispose();
		                
					}catch( Exception e1){
						JOptionPane.showMessageDialog(null,e1);
					}
				}
			});
			btnSubmit.setBounds(69, 132, 156, 25);
			contentPane.add(btnSubmit);
			
			label = new JLabel("  :");
			label.setBounds(231, 47, 19, 25);
			contentPane.add(label);
			
			label_1 = new JLabel("  год");
			label_1.setBounds(208, 52, 26, 14);
			contentPane.add(label_1);
			
			lblNewLabel = new JLabel("   хв");
			lblNewLabel.setBounds(272, 52, 31, 14);
			contentPane.add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("  год");
			lblNewLabel_1.setBounds(208, 100, 26, 14);
			contentPane.add(lblNewLabel_1);
			
			label_2 = new JLabel("  :");
			label_2.setBounds(231, 100, 19, 14);
			contentPane.add(label_2);
			
			label_3 = new JLabel("   хв");
			label_3.setBounds(272, 100, 31, 14);
			contentPane.add(label_3);
			frame.setVisible(true);
		}
	
	public JFrame getFrame() {
			return frame;
		}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}

