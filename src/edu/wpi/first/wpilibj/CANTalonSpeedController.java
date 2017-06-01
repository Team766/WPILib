package edu.wpi.first.wpilibj;

import com.ctre.CANTalon;
import interfaces.SpeedController;

public class CANTalonSpeedController extends CANTalon implements SpeedController{

	public CANTalonSpeedController(int deviceNumber) {
		super(deviceNumber);
	}

}
