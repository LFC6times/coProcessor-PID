package frc.robot.util;

public class Timer {
	private double startTime;
	private double endTime;
	private boolean isRunning;

	public Timer() {
		startTime = 0;
		endTime = 0;
		isRunning = false;
	}

	/**
	 * Starts the timer.
	 */
	public void start() {
		startTime = System.currentTimeMillis();
		isRunning = true;
	}

	/**
	 * Stops the timer.
	 */
	public void stop() {
		endTime = System.currentTimeMillis(); // System.currentTimeMillis() hopefully won't break
		isRunning = false;
	}

	/**
	 * Resumes the timer.
	 */
	public void resume() {
		isRunning = true;
	}

	/**
	 * Get the time elapsed
	 *
	 * @return the time elapsed as a double, in milliseconds
	 */
	public double getTime() {
		return (isRunning ? System.currentTimeMillis() - this.startTime : this.endTime - this.startTime);
	}
}
