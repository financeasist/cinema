package ua.com.cinema.util;

import javax.swing.JTextField;
/**
 * This class - is utilite for ControllerUtilclass from package ua.com.cinema.controller;
 * 
 * @version 1.2 10 Oct 2016
 * @author RomanGupskyi
 */
public class ViewUtil {
	/**
	 * method takes value from Jtext field and parse it to Integer
	 * 
	 * @param jTextField
	 * @return
	 */
	public static Integer textField2Integer(JTextField jTextField) {
		return Integer.parseInt(jTextField.getText());

	}
}
