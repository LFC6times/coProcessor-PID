package frc.robot.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class PIDPanel extends JPanel {
	private JLabel label;
	private GridBagConstraints grid = new GridBagConstraints();
	private AdjustmentPanel adjust;

	public PIDPanel(HashMap<String, String> entries) {
		setLayout(new GridBagLayout());
		setBackground(Color.black);

		JButton button1 = new JButton("Update");
		button1.addActionListener(new Listener1());
		setGrid(0, 3);
		grid.fill = GridBagConstraints.HORIZONTAL;
		add(button1, grid);

		JButton button2 = new JButton("Revert");
		button2.addActionListener(new Listener2());
		setGrid(1, 3);
		grid.fill = GridBagConstraints.HORIZONTAL;
		add(button2, grid);

		label = new JLabel("Update Network Tables");
		label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		label.setForeground(Color.white);
		setGrid(0, 2);
		grid.gridwidth = 2;
		grid.fill = GridBagConstraints.VERTICAL;
		add(label, grid);


		label = new JLabel("NTR");
		label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 50));
		label.setForeground(Color.yellow);
		setGrid(0, 0);
		grid.gridwidth = 2;
		grid.gridheight = 1;
		grid.fill = GridBagConstraints.VERTICAL;
		add(label, grid);

		adjust = new AdjustmentPanel(entries);
		setGrid(0, 1);
		grid.fill = GridBagConstraints.VERTICAL;
		add(adjust, grid);
	}

	public void setGrid(int x, int y) {
		grid.gridx = x;
		grid.gridy = y;
	}

	private class Listener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			adjust.save();
			SavePanel.updateSaveCount();
		}
	}

	private class Listener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			adjust.input();
		}
	}
}