package org.usfirst.frc.team1721.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int dtLeft = 1, dtRight = 0; //TalonSRX ids
	public static CANTalon talonLeft, talonRight;
	public static final int joyLeft = 0; //Joystick id
	public static Joystick stick;
	public static Encoder encPort;
	public static Encoder encStarboard;
	public static final int pValue = 1, iValue = 1, dValue = 1; //P, I, and D values passed to Talons
	
	public static RobotDrive rd;
}
