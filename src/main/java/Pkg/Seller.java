package Pkg;

import javax.swing.*;

public class Seller extends Person {

	ProductMenu menu;

	Seller() {
		menu = new ProductMenuFactory("seller");
	}

	public void showMenu() {
		System.out.println("---- Seller Show Menu ----");
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
