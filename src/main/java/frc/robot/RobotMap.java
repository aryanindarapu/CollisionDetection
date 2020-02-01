package frc.robot;
import edu.wpi.first.wpilibj.I2C;

public class RobotMap {
    public static class Controllers {
        public static final int DRIVER_PORT = 0;
        public static final int OPERATOR_PORT = 1;

        public static final int A = 1;
        public static final int B = 2;
        public static final int X = 3;
        public static final int Y = 4;
        public static final int RB = 6;
        public static final int LB = 5;
        public static final int RSTK = 10;
        public static final int LSTK = 9;
        public static final int START = 8;
        public static final int MENU = 7;

        public static final int LX = 0;
        public static final int LY = 1; // Arcade drive
        public static final int RX = 4; // Arcade drive

        public static final int RY = 5;
        public static final int LT = 2;
        public static final int RT = 3;

        public static final int POV = 0; // untested
    }

    public static class Drivetrain {
        public static final int LEFT_PRIMARY = 1;
        public static final int RIGHT_PRIMARY = 2;
        public static final int LEFT_SECONDARY = 3;
        public static final int RIGHT_SECONDARY = 4;

        public static final boolean LEFT_IS_INVERTED = false;
        public static final boolean RIGHT_IS_INVERTED = false;
    }

    public static class CollisionDetection {
        public static final I2C.Port NAVX = I2C.Port.kMXP;
    }
}