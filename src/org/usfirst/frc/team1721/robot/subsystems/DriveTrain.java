package org.usfirst.frc.team1721.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
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
     * @param rd The DriveTrain object.
     */
    public static void driveWithJoystick(Joystick j, DifferentialDrive rd){
    	double axis = j.getY() * 0.88;
    	double turn = j.getZ() * 0.95;
    	rd.arcadeDrive(axis, turn);
    }
    /** Stops the bot.
     * @param r The DriveTrain object.
     */
    public void stop(DifferentialDrive r){
    	r.arcadeDrive(0,  0);
    }
}