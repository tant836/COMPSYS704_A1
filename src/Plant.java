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
  private Integer chance_thread_14;//sysj\plant.sysj line: 227, column: 3
  private Integer rand_thread_14;//sysj\plant.sysj line: 228, column: 3
  private int S12198 = 1;
  private int S902 = 1;
  private int S856 = 1;
  private int S955 = 1;
  private int S909 = 1;
  private int S999 = 1;
  private int S969 = 1;
  private int S964 = 1;
  private int S1067 = 1;
  private int S1021 = 1;
  private int S1003 = 1;
  private int S1129 = 1;
  private int S1165 = 1;
  private int S1133 = 1;
  private int S1211 = 1;
  private int S1176 = 1;
  private int S1257 = 1;
  private int S1222 = 1;
  private int S1343 = 1;
  private int S1278 = 1;
  private int S1265 = 1;
  private int S1429 = 1;
  private int S1364 = 1;
  private int S1351 = 1;
  private int S1459 = 1;
  private int S1436 = 1;
  private int S2517 = 1;
  private int S1484 = 1;
  private int S1470 = 1;
  private int S2799 = 1;
  private int S2553 = 1;
  private int S2519 = 1;
  private int S2802 = 1;
  private int S2804 = 1;
  private int S2806 = 1;
  private int S2808 = 1;
  private int S2902 = 1;
  private int S2831 = 1;
  private int S2818 = 1;
  private int S2996 = 1;
  private int S2925 = 1;
  private int S2912 = 1;
  private int S3090 = 1;
  private int S3019 = 1;
  private int S3006 = 1;
  private int S3136 = 1;
  private int S3101 = 1;
  private int S3326 = 1;
  private int S3325 = 1;
  private int S3163 = 1;
  private int S3150 = 1;
  private int S3420 = 1;
  private int S3349 = 1;
  private int S3336 = 1;
  private int S3684 = 1;
  private int S3428 = 1;
  private int S3436 = 1;
  private int S3444 = 1;
  private int S3464 = 1;
  private int S3450 = 1;
  private int S3448 = 1;
  private int S3472 = 1;
  private int S3510 = 1;
  private int S3484 = 1;
  private int S3482 = 1;
  private int S3530 = 1;
  private int S3516 = 1;
  private int S3514 = 1;
  private int S3538 = 1;
  private int S3546 = 1;
  private int S3554 = 1;
  private int S3562 = 1;
  private int S3570 = 1;
  private int S3578 = 1;
  private int S3586 = 1;
  private int S3594 = 1;
  private int S3602 = 1;
  private int S3610 = 1;
  private int S3618 = 1;
  private int S3626 = 1;
  private int S3634 = 1;
  private int S3642 = 1;
  private int S3650 = 1;
  private int S3658 = 1;
  private int S3666 = 1;
  private int S3674 = 1;
  private int S3682 = 1;
  
  private int[] ends = new int[52];
  private int[] tdone = new int[52];
  
  public void thread12301(int [] tdone, int [] ends){
        switch(S3682){
      case 0 : 
        active[51]=0;
        ends[51]=0;
        tdone[51]=1;
        break;
      
      case 1 : 
        if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 444, column: 25
          capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 444, column: 44
          currsigs.addElement(capOnBottleAtPos1E);
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

  public void thread12300(int [] tdone, int [] ends){
        switch(S3674){
      case 0 : 
        active[50]=0;
        ends[50]=0;
        tdone[50]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 441, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 441, column: 40
          currsigs.addElement(dosUnitFilledE);
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

  public void thread12299(int [] tdone, int [] ends){
        switch(S3666){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 439, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 439, column: 38
          currsigs.addElement(dosUnitEvacE);
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

  public void thread12298(int [] tdone, int [] ends){
        switch(S3658){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 437, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 437, column: 39
          currsigs.addElement(bottleAtPos2E);
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

  public void thread12297(int [] tdone, int [] ends){
        switch(S3650){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 435, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 435, column: 45
          currsigs.addElement(dosUnitValveExtendE);
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

  public void thread12296(int [] tdone, int [] ends){
        switch(S3642){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 433, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 433, column: 46
          currsigs.addElement(dosUnitValveRetractE);
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

  public void thread12295(int [] tdone, int [] ends){
        switch(S3634){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 431, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 431, column: 42
          currsigs.addElement(valveInletOnOffE);
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

  public void thread12294(int [] tdone, int [] ends){
        switch(S3626){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 429, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 429, column: 45
          currsigs.addElement(valveInjectorOnOffE);
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

  public void thread12293(int [] tdone, int [] ends){
        switch(S3618){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 426, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 426, column: 47
          currsigs.addElement(cylClampBottleExtendE);
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

  public void thread12292(int [] tdone, int [] ends){
        switch(S3610){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 424, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 424, column: 47
          currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread12291(int [] tdone, int [] ends){
        switch(S3602){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 422, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 422, column: 44
          currsigs.addElement(gripperTurnExtendE);
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

  public void thread12290(int [] tdone, int [] ends){
        switch(S3594){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 420, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 420, column: 45
          currsigs.addElement(gripperTurnRetractE);
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

  public void thread12289(int [] tdone, int [] ends){
        switch(S3586){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 418, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 418, column: 45
          currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread12288(int [] tdone, int [] ends){
        switch(S3578){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 416, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 416, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread12287(int [] tdone, int [] ends){
        switch(S3570){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 413, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 413, column: 45
          currsigs.addElement(gripperTurnHomePosE);
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

  public void thread12286(int [] tdone, int [] ends){
        switch(S3562){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 411, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 411, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread12285(int [] tdone, int [] ends){
        switch(S3554){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 409, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 409, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread12284(int [] tdone, int [] ends){
        switch(S3546){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 407, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 407, column: 38
          currsigs.addElement(bottleAtPos2E);
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

  public void thread12283(int [] tdone, int [] ends){
        switch(S3538){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 405, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 405, column: 38
          currsigs.addElement(bottleAtPos4E);
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

  public void thread12282(int [] tdone, int [] ends){
        switch(S3530){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        switch(S3516){
          case 0 : 
            switch(S3514){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 403, column: 54
                  S3514=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 403, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 403, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  S3516=1;
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
            S3516=1;
            S3516=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 403, column: 24
              S3514=0;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            else {
              S3516=1;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread12281(int [] tdone, int [] ends){
        switch(S3510){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        switch(S3484){
          case 0 : 
            switch(S3482){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 394, column: 11
                  S3482=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 396, column: 6
                  currsigs.addElement(bottleLeftPos5E);
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 395, column: 11
                  S3484=1;
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 396, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[31]=1;
                  ends[31]=1;
                  tdone[31]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S3484=1;
            S3484=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 393, column: 12
              S3482=0;
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            else {
              S3484=1;
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread12280(int [] tdone, int [] ends){
        switch(S3472){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 390, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 390, column: 56
          currsigs.addElement(bottleAtPos5E);
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

  public void thread12279(int [] tdone, int [] ends){
        switch(S3464){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S3450){
          case 0 : 
            switch(S3448){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 388, column: 54
                  S3448=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 388, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 388, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  S3450=1;
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
            S3450=1;
            S3450=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 388, column: 24
              S3448=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S3450=1;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread12278(int [] tdone, int [] ends){
        switch(S3444){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 386, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 386, column: 44
          currsigs.addElement(rotaryTableTriggerE);
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

  public void thread12277(int [] tdone, int [] ends){
        switch(S3436){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 384, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 384, column: 39
          currsigs.addElement(motConveyorOnE);
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

  public void thread12276(int [] tdone, int [] ends){
        switch(S3428){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 382, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 382, column: 38
          currsigs.addElement(bottleAtPos1E);
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
  }

  public void thread12275(int [] tdone, int [] ends){
        switch(S3684){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        thread12276(tdone,ends);
        thread12277(tdone,ends);
        thread12278(tdone,ends);
        thread12279(tdone,ends);
        thread12280(tdone,ends);
        thread12281(tdone,ends);
        thread12282(tdone,ends);
        thread12283(tdone,ends);
        thread12284(tdone,ends);
        thread12285(tdone,ends);
        thread12286(tdone,ends);
        thread12287(tdone,ends);
        thread12288(tdone,ends);
        thread12289(tdone,ends);
        thread12290(tdone,ends);
        thread12291(tdone,ends);
        thread12292(tdone,ends);
        thread12293(tdone,ends);
        thread12294(tdone,ends);
        thread12295(tdone,ends);
        thread12296(tdone,ends);
        thread12297(tdone,ends);
        thread12298(tdone,ends);
        thread12299(tdone,ends);
        thread12300(tdone,ends);
        thread12301(tdone,ends);
        int biggest12302 = 0;
        if(ends[26]>=biggest12302){
          biggest12302=ends[26];
        }
        if(ends[27]>=biggest12302){
          biggest12302=ends[27];
        }
        if(ends[28]>=biggest12302){
          biggest12302=ends[28];
        }
        if(ends[29]>=biggest12302){
          biggest12302=ends[29];
        }
        if(ends[30]>=biggest12302){
          biggest12302=ends[30];
        }
        if(ends[31]>=biggest12302){
          biggest12302=ends[31];
        }
        if(ends[32]>=biggest12302){
          biggest12302=ends[32];
        }
        if(ends[33]>=biggest12302){
          biggest12302=ends[33];
        }
        if(ends[34]>=biggest12302){
          biggest12302=ends[34];
        }
        if(ends[35]>=biggest12302){
          biggest12302=ends[35];
        }
        if(ends[36]>=biggest12302){
          biggest12302=ends[36];
        }
        if(ends[37]>=biggest12302){
          biggest12302=ends[37];
        }
        if(ends[38]>=biggest12302){
          biggest12302=ends[38];
        }
        if(ends[39]>=biggest12302){
          biggest12302=ends[39];
        }
        if(ends[40]>=biggest12302){
          biggest12302=ends[40];
        }
        if(ends[41]>=biggest12302){
          biggest12302=ends[41];
        }
        if(ends[42]>=biggest12302){
          biggest12302=ends[42];
        }
        if(ends[43]>=biggest12302){
          biggest12302=ends[43];
        }
        if(ends[44]>=biggest12302){
          biggest12302=ends[44];
        }
        if(ends[45]>=biggest12302){
          biggest12302=ends[45];
        }
        if(ends[46]>=biggest12302){
          biggest12302=ends[46];
        }
        if(ends[47]>=biggest12302){
          biggest12302=ends[47];
        }
        if(ends[48]>=biggest12302){
          biggest12302=ends[48];
        }
        if(ends[49]>=biggest12302){
          biggest12302=ends[49];
        }
        if(ends[50]>=biggest12302){
          biggest12302=ends[50];
        }
        if(ends[51]>=biggest12302){
          biggest12302=ends[51];
        }
        if(biggest12302 == 1){
          active[25]=1;
          ends[25]=1;
          tdone[25]=1;
        }
        //FINXME code
        if(biggest12302 == 0){
          S3684=0;
          active[25]=0;
          ends[25]=0;
          tdone[25]=1;
        }
        break;
      
    }
  }

  public void thread12274(int [] tdone, int [] ends){
        switch(S3420){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S3349){
          case 0 : 
            S3349=0;
            S3349=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 360, column: 12
              S3336=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S3349=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            switch(S3336){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 361, column: 11
                  S3336=1;
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 363, column: 6
                  currsigs.addElement(dosUnitFilled);
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
              
              case 1 : 
                if(!dosUnitValveRetract.getprestatus() && dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 362, column: 11
                  S3349=0;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 363, column: 6
                  currsigs.addElement(dosUnitFilled);
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread12273(int [] tdone, int [] ends){
        switch(S3326){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S3325){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 343, column: 9
              S3325=1;
              S3163=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 344, column: 4
              currsigs.addElement(dosUnitEvac);
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S3163){
              case 0 : 
                S3163=0;
                S3163=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 348, column: 12
                  S3150=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  S3163=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
              case 1 : 
                switch(S3150){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 349, column: 11
                      S3150=1;
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 351, column: 6
                      currsigs.addElement(dosUnitEvac);
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
                    if(!dosUnitValveExtend.getprestatus() && dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 350, column: 11
                      S3163=0;
                      active[23]=1;
                      ends[23]=1;
                      tdone[23]=1;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 351, column: 6
                      currsigs.addElement(dosUnitEvac);
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
        break;
      
    }
  }

  public void thread12272(int [] tdone, int [] ends){
        switch(S3136){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S3101){
          case 0 : 
            S3101=0;
            S3101=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 331, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 333, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S3101=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 332, column: 11
              S3101=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 333, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread12271(int [] tdone, int [] ends){
        switch(S3090){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S3019){
          case 0 : 
            S3019=0;
            S3019=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 319, column: 12
              S3006=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S3019=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S3006){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 320, column: 11
                  S3006=1;
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 322, column: 6
                  currsigs.addElement(gripperTurnHomePos);
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
                if(!gripperTurnRetract.getprestatus() && gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 321, column: 11
                  S3019=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 322, column: 6
                  currsigs.addElement(gripperTurnHomePos);
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

  public void thread12270(int [] tdone, int [] ends){
        switch(S2996){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2925){
          case 0 : 
            S2925=0;
            S2925=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 307, column: 12
              S2912=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S2925=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S2912){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 308, column: 11
                  S2912=1;
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 310, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
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
                if(!gripperTurnExtend.getprestatus() && gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 309, column: 11
                  S2925=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 310, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
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

  public void thread12269(int [] tdone, int [] ends){
        switch(S2902){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2831){
          case 0 : 
            S2831=0;
            S2831=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 295, column: 12
              S2818=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S2831=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S2818){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 296, column: 11
                  S2818=1;
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 298, column: 6
                  currsigs.addElement(gripperZAxisLowered);
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
                if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 297, column: 11
                  S2831=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 298, column: 6
                  currsigs.addElement(gripperZAxisLowered);
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

  public void thread12268(int [] tdone, int [] ends){
        switch(S2808){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread12267(int [] tdone, int [] ends){
        switch(S2806){
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

  public void thread12266(int [] tdone, int [] ends){
        switch(S2804){
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

  public void thread12265(int [] tdone, int [] ends){
        switch(S2802){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 251, column: 3
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread12264(int [] tdone, int [] ends){
        switch(S2799){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S2553){
          case 0 : 
            S2553=0;
            S2553=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 232, column: 12
              rand_thread_14 = (int)(Math.random() * 100);//sysj\plant.sysj line: 233, column: 5
              System.out.println(rand_thread_14);//sysj\plant.sysj line: 234, column: 5
              S2519=0;
              if(rand_thread_14 < chance_thread_14){//sysj\plant.sysj line: 235, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 237, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S2519=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              S2553=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S2519){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 236, column: 12
                  S2519=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 237, column: 8
                  currsigs.addElement(capOnBottleAtPos1);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 241, column: 11
                  S2519=2;
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
                if(!enable.getprestatus()){//sysj\plant.sysj line: 242, column: 11
                  S2553=0;
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

  public void thread12263(int [] tdone, int [] ends){
        switch(S2517){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1484){
          case 0 : 
            S1484=0;
            S1484=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 206, column: 13
              S1470=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                S1484=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1484=0;
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
                S1484=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1484=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              switch(S1470){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 207, column: 12
                    numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 208, column: 6
                    if(numTurns_thread_13 >= 2 && numTurns_thread_13 < 4){//sysj\plant.sysj line: 209, column: 9
                      l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 210, column: 7
                      currsigs.addElement(l_putBottleAt2_1);
                      if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                        numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                        S1484=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                      else {
                        S1484=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                    }
                    else {
                      if(numTurns_thread_13 >= 4 && numTurns_thread_13 < 10){//sysj\plant.sysj line: 211, column: 15
                        l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 212, column: 7
                        currsigs.addElement(l_putBottleAt4_1);
                        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                          S1484=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        else {
                          S1484=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                      }
                      else {
                        if(numTurns_thread_13 >= 10){//sysj\plant.sysj line: 213, column: 15
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 214, column: 7
                          l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 215, column: 7
                          currsigs.addElement(l_putBottleAt5_1);
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                            S1484=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S1484=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                        }
                        else {
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 219, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 5
                            S1484=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S1484=0;
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
                    S1484=0;
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S1484=0;
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

  public void thread12262(int [] tdone, int [] ends){
        switch(S1459){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1436){
          case 0 : 
            S1436=0;
            S1436=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 192, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S1436=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 193, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 194, column: 5
              currsigs.addElement(bottleLeftPos5);
              S1436=0;
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

  public void thread12261(int [] tdone, int [] ends){
        switch(S1429){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1364){
          case 0 : 
            S1364=0;
            S1364=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 180, column: 12
              S1351=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S1364=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt2_1.getprestatus())){//sysj\plant.sysj line: 181, column: 11
              S1364=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S1351){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 182, column: 12
                    S1351=1;
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

  public void thread12260(int [] tdone, int [] ends){
        switch(S1343){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1278){
          case 0 : 
            S1278=0;
            S1278=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 168, column: 12
              S1265=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S1278=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt4_1.getprestatus())){//sysj\plant.sysj line: 169, column: 11
              S1278=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S1265){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 170, column: 12
                    S1265=1;
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

  public void thread12259(int [] tdone, int [] ends){
        switch(S1257){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1222){
          case 0 : 
            S1222=0;
            S1222=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 157, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 159, column: 6
              currsigs.addElement(bottleAtPos5);
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S1222=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt5_1.getprestatus()) || bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 158, column: 11
              S1222=0;
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

  public void thread12258(int [] tdone, int [] ends){
        switch(S1211){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S1176){
          case 0 : 
            S1176=0;
            S1176=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 146, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 148, column: 6
              currsigs.addElement(l_bottleAdded_1);
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S1176=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 11
              S1176=0;
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

  public void thread12257(int [] tdone, int [] ends){
        switch(S1165){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 131, column: 3
        switch(S1133){
          case 0 : 
            S1133=0;
            S1133=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 135, column: 11
              S1133=2;
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
              S1133=0;
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

  public void thread12256(int [] tdone, int [] ends){
        switch(S1129){
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

  public void thread12255(int [] tdone, int [] ends){
        switch(S1067){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1021){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 97, column: 10
              S1021=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1003){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 99, column: 13
                    S1003=1;
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
                    S1003=2;
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
                    S1003=0;
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
              S1021=0;
              S1003=0;
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

  public void thread12254(int [] tdone, int [] ends){
        switch(S999){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S969){
          case 0 : 
            switch(S964){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 77, column: 12
                  S964=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 80, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 81, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 81, column: 7
                    S969=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S969=1;
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
                S969=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 74, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 75, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 76, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 76, column: 6
                    S964=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 78, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S969=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S969=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S969=1;
            S969=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 74, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 75, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 76, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 76, column: 6
                S964=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 78, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S969=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S969=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread12253(int [] tdone, int [] ends){
        switch(S955){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S909){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 61, column: 10
              S909=1;
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
              S909=2;
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
              S909=3;
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
              S909=0;
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

  public void thread12252(int [] tdone, int [] ends){
        switch(S902){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S856){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 48, column: 10
              S856=1;
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
              S856=2;
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
              S856=3;
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
              S856=0;
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

  public void thread12249(int [] tdone, int [] ends){
        S3682=1;
    if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 444, column: 25
      capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 444, column: 44
      currsigs.addElement(capOnBottleAtPos1E);
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

  public void thread12248(int [] tdone, int [] ends){
        S3674=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 441, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 441, column: 40
      currsigs.addElement(dosUnitFilledE);
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

  public void thread12247(int [] tdone, int [] ends){
        S3666=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 439, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 439, column: 38
      currsigs.addElement(dosUnitEvacE);
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

  public void thread12246(int [] tdone, int [] ends){
        S3658=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 437, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 437, column: 39
      currsigs.addElement(bottleAtPos2E);
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

  public void thread12245(int [] tdone, int [] ends){
        S3650=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 435, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 435, column: 45
      currsigs.addElement(dosUnitValveExtendE);
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

  public void thread12244(int [] tdone, int [] ends){
        S3642=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 433, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 433, column: 46
      currsigs.addElement(dosUnitValveRetractE);
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

  public void thread12243(int [] tdone, int [] ends){
        S3634=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 431, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 431, column: 42
      currsigs.addElement(valveInletOnOffE);
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

  public void thread12242(int [] tdone, int [] ends){
        S3626=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 429, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 429, column: 45
      currsigs.addElement(valveInjectorOnOffE);
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

  public void thread12241(int [] tdone, int [] ends){
        S3618=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 426, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 426, column: 47
      currsigs.addElement(cylClampBottleExtendE);
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

  public void thread12240(int [] tdone, int [] ends){
        S3610=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 424, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 424, column: 47
      currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread12239(int [] tdone, int [] ends){
        S3602=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 422, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 422, column: 44
      currsigs.addElement(gripperTurnExtendE);
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

  public void thread12238(int [] tdone, int [] ends){
        S3594=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 420, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 420, column: 45
      currsigs.addElement(gripperTurnRetractE);
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

  public void thread12237(int [] tdone, int [] ends){
        S3586=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 418, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 418, column: 45
      currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread12236(int [] tdone, int [] ends){
        S3578=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 416, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 416, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread12235(int [] tdone, int [] ends){
        S3570=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 413, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 413, column: 45
      currsigs.addElement(gripperTurnHomePosE);
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

  public void thread12234(int [] tdone, int [] ends){
        S3562=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 411, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 411, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread12233(int [] tdone, int [] ends){
        S3554=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 409, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 409, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread12232(int [] tdone, int [] ends){
        S3546=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 407, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 407, column: 38
      currsigs.addElement(bottleAtPos2E);
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

  public void thread12231(int [] tdone, int [] ends){
        S3538=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 405, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 405, column: 38
      currsigs.addElement(bottleAtPos4E);
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

  public void thread12230(int [] tdone, int [] ends){
        S3530=1;
    S3516=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 403, column: 24
      S3514=0;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
    else {
      S3516=1;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
  }

  public void thread12229(int [] tdone, int [] ends){
        S3510=1;
    S3484=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 393, column: 12
      S3482=0;
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
    else {
      S3484=1;
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
  }

  public void thread12228(int [] tdone, int [] ends){
        S3472=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 390, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 390, column: 56
      currsigs.addElement(bottleAtPos5E);
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

  public void thread12227(int [] tdone, int [] ends){
        S3464=1;
    S3450=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 388, column: 24
      S3448=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S3450=1;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread12226(int [] tdone, int [] ends){
        S3444=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 386, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 386, column: 44
      currsigs.addElement(rotaryTableTriggerE);
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

  public void thread12225(int [] tdone, int [] ends){
        S3436=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 384, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 384, column: 39
      currsigs.addElement(motConveyorOnE);
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

  public void thread12224(int [] tdone, int [] ends){
        S3428=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 382, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 382, column: 38
      currsigs.addElement(bottleAtPos1E);
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread12223(int [] tdone, int [] ends){
        S3684=1;
    thread12224(tdone,ends);
    thread12225(tdone,ends);
    thread12226(tdone,ends);
    thread12227(tdone,ends);
    thread12228(tdone,ends);
    thread12229(tdone,ends);
    thread12230(tdone,ends);
    thread12231(tdone,ends);
    thread12232(tdone,ends);
    thread12233(tdone,ends);
    thread12234(tdone,ends);
    thread12235(tdone,ends);
    thread12236(tdone,ends);
    thread12237(tdone,ends);
    thread12238(tdone,ends);
    thread12239(tdone,ends);
    thread12240(tdone,ends);
    thread12241(tdone,ends);
    thread12242(tdone,ends);
    thread12243(tdone,ends);
    thread12244(tdone,ends);
    thread12245(tdone,ends);
    thread12246(tdone,ends);
    thread12247(tdone,ends);
    thread12248(tdone,ends);
    thread12249(tdone,ends);
    int biggest12250 = 0;
    if(ends[26]>=biggest12250){
      biggest12250=ends[26];
    }
    if(ends[27]>=biggest12250){
      biggest12250=ends[27];
    }
    if(ends[28]>=biggest12250){
      biggest12250=ends[28];
    }
    if(ends[29]>=biggest12250){
      biggest12250=ends[29];
    }
    if(ends[30]>=biggest12250){
      biggest12250=ends[30];
    }
    if(ends[31]>=biggest12250){
      biggest12250=ends[31];
    }
    if(ends[32]>=biggest12250){
      biggest12250=ends[32];
    }
    if(ends[33]>=biggest12250){
      biggest12250=ends[33];
    }
    if(ends[34]>=biggest12250){
      biggest12250=ends[34];
    }
    if(ends[35]>=biggest12250){
      biggest12250=ends[35];
    }
    if(ends[36]>=biggest12250){
      biggest12250=ends[36];
    }
    if(ends[37]>=biggest12250){
      biggest12250=ends[37];
    }
    if(ends[38]>=biggest12250){
      biggest12250=ends[38];
    }
    if(ends[39]>=biggest12250){
      biggest12250=ends[39];
    }
    if(ends[40]>=biggest12250){
      biggest12250=ends[40];
    }
    if(ends[41]>=biggest12250){
      biggest12250=ends[41];
    }
    if(ends[42]>=biggest12250){
      biggest12250=ends[42];
    }
    if(ends[43]>=biggest12250){
      biggest12250=ends[43];
    }
    if(ends[44]>=biggest12250){
      biggest12250=ends[44];
    }
    if(ends[45]>=biggest12250){
      biggest12250=ends[45];
    }
    if(ends[46]>=biggest12250){
      biggest12250=ends[46];
    }
    if(ends[47]>=biggest12250){
      biggest12250=ends[47];
    }
    if(ends[48]>=biggest12250){
      biggest12250=ends[48];
    }
    if(ends[49]>=biggest12250){
      biggest12250=ends[49];
    }
    if(ends[50]>=biggest12250){
      biggest12250=ends[50];
    }
    if(ends[51]>=biggest12250){
      biggest12250=ends[51];
    }
    if(biggest12250 == 1){
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
  }

  public void thread12222(int [] tdone, int [] ends){
        S3420=1;
    S3349=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread12221(int [] tdone, int [] ends){
        S3326=1;
    S3325=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 344, column: 4
    currsigs.addElement(dosUnitEvac);
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread12220(int [] tdone, int [] ends){
        S3136=1;
    S3101=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread12219(int [] tdone, int [] ends){
        S3090=1;
    S3019=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread12218(int [] tdone, int [] ends){
        S2996=1;
    S2925=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread12217(int [] tdone, int [] ends){
        S2902=1;
    S2831=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread12216(int [] tdone, int [] ends){
        S2808=1;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread12215(int [] tdone, int [] ends){
        S2806=1;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread12214(int [] tdone, int [] ends){
        S2804=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread12213(int [] tdone, int [] ends){
        S2802=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 251, column: 3
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread12212(int [] tdone, int [] ends){
        S2799=1;
    chance_thread_14 = 5;//sysj\plant.sysj line: 227, column: 3
        S2553=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread12211(int [] tdone, int [] ends){
        S2517=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 202, column: 3
    S1484=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread12210(int [] tdone, int [] ends){
        S1459=1;
    S1436=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread12209(int [] tdone, int [] ends){
        S1429=1;
    S1364=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread12208(int [] tdone, int [] ends){
        S1343=1;
    S1278=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread12207(int [] tdone, int [] ends){
        S1257=1;
    S1222=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread12206(int [] tdone, int [] ends){
        S1211=1;
    S1176=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread12205(int [] tdone, int [] ends){
        S1165=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 131, column: 3
    S1133=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread12204(int [] tdone, int [] ends){
        S1129=1;
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

  public void thread12203(int [] tdone, int [] ends){
        S1067=1;
    S1021=0;
    S1003=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread12202(int [] tdone, int [] ends){
        S999=1;
    S969=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 74, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 75, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 76, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 76, column: 6
        S964=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 78, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S969=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S969=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread12201(int [] tdone, int [] ends){
        S955=1;
    S909=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 62, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread12200(int [] tdone, int [] ends){
        S902=1;
    S856=0;
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
      switch(S12198){
        case 0 : 
          S12198=0;
          break RUN;
        
        case 1 : 
          S12198=2;
          S12198=2;
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
          thread12200(tdone,ends);
          thread12201(tdone,ends);
          thread12202(tdone,ends);
          thread12203(tdone,ends);
          thread12204(tdone,ends);
          thread12205(tdone,ends);
          thread12206(tdone,ends);
          thread12207(tdone,ends);
          thread12208(tdone,ends);
          thread12209(tdone,ends);
          thread12210(tdone,ends);
          thread12211(tdone,ends);
          thread12212(tdone,ends);
          thread12213(tdone,ends);
          thread12214(tdone,ends);
          thread12215(tdone,ends);
          thread12216(tdone,ends);
          thread12217(tdone,ends);
          thread12218(tdone,ends);
          thread12219(tdone,ends);
          thread12220(tdone,ends);
          thread12221(tdone,ends);
          thread12222(tdone,ends);
          thread12223(tdone,ends);
          int biggest12251 = 0;
          if(ends[2]>=biggest12251){
            biggest12251=ends[2];
          }
          if(ends[3]>=biggest12251){
            biggest12251=ends[3];
          }
          if(ends[4]>=biggest12251){
            biggest12251=ends[4];
          }
          if(ends[5]>=biggest12251){
            biggest12251=ends[5];
          }
          if(ends[6]>=biggest12251){
            biggest12251=ends[6];
          }
          if(ends[7]>=biggest12251){
            biggest12251=ends[7];
          }
          if(ends[8]>=biggest12251){
            biggest12251=ends[8];
          }
          if(ends[9]>=biggest12251){
            biggest12251=ends[9];
          }
          if(ends[10]>=biggest12251){
            biggest12251=ends[10];
          }
          if(ends[11]>=biggest12251){
            biggest12251=ends[11];
          }
          if(ends[12]>=biggest12251){
            biggest12251=ends[12];
          }
          if(ends[13]>=biggest12251){
            biggest12251=ends[13];
          }
          if(ends[14]>=biggest12251){
            biggest12251=ends[14];
          }
          if(ends[15]>=biggest12251){
            biggest12251=ends[15];
          }
          if(ends[16]>=biggest12251){
            biggest12251=ends[16];
          }
          if(ends[17]>=biggest12251){
            biggest12251=ends[17];
          }
          if(ends[18]>=biggest12251){
            biggest12251=ends[18];
          }
          if(ends[19]>=biggest12251){
            biggest12251=ends[19];
          }
          if(ends[20]>=biggest12251){
            biggest12251=ends[20];
          }
          if(ends[21]>=biggest12251){
            biggest12251=ends[21];
          }
          if(ends[22]>=biggest12251){
            biggest12251=ends[22];
          }
          if(ends[23]>=biggest12251){
            biggest12251=ends[23];
          }
          if(ends[24]>=biggest12251){
            biggest12251=ends[24];
          }
          if(ends[25]>=biggest12251){
            biggest12251=ends[25];
          }
          if(biggest12251 == 1){
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
          thread12252(tdone,ends);
          thread12253(tdone,ends);
          thread12254(tdone,ends);
          thread12255(tdone,ends);
          thread12256(tdone,ends);
          thread12257(tdone,ends);
          thread12258(tdone,ends);
          thread12259(tdone,ends);
          thread12260(tdone,ends);
          thread12261(tdone,ends);
          thread12262(tdone,ends);
          thread12263(tdone,ends);
          thread12264(tdone,ends);
          thread12265(tdone,ends);
          thread12266(tdone,ends);
          thread12267(tdone,ends);
          thread12268(tdone,ends);
          thread12269(tdone,ends);
          thread12270(tdone,ends);
          thread12271(tdone,ends);
          thread12272(tdone,ends);
          thread12273(tdone,ends);
          thread12274(tdone,ends);
          thread12275(tdone,ends);
          int biggest12303 = 0;
          if(ends[2]>=biggest12303){
            biggest12303=ends[2];
          }
          if(ends[3]>=biggest12303){
            biggest12303=ends[3];
          }
          if(ends[4]>=biggest12303){
            biggest12303=ends[4];
          }
          if(ends[5]>=biggest12303){
            biggest12303=ends[5];
          }
          if(ends[6]>=biggest12303){
            biggest12303=ends[6];
          }
          if(ends[7]>=biggest12303){
            biggest12303=ends[7];
          }
          if(ends[8]>=biggest12303){
            biggest12303=ends[8];
          }
          if(ends[9]>=biggest12303){
            biggest12303=ends[9];
          }
          if(ends[10]>=biggest12303){
            biggest12303=ends[10];
          }
          if(ends[11]>=biggest12303){
            biggest12303=ends[11];
          }
          if(ends[12]>=biggest12303){
            biggest12303=ends[12];
          }
          if(ends[13]>=biggest12303){
            biggest12303=ends[13];
          }
          if(ends[14]>=biggest12303){
            biggest12303=ends[14];
          }
          if(ends[15]>=biggest12303){
            biggest12303=ends[15];
          }
          if(ends[16]>=biggest12303){
            biggest12303=ends[16];
          }
          if(ends[17]>=biggest12303){
            biggest12303=ends[17];
          }
          if(ends[18]>=biggest12303){
            biggest12303=ends[18];
          }
          if(ends[19]>=biggest12303){
            biggest12303=ends[19];
          }
          if(ends[20]>=biggest12303){
            biggest12303=ends[20];
          }
          if(ends[21]>=biggest12303){
            biggest12303=ends[21];
          }
          if(ends[22]>=biggest12303){
            biggest12303=ends[22];
          }
          if(ends[23]>=biggest12303){
            biggest12303=ends[23];
          }
          if(ends[24]>=biggest12303){
            biggest12303=ends[24];
          }
          if(ends[25]>=biggest12303){
            biggest12303=ends[25];
          }
          if(biggest12303 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest12303 == 0){
            S12198=0;
            active[1]=0;
            ends[1]=0;
            S12198=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
