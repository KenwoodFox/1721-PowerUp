package org.usfirst.frc.team1721.robot;

import org.usfirst.frc.team1721.robot.subsystems.Autonomous;
import org.usfirst.frc.team1721.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1721.robot.subsystems.Intake;
import org.usfirst.frc.team1721.robot.subsystems.Lift;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		RobotMap.vspLeft = new WPI_TalonSRX(RobotMap.dtLeft);
		RobotMap.vspRight = new WPI_TalonSRX(RobotMap.dtRight);
		
		RobotMap.slaveLeft = new WPI_VictorSPX(RobotMap.slaveDriveLeft);
		RobotMap.slaveRight = new WPI_VictorSPX(RobotMap.slaveDriveRight);
		
		RobotMap.slaveLeft.follow(RobotMap.vspLeft);
		RobotMap.slaveRight.follow(RobotMap.vspRight);
		
		RobotMap.rd = new DifferentialDrive(RobotMap.vspLeft, RobotMap.vspRight);
		
		RobotMap.stick = new Joystick(0);
		
		RobotMap.vspLeft.setSafetyEnabled(false);
		RobotMap.vspRight.setSafetyEnabled(false);
		RobotMap.rd.setSafetyEnabled(false);
		
		RobotMap.liftTalon = new WPI_TalonSRX(2);
		
		RobotMap.controller = new Joystick(1);
		
		RobotMap.intakeVictorLeft = new WPI_VictorSPX(RobotMap.intakeMaster);
		RobotMap.intakeVictorRight = new WPI_VictorSPX(RobotMap.intakeSlave);
		
		RobotMap.intakeVictorRight.follow(RobotMap.intakeVictorLeft);
		
		//while(isEnabled() && isOperatorControl()){
		//	RobotMap.rd = new RobotDrive(RobotMap.vspLeft, RobotMap.vspRight);
		//}
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
		Autonomous.showSwitchPositions();
		
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
		while(isEnabled() && isOperatorControl()){
			DriveTrain.driveWithJoystick(RobotMap.stick, RobotMap.rd);
			Lift.RaiseLift(RobotMap.liftTalon, RobotMap.controller);
			if(RobotMap.controller.getRawAxis(2) > 0) {
			Lift.LowerLift(RobotMap.liftTalon, RobotMap.controller);
			}
			Intake.IntakeCube(RobotMap.intakeVictorLeft, RobotMap.controller);
			Timer.delay(0.005);
		}
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
