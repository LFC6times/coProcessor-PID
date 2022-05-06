// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.gui.SwingWrapper;
import frc.robot.util.ParseFile;

public class Main {
	private static SwingWrapper swingWrapper;

	public static void main(String... args) {
		// NetworkTablesReader.getInstance().start();
		swingInit();
	}

	public static void swingInit() {
		swingWrapper = new SwingWrapper("sus", new int[]{1000, 1000}, new ParseFile("entries.txt").getEntries());
	}
}
