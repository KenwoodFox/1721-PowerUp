package org.usfirst.frc.team1721.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
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
    	double throttle = -1 * j.getRawAxis(3) / 1.5;
    	a.set(throttle);
    }
    public static void LowerLift(WPI_TalonSRX a, Joystick j) {
    	double throttle = j.getRawAxis(2) / 3;
    	a.set(throttle);
    }
}

