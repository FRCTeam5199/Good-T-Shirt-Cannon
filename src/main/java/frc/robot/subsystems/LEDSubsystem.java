package frc.robot.subsystems;

import javax.swing.text.AbstractDocument.LeafElement;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import static java.awt.Color.black;

public class LEDSubsystem extends SubsystemBase {
    boolean finished;

    static AddressableLED LEDs = new AddressableLED(Constants.LED_PORT);
    static AddressableLEDBuffer LEDBUFFER = new AddressableLEDBuffer(Constants.LED_LENGTH);
    static int blackLED1 = 15;
    static int blackLED2 = 45;
    static int[] blackLEDs = new int[]{13, 15, 17, 43, 45, 47};
    static boolean preloading = false;

   /* public void yellow() {

            for(var i = 0; i < LEDBUFFER.getLength(); i++) {
                LEDBUFFER.setRGB(i, 255, 255, 25);
            }
            LEDs.setLength(LEDBUFFER.getLength());
            LEDs.setData(LEDBUFFER);
            LEDs.start();

    }
    */

    public LEDSubsystem() {

    }

    @Override
    public void periodic() {
        if (preloading) {
            for (int i = 0; i < blackLEDs.length; i++) {
                blackLEDs[i]++;
                if (blackLEDs[i] >= 60) blackLEDs[i] = 1;
            }

            for (int i = 0; i < LEDBUFFER.getLength(); i++) {
                if (contains(i, blackLEDs)) {
                    LEDBUFFER.setRGB(i, 0, 0, 0);
                    LEDBUFFER.setRGB(i - 1, 255, 30, 0);
                } else {
                    LEDBUFFER.setRGB(i, 255, 30, 0);
                }

            }

            LEDs.setLength(LEDBUFFER.getLength());
            LEDs.setData(LEDBUFFER);
            LEDs.start();
        }
    }

    public boolean contains(int targetValue, int[] array) {
        for (int value : array) {
            if (value == targetValue) return true;
        }
        return false;
    }

    public void warningLights() {
        for (var i = 0; i < LEDBUFFER.getLength(); i++) {
            LEDBUFFER.setRGB(i, 255, 0, 0);
        }
        LEDs.setLength(LEDBUFFER.getLength());
        LEDs.setData(LEDBUFFER);
        LEDs.start();

        for (var i = 0; i < LEDBUFFER.getLength(); i++) {
            LEDBUFFER.setRGB(i, 0, 0, 0);

        }
        LEDs.setLength(LEDBUFFER.getLength());
        LEDs.setData(LEDBUFFER);
        LEDs.start();
    }

    public Command yellow() {
        return new InstantCommand(() -> {
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
        return new InstantCommand(() -> {
            preloading = true;
            AddressableLEDBuffer capoLED = new AddressableLEDBuffer(60);
            for (var i = 0; i < capoLED.getLength(); i++) {
                // Calculate the hue - hue is easier for rainbows because the color
                // shape is a circle so only one value needs to precess
                final var v = 0;
                // Set the value
                capoLED.setRGB(i, 255, 30, 0);
            }
            LEDs.setLength(60);
            LEDs.setData(capoLED);
            LEDs.start();
        });
    }

    public Command loaded() {
        return new InstantCommand(() -> {
            preloading = false;
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

    public void yellows() {
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
