import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Plant extends ClockDomain{
  public Plant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal removeBottle = new Signal("removeBottle", Signal.INPUT);
  public Signal motConveyorOn = new Signal("motConveyorOn", Signal.INPUT);
  public Signal bottleAdded = new Signal("bottleAdded", Signal.INPUT);
  public Signal putBottleAt5_FV = new Signal("putBottleAt5_FV", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.INPUT);
  public Signal cylPos5ZaxisExtend = new Signal("cylPos5ZaxisExtend", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.INPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.INPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.INPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.INPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.INPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.INPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.INPUT);
  public Signal selNoz1 = new Signal("selNoz1", Signal.INPUT);
  public Signal selNoz2 = new Signal("selNoz2", Signal.INPUT);
  public Signal selNoz3 = new Signal("selNoz3", Signal.INPUT);
  public Signal selNoz4 = new Signal("selNoz4", Signal.INPUT);
  public Signal turnNozTrigger = new Signal("turnNozTrigger", Signal.INPUT);
  public Signal motConveyorOnE = new Signal("motConveyorOnE", Signal.OUTPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal bottleAtPos1E = new Signal("bottleAtPos1E", Signal.OUTPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal bottleAtPos5_RT = new Signal("bottleAtPos5_RT", Signal.OUTPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.OUTPUT);
  public Signal bottleAtPos5E = new Signal("bottleAtPos5E", Signal.OUTPUT);
  public Signal bottleLeftPos5E = new Signal("bottleLeftPos5E", Signal.OUTPUT);
  public Signal bottleAtPos2E = new Signal("bottleAtPos2E", Signal.OUTPUT);
  public Signal bottleAtPos4E = new Signal("bottleAtPos4E", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal rotaryTableTriggerE = new Signal("rotaryTableTriggerE", Signal.OUTPUT);
  public Signal bottleAtPos1_RT = new Signal("bottleAtPos1_RT", Signal.OUTPUT);
  public Signal capOnBottleAtPos1E = new Signal("capOnBottleAtPos1E", Signal.OUTPUT);
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.OUTPUT);
  public Signal cylPos5ZaxisExtendE = new Signal("cylPos5ZaxisExtendE", Signal.OUTPUT);
  public Signal gripperTurnRetractE = new Signal("gripperTurnRetractE", Signal.OUTPUT);
  public Signal gripperTurnExtendE = new Signal("gripperTurnExtendE", Signal.OUTPUT);
  public Signal capGripperPos5ExtendE = new Signal("capGripperPos5ExtendE", Signal.OUTPUT);
  public Signal cylClampBottleExtendE = new Signal("cylClampBottleExtendE", Signal.OUTPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal empty = new Signal("empty", Signal.OUTPUT);
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  public Signal gripperZAxisLoweredE = new Signal("gripperZAxisLoweredE", Signal.OUTPUT);
  public Signal gripperTurnFinalPosE = new Signal("gripperTurnFinalPosE", Signal.OUTPUT);
  public Signal gripperTurnHomePosE = new Signal("gripperTurnHomePosE", Signal.OUTPUT);
  public Signal gripperZAxisLiftedE = new Signal("gripperZAxisLiftedE", Signal.OUTPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.OUTPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.OUTPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.OUTPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.OUTPUT);
  public Signal valveInjectorOnOffE = new Signal("valveInjectorOnOffE", Signal.OUTPUT);
  public Signal valveInletOnOffE = new Signal("valveInletOnOffE", Signal.OUTPUT);
  public Signal dosUnitValveRetractE = new Signal("dosUnitValveRetractE", Signal.OUTPUT);
  public Signal dosUnitValveExtendE = new Signal("dosUnitValveExtendE", Signal.OUTPUT);
  public Signal dosUnitFilledE = new Signal("dosUnitFilledE", Signal.OUTPUT);
  public Signal dosUnitEvacE = new Signal("dosUnitEvacE", Signal.OUTPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.OUTPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.OUTPUT);
  public Signal noz1 = new Signal("noz1", Signal.OUTPUT);
  public Signal noz2 = new Signal("noz2", Signal.OUTPUT);
  public Signal noz3 = new Signal("noz3", Signal.OUTPUT);
  public Signal noz4 = new Signal("noz4", Signal.OUTPUT);
  public Signal o_selNoz1 = new Signal("o_selNoz1", Signal.OUTPUT);
  public Signal o_selNoz2 = new Signal("o_selNoz2", Signal.OUTPUT);
  public Signal o_selNoz3 = new Signal("o_selNoz3", Signal.OUTPUT);
  public Signal o_selNoz4 = new Signal("o_selNoz4", Signal.OUTPUT);
  public Signal noz1E = new Signal("noz1E", Signal.OUTPUT);
  public Signal noz2E = new Signal("noz2E", Signal.OUTPUT);
  public Signal noz3E = new Signal("noz3E", Signal.OUTPUT);
  public Signal noz4E = new Signal("noz4E", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal l_bottleAdded_1;
  private Signal l_putBottleAt5_1;
  private Signal l_putBottleAt4_1;
  private Signal l_putBottleAt2_1;
  private Signal capPos_1;
  private Signal s_motConveyorOn_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 113, column: 3
  private int numTurns_thread_13;//sysj\plant.sysj line: 203, column: 3
  private Integer chance_thread_14;//sysj\plant.sysj line: 228, column: 3
  private Integer rand_thread_14;//sysj\plant.sysj line: 229, column: 3
  private int nozzlenum_thread_21;//sysj\plant.sysj line: 328, column: 3
  private int S14747 = 1;
  private int S5271 = 1;
  private int S1423 = 1;
  private int S1377 = 1;
  private int S1476 = 1;
  private int S1430 = 1;
  private int S1520 = 1;
  private int S1490 = 1;
  private int S1485 = 1;
  private int S1588 = 1;
  private int S1542 = 1;
  private int S1524 = 1;
  private int S1650 = 1;
  private int S1686 = 1;
  private int S1654 = 1;
  private int S1732 = 1;
  private int S1697 = 1;
  private int S1778 = 1;
  private int S1743 = 1;
  private int S1864 = 1;
  private int S1799 = 1;
  private int S1786 = 1;
  private int S1950 = 1;
  private int S1885 = 1;
  private int S1872 = 1;
  private int S1980 = 1;
  private int S1957 = 1;
  private int S3038 = 1;
  private int S2005 = 1;
  private int S1991 = 1;
  private int S3320 = 1;
  private int S3074 = 1;
  private int S3040 = 1;
  private int S5365 = 1;
  private int S5294 = 1;
  private int S5281 = 1;
  private int S5459 = 1;
  private int S5388 = 1;
  private int S5375 = 1;
  private int S5553 = 1;
  private int S5482 = 1;
  private int S5469 = 1;
  private int S5599 = 1;
  private int S5564 = 1;
  private int S5789 = 1;
  private int S5788 = 1;
  private int S5626 = 1;
  private int S5613 = 1;
  private int S5883 = 1;
  private int S5812 = 1;
  private int S5799 = 1;
  private int S6335 = 1;
  private int S5908 = 1;
  private int S5894 = 1;
  private int S6663 = 1;
  private int S6343 = 1;
  private int S6351 = 1;
  private int S6359 = 1;
  private int S6379 = 1;
  private int S6365 = 1;
  private int S6363 = 1;
  private int S6387 = 1;
  private int S6425 = 1;
  private int S6399 = 1;
  private int S6397 = 1;
  private int S6445 = 1;
  private int S6431 = 1;
  private int S6429 = 1;
  private int S6453 = 1;
  private int S6461 = 1;
  private int S6469 = 1;
  private int S6477 = 1;
  private int S6485 = 1;
  private int S6493 = 1;
  private int S6501 = 1;
  private int S6509 = 1;
  private int S6517 = 1;
  private int S6525 = 1;
  private int S6533 = 1;
  private int S6541 = 1;
  private int S6549 = 1;
  private int S6557 = 1;
  private int S6565 = 1;
  private int S6573 = 1;
  private int S6581 = 1;
  private int S6589 = 1;
  private int S6597 = 1;
  private int S6605 = 1;
  private int S6613 = 1;
  private int S6621 = 1;
  private int S6629 = 1;
  private int S6637 = 1;
  private int S6645 = 1;
  private int S6653 = 1;
  private int S6661 = 1;
  
  private int[] ends = new int[57];
  private int[] tdone = new int[57];
  
  public void thread14862(int [] tdone, int [] ends){
        switch(S6661){
      case 0 : 
        active[56]=0;
        ends[56]=0;
        tdone[56]=1;
        break;
      
      case 1 : 
        if(noz4.getprestatus()){//sysj\plant.sysj line: 441, column: 25
          noz4E.setPresent();//sysj\plant.sysj line: 441, column: 31
          currsigs.addElement(noz4E);
          active[56]=1;
          ends[56]=1;
          tdone[56]=1;
        }
        else {
          active[56]=1;
          ends[56]=1;
          tdone[56]=1;
        }
        break;
      
    }
  }

  public void thread14861(int [] tdone, int [] ends){
        switch(S6653){
      case 0 : 
        active[55]=0;
        ends[55]=0;
        tdone[55]=1;
        break;
      
      case 1 : 
        if(noz3.getprestatus()){//sysj\plant.sysj line: 439, column: 25
          noz3E.setPresent();//sysj\plant.sysj line: 439, column: 31
          currsigs.addElement(noz3E);
          active[55]=1;
          ends[55]=1;
          tdone[55]=1;
        }
        else {
          active[55]=1;
          ends[55]=1;
          tdone[55]=1;
        }
        break;
      
    }
  }

  public void thread14860(int [] tdone, int [] ends){
        switch(S6645){
      case 0 : 
        active[54]=0;
        ends[54]=0;
        tdone[54]=1;
        break;
      
      case 1 : 
        if(noz2.getprestatus()){//sysj\plant.sysj line: 437, column: 25
          noz2E.setPresent();//sysj\plant.sysj line: 437, column: 31
          currsigs.addElement(noz2E);
          active[54]=1;
          ends[54]=1;
          tdone[54]=1;
        }
        else {
          active[54]=1;
          ends[54]=1;
          tdone[54]=1;
        }
        break;
      
    }
  }

  public void thread14859(int [] tdone, int [] ends){
        switch(S6637){
      case 0 : 
        active[53]=0;
        ends[53]=0;
        tdone[53]=1;
        break;
      
      case 1 : 
        if(noz1.getprestatus()){//sysj\plant.sysj line: 435, column: 25
          noz1E.setPresent();//sysj\plant.sysj line: 435, column: 31
          currsigs.addElement(noz1E);
          active[53]=1;
          ends[53]=1;
          tdone[53]=1;
        }
        else {
          active[53]=1;
          ends[53]=1;
          tdone[53]=1;
        }
        break;
      
    }
  }

  public void thread14858(int [] tdone, int [] ends){
        switch(S6629){
      case 0 : 
        active[52]=0;
        ends[52]=0;
        tdone[52]=1;
        break;
      
      case 1 : 
        if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 433, column: 25
          capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 433, column: 44
          currsigs.addElement(capOnBottleAtPos1E);
          active[52]=1;
          ends[52]=1;
          tdone[52]=1;
        }
        else {
          active[52]=1;
          ends[52]=1;
          tdone[52]=1;
        }
        break;
      
    }
  }

  public void thread14857(int [] tdone, int [] ends){
        switch(S6621){
      case 0 : 
        active[51]=0;
        ends[51]=0;
        tdone[51]=1;
        break;
      
      case 1 : 
        if(selNoz4.getprestatus()){//sysj\plant.sysj line: 431, column: 25
          o_selNoz4.setPresent();//sysj\plant.sysj line: 431, column: 34
          currsigs.addElement(o_selNoz4);
          active[51]=1;
          ends[51]=1;
          tdone[51]=1;
        }
        else {
          active[51]=1;
          ends[51]=1;
          tdone[51]=1;
        }
        break;
      
    }
  }

  public void thread14856(int [] tdone, int [] ends){
        switch(S6613){
      case 0 : 
        active[50]=0;
        ends[50]=0;
        tdone[50]=1;
        break;
      
      case 1 : 
        if(selNoz3.getprestatus()){//sysj\plant.sysj line: 429, column: 25
          o_selNoz3.setPresent();//sysj\plant.sysj line: 429, column: 34
          currsigs.addElement(o_selNoz3);
          active[50]=1;
          ends[50]=1;
          tdone[50]=1;
        }
        else {
          active[50]=1;
          ends[50]=1;
          tdone[50]=1;
        }
        break;
      
    }
  }

  public void thread14855(int [] tdone, int [] ends){
        switch(S6605){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(selNoz2.getprestatus()){//sysj\plant.sysj line: 427, column: 25
          o_selNoz2.setPresent();//sysj\plant.sysj line: 427, column: 34
          currsigs.addElement(o_selNoz2);
          active[49]=1;
          ends[49]=1;
          tdone[49]=1;
        }
        else {
          active[49]=1;
          ends[49]=1;
          tdone[49]=1;
        }
        break;
      
    }
  }

  public void thread14854(int [] tdone, int [] ends){
        switch(S6597){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(selNoz1.getprestatus()){//sysj\plant.sysj line: 425, column: 25
          o_selNoz1.setPresent();//sysj\plant.sysj line: 425, column: 34
          currsigs.addElement(o_selNoz1);
          active[48]=1;
          ends[48]=1;
          tdone[48]=1;
        }
        else {
          active[48]=1;
          ends[48]=1;
          tdone[48]=1;
        }
        break;
      
    }
  }

  public void thread14853(int [] tdone, int [] ends){
        switch(S6589){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 422, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 422, column: 40
          currsigs.addElement(dosUnitFilledE);
          active[47]=1;
          ends[47]=1;
          tdone[47]=1;
        }
        else {
          active[47]=1;
          ends[47]=1;
          tdone[47]=1;
        }
        break;
      
    }
  }

  public void thread14852(int [] tdone, int [] ends){
        switch(S6581){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 420, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 420, column: 38
          currsigs.addElement(dosUnitEvacE);
          active[46]=1;
          ends[46]=1;
          tdone[46]=1;
        }
        else {
          active[46]=1;
          ends[46]=1;
          tdone[46]=1;
        }
        break;
      
    }
  }

  public void thread14851(int [] tdone, int [] ends){
        switch(S6573){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 418, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 418, column: 39
          currsigs.addElement(bottleAtPos2E);
          active[45]=1;
          ends[45]=1;
          tdone[45]=1;
        }
        else {
          active[45]=1;
          ends[45]=1;
          tdone[45]=1;
        }
        break;
      
    }
  }

  public void thread14850(int [] tdone, int [] ends){
        switch(S6565){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 416, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 416, column: 45
          currsigs.addElement(dosUnitValveExtendE);
          active[44]=1;
          ends[44]=1;
          tdone[44]=1;
        }
        else {
          active[44]=1;
          ends[44]=1;
          tdone[44]=1;
        }
        break;
      
    }
  }

  public void thread14849(int [] tdone, int [] ends){
        switch(S6557){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 414, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 414, column: 46
          currsigs.addElement(dosUnitValveRetractE);
          active[43]=1;
          ends[43]=1;
          tdone[43]=1;
        }
        else {
          active[43]=1;
          ends[43]=1;
          tdone[43]=1;
        }
        break;
      
    }
  }

  public void thread14848(int [] tdone, int [] ends){
        switch(S6549){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 412, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 412, column: 42
          currsigs.addElement(valveInletOnOffE);
          active[42]=1;
          ends[42]=1;
          tdone[42]=1;
        }
        else {
          active[42]=1;
          ends[42]=1;
          tdone[42]=1;
        }
        break;
      
    }
  }

  public void thread14847(int [] tdone, int [] ends){
        switch(S6541){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 410, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 410, column: 45
          currsigs.addElement(valveInjectorOnOffE);
          active[41]=1;
          ends[41]=1;
          tdone[41]=1;
        }
        else {
          active[41]=1;
          ends[41]=1;
          tdone[41]=1;
        }
        break;
      
    }
  }

  public void thread14846(int [] tdone, int [] ends){
        switch(S6533){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 407, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 407, column: 47
          currsigs.addElement(cylClampBottleExtendE);
          active[40]=1;
          ends[40]=1;
          tdone[40]=1;
        }
        else {
          active[40]=1;
          ends[40]=1;
          tdone[40]=1;
        }
        break;
      
    }
  }

  public void thread14845(int [] tdone, int [] ends){
        switch(S6525){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 405, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 405, column: 47
          currsigs.addElement(capGripperPos5ExtendE);
          active[39]=1;
          ends[39]=1;
          tdone[39]=1;
        }
        else {
          active[39]=1;
          ends[39]=1;
          tdone[39]=1;
        }
        break;
      
    }
  }

  public void thread14844(int [] tdone, int [] ends){
        switch(S6517){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 403, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 403, column: 44
          currsigs.addElement(gripperTurnExtendE);
          active[38]=1;
          ends[38]=1;
          tdone[38]=1;
        }
        else {
          active[38]=1;
          ends[38]=1;
          tdone[38]=1;
        }
        break;
      
    }
  }

  public void thread14843(int [] tdone, int [] ends){
        switch(S6509){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 401, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 401, column: 45
          currsigs.addElement(gripperTurnRetractE);
          active[37]=1;
          ends[37]=1;
          tdone[37]=1;
        }
        else {
          active[37]=1;
          ends[37]=1;
          tdone[37]=1;
        }
        break;
      
    }
  }

  public void thread14842(int [] tdone, int [] ends){
        switch(S6501){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 399, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 399, column: 45
          currsigs.addElement(cylPos5ZaxisExtendE);
          active[36]=1;
          ends[36]=1;
          tdone[36]=1;
        }
        else {
          active[36]=1;
          ends[36]=1;
          tdone[36]=1;
        }
        break;
      
    }
  }

  public void thread14841(int [] tdone, int [] ends){
        switch(S6493){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 397, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 397, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
          active[35]=1;
          ends[35]=1;
          tdone[35]=1;
        }
        else {
          active[35]=1;
          ends[35]=1;
          tdone[35]=1;
        }
        break;
      
    }
  }

  public void thread14840(int [] tdone, int [] ends){
        switch(S6485){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 394, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 394, column: 45
          currsigs.addElement(gripperTurnHomePosE);
          active[34]=1;
          ends[34]=1;
          tdone[34]=1;
        }
        else {
          active[34]=1;
          ends[34]=1;
          tdone[34]=1;
        }
        break;
      
    }
  }

  public void thread14839(int [] tdone, int [] ends){
        switch(S6477){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 392, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 392, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
          active[33]=1;
          ends[33]=1;
          tdone[33]=1;
        }
        else {
          active[33]=1;
          ends[33]=1;
          tdone[33]=1;
        }
        break;
      
    }
  }

  public void thread14838(int [] tdone, int [] ends){
        switch(S6469){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 390, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 390, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
          active[32]=1;
          ends[32]=1;
          tdone[32]=1;
        }
        else {
          active[32]=1;
          ends[32]=1;
          tdone[32]=1;
        }
        break;
      
    }
  }

  public void thread14837(int [] tdone, int [] ends){
        switch(S6461){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 388, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 388, column: 38
          currsigs.addElement(bottleAtPos2E);
          active[31]=1;
          ends[31]=1;
          tdone[31]=1;
        }
        else {
          active[31]=1;
          ends[31]=1;
          tdone[31]=1;
        }
        break;
      
    }
  }

  public void thread14836(int [] tdone, int [] ends){
        switch(S6453){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 386, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 386, column: 38
          currsigs.addElement(bottleAtPos4E);
          active[30]=1;
          ends[30]=1;
          tdone[30]=1;
        }
        else {
          active[30]=1;
          ends[30]=1;
          tdone[30]=1;
        }
        break;
      
    }
  }

  public void thread14835(int [] tdone, int [] ends){
        switch(S6445){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S6431){
          case 0 : 
            switch(S6429){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 384, column: 54
                  S6429=1;
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                else {
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 384, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 384, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  S6431=1;
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                else {
                  active[29]=1;
                  ends[29]=1;
                  tdone[29]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S6431=1;
            S6431=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 384, column: 24
              S6429=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S6431=1;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14834(int [] tdone, int [] ends){
        switch(S6425){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S6399){
          case 0 : 
            switch(S6397){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 375, column: 11
                  S6397=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 377, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                else {
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 376, column: 11
                  S6399=1;
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 377, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S6399=1;
            S6399=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 374, column: 12
              S6397=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S6399=1;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14833(int [] tdone, int [] ends){
        switch(S6387){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 371, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 371, column: 56
          currsigs.addElement(bottleAtPos5E);
          active[27]=1;
          ends[27]=1;
          tdone[27]=1;
        }
        else {
          active[27]=1;
          ends[27]=1;
          tdone[27]=1;
        }
        break;
      
    }
  }

  public void thread14832(int [] tdone, int [] ends){
        switch(S6379){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S6365){
          case 0 : 
            switch(S6363){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 369, column: 54
                  S6363=1;
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                else {
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 369, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 369, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  S6365=1;
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                else {
                  active[26]=1;
                  ends[26]=1;
                  tdone[26]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S6365=1;
            S6365=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 369, column: 24
              S6363=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S6365=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14831(int [] tdone, int [] ends){
        switch(S6359){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 367, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 367, column: 44
          currsigs.addElement(rotaryTableTriggerE);
          active[25]=1;
          ends[25]=1;
          tdone[25]=1;
        }
        else {
          active[25]=1;
          ends[25]=1;
          tdone[25]=1;
        }
        break;
      
    }
  }

  public void thread14830(int [] tdone, int [] ends){
        switch(S6351){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 365, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 365, column: 39
          currsigs.addElement(motConveyorOnE);
          active[24]=1;
          ends[24]=1;
          tdone[24]=1;
        }
        else {
          active[24]=1;
          ends[24]=1;
          tdone[24]=1;
        }
        break;
      
    }
  }

  public void thread14829(int [] tdone, int [] ends){
        switch(S6343){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 363, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 363, column: 38
          currsigs.addElement(bottleAtPos1E);
          active[23]=1;
          ends[23]=1;
          tdone[23]=1;
        }
        else {
          active[23]=1;
          ends[23]=1;
          tdone[23]=1;
        }
        break;
      
    }
  }

  public void thread14828(int [] tdone, int [] ends){
        switch(S6663){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        thread14829(tdone,ends);
        thread14830(tdone,ends);
        thread14831(tdone,ends);
        thread14832(tdone,ends);
        thread14833(tdone,ends);
        thread14834(tdone,ends);
        thread14835(tdone,ends);
        thread14836(tdone,ends);
        thread14837(tdone,ends);
        thread14838(tdone,ends);
        thread14839(tdone,ends);
        thread14840(tdone,ends);
        thread14841(tdone,ends);
        thread14842(tdone,ends);
        thread14843(tdone,ends);
        thread14844(tdone,ends);
        thread14845(tdone,ends);
        thread14846(tdone,ends);
        thread14847(tdone,ends);
        thread14848(tdone,ends);
        thread14849(tdone,ends);
        thread14850(tdone,ends);
        thread14851(tdone,ends);
        thread14852(tdone,ends);
        thread14853(tdone,ends);
        thread14854(tdone,ends);
        thread14855(tdone,ends);
        thread14856(tdone,ends);
        thread14857(tdone,ends);
        thread14858(tdone,ends);
        thread14859(tdone,ends);
        thread14860(tdone,ends);
        thread14861(tdone,ends);
        thread14862(tdone,ends);
        int biggest14863 = 0;
        if(ends[23]>=biggest14863){
          biggest14863=ends[23];
        }
        if(ends[24]>=biggest14863){
          biggest14863=ends[24];
        }
        if(ends[25]>=biggest14863){
          biggest14863=ends[25];
        }
        if(ends[26]>=biggest14863){
          biggest14863=ends[26];
        }
        if(ends[27]>=biggest14863){
          biggest14863=ends[27];
        }
        if(ends[28]>=biggest14863){
          biggest14863=ends[28];
        }
        if(ends[29]>=biggest14863){
          biggest14863=ends[29];
        }
        if(ends[30]>=biggest14863){
          biggest14863=ends[30];
        }
        if(ends[31]>=biggest14863){
          biggest14863=ends[31];
        }
        if(ends[32]>=biggest14863){
          biggest14863=ends[32];
        }
        if(ends[33]>=biggest14863){
          biggest14863=ends[33];
        }
        if(ends[34]>=biggest14863){
          biggest14863=ends[34];
        }
        if(ends[35]>=biggest14863){
          biggest14863=ends[35];
        }
        if(ends[36]>=biggest14863){
          biggest14863=ends[36];
        }
        if(ends[37]>=biggest14863){
          biggest14863=ends[37];
        }
        if(ends[38]>=biggest14863){
          biggest14863=ends[38];
        }
        if(ends[39]>=biggest14863){
          biggest14863=ends[39];
        }
        if(ends[40]>=biggest14863){
          biggest14863=ends[40];
        }
        if(ends[41]>=biggest14863){
          biggest14863=ends[41];
        }
        if(ends[42]>=biggest14863){
          biggest14863=ends[42];
        }
        if(ends[43]>=biggest14863){
          biggest14863=ends[43];
        }
        if(ends[44]>=biggest14863){
          biggest14863=ends[44];
        }
        if(ends[45]>=biggest14863){
          biggest14863=ends[45];
        }
        if(ends[46]>=biggest14863){
          biggest14863=ends[46];
        }
        if(ends[47]>=biggest14863){
          biggest14863=ends[47];
        }
        if(ends[48]>=biggest14863){
          biggest14863=ends[48];
        }
        if(ends[49]>=biggest14863){
          biggest14863=ends[49];
        }
        if(ends[50]>=biggest14863){
          biggest14863=ends[50];
        }
        if(ends[51]>=biggest14863){
          biggest14863=ends[51];
        }
        if(ends[52]>=biggest14863){
          biggest14863=ends[52];
        }
        if(ends[53]>=biggest14863){
          biggest14863=ends[53];
        }
        if(ends[54]>=biggest14863){
          biggest14863=ends[54];
        }
        if(ends[55]>=biggest14863){
          biggest14863=ends[55];
        }
        if(ends[56]>=biggest14863){
          biggest14863=ends[56];
        }
        if(biggest14863 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest14863 == 0){
          S6663=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread14827(int [] tdone, int [] ends){
        switch(S6335){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S5908){
          case 0 : 
            S5908=0;
            S5908=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 332, column: 13
              S5894=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S5908=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if(!turnNozTrigger.getprestatus()){//sysj\plant.sysj line: 331, column: 10
              S5908=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              switch(S5894){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 333, column: 12
                    nozzlenum_thread_21 = nozzlenum_thread_21 + 1;//sysj\plant.sysj line: 334, column: 6
                    if(nozzlenum_thread_21 == 1){//sysj\plant.sysj line: 335, column: 9
                      noz1.setPresent();//sysj\plant.sysj line: 336, column: 7
                      currsigs.addElement(noz1);
                      S5908=0;
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      if(nozzlenum_thread_21 == 2){//sysj\plant.sysj line: 337, column: 15
                        noz2.setPresent();//sysj\plant.sysj line: 338, column: 7
                        currsigs.addElement(noz2);
                        S5908=0;
                        active[21]=1;
                        ends[21]=1;
                        tdone[21]=1;
                      }
                      else {
                        if(nozzlenum_thread_21 == 3){//sysj\plant.sysj line: 339, column: 15
                          noz3.setPresent();//sysj\plant.sysj line: 340, column: 7
                          currsigs.addElement(noz3);
                          S5908=0;
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                        else {
                          noz4.setPresent();//sysj\plant.sysj line: 342, column: 7
                          currsigs.addElement(noz4);
                          nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 343, column: 7
                          S5908=0;
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                      }
                    }
                  }
                  else {
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  break;
                
                case 1 : 
                  S5908=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14826(int [] tdone, int [] ends){
        switch(S5883){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S5812){
          case 0 : 
            S5812=0;
            S5812=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 317, column: 12
              S5799=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S5812=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S5799){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 318, column: 11
                  S5799=1;
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 320, column: 6
                  currsigs.addElement(dosUnitFilled);
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                if(!dosUnitValveRetract.getprestatus() && dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 319, column: 11
                  S5812=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 320, column: 6
                  currsigs.addElement(dosUnitFilled);
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14825(int [] tdone, int [] ends){
        switch(S5789){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S5788){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 300, column: 9
              S5788=1;
              S5626=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 301, column: 4
              currsigs.addElement(dosUnitEvac);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S5626){
              case 0 : 
                S5626=0;
                S5626=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 305, column: 12
                  S5613=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S5626=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                switch(S5613){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 306, column: 11
                      S5613=1;
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 308, column: 6
                      currsigs.addElement(dosUnitEvac);
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    else {
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    break;
                  
                  case 1 : 
                    if(!dosUnitValveExtend.getprestatus() && dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 307, column: 11
                      S5626=0;
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 308, column: 6
                      currsigs.addElement(dosUnitEvac);
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    break;
                  
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14824(int [] tdone, int [] ends){
        switch(S5599){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S5564){
          case 0 : 
            S5564=0;
            S5564=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 288, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 290, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S5564=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 289, column: 11
              S5564=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 290, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14823(int [] tdone, int [] ends){
        switch(S5553){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S5482){
          case 0 : 
            S5482=0;
            S5482=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 276, column: 12
              S5469=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S5482=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S5469){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 277, column: 11
                  S5469=1;
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 279, column: 6
                  currsigs.addElement(gripperTurnHomePos);
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
              case 1 : 
                if(!gripperTurnRetract.getprestatus() && gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 278, column: 11
                  S5482=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 279, column: 6
                  currsigs.addElement(gripperTurnHomePos);
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14822(int [] tdone, int [] ends){
        switch(S5459){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S5388){
          case 0 : 
            S5388=0;
            S5388=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 264, column: 12
              S5375=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S5388=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S5375){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 265, column: 11
                  S5375=1;
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 267, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(!gripperTurnExtend.getprestatus() && gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 266, column: 11
                  S5388=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 267, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14821(int [] tdone, int [] ends){
        switch(S5365){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S5294){
          case 0 : 
            S5294=0;
            S5294=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 252, column: 12
              S5281=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S5294=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S5281){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 253, column: 11
                  S5281=1;
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 255, column: 6
                  currsigs.addElement(gripperZAxisLowered);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 1 : 
                if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 254, column: 11
                  S5294=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 255, column: 6
                  currsigs.addElement(gripperZAxisLowered);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14818(int [] tdone, int [] ends){
        S6661=1;
    if(noz4.getprestatus()){//sysj\plant.sysj line: 441, column: 25
      noz4E.setPresent();//sysj\plant.sysj line: 441, column: 31
      currsigs.addElement(noz4E);
      active[56]=1;
      ends[56]=1;
      tdone[56]=1;
    }
    else {
      active[56]=1;
      ends[56]=1;
      tdone[56]=1;
    }
  }

  public void thread14817(int [] tdone, int [] ends){
        S6653=1;
    if(noz3.getprestatus()){//sysj\plant.sysj line: 439, column: 25
      noz3E.setPresent();//sysj\plant.sysj line: 439, column: 31
      currsigs.addElement(noz3E);
      active[55]=1;
      ends[55]=1;
      tdone[55]=1;
    }
    else {
      active[55]=1;
      ends[55]=1;
      tdone[55]=1;
    }
  }

  public void thread14816(int [] tdone, int [] ends){
        S6645=1;
    if(noz2.getprestatus()){//sysj\plant.sysj line: 437, column: 25
      noz2E.setPresent();//sysj\plant.sysj line: 437, column: 31
      currsigs.addElement(noz2E);
      active[54]=1;
      ends[54]=1;
      tdone[54]=1;
    }
    else {
      active[54]=1;
      ends[54]=1;
      tdone[54]=1;
    }
  }

  public void thread14815(int [] tdone, int [] ends){
        S6637=1;
    if(noz1.getprestatus()){//sysj\plant.sysj line: 435, column: 25
      noz1E.setPresent();//sysj\plant.sysj line: 435, column: 31
      currsigs.addElement(noz1E);
      active[53]=1;
      ends[53]=1;
      tdone[53]=1;
    }
    else {
      active[53]=1;
      ends[53]=1;
      tdone[53]=1;
    }
  }

  public void thread14814(int [] tdone, int [] ends){
        S6629=1;
    if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 433, column: 25
      capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 433, column: 44
      currsigs.addElement(capOnBottleAtPos1E);
      active[52]=1;
      ends[52]=1;
      tdone[52]=1;
    }
    else {
      active[52]=1;
      ends[52]=1;
      tdone[52]=1;
    }
  }

  public void thread14813(int [] tdone, int [] ends){
        S6621=1;
    if(selNoz4.getprestatus()){//sysj\plant.sysj line: 431, column: 25
      o_selNoz4.setPresent();//sysj\plant.sysj line: 431, column: 34
      currsigs.addElement(o_selNoz4);
      active[51]=1;
      ends[51]=1;
      tdone[51]=1;
    }
    else {
      active[51]=1;
      ends[51]=1;
      tdone[51]=1;
    }
  }

  public void thread14812(int [] tdone, int [] ends){
        S6613=1;
    if(selNoz3.getprestatus()){//sysj\plant.sysj line: 429, column: 25
      o_selNoz3.setPresent();//sysj\plant.sysj line: 429, column: 34
      currsigs.addElement(o_selNoz3);
      active[50]=1;
      ends[50]=1;
      tdone[50]=1;
    }
    else {
      active[50]=1;
      ends[50]=1;
      tdone[50]=1;
    }
  }

  public void thread14811(int [] tdone, int [] ends){
        S6605=1;
    if(selNoz2.getprestatus()){//sysj\plant.sysj line: 427, column: 25
      o_selNoz2.setPresent();//sysj\plant.sysj line: 427, column: 34
      currsigs.addElement(o_selNoz2);
      active[49]=1;
      ends[49]=1;
      tdone[49]=1;
    }
    else {
      active[49]=1;
      ends[49]=1;
      tdone[49]=1;
    }
  }

  public void thread14810(int [] tdone, int [] ends){
        S6597=1;
    if(selNoz1.getprestatus()){//sysj\plant.sysj line: 425, column: 25
      o_selNoz1.setPresent();//sysj\plant.sysj line: 425, column: 34
      currsigs.addElement(o_selNoz1);
      active[48]=1;
      ends[48]=1;
      tdone[48]=1;
    }
    else {
      active[48]=1;
      ends[48]=1;
      tdone[48]=1;
    }
  }

  public void thread14809(int [] tdone, int [] ends){
        S6589=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 422, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 422, column: 40
      currsigs.addElement(dosUnitFilledE);
      active[47]=1;
      ends[47]=1;
      tdone[47]=1;
    }
    else {
      active[47]=1;
      ends[47]=1;
      tdone[47]=1;
    }
  }

  public void thread14808(int [] tdone, int [] ends){
        S6581=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 420, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 420, column: 38
      currsigs.addElement(dosUnitEvacE);
      active[46]=1;
      ends[46]=1;
      tdone[46]=1;
    }
    else {
      active[46]=1;
      ends[46]=1;
      tdone[46]=1;
    }
  }

  public void thread14807(int [] tdone, int [] ends){
        S6573=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 418, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 418, column: 39
      currsigs.addElement(bottleAtPos2E);
      active[45]=1;
      ends[45]=1;
      tdone[45]=1;
    }
    else {
      active[45]=1;
      ends[45]=1;
      tdone[45]=1;
    }
  }

  public void thread14806(int [] tdone, int [] ends){
        S6565=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 416, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 416, column: 45
      currsigs.addElement(dosUnitValveExtendE);
      active[44]=1;
      ends[44]=1;
      tdone[44]=1;
    }
    else {
      active[44]=1;
      ends[44]=1;
      tdone[44]=1;
    }
  }

  public void thread14805(int [] tdone, int [] ends){
        S6557=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 414, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 414, column: 46
      currsigs.addElement(dosUnitValveRetractE);
      active[43]=1;
      ends[43]=1;
      tdone[43]=1;
    }
    else {
      active[43]=1;
      ends[43]=1;
      tdone[43]=1;
    }
  }

  public void thread14804(int [] tdone, int [] ends){
        S6549=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 412, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 412, column: 42
      currsigs.addElement(valveInletOnOffE);
      active[42]=1;
      ends[42]=1;
      tdone[42]=1;
    }
    else {
      active[42]=1;
      ends[42]=1;
      tdone[42]=1;
    }
  }

  public void thread14803(int [] tdone, int [] ends){
        S6541=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 410, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 410, column: 45
      currsigs.addElement(valveInjectorOnOffE);
      active[41]=1;
      ends[41]=1;
      tdone[41]=1;
    }
    else {
      active[41]=1;
      ends[41]=1;
      tdone[41]=1;
    }
  }

  public void thread14802(int [] tdone, int [] ends){
        S6533=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 407, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 407, column: 47
      currsigs.addElement(cylClampBottleExtendE);
      active[40]=1;
      ends[40]=1;
      tdone[40]=1;
    }
    else {
      active[40]=1;
      ends[40]=1;
      tdone[40]=1;
    }
  }

  public void thread14801(int [] tdone, int [] ends){
        S6525=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 405, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 405, column: 47
      currsigs.addElement(capGripperPos5ExtendE);
      active[39]=1;
      ends[39]=1;
      tdone[39]=1;
    }
    else {
      active[39]=1;
      ends[39]=1;
      tdone[39]=1;
    }
  }

  public void thread14800(int [] tdone, int [] ends){
        S6517=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 403, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 403, column: 44
      currsigs.addElement(gripperTurnExtendE);
      active[38]=1;
      ends[38]=1;
      tdone[38]=1;
    }
    else {
      active[38]=1;
      ends[38]=1;
      tdone[38]=1;
    }
  }

  public void thread14799(int [] tdone, int [] ends){
        S6509=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 401, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 401, column: 45
      currsigs.addElement(gripperTurnRetractE);
      active[37]=1;
      ends[37]=1;
      tdone[37]=1;
    }
    else {
      active[37]=1;
      ends[37]=1;
      tdone[37]=1;
    }
  }

  public void thread14798(int [] tdone, int [] ends){
        S6501=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 399, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 399, column: 45
      currsigs.addElement(cylPos5ZaxisExtendE);
      active[36]=1;
      ends[36]=1;
      tdone[36]=1;
    }
    else {
      active[36]=1;
      ends[36]=1;
      tdone[36]=1;
    }
  }

  public void thread14797(int [] tdone, int [] ends){
        S6493=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 397, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 397, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
      active[35]=1;
      ends[35]=1;
      tdone[35]=1;
    }
    else {
      active[35]=1;
      ends[35]=1;
      tdone[35]=1;
    }
  }

  public void thread14796(int [] tdone, int [] ends){
        S6485=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 394, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 394, column: 45
      currsigs.addElement(gripperTurnHomePosE);
      active[34]=1;
      ends[34]=1;
      tdone[34]=1;
    }
    else {
      active[34]=1;
      ends[34]=1;
      tdone[34]=1;
    }
  }

  public void thread14795(int [] tdone, int [] ends){
        S6477=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 392, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 392, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
    else {
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
  }

  public void thread14794(int [] tdone, int [] ends){
        S6469=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 390, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 390, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
    else {
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
  }

  public void thread14793(int [] tdone, int [] ends){
        S6461=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 388, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 388, column: 38
      currsigs.addElement(bottleAtPos2E);
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
    else {
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
  }

  public void thread14792(int [] tdone, int [] ends){
        S6453=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 386, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 386, column: 38
      currsigs.addElement(bottleAtPos4E);
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
    else {
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
  }

  public void thread14791(int [] tdone, int [] ends){
        S6445=1;
    S6431=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 384, column: 24
      S6429=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S6431=1;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread14790(int [] tdone, int [] ends){
        S6425=1;
    S6399=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 374, column: 12
      S6397=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      S6399=1;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread14789(int [] tdone, int [] ends){
        S6387=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 371, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 371, column: 56
      currsigs.addElement(bottleAtPos5E);
      active[27]=1;
      ends[27]=1;
      tdone[27]=1;
    }
    else {
      active[27]=1;
      ends[27]=1;
      tdone[27]=1;
    }
  }

  public void thread14788(int [] tdone, int [] ends){
        S6379=1;
    S6365=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 369, column: 24
      S6363=0;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      S6365=1;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread14787(int [] tdone, int [] ends){
        S6359=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 367, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 367, column: 44
      currsigs.addElement(rotaryTableTriggerE);
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
    else {
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
  }

  public void thread14786(int [] tdone, int [] ends){
        S6351=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 365, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 365, column: 39
      currsigs.addElement(motConveyorOnE);
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
    else {
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
  }

  public void thread14785(int [] tdone, int [] ends){
        S6343=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 363, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 363, column: 38
      currsigs.addElement(bottleAtPos1E);
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
    else {
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
  }

  public void thread14784(int [] tdone, int [] ends){
        S6663=1;
    thread14785(tdone,ends);
    thread14786(tdone,ends);
    thread14787(tdone,ends);
    thread14788(tdone,ends);
    thread14789(tdone,ends);
    thread14790(tdone,ends);
    thread14791(tdone,ends);
    thread14792(tdone,ends);
    thread14793(tdone,ends);
    thread14794(tdone,ends);
    thread14795(tdone,ends);
    thread14796(tdone,ends);
    thread14797(tdone,ends);
    thread14798(tdone,ends);
    thread14799(tdone,ends);
    thread14800(tdone,ends);
    thread14801(tdone,ends);
    thread14802(tdone,ends);
    thread14803(tdone,ends);
    thread14804(tdone,ends);
    thread14805(tdone,ends);
    thread14806(tdone,ends);
    thread14807(tdone,ends);
    thread14808(tdone,ends);
    thread14809(tdone,ends);
    thread14810(tdone,ends);
    thread14811(tdone,ends);
    thread14812(tdone,ends);
    thread14813(tdone,ends);
    thread14814(tdone,ends);
    thread14815(tdone,ends);
    thread14816(tdone,ends);
    thread14817(tdone,ends);
    thread14818(tdone,ends);
    int biggest14819 = 0;
    if(ends[23]>=biggest14819){
      biggest14819=ends[23];
    }
    if(ends[24]>=biggest14819){
      biggest14819=ends[24];
    }
    if(ends[25]>=biggest14819){
      biggest14819=ends[25];
    }
    if(ends[26]>=biggest14819){
      biggest14819=ends[26];
    }
    if(ends[27]>=biggest14819){
      biggest14819=ends[27];
    }
    if(ends[28]>=biggest14819){
      biggest14819=ends[28];
    }
    if(ends[29]>=biggest14819){
      biggest14819=ends[29];
    }
    if(ends[30]>=biggest14819){
      biggest14819=ends[30];
    }
    if(ends[31]>=biggest14819){
      biggest14819=ends[31];
    }
    if(ends[32]>=biggest14819){
      biggest14819=ends[32];
    }
    if(ends[33]>=biggest14819){
      biggest14819=ends[33];
    }
    if(ends[34]>=biggest14819){
      biggest14819=ends[34];
    }
    if(ends[35]>=biggest14819){
      biggest14819=ends[35];
    }
    if(ends[36]>=biggest14819){
      biggest14819=ends[36];
    }
    if(ends[37]>=biggest14819){
      biggest14819=ends[37];
    }
    if(ends[38]>=biggest14819){
      biggest14819=ends[38];
    }
    if(ends[39]>=biggest14819){
      biggest14819=ends[39];
    }
    if(ends[40]>=biggest14819){
      biggest14819=ends[40];
    }
    if(ends[41]>=biggest14819){
      biggest14819=ends[41];
    }
    if(ends[42]>=biggest14819){
      biggest14819=ends[42];
    }
    if(ends[43]>=biggest14819){
      biggest14819=ends[43];
    }
    if(ends[44]>=biggest14819){
      biggest14819=ends[44];
    }
    if(ends[45]>=biggest14819){
      biggest14819=ends[45];
    }
    if(ends[46]>=biggest14819){
      biggest14819=ends[46];
    }
    if(ends[47]>=biggest14819){
      biggest14819=ends[47];
    }
    if(ends[48]>=biggest14819){
      biggest14819=ends[48];
    }
    if(ends[49]>=biggest14819){
      biggest14819=ends[49];
    }
    if(ends[50]>=biggest14819){
      biggest14819=ends[50];
    }
    if(ends[51]>=biggest14819){
      biggest14819=ends[51];
    }
    if(ends[52]>=biggest14819){
      biggest14819=ends[52];
    }
    if(ends[53]>=biggest14819){
      biggest14819=ends[53];
    }
    if(ends[54]>=biggest14819){
      biggest14819=ends[54];
    }
    if(ends[55]>=biggest14819){
      biggest14819=ends[55];
    }
    if(ends[56]>=biggest14819){
      biggest14819=ends[56];
    }
    if(biggest14819 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread14783(int [] tdone, int [] ends){
        S6335=1;
    nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 328, column: 3
    S5908=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread14782(int [] tdone, int [] ends){
        S5883=1;
    S5812=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread14781(int [] tdone, int [] ends){
        S5789=1;
    S5788=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 301, column: 4
    currsigs.addElement(dosUnitEvac);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread14780(int [] tdone, int [] ends){
        S5599=1;
    S5564=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread14779(int [] tdone, int [] ends){
        S5553=1;
    S5482=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread14778(int [] tdone, int [] ends){
        S5459=1;
    S5388=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread14777(int [] tdone, int [] ends){
        S5365=1;
    S5294=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread14775(int [] tdone, int [] ends){
        switch(S3320){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S3074){
          case 0 : 
            S3074=0;
            S3074=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 233, column: 12
              rand_thread_14 = (int)(Math.random() * 100);//sysj\plant.sysj line: 234, column: 5
              System.out.println(rand_thread_14);//sysj\plant.sysj line: 235, column: 5
              S3040=0;
              if(rand_thread_14 < chance_thread_14){//sysj\plant.sysj line: 236, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 238, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S3040=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              S3074=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S3040){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 237, column: 12
                  S3040=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 238, column: 8
                  currsigs.addElement(capOnBottleAtPos1);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 242, column: 11
                  S3040=2;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 2 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 243, column: 11
                  S3074=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14774(int [] tdone, int [] ends){
        switch(S3038){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S2005){
          case 0 : 
            S2005=0;
            S2005=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 207, column: 13
              S1991=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                S2005=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S2005=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            break;
          
          case 1 : 
            if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 206, column: 10
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                S2005=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S2005=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              switch(S1991){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 208, column: 12
                    numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 209, column: 6
                    if(numTurns_thread_13 >= 2 && numTurns_thread_13 < 4){//sysj\plant.sysj line: 210, column: 9
                      l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 211, column: 7
                      currsigs.addElement(l_putBottleAt2_1);
                      if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                        numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                        S2005=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                      else {
                        S2005=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                    }
                    else {
                      if(numTurns_thread_13 >= 4 && numTurns_thread_13 < 10){//sysj\plant.sysj line: 212, column: 15
                        l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 213, column: 7
                        currsigs.addElement(l_putBottleAt4_1);
                        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                          S2005=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        else {
                          S2005=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                      }
                      else {
                        if(numTurns_thread_13 >= 10){//sysj\plant.sysj line: 214, column: 15
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 215, column: 7
                          l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 216, column: 7
                          currsigs.addElement(l_putBottleAt5_1);
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                            S2005=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S2005=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                        }
                        else {
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                            S2005=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S2005=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                        }
                      }
                    }
                  }
                  else {
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  break;
                
                case 1 : 
                  if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                    numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                    S2005=0;
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S2005=0;
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14773(int [] tdone, int [] ends){
        switch(S1980){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1957){
          case 0 : 
            S1957=0;
            S1957=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 193, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S1957=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 194, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 195, column: 5
              currsigs.addElement(bottleLeftPos5);
              S1957=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14772(int [] tdone, int [] ends){
        switch(S1950){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1885){
          case 0 : 
            S1885=0;
            S1885=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 181, column: 12
              S1872=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S1885=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt2_1.getprestatus())){//sysj\plant.sysj line: 182, column: 11
              S1885=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S1872){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 183, column: 12
                    S1872=1;
                    bottleAtPos2.setPresent();//sysj\plant.sysj line: 184, column: 6
                    currsigs.addElement(bottleAtPos2);
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                  else {
                    active[11]=1;
                    ends[11]=1;
                    tdone[11]=1;
                  }
                  break;
                
                case 1 : 
                  bottleAtPos2.setPresent();//sysj\plant.sysj line: 184, column: 6
                  currsigs.addElement(bottleAtPos2);
                  active[11]=1;
                  ends[11]=1;
                  tdone[11]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14771(int [] tdone, int [] ends){
        switch(S1864){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1799){
          case 0 : 
            S1799=0;
            S1799=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 169, column: 12
              S1786=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S1799=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt4_1.getprestatus())){//sysj\plant.sysj line: 170, column: 11
              S1799=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S1786){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 171, column: 12
                    S1786=1;
                    bottleAtPos4.setPresent();//sysj\plant.sysj line: 172, column: 6
                    currsigs.addElement(bottleAtPos4);
                    active[10]=1;
                    ends[10]=1;
                    tdone[10]=1;
                  }
                  else {
                    active[10]=1;
                    ends[10]=1;
                    tdone[10]=1;
                  }
                  break;
                
                case 1 : 
                  bottleAtPos4.setPresent();//sysj\plant.sysj line: 172, column: 6
                  currsigs.addElement(bottleAtPos4);
                  active[10]=1;
                  ends[10]=1;
                  tdone[10]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14770(int [] tdone, int [] ends){
        switch(S1778){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1743){
          case 0 : 
            S1743=0;
            S1743=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 158, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S1743=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt5_1.getprestatus()) || bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 159, column: 11
              S1743=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14769(int [] tdone, int [] ends){
        switch(S1732){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S1697){
          case 0 : 
            S1697=0;
            S1697=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S1697=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 148, column: 11
              S1697=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14768(int [] tdone, int [] ends){
        switch(S1686){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
        switch(S1654){
          case 0 : 
            S1654=0;
            S1654=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 136, column: 11
              S1654=2;
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 138, column: 6
              currsigs.addElement(bottleAtPos1);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 2 : 
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 137, column: 11
              S1654=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 138, column: 6
              currsigs.addElement(bottleAtPos1);
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14767(int [] tdone, int [] ends){
        switch(S1650){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 115, column: 12
          if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 116, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 117, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 119, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 120, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
              empty.setPresent();//sysj\plant.sysj line: 124, column: 6
              currsigs.addElement(empty);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
              empty.setPresent();//sysj\plant.sysj line: 124, column: 6
              currsigs.addElement(empty);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        else {
          if(refill.getprestatus()){//sysj\plant.sysj line: 119, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 120, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
              empty.setPresent();//sysj\plant.sysj line: 124, column: 6
              currsigs.addElement(empty);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
              empty.setPresent();//sysj\plant.sysj line: 124, column: 6
              currsigs.addElement(empty);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread14766(int [] tdone, int [] ends){
        switch(S1588){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1542){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 98, column: 10
              S1542=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1524){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 100, column: 13
                    S1524=1;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 1 : 
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 101, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 103, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 103, column: 7
                    S1524=2;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 104, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 105, column: 7
                    currsigs.addElement(capDec_1);
                    S1524=0;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
              }
            }
            break;
          
          case 1 : 
            if(refill.getprestatus()){//sysj\plant.sysj line: 108, column: 10
              S1542=0;
              S1524=0;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14765(int [] tdone, int [] ends){
        switch(S1520){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1490){
          case 0 : 
            switch(S1485){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 78, column: 12
                  S1485=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 81, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 82, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 82, column: 7
                    S1490=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1490=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S1490=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                    S1485=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1490=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S1490=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1490=1;
            S1490=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                S1485=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S1490=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S1490=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14764(int [] tdone, int [] ends){
        switch(S1476){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1430){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 62, column: 10
              S1430=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 65, column: 10
              S1430=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 67, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 66, column: 10
              S1430=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 67, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 69, column: 10
              S1430=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14763(int [] tdone, int [] ends){
        switch(S1423){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1377){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 49, column: 10
              S1377=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 50, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 52, column: 10
              S1377=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 54, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 53, column: 10
              S1377=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 54, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 56, column: 10
              S1377=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 50, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14761(int [] tdone, int [] ends){
        S3320=1;
    chance_thread_14 = 25;//sysj\plant.sysj line: 228, column: 3
        S3074=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread14760(int [] tdone, int [] ends){
        S3038=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 203, column: 3
    S2005=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread14759(int [] tdone, int [] ends){
        S1980=1;
    S1957=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread14758(int [] tdone, int [] ends){
        S1950=1;
    S1885=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread14757(int [] tdone, int [] ends){
        S1864=1;
    S1799=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread14756(int [] tdone, int [] ends){
        S1778=1;
    S1743=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread14755(int [] tdone, int [] ends){
        S1732=1;
    S1697=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread14754(int [] tdone, int [] ends){
        S1686=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
    S1654=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread14753(int [] tdone, int [] ends){
        S1650=1;
    capcount_thread_6 = 5;//sysj\plant.sysj line: 113, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 115, column: 12
      if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 116, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 117, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 119, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 120, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
          empty.setPresent();//sysj\plant.sysj line: 124, column: 6
          currsigs.addElement(empty);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
      else {
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
          empty.setPresent();//sysj\plant.sysj line: 124, column: 6
          currsigs.addElement(empty);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
    }
    else {
      if(refill.getprestatus()){//sysj\plant.sysj line: 119, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 120, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
          empty.setPresent();//sysj\plant.sysj line: 124, column: 6
          currsigs.addElement(empty);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
      else {
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
          empty.setPresent();//sysj\plant.sysj line: 124, column: 6
          currsigs.addElement(empty);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
    }
  }

  public void thread14752(int [] tdone, int [] ends){
        S1588=1;
    S1542=0;
    S1524=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread14751(int [] tdone, int [] ends){
        S1520=1;
    S1490=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
        S1485=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S1490=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S1490=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread14750(int [] tdone, int [] ends){
        S1476=1;
    S1430=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread14749(int [] tdone, int [] ends){
        S1423=1;
    S1377=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 50, column: 5
    currsigs.addElement(armAtDest);
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S14747){
        case 0 : 
          S14747=0;
          break RUN;
        
        case 1 : 
          S14747=2;
          S14747=2;
          class GUI extends Object implements java.lang.Runnable {//sysj\plant.sysj line: 34, column: 1
            public void run() {//sysj\plant.sysj line: 36, column: 21
              org.compsys704.CapLoader.main(null);//sysj\plant.sysj line: 37, column: 4
            }
            GUI(){//sysj\plant.sysj line: 35, column: 42
            }
          }
          new Thread(new GUI()).start();//sysj\plant.sysj line: 40, column: 2
          capDec_1.setClear();//sysj\plant.sysj line: 42, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 43, column: 2
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 44, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 44, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 44, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 45, column: 2
          capPos_1.setPresent();//sysj\plant.sysj line: 46, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\plant.sysj line: 46, column: 2
          S5271=0;
          thread14749(tdone,ends);
          thread14750(tdone,ends);
          thread14751(tdone,ends);
          thread14752(tdone,ends);
          thread14753(tdone,ends);
          thread14754(tdone,ends);
          thread14755(tdone,ends);
          thread14756(tdone,ends);
          thread14757(tdone,ends);
          thread14758(tdone,ends);
          thread14759(tdone,ends);
          thread14760(tdone,ends);
          thread14761(tdone,ends);
          int biggest14762 = 0;
          if(ends[2]>=biggest14762){
            biggest14762=ends[2];
          }
          if(ends[3]>=biggest14762){
            biggest14762=ends[3];
          }
          if(ends[4]>=biggest14762){
            biggest14762=ends[4];
          }
          if(ends[5]>=biggest14762){
            biggest14762=ends[5];
          }
          if(ends[6]>=biggest14762){
            biggest14762=ends[6];
          }
          if(ends[7]>=biggest14762){
            biggest14762=ends[7];
          }
          if(ends[8]>=biggest14762){
            biggest14762=ends[8];
          }
          if(ends[9]>=biggest14762){
            biggest14762=ends[9];
          }
          if(ends[10]>=biggest14762){
            biggest14762=ends[10];
          }
          if(ends[11]>=biggest14762){
            biggest14762=ends[11];
          }
          if(ends[12]>=biggest14762){
            biggest14762=ends[12];
          }
          if(ends[13]>=biggest14762){
            biggest14762=ends[13];
          }
          if(ends[14]>=biggest14762){
            biggest14762=ends[14];
          }
          if(biggest14762 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\plant.sysj line: 42, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 43, column: 2
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 44, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 44, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 44, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 45, column: 2
          switch(S5271){
            case 0 : 
              thread14763(tdone,ends);
              thread14764(tdone,ends);
              thread14765(tdone,ends);
              thread14766(tdone,ends);
              thread14767(tdone,ends);
              thread14768(tdone,ends);
              thread14769(tdone,ends);
              thread14770(tdone,ends);
              thread14771(tdone,ends);
              thread14772(tdone,ends);
              thread14773(tdone,ends);
              thread14774(tdone,ends);
              thread14775(tdone,ends);
              int biggest14776 = 0;
              if(ends[2]>=biggest14776){
                biggest14776=ends[2];
              }
              if(ends[3]>=biggest14776){
                biggest14776=ends[3];
              }
              if(ends[4]>=biggest14776){
                biggest14776=ends[4];
              }
              if(ends[5]>=biggest14776){
                biggest14776=ends[5];
              }
              if(ends[6]>=biggest14776){
                biggest14776=ends[6];
              }
              if(ends[7]>=biggest14776){
                biggest14776=ends[7];
              }
              if(ends[8]>=biggest14776){
                biggest14776=ends[8];
              }
              if(ends[9]>=biggest14776){
                biggest14776=ends[9];
              }
              if(ends[10]>=biggest14776){
                biggest14776=ends[10];
              }
              if(ends[11]>=biggest14776){
                biggest14776=ends[11];
              }
              if(ends[12]>=biggest14776){
                biggest14776=ends[12];
              }
              if(ends[13]>=biggest14776){
                biggest14776=ends[13];
              }
              if(ends[14]>=biggest14776){
                biggest14776=ends[14];
              }
              if(biggest14776 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest14776 == 0){
                S5271=1;
                thread14777(tdone,ends);
                thread14778(tdone,ends);
                thread14779(tdone,ends);
                thread14780(tdone,ends);
                thread14781(tdone,ends);
                thread14782(tdone,ends);
                thread14783(tdone,ends);
                thread14784(tdone,ends);
                int biggest14820 = 0;
                if(ends[15]>=biggest14820){
                  biggest14820=ends[15];
                }
                if(ends[16]>=biggest14820){
                  biggest14820=ends[16];
                }
                if(ends[17]>=biggest14820){
                  biggest14820=ends[17];
                }
                if(ends[18]>=biggest14820){
                  biggest14820=ends[18];
                }
                if(ends[19]>=biggest14820){
                  biggest14820=ends[19];
                }
                if(ends[20]>=biggest14820){
                  biggest14820=ends[20];
                }
                if(ends[21]>=biggest14820){
                  biggest14820=ends[21];
                }
                if(ends[22]>=biggest14820){
                  biggest14820=ends[22];
                }
                if(biggest14820 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              thread14821(tdone,ends);
              thread14822(tdone,ends);
              thread14823(tdone,ends);
              thread14824(tdone,ends);
              thread14825(tdone,ends);
              thread14826(tdone,ends);
              thread14827(tdone,ends);
              thread14828(tdone,ends);
              int biggest14864 = 0;
              if(ends[15]>=biggest14864){
                biggest14864=ends[15];
              }
              if(ends[16]>=biggest14864){
                biggest14864=ends[16];
              }
              if(ends[17]>=biggest14864){
                biggest14864=ends[17];
              }
              if(ends[18]>=biggest14864){
                biggest14864=ends[18];
              }
              if(ends[19]>=biggest14864){
                biggest14864=ends[19];
              }
              if(ends[20]>=biggest14864){
                biggest14864=ends[20];
              }
              if(ends[21]>=biggest14864){
                biggest14864=ends[21];
              }
              if(ends[22]>=biggest14864){
                biggest14864=ends[22];
              }
              if(biggest14864 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest14864 == 0){
                S14747=0;
                active[1]=0;
                ends[1]=0;
                S14747=0;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    capDec_1 = new Signal();
    l_bottleAdded_1 = new Signal();
    l_putBottleAt5_1 = new Signal();
    l_putBottleAt4_1 = new Signal();
    l_putBottleAt2_1 = new Signal();
    capPos_1 = new Signal();
    s_motConveyorOn_1 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          enable.gethook();
          refill.gethook();
          removeBottle.gethook();
          motConveyorOn.gethook();
          bottleAdded.gethook();
          putBottleAt5_FV.gethook();
          rotaryTableTrigger.gethook();
          cylPos5ZaxisExtend.gethook();
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          cylPos5ZAxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          valveInjectorOnOff.gethook();
          valveInletOnOff.gethook();
          dosUnitValveRetract.gethook();
          dosUnitValveExtend.gethook();
          selNoz1.gethook();
          selNoz2.gethook();
          selNoz3.gethook();
          selNoz4.gethook();
          turnNozTrigger.gethook();
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      refill.setpreclear();
      removeBottle.setpreclear();
      motConveyorOn.setpreclear();
      bottleAdded.setpreclear();
      putBottleAt5_FV.setpreclear();
      rotaryTableTrigger.setpreclear();
      cylPos5ZaxisExtend.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      selNoz1.setpreclear();
      selNoz2.setpreclear();
      selNoz3.setpreclear();
      selNoz4.setpreclear();
      turnNozTrigger.setpreclear();
      motConveyorOnE.setpreclear();
      bottleAtPos1.setpreclear();
      bottleAtPos1E.setpreclear();
      bottleAtPos5.setpreclear();
      bottleAtPos5_RT.setpreclear();
      bottleLeftPos5.setpreclear();
      bottleAtPos5E.setpreclear();
      bottleLeftPos5E.setpreclear();
      bottleAtPos2E.setpreclear();
      bottleAtPos4E.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos4.setpreclear();
      rotaryTableTriggerE.setpreclear();
      bottleAtPos1_RT.setpreclear();
      capOnBottleAtPos1E.setpreclear();
      capOnBottleAtPos1.setpreclear();
      cylPos5ZaxisExtendE.setpreclear();
      gripperTurnRetractE.setpreclear();
      gripperTurnExtendE.setpreclear();
      capGripperPos5ExtendE.setpreclear();
      cylClampBottleExtendE.setpreclear();
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      pusherRetractedE.setpreclear();
      pusherExtendedE.setpreclear();
      WPgrippedE.setpreclear();
      armAtSourceE.setpreclear();
      armAtDestE.setpreclear();
      emptyE.setpreclear();
      gripperZAxisLoweredE.setpreclear();
      gripperTurnFinalPosE.setpreclear();
      gripperTurnHomePosE.setpreclear();
      gripperZAxisLiftedE.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperTurnFinalPos.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperZAxisLifted.setpreclear();
      valveInjectorOnOffE.setpreclear();
      valveInletOnOffE.setpreclear();
      dosUnitValveRetractE.setpreclear();
      dosUnitValveExtendE.setpreclear();
      dosUnitFilledE.setpreclear();
      dosUnitEvacE.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      noz1.setpreclear();
      noz2.setpreclear();
      noz3.setpreclear();
      noz4.setpreclear();
      o_selNoz1.setpreclear();
      o_selNoz2.setpreclear();
      o_selNoz3.setpreclear();
      o_selNoz4.setpreclear();
      noz1E.setpreclear();
      noz2E.setpreclear();
      noz3E.setpreclear();
      noz4E.setpreclear();
      capDec_1.setpreclear();
      l_bottleAdded_1.setpreclear();
      l_putBottleAt5_1.setpreclear();
      l_putBottleAt4_1.setpreclear();
      l_putBottleAt2_1.setpreclear();
      capPos_1.setpreclear();
      s_motConveyorOn_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      dummyint = removeBottle.getStatus() ? removeBottle.setprepresent() : removeBottle.setpreclear();
      removeBottle.setpreval(removeBottle.getValue());
      removeBottle.setClear();
      dummyint = motConveyorOn.getStatus() ? motConveyorOn.setprepresent() : motConveyorOn.setpreclear();
      motConveyorOn.setpreval(motConveyorOn.getValue());
      motConveyorOn.setClear();
      dummyint = bottleAdded.getStatus() ? bottleAdded.setprepresent() : bottleAdded.setpreclear();
      bottleAdded.setpreval(bottleAdded.getValue());
      bottleAdded.setClear();
      dummyint = putBottleAt5_FV.getStatus() ? putBottleAt5_FV.setprepresent() : putBottleAt5_FV.setpreclear();
      putBottleAt5_FV.setpreval(putBottleAt5_FV.getValue());
      putBottleAt5_FV.setClear();
      dummyint = rotaryTableTrigger.getStatus() ? rotaryTableTrigger.setprepresent() : rotaryTableTrigger.setpreclear();
      rotaryTableTrigger.setpreval(rotaryTableTrigger.getValue());
      rotaryTableTrigger.setClear();
      dummyint = cylPos5ZaxisExtend.getStatus() ? cylPos5ZaxisExtend.setprepresent() : cylPos5ZaxisExtend.setpreclear();
      cylPos5ZaxisExtend.setpreval(cylPos5ZaxisExtend.getValue());
      cylPos5ZaxisExtend.setClear();
      dummyint = pusherExtend.getStatus() ? pusherExtend.setprepresent() : pusherExtend.setpreclear();
      pusherExtend.setpreval(pusherExtend.getValue());
      pusherExtend.setClear();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = cylPos5ZAxisExtend.getStatus() ? cylPos5ZAxisExtend.setprepresent() : cylPos5ZAxisExtend.setpreclear();
      cylPos5ZAxisExtend.setpreval(cylPos5ZAxisExtend.getValue());
      cylPos5ZAxisExtend.setClear();
      dummyint = gripperTurnRetract.getStatus() ? gripperTurnRetract.setprepresent() : gripperTurnRetract.setpreclear();
      gripperTurnRetract.setpreval(gripperTurnRetract.getValue());
      gripperTurnRetract.setClear();
      dummyint = gripperTurnExtend.getStatus() ? gripperTurnExtend.setprepresent() : gripperTurnExtend.setpreclear();
      gripperTurnExtend.setpreval(gripperTurnExtend.getValue());
      gripperTurnExtend.setClear();
      dummyint = capGripperPos5Extend.getStatus() ? capGripperPos5Extend.setprepresent() : capGripperPos5Extend.setpreclear();
      capGripperPos5Extend.setpreval(capGripperPos5Extend.getValue());
      capGripperPos5Extend.setClear();
      dummyint = cylClampBottleExtend.getStatus() ? cylClampBottleExtend.setprepresent() : cylClampBottleExtend.setpreclear();
      cylClampBottleExtend.setpreval(cylClampBottleExtend.getValue());
      cylClampBottleExtend.setClear();
      dummyint = valveInjectorOnOff.getStatus() ? valveInjectorOnOff.setprepresent() : valveInjectorOnOff.setpreclear();
      valveInjectorOnOff.setpreval(valveInjectorOnOff.getValue());
      valveInjectorOnOff.setClear();
      dummyint = valveInletOnOff.getStatus() ? valveInletOnOff.setprepresent() : valveInletOnOff.setpreclear();
      valveInletOnOff.setpreval(valveInletOnOff.getValue());
      valveInletOnOff.setClear();
      dummyint = dosUnitValveRetract.getStatus() ? dosUnitValveRetract.setprepresent() : dosUnitValveRetract.setpreclear();
      dosUnitValveRetract.setpreval(dosUnitValveRetract.getValue());
      dosUnitValveRetract.setClear();
      dummyint = dosUnitValveExtend.getStatus() ? dosUnitValveExtend.setprepresent() : dosUnitValveExtend.setpreclear();
      dosUnitValveExtend.setpreval(dosUnitValveExtend.getValue());
      dosUnitValveExtend.setClear();
      dummyint = selNoz1.getStatus() ? selNoz1.setprepresent() : selNoz1.setpreclear();
      selNoz1.setpreval(selNoz1.getValue());
      selNoz1.setClear();
      dummyint = selNoz2.getStatus() ? selNoz2.setprepresent() : selNoz2.setpreclear();
      selNoz2.setpreval(selNoz2.getValue());
      selNoz2.setClear();
      dummyint = selNoz3.getStatus() ? selNoz3.setprepresent() : selNoz3.setpreclear();
      selNoz3.setpreval(selNoz3.getValue());
      selNoz3.setClear();
      dummyint = selNoz4.getStatus() ? selNoz4.setprepresent() : selNoz4.setpreclear();
      selNoz4.setpreval(selNoz4.getValue());
      selNoz4.setClear();
      dummyint = turnNozTrigger.getStatus() ? turnNozTrigger.setprepresent() : turnNozTrigger.setpreclear();
      turnNozTrigger.setpreval(turnNozTrigger.getValue());
      turnNozTrigger.setClear();
      motConveyorOnE.sethook();
      motConveyorOnE.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      bottleAtPos1E.sethook();
      bottleAtPos1E.setClear();
      bottleAtPos5.sethook();
      bottleAtPos5.setClear();
      bottleAtPos5_RT.sethook();
      bottleAtPos5_RT.setClear();
      bottleLeftPos5.sethook();
      bottleLeftPos5.setClear();
      bottleAtPos5E.sethook();
      bottleAtPos5E.setClear();
      bottleLeftPos5E.sethook();
      bottleLeftPos5E.setClear();
      bottleAtPos2E.sethook();
      bottleAtPos2E.setClear();
      bottleAtPos4E.sethook();
      bottleAtPos4E.setClear();
      bottleAtPos2.sethook();
      bottleAtPos2.setClear();
      bottleAtPos4.sethook();
      bottleAtPos4.setClear();
      rotaryTableTriggerE.sethook();
      rotaryTableTriggerE.setClear();
      bottleAtPos1_RT.sethook();
      bottleAtPos1_RT.setClear();
      capOnBottleAtPos1E.sethook();
      capOnBottleAtPos1E.setClear();
      capOnBottleAtPos1.sethook();
      capOnBottleAtPos1.setClear();
      cylPos5ZaxisExtendE.sethook();
      cylPos5ZaxisExtendE.setClear();
      gripperTurnRetractE.sethook();
      gripperTurnRetractE.setClear();
      gripperTurnExtendE.sethook();
      gripperTurnExtendE.setClear();
      capGripperPos5ExtendE.sethook();
      capGripperPos5ExtendE.setClear();
      cylClampBottleExtendE.sethook();
      cylClampBottleExtendE.setClear();
      pusherRetracted.sethook();
      pusherRetracted.setClear();
      pusherExtended.sethook();
      pusherExtended.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      empty.sethook();
      empty.setClear();
      pusherRetractedE.sethook();
      pusherRetractedE.setClear();
      pusherExtendedE.sethook();
      pusherExtendedE.setClear();
      WPgrippedE.sethook();
      WPgrippedE.setClear();
      armAtSourceE.sethook();
      armAtSourceE.setClear();
      armAtDestE.sethook();
      armAtDestE.setClear();
      emptyE.sethook();
      emptyE.setClear();
      gripperZAxisLoweredE.sethook();
      gripperZAxisLoweredE.setClear();
      gripperTurnFinalPosE.sethook();
      gripperTurnFinalPosE.setClear();
      gripperTurnHomePosE.sethook();
      gripperTurnHomePosE.setClear();
      gripperZAxisLiftedE.sethook();
      gripperZAxisLiftedE.setClear();
      gripperZAxisLowered.sethook();
      gripperZAxisLowered.setClear();
      gripperTurnFinalPos.sethook();
      gripperTurnFinalPos.setClear();
      gripperTurnHomePos.sethook();
      gripperTurnHomePos.setClear();
      gripperZAxisLifted.sethook();
      gripperZAxisLifted.setClear();
      valveInjectorOnOffE.sethook();
      valveInjectorOnOffE.setClear();
      valveInletOnOffE.sethook();
      valveInletOnOffE.setClear();
      dosUnitValveRetractE.sethook();
      dosUnitValveRetractE.setClear();
      dosUnitValveExtendE.sethook();
      dosUnitValveExtendE.setClear();
      dosUnitFilledE.sethook();
      dosUnitFilledE.setClear();
      dosUnitEvacE.sethook();
      dosUnitEvacE.setClear();
      dosUnitEvac.sethook();
      dosUnitEvac.setClear();
      dosUnitFilled.sethook();
      dosUnitFilled.setClear();
      noz1.sethook();
      noz1.setClear();
      noz2.sethook();
      noz2.setClear();
      noz3.sethook();
      noz3.setClear();
      noz4.sethook();
      noz4.setClear();
      o_selNoz1.sethook();
      o_selNoz1.setClear();
      o_selNoz2.sethook();
      o_selNoz2.setClear();
      o_selNoz3.sethook();
      o_selNoz3.setClear();
      o_selNoz4.sethook();
      o_selNoz4.setClear();
      noz1E.sethook();
      noz1E.setClear();
      noz2E.sethook();
      noz2E.setClear();
      noz3E.sethook();
      noz3E.setClear();
      noz4E.sethook();
      noz4E.setClear();
      capDec_1.setClear();
      l_bottleAdded_1.setClear();
      l_putBottleAt5_1.setClear();
      l_putBottleAt4_1.setClear();
      l_putBottleAt2_1.setClear();
      capPos_1.setClear();
      s_motConveyorOn_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        refill.gethook();
        removeBottle.gethook();
        motConveyorOn.gethook();
        bottleAdded.gethook();
        putBottleAt5_FV.gethook();
        rotaryTableTrigger.gethook();
        cylPos5ZaxisExtend.gethook();
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        cylPos5ZAxisExtend.gethook();
        gripperTurnRetract.gethook();
        gripperTurnExtend.gethook();
        capGripperPos5Extend.gethook();
        cylClampBottleExtend.gethook();
        valveInjectorOnOff.gethook();
        valveInletOnOff.gethook();
        dosUnitValveRetract.gethook();
        dosUnitValveExtend.gethook();
        selNoz1.gethook();
        selNoz2.gethook();
        selNoz3.gethook();
        selNoz4.gethook();
        turnNozTrigger.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
