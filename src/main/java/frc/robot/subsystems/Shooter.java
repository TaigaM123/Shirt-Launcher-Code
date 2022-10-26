package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants.ShooterConstants;

public class Shooter extends SubsystemBase {

  private MotorController lFlywheel = new VictorSP(3);
  private MotorController rFlywheel = new VictorSP(4);
  private MotorController lPuller = new VictorSP(5);
  private MotorController rPuller = new VictorSP(6);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void spinUp(double powerlevel) {
    rFlywheel.setInverted(true);
    lFlywheel.set(powerlevel);
    rFlywheel.set(powerlevel);
  }

  public void gripShirt() {
    rPuller.setInverted(true);
    lPuller.set(ShooterConstants.pullerSpeed);
    rPuller.set(ShooterConstants.pullerSpeed);
  }

  public void spinDown() {
    lFlywheel.set(0);
    rFlywheel.set(0);
    lPuller.set(0);
    rPuller.set(0);
  }

  public void keepOn() {
    rFlywheel.setInverted(true);
    rPuller.setInverted(true);
    lFlywheel.set(ShooterConstants.flywheelResting);
    rFlywheel.set(ShooterConstants.flywheelResting);
    lPuller.set(ShooterConstants.pullerResting);
    rPuller.set(ShooterConstants.pullerResting);
  }
  
  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}