/* Class for declaring autonomous commands. Used to keep all commands on
 * a single thread.
 */

package org.usfirst.frc.team1721.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

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
    public static void driveToBaseline(DifferentialDrive d, WPI_VictorSPX intakeLifter) {
    	//intakeLifter.set(-0.8);
    	//Timer.delay(3);
    	//intakeLifter.set(0);
    	d.arcadeDrive(-0.5, 0);
    	Timer.delay(5);
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
	    	d.arcadeDrive(-0.48, 0);
	    	Timer.delay(5);
	    	d.arcadeDrive(0, 0);
	    	intakeLifter.set(0.8);
	    	Timer.delay(0.8);
	    	intakeLifter.set(0);
	    	intake.set(1);
	    	Timer.delay(5);
	    	intake.set(0);
    	}else {
    		d.arcadeDrive(-0.48, 0);
	    	Timer.delay(1);
	    	d.arcadeDrive(0, -0.67);
	    	Timer.delay(0.7);
	    	d.arcadeDrive(-0.48, 0);
	    	Timer.delay(5);
	    	d.arcadeDrive(0, 0.67);
	    	Timer.delay(0.7);
	    	d.arcadeDrive(-0.48, 0);
	    	Timer.delay(4);
	    	d.arcadeDrive(0, 0);
	    	/*intakeLifter.set(0.8);
	    	Timer.delay(0.8);
	    	intakeLifter.set(0);
	    	intake.set(1);
	    	Timer.delay(5);
	    	intake.set(0);*/
    	}
    }
    public static void switchFromRight(DifferentialDrive d, WPI_VictorSPX lift, WPI_VictorSPX intake, WPI_VictorSPX intakeLifter) {
    	/*intakeLifter.set(-0.8);
    	Timer.delay(3);
    	intakeLifter.set(0);
    	if(DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R') {
    		d.arcadeDrive(-0.48, 0);
    		Timer.delay(0);
    		d.arcadeDrive(0, 0);
    		lift.set(1);
    		Timer.delay(0.3);
    		intake.set(1);
    		Timer.delay(0.2);
    		lift.set(0.8);
    		Timer.delay(1.8);
    		intake.set(0);
    	}else {
    		d.arcadeDrive(-0.45, 0);
    		Timer.delay(5);
    		d.arcadeDrive(0, 0);
    	}*/
    	if(DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R') {
	    	d.arcadeDrive(-0.48, 0);
	    	Timer.delay(5);
	    	d.arcadeDrive(0, 0);
	    	intakeLifter.set(-0.8);
	    	Timer.delay(0.8);
	    	intakeLifter.set(0);
	    	intake.set(1);
	    	Timer.delay(5);
	    	intake.set(0);
    	}else {
    		d.arcadeDrive(-0.48, 0);
	    	Timer.delay(5);
	    	d.arcadeDrive(0, 0);
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

