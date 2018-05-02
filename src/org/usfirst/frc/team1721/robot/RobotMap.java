package org.usfirst.frc.team1721.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
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
	public static final int dtLeft = 0, dtRight = 1, slaveDriveLeft = 1, slaveDriveRight = 0, intakeMaster = 3, intakeSlave = 4, liftTalonAddress = 2, climberLeftAddress = 0, climberRightAddress = 5;
	//Controller and joystick axis/button assignments
	public static final int	raiseLiftAxis = 3, lowerLiftAxis = 2, spinAxis = 5, joystickPort = 0, controllerPort = 1, openButton = 6, closeButton = 5, intakeLifterAxis = 1, climbButton = 1, stopclimb = 2;
	//Talon objects
	public static WPI_TalonSRX vspLeft, vspRight, liftTalon;
	//Victor objects
	public static WPI_VictorSPX slaveLeft, slaveRight, intakeVictorRight, intakeVictorLeft, liftVictor, intakeLifter, climberVictorLeft, climberVictorRight;
	//Joystick objects
	public static Joystick stick, controller;
	//DriveTrain object
	public static DifferentialDrive rd;
	//Pneumatics channels
	public static final int inChannel = 0, outChannel = 1;
	//Piston objects
	public static DoubleSolenoid piston;
	//Limit switch objects - configured to return true when pressed
	public static DigitalInput isAtTop, isAtBottom, intakeLifted;
	//Encoders
	public static FeedbackDevice encRight;
	public static FeedbackDevice encLeft;
}