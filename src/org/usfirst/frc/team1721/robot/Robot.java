package org.usfirst.frc.team1721.robot;

import org.usfirst.frc.team1721.robot.subsystems.AutonomousDrive;
import org.usfirst.frc.team1721.robot.subsystems.DriveTrain;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
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
		//Declare Victors
		RobotMap.talonLeft = new CANTalon(RobotMap.dtLeft);
		RobotMap.talonRight = new CANTalon(RobotMap.dtRight);
		//Declare encoders
		RobotMap.encPort = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		RobotMap.encStarboard = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		//Initialize Talons with encoder feedback
		RobotMap.talonLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		RobotMap.talonLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		//Create drive object for teleop.
		RobotMap.rd = new RobotDrive(RobotMap.talonLeft, RobotMap.talonRight);
		
		//RobotMap.vspLeft.setSafetyEnabled(false);
		//RobotMap.vspRight.setSafetyEnabled(false);
		
		//while(isEnabled() && isOperatorControl()){
		//	RobotMap.rd = new RobotDrive(RobotMap.vspLeft, RobotMap.vspRight);
		//}
	}
	
	public void operatorControl(){
		while(isEnabled() && isOperatorControl()){
			DriveTrain.driveWithJoystick(RobotMap.stick, RobotMap.rd);
			Timer.delay(0.005);
		}
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
		//Start encoder measurement
		AutonomousDrive.InitiateEncoders(RobotMap.encPort, RobotMap.encStarboard);
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
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
