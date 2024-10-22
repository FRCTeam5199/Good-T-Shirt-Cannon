package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AimingSubsystem extends SubsystemBase {

    public static VictorSPX TILT_MOTOR;

    public AimingSubsystem() {
        TILT_MOTOR = new VictorSPX(Constants.TILT_ID);
        TILT_MOTOR.setNeutralMode(NeutralMode.Brake);
    }

    public Command tilt(double speed) {
        return new InstantCommand(() -> TILT_MOTOR.set(ControlMode.PercentOutput, speed));
    }
}
