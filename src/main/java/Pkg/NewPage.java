package Pkg;

import javax.swing.*;
import java.awt.*;


class NewPage extends JFrame {

	JButton b1;
	public JPanel newPanel;
	JLabel userLabel, passLabel;
	private Person person;

	//constructor
	NewPage(String title) {
		//create panel to put form elements
		newPanel = new JPanel(new GridLayout(3, 1));

		newPanel.setSize(400, 200);

		setTitle(title);
		add(newPanel, BorderLayout.CENTER);
	}
}
