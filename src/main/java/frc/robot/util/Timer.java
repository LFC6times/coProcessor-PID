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

	public void start() {
		startTime = System.currentTimeMillis();
		isRunning = true;
	}

	public void stop() {
		endTime = System.currentTimeMillis(); // System.currentTimeMillis() hopefully won't break
		isRunning = false;
	}

	public void resume() {
		isRunning = true;
	}

	public double getTime() {
		return (isRunning ? System.currentTimeMillis() - this.startTime : this.endTime - this.startTime);
	}
}
