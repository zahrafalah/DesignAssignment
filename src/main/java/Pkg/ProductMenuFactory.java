package Pkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMenuFactory implements ProductMenu {

    private List<String> meatList = new ArrayList<>();
    private List<String> produceList = new ArrayList<>();
    private String user;
    private File productInfoFile;
    private File sellersListFile;

    ProductMenuFactory(String user) {

        this.user= user;
        Scanner myReader = null;
        StringBuilder data = new StringBuilder();

        if(this.user == "buyer"){
            System.out.println("buyer");
            try {
                sellersListFile = new File("C:\\Users\\Sepideh\\Desktop\\MS\\SER515\\Design\\src\\main\\java\\Pkg\\SellerList.txt");
//                myReader = new Scanner(sellersListFile);
//                while (myReader.hasNextLine()) {
//                    data.append(myReader.nextLine() + "\n");
//                }
//                String[] str = data.toString().split("\n");

//                for (int i = 0; i < str.length; i++) {
//                    String[] temp = str[i].split(":");
//
//                    if (temp[0].equals("Meat")) {
//                        meatList.add(temp[1]);
//                    }else if(temp[0].equals("Produce")){
//                        produceList.add(temp[1]);
//                    }
//                }
            }catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }else{
            System.out.println("seller");
            productInfoFile = new File("C:\\Users\\Sepideh\\Desktop\\MS\\SER515\\Design\\src\\main\\java\\Pkg\\ProductInfo.txt");
            try {
                myReader = new Scanner(productInfoFile);
                while (myReader.hasNextLine()) {
                    data.append(myReader.nextLine() + "\n");
                }
                String[] str = data.toString().split("\n");

                for (int i = 0; i < str.length; i++) {
                    String[] temp = str[i].split(":");

                    if (temp[0].equals("Meat")) {
                        meatList.add(temp[1]);
                    }else if(temp[0].equals("Produce")){
                        produceList.add(temp[1]);
                    }
                }
            }catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }



    }

    //create a button for each list
    //based on the button clicked create a specific NewProductMenu

    @Override
    public void showMenu() {

        NewPage page = new NewPage("Product menu");

        String[] meatArr = new String[meatList.size()];
        meatArr = meatList.toArray(meatArr);

        String[] produceArr = new String[produceList.size()];
        produceArr = produceList.toArray(produceArr);

        ProductMenu meatMenu = new MeatProductMenu(meatArr,page);
        ProductMenu produceMenu = new ProduceProductMenu(produceArr,page);

        meatMenu.showMenu();
        produceMenu.showMenu();


        page.setVisible(true);

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
    public void showComBoxes() {

    }
}
