package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TankDrive;

public class DefaultDrive extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TankDrive m_Drive = new TankDrive();
    private final double d_left;
    private final double d_right;
    
    public DefaultDrive(double left, double right) {
      d_left = left;
      d_right = right;
      addRequirements(m_Drive);
    }

    public void execute() {
      m_Drive.diffDrive(d_left,d_right);
    }
}