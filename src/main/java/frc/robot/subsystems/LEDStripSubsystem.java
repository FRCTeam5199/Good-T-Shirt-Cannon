// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogOutput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDStripSubsystem extends SubsystemBase {
  /** Creates a new SeparateLEDStripSubsystem. */

  AnalogOutput redStrip;
  public LEDStripSubsystem() {
    redStrip = new AnalogOutput(Constants.redStripPort);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Command test() {
      return this.runOnce(() -> redStrip.setVoltage(1.0));
  }
}
