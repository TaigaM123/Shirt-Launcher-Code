package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TankDrive;
import java.util.function.DoubleSupplier;
import frc.robot.Constants.DriveConstants;

public class DefaultDrive extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TankDrive m_drive;
    private final DoubleSupplier d_left;
    private final DoubleSupplier d_right;
    
    public DefaultDrive(TankDrive subsystem, DoubleSupplier left, DoubleSupplier right) {
      m_drive = subsystem;
      d_left = left;
      d_right = right;
      addRequirements(subsystem);
    }
    
    public void initialize() {
      m_drive.maxOutput(DriveConstants.slowModePower);
    }

    public void execute() {
      m_drive.diffDrive(d_left.getAsDouble(),d_right.getAsDouble());
    }
}