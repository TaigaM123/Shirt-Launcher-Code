// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.Constants.ShooterConstants;

public class Indexer extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Indexer() {}

  private Servo m_pusher = new Servo(7);
  private Servo m_rotator = new Servo(8);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void pushShirt() {
    m_pusher.setAngle(ShooterConstants.pushAngle);
  }

  public void pullShirt() {
    m_pusher.setAngle(ShooterConstants.pullAngle);
  }

  public void rotate() {
    m_rotator.setAngle(ShooterConstants.rotateAngle);
  }

  public void returnRotator() {
    m_rotator.setAngle(ShooterConstants.returnAngle);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
