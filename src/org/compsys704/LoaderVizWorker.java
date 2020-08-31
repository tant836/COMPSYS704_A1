package org.compsys704;

import java.util.Arrays;
import java.util.List;

public class LoaderVizWorker extends Worker {

	@Override
	public void setSignal(boolean status) {
		System.out.println(signame+"  "+status);
		switch (signame) {
		case "motConveyorOnE":
			States.motConveyorOn = status;
			
			break;
		case "bottleAtPos1E":
			States.bottleAtPos1 = status;
			
			break;
		case "rotaryTableTriggerE":
			States.rotaryTableTrigger = status;
			break;
		case "cylPos5ZAxisExtendE":
			States.cylPos5ZAxisExtend = status;
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
		default:
			System.err.println("Wrong sig name : " + signame);
			System.exit(1);
		}
	}

	static final List<String> signames = Arrays.asList("motConveyorOnE", "bottleAtPos1E", "rotaryTableTriggerE", "cylPos5ZAxisExtendE",
			"gripperTurnRetractE", "gripperTurnExtendE", "capGripperPos5ExtendE", "cylClampBottleExtendE",
			"valveInjectorOnOffE", "valveInletOnOffE", "dosUnitValveRetractE", "dosUnitValveExtendE");

	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	}

}
