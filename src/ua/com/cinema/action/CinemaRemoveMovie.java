package ua.com.cinema.action;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ua.com.cinema.main.CinemaGuiMain;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CinemaRemoveMovie {

	private JFrame frame;
	private JTextField textField;
	private String filmName;
	
	
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinemaRemoveMovie window = new CinemaRemoveMovie();
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
	public CinemaRemoveMovie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 7));
		frame.setTitle("**@author RomanGrupskyi");
		frame.setBounds(100, 100, 409, 146);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFilmName = new JLabel("введіть назву фільму для видалення :");
		lblFilmName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblFilmName.setBounds(18, 11, 209, 32);
		frame.getContentPane().add(lblFilmName);
		
		textField = new JTextField();
		textField.setBounds(240, 17, 132, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					filmName = textField.getText();
					CinemaGuiMain.palace.removeMovie(filmName);
					JOptionPane.showMessageDialog(null,
							"фільм '"+filmName +"' видалено з розкладу!");
					frame.dispose();
				}catch(Exception e1){}
			}
		});
		btnNewButton.setBounds(139, 54, 122, 32);
		frame.getContentPane().add(btnNewButton);
	}
}
