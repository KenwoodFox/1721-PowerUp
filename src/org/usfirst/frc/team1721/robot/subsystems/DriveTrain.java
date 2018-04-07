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
<<<<<<< HEAD
    
    public static void driveWithJoystick(Joystick j, DifferentialDrive r){
    	double axis = j.getY();
    	double turn = j.getZ();
    	r.arcadeDrive(axis, turn);
    }
    /**
     * 
     * @param r 
=======
    /**Drives the robot using a joystick.
     * @param j The drive joystick.
     * @param r The DriveTrain object.
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
     */
<<<<<<< HEAD
=======
    public static void driveWithJoystick(Joystick j, DifferentialDrive r){
    	double axis = j.getY() * 0.85;
    	double turn = j.getZ() * 0.75;
    	r.arcadeDrive(axis, turn);
    }
    /** Stops the bot.
     * @param r The DriveTrain object.
     */
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
    public void stop(DifferentialDrive r){
    	r.arcadeDrive(0,  0);
    }
}