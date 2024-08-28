package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.PneumaticsSubsystem;

public class FiringCommands extends Command {
    static PneumaticsSubsystem pneumatics = new PneumaticsSubsystem();
    
    /*Initiates sequence to ready Cannon to fire */
    public static Command loadCannon(){
        return new SequentialCommandGroup(
            pneumatics.openReserve(),
            new WaitCommand(2.5),
            pneumatics.closeReserve()
        );
    }

    /*Fires the cannon and closes the cannon following */
    public static Command fireCannon(){
        return new SequentialCommandGroup(
            pneumatics.triggerCannon(),
            new WaitCommand(.5),
            pneumatics.unTriggerCannon()
        );
    }
}
