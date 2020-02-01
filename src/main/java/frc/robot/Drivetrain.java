package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;


/** 
 * This class is run automatically, and dictates what functions are run during each of these stages.
 * @author dri
 */
public class Drivetrain {
    private Spark l_primary, l_secondary, r_primary, r_secondary; 
    private static Drivetrain instance;
    private SpeedControllerGroup leftSpeedControl;
    private SpeedControllerGroup rightSpeedControl; 

    private Drivetrain() {
        l_primary = new Spark(RobotMap.Drivetrain.LEFT_PRIMARY);
        r_primary = new Spark(RobotMap.Drivetrain.RIGHT_PRIMARY);
        l_secondary = new Spark(RobotMap.Drivetrain.LEFT_SECONDARY);
        r_secondary = new Spark(RobotMap.Drivetrain.RIGHT_SECONDARY);

        leftSpeedControl = new SpeedControllerGroup(l_primary,l_secondary);
        rightSpeedControl = new SpeedControllerGroup(r_primary, r_secondary);

        leftSpeedControl.setInverted(RobotMap.Drivetrain.LEFT_IS_INVERTED);
        rightSpeedControl.setInverted(RobotMap.Drivetrain.RIGHT_IS_INVERTED);
    }

    /**
     * creates a new instance of the drivetrain class if one has not been made
     * @return an instance of the drivetrain class
     */
    public static Drivetrain getInstance() {
        if (instance == null) {
            return new Drivetrain();
        }
        return instance;
    }

    /**
     * Sets the left speed of the drivetrain
     * @param speed tbe speed to set from -1 to 1
     */
    public void setLeftSpeed(double speed){
        leftSpeedControl.set(speed);
    }

    /**
     * Sets the right side speed of the drivetrain.
     * @param speed the speed to set to from -1 to 1
     */
    public void setRightSpeed(double speed){
        rightSpeedControl.set(speed);
    }

    /**
     * Maps joysticks to the drivetrain for Arcade layout
     * @param speed scaling factor for robot speed
     */
    public void arcadeDrive(double speed){
        double y = OI.driver.getLY();
        double x = OI.driver.getRX();
        y = -1 * y * speed;
        x = 1 * x * speed;
        setSpeed(x+y, x-y);
    }

    /**
     * Sets the speed of both the control groups
     * @param leftSpeed speed of the left side of the drivetrain from -1 to 1
     * @param rightSpeed speed of the right side of the drivetrain from -1 to 1
     */
    public void setSpeed(double leftSpeed, double rightSpeed) {
        setRightSpeed(rightSpeed);
        setLeftSpeed(leftSpeed);
    }
}
