/*Class for declaring teleop commands. Placing commands here keeps them on a 
 * single thread. Please put commands (other than DriveTrain) here.
 */

package org.usfirst.frc.team1721.robot.subsystems;

import org.usfirst.frc.team1721.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TeleOp extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /**Raises the lift based on trigger values - right trigger goes up.
     * @param a The lift TalonSRX
     * @param j The controller joystick, must have at least 3 axes.
     */
    public static void RaiseLift(WPI_TalonSRX a, Joystick j) {
    	double throttle = -1 * j.getRawAxis(RobotMap.raiseLiftAxis) / 1.5;
    	a.set(throttle);
    }
    /**Lowers the lift based on trigger values - left trigger goes down.
     * @param a The lift TalonSRX
     * @param j The controller joystick, must have at least 3 axes.
     */
    public static void LowerLift(WPI_TalonSRX a, Joystick j) {
    	double throttle = j.getRawAxis(RobotMap.lowerLiftAxis) / 3;
    	a.set(throttle);
    }
    /**Spins the intake outward or in depending on joystick Y axis input.
     * @param a The master intake VictorSPX
     * @param j The controller joystick, must have at least 5 axes.
     */
    public static void IntakeCube(WPI_VictorSPX a, Joystick j) {
    	double throttle = -1 * j.getRawAxis(RobotMap.intakeAxis);
    	a.set(throttle);
    }
}

