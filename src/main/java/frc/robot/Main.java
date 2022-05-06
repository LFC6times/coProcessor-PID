package frc.robot;

import frc.robot.gui.SwingWrapper;
import frc.robot.robot.NetworkTablesReader;
import frc.robot.util.ParseFile;

import java.util.HashMap;

public class Main {
	private static SwingWrapper swingWrapper;
	public static HashMap<String, String> entries;

	public static void main(String... args) {
		ParseFile parseFile = new ParseFile("entries.txt");
		entries = parseFile.getEntryMap();

		while (entries == null) {
			try {
				Thread.sleep(500);
				System.out.println("Waiting for entries...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		NetworkTablesReader.getInstance(); // start network tables
		swingInit();
	}

	public static void swingInit() {
		swingWrapper = new SwingWrapper("co-Processor PID", new int[]{1000, 1000}, entries);
	}
}
