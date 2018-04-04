/* Class for declaring autonomous commands. Used to keep all commands on
 * a single thread.
 */

package org.usfirst.frc.team1721.robot.subsystems;

import org.usfirst.frc.team1721.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous extends Subsystem {

//0.75 speed for 0.85 seconds = turn 90 agrees
    public void initDefaultCommand() {
    	
    }
    public static void driveToBaseline(DifferentialDrive d) {
    	d.arcadeDrive(-1, 0);
    	Timer.delay(1);
    	d.arcadeDrive(-0.5,0);
    	Timer.delay(.2);
    	d.arcadeDrive(-.2,0);
    	Timer.delay(.2);
    	d.arcadeDrive(0,0);
    }
    public static void driveToBaseline(DifferentialDrive d, WPI_VictorSPX intakeLifter) {
    	//intakeLifter.set(-0.8);
    	//Timer.delay(3);
    	//intakeLifter.set(0);
    	d.arcadeDrive(-0.5, 0.3);
    	Timer.delay(8);
    	d.arcadeDrive(0, 0);
    }
    public static void PIDfromLeft(WPI_TalonSRX port, WPI_TalonSRX starboard) {
    	port.selectProfileSlot(0, 0);
    	starboard.selectProfileSlot(1, 0);
    	port.config_kP(0, 1, 20);
    	port.config_kI(0, 0, 20);
    	port.config_kD(0, 0, 20);
    	port.config_kF(0, 0, 20);
    	starboard.config_kP(1, 1, 20);
    	starboard.config_kI(1, 0, 20);
    	starboard.config_kD(1, 0, 20);
    	starboard.config_kF(1, 0, 20);
    	starboard.set(ControlMode.Position, 400);
    	port.set(ControlMode.Position, 400);
    }
    public static void PIDfromRight(WPI_TalonSRX port, WPI_TalonSRX starboard) {
    	port.selectProfileSlot(0, 0);
    	starboard.selectProfileSlot(1, 0);
    	port.config_kP(0, 1, 20);
    	port.config_kI(0, 0, 20);
    	port.config_kD(0, 0, 20);
    	port.config_kF(0, 0, 20);
    	starboard.config_kP(1, 1, 20);
    	starboard.config_kI(1, 0, 20);
    	starboard.config_kD(1, 0, 20);
    	starboard.config_kF(1, 0, 20);
    	starboard.set(ControlMode.Position, 400);
    	port.set(ControlMode.Position, 400);
    }
    public static void switchFromLeft(DifferentialDrive d, WPI_VictorSPX lift, WPI_VictorSPX intake, WPI_VictorSPX intakeLifter) {
    	if(DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L') {
    		d.arcadeDrive(-0.6, 0.1);
	    	Timer.delay(7.5);
	    	d.arcadeDrive(0, 0);
	    	intakeLifter.set(-0.8);
	    	Timer.delay(0.8);
	    	intakeLifter.set(0);
	    	intake.set(-1);
	    	Timer.delay(5);
	    	intake.set(0);
    	}else {
    		d.arcadeDrive(-0.48, 0.13);
	    	Timer.delay(2.5);
	    	d.arcadeDrive(0, 0.65);
	    	Timer.delay(0.7);
	    	d.arcadeDrive(-0.52, 0.1);
	    	Timer.delay(7);
	    	d.arcadeDrive(0, -0.63);
	    	Timer.delay(0.7);
	    	d.arcadeDrive(-0.48, 0.1);
	    	Timer.delay(4);
	    	d.arcadeDrive(0, 0);
	    	intakeLifter.set(-0.8);
	    	Timer.delay(0.8);
	    	intakeLifter.set(0);
	    	intake.set(-1);
	    	Timer.delay(5);
	    	intake.set(0);
    	}
    }
    public static void switchFromRight(DifferentialDrive d, WPI_VictorSPX lift, WPI_VictorSPX intake, WPI_VictorSPX intakeLifter) {
    	if(DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R') {
    		d.arcadeDrive(-0.6, 0.1);
	    	Timer.delay(7.5);
	    	d.arcadeDrive(0, 0);
	    	intakeLifter.set(-0.8);
	    	Timer.delay(0.8);
	    	intakeLifter.set(0);
	    	intake.set(-1);
	    	Timer.delay(5);
	    	intake.set(0);
    	}else {
    		d.arcadeDrive(-0.48, 0.3);
	    	Timer.delay(2.5);
	    	d.arcadeDrive(0, -0.6);
	    	Timer.delay(0.7);
	    	d.arcadeDrive(-0.52, 0.3);
	    	Timer.delay(7);
	    	d.arcadeDrive(0, 0.68);
	    	Timer.delay(0.7);
	    	d.arcadeDrive(-0.48, 0.3);
	    	Timer.delay(4);
	    	d.arcadeDrive(0, 0);
	    	intakeLifter.set(-0.8);
	    	Timer.delay(0.8);
	    	intakeLifter.set(0);
	    	intake.set(-1);
	    	Timer.delay(5);
	    	intake.set(0);
    	}
    }
    public static void ScaleAutoRight(DifferentialDrive d, WPI_VictorSPX lift, WPI_VictorSPX intake, WPI_VictorSPX intakeLifter, DoubleSolenoid piston) {
    	d.arcadeDrive(1, 0);
    	Timer.delay(5);
    	d.arcadeDrive(0, 0);
    	if(DriverStation.getInstance().getGameSpecificMessage().charAt(1) == 'R') {
    		while(RobotMap.isAtTop.get() != true) {
        		lift.set(1);
        	}
        	intakeLifter.set(-0.8);
        	Timer.delay(0.8);
        	intakeLifter.set(0);
        	intake.set(-1);
    	}
    }
    public static void ScaleAutoLeft(DifferentialDrive d, WPI_VictorSPX lift, WPI_VictorSPX intake, WPI_VictorSPX intakeLifter, DoubleSolenoid piston) {
    	d.arcadeDrive(1, 0);
    	Timer.delay(5);
    	d.arcadeDrive(0, 0);
    	if(DriverStation.getInstance().getGameSpecificMessage().charAt(1) == 'L') {
    		while(RobotMap.isAtTop.get() != true) {
        		lift.set(1);
        	}
        	intakeLifter.set(-0.8);
        	Timer.delay(0.8);
        	intakeLifter.set(0);
        	intake.set(-1);
    	}
    }
    /** Shows switch and scale positions on SmartDashboard. Open YML.yml.xml to
     * view.
     */
    public static void showSwitchPositions() {
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	DriverStation.Alliance allianceColor = DriverStation.getInstance().getAlliance();
    	if(allianceColor == DriverStation.Alliance.Red) {
	    	if(gameData.length() > 0) {
				if(gameData.charAt(0) == 'L') {
					boolean isLeft = true;
					SmartDashboard.putBoolean(" Left home switch " , isLeft);
					SmartDashboard.putBoolean(" Right home switch " , isLeft);
				}
				if(gameData.charAt(0) == 'R') {
					boolean isLeft = false;
					SmartDashboard.putBoolean(" Left home switch " , isLeft);
					SmartDashboard.putBoolean(" Right home switch " , isLeft);
				}
				if(gameData.charAt(1) == 'L') {
					boolean isLeft = true;
					SmartDashboard.putBoolean(" Left scale " , isLeft);
					SmartDashboard.putBoolean(" Right scale " , isLeft);
				}
				if(gameData.charAt(1) == 'R') {
					boolean isLeft = false;
					SmartDashboard.putBoolean(" Left scale " , isLeft);
					SmartDashboard.putBoolean(" Right scale " , isLeft);
				}
				if(gameData.charAt(2) == 'L') {
					boolean isLeft = true;
					SmartDashboard.putBoolean(" Left opponent switch " , isLeft);
					SmartDashboard.putBoolean(" Right opponent switch " , isLeft);
				}
				if(gameData.charAt(2) == 'R') {
					boolean isLeft = false;
					SmartDashboard.putBoolean(" Left opponent switch " , isLeft);
					SmartDashboard.putBoolean(" Right opponent switch " , isLeft);
				}
			}
    	}else {
    		if(gameData.length() > 0) {
    			if(gameData.charAt(0) == 'L') {
    				boolean isLeft = false;
    				SmartDashboard.putBoolean(" Left home switch " , isLeft);
    				SmartDashboard.putBoolean(" Right home switch " , isLeft);
    			}
    			if(gameData.charAt(0) == 'R') {
    				boolean isLeft = true;
    				SmartDashboard.putBoolean(" Left home switch " , isLeft);
    				SmartDashboard.putBoolean(" Right home switch " , isLeft);
    			}
    			if(gameData.charAt(1) == 'L') {
    				boolean isLeft = false;
    				SmartDashboard.putBoolean(" Left scale " , isLeft);
    				SmartDashboard.putBoolean(" Right scale " , isLeft);
    			}
    			if(gameData.charAt(1) == 'R') {
    				boolean isLeft = true;
    				SmartDashboard.putBoolean(" Left scale " , isLeft);
    				SmartDashboard.putBoolean(" Right scale " , isLeft);
    			}
    			if(gameData.charAt(2) == 'L') {
    				boolean isLeft = false;
    				SmartDashboard.putBoolean(" Left opponent switch " , isLeft);
    				SmartDashboard.putBoolean(" Right opponent switch " , isLeft);
    			}
    			if(gameData.charAt(2) == 'R') {
    				boolean isLeft = true;
    				SmartDashboard.putBoolean(" Left opponent switch " , isLeft);
    				SmartDashboard.putBoolean(" Right opponent switch " , isLeft);
    			}
    		}
    	}
    }
}

