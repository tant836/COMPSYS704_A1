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
  private int S14807 = 1;
  private int S5331 = 1;
  private int S1483 = 1;
  private int S1437 = 1;
  private int S1536 = 1;
  private int S1490 = 1;
  private int S1580 = 1;
  private int S1550 = 1;
  private int S1545 = 1;
  private int S1648 = 1;
  private int S1602 = 1;
  private int S1584 = 1;
  private int S1710 = 1;
  private int S1746 = 1;
  private int S1714 = 1;
  private int S1792 = 1;
  private int S1757 = 1;
  private int S1838 = 1;
  private int S1803 = 1;
  private int S1924 = 1;
  private int S1859 = 1;
  private int S1846 = 1;
  private int S2010 = 1;
  private int S1945 = 1;
  private int S1932 = 1;
  private int S2040 = 1;
  private int S2017 = 1;
  private int S3098 = 1;
  private int S2065 = 1;
  private int S2051 = 1;
  private int S3380 = 1;
  private int S3134 = 1;
  private int S3100 = 1;
  private int S5425 = 1;
  private int S5354 = 1;
  private int S5341 = 1;
  private int S5519 = 1;
  private int S5448 = 1;
  private int S5435 = 1;
  private int S5613 = 1;
  private int S5542 = 1;
  private int S5529 = 1;
  private int S5659 = 1;
  private int S5624 = 1;
  private int S5849 = 1;
  private int S5848 = 1;
  private int S5686 = 1;
  private int S5673 = 1;
  private int S5943 = 1;
  private int S5872 = 1;
  private int S5859 = 1;
  private int S6395 = 1;
  private int S5968 = 1;
  private int S5954 = 1;
  private int S6723 = 1;
  private int S6403 = 1;
  private int S6411 = 1;
  private int S6419 = 1;
  private int S6439 = 1;
  private int S6425 = 1;
  private int S6423 = 1;
  private int S6447 = 1;
  private int S6485 = 1;
  private int S6459 = 1;
  private int S6457 = 1;
  private int S6505 = 1;
  private int S6491 = 1;
  private int S6489 = 1;
  private int S6513 = 1;
  private int S6521 = 1;
  private int S6529 = 1;
  private int S6537 = 1;
  private int S6545 = 1;
  private int S6553 = 1;
  private int S6561 = 1;
  private int S6569 = 1;
  private int S6577 = 1;
  private int S6585 = 1;
  private int S6593 = 1;
  private int S6601 = 1;
  private int S6609 = 1;
  private int S6617 = 1;
  private int S6625 = 1;
  private int S6633 = 1;
  private int S6641 = 1;
  private int S6649 = 1;
  private int S6657 = 1;
  private int S6665 = 1;
  private int S6673 = 1;
  private int S6681 = 1;
  private int S6689 = 1;
  private int S6697 = 1;
  private int S6705 = 1;
  private int S6713 = 1;
  private int S6721 = 1;
  
  private int[] ends = new int[57];
  private int[] tdone = new int[57];
  
  public void thread14922(int [] tdone, int [] ends){
        switch(S6721){
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

  public void thread14921(int [] tdone, int [] ends){
        switch(S6713){
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

  public void thread14920(int [] tdone, int [] ends){
        switch(S6705){
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

  public void thread14919(int [] tdone, int [] ends){
        switch(S6697){
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

  public void thread14918(int [] tdone, int [] ends){
        switch(S6689){
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

  public void thread14917(int [] tdone, int [] ends){
        switch(S6681){
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

  public void thread14916(int [] tdone, int [] ends){
        switch(S6673){
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

  public void thread14915(int [] tdone, int [] ends){
        switch(S6665){
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

  public void thread14914(int [] tdone, int [] ends){
        switch(S6657){
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

  public void thread14913(int [] tdone, int [] ends){
        switch(S6649){
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

  public void thread14912(int [] tdone, int [] ends){
        switch(S6641){
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

  public void thread14911(int [] tdone, int [] ends){
        switch(S6633){
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

  public void thread14910(int [] tdone, int [] ends){
        switch(S6625){
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

  public void thread14909(int [] tdone, int [] ends){
        switch(S6617){
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

  public void thread14908(int [] tdone, int [] ends){
        switch(S6609){
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

  public void thread14907(int [] tdone, int [] ends){
        switch(S6601){
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

  public void thread14906(int [] tdone, int [] ends){
        switch(S6593){
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

  public void thread14905(int [] tdone, int [] ends){
        switch(S6585){
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

  public void thread14904(int [] tdone, int [] ends){
        switch(S6577){
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

  public void thread14903(int [] tdone, int [] ends){
        switch(S6569){
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

  public void thread14902(int [] tdone, int [] ends){
        switch(S6561){
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

  public void thread14901(int [] tdone, int [] ends){
        switch(S6553){
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

  public void thread14900(int [] tdone, int [] ends){
        switch(S6545){
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

  public void thread14899(int [] tdone, int [] ends){
        switch(S6537){
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

  public void thread14898(int [] tdone, int [] ends){
        switch(S6529){
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

  public void thread14897(int [] tdone, int [] ends){
        switch(S6521){
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

  public void thread14896(int [] tdone, int [] ends){
        switch(S6513){
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

  public void thread14895(int [] tdone, int [] ends){
        switch(S6505){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S6491){
          case 0 : 
            switch(S6489){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 384, column: 54
                  S6489=1;
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
                  S6491=1;
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
            S6491=1;
            S6491=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 384, column: 24
              S6489=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S6491=1;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14894(int [] tdone, int [] ends){
        switch(S6485){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S6459){
          case 0 : 
            switch(S6457){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 375, column: 11
                  S6457=1;
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
                  S6459=1;
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
            S6459=1;
            S6459=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 374, column: 12
              S6457=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S6459=1;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14893(int [] tdone, int [] ends){
        switch(S6447){
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

  public void thread14892(int [] tdone, int [] ends){
        switch(S6439){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S6425){
          case 0 : 
            switch(S6423){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 369, column: 54
                  S6423=1;
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
                  S6425=1;
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
            S6425=1;
            S6425=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 369, column: 24
              S6423=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S6425=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14891(int [] tdone, int [] ends){
        switch(S6419){
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

  public void thread14890(int [] tdone, int [] ends){
        switch(S6411){
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

  public void thread14889(int [] tdone, int [] ends){
        switch(S6403){
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

  public void thread14888(int [] tdone, int [] ends){
        switch(S6723){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        thread14889(tdone,ends);
        thread14890(tdone,ends);
        thread14891(tdone,ends);
        thread14892(tdone,ends);
        thread14893(tdone,ends);
        thread14894(tdone,ends);
        thread14895(tdone,ends);
        thread14896(tdone,ends);
        thread14897(tdone,ends);
        thread14898(tdone,ends);
        thread14899(tdone,ends);
        thread14900(tdone,ends);
        thread14901(tdone,ends);
        thread14902(tdone,ends);
        thread14903(tdone,ends);
        thread14904(tdone,ends);
        thread14905(tdone,ends);
        thread14906(tdone,ends);
        thread14907(tdone,ends);
        thread14908(tdone,ends);
        thread14909(tdone,ends);
        thread14910(tdone,ends);
        thread14911(tdone,ends);
        thread14912(tdone,ends);
        thread14913(tdone,ends);
        thread14914(tdone,ends);
        thread14915(tdone,ends);
        thread14916(tdone,ends);
        thread14917(tdone,ends);
        thread14918(tdone,ends);
        thread14919(tdone,ends);
        thread14920(tdone,ends);
        thread14921(tdone,ends);
        thread14922(tdone,ends);
        int biggest14923 = 0;
        if(ends[23]>=biggest14923){
          biggest14923=ends[23];
        }
        if(ends[24]>=biggest14923){
          biggest14923=ends[24];
        }
        if(ends[25]>=biggest14923){
          biggest14923=ends[25];
        }
        if(ends[26]>=biggest14923){
          biggest14923=ends[26];
        }
        if(ends[27]>=biggest14923){
          biggest14923=ends[27];
        }
        if(ends[28]>=biggest14923){
          biggest14923=ends[28];
        }
        if(ends[29]>=biggest14923){
          biggest14923=ends[29];
        }
        if(ends[30]>=biggest14923){
          biggest14923=ends[30];
        }
        if(ends[31]>=biggest14923){
          biggest14923=ends[31];
        }
        if(ends[32]>=biggest14923){
          biggest14923=ends[32];
        }
        if(ends[33]>=biggest14923){
          biggest14923=ends[33];
        }
        if(ends[34]>=biggest14923){
          biggest14923=ends[34];
        }
        if(ends[35]>=biggest14923){
          biggest14923=ends[35];
        }
        if(ends[36]>=biggest14923){
          biggest14923=ends[36];
        }
        if(ends[37]>=biggest14923){
          biggest14923=ends[37];
        }
        if(ends[38]>=biggest14923){
          biggest14923=ends[38];
        }
        if(ends[39]>=biggest14923){
          biggest14923=ends[39];
        }
        if(ends[40]>=biggest14923){
          biggest14923=ends[40];
        }
        if(ends[41]>=biggest14923){
          biggest14923=ends[41];
        }
        if(ends[42]>=biggest14923){
          biggest14923=ends[42];
        }
        if(ends[43]>=biggest14923){
          biggest14923=ends[43];
        }
        if(ends[44]>=biggest14923){
          biggest14923=ends[44];
        }
        if(ends[45]>=biggest14923){
          biggest14923=ends[45];
        }
        if(ends[46]>=biggest14923){
          biggest14923=ends[46];
        }
        if(ends[47]>=biggest14923){
          biggest14923=ends[47];
        }
        if(ends[48]>=biggest14923){
          biggest14923=ends[48];
        }
        if(ends[49]>=biggest14923){
          biggest14923=ends[49];
        }
        if(ends[50]>=biggest14923){
          biggest14923=ends[50];
        }
        if(ends[51]>=biggest14923){
          biggest14923=ends[51];
        }
        if(ends[52]>=biggest14923){
          biggest14923=ends[52];
        }
        if(ends[53]>=biggest14923){
          biggest14923=ends[53];
        }
        if(ends[54]>=biggest14923){
          biggest14923=ends[54];
        }
        if(ends[55]>=biggest14923){
          biggest14923=ends[55];
        }
        if(ends[56]>=biggest14923){
          biggest14923=ends[56];
        }
        if(biggest14923 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest14923 == 0){
          S6723=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread14887(int [] tdone, int [] ends){
        switch(S6395){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S5968){
          case 0 : 
            S5968=0;
            S5968=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 332, column: 13
              S5954=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S5968=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if(!turnNozTrigger.getprestatus()){//sysj\plant.sysj line: 331, column: 10
              S5968=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              switch(S5954){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 333, column: 12
                    nozzlenum_thread_21 = nozzlenum_thread_21 + 1;//sysj\plant.sysj line: 334, column: 6
                    if(nozzlenum_thread_21 == 1){//sysj\plant.sysj line: 335, column: 9
                      noz1.setPresent();//sysj\plant.sysj line: 336, column: 7
                      currsigs.addElement(noz1);
                      S5968=0;
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      if(nozzlenum_thread_21 == 2){//sysj\plant.sysj line: 337, column: 15
                        noz2.setPresent();//sysj\plant.sysj line: 338, column: 7
                        currsigs.addElement(noz2);
                        S5968=0;
                        active[21]=1;
                        ends[21]=1;
                        tdone[21]=1;
                      }
                      else {
                        if(nozzlenum_thread_21 == 3){//sysj\plant.sysj line: 339, column: 15
                          noz3.setPresent();//sysj\plant.sysj line: 340, column: 7
                          currsigs.addElement(noz3);
                          S5968=0;
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                        else {
                          noz4.setPresent();//sysj\plant.sysj line: 342, column: 7
                          currsigs.addElement(noz4);
                          nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 343, column: 7
                          S5968=0;
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
                  S5968=0;
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

  public void thread14886(int [] tdone, int [] ends){
        switch(S5943){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S5872){
          case 0 : 
            S5872=0;
            S5872=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 317, column: 12
              S5859=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S5872=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S5859){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 318, column: 11
                  S5859=1;
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
                  S5872=0;
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

  public void thread14885(int [] tdone, int [] ends){
        switch(S5849){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S5848){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 300, column: 9
              S5848=1;
              S5686=0;
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
            switch(S5686){
              case 0 : 
                S5686=0;
                S5686=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 305, column: 12
                  S5673=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S5686=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                switch(S5673){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 306, column: 11
                      S5673=1;
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
                      S5686=0;
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

  public void thread14884(int [] tdone, int [] ends){
        switch(S5659){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S5624){
          case 0 : 
            S5624=0;
            S5624=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 288, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 290, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S5624=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 289, column: 11
              S5624=0;
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

  public void thread14883(int [] tdone, int [] ends){
        switch(S5613){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S5542){
          case 0 : 
            S5542=0;
            S5542=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 276, column: 12
              S5529=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S5542=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S5529){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 277, column: 11
                  S5529=1;
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
                  S5542=0;
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

  public void thread14882(int [] tdone, int [] ends){
        switch(S5519){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S5448){
          case 0 : 
            S5448=0;
            S5448=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 264, column: 12
              S5435=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S5448=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S5435){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 265, column: 11
                  S5435=1;
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
                  S5448=0;
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

  public void thread14881(int [] tdone, int [] ends){
        switch(S5425){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S5354){
          case 0 : 
            S5354=0;
            S5354=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 252, column: 12
              S5341=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S5354=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S5341){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 253, column: 11
                  S5341=1;
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
                  S5354=0;
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

  public void thread14878(int [] tdone, int [] ends){
        S6721=1;
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

  public void thread14877(int [] tdone, int [] ends){
        S6713=1;
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

  public void thread14876(int [] tdone, int [] ends){
        S6705=1;
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

  public void thread14875(int [] tdone, int [] ends){
        S6697=1;
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

  public void thread14874(int [] tdone, int [] ends){
        S6689=1;
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

  public void thread14873(int [] tdone, int [] ends){
        S6681=1;
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

  public void thread14872(int [] tdone, int [] ends){
        S6673=1;
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

  public void thread14871(int [] tdone, int [] ends){
        S6665=1;
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

  public void thread14870(int [] tdone, int [] ends){
        S6657=1;
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

  public void thread14869(int [] tdone, int [] ends){
        S6649=1;
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

  public void thread14868(int [] tdone, int [] ends){
        S6641=1;
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

  public void thread14867(int [] tdone, int [] ends){
        S6633=1;
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

  public void thread14866(int [] tdone, int [] ends){
        S6625=1;
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

  public void thread14865(int [] tdone, int [] ends){
        S6617=1;
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

  public void thread14864(int [] tdone, int [] ends){
        S6609=1;
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

  public void thread14863(int [] tdone, int [] ends){
        S6601=1;
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

  public void thread14862(int [] tdone, int [] ends){
        S6593=1;
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

  public void thread14861(int [] tdone, int [] ends){
        S6585=1;
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

  public void thread14860(int [] tdone, int [] ends){
        S6577=1;
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

  public void thread14859(int [] tdone, int [] ends){
        S6569=1;
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

  public void thread14858(int [] tdone, int [] ends){
        S6561=1;
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

  public void thread14857(int [] tdone, int [] ends){
        S6553=1;
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

  public void thread14856(int [] tdone, int [] ends){
        S6545=1;
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

  public void thread14855(int [] tdone, int [] ends){
        S6537=1;
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

  public void thread14854(int [] tdone, int [] ends){
        S6529=1;
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

  public void thread14853(int [] tdone, int [] ends){
        S6521=1;
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

  public void thread14852(int [] tdone, int [] ends){
        S6513=1;
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

  public void thread14851(int [] tdone, int [] ends){
        S6505=1;
    S6491=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 384, column: 24
      S6489=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S6491=1;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread14850(int [] tdone, int [] ends){
        S6485=1;
    S6459=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 374, column: 12
      S6457=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      S6459=1;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread14849(int [] tdone, int [] ends){
        S6447=1;
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

  public void thread14848(int [] tdone, int [] ends){
        S6439=1;
    S6425=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 369, column: 24
      S6423=0;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      S6425=1;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread14847(int [] tdone, int [] ends){
        S6419=1;
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

  public void thread14846(int [] tdone, int [] ends){
        S6411=1;
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

  public void thread14845(int [] tdone, int [] ends){
        S6403=1;
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

  public void thread14844(int [] tdone, int [] ends){
        S6723=1;
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
    thread14863(tdone,ends);
    thread14864(tdone,ends);
    thread14865(tdone,ends);
    thread14866(tdone,ends);
    thread14867(tdone,ends);
    thread14868(tdone,ends);
    thread14869(tdone,ends);
    thread14870(tdone,ends);
    thread14871(tdone,ends);
    thread14872(tdone,ends);
    thread14873(tdone,ends);
    thread14874(tdone,ends);
    thread14875(tdone,ends);
    thread14876(tdone,ends);
    thread14877(tdone,ends);
    thread14878(tdone,ends);
    int biggest14879 = 0;
    if(ends[23]>=biggest14879){
      biggest14879=ends[23];
    }
    if(ends[24]>=biggest14879){
      biggest14879=ends[24];
    }
    if(ends[25]>=biggest14879){
      biggest14879=ends[25];
    }
    if(ends[26]>=biggest14879){
      biggest14879=ends[26];
    }
    if(ends[27]>=biggest14879){
      biggest14879=ends[27];
    }
    if(ends[28]>=biggest14879){
      biggest14879=ends[28];
    }
    if(ends[29]>=biggest14879){
      biggest14879=ends[29];
    }
    if(ends[30]>=biggest14879){
      biggest14879=ends[30];
    }
    if(ends[31]>=biggest14879){
      biggest14879=ends[31];
    }
    if(ends[32]>=biggest14879){
      biggest14879=ends[32];
    }
    if(ends[33]>=biggest14879){
      biggest14879=ends[33];
    }
    if(ends[34]>=biggest14879){
      biggest14879=ends[34];
    }
    if(ends[35]>=biggest14879){
      biggest14879=ends[35];
    }
    if(ends[36]>=biggest14879){
      biggest14879=ends[36];
    }
    if(ends[37]>=biggest14879){
      biggest14879=ends[37];
    }
    if(ends[38]>=biggest14879){
      biggest14879=ends[38];
    }
    if(ends[39]>=biggest14879){
      biggest14879=ends[39];
    }
    if(ends[40]>=biggest14879){
      biggest14879=ends[40];
    }
    if(ends[41]>=biggest14879){
      biggest14879=ends[41];
    }
    if(ends[42]>=biggest14879){
      biggest14879=ends[42];
    }
    if(ends[43]>=biggest14879){
      biggest14879=ends[43];
    }
    if(ends[44]>=biggest14879){
      biggest14879=ends[44];
    }
    if(ends[45]>=biggest14879){
      biggest14879=ends[45];
    }
    if(ends[46]>=biggest14879){
      biggest14879=ends[46];
    }
    if(ends[47]>=biggest14879){
      biggest14879=ends[47];
    }
    if(ends[48]>=biggest14879){
      biggest14879=ends[48];
    }
    if(ends[49]>=biggest14879){
      biggest14879=ends[49];
    }
    if(ends[50]>=biggest14879){
      biggest14879=ends[50];
    }
    if(ends[51]>=biggest14879){
      biggest14879=ends[51];
    }
    if(ends[52]>=biggest14879){
      biggest14879=ends[52];
    }
    if(ends[53]>=biggest14879){
      biggest14879=ends[53];
    }
    if(ends[54]>=biggest14879){
      biggest14879=ends[54];
    }
    if(ends[55]>=biggest14879){
      biggest14879=ends[55];
    }
    if(ends[56]>=biggest14879){
      biggest14879=ends[56];
    }
    if(biggest14879 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread14843(int [] tdone, int [] ends){
        S6395=1;
    nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 328, column: 3
    S5968=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread14842(int [] tdone, int [] ends){
        S5943=1;
    S5872=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread14841(int [] tdone, int [] ends){
        S5849=1;
    S5848=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 301, column: 4
    currsigs.addElement(dosUnitEvac);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread14840(int [] tdone, int [] ends){
        S5659=1;
    S5624=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread14839(int [] tdone, int [] ends){
        S5613=1;
    S5542=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread14838(int [] tdone, int [] ends){
        S5519=1;
    S5448=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread14837(int [] tdone, int [] ends){
        S5425=1;
    S5354=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread14835(int [] tdone, int [] ends){
        switch(S3380){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S3134){
          case 0 : 
            S3134=0;
            S3134=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 233, column: 12
              rand_thread_14 = (int)(Math.random() * 100);//sysj\plant.sysj line: 234, column: 5
              System.out.println(rand_thread_14);//sysj\plant.sysj line: 235, column: 5
              S3100=0;
              if(rand_thread_14 < chance_thread_14){//sysj\plant.sysj line: 236, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 238, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S3100=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              S3134=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S3100){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 237, column: 12
                  S3100=1;
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
                  S3100=2;
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
                  S3134=0;
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

  public void thread14834(int [] tdone, int [] ends){
        switch(S3098){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S2065){
          case 0 : 
            S2065=0;
            S2065=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 207, column: 13
              S2051=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                S2065=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S2065=0;
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
                S2065=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S2065=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              switch(S2051){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 208, column: 12
                    numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 209, column: 6
                    if(numTurns_thread_13 >= 2 && numTurns_thread_13 < 3){//sysj\plant.sysj line: 210, column: 9
                      l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 211, column: 7
                      currsigs.addElement(l_putBottleAt2_1);
                      if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                        numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                        S2065=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                      else {
                        S2065=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                    }
                    else {
                      if(numTurns_thread_13 >= 3 && numTurns_thread_13 < 4){//sysj\plant.sysj line: 212, column: 15
                        l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 213, column: 7
                        currsigs.addElement(l_putBottleAt4_1);
                        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                          S2065=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        else {
                          S2065=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                      }
                      else {
                        if(numTurns_thread_13 >= 4){//sysj\plant.sysj line: 214, column: 15
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 215, column: 7
                          l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 216, column: 7
                          currsigs.addElement(l_putBottleAt5_1);
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                            S2065=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S2065=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                        }
                        else {
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                            S2065=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S2065=0;
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
                    S2065=0;
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S2065=0;
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

  public void thread14833(int [] tdone, int [] ends){
        switch(S2040){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S2017){
          case 0 : 
            S2017=0;
            S2017=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 193, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S2017=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 194, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 195, column: 5
              currsigs.addElement(bottleLeftPos5);
              S2017=0;
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

  public void thread14832(int [] tdone, int [] ends){
        switch(S2010){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1945){
          case 0 : 
            S1945=0;
            S1945=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 181, column: 12
              S1932=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S1945=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt2_1.getprestatus())){//sysj\plant.sysj line: 182, column: 11
              S1945=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S1932){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 183, column: 12
                    S1932=1;
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

  public void thread14831(int [] tdone, int [] ends){
        switch(S1924){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1859){
          case 0 : 
            S1859=0;
            S1859=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 169, column: 12
              S1846=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S1859=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt4_1.getprestatus())){//sysj\plant.sysj line: 170, column: 11
              S1859=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S1846){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 171, column: 12
                    S1846=1;
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

  public void thread14830(int [] tdone, int [] ends){
        switch(S1838){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1803){
          case 0 : 
            S1803=0;
            S1803=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 158, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S1803=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt5_1.getprestatus()) || bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 159, column: 11
              S1803=0;
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

  public void thread14829(int [] tdone, int [] ends){
        switch(S1792){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S1757){
          case 0 : 
            S1757=0;
            S1757=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S1757=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 148, column: 11
              S1757=0;
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

  public void thread14828(int [] tdone, int [] ends){
        switch(S1746){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
        switch(S1714){
          case 0 : 
            S1714=0;
            S1714=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 136, column: 11
              S1714=2;
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
              S1714=0;
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

  public void thread14827(int [] tdone, int [] ends){
        switch(S1710){
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

  public void thread14826(int [] tdone, int [] ends){
        switch(S1648){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1602){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 98, column: 10
              S1602=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1584){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 100, column: 13
                    S1584=1;
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
                    S1584=2;
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
                    S1584=0;
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
              S1602=0;
              S1584=0;
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

  public void thread14825(int [] tdone, int [] ends){
        switch(S1580){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1550){
          case 0 : 
            switch(S1545){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 78, column: 12
                  S1545=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 81, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 82, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 82, column: 7
                    S1550=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1550=1;
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
                S1550=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                    S1545=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1550=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S1550=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1550=1;
            S1550=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                S1545=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S1550=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S1550=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14824(int [] tdone, int [] ends){
        switch(S1536){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1490){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 62, column: 10
              S1490=1;
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
              S1490=2;
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
              S1490=3;
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
              S1490=0;
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

  public void thread14823(int [] tdone, int [] ends){
        switch(S1483){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S1437){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 49, column: 10
              S1437=1;
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
              S1437=2;
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
              S1437=3;
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
              S1437=0;
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

  public void thread14821(int [] tdone, int [] ends){
        S3380=1;
    chance_thread_14 = 25;//sysj\plant.sysj line: 228, column: 3
        S3134=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread14820(int [] tdone, int [] ends){
        S3098=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 203, column: 3
    S2065=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread14819(int [] tdone, int [] ends){
        S2040=1;
    S2017=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread14818(int [] tdone, int [] ends){
        S2010=1;
    S1945=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread14817(int [] tdone, int [] ends){
        S1924=1;
    S1859=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread14816(int [] tdone, int [] ends){
        S1838=1;
    S1803=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread14815(int [] tdone, int [] ends){
        S1792=1;
    S1757=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread14814(int [] tdone, int [] ends){
        S1746=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
    S1714=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread14813(int [] tdone, int [] ends){
        S1710=1;
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

  public void thread14812(int [] tdone, int [] ends){
        S1648=1;
    S1602=0;
    S1584=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread14811(int [] tdone, int [] ends){
        S1580=1;
    S1550=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
        S1545=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S1550=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S1550=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread14810(int [] tdone, int [] ends){
        S1536=1;
    S1490=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread14809(int [] tdone, int [] ends){
        S1483=1;
    S1437=0;
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
      switch(S14807){
        case 0 : 
          S14807=0;
          break RUN;
        
        case 1 : 
          S14807=2;
          S14807=2;
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
          S5331=0;
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
          thread14819(tdone,ends);
          thread14820(tdone,ends);
          thread14821(tdone,ends);
          int biggest14822 = 0;
          if(ends[2]>=biggest14822){
            biggest14822=ends[2];
          }
          if(ends[3]>=biggest14822){
            biggest14822=ends[3];
          }
          if(ends[4]>=biggest14822){
            biggest14822=ends[4];
          }
          if(ends[5]>=biggest14822){
            biggest14822=ends[5];
          }
          if(ends[6]>=biggest14822){
            biggest14822=ends[6];
          }
          if(ends[7]>=biggest14822){
            biggest14822=ends[7];
          }
          if(ends[8]>=biggest14822){
            biggest14822=ends[8];
          }
          if(ends[9]>=biggest14822){
            biggest14822=ends[9];
          }
          if(ends[10]>=biggest14822){
            biggest14822=ends[10];
          }
          if(ends[11]>=biggest14822){
            biggest14822=ends[11];
          }
          if(ends[12]>=biggest14822){
            biggest14822=ends[12];
          }
          if(ends[13]>=biggest14822){
            biggest14822=ends[13];
          }
          if(ends[14]>=biggest14822){
            biggest14822=ends[14];
          }
          if(biggest14822 == 1){
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
          switch(S5331){
            case 0 : 
              thread14823(tdone,ends);
              thread14824(tdone,ends);
              thread14825(tdone,ends);
              thread14826(tdone,ends);
              thread14827(tdone,ends);
              thread14828(tdone,ends);
              thread14829(tdone,ends);
              thread14830(tdone,ends);
              thread14831(tdone,ends);
              thread14832(tdone,ends);
              thread14833(tdone,ends);
              thread14834(tdone,ends);
              thread14835(tdone,ends);
              int biggest14836 = 0;
              if(ends[2]>=biggest14836){
                biggest14836=ends[2];
              }
              if(ends[3]>=biggest14836){
                biggest14836=ends[3];
              }
              if(ends[4]>=biggest14836){
                biggest14836=ends[4];
              }
              if(ends[5]>=biggest14836){
                biggest14836=ends[5];
              }
              if(ends[6]>=biggest14836){
                biggest14836=ends[6];
              }
              if(ends[7]>=biggest14836){
                biggest14836=ends[7];
              }
              if(ends[8]>=biggest14836){
                biggest14836=ends[8];
              }
              if(ends[9]>=biggest14836){
                biggest14836=ends[9];
              }
              if(ends[10]>=biggest14836){
                biggest14836=ends[10];
              }
              if(ends[11]>=biggest14836){
                biggest14836=ends[11];
              }
              if(ends[12]>=biggest14836){
                biggest14836=ends[12];
              }
              if(ends[13]>=biggest14836){
                biggest14836=ends[13];
              }
              if(ends[14]>=biggest14836){
                biggest14836=ends[14];
              }
              if(biggest14836 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest14836 == 0){
                S5331=1;
                thread14837(tdone,ends);
                thread14838(tdone,ends);
                thread14839(tdone,ends);
                thread14840(tdone,ends);
                thread14841(tdone,ends);
                thread14842(tdone,ends);
                thread14843(tdone,ends);
                thread14844(tdone,ends);
                int biggest14880 = 0;
                if(ends[15]>=biggest14880){
                  biggest14880=ends[15];
                }
                if(ends[16]>=biggest14880){
                  biggest14880=ends[16];
                }
                if(ends[17]>=biggest14880){
                  biggest14880=ends[17];
                }
                if(ends[18]>=biggest14880){
                  biggest14880=ends[18];
                }
                if(ends[19]>=biggest14880){
                  biggest14880=ends[19];
                }
                if(ends[20]>=biggest14880){
                  biggest14880=ends[20];
                }
                if(ends[21]>=biggest14880){
                  biggest14880=ends[21];
                }
                if(ends[22]>=biggest14880){
                  biggest14880=ends[22];
                }
                if(biggest14880 == 1){
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
            
            case 1 : 
              thread14881(tdone,ends);
              thread14882(tdone,ends);
              thread14883(tdone,ends);
              thread14884(tdone,ends);
              thread14885(tdone,ends);
              thread14886(tdone,ends);
              thread14887(tdone,ends);
              thread14888(tdone,ends);
              int biggest14924 = 0;
              if(ends[15]>=biggest14924){
                biggest14924=ends[15];
              }
              if(ends[16]>=biggest14924){
                biggest14924=ends[16];
              }
              if(ends[17]>=biggest14924){
                biggest14924=ends[17];
              }
              if(ends[18]>=biggest14924){
                biggest14924=ends[18];
              }
              if(ends[19]>=biggest14924){
                biggest14924=ends[19];
              }
              if(ends[20]>=biggest14924){
                biggest14924=ends[20];
              }
              if(ends[21]>=biggest14924){
                biggest14924=ends[21];
              }
              if(ends[22]>=biggest14924){
                biggest14924=ends[22];
              }
              if(biggest14924 == 1){
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
              //FINXME code
              if(biggest14924 == 0){
                S14807=0;
                active[1]=0;
                ends[1]=0;
                S14807=0;
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
