package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class Arm extends SubsystemBase {

  private MotorController armMotor = new VictorSP(2);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void armUp() {
    armMotor.set(0.35);
  }

  public void armDown() {
    armMotor.set(-0.35);
  }

  public void armStop() {
    armMotor.set(0);
  }
  
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}