package org.usfirst.frc.team1721.robot;

<<<<<<< HEAD
import com.ctre.CANTalon;
=======
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.DriverStation;
=======
import edu.wpi.first.wpilibj.DigitalInput;
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
import edu.wpi.first.wpilibj.Joystick;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.buttons.Button;
=======
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
<<<<<<< HEAD
	public static final int driveMasterLeft = 0, driveMasterRight = 1, driveSlaveLeft = 1, driveSlaveRight = 0, intakeLeft = 99, intakeRight = 99, liftMotor = 2;
	public static final int intakeButton = 6, outputButton = 5, raiseLiftAxis = 3, lowerLiftAxis = 2;
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
	public static final double switchHeight = 28.6, scaleHeight = 117.8, switchToScale = 89.2;
=======
	//CAN addresses for Talons and Victors
	public static final int dtLeft = 0, dtRight = 1, slaveDriveLeft = 1, slaveDriveRight = 0, intakeMaster = 3, intakeSlave = 4, liftTalonAddress = 2;
	//Controller and joystick axis/button assignments
	public static final int	intakeAxis = 5, raiseLiftAxis = 3, lowerLiftAxis = 2, joystickPort = 0, controllerPort = 1;
	//Talon objects
	public static WPI_TalonSRX vspLeft, vspRight, liftTalon;
	//Victor objects
	public static WPI_VictorSPX slaveLeft, slaveRight, intakeVictorRight, intakeVictorLeft, liftVictor, intakeLifter;
	//Joystick objects
	public static Joystick stick, controller;
	//DriveTrain object
	public static DifferentialDrive rd;
	
	public static DigitalInput isAtTop, isAtBottom, intakeLifted;
	
	public static FeedbackDevice encRight;
	public static FeedbackDevice encLeft;
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
}