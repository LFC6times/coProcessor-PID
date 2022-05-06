// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

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
		swingWrapper = new SwingWrapper("sus", new int[]{1000, 1000}, entries);
	}
}
