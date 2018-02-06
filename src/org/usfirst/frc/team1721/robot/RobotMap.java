package org.usfirst.frc.team1721.robot;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int driveMasterLeft = 0, driveMasterRight = 1, driveSlaveLeft = 0, driveSlaveRight = 1, intakeLeft = 99, intakeRight = 99, liftMotor = 2;
	public static final int intakeButton = 6, outputButton = 5;
	public static final double initialHeight = 0;
	public static WPI_TalonSRX driveTalonLeft, driveTalonRight, liftTalon;
	public static CANTalon canTalonLeft, canTalonRight;
	public static WPI_VictorSPX driveVictorLeft, driveVictorRight, intakeVictorLeft, intakeVictorRight, liftVictor;
	public static final int stickPort = 0, controllerPort = 1;
	public static Joystick stick;
	public static DriverStation driveStation;
	public static FeedbackDevice encPort, encStarboard;
	public static DifferentialDrive rd;
	public static Joystick controller;
	public static Button goToScaleButton;
	public static Button goToSwitchButton;
	public static Button goToFloorButton;
	public static boolean isAtFloor, isAtSwitch, isAtScale;
	public static final double switchHeight = 0.5, scaleHeight = 1, switchToScale = 0.5;
}