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
  private int capcount_thread_6;//sysj\plant.sysj line: 110, column: 3
  private int numTurns_thread_13;//sysj\plant.sysj line: 200, column: 3
  private int S9595 = 1;
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
  private int S2625 = 1;
  private int S2560 = 1;
  private int S2547 = 1;
  private int S2711 = 1;
  private int S2646 = 1;
  private int S2633 = 1;
  private int S2797 = 1;
  private int S2732 = 1;
  private int S2719 = 1;
  private int S2883 = 1;
  private int S2818 = 1;
  private int S2805 = 1;
  private int S3043 = 1;
  private int S2891 = 1;
  private int S2899 = 1;
  private int S2907 = 1;
  private int S2927 = 1;
  private int S2913 = 1;
  private int S2911 = 1;
  private int S2935 = 1;
  private int S2973 = 1;
  private int S2947 = 1;
  private int S2945 = 1;
  private int S2993 = 1;
  private int S2979 = 1;
  private int S2977 = 1;
  private int S3001 = 1;
  private int S3009 = 1;
  private int S3017 = 1;
  private int S3025 = 1;
  private int S3033 = 1;
  private int S3041 = 1;
  
  private int[] ends = new int[36];
  private int[] tdone = new int[36];
  
  public void thread9666(int [] tdone, int [] ends){
        switch(S3041){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 364, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 364, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
          System.out.println("Emitted gripperZAxisLiftedE");
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

  public void thread9665(int [] tdone, int [] ends){
        switch(S3033){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 362, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 362, column: 45
          currsigs.addElement(gripperTurnHomePosE);
          System.out.println("Emitted gripperTurnHomePosE");
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

  public void thread9664(int [] tdone, int [] ends){
        switch(S3025){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 360, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 360, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
          System.out.println("Emitted gripperTurnFinalPosE");
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

  public void thread9663(int [] tdone, int [] ends){
        switch(S3017){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 358, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 358, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
          System.out.println("Emitted gripperZAxisLoweredE");
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

  public void thread9662(int [] tdone, int [] ends){
        switch(S3009){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 356, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 356, column: 38
          currsigs.addElement(bottleAtPos2E);
          System.out.println("Emitted bottleAtPos2E");
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

  public void thread9661(int [] tdone, int [] ends){
        switch(S3001){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 354, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 354, column: 38
          currsigs.addElement(bottleAtPos4E);
          System.out.println("Emitted bottleAtPos4E");
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

  public void thread9660(int [] tdone, int [] ends){
        switch(S2993){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S2979){
          case 0 : 
            switch(S2977){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 352, column: 54
                  S2977=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 352, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 352, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  System.out.println("Emitted bottleAtPos5_RT");
                  S2979=1;
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
            S2979=1;
            S2979=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 352, column: 24
              S2977=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S2979=1;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9659(int [] tdone, int [] ends){
        switch(S2973){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S2947){
          case 0 : 
            switch(S2945){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 343, column: 11
                  S2945=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 345, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  System.out.println("Emitted bottleLeftPos5E");
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 344, column: 11
                  S2947=1;
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 345, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  System.out.println("Emitted bottleLeftPos5E");
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S2947=1;
            S2947=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 342, column: 12
              S2945=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S2947=1;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9658(int [] tdone, int [] ends){
        switch(S2935){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 339, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 339, column: 56
          currsigs.addElement(bottleAtPos5E);
          System.out.println("Emitted bottleAtPos5E");
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

  public void thread9657(int [] tdone, int [] ends){
        switch(S2927){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S2913){
          case 0 : 
            switch(S2911){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 337, column: 54
                  S2911=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 337, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 337, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  System.out.println("Emitted bottleAtPos1_RT");
                  S2913=1;
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
            S2913=1;
            S2913=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 337, column: 24
              S2911=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S2913=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9656(int [] tdone, int [] ends){
        switch(S2907){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 335, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 335, column: 44
          currsigs.addElement(rotaryTableTriggerE);
          System.out.println("Emitted rotaryTableTriggerE");
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

  public void thread9655(int [] tdone, int [] ends){
        switch(S2899){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 333, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 333, column: 39
          currsigs.addElement(motConveyorOnE);
          System.out.println("Emitted motConveyorOnE");
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

  public void thread9654(int [] tdone, int [] ends){
        switch(S2891){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 331, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 331, column: 38
          currsigs.addElement(bottleAtPos1E);
          System.out.println("Emitted bottleAtPos1E");
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

  public void thread9653(int [] tdone, int [] ends){
        switch(S3043){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        thread9654(tdone,ends);
        thread9655(tdone,ends);
        thread9656(tdone,ends);
        thread9657(tdone,ends);
        thread9658(tdone,ends);
        thread9659(tdone,ends);
        thread9660(tdone,ends);
        thread9661(tdone,ends);
        thread9662(tdone,ends);
        thread9663(tdone,ends);
        thread9664(tdone,ends);
        thread9665(tdone,ends);
        thread9666(tdone,ends);
        int biggest9667 = 0;
        if(ends[23]>=biggest9667){
          biggest9667=ends[23];
        }
        if(ends[24]>=biggest9667){
          biggest9667=ends[24];
        }
        if(ends[25]>=biggest9667){
          biggest9667=ends[25];
        }
        if(ends[26]>=biggest9667){
          biggest9667=ends[26];
        }
        if(ends[27]>=biggest9667){
          biggest9667=ends[27];
        }
        if(ends[28]>=biggest9667){
          biggest9667=ends[28];
        }
        if(ends[29]>=biggest9667){
          biggest9667=ends[29];
        }
        if(ends[30]>=biggest9667){
          biggest9667=ends[30];
        }
        if(ends[31]>=biggest9667){
          biggest9667=ends[31];
        }
        if(ends[32]>=biggest9667){
          biggest9667=ends[32];
        }
        if(ends[33]>=biggest9667){
          biggest9667=ends[33];
        }
        if(ends[34]>=biggest9667){
          biggest9667=ends[34];
        }
        if(ends[35]>=biggest9667){
          biggest9667=ends[35];
        }
        if(biggest9667 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest9667 == 0){
          S3043=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread9652(int [] tdone, int [] ends){
        switch(S2883){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S2818){
          case 0 : 
            S2818=0;
            S2818=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 308, column: 12
              S2805=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S2818=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus())){//sysj\plant.sysj line: 309, column: 11
              S2818=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              switch(S2805){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 310, column: 12
                    S2805=1;
                    gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 311, column: 6
                    currsigs.addElement(gripperZAxisLifted);
                    System.out.println("Emitted gripperZAxisLifted");
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
                  gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 311, column: 6
                  currsigs.addElement(gripperZAxisLifted);
                  System.out.println("Emitted gripperZAxisLifted");
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

  public void thread9651(int [] tdone, int [] ends){
        switch(S2797){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2732){
          case 0 : 
            S2732=0;
            S2732=1;
            if((gripperTurnRetract.getprestatus() && !capGripperPos5Extend.getprestatus()) || !gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 296, column: 12
              S2719=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S2732=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus())){//sysj\plant.sysj line: 297, column: 11
              S2732=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              switch(S2719){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 298, column: 12
                    S2719=1;
                    gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 299, column: 6
                    currsigs.addElement(gripperTurnHomePos);
                    System.out.println("Emitted gripperTurnHomePos");
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
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 299, column: 6
                  currsigs.addElement(gripperTurnHomePos);
                  System.out.println("Emitted gripperTurnHomePos");
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9650(int [] tdone, int [] ends){
        switch(S2711){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2646){
          case 0 : 
            S2646=0;
            S2646=1;
            if(gripperTurnExtend.getprestatus() && capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 284, column: 12
              S2633=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S2646=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus())){//sysj\plant.sysj line: 285, column: 11
              S2646=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              switch(S2633){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 286, column: 12
                    S2633=1;
                    gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 287, column: 6
                    currsigs.addElement(gripperTurnFinalPos);
                    System.out.println("Emitted gripperTurnFinalPos");
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
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 287, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
                  System.out.println("Emitted gripperTurnFinalPos");
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9649(int [] tdone, int [] ends){
        switch(S2625){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S2560){
          case 0 : 
            S2560=0;
            S2560=1;
            if(cylPos5ZAxisExtend.getprestatus() && cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 272, column: 12
              S2547=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S2560=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus())){//sysj\plant.sysj line: 273, column: 11
              S2560=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              switch(S2547){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 274, column: 12
                    S2547=1;
                    gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 275, column: 6
                    currsigs.addElement(gripperZAxisLowered);
                    System.out.println("Emitted gripperZAxisLowered");
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
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 275, column: 6
                  currsigs.addElement(gripperZAxisLowered);
                  System.out.println("Emitted gripperZAxisLowered");
                  active[18]=1;
                  ends[18]=1;
                  tdone[18]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9648(int [] tdone, int [] ends){
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

  public void thread9647(int [] tdone, int [] ends){
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

  public void thread9646(int [] tdone, int [] ends){
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

  public void thread9645(int [] tdone, int [] ends){
        switch(S2533){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 228, column: 3
        active[14]=1;
        ends[14]=1;
        tdone[14]=1;
        break;
      
    }
  }

  public void thread9644(int [] tdone, int [] ends){
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
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 204, column: 13
              S1483=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 217, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 218, column: 5
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
            if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 203, column: 10
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 217, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 218, column: 5
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
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 205, column: 12
                    numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 206, column: 6
                    if(numTurns_thread_13 == 2){//sysj\plant.sysj line: 207, column: 9
                      l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 208, column: 7
                      currsigs.addElement(l_putBottleAt2_1);
                      System.out.println("Emitted l_putBottleAt2_1");
                      if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 217, column: 12
                        numTurns_thread_13 = 0;//sysj\plant.sysj line: 218, column: 5
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
                      if(numTurns_thread_13 == 3){//sysj\plant.sysj line: 209, column: 15
                        l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 210, column: 7
                        currsigs.addElement(l_putBottleAt4_1);
                        System.out.println("Emitted l_putBottleAt4_1");
                        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 217, column: 12
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 218, column: 5
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
                        if(numTurns_thread_13 == 4){//sysj\plant.sysj line: 211, column: 15
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 212, column: 7
                          l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 213, column: 7
                          currsigs.addElement(l_putBottleAt5_1);
                          System.out.println("Emitted l_putBottleAt5_1");
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 217, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 218, column: 5
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
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 217, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 218, column: 5
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
                  if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 217, column: 12
                    numTurns_thread_13 = 0;//sysj\plant.sysj line: 218, column: 5
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

  public void thread9643(int [] tdone, int [] ends){
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
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 190, column: 12
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
            if(!enable.getprestatus()){//sysj\plant.sysj line: 191, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 192, column: 5
              currsigs.addElement(bottleLeftPos5);
              System.out.println("Emitted bottleLeftPos5");
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

  public void thread9642(int [] tdone, int [] ends){
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
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 178, column: 12
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
            if((enable.getprestatus() && !l_putBottleAt2_1.getprestatus())){//sysj\plant.sysj line: 179, column: 11
              S1377=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S1364){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 180, column: 12
                    S1364=1;
                    bottleAtPos2.setPresent();//sysj\plant.sysj line: 181, column: 6
                    currsigs.addElement(bottleAtPos2);
                    System.out.println("Emitted bottleAtPos2");
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
                  bottleAtPos2.setPresent();//sysj\plant.sysj line: 181, column: 6
                  currsigs.addElement(bottleAtPos2);
                  System.out.println("Emitted bottleAtPos2");
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

  public void thread9641(int [] tdone, int [] ends){
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
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 166, column: 12
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
            if((enable.getprestatus() && !l_putBottleAt4_1.getprestatus())){//sysj\plant.sysj line: 167, column: 11
              S1291=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S1278){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 168, column: 12
                    S1278=1;
                    bottleAtPos4.setPresent();//sysj\plant.sysj line: 169, column: 6
                    currsigs.addElement(bottleAtPos4);
                    System.out.println("Emitted bottleAtPos4");
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
                  bottleAtPos4.setPresent();//sysj\plant.sysj line: 169, column: 6
                  currsigs.addElement(bottleAtPos4);
                  System.out.println("Emitted bottleAtPos4");
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

  public void thread9640(int [] tdone, int [] ends){
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
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 155, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 157, column: 6
              currsigs.addElement(bottleAtPos5);
              System.out.println("Emitted bottleAtPos5");
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
            if((enable.getprestatus() && !l_putBottleAt5_1.getprestatus()) || bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 156, column: 11
              S1235=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 157, column: 6
              currsigs.addElement(bottleAtPos5);
              System.out.println("Emitted bottleAtPos5");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9639(int [] tdone, int [] ends){
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
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 144, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 146, column: 6
              currsigs.addElement(l_bottleAdded_1);
              System.out.println("Emitted l_bottleAdded_1");
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
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 145, column: 11
              S1189=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 146, column: 6
              currsigs.addElement(l_bottleAdded_1);
              System.out.println("Emitted l_bottleAdded_1");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9638(int [] tdone, int [] ends){
        switch(S1178){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 129, column: 3
        switch(S1146){
          case 0 : 
            S1146=0;
            S1146=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 133, column: 11
              S1146=2;
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 135, column: 6
              currsigs.addElement(bottleAtPos1);
              System.out.println("Emitted bottleAtPos1");
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
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 134, column: 11
              S1146=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 135, column: 6
              currsigs.addElement(bottleAtPos1);
              System.out.println("Emitted bottleAtPos1");
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread9637(int [] tdone, int [] ends){
        switch(S1142){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 112, column: 12
          if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 113, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 114, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 116, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 117, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 120, column: 8
              empty.setPresent();//sysj\plant.sysj line: 121, column: 6
              currsigs.addElement(empty);
              System.out.println("Emitted empty");
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 120, column: 8
              empty.setPresent();//sysj\plant.sysj line: 121, column: 6
              currsigs.addElement(empty);
              System.out.println("Emitted empty");
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
          if(refill.getprestatus()){//sysj\plant.sysj line: 116, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 117, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 120, column: 8
              empty.setPresent();//sysj\plant.sysj line: 121, column: 6
              currsigs.addElement(empty);
              System.out.println("Emitted empty");
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 120, column: 8
              empty.setPresent();//sysj\plant.sysj line: 121, column: 6
              currsigs.addElement(empty);
              System.out.println("Emitted empty");
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

  public void thread9636(int [] tdone, int [] ends){
        switch(S1080){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1034){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 95, column: 10
              S1034=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1016){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 97, column: 13
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
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 98, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 100, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 100, column: 7
                    System.out.println("Emitted capPos_1");
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
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 101, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 102, column: 7
                    currsigs.addElement(capDec_1);
                    System.out.println("Emitted capDec_1");
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
            if(refill.getprestatus()){//sysj\plant.sysj line: 105, column: 10
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

  public void thread9635(int [] tdone, int [] ends){
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
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 75, column: 12
                  S977=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 78, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 79, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 79, column: 7
                    System.out.println("Emitted capPos_1");
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
                  WPgripped.setPresent();//sysj\plant.sysj line: 76, column: 7
                  currsigs.addElement(WPgripped);
                  System.out.println("Emitted WPgripped");
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S982=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 72, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 73, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 74, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 74, column: 6
                    System.out.println("Emitted capPos_1");
                    S977=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 76, column: 7
                    currsigs.addElement(WPgripped);
                    System.out.println("Emitted WPgripped");
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
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 72, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 73, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 74, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 74, column: 6
                System.out.println("Emitted capPos_1");
                S977=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 76, column: 7
                currsigs.addElement(WPgripped);
                System.out.println("Emitted WPgripped");
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

  public void thread9634(int [] tdone, int [] ends){
        switch(S968){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S922){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 59, column: 10
              S922=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 60, column: 5
              currsigs.addElement(pusherRetracted);
              System.out.println("Emitted pusherRetracted");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 62, column: 10
              S922=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 64, column: 5
              currsigs.addElement(pusherExtended);
              System.out.println("Emitted pusherExtended");
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
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 63, column: 10
              S922=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 64, column: 5
              currsigs.addElement(pusherExtended);
              System.out.println("Emitted pusherExtended");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 66, column: 10
              S922=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 60, column: 5
              currsigs.addElement(pusherRetracted);
              System.out.println("Emitted pusherRetracted");
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

  public void thread9633(int [] tdone, int [] ends){
        switch(S915){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S869){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 46, column: 10
              S869=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 47, column: 5
              currsigs.addElement(armAtDest);
              System.out.println("Emitted armAtDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 49, column: 10
              S869=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 51, column: 5
              currsigs.addElement(armAtSource);
              System.out.println("Emitted armAtSource");
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 50, column: 10
              S869=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 51, column: 5
              currsigs.addElement(armAtSource);
              System.out.println("Emitted armAtSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 53, column: 10
              S869=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 47, column: 5
              currsigs.addElement(armAtDest);
              System.out.println("Emitted armAtDest");
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

  public void thread9630(int [] tdone, int [] ends){
        S3041=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 364, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 364, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
      System.out.println("Emitted gripperZAxisLiftedE");
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

  public void thread9629(int [] tdone, int [] ends){
        S3033=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 362, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 362, column: 45
      currsigs.addElement(gripperTurnHomePosE);
      System.out.println("Emitted gripperTurnHomePosE");
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

  public void thread9628(int [] tdone, int [] ends){
        S3025=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 360, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 360, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
      System.out.println("Emitted gripperTurnFinalPosE");
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

  public void thread9627(int [] tdone, int [] ends){
        S3017=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 358, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 358, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
      System.out.println("Emitted gripperZAxisLoweredE");
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

  public void thread9626(int [] tdone, int [] ends){
        S3009=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 356, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 356, column: 38
      currsigs.addElement(bottleAtPos2E);
      System.out.println("Emitted bottleAtPos2E");
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

  public void thread9625(int [] tdone, int [] ends){
        S3001=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 354, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 354, column: 38
      currsigs.addElement(bottleAtPos4E);
      System.out.println("Emitted bottleAtPos4E");
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

  public void thread9624(int [] tdone, int [] ends){
        S2993=1;
    S2979=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 352, column: 24
      S2977=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S2979=1;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread9623(int [] tdone, int [] ends){
        S2973=1;
    S2947=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 342, column: 12
      S2945=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      S2947=1;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread9622(int [] tdone, int [] ends){
        S2935=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 339, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 339, column: 56
      currsigs.addElement(bottleAtPos5E);
      System.out.println("Emitted bottleAtPos5E");
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

  public void thread9621(int [] tdone, int [] ends){
        S2927=1;
    S2913=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 337, column: 24
      S2911=0;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      S2913=1;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread9620(int [] tdone, int [] ends){
        S2907=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 335, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 335, column: 44
      currsigs.addElement(rotaryTableTriggerE);
      System.out.println("Emitted rotaryTableTriggerE");
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

  public void thread9619(int [] tdone, int [] ends){
        S2899=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 333, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 333, column: 39
      currsigs.addElement(motConveyorOnE);
      System.out.println("Emitted motConveyorOnE");
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

  public void thread9618(int [] tdone, int [] ends){
        S2891=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 331, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 331, column: 38
      currsigs.addElement(bottleAtPos1E);
      System.out.println("Emitted bottleAtPos1E");
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

  public void thread9617(int [] tdone, int [] ends){
        S3043=1;
    thread9618(tdone,ends);
    thread9619(tdone,ends);
    thread9620(tdone,ends);
    thread9621(tdone,ends);
    thread9622(tdone,ends);
    thread9623(tdone,ends);
    thread9624(tdone,ends);
    thread9625(tdone,ends);
    thread9626(tdone,ends);
    thread9627(tdone,ends);
    thread9628(tdone,ends);
    thread9629(tdone,ends);
    thread9630(tdone,ends);
    int biggest9631 = 0;
    if(ends[23]>=biggest9631){
      biggest9631=ends[23];
    }
    if(ends[24]>=biggest9631){
      biggest9631=ends[24];
    }
    if(ends[25]>=biggest9631){
      biggest9631=ends[25];
    }
    if(ends[26]>=biggest9631){
      biggest9631=ends[26];
    }
    if(ends[27]>=biggest9631){
      biggest9631=ends[27];
    }
    if(ends[28]>=biggest9631){
      biggest9631=ends[28];
    }
    if(ends[29]>=biggest9631){
      biggest9631=ends[29];
    }
    if(ends[30]>=biggest9631){
      biggest9631=ends[30];
    }
    if(ends[31]>=biggest9631){
      biggest9631=ends[31];
    }
    if(ends[32]>=biggest9631){
      biggest9631=ends[32];
    }
    if(ends[33]>=biggest9631){
      biggest9631=ends[33];
    }
    if(ends[34]>=biggest9631){
      biggest9631=ends[34];
    }
    if(ends[35]>=biggest9631){
      biggest9631=ends[35];
    }
    if(biggest9631 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread9616(int [] tdone, int [] ends){
        S2883=1;
    S2818=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread9615(int [] tdone, int [] ends){
        S2797=1;
    S2732=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread9614(int [] tdone, int [] ends){
        S2711=1;
    S2646=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread9613(int [] tdone, int [] ends){
        S2625=1;
    S2560=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread9612(int [] tdone, int [] ends){
        S2539=1;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread9611(int [] tdone, int [] ends){
        S2537=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread9610(int [] tdone, int [] ends){
        S2535=1;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread9609(int [] tdone, int [] ends){
        S2533=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 228, column: 3
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread9608(int [] tdone, int [] ends){
        S2530=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 200, column: 3
    S1497=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread9607(int [] tdone, int [] ends){
        S1472=1;
    S1449=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread9606(int [] tdone, int [] ends){
        S1442=1;
    S1377=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread9605(int [] tdone, int [] ends){
        S1356=1;
    S1291=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread9604(int [] tdone, int [] ends){
        S1270=1;
    S1235=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread9603(int [] tdone, int [] ends){
        S1224=1;
    S1189=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread9602(int [] tdone, int [] ends){
        S1178=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 129, column: 3
    S1146=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread9601(int [] tdone, int [] ends){
        S1142=1;
    capcount_thread_6 = 5;//sysj\plant.sysj line: 110, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 112, column: 12
      if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 113, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 114, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 116, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 117, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 120, column: 8
          empty.setPresent();//sysj\plant.sysj line: 121, column: 6
          currsigs.addElement(empty);
          System.out.println("Emitted empty");
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 120, column: 8
          empty.setPresent();//sysj\plant.sysj line: 121, column: 6
          currsigs.addElement(empty);
          System.out.println("Emitted empty");
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
      if(refill.getprestatus()){//sysj\plant.sysj line: 116, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 117, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 120, column: 8
          empty.setPresent();//sysj\plant.sysj line: 121, column: 6
          currsigs.addElement(empty);
          System.out.println("Emitted empty");
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 120, column: 8
          empty.setPresent();//sysj\plant.sysj line: 121, column: 6
          currsigs.addElement(empty);
          System.out.println("Emitted empty");
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

  public void thread9600(int [] tdone, int [] ends){
        S1080=1;
    S1034=0;
    S1016=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread9599(int [] tdone, int [] ends){
        S1012=1;
    S982=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 72, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 73, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 74, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 74, column: 6
        System.out.println("Emitted capPos_1");
        S977=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 76, column: 7
        currsigs.addElement(WPgripped);
        System.out.println("Emitted WPgripped");
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

  public void thread9598(int [] tdone, int [] ends){
        S968=1;
    S922=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 60, column: 5
    currsigs.addElement(pusherRetracted);
    System.out.println("Emitted pusherRetracted");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread9597(int [] tdone, int [] ends){
        S915=1;
    S869=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 47, column: 5
    currsigs.addElement(armAtDest);
    System.out.println("Emitted armAtDest");
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
      switch(S9595){
        case 0 : 
          S9595=0;
          break RUN;
        
        case 1 : 
          S9595=2;
          S9595=2;
          class GUI extends Object implements java.lang.Runnable {//sysj\plant.sysj line: 31, column: 1
            public void run() {//sysj\plant.sysj line: 33, column: 21
              org.compsys704.CapLoader.main(null);//sysj\plant.sysj line: 34, column: 4
            }
            GUI(){//sysj\plant.sysj line: 32, column: 42
            }
          }
          new Thread(new GUI()).start();//sysj\plant.sysj line: 37, column: 2
          capDec_1.setClear();//sysj\plant.sysj line: 39, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 40, column: 2
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 41, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 41, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 41, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 42, column: 2
          capPos_1.setPresent();//sysj\plant.sysj line: 43, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\plant.sysj line: 43, column: 2
          System.out.println("Emitted capPos_1");
          thread9597(tdone,ends);
          thread9598(tdone,ends);
          thread9599(tdone,ends);
          thread9600(tdone,ends);
          thread9601(tdone,ends);
          thread9602(tdone,ends);
          thread9603(tdone,ends);
          thread9604(tdone,ends);
          thread9605(tdone,ends);
          thread9606(tdone,ends);
          thread9607(tdone,ends);
          thread9608(tdone,ends);
          thread9609(tdone,ends);
          thread9610(tdone,ends);
          thread9611(tdone,ends);
          thread9612(tdone,ends);
          thread9613(tdone,ends);
          thread9614(tdone,ends);
          thread9615(tdone,ends);
          thread9616(tdone,ends);
          thread9617(tdone,ends);
          int biggest9632 = 0;
          if(ends[2]>=biggest9632){
            biggest9632=ends[2];
          }
          if(ends[3]>=biggest9632){
            biggest9632=ends[3];
          }
          if(ends[4]>=biggest9632){
            biggest9632=ends[4];
          }
          if(ends[5]>=biggest9632){
            biggest9632=ends[5];
          }
          if(ends[6]>=biggest9632){
            biggest9632=ends[6];
          }
          if(ends[7]>=biggest9632){
            biggest9632=ends[7];
          }
          if(ends[8]>=biggest9632){
            biggest9632=ends[8];
          }
          if(ends[9]>=biggest9632){
            biggest9632=ends[9];
          }
          if(ends[10]>=biggest9632){
            biggest9632=ends[10];
          }
          if(ends[11]>=biggest9632){
            biggest9632=ends[11];
          }
          if(ends[12]>=biggest9632){
            biggest9632=ends[12];
          }
          if(ends[13]>=biggest9632){
            biggest9632=ends[13];
          }
          if(ends[14]>=biggest9632){
            biggest9632=ends[14];
          }
          if(ends[15]>=biggest9632){
            biggest9632=ends[15];
          }
          if(ends[16]>=biggest9632){
            biggest9632=ends[16];
          }
          if(ends[17]>=biggest9632){
            biggest9632=ends[17];
          }
          if(ends[18]>=biggest9632){
            biggest9632=ends[18];
          }
          if(ends[19]>=biggest9632){
            biggest9632=ends[19];
          }
          if(ends[20]>=biggest9632){
            biggest9632=ends[20];
          }
          if(ends[21]>=biggest9632){
            biggest9632=ends[21];
          }
          if(ends[22]>=biggest9632){
            biggest9632=ends[22];
          }
          if(biggest9632 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\plant.sysj line: 39, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 40, column: 2
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 41, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 41, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 41, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 42, column: 2
          thread9633(tdone,ends);
          thread9634(tdone,ends);
          thread9635(tdone,ends);
          thread9636(tdone,ends);
          thread9637(tdone,ends);
          thread9638(tdone,ends);
          thread9639(tdone,ends);
          thread9640(tdone,ends);
          thread9641(tdone,ends);
          thread9642(tdone,ends);
          thread9643(tdone,ends);
          thread9644(tdone,ends);
          thread9645(tdone,ends);
          thread9646(tdone,ends);
          thread9647(tdone,ends);
          thread9648(tdone,ends);
          thread9649(tdone,ends);
          thread9650(tdone,ends);
          thread9651(tdone,ends);
          thread9652(tdone,ends);
          thread9653(tdone,ends);
          int biggest9668 = 0;
          if(ends[2]>=biggest9668){
            biggest9668=ends[2];
          }
          if(ends[3]>=biggest9668){
            biggest9668=ends[3];
          }
          if(ends[4]>=biggest9668){
            biggest9668=ends[4];
          }
          if(ends[5]>=biggest9668){
            biggest9668=ends[5];
          }
          if(ends[6]>=biggest9668){
            biggest9668=ends[6];
          }
          if(ends[7]>=biggest9668){
            biggest9668=ends[7];
          }
          if(ends[8]>=biggest9668){
            biggest9668=ends[8];
          }
          if(ends[9]>=biggest9668){
            biggest9668=ends[9];
          }
          if(ends[10]>=biggest9668){
            biggest9668=ends[10];
          }
          if(ends[11]>=biggest9668){
            biggest9668=ends[11];
          }
          if(ends[12]>=biggest9668){
            biggest9668=ends[12];
          }
          if(ends[13]>=biggest9668){
            biggest9668=ends[13];
          }
          if(ends[14]>=biggest9668){
            biggest9668=ends[14];
          }
          if(ends[15]>=biggest9668){
            biggest9668=ends[15];
          }
          if(ends[16]>=biggest9668){
            biggest9668=ends[16];
          }
          if(ends[17]>=biggest9668){
            biggest9668=ends[17];
          }
          if(ends[18]>=biggest9668){
            biggest9668=ends[18];
          }
          if(ends[19]>=biggest9668){
            biggest9668=ends[19];
          }
          if(ends[20]>=biggest9668){
            biggest9668=ends[20];
          }
          if(ends[21]>=biggest9668){
            biggest9668=ends[21];
          }
          if(ends[22]>=biggest9668){
            biggest9668=ends[22];
          }
          if(biggest9668 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest9668 == 0){
            S9595=0;
            active[1]=0;
            ends[1]=0;
            S9595=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
