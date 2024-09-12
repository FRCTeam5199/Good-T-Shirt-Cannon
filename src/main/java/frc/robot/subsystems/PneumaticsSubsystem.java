package frc.robot.subsystems;

import org.opencv.features2d.FlannBasedMatcher;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticsSubsystem extends SubsystemBase {
    public static Solenoid reserveSolenoid = new Solenoid(PneumaticsModuleType.REVPH, Constants.RESERVE_SOLENOID_ID);
    public static DigitalOutput cannonTrigger = new DigitalOutput(9);
    public static Compressor compressor = new Compressor(Constants.COMPRESSOR_ID, PneumaticsModuleType.REVPH);
    public static boolean compressing = true;

    public PneumaticsSubsystem() {
        unTriggerCannon();
        toggleCompressor();
    }


    public void toggleCompressor() {
        if (compressing) {
            compressing = false;
            compressor.disable();
        } else {
            compressing = true;
            compressor.enableDigital();
        }
    }

    /*opens the reserve from the main tank */
    public Command openReserve() {
        return new InstantCommand(() -> {
            reserveSolenoid.set(false);
        });
    }

    /*Closes the reserve from the main tank */
    public Command closeReserve() {
        return new InstantCommand(() -> reserveSolenoid.set(true));
    }


    /*Opens the Cannons connection to the reserve tank */
    public Command triggerCannon() {
        return new InstantCommand(() -> cannonTrigger.set(false));
    }

    /*Closes Cannons connection to reserve tank */
    public Command unTriggerCannon() {
        return new InstantCommand(() -> cannonTrigger.set(true));
    }

}
