// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import java.util.ArrayList;
import java.util.HashMap;

public class NetworkTablesReader extends Thread { // make multithreaded so other stuff can be done without holdup
	private static NetworkTablesReader ntr = null;
	private final long waitTimeMS = 10;
	private final NetworkTableInstance networkTableInstance;
	private HashMap<String, NetworkTableEntry> hashedEntries;

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

		// this.init();
	}

	/**
	 * Initialize the HashMap of entries
	 *
	 * @param entries a HashMap of Strings to an ArrayList of Strings, tables to entries in each table
	 */
	private void init(HashMap<String, ArrayList<String>> entries) {
		for (String i : entries.keySet()) {
			for (String j : entries.get(i)) {
				hashedEntries.put(i, networkTableInstance.getTable(i).getEntry(j));
			}
		}
	}

	/**
	 * Basically a periodic() for this class, idk if this'll even be used
	 */
	@Override
	public void run() {
		while (true) { // "'while' statement cannot complete without throwing an exception" - IntelliJ, 2022
			try {
				Thread.sleep(waitTimeMS); // "probably busy-waiting" - IntelliJ, 2022
				// System.out.println(instance.getTable("test").getEntry("sus").getString("not a string"));
			} catch (InterruptedException iException) {
				System.out.println("baka interrupted me");
			}
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