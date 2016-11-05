package edu.wpi.first.wpilibj;

import interfaces.CameraReader;
import interfaces.EncoderReader;
import interfaces.GyroReader;
import interfaces.JoystickReader;
import interfaces.RobotProvider;
import interfaces.SolenoidController;
import interfaces.SpeedController;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class WPIRobotProvider extends RobotProvider{

	@Override
	public SpeedController getMotor(int index) {
		if(motors[index] == null)
			motors[index] = new Talon(index);
		return motors[index];
	}

	@Override
	public EncoderReader getEncoder(int index1, int index2) {
		if(encoders[index1] == null)
			encoders[index1] = new Encoder(index1, index2);
		return encoders[index1];
	}

	@Override
	public SolenoidController getSolenoid(int index) {
		if(solenoids[index] == null)
			solenoids[index] = new Solenoid(index);
		return solenoids[index];
	}

	@Override
	public GyroReader getGyro(int index) {
		if(gyros[0] == null)
			gyros[0] = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
		return gyros[0];
	}
	
	@Override
	public CameraReader getCamera(String id, String value) {
		if(id.equals("axisCamera"))
			return new AxisCamera(value);
		return new USBCamera(value);
	}

	@Override
	public JoystickReader getJoystick(int index) {
		if(joysticks[index] == null)
			joysticks[index] = new Joystick(index);
		return joysticks[index];
	}

}
