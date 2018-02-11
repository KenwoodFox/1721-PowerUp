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
	//CAN addresses for Talons and Victors
	public static final int dtLeft = 0, dtRight = 1, slaveDriveLeft = 1, slaveDriveRight = 0, intakeMaster = 3, intakeSlave = 4, liftTalonAddress = 2;
	//Controller and joystick axis/button assignments
	public static final int	intakeAxis = 5, raiseLiftAxis = 3, lowerLiftAxis = 2, joystickPort = 0, controllerPort = 1;
	//Talon objects
	public static WPI_TalonSRX vspLeft, vspRight, liftTalon;
	//Victor objects
	public static WPI_VictorSPX slaveLeft, slaveRight, intakeVictorRight, intakeVictorLeft;
	//Joystick objects
	public static Joystick stick, controller;
	//DriveTrain object
	public static DifferentialDrive rd;
}