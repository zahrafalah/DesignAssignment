package Pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Bridge design pattern
 */
public class ProduceProductMenu implements ProductMenu {
    PageBuilder page;
    ProductIterator iterator = null;
    UserInfoItem user;
    FilePaths paths = new FilePaths();

    ProduceProductMenu(String[] list, PageBuilder page, UserInfoItem user) {
        this.user = user;
        this.page = page;

        // create an iterator for all the list items
        for (int i = 0; i < list.length; i++) {
            if (iterator == null) {
                iterator = new ProductIterator(list[i]);
            } else {
                System.out.println("item - " + list[i]);
                if (!iterator.hasNext()) {
                    System.out.println("adding to iterator - " + list[i]);
                    iterator.next = new ProductIterator(list[i]);
                }
            }
        }
    }

    public void showMenu() {
        List<String> list = new ArrayList<>();
        ProductIterator current = iterator;

        // traverse the iterator to get all products for the dropdown
        while (current != null) {
            list.add(current.name);
            current = current.next;
        }

        String[] produceArr = list.toArray(new String[list.size()]);
        final JComboBox<String> cb = new JComboBox<>(produceArr);
        cb.setMaximumSize(cb.getPreferredSize());
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);

        if (this.user.getUserTypeString() == "seller") {
            cb.addActionListener(this.writeToSellerListFile());
        } else {
            cb.addActionListener(this.writeToUserProductFile());
        }

        page.addComponent(cb);
    }

    private ActionListener writeToSellerListFile() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb2 = (JComboBox) e.getSource();
                String selected = (String) cb2.getSelectedItem();

                System.out.println("selected produce item - " + selected);
                String line = "Produce:" + selected + "\n";
                writeToFile(paths.sellerListPath, line);

                selected = user.getName() + ":" + selected + "\n";
                writeToFile(paths.userProductPath, selected);
            }
        };
    }

    private ActionListener writeToUserProductFile() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb2 = (JComboBox) e.getSource();
                String selected = (String) cb2.getSelectedItem();
                selected = user.getName() + ":" + selected + "\n";

                System.out.println("selected produce item - " + selected);
                writeToFile(paths.userProductPath, selected);
            }
        };
    }

    private void writeToFile(String fileName, String line) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAddButton() {

    }

    public void showViewButton() {

    }

    public void showRadioButton() {

    }

    public void showLabels() {

    }

    public void showComBoxes() {

    }

}
