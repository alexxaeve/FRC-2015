package org.team708.robot.subsystems;

import org.team708.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteElevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon toteElevatorMotor1; 
	private CANTalon toteElevatorMotor2;
	
	private Encoder toteElevatorEncoder;
	private final double PULSES_PER_REVOLUTION = 7.0;
	private final double GEARING = (16 / 50);
	private double DISTANCE_PER_PULSE;
	
	public final double TOP_ENCODER_DISTANCE = 25.0;
	public final double BOTTOM_ENCODER_DISTANCE = 0.0;
	
	public ToteElevator() {
		toteElevatorMotor1 = new CANTalon(RobotMap.toteElevatorMotor1);
		toteElevatorMotor2 = new CANTalon(RobotMap.toteElevatorMotor2);
		
		toteElevatorEncoder = new Encoder(RobotMap.toteElevatorEncoderA, RobotMap.toteElevatorEncoderB);
		DISTANCE_PER_PULSE = PULSES_PER_REVOLUTION * GEARING;
		toteElevatorEncoder.setDistancePerPulse(DISTANCE_PER_PULSE);
		toteElevatorEncoder.setReverseDirection(true);
	}
	
	public void set(double speed) {
		toteElevatorMotor1.set(speed);
		toteElevatorMotor2.set(-speed);
	}
	
	public double getEncoderDistance() {
		return toteElevatorEncoder.getDistance();
	}
	
	public double getEncoderRate() {
		return toteElevatorEncoder.getRate();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

