/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.CollisionDetection;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private XboxController controller = new XboxController(RobotMap.Controllers.DRIVER_PORT);

  public Spark l_primary, l_secondary, r_primary, r_secondary;
  public static CollisionDetection collisionDetection = CollisionDetection.getInstance();
  public static Drivetrain drivetrain = Drivetrain.getInstance();
  private Timer timer = new Timer();
  

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    l_primary = new Spark(RobotMap.Drivetrain.LEFT_PRIMARY);
    r_primary = new Spark(RobotMap.Drivetrain.RIGHT_PRIMARY);
    l_secondary = new Spark(RobotMap.Drivetrain.LEFT_SECONDARY);
    r_secondary = new Spark(RobotMap.Drivetrain.RIGHT_SECONDARY);

    l_primary.setInverted(true);
    l_secondary.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    l_primary.set(controller.getRawAxis(RobotMap.Controllers.LY));
    l_secondary.set(controller.getRawAxis(RobotMap.Controllers.LY));
    r_primary.set(controller.getRawAxis(RobotMap.Controllers.RY));
    r_secondary.set(controller.getRawAxis(RobotMap.Controllers.RY));
    collisionDetection.detectCollision();

    if (collisionDetection.detectCollision()) {
      l_primary.set(0.0);
      r_primary.set(0.0);
      l_secondary.set(0.0);
      r_secondary.set(0.0);
      System.out.println("collision detected");
      timer.delay(0.5);   
    }
  }
  
  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }
}
