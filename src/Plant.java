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
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.OUTPUT);
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
  private Integer chance_thread_14;//sysj\plant.sysj line: 231, column: 3
  private Integer rand_thread_14;//sysj\plant.sysj line: 232, column: 3
  private int nozzlenum_thread_21;//sysj\plant.sysj line: 333, column: 3
  private int S17949 = 1;
  private int S1737 = 1;
  private int S1691 = 1;
  private int S1790 = 1;
  private int S1744 = 1;
  private int S1834 = 1;
  private int S1804 = 1;
  private int S1799 = 1;
  private int S1902 = 1;
  private int S1856 = 1;
  private int S1838 = 1;
  private int S1964 = 1;
  private int S2000 = 1;
  private int S1968 = 1;
  private int S2046 = 1;
  private int S2011 = 1;
  private int S2092 = 1;
  private int S2057 = 1;
  private int S2178 = 1;
  private int S2113 = 1;
  private int S2100 = 1;
  private int S2264 = 1;
  private int S2199 = 1;
  private int S2186 = 1;
  private int S2294 = 1;
  private int S2271 = 1;
  private int S4074 = 1;
  private int S2421 = 1;
  private int S2296 = 1;
  private int S2326 = 1;
  private int S2325 = 1;
  private int S4356 = 1;
  private int S4110 = 1;
  private int S4076 = 1;
  private int S4450 = 1;
  private int S4379 = 1;
  private int S4366 = 1;
  private int S4544 = 1;
  private int S4473 = 1;
  private int S4460 = 1;
  private int S4638 = 1;
  private int S4567 = 1;
  private int S4554 = 1;
  private int S4684 = 1;
  private int S4649 = 1;
  private int S4874 = 1;
  private int S4873 = 1;
  private int S4711 = 1;
  private int S4698 = 1;
  private int S4968 = 1;
  private int S4897 = 1;
  private int S4884 = 1;
  private int S5420 = 1;
  private int S4993 = 1;
  private int S4979 = 1;
  private int S5748 = 1;
  private int S5428 = 1;
  private int S5436 = 1;
  private int S5444 = 1;
  private int S5464 = 1;
  private int S5450 = 1;
  private int S5448 = 1;
  private int S5472 = 1;
  private int S5510 = 1;
  private int S5484 = 1;
  private int S5482 = 1;
  private int S5530 = 1;
  private int S5516 = 1;
  private int S5514 = 1;
  private int S5538 = 1;
  private int S5546 = 1;
  private int S5554 = 1;
  private int S5562 = 1;
  private int S5570 = 1;
  private int S5578 = 1;
  private int S5586 = 1;
  private int S5594 = 1;
  private int S5602 = 1;
  private int S5610 = 1;
  private int S5618 = 1;
  private int S5626 = 1;
  private int S5634 = 1;
  private int S5642 = 1;
  private int S5650 = 1;
  private int S5658 = 1;
  private int S5666 = 1;
  private int S5674 = 1;
  private int S5682 = 1;
  private int S5690 = 1;
  private int S5698 = 1;
  private int S5706 = 1;
  private int S5714 = 1;
  private int S5722 = 1;
  private int S5730 = 1;
  private int S5738 = 1;
  private int S5746 = 1;
  
  private int[] ends = new int[57];
  private int[] tdone = new int[57];
  
  public void thread18062(int [] tdone, int [] ends){
        switch(S5746){
      case 0 : 
        active[56]=0;
        ends[56]=0;
        tdone[56]=1;
        break;
      
      case 1 : 
        if(noz4.getprestatus()){//sysj\plant.sysj line: 446, column: 25
          noz4E.setPresent();//sysj\plant.sysj line: 446, column: 31
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

  public void thread18061(int [] tdone, int [] ends){
        switch(S5738){
      case 0 : 
        active[55]=0;
        ends[55]=0;
        tdone[55]=1;
        break;
      
      case 1 : 
        if(noz3.getprestatus()){//sysj\plant.sysj line: 444, column: 25
          noz3E.setPresent();//sysj\plant.sysj line: 444, column: 31
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

  public void thread18060(int [] tdone, int [] ends){
        switch(S5730){
      case 0 : 
        active[54]=0;
        ends[54]=0;
        tdone[54]=1;
        break;
      
      case 1 : 
        if(noz2.getprestatus()){//sysj\plant.sysj line: 442, column: 25
          noz2E.setPresent();//sysj\plant.sysj line: 442, column: 31
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

  public void thread18059(int [] tdone, int [] ends){
        switch(S5722){
      case 0 : 
        active[53]=0;
        ends[53]=0;
        tdone[53]=1;
        break;
      
      case 1 : 
        if(noz1.getprestatus()){//sysj\plant.sysj line: 440, column: 25
          noz1E.setPresent();//sysj\plant.sysj line: 440, column: 31
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

  public void thread18058(int [] tdone, int [] ends){
        switch(S5714){
      case 0 : 
        active[52]=0;
        ends[52]=0;
        tdone[52]=1;
        break;
      
      case 1 : 
        if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 438, column: 25
          capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 438, column: 44
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

  public void thread18057(int [] tdone, int [] ends){
        switch(S5706){
      case 0 : 
        active[51]=0;
        ends[51]=0;
        tdone[51]=1;
        break;
      
      case 1 : 
        if(selNoz4.getprestatus()){//sysj\plant.sysj line: 436, column: 25
          o_selNoz4.setPresent();//sysj\plant.sysj line: 436, column: 34
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

  public void thread18056(int [] tdone, int [] ends){
        switch(S5698){
      case 0 : 
        active[50]=0;
        ends[50]=0;
        tdone[50]=1;
        break;
      
      case 1 : 
        if(selNoz3.getprestatus()){//sysj\plant.sysj line: 434, column: 25
          o_selNoz3.setPresent();//sysj\plant.sysj line: 434, column: 34
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

  public void thread18055(int [] tdone, int [] ends){
        switch(S5690){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(selNoz2.getprestatus()){//sysj\plant.sysj line: 432, column: 25
          o_selNoz2.setPresent();//sysj\plant.sysj line: 432, column: 34
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

  public void thread18054(int [] tdone, int [] ends){
        switch(S5682){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(selNoz1.getprestatus()){//sysj\plant.sysj line: 430, column: 25
          o_selNoz1.setPresent();//sysj\plant.sysj line: 430, column: 34
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

  public void thread18053(int [] tdone, int [] ends){
        switch(S5674){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 427, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 427, column: 40
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

  public void thread18052(int [] tdone, int [] ends){
        switch(S5666){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 425, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 425, column: 38
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

  public void thread18051(int [] tdone, int [] ends){
        switch(S5658){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 423, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 423, column: 39
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

  public void thread18050(int [] tdone, int [] ends){
        switch(S5650){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 421, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 421, column: 45
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

  public void thread18049(int [] tdone, int [] ends){
        switch(S5642){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 419, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 419, column: 46
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

  public void thread18048(int [] tdone, int [] ends){
        switch(S5634){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 417, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 417, column: 42
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

  public void thread18047(int [] tdone, int [] ends){
        switch(S5626){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 415, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 415, column: 45
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

  public void thread18046(int [] tdone, int [] ends){
        switch(S5618){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 412, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 412, column: 47
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

  public void thread18045(int [] tdone, int [] ends){
        switch(S5610){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 410, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 410, column: 47
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

  public void thread18044(int [] tdone, int [] ends){
        switch(S5602){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 408, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 408, column: 44
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

  public void thread18043(int [] tdone, int [] ends){
        switch(S5594){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 406, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 406, column: 45
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

  public void thread18042(int [] tdone, int [] ends){
        switch(S5586){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 404, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 404, column: 45
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

  public void thread18041(int [] tdone, int [] ends){
        switch(S5578){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 402, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 402, column: 45
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

  public void thread18040(int [] tdone, int [] ends){
        switch(S5570){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 399, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 399, column: 45
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

  public void thread18039(int [] tdone, int [] ends){
        switch(S5562){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 397, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 397, column: 46
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

  public void thread18038(int [] tdone, int [] ends){
        switch(S5554){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 395, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 395, column: 46
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

  public void thread18037(int [] tdone, int [] ends){
        switch(S5546){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 393, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 393, column: 38
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

  public void thread18036(int [] tdone, int [] ends){
        switch(S5538){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 391, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 391, column: 38
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

  public void thread18035(int [] tdone, int [] ends){
        switch(S5530){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S5516){
          case 0 : 
            switch(S5514){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 389, column: 54
                  S5514=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 389, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 389, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  S5516=1;
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
            S5516=1;
            S5516=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 389, column: 24
              S5514=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S5516=1;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18034(int [] tdone, int [] ends){
        switch(S5510){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S5484){
          case 0 : 
            switch(S5482){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 380, column: 11
                  S5482=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 382, column: 6
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 381, column: 11
                  S5484=1;
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 382, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S5484=1;
            S5484=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 379, column: 12
              S5482=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S5484=1;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18033(int [] tdone, int [] ends){
        switch(S5472){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 376, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 376, column: 56
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

  public void thread18032(int [] tdone, int [] ends){
        switch(S5464){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S5450){
          case 0 : 
            switch(S5448){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 374, column: 54
                  S5448=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 374, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 374, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  S5450=1;
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
            S5450=1;
            S5450=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 374, column: 24
              S5448=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S5450=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18031(int [] tdone, int [] ends){
        switch(S5444){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 372, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 372, column: 44
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

  public void thread18030(int [] tdone, int [] ends){
        switch(S5436){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 370, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 370, column: 39
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

  public void thread18029(int [] tdone, int [] ends){
        switch(S5428){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 368, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 368, column: 38
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

  public void thread18028(int [] tdone, int [] ends){
        switch(S5748){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        thread18029(tdone,ends);
        thread18030(tdone,ends);
        thread18031(tdone,ends);
        thread18032(tdone,ends);
        thread18033(tdone,ends);
        thread18034(tdone,ends);
        thread18035(tdone,ends);
        thread18036(tdone,ends);
        thread18037(tdone,ends);
        thread18038(tdone,ends);
        thread18039(tdone,ends);
        thread18040(tdone,ends);
        thread18041(tdone,ends);
        thread18042(tdone,ends);
        thread18043(tdone,ends);
        thread18044(tdone,ends);
        thread18045(tdone,ends);
        thread18046(tdone,ends);
        thread18047(tdone,ends);
        thread18048(tdone,ends);
        thread18049(tdone,ends);
        thread18050(tdone,ends);
        thread18051(tdone,ends);
        thread18052(tdone,ends);
        thread18053(tdone,ends);
        thread18054(tdone,ends);
        thread18055(tdone,ends);
        thread18056(tdone,ends);
        thread18057(tdone,ends);
        thread18058(tdone,ends);
        thread18059(tdone,ends);
        thread18060(tdone,ends);
        thread18061(tdone,ends);
        thread18062(tdone,ends);
        int biggest18063 = 0;
        if(ends[23]>=biggest18063){
          biggest18063=ends[23];
        }
        if(ends[24]>=biggest18063){
          biggest18063=ends[24];
        }
        if(ends[25]>=biggest18063){
          biggest18063=ends[25];
        }
        if(ends[26]>=biggest18063){
          biggest18063=ends[26];
        }
        if(ends[27]>=biggest18063){
          biggest18063=ends[27];
        }
        if(ends[28]>=biggest18063){
          biggest18063=ends[28];
        }
        if(ends[29]>=biggest18063){
          biggest18063=ends[29];
        }
        if(ends[30]>=biggest18063){
          biggest18063=ends[30];
        }
        if(ends[31]>=biggest18063){
          biggest18063=ends[31];
        }
        if(ends[32]>=biggest18063){
          biggest18063=ends[32];
        }
        if(ends[33]>=biggest18063){
          biggest18063=ends[33];
        }
        if(ends[34]>=biggest18063){
          biggest18063=ends[34];
        }
        if(ends[35]>=biggest18063){
          biggest18063=ends[35];
        }
        if(ends[36]>=biggest18063){
          biggest18063=ends[36];
        }
        if(ends[37]>=biggest18063){
          biggest18063=ends[37];
        }
        if(ends[38]>=biggest18063){
          biggest18063=ends[38];
        }
        if(ends[39]>=biggest18063){
          biggest18063=ends[39];
        }
        if(ends[40]>=biggest18063){
          biggest18063=ends[40];
        }
        if(ends[41]>=biggest18063){
          biggest18063=ends[41];
        }
        if(ends[42]>=biggest18063){
          biggest18063=ends[42];
        }
        if(ends[43]>=biggest18063){
          biggest18063=ends[43];
        }
        if(ends[44]>=biggest18063){
          biggest18063=ends[44];
        }
        if(ends[45]>=biggest18063){
          biggest18063=ends[45];
        }
        if(ends[46]>=biggest18063){
          biggest18063=ends[46];
        }
        if(ends[47]>=biggest18063){
          biggest18063=ends[47];
        }
        if(ends[48]>=biggest18063){
          biggest18063=ends[48];
        }
        if(ends[49]>=biggest18063){
          biggest18063=ends[49];
        }
        if(ends[50]>=biggest18063){
          biggest18063=ends[50];
        }
        if(ends[51]>=biggest18063){
          biggest18063=ends[51];
        }
        if(ends[52]>=biggest18063){
          biggest18063=ends[52];
        }
        if(ends[53]>=biggest18063){
          biggest18063=ends[53];
        }
        if(ends[54]>=biggest18063){
          biggest18063=ends[54];
        }
        if(ends[55]>=biggest18063){
          biggest18063=ends[55];
        }
        if(ends[56]>=biggest18063){
          biggest18063=ends[56];
        }
        if(biggest18063 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest18063 == 0){
          S5748=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread18027(int [] tdone, int [] ends){
        switch(S5420){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S4993){
          case 0 : 
            S4993=0;
            S4993=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 337, column: 13
              S4979=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S4993=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if(!turnNozTrigger.getprestatus()){//sysj\plant.sysj line: 336, column: 10
              S4993=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              switch(S4979){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 338, column: 12
                    nozzlenum_thread_21 = nozzlenum_thread_21 + 1;//sysj\plant.sysj line: 339, column: 6
                    if(nozzlenum_thread_21 == 1){//sysj\plant.sysj line: 340, column: 9
                      noz1.setPresent();//sysj\plant.sysj line: 341, column: 7
                      currsigs.addElement(noz1);
                      S4993=0;
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      if(nozzlenum_thread_21 == 2){//sysj\plant.sysj line: 342, column: 15
                        noz2.setPresent();//sysj\plant.sysj line: 343, column: 7
                        currsigs.addElement(noz2);
                        S4993=0;
                        active[21]=1;
                        ends[21]=1;
                        tdone[21]=1;
                      }
                      else {
                        if(nozzlenum_thread_21 == 3){//sysj\plant.sysj line: 344, column: 15
                          noz3.setPresent();//sysj\plant.sysj line: 345, column: 7
                          currsigs.addElement(noz3);
                          S4993=0;
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                        else {
                          noz4.setPresent();//sysj\plant.sysj line: 347, column: 7
                          currsigs.addElement(noz4);
                          nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 348, column: 7
                          S4993=0;
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
                  S4993=0;
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

  public void thread18026(int [] tdone, int [] ends){
        switch(S4968){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S4897){
          case 0 : 
            S4897=0;
            S4897=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 322, column: 12
              S4884=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S4897=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S4884){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 323, column: 11
                  S4884=1;
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 325, column: 6
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
                if(!dosUnitValveRetract.getprestatus() && dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 324, column: 11
                  S4897=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 325, column: 6
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

  public void thread18025(int [] tdone, int [] ends){
        switch(S4874){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S4873){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 305, column: 9
              S4873=1;
              S4711=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 306, column: 4
              currsigs.addElement(dosUnitEvac);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S4711){
              case 0 : 
                S4711=0;
                S4711=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 310, column: 12
                  S4698=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S4711=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                switch(S4698){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 311, column: 11
                      S4698=1;
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 313, column: 6
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
                    if(!dosUnitValveExtend.getprestatus() && dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 312, column: 11
                      S4711=0;
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 313, column: 6
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

  public void thread18024(int [] tdone, int [] ends){
        switch(S4684){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S4649){
          case 0 : 
            S4649=0;
            S4649=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 292, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 294, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S4649=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 293, column: 11
              S4649=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 294, column: 6
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

  public void thread18023(int [] tdone, int [] ends){
        switch(S4638){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S4567){
          case 0 : 
            S4567=0;
            S4567=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 280, column: 12
              S4554=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S4567=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S4554){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 281, column: 11
                  S4554=1;
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 283, column: 6
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
                if(!gripperTurnRetract.getprestatus() && gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 282, column: 11
                  S4567=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 283, column: 6
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

  public void thread18022(int [] tdone, int [] ends){
        switch(S4544){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S4473){
          case 0 : 
            S4473=0;
            S4473=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 268, column: 12
              S4460=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S4473=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S4460){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 269, column: 11
                  S4460=1;
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 271, column: 6
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
                if(!gripperTurnExtend.getprestatus() && gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 270, column: 11
                  S4473=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 271, column: 6
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

  public void thread18021(int [] tdone, int [] ends){
        switch(S4450){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S4379){
          case 0 : 
            S4379=0;
            S4379=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 256, column: 12
              S4366=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S4379=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S4366){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 257, column: 11
                  S4366=1;
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 259, column: 6
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
                if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 258, column: 11
                  S4379=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 259, column: 6
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

  public void thread18020(int [] tdone, int [] ends){
        switch(S4356){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S4110){
          case 0 : 
            S4110=0;
            S4110=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 236, column: 12
              rand_thread_14 = (int)(Math.random() * 100);//sysj\plant.sysj line: 237, column: 5
              System.out.println(rand_thread_14);//sysj\plant.sysj line: 238, column: 5
              S4076=0;
              if(rand_thread_14 < chance_thread_14){//sysj\plant.sysj line: 239, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 241, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S4076=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              S4110=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S4076){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 240, column: 12
                  S4076=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 241, column: 8
                  currsigs.addElement(capOnBottleAtPos1);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 245, column: 11
                  S4076=2;
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
                if(!enable.getprestatus()){//sysj\plant.sysj line: 246, column: 11
                  S4110=0;
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

  public void thread18019(int [] tdone, int [] ends){
        switch(S4074){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S2421){
          case 0 : 
            S2421=0;
            S2421=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 206, column: 12
              S2296=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S2421=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            switch(S2296){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 207, column: 11
                  numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 208, column: 5
                  S2296=1;
                  if(numTurns_thread_13 >= 2 && numTurns_thread_13 < 3){//sysj\plant.sysj line: 209, column: 8
                    S2326=0;
                    l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 210, column: 6
                    currsigs.addElement(l_putBottleAt2_1);
                    tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 212, column: 7
                    currsigs.addElement(tableAlignedWithSensor);
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S2326=1;
                    if(numTurns_thread_13 >= 3 && numTurns_thread_13 < 4){//sysj\plant.sysj line: 214, column: 14
                      S2325=0;
                      l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 215, column: 6
                      currsigs.addElement(l_putBottleAt4_1);
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 217, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      active[13]=1;
                      ends[13]=1;
                      tdone[13]=1;
                    }
                    else {
                      S2325=1;
                      if(numTurns_thread_13 >= 4){//sysj\plant.sysj line: 219, column: 14
                        numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 6
                        l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 221, column: 6
                        currsigs.addElement(l_putBottleAt5_1);
                        tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 223, column: 7
                        currsigs.addElement(tableAlignedWithSensor);
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                      else {
                        S2421=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
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
                switch(S2326){
                  case 0 : 
                    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                      S2421=0;
                      active[13]=1;
                      ends[13]=1;
                      tdone[13]=1;
                    }
                    else {
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 212, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      active[13]=1;
                      ends[13]=1;
                      tdone[13]=1;
                    }
                    break;
                  
                  case 1 : 
                    switch(S2325){
                      case 0 : 
                        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 216, column: 12
                          S2421=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        else {
                          tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 217, column: 7
                          currsigs.addElement(tableAlignedWithSensor);
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        break;
                      
                      case 1 : 
                        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 222, column: 12
                          S2421=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        else {
                          tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 223, column: 7
                          currsigs.addElement(tableAlignedWithSensor);
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        break;
                      
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

  public void thread18018(int [] tdone, int [] ends){
        switch(S2294){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S2271){
          case 0 : 
            S2271=0;
            S2271=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 193, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S2271=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 194, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 195, column: 5
              currsigs.addElement(bottleLeftPos5);
              S2271=0;
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

  public void thread18017(int [] tdone, int [] ends){
        switch(S2264){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S2199){
          case 0 : 
            S2199=0;
            S2199=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 181, column: 12
              S2186=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S2199=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos4.getprestatus())){//sysj\plant.sysj line: 182, column: 11
              S2199=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S2186){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 183, column: 12
                    S2186=1;
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

  public void thread18016(int [] tdone, int [] ends){
        switch(S2178){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S2113){
          case 0 : 
            S2113=0;
            S2113=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 169, column: 12
              S2100=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S2113=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos5.getprestatus())){//sysj\plant.sysj line: 170, column: 11
              S2113=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S2100){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 171, column: 12
                    S2100=1;
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

  public void thread18015(int [] tdone, int [] ends){
        switch(S2092){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S2057){
          case 0 : 
            S2057=0;
            S2057=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 158, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S2057=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 159, column: 11
              S2057=0;
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

  public void thread18014(int [] tdone, int [] ends){
        switch(S2046){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2011){
          case 0 : 
            S2011=0;
            S2011=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S2011=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 148, column: 11
              S2011=0;
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

  public void thread18013(int [] tdone, int [] ends){
        switch(S2000){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
        switch(S1968){
          case 0 : 
            S1968=0;
            S1968=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 136, column: 11
              S1968=2;
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
              S1968=0;
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

  public void thread18012(int [] tdone, int [] ends){
        switch(S1964){
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

  public void thread18011(int [] tdone, int [] ends){
        switch(S1902){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1856){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 98, column: 10
              S1856=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1838){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 100, column: 13
                    S1838=1;
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
                    S1838=2;
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
                    S1838=0;
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
              S1856=0;
              S1838=0;
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

  public void thread18010(int [] tdone, int [] ends){
        switch(S1834){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1804){
          case 0 : 
            switch(S1799){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 78, column: 12
                  S1799=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 81, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 82, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 82, column: 7
                    S1804=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1804=1;
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
                S1804=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                    S1799=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1804=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S1804=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1804=1;
            S1804=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                S1799=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S1804=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S1804=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18009(int [] tdone, int [] ends){
        switch(S1790){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1744){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 62, column: 10
              S1744=1;
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
              S1744=2;
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
              S1744=3;
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
              S1744=0;
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

  public void thread18008(int [] tdone, int [] ends){
        switch(S1737){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1691){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 49, column: 10
              S1691=1;
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
              S1691=2;
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
              S1691=3;
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
              S1691=0;
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

  public void thread18005(int [] tdone, int [] ends){
        S5746=1;
    if(noz4.getprestatus()){//sysj\plant.sysj line: 446, column: 25
      noz4E.setPresent();//sysj\plant.sysj line: 446, column: 31
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

  public void thread18004(int [] tdone, int [] ends){
        S5738=1;
    if(noz3.getprestatus()){//sysj\plant.sysj line: 444, column: 25
      noz3E.setPresent();//sysj\plant.sysj line: 444, column: 31
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

  public void thread18003(int [] tdone, int [] ends){
        S5730=1;
    if(noz2.getprestatus()){//sysj\plant.sysj line: 442, column: 25
      noz2E.setPresent();//sysj\plant.sysj line: 442, column: 31
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

  public void thread18002(int [] tdone, int [] ends){
        S5722=1;
    if(noz1.getprestatus()){//sysj\plant.sysj line: 440, column: 25
      noz1E.setPresent();//sysj\plant.sysj line: 440, column: 31
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

  public void thread18001(int [] tdone, int [] ends){
        S5714=1;
    if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 438, column: 25
      capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 438, column: 44
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

  public void thread18000(int [] tdone, int [] ends){
        S5706=1;
    if(selNoz4.getprestatus()){//sysj\plant.sysj line: 436, column: 25
      o_selNoz4.setPresent();//sysj\plant.sysj line: 436, column: 34
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

  public void thread17999(int [] tdone, int [] ends){
        S5698=1;
    if(selNoz3.getprestatus()){//sysj\plant.sysj line: 434, column: 25
      o_selNoz3.setPresent();//sysj\plant.sysj line: 434, column: 34
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

  public void thread17998(int [] tdone, int [] ends){
        S5690=1;
    if(selNoz2.getprestatus()){//sysj\plant.sysj line: 432, column: 25
      o_selNoz2.setPresent();//sysj\plant.sysj line: 432, column: 34
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

  public void thread17997(int [] tdone, int [] ends){
        S5682=1;
    if(selNoz1.getprestatus()){//sysj\plant.sysj line: 430, column: 25
      o_selNoz1.setPresent();//sysj\plant.sysj line: 430, column: 34
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

  public void thread17996(int [] tdone, int [] ends){
        S5674=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 427, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 427, column: 40
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

  public void thread17995(int [] tdone, int [] ends){
        S5666=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 425, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 425, column: 38
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

  public void thread17994(int [] tdone, int [] ends){
        S5658=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 423, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 423, column: 39
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

  public void thread17993(int [] tdone, int [] ends){
        S5650=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 421, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 421, column: 45
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

  public void thread17992(int [] tdone, int [] ends){
        S5642=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 419, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 419, column: 46
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

  public void thread17991(int [] tdone, int [] ends){
        S5634=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 417, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 417, column: 42
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

  public void thread17990(int [] tdone, int [] ends){
        S5626=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 415, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 415, column: 45
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

  public void thread17989(int [] tdone, int [] ends){
        S5618=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 412, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 412, column: 47
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

  public void thread17988(int [] tdone, int [] ends){
        S5610=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 410, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 410, column: 47
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

  public void thread17987(int [] tdone, int [] ends){
        S5602=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 408, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 408, column: 44
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

  public void thread17986(int [] tdone, int [] ends){
        S5594=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 406, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 406, column: 45
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

  public void thread17985(int [] tdone, int [] ends){
        S5586=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 404, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 404, column: 45
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

  public void thread17984(int [] tdone, int [] ends){
        S5578=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 402, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 402, column: 45
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

  public void thread17983(int [] tdone, int [] ends){
        S5570=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 399, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 399, column: 45
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

  public void thread17982(int [] tdone, int [] ends){
        S5562=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 397, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 397, column: 46
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

  public void thread17981(int [] tdone, int [] ends){
        S5554=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 395, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 395, column: 46
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

  public void thread17980(int [] tdone, int [] ends){
        S5546=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 393, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 393, column: 38
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

  public void thread17979(int [] tdone, int [] ends){
        S5538=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 391, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 391, column: 38
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

  public void thread17978(int [] tdone, int [] ends){
        S5530=1;
    S5516=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 389, column: 24
      S5514=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S5516=1;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread17977(int [] tdone, int [] ends){
        S5510=1;
    S5484=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 379, column: 12
      S5482=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      S5484=1;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread17976(int [] tdone, int [] ends){
        S5472=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 376, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 376, column: 56
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

  public void thread17975(int [] tdone, int [] ends){
        S5464=1;
    S5450=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 374, column: 24
      S5448=0;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      S5450=1;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread17974(int [] tdone, int [] ends){
        S5444=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 372, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 372, column: 44
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

  public void thread17973(int [] tdone, int [] ends){
        S5436=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 370, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 370, column: 39
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

  public void thread17972(int [] tdone, int [] ends){
        S5428=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 368, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 368, column: 38
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

  public void thread17971(int [] tdone, int [] ends){
        S5748=1;
    thread17972(tdone,ends);
    thread17973(tdone,ends);
    thread17974(tdone,ends);
    thread17975(tdone,ends);
    thread17976(tdone,ends);
    thread17977(tdone,ends);
    thread17978(tdone,ends);
    thread17979(tdone,ends);
    thread17980(tdone,ends);
    thread17981(tdone,ends);
    thread17982(tdone,ends);
    thread17983(tdone,ends);
    thread17984(tdone,ends);
    thread17985(tdone,ends);
    thread17986(tdone,ends);
    thread17987(tdone,ends);
    thread17988(tdone,ends);
    thread17989(tdone,ends);
    thread17990(tdone,ends);
    thread17991(tdone,ends);
    thread17992(tdone,ends);
    thread17993(tdone,ends);
    thread17994(tdone,ends);
    thread17995(tdone,ends);
    thread17996(tdone,ends);
    thread17997(tdone,ends);
    thread17998(tdone,ends);
    thread17999(tdone,ends);
    thread18000(tdone,ends);
    thread18001(tdone,ends);
    thread18002(tdone,ends);
    thread18003(tdone,ends);
    thread18004(tdone,ends);
    thread18005(tdone,ends);
    int biggest18006 = 0;
    if(ends[23]>=biggest18006){
      biggest18006=ends[23];
    }
    if(ends[24]>=biggest18006){
      biggest18006=ends[24];
    }
    if(ends[25]>=biggest18006){
      biggest18006=ends[25];
    }
    if(ends[26]>=biggest18006){
      biggest18006=ends[26];
    }
    if(ends[27]>=biggest18006){
      biggest18006=ends[27];
    }
    if(ends[28]>=biggest18006){
      biggest18006=ends[28];
    }
    if(ends[29]>=biggest18006){
      biggest18006=ends[29];
    }
    if(ends[30]>=biggest18006){
      biggest18006=ends[30];
    }
    if(ends[31]>=biggest18006){
      biggest18006=ends[31];
    }
    if(ends[32]>=biggest18006){
      biggest18006=ends[32];
    }
    if(ends[33]>=biggest18006){
      biggest18006=ends[33];
    }
    if(ends[34]>=biggest18006){
      biggest18006=ends[34];
    }
    if(ends[35]>=biggest18006){
      biggest18006=ends[35];
    }
    if(ends[36]>=biggest18006){
      biggest18006=ends[36];
    }
    if(ends[37]>=biggest18006){
      biggest18006=ends[37];
    }
    if(ends[38]>=biggest18006){
      biggest18006=ends[38];
    }
    if(ends[39]>=biggest18006){
      biggest18006=ends[39];
    }
    if(ends[40]>=biggest18006){
      biggest18006=ends[40];
    }
    if(ends[41]>=biggest18006){
      biggest18006=ends[41];
    }
    if(ends[42]>=biggest18006){
      biggest18006=ends[42];
    }
    if(ends[43]>=biggest18006){
      biggest18006=ends[43];
    }
    if(ends[44]>=biggest18006){
      biggest18006=ends[44];
    }
    if(ends[45]>=biggest18006){
      biggest18006=ends[45];
    }
    if(ends[46]>=biggest18006){
      biggest18006=ends[46];
    }
    if(ends[47]>=biggest18006){
      biggest18006=ends[47];
    }
    if(ends[48]>=biggest18006){
      biggest18006=ends[48];
    }
    if(ends[49]>=biggest18006){
      biggest18006=ends[49];
    }
    if(ends[50]>=biggest18006){
      biggest18006=ends[50];
    }
    if(ends[51]>=biggest18006){
      biggest18006=ends[51];
    }
    if(ends[52]>=biggest18006){
      biggest18006=ends[52];
    }
    if(ends[53]>=biggest18006){
      biggest18006=ends[53];
    }
    if(ends[54]>=biggest18006){
      biggest18006=ends[54];
    }
    if(ends[55]>=biggest18006){
      biggest18006=ends[55];
    }
    if(ends[56]>=biggest18006){
      biggest18006=ends[56];
    }
    if(biggest18006 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread17970(int [] tdone, int [] ends){
        S5420=1;
    nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 333, column: 3
    S4993=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread17969(int [] tdone, int [] ends){
        S4968=1;
    S4897=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread17968(int [] tdone, int [] ends){
        S4874=1;
    S4873=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 306, column: 4
    currsigs.addElement(dosUnitEvac);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread17967(int [] tdone, int [] ends){
        S4684=1;
    S4649=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread17966(int [] tdone, int [] ends){
        S4638=1;
    S4567=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread17965(int [] tdone, int [] ends){
        S4544=1;
    S4473=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread17964(int [] tdone, int [] ends){
        S4450=1;
    S4379=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread17963(int [] tdone, int [] ends){
        S4356=1;
    chance_thread_14 = 25;//sysj\plant.sysj line: 231, column: 3
        S4110=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread17962(int [] tdone, int [] ends){
        S4074=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 203, column: 3
    S2421=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread17961(int [] tdone, int [] ends){
        S2294=1;
    S2271=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread17960(int [] tdone, int [] ends){
        S2264=1;
    S2199=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread17959(int [] tdone, int [] ends){
        S2178=1;
    S2113=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread17958(int [] tdone, int [] ends){
        S2092=1;
    S2057=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread17957(int [] tdone, int [] ends){
        S2046=1;
    S2011=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread17956(int [] tdone, int [] ends){
        S2000=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
    S1968=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread17955(int [] tdone, int [] ends){
        S1964=1;
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

  public void thread17954(int [] tdone, int [] ends){
        S1902=1;
    S1856=0;
    S1838=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread17953(int [] tdone, int [] ends){
        S1834=1;
    S1804=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
        S1799=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S1804=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S1804=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread17952(int [] tdone, int [] ends){
        S1790=1;
    S1744=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread17951(int [] tdone, int [] ends){
        S1737=1;
    S1691=0;
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
      switch(S17949){
        case 0 : 
          S17949=0;
          break RUN;
        
        case 1 : 
          S17949=2;
          S17949=2;
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
          thread17951(tdone,ends);
          thread17952(tdone,ends);
          thread17953(tdone,ends);
          thread17954(tdone,ends);
          thread17955(tdone,ends);
          thread17956(tdone,ends);
          thread17957(tdone,ends);
          thread17958(tdone,ends);
          thread17959(tdone,ends);
          thread17960(tdone,ends);
          thread17961(tdone,ends);
          thread17962(tdone,ends);
          thread17963(tdone,ends);
          thread17964(tdone,ends);
          thread17965(tdone,ends);
          thread17966(tdone,ends);
          thread17967(tdone,ends);
          thread17968(tdone,ends);
          thread17969(tdone,ends);
          thread17970(tdone,ends);
          thread17971(tdone,ends);
          int biggest18007 = 0;
          if(ends[2]>=biggest18007){
            biggest18007=ends[2];
          }
          if(ends[3]>=biggest18007){
            biggest18007=ends[3];
          }
          if(ends[4]>=biggest18007){
            biggest18007=ends[4];
          }
          if(ends[5]>=biggest18007){
            biggest18007=ends[5];
          }
          if(ends[6]>=biggest18007){
            biggest18007=ends[6];
          }
          if(ends[7]>=biggest18007){
            biggest18007=ends[7];
          }
          if(ends[8]>=biggest18007){
            biggest18007=ends[8];
          }
          if(ends[9]>=biggest18007){
            biggest18007=ends[9];
          }
          if(ends[10]>=biggest18007){
            biggest18007=ends[10];
          }
          if(ends[11]>=biggest18007){
            biggest18007=ends[11];
          }
          if(ends[12]>=biggest18007){
            biggest18007=ends[12];
          }
          if(ends[13]>=biggest18007){
            biggest18007=ends[13];
          }
          if(ends[14]>=biggest18007){
            biggest18007=ends[14];
          }
          if(ends[15]>=biggest18007){
            biggest18007=ends[15];
          }
          if(ends[16]>=biggest18007){
            biggest18007=ends[16];
          }
          if(ends[17]>=biggest18007){
            biggest18007=ends[17];
          }
          if(ends[18]>=biggest18007){
            biggest18007=ends[18];
          }
          if(ends[19]>=biggest18007){
            biggest18007=ends[19];
          }
          if(ends[20]>=biggest18007){
            biggest18007=ends[20];
          }
          if(ends[21]>=biggest18007){
            biggest18007=ends[21];
          }
          if(ends[22]>=biggest18007){
            biggest18007=ends[22];
          }
          if(biggest18007 == 1){
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
          thread18008(tdone,ends);
          thread18009(tdone,ends);
          thread18010(tdone,ends);
          thread18011(tdone,ends);
          thread18012(tdone,ends);
          thread18013(tdone,ends);
          thread18014(tdone,ends);
          thread18015(tdone,ends);
          thread18016(tdone,ends);
          thread18017(tdone,ends);
          thread18018(tdone,ends);
          thread18019(tdone,ends);
          thread18020(tdone,ends);
          thread18021(tdone,ends);
          thread18022(tdone,ends);
          thread18023(tdone,ends);
          thread18024(tdone,ends);
          thread18025(tdone,ends);
          thread18026(tdone,ends);
          thread18027(tdone,ends);
          thread18028(tdone,ends);
          int biggest18064 = 0;
          if(ends[2]>=biggest18064){
            biggest18064=ends[2];
          }
          if(ends[3]>=biggest18064){
            biggest18064=ends[3];
          }
          if(ends[4]>=biggest18064){
            biggest18064=ends[4];
          }
          if(ends[5]>=biggest18064){
            biggest18064=ends[5];
          }
          if(ends[6]>=biggest18064){
            biggest18064=ends[6];
          }
          if(ends[7]>=biggest18064){
            biggest18064=ends[7];
          }
          if(ends[8]>=biggest18064){
            biggest18064=ends[8];
          }
          if(ends[9]>=biggest18064){
            biggest18064=ends[9];
          }
          if(ends[10]>=biggest18064){
            biggest18064=ends[10];
          }
          if(ends[11]>=biggest18064){
            biggest18064=ends[11];
          }
          if(ends[12]>=biggest18064){
            biggest18064=ends[12];
          }
          if(ends[13]>=biggest18064){
            biggest18064=ends[13];
          }
          if(ends[14]>=biggest18064){
            biggest18064=ends[14];
          }
          if(ends[15]>=biggest18064){
            biggest18064=ends[15];
          }
          if(ends[16]>=biggest18064){
            biggest18064=ends[16];
          }
          if(ends[17]>=biggest18064){
            biggest18064=ends[17];
          }
          if(ends[18]>=biggest18064){
            biggest18064=ends[18];
          }
          if(ends[19]>=biggest18064){
            biggest18064=ends[19];
          }
          if(ends[20]>=biggest18064){
            biggest18064=ends[20];
          }
          if(ends[21]>=biggest18064){
            biggest18064=ends[21];
          }
          if(ends[22]>=biggest18064){
            biggest18064=ends[22];
          }
          if(biggest18064 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest18064 == 0){
            S17949=0;
            active[1]=0;
            ends[1]=0;
            S17949=0;
            break RUN;
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
      tableAlignedWithSensor.setpreclear();
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
      tableAlignedWithSensor.sethook();
      tableAlignedWithSensor.setClear();
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
