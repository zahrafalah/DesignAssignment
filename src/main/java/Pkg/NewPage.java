package Pkg;

import javax.swing.*;
import java.awt.*;


class NewPage extends JFrame {

	JButton b1;
	JPanel newPanel;
	JLabel userLabel, passLabel;
	final JTextField textField1, textField2;

	private Person person;

	//constructor
	NewPage() {


		userLabel = new JLabel();
		userLabel.setText("Username");      //set label value for textField1

		//create text field to get username from the user
		textField1 = new JTextField(15);    //set length of the text

		//create label for password
		passLabel = new JLabel();
		passLabel.setText("Password");      //set label value for textField2

		//create text field to get password from the user
		textField2 = new JPasswordField(15);    //set length for the password

		//create submit button
		b1 = new JButton("SUBMIT"); //set label to button

		//create panel to put form elements
		newPanel = new JPanel(new GridLayout(3, 1));
		newPanel.add(userLabel);    //set username label to panel
		newPanel.add(textField1);   //set text field to panel
		newPanel.add(passLabel);    //set password label to panel
		newPanel.add(textField2);   //set text field to panel
		newPanel.add(b1);           //set button to panel

		//set border to panel
		add(newPanel, BorderLayout.CENTER);

		//perform action on button click

		setTitle("LOGIN FORM");         //set title to the login form


	}
}
