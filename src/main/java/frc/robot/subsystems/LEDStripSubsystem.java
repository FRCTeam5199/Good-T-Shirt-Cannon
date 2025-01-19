// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.simulation.PWMSim;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class LEDStripSubsystem extends SubsystemBase {
  /** Creates a new SeparateLEDStripSubsystem. */

  private PWM redStrip;
  private PWM greenStrip;
  private PWM blueStrip;


  private int pressedCount;

  public LEDStripSubsystem(int redPort, int greenPort, int bluePort) {
    redStrip = new PWM(redPort);
    greenStrip = new PWM(greenPort);
    blueStrip = new PWM(bluePort);


    pressedCount = 0;

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**
   * Sets led strip color based on 8bit rgb values
   * @param red 8bit Red value (0-255)
   * @param green 8bit Green value (0-255)
   * @param blue 8bit Blue value (0-255)
   */

  public void setRGB(int red, int green, int blue) {
    //Because I have to set colors with the microseconds, it is not completely accurate to the usual way
      redStrip.setPulseTimeMicroseconds(eightbitToMs(red));
      greenStrip.setPulseTimeMicroseconds(eightbitToMs(green));
      blueStrip.setPulseTimeMicroseconds(eightbitToMs(blue));
  }

  /**
   * Sets the led strip color based on the color enum
   * @param selectedColor the color enum Color.kColor (ex: Color.kRed)
   */

  public void setColor(Color selectedColor) {
    setRGB((int) (Math.round(selectedColor.red*255)), (int) (Math.round(selectedColor.green*255)), (int) (Math.round(selectedColor.blue*255)));
  }

  /**
   * Turns 8bit val to microseconds for led strip brightness
   * @param eightbit: 8bit value (0-255)
   * @return ms: the pulse time in milliseconds (0 - 4095)
   */

  public int eightbitToMs(int eightbit) {
    //Converts the 8bit value to a microseconds value because the PWM class only accepts that
    if(eightbit>255) {
      System.err.println("Please make the 8bit value 0 - 255");
      eightbit = 255;
    } else if(eightbit<0) {
      System.err.println("Please make the 8bit value 0 - 255");
      eightbit = 0 ;
    }

    return (int) Math.round((((double) eightbit)/255.0)*4095.0);
  }

  public Command testColors() {
    
    return this.runOnce(() -> {
      if (getCount()==0) {
        this.pressedCount += 1;
        setColor(Color.kDeepSkyBlue);
      } else if (getCount()==1) {
        this.pressedCount+= 1;
        setColor(Color.kBrown);
      } else {
        this.pressedCount = 0;
        setColor(Color.kDarkOliveGreen);;
       }});
  }

  public Command testEnums(Color selectedColor) {
    return this.runOnce(() -> {
      System.out.println("Red: " + selectedColor.red);
      System.out.println("Green: " + selectedColor.green);
      System.out.println("Blue: " + selectedColor.blue);
    });
  }

  public int getCount() {
    return this.pressedCount;
  }

  public Command resetLights() {
    return this.runOnce(() -> setRGB(0,0,0));
  }

}
