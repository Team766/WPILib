package edu.wpi.first.wpilibj;

import interfaces.SpeedController;

public interface WPISpeedController extends PIDOutput, SpeedController {
	/**
	 * Disable the speed controller
	 */
	void disable();
}
