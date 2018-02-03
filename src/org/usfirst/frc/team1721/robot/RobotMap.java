package org.usfirst.frc.team1721.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int dtLeft = 0, dtRight = 1;
	public static WPI_TalonSRX driveTalonLeft, driveTalonRight;
	//public static final int joyLeft = 0;
	public static Joystick stick;
	
	public static RobotDrive rd;
}