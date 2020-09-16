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
  private int S18424 = 1;
  private int S2368 = 1;
  private int S2322 = 1;
  private int S2421 = 1;
  private int S2375 = 1;
  private int S2465 = 1;
  private int S2435 = 1;
  private int S2430 = 1;
  private int S2533 = 1;
  private int S2487 = 1;
  private int S2469 = 1;
  private int S2595 = 1;
  private int S2631 = 1;
  private int S2599 = 1;
  private int S2677 = 1;
  private int S2642 = 1;
  private int S2723 = 1;
  private int S2688 = 1;
  private int S2809 = 1;
  private int S2744 = 1;
  private int S2731 = 1;
  private int S2895 = 1;
  private int S2830 = 1;
  private int S2817 = 1;
  private int S2925 = 1;
  private int S2902 = 1;
  private int S4705 = 1;
  private int S3052 = 1;
  private int S2927 = 1;
  private int S2957 = 1;
  private int S2956 = 1;
  private int S4987 = 1;
  private int S4741 = 1;
  private int S4707 = 1;
  private int S5081 = 1;
  private int S5010 = 1;
  private int S4997 = 1;
  private int S5175 = 1;
  private int S5104 = 1;
  private int S5091 = 1;
  private int S5269 = 1;
  private int S5198 = 1;
  private int S5185 = 1;
  private int S5315 = 1;
  private int S5280 = 1;
  private int S5505 = 1;
  private int S5504 = 1;
  private int S5342 = 1;
  private int S5329 = 1;
  private int S5599 = 1;
  private int S5528 = 1;
  private int S5515 = 1;
  private int S6004 = 1;
  private int S5786 = 1;
  private int S5623 = 1;
  private int S5602 = 1;
  private int S5840 = 1;
  private int S5789 = 1;
  private int S5894 = 1;
  private int S5843 = 1;
  private int S5948 = 1;
  private int S5897 = 1;
  private int S6002 = 1;
  private int S5951 = 1;
  private int S6340 = 1;
  private int S6012 = 1;
  private int S6020 = 1;
  private int S6028 = 1;
  private int S6048 = 1;
  private int S6034 = 1;
  private int S6032 = 1;
  private int S6056 = 1;
  private int S6094 = 1;
  private int S6068 = 1;
  private int S6066 = 1;
  private int S6114 = 1;
  private int S6100 = 1;
  private int S6098 = 1;
  private int S6122 = 1;
  private int S6130 = 1;
  private int S6138 = 1;
  private int S6146 = 1;
  private int S6154 = 1;
  private int S6162 = 1;
  private int S6170 = 1;
  private int S6178 = 1;
  private int S6186 = 1;
  private int S6194 = 1;
  private int S6202 = 1;
  private int S6210 = 1;
  private int S6218 = 1;
  private int S6226 = 1;
  private int S6234 = 1;
  private int S6242 = 1;
  private int S6250 = 1;
  private int S6258 = 1;
  private int S6266 = 1;
  private int S6274 = 1;
  private int S6282 = 1;
  private int S6290 = 1;
  private int S6298 = 1;
  private int S6306 = 1;
  private int S6314 = 1;
  private int S6322 = 1;
  private int S6330 = 1;
  private int S6338 = 1;
  
  private int[] ends = new int[63];
  private int[] tdone = new int[63];
  
  public void thread18551(int [] tdone, int [] ends){
        switch(S6338){
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

  public void thread18550(int [] tdone, int [] ends){
        switch(S6330){
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

  public void thread18549(int [] tdone, int [] ends){
        switch(S6322){
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

  public void thread18548(int [] tdone, int [] ends){
        switch(S6314){
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

  public void thread18547(int [] tdone, int [] ends){
        switch(S6306){
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

  public void thread18546(int [] tdone, int [] ends){
        switch(S6298){
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

  public void thread18545(int [] tdone, int [] ends){
        switch(S6290){
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

  public void thread18544(int [] tdone, int [] ends){
        switch(S6282){
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

  public void thread18543(int [] tdone, int [] ends){
        switch(S6274){
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

  public void thread18542(int [] tdone, int [] ends){
        switch(S6266){
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

  public void thread18541(int [] tdone, int [] ends){
        switch(S6258){
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

  public void thread18540(int [] tdone, int [] ends){
        switch(S6250){
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

  public void thread18539(int [] tdone, int [] ends){
        switch(S6242){
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

  public void thread18538(int [] tdone, int [] ends){
        switch(S6234){
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

  public void thread18537(int [] tdone, int [] ends){
        switch(S6226){
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

  public void thread18536(int [] tdone, int [] ends){
        switch(S6218){
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

  public void thread18535(int [] tdone, int [] ends){
        switch(S6210){
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

  public void thread18534(int [] tdone, int [] ends){
        switch(S6202){
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

  public void thread18533(int [] tdone, int [] ends){
        switch(S6194){
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

  public void thread18532(int [] tdone, int [] ends){
        switch(S6186){
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

  public void thread18531(int [] tdone, int [] ends){
        switch(S6178){
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

  public void thread18530(int [] tdone, int [] ends){
        switch(S6170){
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

  public void thread18529(int [] tdone, int [] ends){
        switch(S6162){
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

  public void thread18528(int [] tdone, int [] ends){
        switch(S6154){
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

  public void thread18527(int [] tdone, int [] ends){
        switch(S6146){
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

  public void thread18526(int [] tdone, int [] ends){
        switch(S6138){
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

  public void thread18525(int [] tdone, int [] ends){
        switch(S6130){
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

  public void thread18524(int [] tdone, int [] ends){
        switch(S6122){
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

  public void thread18523(int [] tdone, int [] ends){
        switch(S6114){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        switch(S6100){
          case 0 : 
            switch(S6098){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 447, column: 54
                  S6098=1;
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
                  S6100=1;
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
            S6100=1;
            S6100=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 447, column: 24
              S6098=0;
              active[34]=1;
              ends[34]=1;
              tdone[34]=1;
            }
            else {
              S6100=1;
              active[34]=1;
              ends[34]=1;
              tdone[34]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18522(int [] tdone, int [] ends){
        switch(S6094){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        switch(S6068){
          case 0 : 
            switch(S6066){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 438, column: 11
                  S6066=1;
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
                  S6068=1;
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
            S6068=1;
            S6068=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 437, column: 12
              S6066=0;
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            else {
              S6068=1;
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18521(int [] tdone, int [] ends){
        switch(S6056){
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

  public void thread18520(int [] tdone, int [] ends){
        switch(S6048){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        switch(S6034){
          case 0 : 
            switch(S6032){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 432, column: 54
                  S6032=1;
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
                  S6034=1;
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
            S6034=1;
            S6034=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 432, column: 24
              S6032=0;
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            else {
              S6034=1;
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18519(int [] tdone, int [] ends){
        switch(S6028){
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

  public void thread18518(int [] tdone, int [] ends){
        switch(S6020){
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

  public void thread18517(int [] tdone, int [] ends){
        switch(S6012){
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

  public void thread18516(int [] tdone, int [] ends){
        switch(S6340){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        thread18517(tdone,ends);
        thread18518(tdone,ends);
        thread18519(tdone,ends);
        thread18520(tdone,ends);
        thread18521(tdone,ends);
        thread18522(tdone,ends);
        thread18523(tdone,ends);
        thread18524(tdone,ends);
        thread18525(tdone,ends);
        thread18526(tdone,ends);
        thread18527(tdone,ends);
        thread18528(tdone,ends);
        thread18529(tdone,ends);
        thread18530(tdone,ends);
        thread18531(tdone,ends);
        thread18532(tdone,ends);
        thread18533(tdone,ends);
        thread18534(tdone,ends);
        thread18535(tdone,ends);
        thread18536(tdone,ends);
        thread18537(tdone,ends);
        thread18538(tdone,ends);
        thread18539(tdone,ends);
        thread18540(tdone,ends);
        thread18541(tdone,ends);
        thread18542(tdone,ends);
        thread18543(tdone,ends);
        thread18544(tdone,ends);
        thread18545(tdone,ends);
        thread18546(tdone,ends);
        thread18547(tdone,ends);
        thread18548(tdone,ends);
        thread18549(tdone,ends);
        thread18550(tdone,ends);
        thread18551(tdone,ends);
        int biggest18552 = 0;
        if(ends[28]>=biggest18552){
          biggest18552=ends[28];
        }
        if(ends[29]>=biggest18552){
          biggest18552=ends[29];
        }
        if(ends[30]>=biggest18552){
          biggest18552=ends[30];
        }
        if(ends[31]>=biggest18552){
          biggest18552=ends[31];
        }
        if(ends[32]>=biggest18552){
          biggest18552=ends[32];
        }
        if(ends[33]>=biggest18552){
          biggest18552=ends[33];
        }
        if(ends[34]>=biggest18552){
          biggest18552=ends[34];
        }
        if(ends[35]>=biggest18552){
          biggest18552=ends[35];
        }
        if(ends[36]>=biggest18552){
          biggest18552=ends[36];
        }
        if(ends[37]>=biggest18552){
          biggest18552=ends[37];
        }
        if(ends[38]>=biggest18552){
          biggest18552=ends[38];
        }
        if(ends[39]>=biggest18552){
          biggest18552=ends[39];
        }
        if(ends[40]>=biggest18552){
          biggest18552=ends[40];
        }
        if(ends[41]>=biggest18552){
          biggest18552=ends[41];
        }
        if(ends[42]>=biggest18552){
          biggest18552=ends[42];
        }
        if(ends[43]>=biggest18552){
          biggest18552=ends[43];
        }
        if(ends[44]>=biggest18552){
          biggest18552=ends[44];
        }
        if(ends[45]>=biggest18552){
          biggest18552=ends[45];
        }
        if(ends[46]>=biggest18552){
          biggest18552=ends[46];
        }
        if(ends[47]>=biggest18552){
          biggest18552=ends[47];
        }
        if(ends[48]>=biggest18552){
          biggest18552=ends[48];
        }
        if(ends[49]>=biggest18552){
          biggest18552=ends[49];
        }
        if(ends[50]>=biggest18552){
          biggest18552=ends[50];
        }
        if(ends[51]>=biggest18552){
          biggest18552=ends[51];
        }
        if(ends[52]>=biggest18552){
          biggest18552=ends[52];
        }
        if(ends[53]>=biggest18552){
          biggest18552=ends[53];
        }
        if(ends[54]>=biggest18552){
          biggest18552=ends[54];
        }
        if(ends[55]>=biggest18552){
          biggest18552=ends[55];
        }
        if(ends[56]>=biggest18552){
          biggest18552=ends[56];
        }
        if(ends[57]>=biggest18552){
          biggest18552=ends[57];
        }
        if(ends[58]>=biggest18552){
          biggest18552=ends[58];
        }
        if(ends[59]>=biggest18552){
          biggest18552=ends[59];
        }
        if(ends[60]>=biggest18552){
          biggest18552=ends[60];
        }
        if(ends[61]>=biggest18552){
          biggest18552=ends[61];
        }
        if(ends[62]>=biggest18552){
          biggest18552=ends[62];
        }
        if(biggest18552 == 1){
          active[27]=1;
          ends[27]=1;
          tdone[27]=1;
        }
        //FINXME code
        if(biggest18552 == 0){
          S6340=0;
          active[27]=0;
          ends[27]=0;
          tdone[27]=1;
        }
        break;
      
    }
  }

  public void thread18514(int [] tdone, int [] ends){
        switch(S6002){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S5951){
          case 0 : 
            S5951=0;
            S5951=1;
            active[26]=1;
            ends[26]=1;
            tdone[26]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 403, column: 11
              S5951=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 4){//sysj\plant.sysj line: 404, column: 8
                noz4.setPresent();//sysj\plant.sysj line: 406, column: 7
                currsigs.addElement(noz4);
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
              }
              else {
                S5951=0;
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
              S5951=0;
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

  public void thread18513(int [] tdone, int [] ends){
        switch(S5948){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S5897){
          case 0 : 
            S5897=0;
            S5897=1;
            active[25]=1;
            ends[25]=1;
            tdone[25]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 391, column: 11
              S5897=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 3){//sysj\plant.sysj line: 392, column: 8
                noz3.setPresent();//sysj\plant.sysj line: 394, column: 7
                currsigs.addElement(noz3);
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
              }
              else {
                S5897=0;
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
              S5897=0;
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

  public void thread18512(int [] tdone, int [] ends){
        switch(S5894){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S5843){
          case 0 : 
            S5843=0;
            S5843=1;
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 379, column: 11
              S5843=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 2){//sysj\plant.sysj line: 380, column: 8
                noz2.setPresent();//sysj\plant.sysj line: 382, column: 7
                currsigs.addElement(noz2);
                active[24]=1;
                ends[24]=1;
                tdone[24]=1;
              }
              else {
                S5843=0;
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
              S5843=0;
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

  public void thread18511(int [] tdone, int [] ends){
        switch(S5840){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S5789){
          case 0 : 
            S5789=0;
            S5789=1;
            active[23]=1;
            ends[23]=1;
            tdone[23]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 366, column: 11
              S5789=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 1){//sysj\plant.sysj line: 367, column: 8
                noz1.setPresent();//sysj\plant.sysj line: 369, column: 7
                currsigs.addElement(noz1);
                active[23]=1;
                ends[23]=1;
                tdone[23]=1;
              }
              else {
                S5789=0;
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
              S5789=0;
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

  public void thread18510(int [] tdone, int [] ends){
        switch(S5786){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S5623){
          case 0 : 
            S5623=0;
            S5623=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 339, column: 13
              S5602=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S5623=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S5602){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 340, column: 12
                  nozzlenum_thread_22 = nozzlenum_thread_22 + 1;//sysj\plant.sysj line: 341, column: 6
                  if(nozzlenum_thread_22 > 4) {//sysj\plant.sysj line: 342, column: 24
                    nozzlenum_thread_22 = 0;//sysj\plant.sysj line: 343, column: 7
                  }
                  S5602=1;
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
                  S5623=0;
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

  public void thread18509(int [] tdone, int [] ends){
        switch(S6004){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        s_nozzlenum_1.setClear();//sysj\plant.sysj line: 333, column: 3
        thread18510(tdone,ends);
        thread18511(tdone,ends);
        thread18512(tdone,ends);
        thread18513(tdone,ends);
        thread18514(tdone,ends);
        int biggest18515 = 0;
        if(ends[22]>=biggest18515){
          biggest18515=ends[22];
        }
        if(ends[23]>=biggest18515){
          biggest18515=ends[23];
        }
        if(ends[24]>=biggest18515){
          biggest18515=ends[24];
        }
        if(ends[25]>=biggest18515){
          biggest18515=ends[25];
        }
        if(ends[26]>=biggest18515){
          biggest18515=ends[26];
        }
        if(biggest18515 == 1){
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        //FINXME code
        if(biggest18515 == 0){
          S6004=0;
          active[21]=0;
          ends[21]=0;
          tdone[21]=1;
        }
        break;
      
    }
  }

  public void thread18508(int [] tdone, int [] ends){
        switch(S5599){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S5528){
          case 0 : 
            S5528=0;
            S5528=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 322, column: 12
              S5515=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S5528=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S5515){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 323, column: 11
                  S5515=1;
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
                  S5528=0;
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

  public void thread18507(int [] tdone, int [] ends){
        switch(S5505){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S5504){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 305, column: 9
              S5504=1;
              S5342=0;
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
            switch(S5342){
              case 0 : 
                S5342=0;
                S5342=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 310, column: 12
                  S5329=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S5342=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                switch(S5329){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 311, column: 11
                      S5329=1;
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
                      S5342=0;
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

  public void thread18506(int [] tdone, int [] ends){
        switch(S5315){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S5280){
          case 0 : 
            S5280=0;
            S5280=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 292, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 294, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S5280=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 293, column: 11
              S5280=0;
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

  public void thread18505(int [] tdone, int [] ends){
        switch(S5269){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S5198){
          case 0 : 
            S5198=0;
            S5198=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 280, column: 12
              S5185=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S5198=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S5185){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 281, column: 11
                  S5185=1;
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
                  S5198=0;
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

  public void thread18504(int [] tdone, int [] ends){
        switch(S5175){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S5104){
          case 0 : 
            S5104=0;
            S5104=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 268, column: 12
              S5091=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S5104=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S5091){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 269, column: 11
                  S5091=1;
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
                  S5104=0;
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

  public void thread18503(int [] tdone, int [] ends){
        switch(S5081){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S5010){
          case 0 : 
            S5010=0;
            S5010=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 256, column: 12
              S4997=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S5010=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S4997){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 257, column: 11
                  S4997=1;
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
                  S5010=0;
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

  public void thread18502(int [] tdone, int [] ends){
        switch(S4987){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S4741){
          case 0 : 
            S4741=0;
            S4741=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 236, column: 12
              rand_thread_14 = (int)(Math.random() * 100);//sysj\plant.sysj line: 237, column: 5
              System.out.println(rand_thread_14);//sysj\plant.sysj line: 238, column: 5
              S4707=0;
              if(rand_thread_14 < chance_thread_14){//sysj\plant.sysj line: 239, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 241, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S4707=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              S4741=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S4707){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 240, column: 12
                  S4707=1;
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
                  S4707=2;
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
                  S4741=0;
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

  public void thread18501(int [] tdone, int [] ends){
        switch(S4705){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S3052){
          case 0 : 
            S3052=0;
            S3052=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 206, column: 12
              S2927=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S3052=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            switch(S2927){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 207, column: 11
                  numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 208, column: 5
                  S2927=1;
                  if(numTurns_thread_13 >= 2 && numTurns_thread_13 < 3){//sysj\plant.sysj line: 209, column: 8
                    S2957=0;
                    l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 210, column: 6
                    currsigs.addElement(l_putBottleAt2_1);
                    tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 212, column: 7
                    currsigs.addElement(tableAlignedWithSensor);
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S2957=1;
                    if(numTurns_thread_13 >= 3 && numTurns_thread_13 < 4){//sysj\plant.sysj line: 214, column: 14
                      S2956=0;
                      l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 215, column: 6
                      currsigs.addElement(l_putBottleAt4_1);
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 217, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      active[13]=1;
                      ends[13]=1;
                      tdone[13]=1;
                    }
                    else {
                      S2956=1;
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
                        S3052=0;
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
                switch(S2957){
                  case 0 : 
                    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                      S3052=0;
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
                    switch(S2956){
                      case 0 : 
                        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 216, column: 12
                          S3052=0;
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
                          S3052=0;
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

  public void thread18500(int [] tdone, int [] ends){
        switch(S2925){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S2902){
          case 0 : 
            S2902=0;
            S2902=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 193, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S2902=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 194, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 195, column: 5
              currsigs.addElement(bottleLeftPos5);
              S2902=0;
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

  public void thread18499(int [] tdone, int [] ends){
        switch(S2895){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S2830){
          case 0 : 
            S2830=0;
            S2830=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 181, column: 12
              S2817=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S2830=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos4.getprestatus())){//sysj\plant.sysj line: 182, column: 11
              S2830=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S2817){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 183, column: 12
                    S2817=1;
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

  public void thread18498(int [] tdone, int [] ends){
        switch(S2809){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S2744){
          case 0 : 
            S2744=0;
            S2744=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 169, column: 12
              S2731=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S2744=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos5.getprestatus())){//sysj\plant.sysj line: 170, column: 11
              S2744=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S2731){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 171, column: 12
                    S2731=1;
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

  public void thread18497(int [] tdone, int [] ends){
        switch(S2723){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S2688){
          case 0 : 
            S2688=0;
            S2688=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 158, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S2688=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 159, column: 11
              S2688=0;
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

  public void thread18496(int [] tdone, int [] ends){
        switch(S2677){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S2642){
          case 0 : 
            S2642=0;
            S2642=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S2642=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 148, column: 11
              S2642=0;
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

  public void thread18495(int [] tdone, int [] ends){
        switch(S2631){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
        switch(S2599){
          case 0 : 
            S2599=0;
            S2599=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 136, column: 11
              S2599=2;
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
              S2599=0;
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

  public void thread18494(int [] tdone, int [] ends){
        switch(S2595){
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

  public void thread18493(int [] tdone, int [] ends){
        switch(S2533){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S2487){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 98, column: 10
              S2487=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S2469){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 100, column: 13
                    S2469=1;
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
                    S2469=2;
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
                    S2469=0;
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
              S2487=0;
              S2469=0;
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

  public void thread18492(int [] tdone, int [] ends){
        switch(S2465){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S2435){
          case 0 : 
            switch(S2430){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 78, column: 12
                  S2430=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 81, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 82, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 82, column: 7
                    S2435=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S2435=1;
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
                S2435=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                    S2430=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S2435=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S2435=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S2435=1;
            S2435=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                S2430=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S2435=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S2435=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread18491(int [] tdone, int [] ends){
        switch(S2421){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2375){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 62, column: 10
              S2375=1;
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
              S2375=2;
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
              S2375=3;
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
              S2375=0;
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

  public void thread18490(int [] tdone, int [] ends){
        switch(S2368){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2322){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 49, column: 10
              S2322=1;
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
              S2322=2;
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
              S2322=3;
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
              S2322=0;
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

  public void thread18487(int [] tdone, int [] ends){
        S6338=1;
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

  public void thread18486(int [] tdone, int [] ends){
        S6330=1;
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

  public void thread18485(int [] tdone, int [] ends){
        S6322=1;
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

  public void thread18484(int [] tdone, int [] ends){
        S6314=1;
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

  public void thread18483(int [] tdone, int [] ends){
        S6306=1;
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

  public void thread18482(int [] tdone, int [] ends){
        S6298=1;
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

  public void thread18481(int [] tdone, int [] ends){
        S6290=1;
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

  public void thread18480(int [] tdone, int [] ends){
        S6282=1;
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

  public void thread18479(int [] tdone, int [] ends){
        S6274=1;
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

  public void thread18478(int [] tdone, int [] ends){
        S6266=1;
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

  public void thread18477(int [] tdone, int [] ends){
        S6258=1;
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

  public void thread18476(int [] tdone, int [] ends){
        S6250=1;
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

  public void thread18475(int [] tdone, int [] ends){
        S6242=1;
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

  public void thread18474(int [] tdone, int [] ends){
        S6234=1;
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

  public void thread18473(int [] tdone, int [] ends){
        S6226=1;
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

  public void thread18472(int [] tdone, int [] ends){
        S6218=1;
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

  public void thread18471(int [] tdone, int [] ends){
        S6210=1;
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

  public void thread18470(int [] tdone, int [] ends){
        S6202=1;
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

  public void thread18469(int [] tdone, int [] ends){
        S6194=1;
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

  public void thread18468(int [] tdone, int [] ends){
        S6186=1;
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

  public void thread18467(int [] tdone, int [] ends){
        S6178=1;
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

  public void thread18466(int [] tdone, int [] ends){
        S6170=1;
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

  public void thread18465(int [] tdone, int [] ends){
        S6162=1;
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

  public void thread18464(int [] tdone, int [] ends){
        S6154=1;
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

  public void thread18463(int [] tdone, int [] ends){
        S6146=1;
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

  public void thread18462(int [] tdone, int [] ends){
        S6138=1;
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

  public void thread18461(int [] tdone, int [] ends){
        S6130=1;
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

  public void thread18460(int [] tdone, int [] ends){
        S6122=1;
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

  public void thread18459(int [] tdone, int [] ends){
        S6114=1;
    S6100=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 447, column: 24
      S6098=0;
      active[34]=1;
      ends[34]=1;
      tdone[34]=1;
    }
    else {
      S6100=1;
      active[34]=1;
      ends[34]=1;
      tdone[34]=1;
    }
  }

  public void thread18458(int [] tdone, int [] ends){
        S6094=1;
    S6068=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 437, column: 12
      S6066=0;
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
    else {
      S6068=1;
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
  }

  public void thread18457(int [] tdone, int [] ends){
        S6056=1;
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

  public void thread18456(int [] tdone, int [] ends){
        S6048=1;
    S6034=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 432, column: 24
      S6032=0;
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
    else {
      S6034=1;
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
  }

  public void thread18455(int [] tdone, int [] ends){
        S6028=1;
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

  public void thread18454(int [] tdone, int [] ends){
        S6020=1;
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

  public void thread18453(int [] tdone, int [] ends){
        S6012=1;
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

  public void thread18452(int [] tdone, int [] ends){
        S6340=1;
    thread18453(tdone,ends);
    thread18454(tdone,ends);
    thread18455(tdone,ends);
    thread18456(tdone,ends);
    thread18457(tdone,ends);
    thread18458(tdone,ends);
    thread18459(tdone,ends);
    thread18460(tdone,ends);
    thread18461(tdone,ends);
    thread18462(tdone,ends);
    thread18463(tdone,ends);
    thread18464(tdone,ends);
    thread18465(tdone,ends);
    thread18466(tdone,ends);
    thread18467(tdone,ends);
    thread18468(tdone,ends);
    thread18469(tdone,ends);
    thread18470(tdone,ends);
    thread18471(tdone,ends);
    thread18472(tdone,ends);
    thread18473(tdone,ends);
    thread18474(tdone,ends);
    thread18475(tdone,ends);
    thread18476(tdone,ends);
    thread18477(tdone,ends);
    thread18478(tdone,ends);
    thread18479(tdone,ends);
    thread18480(tdone,ends);
    thread18481(tdone,ends);
    thread18482(tdone,ends);
    thread18483(tdone,ends);
    thread18484(tdone,ends);
    thread18485(tdone,ends);
    thread18486(tdone,ends);
    thread18487(tdone,ends);
    int biggest18488 = 0;
    if(ends[28]>=biggest18488){
      biggest18488=ends[28];
    }
    if(ends[29]>=biggest18488){
      biggest18488=ends[29];
    }
    if(ends[30]>=biggest18488){
      biggest18488=ends[30];
    }
    if(ends[31]>=biggest18488){
      biggest18488=ends[31];
    }
    if(ends[32]>=biggest18488){
      biggest18488=ends[32];
    }
    if(ends[33]>=biggest18488){
      biggest18488=ends[33];
    }
    if(ends[34]>=biggest18488){
      biggest18488=ends[34];
    }
    if(ends[35]>=biggest18488){
      biggest18488=ends[35];
    }
    if(ends[36]>=biggest18488){
      biggest18488=ends[36];
    }
    if(ends[37]>=biggest18488){
      biggest18488=ends[37];
    }
    if(ends[38]>=biggest18488){
      biggest18488=ends[38];
    }
    if(ends[39]>=biggest18488){
      biggest18488=ends[39];
    }
    if(ends[40]>=biggest18488){
      biggest18488=ends[40];
    }
    if(ends[41]>=biggest18488){
      biggest18488=ends[41];
    }
    if(ends[42]>=biggest18488){
      biggest18488=ends[42];
    }
    if(ends[43]>=biggest18488){
      biggest18488=ends[43];
    }
    if(ends[44]>=biggest18488){
      biggest18488=ends[44];
    }
    if(ends[45]>=biggest18488){
      biggest18488=ends[45];
    }
    if(ends[46]>=biggest18488){
      biggest18488=ends[46];
    }
    if(ends[47]>=biggest18488){
      biggest18488=ends[47];
    }
    if(ends[48]>=biggest18488){
      biggest18488=ends[48];
    }
    if(ends[49]>=biggest18488){
      biggest18488=ends[49];
    }
    if(ends[50]>=biggest18488){
      biggest18488=ends[50];
    }
    if(ends[51]>=biggest18488){
      biggest18488=ends[51];
    }
    if(ends[52]>=biggest18488){
      biggest18488=ends[52];
    }
    if(ends[53]>=biggest18488){
      biggest18488=ends[53];
    }
    if(ends[54]>=biggest18488){
      biggest18488=ends[54];
    }
    if(ends[55]>=biggest18488){
      biggest18488=ends[55];
    }
    if(ends[56]>=biggest18488){
      biggest18488=ends[56];
    }
    if(ends[57]>=biggest18488){
      biggest18488=ends[57];
    }
    if(ends[58]>=biggest18488){
      biggest18488=ends[58];
    }
    if(ends[59]>=biggest18488){
      biggest18488=ends[59];
    }
    if(ends[60]>=biggest18488){
      biggest18488=ends[60];
    }
    if(ends[61]>=biggest18488){
      biggest18488=ends[61];
    }
    if(ends[62]>=biggest18488){
      biggest18488=ends[62];
    }
    if(biggest18488 == 1){
      active[27]=1;
      ends[27]=1;
      tdone[27]=1;
    }
  }

  public void thread18450(int [] tdone, int [] ends){
        S6002=1;
    S5951=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void thread18449(int [] tdone, int [] ends){
        S5948=1;
    S5897=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread18448(int [] tdone, int [] ends){
        S5894=1;
    S5843=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread18447(int [] tdone, int [] ends){
        S5840=1;
    S5789=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread18446(int [] tdone, int [] ends){
        S5786=1;
    nozzlenum_thread_22 = 0;//sysj\plant.sysj line: 335, column: 4
    S5623=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread18445(int [] tdone, int [] ends){
        S6004=1;
    s_nozzlenum_1.setClear();//sysj\plant.sysj line: 333, column: 3
    thread18446(tdone,ends);
    thread18447(tdone,ends);
    thread18448(tdone,ends);
    thread18449(tdone,ends);
    thread18450(tdone,ends);
    int biggest18451 = 0;
    if(ends[22]>=biggest18451){
      biggest18451=ends[22];
    }
    if(ends[23]>=biggest18451){
      biggest18451=ends[23];
    }
    if(ends[24]>=biggest18451){
      biggest18451=ends[24];
    }
    if(ends[25]>=biggest18451){
      biggest18451=ends[25];
    }
    if(ends[26]>=biggest18451){
      biggest18451=ends[26];
    }
    if(biggest18451 == 1){
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
  }

  public void thread18444(int [] tdone, int [] ends){
        S5599=1;
    S5528=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread18443(int [] tdone, int [] ends){
        S5505=1;
    S5504=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 306, column: 4
    currsigs.addElement(dosUnitEvac);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread18442(int [] tdone, int [] ends){
        S5315=1;
    S5280=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread18441(int [] tdone, int [] ends){
        S5269=1;
    S5198=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread18440(int [] tdone, int [] ends){
        S5175=1;
    S5104=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread18439(int [] tdone, int [] ends){
        S5081=1;
    S5010=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread18438(int [] tdone, int [] ends){
        S4987=1;
    chance_thread_14 = 25;//sysj\plant.sysj line: 231, column: 3
        S4741=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread18437(int [] tdone, int [] ends){
        S4705=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 203, column: 3
    S3052=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread18436(int [] tdone, int [] ends){
        S2925=1;
    S2902=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread18435(int [] tdone, int [] ends){
        S2895=1;
    S2830=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread18434(int [] tdone, int [] ends){
        S2809=1;
    S2744=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread18433(int [] tdone, int [] ends){
        S2723=1;
    S2688=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread18432(int [] tdone, int [] ends){
        S2677=1;
    S2642=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread18431(int [] tdone, int [] ends){
        S2631=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
    S2599=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread18430(int [] tdone, int [] ends){
        S2595=1;
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

  public void thread18429(int [] tdone, int [] ends){
        S2533=1;
    S2487=0;
    S2469=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread18428(int [] tdone, int [] ends){
        S2465=1;
    S2435=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
        S2430=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S2435=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S2435=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread18427(int [] tdone, int [] ends){
        S2421=1;
    S2375=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread18426(int [] tdone, int [] ends){
        S2368=1;
    S2322=0;
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
      switch(S18424){
        case 0 : 
          S18424=0;
          break RUN;
        
        case 1 : 
          S18424=2;
          S18424=2;
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
          thread18426(tdone,ends);
          thread18427(tdone,ends);
          thread18428(tdone,ends);
          thread18429(tdone,ends);
          thread18430(tdone,ends);
          thread18431(tdone,ends);
          thread18432(tdone,ends);
          thread18433(tdone,ends);
          thread18434(tdone,ends);
          thread18435(tdone,ends);
          thread18436(tdone,ends);
          thread18437(tdone,ends);
          thread18438(tdone,ends);
          thread18439(tdone,ends);
          thread18440(tdone,ends);
          thread18441(tdone,ends);
          thread18442(tdone,ends);
          thread18443(tdone,ends);
          thread18444(tdone,ends);
          thread18445(tdone,ends);
          thread18452(tdone,ends);
          int biggest18489 = 0;
          if(ends[2]>=biggest18489){
            biggest18489=ends[2];
          }
          if(ends[3]>=biggest18489){
            biggest18489=ends[3];
          }
          if(ends[4]>=biggest18489){
            biggest18489=ends[4];
          }
          if(ends[5]>=biggest18489){
            biggest18489=ends[5];
          }
          if(ends[6]>=biggest18489){
            biggest18489=ends[6];
          }
          if(ends[7]>=biggest18489){
            biggest18489=ends[7];
          }
          if(ends[8]>=biggest18489){
            biggest18489=ends[8];
          }
          if(ends[9]>=biggest18489){
            biggest18489=ends[9];
          }
          if(ends[10]>=biggest18489){
            biggest18489=ends[10];
          }
          if(ends[11]>=biggest18489){
            biggest18489=ends[11];
          }
          if(ends[12]>=biggest18489){
            biggest18489=ends[12];
          }
          if(ends[13]>=biggest18489){
            biggest18489=ends[13];
          }
          if(ends[14]>=biggest18489){
            biggest18489=ends[14];
          }
          if(ends[15]>=biggest18489){
            biggest18489=ends[15];
          }
          if(ends[16]>=biggest18489){
            biggest18489=ends[16];
          }
          if(ends[17]>=biggest18489){
            biggest18489=ends[17];
          }
          if(ends[18]>=biggest18489){
            biggest18489=ends[18];
          }
          if(ends[19]>=biggest18489){
            biggest18489=ends[19];
          }
          if(ends[20]>=biggest18489){
            biggest18489=ends[20];
          }
          if(ends[21]>=biggest18489){
            biggest18489=ends[21];
          }
          if(ends[27]>=biggest18489){
            biggest18489=ends[27];
          }
          if(biggest18489 == 1){
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
          thread18490(tdone,ends);
          thread18491(tdone,ends);
          thread18492(tdone,ends);
          thread18493(tdone,ends);
          thread18494(tdone,ends);
          thread18495(tdone,ends);
          thread18496(tdone,ends);
          thread18497(tdone,ends);
          thread18498(tdone,ends);
          thread18499(tdone,ends);
          thread18500(tdone,ends);
          thread18501(tdone,ends);
          thread18502(tdone,ends);
          thread18503(tdone,ends);
          thread18504(tdone,ends);
          thread18505(tdone,ends);
          thread18506(tdone,ends);
          thread18507(tdone,ends);
          thread18508(tdone,ends);
          thread18509(tdone,ends);
          thread18516(tdone,ends);
          int biggest18553 = 0;
          if(ends[2]>=biggest18553){
            biggest18553=ends[2];
          }
          if(ends[3]>=biggest18553){
            biggest18553=ends[3];
          }
          if(ends[4]>=biggest18553){
            biggest18553=ends[4];
          }
          if(ends[5]>=biggest18553){
            biggest18553=ends[5];
          }
          if(ends[6]>=biggest18553){
            biggest18553=ends[6];
          }
          if(ends[7]>=biggest18553){
            biggest18553=ends[7];
          }
          if(ends[8]>=biggest18553){
            biggest18553=ends[8];
          }
          if(ends[9]>=biggest18553){
            biggest18553=ends[9];
          }
          if(ends[10]>=biggest18553){
            biggest18553=ends[10];
          }
          if(ends[11]>=biggest18553){
            biggest18553=ends[11];
          }
          if(ends[12]>=biggest18553){
            biggest18553=ends[12];
          }
          if(ends[13]>=biggest18553){
            biggest18553=ends[13];
          }
          if(ends[14]>=biggest18553){
            biggest18553=ends[14];
          }
          if(ends[15]>=biggest18553){
            biggest18553=ends[15];
          }
          if(ends[16]>=biggest18553){
            biggest18553=ends[16];
          }
          if(ends[17]>=biggest18553){
            biggest18553=ends[17];
          }
          if(ends[18]>=biggest18553){
            biggest18553=ends[18];
          }
          if(ends[19]>=biggest18553){
            biggest18553=ends[19];
          }
          if(ends[20]>=biggest18553){
            biggest18553=ends[20];
          }
          if(ends[21]>=biggest18553){
            biggest18553=ends[21];
          }
          if(ends[27]>=biggest18553){
            biggest18553=ends[27];
          }
          if(biggest18553 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest18553 == 0){
            S18424=0;
            active[1]=0;
            ends[1]=0;
            S18424=0;
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
