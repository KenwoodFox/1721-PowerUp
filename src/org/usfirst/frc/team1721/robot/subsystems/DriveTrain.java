package org.usfirst.frc.team1721.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {}
    
    public static void driveWithJoystick(Joystick j, DifferentialDrive r){
    	double axis = j.getY();
    	double turn = j.getZ();
    	r.arcadeDrive(axis, turn);
    }
    /**
     * 
     * @param r 
     */
    public void stop(DifferentialDrive r){
    	r.arcadeDrive(0,  0);
    }
}