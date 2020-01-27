/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class ControlPanel extends SubsystemBase {
    /**
     * Creates a new ControlPanel.
     */
    private final VictorSP spinMotor;

    public ControlPanel() {
        spinMotor = new VictorSP(SPIN_MOTOR);
    }

    public void spinnerOn() {
        spinMotor.set(0.5);
    }
    
    public void spinnerOff() {
        spinMotor.set(0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
