package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TankDrive extends SubsystemBase {

//copy pasted from 2020 948 robot code

  private MotorController leftMotors = new VictorSP(0);
  private MotorController rightMotors = new VictorSP(1);

  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotors, rightMotors);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
