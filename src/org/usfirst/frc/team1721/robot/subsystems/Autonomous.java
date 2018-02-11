/* Class for declaring autonomous commands. Used to keep all commands on
 * a single thread.
 */

package org.usfirst.frc.team1721.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous extends Subsystem {


    public void initDefaultCommand() {
    	
    }
    /** Shows switch and scale positions on SmartDashboard. Open YML.yml.xml to
     * view.
     */
    public static void showSwitchPositions() {
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	DriverStation.Alliance allianceColor = DriverStation.getInstance().getAlliance();
    	if(allianceColor == DriverStation.Alliance.Red) {
	    	if(gameData.length() > 0) {
				if(gameData.charAt(0) == 'L') {
					boolean isLeft = true;
					SmartDashboard.putBoolean(" Left home switch " , isLeft);
					SmartDashboard.putBoolean(" Right home switch " , isLeft);
				}
				if(gameData.charAt(0) == 'R') {
					boolean isLeft = false;
					SmartDashboard.putBoolean(" Left home switch " , isLeft);
					SmartDashboard.putBoolean(" Right home switch " , isLeft);
				}
				if(gameData.charAt(1) == 'L') {
					boolean isLeft = true;
					SmartDashboard.putBoolean(" Left scale " , isLeft);
					SmartDashboard.putBoolean(" Right scale " , isLeft);
				}
				if(gameData.charAt(1) == 'R') {
					boolean isLeft = false;
					SmartDashboard.putBoolean(" Left scale " , isLeft);
					SmartDashboard.putBoolean(" Right scale " , isLeft);
				}
				if(gameData.charAt(2) == 'L') {
					boolean isLeft = true;
					SmartDashboard.putBoolean(" Left opponent switch " , isLeft);
					SmartDashboard.putBoolean(" Right opponent switch " , isLeft);
				}
				if(gameData.charAt(2) == 'R') {
					boolean isLeft = false;
					SmartDashboard.putBoolean(" Left opponent switch " , isLeft);
					SmartDashboard.putBoolean(" Right opponent switch " , isLeft);
				}
			}
    	}else {
    		if(gameData.length() > 0) {
    			if(gameData.charAt(0) == 'L') {
    				boolean isLeft = false;
    				SmartDashboard.putBoolean(" Left home switch " , isLeft);
    				SmartDashboard.putBoolean(" Right home switch " , isLeft);
    			}
    			if(gameData.charAt(0) == 'R') {
    				boolean isLeft = true;
    				SmartDashboard.putBoolean(" Left home switch " , isLeft);
    				SmartDashboard.putBoolean(" Right home switch " , isLeft);
    			}
    			if(gameData.charAt(1) == 'L') {
    				boolean isLeft = false;
    				SmartDashboard.putBoolean(" Left scale " , isLeft);
    				SmartDashboard.putBoolean(" Right scale " , isLeft);
    			}
    			if(gameData.charAt(1) == 'R') {
    				boolean isLeft = true;
    				SmartDashboard.putBoolean(" Left scale " , isLeft);
    				SmartDashboard.putBoolean(" Right scale " , isLeft);
    			}
    			if(gameData.charAt(2) == 'L') {
    				boolean isLeft = false;
    				SmartDashboard.putBoolean(" Left opponent switch " , isLeft);
    				SmartDashboard.putBoolean(" Right opponent switch " , isLeft);
    			}
    			if(gameData.charAt(2) == 'R') {
    				boolean isLeft = true;
    				SmartDashboard.putBoolean(" Left opponent switch " , isLeft);
    				SmartDashboard.putBoolean(" Right opponent switch " , isLeft);
    			}
    		}
    	}
    }
}

