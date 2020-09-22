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
  public Signal turnNozTrigger = new Signal("turnNozTrigger", Signal.INPUT);
  public Signal pusherExtendE = new Signal("pusherExtendE", Signal.OUTPUT);
  public Signal vacOnE = new Signal("vacOnE", Signal.OUTPUT);
  public Signal armSourceE = new Signal("armSourceE", Signal.OUTPUT);
  public Signal armDestE = new Signal("armDestE", Signal.OUTPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.OUTPUT);
  public Signal bottleAtPos3E = new Signal("bottleAtPos3E", Signal.OUTPUT);
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
  public Signal noz1E = new Signal("noz1E", Signal.OUTPUT);
  public Signal noz2E = new Signal("noz2E", Signal.OUTPUT);
  public Signal noz3E = new Signal("noz3E", Signal.OUTPUT);
  public Signal noz4E = new Signal("noz4E", Signal.OUTPUT);
  public Signal bottleAddedC = new Signal("bottleAddedC", Signal.OUTPUT);
  public Signal bottleAtPos4_RT = new Signal("bottleAtPos4_RT", Signal.OUTPUT);
  public Signal bottleAtPos3_RT = new Signal("bottleAtPos3_RT", Signal.OUTPUT);
  public Signal bottleAtPos2_RT = new Signal("bottleAtPos2_RT", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal l_bottleAdded_1;
  private Signal l_putBottleAt5_1;
  private Signal l_putBottleAt4_1;
  private Signal l_putBottleAt2_1;
  private Signal l_putBottleAt3_1;
  private Signal capPos_1;
  private Signal s_motConveyorOn_1;
  private Signal s_nozzlenum_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 115, column: 3
  private int numTurns_thread_14;//sysj\plant.sysj line: 217, column: 3
  private Integer chance_thread_15;//sysj\plant.sysj line: 250, column: 3
  private Integer rand_thread_15;//sysj\plant.sysj line: 251, column: 3
  private int nozzlenum_thread_23;//sysj\plant.sysj line: 354, column: 4
  private int capcount_thread_67;//sysj\plant.sysj line: 594, column: 3
  private int S22867 = 1;
  private int S2978 = 1;
  private int S2932 = 1;
  private int S3031 = 1;
  private int S2985 = 1;
  private int S3075 = 1;
  private int S3045 = 1;
  private int S3040 = 1;
  private int S3143 = 1;
  private int S3097 = 1;
  private int S3079 = 1;
  private int S3205 = 1;
  private int S3241 = 1;
  private int S3209 = 1;
  private int S3287 = 1;
  private int S3252 = 1;
  private int S3333 = 1;
  private int S3298 = 1;
  private int S3419 = 1;
  private int S3354 = 1;
  private int S3341 = 1;
  private int S3505 = 1;
  private int S3440 = 1;
  private int S3427 = 1;
  private int S3591 = 1;
  private int S3526 = 1;
  private int S3513 = 1;
  private int S3621 = 1;
  private int S3598 = 1;
  private int S5911 = 1;
  private int S3622 = 1;
  private int S3624 = 1;
  private int S3658 = 1;
  private int S3657 = 1;
  private int S3656 = 1;
  private int S6193 = 1;
  private int S5947 = 1;
  private int S5913 = 1;
  private int S6287 = 1;
  private int S6216 = 1;
  private int S6203 = 1;
  private int S6381 = 1;
  private int S6310 = 1;
  private int S6297 = 1;
  private int S6475 = 1;
  private int S6404 = 1;
  private int S6391 = 1;
  private int S6521 = 1;
  private int S6486 = 1;
  private int S6711 = 1;
  private int S6710 = 1;
  private int S6548 = 1;
  private int S6535 = 1;
  private int S6805 = 1;
  private int S6734 = 1;
  private int S6721 = 1;
  private int S7210 = 1;
  private int S6992 = 1;
  private int S6829 = 1;
  private int S6808 = 1;
  private int S7046 = 1;
  private int S6995 = 1;
  private int S7100 = 1;
  private int S7049 = 1;
  private int S7154 = 1;
  private int S7103 = 1;
  private int S7208 = 1;
  private int S7157 = 1;
  private int S7538 = 1;
  private int S7218 = 1;
  private int S7226 = 1;
  private int S7234 = 1;
  private int S7254 = 1;
  private int S7240 = 1;
  private int S7238 = 1;
  private int S7262 = 1;
  private int S7270 = 1;
  private int S7278 = 1;
  private int S7286 = 1;
  private int S7324 = 1;
  private int S7298 = 1;
  private int S7296 = 1;
  private int S7344 = 1;
  private int S7330 = 1;
  private int S7328 = 1;
  private int S7352 = 1;
  private int S7360 = 1;
  private int S7368 = 1;
  private int S7376 = 1;
  private int S7384 = 1;
  private int S7392 = 1;
  private int S7400 = 1;
  private int S7408 = 1;
  private int S7416 = 1;
  private int S7424 = 1;
  private int S7432 = 1;
  private int S7440 = 1;
  private int S7448 = 1;
  private int S7456 = 1;
  private int S7464 = 1;
  private int S7472 = 1;
  private int S7480 = 1;
  private int S7488 = 1;
  private int S7496 = 1;
  private int S7504 = 1;
  private int S7512 = 1;
  private int S7520 = 1;
  private int S7528 = 1;
  private int S7536 = 1;
  private int S7591 = 1;
  private int S7545 = 1;
  private int S7644 = 1;
  private int S7598 = 1;
  private int S7688 = 1;
  private int S7658 = 1;
  private int S7756 = 1;
  private int S7710 = 1;
  private int S7692 = 1;
  private int S7818 = 1;
  private int S7908 = 1;
  private int S7826 = 1;
  private int S7834 = 1;
  private int S7842 = 1;
  private int S7850 = 1;
  private int S7858 = 1;
  private int S7866 = 1;
  private int S7874 = 1;
  private int S7882 = 1;
  private int S7890 = 1;
  private int S7898 = 1;
  private int S7906 = 1;
  
  private int[] ends = new int[80];
  private int[] tdone = new int[80];
  
  public void thread23030(int [] tdone, int [] ends){
        switch(S7906){
      case 0 : 
        active[79]=0;
        ends[79]=0;
        tdone[79]=1;
        break;
      
      case 1 : 
        if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 633, column: 24
          bottleAtPos3E.setPresent();//sysj\plant.sysj line: 633, column: 38
          currsigs.addElement(bottleAtPos3E);
          active[79]=1;
          ends[79]=1;
          tdone[79]=1;
        }
        else {
          active[79]=1;
          ends[79]=1;
          tdone[79]=1;
        }
        break;
      
    }
  }

  public void thread23029(int [] tdone, int [] ends){
        switch(S7898){
      case 0 : 
        active[78]=0;
        ends[78]=0;
        tdone[78]=1;
        break;
      
      case 1 : 
        if(armDest.getprestatus()){//sysj\plant.sysj line: 631, column: 24
          armDestE.setPresent();//sysj\plant.sysj line: 631, column: 33
          currsigs.addElement(armDestE);
          active[78]=1;
          ends[78]=1;
          tdone[78]=1;
        }
        else {
          active[78]=1;
          ends[78]=1;
          tdone[78]=1;
        }
        break;
      
    }
  }

  public void thread23028(int [] tdone, int [] ends){
        switch(S7890){
      case 0 : 
        active[77]=0;
        ends[77]=0;
        tdone[77]=1;
        break;
      
      case 1 : 
        if(armSource.getprestatus()){//sysj\plant.sysj line: 629, column: 24
          armSourceE.setPresent();//sysj\plant.sysj line: 629, column: 35
          currsigs.addElement(armSourceE);
          active[77]=1;
          ends[77]=1;
          tdone[77]=1;
        }
        else {
          active[77]=1;
          ends[77]=1;
          tdone[77]=1;
        }
        break;
      
    }
  }

  public void thread23027(int [] tdone, int [] ends){
        switch(S7882){
      case 0 : 
        active[76]=0;
        ends[76]=0;
        tdone[76]=1;
        break;
      
      case 1 : 
        if(vacOn.getprestatus()){//sysj\plant.sysj line: 627, column: 24
          vacOnE.setPresent();//sysj\plant.sysj line: 627, column: 31
          currsigs.addElement(vacOnE);
          active[76]=1;
          ends[76]=1;
          tdone[76]=1;
        }
        else {
          active[76]=1;
          ends[76]=1;
          tdone[76]=1;
        }
        break;
      
    }
  }

  public void thread23026(int [] tdone, int [] ends){
        switch(S7874){
      case 0 : 
        active[75]=0;
        ends[75]=0;
        tdone[75]=1;
        break;
      
      case 1 : 
        if(pusherExtend.getprestatus()){//sysj\plant.sysj line: 625, column: 24
          pusherExtendE.setPresent();//sysj\plant.sysj line: 625, column: 38
          currsigs.addElement(pusherExtendE);
          active[75]=1;
          ends[75]=1;
          tdone[75]=1;
        }
        else {
          active[75]=1;
          ends[75]=1;
          tdone[75]=1;
        }
        break;
      
    }
  }

  public void thread23025(int [] tdone, int [] ends){
        switch(S7866){
      case 0 : 
        active[74]=0;
        ends[74]=0;
        tdone[74]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\plant.sysj line: 622, column: 24
          emptyE.setPresent();//sysj\plant.sysj line: 622, column: 31
          currsigs.addElement(emptyE);
          active[74]=1;
          ends[74]=1;
          tdone[74]=1;
        }
        else {
          active[74]=1;
          ends[74]=1;
          tdone[74]=1;
        }
        break;
      
    }
  }

  public void thread23024(int [] tdone, int [] ends){
        switch(S7858){
      case 0 : 
        active[73]=0;
        ends[73]=0;
        tdone[73]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\plant.sysj line: 620, column: 24
          armAtDestE.setPresent();//sysj\plant.sysj line: 620, column: 35
          currsigs.addElement(armAtDestE);
          active[73]=1;
          ends[73]=1;
          tdone[73]=1;
        }
        else {
          active[73]=1;
          ends[73]=1;
          tdone[73]=1;
        }
        break;
      
    }
  }

  public void thread23023(int [] tdone, int [] ends){
        switch(S7850){
      case 0 : 
        active[72]=0;
        ends[72]=0;
        tdone[72]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\plant.sysj line: 618, column: 24
          armAtSourceE.setPresent();//sysj\plant.sysj line: 618, column: 37
          currsigs.addElement(armAtSourceE);
          active[72]=1;
          ends[72]=1;
          tdone[72]=1;
        }
        else {
          active[72]=1;
          ends[72]=1;
          tdone[72]=1;
        }
        break;
      
    }
  }

  public void thread23022(int [] tdone, int [] ends){
        switch(S7842){
      case 0 : 
        active[71]=0;
        ends[71]=0;
        tdone[71]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\plant.sysj line: 616, column: 24
          WPgrippedE.setPresent();//sysj\plant.sysj line: 616, column: 35
          currsigs.addElement(WPgrippedE);
          active[71]=1;
          ends[71]=1;
          tdone[71]=1;
        }
        else {
          active[71]=1;
          ends[71]=1;
          tdone[71]=1;
        }
        break;
      
    }
  }

  public void thread23021(int [] tdone, int [] ends){
        switch(S7834){
      case 0 : 
        active[70]=0;
        ends[70]=0;
        tdone[70]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 614, column: 24
          pusherExtendedE.setPresent();//sysj\plant.sysj line: 614, column: 40
          currsigs.addElement(pusherExtendedE);
          active[70]=1;
          ends[70]=1;
          tdone[70]=1;
        }
        else {
          active[70]=1;
          ends[70]=1;
          tdone[70]=1;
        }
        break;
      
    }
  }

  public void thread23020(int [] tdone, int [] ends){
        switch(S7826){
      case 0 : 
        active[69]=0;
        ends[69]=0;
        tdone[69]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 612, column: 24
          pusherRetractedE.setPresent();//sysj\plant.sysj line: 612, column: 41
          currsigs.addElement(pusherRetractedE);
          active[69]=1;
          ends[69]=1;
          tdone[69]=1;
        }
        else {
          active[69]=1;
          ends[69]=1;
          tdone[69]=1;
        }
        break;
      
    }
  }

  public void thread23019(int [] tdone, int [] ends){
        switch(S7908){
      case 0 : 
        active[68]=0;
        ends[68]=0;
        tdone[68]=1;
        break;
      
      case 1 : 
        thread23020(tdone,ends);
        thread23021(tdone,ends);
        thread23022(tdone,ends);
        thread23023(tdone,ends);
        thread23024(tdone,ends);
        thread23025(tdone,ends);
        thread23026(tdone,ends);
        thread23027(tdone,ends);
        thread23028(tdone,ends);
        thread23029(tdone,ends);
        thread23030(tdone,ends);
        int biggest23031 = 0;
        if(ends[69]>=biggest23031){
          biggest23031=ends[69];
        }
        if(ends[70]>=biggest23031){
          biggest23031=ends[70];
        }
        if(ends[71]>=biggest23031){
          biggest23031=ends[71];
        }
        if(ends[72]>=biggest23031){
          biggest23031=ends[72];
        }
        if(ends[73]>=biggest23031){
          biggest23031=ends[73];
        }
        if(ends[74]>=biggest23031){
          biggest23031=ends[74];
        }
        if(ends[75]>=biggest23031){
          biggest23031=ends[75];
        }
        if(ends[76]>=biggest23031){
          biggest23031=ends[76];
        }
        if(ends[77]>=biggest23031){
          biggest23031=ends[77];
        }
        if(ends[78]>=biggest23031){
          biggest23031=ends[78];
        }
        if(ends[79]>=biggest23031){
          biggest23031=ends[79];
        }
        if(biggest23031 == 1){
          active[68]=1;
          ends[68]=1;
          tdone[68]=1;
        }
        //FINXME code
        if(biggest23031 == 0){
          S7908=0;
          active[68]=0;
          ends[68]=0;
          tdone[68]=1;
        }
        break;
      
    }
  }

  public void thread23018(int [] tdone, int [] ends){
        switch(S7818){
      case 0 : 
        active[67]=0;
        ends[67]=0;
        tdone[67]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 596, column: 12
          if(capcount_thread_67 > 0) {//sysj\plant.sysj line: 597, column: 5
            capcount_thread_67 = capcount_thread_67 - 1;//sysj\plant.sysj line: 598, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 600, column: 12
            capcount_thread_67 = 5;//sysj\plant.sysj line: 601, column: 5
            if(capcount_thread_67 == 0){//sysj\plant.sysj line: 604, column: 8
              empty.setPresent();//sysj\plant.sysj line: 605, column: 6
              currsigs.addElement(empty);
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
            else {
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
          }
          else {
            if(capcount_thread_67 == 0){//sysj\plant.sysj line: 604, column: 8
              empty.setPresent();//sysj\plant.sysj line: 605, column: 6
              currsigs.addElement(empty);
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
            else {
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
          }
        }
        else {
          if(refill.getprestatus()){//sysj\plant.sysj line: 600, column: 12
            capcount_thread_67 = 5;//sysj\plant.sysj line: 601, column: 5
            if(capcount_thread_67 == 0){//sysj\plant.sysj line: 604, column: 8
              empty.setPresent();//sysj\plant.sysj line: 605, column: 6
              currsigs.addElement(empty);
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
            else {
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
          }
          else {
            if(capcount_thread_67 == 0){//sysj\plant.sysj line: 604, column: 8
              empty.setPresent();//sysj\plant.sysj line: 605, column: 6
              currsigs.addElement(empty);
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
            else {
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread23017(int [] tdone, int [] ends){
        switch(S7756){
      case 0 : 
        active[66]=0;
        ends[66]=0;
        tdone[66]=1;
        break;
      
      case 1 : 
        switch(S7710){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 579, column: 10
              S7710=1;
              active[66]=1;
              ends[66]=1;
              tdone[66]=1;
            }
            else {
              switch(S7692){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 581, column: 13
                    S7692=1;
                    active[66]=1;
                    ends[66]=1;
                    tdone[66]=1;
                  }
                  else {
                    active[66]=1;
                    ends[66]=1;
                    tdone[66]=1;
                  }
                  break;
                
                case 1 : 
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 582, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 584, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 584, column: 7
                    S7692=2;
                    active[66]=1;
                    ends[66]=1;
                    tdone[66]=1;
                  }
                  else {
                    active[66]=1;
                    ends[66]=1;
                    tdone[66]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 585, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 586, column: 7
                    currsigs.addElement(capDec_1);
                    S7692=0;
                    active[66]=1;
                    ends[66]=1;
                    tdone[66]=1;
                  }
                  else {
                    active[66]=1;
                    ends[66]=1;
                    tdone[66]=1;
                  }
                  break;
                
              }
            }
            break;
          
          case 1 : 
            if(refill.getprestatus()){//sysj\plant.sysj line: 589, column: 10
              S7710=0;
              S7692=0;
              active[66]=1;
              ends[66]=1;
              tdone[66]=1;
            }
            else {
              active[66]=1;
              ends[66]=1;
              tdone[66]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread23016(int [] tdone, int [] ends){
        switch(S7688){
      case 0 : 
        active[65]=0;
        ends[65]=0;
        tdone[65]=1;
        break;
      
      case 1 : 
        switch(S7658){
          case 0 : 
            if(!vacOn.getprestatus()){//sysj\plant.sysj line: 559, column: 12
              if(armAtSource.getprestatus()){//sysj\plant.sysj line: 562, column: 14
                capPos_1.setPresent();//sysj\plant.sysj line: 563, column: 7
                currsigs.addElement(capPos_1);
                capPos_1.setValue(1);//sysj\plant.sysj line: 563, column: 7
                S7658=1;
                active[65]=1;
                ends[65]=1;
                tdone[65]=1;
              }
              else {
                S7658=1;
                active[65]=1;
                ends[65]=1;
                tdone[65]=1;
              }
            }
            else {
              WPgripped.setPresent();//sysj\plant.sysj line: 560, column: 7
              currsigs.addElement(WPgripped);
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            break;
          
          case 1 : 
            S7658=1;
            S7658=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 556, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 557, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 558, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 558, column: 6
                WPgripped.setPresent();//sysj\plant.sysj line: 560, column: 7
                currsigs.addElement(WPgripped);
                active[65]=1;
                ends[65]=1;
                tdone[65]=1;
              }
              else {
                S7658=1;
                active[65]=1;
                ends[65]=1;
                tdone[65]=1;
              }
            }
            else {
              S7658=1;
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread23015(int [] tdone, int [] ends){
        switch(S7644){
      case 0 : 
        active[64]=0;
        ends[64]=0;
        tdone[64]=1;
        break;
      
      case 1 : 
        switch(S7598){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 543, column: 10
              S7598=1;
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 544, column: 5
              currsigs.addElement(pusherRetracted);
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 546, column: 10
              S7598=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 548, column: 5
              currsigs.addElement(pusherExtended);
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            else {
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            break;
          
          case 2 : 
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 547, column: 10
              S7598=3;
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 548, column: 5
              currsigs.addElement(pusherExtended);
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 550, column: 10
              S7598=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 544, column: 5
              currsigs.addElement(pusherRetracted);
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            else {
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread23014(int [] tdone, int [] ends){
        switch(S7591){
      case 0 : 
        active[63]=0;
        ends[63]=0;
        tdone[63]=1;
        break;
      
      case 1 : 
        switch(S7545){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 530, column: 10
              S7545=1;
              active[63]=1;
              ends[63]=1;
              tdone[63]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 531, column: 5
              currsigs.addElement(armAtDest);
              active[63]=1;
              ends[63]=1;
              tdone[63]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 533, column: 10
              S7545=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 535, column: 5
              currsigs.addElement(armAtSource);
              active[63]=1;
              ends[63]=1;
              tdone[63]=1;
            }
            else {
              active[63]=1;
              ends[63]=1;
              tdone[63]=1;
            }
            break;
          
          case 2 : 
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 534, column: 10
              S7545=3;
              active[63]=1;
              ends[63]=1;
              tdone[63]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 535, column: 5
              currsigs.addElement(armAtSource);
              active[63]=1;
              ends[63]=1;
              tdone[63]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 537, column: 10
              S7545=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 531, column: 5
              currsigs.addElement(armAtDest);
              active[63]=1;
              ends[63]=1;
              tdone[63]=1;
            }
            else {
              active[63]=1;
              ends[63]=1;
              tdone[63]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread23012(int [] tdone, int [] ends){
        switch(S7536){
      case 0 : 
        active[62]=0;
        ends[62]=0;
        tdone[62]=1;
        break;
      
      case 1 : 
        if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 524, column: 25
          bottleAddedC.setPresent();//sysj\plant.sysj line: 524, column: 38
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

  public void thread23011(int [] tdone, int [] ends){
        switch(S7528){
      case 0 : 
        active[61]=0;
        ends[61]=0;
        tdone[61]=1;
        break;
      
      case 1 : 
        if(noz4.getprestatus()){//sysj\plant.sysj line: 522, column: 25
          noz4E.setPresent();//sysj\plant.sysj line: 522, column: 31
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

  public void thread23010(int [] tdone, int [] ends){
        switch(S7520){
      case 0 : 
        active[60]=0;
        ends[60]=0;
        tdone[60]=1;
        break;
      
      case 1 : 
        if(noz3.getprestatus()){//sysj\plant.sysj line: 520, column: 25
          noz3E.setPresent();//sysj\plant.sysj line: 520, column: 31
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

  public void thread23009(int [] tdone, int [] ends){
        switch(S7512){
      case 0 : 
        active[59]=0;
        ends[59]=0;
        tdone[59]=1;
        break;
      
      case 1 : 
        if(noz2.getprestatus()){//sysj\plant.sysj line: 518, column: 25
          noz2E.setPresent();//sysj\plant.sysj line: 518, column: 31
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

  public void thread23008(int [] tdone, int [] ends){
        switch(S7504){
      case 0 : 
        active[58]=0;
        ends[58]=0;
        tdone[58]=1;
        break;
      
      case 1 : 
        if(noz1.getprestatus()){//sysj\plant.sysj line: 516, column: 25
          noz1E.setPresent();//sysj\plant.sysj line: 516, column: 31
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

  public void thread23007(int [] tdone, int [] ends){
        switch(S7496){
      case 0 : 
        active[57]=0;
        ends[57]=0;
        tdone[57]=1;
        break;
      
      case 1 : 
        if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 514, column: 25
          capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 514, column: 44
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

  public void thread23006(int [] tdone, int [] ends){
        switch(S7488){
      case 0 : 
        active[56]=0;
        ends[56]=0;
        tdone[56]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 510, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 510, column: 40
          currsigs.addElement(dosUnitFilledE);
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

  public void thread23005(int [] tdone, int [] ends){
        switch(S7480){
      case 0 : 
        active[55]=0;
        ends[55]=0;
        tdone[55]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 508, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 508, column: 38
          currsigs.addElement(dosUnitEvacE);
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

  public void thread23004(int [] tdone, int [] ends){
        switch(S7472){
      case 0 : 
        active[54]=0;
        ends[54]=0;
        tdone[54]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 506, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 506, column: 39
          currsigs.addElement(bottleAtPos2E);
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

  public void thread23003(int [] tdone, int [] ends){
        switch(S7464){
      case 0 : 
        active[53]=0;
        ends[53]=0;
        tdone[53]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 504, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 504, column: 45
          currsigs.addElement(dosUnitValveExtendE);
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

  public void thread23002(int [] tdone, int [] ends){
        switch(S7456){
      case 0 : 
        active[52]=0;
        ends[52]=0;
        tdone[52]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 502, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 502, column: 46
          currsigs.addElement(dosUnitValveRetractE);
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

  public void thread23001(int [] tdone, int [] ends){
        switch(S7448){
      case 0 : 
        active[51]=0;
        ends[51]=0;
        tdone[51]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 500, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 500, column: 42
          currsigs.addElement(valveInletOnOffE);
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

  public void thread23000(int [] tdone, int [] ends){
        switch(S7440){
      case 0 : 
        active[50]=0;
        ends[50]=0;
        tdone[50]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 498, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 498, column: 45
          currsigs.addElement(valveInjectorOnOffE);
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

  public void thread22999(int [] tdone, int [] ends){
        switch(S7432){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 495, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 495, column: 47
          currsigs.addElement(cylClampBottleExtendE);
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

  public void thread22998(int [] tdone, int [] ends){
        switch(S7424){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 493, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 493, column: 47
          currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread22997(int [] tdone, int [] ends){
        switch(S7416){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 491, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 491, column: 44
          currsigs.addElement(gripperTurnExtendE);
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

  public void thread22996(int [] tdone, int [] ends){
        switch(S7408){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 489, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 489, column: 45
          currsigs.addElement(gripperTurnRetractE);
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

  public void thread22995(int [] tdone, int [] ends){
        switch(S7400){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 487, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 487, column: 45
          currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread22994(int [] tdone, int [] ends){
        switch(S7392){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 485, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 485, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread22993(int [] tdone, int [] ends){
        switch(S7384){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 482, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 482, column: 45
          currsigs.addElement(gripperTurnHomePosE);
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

  public void thread22992(int [] tdone, int [] ends){
        switch(S7376){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 480, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 480, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread22991(int [] tdone, int [] ends){
        switch(S7368){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 478, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 478, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread22990(int [] tdone, int [] ends){
        switch(S7360){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 476, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 476, column: 38
          currsigs.addElement(bottleAtPos2E);
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

  public void thread22989(int [] tdone, int [] ends){
        switch(S7352){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 474, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 474, column: 38
          currsigs.addElement(bottleAtPos4E);
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

  public void thread22988(int [] tdone, int [] ends){
        switch(S7344){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        switch(S7330){
          case 0 : 
            switch(S7328){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 472, column: 54
                  S7328=1;
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
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 472, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 472, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  S7330=1;
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
            break;
          
          case 1 : 
            S7330=1;
            S7330=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 472, column: 24
              S7328=0;
              active[38]=1;
              ends[38]=1;
              tdone[38]=1;
            }
            else {
              S7330=1;
              active[38]=1;
              ends[38]=1;
              tdone[38]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22987(int [] tdone, int [] ends){
        switch(S7324){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        switch(S7298){
          case 0 : 
            switch(S7296){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 463, column: 11
                  S7296=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 465, column: 6
                  currsigs.addElement(bottleLeftPos5E);
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
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 464, column: 11
                  S7298=1;
                  active[37]=1;
                  ends[37]=1;
                  tdone[37]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 465, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[37]=1;
                  ends[37]=1;
                  tdone[37]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S7298=1;
            S7298=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 462, column: 12
              S7296=0;
              active[37]=1;
              ends[37]=1;
              tdone[37]=1;
            }
            else {
              S7298=1;
              active[37]=1;
              ends[37]=1;
              tdone[37]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22986(int [] tdone, int [] ends){
        switch(S7286){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 459, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 459, column: 56
          currsigs.addElement(bottleAtPos5E);
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

  public void thread22985(int [] tdone, int [] ends){
        switch(S7278){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 457, column: 24
          bottleAtPos4_RT.setPresent();//sysj\plant.sysj line: 457, column: 38
          currsigs.addElement(bottleAtPos4_RT);
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

  public void thread22984(int [] tdone, int [] ends){
        switch(S7270){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 455, column: 24
          bottleAtPos3_RT.setPresent();//sysj\plant.sysj line: 455, column: 38
          currsigs.addElement(bottleAtPos3_RT);
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

  public void thread22983(int [] tdone, int [] ends){
        switch(S7262){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 453, column: 24
          bottleAtPos2_RT.setPresent();//sysj\plant.sysj line: 453, column: 38
          currsigs.addElement(bottleAtPos2_RT);
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

  public void thread22982(int [] tdone, int [] ends){
        switch(S7254){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        switch(S7240){
          case 0 : 
            switch(S7238){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 451, column: 54
                  S7238=1;
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
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 451, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 451, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  S7240=1;
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
            break;
          
          case 1 : 
            S7240=1;
            S7240=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 451, column: 24
              S7238=0;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            else {
              S7240=1;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22981(int [] tdone, int [] ends){
        switch(S7234){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 449, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 449, column: 44
          currsigs.addElement(rotaryTableTriggerE);
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

  public void thread22980(int [] tdone, int [] ends){
        switch(S7226){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 447, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 447, column: 39
          currsigs.addElement(motConveyorOnE);
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

  public void thread22979(int [] tdone, int [] ends){
        switch(S7218){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 445, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 445, column: 38
          currsigs.addElement(bottleAtPos1E);
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

  public void thread22978(int [] tdone, int [] ends){
        switch(S7538){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        thread22979(tdone,ends);
        thread22980(tdone,ends);
        thread22981(tdone,ends);
        thread22982(tdone,ends);
        thread22983(tdone,ends);
        thread22984(tdone,ends);
        thread22985(tdone,ends);
        thread22986(tdone,ends);
        thread22987(tdone,ends);
        thread22988(tdone,ends);
        thread22989(tdone,ends);
        thread22990(tdone,ends);
        thread22991(tdone,ends);
        thread22992(tdone,ends);
        thread22993(tdone,ends);
        thread22994(tdone,ends);
        thread22995(tdone,ends);
        thread22996(tdone,ends);
        thread22997(tdone,ends);
        thread22998(tdone,ends);
        thread22999(tdone,ends);
        thread23000(tdone,ends);
        thread23001(tdone,ends);
        thread23002(tdone,ends);
        thread23003(tdone,ends);
        thread23004(tdone,ends);
        thread23005(tdone,ends);
        thread23006(tdone,ends);
        thread23007(tdone,ends);
        thread23008(tdone,ends);
        thread23009(tdone,ends);
        thread23010(tdone,ends);
        thread23011(tdone,ends);
        thread23012(tdone,ends);
        int biggest23013 = 0;
        if(ends[29]>=biggest23013){
          biggest23013=ends[29];
        }
        if(ends[30]>=biggest23013){
          biggest23013=ends[30];
        }
        if(ends[31]>=biggest23013){
          biggest23013=ends[31];
        }
        if(ends[32]>=biggest23013){
          biggest23013=ends[32];
        }
        if(ends[33]>=biggest23013){
          biggest23013=ends[33];
        }
        if(ends[34]>=biggest23013){
          biggest23013=ends[34];
        }
        if(ends[35]>=biggest23013){
          biggest23013=ends[35];
        }
        if(ends[36]>=biggest23013){
          biggest23013=ends[36];
        }
        if(ends[37]>=biggest23013){
          biggest23013=ends[37];
        }
        if(ends[38]>=biggest23013){
          biggest23013=ends[38];
        }
        if(ends[39]>=biggest23013){
          biggest23013=ends[39];
        }
        if(ends[40]>=biggest23013){
          biggest23013=ends[40];
        }
        if(ends[41]>=biggest23013){
          biggest23013=ends[41];
        }
        if(ends[42]>=biggest23013){
          biggest23013=ends[42];
        }
        if(ends[43]>=biggest23013){
          biggest23013=ends[43];
        }
        if(ends[44]>=biggest23013){
          biggest23013=ends[44];
        }
        if(ends[45]>=biggest23013){
          biggest23013=ends[45];
        }
        if(ends[46]>=biggest23013){
          biggest23013=ends[46];
        }
        if(ends[47]>=biggest23013){
          biggest23013=ends[47];
        }
        if(ends[48]>=biggest23013){
          biggest23013=ends[48];
        }
        if(ends[49]>=biggest23013){
          biggest23013=ends[49];
        }
        if(ends[50]>=biggest23013){
          biggest23013=ends[50];
        }
        if(ends[51]>=biggest23013){
          biggest23013=ends[51];
        }
        if(ends[52]>=biggest23013){
          biggest23013=ends[52];
        }
        if(ends[53]>=biggest23013){
          biggest23013=ends[53];
        }
        if(ends[54]>=biggest23013){
          biggest23013=ends[54];
        }
        if(ends[55]>=biggest23013){
          biggest23013=ends[55];
        }
        if(ends[56]>=biggest23013){
          biggest23013=ends[56];
        }
        if(ends[57]>=biggest23013){
          biggest23013=ends[57];
        }
        if(ends[58]>=biggest23013){
          biggest23013=ends[58];
        }
        if(ends[59]>=biggest23013){
          biggest23013=ends[59];
        }
        if(ends[60]>=biggest23013){
          biggest23013=ends[60];
        }
        if(ends[61]>=biggest23013){
          biggest23013=ends[61];
        }
        if(ends[62]>=biggest23013){
          biggest23013=ends[62];
        }
        if(biggest23013 == 1){
          active[28]=1;
          ends[28]=1;
          tdone[28]=1;
        }
        //FINXME code
        if(biggest23013 == 0){
          S7538=0;
          active[28]=0;
          ends[28]=0;
          tdone[28]=1;
        }
        break;
      
    }
  }

  public void thread22976(int [] tdone, int [] ends){
        switch(S7208){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        switch(S7157){
          case 0 : 
            S7157=0;
            S7157=1;
            active[27]=1;
            ends[27]=1;
            tdone[27]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 422, column: 11
              S7157=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 4){//sysj\plant.sysj line: 423, column: 8
                noz4.setPresent();//sysj\plant.sysj line: 425, column: 7
                currsigs.addElement(noz4);
                active[27]=1;
                ends[27]=1;
                tdone[27]=1;
              }
              else {
                S7157=0;
                active[27]=1;
                ends[27]=1;
                tdone[27]=1;
              }
            }
            else {
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 2 : 
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 424, column: 12
              S7157=0;
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              noz4.setPresent();//sysj\plant.sysj line: 425, column: 7
              currsigs.addElement(noz4);
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22975(int [] tdone, int [] ends){
        switch(S7154){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S7103){
          case 0 : 
            S7103=0;
            S7103=1;
            active[26]=1;
            ends[26]=1;
            tdone[26]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 410, column: 11
              S7103=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 3){//sysj\plant.sysj line: 411, column: 8
                noz3.setPresent();//sysj\plant.sysj line: 413, column: 7
                currsigs.addElement(noz3);
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
              }
              else {
                S7103=0;
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
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 412, column: 12
              S7103=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              noz3.setPresent();//sysj\plant.sysj line: 413, column: 7
              currsigs.addElement(noz3);
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22974(int [] tdone, int [] ends){
        switch(S7100){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S7049){
          case 0 : 
            S7049=0;
            S7049=1;
            active[25]=1;
            ends[25]=1;
            tdone[25]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 398, column: 11
              S7049=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 2){//sysj\plant.sysj line: 399, column: 8
                noz2.setPresent();//sysj\plant.sysj line: 401, column: 7
                currsigs.addElement(noz2);
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
              }
              else {
                S7049=0;
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
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 400, column: 12
              S7049=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              noz2.setPresent();//sysj\plant.sysj line: 401, column: 7
              currsigs.addElement(noz2);
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22973(int [] tdone, int [] ends){
        switch(S7046){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S6995){
          case 0 : 
            S6995=0;
            S6995=1;
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 385, column: 11
              S6995=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 1){//sysj\plant.sysj line: 386, column: 8
                noz1.setPresent();//sysj\plant.sysj line: 388, column: 7
                currsigs.addElement(noz1);
                active[24]=1;
                ends[24]=1;
                tdone[24]=1;
              }
              else {
                S6995=0;
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
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 387, column: 12
              S6995=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              noz1.setPresent();//sysj\plant.sysj line: 388, column: 7
              currsigs.addElement(noz1);
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22972(int [] tdone, int [] ends){
        switch(S6992){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S6829){
          case 0 : 
            S6829=0;
            S6829=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 358, column: 13
              S6808=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S6829=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S6808){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 359, column: 12
                  nozzlenum_thread_23 = nozzlenum_thread_23 + 1;//sysj\plant.sysj line: 360, column: 6
                  if(nozzlenum_thread_23 > 4) {//sysj\plant.sysj line: 361, column: 24
                    nozzlenum_thread_23 = 0;//sysj\plant.sysj line: 362, column: 7
                  }
                  S6808=1;
                  s_nozzlenum_1.setPresent();//sysj\plant.sysj line: 365, column: 7
                  currsigs.addElement(s_nozzlenum_1);
                  s_nozzlenum_1.setValue(nozzlenum_thread_23);//sysj\plant.sysj line: 365, column: 7
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
              
              case 1 : 
                if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 364, column: 12
                  S6829=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  s_nozzlenum_1.setPresent();//sysj\plant.sysj line: 365, column: 7
                  currsigs.addElement(s_nozzlenum_1);
                  s_nozzlenum_1.setValue(nozzlenum_thread_23);//sysj\plant.sysj line: 365, column: 7
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22971(int [] tdone, int [] ends){
        switch(S7210){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        s_nozzlenum_1.setClear();//sysj\plant.sysj line: 352, column: 3
        thread22972(tdone,ends);
        thread22973(tdone,ends);
        thread22974(tdone,ends);
        thread22975(tdone,ends);
        thread22976(tdone,ends);
        int biggest22977 = 0;
        if(ends[23]>=biggest22977){
          biggest22977=ends[23];
        }
        if(ends[24]>=biggest22977){
          biggest22977=ends[24];
        }
        if(ends[25]>=biggest22977){
          biggest22977=ends[25];
        }
        if(ends[26]>=biggest22977){
          biggest22977=ends[26];
        }
        if(ends[27]>=biggest22977){
          biggest22977=ends[27];
        }
        if(biggest22977 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest22977 == 0){
          S7210=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread22970(int [] tdone, int [] ends){
        switch(S6805){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S6734){
          case 0 : 
            S6734=0;
            S6734=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 341, column: 12
              S6721=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S6734=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S6721){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 342, column: 11
                  S6721=1;
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 344, column: 6
                  currsigs.addElement(dosUnitFilled);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(!dosUnitValveRetract.getprestatus() && dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 343, column: 11
                  S6734=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 344, column: 6
                  currsigs.addElement(dosUnitFilled);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22969(int [] tdone, int [] ends){
        switch(S6711){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S6710){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 324, column: 9
              S6710=1;
              S6548=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 325, column: 4
              currsigs.addElement(dosUnitEvac);
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S6548){
              case 0 : 
                S6548=0;
                S6548=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 329, column: 12
                  S6535=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  S6548=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                switch(S6535){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 330, column: 11
                      S6535=1;
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 332, column: 6
                      currsigs.addElement(dosUnitEvac);
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
                    if(!dosUnitValveExtend.getprestatus() && dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 331, column: 11
                      S6548=0;
                      active[20]=1;
                      ends[20]=1;
                      tdone[20]=1;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 332, column: 6
                      currsigs.addElement(dosUnitEvac);
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
        break;
      
    }
  }

  public void thread22968(int [] tdone, int [] ends){
        switch(S6521){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S6486){
          case 0 : 
            S6486=0;
            S6486=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 311, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 313, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S6486=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 312, column: 11
              S6486=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 313, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22967(int [] tdone, int [] ends){
        switch(S6475){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S6404){
          case 0 : 
            S6404=0;
            S6404=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 299, column: 12
              S6391=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S6404=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S6391){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 300, column: 11
                  S6391=1;
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 302, column: 6
                  currsigs.addElement(gripperTurnHomePos);
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
              case 1 : 
                if(!gripperTurnRetract.getprestatus() && gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 301, column: 11
                  S6404=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 302, column: 6
                  currsigs.addElement(gripperTurnHomePos);
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22966(int [] tdone, int [] ends){
        switch(S6381){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S6310){
          case 0 : 
            S6310=0;
            S6310=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 287, column: 12
              S6297=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S6310=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S6297){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 288, column: 11
                  S6297=1;
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 290, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
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
                if(!gripperTurnExtend.getprestatus() && gripperTurnRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 289, column: 11
                  S6310=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 290, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
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

  public void thread22965(int [] tdone, int [] ends){
        switch(S6287){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S6216){
          case 0 : 
            S6216=0;
            S6216=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 275, column: 12
              S6203=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S6216=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S6203){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 276, column: 11
                  S6203=1;
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 278, column: 6
                  currsigs.addElement(gripperZAxisLowered);
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
                if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 277, column: 11
                  S6216=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 278, column: 6
                  currsigs.addElement(gripperZAxisLowered);
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

  public void thread22964(int [] tdone, int [] ends){
        switch(S6193){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S5947){
          case 0 : 
            S5947=0;
            S5947=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 255, column: 12
              rand_thread_15 = (int)(Math.random() * 100);//sysj\plant.sysj line: 256, column: 5
              System.out.println(rand_thread_15);//sysj\plant.sysj line: 257, column: 5
              S5913=0;
              if(rand_thread_15 < chance_thread_15){//sysj\plant.sysj line: 258, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 260, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                S5913=1;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              S5947=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S5913){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 259, column: 12
                  S5913=1;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 260, column: 8
                  currsigs.addElement(capOnBottleAtPos1);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 264, column: 11
                  S5913=2;
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
              
              case 2 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 265, column: 11
                  S5947=0;
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
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22963(int [] tdone, int [] ends){
        switch(S5911){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S3622){
          case 0 : 
            S3622=0;
            tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 220, column: 4
            currsigs.addElement(tableAlignedWithSensor);
            S3622=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 221, column: 12
              S3624=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              S3622=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S3624){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 222, column: 11
                  numTurns_thread_14 = numTurns_thread_14 + 1;//sysj\plant.sysj line: 223, column: 5
                  S3624=1;
                  if(numTurns_thread_14 == 2){//sysj\plant.sysj line: 224, column: 8
                    S3658=0;
                    l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 225, column: 6
                    currsigs.addElement(l_putBottleAt2_1);
                    tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 227, column: 7
                    currsigs.addElement(tableAlignedWithSensor);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    S3658=1;
                    if(numTurns_thread_14 == 3){//sysj\plant.sysj line: 229, column: 14
                      S3657=0;
                      l_putBottleAt3_1.setPresent();//sysj\plant.sysj line: 230, column: 6
                      currsigs.addElement(l_putBottleAt3_1);
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 232, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      S3657=1;
                      if(numTurns_thread_14 == 4){//sysj\plant.sysj line: 235, column: 14
                        S3656=0;
                        l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 236, column: 6
                        currsigs.addElement(l_putBottleAt4_1);
                        tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 238, column: 7
                        currsigs.addElement(tableAlignedWithSensor);
                        active[14]=1;
                        ends[14]=1;
                        tdone[14]=1;
                      }
                      else {
                        S3656=1;
                        if(numTurns_thread_14 == 5){//sysj\plant.sysj line: 240, column: 14
                          numTurns_thread_14 = 0;//sysj\plant.sysj line: 241, column: 6
                          l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 242, column: 6
                          currsigs.addElement(l_putBottleAt5_1);
                          active[14]=1;
                          ends[14]=1;
                          tdone[14]=1;
                        }
                        else {
                          S3622=0;
                          active[14]=1;
                          ends[14]=1;
                          tdone[14]=1;
                        }
                      }
                    }
                  }
                }
                else {
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                switch(S3658){
                  case 0 : 
                    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 226, column: 12
                      S3622=0;
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 227, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    break;
                  
                  case 1 : 
                    switch(S3657){
                      case 0 : 
                        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 231, column: 12
                          S3622=0;
                          active[14]=1;
                          ends[14]=1;
                          tdone[14]=1;
                        }
                        else {
                          tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 232, column: 7
                          currsigs.addElement(tableAlignedWithSensor);
                          active[14]=1;
                          ends[14]=1;
                          tdone[14]=1;
                        }
                        break;
                      
                      case 1 : 
                        switch(S3656){
                          case 0 : 
                            if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 237, column: 12
                              S3622=0;
                              active[14]=1;
                              ends[14]=1;
                              tdone[14]=1;
                            }
                            else {
                              tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 238, column: 7
                              currsigs.addElement(tableAlignedWithSensor);
                              active[14]=1;
                              ends[14]=1;
                              tdone[14]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 243, column: 12
                              S3622=0;
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
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22962(int [] tdone, int [] ends){
        switch(S3621){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S3598){
          case 0 : 
            S3598=0;
            S3598=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 207, column: 12
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S3598=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 208, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 209, column: 5
              currsigs.addElement(bottleLeftPos5);
              S3598=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22961(int [] tdone, int [] ends){
        switch(S3591){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S3526){
          case 0 : 
            S3526=0;
            S3526=1;
            if(l_putBottleAt3_1.getprestatus()){//sysj\plant.sysj line: 195, column: 12
              S3513=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S3526=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos4.getprestatus())){//sysj\plant.sysj line: 196, column: 11
              S3526=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              switch(S3513){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 197, column: 12
                    S3513=1;
                    bottleAtPos3.setPresent();//sysj\plant.sysj line: 198, column: 6
                    currsigs.addElement(bottleAtPos3);
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
                
                case 1 : 
                  bottleAtPos3.setPresent();//sysj\plant.sysj line: 198, column: 6
                  currsigs.addElement(bottleAtPos3);
                  active[12]=1;
                  ends[12]=1;
                  tdone[12]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22960(int [] tdone, int [] ends){
        switch(S3505){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S3440){
          case 0 : 
            S3440=0;
            S3440=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 183, column: 12
              S3427=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S3440=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos3.getprestatus())){//sysj\plant.sysj line: 184, column: 11
              S3440=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S3427){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 185, column: 12
                    S3427=1;
                    bottleAtPos2.setPresent();//sysj\plant.sysj line: 186, column: 6
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
                  bottleAtPos2.setPresent();//sysj\plant.sysj line: 186, column: 6
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

  public void thread22959(int [] tdone, int [] ends){
        switch(S3419){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S3354){
          case 0 : 
            S3354=0;
            S3354=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 171, column: 12
              S3341=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S3354=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos5.getprestatus())){//sysj\plant.sysj line: 172, column: 11
              S3354=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S3341){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 173, column: 12
                    S3341=1;
                    bottleAtPos4.setPresent();//sysj\plant.sysj line: 174, column: 6
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
                  bottleAtPos4.setPresent();//sysj\plant.sysj line: 174, column: 6
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

  public void thread22958(int [] tdone, int [] ends){
        switch(S3333){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S3298){
          case 0 : 
            S3298=0;
            S3298=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 160, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 162, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S3298=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 161, column: 11
              S3298=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 162, column: 6
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

  public void thread22957(int [] tdone, int [] ends){
        switch(S3287){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S3252){
          case 0 : 
            S3252=0;
            S3252=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 149, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 151, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S3252=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 150, column: 11
              S3252=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 151, column: 6
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

  public void thread22956(int [] tdone, int [] ends){
        switch(S3241){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 134, column: 3
        switch(S3209){
          case 0 : 
            S3209=0;
            S3209=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 138, column: 11
              S3209=2;
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 140, column: 6
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
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 139, column: 11
              S3209=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 140, column: 6
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

  public void thread22955(int [] tdone, int [] ends){
        switch(S3205){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 117, column: 12
          if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 118, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 119, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 121, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 122, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 125, column: 8
              empty.setPresent();//sysj\plant.sysj line: 126, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 125, column: 8
              empty.setPresent();//sysj\plant.sysj line: 126, column: 6
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
          if(refill.getprestatus()){//sysj\plant.sysj line: 121, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 122, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 125, column: 8
              empty.setPresent();//sysj\plant.sysj line: 126, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 125, column: 8
              empty.setPresent();//sysj\plant.sysj line: 126, column: 6
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

  public void thread22954(int [] tdone, int [] ends){
        switch(S3143){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S3097){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 100, column: 10
              S3097=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S3079){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 102, column: 13
                    S3079=1;
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
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 103, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 105, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 105, column: 7
                    S3079=2;
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
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 106, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 107, column: 7
                    currsigs.addElement(capDec_1);
                    S3079=0;
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
            if(refill.getprestatus()){//sysj\plant.sysj line: 110, column: 10
              S3097=0;
              S3079=0;
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

  public void thread22953(int [] tdone, int [] ends){
        switch(S3075){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S3045){
          case 0 : 
            switch(S3040){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 80, column: 12
                  S3040=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 83, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 84, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 84, column: 7
                    S3045=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S3045=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\plant.sysj line: 81, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S3045=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 77, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 78, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 79, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 79, column: 6
                    S3040=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 81, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S3045=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S3045=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S3045=1;
            S3045=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 77, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 78, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 79, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 79, column: 6
                S3040=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 81, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S3045=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S3045=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread22952(int [] tdone, int [] ends){
        switch(S3031){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S2985){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 64, column: 10
              S2985=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 65, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 67, column: 10
              S2985=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 69, column: 5
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
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 68, column: 10
              S2985=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 69, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 71, column: 10
              S2985=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 65, column: 5
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

  public void thread22951(int [] tdone, int [] ends){
        switch(S2978){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S2932){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 51, column: 10
              S2932=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 52, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 54, column: 10
              S2932=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 56, column: 5
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 55, column: 10
              S2932=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 56, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 58, column: 10
              S2932=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 52, column: 5
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

  public void thread22948(int [] tdone, int [] ends){
        S7906=1;
    if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 633, column: 24
      bottleAtPos3E.setPresent();//sysj\plant.sysj line: 633, column: 38
      currsigs.addElement(bottleAtPos3E);
      active[79]=1;
      ends[79]=1;
      tdone[79]=1;
    }
    else {
      active[79]=1;
      ends[79]=1;
      tdone[79]=1;
    }
  }

  public void thread22947(int [] tdone, int [] ends){
        S7898=1;
    if(armDest.getprestatus()){//sysj\plant.sysj line: 631, column: 24
      armDestE.setPresent();//sysj\plant.sysj line: 631, column: 33
      currsigs.addElement(armDestE);
      active[78]=1;
      ends[78]=1;
      tdone[78]=1;
    }
    else {
      active[78]=1;
      ends[78]=1;
      tdone[78]=1;
    }
  }

  public void thread22946(int [] tdone, int [] ends){
        S7890=1;
    if(armSource.getprestatus()){//sysj\plant.sysj line: 629, column: 24
      armSourceE.setPresent();//sysj\plant.sysj line: 629, column: 35
      currsigs.addElement(armSourceE);
      active[77]=1;
      ends[77]=1;
      tdone[77]=1;
    }
    else {
      active[77]=1;
      ends[77]=1;
      tdone[77]=1;
    }
  }

  public void thread22945(int [] tdone, int [] ends){
        S7882=1;
    if(vacOn.getprestatus()){//sysj\plant.sysj line: 627, column: 24
      vacOnE.setPresent();//sysj\plant.sysj line: 627, column: 31
      currsigs.addElement(vacOnE);
      active[76]=1;
      ends[76]=1;
      tdone[76]=1;
    }
    else {
      active[76]=1;
      ends[76]=1;
      tdone[76]=1;
    }
  }

  public void thread22944(int [] tdone, int [] ends){
        S7874=1;
    if(pusherExtend.getprestatus()){//sysj\plant.sysj line: 625, column: 24
      pusherExtendE.setPresent();//sysj\plant.sysj line: 625, column: 38
      currsigs.addElement(pusherExtendE);
      active[75]=1;
      ends[75]=1;
      tdone[75]=1;
    }
    else {
      active[75]=1;
      ends[75]=1;
      tdone[75]=1;
    }
  }

  public void thread22943(int [] tdone, int [] ends){
        S7866=1;
    if(empty.getprestatus()){//sysj\plant.sysj line: 622, column: 24
      emptyE.setPresent();//sysj\plant.sysj line: 622, column: 31
      currsigs.addElement(emptyE);
      active[74]=1;
      ends[74]=1;
      tdone[74]=1;
    }
    else {
      active[74]=1;
      ends[74]=1;
      tdone[74]=1;
    }
  }

  public void thread22942(int [] tdone, int [] ends){
        S7858=1;
    if(armAtDest.getprestatus()){//sysj\plant.sysj line: 620, column: 24
      armAtDestE.setPresent();//sysj\plant.sysj line: 620, column: 35
      currsigs.addElement(armAtDestE);
      active[73]=1;
      ends[73]=1;
      tdone[73]=1;
    }
    else {
      active[73]=1;
      ends[73]=1;
      tdone[73]=1;
    }
  }

  public void thread22941(int [] tdone, int [] ends){
        S7850=1;
    if(armAtSource.getprestatus()){//sysj\plant.sysj line: 618, column: 24
      armAtSourceE.setPresent();//sysj\plant.sysj line: 618, column: 37
      currsigs.addElement(armAtSourceE);
      active[72]=1;
      ends[72]=1;
      tdone[72]=1;
    }
    else {
      active[72]=1;
      ends[72]=1;
      tdone[72]=1;
    }
  }

  public void thread22940(int [] tdone, int [] ends){
        S7842=1;
    if(WPgripped.getprestatus()){//sysj\plant.sysj line: 616, column: 24
      WPgrippedE.setPresent();//sysj\plant.sysj line: 616, column: 35
      currsigs.addElement(WPgrippedE);
      active[71]=1;
      ends[71]=1;
      tdone[71]=1;
    }
    else {
      active[71]=1;
      ends[71]=1;
      tdone[71]=1;
    }
  }

  public void thread22939(int [] tdone, int [] ends){
        S7834=1;
    if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 614, column: 24
      pusherExtendedE.setPresent();//sysj\plant.sysj line: 614, column: 40
      currsigs.addElement(pusherExtendedE);
      active[70]=1;
      ends[70]=1;
      tdone[70]=1;
    }
    else {
      active[70]=1;
      ends[70]=1;
      tdone[70]=1;
    }
  }

  public void thread22938(int [] tdone, int [] ends){
        S7826=1;
    if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 612, column: 24
      pusherRetractedE.setPresent();//sysj\plant.sysj line: 612, column: 41
      currsigs.addElement(pusherRetractedE);
      active[69]=1;
      ends[69]=1;
      tdone[69]=1;
    }
    else {
      active[69]=1;
      ends[69]=1;
      tdone[69]=1;
    }
  }

  public void thread22937(int [] tdone, int [] ends){
        S7908=1;
    thread22938(tdone,ends);
    thread22939(tdone,ends);
    thread22940(tdone,ends);
    thread22941(tdone,ends);
    thread22942(tdone,ends);
    thread22943(tdone,ends);
    thread22944(tdone,ends);
    thread22945(tdone,ends);
    thread22946(tdone,ends);
    thread22947(tdone,ends);
    thread22948(tdone,ends);
    int biggest22949 = 0;
    if(ends[69]>=biggest22949){
      biggest22949=ends[69];
    }
    if(ends[70]>=biggest22949){
      biggest22949=ends[70];
    }
    if(ends[71]>=biggest22949){
      biggest22949=ends[71];
    }
    if(ends[72]>=biggest22949){
      biggest22949=ends[72];
    }
    if(ends[73]>=biggest22949){
      biggest22949=ends[73];
    }
    if(ends[74]>=biggest22949){
      biggest22949=ends[74];
    }
    if(ends[75]>=biggest22949){
      biggest22949=ends[75];
    }
    if(ends[76]>=biggest22949){
      biggest22949=ends[76];
    }
    if(ends[77]>=biggest22949){
      biggest22949=ends[77];
    }
    if(ends[78]>=biggest22949){
      biggest22949=ends[78];
    }
    if(ends[79]>=biggest22949){
      biggest22949=ends[79];
    }
    if(biggest22949 == 1){
      active[68]=1;
      ends[68]=1;
      tdone[68]=1;
    }
  }

  public void thread22936(int [] tdone, int [] ends){
        S7818=1;
    capcount_thread_67 = 5;//sysj\plant.sysj line: 594, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 596, column: 12
      if(capcount_thread_67 > 0) {//sysj\plant.sysj line: 597, column: 5
        capcount_thread_67 = capcount_thread_67 - 1;//sysj\plant.sysj line: 598, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 600, column: 12
        capcount_thread_67 = 5;//sysj\plant.sysj line: 601, column: 5
        if(capcount_thread_67 == 0){//sysj\plant.sysj line: 604, column: 8
          empty.setPresent();//sysj\plant.sysj line: 605, column: 6
          currsigs.addElement(empty);
          active[67]=1;
          ends[67]=1;
          tdone[67]=1;
        }
        else {
          active[67]=1;
          ends[67]=1;
          tdone[67]=1;
        }
      }
      else {
        if(capcount_thread_67 == 0){//sysj\plant.sysj line: 604, column: 8
          empty.setPresent();//sysj\plant.sysj line: 605, column: 6
          currsigs.addElement(empty);
          active[67]=1;
          ends[67]=1;
          tdone[67]=1;
        }
        else {
          active[67]=1;
          ends[67]=1;
          tdone[67]=1;
        }
      }
    }
    else {
      if(refill.getprestatus()){//sysj\plant.sysj line: 600, column: 12
        capcount_thread_67 = 5;//sysj\plant.sysj line: 601, column: 5
        if(capcount_thread_67 == 0){//sysj\plant.sysj line: 604, column: 8
          empty.setPresent();//sysj\plant.sysj line: 605, column: 6
          currsigs.addElement(empty);
          active[67]=1;
          ends[67]=1;
          tdone[67]=1;
        }
        else {
          active[67]=1;
          ends[67]=1;
          tdone[67]=1;
        }
      }
      else {
        if(capcount_thread_67 == 0){//sysj\plant.sysj line: 604, column: 8
          empty.setPresent();//sysj\plant.sysj line: 605, column: 6
          currsigs.addElement(empty);
          active[67]=1;
          ends[67]=1;
          tdone[67]=1;
        }
        else {
          active[67]=1;
          ends[67]=1;
          tdone[67]=1;
        }
      }
    }
  }

  public void thread22935(int [] tdone, int [] ends){
        S7756=1;
    S7710=0;
    S7692=0;
    active[66]=1;
    ends[66]=1;
    tdone[66]=1;
  }

  public void thread22934(int [] tdone, int [] ends){
        S7688=1;
    S7658=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 556, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 557, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 558, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 558, column: 6
        WPgripped.setPresent();//sysj\plant.sysj line: 560, column: 7
        currsigs.addElement(WPgripped);
        active[65]=1;
        ends[65]=1;
        tdone[65]=1;
      }
      else {
        S7658=1;
        active[65]=1;
        ends[65]=1;
        tdone[65]=1;
      }
    }
    else {
      S7658=1;
      active[65]=1;
      ends[65]=1;
      tdone[65]=1;
    }
  }

  public void thread22933(int [] tdone, int [] ends){
        S7644=1;
    S7598=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 544, column: 5
    currsigs.addElement(pusherRetracted);
    active[64]=1;
    ends[64]=1;
    tdone[64]=1;
  }

  public void thread22932(int [] tdone, int [] ends){
        S7591=1;
    S7545=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 531, column: 5
    currsigs.addElement(armAtDest);
    active[63]=1;
    ends[63]=1;
    tdone[63]=1;
  }

  public void thread22930(int [] tdone, int [] ends){
        S7536=1;
    if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 524, column: 25
      bottleAddedC.setPresent();//sysj\plant.sysj line: 524, column: 38
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

  public void thread22929(int [] tdone, int [] ends){
        S7528=1;
    if(noz4.getprestatus()){//sysj\plant.sysj line: 522, column: 25
      noz4E.setPresent();//sysj\plant.sysj line: 522, column: 31
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

  public void thread22928(int [] tdone, int [] ends){
        S7520=1;
    if(noz3.getprestatus()){//sysj\plant.sysj line: 520, column: 25
      noz3E.setPresent();//sysj\plant.sysj line: 520, column: 31
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

  public void thread22927(int [] tdone, int [] ends){
        S7512=1;
    if(noz2.getprestatus()){//sysj\plant.sysj line: 518, column: 25
      noz2E.setPresent();//sysj\plant.sysj line: 518, column: 31
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

  public void thread22926(int [] tdone, int [] ends){
        S7504=1;
    if(noz1.getprestatus()){//sysj\plant.sysj line: 516, column: 25
      noz1E.setPresent();//sysj\plant.sysj line: 516, column: 31
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

  public void thread22925(int [] tdone, int [] ends){
        S7496=1;
    if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 514, column: 25
      capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 514, column: 44
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

  public void thread22924(int [] tdone, int [] ends){
        S7488=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 510, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 510, column: 40
      currsigs.addElement(dosUnitFilledE);
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

  public void thread22923(int [] tdone, int [] ends){
        S7480=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 508, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 508, column: 38
      currsigs.addElement(dosUnitEvacE);
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

  public void thread22922(int [] tdone, int [] ends){
        S7472=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 506, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 506, column: 39
      currsigs.addElement(bottleAtPos2E);
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

  public void thread22921(int [] tdone, int [] ends){
        S7464=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 504, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 504, column: 45
      currsigs.addElement(dosUnitValveExtendE);
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

  public void thread22920(int [] tdone, int [] ends){
        S7456=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 502, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 502, column: 46
      currsigs.addElement(dosUnitValveRetractE);
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

  public void thread22919(int [] tdone, int [] ends){
        S7448=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 500, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 500, column: 42
      currsigs.addElement(valveInletOnOffE);
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

  public void thread22918(int [] tdone, int [] ends){
        S7440=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 498, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 498, column: 45
      currsigs.addElement(valveInjectorOnOffE);
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

  public void thread22917(int [] tdone, int [] ends){
        S7432=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 495, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 495, column: 47
      currsigs.addElement(cylClampBottleExtendE);
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

  public void thread22916(int [] tdone, int [] ends){
        S7424=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 493, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 493, column: 47
      currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread22915(int [] tdone, int [] ends){
        S7416=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 491, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 491, column: 44
      currsigs.addElement(gripperTurnExtendE);
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

  public void thread22914(int [] tdone, int [] ends){
        S7408=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 489, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 489, column: 45
      currsigs.addElement(gripperTurnRetractE);
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

  public void thread22913(int [] tdone, int [] ends){
        S7400=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 487, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 487, column: 45
      currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread22912(int [] tdone, int [] ends){
        S7392=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 485, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 485, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread22911(int [] tdone, int [] ends){
        S7384=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 482, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 482, column: 45
      currsigs.addElement(gripperTurnHomePosE);
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

  public void thread22910(int [] tdone, int [] ends){
        S7376=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 480, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 480, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread22909(int [] tdone, int [] ends){
        S7368=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 478, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 478, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread22908(int [] tdone, int [] ends){
        S7360=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 476, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 476, column: 38
      currsigs.addElement(bottleAtPos2E);
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

  public void thread22907(int [] tdone, int [] ends){
        S7352=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 474, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 474, column: 38
      currsigs.addElement(bottleAtPos4E);
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

  public void thread22906(int [] tdone, int [] ends){
        S7344=1;
    S7330=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 472, column: 24
      S7328=0;
      active[38]=1;
      ends[38]=1;
      tdone[38]=1;
    }
    else {
      S7330=1;
      active[38]=1;
      ends[38]=1;
      tdone[38]=1;
    }
  }

  public void thread22905(int [] tdone, int [] ends){
        S7324=1;
    S7298=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 462, column: 12
      S7296=0;
      active[37]=1;
      ends[37]=1;
      tdone[37]=1;
    }
    else {
      S7298=1;
      active[37]=1;
      ends[37]=1;
      tdone[37]=1;
    }
  }

  public void thread22904(int [] tdone, int [] ends){
        S7286=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 459, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 459, column: 56
      currsigs.addElement(bottleAtPos5E);
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

  public void thread22903(int [] tdone, int [] ends){
        S7278=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 457, column: 24
      bottleAtPos4_RT.setPresent();//sysj\plant.sysj line: 457, column: 38
      currsigs.addElement(bottleAtPos4_RT);
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

  public void thread22902(int [] tdone, int [] ends){
        S7270=1;
    if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 455, column: 24
      bottleAtPos3_RT.setPresent();//sysj\plant.sysj line: 455, column: 38
      currsigs.addElement(bottleAtPos3_RT);
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

  public void thread22901(int [] tdone, int [] ends){
        S7262=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 453, column: 24
      bottleAtPos2_RT.setPresent();//sysj\plant.sysj line: 453, column: 38
      currsigs.addElement(bottleAtPos2_RT);
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

  public void thread22900(int [] tdone, int [] ends){
        S7254=1;
    S7240=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 451, column: 24
      S7238=0;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
    else {
      S7240=1;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
  }

  public void thread22899(int [] tdone, int [] ends){
        S7234=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 449, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 449, column: 44
      currsigs.addElement(rotaryTableTriggerE);
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

  public void thread22898(int [] tdone, int [] ends){
        S7226=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 447, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 447, column: 39
      currsigs.addElement(motConveyorOnE);
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

  public void thread22897(int [] tdone, int [] ends){
        S7218=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 445, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 445, column: 38
      currsigs.addElement(bottleAtPos1E);
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

  public void thread22896(int [] tdone, int [] ends){
        S7538=1;
    thread22897(tdone,ends);
    thread22898(tdone,ends);
    thread22899(tdone,ends);
    thread22900(tdone,ends);
    thread22901(tdone,ends);
    thread22902(tdone,ends);
    thread22903(tdone,ends);
    thread22904(tdone,ends);
    thread22905(tdone,ends);
    thread22906(tdone,ends);
    thread22907(tdone,ends);
    thread22908(tdone,ends);
    thread22909(tdone,ends);
    thread22910(tdone,ends);
    thread22911(tdone,ends);
    thread22912(tdone,ends);
    thread22913(tdone,ends);
    thread22914(tdone,ends);
    thread22915(tdone,ends);
    thread22916(tdone,ends);
    thread22917(tdone,ends);
    thread22918(tdone,ends);
    thread22919(tdone,ends);
    thread22920(tdone,ends);
    thread22921(tdone,ends);
    thread22922(tdone,ends);
    thread22923(tdone,ends);
    thread22924(tdone,ends);
    thread22925(tdone,ends);
    thread22926(tdone,ends);
    thread22927(tdone,ends);
    thread22928(tdone,ends);
    thread22929(tdone,ends);
    thread22930(tdone,ends);
    int biggest22931 = 0;
    if(ends[29]>=biggest22931){
      biggest22931=ends[29];
    }
    if(ends[30]>=biggest22931){
      biggest22931=ends[30];
    }
    if(ends[31]>=biggest22931){
      biggest22931=ends[31];
    }
    if(ends[32]>=biggest22931){
      biggest22931=ends[32];
    }
    if(ends[33]>=biggest22931){
      biggest22931=ends[33];
    }
    if(ends[34]>=biggest22931){
      biggest22931=ends[34];
    }
    if(ends[35]>=biggest22931){
      biggest22931=ends[35];
    }
    if(ends[36]>=biggest22931){
      biggest22931=ends[36];
    }
    if(ends[37]>=biggest22931){
      biggest22931=ends[37];
    }
    if(ends[38]>=biggest22931){
      biggest22931=ends[38];
    }
    if(ends[39]>=biggest22931){
      biggest22931=ends[39];
    }
    if(ends[40]>=biggest22931){
      biggest22931=ends[40];
    }
    if(ends[41]>=biggest22931){
      biggest22931=ends[41];
    }
    if(ends[42]>=biggest22931){
      biggest22931=ends[42];
    }
    if(ends[43]>=biggest22931){
      biggest22931=ends[43];
    }
    if(ends[44]>=biggest22931){
      biggest22931=ends[44];
    }
    if(ends[45]>=biggest22931){
      biggest22931=ends[45];
    }
    if(ends[46]>=biggest22931){
      biggest22931=ends[46];
    }
    if(ends[47]>=biggest22931){
      biggest22931=ends[47];
    }
    if(ends[48]>=biggest22931){
      biggest22931=ends[48];
    }
    if(ends[49]>=biggest22931){
      biggest22931=ends[49];
    }
    if(ends[50]>=biggest22931){
      biggest22931=ends[50];
    }
    if(ends[51]>=biggest22931){
      biggest22931=ends[51];
    }
    if(ends[52]>=biggest22931){
      biggest22931=ends[52];
    }
    if(ends[53]>=biggest22931){
      biggest22931=ends[53];
    }
    if(ends[54]>=biggest22931){
      biggest22931=ends[54];
    }
    if(ends[55]>=biggest22931){
      biggest22931=ends[55];
    }
    if(ends[56]>=biggest22931){
      biggest22931=ends[56];
    }
    if(ends[57]>=biggest22931){
      biggest22931=ends[57];
    }
    if(ends[58]>=biggest22931){
      biggest22931=ends[58];
    }
    if(ends[59]>=biggest22931){
      biggest22931=ends[59];
    }
    if(ends[60]>=biggest22931){
      biggest22931=ends[60];
    }
    if(ends[61]>=biggest22931){
      biggest22931=ends[61];
    }
    if(ends[62]>=biggest22931){
      biggest22931=ends[62];
    }
    if(biggest22931 == 1){
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread22894(int [] tdone, int [] ends){
        S7208=1;
    S7157=0;
    active[27]=1;
    ends[27]=1;
    tdone[27]=1;
  }

  public void thread22893(int [] tdone, int [] ends){
        S7154=1;
    S7103=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void thread22892(int [] tdone, int [] ends){
        S7100=1;
    S7049=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread22891(int [] tdone, int [] ends){
        S7046=1;
    S6995=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread22890(int [] tdone, int [] ends){
        S6992=1;
    nozzlenum_thread_23 = 0;//sysj\plant.sysj line: 354, column: 4
    S6829=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread22889(int [] tdone, int [] ends){
        S7210=1;
    s_nozzlenum_1.setClear();//sysj\plant.sysj line: 352, column: 3
    thread22890(tdone,ends);
    thread22891(tdone,ends);
    thread22892(tdone,ends);
    thread22893(tdone,ends);
    thread22894(tdone,ends);
    int biggest22895 = 0;
    if(ends[23]>=biggest22895){
      biggest22895=ends[23];
    }
    if(ends[24]>=biggest22895){
      biggest22895=ends[24];
    }
    if(ends[25]>=biggest22895){
      biggest22895=ends[25];
    }
    if(ends[26]>=biggest22895){
      biggest22895=ends[26];
    }
    if(ends[27]>=biggest22895){
      biggest22895=ends[27];
    }
    if(biggest22895 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread22888(int [] tdone, int [] ends){
        S6805=1;
    S6734=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread22887(int [] tdone, int [] ends){
        S6711=1;
    S6710=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 325, column: 4
    currsigs.addElement(dosUnitEvac);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread22886(int [] tdone, int [] ends){
        S6521=1;
    S6486=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread22885(int [] tdone, int [] ends){
        S6475=1;
    S6404=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread22884(int [] tdone, int [] ends){
        S6381=1;
    S6310=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread22883(int [] tdone, int [] ends){
        S6287=1;
    S6216=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread22882(int [] tdone, int [] ends){
        S6193=1;
    chance_thread_15 = 25;//sysj\plant.sysj line: 250, column: 3
        S5947=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread22881(int [] tdone, int [] ends){
        S5911=1;
    numTurns_thread_14 = 0;//sysj\plant.sysj line: 217, column: 3
    S3622=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread22880(int [] tdone, int [] ends){
        S3621=1;
    S3598=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread22879(int [] tdone, int [] ends){
        S3591=1;
    S3526=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread22878(int [] tdone, int [] ends){
        S3505=1;
    S3440=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread22877(int [] tdone, int [] ends){
        S3419=1;
    S3354=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread22876(int [] tdone, int [] ends){
        S3333=1;
    S3298=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread22875(int [] tdone, int [] ends){
        S3287=1;
    S3252=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread22874(int [] tdone, int [] ends){
        S3241=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 134, column: 3
    S3209=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread22873(int [] tdone, int [] ends){
        S3205=1;
    capcount_thread_6 = 5;//sysj\plant.sysj line: 115, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 117, column: 12
      if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 118, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 119, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 121, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 122, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 125, column: 8
          empty.setPresent();//sysj\plant.sysj line: 126, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 125, column: 8
          empty.setPresent();//sysj\plant.sysj line: 126, column: 6
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
      if(refill.getprestatus()){//sysj\plant.sysj line: 121, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 122, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 125, column: 8
          empty.setPresent();//sysj\plant.sysj line: 126, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 125, column: 8
          empty.setPresent();//sysj\plant.sysj line: 126, column: 6
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

  public void thread22872(int [] tdone, int [] ends){
        S3143=1;
    S3097=0;
    S3079=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread22871(int [] tdone, int [] ends){
        S3075=1;
    S3045=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 77, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 78, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 79, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 79, column: 6
        S3040=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 81, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S3045=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S3045=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread22870(int [] tdone, int [] ends){
        S3031=1;
    S2985=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 65, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread22869(int [] tdone, int [] ends){
        S2978=1;
    S2932=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 52, column: 5
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
      switch(S22867){
        case 0 : 
          S22867=0;
          break RUN;
        
        case 1 : 
          S22867=2;
          S22867=2;
          class GUI extends Object implements java.lang.Runnable {//sysj\plant.sysj line: 35, column: 1
            public void run() {//sysj\plant.sysj line: 37, column: 21
              org.compsys704.GUI.main(null);//sysj\plant.sysj line: 38, column: 4
            }
            GUI(){//sysj\plant.sysj line: 36, column: 42
            }
          }
          new Thread(new GUI()).start();//sysj\plant.sysj line: 41, column: 2
          capDec_1.setClear();//sysj\plant.sysj line: 43, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 44, column: 2
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 45, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 45, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 45, column: 2
          l_putBottleAt3_1.setClear();//sysj\plant.sysj line: 45, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 46, column: 2
          capPos_1.setPresent();//sysj\plant.sysj line: 47, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\plant.sysj line: 47, column: 2
          thread22869(tdone,ends);
          thread22870(tdone,ends);
          thread22871(tdone,ends);
          thread22872(tdone,ends);
          thread22873(tdone,ends);
          thread22874(tdone,ends);
          thread22875(tdone,ends);
          thread22876(tdone,ends);
          thread22877(tdone,ends);
          thread22878(tdone,ends);
          thread22879(tdone,ends);
          thread22880(tdone,ends);
          thread22881(tdone,ends);
          thread22882(tdone,ends);
          thread22883(tdone,ends);
          thread22884(tdone,ends);
          thread22885(tdone,ends);
          thread22886(tdone,ends);
          thread22887(tdone,ends);
          thread22888(tdone,ends);
          thread22889(tdone,ends);
          thread22896(tdone,ends);
          thread22932(tdone,ends);
          thread22933(tdone,ends);
          thread22934(tdone,ends);
          thread22935(tdone,ends);
          thread22936(tdone,ends);
          thread22937(tdone,ends);
          int biggest22950 = 0;
          if(ends[2]>=biggest22950){
            biggest22950=ends[2];
          }
          if(ends[3]>=biggest22950){
            biggest22950=ends[3];
          }
          if(ends[4]>=biggest22950){
            biggest22950=ends[4];
          }
          if(ends[5]>=biggest22950){
            biggest22950=ends[5];
          }
          if(ends[6]>=biggest22950){
            biggest22950=ends[6];
          }
          if(ends[7]>=biggest22950){
            biggest22950=ends[7];
          }
          if(ends[8]>=biggest22950){
            biggest22950=ends[8];
          }
          if(ends[9]>=biggest22950){
            biggest22950=ends[9];
          }
          if(ends[10]>=biggest22950){
            biggest22950=ends[10];
          }
          if(ends[11]>=biggest22950){
            biggest22950=ends[11];
          }
          if(ends[12]>=biggest22950){
            biggest22950=ends[12];
          }
          if(ends[13]>=biggest22950){
            biggest22950=ends[13];
          }
          if(ends[14]>=biggest22950){
            biggest22950=ends[14];
          }
          if(ends[15]>=biggest22950){
            biggest22950=ends[15];
          }
          if(ends[16]>=biggest22950){
            biggest22950=ends[16];
          }
          if(ends[17]>=biggest22950){
            biggest22950=ends[17];
          }
          if(ends[18]>=biggest22950){
            biggest22950=ends[18];
          }
          if(ends[19]>=biggest22950){
            biggest22950=ends[19];
          }
          if(ends[20]>=biggest22950){
            biggest22950=ends[20];
          }
          if(ends[21]>=biggest22950){
            biggest22950=ends[21];
          }
          if(ends[22]>=biggest22950){
            biggest22950=ends[22];
          }
          if(ends[28]>=biggest22950){
            biggest22950=ends[28];
          }
          if(ends[63]>=biggest22950){
            biggest22950=ends[63];
          }
          if(ends[64]>=biggest22950){
            biggest22950=ends[64];
          }
          if(ends[65]>=biggest22950){
            biggest22950=ends[65];
          }
          if(ends[66]>=biggest22950){
            biggest22950=ends[66];
          }
          if(ends[67]>=biggest22950){
            biggest22950=ends[67];
          }
          if(ends[68]>=biggest22950){
            biggest22950=ends[68];
          }
          if(biggest22950 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\plant.sysj line: 43, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 44, column: 2
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 45, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 45, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 45, column: 2
          l_putBottleAt3_1.setClear();//sysj\plant.sysj line: 45, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 46, column: 2
          thread22951(tdone,ends);
          thread22952(tdone,ends);
          thread22953(tdone,ends);
          thread22954(tdone,ends);
          thread22955(tdone,ends);
          thread22956(tdone,ends);
          thread22957(tdone,ends);
          thread22958(tdone,ends);
          thread22959(tdone,ends);
          thread22960(tdone,ends);
          thread22961(tdone,ends);
          thread22962(tdone,ends);
          thread22963(tdone,ends);
          thread22964(tdone,ends);
          thread22965(tdone,ends);
          thread22966(tdone,ends);
          thread22967(tdone,ends);
          thread22968(tdone,ends);
          thread22969(tdone,ends);
          thread22970(tdone,ends);
          thread22971(tdone,ends);
          thread22978(tdone,ends);
          thread23014(tdone,ends);
          thread23015(tdone,ends);
          thread23016(tdone,ends);
          thread23017(tdone,ends);
          thread23018(tdone,ends);
          thread23019(tdone,ends);
          int biggest23032 = 0;
          if(ends[2]>=biggest23032){
            biggest23032=ends[2];
          }
          if(ends[3]>=biggest23032){
            biggest23032=ends[3];
          }
          if(ends[4]>=biggest23032){
            biggest23032=ends[4];
          }
          if(ends[5]>=biggest23032){
            biggest23032=ends[5];
          }
          if(ends[6]>=biggest23032){
            biggest23032=ends[6];
          }
          if(ends[7]>=biggest23032){
            biggest23032=ends[7];
          }
          if(ends[8]>=biggest23032){
            biggest23032=ends[8];
          }
          if(ends[9]>=biggest23032){
            biggest23032=ends[9];
          }
          if(ends[10]>=biggest23032){
            biggest23032=ends[10];
          }
          if(ends[11]>=biggest23032){
            biggest23032=ends[11];
          }
          if(ends[12]>=biggest23032){
            biggest23032=ends[12];
          }
          if(ends[13]>=biggest23032){
            biggest23032=ends[13];
          }
          if(ends[14]>=biggest23032){
            biggest23032=ends[14];
          }
          if(ends[15]>=biggest23032){
            biggest23032=ends[15];
          }
          if(ends[16]>=biggest23032){
            biggest23032=ends[16];
          }
          if(ends[17]>=biggest23032){
            biggest23032=ends[17];
          }
          if(ends[18]>=biggest23032){
            biggest23032=ends[18];
          }
          if(ends[19]>=biggest23032){
            biggest23032=ends[19];
          }
          if(ends[20]>=biggest23032){
            biggest23032=ends[20];
          }
          if(ends[21]>=biggest23032){
            biggest23032=ends[21];
          }
          if(ends[22]>=biggest23032){
            biggest23032=ends[22];
          }
          if(ends[28]>=biggest23032){
            biggest23032=ends[28];
          }
          if(ends[63]>=biggest23032){
            biggest23032=ends[63];
          }
          if(ends[64]>=biggest23032){
            biggest23032=ends[64];
          }
          if(ends[65]>=biggest23032){
            biggest23032=ends[65];
          }
          if(ends[66]>=biggest23032){
            biggest23032=ends[66];
          }
          if(ends[67]>=biggest23032){
            biggest23032=ends[67];
          }
          if(ends[68]>=biggest23032){
            biggest23032=ends[68];
          }
          if(biggest23032 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest23032 == 0){
            S22867=0;
            active[1]=0;
            ends[1]=0;
            S22867=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    capDec_1 = new Signal();
    l_bottleAdded_1 = new Signal();
    l_putBottleAt5_1 = new Signal();
    l_putBottleAt4_1 = new Signal();
    l_putBottleAt2_1 = new Signal();
    l_putBottleAt3_1 = new Signal();
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
      turnNozTrigger.setpreclear();
      pusherExtendE.setpreclear();
      vacOnE.setpreclear();
      armSourceE.setpreclear();
      armDestE.setpreclear();
      bottleAtPos3.setpreclear();
      bottleAtPos3E.setpreclear();
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
      noz1E.setpreclear();
      noz2E.setpreclear();
      noz3E.setpreclear();
      noz4E.setpreclear();
      bottleAddedC.setpreclear();
      bottleAtPos4_RT.setpreclear();
      bottleAtPos3_RT.setpreclear();
      bottleAtPos2_RT.setpreclear();
      capDec_1.setpreclear();
      l_bottleAdded_1.setpreclear();
      l_putBottleAt5_1.setpreclear();
      l_putBottleAt4_1.setpreclear();
      l_putBottleAt2_1.setpreclear();
      l_putBottleAt3_1.setpreclear();
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
      dummyint = turnNozTrigger.getStatus() ? turnNozTrigger.setprepresent() : turnNozTrigger.setpreclear();
      turnNozTrigger.setpreval(turnNozTrigger.getValue());
      turnNozTrigger.setClear();
      pusherExtendE.sethook();
      pusherExtendE.setClear();
      vacOnE.sethook();
      vacOnE.setClear();
      armSourceE.sethook();
      armSourceE.setClear();
      armDestE.sethook();
      armDestE.setClear();
      bottleAtPos3.sethook();
      bottleAtPos3.setClear();
      bottleAtPos3E.sethook();
      bottleAtPos3E.setClear();
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
      bottleAtPos4_RT.sethook();
      bottleAtPos4_RT.setClear();
      bottleAtPos3_RT.sethook();
      bottleAtPos3_RT.setClear();
      bottleAtPos2_RT.sethook();
      bottleAtPos2_RT.setClear();
      capDec_1.setClear();
      l_bottleAdded_1.setClear();
      l_putBottleAt5_1.setClear();
      l_putBottleAt4_1.setClear();
      l_putBottleAt2_1.setClear();
      l_putBottleAt3_1.setClear();
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
