// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class ShooterConstants {
      public static final double pushDelay = 0.5; //sec
      public static final double pullDelay = 0.5; //sec
      public static final double rotateDelay = 1; //sec
      public static final int rotateAngle = 135; //deg
      public static final int returnAngle = 45; //deg
      public static final double pullerSpeed = 0.9; //percent
      public static final double flywheelResting = 0.4; //percent
      public static final double pullerResting = 0; //percent
      public static final int pushAngle = 90; //degrees
      public static final int pullAngle = 180; //degrees
    }

    public static final class ArmConstants {
      public static final double armPower = 0.35; //percent
    }

    public static final class DriveConstants {
      public static final double slowModePower = 0.5; //percent
    }
}
