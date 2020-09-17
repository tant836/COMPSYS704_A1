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
  public Signal bottleAddedC = new Signal("bottleAddedC", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal l_bottleAdded_1;
  private Signal l_putBottleAt5_1;
  private Signal l_putBottleAt4_1;
  private Signal l_putBottleAt2_1;
  private Signal capPos_1;
  private Signal s_motConveyorOn_1;
  private Signal s_nozzlenum_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 113, column: 3
  private int numTurns_thread_13;//sysj\plant.sysj line: 203, column: 3
  private Integer chance_thread_14;//sysj\plant.sysj line: 231, column: 3
  private Integer rand_thread_14;//sysj\plant.sysj line: 232, column: 3
  private int nozzlenum_thread_22;//sysj\plant.sysj line: 335, column: 4
  private int S18773 = 1;
  private int S2717 = 1;
  private int S2671 = 1;
  private int S2770 = 1;
  private int S2724 = 1;
  private int S2814 = 1;
  private int S2784 = 1;
  private int S2779 = 1;
  private int S2882 = 1;
  private int S2836 = 1;
  private int S2818 = 1;
  private int S2944 = 1;
  private int S2980 = 1;
  private int S2948 = 1;
  private int S3026 = 1;
  private int S2991 = 1;
  private int S3072 = 1;
  private int S3037 = 1;
  private int S3158 = 1;
  private int S3093 = 1;
  private int S3080 = 1;
  private int S3244 = 1;
  private int S3179 = 1;
  private int S3166 = 1;
  private int S3274 = 1;
  private int S3251 = 1;
  private int S5054 = 1;
  private int S3401 = 1;
  private int S3276 = 1;
  private int S3306 = 1;
  private int S3305 = 1;
  private int S5336 = 1;
  private int S5090 = 1;
  private int S5056 = 1;
  private int S5430 = 1;
  private int S5359 = 1;
  private int S5346 = 1;
  private int S5524 = 1;
  private int S5453 = 1;
  private int S5440 = 1;
  private int S5618 = 1;
  private int S5547 = 1;
  private int S5534 = 1;
  private int S5664 = 1;
  private int S5629 = 1;
  private int S5854 = 1;
  private int S5853 = 1;
  private int S5691 = 1;
  private int S5678 = 1;
  private int S5948 = 1;
  private int S5877 = 1;
  private int S5864 = 1;
  private int S6353 = 1;
  private int S6135 = 1;
  private int S5972 = 1;
  private int S5951 = 1;
  private int S6189 = 1;
  private int S6138 = 1;
  private int S6243 = 1;
  private int S6192 = 1;
  private int S6297 = 1;
  private int S6246 = 1;
  private int S6351 = 1;
  private int S6300 = 1;
  private int S6689 = 1;
  private int S6361 = 1;
  private int S6369 = 1;
  private int S6377 = 1;
  private int S6397 = 1;
  private int S6383 = 1;
  private int S6381 = 1;
  private int S6405 = 1;
  private int S6443 = 1;
  private int S6417 = 1;
  private int S6415 = 1;
  private int S6463 = 1;
  private int S6449 = 1;
  private int S6447 = 1;
  private int S6471 = 1;
  private int S6479 = 1;
  private int S6487 = 1;
  private int S6495 = 1;
  private int S6503 = 1;
  private int S6511 = 1;
  private int S6519 = 1;
  private int S6527 = 1;
  private int S6535 = 1;
  private int S6543 = 1;
  private int S6551 = 1;
  private int S6559 = 1;
  private int S6567 = 1;
  private int S6575 = 1;
  private int S6583 = 1;
  private int S6591 = 1;
  private int S6599 = 1;
  private int S6607 = 1;
  private int S6615 = 1;
  private int S6623 = 1;
  private int S6631 = 1;
  private int S6639 = 1;
  private int S6647 = 1;
  private int S6655 = 1;
  private int S6663 = 1;
  private int S6671 = 1;
  private int S6679 = 1;
  private int S6687 = 1;
  
  private int[] ends = new int[63];
  private int[] tdone = new int[63];
  
  public void thread18900(int [] tdone, int [] ends){
        switch(S6687){
      case 0 : 
        active[62]=0;
        ends[62]=0;
        tdone[62]=1;
        break;
      
      case 1 : 
        if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 506, column: 25
          bottleAddedC.setPresent();//sysj\plant.sysj line: 506, column: 38
          currsigs.addElement(bottleAddedC);
          active[62]=1;
          ends[62]=1;
          tdone[62]=1;
        }
        else {
          active[62]=1;
          ends[62]=1;
          tdone[62]=1;
        }
        break;
      
    }
  }

  public void thread18899(int [] tdone, int [] ends){
        switch(S6679){
      case 0 : 
        active[61]=0;
        ends[61]=0;
        tdone[61]=1;
        break;
      
      case 1 : 
        if(noz4.getprestatus()){//sysj\plant.sysj line: 504, column: 25
          noz4E.setPresent();//sysj\plant.sysj line: 504, column: 31
          currsigs.addElement(noz4E);
          active[61]=1;
          ends[61]=1;
          tdone[61]=1;
        }
        else {
          active[61]=1;
          ends[61]=1;
          tdone[61]=1;
        }
        break;
      
    }
  }

  public void thread18898(int [] tdone, int [] ends){
        switch(S6671){
      case 0 : 
        active[60]=0;
        ends[60]=0;
        tdone[60]=1;
        break;
      
      case 1 : 
        if(noz3.getprestatus()){//sysj\plant.sysj line: 502, column: 25
          noz3E.setPresent();//sysj\plant.sysj line: 502, column: 31
          currsigs.addElement(noz3E);
          active[60]=1;
          ends[60]=1;
          tdone[60]=1;
        }
        else {
          active[60]=1;
          ends[60]=1;
          tdone[60]=1;
        }
        break;
      
    }
  }

  public void thread18897(int [] tdone, int [] ends){
        switch(S6663){
      case 0 : 
        active[59]=0;
        ends[59]=0;
        tdone[59]=1;
        break;
      
      case 1 : 
        if(noz2.getprestatus()){//sysj\plant.sysj line: 500, column: 25
          noz2E.setPresent();//sysj\plant.sysj line: 500, column: 31
          currsigs.addElement(noz2E);
          active[59]=1;
          ends[59]=1;
          tdone[59]=1;
        }
        else {
          active[59]=1;
          ends[59]=1;
          tdone[59]=1;
        }
        break;
      
    }
  }

  public void thread18896(int [] tdone, int [] ends){
        switch(S6655){
      case 0 : 
        active[58]=0;
        ends[58]=0;
        tdone[58]=1;
        break;
      
      case 1 : 
        if(noz1.getprestatus()){//sysj\plant.sysj line: 498, column: 25
          noz1E.setPresent();//sysj\plant.sysj line: 498, column: 31
          currsigs.addElement(noz1E);
          active[58]=1;
          ends[58]=1;
          tdone[58]=1;
        }
        else {
          active[58]=1;
          ends[58]=1;
          tdone[58]=1;
        }
        break;
      
    }
  }

  public void thread18895(int [] tdone, int [] ends){
        switch(S6647){
      case 0 : 
        active[57]=0;
        ends[57]=0;
        tdone[57]=1;
        break;
      
      case 1 : 
        if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 496, column: 25
          capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 496, column: 44
          currsigs.addElement(capOnBottleAtPos1E);
          active[57]=1;
          ends[57]=1;
          tdone[57]=1;
        }
        else {
          active[57]=1;
          ends[57]=1;
          tdone[57]=1;
        }
        break;
      
    }
  }

  public void thread18894(int [] tdone, int [] ends){
        switch(S6639){
      case 0 : 
        active[56]=0;
        ends[56]=0;
        tdone[56]=1;
        break;
      
      case 1 : 
        if(selNoz4.getprestatus()){//sysj\plant.sysj line: 494, column: 25
          o_selNoz4.setPresent();//sysj\plant.sysj line: 494, column: 34
          currsigs.addElement(o_selNoz4);
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

  public void thread18893(int [] tdone, int [] ends){
        switch(S6631){
      case 0 : 
        active[55]=0;
        ends[55]=0;
        tdone[55]=1;
        break;
      
      case 1 : 
        if(selNoz3.getprestatus()){//sysj\plant.sysj line: 492, column: 25
          o_selNoz3.setPresent();//sysj\plant.sysj line: 492, column: 34
          currsigs.addElement(o_selNoz3);
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

  public void thread18892(int [] tdone, int [] ends){
        switch(S6623){
      case 0 : 
        active[54]=0;
        ends[54]=0;
        tdone[54]=1;
        break;
      
      case 1 : 
        if(selNoz2.getprestatus()){//sysj\plant.sysj line: 490, column: 25
          o_selNoz2.setPresent();//sysj\plant.sysj line: 490, column: 34
          currsigs.addElement(o_selNoz2);
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

  public void thread18891(int [] tdone, int [] ends){
        switch(S6615){
      case 0 : 
        active[53]=0;
        ends[53]=0;
        tdone[53]=1;
        break;
      
      case 1 : 
        if(selNoz1.getprestatus()){//sysj\plant.sysj line: 488, column: 25
          o_selNoz1.setPresent();//sysj\plant.sysj line: 488, column: 34
          currsigs.addElement(o_selNoz1);
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

  public void thread18890(int [] tdone, int [] ends){
        switch(S6607){
      case 0 : 
        active[52]=0;
        ends[52]=0;
        tdone[52]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 485, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 485, column: 40
          currsigs.addElement(dosUnitFilledE);
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

  public void thread18889(int [] tdone, int [] ends){
        switch(S6599){
      case 0 : 
        active[51]=0;
        ends[51]=0;
        tdone[51]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 483, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 483, column: 38
          currsigs.addElement(dosUnitEvacE);
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

  public void thread18888(int [] tdone, int [] ends){
        switch(S6591){
      case 0 : 
        active[50]=0;
        ends[50]=0;
        tdone[50]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 481, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 481, column: 39
          currsigs.addElement(bottleAtPos2E);
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

  public void thread18887(int [] tdone, int [] ends){
        switch(S6583){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 479, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 479, column: 45
          currsigs.addElement(dosUnitValveExtendE);
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

  public void thread18886(int [] tdone, int [] ends){
        switch(S6575){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 477, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 477, column: 46
          currsigs.addElement(dosUnitValveRetractE);
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

  public void thread18885(int [] tdone, int [] ends){
        switch(S6567){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 475, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 475, column: 42
          currsigs.addElement(valveInletOnOffE);
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

  public void thread18884(int [] tdone, int [] ends){
        switch(S6559){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 473, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 473, column: 45
          currsigs.addElement(valveInjectorOnOffE);
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

  public void thread18883(int [] tdone, int [] ends){
        switch(S6551){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 470, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 470, column: 47
          currsigs.addElement(cylClampBottleExtendE);
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

  public void thread18882(int [] tdone, int [] ends){
        switch(S6543){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 468, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 468, column: 47
          currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread18881(int [] tdone, int [] ends){
        switch(S6535){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 466, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 466, column: 44
          currsigs.addElement(gripperTurnExtendE);
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

  public void thread18880(int [] tdone, int [] ends){
        switch(S6527){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 464, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 464, column: 45
          currsigs.addElement(gripperTurnRetractE);
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

  public void thread18879(int [] tdone, int [] ends){
        switch(S6519){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 462, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 462, column: 45
          currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread18878(int [] tdone, int [] ends){
        switch(S6511){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 460, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 460, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread18877(int [] tdone, int [] ends){
        switch(S6503){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 457, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 457, column: 45
          currsigs.addElement(gripperTurnHomePosE);
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

  public void thread18876(int [] tdone, int [] ends){
        switch(S6495){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 455, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 455, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread18875(int [] tdone, int [] ends){
        switch(S6487){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 453, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 453, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread18874(int [] tdone, int [] ends){
        switch(S6479){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 451, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 451, column: 38
          currsigs.addElement(bottleAtPos2E);
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

  public void thread18873(int [] tdone, int [] ends){
        switch(S6471){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 449, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 449, column: 38
          currsigs.addElement(bottleAtPos4E);
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

  public void thread18872(int [] tdone, int [] ends){
        switch(S6463){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        switch(S6449){
          case 0 : 
            switch(S6447){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 447, column: 54
                  S6447=1;
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
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 447, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 447, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  S6449=1;
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
            break;
          
          case 1 : 
            S6449=1;
            S6449=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 447, column: 24
              S6447=0;
              active[34]=1;
              ends[34]=1;
              tdone[34]=1;
            }
            else {
              S6449=1;
              active[34]=1;
              ends[34]=1;
              tdone[34]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18871(int [] tdone, int [] ends){
        switch(S6443){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        switch(S6417){
          case 0 : 
            switch(S6415){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 438, column: 11
                  S6415=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 440, column: 6
                  currsigs.addElement(bottleLeftPos5E);
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
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 439, column: 11
                  S6417=1;
                  active[33]=1;
                  ends[33]=1;
                  tdone[33]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 440, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[33]=1;
                  ends[33]=1;
                  tdone[33]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S6417=1;
            S6417=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 437, column: 12
              S6415=0;
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            else {
              S6417=1;
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18870(int [] tdone, int [] ends){
        switch(S6405){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 434, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 434, column: 56
          currsigs.addElement(bottleAtPos5E);
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

  public void thread18869(int [] tdone, int [] ends){
        switch(S6397){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        switch(S6383){
          case 0 : 
            switch(S6381){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 432, column: 54
                  S6381=1;
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
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 432, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 432, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  S6383=1;
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
            break;
          
          case 1 : 
            S6383=1;
            S6383=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 432, column: 24
              S6381=0;
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            else {
              S6383=1;
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18868(int [] tdone, int [] ends){
        switch(S6377){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 430, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 430, column: 44
          currsigs.addElement(rotaryTableTriggerE);
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

  public void thread18867(int [] tdone, int [] ends){
        switch(S6369){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 428, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 428, column: 39
          currsigs.addElement(motConveyorOnE);
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
  }

  public void thread18866(int [] tdone, int [] ends){
        switch(S6361){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 426, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 426, column: 38
          currsigs.addElement(bottleAtPos1E);
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
      
    }
  }

  public void thread18865(int [] tdone, int [] ends){
        switch(S6689){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        thread18866(tdone,ends);
        thread18867(tdone,ends);
        thread18868(tdone,ends);
        thread18869(tdone,ends);
        thread18870(tdone,ends);
        thread18871(tdone,ends);
        thread18872(tdone,ends);
        thread18873(tdone,ends);
        thread18874(tdone,ends);
        thread18875(tdone,ends);
        thread18876(tdone,ends);
        thread18877(tdone,ends);
        thread18878(tdone,ends);
        thread18879(tdone,ends);
        thread18880(tdone,ends);
        thread18881(tdone,ends);
        thread18882(tdone,ends);
        thread18883(tdone,ends);
        thread18884(tdone,ends);
        thread18885(tdone,ends);
        thread18886(tdone,ends);
        thread18887(tdone,ends);
        thread18888(tdone,ends);
        thread18889(tdone,ends);
        thread18890(tdone,ends);
        thread18891(tdone,ends);
        thread18892(tdone,ends);
        thread18893(tdone,ends);
        thread18894(tdone,ends);
        thread18895(tdone,ends);
        thread18896(tdone,ends);
        thread18897(tdone,ends);
        thread18898(tdone,ends);
        thread18899(tdone,ends);
        thread18900(tdone,ends);
        int biggest18901 = 0;
        if(ends[28]>=biggest18901){
          biggest18901=ends[28];
        }
        if(ends[29]>=biggest18901){
          biggest18901=ends[29];
        }
        if(ends[30]>=biggest18901){
          biggest18901=ends[30];
        }
        if(ends[31]>=biggest18901){
          biggest18901=ends[31];
        }
        if(ends[32]>=biggest18901){
          biggest18901=ends[32];
        }
        if(ends[33]>=biggest18901){
          biggest18901=ends[33];
        }
        if(ends[34]>=biggest18901){
          biggest18901=ends[34];
        }
        if(ends[35]>=biggest18901){
          biggest18901=ends[35];
        }
        if(ends[36]>=biggest18901){
          biggest18901=ends[36];
        }
        if(ends[37]>=biggest18901){
          biggest18901=ends[37];
        }
        if(ends[38]>=biggest18901){
          biggest18901=ends[38];
        }
        if(ends[39]>=biggest18901){
          biggest18901=ends[39];
        }
        if(ends[40]>=biggest18901){
          biggest18901=ends[40];
        }
        if(ends[41]>=biggest18901){
          biggest18901=ends[41];
        }
        if(ends[42]>=biggest18901){
          biggest18901=ends[42];
        }
        if(ends[43]>=biggest18901){
          biggest18901=ends[43];
        }
        if(ends[44]>=biggest18901){
          biggest18901=ends[44];
        }
        if(ends[45]>=biggest18901){
          biggest18901=ends[45];
        }
        if(ends[46]>=biggest18901){
          biggest18901=ends[46];
        }
        if(ends[47]>=biggest18901){
          biggest18901=ends[47];
        }
        if(ends[48]>=biggest18901){
          biggest18901=ends[48];
        }
        if(ends[49]>=biggest18901){
          biggest18901=ends[49];
        }
        if(ends[50]>=biggest18901){
          biggest18901=ends[50];
        }
        if(ends[51]>=biggest18901){
          biggest18901=ends[51];
        }
        if(ends[52]>=biggest18901){
          biggest18901=ends[52];
        }
        if(ends[53]>=biggest18901){
          biggest18901=ends[53];
        }
        if(ends[54]>=biggest18901){
          biggest18901=ends[54];
        }
        if(ends[55]>=biggest18901){
          biggest18901=ends[55];
        }
        if(ends[56]>=biggest18901){
          biggest18901=ends[56];
        }
        if(ends[57]>=biggest18901){
          biggest18901=ends[57];
        }
        if(ends[58]>=biggest18901){
          biggest18901=ends[58];
        }
        if(ends[59]>=biggest18901){
          biggest18901=ends[59];
        }
        if(ends[60]>=biggest18901){
          biggest18901=ends[60];
        }
        if(ends[61]>=biggest18901){
          biggest18901=ends[61];
        }
        if(ends[62]>=biggest18901){
          biggest18901=ends[62];
        }
        if(biggest18901 == 1){
          active[27]=1;
          ends[27]=1;
          tdone[27]=1;
        }
        //FINXME code
        if(biggest18901 == 0){
          S6689=0;
          active[27]=0;
          ends[27]=0;
          tdone[27]=1;
        }
        break;
      
    }
  }

  public void thread18863(int [] tdone, int [] ends){
        switch(S6351){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S6300){
          case 0 : 
            S6300=0;
            S6300=1;
            active[26]=1;
            ends[26]=1;
            tdone[26]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 403, column: 11
              S6300=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 4){//sysj\plant.sysj line: 404, column: 8
                noz4.setPresent();//sysj\plant.sysj line: 406, column: 7
                currsigs.addElement(noz4);
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
              }
              else {
                S6300=0;
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
              }
            }
            else {
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 2 : 
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 405, column: 12
              S6300=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              noz4.setPresent();//sysj\plant.sysj line: 406, column: 7
              currsigs.addElement(noz4);
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18862(int [] tdone, int [] ends){
        switch(S6297){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S6246){
          case 0 : 
            S6246=0;
            S6246=1;
            active[25]=1;
            ends[25]=1;
            tdone[25]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 391, column: 11
              S6246=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 3){//sysj\plant.sysj line: 392, column: 8
                noz3.setPresent();//sysj\plant.sysj line: 394, column: 7
                currsigs.addElement(noz3);
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
              }
              else {
                S6246=0;
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
              }
            }
            else {
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 2 : 
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 393, column: 12
              S6246=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              noz3.setPresent();//sysj\plant.sysj line: 394, column: 7
              currsigs.addElement(noz3);
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18861(int [] tdone, int [] ends){
        switch(S6243){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S6192){
          case 0 : 
            S6192=0;
            S6192=1;
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 379, column: 11
              S6192=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 2){//sysj\plant.sysj line: 380, column: 8
                noz2.setPresent();//sysj\plant.sysj line: 382, column: 7
                currsigs.addElement(noz2);
                active[24]=1;
                ends[24]=1;
                tdone[24]=1;
              }
              else {
                S6192=0;
                active[24]=1;
                ends[24]=1;
                tdone[24]=1;
              }
            }
            else {
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 2 : 
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 381, column: 12
              S6192=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              noz2.setPresent();//sysj\plant.sysj line: 382, column: 7
              currsigs.addElement(noz2);
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18860(int [] tdone, int [] ends){
        switch(S6189){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S6138){
          case 0 : 
            S6138=0;
            S6138=1;
            active[23]=1;
            ends[23]=1;
            tdone[23]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 366, column: 11
              S6138=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 1){//sysj\plant.sysj line: 367, column: 8
                noz1.setPresent();//sysj\plant.sysj line: 369, column: 7
                currsigs.addElement(noz1);
                active[23]=1;
                ends[23]=1;
                tdone[23]=1;
              }
              else {
                S6138=0;
                active[23]=1;
                ends[23]=1;
                tdone[23]=1;
              }
            }
            else {
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 2 : 
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 368, column: 12
              S6138=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              noz1.setPresent();//sysj\plant.sysj line: 369, column: 7
              currsigs.addElement(noz1);
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18859(int [] tdone, int [] ends){
        switch(S6135){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S5972){
          case 0 : 
            S5972=0;
            S5972=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 339, column: 13
              S5951=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S5972=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S5951){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 340, column: 12
                  nozzlenum_thread_22 = nozzlenum_thread_22 + 1;//sysj\plant.sysj line: 341, column: 6
                  if(nozzlenum_thread_22 > 4) {//sysj\plant.sysj line: 342, column: 24
                    nozzlenum_thread_22 = 0;//sysj\plant.sysj line: 343, column: 7
                  }
                  S5951=1;
                  s_nozzlenum_1.setPresent();//sysj\plant.sysj line: 346, column: 7
                  currsigs.addElement(s_nozzlenum_1);
                  s_nozzlenum_1.setValue(nozzlenum_thread_22);//sysj\plant.sysj line: 346, column: 7
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
              case 1 : 
                if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 345, column: 12
                  S5972=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  s_nozzlenum_1.setPresent();//sysj\plant.sysj line: 346, column: 7
                  currsigs.addElement(s_nozzlenum_1);
                  s_nozzlenum_1.setValue(nozzlenum_thread_22);//sysj\plant.sysj line: 346, column: 7
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18858(int [] tdone, int [] ends){
        switch(S6353){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        s_nozzlenum_1.setClear();//sysj\plant.sysj line: 333, column: 3
        thread18859(tdone,ends);
        thread18860(tdone,ends);
        thread18861(tdone,ends);
        thread18862(tdone,ends);
        thread18863(tdone,ends);
        int biggest18864 = 0;
        if(ends[22]>=biggest18864){
          biggest18864=ends[22];
        }
        if(ends[23]>=biggest18864){
          biggest18864=ends[23];
        }
        if(ends[24]>=biggest18864){
          biggest18864=ends[24];
        }
        if(ends[25]>=biggest18864){
          biggest18864=ends[25];
        }
        if(ends[26]>=biggest18864){
          biggest18864=ends[26];
        }
        if(biggest18864 == 1){
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        //FINXME code
        if(biggest18864 == 0){
          S6353=0;
          active[21]=0;
          ends[21]=0;
          tdone[21]=1;
        }
        break;
      
    }
  }

  public void thread18857(int [] tdone, int [] ends){
        switch(S5948){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S5877){
          case 0 : 
            S5877=0;
            S5877=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 322, column: 12
              S5864=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S5877=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S5864){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 323, column: 11
                  S5864=1;
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
                  S5877=0;
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

  public void thread18856(int [] tdone, int [] ends){
        switch(S5854){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S5853){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 305, column: 9
              S5853=1;
              S5691=0;
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
            switch(S5691){
              case 0 : 
                S5691=0;
                S5691=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 310, column: 12
                  S5678=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S5691=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                switch(S5678){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 311, column: 11
                      S5678=1;
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
                    if(!dosUnitValveExtend.getprestatus() && dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 312, column: 11
                      S5691=0;
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

  public void thread18855(int [] tdone, int [] ends){
        switch(S5664){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S5629){
          case 0 : 
            S5629=0;
            S5629=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 292, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 294, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S5629=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 293, column: 11
              S5629=0;
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

  public void thread18854(int [] tdone, int [] ends){
        switch(S5618){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S5547){
          case 0 : 
            S5547=0;
            S5547=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 280, column: 12
              S5534=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S5547=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S5534){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 281, column: 11
                  S5534=1;
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
                if(!gripperTurnRetract.getprestatus() && gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 282, column: 11
                  S5547=0;
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

  public void thread18853(int [] tdone, int [] ends){
        switch(S5524){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S5453){
          case 0 : 
            S5453=0;
            S5453=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 268, column: 12
              S5440=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S5453=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S5440){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 269, column: 11
                  S5440=1;
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
                if(!gripperTurnExtend.getprestatus() && gripperTurnRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 270, column: 11
                  S5453=0;
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

  public void thread18852(int [] tdone, int [] ends){
        switch(S5430){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S5359){
          case 0 : 
            S5359=0;
            S5359=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 256, column: 12
              S5346=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S5359=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S5346){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 257, column: 11
                  S5346=1;
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
                  S5359=0;
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

  public void thread18851(int [] tdone, int [] ends){
        switch(S5336){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S5090){
          case 0 : 
            S5090=0;
            S5090=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 236, column: 12
              rand_thread_14 = (int)(Math.random() * 100);//sysj\plant.sysj line: 237, column: 5
              System.out.println(rand_thread_14);//sysj\plant.sysj line: 238, column: 5
              S5056=0;
              if(rand_thread_14 < chance_thread_14){//sysj\plant.sysj line: 239, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 241, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S5056=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              S5090=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S5056){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 240, column: 12
                  S5056=1;
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
                  S5056=2;
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
                  S5090=0;
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

  public void thread18850(int [] tdone, int [] ends){
        switch(S5054){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S3401){
          case 0 : 
            S3401=0;
            S3401=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 206, column: 12
              S3276=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S3401=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            switch(S3276){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 207, column: 11
                  numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 208, column: 5
                  S3276=1;
                  if(numTurns_thread_13 >= 2 && numTurns_thread_13 < 3){//sysj\plant.sysj line: 209, column: 8
                    S3306=0;
                    l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 210, column: 6
                    currsigs.addElement(l_putBottleAt2_1);
                    tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 212, column: 7
                    currsigs.addElement(tableAlignedWithSensor);
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S3306=1;
                    if(numTurns_thread_13 >= 3 && numTurns_thread_13 < 4){//sysj\plant.sysj line: 214, column: 14
                      S3305=0;
                      l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 215, column: 6
                      currsigs.addElement(l_putBottleAt4_1);
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 217, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      active[13]=1;
                      ends[13]=1;
                      tdone[13]=1;
                    }
                    else {
                      S3305=1;
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
                        S3401=0;
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
                switch(S3306){
                  case 0 : 
                    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                      S3401=0;
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
                    switch(S3305){
                      case 0 : 
                        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 216, column: 12
                          S3401=0;
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
                          S3401=0;
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

  public void thread18849(int [] tdone, int [] ends){
        switch(S3274){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S3251){
          case 0 : 
            S3251=0;
            S3251=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 193, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S3251=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 194, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 195, column: 5
              currsigs.addElement(bottleLeftPos5);
              S3251=0;
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

  public void thread18848(int [] tdone, int [] ends){
        switch(S3244){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S3179){
          case 0 : 
            S3179=0;
            S3179=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 181, column: 12
              S3166=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S3179=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos4.getprestatus())){//sysj\plant.sysj line: 182, column: 11
              S3179=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S3166){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 183, column: 12
                    S3166=1;
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

  public void thread18847(int [] tdone, int [] ends){
        switch(S3158){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S3093){
          case 0 : 
            S3093=0;
            S3093=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 169, column: 12
              S3080=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S3093=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos5.getprestatus())){//sysj\plant.sysj line: 170, column: 11
              S3093=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S3080){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 171, column: 12
                    S3080=1;
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

  public void thread18846(int [] tdone, int [] ends){
        switch(S3072){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S3037){
          case 0 : 
            S3037=0;
            S3037=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 158, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S3037=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 159, column: 11
              S3037=0;
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

  public void thread18845(int [] tdone, int [] ends){
        switch(S3026){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2991){
          case 0 : 
            S2991=0;
            S2991=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S2991=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 148, column: 11
              S2991=0;
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

  public void thread18844(int [] tdone, int [] ends){
        switch(S2980){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
        switch(S2948){
          case 0 : 
            S2948=0;
            S2948=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 136, column: 11
              S2948=2;
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
              S2948=0;
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

  public void thread18843(int [] tdone, int [] ends){
        switch(S2944){
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

  public void thread18842(int [] tdone, int [] ends){
        switch(S2882){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S2836){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 98, column: 10
              S2836=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S2818){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 100, column: 13
                    S2818=1;
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
                    S2818=2;
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
                    S2818=0;
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
              S2836=0;
              S2818=0;
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

  public void thread18841(int [] tdone, int [] ends){
        switch(S2814){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S2784){
          case 0 : 
            switch(S2779){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 78, column: 12
                  S2779=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 81, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 82, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 82, column: 7
                    S2784=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S2784=1;
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
                S2784=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                    S2779=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S2784=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S2784=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S2784=1;
            S2784=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                S2779=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S2784=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S2784=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18840(int [] tdone, int [] ends){
        switch(S2770){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2724){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 62, column: 10
              S2724=1;
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
              S2724=2;
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
              S2724=3;
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
              S2724=0;
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

  public void thread18839(int [] tdone, int [] ends){
        switch(S2717){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2671){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 49, column: 10
              S2671=1;
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
              S2671=2;
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
              S2671=3;
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
              S2671=0;
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

  public void thread18836(int [] tdone, int [] ends){
        S6687=1;
    if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 506, column: 25
      bottleAddedC.setPresent();//sysj\plant.sysj line: 506, column: 38
      currsigs.addElement(bottleAddedC);
      active[62]=1;
      ends[62]=1;
      tdone[62]=1;
    }
    else {
      active[62]=1;
      ends[62]=1;
      tdone[62]=1;
    }
  }

  public void thread18835(int [] tdone, int [] ends){
        S6679=1;
    if(noz4.getprestatus()){//sysj\plant.sysj line: 504, column: 25
      noz4E.setPresent();//sysj\plant.sysj line: 504, column: 31
      currsigs.addElement(noz4E);
      active[61]=1;
      ends[61]=1;
      tdone[61]=1;
    }
    else {
      active[61]=1;
      ends[61]=1;
      tdone[61]=1;
    }
  }

  public void thread18834(int [] tdone, int [] ends){
        S6671=1;
    if(noz3.getprestatus()){//sysj\plant.sysj line: 502, column: 25
      noz3E.setPresent();//sysj\plant.sysj line: 502, column: 31
      currsigs.addElement(noz3E);
      active[60]=1;
      ends[60]=1;
      tdone[60]=1;
    }
    else {
      active[60]=1;
      ends[60]=1;
      tdone[60]=1;
    }
  }

  public void thread18833(int [] tdone, int [] ends){
        S6663=1;
    if(noz2.getprestatus()){//sysj\plant.sysj line: 500, column: 25
      noz2E.setPresent();//sysj\plant.sysj line: 500, column: 31
      currsigs.addElement(noz2E);
      active[59]=1;
      ends[59]=1;
      tdone[59]=1;
    }
    else {
      active[59]=1;
      ends[59]=1;
      tdone[59]=1;
    }
  }

  public void thread18832(int [] tdone, int [] ends){
        S6655=1;
    if(noz1.getprestatus()){//sysj\plant.sysj line: 498, column: 25
      noz1E.setPresent();//sysj\plant.sysj line: 498, column: 31
      currsigs.addElement(noz1E);
      active[58]=1;
      ends[58]=1;
      tdone[58]=1;
    }
    else {
      active[58]=1;
      ends[58]=1;
      tdone[58]=1;
    }
  }

  public void thread18831(int [] tdone, int [] ends){
        S6647=1;
    if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 496, column: 25
      capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 496, column: 44
      currsigs.addElement(capOnBottleAtPos1E);
      active[57]=1;
      ends[57]=1;
      tdone[57]=1;
    }
    else {
      active[57]=1;
      ends[57]=1;
      tdone[57]=1;
    }
  }

  public void thread18830(int [] tdone, int [] ends){
        S6639=1;
    if(selNoz4.getprestatus()){//sysj\plant.sysj line: 494, column: 25
      o_selNoz4.setPresent();//sysj\plant.sysj line: 494, column: 34
      currsigs.addElement(o_selNoz4);
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

  public void thread18829(int [] tdone, int [] ends){
        S6631=1;
    if(selNoz3.getprestatus()){//sysj\plant.sysj line: 492, column: 25
      o_selNoz3.setPresent();//sysj\plant.sysj line: 492, column: 34
      currsigs.addElement(o_selNoz3);
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

  public void thread18828(int [] tdone, int [] ends){
        S6623=1;
    if(selNoz2.getprestatus()){//sysj\plant.sysj line: 490, column: 25
      o_selNoz2.setPresent();//sysj\plant.sysj line: 490, column: 34
      currsigs.addElement(o_selNoz2);
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

  public void thread18827(int [] tdone, int [] ends){
        S6615=1;
    if(selNoz1.getprestatus()){//sysj\plant.sysj line: 488, column: 25
      o_selNoz1.setPresent();//sysj\plant.sysj line: 488, column: 34
      currsigs.addElement(o_selNoz1);
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

  public void thread18826(int [] tdone, int [] ends){
        S6607=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 485, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 485, column: 40
      currsigs.addElement(dosUnitFilledE);
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

  public void thread18825(int [] tdone, int [] ends){
        S6599=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 483, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 483, column: 38
      currsigs.addElement(dosUnitEvacE);
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

  public void thread18824(int [] tdone, int [] ends){
        S6591=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 481, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 481, column: 39
      currsigs.addElement(bottleAtPos2E);
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

  public void thread18823(int [] tdone, int [] ends){
        S6583=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 479, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 479, column: 45
      currsigs.addElement(dosUnitValveExtendE);
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

  public void thread18822(int [] tdone, int [] ends){
        S6575=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 477, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 477, column: 46
      currsigs.addElement(dosUnitValveRetractE);
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

  public void thread18821(int [] tdone, int [] ends){
        S6567=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 475, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 475, column: 42
      currsigs.addElement(valveInletOnOffE);
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

  public void thread18820(int [] tdone, int [] ends){
        S6559=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 473, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 473, column: 45
      currsigs.addElement(valveInjectorOnOffE);
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

  public void thread18819(int [] tdone, int [] ends){
        S6551=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 470, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 470, column: 47
      currsigs.addElement(cylClampBottleExtendE);
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

  public void thread18818(int [] tdone, int [] ends){
        S6543=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 468, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 468, column: 47
      currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread18817(int [] tdone, int [] ends){
        S6535=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 466, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 466, column: 44
      currsigs.addElement(gripperTurnExtendE);
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

  public void thread18816(int [] tdone, int [] ends){
        S6527=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 464, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 464, column: 45
      currsigs.addElement(gripperTurnRetractE);
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

  public void thread18815(int [] tdone, int [] ends){
        S6519=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 462, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 462, column: 45
      currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread18814(int [] tdone, int [] ends){
        S6511=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 460, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 460, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread18813(int [] tdone, int [] ends){
        S6503=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 457, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 457, column: 45
      currsigs.addElement(gripperTurnHomePosE);
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

  public void thread18812(int [] tdone, int [] ends){
        S6495=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 455, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 455, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread18811(int [] tdone, int [] ends){
        S6487=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 453, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 453, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread18810(int [] tdone, int [] ends){
        S6479=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 451, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 451, column: 38
      currsigs.addElement(bottleAtPos2E);
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

  public void thread18809(int [] tdone, int [] ends){
        S6471=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 449, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 449, column: 38
      currsigs.addElement(bottleAtPos4E);
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

  public void thread18808(int [] tdone, int [] ends){
        S6463=1;
    S6449=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 447, column: 24
      S6447=0;
      active[34]=1;
      ends[34]=1;
      tdone[34]=1;
    }
    else {
      S6449=1;
      active[34]=1;
      ends[34]=1;
      tdone[34]=1;
    }
  }

  public void thread18807(int [] tdone, int [] ends){
        S6443=1;
    S6417=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 437, column: 12
      S6415=0;
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
    else {
      S6417=1;
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
  }

  public void thread18806(int [] tdone, int [] ends){
        S6405=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 434, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 434, column: 56
      currsigs.addElement(bottleAtPos5E);
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

  public void thread18805(int [] tdone, int [] ends){
        S6397=1;
    S6383=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 432, column: 24
      S6381=0;
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
    else {
      S6383=1;
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
  }

  public void thread18804(int [] tdone, int [] ends){
        S6377=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 430, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 430, column: 44
      currsigs.addElement(rotaryTableTriggerE);
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

  public void thread18803(int [] tdone, int [] ends){
        S6369=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 428, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 428, column: 39
      currsigs.addElement(motConveyorOnE);
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread18802(int [] tdone, int [] ends){
        S6361=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 426, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 426, column: 38
      currsigs.addElement(bottleAtPos1E);
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread18801(int [] tdone, int [] ends){
        S6689=1;
    thread18802(tdone,ends);
    thread18803(tdone,ends);
    thread18804(tdone,ends);
    thread18805(tdone,ends);
    thread18806(tdone,ends);
    thread18807(tdone,ends);
    thread18808(tdone,ends);
    thread18809(tdone,ends);
    thread18810(tdone,ends);
    thread18811(tdone,ends);
    thread18812(tdone,ends);
    thread18813(tdone,ends);
    thread18814(tdone,ends);
    thread18815(tdone,ends);
    thread18816(tdone,ends);
    thread18817(tdone,ends);
    thread18818(tdone,ends);
    thread18819(tdone,ends);
    thread18820(tdone,ends);
    thread18821(tdone,ends);
    thread18822(tdone,ends);
    thread18823(tdone,ends);
    thread18824(tdone,ends);
    thread18825(tdone,ends);
    thread18826(tdone,ends);
    thread18827(tdone,ends);
    thread18828(tdone,ends);
    thread18829(tdone,ends);
    thread18830(tdone,ends);
    thread18831(tdone,ends);
    thread18832(tdone,ends);
    thread18833(tdone,ends);
    thread18834(tdone,ends);
    thread18835(tdone,ends);
    thread18836(tdone,ends);
    int biggest18837 = 0;
    if(ends[28]>=biggest18837){
      biggest18837=ends[28];
    }
    if(ends[29]>=biggest18837){
      biggest18837=ends[29];
    }
    if(ends[30]>=biggest18837){
      biggest18837=ends[30];
    }
    if(ends[31]>=biggest18837){
      biggest18837=ends[31];
    }
    if(ends[32]>=biggest18837){
      biggest18837=ends[32];
    }
    if(ends[33]>=biggest18837){
      biggest18837=ends[33];
    }
    if(ends[34]>=biggest18837){
      biggest18837=ends[34];
    }
    if(ends[35]>=biggest18837){
      biggest18837=ends[35];
    }
    if(ends[36]>=biggest18837){
      biggest18837=ends[36];
    }
    if(ends[37]>=biggest18837){
      biggest18837=ends[37];
    }
    if(ends[38]>=biggest18837){
      biggest18837=ends[38];
    }
    if(ends[39]>=biggest18837){
      biggest18837=ends[39];
    }
    if(ends[40]>=biggest18837){
      biggest18837=ends[40];
    }
    if(ends[41]>=biggest18837){
      biggest18837=ends[41];
    }
    if(ends[42]>=biggest18837){
      biggest18837=ends[42];
    }
    if(ends[43]>=biggest18837){
      biggest18837=ends[43];
    }
    if(ends[44]>=biggest18837){
      biggest18837=ends[44];
    }
    if(ends[45]>=biggest18837){
      biggest18837=ends[45];
    }
    if(ends[46]>=biggest18837){
      biggest18837=ends[46];
    }
    if(ends[47]>=biggest18837){
      biggest18837=ends[47];
    }
    if(ends[48]>=biggest18837){
      biggest18837=ends[48];
    }
    if(ends[49]>=biggest18837){
      biggest18837=ends[49];
    }
    if(ends[50]>=biggest18837){
      biggest18837=ends[50];
    }
    if(ends[51]>=biggest18837){
      biggest18837=ends[51];
    }
    if(ends[52]>=biggest18837){
      biggest18837=ends[52];
    }
    if(ends[53]>=biggest18837){
      biggest18837=ends[53];
    }
    if(ends[54]>=biggest18837){
      biggest18837=ends[54];
    }
    if(ends[55]>=biggest18837){
      biggest18837=ends[55];
    }
    if(ends[56]>=biggest18837){
      biggest18837=ends[56];
    }
    if(ends[57]>=biggest18837){
      biggest18837=ends[57];
    }
    if(ends[58]>=biggest18837){
      biggest18837=ends[58];
    }
    if(ends[59]>=biggest18837){
      biggest18837=ends[59];
    }
    if(ends[60]>=biggest18837){
      biggest18837=ends[60];
    }
    if(ends[61]>=biggest18837){
      biggest18837=ends[61];
    }
    if(ends[62]>=biggest18837){
      biggest18837=ends[62];
    }
    if(biggest18837 == 1){
      active[27]=1;
      ends[27]=1;
      tdone[27]=1;
    }
  }

  public void thread18799(int [] tdone, int [] ends){
        S6351=1;
    S6300=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void thread18798(int [] tdone, int [] ends){
        S6297=1;
    S6246=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread18797(int [] tdone, int [] ends){
        S6243=1;
    S6192=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread18796(int [] tdone, int [] ends){
        S6189=1;
    S6138=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread18795(int [] tdone, int [] ends){
        S6135=1;
    nozzlenum_thread_22 = 0;//sysj\plant.sysj line: 335, column: 4
    S5972=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread18794(int [] tdone, int [] ends){
        S6353=1;
    s_nozzlenum_1.setClear();//sysj\plant.sysj line: 333, column: 3
    thread18795(tdone,ends);
    thread18796(tdone,ends);
    thread18797(tdone,ends);
    thread18798(tdone,ends);
    thread18799(tdone,ends);
    int biggest18800 = 0;
    if(ends[22]>=biggest18800){
      biggest18800=ends[22];
    }
    if(ends[23]>=biggest18800){
      biggest18800=ends[23];
    }
    if(ends[24]>=biggest18800){
      biggest18800=ends[24];
    }
    if(ends[25]>=biggest18800){
      biggest18800=ends[25];
    }
    if(ends[26]>=biggest18800){
      biggest18800=ends[26];
    }
    if(biggest18800 == 1){
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
  }

  public void thread18793(int [] tdone, int [] ends){
        S5948=1;
    S5877=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread18792(int [] tdone, int [] ends){
        S5854=1;
    S5853=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 306, column: 4
    currsigs.addElement(dosUnitEvac);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread18791(int [] tdone, int [] ends){
        S5664=1;
    S5629=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread18790(int [] tdone, int [] ends){
        S5618=1;
    S5547=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread18789(int [] tdone, int [] ends){
        S5524=1;
    S5453=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread18788(int [] tdone, int [] ends){
        S5430=1;
    S5359=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread18787(int [] tdone, int [] ends){
        S5336=1;
    chance_thread_14 = 25;//sysj\plant.sysj line: 231, column: 3
        S5090=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread18786(int [] tdone, int [] ends){
        S5054=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 203, column: 3
    S3401=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread18785(int [] tdone, int [] ends){
        S3274=1;
    S3251=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread18784(int [] tdone, int [] ends){
        S3244=1;
    S3179=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread18783(int [] tdone, int [] ends){
        S3158=1;
    S3093=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread18782(int [] tdone, int [] ends){
        S3072=1;
    S3037=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread18781(int [] tdone, int [] ends){
        S3026=1;
    S2991=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread18780(int [] tdone, int [] ends){
        S2980=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
    S2948=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread18779(int [] tdone, int [] ends){
        S2944=1;
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

  public void thread18778(int [] tdone, int [] ends){
        S2882=1;
    S2836=0;
    S2818=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread18777(int [] tdone, int [] ends){
        S2814=1;
    S2784=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
        S2779=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S2784=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S2784=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread18776(int [] tdone, int [] ends){
        S2770=1;
    S2724=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread18775(int [] tdone, int [] ends){
        S2717=1;
    S2671=0;
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
      switch(S18773){
        case 0 : 
          S18773=0;
          break RUN;
        
        case 1 : 
          S18773=2;
          S18773=2;
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
          thread18801(tdone,ends);
          int biggest18838 = 0;
          if(ends[2]>=biggest18838){
            biggest18838=ends[2];
          }
          if(ends[3]>=biggest18838){
            biggest18838=ends[3];
          }
          if(ends[4]>=biggest18838){
            biggest18838=ends[4];
          }
          if(ends[5]>=biggest18838){
            biggest18838=ends[5];
          }
          if(ends[6]>=biggest18838){
            biggest18838=ends[6];
          }
          if(ends[7]>=biggest18838){
            biggest18838=ends[7];
          }
          if(ends[8]>=biggest18838){
            biggest18838=ends[8];
          }
          if(ends[9]>=biggest18838){
            biggest18838=ends[9];
          }
          if(ends[10]>=biggest18838){
            biggest18838=ends[10];
          }
          if(ends[11]>=biggest18838){
            biggest18838=ends[11];
          }
          if(ends[12]>=biggest18838){
            biggest18838=ends[12];
          }
          if(ends[13]>=biggest18838){
            biggest18838=ends[13];
          }
          if(ends[14]>=biggest18838){
            biggest18838=ends[14];
          }
          if(ends[15]>=biggest18838){
            biggest18838=ends[15];
          }
          if(ends[16]>=biggest18838){
            biggest18838=ends[16];
          }
          if(ends[17]>=biggest18838){
            biggest18838=ends[17];
          }
          if(ends[18]>=biggest18838){
            biggest18838=ends[18];
          }
          if(ends[19]>=biggest18838){
            biggest18838=ends[19];
          }
          if(ends[20]>=biggest18838){
            biggest18838=ends[20];
          }
          if(ends[21]>=biggest18838){
            biggest18838=ends[21];
          }
          if(ends[27]>=biggest18838){
            biggest18838=ends[27];
          }
          if(biggest18838 == 1){
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
          thread18839(tdone,ends);
          thread18840(tdone,ends);
          thread18841(tdone,ends);
          thread18842(tdone,ends);
          thread18843(tdone,ends);
          thread18844(tdone,ends);
          thread18845(tdone,ends);
          thread18846(tdone,ends);
          thread18847(tdone,ends);
          thread18848(tdone,ends);
          thread18849(tdone,ends);
          thread18850(tdone,ends);
          thread18851(tdone,ends);
          thread18852(tdone,ends);
          thread18853(tdone,ends);
          thread18854(tdone,ends);
          thread18855(tdone,ends);
          thread18856(tdone,ends);
          thread18857(tdone,ends);
          thread18858(tdone,ends);
          thread18865(tdone,ends);
          int biggest18902 = 0;
          if(ends[2]>=biggest18902){
            biggest18902=ends[2];
          }
          if(ends[3]>=biggest18902){
            biggest18902=ends[3];
          }
          if(ends[4]>=biggest18902){
            biggest18902=ends[4];
          }
          if(ends[5]>=biggest18902){
            biggest18902=ends[5];
          }
          if(ends[6]>=biggest18902){
            biggest18902=ends[6];
          }
          if(ends[7]>=biggest18902){
            biggest18902=ends[7];
          }
          if(ends[8]>=biggest18902){
            biggest18902=ends[8];
          }
          if(ends[9]>=biggest18902){
            biggest18902=ends[9];
          }
          if(ends[10]>=biggest18902){
            biggest18902=ends[10];
          }
          if(ends[11]>=biggest18902){
            biggest18902=ends[11];
          }
          if(ends[12]>=biggest18902){
            biggest18902=ends[12];
          }
          if(ends[13]>=biggest18902){
            biggest18902=ends[13];
          }
          if(ends[14]>=biggest18902){
            biggest18902=ends[14];
          }
          if(ends[15]>=biggest18902){
            biggest18902=ends[15];
          }
          if(ends[16]>=biggest18902){
            biggest18902=ends[16];
          }
          if(ends[17]>=biggest18902){
            biggest18902=ends[17];
          }
          if(ends[18]>=biggest18902){
            biggest18902=ends[18];
          }
          if(ends[19]>=biggest18902){
            biggest18902=ends[19];
          }
          if(ends[20]>=biggest18902){
            biggest18902=ends[20];
          }
          if(ends[21]>=biggest18902){
            biggest18902=ends[21];
          }
          if(ends[27]>=biggest18902){
            biggest18902=ends[27];
          }
          if(biggest18902 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest18902 == 0){
            S18773=0;
            active[1]=0;
            ends[1]=0;
            S18773=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    s_nozzlenum_1 = new Signal();
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
      bottleAddedC.setpreclear();
      capDec_1.setpreclear();
      l_bottleAdded_1.setpreclear();
      l_putBottleAt5_1.setpreclear();
      l_putBottleAt4_1.setpreclear();
      l_putBottleAt2_1.setpreclear();
      capPos_1.setpreclear();
      s_motConveyorOn_1.setpreclear();
      s_nozzlenum_1.setpreclear();
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
      bottleAddedC.sethook();
      bottleAddedC.setClear();
      capDec_1.setClear();
      l_bottleAdded_1.setClear();
      l_putBottleAt5_1.setClear();
      l_putBottleAt4_1.setClear();
      l_putBottleAt2_1.setClear();
      capPos_1.setClear();
      s_motConveyorOn_1.setClear();
      s_nozzlenum_1.setClear();
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
