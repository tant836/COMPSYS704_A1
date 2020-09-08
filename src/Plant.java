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
  private Integer chance_thread_14;//sysj\plant.sysj line: 228, column: 3
  private Integer rand_thread_14;//sysj\plant.sysj line: 229, column: 3
  private int nozzlenum_thread_25;//sysj\plant.sysj line: 372, column: 3
  private int S14144 = 1;
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
  private int S2809 = 1;
  private int S2563 = 1;
  private int S2529 = 1;
  private int S2812 = 1;
  private int S2814 = 1;
  private int S2816 = 1;
  private int S2818 = 1;
  private int S2912 = 1;
  private int S2841 = 1;
  private int S2828 = 1;
  private int S3006 = 1;
  private int S2935 = 1;
  private int S2922 = 1;
  private int S3100 = 1;
  private int S3029 = 1;
  private int S3016 = 1;
  private int S3146 = 1;
  private int S3111 = 1;
  private int S3336 = 1;
  private int S3335 = 1;
  private int S3173 = 1;
  private int S3160 = 1;
  private int S3430 = 1;
  private int S3359 = 1;
  private int S3346 = 1;
  private int S3882 = 1;
  private int S3455 = 1;
  private int S3441 = 1;
  private int S4178 = 1;
  private int S3890 = 1;
  private int S3898 = 1;
  private int S3906 = 1;
  private int S3926 = 1;
  private int S3912 = 1;
  private int S3910 = 1;
  private int S3934 = 1;
  private int S3972 = 1;
  private int S3946 = 1;
  private int S3944 = 1;
  private int S3992 = 1;
  private int S3978 = 1;
  private int S3976 = 1;
  private int S4000 = 1;
  private int S4008 = 1;
  private int S4016 = 1;
  private int S4024 = 1;
  private int S4032 = 1;
  private int S4040 = 1;
  private int S4048 = 1;
  private int S4056 = 1;
  private int S4064 = 1;
  private int S4072 = 1;
  private int S4080 = 1;
  private int S4088 = 1;
  private int S4096 = 1;
  private int S4104 = 1;
  private int S4112 = 1;
  private int S4120 = 1;
  private int S4128 = 1;
  private int S4136 = 1;
  private int S4144 = 1;
  private int S4152 = 1;
  private int S4160 = 1;
  private int S4168 = 1;
  private int S4176 = 1;
  
  private int[] ends = new int[57];
  private int[] tdone = new int[57];
  
  public void thread14257(int [] tdone, int [] ends){
        switch(S4176){
      case 0 : 
        active[56]=0;
        ends[56]=0;
        tdone[56]=1;
        break;
      
      case 1 : 
        if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 477, column: 25
          capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 477, column: 44
          currsigs.addElement(capOnBottleAtPos1E);
          System.out.println("Emitted capOnBottleAtPos1E");
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

  public void thread14256(int [] tdone, int [] ends){
        switch(S4168){
      case 0 : 
        active[55]=0;
        ends[55]=0;
        tdone[55]=1;
        break;
      
      case 1 : 
        if(selNoz4.getprestatus()){//sysj\plant.sysj line: 475, column: 25
          o_selNoz4.setPresent();//sysj\plant.sysj line: 475, column: 34
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

  public void thread14255(int [] tdone, int [] ends){
        switch(S4160){
      case 0 : 
        active[54]=0;
        ends[54]=0;
        tdone[54]=1;
        break;
      
      case 1 : 
        if(selNoz3.getprestatus()){//sysj\plant.sysj line: 473, column: 25
          o_selNoz3.setPresent();//sysj\plant.sysj line: 473, column: 34
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

  public void thread14254(int [] tdone, int [] ends){
        switch(S4152){
      case 0 : 
        active[53]=0;
        ends[53]=0;
        tdone[53]=1;
        break;
      
      case 1 : 
        if(selNoz2.getprestatus()){//sysj\plant.sysj line: 471, column: 25
          o_selNoz2.setPresent();//sysj\plant.sysj line: 471, column: 34
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

  public void thread14253(int [] tdone, int [] ends){
        switch(S4144){
      case 0 : 
        active[52]=0;
        ends[52]=0;
        tdone[52]=1;
        break;
      
      case 1 : 
        if(selNoz1.getprestatus()){//sysj\plant.sysj line: 469, column: 25
          o_selNoz1.setPresent();//sysj\plant.sysj line: 469, column: 34
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

  public void thread14252(int [] tdone, int [] ends){
        switch(S4136){
      case 0 : 
        active[51]=0;
        ends[51]=0;
        tdone[51]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 466, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 466, column: 40
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

  public void thread14251(int [] tdone, int [] ends){
        switch(S4128){
      case 0 : 
        active[50]=0;
        ends[50]=0;
        tdone[50]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 464, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 464, column: 38
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

  public void thread14250(int [] tdone, int [] ends){
        switch(S4120){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 462, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 462, column: 39
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

  public void thread14249(int [] tdone, int [] ends){
        switch(S4112){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 460, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 460, column: 45
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

  public void thread14248(int [] tdone, int [] ends){
        switch(S4104){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 458, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 458, column: 46
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

  public void thread14247(int [] tdone, int [] ends){
        switch(S4096){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 456, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 456, column: 42
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

  public void thread14246(int [] tdone, int [] ends){
        switch(S4088){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 454, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 454, column: 45
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

  public void thread14245(int [] tdone, int [] ends){
        switch(S4080){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 451, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 451, column: 47
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

  public void thread14244(int [] tdone, int [] ends){
        switch(S4072){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 449, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 449, column: 47
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

  public void thread14243(int [] tdone, int [] ends){
        switch(S4064){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 447, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 447, column: 44
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

  public void thread14242(int [] tdone, int [] ends){
        switch(S4056){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 445, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 445, column: 45
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

  public void thread14241(int [] tdone, int [] ends){
        switch(S4048){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 443, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 443, column: 45
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

  public void thread14240(int [] tdone, int [] ends){
        switch(S4040){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 441, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 441, column: 45
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

  public void thread14239(int [] tdone, int [] ends){
        switch(S4032){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 438, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 438, column: 45
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

  public void thread14238(int [] tdone, int [] ends){
        switch(S4024){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 436, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 436, column: 46
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

  public void thread14237(int [] tdone, int [] ends){
        switch(S4016){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 434, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 434, column: 46
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

  public void thread14236(int [] tdone, int [] ends){
        switch(S4008){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 432, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 432, column: 38
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

  public void thread14235(int [] tdone, int [] ends){
        switch(S4000){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 430, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 430, column: 38
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

  public void thread14234(int [] tdone, int [] ends){
        switch(S3992){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        switch(S3978){
          case 0 : 
            switch(S3976){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 428, column: 54
                  S3976=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 428, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 428, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  System.out.println("Emitted bottleAtPos5_RT");
                  S3978=1;
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
            S3978=1;
            S3978=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 428, column: 24
              S3976=0;
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            else {
              S3978=1;
              active[33]=1;
              ends[33]=1;
              tdone[33]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14233(int [] tdone, int [] ends){
        switch(S3972){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        switch(S3946){
          case 0 : 
            switch(S3944){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 419, column: 11
                  S3944=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 421, column: 6
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 420, column: 11
                  S3946=1;
                  active[32]=1;
                  ends[32]=1;
                  tdone[32]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 421, column: 6
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
            S3946=1;
            S3946=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 418, column: 12
              S3944=0;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            else {
              S3946=1;
              active[32]=1;
              ends[32]=1;
              tdone[32]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14232(int [] tdone, int [] ends){
        switch(S3934){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 415, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 415, column: 56
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

  public void thread14231(int [] tdone, int [] ends){
        switch(S3926){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        switch(S3912){
          case 0 : 
            switch(S3910){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 413, column: 54
                  S3910=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 413, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 413, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  System.out.println("Emitted bottleAtPos1_RT");
                  S3912=1;
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
            S3912=1;
            S3912=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 413, column: 24
              S3910=0;
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            else {
              S3912=1;
              active[30]=1;
              ends[30]=1;
              tdone[30]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread14230(int [] tdone, int [] ends){
        switch(S3906){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 411, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 411, column: 44
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

  public void thread14229(int [] tdone, int [] ends){
        switch(S3898){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 409, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 409, column: 39
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

  public void thread14228(int [] tdone, int [] ends){
        switch(S3890){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 407, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 407, column: 38
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

  public void thread14227(int [] tdone, int [] ends){
        switch(S4178){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        thread14228(tdone,ends);
        thread14229(tdone,ends);
        thread14230(tdone,ends);
        thread14231(tdone,ends);
        thread14232(tdone,ends);
        thread14233(tdone,ends);
        thread14234(tdone,ends);
        thread14235(tdone,ends);
        thread14236(tdone,ends);
        thread14237(tdone,ends);
        thread14238(tdone,ends);
        thread14239(tdone,ends);
        thread14240(tdone,ends);
        thread14241(tdone,ends);
        thread14242(tdone,ends);
        thread14243(tdone,ends);
        thread14244(tdone,ends);
        thread14245(tdone,ends);
        thread14246(tdone,ends);
        thread14247(tdone,ends);
        thread14248(tdone,ends);
        thread14249(tdone,ends);
        thread14250(tdone,ends);
        thread14251(tdone,ends);
        thread14252(tdone,ends);
        thread14253(tdone,ends);
        thread14254(tdone,ends);
        thread14255(tdone,ends);
        thread14256(tdone,ends);
        thread14257(tdone,ends);
        int biggest14258 = 0;
        if(ends[27]>=biggest14258){
          biggest14258=ends[27];
        }
        if(ends[28]>=biggest14258){
          biggest14258=ends[28];
        }
        if(ends[29]>=biggest14258){
          biggest14258=ends[29];
        }
        if(ends[30]>=biggest14258){
          biggest14258=ends[30];
        }
        if(ends[31]>=biggest14258){
          biggest14258=ends[31];
        }
        if(ends[32]>=biggest14258){
          biggest14258=ends[32];
        }
        if(ends[33]>=biggest14258){
          biggest14258=ends[33];
        }
        if(ends[34]>=biggest14258){
          biggest14258=ends[34];
        }
        if(ends[35]>=biggest14258){
          biggest14258=ends[35];
        }
        if(ends[36]>=biggest14258){
          biggest14258=ends[36];
        }
        if(ends[37]>=biggest14258){
          biggest14258=ends[37];
        }
        if(ends[38]>=biggest14258){
          biggest14258=ends[38];
        }
        if(ends[39]>=biggest14258){
          biggest14258=ends[39];
        }
        if(ends[40]>=biggest14258){
          biggest14258=ends[40];
        }
        if(ends[41]>=biggest14258){
          biggest14258=ends[41];
        }
        if(ends[42]>=biggest14258){
          biggest14258=ends[42];
        }
        if(ends[43]>=biggest14258){
          biggest14258=ends[43];
        }
        if(ends[44]>=biggest14258){
          biggest14258=ends[44];
        }
        if(ends[45]>=biggest14258){
          biggest14258=ends[45];
        }
        if(ends[46]>=biggest14258){
          biggest14258=ends[46];
        }
        if(ends[47]>=biggest14258){
          biggest14258=ends[47];
        }
        if(ends[48]>=biggest14258){
          biggest14258=ends[48];
        }
        if(ends[49]>=biggest14258){
          biggest14258=ends[49];
        }
        if(ends[50]>=biggest14258){
          biggest14258=ends[50];
        }
        if(ends[51]>=biggest14258){
          biggest14258=ends[51];
        }
        if(ends[52]>=biggest14258){
          biggest14258=ends[52];
        }
        if(ends[53]>=biggest14258){
          biggest14258=ends[53];
        }
        if(ends[54]>=biggest14258){
          biggest14258=ends[54];
        }
        if(ends[55]>=biggest14258){
          biggest14258=ends[55];
        }
        if(ends[56]>=biggest14258){
          biggest14258=ends[56];
        }
        if(biggest14258 == 1){
          active[26]=1;
          ends[26]=1;
          tdone[26]=1;
        }
        //FINXME code
        if(biggest14258 == 0){
          S4178=0;
          active[26]=0;
          ends[26]=0;
          tdone[26]=1;
        }
        break;
      
    }
  }

  public void thread14226(int [] tdone, int [] ends){
        switch(S3882){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S3455){
          case 0 : 
            S3455=0;
            S3455=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 376, column: 13
              S3441=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S3455=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            if(!turnNozTrigger.getprestatus()){//sysj\plant.sysj line: 375, column: 10
              S3455=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              switch(S3441){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 377, column: 12
                    nozzlenum_thread_25 = nozzlenum_thread_25 + 1;//sysj\plant.sysj line: 378, column: 6
                    if(nozzlenum_thread_25 == 1){//sysj\plant.sysj line: 379, column: 9
                      noz1.setPresent();//sysj\plant.sysj line: 380, column: 7
                      currsigs.addElement(noz1);
                      System.out.println("Emitted noz1");
                      S3455=0;
                      active[25]=1;
                      ends[25]=1;
                      tdone[25]=1;
                    }
                    else {
                      if(nozzlenum_thread_25 == 2){//sysj\plant.sysj line: 381, column: 15
                        noz2.setPresent();//sysj\plant.sysj line: 382, column: 7
                        currsigs.addElement(noz2);
                        System.out.println("Emitted noz2");
                        S3455=0;
                        active[25]=1;
                        ends[25]=1;
                        tdone[25]=1;
                      }
                      else {
                        if(nozzlenum_thread_25 == 3){//sysj\plant.sysj line: 383, column: 15
                          noz3.setPresent();//sysj\plant.sysj line: 384, column: 7
                          currsigs.addElement(noz3);
                          System.out.println("Emitted noz3");
                          S3455=0;
                          active[25]=1;
                          ends[25]=1;
                          tdone[25]=1;
                        }
                        else {
                          noz4.setPresent();//sysj\plant.sysj line: 386, column: 7
                          currsigs.addElement(noz4);
                          System.out.println("Emitted noz4");
                          nozzlenum_thread_25 = 0;//sysj\plant.sysj line: 387, column: 7
                          S3455=0;
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
                  S3455=0;
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

  public void thread14225(int [] tdone, int [] ends){
        switch(S3430){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S3359){
          case 0 : 
            S3359=0;
            S3359=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 361, column: 12
              S3346=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S3359=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            switch(S3346){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 362, column: 11
                  S3346=1;
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 364, column: 6
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
                if(!dosUnitValveRetract.getprestatus() && dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 363, column: 11
                  S3359=0;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 364, column: 6
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

  public void thread14224(int [] tdone, int [] ends){
        switch(S3336){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S3335){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 344, column: 9
              S3335=1;
              S3173=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 345, column: 4
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
          case 1 : 
            switch(S3173){
              case 0 : 
                S3173=0;
                S3173=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 349, column: 12
                  S3160=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  S3173=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                break;
              
              case 1 : 
                switch(S3160){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 350, column: 11
                      S3160=1;
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 352, column: 6
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
                    if(!dosUnitValveExtend.getprestatus() && dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 351, column: 11
                      S3173=0;
                      active[23]=1;
                      ends[23]=1;
                      tdone[23]=1;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 352, column: 6
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

  public void thread14223(int [] tdone, int [] ends){
        switch(S3146){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S3111){
          case 0 : 
            S3111=0;
            S3111=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 332, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 334, column: 6
              currsigs.addElement(gripperZAxisLifted);
              System.out.println("Emitted gripperZAxisLifted");
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S3111=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 333, column: 11
              S3111=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 334, column: 6
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

  public void thread14222(int [] tdone, int [] ends){
        switch(S3100){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S3029){
          case 0 : 
            S3029=0;
            S3029=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 320, column: 12
              S3016=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S3029=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            switch(S3016){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 321, column: 11
                  S3016=1;
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 323, column: 6
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
                if(!gripperTurnRetract.getprestatus() && gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 322, column: 11
                  S3029=0;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 323, column: 6
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

  public void thread14221(int [] tdone, int [] ends){
        switch(S3006){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S2935){
          case 0 : 
            S2935=0;
            S2935=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 308, column: 12
              S2922=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S2935=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S2922){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 309, column: 11
                  S2922=1;
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 311, column: 6
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
                if(!gripperTurnExtend.getprestatus() && gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 310, column: 11
                  S2935=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 311, column: 6
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

  public void thread14220(int [] tdone, int [] ends){
        switch(S2912){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S2841){
          case 0 : 
            S2841=0;
            S2841=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 296, column: 12
              S2828=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              S2841=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S2828){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 297, column: 11
                  S2828=1;
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 299, column: 6
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
                if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 298, column: 11
                  S2841=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 299, column: 6
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

  public void thread14219(int [] tdone, int [] ends){
        switch(S2818){
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

  public void thread14218(int [] tdone, int [] ends){
        switch(S2816){
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

  public void thread14217(int [] tdone, int [] ends){
        switch(S2814){
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

  public void thread14216(int [] tdone, int [] ends){
        switch(S2812){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 252, column: 3
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread14215(int [] tdone, int [] ends){
        switch(S2809){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S2563){
          case 0 : 
            S2563=0;
            S2563=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 233, column: 12
              rand_thread_14 = (int)(Math.random() * 100);//sysj\plant.sysj line: 234, column: 5
              System.out.println(rand_thread_14);//sysj\plant.sysj line: 235, column: 5
              S2529=0;
              if(rand_thread_14 < chance_thread_14){//sysj\plant.sysj line: 236, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 238, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                System.out.println("Emitted capOnBottleAtPos1");
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S2529=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              S2563=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S2529){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 237, column: 12
                  S2529=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 238, column: 8
                  currsigs.addElement(capOnBottleAtPos1);
                  System.out.println("Emitted capOnBottleAtPos1");
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 242, column: 11
                  S2529=2;
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
                  S2563=0;
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

  public void thread14214(int [] tdone, int [] ends){
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

  public void thread14213(int [] tdone, int [] ends){
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

  public void thread14212(int [] tdone, int [] ends){
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

  public void thread14211(int [] tdone, int [] ends){
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

  public void thread14210(int [] tdone, int [] ends){
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

  public void thread14209(int [] tdone, int [] ends){
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

  public void thread14208(int [] tdone, int [] ends){
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

  public void thread14207(int [] tdone, int [] ends){
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

  public void thread14206(int [] tdone, int [] ends){
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

  public void thread14205(int [] tdone, int [] ends){
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

  public void thread14204(int [] tdone, int [] ends){
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

  public void thread14203(int [] tdone, int [] ends){
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

  public void thread14200(int [] tdone, int [] ends){
        S4176=1;
    if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 477, column: 25
      capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 477, column: 44
      currsigs.addElement(capOnBottleAtPos1E);
      System.out.println("Emitted capOnBottleAtPos1E");
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

  public void thread14199(int [] tdone, int [] ends){
        S4168=1;
    if(selNoz4.getprestatus()){//sysj\plant.sysj line: 475, column: 25
      o_selNoz4.setPresent();//sysj\plant.sysj line: 475, column: 34
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

  public void thread14198(int [] tdone, int [] ends){
        S4160=1;
    if(selNoz3.getprestatus()){//sysj\plant.sysj line: 473, column: 25
      o_selNoz3.setPresent();//sysj\plant.sysj line: 473, column: 34
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

  public void thread14197(int [] tdone, int [] ends){
        S4152=1;
    if(selNoz2.getprestatus()){//sysj\plant.sysj line: 471, column: 25
      o_selNoz2.setPresent();//sysj\plant.sysj line: 471, column: 34
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

  public void thread14196(int [] tdone, int [] ends){
        S4144=1;
    if(selNoz1.getprestatus()){//sysj\plant.sysj line: 469, column: 25
      o_selNoz1.setPresent();//sysj\plant.sysj line: 469, column: 34
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

  public void thread14195(int [] tdone, int [] ends){
        S4136=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 466, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 466, column: 40
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

  public void thread14194(int [] tdone, int [] ends){
        S4128=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 464, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 464, column: 38
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

  public void thread14193(int [] tdone, int [] ends){
        S4120=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 462, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 462, column: 39
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

  public void thread14192(int [] tdone, int [] ends){
        S4112=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 460, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 460, column: 45
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

  public void thread14191(int [] tdone, int [] ends){
        S4104=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 458, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 458, column: 46
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

  public void thread14190(int [] tdone, int [] ends){
        S4096=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 456, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 456, column: 42
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

  public void thread14189(int [] tdone, int [] ends){
        S4088=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 454, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 454, column: 45
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

  public void thread14188(int [] tdone, int [] ends){
        S4080=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 451, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 451, column: 47
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

  public void thread14187(int [] tdone, int [] ends){
        S4072=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 449, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 449, column: 47
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

  public void thread14186(int [] tdone, int [] ends){
        S4064=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 447, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 447, column: 44
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

  public void thread14185(int [] tdone, int [] ends){
        S4056=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 445, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 445, column: 45
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

  public void thread14184(int [] tdone, int [] ends){
        S4048=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 443, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 443, column: 45
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

  public void thread14183(int [] tdone, int [] ends){
        S4040=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 441, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 441, column: 45
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

  public void thread14182(int [] tdone, int [] ends){
        S4032=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 438, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 438, column: 45
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

  public void thread14181(int [] tdone, int [] ends){
        S4024=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 436, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 436, column: 46
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

  public void thread14180(int [] tdone, int [] ends){
        S4016=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 434, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 434, column: 46
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

  public void thread14179(int [] tdone, int [] ends){
        S4008=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 432, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 432, column: 38
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

  public void thread14178(int [] tdone, int [] ends){
        S4000=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 430, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 430, column: 38
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

  public void thread14177(int [] tdone, int [] ends){
        S3992=1;
    S3978=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 428, column: 24
      S3976=0;
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
    else {
      S3978=1;
      active[33]=1;
      ends[33]=1;
      tdone[33]=1;
    }
  }

  public void thread14176(int [] tdone, int [] ends){
        S3972=1;
    S3946=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 418, column: 12
      S3944=0;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
    else {
      S3946=1;
      active[32]=1;
      ends[32]=1;
      tdone[32]=1;
    }
  }

  public void thread14175(int [] tdone, int [] ends){
        S3934=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 415, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 415, column: 56
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

  public void thread14174(int [] tdone, int [] ends){
        S3926=1;
    S3912=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 413, column: 24
      S3910=0;
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
    else {
      S3912=1;
      active[30]=1;
      ends[30]=1;
      tdone[30]=1;
    }
  }

  public void thread14173(int [] tdone, int [] ends){
        S3906=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 411, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 411, column: 44
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

  public void thread14172(int [] tdone, int [] ends){
        S3898=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 409, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 409, column: 39
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

  public void thread14171(int [] tdone, int [] ends){
        S3890=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 407, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 407, column: 38
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

  public void thread14170(int [] tdone, int [] ends){
        S4178=1;
    thread14171(tdone,ends);
    thread14172(tdone,ends);
    thread14173(tdone,ends);
    thread14174(tdone,ends);
    thread14175(tdone,ends);
    thread14176(tdone,ends);
    thread14177(tdone,ends);
    thread14178(tdone,ends);
    thread14179(tdone,ends);
    thread14180(tdone,ends);
    thread14181(tdone,ends);
    thread14182(tdone,ends);
    thread14183(tdone,ends);
    thread14184(tdone,ends);
    thread14185(tdone,ends);
    thread14186(tdone,ends);
    thread14187(tdone,ends);
    thread14188(tdone,ends);
    thread14189(tdone,ends);
    thread14190(tdone,ends);
    thread14191(tdone,ends);
    thread14192(tdone,ends);
    thread14193(tdone,ends);
    thread14194(tdone,ends);
    thread14195(tdone,ends);
    thread14196(tdone,ends);
    thread14197(tdone,ends);
    thread14198(tdone,ends);
    thread14199(tdone,ends);
    thread14200(tdone,ends);
    int biggest14201 = 0;
    if(ends[27]>=biggest14201){
      biggest14201=ends[27];
    }
    if(ends[28]>=biggest14201){
      biggest14201=ends[28];
    }
    if(ends[29]>=biggest14201){
      biggest14201=ends[29];
    }
    if(ends[30]>=biggest14201){
      biggest14201=ends[30];
    }
    if(ends[31]>=biggest14201){
      biggest14201=ends[31];
    }
    if(ends[32]>=biggest14201){
      biggest14201=ends[32];
    }
    if(ends[33]>=biggest14201){
      biggest14201=ends[33];
    }
    if(ends[34]>=biggest14201){
      biggest14201=ends[34];
    }
    if(ends[35]>=biggest14201){
      biggest14201=ends[35];
    }
    if(ends[36]>=biggest14201){
      biggest14201=ends[36];
    }
    if(ends[37]>=biggest14201){
      biggest14201=ends[37];
    }
    if(ends[38]>=biggest14201){
      biggest14201=ends[38];
    }
    if(ends[39]>=biggest14201){
      biggest14201=ends[39];
    }
    if(ends[40]>=biggest14201){
      biggest14201=ends[40];
    }
    if(ends[41]>=biggest14201){
      biggest14201=ends[41];
    }
    if(ends[42]>=biggest14201){
      biggest14201=ends[42];
    }
    if(ends[43]>=biggest14201){
      biggest14201=ends[43];
    }
    if(ends[44]>=biggest14201){
      biggest14201=ends[44];
    }
    if(ends[45]>=biggest14201){
      biggest14201=ends[45];
    }
    if(ends[46]>=biggest14201){
      biggest14201=ends[46];
    }
    if(ends[47]>=biggest14201){
      biggest14201=ends[47];
    }
    if(ends[48]>=biggest14201){
      biggest14201=ends[48];
    }
    if(ends[49]>=biggest14201){
      biggest14201=ends[49];
    }
    if(ends[50]>=biggest14201){
      biggest14201=ends[50];
    }
    if(ends[51]>=biggest14201){
      biggest14201=ends[51];
    }
    if(ends[52]>=biggest14201){
      biggest14201=ends[52];
    }
    if(ends[53]>=biggest14201){
      biggest14201=ends[53];
    }
    if(ends[54]>=biggest14201){
      biggest14201=ends[54];
    }
    if(ends[55]>=biggest14201){
      biggest14201=ends[55];
    }
    if(ends[56]>=biggest14201){
      biggest14201=ends[56];
    }
    if(biggest14201 == 1){
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread14169(int [] tdone, int [] ends){
        S3882=1;
    nozzlenum_thread_25 = 0;//sysj\plant.sysj line: 372, column: 3
    S3455=0;
    active[25]=1;
    ends[25]=1;
    tdone[25]=1;
  }

  public void thread14168(int [] tdone, int [] ends){
        S3430=1;
    S3359=0;
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread14167(int [] tdone, int [] ends){
        S3336=1;
    S3335=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 345, column: 4
    currsigs.addElement(dosUnitEvac);
    System.out.println("Emitted dosUnitEvac");
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void thread14166(int [] tdone, int [] ends){
        S3146=1;
    S3111=0;
    active[22]=1;
    ends[22]=1;
    tdone[22]=1;
  }

  public void thread14165(int [] tdone, int [] ends){
        S3100=1;
    S3029=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread14164(int [] tdone, int [] ends){
        S3006=1;
    S2935=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread14163(int [] tdone, int [] ends){
        S2912=1;
    S2841=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread14162(int [] tdone, int [] ends){
        S2818=1;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread14161(int [] tdone, int [] ends){
        S2816=1;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread14160(int [] tdone, int [] ends){
        S2814=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread14159(int [] tdone, int [] ends){
        S2812=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 252, column: 3
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread14158(int [] tdone, int [] ends){
        S2809=1;
    chance_thread_14 = 25;//sysj\plant.sysj line: 228, column: 3
        S2563=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread14157(int [] tdone, int [] ends){
        S2527=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 203, column: 3
    S1494=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread14156(int [] tdone, int [] ends){
        S1469=1;
    S1446=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread14155(int [] tdone, int [] ends){
        S1439=1;
    S1374=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread14154(int [] tdone, int [] ends){
        S1353=1;
    S1288=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread14153(int [] tdone, int [] ends){
        S1267=1;
    S1232=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread14152(int [] tdone, int [] ends){
        S1221=1;
    S1186=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread14151(int [] tdone, int [] ends){
        S1175=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
    S1143=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread14150(int [] tdone, int [] ends){
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

  public void thread14149(int [] tdone, int [] ends){
        S1077=1;
    S1031=0;
    S1013=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread14148(int [] tdone, int [] ends){
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

  public void thread14147(int [] tdone, int [] ends){
        S965=1;
    S919=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
    currsigs.addElement(pusherRetracted);
    System.out.println("Emitted pusherRetracted");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread14146(int [] tdone, int [] ends){
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
      switch(S14144){
        case 0 : 
          S14144=0;
          break RUN;
        
        case 1 : 
          S14144=2;
          S14144=2;
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
          thread14146(tdone,ends);
          thread14147(tdone,ends);
          thread14148(tdone,ends);
          thread14149(tdone,ends);
          thread14150(tdone,ends);
          thread14151(tdone,ends);
          thread14152(tdone,ends);
          thread14153(tdone,ends);
          thread14154(tdone,ends);
          thread14155(tdone,ends);
          thread14156(tdone,ends);
          thread14157(tdone,ends);
          thread14158(tdone,ends);
          thread14159(tdone,ends);
          thread14160(tdone,ends);
          thread14161(tdone,ends);
          thread14162(tdone,ends);
          thread14163(tdone,ends);
          thread14164(tdone,ends);
          thread14165(tdone,ends);
          thread14166(tdone,ends);
          thread14167(tdone,ends);
          thread14168(tdone,ends);
          thread14169(tdone,ends);
          thread14170(tdone,ends);
          int biggest14202 = 0;
          if(ends[2]>=biggest14202){
            biggest14202=ends[2];
          }
          if(ends[3]>=biggest14202){
            biggest14202=ends[3];
          }
          if(ends[4]>=biggest14202){
            biggest14202=ends[4];
          }
          if(ends[5]>=biggest14202){
            biggest14202=ends[5];
          }
          if(ends[6]>=biggest14202){
            biggest14202=ends[6];
          }
          if(ends[7]>=biggest14202){
            biggest14202=ends[7];
          }
          if(ends[8]>=biggest14202){
            biggest14202=ends[8];
          }
          if(ends[9]>=biggest14202){
            biggest14202=ends[9];
          }
          if(ends[10]>=biggest14202){
            biggest14202=ends[10];
          }
          if(ends[11]>=biggest14202){
            biggest14202=ends[11];
          }
          if(ends[12]>=biggest14202){
            biggest14202=ends[12];
          }
          if(ends[13]>=biggest14202){
            biggest14202=ends[13];
          }
          if(ends[14]>=biggest14202){
            biggest14202=ends[14];
          }
          if(ends[15]>=biggest14202){
            biggest14202=ends[15];
          }
          if(ends[16]>=biggest14202){
            biggest14202=ends[16];
          }
          if(ends[17]>=biggest14202){
            biggest14202=ends[17];
          }
          if(ends[18]>=biggest14202){
            biggest14202=ends[18];
          }
          if(ends[19]>=biggest14202){
            biggest14202=ends[19];
          }
          if(ends[20]>=biggest14202){
            biggest14202=ends[20];
          }
          if(ends[21]>=biggest14202){
            biggest14202=ends[21];
          }
          if(ends[22]>=biggest14202){
            biggest14202=ends[22];
          }
          if(ends[23]>=biggest14202){
            biggest14202=ends[23];
          }
          if(ends[24]>=biggest14202){
            biggest14202=ends[24];
          }
          if(ends[25]>=biggest14202){
            biggest14202=ends[25];
          }
          if(ends[26]>=biggest14202){
            biggest14202=ends[26];
          }
          if(biggest14202 == 1){
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
          thread14203(tdone,ends);
          thread14204(tdone,ends);
          thread14205(tdone,ends);
          thread14206(tdone,ends);
          thread14207(tdone,ends);
          thread14208(tdone,ends);
          thread14209(tdone,ends);
          thread14210(tdone,ends);
          thread14211(tdone,ends);
          thread14212(tdone,ends);
          thread14213(tdone,ends);
          thread14214(tdone,ends);
          thread14215(tdone,ends);
          thread14216(tdone,ends);
          thread14217(tdone,ends);
          thread14218(tdone,ends);
          thread14219(tdone,ends);
          thread14220(tdone,ends);
          thread14221(tdone,ends);
          thread14222(tdone,ends);
          thread14223(tdone,ends);
          thread14224(tdone,ends);
          thread14225(tdone,ends);
          thread14226(tdone,ends);
          thread14227(tdone,ends);
          int biggest14259 = 0;
          if(ends[2]>=biggest14259){
            biggest14259=ends[2];
          }
          if(ends[3]>=biggest14259){
            biggest14259=ends[3];
          }
          if(ends[4]>=biggest14259){
            biggest14259=ends[4];
          }
          if(ends[5]>=biggest14259){
            biggest14259=ends[5];
          }
          if(ends[6]>=biggest14259){
            biggest14259=ends[6];
          }
          if(ends[7]>=biggest14259){
            biggest14259=ends[7];
          }
          if(ends[8]>=biggest14259){
            biggest14259=ends[8];
          }
          if(ends[9]>=biggest14259){
            biggest14259=ends[9];
          }
          if(ends[10]>=biggest14259){
            biggest14259=ends[10];
          }
          if(ends[11]>=biggest14259){
            biggest14259=ends[11];
          }
          if(ends[12]>=biggest14259){
            biggest14259=ends[12];
          }
          if(ends[13]>=biggest14259){
            biggest14259=ends[13];
          }
          if(ends[14]>=biggest14259){
            biggest14259=ends[14];
          }
          if(ends[15]>=biggest14259){
            biggest14259=ends[15];
          }
          if(ends[16]>=biggest14259){
            biggest14259=ends[16];
          }
          if(ends[17]>=biggest14259){
            biggest14259=ends[17];
          }
          if(ends[18]>=biggest14259){
            biggest14259=ends[18];
          }
          if(ends[19]>=biggest14259){
            biggest14259=ends[19];
          }
          if(ends[20]>=biggest14259){
            biggest14259=ends[20];
          }
          if(ends[21]>=biggest14259){
            biggest14259=ends[21];
          }
          if(ends[22]>=biggest14259){
            biggest14259=ends[22];
          }
          if(ends[23]>=biggest14259){
            biggest14259=ends[23];
          }
          if(ends[24]>=biggest14259){
            biggest14259=ends[24];
          }
          if(ends[25]>=biggest14259){
            biggest14259=ends[25];
          }
          if(ends[26]>=biggest14259){
            biggest14259=ends[26];
          }
          if(biggest14259 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest14259 == 0){
            S14144=0;
            active[1]=0;
            ends[1]=0;
            S14144=0;
            break RUN;
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
