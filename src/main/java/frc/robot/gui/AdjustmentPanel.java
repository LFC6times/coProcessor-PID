package frc.robot.gui;

import java.awt.*;
import javax.swing.*;
public class AdjustmentPanel extends JPanel
{
	private JLabel[] labels;
	private JTextField[] fields;

	public AdjustmentPanel(int rows) {
		setLayout(new GridLayout(rows,2));

		labels = new JLabel[rows];
		fields = new JTextField[rows];

		for(int i = 0; i < rows; i++){
			JLabel label = new JLabel("PID stuff");
			label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
			label.setForeground(Color.black);
			add(label);
			labels[i] = label;

			JTextField text = new JTextField(10);
			add(text);
			fields[i] = text;
		}
	}

	public JTextField[] getFields() {
		return fields;
	}
}