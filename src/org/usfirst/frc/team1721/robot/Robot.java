package org.usfirst.frc.team1721.robot;

import org.usfirst.frc.team1721.robot.commands.GoToFloor;
import org.usfirst.frc.team1721.robot.commands.GoToScale;
import org.usfirst.frc.team1721.robot.commands.GoToSwitch;
import org.usfirst.frc.team1721.robot.subsystems.DriveTrain;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	public static OI oi; 
	
	public static DriveTrain dt;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		oi = new OI();
		dt = new DriveTrain();
		//Declare drive Talons
		RobotMap.driveTalonLeft = new WPI_TalonSRX(RobotMap.driveMasterLeft);
		RobotMap.driveTalonRight = new WPI_TalonSRX(RobotMap.driveMasterRight);
		//Declare drive Victors for WPI purposes
		RobotMap.driveVictorLeft = new WPI_VictorSPX(RobotMap.driveSlaveLeft);
		RobotMap.driveVictorRight = new WPI_VictorSPX(RobotMap.driveSlaveRight);
		//Declare drivetrain
		RobotMap.rd = new DifferentialDrive(RobotMap.driveTalonLeft, RobotMap.driveTalonRight);
		//Turn off safety
		RobotMap.driveTalonLeft.setSafetyEnabled(false);
		RobotMap.driveTalonRight.setSafetyEnabled(false);
		RobotMap.rd.setSafetyEnabled(false);
		//Declare joystick
		RobotMap.stick = new Joystick(RobotMap.stickPort);
		//Declare controller
		RobotMap.controller = new Joystick(RobotMap.controllerPort);
		//Set drive Victors to follower mode
		RobotMap.driveVictorLeft.follow(RobotMap.driveTalonLeft);
		RobotMap.driveVictorRight.follow(RobotMap.driveTalonRight);
		//Declare drive Victors for CTRE purposes
		RobotMap.canTalonRight = new CANTalon(RobotMap.driveMasterRight);
		RobotMap.canTalonLeft = new CANTalon(RobotMap.driveMasterLeft);
		//Declare intake Victors
		RobotMap.intakeVictorLeft = new WPI_VictorSPX(RobotMap.intakeLeft);
		RobotMap.intakeVictorRight = new WPI_VictorSPX(RobotMap.intakeRight);
		//Declare lift Talon
		RobotMap.liftTalon = new WPI_TalonSRX(RobotMap.liftMotor);
		
		RobotMap.goToFloorButton = new JoystickButton(RobotMap.controller, 1);
		RobotMap.goToScaleButton = new JoystickButton(RobotMap.controller, 4);
		RobotMap.goToSwitchButton = new JoystickButton(RobotMap.controller, 2);
	}
	
	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		RobotMap.isAtFloor = true;
		RobotMap.isAtScale = false;
		RobotMap.isAtSwitch = false;
		while (isEnabled() && isAutonomous()) {
		RobotMap.rd.arcadeDrive(10, 0);
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	
	@Override
	public void teleopInit() {
		while (isEnabled() && isOperatorControl()) {
			DriveTrain.driveWithJoystick(RobotMap.stick, RobotMap.rd);
			//Intake.ExpelCube(RobotMap.intakeVictorLeft, RobotMap.intakeVictorRight, RobotMap.controller);
			//Intake.IntakeCube(RobotMap.intakeVictorLeft, RobotMap.intakeVictorRight, RobotMap.controller);
			RobotMap.goToFloorButton.whenPressed(new GoToFloor());
			RobotMap.goToScaleButton.whenPressed(new GoToScale());
			RobotMap.goToSwitchButton.whenPressed(new GoToSwitch());
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
public void teleopPeriodic() {
	Scheduler.getInstance().run();
}
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}