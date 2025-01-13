// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.simulation.PWMSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class LEDStripSubsystem extends SubsystemBase {
  /** Creates a new SeparateLEDStripSubsystem. */

  PWM redStrip;
  PWM greenStrip;
  PWM blueStrip;

  int pressedCount;

  public LEDStripSubsystem() {
    redStrip = new PWM(Constants.redStripPort);
    greenStrip = new PWM(Constants.greenStripPort);
    blueStrip = new PWM(Constants.blueStripPort);

    pressedCount = 0;

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setRGB(int red, int green, int blue) {
    //Because I have to set colors with the microseconds, it is not completely accurate to the usual way
      redStrip.setPulseTimeMicroseconds(eightbitToMs(red));
      greenStrip.setPulseTimeMicroseconds(eightbitToMs(green));
      blueStrip.setPulseTimeMicroseconds(eightbitToMs(blue));
    

  }

  public int eightbitToMs(int eightbit) {
    //Converts the 8bit value to a microseconds value because the PWM class only accepts that
    return (int) ((eightbit/255)*4095);
  }

  public Command testColors() {

    System.out.println("RUnning test light hginigsk");
    System.out.println(eightbitToMs(255));
    
    return this.runOnce(() -> {
    if (getCount()==0) {
      this.pressedCount += 1;
      System.out.println("here1");
      setRGB(255,0,0);
    } else if (getCount()==1) {
      this.pressedCount+= 1;
      System.out.println("here2");
      setRGB(0,255,0);
    } else {
      this.pressedCount = 0;
      System.out.println("here3");
      setRGB(0,0,255);
  }});
  }

  public int getCount() {
    return this.pressedCount;
  }

  public Command resetLights() {
    return this.runOnce(() -> setRGB(0,0,0));
  }

}
