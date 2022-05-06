package frc.robot.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class Panel extends JPanel {
	private InfoPanel rightPanel;
	private PIDPanel leftPanel;
	private SavePanel savePanel;

	private GridBagConstraints grid = new GridBagConstraints();

	public Panel(HashMap<String, String> entries) {
		this.setLayout(new GridBagLayout());

		this.savePanel = new SavePanel();
		this.grid.gridx = 0;
		this.grid.gridy = 0;
		this.grid.weightx = 0.15;
		this.grid.weighty = 1;
		this.grid.fill = GridBagConstraints.BOTH;
		this.add(savePanel, grid);

		leftPanel = new PIDPanel(entries);
		this.grid.gridx = 1;
		this.grid.gridy = 0;
		this.grid.weightx = 0.25;
		this.grid.weighty = 1;
		this.grid.fill = GridBagConstraints.BOTH;
		this.add(leftPanel, grid);

		rightPanel = new InfoPanel();
		this.grid.gridx = 2;
		this.grid.gridy = 0;
		this.grid.weightx = 0.60;
		this.grid.weighty = 1;
		this.grid.fill = GridBagConstraints.BOTH;
		this.add(rightPanel, grid);
	}
}