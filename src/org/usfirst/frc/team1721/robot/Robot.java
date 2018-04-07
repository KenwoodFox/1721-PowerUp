package org.usfirst.frc.team1721.robot;

import org.usfirst.frc.team1721.robot.commands.DriveToBaseline;
import org.usfirst.frc.team1721.robot.commands.IntakeCube;
import org.usfirst.frc.team1721.robot.commands.NullAuto;
import org.usfirst.frc.team1721.robot.commands.PIDfromLeft;
import org.usfirst.frc.team1721.robot.commands.PIDfromRight;
import org.usfirst.frc.team1721.robot.commands.SwitchFromLeft;
import org.usfirst.frc.team1721.robot.commands.SwitchFromRight;
import org.usfirst.frc.team1721.robot.subsystems.Autonomous;
import org.usfirst.frc.team1721.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1721.robot.subsystems.Lift;
import org.usfirst.frc.team1721.robot.subsystems.TeleOp;
import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static SendableChooser autoChooser;
	Command autonomousCommand;
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

		// TODO: Make the talons move like a PID loop, because they can.
		// I'm only not doing this because I'm waking up in under 5 hours.
		RobotMap.isAtFloor = true;
		RobotMap.isAtScale = false;
		RobotMap.isAtSwitch = false;
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
		while (isEnabled() && isAutonomous()) {
		RobotMap.rd.arcadeDrive(10, 0);
		}
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
		while(isEnabled() && isOperatorControl()){ // Runs periodically (every 25 ms) during teleop
			//RobotMap.intakeLifter.set(-0.8);
			SmartDashboard.putBoolean("Max Intake Extension: ", RobotMap.intakeLifted.get());
			SmartDashboard.putBoolean("Max Lift Extension:", RobotMap.isAtTop.get());
			SmartDashboard.putBoolean("Min Lift Extension:", RobotMap.isAtBottom.get());
			DriveTrain.driveWithJoystick(RobotMap.stick, RobotMap.rd); // Drive
			TeleOp.RaiseLift(RobotMap.liftVictor, RobotMap.controller); // Raise lift
			if(RobotMap.controller.getRawAxis(2) > 0) { // Ensures brake mode does not stop the lift from rising
				TeleOp.LowerLift(RobotMap.liftVictor, RobotMap.controller);// Lower lift
			}
			new IntakeCube();
			TeleOp.DropIntake(RobotMap.controller, RobotMap.intakeLifter);
			TeleOp.IntakeCube(RobotMap.intakeVictorLeft, RobotMap.controller);
			Timer.delay(0.005);
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
