package frc.robot.robot;

public class PoseEstimatingNaivety {
	private final double startX, startZ, initVelX, initVelZ;
	private double velocityX, velocityZ, displacementX, displacementZ;

	public PoseEstimatingNaivety(double startX, double startZ, double velocityX, double velocityZ) {
		this.startX = startX;
		this.startZ = startZ;
		this.initVelX = velocityX;
		this.initVelZ = velocityZ;
		this.velocityX = initVelX;
		this.velocityZ = initVelZ;
	}

	/**
	 * @return the displacement in the x direction
	 */
	public double getDisplacementX() {
		return this.displacementX;
	}

	/**
	 * @return the displacement in the z direction
	 */
	public double getDisplacementZ() {
		return this.displacementZ;
	}

	/**
	 * @return the velocity in the x direction
	 */
	public double getVelocityX() {
		return this.velocityX;
	}

	/**
	 * @return the velocity in the z direction
	 */
	public double getVelocityZ() {
		return this.velocityZ;
	}

	/**
	 * update the velocity and displacement
	 *
	 * @param accelX the acceleration in the x direction
	 * @param accelZ the acceleration in the z direction
	 * @param deltaTime the time since the last update
	 */
	public void update(double accelX, double accelZ, double deltaTime) {
		this.velocityX = this.calculateVelocityX(accelX, deltaTime);
		this.velocityZ = this.calculateVelocityZ(accelZ, deltaTime);

		this.displacementX = this.calculateDisplacementX(accelX, deltaTime);
		this.displacementZ = this.calculateDisplacementZ(accelZ, deltaTime);
	}

	/**
	 * @param accel the acceleration in the x direction
	 * @param deltaTime the time since the last update
	 * @return the new velocity in the x direction
	 */
	public double calculateVelocityX(double accel, double deltaTime) {
		return this.velocityX + accel * deltaTime;
	}

	/**
	 * @param accel the acceleration in the z direction
	 * @param deltaTime the time since the last update
	 * @return the new velocity in the z direction
	 */
	public double calculateVelocityZ(double accel, double deltaTime) {
		return this.velocityZ + accel * deltaTime;
	}

	/**
	 * @param velocityX the current velocity in the X direction
	 * @param deltaTime the time since the last update
	 * @return the new displacement in the X direction
	 */
	public double calculateDisplacementX(double velocityX, double deltaTime) {
		return this.displacementX + velocityX * deltaTime;
	}

	/**
	 * @param velocityZ the current velocity in the Z direction
	 * @param deltaTime the time since the last update
	 * @return the new displacement in the Z direction
	 */
	public double calculateDisplacementZ(double velocityZ, double deltaTime) {
		return this.displacementZ + velocityZ * deltaTime;
	}

	/**
	 * @param velocityX the new velocity in the x direction
	 */
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	/**
	 * @param velocityZ the new velocity in the z direction
	 */
	public void setVelocityZ(double velocityZ) {
		this.velocityZ = velocityZ;
	}

	/**
	 * @param displacement the displacement in the x direction
	 */
	public void setDisplacementX(double displacement) {
		this.displacementX = displacement;
	}

	/**
	 * @param displacement the displacement in the z direction
	 */
	public void setDisplacementZ(double displacement) {
		this.displacementZ = displacement;
	}
}
