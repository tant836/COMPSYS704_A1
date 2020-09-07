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
  private Signal capDec_1;
  private Signal l_bottleAdded_1;
  private Signal l_putBottleAt5_1;
  private Signal l_putBottleAt4_1;
  private Signal l_putBottleAt2_1;
  private Signal capPos_1;
  private Signal s_motConveyorOn_1;
  private Signal s_valveInjectorOnOff_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 112, column: 3
  private int numTurns_thread_13;//sysj\plant.sysj line: 202, column: 3
  private int S9691 = 1;
  private int S915 = 1;
  private int S869 = 1;
  private int S968 = 1;
  private int S922 = 1;
  private int S1012 = 1;
  private int S982 = 1;
  private int S977 = 1;
  private int S1080 = 1;
  private int S1034 = 1;
  private int S1016 = 1;
  private int S1142 = 1;
  private int S1178 = 1;
  private int S1146 = 1;
  private int S1224 = 1;
  private int S1189 = 1;
  private int S1270 = 1;
  private int S1235 = 1;
  private int S1356 = 1;
  private int S1291 = 1;
  private int S1278 = 1;
  private int S1442 = 1;
  private int S1377 = 1;
  private int S1364 = 1;
  private int S1472 = 1;
  private int S1449 = 1;
  private int S2530 = 1;
  private int S1497 = 1;
  private int S1483 = 1;
  private int S2533 = 1;
  private int S2535 = 1;
  private int S2537 = 1;
  private int S2539 = 1;
  private int S2633 = 1;
  private int S2562 = 1;
  private int S2549 = 1;
  private int S2727 = 1;
  private int S2656 = 1;
  private int S2643 = 1;
  private int S2821 = 1;
  private int S2750 = 1;
  private int S2737 = 1;
  private int S2867 = 1;
  private int S2832 = 1;
  private int S3067 = 1;
  private int S2875 = 1;
  private int S2883 = 1;
  private int S2891 = 1;
  private int S2911 = 1;
  private int S2897 = 1;
  private int S2895 = 1;
  private int S2919 = 1;
  private int S2957 = 1;
  private int S2931 = 1;
  private int S2929 = 1;
  private int S2977 = 1;
  private int S2963 = 1;
  private int S2961 = 1;
  private int S2985 = 1;
  private int S2993 = 1;
  private int S3001 = 1;
  private int S3009 = 1;
  private int S3017 = 1;
  private int S3025 = 1;
  private int S3033 = 1;
  private int S3041 = 1;
  private int S3049 = 1;
  private int S3057 = 1;
  private int S3065 = 1;
  
  private int[] ends = new int[41];
  private int[] tdone = new int[41];
  
  public void thread9772(int [] tdone, int [] ends){
        switch(S3065){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 376, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 376, column: 47
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

  public void thread9771(int [] tdone, int [] ends){
        switch(S3057){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 374, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 374, column: 47
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

  public void thread9770(int [] tdone, int [] ends){
        switch(S3049){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 372, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 372, column: 44
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

  public void thread9769(int [] tdone, int [] ends){
        switch(S3041){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 370, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 370, column: 45
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

  public void thread9768(int [] tdone, int [] ends){
        switch(S3033){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 368, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 368, column: 45
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

  public void thread9767(int [] tdone, int [] ends){
        switch(S3025){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 366, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 366, column: 45
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

  public void thread9766(int [] tdone, int [] ends){
        switch(S3017){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 363, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 363, column: 45
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

  public void thread9765(int [] tdone, int [] ends){
        switch(S3009){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 361, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 361, column: 46
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

  public void thread9764(int [] tdone, int [] ends){
        switch(S3001){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 359, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 359, column: 46
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

  public void thread9763(int [] tdone, int [] ends){
        switch(S2993){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 357, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 357, column: 38
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

  public void thread9762(int [] tdone, int [] ends){
        switch(S2985){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 355, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 355, column: 38
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

  public void thread9761(int [] tdone, int [] ends){
        switch(S2977){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S2963){
          case 0 : 
            switch(S2961){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 353, column: 54
                  S2961=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 353, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 353, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  S2963=1;
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
            S2963=1;
            S2963=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 353, column: 24
              S2961=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S2963=1;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9760(int [] tdone, int [] ends){
        switch(S2957){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S2931){
          case 0 : 
            switch(S2929){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 344, column: 11
                  S2929=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 346, column: 6
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 345, column: 11
                  S2931=1;
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 346, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S2931=1;
            S2931=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 343, column: 12
              S2929=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S2931=1;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9759(int [] tdone, int [] ends){
        switch(S2919){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 340, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 340, column: 56
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

  public void thread9758(int [] tdone, int [] ends){
        switch(S2911){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S2897){
          case 0 : 
            switch(S2895){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 338, column: 54
                  S2895=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 338, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 338, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  S2897=1;
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
            S2897=1;
            S2897=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 338, column: 24
              S2895=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S2897=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9757(int [] tdone, int [] ends){
        switch(S2891){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 336, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 336, column: 44
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

  public void thread9756(int [] tdone, int [] ends){
        switch(S2883){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 334, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 334, column: 39
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

  public void thread9755(int [] tdone, int [] ends){
        switch(S2875){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 332, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 332, column: 38
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

  public void thread9754(int [] tdone, int [] ends){
        switch(S3067){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        thread9755(tdone,ends);
        thread9756(tdone,ends);
        thread9757(tdone,ends);
        thread9758(tdone,ends);
        thread9759(tdone,ends);
        thread9760(tdone,ends);
        thread9761(tdone,ends);
        thread9762(tdone,ends);
        thread9763(tdone,ends);
        thread9764(tdone,ends);
        thread9765(tdone,ends);
        thread9766(tdone,ends);
        thread9767(tdone,ends);
        thread9768(tdone,ends);
        thread9769(tdone,ends);
        thread9770(tdone,ends);
        thread9771(tdone,ends);
        thread9772(tdone,ends);
        int biggest9773 = 0;
        if(ends[23]>=biggest9773){
          biggest9773=ends[23];
        }
        if(ends[24]>=biggest9773){
          biggest9773=ends[24];
        }
        if(ends[25]>=biggest9773){
          biggest9773=ends[25];
        }
        if(ends[26]>=biggest9773){
          biggest9773=ends[26];
        }
        if(ends[27]>=biggest9773){
          biggest9773=ends[27];
        }
        if(ends[28]>=biggest9773){
          biggest9773=ends[28];
        }
        if(ends[29]>=biggest9773){
          biggest9773=ends[29];
        }
        if(ends[30]>=biggest9773){
          biggest9773=ends[30];
        }
        if(ends[31]>=biggest9773){
          biggest9773=ends[31];
        }
        if(ends[32]>=biggest9773){
          biggest9773=ends[32];
        }
        if(ends[33]>=biggest9773){
          biggest9773=ends[33];
        }
        if(ends[34]>=biggest9773){
          biggest9773=ends[34];
        }
        if(ends[35]>=biggest9773){
          biggest9773=ends[35];
        }
        if(ends[36]>=biggest9773){
          biggest9773=ends[36];
        }
        if(ends[37]>=biggest9773){
          biggest9773=ends[37];
        }
        if(ends[38]>=biggest9773){
          biggest9773=ends[38];
        }
        if(ends[39]>=biggest9773){
          biggest9773=ends[39];
        }
        if(ends[40]>=biggest9773){
          biggest9773=ends[40];
        }
        if(biggest9773 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest9773 == 0){
          S3067=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread9753(int [] tdone, int [] ends){
        switch(S2867){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S2832){
          case 0 : 
            S2832=0;
            S2832=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 310, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 312, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S2832=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 311, column: 11
              S2832=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 312, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9752(int [] tdone, int [] ends){
        switch(S2821){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2750){
          case 0 : 
            S2750=0;
            S2750=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 298, column: 12
              S2737=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S2750=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S2737){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 299, column: 11
                  S2737=1;
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 301, column: 6
                  currsigs.addElement(gripperTurnHomePos);
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
                if(!gripperTurnRetract.getprestatus() && gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 300, column: 11
                  S2750=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 301, column: 6
                  currsigs.addElement(gripperTurnHomePos);
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

  public void thread9751(int [] tdone, int [] ends){
        switch(S2727){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2656){
          case 0 : 
            S2656=0;
            S2656=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 286, column: 12
              S2643=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S2656=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S2643){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 287, column: 11
                  S2643=1;
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 289, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
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
                if(!gripperTurnExtend.getprestatus() && gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 288, column: 11
                  S2656=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 289, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
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
  }

  public void thread9750(int [] tdone, int [] ends){
        switch(S2633){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S2562){
          case 0 : 
            S2562=0;
            S2562=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 274, column: 12
              S2549=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S2562=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S2549){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 275, column: 11
                  S2549=1;
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 277, column: 6
                  currsigs.addElement(gripperZAxisLowered);
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
                if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 276, column: 11
                  S2562=0;
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                }
                else {
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 277, column: 6
                  currsigs.addElement(gripperZAxisLowered);
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

  public void thread9749(int [] tdone, int [] ends){
        switch(S2539){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread9748(int [] tdone, int [] ends){
        switch(S2537){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread9747(int [] tdone, int [] ends){
        switch(S2535){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread9746(int [] tdone, int [] ends){
        switch(S2533){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 230, column: 3
        active[14]=1;
        ends[14]=1;
        tdone[14]=1;
        break;
      
    }
  }

  public void thread9745(int [] tdone, int [] ends){
        switch(S2530){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1497){
          case 0 : 
            S1497=0;
            S1497=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 206, column: 13
              S1483=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                S1497=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1497=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            break;
          
          case 1 : 
            if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 205, column: 10
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                S1497=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1497=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              switch(S1483){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 207, column: 12
                    numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 208, column: 6
                    if(numTurns_thread_13 == 2){//sysj\plant.sysj line: 209, column: 9
                      l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 210, column: 7
                      currsigs.addElement(l_putBottleAt2_1);
                      if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                        numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                        S1497=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                      else {
                        S1497=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                    }
                    else {
                      if(numTurns_thread_13 >= 3 && numTurns_thread_13 < 9){//sysj\plant.sysj line: 211, column: 15
                        l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 212, column: 7
                        currsigs.addElement(l_putBottleAt4_1);
                        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                          S1497=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        else {
                          S1497=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                      }
                      else {
                        if(numTurns_thread_13 >= 9){//sysj\plant.sysj line: 213, column: 15
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 214, column: 7
                          l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 215, column: 7
                          currsigs.addElement(l_putBottleAt5_1);
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                            S1497=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S1497=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                        }
                        else {
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                            S1497=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S1497=0;
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
                  if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                    numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                    S1497=0;
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S1497=0;
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

  public void thread9744(int [] tdone, int [] ends){
        switch(S1472){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1449){
          case 0 : 
            S1449=0;
            S1449=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 192, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S1449=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 193, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 194, column: 5
              currsigs.addElement(bottleLeftPos5);
              S1449=0;
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

  public void thread9743(int [] tdone, int [] ends){
        switch(S1442){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1377){
          case 0 : 
            S1377=0;
            S1377=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 180, column: 12
              S1364=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S1377=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt2_1.getprestatus())){//sysj\plant.sysj line: 181, column: 11
              S1377=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S1364){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 182, column: 12
                    S1364=1;
                    bottleAtPos2.setPresent();//sysj\plant.sysj line: 183, column: 6
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
                  bottleAtPos2.setPresent();//sysj\plant.sysj line: 183, column: 6
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

  public void thread9742(int [] tdone, int [] ends){
        switch(S1356){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1291){
          case 0 : 
            S1291=0;
            S1291=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 168, column: 12
              S1278=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S1291=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt4_1.getprestatus())){//sysj\plant.sysj line: 169, column: 11
              S1291=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S1278){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 170, column: 12
                    S1278=1;
                    bottleAtPos4.setPresent();//sysj\plant.sysj line: 171, column: 6
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
                  bottleAtPos4.setPresent();//sysj\plant.sysj line: 171, column: 6
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

  public void thread9741(int [] tdone, int [] ends){
        switch(S1270){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1235){
          case 0 : 
            S1235=0;
            S1235=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 157, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 159, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S1235=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt5_1.getprestatus()) || bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 158, column: 11
              S1235=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 159, column: 6
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

  public void thread9740(int [] tdone, int [] ends){
        switch(S1224){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S1189){
          case 0 : 
            S1189=0;
            S1189=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 146, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 148, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S1189=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 11
              S1189=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 148, column: 6
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

  public void thread9739(int [] tdone, int [] ends){
        switch(S1178){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 131, column: 3
        switch(S1146){
          case 0 : 
            S1146=0;
            S1146=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 135, column: 11
              S1146=2;
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 137, column: 6
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
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 136, column: 11
              S1146=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 137, column: 6
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

  public void thread9738(int [] tdone, int [] ends){
        switch(S1142){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 114, column: 12
          if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 115, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 116, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 118, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 119, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 122, column: 8
              empty.setPresent();//sysj\plant.sysj line: 123, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 122, column: 8
              empty.setPresent();//sysj\plant.sysj line: 123, column: 6
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
          if(refill.getprestatus()){//sysj\plant.sysj line: 118, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 119, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 122, column: 8
              empty.setPresent();//sysj\plant.sysj line: 123, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 122, column: 8
              empty.setPresent();//sysj\plant.sysj line: 123, column: 6
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

  public void thread9737(int [] tdone, int [] ends){
        switch(S1080){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1034){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 97, column: 10
              S1034=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1016){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 99, column: 13
                    S1016=1;
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
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 100, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 102, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 102, column: 7
                    S1016=2;
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
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 103, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 104, column: 7
                    currsigs.addElement(capDec_1);
                    S1016=0;
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
            if(refill.getprestatus()){//sysj\plant.sysj line: 107, column: 10
              S1034=0;
              S1016=0;
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

  public void thread9736(int [] tdone, int [] ends){
        switch(S1012){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S982){
          case 0 : 
            switch(S977){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 77, column: 12
                  S977=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 80, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 81, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 81, column: 7
                    S982=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S982=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\plant.sysj line: 78, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S982=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 74, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 75, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 76, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 76, column: 6
                    S977=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 78, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S982=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S982=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S982=1;
            S982=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 74, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 75, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 76, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 76, column: 6
                S977=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 78, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S982=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S982=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9735(int [] tdone, int [] ends){
        switch(S968){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S922){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 61, column: 10
              S922=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 62, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 64, column: 10
              S922=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 66, column: 5
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
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 65, column: 10
              S922=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 66, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 68, column: 10
              S922=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 62, column: 5
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

  public void thread9734(int [] tdone, int [] ends){
        switch(S915){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S869){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 48, column: 10
              S869=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 49, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 51, column: 10
              S869=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 53, column: 5
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 52, column: 10
              S869=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 53, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 55, column: 10
              S869=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 49, column: 5
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

  public void thread9731(int [] tdone, int [] ends){
        S3065=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 376, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 376, column: 47
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

  public void thread9730(int [] tdone, int [] ends){
        S3057=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 374, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 374, column: 47
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

  public void thread9729(int [] tdone, int [] ends){
        S3049=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 372, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 372, column: 44
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

  public void thread9728(int [] tdone, int [] ends){
        S3041=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 370, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 370, column: 45
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

  public void thread9727(int [] tdone, int [] ends){
        S3033=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 368, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 368, column: 45
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

  public void thread9726(int [] tdone, int [] ends){
        S3025=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 366, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 366, column: 45
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

  public void thread9725(int [] tdone, int [] ends){
        S3017=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 363, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 363, column: 45
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

  public void thread9724(int [] tdone, int [] ends){
        S3009=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 361, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 361, column: 46
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

  public void thread9723(int [] tdone, int [] ends){
        S3001=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 359, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 359, column: 46
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

  public void thread9722(int [] tdone, int [] ends){
        S2993=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 357, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 357, column: 38
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

  public void thread9721(int [] tdone, int [] ends){
        S2985=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 355, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 355, column: 38
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

  public void thread9720(int [] tdone, int [] ends){
        S2977=1;
    S2963=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 353, column: 24
      S2961=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S2963=1;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread9719(int [] tdone, int [] ends){
        S2957=1;
    S2931=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 343, column: 12
      S2929=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      S2931=1;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread9718(int [] tdone, int [] ends){
        S2919=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 340, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 340, column: 56
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

  public void thread9717(int [] tdone, int [] ends){
        S2911=1;
    S2897=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 338, column: 24
      S2895=0;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      S2897=1;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread9716(int [] tdone, int [] ends){
        S2891=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 336, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 336, column: 44
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

  public void thread9715(int [] tdone, int [] ends){
        S2883=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 334, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 334, column: 39
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

  public void thread9714(int [] tdone, int [] ends){
        S2875=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 332, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 332, column: 38
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

  public void thread9713(int [] tdone, int [] ends){
        S3067=1;
    thread9714(tdone,ends);
    thread9715(tdone,ends);
    thread9716(tdone,ends);
    thread9717(tdone,ends);
    thread9718(tdone,ends);
    thread9719(tdone,ends);
    thread9720(tdone,ends);
    thread9721(tdone,ends);
    thread9722(tdone,ends);
    thread9723(tdone,ends);
    thread9724(tdone,ends);
    thread9725(tdone,ends);
    thread9726(tdone,ends);
    thread9727(tdone,ends);
    thread9728(tdone,ends);
    thread9729(tdone,ends);
    thread9730(tdone,ends);
    thread9731(tdone,ends);
    int biggest9732 = 0;
    if(ends[23]>=biggest9732){
      biggest9732=ends[23];
    }
    if(ends[24]>=biggest9732){
      biggest9732=ends[24];
    }
    if(ends[25]>=biggest9732){
      biggest9732=ends[25];
    }
    if(ends[26]>=biggest9732){
      biggest9732=ends[26];
    }
    if(ends[27]>=biggest9732){
      biggest9732=ends[27];
    }
    if(ends[28]>=biggest9732){
      biggest9732=ends[28];
    }
    if(ends[29]>=biggest9732){
      biggest9732=ends[29];
    }
    if(ends[30]>=biggest9732){
      biggest9732=ends[30];
    }
    if(ends[31]>=biggest9732){
      biggest9732=ends[31];
    }
    if(ends[32]>=biggest9732){
      biggest9732=ends[32];
    }
    if(ends[33]>=biggest9732){
      biggest9732=ends[33];
    }
    if(ends[34]>=biggest9732){
      biggest9732=ends[34];
    }
    if(ends[35]>=biggest9732){
      biggest9732=ends[35];
    }
    if(ends[36]>=biggest9732){
      biggest9732=ends[36];
    }
    if(ends[37]>=biggest9732){
      biggest9732=ends[37];
    }
    if(ends[38]>=biggest9732){
      biggest9732=ends[38];
    }
    if(ends[39]>=biggest9732){
      biggest9732=ends[39];
    }
    if(ends[40]>=biggest9732){
      biggest9732=ends[40];
    }
    if(biggest9732 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread9712(int [] tdone, int [] ends){
        S2867=1;
    S2832=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread9711(int [] tdone, int [] ends){
        S2821=1;
    S2750=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread9710(int [] tdone, int [] ends){
        S2727=1;
    S2656=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread9709(int [] tdone, int [] ends){
        S2633=1;
    S2562=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread9708(int [] tdone, int [] ends){
        S2539=1;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread9707(int [] tdone, int [] ends){
        S2537=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread9706(int [] tdone, int [] ends){
        S2535=1;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread9705(int [] tdone, int [] ends){
        S2533=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 230, column: 3
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread9704(int [] tdone, int [] ends){
        S2530=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 202, column: 3
    S1497=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread9703(int [] tdone, int [] ends){
        S1472=1;
    S1449=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread9702(int [] tdone, int [] ends){
        S1442=1;
    S1377=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread9701(int [] tdone, int [] ends){
        S1356=1;
    S1291=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread9700(int [] tdone, int [] ends){
        S1270=1;
    S1235=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread9699(int [] tdone, int [] ends){
        S1224=1;
    S1189=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread9698(int [] tdone, int [] ends){
        S1178=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 131, column: 3
    S1146=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread9697(int [] tdone, int [] ends){
        S1142=1;
    capcount_thread_6 = 5;//sysj\plant.sysj line: 112, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 114, column: 12
      if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 115, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 116, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 118, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 119, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 122, column: 8
          empty.setPresent();//sysj\plant.sysj line: 123, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 122, column: 8
          empty.setPresent();//sysj\plant.sysj line: 123, column: 6
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
      if(refill.getprestatus()){//sysj\plant.sysj line: 118, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 119, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 122, column: 8
          empty.setPresent();//sysj\plant.sysj line: 123, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 122, column: 8
          empty.setPresent();//sysj\plant.sysj line: 123, column: 6
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

  public void thread9696(int [] tdone, int [] ends){
        S1080=1;
    S1034=0;
    S1016=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread9695(int [] tdone, int [] ends){
        S1012=1;
    S982=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 74, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 75, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 76, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 76, column: 6
        S977=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 78, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S982=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S982=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread9694(int [] tdone, int [] ends){
        S968=1;
    S922=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 62, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread9693(int [] tdone, int [] ends){
        S915=1;
    S869=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 49, column: 5
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
      switch(S9691){
        case 0 : 
          S9691=0;
          break RUN;
        
        case 1 : 
          S9691=2;
          S9691=2;
          class GUI extends Object implements java.lang.Runnable {//sysj\plant.sysj line: 33, column: 1
            public void run() {//sysj\plant.sysj line: 35, column: 21
              org.compsys704.CapLoader.main(null);//sysj\plant.sysj line: 36, column: 4
            }
            GUI(){//sysj\plant.sysj line: 34, column: 42
            }
          }
          new Thread(new GUI()).start();//sysj\plant.sysj line: 39, column: 2
          capDec_1.setClear();//sysj\plant.sysj line: 41, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 42, column: 2
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 43, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 43, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 43, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 44, column: 2
          capPos_1.setPresent();//sysj\plant.sysj line: 45, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\plant.sysj line: 45, column: 2
          thread9693(tdone,ends);
          thread9694(tdone,ends);
          thread9695(tdone,ends);
          thread9696(tdone,ends);
          thread9697(tdone,ends);
          thread9698(tdone,ends);
          thread9699(tdone,ends);
          thread9700(tdone,ends);
          thread9701(tdone,ends);
          thread9702(tdone,ends);
          thread9703(tdone,ends);
          thread9704(tdone,ends);
          thread9705(tdone,ends);
          thread9706(tdone,ends);
          thread9707(tdone,ends);
          thread9708(tdone,ends);
          thread9709(tdone,ends);
          thread9710(tdone,ends);
          thread9711(tdone,ends);
          thread9712(tdone,ends);
          thread9713(tdone,ends);
          int biggest9733 = 0;
          if(ends[2]>=biggest9733){
            biggest9733=ends[2];
          }
          if(ends[3]>=biggest9733){
            biggest9733=ends[3];
          }
          if(ends[4]>=biggest9733){
            biggest9733=ends[4];
          }
          if(ends[5]>=biggest9733){
            biggest9733=ends[5];
          }
          if(ends[6]>=biggest9733){
            biggest9733=ends[6];
          }
          if(ends[7]>=biggest9733){
            biggest9733=ends[7];
          }
          if(ends[8]>=biggest9733){
            biggest9733=ends[8];
          }
          if(ends[9]>=biggest9733){
            biggest9733=ends[9];
          }
          if(ends[10]>=biggest9733){
            biggest9733=ends[10];
          }
          if(ends[11]>=biggest9733){
            biggest9733=ends[11];
          }
          if(ends[12]>=biggest9733){
            biggest9733=ends[12];
          }
          if(ends[13]>=biggest9733){
            biggest9733=ends[13];
          }
          if(ends[14]>=biggest9733){
            biggest9733=ends[14];
          }
          if(ends[15]>=biggest9733){
            biggest9733=ends[15];
          }
          if(ends[16]>=biggest9733){
            biggest9733=ends[16];
          }
          if(ends[17]>=biggest9733){
            biggest9733=ends[17];
          }
          if(ends[18]>=biggest9733){
            biggest9733=ends[18];
          }
          if(ends[19]>=biggest9733){
            biggest9733=ends[19];
          }
          if(ends[20]>=biggest9733){
            biggest9733=ends[20];
          }
          if(ends[21]>=biggest9733){
            biggest9733=ends[21];
          }
          if(ends[22]>=biggest9733){
            biggest9733=ends[22];
          }
          if(biggest9733 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\plant.sysj line: 41, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 42, column: 2
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 43, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 43, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 43, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 44, column: 2
          thread9734(tdone,ends);
          thread9735(tdone,ends);
          thread9736(tdone,ends);
          thread9737(tdone,ends);
          thread9738(tdone,ends);
          thread9739(tdone,ends);
          thread9740(tdone,ends);
          thread9741(tdone,ends);
          thread9742(tdone,ends);
          thread9743(tdone,ends);
          thread9744(tdone,ends);
          thread9745(tdone,ends);
          thread9746(tdone,ends);
          thread9747(tdone,ends);
          thread9748(tdone,ends);
          thread9749(tdone,ends);
          thread9750(tdone,ends);
          thread9751(tdone,ends);
          thread9752(tdone,ends);
          thread9753(tdone,ends);
          thread9754(tdone,ends);
          int biggest9774 = 0;
          if(ends[2]>=biggest9774){
            biggest9774=ends[2];
          }
          if(ends[3]>=biggest9774){
            biggest9774=ends[3];
          }
          if(ends[4]>=biggest9774){
            biggest9774=ends[4];
          }
          if(ends[5]>=biggest9774){
            biggest9774=ends[5];
          }
          if(ends[6]>=biggest9774){
            biggest9774=ends[6];
          }
          if(ends[7]>=biggest9774){
            biggest9774=ends[7];
          }
          if(ends[8]>=biggest9774){
            biggest9774=ends[8];
          }
          if(ends[9]>=biggest9774){
            biggest9774=ends[9];
          }
          if(ends[10]>=biggest9774){
            biggest9774=ends[10];
          }
          if(ends[11]>=biggest9774){
            biggest9774=ends[11];
          }
          if(ends[12]>=biggest9774){
            biggest9774=ends[12];
          }
          if(ends[13]>=biggest9774){
            biggest9774=ends[13];
          }
          if(ends[14]>=biggest9774){
            biggest9774=ends[14];
          }
          if(ends[15]>=biggest9774){
            biggest9774=ends[15];
          }
          if(ends[16]>=biggest9774){
            biggest9774=ends[16];
          }
          if(ends[17]>=biggest9774){
            biggest9774=ends[17];
          }
          if(ends[18]>=biggest9774){
            biggest9774=ends[18];
          }
          if(ends[19]>=biggest9774){
            biggest9774=ends[19];
          }
          if(ends[20]>=biggest9774){
            biggest9774=ends[20];
          }
          if(ends[21]>=biggest9774){
            biggest9774=ends[21];
          }
          if(ends[22]>=biggest9774){
            biggest9774=ends[22];
          }
          if(biggest9774 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest9774 == 0){
            S9691=0;
            active[1]=0;
            ends[1]=0;
            S9691=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
    s_valveInjectorOnOff_1 = new Signal();
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
          df = true;
        }
        runClockDomain();
      }
      enable.setpreclear();
      refill.setpreclear();
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
      capDec_1.setpreclear();
      l_bottleAdded_1.setpreclear();
      l_putBottleAt5_1.setpreclear();
      l_putBottleAt4_1.setpreclear();
      l_putBottleAt2_1.setpreclear();
      capPos_1.setpreclear();
      s_motConveyorOn_1.setpreclear();
      s_valveInjectorOnOff_1.setpreclear();
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
      capDec_1.setClear();
      l_bottleAdded_1.setClear();
      l_putBottleAt5_1.setClear();
      l_putBottleAt4_1.setClear();
      l_putBottleAt2_1.setClear();
      capPos_1.setClear();
      s_motConveyorOn_1.setClear();
      s_valveInjectorOnOff_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        refill.gethook();
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
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
