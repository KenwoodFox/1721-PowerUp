package org.usfirst.frc.team1721.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DriverStation;

/**
 *  SideDetector.java
 *  Written by Brennan Macaig
 *  Detects what side of the field the scale/switch are correctly and safely.
 */


public class SideDetector extends Subsystem {
    /** Side enum
     *  Valid sides are LEFT, RIGHT and NULL. NULL is for pre-match when the
     *  side is not yet set.
     */
    public enum Side {
      LEFT, RIGHT, NULL;
    }

    public void initDefaultCommand() {}


    public static Side getSwitch() {
        Side thisMatch = Side.NULL;
        DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
        while (thisMatch == Side.NULL) {
            String data = DriverStation.getInstance().getGameSpecificMessage();
            if (color == DriverStation.Alliance.Red) {
                if (data.length > 0) {
                    if (data.charAt(0) == 'L') {
                        return LEFT;
                    } else {
                        return RIGHT;
                    }
                } else {
                  continue;
                }
            } else if (color == DriverStation.Alliance.Blue) {
              if (data.length > 0) {
                  if (data.charAt(0) == 'L') {
                      return RIGHT;
                  } else {
                      return LEFT;
                  }
              }
            }
        }
    }
}
