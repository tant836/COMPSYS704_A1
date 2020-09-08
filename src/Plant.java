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
  private int S11038 = 1;
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
  private int S2520 = 1;
  private int S2522 = 1;
  private int S2524 = 1;
  private int S2526 = 1;
  private int S2620 = 1;
  private int S2549 = 1;
  private int S2536 = 1;
  private int S2714 = 1;
  private int S2643 = 1;
  private int S2630 = 1;
  private int S2808 = 1;
  private int S2737 = 1;
  private int S2724 = 1;
  private int S2854 = 1;
  private int S2819 = 1;
  private int S3044 = 1;
  private int S3043 = 1;
  private int S2881 = 1;
  private int S2868 = 1;
  private int S3138 = 1;
  private int S3067 = 1;
  private int S3054 = 1;
  private int S3394 = 1;
  private int S3146 = 1;
  private int S3154 = 1;
  private int S3162 = 1;
  private int S3182 = 1;
  private int S3168 = 1;
  private int S3166 = 1;
  private int S3190 = 1;
  private int S3228 = 1;
  private int S3202 = 1;
  private int S3200 = 1;
  private int S3248 = 1;
  private int S3234 = 1;
  private int S3232 = 1;
  private int S3256 = 1;
  private int S3264 = 1;
  private int S3272 = 1;
  private int S3280 = 1;
  private int S3288 = 1;
  private int S3296 = 1;
  private int S3304 = 1;
  private int S3312 = 1;
  private int S3320 = 1;
  private int S3328 = 1;
  private int S3336 = 1;
  private int S3344 = 1;
  private int S3352 = 1;
  private int S3360 = 1;
  private int S3368 = 1;
  private int S3376 = 1;
  private int S3384 = 1;
  private int S3392 = 1;
  
  private int[] ends = new int[50];
  private int[] tdone = new int[50];
  
  public void thread11137(int [] tdone, int [] ends){
        switch(S3392){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 420, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 420, column: 40
          currsigs.addElement(dosUnitFilledE);
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

  public void thread11136(int [] tdone, int [] ends){
        switch(S3384){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 418, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 418, column: 38
          currsigs.addElement(dosUnitEvacE);
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

  public void thread11135(int [] tdone, int [] ends){
        switch(S3376){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 416, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 416, column: 39
          currsigs.addElement(bottleAtPos2E);
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

  public void thread11134(int [] tdone, int [] ends){
        switch(S3368){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 414, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 414, column: 45
          currsigs.addElement(dosUnitValveExtendE);
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

  public void thread11133(int [] tdone, int [] ends){
        switch(S3360){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 412, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 412, column: 46
          currsigs.addElement(dosUnitValveRetractE);
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

  public void thread11132(int [] tdone, int [] ends){
        switch(S3352){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 410, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 410, column: 42
          currsigs.addElement(valveInletOnOffE);
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

  public void thread11131(int [] tdone, int [] ends){
        switch(S3344){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 408, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 408, column: 45
          currsigs.addElement(valveInjectorOnOffE);
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

  public void thread11130(int [] tdone, int [] ends){
        switch(S3336){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 405, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 405, column: 47
          currsigs.addElement(cylClampBottleExtendE);
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

  public void thread11129(int [] tdone, int [] ends){
        switch(S3328){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 403, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 403, column: 47
          currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread11128(int [] tdone, int [] ends){
        switch(S3320){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 401, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 401, column: 44
          currsigs.addElement(gripperTurnExtendE);
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

  public void thread11127(int [] tdone, int [] ends){
        switch(S3312){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 399, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 399, column: 45
          currsigs.addElement(gripperTurnRetractE);
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

  public void thread11126(int [] tdone, int [] ends){
        switch(S3304){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 397, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 397, column: 45
          currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread11125(int [] tdone, int [] ends){
        switch(S3296){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 395, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 395, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread11124(int [] tdone, int [] ends){
        switch(S3288){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 392, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 392, column: 45
          currsigs.addElement(gripperTurnHomePosE);
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

  public void thread11123(int [] tdone, int [] ends){
        switch(S3280){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 390, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 390, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread11122(int [] tdone, int [] ends){
        switch(S3272){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 388, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 388, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread11121(int [] tdone, int [] ends){
        switch(S3264){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 386, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 386, column: 38
          currsigs.addElement(bottleAtPos2E);
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

  public void thread11120(int [] tdone, int [] ends){
        switch(S3256){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 384, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 384, column: 38
          currsigs.addElement(bottleAtPos4E);
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

  public void thread11119(int [] tdone, int [] ends){
        switch(S3248){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        switch(S3234){
          case 0 : 
            switch(S3232){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 382, column: 54
                  S3232=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 382, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 382, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  S3234=1;
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
            S3234=1;
            S3234=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 382, column: 24
              S3232=0;
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            else {
              S3234=1;
              active[31]=1;
              ends[31]=1;
              tdone[31]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread11118(int [] tdone, int [] ends){
        switch(S3228){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        switch(S3202){
          case 0 : 
            switch(S3200){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 373, column: 11
                  S3200=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 375, column: 6
                  currsigs.addElement(bottleLeftPos5E);
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
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 374, column: 11
                  S3202=1;
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 375, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[30]=1;
                  ends[30]=1;
                  tdone[30]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S3202=1;
            S3202=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 372, column: 12
              S3200=0;
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            else {
              S3202=1;
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread11117(int [] tdone, int [] ends){
        switch(S3190){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 369, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 369, column: 56
          currsigs.addElement(bottleAtPos5E);
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

  public void thread11116(int [] tdone, int [] ends){
        switch(S3182){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S3168){
          case 0 : 
            switch(S3166){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 367, column: 54
                  S3166=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 367, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 367, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  S3168=1;
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
            break;
          
          case 1 : 
            S3168=1;
            S3168=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 367, column: 24
              S3166=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S3168=1;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread11115(int [] tdone, int [] ends){
        switch(S3162){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 365, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 365, column: 44
          currsigs.addElement(rotaryTableTriggerE);
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

  public void thread11114(int [] tdone, int [] ends){
        switch(S3154){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 363, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 363, column: 39
          currsigs.addElement(motConveyorOnE);
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

  public void thread11113(int [] tdone, int [] ends){
        switch(S3146){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 361, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 361, column: 38
          currsigs.addElement(bottleAtPos1E);
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

  public void thread11112(int [] tdone, int [] ends){
        switch(S3394){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        thread11113(tdone,ends);
        thread11114(tdone,ends);
        thread11115(tdone,ends);
        thread11116(tdone,ends);
        thread11117(tdone,ends);
        thread11118(tdone,ends);
        thread11119(tdone,ends);
        thread11120(tdone,ends);
        thread11121(tdone,ends);
        thread11122(tdone,ends);
        thread11123(tdone,ends);
        thread11124(tdone,ends);
        thread11125(tdone,ends);
        thread11126(tdone,ends);
        thread11127(tdone,ends);
        thread11128(tdone,ends);
        thread11129(tdone,ends);
        thread11130(tdone,ends);
        thread11131(tdone,ends);
        thread11132(tdone,ends);
        thread11133(tdone,ends);
        thread11134(tdone,ends);
        thread11135(tdone,ends);
        thread11136(tdone,ends);
        thread11137(tdone,ends);
        int biggest11138 = 0;
        if(ends[25]>=biggest11138){
          biggest11138=ends[25];
        }
        if(ends[26]>=biggest11138){
          biggest11138=ends[26];
        }
        if(ends[27]>=biggest11138){
          biggest11138=ends[27];
        }
        if(ends[28]>=biggest11138){
          biggest11138=ends[28];
        }
        if(ends[29]>=biggest11138){
          biggest11138=ends[29];
        }
        if(ends[30]>=biggest11138){
          biggest11138=ends[30];
        }
        if(ends[31]>=biggest11138){
          biggest11138=ends[31];
        }
        if(ends[32]>=biggest11138){
          biggest11138=ends[32];
        }
        if(ends[33]>=biggest11138){
          biggest11138=ends[33];
        }
        if(ends[34]>=biggest11138){
          biggest11138=ends[34];
        }
        if(ends[35]>=biggest11138){
          biggest11138=ends[35];
        }
        if(ends[36]>=biggest11138){
          biggest11138=ends[36];
        }
        if(ends[37]>=biggest11138){
          biggest11138=ends[37];
        }
        if(ends[38]>=biggest11138){
          biggest11138=ends[38];
        }
        if(ends[39]>=biggest11138){
          biggest11138=ends[39];
        }
        if(ends[40]>=biggest11138){
          biggest11138=ends[40];
        }
        if(ends[41]>=biggest11138){
          biggest11138=ends[41];
        }
        if(ends[42]>=biggest11138){
          biggest11138=ends[42];
        }
        if(ends[43]>=biggest11138){
          biggest11138=ends[43];
        }
        if(ends[44]>=biggest11138){
          biggest11138=ends[44];
        }
        if(ends[45]>=biggest11138){
          biggest11138=ends[45];
        }
        if(ends[46]>=biggest11138){
          biggest11138=ends[46];
        }
        if(ends[47]>=biggest11138){
          biggest11138=ends[47];
        }
        if(ends[48]>=biggest11138){
          biggest11138=ends[48];
        }
        if(ends[49]>=biggest11138){
          biggest11138=ends[49];
        }
        if(biggest11138 == 1){
          active[24]=1;
          ends[24]=1;
          tdone[24]=1;
        }
        //FINXME code
        if(biggest11138 == 0){
          S3394=0;
          active[24]=0;
          ends[24]=0;
          tdone[24]=1;
        }
        break;
      
    }
  }

  public void thread11111(int [] tdone, int [] ends){
        switch(S3138){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S3067){
          case 0 : 
            S3067=0;
            S3067=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 339, column: 12
              S3054=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S3067=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S3054){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 340, column: 11
                  S3054=1;
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 342, column: 6
                  currsigs.addElement(dosUnitFilled);
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
                if(!dosUnitValveRetract.getprestatus() && dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 341, column: 11
                  S3067=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 342, column: 6
                  currsigs.addElement(dosUnitFilled);
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

  public void thread11110(int [] tdone, int [] ends){
        switch(S3044){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S3043){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 322, column: 9
              S3043=1;
              S2881=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 323, column: 4
              currsigs.addElement(dosUnitEvac);
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            switch(S2881){
              case 0 : 
                S2881=0;
                S2881=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 327, column: 12
                  S2868=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                else {
                  S2881=0;
                  active[22]=1;
                  ends[22]=1;
                  tdone[22]=1;
                }
                break;
              
              case 1 : 
                switch(S2868){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 328, column: 11
                      S2868=1;
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 330, column: 6
                      currsigs.addElement(dosUnitEvac);
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
                    if(!dosUnitValveExtend.getprestatus() && dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 329, column: 11
                      S2881=0;
                      active[22]=1;
                      ends[22]=1;
                      tdone[22]=1;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 330, column: 6
                      currsigs.addElement(dosUnitEvac);
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
        break;
      
    }
  }

  public void thread11109(int [] tdone, int [] ends){
        switch(S2854){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S2819){
          case 0 : 
            S2819=0;
            S2819=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 310, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 312, column: 6
              currsigs.addElement(gripperZAxisLifted);
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S2819=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 311, column: 11
              S2819=0;
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

  public void thread11108(int [] tdone, int [] ends){
        switch(S2808){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2737){
          case 0 : 
            S2737=0;
            S2737=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 298, column: 12
              S2724=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S2737=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S2724){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 299, column: 11
                  S2724=1;
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
                  S2737=0;
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

  public void thread11107(int [] tdone, int [] ends){
        switch(S2714){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2643){
          case 0 : 
            S2643=0;
            S2643=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 286, column: 12
              S2630=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S2643=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S2630){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 287, column: 11
                  S2630=1;
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
                  S2643=0;
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

  public void thread11106(int [] tdone, int [] ends){
        switch(S2620){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S2549){
          case 0 : 
            S2549=0;
            S2549=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 274, column: 12
              S2536=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S2549=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            switch(S2536){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 275, column: 11
                  S2536=1;
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
                  S2549=0;
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

  public void thread11105(int [] tdone, int [] ends){
        switch(S2526){
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

  public void thread11104(int [] tdone, int [] ends){
        switch(S2524){
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

  public void thread11103(int [] tdone, int [] ends){
        switch(S2522){
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

  public void thread11102(int [] tdone, int [] ends){
        switch(S2520){
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

  public void thread11101(int [] tdone, int [] ends){
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

  public void thread11100(int [] tdone, int [] ends){
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

  public void thread11099(int [] tdone, int [] ends){
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

  public void thread11098(int [] tdone, int [] ends){
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

  public void thread11097(int [] tdone, int [] ends){
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

  public void thread11096(int [] tdone, int [] ends){
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

  public void thread11095(int [] tdone, int [] ends){
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

  public void thread11094(int [] tdone, int [] ends){
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

  public void thread11093(int [] tdone, int [] ends){
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

  public void thread11092(int [] tdone, int [] ends){
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

  public void thread11091(int [] tdone, int [] ends){
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

  public void thread11090(int [] tdone, int [] ends){
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

  public void thread11087(int [] tdone, int [] ends){
        S3392=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 420, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 420, column: 40
      currsigs.addElement(dosUnitFilledE);
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

  public void thread11086(int [] tdone, int [] ends){
        S3384=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 418, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 418, column: 38
      currsigs.addElement(dosUnitEvacE);
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

  public void thread11085(int [] tdone, int [] ends){
        S3376=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 416, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 416, column: 39
      currsigs.addElement(bottleAtPos2E);
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

  public void thread11084(int [] tdone, int [] ends){
        S3368=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 414, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 414, column: 45
      currsigs.addElement(dosUnitValveExtendE);
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

  public void thread11083(int [] tdone, int [] ends){
        S3360=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 412, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 412, column: 46
      currsigs.addElement(dosUnitValveRetractE);
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

  public void thread11082(int [] tdone, int [] ends){
        S3352=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 410, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 410, column: 42
      currsigs.addElement(valveInletOnOffE);
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

  public void thread11081(int [] tdone, int [] ends){
        S3344=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 408, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 408, column: 45
      currsigs.addElement(valveInjectorOnOffE);
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

  public void thread11080(int [] tdone, int [] ends){
        S3336=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 405, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 405, column: 47
      currsigs.addElement(cylClampBottleExtendE);
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

  public void thread11079(int [] tdone, int [] ends){
        S3328=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 403, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 403, column: 47
      currsigs.addElement(capGripperPos5ExtendE);
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

  public void thread11078(int [] tdone, int [] ends){
        S3320=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 401, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 401, column: 44
      currsigs.addElement(gripperTurnExtendE);
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

  public void thread11077(int [] tdone, int [] ends){
        S3312=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 399, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 399, column: 45
      currsigs.addElement(gripperTurnRetractE);
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

  public void thread11076(int [] tdone, int [] ends){
        S3304=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 397, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 397, column: 45
      currsigs.addElement(cylPos5ZaxisExtendE);
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

  public void thread11075(int [] tdone, int [] ends){
        S3296=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 395, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 395, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
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

  public void thread11074(int [] tdone, int [] ends){
        S3288=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 392, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 392, column: 45
      currsigs.addElement(gripperTurnHomePosE);
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

  public void thread11073(int [] tdone, int [] ends){
        S3280=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 390, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 390, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
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

  public void thread11072(int [] tdone, int [] ends){
        S3272=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 388, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 388, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
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

  public void thread11071(int [] tdone, int [] ends){
        S3264=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 386, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 386, column: 38
      currsigs.addElement(bottleAtPos2E);
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

  public void thread11070(int [] tdone, int [] ends){
        S3256=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 384, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 384, column: 38
      currsigs.addElement(bottleAtPos4E);
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

  public void thread11069(int [] tdone, int [] ends){
        S3248=1;
    S3234=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 382, column: 24
      S3232=0;
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
    else {
      S3234=1;
      active[31]=1;
      ends[31]=1;
      tdone[31]=1;
    }
  }

  public void thread11068(int [] tdone, int [] ends){
        S3228=1;
    S3202=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 372, column: 12
      S3200=0;
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
    else {
      S3202=1;
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
  }

  public void thread11067(int [] tdone, int [] ends){
        S3190=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 369, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 369, column: 56
      currsigs.addElement(bottleAtPos5E);
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

  public void thread11066(int [] tdone, int [] ends){
        S3182=1;
    S3168=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 367, column: 24
      S3166=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      S3168=1;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread11065(int [] tdone, int [] ends){
        S3162=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 365, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 365, column: 44
      currsigs.addElement(rotaryTableTriggerE);
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

  public void thread11064(int [] tdone, int [] ends){
        S3154=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 363, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 363, column: 39
      currsigs.addElement(motConveyorOnE);
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

  public void thread11063(int [] tdone, int [] ends){
        S3146=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 361, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 361, column: 38
      currsigs.addElement(bottleAtPos1E);
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

  public void thread11062(int [] tdone, int [] ends){
        S3394=1;
    thread11063(tdone,ends);
    thread11064(tdone,ends);
    thread11065(tdone,ends);
    thread11066(tdone,ends);
    thread11067(tdone,ends);
    thread11068(tdone,ends);
    thread11069(tdone,ends);
    thread11070(tdone,ends);
    thread11071(tdone,ends);
    thread11072(tdone,ends);
    thread11073(tdone,ends);
    thread11074(tdone,ends);
    thread11075(tdone,ends);
    thread11076(tdone,ends);
    thread11077(tdone,ends);
    thread11078(tdone,ends);
    thread11079(tdone,ends);
    thread11080(tdone,ends);
    thread11081(tdone,ends);
    thread11082(tdone,ends);
    thread11083(tdone,ends);
    thread11084(tdone,ends);
    thread11085(tdone,ends);
    thread11086(tdone,ends);
    thread11087(tdone,ends);
    int biggest11088 = 0;
    if(ends[25]>=biggest11088){
      biggest11088=ends[25];
    }
    if(ends[26]>=biggest11088){
      biggest11088=ends[26];
    }
    if(ends[27]>=biggest11088){
      biggest11088=ends[27];
    }
    if(ends[28]>=biggest11088){
      biggest11088=ends[28];
    }
    if(ends[29]>=biggest11088){
      biggest11088=ends[29];
    }
    if(ends[30]>=biggest11088){
      biggest11088=ends[30];
    }
    if(ends[31]>=biggest11088){
      biggest11088=ends[31];
    }
    if(ends[32]>=biggest11088){
      biggest11088=ends[32];
    }
    if(ends[33]>=biggest11088){
      biggest11088=ends[33];
    }
    if(ends[34]>=biggest11088){
      biggest11088=ends[34];
    }
    if(ends[35]>=biggest11088){
      biggest11088=ends[35];
    }
    if(ends[36]>=biggest11088){
      biggest11088=ends[36];
    }
    if(ends[37]>=biggest11088){
      biggest11088=ends[37];
    }
    if(ends[38]>=biggest11088){
      biggest11088=ends[38];
    }
    if(ends[39]>=biggest11088){
      biggest11088=ends[39];
    }
    if(ends[40]>=biggest11088){
      biggest11088=ends[40];
    }
    if(ends[41]>=biggest11088){
      biggest11088=ends[41];
    }
    if(ends[42]>=biggest11088){
      biggest11088=ends[42];
    }
    if(ends[43]>=biggest11088){
      biggest11088=ends[43];
    }
    if(ends[44]>=biggest11088){
      biggest11088=ends[44];
    }
    if(ends[45]>=biggest11088){
      biggest11088=ends[45];
    }
    if(ends[46]>=biggest11088){
      biggest11088=ends[46];
    }
    if(ends[47]>=biggest11088){
      biggest11088=ends[47];
    }
    if(ends[48]>=biggest11088){
      biggest11088=ends[48];
    }
    if(ends[49]>=biggest11088){
      biggest11088=ends[49];
    }
    if(biggest11088 == 1){
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
  }

  public void thread11061(int [] tdone, int [] ends){
        S3138=1;
    S3067=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread11060(int [] tdone, int [] ends){
        S3044=1;
    S3043=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 323, column: 4
    currsigs.addElement(dosUnitEvac);
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread11059(int [] tdone, int [] ends){
        S2854=1;
    S2819=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread11058(int [] tdone, int [] ends){
        S2808=1;
    S2737=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread11057(int [] tdone, int [] ends){
        S2714=1;
    S2643=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread11056(int [] tdone, int [] ends){
        S2620=1;
    S2549=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread11055(int [] tdone, int [] ends){
        S2526=1;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread11054(int [] tdone, int [] ends){
        S2524=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread11053(int [] tdone, int [] ends){
        S2522=1;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread11052(int [] tdone, int [] ends){
        S2520=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 230, column: 3
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread11051(int [] tdone, int [] ends){
        S2517=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 202, column: 3
    S1484=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread11050(int [] tdone, int [] ends){
        S1459=1;
    S1436=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread11049(int [] tdone, int [] ends){
        S1429=1;
    S1364=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread11048(int [] tdone, int [] ends){
        S1343=1;
    S1278=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread11047(int [] tdone, int [] ends){
        S1257=1;
    S1222=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread11046(int [] tdone, int [] ends){
        S1211=1;
    S1176=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread11045(int [] tdone, int [] ends){
        S1165=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 131, column: 3
    S1133=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread11044(int [] tdone, int [] ends){
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

  public void thread11043(int [] tdone, int [] ends){
        S1067=1;
    S1021=0;
    S1003=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread11042(int [] tdone, int [] ends){
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

  public void thread11041(int [] tdone, int [] ends){
        S955=1;
    S909=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 62, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread11040(int [] tdone, int [] ends){
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
      switch(S11038){
        case 0 : 
          S11038=0;
          break RUN;
        
        case 1 : 
          S11038=2;
          S11038=2;
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
          thread11040(tdone,ends);
          thread11041(tdone,ends);
          thread11042(tdone,ends);
          thread11043(tdone,ends);
          thread11044(tdone,ends);
          thread11045(tdone,ends);
          thread11046(tdone,ends);
          thread11047(tdone,ends);
          thread11048(tdone,ends);
          thread11049(tdone,ends);
          thread11050(tdone,ends);
          thread11051(tdone,ends);
          thread11052(tdone,ends);
          thread11053(tdone,ends);
          thread11054(tdone,ends);
          thread11055(tdone,ends);
          thread11056(tdone,ends);
          thread11057(tdone,ends);
          thread11058(tdone,ends);
          thread11059(tdone,ends);
          thread11060(tdone,ends);
          thread11061(tdone,ends);
          thread11062(tdone,ends);
          int biggest11089 = 0;
          if(ends[2]>=biggest11089){
            biggest11089=ends[2];
          }
          if(ends[3]>=biggest11089){
            biggest11089=ends[3];
          }
          if(ends[4]>=biggest11089){
            biggest11089=ends[4];
          }
          if(ends[5]>=biggest11089){
            biggest11089=ends[5];
          }
          if(ends[6]>=biggest11089){
            biggest11089=ends[6];
          }
          if(ends[7]>=biggest11089){
            biggest11089=ends[7];
          }
          if(ends[8]>=biggest11089){
            biggest11089=ends[8];
          }
          if(ends[9]>=biggest11089){
            biggest11089=ends[9];
          }
          if(ends[10]>=biggest11089){
            biggest11089=ends[10];
          }
          if(ends[11]>=biggest11089){
            biggest11089=ends[11];
          }
          if(ends[12]>=biggest11089){
            biggest11089=ends[12];
          }
          if(ends[13]>=biggest11089){
            biggest11089=ends[13];
          }
          if(ends[14]>=biggest11089){
            biggest11089=ends[14];
          }
          if(ends[15]>=biggest11089){
            biggest11089=ends[15];
          }
          if(ends[16]>=biggest11089){
            biggest11089=ends[16];
          }
          if(ends[17]>=biggest11089){
            biggest11089=ends[17];
          }
          if(ends[18]>=biggest11089){
            biggest11089=ends[18];
          }
          if(ends[19]>=biggest11089){
            biggest11089=ends[19];
          }
          if(ends[20]>=biggest11089){
            biggest11089=ends[20];
          }
          if(ends[21]>=biggest11089){
            biggest11089=ends[21];
          }
          if(ends[22]>=biggest11089){
            biggest11089=ends[22];
          }
          if(ends[23]>=biggest11089){
            biggest11089=ends[23];
          }
          if(ends[24]>=biggest11089){
            biggest11089=ends[24];
          }
          if(biggest11089 == 1){
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
          thread11090(tdone,ends);
          thread11091(tdone,ends);
          thread11092(tdone,ends);
          thread11093(tdone,ends);
          thread11094(tdone,ends);
          thread11095(tdone,ends);
          thread11096(tdone,ends);
          thread11097(tdone,ends);
          thread11098(tdone,ends);
          thread11099(tdone,ends);
          thread11100(tdone,ends);
          thread11101(tdone,ends);
          thread11102(tdone,ends);
          thread11103(tdone,ends);
          thread11104(tdone,ends);
          thread11105(tdone,ends);
          thread11106(tdone,ends);
          thread11107(tdone,ends);
          thread11108(tdone,ends);
          thread11109(tdone,ends);
          thread11110(tdone,ends);
          thread11111(tdone,ends);
          thread11112(tdone,ends);
          int biggest11139 = 0;
          if(ends[2]>=biggest11139){
            biggest11139=ends[2];
          }
          if(ends[3]>=biggest11139){
            biggest11139=ends[3];
          }
          if(ends[4]>=biggest11139){
            biggest11139=ends[4];
          }
          if(ends[5]>=biggest11139){
            biggest11139=ends[5];
          }
          if(ends[6]>=biggest11139){
            biggest11139=ends[6];
          }
          if(ends[7]>=biggest11139){
            biggest11139=ends[7];
          }
          if(ends[8]>=biggest11139){
            biggest11139=ends[8];
          }
          if(ends[9]>=biggest11139){
            biggest11139=ends[9];
          }
          if(ends[10]>=biggest11139){
            biggest11139=ends[10];
          }
          if(ends[11]>=biggest11139){
            biggest11139=ends[11];
          }
          if(ends[12]>=biggest11139){
            biggest11139=ends[12];
          }
          if(ends[13]>=biggest11139){
            biggest11139=ends[13];
          }
          if(ends[14]>=biggest11139){
            biggest11139=ends[14];
          }
          if(ends[15]>=biggest11139){
            biggest11139=ends[15];
          }
          if(ends[16]>=biggest11139){
            biggest11139=ends[16];
          }
          if(ends[17]>=biggest11139){
            biggest11139=ends[17];
          }
          if(ends[18]>=biggest11139){
            biggest11139=ends[18];
          }
          if(ends[19]>=biggest11139){
            biggest11139=ends[19];
          }
          if(ends[20]>=biggest11139){
            biggest11139=ends[20];
          }
          if(ends[21]>=biggest11139){
            biggest11139=ends[21];
          }
          if(ends[22]>=biggest11139){
            biggest11139=ends[22];
          }
          if(ends[23]>=biggest11139){
            biggest11139=ends[23];
          }
          if(ends[24]>=biggest11139){
            biggest11139=ends[24];
          }
          if(biggest11139 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest11139 == 0){
            S11038=0;
            active[1]=0;
            ends[1]=0;
            S11038=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
