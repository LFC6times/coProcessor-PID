package frc.robot.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import frc.robot.robot.NetworkTablesReader;

public class PIDPanel extends JPanel
{
	private JLabel label;
	private GridBagConstraints grid = new GridBagConstraints();
	private AdjustmentPanel adjust;

	private double[] values;

	public PIDPanel(int rows){
		values = new double[rows];

		setLayout(new GridBagLayout());
		setBackground(Color.black);

		JButton button1 = new JButton("Update");
		button1.addActionListener(new sendDataButton());
		setGrid(0,3);
		grid.fill = GridBagConstraints.HORIZONTAL;
		add(button1, grid);

		JButton button2 = new JButton("Revert");
		button2.addActionListener(new revertButton());
		setGrid(1,3);
		grid.fill = GridBagConstraints.HORIZONTAL;
		add(button2, grid);

		label = new JLabel("Update Network Tables");
		label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		label.setForeground(Color.white);
		setGrid(0,2);
		grid.gridwidth = 2;
		grid.fill = GridBagConstraints.VERTICAL;
		add(label,grid);


		label = new JLabel("NTR");
		label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 50));
		label.setForeground(Color.yellow);
		setGrid(0,0);
		grid.gridwidth = 2;
		grid.gridheight = 1;
		grid.fill = GridBagConstraints.VERTICAL;
		add(label,grid);

		adjust = new AdjustmentPanel(rows);
		setGrid(0,1);
		grid.fill = GridBagConstraints.VERTICAL;
		add(adjust,grid);
	}
	public void setGrid(int x, int y){
		grid.gridx = x;
		grid.gridy = y;
	}
	private class sendDataButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JTextField[] fields = adjust.getFields();
			double[] values = new double[fields.length];

			for(int i = 0; i < fields.length; i++) {
				values[i] = Double.parseDouble(fields[i].getText()); // get the values for labels

				System.out.println("yeet");
				// NetworkTablesReader.getInstance().setDoubleEntry(names[i], values[i]); // set the values in the NT
			}

			PIDPanel.this.values = values; // thank you stackoverflow for this
		}
	}
	private class revertButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JTextField[] fields = adjust.getFields();
			double[] previousValues = PIDPanel.this.values; // get the previous values

			for(int i = 0; i < fields.length; i++) {
				fields[i].setText(Double.toString(previousValues[i])); // set the values in the text fields
			}
		}
	}
}