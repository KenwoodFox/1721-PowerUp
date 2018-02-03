package org.usfirst.frc.team1721.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {}
    
    public static void driveWithJoystick(Joystick j, RobotDrive r){
    	r.arcadeDrive(j);
    }
    /**
     * 
     * @param r 
     */
    public void stop(RobotDrive r){
    	r.drive(0,  0);
    }
}