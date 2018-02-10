package org.usfirst.frc.team1721.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int dtLeft = 0, dtRight = 1, slaveDriveLeft = 1, slaveDriveRight = 0, intakeButton = 6, outputButton = 5, intakeMaster = 3, intakeSlave = 4;
	public static WPI_TalonSRX vspLeft, vspRight, liftTalon;
	public static WPI_VictorSPX slaveLeft, slaveRight, intakeVictorRight, intakeVictorLeft;
	public static final int joyLeft = 0;
	public static Joystick stick, controller;
	
	public static DifferentialDrive rd;
}