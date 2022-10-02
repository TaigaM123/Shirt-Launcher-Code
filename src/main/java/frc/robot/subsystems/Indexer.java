// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants.ShooterConstants;

public class Indexer extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Indexer() {}

  //private VictorSP m_pusherTest = new VictorSP(7);
  //private VictorSP m_rotatorTest = new VictorSP(8);
  private Servo m_pusher = new Servo(7);
  private Servo m_rotator = new Servo(8);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void pushShirt() {
    m_pusher.setAngle(ShooterConstants.pushAngle);
    //m_pusherTest.set(0.5);
  }

  public void pullShirt() {
    m_pusher.setAngle(ShooterConstants.pullAngle);
    //m_pusherTest.set(0);
  }

  public void rotate() {
    m_rotator.setAngle(ShooterConstants.rotateAngle);
    //m_rotatorTest.set(0.5);
  }

  public void returnRotator() {
    m_rotator.setAngle(ShooterConstants.returnAngle);
    //m_rotatorTest.set(-0.5);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
