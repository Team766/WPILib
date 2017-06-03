package edu.wpi.first.wpilibj;

import interfaces.AnalogInputReader;
import interfaces.CameraInterface;
import interfaces.CameraReader;
import interfaces.DigitalInputReader;
import interfaces.DigitalOut;
import interfaces.EncoderReader;
import interfaces.GyroReader;
import interfaces.JoystickReader;
import interfaces.RobotProvider;
import interfaces.SolenoidController;
import interfaces.SpeedController;

public class WPIRobotProvider extends RobotProvider{

	@Override
	public SpeedController getMotor(int index, boolean isTalon) {
		if(motors[index] == null){
			motors[index] = isTalon ? new CANTalonSpeedController(index) : new Victor(index);
		}
		
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
	//Gyro index values:
	// -1 	= Spartan Gyro
	// 	0+ 	= Analog Gyro on port index 
	public GyroReader getGyro(int index) {
		if(gyros[index + 1] == null){
			if(index == -1)
				gyros[index + 1] = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
			else
				gyros[index + 1] = new AnalogGyro(index);
		}
		return gyros[index + 1];
	}
	
	@Override
	public CameraReader getCamera(String id, String value) {
		System.err.println("Camera support not yet avaible");
		return null;
	}

	@Override
	public JoystickReader getJoystick(int index) {
		if(joysticks[index] == null)
			joysticks[index] = new Joystick(index);
		return joysticks[index];
	}
	
	@Override
	public CameraInterface getCamServer(){
		return CameraServer.getInstance();
	}

	@Override
	public DigitalInputReader getDigitalInput(int index) {
		if(digInputs[index] == null)
			digInputs[index] = new DigitalInput(index);
		return digInputs[index];
	}
	
	public AnalogInputReader getAnalogInput(int index){
		if(angInputs[index] == null)
			angInputs[index] = new AnalogInput(index);
		return angInputs[index];
	}
	
	public DigitalOut getDigitalOutput(int index) {
		if(digOut[index] == null)
			digOut[index] = new Relay(index);
		return digOut[index];
	}

}
