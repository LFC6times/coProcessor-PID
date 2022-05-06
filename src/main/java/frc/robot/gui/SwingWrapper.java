package frc.robot.gui;

import frc.robot.gui.panel.Panel;

import javax.swing.JFrame;
import java.util.HashMap;

public class SwingWrapper {
	private final JFrame frame;

	public SwingWrapper(String name, int[] dimensions, HashMap<String, String> entries) {
		frame = new JFrame(name);
		frame.setSize(dimensions[0], dimensions[1]);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Panel(entries));
		frame.setVisible(true);
	}
}