package org.usfirst.frc.team1721.robot.subsystems;

import org.usfirst.frc.team1721.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {}
    
    public static void driveWithJoystick(Joystick j, RobotDrive r){
    	
    	
    	
    	double valueX = RobotMap.stick.getX();
    	double valueY = RobotMap.stick.getY();
    	double valueZ = RobotMap.stick.getZ();
    	
    	double valuePort;
    	double valueStarboard;
    	
    	RobotMap.vspLeft.set(valuePort);
    	RobotMap.vspRight.set(valueStarboard);
    	
    	SmartDashboard.putNumber("Port: ", valuePort);
    	SmartDashboard.putNumber("Starboard: ", valueStarboard);
    	
    	
    	//RobotThingies
    	
    	
    	
    	
    	
    }
    
    //@param r does something amazin			g
    
    public void stop(RobotDrive r){
    	r.drive(0,  0);
    }
}

