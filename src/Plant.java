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
  private Signal l_putBottleAt3_1;
  private Signal capPos_1;
  private Signal s_motConveyorOn_1;
  private Signal s_nozzlenum_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 115, column: 3
  private int numTurns_thread_14;//sysj\plant.sysj line: 218, column: 3
  private Integer chance_thread_15;//sysj\plant.sysj line: 253, column: 3
  private Integer rand_thread_15;//sysj\plant.sysj line: 254, column: 3
  private int nozzlenum_thread_23;//sysj\plant.sysj line: 357, column: 4
  private int capcount_thread_68;//sysj\plant.sysj line: 598, column: 3
  private int S24755 = 1;
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
  private int S3671 = 1;
  private int S3546 = 1;
  private int S3513 = 1;
  private int S3701 = 1;
  private int S3678 = 1;
  private int S6375 = 1;
  private int S3868 = 1;
  private int S3703 = 1;
  private int S3743 = 1;
  private int S3742 = 1;
  private int S3741 = 1;
  private int S6657 = 1;
  private int S6411 = 1;
  private int S6377 = 1;
  private int S6751 = 1;
  private int S6680 = 1;
  private int S6667 = 1;
  private int S6845 = 1;
  private int S6774 = 1;
  private int S6761 = 1;
  private int S6939 = 1;
  private int S6868 = 1;
  private int S6855 = 1;
  private int S6985 = 1;
  private int S6950 = 1;
  private int S7175 = 1;
  private int S7174 = 1;
  private int S7012 = 1;
  private int S6999 = 1;
  private int S7269 = 1;
  private int S7198 = 1;
  private int S7185 = 1;
  private int S7674 = 1;
  private int S7456 = 1;
  private int S7293 = 1;
  private int S7272 = 1;
  private int S7510 = 1;
  private int S7459 = 1;
  private int S7564 = 1;
  private int S7513 = 1;
  private int S7618 = 1;
  private int S7567 = 1;
  private int S7672 = 1;
  private int S7621 = 1;
  private int S8010 = 1;
  private int S7682 = 1;
  private int S7690 = 1;
  private int S7698 = 1;
  private int S7718 = 1;
  private int S7704 = 1;
  private int S7702 = 1;
  private int S7726 = 1;
  private int S7764 = 1;
  private int S7738 = 1;
  private int S7736 = 1;
  private int S7784 = 1;
  private int S7770 = 1;
  private int S7768 = 1;
  private int S7792 = 1;
  private int S7800 = 1;
  private int S7808 = 1;
  private int S7816 = 1;
  private int S7824 = 1;
  private int S7832 = 1;
  private int S7840 = 1;
  private int S7848 = 1;
  private int S7856 = 1;
  private int S7864 = 1;
  private int S7872 = 1;
  private int S7880 = 1;
  private int S7888 = 1;
  private int S7896 = 1;
  private int S7904 = 1;
  private int S7912 = 1;
  private int S7920 = 1;
  private int S7928 = 1;
  private int S7936 = 1;
  private int S7944 = 1;
  private int S7952 = 1;
  private int S7960 = 1;
  private int S7968 = 1;
  private int S7976 = 1;
  private int S7984 = 1;
  private int S7992 = 1;
  private int S8000 = 1;
  private int S8008 = 1;
  private int S8063 = 1;
  private int S8017 = 1;
  private int S8116 = 1;
  private int S8070 = 1;
  private int S8160 = 1;
  private int S8130 = 1;
  private int S8228 = 1;
  private int S8182 = 1;
  private int S8164 = 1;
  private int S8290 = 1;
  private int S8380 = 1;
  private int S8298 = 1;
  private int S8306 = 1;
  private int S8314 = 1;
  private int S8322 = 1;
  private int S8330 = 1;
  private int S8338 = 1;
  private int S8346 = 1;
  private int S8354 = 1;
  private int S8362 = 1;
  private int S8370 = 1;
  private int S8378 = 1;
  
  private int[] ends = new int[81];
  private int[] tdone = new int[81];
  
  public void thread24920(int [] tdone, int [] ends){
        switch(S8378){
      case 0 : 
        active[80]=0;
        ends[80]=0;
        tdone[80]=1;
        break;
      
      case 1 : 
        if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 637, column: 24
          bottleAtPos3E.setPresent();//sysj\plant.sysj line: 637, column: 38
          currsigs.addElement(bottleAtPos3E);
          active[80]=1;
          ends[80]=1;
          tdone[80]=1;
        }
        else {
          active[80]=1;
          ends[80]=1;
          tdone[80]=1;
        }
        break;
      
    }
  }

  public void thread24919(int [] tdone, int [] ends){
        switch(S8370){
      case 0 : 
        active[79]=0;
        ends[79]=0;
        tdone[79]=1;
        break;
      
      case 1 : 
        if(armDest.getprestatus()){//sysj\plant.sysj line: 635, column: 24
          armDestE.setPresent();//sysj\plant.sysj line: 635, column: 33
          currsigs.addElement(armDestE);
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

  public void thread24918(int [] tdone, int [] ends){
        switch(S8362){
      case 0 : 
        active[78]=0;
        ends[78]=0;
        tdone[78]=1;
        break;
      
      case 1 : 
        if(armSource.getprestatus()){//sysj\plant.sysj line: 633, column: 24
          armSourceE.setPresent();//sysj\plant.sysj line: 633, column: 35
          currsigs.addElement(armSourceE);
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

  public void thread24917(int [] tdone, int [] ends){
        switch(S8354){
      case 0 : 
        active[77]=0;
        ends[77]=0;
        tdone[77]=1;
        break;
      
      case 1 : 
        if(vacOn.getprestatus()){//sysj\plant.sysj line: 631, column: 24
          vacOnE.setPresent();//sysj\plant.sysj line: 631, column: 31
          currsigs.addElement(vacOnE);
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

  public void thread24916(int [] tdone, int [] ends){
        switch(S8346){
      case 0 : 
        active[76]=0;
        ends[76]=0;
        tdone[76]=1;
        break;
      
      case 1 : 
        if(pusherExtend.getprestatus()){//sysj\plant.sysj line: 629, column: 24
          pusherExtendE.setPresent();//sysj\plant.sysj line: 629, column: 38
          currsigs.addElement(pusherExtendE);
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

  public void thread24915(int [] tdone, int [] ends){
        switch(S8338){
      case 0 : 
        active[75]=0;
        ends[75]=0;
        tdone[75]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\plant.sysj line: 626, column: 24
          emptyE.setPresent();//sysj\plant.sysj line: 626, column: 31
          currsigs.addElement(emptyE);
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

  public void thread24914(int [] tdone, int [] ends){
        switch(S8330){
      case 0 : 
        active[74]=0;
        ends[74]=0;
        tdone[74]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\plant.sysj line: 624, column: 24
          armAtDestE.setPresent();//sysj\plant.sysj line: 624, column: 35
          currsigs.addElement(armAtDestE);
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

  public void thread24913(int [] tdone, int [] ends){
        switch(S8322){
      case 0 : 
        active[73]=0;
        ends[73]=0;
        tdone[73]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\plant.sysj line: 622, column: 24
          armAtSourceE.setPresent();//sysj\plant.sysj line: 622, column: 37
          currsigs.addElement(armAtSourceE);
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

  public void thread24912(int [] tdone, int [] ends){
        switch(S8314){
      case 0 : 
        active[72]=0;
        ends[72]=0;
        tdone[72]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\plant.sysj line: 620, column: 24
          WPgrippedE.setPresent();//sysj\plant.sysj line: 620, column: 35
          currsigs.addElement(WPgrippedE);
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

  public void thread24911(int [] tdone, int [] ends){
        switch(S8306){
      case 0 : 
        active[71]=0;
        ends[71]=0;
        tdone[71]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 618, column: 24
          pusherExtendedE.setPresent();//sysj\plant.sysj line: 618, column: 40
          currsigs.addElement(pusherExtendedE);
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

  public void thread24910(int [] tdone, int [] ends){
        switch(S8298){
      case 0 : 
        active[70]=0;
        ends[70]=0;
        tdone[70]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 616, column: 24
          pusherRetractedE.setPresent();//sysj\plant.sysj line: 616, column: 41
          currsigs.addElement(pusherRetractedE);
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

  public void thread24909(int [] tdone, int [] ends){
        switch(S8380){
      case 0 : 
        active[69]=0;
        ends[69]=0;
        tdone[69]=1;
        break;
      
      case 1 : 
        thread24910(tdone,ends);
        thread24911(tdone,ends);
        thread24912(tdone,ends);
        thread24913(tdone,ends);
        thread24914(tdone,ends);
        thread24915(tdone,ends);
        thread24916(tdone,ends);
        thread24917(tdone,ends);
        thread24918(tdone,ends);
        thread24919(tdone,ends);
        thread24920(tdone,ends);
        int biggest24921 = 0;
        if(ends[70]>=biggest24921){
          biggest24921=ends[70];
        }
        if(ends[71]>=biggest24921){
          biggest24921=ends[71];
        }
        if(ends[72]>=biggest24921){
          biggest24921=ends[72];
        }
        if(ends[73]>=biggest24921){
          biggest24921=ends[73];
        }
        if(ends[74]>=biggest24921){
          biggest24921=ends[74];
        }
        if(ends[75]>=biggest24921){
          biggest24921=ends[75];
        }
        if(ends[76]>=biggest24921){
          biggest24921=ends[76];
        }
        if(ends[77]>=biggest24921){
          biggest24921=ends[77];
        }
        if(ends[78]>=biggest24921){
          biggest24921=ends[78];
        }
        if(ends[79]>=biggest24921){
          biggest24921=ends[79];
        }
        if(ends[80]>=biggest24921){
          biggest24921=ends[80];
        }
        if(biggest24921 == 1){
          active[69]=1;
          ends[69]=1;
          tdone[69]=1;
        }
        //FINXME code
        if(biggest24921 == 0){
          S8380=0;
          active[69]=0;
          ends[69]=0;
          tdone[69]=1;
        }
        break;
      
    }
  }

  public void thread24908(int [] tdone, int [] ends){
        switch(S8290){
      case 0 : 
        active[68]=0;
        ends[68]=0;
        tdone[68]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 600, column: 12
          if(capcount_thread_68 > 0) {//sysj\plant.sysj line: 601, column: 5
            capcount_thread_68 = capcount_thread_68 - 1;//sysj\plant.sysj line: 602, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 604, column: 12
            capcount_thread_68 = 5;//sysj\plant.sysj line: 605, column: 5
            if(capcount_thread_68 == 0){//sysj\plant.sysj line: 608, column: 8
              empty.setPresent();//sysj\plant.sysj line: 609, column: 6
              currsigs.addElement(empty);
              active[68]=1;
              ends[68]=1;
              tdone[68]=1;
            }
            else {
              active[68]=1;
              ends[68]=1;
              tdone[68]=1;
            }
          }
          else {
            if(capcount_thread_68 == 0){//sysj\plant.sysj line: 608, column: 8
              empty.setPresent();//sysj\plant.sysj line: 609, column: 6
              currsigs.addElement(empty);
              active[68]=1;
              ends[68]=1;
              tdone[68]=1;
            }
            else {
              active[68]=1;
              ends[68]=1;
              tdone[68]=1;
            }
          }
        }
        else {
          if(refill.getprestatus()){//sysj\plant.sysj line: 604, column: 12
            capcount_thread_68 = 5;//sysj\plant.sysj line: 605, column: 5
            if(capcount_thread_68 == 0){//sysj\plant.sysj line: 608, column: 8
              empty.setPresent();//sysj\plant.sysj line: 609, column: 6
              currsigs.addElement(empty);
              active[68]=1;
              ends[68]=1;
              tdone[68]=1;
            }
            else {
              active[68]=1;
              ends[68]=1;
              tdone[68]=1;
            }
          }
          else {
            if(capcount_thread_68 == 0){//sysj\plant.sysj line: 608, column: 8
              empty.setPresent();//sysj\plant.sysj line: 609, column: 6
              currsigs.addElement(empty);
              active[68]=1;
              ends[68]=1;
              tdone[68]=1;
            }
            else {
              active[68]=1;
              ends[68]=1;
              tdone[68]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread24907(int [] tdone, int [] ends){
        switch(S8228){
      case 0 : 
        active[67]=0;
        ends[67]=0;
        tdone[67]=1;
        break;
      
      case 1 : 
        switch(S8182){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 583, column: 10
              S8182=1;
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
            else {
              switch(S8164){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 585, column: 13
                    S8164=1;
                    active[67]=1;
                    ends[67]=1;
                    tdone[67]=1;
                  }
                  else {
                    active[67]=1;
                    ends[67]=1;
                    tdone[67]=1;
                  }
                  break;
                
                case 1 : 
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 586, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 588, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 588, column: 7
                    S8164=2;
                    active[67]=1;
                    ends[67]=1;
                    tdone[67]=1;
                  }
                  else {
                    active[67]=1;
                    ends[67]=1;
                    tdone[67]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 589, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 590, column: 7
                    currsigs.addElement(capDec_1);
                    S8164=0;
                    active[67]=1;
                    ends[67]=1;
                    tdone[67]=1;
                  }
                  else {
                    active[67]=1;
                    ends[67]=1;
                    tdone[67]=1;
                  }
                  break;
                
              }
            }
            break;
          
          case 1 : 
            if(refill.getprestatus()){//sysj\plant.sysj line: 593, column: 10
              S8182=0;
              S8164=0;
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
            else {
              active[67]=1;
              ends[67]=1;
              tdone[67]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread24906(int [] tdone, int [] ends){
        switch(S8160){
      case 0 : 
        active[66]=0;
        ends[66]=0;
        tdone[66]=1;
        break;
      
      case 1 : 
        switch(S8130){
          case 0 : 
            if(!vacOn.getprestatus()){//sysj\plant.sysj line: 563, column: 12
              if(armAtSource.getprestatus()){//sysj\plant.sysj line: 566, column: 14
                capPos_1.setPresent();//sysj\plant.sysj line: 567, column: 7
                currsigs.addElement(capPos_1);
                capPos_1.setValue(1);//sysj\plant.sysj line: 567, column: 7
                S8130=1;
                active[66]=1;
                ends[66]=1;
                tdone[66]=1;
              }
              else {
                S8130=1;
                active[66]=1;
                ends[66]=1;
                tdone[66]=1;
              }
            }
            else {
              WPgripped.setPresent();//sysj\plant.sysj line: 564, column: 7
              currsigs.addElement(WPgripped);
              active[66]=1;
              ends[66]=1;
              tdone[66]=1;
            }
            break;
          
          case 1 : 
            S8130=1;
            S8130=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 560, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 561, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 562, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 562, column: 6
                WPgripped.setPresent();//sysj\plant.sysj line: 564, column: 7
                currsigs.addElement(WPgripped);
                active[66]=1;
                ends[66]=1;
                tdone[66]=1;
              }
              else {
                S8130=1;
                active[66]=1;
                ends[66]=1;
                tdone[66]=1;
              }
            }
            else {
              S8130=1;
              active[66]=1;
              ends[66]=1;
              tdone[66]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread24905(int [] tdone, int [] ends){
        switch(S8116){
      case 0 : 
        active[65]=0;
        ends[65]=0;
        tdone[65]=1;
        break;
      
      case 1 : 
        switch(S8070){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 547, column: 10
              S8070=1;
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 548, column: 5
              currsigs.addElement(pusherRetracted);
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 550, column: 10
              S8070=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 552, column: 5
              currsigs.addElement(pusherExtended);
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            else {
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            break;
          
          case 2 : 
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 551, column: 10
              S8070=3;
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 552, column: 5
              currsigs.addElement(pusherExtended);
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 554, column: 10
              S8070=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 548, column: 5
              currsigs.addElement(pusherRetracted);
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            else {
              active[65]=1;
              ends[65]=1;
              tdone[65]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread24904(int [] tdone, int [] ends){
        switch(S8063){
      case 0 : 
        active[64]=0;
        ends[64]=0;
        tdone[64]=1;
        break;
      
      case 1 : 
        switch(S8017){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 534, column: 10
              S8017=1;
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 535, column: 5
              currsigs.addElement(armAtDest);
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 537, column: 10
              S8017=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 539, column: 5
              currsigs.addElement(armAtSource);
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 538, column: 10
              S8017=3;
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 539, column: 5
              currsigs.addElement(armAtSource);
              active[64]=1;
              ends[64]=1;
              tdone[64]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 541, column: 10
              S8017=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 535, column: 5
              currsigs.addElement(armAtDest);
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

  public void thread24902(int [] tdone, int [] ends){
        switch(S8008){
      case 0 : 
        active[63]=0;
        ends[63]=0;
        tdone[63]=1;
        break;
      
      case 1 : 
        if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 528, column: 25
          bottleAddedC.setPresent();//sysj\plant.sysj line: 528, column: 38
          currsigs.addElement(bottleAddedC);
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
  }

  public void thread24901(int [] tdone, int [] ends){
        switch(S8000){
      case 0 : 
        active[62]=0;
        ends[62]=0;
        tdone[62]=1;
        break;
      
      case 1 : 
        if(noz4.getprestatus()){//sysj\plant.sysj line: 526, column: 25
          noz4E.setPresent();//sysj\plant.sysj line: 526, column: 31
          currsigs.addElement(noz4E);
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

  public void thread24900(int [] tdone, int [] ends){
        switch(S7992){
      case 0 : 
        active[61]=0;
        ends[61]=0;
        tdone[61]=1;
        break;
      
      case 1 : 
        if(noz3.getprestatus()){//sysj\plant.sysj line: 524, column: 25
          noz3E.setPresent();//sysj\plant.sysj line: 524, column: 31
          currsigs.addElement(noz3E);
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

  public void thread24899(int [] tdone, int [] ends){
        switch(S7984){
      case 0 : 
        active[60]=0;
        ends[60]=0;
        tdone[60]=1;
        break;
      
      case 1 : 
        if(noz2.getprestatus()){//sysj\plant.sysj line: 522, column: 25
          noz2E.setPresent();//sysj\plant.sysj line: 522, column: 31
          currsigs.addElement(noz2E);
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

  public void thread24898(int [] tdone, int [] ends){
        switch(S7976){
      case 0 : 
        active[59]=0;
        ends[59]=0;
        tdone[59]=1;
        break;
      
      case 1 : 
        if(noz1.getprestatus()){//sysj\plant.sysj line: 520, column: 25
          noz1E.setPresent();//sysj\plant.sysj line: 520, column: 31
          currsigs.addElement(noz1E);
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

  public void thread24897(int [] tdone, int [] ends){
        switch(S7968){
      case 0 : 
        active[58]=0;
        ends[58]=0;
        tdone[58]=1;
        break;
      
      case 1 : 
        if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 518, column: 25
          capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 518, column: 44
          currsigs.addElement(capOnBottleAtPos1E);
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

  public void thread24896(int [] tdone, int [] ends){
        switch(S7960){
      case 0 : 
        active[57]=0;
        ends[57]=0;
        tdone[57]=1;
        break;
      
      case 1 : 
        if(selNoz4.getprestatus()){//sysj\plant.sysj line: 516, column: 25
          o_selNoz4.setPresent();//sysj\plant.sysj line: 516, column: 34
          currsigs.addElement(o_selNoz4);
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

  public void thread24895(int [] tdone, int [] ends){
        switch(S7952){
      case 0 : 
        active[56]=0;
        ends[56]=0;
        tdone[56]=1;
        break;
      
      case 1 : 
        if(selNoz3.getprestatus()){//sysj\plant.sysj line: 514, column: 25
          o_selNoz3.setPresent();//sysj\plant.sysj line: 514, column: 34
          currsigs.addElement(o_selNoz3);
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

  public void thread24894(int [] tdone, int [] ends){
        switch(S7944){
      case 0 : 
        active[55]=0;
        ends[55]=0;
        tdone[55]=1;
        break;
      
      case 1 : 
        if(selNoz2.getprestatus()){//sysj\plant.sysj line: 512, column: 25
          o_selNoz2.setPresent();//sysj\plant.sysj line: 512, column: 34
          currsigs.addElement(o_selNoz2);
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

  public void thread24893(int [] tdone, int [] ends){
        switch(S7936){
      case 0 : 
        active[54]=0;
        ends[54]=0;
        tdone[54]=1;
        break;
      
      case 1 : 
        if(selNoz1.getprestatus()){//sysj\plant.sysj line: 510, column: 25
          o_selNoz1.setPresent();//sysj\plant.sysj line: 510, column: 34
          currsigs.addElement(o_selNoz1);
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

  public void thread24892(int [] tdone, int [] ends){
        switch(S7928){
      case 0 : 
        active[53]=0;
        ends[53]=0;
        tdone[53]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 507, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 507, column: 40
          currsigs.addElement(dosUnitFilledE);
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

  public void thread24891(int [] tdone, int [] ends){
        switch(S7920){
      case 0 : 
        active[52]=0;
        ends[52]=0;
        tdone[52]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 505, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 505, column: 38
          currsigs.addElement(dosUnitEvacE);
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

  public void thread24890(int [] tdone, int [] ends){
        switch(S7912){
      case 0 : 
        active[51]=0;
        ends[51]=0;
        tdone[51]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 503, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 503, column: 39
          currsigs.addElement(bottleAtPos2E);
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

  public void thread24889(int [] tdone, int [] ends){
        switch(S7904){
      case 0 : 
        active[50]=0;
        ends[50]=0;
        tdone[50]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 501, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 501, column: 45
          currsigs.addElement(dosUnitValveExtendE);
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

  public void thread24888(int [] tdone, int [] ends){
        switch(S7896){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 499, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 499, column: 46
          currsigs.addElement(dosUnitValveRetractE);
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

  public void thread24887(int [] tdone, int [] ends){
        switch(S7888){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 497, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 497, column: 42
          currsigs.addElement(valveInletOnOffE);
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

  public void thread24886(int [] tdone, int [] ends){
        switch(S7880){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 495, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 495, column: 45
          currsigs.addElement(valveInjectorOnOffE);
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

  public void thread24885(int [] tdone, int [] ends){
        switch(S7872){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 492, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 492, column: 47
          currsigs.addElement(cylClampBottleExtendE);
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

  public void thread24884(int [] tdone, int [] ends){
        switch(S7864){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 490, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 490, column: 47
          currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread24883(int [] tdone, int [] ends){
        switch(S7856){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 488, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 488, column: 44
          currsigs.addElement(gripperTurnExtendE);
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

  public void thread24882(int [] tdone, int [] ends){
        switch(S7848){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 486, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 486, column: 45
          currsigs.addElement(gripperTurnRetractE);
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

  public void thread24881(int [] tdone, int [] ends){
        switch(S7840){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 484, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 484, column: 45
          currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread24880(int [] tdone, int [] ends){
        switch(S7832){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 482, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 482, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread24879(int [] tdone, int [] ends){
        switch(S7824){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 479, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 479, column: 45
          currsigs.addElement(gripperTurnHomePosE);
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

  public void thread24878(int [] tdone, int [] ends){
        switch(S7816){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 477, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 477, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread24877(int [] tdone, int [] ends){
        switch(S7808){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 475, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 475, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread24876(int [] tdone, int [] ends){
        switch(S7800){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 473, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 473, column: 38
          currsigs.addElement(bottleAtPos2E);
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

  public void thread24875(int [] tdone, int [] ends){
        switch(S7792){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 471, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 471, column: 38
          currsigs.addElement(bottleAtPos4E);
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

  public void thread24874(int [] tdone, int [] ends){
        switch(S7784){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        switch(S7770){
          case 0 : 
            switch(S7768){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 469, column: 54
                  S7768=1;
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
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 469, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 469, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  S7770=1;
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
            break;
          
          case 1 : 
            S7770=1;
            S7770=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 469, column: 24
              S7768=0;
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            else {
              S7770=1;
              active[35]=1;
              ends[35]=1;
              tdone[35]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread24873(int [] tdone, int [] ends){
        switch(S7764){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        switch(S7738){
          case 0 : 
            switch(S7736){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 460, column: 11
                  S7736=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 462, column: 6
                  currsigs.addElement(bottleLeftPos5E);
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 461, column: 11
                  S7738=1;
                  active[34]=1;
                  ends[34]=1;
                  tdone[34]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 462, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[34]=1;
                  ends[34]=1;
                  tdone[34]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S7738=1;
            S7738=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 459, column: 12
              S7736=0;
              active[34]=1;
              ends[34]=1;
              tdone[34]=1;
            }
            else {
              S7738=1;
              active[34]=1;
              ends[34]=1;
              tdone[34]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread24872(int [] tdone, int [] ends){
        switch(S7726){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 456, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 456, column: 56
          currsigs.addElement(bottleAtPos5E);
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

  public void thread24871(int [] tdone, int [] ends){
        switch(S7718){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        switch(S7704){
          case 0 : 
            switch(S7702){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 454, column: 54
                  S7702=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 454, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 454, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  S7704=1;
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
            S7704=1;
            S7704=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 454, column: 24
              S7702=0;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            else {
              S7704=1;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread24870(int [] tdone, int [] ends){
        switch(S7698){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 452, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 452, column: 44
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

  public void thread24869(int [] tdone, int [] ends){
        switch(S7690){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 450, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 450, column: 39
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

  public void thread24868(int [] tdone, int [] ends){
        switch(S7682){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 448, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 448, column: 38
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

  public void thread24867(int [] tdone, int [] ends){
        switch(S8010){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        thread24868(tdone,ends);
        thread24869(tdone,ends);
        thread24870(tdone,ends);
        thread24871(tdone,ends);
        thread24872(tdone,ends);
        thread24873(tdone,ends);
        thread24874(tdone,ends);
        thread24875(tdone,ends);
        thread24876(tdone,ends);
        thread24877(tdone,ends);
        thread24878(tdone,ends);
        thread24879(tdone,ends);
        thread24880(tdone,ends);
        thread24881(tdone,ends);
        thread24882(tdone,ends);
        thread24883(tdone,ends);
        thread24884(tdone,ends);
        thread24885(tdone,ends);
        thread24886(tdone,ends);
        thread24887(tdone,ends);
        thread24888(tdone,ends);
        thread24889(tdone,ends);
        thread24890(tdone,ends);
        thread24891(tdone,ends);
        thread24892(tdone,ends);
        thread24893(tdone,ends);
        thread24894(tdone,ends);
        thread24895(tdone,ends);
        thread24896(tdone,ends);
        thread24897(tdone,ends);
        thread24898(tdone,ends);
        thread24899(tdone,ends);
        thread24900(tdone,ends);
        thread24901(tdone,ends);
        thread24902(tdone,ends);
        int biggest24903 = 0;
        if(ends[29]>=biggest24903){
          biggest24903=ends[29];
        }
        if(ends[30]>=biggest24903){
          biggest24903=ends[30];
        }
        if(ends[31]>=biggest24903){
          biggest24903=ends[31];
        }
        if(ends[32]>=biggest24903){
          biggest24903=ends[32];
        }
        if(ends[33]>=biggest24903){
          biggest24903=ends[33];
        }
        if(ends[34]>=biggest24903){
          biggest24903=ends[34];
        }
        if(ends[35]>=biggest24903){
          biggest24903=ends[35];
        }
        if(ends[36]>=biggest24903){
          biggest24903=ends[36];
        }
        if(ends[37]>=biggest24903){
          biggest24903=ends[37];
        }
        if(ends[38]>=biggest24903){
          biggest24903=ends[38];
        }
        if(ends[39]>=biggest24903){
          biggest24903=ends[39];
        }
        if(ends[40]>=biggest24903){
          biggest24903=ends[40];
        }
        if(ends[41]>=biggest24903){
          biggest24903=ends[41];
        }
        if(ends[42]>=biggest24903){
          biggest24903=ends[42];
        }
        if(ends[43]>=biggest24903){
          biggest24903=ends[43];
        }
        if(ends[44]>=biggest24903){
          biggest24903=ends[44];
        }
        if(ends[45]>=biggest24903){
          biggest24903=ends[45];
        }
        if(ends[46]>=biggest24903){
          biggest24903=ends[46];
        }
        if(ends[47]>=biggest24903){
          biggest24903=ends[47];
        }
        if(ends[48]>=biggest24903){
          biggest24903=ends[48];
        }
        if(ends[49]>=biggest24903){
          biggest24903=ends[49];
        }
        if(ends[50]>=biggest24903){
          biggest24903=ends[50];
        }
        if(ends[51]>=biggest24903){
          biggest24903=ends[51];
        }
        if(ends[52]>=biggest24903){
          biggest24903=ends[52];
        }
        if(ends[53]>=biggest24903){
          biggest24903=ends[53];
        }
        if(ends[54]>=biggest24903){
          biggest24903=ends[54];
        }
        if(ends[55]>=biggest24903){
          biggest24903=ends[55];
        }
        if(ends[56]>=biggest24903){
          biggest24903=ends[56];
        }
        if(ends[57]>=biggest24903){
          biggest24903=ends[57];
        }
        if(ends[58]>=biggest24903){
          biggest24903=ends[58];
        }
        if(ends[59]>=biggest24903){
          biggest24903=ends[59];
        }
        if(ends[60]>=biggest24903){
          biggest24903=ends[60];
        }
        if(ends[61]>=biggest24903){
          biggest24903=ends[61];
        }
        if(ends[62]>=biggest24903){
          biggest24903=ends[62];
        }
        if(ends[63]>=biggest24903){
          biggest24903=ends[63];
        }
        if(biggest24903 == 1){
          active[28]=1;
          ends[28]=1;
          tdone[28]=1;
        }
        //FINXME code
        if(biggest24903 == 0){
          S8010=0;
          active[28]=0;
          ends[28]=0;
          tdone[28]=1;
        }
        break;
      
    }
  }

  public void thread24865(int [] tdone, int [] ends){
        switch(S7672){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        switch(S7621){
          case 0 : 
            S7621=0;
            S7621=1;
            active[27]=1;
            ends[27]=1;
            tdone[27]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 425, column: 11
              S7621=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 4){//sysj\plant.sysj line: 426, column: 8
                noz4.setPresent();//sysj\plant.sysj line: 428, column: 7
                currsigs.addElement(noz4);
                active[27]=1;
                ends[27]=1;
                tdone[27]=1;
              }
              else {
                S7621=0;
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
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 427, column: 12
              S7621=0;
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              noz4.setPresent();//sysj\plant.sysj line: 428, column: 7
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

  public void thread24864(int [] tdone, int [] ends){
        switch(S7618){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S7567){
          case 0 : 
            S7567=0;
            S7567=1;
            active[26]=1;
            ends[26]=1;
            tdone[26]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 413, column: 11
              S7567=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 3){//sysj\plant.sysj line: 414, column: 8
                noz3.setPresent();//sysj\plant.sysj line: 416, column: 7
                currsigs.addElement(noz3);
                active[26]=1;
                ends[26]=1;
                tdone[26]=1;
              }
              else {
                S7567=0;
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
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 415, column: 12
              S7567=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              noz3.setPresent();//sysj\plant.sysj line: 416, column: 7
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

  public void thread24863(int [] tdone, int [] ends){
        switch(S7564){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S7513){
          case 0 : 
            S7513=0;
            S7513=1;
            active[25]=1;
            ends[25]=1;
            tdone[25]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 401, column: 11
              S7513=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 2){//sysj\plant.sysj line: 402, column: 8
                noz2.setPresent();//sysj\plant.sysj line: 404, column: 7
                currsigs.addElement(noz2);
                active[25]=1;
                ends[25]=1;
                tdone[25]=1;
              }
              else {
                S7513=0;
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
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 403, column: 12
              S7513=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              noz2.setPresent();//sysj\plant.sysj line: 404, column: 7
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

  public void thread24862(int [] tdone, int [] ends){
        switch(S7510){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S7459){
          case 0 : 
            S7459=0;
            S7459=1;
            active[24]=1;
            ends[24]=1;
            tdone[24]=1;
            break;
          
          case 1 : 
            if(s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 388, column: 11
              S7459=2;
              if((s_nozzlenum_1.getpreval() == null ? null : ((Integer)s_nozzlenum_1.getpreval())) == 1){//sysj\plant.sysj line: 389, column: 8
                noz1.setPresent();//sysj\plant.sysj line: 391, column: 7
                currsigs.addElement(noz1);
                active[24]=1;
                ends[24]=1;
                tdone[24]=1;
              }
              else {
                S7459=0;
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
            if(!s_nozzlenum_1.getprestatus()){//sysj\plant.sysj line: 390, column: 12
              S7459=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              noz1.setPresent();//sysj\plant.sysj line: 391, column: 7
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

  public void thread24861(int [] tdone, int [] ends){
        switch(S7456){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S7293){
          case 0 : 
            S7293=0;
            S7293=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 361, column: 13
              S7272=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S7293=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S7272){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 362, column: 12
                  nozzlenum_thread_23 = nozzlenum_thread_23 + 1;//sysj\plant.sysj line: 363, column: 6
                  if(nozzlenum_thread_23 > 4) {//sysj\plant.sysj line: 364, column: 24
                    nozzlenum_thread_23 = 0;//sysj\plant.sysj line: 365, column: 7
                  }
                  S7272=1;
                  s_nozzlenum_1.setPresent();//sysj\plant.sysj line: 368, column: 7
                  currsigs.addElement(s_nozzlenum_1);
                  s_nozzlenum_1.setValue(nozzlenum_thread_23);//sysj\plant.sysj line: 368, column: 7
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
                if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 367, column: 12
                  S7293=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  s_nozzlenum_1.setPresent();//sysj\plant.sysj line: 368, column: 7
                  currsigs.addElement(s_nozzlenum_1);
                  s_nozzlenum_1.setValue(nozzlenum_thread_23);//sysj\plant.sysj line: 368, column: 7
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

  public void thread24860(int [] tdone, int [] ends){
        switch(S7674){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        s_nozzlenum_1.setClear();//sysj\plant.sysj line: 355, column: 3
        thread24861(tdone,ends);
        thread24862(tdone,ends);
        thread24863(tdone,ends);
        thread24864(tdone,ends);
        thread24865(tdone,ends);
        int biggest24866 = 0;
        if(ends[23]>=biggest24866){
          biggest24866=ends[23];
        }
        if(ends[24]>=biggest24866){
          biggest24866=ends[24];
        }
        if(ends[25]>=biggest24866){
          biggest24866=ends[25];
        }
        if(ends[26]>=biggest24866){
          biggest24866=ends[26];
        }
        if(ends[27]>=biggest24866){
          biggest24866=ends[27];
        }
        if(biggest24866 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest24866 == 0){
          S7674=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread24859(int [] tdone, int [] ends){
        switch(S7269){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S7198){
          case 0 : 
            S7198=0;
            S7198=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 344, column: 12
              S7185=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S7198=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S7185){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 345, column: 11
                  S7185=1;
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 347, column: 6
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
                if(!dosUnitValveRetract.getprestatus() && dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 346, column: 11
                  S7198=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 347, column: 6
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

  public void thread24858(int [] tdone, int [] ends){
        switch(S7175){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S7174){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 327, column: 9
              S7174=1;
              S7012=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 328, column: 4
              currsigs.addElement(dosUnitEvac);
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S7012){
              case 0 : 
                S7012=0;
                S7012=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 332, column: 12
                  S6999=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  S7012=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                break;
              
              case 1 : 
                switch(S6999){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 333, column: 11
                      S6999=1;
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 335, column: 6
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
                    if(!dosUnitValveExtend.getprestatus() && dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 334, column: 11
                      S7012=0;
                      active[20]=1;
                      ends[20]=1;
                      tdone[20]=1;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 335, column: 6
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

  public void thread24857(int [] tdone, int [] ends){
        switch(S6985){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S6950){
          case 0 : 
            S6950=0;
            S6950=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 314, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 316, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S6950=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 315, column: 11
              S6950=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 316, column: 6
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

  public void thread24856(int [] tdone, int [] ends){
        switch(S6939){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S6868){
          case 0 : 
            S6868=0;
            S6868=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 302, column: 12
              S6855=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S6868=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S6855){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 303, column: 11
                  S6855=1;
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 305, column: 6
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
                if(!gripperTurnRetract.getprestatus() && gripperTurnExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 304, column: 11
                  S6868=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 305, column: 6
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

  public void thread24855(int [] tdone, int [] ends){
        switch(S6845){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S6774){
          case 0 : 
            S6774=0;
            S6774=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 290, column: 12
              S6761=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S6774=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S6761){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 291, column: 11
                  S6761=1;
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 293, column: 6
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
                if(!gripperTurnExtend.getprestatus() && gripperTurnRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 292, column: 11
                  S6774=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 293, column: 6
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

  public void thread24854(int [] tdone, int [] ends){
        switch(S6751){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S6680){
          case 0 : 
            S6680=0;
            S6680=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 278, column: 12
              S6667=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S6680=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S6667){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 279, column: 11
                  S6667=1;
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 281, column: 6
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
                if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 280, column: 11
                  S6680=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 281, column: 6
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

  public void thread24853(int [] tdone, int [] ends){
        switch(S6657){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S6411){
          case 0 : 
            S6411=0;
            S6411=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 258, column: 12
              rand_thread_15 = (int)(Math.random() * 100);//sysj\plant.sysj line: 259, column: 5
              System.out.println(rand_thread_15);//sysj\plant.sysj line: 260, column: 5
              S6377=0;
              if(rand_thread_15 < chance_thread_15){//sysj\plant.sysj line: 261, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 263, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                S6377=1;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              S6411=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S6377){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 262, column: 12
                  S6377=1;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 263, column: 8
                  currsigs.addElement(capOnBottleAtPos1);
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 267, column: 11
                  S6377=2;
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
                if(!enable.getprestatus()){//sysj\plant.sysj line: 268, column: 11
                  S6411=0;
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

  public void thread24852(int [] tdone, int [] ends){
        switch(S6375){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S3868){
          case 0 : 
            S3868=0;
            S3868=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 221, column: 12
              S3703=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              S3868=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S3703){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 222, column: 11
                  numTurns_thread_14 = numTurns_thread_14 + 1;//sysj\plant.sysj line: 223, column: 5
                  S3703=1;
                  if(numTurns_thread_14 >= 2 && numTurns_thread_14 < 3){//sysj\plant.sysj line: 224, column: 8
                    S3743=0;
                    l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 225, column: 6
                    currsigs.addElement(l_putBottleAt2_1);
                    tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 227, column: 7
                    currsigs.addElement(tableAlignedWithSensor);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    S3743=1;
                    if(numTurns_thread_14 >= 3 && numTurns_thread_14 < 4){//sysj\plant.sysj line: 229, column: 14
                      S3742=0;
                      l_putBottleAt3_1.setPresent();//sysj\plant.sysj line: 230, column: 6
                      currsigs.addElement(l_putBottleAt3_1);
                      System.out.println("putting at pos 3");//sysj\plant.sysj line: 231, column: 6
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 233, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      S3742=1;
                      if(numTurns_thread_14 >= 4 && numTurns_thread_14 < 5){//sysj\plant.sysj line: 236, column: 14
                        S3741=0;
                        l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 237, column: 6
                        currsigs.addElement(l_putBottleAt4_1);
                        tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 239, column: 7
                        currsigs.addElement(tableAlignedWithSensor);
                        active[14]=1;
                        ends[14]=1;
                        tdone[14]=1;
                      }
                      else {
                        S3741=1;
                        if(numTurns_thread_14 >= 5){//sysj\plant.sysj line: 241, column: 14
                          numTurns_thread_14 = 0;//sysj\plant.sysj line: 242, column: 6
                          l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 243, column: 6
                          currsigs.addElement(l_putBottleAt5_1);
                          tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 245, column: 7
                          currsigs.addElement(tableAlignedWithSensor);
                          active[14]=1;
                          ends[14]=1;
                          tdone[14]=1;
                        }
                        else {
                          S3868=0;
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
                switch(S3743){
                  case 0 : 
                    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 226, column: 12
                      S3868=0;
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
                    switch(S3742){
                      case 0 : 
                        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 232, column: 12
                          S3868=0;
                          active[14]=1;
                          ends[14]=1;
                          tdone[14]=1;
                        }
                        else {
                          tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 233, column: 7
                          currsigs.addElement(tableAlignedWithSensor);
                          active[14]=1;
                          ends[14]=1;
                          tdone[14]=1;
                        }
                        break;
                      
                      case 1 : 
                        switch(S3741){
                          case 0 : 
                            if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 238, column: 12
                              S3868=0;
                              active[14]=1;
                              ends[14]=1;
                              tdone[14]=1;
                            }
                            else {
                              tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 239, column: 7
                              currsigs.addElement(tableAlignedWithSensor);
                              active[14]=1;
                              ends[14]=1;
                              tdone[14]=1;
                            }
                            break;
                          
                          case 1 : 
                            if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 244, column: 12
                              S3868=0;
                              active[14]=1;
                              ends[14]=1;
                              tdone[14]=1;
                            }
                            else {
                              tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 245, column: 7
                              currsigs.addElement(tableAlignedWithSensor);
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

  public void thread24851(int [] tdone, int [] ends){
        switch(S3701){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S3678){
          case 0 : 
            S3678=0;
            S3678=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 208, column: 12
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S3678=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 209, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 210, column: 5
              currsigs.addElement(bottleLeftPos5);
              S3678=0;
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

  public void thread24850(int [] tdone, int [] ends){
        switch(S3671){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S3546){
          case 0 : 
            S3546=0;
            S3546=1;
            if(l_putBottleAt3_1.getprestatus()){//sysj\plant.sysj line: 195, column: 12
              System.out.println("putting at pos 3 proper");//sysj\plant.sysj line: 196, column: 5
              S3513=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S3546=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos4.getprestatus())){//sysj\plant.sysj line: 197, column: 11
              S3546=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              switch(S3513){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 198, column: 12
                    S3513=1;
                    bottleAtPos3.setPresent();//sysj\plant.sysj line: 199, column: 6
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
                  bottleAtPos3.setPresent();//sysj\plant.sysj line: 199, column: 6
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

  public void thread24849(int [] tdone, int [] ends){
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

  public void thread24848(int [] tdone, int [] ends){
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

  public void thread24847(int [] tdone, int [] ends){
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

  public void thread24846(int [] tdone, int [] ends){
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

  public void thread24845(int [] tdone, int [] ends){
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

  public void thread24844(int [] tdone, int [] ends){
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

  public void thread24843(int [] tdone, int [] ends){
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

  public void thread24842(int [] tdone, int [] ends){
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

  public void thread24841(int [] tdone, int [] ends){
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

  public void thread24840(int [] tdone, int [] ends){
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

  public void thread24837(int [] tdone, int [] ends){
        S8378=1;
    if(bottleAtPos3.getprestatus()){//sysj\plant.sysj line: 637, column: 24
      bottleAtPos3E.setPresent();//sysj\plant.sysj line: 637, column: 38
      currsigs.addElement(bottleAtPos3E);
      active[80]=1;
      ends[80]=1;
      tdone[80]=1;
    }
    else {
      active[80]=1;
      ends[80]=1;
      tdone[80]=1;
    }
  }

  public void thread24836(int [] tdone, int [] ends){
        S8370=1;
    if(armDest.getprestatus()){//sysj\plant.sysj line: 635, column: 24
      armDestE.setPresent();//sysj\plant.sysj line: 635, column: 33
      currsigs.addElement(armDestE);
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

  public void thread24835(int [] tdone, int [] ends){
        S8362=1;
    if(armSource.getprestatus()){//sysj\plant.sysj line: 633, column: 24
      armSourceE.setPresent();//sysj\plant.sysj line: 633, column: 35
      currsigs.addElement(armSourceE);
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

  public void thread24834(int [] tdone, int [] ends){
        S8354=1;
    if(vacOn.getprestatus()){//sysj\plant.sysj line: 631, column: 24
      vacOnE.setPresent();//sysj\plant.sysj line: 631, column: 31
      currsigs.addElement(vacOnE);
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

  public void thread24833(int [] tdone, int [] ends){
        S8346=1;
    if(pusherExtend.getprestatus()){//sysj\plant.sysj line: 629, column: 24
      pusherExtendE.setPresent();//sysj\plant.sysj line: 629, column: 38
      currsigs.addElement(pusherExtendE);
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

  public void thread24832(int [] tdone, int [] ends){
        S8338=1;
    if(empty.getprestatus()){//sysj\plant.sysj line: 626, column: 24
      emptyE.setPresent();//sysj\plant.sysj line: 626, column: 31
      currsigs.addElement(emptyE);
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

  public void thread24831(int [] tdone, int [] ends){
        S8330=1;
    if(armAtDest.getprestatus()){//sysj\plant.sysj line: 624, column: 24
      armAtDestE.setPresent();//sysj\plant.sysj line: 624, column: 35
      currsigs.addElement(armAtDestE);
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

  public void thread24830(int [] tdone, int [] ends){
        S8322=1;
    if(armAtSource.getprestatus()){//sysj\plant.sysj line: 622, column: 24
      armAtSourceE.setPresent();//sysj\plant.sysj line: 622, column: 37
      currsigs.addElement(armAtSourceE);
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

  public void thread24829(int [] tdone, int [] ends){
        S8314=1;
    if(WPgripped.getprestatus()){//sysj\plant.sysj line: 620, column: 24
      WPgrippedE.setPresent();//sysj\plant.sysj line: 620, column: 35
      currsigs.addElement(WPgrippedE);
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

  public void thread24828(int [] tdone, int [] ends){
        S8306=1;
    if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 618, column: 24
      pusherExtendedE.setPresent();//sysj\plant.sysj line: 618, column: 40
      currsigs.addElement(pusherExtendedE);
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

  public void thread24827(int [] tdone, int [] ends){
        S8298=1;
    if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 616, column: 24
      pusherRetractedE.setPresent();//sysj\plant.sysj line: 616, column: 41
      currsigs.addElement(pusherRetractedE);
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

  public void thread24826(int [] tdone, int [] ends){
        S8380=1;
    thread24827(tdone,ends);
    thread24828(tdone,ends);
    thread24829(tdone,ends);
    thread24830(tdone,ends);
    thread24831(tdone,ends);
    thread24832(tdone,ends);
    thread24833(tdone,ends);
    thread24834(tdone,ends);
    thread24835(tdone,ends);
    thread24836(tdone,ends);
    thread24837(tdone,ends);
    int biggest24838 = 0;
    if(ends[70]>=biggest24838){
      biggest24838=ends[70];
    }
    if(ends[71]>=biggest24838){
      biggest24838=ends[71];
    }
    if(ends[72]>=biggest24838){
      biggest24838=ends[72];
    }
    if(ends[73]>=biggest24838){
      biggest24838=ends[73];
    }
    if(ends[74]>=biggest24838){
      biggest24838=ends[74];
    }
    if(ends[75]>=biggest24838){
      biggest24838=ends[75];
    }
    if(ends[76]>=biggest24838){
      biggest24838=ends[76];
    }
    if(ends[77]>=biggest24838){
      biggest24838=ends[77];
    }
    if(ends[78]>=biggest24838){
      biggest24838=ends[78];
    }
    if(ends[79]>=biggest24838){
      biggest24838=ends[79];
    }
    if(ends[80]>=biggest24838){
      biggest24838=ends[80];
    }
    if(biggest24838 == 1){
      active[69]=1;
      ends[69]=1;
      tdone[69]=1;
    }
  }

  public void thread24825(int [] tdone, int [] ends){
        S8290=1;
    capcount_thread_68 = 5;//sysj\plant.sysj line: 598, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 600, column: 12
      if(capcount_thread_68 > 0) {//sysj\plant.sysj line: 601, column: 5
        capcount_thread_68 = capcount_thread_68 - 1;//sysj\plant.sysj line: 602, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 604, column: 12
        capcount_thread_68 = 5;//sysj\plant.sysj line: 605, column: 5
        if(capcount_thread_68 == 0){//sysj\plant.sysj line: 608, column: 8
          empty.setPresent();//sysj\plant.sysj line: 609, column: 6
          currsigs.addElement(empty);
          active[68]=1;
          ends[68]=1;
          tdone[68]=1;
        }
        else {
          active[68]=1;
          ends[68]=1;
          tdone[68]=1;
        }
      }
      else {
        if(capcount_thread_68 == 0){//sysj\plant.sysj line: 608, column: 8
          empty.setPresent();//sysj\plant.sysj line: 609, column: 6
          currsigs.addElement(empty);
          active[68]=1;
          ends[68]=1;
          tdone[68]=1;
        }
        else {
          active[68]=1;
          ends[68]=1;
          tdone[68]=1;
        }
      }
    }
    else {
      if(refill.getprestatus()){//sysj\plant.sysj line: 604, column: 12
        capcount_thread_68 = 5;//sysj\plant.sysj line: 605, column: 5
        if(capcount_thread_68 == 0){//sysj\plant.sysj line: 608, column: 8
          empty.setPresent();//sysj\plant.sysj line: 609, column: 6
          currsigs.addElement(empty);
          active[68]=1;
          ends[68]=1;
          tdone[68]=1;
        }
        else {
          active[68]=1;
          ends[68]=1;
          tdone[68]=1;
        }
      }
      else {
        if(capcount_thread_68 == 0){//sysj\plant.sysj line: 608, column: 8
          empty.setPresent();//sysj\plant.sysj line: 609, column: 6
          currsigs.addElement(empty);
          active[68]=1;
          ends[68]=1;
          tdone[68]=1;
        }
        else {
          active[68]=1;
          ends[68]=1;
          tdone[68]=1;
        }
      }
    }
  }

  public void thread24824(int [] tdone, int [] ends){
        S8228=1;
    S8182=0;
    S8164=0;
    active[67]=1;
    ends[67]=1;
    tdone[67]=1;
  }

  public void thread24823(int [] tdone, int [] ends){
        S8160=1;
    S8130=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 560, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 561, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 562, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 562, column: 6
        WPgripped.setPresent();//sysj\plant.sysj line: 564, column: 7
        currsigs.addElement(WPgripped);
        active[66]=1;
        ends[66]=1;
        tdone[66]=1;
      }
      else {
        S8130=1;
        active[66]=1;
        ends[66]=1;
        tdone[66]=1;
      }
    }
    else {
      S8130=1;
      active[66]=1;
      ends[66]=1;
      tdone[66]=1;
    }
  }

  public void thread24822(int [] tdone, int [] ends){
        S8116=1;
    S8070=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 548, column: 5
    currsigs.addElement(pusherRetracted);
    active[65]=1;
    ends[65]=1;
    tdone[65]=1;
  }

  public void thread24821(int [] tdone, int [] ends){
        S8063=1;
    S8017=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 535, column: 5
    currsigs.addElement(armAtDest);
    active[64]=1;
    ends[64]=1;
    tdone[64]=1;
  }

  public void thread24819(int [] tdone, int [] ends){
        S8008=1;
    if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 528, column: 25
      bottleAddedC.setPresent();//sysj\plant.sysj line: 528, column: 38
      currsigs.addElement(bottleAddedC);
      active[63]=1;
      ends[63]=1;
      tdone[63]=1;
    }
    else {
      active[63]=1;
      ends[63]=1;
      tdone[63]=1;
    }
  }

  public void thread24818(int [] tdone, int [] ends){
        S8000=1;
    if(noz4.getprestatus()){//sysj\plant.sysj line: 526, column: 25
      noz4E.setPresent();//sysj\plant.sysj line: 526, column: 31
      currsigs.addElement(noz4E);
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

  public void thread24817(int [] tdone, int [] ends){
        S7992=1;
    if(noz3.getprestatus()){//sysj\plant.sysj line: 524, column: 25
      noz3E.setPresent();//sysj\plant.sysj line: 524, column: 31
      currsigs.addElement(noz3E);
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

  public void thread24816(int [] tdone, int [] ends){
        S7984=1;
    if(noz2.getprestatus()){//sysj\plant.sysj line: 522, column: 25
      noz2E.setPresent();//sysj\plant.sysj line: 522, column: 31
      currsigs.addElement(noz2E);
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

  public void thread24815(int [] tdone, int [] ends){
        S7976=1;
    if(noz1.getprestatus()){//sysj\plant.sysj line: 520, column: 25
      noz1E.setPresent();//sysj\plant.sysj line: 520, column: 31
      currsigs.addElement(noz1E);
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

  public void thread24814(int [] tdone, int [] ends){
        S7968=1;
    if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 518, column: 25
      capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 518, column: 44
      currsigs.addElement(capOnBottleAtPos1E);
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

  public void thread24813(int [] tdone, int [] ends){
        S7960=1;
    if(selNoz4.getprestatus()){//sysj\plant.sysj line: 516, column: 25
      o_selNoz4.setPresent();//sysj\plant.sysj line: 516, column: 34
      currsigs.addElement(o_selNoz4);
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

  public void thread24812(int [] tdone, int [] ends){
        S7952=1;
    if(selNoz3.getprestatus()){//sysj\plant.sysj line: 514, column: 25
      o_selNoz3.setPresent();//sysj\plant.sysj line: 514, column: 34
      currsigs.addElement(o_selNoz3);
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

  public void thread24811(int [] tdone, int [] ends){
        S7944=1;
    if(selNoz2.getprestatus()){//sysj\plant.sysj line: 512, column: 25
      o_selNoz2.setPresent();//sysj\plant.sysj line: 512, column: 34
      currsigs.addElement(o_selNoz2);
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

  public void thread24810(int [] tdone, int [] ends){
        S7936=1;
    if(selNoz1.getprestatus()){//sysj\plant.sysj line: 510, column: 25
      o_selNoz1.setPresent();//sysj\plant.sysj line: 510, column: 34
      currsigs.addElement(o_selNoz1);
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

  public void thread24809(int [] tdone, int [] ends){
        S7928=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 507, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 507, column: 40
      currsigs.addElement(dosUnitFilledE);
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

  public void thread24808(int [] tdone, int [] ends){
        S7920=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 505, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 505, column: 38
      currsigs.addElement(dosUnitEvacE);
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

  public void thread24807(int [] tdone, int [] ends){
        S7912=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 503, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 503, column: 39
      currsigs.addElement(bottleAtPos2E);
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

  public void thread24806(int [] tdone, int [] ends){
        S7904=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 501, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 501, column: 45
      currsigs.addElement(dosUnitValveExtendE);
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

  public void thread24805(int [] tdone, int [] ends){
        S7896=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 499, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 499, column: 46
      currsigs.addElement(dosUnitValveRetractE);
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

  public void thread24804(int [] tdone, int [] ends){
        S7888=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 497, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 497, column: 42
      currsigs.addElement(valveInletOnOffE);
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

  public void thread24803(int [] tdone, int [] ends){
        S7880=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 495, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 495, column: 45
      currsigs.addElement(valveInjectorOnOffE);
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

  public void thread24802(int [] tdone, int [] ends){
        S7872=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 492, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 492, column: 47
      currsigs.addElement(cylClampBottleExtendE);
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

  public void thread24801(int [] tdone, int [] ends){
        S7864=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 490, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 490, column: 47
      currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread24800(int [] tdone, int [] ends){
        S7856=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 488, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 488, column: 44
      currsigs.addElement(gripperTurnExtendE);
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

  public void thread24799(int [] tdone, int [] ends){
        S7848=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 486, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 486, column: 45
      currsigs.addElement(gripperTurnRetractE);
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

  public void thread24798(int [] tdone, int [] ends){
        S7840=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 484, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 484, column: 45
      currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread24797(int [] tdone, int [] ends){
        S7832=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 482, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 482, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread24796(int [] tdone, int [] ends){
        S7824=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 479, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 479, column: 45
      currsigs.addElement(gripperTurnHomePosE);
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

  public void thread24795(int [] tdone, int [] ends){
        S7816=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 477, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 477, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread24794(int [] tdone, int [] ends){
        S7808=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 475, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 475, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread24793(int [] tdone, int [] ends){
        S7800=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 473, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 473, column: 38
      currsigs.addElement(bottleAtPos2E);
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

  public void thread24792(int [] tdone, int [] ends){
        S7792=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 471, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 471, column: 38
      currsigs.addElement(bottleAtPos4E);
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

  public void thread24791(int [] tdone, int [] ends){
        S7784=1;
    S7770=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 469, column: 24
      S7768=0;
      active[35]=1;
      ends[35]=1;
      tdone[35]=1;
    }
    else {
      S7770=1;
      active[35]=1;
      ends[35]=1;
      tdone[35]=1;
    }
  }

  public void thread24790(int [] tdone, int [] ends){
        S7764=1;
    S7738=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 459, column: 12
      S7736=0;
      active[34]=1;
      ends[34]=1;
      tdone[34]=1;
    }
    else {
      S7738=1;
      active[34]=1;
      ends[34]=1;
      tdone[34]=1;
    }
  }

  public void thread24789(int [] tdone, int [] ends){
        S7726=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 456, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 456, column: 56
      currsigs.addElement(bottleAtPos5E);
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

  public void thread24788(int [] tdone, int [] ends){
        S7718=1;
    S7704=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 454, column: 24
      S7702=0;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
    else {
      S7704=1;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
  }

  public void thread24787(int [] tdone, int [] ends){
        S7698=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 452, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 452, column: 44
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

  public void thread24786(int [] tdone, int [] ends){
        S7690=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 450, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 450, column: 39
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

  public void thread24785(int [] tdone, int [] ends){
        S7682=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 448, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 448, column: 38
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

  public void thread24784(int [] tdone, int [] ends){
        S8010=1;
    thread24785(tdone,ends);
    thread24786(tdone,ends);
    thread24787(tdone,ends);
    thread24788(tdone,ends);
    thread24789(tdone,ends);
    thread24790(tdone,ends);
    thread24791(tdone,ends);
    thread24792(tdone,ends);
    thread24793(tdone,ends);
    thread24794(tdone,ends);
    thread24795(tdone,ends);
    thread24796(tdone,ends);
    thread24797(tdone,ends);
    thread24798(tdone,ends);
    thread24799(tdone,ends);
    thread24800(tdone,ends);
    thread24801(tdone,ends);
    thread24802(tdone,ends);
    thread24803(tdone,ends);
    thread24804(tdone,ends);
    thread24805(tdone,ends);
    thread24806(tdone,ends);
    thread24807(tdone,ends);
    thread24808(tdone,ends);
    thread24809(tdone,ends);
    thread24810(tdone,ends);
    thread24811(tdone,ends);
    thread24812(tdone,ends);
    thread24813(tdone,ends);
    thread24814(tdone,ends);
    thread24815(tdone,ends);
    thread24816(tdone,ends);
    thread24817(tdone,ends);
    thread24818(tdone,ends);
    thread24819(tdone,ends);
    int biggest24820 = 0;
    if(ends[29]>=biggest24820){
      biggest24820=ends[29];
    }
    if(ends[30]>=biggest24820){
      biggest24820=ends[30];
    }
    if(ends[31]>=biggest24820){
      biggest24820=ends[31];
    }
    if(ends[32]>=biggest24820){
      biggest24820=ends[32];
    }
    if(ends[33]>=biggest24820){
      biggest24820=ends[33];
    }
    if(ends[34]>=biggest24820){
      biggest24820=ends[34];
    }
    if(ends[35]>=biggest24820){
      biggest24820=ends[35];
    }
    if(ends[36]>=biggest24820){
      biggest24820=ends[36];
    }
    if(ends[37]>=biggest24820){
      biggest24820=ends[37];
    }
    if(ends[38]>=biggest24820){
      biggest24820=ends[38];
    }
    if(ends[39]>=biggest24820){
      biggest24820=ends[39];
    }
    if(ends[40]>=biggest24820){
      biggest24820=ends[40];
    }
    if(ends[41]>=biggest24820){
      biggest24820=ends[41];
    }
    if(ends[42]>=biggest24820){
      biggest24820=ends[42];
    }
    if(ends[43]>=biggest24820){
      biggest24820=ends[43];
    }
    if(ends[44]>=biggest24820){
      biggest24820=ends[44];
    }
    if(ends[45]>=biggest24820){
      biggest24820=ends[45];
    }
    if(ends[46]>=biggest24820){
      biggest24820=ends[46];
    }
    if(ends[47]>=biggest24820){
      biggest24820=ends[47];
    }
    if(ends[48]>=biggest24820){
      biggest24820=ends[48];
    }
    if(ends[49]>=biggest24820){
      biggest24820=ends[49];
    }
    if(ends[50]>=biggest24820){
      biggest24820=ends[50];
    }
    if(ends[51]>=biggest24820){
      biggest24820=ends[51];
    }
    if(ends[52]>=biggest24820){
      biggest24820=ends[52];
    }
    if(ends[53]>=biggest24820){
      biggest24820=ends[53];
    }
    if(ends[54]>=biggest24820){
      biggest24820=ends[54];
    }
    if(ends[55]>=biggest24820){
      biggest24820=ends[55];
    }
    if(ends[56]>=biggest24820){
      biggest24820=ends[56];
    }
    if(ends[57]>=biggest24820){
      biggest24820=ends[57];
    }
    if(ends[58]>=biggest24820){
      biggest24820=ends[58];
    }
    if(ends[59]>=biggest24820){
      biggest24820=ends[59];
    }
    if(ends[60]>=biggest24820){
      biggest24820=ends[60];
    }
    if(ends[61]>=biggest24820){
      biggest24820=ends[61];
    }
    if(ends[62]>=biggest24820){
      biggest24820=ends[62];
    }
    if(ends[63]>=biggest24820){
      biggest24820=ends[63];
    }
    if(biggest24820 == 1){
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread24782(int [] tdone, int [] ends){
        S7672=1;
    S7621=0;
    active[27]=1;
    ends[27]=1;
    tdone[27]=1;
  }

  public void thread24781(int [] tdone, int [] ends){
        S7618=1;
    S7567=0;
    active[26]=1;
    ends[26]=1;
    tdone[26]=1;
  }

  public void thread24780(int [] tdone, int [] ends){
        S7564=1;
    S7513=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread24779(int [] tdone, int [] ends){
        S7510=1;
    S7459=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread24778(int [] tdone, int [] ends){
        S7456=1;
    nozzlenum_thread_23 = 0;//sysj\plant.sysj line: 357, column: 4
    S7293=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread24777(int [] tdone, int [] ends){
        S7674=1;
    s_nozzlenum_1.setClear();//sysj\plant.sysj line: 355, column: 3
    thread24778(tdone,ends);
    thread24779(tdone,ends);
    thread24780(tdone,ends);
    thread24781(tdone,ends);
    thread24782(tdone,ends);
    int biggest24783 = 0;
    if(ends[23]>=biggest24783){
      biggest24783=ends[23];
    }
    if(ends[24]>=biggest24783){
      biggest24783=ends[24];
    }
    if(ends[25]>=biggest24783){
      biggest24783=ends[25];
    }
    if(ends[26]>=biggest24783){
      biggest24783=ends[26];
    }
    if(ends[27]>=biggest24783){
      biggest24783=ends[27];
    }
    if(biggest24783 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread24776(int [] tdone, int [] ends){
        S7269=1;
    S7198=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread24775(int [] tdone, int [] ends){
        S7175=1;
    S7174=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 328, column: 4
    currsigs.addElement(dosUnitEvac);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread24774(int [] tdone, int [] ends){
        S6985=1;
    S6950=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread24773(int [] tdone, int [] ends){
        S6939=1;
    S6868=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread24772(int [] tdone, int [] ends){
        S6845=1;
    S6774=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread24771(int [] tdone, int [] ends){
        S6751=1;
    S6680=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread24770(int [] tdone, int [] ends){
        S6657=1;
    chance_thread_15 = 25;//sysj\plant.sysj line: 253, column: 3
        S6411=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread24769(int [] tdone, int [] ends){
        S6375=1;
    numTurns_thread_14 = 0;//sysj\plant.sysj line: 218, column: 3
    S3868=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread24768(int [] tdone, int [] ends){
        S3701=1;
    S3678=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread24767(int [] tdone, int [] ends){
        S3671=1;
    S3546=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread24766(int [] tdone, int [] ends){
        S3505=1;
    S3440=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread24765(int [] tdone, int [] ends){
        S3419=1;
    S3354=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread24764(int [] tdone, int [] ends){
        S3333=1;
    S3298=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread24763(int [] tdone, int [] ends){
        S3287=1;
    S3252=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread24762(int [] tdone, int [] ends){
        S3241=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 134, column: 3
    S3209=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread24761(int [] tdone, int [] ends){
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

  public void thread24760(int [] tdone, int [] ends){
        S3143=1;
    S3097=0;
    S3079=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread24759(int [] tdone, int [] ends){
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

  public void thread24758(int [] tdone, int [] ends){
        S3031=1;
    S2985=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 65, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread24757(int [] tdone, int [] ends){
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
      switch(S24755){
        case 0 : 
          S24755=0;
          break RUN;
        
        case 1 : 
          S24755=2;
          S24755=2;
          class GUI extends Object implements java.lang.Runnable {//sysj\plant.sysj line: 35, column: 1
            public void run() {//sysj\plant.sysj line: 37, column: 21
              org.compsys704.CapLoader.main(null);//sysj\plant.sysj line: 38, column: 4
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
          thread24757(tdone,ends);
          thread24758(tdone,ends);
          thread24759(tdone,ends);
          thread24760(tdone,ends);
          thread24761(tdone,ends);
          thread24762(tdone,ends);
          thread24763(tdone,ends);
          thread24764(tdone,ends);
          thread24765(tdone,ends);
          thread24766(tdone,ends);
          thread24767(tdone,ends);
          thread24768(tdone,ends);
          thread24769(tdone,ends);
          thread24770(tdone,ends);
          thread24771(tdone,ends);
          thread24772(tdone,ends);
          thread24773(tdone,ends);
          thread24774(tdone,ends);
          thread24775(tdone,ends);
          thread24776(tdone,ends);
          thread24777(tdone,ends);
          thread24784(tdone,ends);
          thread24821(tdone,ends);
          thread24822(tdone,ends);
          thread24823(tdone,ends);
          thread24824(tdone,ends);
          thread24825(tdone,ends);
          thread24826(tdone,ends);
          int biggest24839 = 0;
          if(ends[2]>=biggest24839){
            biggest24839=ends[2];
          }
          if(ends[3]>=biggest24839){
            biggest24839=ends[3];
          }
          if(ends[4]>=biggest24839){
            biggest24839=ends[4];
          }
          if(ends[5]>=biggest24839){
            biggest24839=ends[5];
          }
          if(ends[6]>=biggest24839){
            biggest24839=ends[6];
          }
          if(ends[7]>=biggest24839){
            biggest24839=ends[7];
          }
          if(ends[8]>=biggest24839){
            biggest24839=ends[8];
          }
          if(ends[9]>=biggest24839){
            biggest24839=ends[9];
          }
          if(ends[10]>=biggest24839){
            biggest24839=ends[10];
          }
          if(ends[11]>=biggest24839){
            biggest24839=ends[11];
          }
          if(ends[12]>=biggest24839){
            biggest24839=ends[12];
          }
          if(ends[13]>=biggest24839){
            biggest24839=ends[13];
          }
          if(ends[14]>=biggest24839){
            biggest24839=ends[14];
          }
          if(ends[15]>=biggest24839){
            biggest24839=ends[15];
          }
          if(ends[16]>=biggest24839){
            biggest24839=ends[16];
          }
          if(ends[17]>=biggest24839){
            biggest24839=ends[17];
          }
          if(ends[18]>=biggest24839){
            biggest24839=ends[18];
          }
          if(ends[19]>=biggest24839){
            biggest24839=ends[19];
          }
          if(ends[20]>=biggest24839){
            biggest24839=ends[20];
          }
          if(ends[21]>=biggest24839){
            biggest24839=ends[21];
          }
          if(ends[22]>=biggest24839){
            biggest24839=ends[22];
          }
          if(ends[28]>=biggest24839){
            biggest24839=ends[28];
          }
          if(ends[64]>=biggest24839){
            biggest24839=ends[64];
          }
          if(ends[65]>=biggest24839){
            biggest24839=ends[65];
          }
          if(ends[66]>=biggest24839){
            biggest24839=ends[66];
          }
          if(ends[67]>=biggest24839){
            biggest24839=ends[67];
          }
          if(ends[68]>=biggest24839){
            biggest24839=ends[68];
          }
          if(ends[69]>=biggest24839){
            biggest24839=ends[69];
          }
          if(biggest24839 == 1){
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
          thread24840(tdone,ends);
          thread24841(tdone,ends);
          thread24842(tdone,ends);
          thread24843(tdone,ends);
          thread24844(tdone,ends);
          thread24845(tdone,ends);
          thread24846(tdone,ends);
          thread24847(tdone,ends);
          thread24848(tdone,ends);
          thread24849(tdone,ends);
          thread24850(tdone,ends);
          thread24851(tdone,ends);
          thread24852(tdone,ends);
          thread24853(tdone,ends);
          thread24854(tdone,ends);
          thread24855(tdone,ends);
          thread24856(tdone,ends);
          thread24857(tdone,ends);
          thread24858(tdone,ends);
          thread24859(tdone,ends);
          thread24860(tdone,ends);
          thread24867(tdone,ends);
          thread24904(tdone,ends);
          thread24905(tdone,ends);
          thread24906(tdone,ends);
          thread24907(tdone,ends);
          thread24908(tdone,ends);
          thread24909(tdone,ends);
          int biggest24922 = 0;
          if(ends[2]>=biggest24922){
            biggest24922=ends[2];
          }
          if(ends[3]>=biggest24922){
            biggest24922=ends[3];
          }
          if(ends[4]>=biggest24922){
            biggest24922=ends[4];
          }
          if(ends[5]>=biggest24922){
            biggest24922=ends[5];
          }
          if(ends[6]>=biggest24922){
            biggest24922=ends[6];
          }
          if(ends[7]>=biggest24922){
            biggest24922=ends[7];
          }
          if(ends[8]>=biggest24922){
            biggest24922=ends[8];
          }
          if(ends[9]>=biggest24922){
            biggest24922=ends[9];
          }
          if(ends[10]>=biggest24922){
            biggest24922=ends[10];
          }
          if(ends[11]>=biggest24922){
            biggest24922=ends[11];
          }
          if(ends[12]>=biggest24922){
            biggest24922=ends[12];
          }
          if(ends[13]>=biggest24922){
            biggest24922=ends[13];
          }
          if(ends[14]>=biggest24922){
            biggest24922=ends[14];
          }
          if(ends[15]>=biggest24922){
            biggest24922=ends[15];
          }
          if(ends[16]>=biggest24922){
            biggest24922=ends[16];
          }
          if(ends[17]>=biggest24922){
            biggest24922=ends[17];
          }
          if(ends[18]>=biggest24922){
            biggest24922=ends[18];
          }
          if(ends[19]>=biggest24922){
            biggest24922=ends[19];
          }
          if(ends[20]>=biggest24922){
            biggest24922=ends[20];
          }
          if(ends[21]>=biggest24922){
            biggest24922=ends[21];
          }
          if(ends[22]>=biggest24922){
            biggest24922=ends[22];
          }
          if(ends[28]>=biggest24922){
            biggest24922=ends[28];
          }
          if(ends[64]>=biggest24922){
            biggest24922=ends[64];
          }
          if(ends[65]>=biggest24922){
            biggest24922=ends[65];
          }
          if(ends[66]>=biggest24922){
            biggest24922=ends[66];
          }
          if(ends[67]>=biggest24922){
            biggest24922=ends[67];
          }
          if(ends[68]>=biggest24922){
            biggest24922=ends[68];
          }
          if(ends[69]>=biggest24922){
            biggest24922=ends[69];
          }
          if(biggest24922 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest24922 == 0){
            S24755=0;
            active[1]=0;
            ends[1]=0;
            S24755=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
