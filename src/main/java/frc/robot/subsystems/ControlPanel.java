/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class ControlPanel extends SubsystemBase {
  /**
   * Creates a new ControlPanel.
   */
  private VictorSP spinMotor;
  private DoubleSolenoid lifterPiston;

  public ControlPanel() {
    spinMotor = new VictorSP(SPIN_MOTOR);
    lifterPiston = new DoubleSolenoid(CONTROL_PISTON_1, CONTROL_PISTON_2);
  }

  // SPIN MOTOR

  public void spinnerOn() {
    spinMotor.set(1);
  }
  public void spinnerOff() {
    spinMotor.set(0);
  }

  // CONTROL PANEL PISTON BASE COMANDS
  public void lifterPistonUp(){
    lifterPiston.set(DoubleSolenoid.Value.kForward);
    //hasLifted = true;
  }

  public void lifterPistonOff(){
    lifterPiston.set(DoubleSolenoid.Value.kOff);
  }

  public void lifterPistonDown(){
    lifterPiston.set(DoubleSolenoid.Value.kReverse);
    //hasLifted = false;
  }

  // BOOLEANSUPPLIERS: For robotContainer control panel commands
  //public final BooleanSupplier controlPistonUpSupplier = () -> hasLifted;
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}