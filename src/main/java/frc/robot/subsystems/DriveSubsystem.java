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


    // create an XboxController object (with port) and get joysticks from it using methods like getLeftY
    //trying passing these into each motor to get it to work
    //use parallel command group with 4 instant commands, one for each motor
    //left1 and left2 should always be set to the same thing as well as right1 and right2
    //you'll have to add getleftY and getRightx in each side
}
