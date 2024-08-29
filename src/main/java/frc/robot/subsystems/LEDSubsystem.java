package frc.robot.subsystems;

import javax.swing.text.AbstractDocument.LeafElement;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static java.awt.Color.black;

public class LEDSubsystem extends SubsystemBase{
    boolean finished;

    static AddressableLED LEDs = new AddressableLED(Constants.LED_PORT);
    static AddressableLEDBuffer LEDBUFFER = new AddressableLEDBuffer(Constants.LED_LENGTH);

   /* public void yellow() {

            for(var i = 0; i < LEDBUFFER.getLength(); i++) {
                LEDBUFFER.setRGB(i, 255, 255, 25);
            }
            LEDs.setLength(LEDBUFFER.getLength());
            LEDs.setData(LEDBUFFER);
            LEDs.start();

    }
    */

    public void warningLights(){
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
    }

    public Command yellow() {
        return new InstantCommand(()-> {
            AddressableLEDBuffer capoLED = new AddressableLEDBuffer(60);
            for (var i = 0; i < capoLED.getLength(); i++) {
                // Calculate the hue - hue is easier for rainbows because the color
                // shape is a circle so only one value needs to precess
                final var v = 0;
                // Set the value
                capoLED.setRGB(i, 255, 150, 0);
            }
            LEDs.setLength(60);
            LEDs.setData(capoLED);
            LEDs.start();
        });
    }

    public Command loading() {
        return new InstantCommand(()-> {
            AddressableLEDBuffer capoLED = new AddressableLEDBuffer(60);
        for (var i = 0; i < capoLED.getLength(); i++) {
            // Calculate the hue - hue is easier for rainbows because the color
            // shape is a circle so only one value needs to precess
            final var v = 0;
            // Set the value
            capoLED.setRGB(i, 255, 0, 0);
        }
        LEDs.setLength(60);
        LEDs.setData(capoLED);
        LEDs.start();
        });
    }

    public Command loaded() {
        return new InstantCommand(()-> {
            AddressableLEDBuffer capoLED = new AddressableLEDBuffer(60);
            for (var i = 0; i < capoLED.getLength(); i++) {
                // Calculate the hue - hue is easier for rainbows because the color
                // shape is a circle so only one value needs to precess
                final var v = 0;
                // Set the value
                capoLED.setRGB(i, 0, 255, 0);
            }
            LEDs.setLength(60);
            LEDs.setData(capoLED);
            LEDs.start();
        });
    }

    public void yellows(){
        AddressableLEDBuffer capoLED = new AddressableLEDBuffer(60);
        for (var i = 0; i < capoLED.getLength(); i++) {
            // Calculate the hue - hue is easier for rainbows because the color
            // shape is a circle so only one value needs to precess
            final var v = 0;
            // Set the value
            capoLED.setHSV(i, 60, 255, 125);
        }
    }

}
