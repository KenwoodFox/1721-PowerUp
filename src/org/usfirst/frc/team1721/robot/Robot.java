package org.usfirst.frc.team1721.robot;

import org.usfirst.frc.team1721.robot.commands.DriveToBaseline;
import org.usfirst.frc.team1721.robot.commands.NullAuto;
import org.usfirst.frc.team1721.robot.commands.PIDTESTER;
import org.usfirst.frc.team1721.robot.commands.PIDfromLeft;
import org.usfirst.frc.team1721.robot.commands.PIDfromRight;
import org.usfirst.frc.team1721.robot.commands.ScaleAutoLeft;
import org.usfirst.frc.team1721.robot.commands.ScaleAutoRight;
import org.usfirst.frc.team1721.robot.commands.SwitchFromLeft;
import org.usfirst.frc.team1721.robot.commands.SwitchFromRight;
import org.usfirst.frc.team1721.robot.commands.leftOnly;
import org.usfirst.frc.team1721.robot.subsystems.Autonomous;
import org.usfirst.frc.team1721.robot.subsystems.DriveTrain;
<<<<<<< HEAD
import org.usfirst.frc.team1721.robot.subsystems.Lift;
=======
import org.usfirst.frc.team1721.robot.subsystems.TeleOp;
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp

<<<<<<< HEAD
import com.ctre.CANTalon;
=======
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
<<<<<<< HEAD
import com.ctre.phoenix.motorcontrol.VelocityMeasPeriod;
=======
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
>>>>>>> 25a46901b680da9df7b41ca48d38c709a0c4fd96
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import edu.wpi.first.wpilibj.buttons.JoystickButton;
=======
import edu.wpi.first.wpilibj.Timer;
>>>>>>> 25a46901b680da9df7b41ca48d38c709a0c4fd96
import edu.wpi.first.wpilibj.command.Command;
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
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
		dt = new DriveTrain();
<<<<<<< HEAD
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
		
		RobotMap.isAtFloor = true;
		RobotMap.isAtScale = false;
		RobotMap.isAtSwitch = false;
	}
	
	
=======
		//Initialize drive Talons
		RobotMap.vspLeft = new WPI_TalonSRX(RobotMap.dtLeft);
		RobotMap.vspRight = new WPI_TalonSRX(RobotMap.dtRight);
		//Initialize drive slave Victors
		//RobotMap.slaveLeft = new WPI_VictorSPX(RobotMap.slaveDriveLeft);
		//RobotMap.slaveRight = new WPI_VictorSPX(RobotMap.slaveDriveRight);
		//Set drive slaves to follower mode
		//RobotMap.slaveLeft.follow(RobotMap.vspLeft);
		//RobotMap.slaveRight.follow(RobotMap.vspRight);
		//Initialize drive train
		RobotMap.rd = new DifferentialDrive(RobotMap.vspLeft, RobotMap.vspRight);
		//Initialize drive joystick
		RobotMap.stick = new Joystick(RobotMap.joystickPort);
		//Disabled drive safety
		RobotMap.vspLeft.setSafetyEnabled(false);
		RobotMap.vspRight.setSafetyEnabled(false);
		RobotMap.rd.setSafetyEnabled(false);
		//Initialize lift Talon
		RobotMap.liftTalon = new WPI_TalonSRX(5);
		//Initialize operator controller
		RobotMap.controller = new Joystick(RobotMap.controllerPort);
		//Initialize intake Victors
		RobotMap.intakeVictorLeft = new WPI_VictorSPX(RobotMap.intakeMaster);
		RobotMap.intakeVictorRight = new WPI_VictorSPX(RobotMap.intakeSlave);
		//Set right intake Victor to follow left intake Victor
		RobotMap.intakeVictorRight.follow(RobotMap.intakeVictorLeft);
		
		RobotMap.climberVictorLeft = new WPI_VictorSPX(RobotMap.climberLeftAddress);
		RobotMap.climberVictorRight = new WPI_VictorSPX(RobotMap.climberRightAddress);
		
		RobotMap.climberVictorRight.follow(RobotMap.climberVictorLeft);
		
		RobotMap.piston = new DoubleSolenoid(RobotMap.inChannel, RobotMap.outChannel);
		
		RobotMap.intakeLifter = new WPI_VictorSPX(2);
		
		RobotMap.liftTalon = new WPI_TalonSRX(RobotMap.liftTalonAddress);
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Drive to baseline" , new DriveToBaseline());
		autoChooser.addObject("Null auto", new NullAuto());
		autoChooser.addObject("Switch from right", new SwitchFromRight());
		autoChooser.addObject("Switch from left", new SwitchFromLeft());
		autoChooser.addObject("PID from left", new PIDfromLeft());
		autoChooser.addObject("PID from right", new PIDfromRight());
		autoChooser.addObject("Scale from right",  new ScaleAutoRight());
		autoChooser.addObject("Scale from left", new ScaleAutoLeft());
		autoChooser.addObject("PID tester", new PIDTESTER());
		autoChooser.addObject("Joe use this one", new leftOnly());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		
		//RobotMap.liftVictor.follow(RobotMap.climberTalon);
		
		RobotMap.vspLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		RobotMap.vspRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		RobotMap.intakeLifted = new DigitalInput(1);
		RobotMap.isAtTop = new DigitalInput(2);
		RobotMap.isAtBottom = new DigitalInput(0);
		
		RobotMap.vspLeft.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_100Ms, 1);
		RobotMap.vspRight.configVelocityMeasurementWindow(64, 1); 
		
		oi = new OI();
	}
<<<<<<< HEAD
=======
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
>>>>>>> 25a46901b680da9df7b41ca48d38c709a0c4fd96
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	@Override
	public void autonomousInit() {
<<<<<<< HEAD
		RobotMap.piston.set(DoubleSolenoid.Value.kForward);
=======
<<<<<<< HEAD
		while (isEnabled() && isAutonomous()) {
		RobotMap.rd.arcadeDrive(10, 0);
		}
=======
>>>>>>> 25a46901b680da9df7b41ca48d38c709a0c4fd96
		Autonomous.showSwitchPositions();
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
	}

	/**
	 * This function is called periodically during autonomous
	 */
<<<<<<< HEAD
	
=======
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
	@Override
	public void teleopInit() {
<<<<<<< HEAD
		
=======
<<<<<<< HEAD
		while (isEnabled() && isOperatorControl()) {
			DriveTrain.driveWithJoystick(RobotMap.stick, RobotMap.rd);
			//Intake.ExpelCube(RobotMap.intakeVictorLeft, RobotMap.intakeVictorRight, RobotMap.controller);
			//Intake.IntakeCube(RobotMap.intakeVictorLeft, RobotMap.intakeVictorRight, RobotMap.controller);
			Lift.LowerLift(RobotMap.liftTalon, RobotMap.controller);
			Lift.RaiseLift(RobotMap.liftTalon, RobotMap.controller);
=======
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
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
		}
>>>>>>> 25a46901b680da9df7b41ca48d38c709a0c4fd96
	}

	/**
	 * This function is called periodically during operator control
	 */
<<<<<<< HEAD
public void teleopPeriodic() {
	Scheduler.getInstance().run();
}
=======
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Max Intake Extension: ", RobotMap.intakeLifted.get());
		SmartDashboard.putBoolean("Max Lift Extension:", RobotMap.isAtTop.get());
		SmartDashboard.putBoolean("Min Lift Extension:", RobotMap.isAtBottom.get());
		DriveTrain.driveWithJoystick(RobotMap.stick, RobotMap.rd); // Drive
		TeleOp.RaiseLift(RobotMap.liftTalon, RobotMap.controller); // Raise lift
		if(RobotMap.controller.getRawAxis(RobotMap.lowerLiftAxis) >= 0.2) {
		TeleOp.LowerLift(RobotMap.liftTalon, RobotMap.controller);
		}
		TeleOp.DropIntake(RobotMap.controller, RobotMap.intakeLifter);
		TeleOp.spinOut(RobotMap.intakeVictorLeft, RobotMap.controller);
		//TeleOp.spinnySpinny(RobotMap.intakeVictorLeft, RobotMap.stick);
	}

>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
