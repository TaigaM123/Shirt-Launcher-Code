// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.ShooterConstants;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Shoot extends SequentialCommandGroup {

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Shoot(Shooter shooter, Indexer indexer) {
    addCommands(
      new InstantCommand(shooter::gripShirt,shooter),
      //new InstantCommand(indexer::pushShirt,indexer),
      new WaitCommand(ShooterConstants.pushDelay),
      new InstantCommand(shooter::keepOn,shooter),
      new Index(indexer));
  }
}
