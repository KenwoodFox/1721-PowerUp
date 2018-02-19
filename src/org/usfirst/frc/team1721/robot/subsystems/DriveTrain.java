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
    /**Drives the robot using a joystick.
     * @param j The drive joystick.
     * @param r The DriveTrain object.
     */
    public static void driveWithJoystick(Joystick j, DifferentialDrive r){
    	double axis = j.getY() * 0.85;
    	double turn = j.getZ() * 0.75;
    	r.arcadeDrive(axis, turn);
    }
    /** Stops the bot.
     * @param r The DriveTrain object.
     */
    public void stop(DifferentialDrive r){
    	r.arcadeDrive(0,  0);
    }
}