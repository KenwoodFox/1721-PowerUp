package org.usfirst.frc.team1721.robot.subsystems;

import org.usfirst.frc.team1721.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CustomDriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {}
    
    public static void driveWithJoystick(Joystick j/*, RobotDrive r*/){
    	
    	
    	
    	double valueX = j.getX();
    	double valueY = j.getY();
    	double valueZ = j.getZ();
    	
    	double valuePort = 0;
    	double valueStarboard = 0;
    	
    	if(valueZ > 0){
    		valuePort = valueY;
    		valueStarboard = valueY - valueZ;
    	}else if(valueZ < 0){
    		valueStarboard = valueY;
    		valuePort = valueY + valueZ;
    	}else{
    		valueStarboard = valueY;
    		valuePort = valueY;
    	}
    	
    	SmartDashboard.putNumber("Port: ", valuePort);
    	SmartDashboard.putNumber("Starboard: ", valueStarboard);
    	
    	RobotMap.vspLeft.set(valuePort);
    	RobotMap.vspRight.set(valueStarboard);
    }
    
    //@param r does something amazin			g
    
    public void stop(RobotDrive r){
    	r.drive(0,  0);
    }
}

