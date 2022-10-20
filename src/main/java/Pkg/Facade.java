package Pkg;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Facade {

	CreateLoginForm form;
	ProductMenu productMenu;

	Facade(ProductMenu productMenu) {
		this.productMenu = productMenu;
	}

	private int userType;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person thePerson;

	public int login() {
		//create instance of the CreateLoginForm
		CreateLoginForm form = new CreateLoginForm();

		userType = form.getUserType();
//		System.out.println("here "+userType);

		form.setSize(400, 200);  //set size of the frame
		form.setVisible(true);

		return userType;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createUser(UserInfoItem userinfoitem) {

	}

	public void createProductList() {

	}

	public void attachProductToUser() {

	}

	public int selectProduct() {
		return 0;
	}

	public void productOperation() {

	}
}
