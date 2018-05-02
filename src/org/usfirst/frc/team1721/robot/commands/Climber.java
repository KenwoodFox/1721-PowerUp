package org.usfirst.frc.team1721.robot.commands;

import org.usfirst.frc.team1721.robot.RobotMap;
<<<<<<< HEAD
import org.usfirst.frc.team1721.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCube extends Command {

    public IntakeCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Intake.IntakeCube(RobotMap.intakeVictorLeft, RobotMap.intakeVictorRight, RobotMap.controller);
=======
import org.usfirst.frc.team1721.robot.subsystems.TeleOp;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climber extends Command {

    public Climber() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	TeleOp.climb(RobotMap.climberVictorLeft);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
<<<<<<< HEAD:src/org/usfirst/frc/team1721/robot/commands/Climber.java
=======
    	TeleOp.IntakeCube(RobotMap.intakeVictorLeft, RobotMap.controller);
>>>>>>> branch 'master' of https://github.com/KenwoodFox/2018-PowerUp
>>>>>>> 25a46901b680da9df7b41ca48d38c709a0c4fd96:src/org/usfirst/frc/team1721/robot/commands/IntakeCube.java
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//RobotMap.climberVictorLeft.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
