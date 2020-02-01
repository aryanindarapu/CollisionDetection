package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;


/** 
 * This class is run automatically, and dictates what functions are run during each of these stages.
 * @author dri
 */
public class Drivetrain {
    public Spark l_primary, l_secondary, r_primary, r_secondary; 
    private static Drivetrain instance;

    private Drivetrain() {
        try {
            
        } catch (Exception e) {
            System.out.println("TESTING TESTING TESTING");
        }
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
        
            l_primary.set(speed);
            l_secondary.set(speed);
        
    }

    /**
     * Sets the right side speed of the drivetrain.
     * @param speed the speed to set to from -1 to 1
     */
    public void setRightSpeed(double speed){
       
            r_primary.set(speed);
            r_secondary.set(speed);
        
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

    /**
     * Maps joysticks to the drivetrain for Arcade layout
     * @param speed scaling factor for robot speed
     */
    public void arcadeDrive(double speed){
        double y = OI.driver.getLY();
        double x = OI.driver.getRX();
        y = -1 * y * speed;
        x = 1 * x * speed;
        System.out.println(y + " " + x);
        System.out.println((x+y) + " " + (x-y));
        setSpeed((x+y), (x-y));
    }
}
