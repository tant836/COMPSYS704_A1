package org.compsys704;

import java.util.Arrays;
import java.util.List;

public class LoaderVizWorker extends Worker {

	@Override
	public void setSignal(boolean status) {
		System.out.println(signame + "  " + status);
		switch (signame) {
		case "motConveyorOnE":
			States.motConveyorOn = status;

			break;
		case "bottleLeftPos5E":
			States.bottleLeftPos5 = status;

			break;
		case "bottleAtPos5E":
			States.bottleAtPos5 = status;

			break;
		case "bottleAtPos1E":
			States.bottleAtPos1 = status;

			break;
		case "rotaryTableTriggerE":
			States.rotaryTableTrigger = status;
			break;
		case "gripperTurnRetractE":
			States.gripperTurnRetract = status;
			break;
		case "gripperTurnExtendE":
			States.gripperTurnExtend = status;
			break;
		case "capGripperPos5ExtendE":
			States.capGripperPos5Extend = status;
			break;
		case "cylClampBottleExtendE":
			States.cylClampBottleExtend = status;
			break;
		case "valveInjectorOnOffE":
			States.valveInjectorOnOff = status;
			break;
		case "valveInletOnOffE":
			States.valveInletOnOff = status;
			break;
		case "dosUnitValveRetractE":
			States.dosUnitValveRetract = status;
			break;
		case "dosUnitValveExtendE":
			States.dosUnitValveExtend = status;
			break;
		case "bottleAtPos2E":
			States.bottleAtPos2 = status;
			break;
		case "bottleAtPos4E":
			States.bottleAtPos4 = status;
			break;

		case "gripperZAxisLoweredE":
			States.gripperZAxisLowered = status;
			break;

		case "gripperZAxisLiftedE":
			States.gripperZAxisLifted = status;
			break;

		case "gripperTurnHomePosE":
			States.gripperTurnHomePos = status;
			break;

		case "gripperTurnFinalPosE":
			States.gripperTurnFinalPos = status;
			break;

		case "cylPos5ZaxisExtendE":
			States.cylPos5ZaxisExtend = status;
			break;
			
		case "dosUnitFilledE":
			States.dosUnitFilled = status;
			break;
			
		case "dosUnitEvacE":
			States.dosUnitEvac = status;
			break;
			
		case "capOnBottleAtPos1E":
			States.capsonBottleAtPos1 = status;
			break;
			
		case "noz1E":
			
			States.noz1 = status;
			break;
			
		case "noz2E":
			
			States.noz2 = status;
			break;
			
		case "noz3E":
			
			States.noz3 = status;
			break;
			
		case "noz4E":
			
			States.noz4 = status;
			break;
			
		case "pusherRetractedE":
			States.PUSHER_RETRACTED = status;
			break;
		case "pusherExtendedE":
			if(!States.MAG_EMPTY && !States.PUSHER_EXTENDED)
				States.CAP_READY = true;
			States.PUSHER_EXTENDED = status;
			break;
		case "WPgrippedE":
			if(States.GRIPPED && States.ARM_AT_SOURCE){
				if(!status)
					States.CAP_READY = true;
			}
			States.GRIPPED = status;
			if(States.GRIPPED && States.ARM_AT_SOURCE){
				States.CAP_READY = false;
			}
			break;
		case "armAtSourceE":
			States.ARM_AT_SOURCE = status;
			break;
		case "armAtDestE":
			States.ARM_AT_DEST = status;
			break;
		case "emptyE":
			States.MAG_EMPTY = status;
			break;

		case "pusherExtendE":
			
			States.pusherExtend = status;
			break;
			
		case "vacOnE":
			
			States.vacOn = status;
			break;
			
		case "armSourceE":
			
			States.armSource = status;
			break;
			
		case "armDestE":
			
			States.armDest = status;
			break;
			
		case "bottleAtPos3E":
			
			States.bottleAtPos3 = status;
			break;
			
		default:
			System.err.println("Wrong sig name : " + signame);
			// System.exit(1);
		}
		
		
	}

	static final List<String> signames = Arrays.asList("motConveyorOnE", "bottleAtPos1E", "rotaryTableTriggerE", "bottleAtPos3E",
			"cylPos5ZAxisExtendE", "bottleLeftPos5E", "bottleAtPos4E", "bottleAtPos2E", "gripperTurnRetractE",
			"gripperTurnExtendE", "capGripperPos5ExtendE", "cylClampBottleExtendE", "bottleAtPos5E", "capOnBottleAtPos1E",
			"gripperZAxisLoweredE", "gripperZAxisLiftedE", "gripperTurnHomePosE", "gripperTurnFinalPosE",
			"valveInjectorOnOffE", "valveInletOnOffE", "dosUnitValveRetractE", "dosUnitEvacE", "dosUnitFilledE",
			"dosUnitValveExtendE", "emptyE", "armAtDestE", "armAtSourceE", "WPgrippedE", "pusherExtendedE",
			"pusherRetractedE", "noz1E", "noz2E", "noz3E", "noz4E", "pusherRetractedE","pusherExtendedE","WPgrippedE",
			"armAtSourceE","armAtDestE","emptyE", "pusherExtendE", "vacOnE", "armSourceE", "armDestE");

	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	}

}
