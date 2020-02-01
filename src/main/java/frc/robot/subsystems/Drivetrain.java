/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//hi
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase {

  public static final double MM_TO_IN = 0.0393701;
  public static final double WHEEL_TO_WHEEL_DIAMETER_INCHES = 320 * MM_TO_IN;
  public static final double WHEEL_DIAMETER_INCHES = 4;

  public static final double PULSES_PER_ROTATION = 256;
  
  private VictorSP frontLeft, frontRight, backLeft, backRight;

  private SpeedControllerGroup left, right;

  private double speedMode = 0.25;
  private boolean isFast = false;


  public Drivetrain() {
    frontLeft = new VictorSP(FRONT_LEFT_DRIVE_MOTOR);
    backLeft = new VictorSP(BACK_LEFT_DRIVE_MOTOR);
    frontRight = new VictorSP(FRONT_RIGHT_DRIVE_MOTOR);
    backRight = new VictorSP(BACK_RIGHT_DRIVE_MOTOR);

    left = new SpeedControllerGroup(frontLeft, backLeft);
    right = new SpeedControllerGroup(frontRight, backRight);
  }

  public void modeSwitch(){
    if (!(isFast)) speedMode = 1;
    else speedMode = 0.25;
    
    isFast = !(isFast);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    setLeftSpeed(-leftSpeed);
    setRightSpeed(rightSpeed);
  }
  public void arcadeDrive(double x, double z){
    x *= Math.abs(x);
    z *= Math.abs(z);

    tankDrive(x+z, x-z);
  }

  private void setLeftSpeed(double speed) {
    left.set(-speed*speedMode);
  }

  private void setRightSpeed(double speed) {
    right.set(-speed*speedMode);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}