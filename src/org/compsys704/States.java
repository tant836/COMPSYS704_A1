package org.compsys704;

public class States {
	public static volatile boolean bottleInserted = false;
	
	
	public static volatile boolean bottleAtPos1 = true;
	public static volatile boolean bottleLeftPos5 = false;
	public static volatile boolean motConveyorOn = false;
	
	public static volatile boolean tableAlignedWithSensor = true;
	public static volatile boolean bottleAtPos5 = false;
	public static volatile boolean capsonBottleAtPos1 = false;
	public static volatile boolean rotaryTableTrigger = false;
	
	public static volatile boolean bottleAtPos4 = false;
	public static volatile boolean gripperZAxisLowered = true;
	public static volatile boolean gripperZAxisLifted = !gripperZAxisLowered;
	public static volatile boolean gripperTurnHomePos = true;
	public static volatile boolean gripperTurnFinalPos = !gripperTurnHomePos;
	public static volatile boolean cylPos5ZaxisExtend = false;
	public static volatile boolean gripperTurnRetract = false;
	public static volatile boolean gripperTurnExtend = false;
	public static volatile boolean capGripperPos5Extend = false;
	public static volatile boolean cylClampBottleExtend = false;
	
	public static volatile boolean bottleAtPos2 = false;
	public static volatile boolean dosUnitEvac = true;
	public static volatile boolean dosUnitFilled = !dosUnitEvac;
	public static volatile boolean valveInjectorOnOff = false;
	public static volatile boolean valveInletOnOff = false;
	public static volatile boolean dosUnitValveRetract = false;
	public static volatile boolean dosUnitValveExtend = false;
	
	public static volatile boolean noz1 = false;
	public static volatile boolean noz2 = false;
	public static volatile boolean noz3 = false;
	public static volatile boolean noz4 = false;
	
	
	public static volatile boolean PUSHER_RETRACTED = true;
	public static volatile boolean PUSHER_EXTENDED = !PUSHER_RETRACTED;
	public static volatile boolean GRIPPED = false;
	public static volatile boolean ARM_AT_SOURCE = false;
	public static volatile boolean ARM_AT_DEST = true;
	public static volatile boolean MAG_EMPTY = false;
	public static volatile boolean bottleAtPos3 = false;
	
	public static volatile boolean CAP_READY = false;
	
	
	
	public static volatile boolean pusherExtend = false;
	public static volatile boolean vacOn = false;
	public static volatile boolean armSource = false;
	public static volatile boolean armDest = false;
	
	public static volatile String Liquid = "Water";
	
}
