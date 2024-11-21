package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class AimingSubsystem extends SubsystemBase {
    VictorSPX  motor1;
    public AimingSubsystem() {
        motor1 = new VictorSPX(Constants.TILT_ID);
        motor1.setNeutralMode(NeutralMode.Brake);
    }
    public Command toggleButton(double speed) {
        return new InstantCommand(() -> motor1.set(ControlMode.PercentOutput, speed));
    }
}
