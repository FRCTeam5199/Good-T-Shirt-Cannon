package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class DriveSubsystem extends SubsystemBase{
    VictorSPX  motorFrontL;
    VictorSPX  motorFrontR;
    VictorSPX  motorBackL;
    VictorSPX  motorBackR;
    XboxController xbox = new XboxController(Constants.XBOX_CONTROLLER_PORT);

    public DriveSubsystem() {
        motorFrontL = new VictorSPX(Constants.LEFT_1_DEVICE_ID);
        motorFrontR = new VictorSPX(Constants.RIGHT_1_DEVICE_ID);
        motorBackL = new VictorSPX(Constants.LEFT_2_DEVICE_ID); 
        motorBackR = new VictorSPX(Constants.RIGHT_2_DEVICE_ID);

        motorBackL.follow(motorFrontL);
        motorBackR.follow(motorFrontR);

        motorFrontR.setNeutralMode(NeutralMode.Brake);
        motorFrontL.setNeutralMode(NeutralMode.Brake);
    }

    public Command control() {
        return new InstantCommand(() -> {
            motorFrontL.set(ControlMode.PercentOutput, (xbox.getLeftY() + xbox.getRightX()));
            motorFrontR.set(ControlMode.PercentOutput, (xbox.getLeftY() + xbox.getRightX()));
        });
        
    }
    // create an XboxController object (with port) and get joysticks from it using methods like getLeftY
    //trying passing these into each motor to get it to work
    //use parallel command group with 4 instant commands, one for each motor
    //left1 and left2 should always be set to the same thing as well as right1 and right2
    //you'll have to add getleftY and getRightx in each side
}
