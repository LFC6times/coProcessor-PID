// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Main;

import java.util.HashMap;

public class NetworkTablesReader {
	private static NetworkTablesReader ntr = null;
	private final long waitTimeMS = 10;
	private final NetworkTableInstance networkTableInstance;
	private final HashMap<String, NetworkTableEntry> hashedEntries;

	/**
	 * @return the singleton instance of NetworkTablesReader
	 */
	public static NetworkTablesReader getInstance() {
		if (ntr == null) {
			ntr = new NetworkTablesReader();
		}

		return ntr;
	}

	/**
	 * Private constructor for singleton
	 */
	private NetworkTablesReader() {
		networkTableInstance = NetworkTableInstance.getDefault();
		networkTableInstance.startClientTeam(3952);
		networkTableInstance.startDSClient();

		hashedEntries = new HashMap<>();

		this.init(Main.entries);
	}

	/**
	 * Initialize the HashMap of entries
	 *
	 * @param entries a HashMap of Strings to an ArrayList of Strings, tables to entries in each table
	 */
	private void init(HashMap<String, String> entries) {
		for (String i : entries.keySet()) {
			String[] tableAndEntry = entries.get(i).split("/");
			hashedEntries.put(i, networkTableInstance.getTable(tableAndEntry[0]).getEntry(tableAndEntry[1]));
			System.out.println("added " + i);
		}
	}

	/**
	 * @param entry table ID
	 * @return String from entry
	 */
	public String getStringEntry(String entry) {
		return this.hashedEntries.get(entry).getString("not a string");
	}

	/**
	 * @param entry table ID
	 * @return double from entry
	 */
	public double getDoubleEntry(String entry) {
		return this.hashedEntries.get(entry).getDouble(0.0);
	}

	/**
	 * @param entry table ID
	 * @param value String value to set entry to
	 */
	public void setStringEntry(String entry, String value) {
		this.hashedEntries.get(entry).setString(value);
		this.networkTableInstance.flush();
	}

	/**
	 * @param entry table ID
	 * @param value double value to set entry to
	 */
	public void setDoubleEntry(String entry, double value) {
		this.hashedEntries.get(entry).setDouble(value);
		this.networkTableInstance.flush();
	}
}