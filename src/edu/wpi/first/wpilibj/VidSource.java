package edu.wpi.first.wpilibj;

import edu.wpi.cscore.VideoSource;
import interfaces.VidSourceInterface;

public abstract class VidSource extends VideoSource implements VidSourceInterface{
	protected VidSource(int handle) {
		super(handle);
	}

}
