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
			if(status) {
				States.Liquid = "Liquid 1";
			}
			break;
			
		case "noz2E":
			if(status) {
				States.Liquid = "Liquid 2";
			}
			break;
			
		case "noz3E":
			if(status) {
				States.Liquid = "Liquid 3";
			}
			break;
			
		case "noz4E":
			if(status) {
				States.Liquid = "Liquid 4";
			}
			break;

		default:
			System.err.println("Wrong sig name : " + signame);
			// System.exit(1);
		}
	}

	static final List<String> signames = Arrays.asList("motConveyorOnE", "bottleAtPos1E", "rotaryTableTriggerE",
			"cylPos5ZAxisExtendE", "bottleLeftPos5E", "bottleAtPos4E", "bottleAtPos2E", "gripperTurnRetractE",
			"gripperTurnExtendE", "capGripperPos5ExtendE", "cylClampBottleExtendE", "bottleAtPos5E", "capOnBottleAtPos1E",
			"gripperZAxisLoweredE", "gripperZAxisLiftedE", "gripperTurnHomePosE", "gripperTurnFinalPosE",
			"valveInjectorOnOffE", "valveInletOnOffE", "dosUnitValveRetractE", "dosUnitEvacE", "dosUnitFilledE",
			"dosUnitValveExtendE", "emptyE", "armAtDestE", "armAtSourceE", "WPgrippedE", "pusherExtendedE",
			"pusherRetractedE", "noz1E", "noz2E", "no3E", "noz4E");

	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	}

}
