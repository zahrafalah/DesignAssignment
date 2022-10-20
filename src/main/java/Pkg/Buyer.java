package Pkg;

import javax.swing.*;

public class Buyer extends Person {

	Buyer() {

	}

	public void showMenu() {
		System.out.println("buyer show menu");
		//create instance of the NewPage


		//make page visible to the user
//		page.setVisible(true);

		//create a welcome label and set it to the new page
//		JLabel wel_label = new JLabel("Welcome: tutu" );
//		page.getContentPane().add(wel_label);

		// JButton button = new JButton("Show Menu");
		// button.setSize(30, 30);
		// page.add(button);

	}

	@Override
	public void showAddButton() {

	}

	@Override
	public void showViewButton() {

	}

	@Override
	public void showRadioButton() {

	}

	@Override
	public void showLabels() {

	}

	@Override
	public ProductMenu createProductMenu() {
		return null;
	}

	public ProductMenu CreateProductMenu() {
		return null;
	}

}
