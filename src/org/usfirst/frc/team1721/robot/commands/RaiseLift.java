package org.usfirst.frc.team1721.robot.commands;

import org.usfirst.frc.team1721.robot.RobotMap;
import org.usfirst.frc.team1721.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseLift extends Command {

    public RaiseLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Lift.RaiseLift(RobotMap.liftTalon, RobotMap.controller);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
