package Pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LoginForm extends JFrame implements ActionListener {
    final JTextField textField1, textField2;
    //initialize button, panel, label, and text field
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    Facade facade;
    private int userType = 2;
    private String userName = "";

    //calling constructor
    LoginForm(Facade facade) {
        this.facade = facade;

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

    public String userTypeString(int userType) {
        if (userType == 0) {
            return "buyer";
        } else {
            return "seller";
        }
    }


    //define abstract method actionPerformed() which will be called on button click
    public void actionPerformed(ActionEvent ae) {
        System.out.println("button clicked");
        this.userName = textField1.getText();        //get user entered username from the textField1
        String userPass = textField2.getText();        //get user entered pasword from the textField2
        FilePaths paths = new FilePaths();
        File buyerFile = new File(paths.buyerInfoPath);
        File sellerFile = new File(paths.sellerInfoPath);

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
                if (temp[0].equals(userName) && temp[1].equals(userPass)) {
                    isABuyer = true;
                    this.userType = 0;
                } else if (temp[0].equals(userName) || temp[1].equals(userPass)) {
                    myReader = new Scanner(sellerFile);
                    while (myReader.hasNextLine()) {
                        data.append(myReader.nextLine() + "\n");
                    }
                    String[] seller = data.toString().split("\n");

                    for (int j = 0; j < seller.length; j++) {
                        String[] temp2 = seller[j].split(":");
                        if (temp2[0].equals(userName) && temp2[1].equals(userPass)) {
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

            System.out.printf("user %s has logged in as a %s\n", userName, this.userTypeString(this.userType));


            new Thread() {
                @Override
                public void run() {
                    facade.setUserType(userType, userName);
                }
            }.start();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        SwingUtilities.getWindowAncestor(newPanel).dispose();
        myReader.close();
    }

}
