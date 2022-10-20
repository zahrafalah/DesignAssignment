package Pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeatProductMenu implements ProductMenu {
	String[] list;
	NewPage page;

	MeatProductMenu(String[] list, NewPage page) {
		this.list = list;
		this.page= page;
	}

	public void showMenu() {

		final JComboBox<String> cb = new JComboBox<String>(list);

		cb.setMaximumSize(cb.getPreferredSize());
		cb.setAlignmentX(Component.CENTER_ALIGNMENT);

		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String selected = (String) cb.getSelectedItem();

				System.out.println("item name selected:" + selected);
			}
		});
		cb.setSelectedIndex(0);
		page.newPanel.add(cb);

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
