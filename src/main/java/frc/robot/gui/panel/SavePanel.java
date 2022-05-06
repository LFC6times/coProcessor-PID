package frc.robot.gui.panel;

import frc.robot.gui.SystemOutHandler;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class SavePanel extends JPanel {
	private static JTextField field;
	private JLabel label;

	public SavePanel() {
		setLayout(new FlowLayout());
		label = new JLabel("File Selection:");
		label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		label.setForeground(Color.blue);
		add(label);

		field = new JTextField(15);
		add(field);
		updateText(getSaveCount());
	}

	public static int getSaveCount() {
		Scanner input;
		try {
			input = new Scanner(new File("PISS\\saveInfo.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("no such file, making one");
			try {
				new File("PISS").mkdir();
				SystemOutHandler.setOutStream("PISS\\saveInfo.txt");
				System.out.println("0");
				SystemOutHandler.resetOutStream();
				return 0;
			} catch (Exception ex) {
				SystemOutHandler.resetOutStream();
				throw new RuntimeException(ex);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int size = input.nextInt();
		input.close();
		return size;
	}

	public static void updateSaveCount() {
		int count = getSaveCount();
		try {
			SystemOutHandler.setOutStream("PISS\\saveInfo.txt");
		} catch (Exception e) {
			SystemOutHandler.resetOutStream();
			throw new RuntimeException(e);
		}
		updateText(count + 1);
		System.out.println(count + 1);
		SystemOutHandler.resetOutStream();
	}

	public static void updateText(int number) {
		field.setText("" + number);
	}

	public static int getText() {
		return Integer.parseInt(field.getText());
	}
}
