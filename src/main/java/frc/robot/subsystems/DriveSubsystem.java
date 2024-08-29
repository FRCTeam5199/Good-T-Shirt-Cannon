package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DriveSubsystem extends SubsystemBase{

    public static VictorSPX left1;
    public static VictorSPX left2;
    public static VictorSPX right1;
    public static VictorSPX right2;
    public static VictorSPX tilt;

    private XboxController joystick = new XboxController(Constants.XBOX_CONTROLLER_PORT);
    public Robot driveable = new Robot();

    public DriveSubsystem(){
        left1 = new VictorSPX(Constants.LEFT_1_DEVICE_ID);
        left2 = new VictorSPX(Constants.LEFT_2_DEVICE_ID);
        right1 = new VictorSPX(Constants.RIGHT_1_DEVICE_ID);
        right2 = new VictorSPX(Constants.RIGHT_2_DEVICE_ID);
        tilt = new VictorSPX(Constants.TILT_ID);

        left2.follow(left1);
        right2.follow(right1);

        right1.setInverted(Constants.IS_INVERTED);
        right1.setNeutralMode(NeutralMode.Brake);
        left1.setNeutralMode(NeutralMode.Brake);

    }

    //Speed at 50% of max

    public Command drive() {

        //Drive
        return this.runOnce(()-> {
        left1.set(ControlMode.PercentOutput, ((-joystick.getLeftY() + (joystick.getRightX() * Constants.TURN_FACTOR)) * Constants.VOLTAGE_MULT) * Constants.MAX_SPEED_PERCENT);
        right1.set(ControlMode.PercentOutput, ((joystick.getLeftY() + (joystick.getRightX() * Constants.TURN_FACTOR)) * Constants.VOLTAGE_MULT) * Constants.MAX_SPEED_PERCENT);
        });

        /*
        if(joystick.getButton(1)) {
            System.out.println("hello");
            tilt.set(ControlMode.Position, 30 * (4096.0 / 360.0));
        }
        if(joystick.getButton(2)) {
            tilt.set(ControlMode.Position, 45 * (4096.0 / 360.0));
        }
        if(joystick.getButton(3)) {
            tilt.set(ControlMode.Position, 60 * (4096.0 / 360.0));
        }
        */

        //Tilt
        //System.out.println("d-pad-up is " + joystick.getDPadUp());

    }


}
