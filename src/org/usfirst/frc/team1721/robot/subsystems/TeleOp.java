/*Class for declaring teleop commands. Placing commands here keeps them on a 
 * single thread. Please put commands (other than DriveTrain) here.
 */

package org.usfirst.frc.team1721.robot.subsystems;

import org.usfirst.frc.team1721.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class TeleOp extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static int deadbandSpin = (int) 0.08;
	public static int toleranceVal = (int) 0.18;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**Raises the lift based on trigger values - right trigger goes up.
     * @param a The lift TalonSRX
     * @param j The controller joystick, must have at least 3 axes.
     */
    public static void RaiseLift(WPI_TalonSRX a, Joystick j) {
    	double throttle = -1 * j.getRawAxis(RobotMap.raiseLiftAxis);
    	//if(RobotMap.isAtTop.get() != true) {
    	SmartDashboard.putNumber("down", throttle);
    	SmartDashboard.putNumber("RawDown", j.getRawAxis(RobotMap.raiseLiftAxis));
    		a.set(throttle);
    	//}
    }
    public static void LowerLift(WPI_TalonSRX a, Joystick j) {
    	double throttle = 1 * j.getRawAxis(RobotMap.lowerLiftAxis);
    	//if(RobotMap.isAtBottom.get() != true) {
    	SmartDashboard.putNumber("up", throttle);
    	a.set(throttle);
    	//}
    }
    public static void RaiseIntake() {
    	RobotMap.intakeLifter.set(0.8);
    	Timer.delay(3);
    	RobotMap.intakeLifter.set(0);
    }
    public static void DropIntake(Joystick c, WPI_VictorSPX m) {
    	double throttle = c.getRawAxis(RobotMap.intakeLifterAxis);
    	m.set(throttle);
    }
    public static void climb(WPI_VictorSPX climber) {
    	
    	climber.set(-1);

    }
    public static void stopClimb(WPI_VictorSPX climber) {
    	climber.set(0);
    }
    public static void spinnySpinny(WPI_VictorSPX a, Joystick j) {
    	double throttle = j.getRawAxis(3);
    	if(throttle >= 0.5 || throttle <= -0.5) {
    		a.set(throttle);
    	}else {
    		a.set(0);
    	}
    }
    /**Lowers the lift based on trigger values - left trigger goes down.
     * @param a The lift TalonSRX
     * @param j The controller joystick, must have at least 3 axes.
     */
    public static void spinOut(WPI_VictorSPX a, Joystick j) {
    	
    	//compensating for the Y axis error, this creates a negative Y axis value past 0
    	double spinValRaw = j.getRawAxis(RobotMap.spinAxis) - toleranceVal;
    	
    	////makes any negative value equal zero
    	//if(spinValRaw < 0) {
    	//	spinValRaw = 0;
    	//}
    	
    	//deadband implementation about the adjusted center
    	if( spinValRaw > 0 && spinValRaw < (0 + deadbandSpin / 2))
    	{
    		spinValRaw = 0;
    	}
    	if(spinValRaw < 0 && spinValRaw > (0 - deadbandSpin / 2))
    	{
    		spinValRaw = 0;
    	}
  
    	//setting the axis to the intake wheels
    	a.set(spinValRaw);
    	//a.set(j.getRawAxis(RobotMap.spinAxis));
    }
}

