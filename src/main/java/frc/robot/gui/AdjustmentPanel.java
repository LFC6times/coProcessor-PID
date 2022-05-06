package frc.robot.gui;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class AdjustmentPanel extends JPanel {
	private final int num;
	private int size = 0;
	private JLabel[] labels;
	private JTextField[] fields;


	public AdjustmentPanel(HashMap<String, String> entries) {
		this.num = entries.size();
		this.labels = new JLabel[this.num * 2];
		this.fields = new JTextField[this.num * 2];

		setLayout(new GridLayout(this.num, 2));
		String[] keys = entries.keySet().toArray(new String[0]);

		for (int i = 0; i < this.num; i++) {
			labels[i] = new JLabel(keys[i]);
			labels[i].setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
			labels[i].setForeground(Color.black);
			this.add(labels[i]);

			fields[i] = new JTextField();
			this.add(fields[i]);
		}
		input();

	}

	public void save() {
		try {
			System.setOut(new PrintStream(new FileOutputStream("PISS\\save" + (SavePanel.getSaveCount() + 1) + ".txt")));
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		System.out.println(size);
		for (int i = 0; i < size; ++i) {
			System.out.println(Double.parseDouble(fields[i].getText()));
		}
	}

	public void input() {
		Scanner input;
		try {
			input = new Scanner(new File("PISS//save" + SavePanel.getText() + ".txt"));
		} catch (Exception e) {
			System.out.println("no such file");
			return;
		}
		size = input.nextInt();
		System.out.println(size);
		for (int i = 0; i < size; ++i) {
			fields[i].setText("" + input.nextDouble());
		}
		input.close();
	}
}