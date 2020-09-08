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
  private Signal capDec_1;
  private Signal l_bottleAdded_1;
  private Signal l_putBottleAt5_1;
  private Signal l_putBottleAt4_1;
  private Signal l_putBottleAt2_1;
  private Signal capPos_1;
  private Signal s_motConveyorOn_1;
  private Signal s_valveInjectorOnOff_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 113, column: 3
  private int numTurns_thread_13;//sysj\plant.sysj line: 203, column: 3
  private int nozzlenum_thread_25;//sysj\plant.sysj line: 360, column: 3
  private int S12992 = 1;
  private int S912 = 1;
  private int S866 = 1;
  private int S965 = 1;
  private int S919 = 1;
  private int S1009 = 1;
  private int S979 = 1;
  private int S974 = 1;
  private int S1077 = 1;
  private int S1031 = 1;
  private int S1013 = 1;
  private int S1139 = 1;
  private int S1175 = 1;
  private int S1143 = 1;
  private int S1221 = 1;
  private int S1186 = 1;
  private int S1267 = 1;
  private int S1232 = 1;
  private int S1353 = 1;
  private int S1288 = 1;
  private int S1275 = 1;
  private int S1439 = 1;
  private int S1374 = 1;
  private int S1361 = 1;
  private int S1469 = 1;
  private int S1446 = 1;
  private int S2527 = 1;
  private int S1494 = 1;
  private int S1480 = 1;
  private int S2529 = 1;
  private int S2532 = 1;
  private int S2534 = 1;
  private int S2536 = 1;
  private int S2538 = 1;
  private int S2632 = 1;
  private int S2561 = 1;
  private int S2548 = 1;
  private int S2726 = 1;
  private int S2655 = 1;
  private int S2642 = 1;
  private int S2820 = 1;
  private int S2749 = 1;
  private int S2736 = 1;
  private int S2866 = 1;
  private int S2831 = 1;
  private int S3056 = 1;
  private int S3055 = 1;
  private int S2893 = 1;
  private int S2880 = 1;
  private int S3150 = 1;
  private int S3079 = 1;
  private int S3066 = 1;
  private int S3602 = 1;
  private int S3175 = 1;
  private int S3161 = 1;
  private int S3890 = 1;
  private int S3610 = 1;
  private int S3618 = 1;
  private int S3626 = 1;
  private int S3646 = 1;
  private int S3632 = 1;
  private int S3630 = 1;
  private int S3654 = 1;
  private int S3692 = 1;
  private int S3666 = 1;
  private int S3664 = 1;
  private int S3712 = 1;
  private int S3698 = 1;
  private int S3696 = 1;
  private int S3720 = 1;
  private int S3728 = 1;
  private int S3736 = 1;
  private int S3744 = 1;
  private int S3752 = 1;
  private int S3760 = 1;
  private int S3768 = 1;
  private int S3776 = 1;
  private int S3784 = 1;
  private int S3792 = 1;
  private int S3800 = 1;
  private int S3808 = 1;
  private int S3816 = 1;
  private int S3824 = 1;
  private int S3832 = 1;
  private int S3840 = 1;
  private int S3848 = 1;
  private int S3856 = 1;
  private int S3864 = 1;
  private int S3872 = 1;
  private int S3880 = 1;
  private int S3888 = 1;
  
  private int[] ends = new int[56];
  private int[] tdone = new int[56];
  
  public void thread13103(int [] tdone, int [] ends){
        switch(S3888){
      case 0 : 
        active[55]=0;
        ends[55]=0;
        tdone[55]=1;
        break;
      
      case 1 : 
        if(selNoz4.getprestatus()){//sysj\plant.sysj line: 462, column: 25
          o_selNoz4.setPresent();//sysj\plant.sysj line: 462, column: 34
          currsigs.addElement(o_selNoz4);
          System.out.println("Emitted o_selNoz4");
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

  public void thread13102(int [] tdone, int [] ends){
        switch(S3880){
      case 0 : 
        active[54]=0;
        ends[54]=0;
        tdone[54]=1;
        break;
      
      case 1 : 
        if(selNoz3.getprestatus()){//sysj\plant.sysj line: 460, column: 25
          o_selNoz3.setPresent();//sysj\plant.sysj line: 460, column: 34
          currsigs.addElement(o_selNoz3);
          System.out.println("Emitted o_selNoz3");
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

  public void thread13101(int [] tdone, int [] ends){
        switch(S3872){
      case 0 : 
        active[53]=0;
        ends[53]=0;
        tdone[53]=1;
        break;
      
      case 1 : 
        if(selNoz2.getprestatus()){//sysj\plant.sysj line: 458, column: 25
          o_selNoz2.setPresent();//sysj\plant.sysj line: 458, column: 34
          currsigs.addElement(o_selNoz2);
          System.out.println("Emitted o_selNoz2");
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

  public void thread13100(int [] tdone, int [] ends){
        switch(S3864){
      case 0 : 
        active[52]=0;
        ends[52]=0;
        tdone[52]=1;
        break;
      
      case 1 : 
        if(selNoz1.getprestatus()){//sysj\plant.sysj line: 456, column: 25
          o_selNoz1.setPresent();//sysj\plant.sysj line: 456, column: 34
          currsigs.addElement(o_selNoz1);
          System.out.println("Emitted o_selNoz1");
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

  public void thread13099(int [] tdone, int [] ends){
        switch(S3856){
      case 0 : 
        active[51]=0;
        ends[51]=0;
        tdone[51]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 454, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 454, column: 40
          currsigs.addElement(dosUnitFilledE);
          System.out.println("Emitted dosUnitFilledE");
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

  public void thread13098(int [] tdone, int [] ends){
        switch(S3848){
      case 0 : 
        active[50]=0;
        ends[50]=0;
        tdone[50]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 452, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 452, column: 38
          currsigs.addElement(dosUnitEvacE);
          System.out.println("Emitted dosUnitEvacE");
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

  public void thread13097(int [] tdone, int [] ends){
        switch(S3840){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 450, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 450, column: 39
          currsigs.addElement(bottleAtPos2E);
          System.out.println("Emitted bottleAtPos2E");
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

  public void thread13096(int [] tdone, int [] ends){
        switch(S3832){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 448, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 448, column: 45
          currsigs.addElement(dosUnitValveExtendE);
          System.out.println("Emitted dosUnitValveExtendE");
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

  public void thread13095(int [] tdone, int [] ends){
        switch(S3824){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 446, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 446, column: 46
          currsigs.addElement(dosUnitValveRetractE);
          System.out.println("Emitted dosUnitValveRetractE");
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

  public void thread13094(int [] tdone, int [] ends){
        switch(S3816){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 444, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 444, column: 42
          currsigs.addElement(valveInletOnOffE);
          System.out.println("Emitted valveInletOnOffE");
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

  public void thread13093(int [] tdone, int [] ends){
        switch(S3808){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 442, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 442, column: 45
          currsigs.addElement(valveInjectorOnOffE);
          System.out.println("Emitted valveInjectorOnOffE");
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

  public void thread13092(int [] tdone, int [] ends){
        switch(S3800){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 439, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 439, column: 47
          currsigs.addElement(cylClampBottleExtendE);
          System.out.println("Emitted cylClampBottleExtendE");
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

  public void thread13091(int [] tdone, int [] ends){
        switch(S3792){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 437, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 437, column: 47
          currsigs.addElement(capGripperPos5ExtendE);
          System.out.println("Emitted capGripperPos5ExtendE");
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

  public void thread13090(int [] tdone, int [] ends){
        switch(S3784){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 435, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 435, column: 44
          currsigs.addElement(gripperTurnExtendE);
          System.out.println("Emitted gripperTurnExtendE");
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

  public void thread13089(int [] tdone, int [] ends){
        switch(S3776){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 433, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 433, column: 45
          currsigs.addElement(gripperTurnRetractE);
          System.out.println("Emitted gripperTurnRetractE");
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

  public void thread13088(int [] tdone, int [] ends){
        switch(S3768){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 431, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 431, column: 45
          currsigs.addElement(cylPos5ZaxisExtendE);
          System.out.println("Emitted cylPos5ZaxisExtendE");
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

  public void thread13087(int [] tdone, int [] ends){
        switch(S3760){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 429, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 429, column: 45
          currsigs.addElement(gripperZAxisLiftedE);
          System.out.println("Emitted gripperZAxisLiftedE");
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

  public void thread13086(int [] tdone, int [] ends){
        switch(S3752){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 426, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 426, column: 45
          currsigs.addElement(gripperTurnHomePosE);
          System.out.println("Emitted gripperTurnHomePosE");
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

  public void thread13085(int [] tdone, int [] ends){
        switch(S3744){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 424, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 424, column: 46
          currsigs.addElement(gripperTurnFinalPosE);
          System.out.println("Emitted gripperTurnFinalPosE");
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

  public void thread13084(int [] tdone, int [] ends){
        switch(S3736){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 422, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 422, column: 46
          currsigs.addElement(gripperZAxisLoweredE);
          System.out.println("Emitted gripperZAxisLoweredE");
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

  public void thread13083(int [] tdone, int [] ends){
        switch(S3728){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 420, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 420, column: 38
          currsigs.addElement(bottleAtPos2E);
          System.out.println("Emitted bottleAtPos2E");
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

  public void thread13082(int [] tdone, int [] ends){
        switch(S3720){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 418, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 418, column: 38
          currsigs.addElement(bottleAtPos4E);
          System.out.println("Emitted bottleAtPos4E");
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

  public void thread13081(int [] tdone, int [] ends){
        switch(S3712){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        switch(S3698){
          case 0 : 
            switch(S3696){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 416, column: 54
                  S3696=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 416, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 416, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  System.out.println("Emitted bottleAtPos5_RT");
                  S3698=1;
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
            break;
          
          case 1 : 
            S3698=1;
            S3698=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 416, column: 24
              S3696=0;
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            else {
              S3698=1;
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread13080(int [] tdone, int [] ends){
        switch(S3692){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        switch(S3666){
          case 0 : 
            switch(S3664){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 407, column: 11
                  S3664=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 409, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  System.out.println("Emitted bottleLeftPos5E");
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 408, column: 11
                  S3666=1;
                  active[32]=1;
                  ends[32]=1;
                  tdone[32]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 409, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  System.out.println("Emitted bottleLeftPos5E");
                  active[32]=1;
                  ends[32]=1;
                  tdone[32]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S3666=1;
            S3666=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 406, column: 12
              S3664=0;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            else {
              S3666=1;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread13079(int [] tdone, int [] ends){
        switch(S3654){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 403, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 403, column: 56
          currsigs.addElement(bottleAtPos5E);
          System.out.println("Emitted bottleAtPos5E");
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

  public void thread13078(int [] tdone, int [] ends){
        switch(S3646){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        switch(S3632){
          case 0 : 
            switch(S3630){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 401, column: 54
                  S3630=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 401, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 401, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  System.out.println("Emitted bottleAtPos1_RT");
                  S3632=1;
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
            break;
          
          case 1 : 
            S3632=1;
            S3632=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 401, column: 24
              S3630=0;
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            else {
              S3632=1;
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread13077(int [] tdone, int [] ends){
        switch(S3626){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 399, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 399, column: 44
          currsigs.addElement(rotaryTableTriggerE);
          System.out.println("Emitted rotaryTableTriggerE");
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

  public void thread13076(int [] tdone, int [] ends){
        switch(S3618){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 397, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 397, column: 39
          currsigs.addElement(motConveyorOnE);
          System.out.println("Emitted motConveyorOnE");
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

  public void thread13075(int [] tdone, int [] ends){
        switch(S3610){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 395, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 395, column: 38
          currsigs.addElement(bottleAtPos1E);
          System.out.println("Emitted bottleAtPos1E");
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

  public void thread13074(int [] tdone, int [] ends){
        switch(S3890){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        thread13075(tdone,ends);
        thread13076(tdone,ends);
        thread13077(tdone,ends);
        thread13078(tdone,ends);
        thread13079(tdone,ends);
        thread13080(tdone,ends);
        thread13081(tdone,ends);
        thread13082(tdone,ends);
        thread13083(tdone,ends);
        thread13084(tdone,ends);
        thread13085(tdone,ends);
        thread13086(tdone,ends);
        thread13087(tdone,ends);
        thread13088(tdone,ends);
        thread13089(tdone,ends);
        thread13090(tdone,ends);
        thread13091(tdone,ends);
        thread13092(tdone,ends);
        thread13093(tdone,ends);
        thread13094(tdone,ends);
        thread13095(tdone,ends);
        thread13096(tdone,ends);
        thread13097(tdone,ends);
        thread13098(tdone,ends);
        thread13099(tdone,ends);
        thread13100(tdone,ends);
        thread13101(tdone,ends);
        thread13102(tdone,ends);
        thread13103(tdone,ends);
        int biggest13104 = 0;
        if(ends[27]>=biggest13104){
          biggest13104=ends[27];
        }
        if(ends[28]>=biggest13104){
          biggest13104=ends[28];
        }
        if(ends[29]>=biggest13104){
          biggest13104=ends[29];
        }
        if(ends[30]>=biggest13104){
          biggest13104=ends[30];
        }
        if(ends[31]>=biggest13104){
          biggest13104=ends[31];
        }
        if(ends[32]>=biggest13104){
          biggest13104=ends[32];
        }
        if(ends[33]>=biggest13104){
          biggest13104=ends[33];
        }
        if(ends[34]>=biggest13104){
          biggest13104=ends[34];
        }
        if(ends[35]>=biggest13104){
          biggest13104=ends[35];
        }
        if(ends[36]>=biggest13104){
          biggest13104=ends[36];
        }
        if(ends[37]>=biggest13104){
          biggest13104=ends[37];
        }
        if(ends[38]>=biggest13104){
          biggest13104=ends[38];
        }
        if(ends[39]>=biggest13104){
          biggest13104=ends[39];
        }
        if(ends[40]>=biggest13104){
          biggest13104=ends[40];
        }
        if(ends[41]>=biggest13104){
          biggest13104=ends[41];
        }
        if(ends[42]>=biggest13104){
          biggest13104=ends[42];
        }
        if(ends[43]>=biggest13104){
          biggest13104=ends[43];
        }
        if(ends[44]>=biggest13104){
          biggest13104=ends[44];
        }
        if(ends[45]>=biggest13104){
          biggest13104=ends[45];
        }
        if(ends[46]>=biggest13104){
          biggest13104=ends[46];
        }
        if(ends[47]>=biggest13104){
          biggest13104=ends[47];
        }
        if(ends[48]>=biggest13104){
          biggest13104=ends[48];
        }
        if(ends[49]>=biggest13104){
          biggest13104=ends[49];
        }
        if(ends[50]>=biggest13104){
          biggest13104=ends[50];
        }
        if(ends[51]>=biggest13104){
          biggest13104=ends[51];
        }
        if(ends[52]>=biggest13104){
          biggest13104=ends[52];
        }
        if(ends[53]>=biggest13104){
          biggest13104=ends[53];
        }
        if(ends[54]>=biggest13104){
          biggest13104=ends[54];
        }
        if(ends[55]>=biggest13104){
          biggest13104=ends[55];
        }
        if(biggest13104 == 1){
          active[26]=1;
          ends[26]=1;
          tdone[26]=1;
        }
        //FINXME code
        if(biggest13104 == 0){
          S3890=0;
          active[26]=0;
          ends[26]=0;
          tdone[26]=1;
        }
        break;
      
    }
  }

  public void thread13073(int [] tdone, int [] ends){
        switch(S3602){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S3175){
          case 0 : 
            S3175=0;
            S3175=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 364, column: 13
              S3161=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S3175=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            if(!turnNozTrigger.getprestatus()){//sysj\plant.sysj line: 363, column: 10
              S3175=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              switch(S3161){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 365, column: 12
                    nozzlenum_thread_25 = nozzlenum_thread_25 + 1;//sysj\plant.sysj line: 366, column: 6
                    if(nozzlenum_thread_25 == 1){//sysj\plant.sysj line: 367, column: 9
                      noz1.setPresent();//sysj\plant.sysj line: 368, column: 7
                      currsigs.addElement(noz1);
                      System.out.println("Emitted noz1");
                      S3175=0;
                      active[25]=1;
                      ends[25]=1;
                      tdone[25]=1;
                    }
                    else {
                      if(nozzlenum_thread_25 == 2){//sysj\plant.sysj line: 369, column: 15
                        noz2.setPresent();//sysj\plant.sysj line: 370, column: 7
                        currsigs.addElement(noz2);
                        System.out.println("Emitted noz2");
                        S3175=0;
                        active[25]=1;
                        ends[25]=1;
                        tdone[25]=1;
                      }
                      else {
                        if(nozzlenum_thread_25 == 3){//sysj\plant.sysj line: 371, column: 15
                          noz3.setPresent();//sysj\plant.sysj line: 372, column: 7
                          currsigs.addElement(noz3);
                          System.out.println("Emitted noz3");
                          S3175=0;
                          active[25]=1;
                          ends[25]=1;
                          tdone[25]=1;
                        }
                        else {
                          noz4.setPresent();//sysj\plant.sysj line: 374, column: 7
                          currsigs.addElement(noz4);
                          System.out.println("Emitted noz4");
                          nozzlenum_thread_25 = 0;//sysj\plant.sysj line: 375, column: 7
                          S3175=0;
                          active[25]=1;
                          ends[25]=1;
                          tdone[25]=1;
                        }
                      }
                    }
                  }
                  else {
                    active[25]=1;
                    ends[25]=1;
                    tdone[25]=1;
                  }
                  break;
                
                case 1 : 
                  S3175=0;
                  active[25]=1;
                  ends[25]=1;
                  tdone[25]=1;
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread13072(int [] tdone, int [] ends){
        switch(S3150){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S3079){
          case 0 : 
            S3079=0;
            S3079=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 349, column: 12
              S3066=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S3079=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            switch(S3066){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 350, column: 11
                  S3066=1;
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 352, column: 6
                  currsigs.addElement(dosUnitFilled);
                  System.out.println("Emitted dosUnitFilled");
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
                if(!dosUnitValveRetract.getprestatus() && dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 351, column: 11
                  S3079=0;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 352, column: 6
                  currsigs.addElement(dosUnitFilled);
                  System.out.println("Emitted dosUnitFilled");
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

  public void thread13071(int [] tdone, int [] ends){
        switch(S3056){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S3055){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 332, column: 9
              S3055=1;
              S2893=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 333, column: 4
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S2893){
              case 0 : 
                S2893=0;
                S2893=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 337, column: 12
                  S2880=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  S2893=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
              case 1 : 
                switch(S2880){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 338, column: 11
                      S2880=1;
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 340, column: 6
                      currsigs.addElement(dosUnitEvac);
                      System.out.println("Emitted dosUnitEvac");
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
                    if(!dosUnitValveExtend.getprestatus() && dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 339, column: 11
                      S2893=0;
                      active[23]=1;
                      ends[23]=1;
                      tdone[23]=1;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 340, column: 6
                      currsigs.addElement(dosUnitEvac);
                      System.out.println("Emitted dosUnitEvac");
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

  public void thread13070(int [] tdone, int [] ends){
        switch(S2866){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S2831){
          case 0 : 
            S2831=0;
            S2831=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 320, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 322, column: 6
              currsigs.addElement(gripperZAxisLifted);
              System.out.println("Emitted gripperZAxisLifted");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S2831=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 321, column: 11
              S2831=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 322, column: 6
              currsigs.addElement(gripperZAxisLifted);
              System.out.println("Emitted gripperZAxisLifted");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread13069(int [] tdone, int [] ends){
        switch(S2820){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S2749){
          case 0 : 
            S2749=0;
            S2749=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 308, column: 12
              S2736=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S2749=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S2736){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 309, column: 11
                  S2736=1;
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 311, column: 6
                  currsigs.addElement(gripperTurnHomePos);
                  System.out.println("Emitted gripperTurnHomePos");
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
                if(!gripperTurnRetract.getprestatus() && gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 310, column: 11
                  S2749=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 311, column: 6
                  currsigs.addElement(gripperTurnHomePos);
                  System.out.println("Emitted gripperTurnHomePos");
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

  public void thread13068(int [] tdone, int [] ends){
        switch(S2726){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2655){
          case 0 : 
            S2655=0;
            S2655=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 296, column: 12
              S2642=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S2655=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S2642){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 297, column: 11
                  S2642=1;
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 299, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
                  System.out.println("Emitted gripperTurnFinalPos");
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
                if(!gripperTurnExtend.getprestatus() && gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 298, column: 11
                  S2655=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 299, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
                  System.out.println("Emitted gripperTurnFinalPos");
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

  public void thread13067(int [] tdone, int [] ends){
        switch(S2632){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2561){
          case 0 : 
            S2561=0;
            S2561=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 284, column: 12
              S2548=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S2561=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S2548){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 285, column: 11
                  S2548=1;
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 287, column: 6
                  currsigs.addElement(gripperZAxisLowered);
                  System.out.println("Emitted gripperZAxisLowered");
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
                if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 286, column: 11
                  S2561=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 287, column: 6
                  currsigs.addElement(gripperZAxisLowered);
                  System.out.println("Emitted gripperZAxisLowered");
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

  public void thread13066(int [] tdone, int [] ends){
        switch(S2538){
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

  public void thread13065(int [] tdone, int [] ends){
        switch(S2536){
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

  public void thread13064(int [] tdone, int [] ends){
        switch(S2534){
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

  public void thread13063(int [] tdone, int [] ends){
        switch(S2532){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 240, column: 3
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread13062(int [] tdone, int [] ends){
        switch(S2529){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        active[14]=1;
        ends[14]=1;
        tdone[14]=1;
        break;
      
    }
  }

  public void thread13061(int [] tdone, int [] ends){
        switch(S2527){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1494){
          case 0 : 
            S1494=0;
            S1494=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 207, column: 13
              S1480=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                S1494=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1494=0;
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
                S1494=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
              else {
                S1494=0;
                active[13]=1;
                ends[13]=1;
                tdone[13]=1;
              }
            }
            else {
              switch(S1480){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 208, column: 12
                    numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 209, column: 6
                    if(numTurns_thread_13 >= 2 && numTurns_thread_13 < 4){//sysj\plant.sysj line: 210, column: 9
                      l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 211, column: 7
                      currsigs.addElement(l_putBottleAt2_1);
                      System.out.println("Emitted l_putBottleAt2_1");
                      if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                        numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                        S1494=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                      else {
                        S1494=0;
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                    }
                    else {
                      if(numTurns_thread_13 >= 4 && numTurns_thread_13 < 10){//sysj\plant.sysj line: 212, column: 15
                        l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 213, column: 7
                        currsigs.addElement(l_putBottleAt4_1);
                        System.out.println("Emitted l_putBottleAt4_1");
                        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                          S1494=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        else {
                          S1494=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                      }
                      else {
                        if(numTurns_thread_13 >= 10){//sysj\plant.sysj line: 214, column: 15
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 215, column: 7
                          l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 216, column: 7
                          currsigs.addElement(l_putBottleAt5_1);
                          System.out.println("Emitted l_putBottleAt5_1");
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                            S1494=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S1494=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                        }
                        else {
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 220, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 221, column: 5
                            S1494=0;
                            active[13]=1;
                            ends[13]=1;
                            tdone[13]=1;
                          }
                          else {
                            S1494=0;
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
                    S1494=0;
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S1494=0;
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

  public void thread13060(int [] tdone, int [] ends){
        switch(S1469){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S1446){
          case 0 : 
            S1446=0;
            S1446=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 193, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S1446=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 194, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 195, column: 5
              currsigs.addElement(bottleLeftPos5);
              System.out.println("Emitted bottleLeftPos5");
              S1446=0;
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

  public void thread13059(int [] tdone, int [] ends){
        switch(S1439){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S1374){
          case 0 : 
            S1374=0;
            S1374=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 181, column: 12
              S1361=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S1374=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt2_1.getprestatus())){//sysj\plant.sysj line: 182, column: 11
              S1374=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S1361){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 183, column: 12
                    S1361=1;
                    bottleAtPos2.setPresent();//sysj\plant.sysj line: 184, column: 6
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
                  bottleAtPos2.setPresent();//sysj\plant.sysj line: 184, column: 6
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

  public void thread13058(int [] tdone, int [] ends){
        switch(S1353){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1288){
          case 0 : 
            S1288=0;
            S1288=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 169, column: 12
              S1275=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S1288=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt4_1.getprestatus())){//sysj\plant.sysj line: 170, column: 11
              S1288=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S1275){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 171, column: 12
                    S1275=1;
                    bottleAtPos4.setPresent();//sysj\plant.sysj line: 172, column: 6
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
                  bottleAtPos4.setPresent();//sysj\plant.sysj line: 172, column: 6
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

  public void thread13057(int [] tdone, int [] ends){
        switch(S1267){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S1232){
          case 0 : 
            S1232=0;
            S1232=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 158, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
              currsigs.addElement(bottleAtPos5);
              System.out.println("Emitted bottleAtPos5");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S1232=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if((enable.getprestatus() && !l_putBottleAt5_1.getprestatus()) || bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 159, column: 11
              S1232=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
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

  public void thread13056(int [] tdone, int [] ends){
        switch(S1221){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S1186){
          case 0 : 
            S1186=0;
            S1186=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
              currsigs.addElement(l_bottleAdded_1);
              System.out.println("Emitted l_bottleAdded_1");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S1186=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 148, column: 11
              S1186=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
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

  public void thread13055(int [] tdone, int [] ends){
        switch(S1175){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
        switch(S1143){
          case 0 : 
            S1143=0;
            S1143=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 136, column: 11
              S1143=2;
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 138, column: 6
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
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 137, column: 11
              S1143=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 138, column: 6
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

  public void thread13054(int [] tdone, int [] ends){
        switch(S1139){
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
              empty.setPresent();//sysj\plant.sysj line: 124, column: 6
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
          if(refill.getprestatus()){//sysj\plant.sysj line: 119, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 120, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
              empty.setPresent();//sysj\plant.sysj line: 124, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
              empty.setPresent();//sysj\plant.sysj line: 124, column: 6
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

  public void thread13053(int [] tdone, int [] ends){
        switch(S1077){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1031){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 98, column: 10
              S1031=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1013){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 100, column: 13
                    S1013=1;
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
                    System.out.println("Emitted capPos_1");
                    S1013=2;
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
                    System.out.println("Emitted capDec_1");
                    S1013=0;
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
              S1031=0;
              S1013=0;
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

  public void thread13052(int [] tdone, int [] ends){
        switch(S1009){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S979){
          case 0 : 
            switch(S974){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 78, column: 12
                  S974=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 81, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 82, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 82, column: 7
                    System.out.println("Emitted capPos_1");
                    S979=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S979=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                  currsigs.addElement(WPgripped);
                  System.out.println("Emitted WPgripped");
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S979=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                    System.out.println("Emitted capPos_1");
                    S974=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                    currsigs.addElement(WPgripped);
                    System.out.println("Emitted WPgripped");
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S979=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S979=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S979=1;
            S979=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                System.out.println("Emitted capPos_1");
                S974=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                currsigs.addElement(WPgripped);
                System.out.println("Emitted WPgripped");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S979=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S979=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread13051(int [] tdone, int [] ends){
        switch(S965){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S919){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 62, column: 10
              S919=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
              currsigs.addElement(pusherRetracted);
              System.out.println("Emitted pusherRetracted");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 65, column: 10
              S919=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 67, column: 5
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
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 66, column: 10
              S919=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 67, column: 5
              currsigs.addElement(pusherExtended);
              System.out.println("Emitted pusherExtended");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 69, column: 10
              S919=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
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

  public void thread13050(int [] tdone, int [] ends){
        switch(S912){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S866){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 49, column: 10
              S866=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 50, column: 5
              currsigs.addElement(armAtDest);
              System.out.println("Emitted armAtDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 52, column: 10
              S866=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 54, column: 5
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 53, column: 10
              S866=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 54, column: 5
              currsigs.addElement(armAtSource);
              System.out.println("Emitted armAtSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 56, column: 10
              S866=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 50, column: 5
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

  public void thread13047(int [] tdone, int [] ends){
        S3888=1;
    if(selNoz4.getprestatus()){//sysj\plant.sysj line: 462, column: 25
      o_selNoz4.setPresent();//sysj\plant.sysj line: 462, column: 34
      currsigs.addElement(o_selNoz4);
      System.out.println("Emitted o_selNoz4");
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

  public void thread13046(int [] tdone, int [] ends){
        S3880=1;
    if(selNoz3.getprestatus()){//sysj\plant.sysj line: 460, column: 25
      o_selNoz3.setPresent();//sysj\plant.sysj line: 460, column: 34
      currsigs.addElement(o_selNoz3);
      System.out.println("Emitted o_selNoz3");
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

  public void thread13045(int [] tdone, int [] ends){
        S3872=1;
    if(selNoz2.getprestatus()){//sysj\plant.sysj line: 458, column: 25
      o_selNoz2.setPresent();//sysj\plant.sysj line: 458, column: 34
      currsigs.addElement(o_selNoz2);
      System.out.println("Emitted o_selNoz2");
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

  public void thread13044(int [] tdone, int [] ends){
        S3864=1;
    if(selNoz1.getprestatus()){//sysj\plant.sysj line: 456, column: 25
      o_selNoz1.setPresent();//sysj\plant.sysj line: 456, column: 34
      currsigs.addElement(o_selNoz1);
      System.out.println("Emitted o_selNoz1");
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

  public void thread13043(int [] tdone, int [] ends){
        S3856=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 454, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 454, column: 40
      currsigs.addElement(dosUnitFilledE);
      System.out.println("Emitted dosUnitFilledE");
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

  public void thread13042(int [] tdone, int [] ends){
        S3848=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 452, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 452, column: 38
      currsigs.addElement(dosUnitEvacE);
      System.out.println("Emitted dosUnitEvacE");
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

  public void thread13041(int [] tdone, int [] ends){
        S3840=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 450, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 450, column: 39
      currsigs.addElement(bottleAtPos2E);
      System.out.println("Emitted bottleAtPos2E");
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

  public void thread13040(int [] tdone, int [] ends){
        S3832=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 448, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 448, column: 45
      currsigs.addElement(dosUnitValveExtendE);
      System.out.println("Emitted dosUnitValveExtendE");
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

  public void thread13039(int [] tdone, int [] ends){
        S3824=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 446, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 446, column: 46
      currsigs.addElement(dosUnitValveRetractE);
      System.out.println("Emitted dosUnitValveRetractE");
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

  public void thread13038(int [] tdone, int [] ends){
        S3816=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 444, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 444, column: 42
      currsigs.addElement(valveInletOnOffE);
      System.out.println("Emitted valveInletOnOffE");
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

  public void thread13037(int [] tdone, int [] ends){
        S3808=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 442, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 442, column: 45
      currsigs.addElement(valveInjectorOnOffE);
      System.out.println("Emitted valveInjectorOnOffE");
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

  public void thread13036(int [] tdone, int [] ends){
        S3800=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 439, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 439, column: 47
      currsigs.addElement(cylClampBottleExtendE);
      System.out.println("Emitted cylClampBottleExtendE");
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

  public void thread13035(int [] tdone, int [] ends){
        S3792=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 437, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 437, column: 47
      currsigs.addElement(capGripperPos5ExtendE);
      System.out.println("Emitted capGripperPos5ExtendE");
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

  public void thread13034(int [] tdone, int [] ends){
        S3784=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 435, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 435, column: 44
      currsigs.addElement(gripperTurnExtendE);
      System.out.println("Emitted gripperTurnExtendE");
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

  public void thread13033(int [] tdone, int [] ends){
        S3776=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 433, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 433, column: 45
      currsigs.addElement(gripperTurnRetractE);
      System.out.println("Emitted gripperTurnRetractE");
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

  public void thread13032(int [] tdone, int [] ends){
        S3768=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 431, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 431, column: 45
      currsigs.addElement(cylPos5ZaxisExtendE);
      System.out.println("Emitted cylPos5ZaxisExtendE");
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

  public void thread13031(int [] tdone, int [] ends){
        S3760=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 429, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 429, column: 45
      currsigs.addElement(gripperZAxisLiftedE);
      System.out.println("Emitted gripperZAxisLiftedE");
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

  public void thread13030(int [] tdone, int [] ends){
        S3752=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 426, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 426, column: 45
      currsigs.addElement(gripperTurnHomePosE);
      System.out.println("Emitted gripperTurnHomePosE");
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

  public void thread13029(int [] tdone, int [] ends){
        S3744=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 424, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 424, column: 46
      currsigs.addElement(gripperTurnFinalPosE);
      System.out.println("Emitted gripperTurnFinalPosE");
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

  public void thread13028(int [] tdone, int [] ends){
        S3736=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 422, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 422, column: 46
      currsigs.addElement(gripperZAxisLoweredE);
      System.out.println("Emitted gripperZAxisLoweredE");
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

  public void thread13027(int [] tdone, int [] ends){
        S3728=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 420, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 420, column: 38
      currsigs.addElement(bottleAtPos2E);
      System.out.println("Emitted bottleAtPos2E");
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

  public void thread13026(int [] tdone, int [] ends){
        S3720=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 418, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 418, column: 38
      currsigs.addElement(bottleAtPos4E);
      System.out.println("Emitted bottleAtPos4E");
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

  public void thread13025(int [] tdone, int [] ends){
        S3712=1;
    S3698=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 416, column: 24
      S3696=0;
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
    else {
      S3698=1;
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
  }

  public void thread13024(int [] tdone, int [] ends){
        S3692=1;
    S3666=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 406, column: 12
      S3664=0;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
    else {
      S3666=1;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
  }

  public void thread13023(int [] tdone, int [] ends){
        S3654=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 403, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 403, column: 56
      currsigs.addElement(bottleAtPos5E);
      System.out.println("Emitted bottleAtPos5E");
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

  public void thread13022(int [] tdone, int [] ends){
        S3646=1;
    S3632=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 401, column: 24
      S3630=0;
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
    else {
      S3632=1;
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
  }

  public void thread13021(int [] tdone, int [] ends){
        S3626=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 399, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 399, column: 44
      currsigs.addElement(rotaryTableTriggerE);
      System.out.println("Emitted rotaryTableTriggerE");
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

  public void thread13020(int [] tdone, int [] ends){
        S3618=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 397, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 397, column: 39
      currsigs.addElement(motConveyorOnE);
      System.out.println("Emitted motConveyorOnE");
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

  public void thread13019(int [] tdone, int [] ends){
        S3610=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 395, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 395, column: 38
      currsigs.addElement(bottleAtPos1E);
      System.out.println("Emitted bottleAtPos1E");
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

  public void thread13018(int [] tdone, int [] ends){
        S3890=1;
    thread13019(tdone,ends);
    thread13020(tdone,ends);
    thread13021(tdone,ends);
    thread13022(tdone,ends);
    thread13023(tdone,ends);
    thread13024(tdone,ends);
    thread13025(tdone,ends);
    thread13026(tdone,ends);
    thread13027(tdone,ends);
    thread13028(tdone,ends);
    thread13029(tdone,ends);
    thread13030(tdone,ends);
    thread13031(tdone,ends);
    thread13032(tdone,ends);
    thread13033(tdone,ends);
    thread13034(tdone,ends);
    thread13035(tdone,ends);
    thread13036(tdone,ends);
    thread13037(tdone,ends);
    thread13038(tdone,ends);
    thread13039(tdone,ends);
    thread13040(tdone,ends);
    thread13041(tdone,ends);
    thread13042(tdone,ends);
    thread13043(tdone,ends);
    thread13044(tdone,ends);
    thread13045(tdone,ends);
    thread13046(tdone,ends);
    thread13047(tdone,ends);
    int biggest13048 = 0;
    if(ends[27]>=biggest13048){
      biggest13048=ends[27];
    }
    if(ends[28]>=biggest13048){
      biggest13048=ends[28];
    }
    if(ends[29]>=biggest13048){
      biggest13048=ends[29];
    }
    if(ends[30]>=biggest13048){
      biggest13048=ends[30];
    }
    if(ends[31]>=biggest13048){
      biggest13048=ends[31];
    }
    if(ends[32]>=biggest13048){
      biggest13048=ends[32];
    }
    if(ends[33]>=biggest13048){
      biggest13048=ends[33];
    }
    if(ends[34]>=biggest13048){
      biggest13048=ends[34];
    }
    if(ends[35]>=biggest13048){
      biggest13048=ends[35];
    }
    if(ends[36]>=biggest13048){
      biggest13048=ends[36];
    }
    if(ends[37]>=biggest13048){
      biggest13048=ends[37];
    }
    if(ends[38]>=biggest13048){
      biggest13048=ends[38];
    }
    if(ends[39]>=biggest13048){
      biggest13048=ends[39];
    }
    if(ends[40]>=biggest13048){
      biggest13048=ends[40];
    }
    if(ends[41]>=biggest13048){
      biggest13048=ends[41];
    }
    if(ends[42]>=biggest13048){
      biggest13048=ends[42];
    }
    if(ends[43]>=biggest13048){
      biggest13048=ends[43];
    }
    if(ends[44]>=biggest13048){
      biggest13048=ends[44];
    }
    if(ends[45]>=biggest13048){
      biggest13048=ends[45];
    }
    if(ends[46]>=biggest13048){
      biggest13048=ends[46];
    }
    if(ends[47]>=biggest13048){
      biggest13048=ends[47];
    }
    if(ends[48]>=biggest13048){
      biggest13048=ends[48];
    }
    if(ends[49]>=biggest13048){
      biggest13048=ends[49];
    }
    if(ends[50]>=biggest13048){
      biggest13048=ends[50];
    }
    if(ends[51]>=biggest13048){
      biggest13048=ends[51];
    }
    if(ends[52]>=biggest13048){
      biggest13048=ends[52];
    }
    if(ends[53]>=biggest13048){
      biggest13048=ends[53];
    }
    if(ends[54]>=biggest13048){
      biggest13048=ends[54];
    }
    if(ends[55]>=biggest13048){
      biggest13048=ends[55];
    }
    if(biggest13048 == 1){
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread13017(int [] tdone, int [] ends){
        S3602=1;
    nozzlenum_thread_25 = 0;//sysj\plant.sysj line: 360, column: 3
    S3175=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread13016(int [] tdone, int [] ends){
        S3150=1;
    S3079=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread13015(int [] tdone, int [] ends){
        S3056=1;
    S3055=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 333, column: 4
    currsigs.addElement(dosUnitEvac);
    System.out.println("Emitted dosUnitEvac");
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread13014(int [] tdone, int [] ends){
        S2866=1;
    S2831=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread13013(int [] tdone, int [] ends){
        S2820=1;
    S2749=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread13012(int [] tdone, int [] ends){
        S2726=1;
    S2655=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread13011(int [] tdone, int [] ends){
        S2632=1;
    S2561=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread13010(int [] tdone, int [] ends){
        S2538=1;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread13009(int [] tdone, int [] ends){
        S2536=1;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread13008(int [] tdone, int [] ends){
        S2534=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread13007(int [] tdone, int [] ends){
        S2532=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 240, column: 3
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread13006(int [] tdone, int [] ends){
        S2529=1;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread13005(int [] tdone, int [] ends){
        S2527=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 203, column: 3
    S1494=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread13004(int [] tdone, int [] ends){
        S1469=1;
    S1446=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread13003(int [] tdone, int [] ends){
        S1439=1;
    S1374=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread13002(int [] tdone, int [] ends){
        S1353=1;
    S1288=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread13001(int [] tdone, int [] ends){
        S1267=1;
    S1232=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread13000(int [] tdone, int [] ends){
        S1221=1;
    S1186=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread12999(int [] tdone, int [] ends){
        S1175=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
    S1143=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread12998(int [] tdone, int [] ends){
        S1139=1;
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
          empty.setPresent();//sysj\plant.sysj line: 124, column: 6
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
      if(refill.getprestatus()){//sysj\plant.sysj line: 119, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 120, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
          empty.setPresent();//sysj\plant.sysj line: 124, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 123, column: 8
          empty.setPresent();//sysj\plant.sysj line: 124, column: 6
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

  public void thread12997(int [] tdone, int [] ends){
        S1077=1;
    S1031=0;
    S1013=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread12996(int [] tdone, int [] ends){
        S1009=1;
    S979=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
        System.out.println("Emitted capPos_1");
        S974=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
        currsigs.addElement(WPgripped);
        System.out.println("Emitted WPgripped");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S979=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S979=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread12995(int [] tdone, int [] ends){
        S965=1;
    S919=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
    currsigs.addElement(pusherRetracted);
    System.out.println("Emitted pusherRetracted");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread12994(int [] tdone, int [] ends){
        S912=1;
    S866=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 50, column: 5
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
      switch(S12992){
        case 0 : 
          S12992=0;
          break RUN;
        
        case 1 : 
          S12992=2;
          S12992=2;
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
          System.out.println("Emitted capPos_1");
          thread12994(tdone,ends);
          thread12995(tdone,ends);
          thread12996(tdone,ends);
          thread12997(tdone,ends);
          thread12998(tdone,ends);
          thread12999(tdone,ends);
          thread13000(tdone,ends);
          thread13001(tdone,ends);
          thread13002(tdone,ends);
          thread13003(tdone,ends);
          thread13004(tdone,ends);
          thread13005(tdone,ends);
          thread13006(tdone,ends);
          thread13007(tdone,ends);
          thread13008(tdone,ends);
          thread13009(tdone,ends);
          thread13010(tdone,ends);
          thread13011(tdone,ends);
          thread13012(tdone,ends);
          thread13013(tdone,ends);
          thread13014(tdone,ends);
          thread13015(tdone,ends);
          thread13016(tdone,ends);
          thread13017(tdone,ends);
          thread13018(tdone,ends);
          int biggest13049 = 0;
          if(ends[2]>=biggest13049){
            biggest13049=ends[2];
          }
          if(ends[3]>=biggest13049){
            biggest13049=ends[3];
          }
          if(ends[4]>=biggest13049){
            biggest13049=ends[4];
          }
          if(ends[5]>=biggest13049){
            biggest13049=ends[5];
          }
          if(ends[6]>=biggest13049){
            biggest13049=ends[6];
          }
          if(ends[7]>=biggest13049){
            biggest13049=ends[7];
          }
          if(ends[8]>=biggest13049){
            biggest13049=ends[8];
          }
          if(ends[9]>=biggest13049){
            biggest13049=ends[9];
          }
          if(ends[10]>=biggest13049){
            biggest13049=ends[10];
          }
          if(ends[11]>=biggest13049){
            biggest13049=ends[11];
          }
          if(ends[12]>=biggest13049){
            biggest13049=ends[12];
          }
          if(ends[13]>=biggest13049){
            biggest13049=ends[13];
          }
          if(ends[14]>=biggest13049){
            biggest13049=ends[14];
          }
          if(ends[15]>=biggest13049){
            biggest13049=ends[15];
          }
          if(ends[16]>=biggest13049){
            biggest13049=ends[16];
          }
          if(ends[17]>=biggest13049){
            biggest13049=ends[17];
          }
          if(ends[18]>=biggest13049){
            biggest13049=ends[18];
          }
          if(ends[19]>=biggest13049){
            biggest13049=ends[19];
          }
          if(ends[20]>=biggest13049){
            biggest13049=ends[20];
          }
          if(ends[21]>=biggest13049){
            biggest13049=ends[21];
          }
          if(ends[22]>=biggest13049){
            biggest13049=ends[22];
          }
          if(ends[23]>=biggest13049){
            biggest13049=ends[23];
          }
          if(ends[24]>=biggest13049){
            biggest13049=ends[24];
          }
          if(ends[25]>=biggest13049){
            biggest13049=ends[25];
          }
          if(ends[26]>=biggest13049){
            biggest13049=ends[26];
          }
          if(biggest13049 == 1){
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
          thread13050(tdone,ends);
          thread13051(tdone,ends);
          thread13052(tdone,ends);
          thread13053(tdone,ends);
          thread13054(tdone,ends);
          thread13055(tdone,ends);
          thread13056(tdone,ends);
          thread13057(tdone,ends);
          thread13058(tdone,ends);
          thread13059(tdone,ends);
          thread13060(tdone,ends);
          thread13061(tdone,ends);
          thread13062(tdone,ends);
          thread13063(tdone,ends);
          thread13064(tdone,ends);
          thread13065(tdone,ends);
          thread13066(tdone,ends);
          thread13067(tdone,ends);
          thread13068(tdone,ends);
          thread13069(tdone,ends);
          thread13070(tdone,ends);
          thread13071(tdone,ends);
          thread13072(tdone,ends);
          thread13073(tdone,ends);
          thread13074(tdone,ends);
          int biggest13105 = 0;
          if(ends[2]>=biggest13105){
            biggest13105=ends[2];
          }
          if(ends[3]>=biggest13105){
            biggest13105=ends[3];
          }
          if(ends[4]>=biggest13105){
            biggest13105=ends[4];
          }
          if(ends[5]>=biggest13105){
            biggest13105=ends[5];
          }
          if(ends[6]>=biggest13105){
            biggest13105=ends[6];
          }
          if(ends[7]>=biggest13105){
            biggest13105=ends[7];
          }
          if(ends[8]>=biggest13105){
            biggest13105=ends[8];
          }
          if(ends[9]>=biggest13105){
            biggest13105=ends[9];
          }
          if(ends[10]>=biggest13105){
            biggest13105=ends[10];
          }
          if(ends[11]>=biggest13105){
            biggest13105=ends[11];
          }
          if(ends[12]>=biggest13105){
            biggest13105=ends[12];
          }
          if(ends[13]>=biggest13105){
            biggest13105=ends[13];
          }
          if(ends[14]>=biggest13105){
            biggest13105=ends[14];
          }
          if(ends[15]>=biggest13105){
            biggest13105=ends[15];
          }
          if(ends[16]>=biggest13105){
            biggest13105=ends[16];
          }
          if(ends[17]>=biggest13105){
            biggest13105=ends[17];
          }
          if(ends[18]>=biggest13105){
            biggest13105=ends[18];
          }
          if(ends[19]>=biggest13105){
            biggest13105=ends[19];
          }
          if(ends[20]>=biggest13105){
            biggest13105=ends[20];
          }
          if(ends[21]>=biggest13105){
            biggest13105=ends[21];
          }
          if(ends[22]>=biggest13105){
            biggest13105=ends[22];
          }
          if(ends[23]>=biggest13105){
            biggest13105=ends[23];
          }
          if(ends[24]>=biggest13105){
            biggest13105=ends[24];
          }
          if(ends[25]>=biggest13105){
            biggest13105=ends[25];
          }
          if(ends[26]>=biggest13105){
            biggest13105=ends[26];
          }
          if(biggest13105 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest13105 == 0){
            S12992=0;
            active[1]=0;
            ends[1]=0;
            S12992=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
