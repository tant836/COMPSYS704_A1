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
  private int S18687 = 1;
  private int S2475 = 1;
  private int S2429 = 1;
  private int S2528 = 1;
  private int S2482 = 1;
  private int S2572 = 1;
  private int S2542 = 1;
  private int S2537 = 1;
  private int S2640 = 1;
  private int S2594 = 1;
  private int S2576 = 1;
  private int S2702 = 1;
  private int S2738 = 1;
  private int S2706 = 1;
  private int S2784 = 1;
  private int S2749 = 1;
  private int S2830 = 1;
  private int S2795 = 1;
  private int S2916 = 1;
  private int S2851 = 1;
  private int S2838 = 1;
  private int S3002 = 1;
  private int S2937 = 1;
  private int S2924 = 1;
  private int S3032 = 1;
  private int S3009 = 1;
  private int S4812 = 1;
  private int S3159 = 1;
  private int S3034 = 1;
  private int S3064 = 1;
  private int S3063 = 1;
  private int S5094 = 1;
  private int S4848 = 1;
  private int S4814 = 1;
  private int S5188 = 1;
  private int S5117 = 1;
  private int S5104 = 1;
  private int S5282 = 1;
  private int S5211 = 1;
  private int S5198 = 1;
  private int S5376 = 1;
  private int S5305 = 1;
  private int S5292 = 1;
  private int S5422 = 1;
  private int S5387 = 1;
  private int S5612 = 1;
  private int S5611 = 1;
  private int S5449 = 1;
  private int S5436 = 1;
  private int S5706 = 1;
  private int S5635 = 1;
  private int S5622 = 1;
  private int S6158 = 1;
  private int S5731 = 1;
  private int S5717 = 1;
  private int S6486 = 1;
  private int S6166 = 1;
  private int S6174 = 1;
  private int S6182 = 1;
  private int S6202 = 1;
  private int S6188 = 1;
  private int S6186 = 1;
  private int S6210 = 1;
  private int S6248 = 1;
  private int S6222 = 1;
  private int S6220 = 1;
  private int S6268 = 1;
  private int S6254 = 1;
  private int S6252 = 1;
  private int S6276 = 1;
  private int S6284 = 1;
  private int S6292 = 1;
  private int S6300 = 1;
  private int S6308 = 1;
  private int S6316 = 1;
  private int S6324 = 1;
  private int S6332 = 1;
  private int S6340 = 1;
  private int S6348 = 1;
  private int S6356 = 1;
  private int S6364 = 1;
  private int S6372 = 1;
  private int S6380 = 1;
  private int S6388 = 1;
  private int S6396 = 1;
  private int S6404 = 1;
  private int S6412 = 1;
  private int S6420 = 1;
  private int S6428 = 1;
  private int S6436 = 1;
  private int S6444 = 1;
  private int S6452 = 1;
  private int S6460 = 1;
  private int S6468 = 1;
  private int S6476 = 1;
  private int S6484 = 1;
  
  private int[] ends = new int[57];
  private int[] tdone = new int[57];
  
  public void thread18800(int [] tdone, int [] ends){
        switch(S6484){
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

  public void thread18799(int [] tdone, int [] ends){
        switch(S6476){
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

  public void thread18798(int [] tdone, int [] ends){
        switch(S6468){
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

  public void thread18797(int [] tdone, int [] ends){
        switch(S6460){
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

  public void thread18796(int [] tdone, int [] ends){
        switch(S6452){
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

  public void thread18795(int [] tdone, int [] ends){
        switch(S6444){
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

  public void thread18794(int [] tdone, int [] ends){
        switch(S6436){
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

  public void thread18793(int [] tdone, int [] ends){
        switch(S6428){
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

  public void thread18792(int [] tdone, int [] ends){
        switch(S6420){
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

  public void thread18791(int [] tdone, int [] ends){
        switch(S6412){
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

  public void thread18790(int [] tdone, int [] ends){
        switch(S6404){
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

  public void thread18789(int [] tdone, int [] ends){
        switch(S6396){
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

  public void thread18788(int [] tdone, int [] ends){
        switch(S6388){
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

  public void thread18787(int [] tdone, int [] ends){
        switch(S6380){
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

  public void thread18786(int [] tdone, int [] ends){
        switch(S6372){
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

  public void thread18785(int [] tdone, int [] ends){
        switch(S6364){
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

  public void thread18784(int [] tdone, int [] ends){
        switch(S6356){
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

  public void thread18783(int [] tdone, int [] ends){
        switch(S6348){
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

  public void thread18782(int [] tdone, int [] ends){
        switch(S6340){
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

  public void thread18781(int [] tdone, int [] ends){
        switch(S6332){
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

  public void thread18780(int [] tdone, int [] ends){
        switch(S6324){
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

  public void thread18779(int [] tdone, int [] ends){
        switch(S6316){
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

  public void thread18778(int [] tdone, int [] ends){
        switch(S6308){
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

  public void thread18777(int [] tdone, int [] ends){
        switch(S6300){
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

  public void thread18776(int [] tdone, int [] ends){
        switch(S6292){
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

  public void thread18775(int [] tdone, int [] ends){
        switch(S6284){
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

  public void thread18774(int [] tdone, int [] ends){
        switch(S6276){
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

  public void thread18773(int [] tdone, int [] ends){
        switch(S6268){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S6254){
          case 0 : 
            switch(S6252){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 389, column: 54
                  S6252=1;
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
                  S6254=1;
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
            S6254=1;
            S6254=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 389, column: 24
              S6252=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S6254=1;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18772(int [] tdone, int [] ends){
        switch(S6248){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S6222){
          case 0 : 
            switch(S6220){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 380, column: 11
                  S6220=1;
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
                  S6222=1;
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
            S6222=1;
            S6222=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 379, column: 12
              S6220=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S6222=1;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18771(int [] tdone, int [] ends){
        switch(S6210){
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

  public void thread18770(int [] tdone, int [] ends){
        switch(S6202){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S6188){
          case 0 : 
            switch(S6186){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 374, column: 54
                  S6186=1;
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
                  S6188=1;
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
            S6188=1;
            S6188=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 374, column: 24
              S6186=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S6188=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18769(int [] tdone, int [] ends){
        switch(S6182){
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

  public void thread18768(int [] tdone, int [] ends){
        switch(S6174){
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

  public void thread18767(int [] tdone, int [] ends){
        switch(S6166){
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

  public void thread18766(int [] tdone, int [] ends){
        switch(S6486){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        thread18767(tdone,ends);
        thread18768(tdone,ends);
        thread18769(tdone,ends);
        thread18770(tdone,ends);
        thread18771(tdone,ends);
        thread18772(tdone,ends);
        thread18773(tdone,ends);
        thread18774(tdone,ends);
        thread18775(tdone,ends);
        thread18776(tdone,ends);
        thread18777(tdone,ends);
        thread18778(tdone,ends);
        thread18779(tdone,ends);
        thread18780(tdone,ends);
        thread18781(tdone,ends);
        thread18782(tdone,ends);
        thread18783(tdone,ends);
        thread18784(tdone,ends);
        thread18785(tdone,ends);
        thread18786(tdone,ends);
        thread18787(tdone,ends);
        thread18788(tdone,ends);
        thread18789(tdone,ends);
        thread18790(tdone,ends);
        thread18791(tdone,ends);
        thread18792(tdone,ends);
        thread18793(tdone,ends);
        thread18794(tdone,ends);
        thread18795(tdone,ends);
        thread18796(tdone,ends);
        thread18797(tdone,ends);
        thread18798(tdone,ends);
        thread18799(tdone,ends);
        thread18800(tdone,ends);
        int biggest18801 = 0;
        if(ends[23]>=biggest18801){
          biggest18801=ends[23];
        }
        if(ends[24]>=biggest18801){
          biggest18801=ends[24];
        }
        if(ends[25]>=biggest18801){
          biggest18801=ends[25];
        }
        if(ends[26]>=biggest18801){
          biggest18801=ends[26];
        }
        if(ends[27]>=biggest18801){
          biggest18801=ends[27];
        }
        if(ends[28]>=biggest18801){
          biggest18801=ends[28];
        }
        if(ends[29]>=biggest18801){
          biggest18801=ends[29];
        }
        if(ends[30]>=biggest18801){
          biggest18801=ends[30];
        }
        if(ends[31]>=biggest18801){
          biggest18801=ends[31];
        }
        if(ends[32]>=biggest18801){
          biggest18801=ends[32];
        }
        if(ends[33]>=biggest18801){
          biggest18801=ends[33];
        }
        if(ends[34]>=biggest18801){
          biggest18801=ends[34];
        }
        if(ends[35]>=biggest18801){
          biggest18801=ends[35];
        }
        if(ends[36]>=biggest18801){
          biggest18801=ends[36];
        }
        if(ends[37]>=biggest18801){
          biggest18801=ends[37];
        }
        if(ends[38]>=biggest18801){
          biggest18801=ends[38];
        }
        if(ends[39]>=biggest18801){
          biggest18801=ends[39];
        }
        if(ends[40]>=biggest18801){
          biggest18801=ends[40];
        }
        if(ends[41]>=biggest18801){
          biggest18801=ends[41];
        }
        if(ends[42]>=biggest18801){
          biggest18801=ends[42];
        }
        if(ends[43]>=biggest18801){
          biggest18801=ends[43];
        }
        if(ends[44]>=biggest18801){
          biggest18801=ends[44];
        }
        if(ends[45]>=biggest18801){
          biggest18801=ends[45];
        }
        if(ends[46]>=biggest18801){
          biggest18801=ends[46];
        }
        if(ends[47]>=biggest18801){
          biggest18801=ends[47];
        }
        if(ends[48]>=biggest18801){
          biggest18801=ends[48];
        }
        if(ends[49]>=biggest18801){
          biggest18801=ends[49];
        }
        if(ends[50]>=biggest18801){
          biggest18801=ends[50];
        }
        if(ends[51]>=biggest18801){
          biggest18801=ends[51];
        }
        if(ends[52]>=biggest18801){
          biggest18801=ends[52];
        }
        if(ends[53]>=biggest18801){
          biggest18801=ends[53];
        }
        if(ends[54]>=biggest18801){
          biggest18801=ends[54];
        }
        if(ends[55]>=biggest18801){
          biggest18801=ends[55];
        }
        if(ends[56]>=biggest18801){
          biggest18801=ends[56];
        }
        if(biggest18801 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest18801 == 0){
          S6486=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread18765(int [] tdone, int [] ends){
        switch(S6158){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S5731){
          case 0 : 
            S5731=0;
            S5731=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 337, column: 13
              S5717=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S5731=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if(!turnNozTrigger.getprestatus()){//sysj\plant.sysj line: 336, column: 10
              S5731=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              switch(S5717){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 338, column: 12
                    nozzlenum_thread_21 = nozzlenum_thread_21 + 1;//sysj\plant.sysj line: 339, column: 6
                    if(nozzlenum_thread_21 == 1){//sysj\plant.sysj line: 340, column: 9
                      noz1.setPresent();//sysj\plant.sysj line: 341, column: 7
                      currsigs.addElement(noz1);
                      S5731=0;
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      if(nozzlenum_thread_21 == 2){//sysj\plant.sysj line: 342, column: 15
                        noz2.setPresent();//sysj\plant.sysj line: 343, column: 7
                        currsigs.addElement(noz2);
                        S5731=0;
                        active[21]=1;
                        ends[21]=1;
                        tdone[21]=1;
                      }
                      else {
                        if(nozzlenum_thread_21 == 3){//sysj\plant.sysj line: 344, column: 15
                          noz3.setPresent();//sysj\plant.sysj line: 345, column: 7
                          currsigs.addElement(noz3);
                          S5731=0;
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                        else {
                          noz4.setPresent();//sysj\plant.sysj line: 347, column: 7
                          currsigs.addElement(noz4);
                          nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 348, column: 7
                          S5731=0;
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
                  S5731=0;
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

  public void thread18764(int [] tdone, int [] ends){
        switch(S5706){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S5635){
          case 0 : 
            S5635=0;
            S5635=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 322, column: 12
              S5622=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S5635=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S5622){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 323, column: 11
                  S5622=1;
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
                  S5635=0;
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

  public void thread18763(int [] tdone, int [] ends){
        switch(S5612){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S5611){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 305, column: 9
              S5611=1;
              S5449=0;
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
            switch(S5449){
              case 0 : 
                S5449=0;
                S5449=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 310, column: 12
                  S5436=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S5449=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                switch(S5436){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 311, column: 11
                      S5436=1;
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
                      S5449=0;
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

  public void thread18762(int [] tdone, int [] ends){
        switch(S5422){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S5387){
          case 0 : 
            S5387=0;
            S5387=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 292, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 294, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S5387=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 293, column: 11
              S5387=0;
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

  public void thread18761(int [] tdone, int [] ends){
        switch(S5376){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S5305){
          case 0 : 
            S5305=0;
            S5305=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 280, column: 12
              S5292=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S5305=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S5292){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 281, column: 11
                  S5292=1;
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
                  S5305=0;
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

  public void thread18760(int [] tdone, int [] ends){
        switch(S5282){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S5211){
          case 0 : 
            S5211=0;
            S5211=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 268, column: 12
              S5198=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S5211=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S5198){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 269, column: 11
                  S5198=1;
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
                  S5211=0;
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

  public void thread18759(int [] tdone, int [] ends){
        switch(S5188){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S5117){
          case 0 : 
            S5117=0;
            S5117=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 256, column: 12
              S5104=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S5117=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S5104){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 257, column: 11
                  S5104=1;
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
                  S5117=0;
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

  public void thread18758(int [] tdone, int [] ends){
        switch(S5094){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S4848){
          case 0 : 
            S4848=0;
            S4848=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 236, column: 12
              rand_thread_14 = (int)(Math.random() * 100);//sysj\plant.sysj line: 237, column: 5
              System.out.println(rand_thread_14);//sysj\plant.sysj line: 238, column: 5
              S4814=0;
              if(rand_thread_14 < chance_thread_14){//sysj\plant.sysj line: 239, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 241, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S4814=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              S4848=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S4814){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 240, column: 12
                  S4814=1;
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
                  S4814=2;
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
                  S4848=0;
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

  public void thread18757(int [] tdone, int [] ends){
        switch(S4812){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S3159){
          case 0 : 
            S3159=0;
            S3159=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 206, column: 12
              S3034=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S3159=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            switch(S3034){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 207, column: 11
                  numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 208, column: 5
                  S3034=1;
                  if(numTurns_thread_13 >= 2 && numTurns_thread_13 < 3){//sysj\plant.sysj line: 209, column: 8
                    S3064=0;
                    l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 210, column: 6
                    currsigs.addElement(l_putBottleAt2_1);
                    tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 212, column: 7
                    currsigs.addElement(tableAlignedWithSensor);
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S3064=1;
                    if(numTurns_thread_13 >= 3 && numTurns_thread_13 < 4){//sysj\plant.sysj line: 214, column: 14
                      S3063=0;
                      l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 215, column: 6
                      currsigs.addElement(l_putBottleAt4_1);
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 217, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      active[13]=1;
                      ends[13]=1;
                      tdone[13]=1;
                    }
                    else {
                      S3063=1;
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
                        S3159=0;
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
                switch(S3064){
                  case 0 : 
                    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                      S3159=0;
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
                    switch(S3063){
                      case 0 : 
                        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 216, column: 12
                          S3159=0;
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
                          S3159=0;
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

  public void thread18756(int [] tdone, int [] ends){
        switch(S3032){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S3009){
          case 0 : 
            S3009=0;
            S3009=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 193, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S3009=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 194, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 195, column: 5
              currsigs.addElement(bottleLeftPos5);
              S3009=0;
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

  public void thread18755(int [] tdone, int [] ends){
        switch(S3002){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S2937){
          case 0 : 
            S2937=0;
            S2937=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 181, column: 12
              S2924=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S2937=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos4.getprestatus())){//sysj\plant.sysj line: 182, column: 11
              S2937=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S2924){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 183, column: 12
                    S2924=1;
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

  public void thread18754(int [] tdone, int [] ends){
        switch(S2916){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S2851){
          case 0 : 
            S2851=0;
            S2851=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 169, column: 12
              S2838=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S2851=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos5.getprestatus())){//sysj\plant.sysj line: 170, column: 11
              S2851=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S2838){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 171, column: 12
                    S2838=1;
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

  public void thread18753(int [] tdone, int [] ends){
        switch(S2830){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S2795){
          case 0 : 
            S2795=0;
            S2795=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 158, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S2795=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 159, column: 11
              S2795=0;
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

  public void thread18752(int [] tdone, int [] ends){
        switch(S2784){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2749){
          case 0 : 
            S2749=0;
            S2749=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S2749=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 148, column: 11
              S2749=0;
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

  public void thread18751(int [] tdone, int [] ends){
        switch(S2738){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
        switch(S2706){
          case 0 : 
            S2706=0;
            S2706=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 136, column: 11
              S2706=2;
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
              S2706=0;
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

  public void thread18750(int [] tdone, int [] ends){
        switch(S2702){
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

  public void thread18749(int [] tdone, int [] ends){
        switch(S2640){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S2594){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 98, column: 10
              S2594=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S2576){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 100, column: 13
                    S2576=1;
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
                    S2576=2;
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
                    S2576=0;
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
              S2594=0;
              S2576=0;
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

  public void thread18748(int [] tdone, int [] ends){
        switch(S2572){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S2542){
          case 0 : 
            switch(S2537){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 78, column: 12
                  S2537=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 81, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 82, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 82, column: 7
                    S2542=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S2542=1;
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
                S2542=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                    S2537=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S2542=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S2542=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S2542=1;
            S2542=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                S2537=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S2542=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S2542=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18747(int [] tdone, int [] ends){
        switch(S2528){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2482){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 62, column: 10
              S2482=1;
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
              S2482=2;
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
              S2482=3;
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
              S2482=0;
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

  public void thread18746(int [] tdone, int [] ends){
        switch(S2475){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2429){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 49, column: 10
              S2429=1;
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
              S2429=2;
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
              S2429=3;
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
              S2429=0;
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

  public void thread18743(int [] tdone, int [] ends){
        S6484=1;
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

  public void thread18742(int [] tdone, int [] ends){
        S6476=1;
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

  public void thread18741(int [] tdone, int [] ends){
        S6468=1;
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

  public void thread18740(int [] tdone, int [] ends){
        S6460=1;
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

  public void thread18739(int [] tdone, int [] ends){
        S6452=1;
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

  public void thread18738(int [] tdone, int [] ends){
        S6444=1;
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

  public void thread18737(int [] tdone, int [] ends){
        S6436=1;
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

  public void thread18736(int [] tdone, int [] ends){
        S6428=1;
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

  public void thread18735(int [] tdone, int [] ends){
        S6420=1;
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

  public void thread18734(int [] tdone, int [] ends){
        S6412=1;
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

  public void thread18733(int [] tdone, int [] ends){
        S6404=1;
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

  public void thread18732(int [] tdone, int [] ends){
        S6396=1;
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

  public void thread18731(int [] tdone, int [] ends){
        S6388=1;
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

  public void thread18730(int [] tdone, int [] ends){
        S6380=1;
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

  public void thread18729(int [] tdone, int [] ends){
        S6372=1;
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

  public void thread18728(int [] tdone, int [] ends){
        S6364=1;
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

  public void thread18727(int [] tdone, int [] ends){
        S6356=1;
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

  public void thread18726(int [] tdone, int [] ends){
        S6348=1;
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

  public void thread18725(int [] tdone, int [] ends){
        S6340=1;
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

  public void thread18724(int [] tdone, int [] ends){
        S6332=1;
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

  public void thread18723(int [] tdone, int [] ends){
        S6324=1;
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

  public void thread18722(int [] tdone, int [] ends){
        S6316=1;
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

  public void thread18721(int [] tdone, int [] ends){
        S6308=1;
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

  public void thread18720(int [] tdone, int [] ends){
        S6300=1;
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

  public void thread18719(int [] tdone, int [] ends){
        S6292=1;
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

  public void thread18718(int [] tdone, int [] ends){
        S6284=1;
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

  public void thread18717(int [] tdone, int [] ends){
        S6276=1;
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

  public void thread18716(int [] tdone, int [] ends){
        S6268=1;
    S6254=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 389, column: 24
      S6252=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S6254=1;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread18715(int [] tdone, int [] ends){
        S6248=1;
    S6222=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 379, column: 12
      S6220=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      S6222=1;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread18714(int [] tdone, int [] ends){
        S6210=1;
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

  public void thread18713(int [] tdone, int [] ends){
        S6202=1;
    S6188=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 374, column: 24
      S6186=0;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      S6188=1;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread18712(int [] tdone, int [] ends){
        S6182=1;
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

  public void thread18711(int [] tdone, int [] ends){
        S6174=1;
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

  public void thread18710(int [] tdone, int [] ends){
        S6166=1;
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

  public void thread18709(int [] tdone, int [] ends){
        S6486=1;
    thread18710(tdone,ends);
    thread18711(tdone,ends);
    thread18712(tdone,ends);
    thread18713(tdone,ends);
    thread18714(tdone,ends);
    thread18715(tdone,ends);
    thread18716(tdone,ends);
    thread18717(tdone,ends);
    thread18718(tdone,ends);
    thread18719(tdone,ends);
    thread18720(tdone,ends);
    thread18721(tdone,ends);
    thread18722(tdone,ends);
    thread18723(tdone,ends);
    thread18724(tdone,ends);
    thread18725(tdone,ends);
    thread18726(tdone,ends);
    thread18727(tdone,ends);
    thread18728(tdone,ends);
    thread18729(tdone,ends);
    thread18730(tdone,ends);
    thread18731(tdone,ends);
    thread18732(tdone,ends);
    thread18733(tdone,ends);
    thread18734(tdone,ends);
    thread18735(tdone,ends);
    thread18736(tdone,ends);
    thread18737(tdone,ends);
    thread18738(tdone,ends);
    thread18739(tdone,ends);
    thread18740(tdone,ends);
    thread18741(tdone,ends);
    thread18742(tdone,ends);
    thread18743(tdone,ends);
    int biggest18744 = 0;
    if(ends[23]>=biggest18744){
      biggest18744=ends[23];
    }
    if(ends[24]>=biggest18744){
      biggest18744=ends[24];
    }
    if(ends[25]>=biggest18744){
      biggest18744=ends[25];
    }
    if(ends[26]>=biggest18744){
      biggest18744=ends[26];
    }
    if(ends[27]>=biggest18744){
      biggest18744=ends[27];
    }
    if(ends[28]>=biggest18744){
      biggest18744=ends[28];
    }
    if(ends[29]>=biggest18744){
      biggest18744=ends[29];
    }
    if(ends[30]>=biggest18744){
      biggest18744=ends[30];
    }
    if(ends[31]>=biggest18744){
      biggest18744=ends[31];
    }
    if(ends[32]>=biggest18744){
      biggest18744=ends[32];
    }
    if(ends[33]>=biggest18744){
      biggest18744=ends[33];
    }
    if(ends[34]>=biggest18744){
      biggest18744=ends[34];
    }
    if(ends[35]>=biggest18744){
      biggest18744=ends[35];
    }
    if(ends[36]>=biggest18744){
      biggest18744=ends[36];
    }
    if(ends[37]>=biggest18744){
      biggest18744=ends[37];
    }
    if(ends[38]>=biggest18744){
      biggest18744=ends[38];
    }
    if(ends[39]>=biggest18744){
      biggest18744=ends[39];
    }
    if(ends[40]>=biggest18744){
      biggest18744=ends[40];
    }
    if(ends[41]>=biggest18744){
      biggest18744=ends[41];
    }
    if(ends[42]>=biggest18744){
      biggest18744=ends[42];
    }
    if(ends[43]>=biggest18744){
      biggest18744=ends[43];
    }
    if(ends[44]>=biggest18744){
      biggest18744=ends[44];
    }
    if(ends[45]>=biggest18744){
      biggest18744=ends[45];
    }
    if(ends[46]>=biggest18744){
      biggest18744=ends[46];
    }
    if(ends[47]>=biggest18744){
      biggest18744=ends[47];
    }
    if(ends[48]>=biggest18744){
      biggest18744=ends[48];
    }
    if(ends[49]>=biggest18744){
      biggest18744=ends[49];
    }
    if(ends[50]>=biggest18744){
      biggest18744=ends[50];
    }
    if(ends[51]>=biggest18744){
      biggest18744=ends[51];
    }
    if(ends[52]>=biggest18744){
      biggest18744=ends[52];
    }
    if(ends[53]>=biggest18744){
      biggest18744=ends[53];
    }
    if(ends[54]>=biggest18744){
      biggest18744=ends[54];
    }
    if(ends[55]>=biggest18744){
      biggest18744=ends[55];
    }
    if(ends[56]>=biggest18744){
      biggest18744=ends[56];
    }
    if(biggest18744 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread18708(int [] tdone, int [] ends){
        S6158=1;
    nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 333, column: 3
    S5731=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread18707(int [] tdone, int [] ends){
        S5706=1;
    S5635=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread18706(int [] tdone, int [] ends){
        S5612=1;
    S5611=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 306, column: 4
    currsigs.addElement(dosUnitEvac);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread18705(int [] tdone, int [] ends){
        S5422=1;
    S5387=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread18704(int [] tdone, int [] ends){
        S5376=1;
    S5305=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread18703(int [] tdone, int [] ends){
        S5282=1;
    S5211=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread18702(int [] tdone, int [] ends){
        S5188=1;
    S5117=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread18701(int [] tdone, int [] ends){
        S5094=1;
    chance_thread_14 = 25;//sysj\plant.sysj line: 231, column: 3
        S4848=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread18700(int [] tdone, int [] ends){
        S4812=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 203, column: 3
    S3159=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread18699(int [] tdone, int [] ends){
        S3032=1;
    S3009=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread18698(int [] tdone, int [] ends){
        S3002=1;
    S2937=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread18697(int [] tdone, int [] ends){
        S2916=1;
    S2851=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread18696(int [] tdone, int [] ends){
        S2830=1;
    S2795=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread18695(int [] tdone, int [] ends){
        S2784=1;
    S2749=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread18694(int [] tdone, int [] ends){
        S2738=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
    S2706=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread18693(int [] tdone, int [] ends){
        S2702=1;
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

  public void thread18692(int [] tdone, int [] ends){
        S2640=1;
    S2594=0;
    S2576=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread18691(int [] tdone, int [] ends){
        S2572=1;
    S2542=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
        S2537=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S2542=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S2542=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread18690(int [] tdone, int [] ends){
        S2528=1;
    S2482=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread18689(int [] tdone, int [] ends){
        S2475=1;
    S2429=0;
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
      switch(S18687){
        case 0 : 
          S18687=0;
          break RUN;
        
        case 1 : 
          S18687=2;
          S18687=2;
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
          thread18689(tdone,ends);
          thread18690(tdone,ends);
          thread18691(tdone,ends);
          thread18692(tdone,ends);
          thread18693(tdone,ends);
          thread18694(tdone,ends);
          thread18695(tdone,ends);
          thread18696(tdone,ends);
          thread18697(tdone,ends);
          thread18698(tdone,ends);
          thread18699(tdone,ends);
          thread18700(tdone,ends);
          thread18701(tdone,ends);
          thread18702(tdone,ends);
          thread18703(tdone,ends);
          thread18704(tdone,ends);
          thread18705(tdone,ends);
          thread18706(tdone,ends);
          thread18707(tdone,ends);
          thread18708(tdone,ends);
          thread18709(tdone,ends);
          int biggest18745 = 0;
          if(ends[2]>=biggest18745){
            biggest18745=ends[2];
          }
          if(ends[3]>=biggest18745){
            biggest18745=ends[3];
          }
          if(ends[4]>=biggest18745){
            biggest18745=ends[4];
          }
          if(ends[5]>=biggest18745){
            biggest18745=ends[5];
          }
          if(ends[6]>=biggest18745){
            biggest18745=ends[6];
          }
          if(ends[7]>=biggest18745){
            biggest18745=ends[7];
          }
          if(ends[8]>=biggest18745){
            biggest18745=ends[8];
          }
          if(ends[9]>=biggest18745){
            biggest18745=ends[9];
          }
          if(ends[10]>=biggest18745){
            biggest18745=ends[10];
          }
          if(ends[11]>=biggest18745){
            biggest18745=ends[11];
          }
          if(ends[12]>=biggest18745){
            biggest18745=ends[12];
          }
          if(ends[13]>=biggest18745){
            biggest18745=ends[13];
          }
          if(ends[14]>=biggest18745){
            biggest18745=ends[14];
          }
          if(ends[15]>=biggest18745){
            biggest18745=ends[15];
          }
          if(ends[16]>=biggest18745){
            biggest18745=ends[16];
          }
          if(ends[17]>=biggest18745){
            biggest18745=ends[17];
          }
          if(ends[18]>=biggest18745){
            biggest18745=ends[18];
          }
          if(ends[19]>=biggest18745){
            biggest18745=ends[19];
          }
          if(ends[20]>=biggest18745){
            biggest18745=ends[20];
          }
          if(ends[21]>=biggest18745){
            biggest18745=ends[21];
          }
          if(ends[22]>=biggest18745){
            biggest18745=ends[22];
          }
          if(biggest18745 == 1){
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
          thread18746(tdone,ends);
          thread18747(tdone,ends);
          thread18748(tdone,ends);
          thread18749(tdone,ends);
          thread18750(tdone,ends);
          thread18751(tdone,ends);
          thread18752(tdone,ends);
          thread18753(tdone,ends);
          thread18754(tdone,ends);
          thread18755(tdone,ends);
          thread18756(tdone,ends);
          thread18757(tdone,ends);
          thread18758(tdone,ends);
          thread18759(tdone,ends);
          thread18760(tdone,ends);
          thread18761(tdone,ends);
          thread18762(tdone,ends);
          thread18763(tdone,ends);
          thread18764(tdone,ends);
          thread18765(tdone,ends);
          thread18766(tdone,ends);
          int biggest18802 = 0;
          if(ends[2]>=biggest18802){
            biggest18802=ends[2];
          }
          if(ends[3]>=biggest18802){
            biggest18802=ends[3];
          }
          if(ends[4]>=biggest18802){
            biggest18802=ends[4];
          }
          if(ends[5]>=biggest18802){
            biggest18802=ends[5];
          }
          if(ends[6]>=biggest18802){
            biggest18802=ends[6];
          }
          if(ends[7]>=biggest18802){
            biggest18802=ends[7];
          }
          if(ends[8]>=biggest18802){
            biggest18802=ends[8];
          }
          if(ends[9]>=biggest18802){
            biggest18802=ends[9];
          }
          if(ends[10]>=biggest18802){
            biggest18802=ends[10];
          }
          if(ends[11]>=biggest18802){
            biggest18802=ends[11];
          }
          if(ends[12]>=biggest18802){
            biggest18802=ends[12];
          }
          if(ends[13]>=biggest18802){
            biggest18802=ends[13];
          }
          if(ends[14]>=biggest18802){
            biggest18802=ends[14];
          }
          if(ends[15]>=biggest18802){
            biggest18802=ends[15];
          }
          if(ends[16]>=biggest18802){
            biggest18802=ends[16];
          }
          if(ends[17]>=biggest18802){
            biggest18802=ends[17];
          }
          if(ends[18]>=biggest18802){
            biggest18802=ends[18];
          }
          if(ends[19]>=biggest18802){
            biggest18802=ends[19];
          }
          if(ends[20]>=biggest18802){
            biggest18802=ends[20];
          }
          if(ends[21]>=biggest18802){
            biggest18802=ends[21];
          }
          if(ends[22]>=biggest18802){
            biggest18802=ends[22];
          }
          if(biggest18802 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest18802 == 0){
            S18687=0;
            active[1]=0;
            ends[1]=0;
            S18687=0;
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
