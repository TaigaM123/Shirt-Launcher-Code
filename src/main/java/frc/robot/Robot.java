package frc.robot;
 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
 
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Servo;

public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private final MotorController m_leftMotor = new VictorSP(0);
  private final MotorController m_rightMotor = new VictorSP(1);
  //We'll use Y-splitters, so it's one PWM port for the 2 motors on each side
 
  private final MotorController m_leftFlywheel = new VictorSP(3);
  private final MotorController m_rightFlywheel = new VictorSP(4);
  private final MotorController m_leftPuller = new VictorSP(5);
  private final MotorController m_rightPuller = new VictorSP(6);
 
  private final MotorController m_armMotor = new VictorSP(2);
 
  private Timer timer;
  private final Servo spinServo = new Servo(7);
  private final Servo pushServo = new Servo(8);
 
 
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightMotor.setInverted(true);
 
    m_myRobot = new DifferentialDrive(m_leftMotor, m_rightMotor);
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  }
 
 
  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
    //start a spinup of the motors
    if (m_leftStick.getRawButtonPressed(3)) {
      m_rightFlywheel.set(-0.5);
      m_leftFlywheel.set(0.5);
      m_leftPuller.set(0.5);
      m_rightPuller.set(-0.5);
      pushServo.setAngle(0);
    }
 
    //for safety, either button 2 works to stop the flywheels
    if (m_leftStick.getRawButton(2) || m_rightStick.getRawButton(2)) {
      m_rightFlywheel.set(0);
      m_leftFlywheel.set(0);
      m_leftPuller.set(0);
      m_rightPuller.set(0);
    }
 
    if(m_rightStick.getRawButtonPressed(3)){
      pushServo.setAngle(0);
      //INSERT spin ratchet
      spinServo.setAngle(0);
    }
   
    //shooting time! Would getrawbuttonpressed or getrawbutton be better?
    //getrawbutton allows for automatic fire, and if there's a delay between the 2
    //triggers I think that'll be an issue with getrawbuttonpressed
    if (m_leftStick.getRawButton(1) && m_rightStick.getRawButton(1)) {
      m_leftMotor.set(0);
      m_rightMotor.set(0);
      m_armMotor.set(0);
 
      m_leftPuller.set(1);
      m_rightPuller.set(-1);
      m_rightFlywheel.set(-1);
      m_leftFlywheel.set(1);
 
      pushServo.setAngle(90);
      timer.delay(0.5);//see how small you can get this
      pushServo.setAngle(0);
      //INSERT spin ratchet
      spinServo.setAngle(0);
 
      m_leftPuller.set(0.5);
      m_rightPuller.set(-0.5);
      m_rightFlywheel.set(-0.5);
      m_leftFlywheel.set(0.5);
    }
 
    //adjust following values during testing
    if (m_rightStick.getRawButton(4)) {
      m_armMotor.set(-0.25);
    } else if (m_rightStick.getRawButton(5)) {
      m_armMotor.set(0.25);
    } else {
      m_armMotor.set(0);
    }
  }
}
 
/**
NOTES:

So I set it up so that both the stage 2 flywheels and the stage 1 “pullers” will be
constantly spinning. I don’t know if this is better or worse than spinning up the
pullers from 0, I need to talk with other people or test it to see.
 
Would a motorcontrollergroup be better in this situation since all 4 are spinning at
the same time although tbf half of them are inverted
**/
