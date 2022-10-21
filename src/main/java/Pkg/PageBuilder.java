package Pkg;

import javax.swing.*;
import java.awt.*;

/**
 * PageBuilder implements the Builder design pattern.
 */

class PageBuilder extends JFrame {
    public JPanel newPanel;
    private Person person;

    PageBuilder() {
        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(3, 1));
    }

    public PageBuilder addTitle(String title) {
        setTitle(title);
        return this;
    }

    public PageBuilder addSize(int width, int height) {
        newPanel.setSize(width, height);
        return this;
    }

    public PageBuilder addComponent(Component comp) {
        newPanel.add(comp);
        return this;
    }

    public void build() {
        add(newPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
