// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.DriveConstants;

public class SetDriveSpeed extends CommandBase {
  private final TankDrive m_drive = new TankDrive();

  public SetDriveSpeed() {

  }

  @Override
  public void initialize() {
    m_drive.maxOutput(DriveConstants.slowModePower);
  }

  @Override
  public void end(boolean interrupted) {
    m_drive.maxOutput(1);
  }
}