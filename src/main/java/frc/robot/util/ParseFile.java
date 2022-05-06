package frc.robot.util;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class ParseFile {
	private Scanner input;

	private String lines;
	private HashMap<String, String> entries;

	public ParseFile(String fileName) {
		try {
			input = new Scanner(new File(fileName));
			this.lines = getLines();
			this.entries = getEntries(lines);
		} catch (Exception e) {
			System.out.println("no such file");
		}
	}

	public boolean successful() {
		return input != null;
	}

	private String getLines() {
		StringBuilder sb = new StringBuilder();
		while (input.hasNextLine()) {
			sb.append(input.nextLine());
			/*
			 * Format of the file will be as follows:
			 *
			 * name:table/entry
			 * name2:table2/entry2
			 *
			 * and so on. So we use nextLine() to remove the line breaks and then combine with a colon for quicker parse
			 */
			sb.append(":");
		}
		this.input.close();
		return sb.toString();
	}

	private HashMap<String, String> getEntries(String lines) {
		HashMap<String, String> entries = new HashMap<>();

		String[] linesArray = lines.split(":"); // I've been duly informed by stackoverflow that no regex will be created since it's single char
		for (int i = 0; i < linesArray.length; i += 2) {
			entries.put(linesArray[i], linesArray[i + 1]); // should be slightly faster than double split. should be.
		}

		return entries;
	}

	private HashMap<String, String> getEntries() {
		HashMap<String, String> entries = new HashMap<>();
		String lines = getLines();

		String[] linesArray = lines.split(":"); // I've been duly informed by stackoverflow that no regex will be created since it's single char
		for (int i = 0; i < linesArray.length; i += 2) {
			entries.put(linesArray[i], linesArray[i + 1]); // should be slightly faster than double split. should be.
		}

		return entries;
	}

	public HashMap<String, String> getEntryMap() {
		return this.entries;
	}
}
