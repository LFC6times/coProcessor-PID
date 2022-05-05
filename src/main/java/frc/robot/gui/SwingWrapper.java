package frc.robot.gui;

import javax.swing.JFrame;

public class SwingWrapper {
	private final JFrame frame;

	public SwingWrapper(String name, int[] dimensions) {
		frame = new JFrame(name);
		frame.setSize(dimensions[0], dimensions[1]);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Panel(10));
		frame.setVisible(true);
	}
}