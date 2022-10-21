package Pkg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Factory design pattern
 */
public class ProductMenuFactory implements ProductMenu {

    private final List<String> meatList = new ArrayList<>();
    private final List<String> produceList = new ArrayList<>();
    private final UserInfoItem user;

    ProductMenuFactory(UserInfoItem user) {
        this.user = user;
        Scanner myReader = null;
        StringBuilder data = new StringBuilder();

        FilePaths paths = new FilePaths();

        // create a meat and produce list for a buyer
        if (this.user.getUserTypeString() == "buyer") {
            System.out.println("product menu factory buyer");
            try {
                File sellersListFile = new File(paths.sellerListPath);
                myReader = new Scanner(sellersListFile);
                while (myReader.hasNextLine()) {
                    data.append(myReader.nextLine() + "\n");
                }
                String[] str = data.toString().split("\n");

                for (int i = 0; i < str.length; i++) {
                    String[] temp = str[i].split(":");

                    if (temp[0].equals("Meat")) {
                        meatList.add(temp[1]);
                    } else if (temp[0].equals("Produce")) {
                        produceList.add(temp[1]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // create a meat and produce list for a seller
            System.out.println("product menu factory seller");
            try {
                File productInfoFile = new File(paths.productInfoPath);
                myReader = new Scanner(productInfoFile);
                while (myReader.hasNextLine()) {
                    data.append(myReader.nextLine() + "\n");
                }
                String[] str = data.toString().split("\n");

                for (int i = 0; i < str.length; i++) {
                    String[] temp = str[i].split(":");

                    if (temp[0].equals("Meat")) {
                        meatList.add(temp[1]);
                    } else if (temp[0].equals("Produce")) {
                        produceList.add(temp[1]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //create a button for each list
    //based on the button clicked create a specific NewProductMenu

    @Override
    public void showMenu() {
        // "Product menu"
        PageBuilder page = new PageBuilder();
        page.addTitle("Product Menu").build();
        page.setSize(400,200);

        String[] meatArr = new String[meatList.size()];
        meatArr = meatList.toArray(meatArr);

        String[] produceArr = new String[produceList.size()];
        produceArr = produceList.toArray(produceArr);

        ProductMenu meatMenu = new MeatProductMenu(meatArr, page, this.user);
        ProductMenu produceMenu = new ProduceProductMenu(produceArr, page, this.user);

        meatMenu.showMenu();
        produceMenu.showMenu();


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
