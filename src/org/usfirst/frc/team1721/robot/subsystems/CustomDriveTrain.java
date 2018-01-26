package org.usfirst.frc.team1721.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CustomDriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {}
    
    public static void driveWithJoystick(Joystick j, RobotDrive r){
    	
    	double valueY = j.getY();
    	double valueZ = j.getZ();
    	
    	double valuePort = 0;
    	double valueStarboard = 0;
    	
    	double speed = 1 - (1/valueY);
    	double turnInput = 1 - (1/valueZ);
    	
    	SmartDashboard.putNumber("Port: ", valuePort);
    	SmartDashboard.putNumber("Starboard: ", valueStarboard);
    	
    	r.arcadeDrive(speed, turnInput);
    }
    
    //@param r does something amazin			g
    
    public void stop(RobotDrive r){
    	r.drive(0,  0);
    }
}

