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

    public static void IntakeCube(WPI_VictorSPX a, Joystick j) {
    	double throttle = -1 * j.getRawAxis(5);
    	a.set(throttle);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}