package ua.com.cinema;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CinemaGuiWindow {

	private CinemaGuiRemoveSeance cinemaGuiRemoveSeance; 
	private JFrame frame;
	
	
	 static Cinema palace = new Cinema (new Time (8,30), new Time (23,30));

		public static void main(String[] args) {
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaGuiWindow window = new CinemaGuiWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		

	/**
	 * Create the application.
	 */
	public CinemaGuiWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 758, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddnewFilm = new JButton("Додати фільм разом із сеансами до розкладу");
		btnAddnewFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CinemaAddNewFilm cinemaAddNewFilm = new CinemaAddNewFilm();
				CinemaAddNewFilm.frame.setVisible(true);
			}
		});
		btnAddnewFilm.setBounds(35, 39, 200, 50);
		frame.getContentPane().add(btnAddnewFilm);
		
		JButton btnAddNewSeance = new JButton("Додати сеанс до розкладу");
		btnAddNewSeance.setBounds(35, 100, 200, 50);
		frame.getContentPane().add(btnAddNewSeance);
		
		JButton btnRemoveFilmFromList = new JButton("Видалити фільм зі списку");
		btnRemoveFilmFromList.setBounds(35, 171, 200, 50);
		frame.getContentPane().add(btnRemoveFilmFromList);
		
		JButton btnRemoveSeance = new JButton("Видалити сеанс");
		btnRemoveSeance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//frame.dispose();
					CinemaGuiRemoveSeance cinGuiRemoveSeance = new CinemaGuiRemoveSeance();
					//cinGuiRemoveSeance.frame.setVisible(true);
                    
				}catch( Exception e1){
					JOptionPane.showMessageDialog(null,e1);
				}
				
			}
		});
		btnRemoveSeance.setBounds(35, 232, 200, 50);
		frame.getContentPane().add(btnRemoveSeance);
		
		JButton btnSetPrepaireSchedule = new JButton("Заповнити розклад улюбленими фільмами");
		btnSetPrepaireSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					palace.addMovie(new Movie("Transformers 2", new Time (2,34)), new Time(10, 20), new Time (20,10));
                    palace.addMovie(new Movie("Heaven's kingdom", new Time (2,12)), new Time(9, 10));
                    palace.addMovie(new Movie("Lion King", new Time (1,36)), new Time(14, 50), new Time (16,0), new Time (8,30));
                    palace.addMovie(new Movie("Hobbit 2", new Time (2,48)), new Time(12, 45), new Time (22,15));
                    JOptionPane.showMessageDialog(null, "films succsessfully edded to schedule!"
                    		+ "\n"+"натисніть 'показати розклад' щоб вивести розклад на екран!");
                    
				}catch( Exception e1){
					JOptionPane.showMessageDialog(null,e1);
				}
				
			}
		});
		btnSetPrepaireSchedule.setBounds(35, 298, 200, 50);
		frame.getContentPane().add(btnSetPrepaireSchedule);
		
		JButton btnShowSchedule = new JButton("Вивести розклад на екран");
		btnShowSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					CinemaShowSchedule cinemaShowSchedule= new CinemaShowSchedule();
					CinemaShowSchedule.frame.setVisible(true);
					
					CinemaShowSchedule.textArea.setText(palace.toString()); 
				}catch( Exception e1){
					JOptionPane.showMessageDialog(null,e1);
				}
				
			}
		});
		btnShowSchedule.setBounds(35, 362, 200, 50);
		frame.getContentPane().add(btnShowSchedule);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/oscar.png").getFile());
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(245, 11, 487, 408);
		frame.getContentPane().add(lblNewLabel);
//		
//		JLabel label = new JLabel("  Розклад");
//		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
//		label.setBounds(449, 0, 77, 25);
//		frame.getContentPane().add(label);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(258, 39, 441, 368);
//		frame.getContentPane().add(scrollPane);
//		
//		textArea = new JTextArea("~~~Вітаємо! ця програма - це моделювання роботи кінотеатру! ~~\r\n\r\n Щоб скористатись потрібним Вам методом, натисніть відповідну кнопку! ");
//		textArea.setWrapStyleWord(true);
//		scrollPane.setViewportView(textArea);
		
//		Image img = new ImageIcon(this.getClass().getResource("/movies.png").getImage);
//		Jlable.setIcon(new ImageIcon(img));
		
	}
}
