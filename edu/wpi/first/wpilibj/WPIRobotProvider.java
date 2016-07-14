package edu.wpi.first.wpilibj;

import interfaces.EncoderReader;
import interfaces.GyroReader;
import interfaces.JoystickReader;
import interfaces.RobotProvider;
import interfaces.SolenoidController;
import interfaces.SpeedController;

public class WPIRobotProvider extends RobotProvider{

	/**
	 * Ports
	 */
	private final int LEFT_DRIVE = 1,
					  RIGHT_DRIVE = 0,
					  DIO_LDriveEncA = 16,	//Enc3
					  DIO_LDriveEncB = 17,
					  DIO_RDriveEncA = 14,	//Enc2
					  DIO_RDriveEncB = 15,
					  SOL_DRIVE_SHIFT = 0;
	
	
	
	@Override
	public SpeedController getLeftDrive() {
		return new Talon(LEFT_DRIVE);
	}

	@Override
	public SpeedController getRightDrive() {
		return new Talon(RIGHT_DRIVE);
	}

	@Override
	public EncoderReader getLeftEncoder() {
		return new Encoder(DIO_LDriveEncA, DIO_LDriveEncB);
	}

	@Override
	public EncoderReader getRightEncoder() {
		return new Encoder(DIO_RDriveEncA, DIO_RDriveEncB);
	}

	@Override
	public SolenoidController getDriveShifter() {
		return new Solenoid(0, SOL_DRIVE_SHIFT);
	}

	@Override
	public GyroReader getGyro() {
		return new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
	}

	@Override
	public JoystickReader getLeftJoystick() {
		return new Joystick(0);
	}

	@Override
	public JoystickReader getRightJoystick() {
		return new Joystick(1);
	}
	
	public JoystickReader getBoxJoystick() {
		return new Joystick(2);
	}

}
