package frc.robot.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel
{
	private InfoPanel rightPanel;
	private PIDPanel leftPanel;
	public Panel(int rows)
	{
		GridLayout layout = new GridLayout(1, 2);
		setLayout(layout);

		leftPanel = new PIDPanel(rows);
		add(leftPanel);

		rightPanel = new InfoPanel();
		add(rightPanel);
	}
}