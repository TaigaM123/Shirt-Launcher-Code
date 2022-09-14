//straight up copied from 948 2020 robot code
//might be no good because wpilib changed

/**
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.utilities.Logger;

public class InterruptAll extends CommandBase {

  // Creates a new InterruptAll command.
  public InterruptAll(RobotSubsystems subsystems) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystems.getAll());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Logger.commandInit(this);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Returns true when the command should end, which is immediately.
  @Override
  public boolean isFinished() {
    return true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Logger.commandEnd(this, interrupted);
  }
}

*/