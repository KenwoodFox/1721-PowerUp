package org.usfirst.frc.team1721.robot.subsystems;

import org.usfirst.frc.team1721.robot.Robot;
import org.usfirst.frc.team1721.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public static void RaiseLift(WPI_TalonSRX a, Joystick j) {
    	double throttle = -1 * (j.getRawAxis(RobotMap.raiseLiftAxis) / 1.8);
    	a.set(throttle);
    	//double time = height / 0.555555556;
    	//a.set(-0.55555556);
    	//Timer.delay(time);
    	//a.set(0);
    }
    public static void LowerLift(WPI_TalonSRX a, Joystick j) {
    	double throttle = j.getRawAxis(RobotMap.lowerLiftAxis) / 2.4;
    	a.set(throttle);
    	//double time = height / 0.4166666;
    	//a.set(0.41666666);
    	//Timer.delay(time);
    	//a.set(0);
    }
   /* public static void moveToFloor(WPI_TalonSRX a) {
    	if(RobotMap.isAtSwitch) {
    		LowerLift(a, RobotMap.switchHeight);
    	}
    	if(RobotMap.isAtScale) {
    		LowerLift(a, RobotMap.scaleHeight);
    	}
    	RobotMap.isAtFloor = true;
    	RobotMap.isAtScale = false;
    	RobotMap.isAtSwitch = false;
   	}    
    public static void moveToSwitch(WPI_TalonSRX a) {
    	if(RobotMap.isAtFloor) {
    		RaiseLift(a, RobotMap.switchHeight);
    	}
    	if(RobotMap.isAtScale) {
    		LowerLift(a, RobotMap.switchToScale);
    	}
    	RobotMap.isAtFloor = false;
    	RobotMap.isAtScale = false;
    	RobotMap.isAtSwitch = true;
    }
    public static void moveToScale(WPI_TalonSRX a) {
    	if(RobotMap.isAtFloor) {
    		RaiseLift(a, RobotMap.scaleHeight);
    	}
    	if(RobotMap.isAtSwitch) {
    		RaiseLift(a, RobotMap.switchToScale);
    	}
    	RobotMap.isAtFloor = false;
    	RobotMap.isAtScale = true;
    	RobotMap.isAtSwitch = false;
    } */
}

