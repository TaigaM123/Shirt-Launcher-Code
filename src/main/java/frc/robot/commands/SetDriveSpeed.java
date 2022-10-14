// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.DriveConstants;

public class SetDriveSpeed extends CommandBase {
  private final TankDrive m_drive;
  private static double v_fullSpeed = DriveConstants.slowModePower;

  public SetDriveSpeed(TankDrive drive) {
    m_drive = drive;
  }

  @Override
  public void execute() {
    v_fullSpeed = v_fullSpeed + DriveConstants.fullSpeedRateLimit;
    m_drive.maxOutput(v_fullSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.maxOutput(DriveConstants.slowModePower);
    v_fullSpeed = DriveConstants.slowModePower;
  }
}
