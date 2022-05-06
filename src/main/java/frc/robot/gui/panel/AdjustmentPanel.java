package frc.robot.gui.panel;

import frc.robot.Main;
import frc.robot.gui.SystemOutHandler;
import frc.robot.robot.NetworkTablesReader;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class AdjustmentPanel extends JPanel {
	private final int num;
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
		String outPath = "PISS\\save" + (SavePanel.getSaveCount() + 1) + ".txt";
		SystemOutHandler.setOutStream(outPath);
		System.out.println(num);
		NetworkTablesReader ntr = NetworkTablesReader.getInstance();

		for (int i = 0; i < num; ++i) {
			double val = Double.parseDouble(fields[i].getText());
			System.out.println(val);
			// System.out.println("try to get " + labels[i].getText());
			ntr.setDoubleEntry(labels[i].getText(), val);
		}
		SystemOutHandler.resetOutStream();
	}

	public void input() {
		Scanner input;
		try {
			input = new Scanner(new File("PISS//save" + SavePanel.getText() + ".txt"));
		} catch (Exception e) {
			System.out.println("no such file");
			return;
		}
		// num = input.nextInt();
		input.nextDouble();
		System.out.println(num);
		for (int i = 0; i < num; ++i) {
			fields[i].setText("" + input.nextDouble());
		}
		input.close();

	}
}