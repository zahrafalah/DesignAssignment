package Pkg;

import javax.swing.*;

public class Buyer extends Person {
	ProductMenu menu;

	Buyer() {
		menu = new ProductMenuFactory("buyer");
	}

	public void showMenu() {
		System.out.println("---- Buyer Show Menu ----");
		menu.showMenu();
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
