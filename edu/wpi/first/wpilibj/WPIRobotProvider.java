package edu.wpi.first.wpilibj;

import interfaces.EncoderReader;
import interfaces.GyroReader;
import interfaces.JoystickReader;
import interfaces.RobotProvider;
import interfaces.SolenoidController;
import interfaces.SpeedController;

public class WPIRobotProvider extends RobotProvider{

	@Override
	public SpeedController getMotor(int index) {
		return new Talon(index);
	}

	@Override
	public EncoderReader getEncoder(int index1, int index2) {
		return new Encoder(index1, index2);
	}

	@Override
	public SolenoidController getSolenoid(int index) {
		return new Solenoid(index);
	}

	@Override
	public GyroReader getGyro(int index) {
		return new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
	}

	@Override
	public JoystickReader getJoystick(int index) {
		return new Joystick(index);
	}

}
