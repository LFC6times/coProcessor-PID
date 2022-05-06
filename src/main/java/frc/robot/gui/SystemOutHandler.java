package frc.robot.gui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Make sure we don't leave the out stream in the wrong place... should be fine
 */
public class SystemOutHandler {
	public static void setOutStream(String out) {
		try {
			System.setOut(new PrintStream(new FileOutputStream(out)));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void resetOutStream() {
		System.setOut(System.out);
	}
}
