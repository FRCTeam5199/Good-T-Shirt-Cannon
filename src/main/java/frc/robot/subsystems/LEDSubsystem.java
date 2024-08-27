package frc.robot.subsystems;

import javax.swing.text.AbstractDocument.LeafElement;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDSubsystem extends SubsystemBase{

    static AddressableLED LEDs = new AddressableLED(Constants.LED_PORT);
    static AddressableLEDBuffer LEDBUFFER = new AddressableLEDBuffer(Constants.LED_LENGTH);

    public Command yellow() {

        return new InstantCommand(()-> {
            for(var i = 0; i < LEDBUFFER.getLength(); i++) {
                LEDBUFFER.setRGB(i, 255, 255, 25);
            }
            LEDs.setLength(LEDBUFFER.getLength());
            LEDs.setData(LEDBUFFER);
            LEDs.start();
            }
        );
  
    }

    public Command warningLights(){
        return new InstantCommand(()->{
            for(var i = 0; i < LEDBUFFER.getLength(); i++){
                LEDBUFFER.setRGB(i, 255, 0, 0);
            }
            LEDs.setLength(LEDBUFFER.getLength());
            LEDs.setData(LEDBUFFER);
            LEDs.start();

            for(var i = 0; i < LEDBUFFER.getLength(); i++){
                LEDBUFFER.setRGB(i, 0, 0, 0);

            }
            LEDs.setLength(LEDBUFFER.getLength());
            LEDs.setData(LEDBUFFER);
            LEDs.start();
        });
    }

}
