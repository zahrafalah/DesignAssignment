package Pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Exception;
import java.util.Scanner;

class CreateLoginForm extends JFrame implements ActionListener {
    //initialize button, panel, label, and text field
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField textField1, textField2;
    private int userType = 2;

    //calling constructor
    CreateLoginForm() {

        //create label for username
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
        b1.addActionListener(this);     //add action listener to button
        setTitle("LOGIN FORM");         //set title to the login form
    }

    public int getUserType() {
        return this.userType;
    }


    //define abstract method actionPerformed() which will be called on button click
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter
    {
        String userValue = textField1.getText();        //get user entered username from the textField1
        String passValue = textField2.getText();        //get user entered pasword from the textField2

        File buyerFile = new File("C:\\Users\\Sepideh\\Desktop\\MS\\SER515\\Design\\src\\main\\java\\Pkg\\BuyerInfo.txt");
        File sellerFile = new File("C:\\Users\\Sepideh\\Desktop\\MS\\SER515\\Design\\src\\main\\java\\Pkg\\SellerInfo.txt");

        Scanner myReader = null;
        StringBuilder data = new StringBuilder();
        Boolean isABuyer = false;
        Boolean isASeller = false;

        try {
            myReader = new Scanner(buyerFile);
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine() + "\n");
            }
            String[] s = data.toString().split("\n");
            for (int i = 0; i < s.length; i++) {
                String[] temp = s[i].split(":");
                if (temp[0].equals(userValue) && temp[1].equals(passValue)) {
                    System.out.println("Buyer");
                    isABuyer = true;
                    this.userType = 0;
                } else if(temp[0].equals(userValue) || temp[1].equals(passValue)){
                    myReader = new Scanner(sellerFile);
                    while (myReader.hasNextLine()) {
                        data.append(myReader.nextLine() + "\n");
                    }
                    String[] seller = data.toString().split("\n");

                    for (int j = 0; j < seller.length; j++) {
                        String[] temp2 = seller[j].split(":");
                        if (temp2[0].equals(userValue) && temp2[1].equals(passValue)) {
                            System.out.println("Seller");
                            isASeller = true;
                            this.userType = 1;
                        }
                    }
                }
            }

            if (!isABuyer && !isASeller) {
                System.out.println("User not found");
                return;
            }

//            if (isABuyer) {
//
//
//            } else if (isASeller) {
//
//                //create instance of the NewPage
//                NewPage page = new NewPage();
//
//                //make page visible to the user
//                page.setVisible(true);
//
//                //create a welcome label and set it to the new page
//                JLabel wel_label = new JLabel("Welcome: " + userValue);
//                page.getContentPane().add(wel_label);
//
////                JButton button = new JButton("Show Menu");
////                button.setSize(30, 30);
////                page.add(button);
//            }
            System.out.println(userType);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        myReader.close();
    }

}

public class Main {
    public static void main(String[] args) {

        try {

            Facade facade = new Facade( null);
            int isAuthenticated = facade.login();

            if(isAuthenticated == 0 ){

                System.out.println("0");
                NewPage page = new NewPage();
                page.setSize(400, 200);  //set size of the frame
                page.setVisible(true);

                Buyer buyer = new Buyer();
                buyer.showMenu();

            }else if(isAuthenticated == 1){

                System.out.println("1");
                Person seller = new Seller();
                seller.showMenu();
            }

        } catch (Exception e) {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}
