package Pkg;

import javax.swing.*;

/**
 * @Author Zahra Falah - ASU ID 1213300697
 * @Date 10/20/2022
 * @Description: In this assignment I implemented 5 design patterns: Facade, Bridge, Factory, Iterator, Builder.
 * This is a GUI Based multi-user "Product  Trading  and  Bidding System (PTBS) program".
 * The seller logs in and sets the products he wants to sell and then the users can log in and see the
 * products available and will then click to buy. The result then will get stored in a text file called
 * UserProduct.txt.
 * The result is what the seller and users decided on and will get saved in the UserProduct.txt file.
 * ****
 * NOTE: To Run, Please make sure you change the path to the text files according to your
 * computers paths in the FilePaths.java. Also, make sure before running the SellerList.txt and the
 * UserProduct.txt (Duhh!!) is empty.
 * ****
 **/

public class Main {
    public static void main(String[] args) {
        try {

            Facade facade = new Facade();
            int isAuthenticated = facade.login();

            // show the person menu if the user logged in
            if (isAuthenticated == 1) {
                facade.getPerson().showMenu();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
