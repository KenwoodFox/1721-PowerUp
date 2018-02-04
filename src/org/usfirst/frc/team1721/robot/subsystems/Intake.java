package org.usfirst.frc.team1721.robot.subsystems;

import org.usfirst.frc.team1721.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    public static void IntakeCube(WPI_VictorSPX a, WPI_VictorSPX b, Joystick j) {
    	boolean isPressed = j.getRawButton(RobotMap.intakeButton);
    	if (isPressed) {
    		a.set(2);
    		b.set(-2);
    		Timer.delay(0.5);
    		a.set(0);
    		b.set(0);
    	}
    }
    public static void ExpelCube(WPI_VictorSPX a, WPI_VictorSPX b, Joystick j) {
    	boolean isPressed = j.getRawButton(RobotMap.outputButton);
    	if (isPressed) {
	    	a.set(-2);
	    	b.set(2);
	    	Timer.delay(0.5);
	    	a.set(0);
	    	b.set(0);
    	}
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

