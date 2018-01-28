package org.usfirst.frc.team1721.robot.subsystems;

import org.usfirst.frc.team1721.robot.RobotMap;

import com.ctre.CANTalon;

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
    public static void DriveToDistance(Encoder port, Encoder starboard, RobotDrive r){
    	/* P = Error
    	 * I = Integral (does not go to zero as you reach target) (Only equals 0 at target, accumulates as long as there is an error)
    	 * D = Derivative (Slows the acceleration) (rate of change) (Added in as a negative value)
    	 */
    	
    	//Need a variable Dist
    	
    	//Convert to inches
    	port = /*math*/ portDist;
    	starboard = /*math*/ starboardDist; //dist vars are measured in inches, if the encoder is already outputing a distance, converte distance to inches rather than speed to dist
    	
    	
    	
    }
    public static void DriveAndStop(Encoder port, Encoder starboard, RobotDrive r){
    	
    }
    public static void Turn(Encoder port, Encoder starboard, RobotDrive r, int angle){
    	 
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
    public static void InitiatePID(CANTalon port, CANTalon starboard){
    	port.setPID(RobotMap.pValue, RobotMap.iValue, RobotMap.dValue);
    	starboard.setPID(RobotMap.pValue, RobotMap.iValue, RobotMap.dValue);
    }
}

