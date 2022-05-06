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

	/**
	 * Whether getting Scanner was successful
	 * @return true if successful, false otherwise
	 */
	public boolean successful() {
		return input != null;
	}

	/**
	 * Get the lines of the file
	 *
	 * Format of file:
	 *
	 * name:table/entry
	 * name2:table2/entry2
	 *
	 * and so on. This will therefore remove the line breaks and replace with a colon, and {@link #getEntries(String)}
	 * will return a HashMap with the names mapped to entries.
	 *
	 * @return the lines of the file, as a single string without line breaks. Every item is separated by a colon.
	 */
	private String getLines() {
		StringBuilder sb = new StringBuilder();
		while (input.hasNextLine()) {
			sb.append(input.nextLine());
			sb.append(":");
		}
		this.input.close();
		return sb.toString();
	}

	/**
	 * Get the entries from the formatted string
	 *
	 * @param lines the formatted string from {@link #getLines()}, or another source if you so wish
	 * @return a HashMap with the names mapped to entries
	 */
	private HashMap<String, String> getEntries(String lines) {
		HashMap<String, String> entries = new HashMap<>();

		String[] linesArray = lines.split(":"); // I've been duly informed by stackoverflow that no regex will be created since it's single char
		for (int i = 0; i < linesArray.length; i += 2) {
			entries.put(linesArray[i], linesArray[i + 1]); // should be slightly faster than double split. should be.
		}

		return entries;
	}

	/**
	 * The same as {@link #getEntries(String)}, but calls {@link #getLines()} automatically
	 * @return a HashMap with the names mapped to entries
	 */
	private HashMap<String, String> getEntries() {
		HashMap<String, String> entries = new HashMap<>();
		String lines = getLines();

		String[] linesArray = lines.split(":"); // I've been duly informed by stackoverflow that no regex will be created since it's single char
		for (int i = 0; i < linesArray.length; i += 2) {
			entries.put(linesArray[i], linesArray[i + 1]); // should be slightly faster than double split. should be.
		}

		return entries;
	}

	/**
	 * Get the entry HashMap
	 *
	 * @return the entry HashMap
	 */
	public HashMap<String, String> getEntryMap() {
		return this.entries;
	}
}
