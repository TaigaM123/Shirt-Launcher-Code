// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // big chunk of button definitions I guess
  private final Joystick leftJoystick = new Joystick(0);
  private final Joystick rightJoystick = new Joystick(1);

  private JoystickButton leftJoyButton1 = new JoystickButton(leftJoystick, 1);
  private JoystickButton leftJoyButton2 = new JoystickButton(leftJoystick, 2);
  private JoystickButton leftJoyButton3 = new JoystickButton(leftJoystick, 3);
  private JoystickButton leftJoyButton4 = new JoystickButton(leftJoystick, 4);
  private JoystickButton leftJoyButton5 = new JoystickButton(leftJoystick, 5);

  private JoystickButton rightJoyButton1 = new JoystickButton(rightJoystick, 1);
  private JoystickButton rightJoyButton2 = new JoystickButton(rightJoystick, 2);
  private JoystickButton rightJoyButton3 = new JoystickButton(rightJoystick, 3);
  private JoystickButton rightJoyButton4 = new JoystickButton(rightJoystick, 4);
  private JoystickButton rightJoyButton5 = new JoystickButton(rightJoystick, 5);
  //********************************

  private final Arm m_Arm = new Arm();
  private final TankDrive m_Drive = new TankDrive();
  private final Shooter m_Shooter = new Shooter();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    m_Drive.setDefaultCommand(new DefaultDrive(leftJoystick.getY(), rightJoystick.getY()));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    rightJoyButton5.whileHeld(new MoveArm(true));
    rightJoyButton4.whileHeld(new MoveArm(false));

    leftJoyButton1.whenPressed(new SpinUpShooter(0.9)); //possibly switch it to a variable based on the throttle position?
    leftJoyButton1.whenReleased(new Shoot());
    rightJoyButton1.whenPressed(new Index());

    leftJoyButton2.whenPressed(new StopShooter());
    rightJoyButton2.whenPressed(new StopShooter());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  public Command getAutonomousCommand() {
    //return m_chooser.getSelected();
  }*/
}
