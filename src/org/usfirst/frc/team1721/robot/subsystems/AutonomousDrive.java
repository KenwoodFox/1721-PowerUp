package org.usfirst.frc.team1721.robot.subsystems;

import org.usfirst.frc.team1721.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutonomousDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public static void DriveInAuto(Encoder port, Encoder starboard, RobotDrive r){
    	
    }
    public static void InitiateEncoders(Encoder port, Encoder starboard){
    	port.setMaxPeriod(1);
		port.setMinRate(5);
		port.setDistancePerPulse(5);
		port.setReverseDirection(false);
		port.setSamplesToAverage(12);
		port.reset();
		
		starboard.setMaxPeriod(1);
		starboard.setMinRate(5);
		starboard.setDistancePerPulse(5);
		starboard.setReverseDirection(false);
		starboard.setSamplesToAverage(12);
		starboard.reset();
    }
}

