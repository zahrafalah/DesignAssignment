package Pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProduceProductMenu implements ProductMenu {
	String[] list;
	NewPage page;

	ProduceProductMenu(String[] list, NewPage page) {
		this.list = list;
		this.page = page;
	}

	public void showMenu() {
		final JComboBox<String> cb = new JComboBox<String>(list);
		cb.setMaximumSize(cb.getPreferredSize()); // added code
		cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code

		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb2 = (JComboBox) e.getSource();
				String selected = (String) cb2.getSelectedItem();

				System.out.println("item produce name selected:" + selected);
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
