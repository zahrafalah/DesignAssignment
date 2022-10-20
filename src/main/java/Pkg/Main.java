package Pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Exception;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Facade facade = new Facade();
			int isAuthenticated = facade.login();

			// show the person menu if the user logged in
			if (isAuthenticated == 1) {
				facade.getPerson().showMenu();
			}

//			if (isAuthenticated == 0) {
//				NewPage page = new NewPage();
//				page.setSize(400, 200);
//				page.setVisible(true);
//
//				Buyer buyer = new Buyer();
//				buyer.showMenu();
//
//			} else if (isAuthenticated == 1) {
//				Person seller = new Seller();
//				seller.showMenu();
//			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
