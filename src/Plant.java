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
  private Signal capDec_1;
  private Signal l_bottleAdded_1;
  private Signal l_putBottleAt5_1;
  private Signal l_putBottleAt4_1;
  private Signal l_putBottleAt2_1;
  private Signal capPos_1;
  private Signal s_motConveyorOn_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 113, column: 3
  private int numTurns_thread_13;//sysj\plant.sysj line: 203, column: 3
  private Integer chance_thread_14;//sysj\plant.sysj line: 231, column: 3
  private Integer rand_thread_14;//sysj\plant.sysj line: 232, column: 3
  private int nozzlenum_thread_21;//sysj\plant.sysj line: 333, column: 3
  private int S116484 = 1;
  private int S100272 = 1;
  private int S100226 = 1;
  private int S100325 = 1;
  private int S100279 = 1;
  private int S100369 = 1;
  private int S100339 = 1;
  private int S100334 = 1;
  private int S100437 = 1;
  private int S100391 = 1;
  private int S100373 = 1;
  private int S100499 = 1;
  private int S100535 = 1;
  private int S100503 = 1;
  private int S100581 = 1;
  private int S100546 = 1;
  private int S100627 = 1;
  private int S100592 = 1;
  private int S100713 = 1;
  private int S100648 = 1;
  private int S100635 = 1;
  private int S100799 = 1;
  private int S100734 = 1;
  private int S100721 = 1;
  private int S100829 = 1;
  private int S100806 = 1;
  private int S102609 = 1;
  private int S100956 = 1;
  private int S100831 = 1;
  private int S100861 = 1;
  private int S100860 = 1;
  private int S102891 = 1;
  private int S102645 = 1;
  private int S102611 = 1;
  private int S102985 = 1;
  private int S102914 = 1;
  private int S102901 = 1;
  private int S103079 = 1;
  private int S103008 = 1;
  private int S102995 = 1;
  private int S103173 = 1;
  private int S103102 = 1;
  private int S103089 = 1;
  private int S103219 = 1;
  private int S103184 = 1;
  private int S103409 = 1;
  private int S103408 = 1;
  private int S103246 = 1;
  private int S103233 = 1;
  private int S103503 = 1;
  private int S103432 = 1;
  private int S103419 = 1;
  private int S103955 = 1;
  private int S103528 = 1;
  private int S103514 = 1;
  private int S104283 = 1;
  private int S103963 = 1;
  private int S103971 = 1;
  private int S103979 = 1;
  private int S103999 = 1;
  private int S103985 = 1;
  private int S103983 = 1;
  private int S104007 = 1;
  private int S104045 = 1;
  private int S104019 = 1;
  private int S104017 = 1;
  private int S104065 = 1;
  private int S104051 = 1;
  private int S104049 = 1;
  private int S104073 = 1;
  private int S104081 = 1;
  private int S104089 = 1;
  private int S104097 = 1;
  private int S104105 = 1;
  private int S104113 = 1;
  private int S104121 = 1;
  private int S104129 = 1;
  private int S104137 = 1;
  private int S104145 = 1;
  private int S104153 = 1;
  private int S104161 = 1;
  private int S104169 = 1;
  private int S104177 = 1;
  private int S104185 = 1;
  private int S104193 = 1;
  private int S104201 = 1;
  private int S104209 = 1;
  private int S104217 = 1;
  private int S104225 = 1;
  private int S104233 = 1;
  private int S104241 = 1;
  private int S104249 = 1;
  private int S104257 = 1;
  private int S104265 = 1;
  private int S104273 = 1;
  private int S104281 = 1;
  
  private int[] ends = new int[57];
  private int[] tdone = new int[57];
  
  public void thread116597(int [] tdone, int [] ends){
        switch(S104281){
      case 0 : 
        active[56]=0;
        ends[56]=0;
        tdone[56]=1;
        break;
      
      case 1 : 
        if(noz4.getprestatus()){//sysj\plant.sysj line: 446, column: 25
          noz4E.setPresent();//sysj\plant.sysj line: 446, column: 31
          currsigs.addElement(noz4E);
          System.out.println("Emitted noz4E");
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

  public void thread116596(int [] tdone, int [] ends){
        switch(S104273){
      case 0 : 
        active[55]=0;
        ends[55]=0;
        tdone[55]=1;
        break;
      
      case 1 : 
        if(noz3.getprestatus()){//sysj\plant.sysj line: 444, column: 25
          noz3E.setPresent();//sysj\plant.sysj line: 444, column: 31
          currsigs.addElement(noz3E);
          System.out.println("Emitted noz3E");
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

  public void thread116595(int [] tdone, int [] ends){
        switch(S104265){
      case 0 : 
        active[54]=0;
        ends[54]=0;
        tdone[54]=1;
        break;
      
      case 1 : 
        if(noz2.getprestatus()){//sysj\plant.sysj line: 442, column: 25
          noz2E.setPresent();//sysj\plant.sysj line: 442, column: 31
          currsigs.addElement(noz2E);
          System.out.println("Emitted noz2E");
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

  public void thread116594(int [] tdone, int [] ends){
        switch(S104257){
      case 0 : 
        active[53]=0;
        ends[53]=0;
        tdone[53]=1;
        break;
      
      case 1 : 
        if(noz1.getprestatus()){//sysj\plant.sysj line: 440, column: 25
          noz1E.setPresent();//sysj\plant.sysj line: 440, column: 31
          currsigs.addElement(noz1E);
          System.out.println("Emitted noz1E");
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

  public void thread116593(int [] tdone, int [] ends){
        switch(S104249){
      case 0 : 
        active[52]=0;
        ends[52]=0;
        tdone[52]=1;
        break;
      
      case 1 : 
        if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 438, column: 25
          capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 438, column: 44
          currsigs.addElement(capOnBottleAtPos1E);
          System.out.println("Emitted capOnBottleAtPos1E");
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

  public void thread116592(int [] tdone, int [] ends){
        switch(S104241){
      case 0 : 
        active[51]=0;
        ends[51]=0;
        tdone[51]=1;
        break;
      
      case 1 : 
        if(selNoz4.getprestatus()){//sysj\plant.sysj line: 436, column: 25
          o_selNoz4.setPresent();//sysj\plant.sysj line: 436, column: 34
          currsigs.addElement(o_selNoz4);
          System.out.println("Emitted o_selNoz4");
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

  public void thread116591(int [] tdone, int [] ends){
        switch(S104233){
      case 0 : 
        active[50]=0;
        ends[50]=0;
        tdone[50]=1;
        break;
      
      case 1 : 
        if(selNoz3.getprestatus()){//sysj\plant.sysj line: 434, column: 25
          o_selNoz3.setPresent();//sysj\plant.sysj line: 434, column: 34
          currsigs.addElement(o_selNoz3);
          System.out.println("Emitted o_selNoz3");
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

  public void thread116590(int [] tdone, int [] ends){
        switch(S104225){
      case 0 : 
        active[49]=0;
        ends[49]=0;
        tdone[49]=1;
        break;
      
      case 1 : 
        if(selNoz2.getprestatus()){//sysj\plant.sysj line: 432, column: 25
          o_selNoz2.setPresent();//sysj\plant.sysj line: 432, column: 34
          currsigs.addElement(o_selNoz2);
          System.out.println("Emitted o_selNoz2");
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

  public void thread116589(int [] tdone, int [] ends){
        switch(S104217){
      case 0 : 
        active[48]=0;
        ends[48]=0;
        tdone[48]=1;
        break;
      
      case 1 : 
        if(selNoz1.getprestatus()){//sysj\plant.sysj line: 430, column: 25
          o_selNoz1.setPresent();//sysj\plant.sysj line: 430, column: 34
          currsigs.addElement(o_selNoz1);
          System.out.println("Emitted o_selNoz1");
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

  public void thread116588(int [] tdone, int [] ends){
        switch(S104209){
      case 0 : 
        active[47]=0;
        ends[47]=0;
        tdone[47]=1;
        break;
      
      case 1 : 
        if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 427, column: 25
          dosUnitFilledE.setPresent();//sysj\plant.sysj line: 427, column: 40
          currsigs.addElement(dosUnitFilledE);
          System.out.println("Emitted dosUnitFilledE");
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

  public void thread116587(int [] tdone, int [] ends){
        switch(S104201){
      case 0 : 
        active[46]=0;
        ends[46]=0;
        tdone[46]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 425, column: 25
          dosUnitEvacE.setPresent();//sysj\plant.sysj line: 425, column: 38
          currsigs.addElement(dosUnitEvacE);
          System.out.println("Emitted dosUnitEvacE");
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

  public void thread116586(int [] tdone, int [] ends){
        switch(S104193){
      case 0 : 
        active[45]=0;
        ends[45]=0;
        tdone[45]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 423, column: 25
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 423, column: 39
          currsigs.addElement(bottleAtPos2E);
          System.out.println("Emitted bottleAtPos2E");
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

  public void thread116585(int [] tdone, int [] ends){
        switch(S104185){
      case 0 : 
        active[44]=0;
        ends[44]=0;
        tdone[44]=1;
        break;
      
      case 1 : 
        if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 421, column: 25
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 421, column: 45
          currsigs.addElement(dosUnitValveExtendE);
          System.out.println("Emitted dosUnitValveExtendE");
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

  public void thread116584(int [] tdone, int [] ends){
        switch(S104177){
      case 0 : 
        active[43]=0;
        ends[43]=0;
        tdone[43]=1;
        break;
      
      case 1 : 
        if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 419, column: 25
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 419, column: 46
          currsigs.addElement(dosUnitValveRetractE);
          System.out.println("Emitted dosUnitValveRetractE");
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

  public void thread116583(int [] tdone, int [] ends){
        switch(S104169){
      case 0 : 
        active[42]=0;
        ends[42]=0;
        tdone[42]=1;
        break;
      
      case 1 : 
        if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 417, column: 25
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 417, column: 42
          currsigs.addElement(valveInletOnOffE);
          System.out.println("Emitted valveInletOnOffE");
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

  public void thread116582(int [] tdone, int [] ends){
        switch(S104161){
      case 0 : 
        active[41]=0;
        ends[41]=0;
        tdone[41]=1;
        break;
      
      case 1 : 
        if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 415, column: 25
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 415, column: 45
          currsigs.addElement(valveInjectorOnOffE);
          System.out.println("Emitted valveInjectorOnOffE");
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

  public void thread116581(int [] tdone, int [] ends){
        switch(S104153){
      case 0 : 
        active[40]=0;
        ends[40]=0;
        tdone[40]=1;
        break;
      
      case 1 : 
        if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 412, column: 25
          cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 412, column: 47
          currsigs.addElement(cylClampBottleExtendE);
          System.out.println("Emitted cylClampBottleExtendE");
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

  public void thread116580(int [] tdone, int [] ends){
        switch(S104145){
      case 0 : 
        active[39]=0;
        ends[39]=0;
        tdone[39]=1;
        break;
      
      case 1 : 
        if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 410, column: 25
          capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 410, column: 47
          currsigs.addElement(capGripperPos5ExtendE);
          System.out.println("Emitted capGripperPos5ExtendE");
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

  public void thread116579(int [] tdone, int [] ends){
        switch(S104137){
      case 0 : 
        active[38]=0;
        ends[38]=0;
        tdone[38]=1;
        break;
      
      case 1 : 
        if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 408, column: 25
          gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 408, column: 44
          currsigs.addElement(gripperTurnExtendE);
          System.out.println("Emitted gripperTurnExtendE");
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

  public void thread116578(int [] tdone, int [] ends){
        switch(S104129){
      case 0 : 
        active[37]=0;
        ends[37]=0;
        tdone[37]=1;
        break;
      
      case 1 : 
        if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 406, column: 25
          gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 406, column: 45
          currsigs.addElement(gripperTurnRetractE);
          System.out.println("Emitted gripperTurnRetractE");
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

  public void thread116577(int [] tdone, int [] ends){
        switch(S104121){
      case 0 : 
        active[36]=0;
        ends[36]=0;
        tdone[36]=1;
        break;
      
      case 1 : 
        if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 404, column: 25
          cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 404, column: 45
          currsigs.addElement(cylPos5ZaxisExtendE);
          System.out.println("Emitted cylPos5ZaxisExtendE");
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

  public void thread116576(int [] tdone, int [] ends){
        switch(S104113){
      case 0 : 
        active[35]=0;
        ends[35]=0;
        tdone[35]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 402, column: 25
          gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 402, column: 45
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

  public void thread116575(int [] tdone, int [] ends){
        switch(S104105){
      case 0 : 
        active[34]=0;
        ends[34]=0;
        tdone[34]=1;
        break;
      
      case 1 : 
        if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 399, column: 25
          gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 399, column: 45
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

  public void thread116574(int [] tdone, int [] ends){
        switch(S104097){
      case 0 : 
        active[33]=0;
        ends[33]=0;
        tdone[33]=1;
        break;
      
      case 1 : 
        if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 397, column: 25
          gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 397, column: 46
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

  public void thread116573(int [] tdone, int [] ends){
        switch(S104089){
      case 0 : 
        active[32]=0;
        ends[32]=0;
        tdone[32]=1;
        break;
      
      case 1 : 
        if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 395, column: 25
          gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 395, column: 46
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

  public void thread116572(int [] tdone, int [] ends){
        switch(S104081){
      case 0 : 
        active[31]=0;
        ends[31]=0;
        tdone[31]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 393, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 393, column: 38
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

  public void thread116571(int [] tdone, int [] ends){
        switch(S104073){
      case 0 : 
        active[30]=0;
        ends[30]=0;
        tdone[30]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 391, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 391, column: 38
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

  public void thread116570(int [] tdone, int [] ends){
        switch(S104065){
      case 0 : 
        active[29]=0;
        ends[29]=0;
        tdone[29]=1;
        break;
      
      case 1 : 
        switch(S104051){
          case 0 : 
            switch(S104049){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 389, column: 54
                  S104049=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 389, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 389, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  System.out.println("Emitted bottleAtPos5_RT");
                  S104051=1;
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
            S104051=1;
            S104051=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 389, column: 24
              S104049=0;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            else {
              S104051=1;
              active[29]=1;
              ends[29]=1;
              tdone[29]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread116569(int [] tdone, int [] ends){
        switch(S104045){
      case 0 : 
        active[28]=0;
        ends[28]=0;
        tdone[28]=1;
        break;
      
      case 1 : 
        switch(S104019){
          case 0 : 
            switch(S104017){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 380, column: 11
                  S104017=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 382, column: 6
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 381, column: 11
                  S104019=1;
                  active[28]=1;
                  ends[28]=1;
                  tdone[28]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 382, column: 6
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
            S104019=1;
            S104019=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 379, column: 12
              S104017=0;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            else {
              S104019=1;
              active[28]=1;
              ends[28]=1;
              tdone[28]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread116568(int [] tdone, int [] ends){
        switch(S104007){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 376, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 376, column: 56
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

  public void thread116567(int [] tdone, int [] ends){
        switch(S103999){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S103985){
          case 0 : 
            switch(S103983){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 374, column: 54
                  S103983=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 374, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 374, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  System.out.println("Emitted bottleAtPos1_RT");
                  S103985=1;
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
            S103985=1;
            S103985=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 374, column: 24
              S103983=0;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S103985=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread116566(int [] tdone, int [] ends){
        switch(S103979){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 372, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 372, column: 44
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

  public void thread116565(int [] tdone, int [] ends){
        switch(S103971){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 370, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 370, column: 39
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

  public void thread116564(int [] tdone, int [] ends){
        switch(S103963){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 368, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 368, column: 38
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

  public void thread116563(int [] tdone, int [] ends){
        switch(S104283){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        thread116564(tdone,ends);
        thread116565(tdone,ends);
        thread116566(tdone,ends);
        thread116567(tdone,ends);
        thread116568(tdone,ends);
        thread116569(tdone,ends);
        thread116570(tdone,ends);
        thread116571(tdone,ends);
        thread116572(tdone,ends);
        thread116573(tdone,ends);
        thread116574(tdone,ends);
        thread116575(tdone,ends);
        thread116576(tdone,ends);
        thread116577(tdone,ends);
        thread116578(tdone,ends);
        thread116579(tdone,ends);
        thread116580(tdone,ends);
        thread116581(tdone,ends);
        thread116582(tdone,ends);
        thread116583(tdone,ends);
        thread116584(tdone,ends);
        thread116585(tdone,ends);
        thread116586(tdone,ends);
        thread116587(tdone,ends);
        thread116588(tdone,ends);
        thread116589(tdone,ends);
        thread116590(tdone,ends);
        thread116591(tdone,ends);
        thread116592(tdone,ends);
        thread116593(tdone,ends);
        thread116594(tdone,ends);
        thread116595(tdone,ends);
        thread116596(tdone,ends);
        thread116597(tdone,ends);
        int biggest116598 = 0;
        if(ends[23]>=biggest116598){
          biggest116598=ends[23];
        }
        if(ends[24]>=biggest116598){
          biggest116598=ends[24];
        }
        if(ends[25]>=biggest116598){
          biggest116598=ends[25];
        }
        if(ends[26]>=biggest116598){
          biggest116598=ends[26];
        }
        if(ends[27]>=biggest116598){
          biggest116598=ends[27];
        }
        if(ends[28]>=biggest116598){
          biggest116598=ends[28];
        }
        if(ends[29]>=biggest116598){
          biggest116598=ends[29];
        }
        if(ends[30]>=biggest116598){
          biggest116598=ends[30];
        }
        if(ends[31]>=biggest116598){
          biggest116598=ends[31];
        }
        if(ends[32]>=biggest116598){
          biggest116598=ends[32];
        }
        if(ends[33]>=biggest116598){
          biggest116598=ends[33];
        }
        if(ends[34]>=biggest116598){
          biggest116598=ends[34];
        }
        if(ends[35]>=biggest116598){
          biggest116598=ends[35];
        }
        if(ends[36]>=biggest116598){
          biggest116598=ends[36];
        }
        if(ends[37]>=biggest116598){
          biggest116598=ends[37];
        }
        if(ends[38]>=biggest116598){
          biggest116598=ends[38];
        }
        if(ends[39]>=biggest116598){
          biggest116598=ends[39];
        }
        if(ends[40]>=biggest116598){
          biggest116598=ends[40];
        }
        if(ends[41]>=biggest116598){
          biggest116598=ends[41];
        }
        if(ends[42]>=biggest116598){
          biggest116598=ends[42];
        }
        if(ends[43]>=biggest116598){
          biggest116598=ends[43];
        }
        if(ends[44]>=biggest116598){
          biggest116598=ends[44];
        }
        if(ends[45]>=biggest116598){
          biggest116598=ends[45];
        }
        if(ends[46]>=biggest116598){
          biggest116598=ends[46];
        }
        if(ends[47]>=biggest116598){
          biggest116598=ends[47];
        }
        if(ends[48]>=biggest116598){
          biggest116598=ends[48];
        }
        if(ends[49]>=biggest116598){
          biggest116598=ends[49];
        }
        if(ends[50]>=biggest116598){
          biggest116598=ends[50];
        }
        if(ends[51]>=biggest116598){
          biggest116598=ends[51];
        }
        if(ends[52]>=biggest116598){
          biggest116598=ends[52];
        }
        if(ends[53]>=biggest116598){
          biggest116598=ends[53];
        }
        if(ends[54]>=biggest116598){
          biggest116598=ends[54];
        }
        if(ends[55]>=biggest116598){
          biggest116598=ends[55];
        }
        if(ends[56]>=biggest116598){
          biggest116598=ends[56];
        }
        if(biggest116598 == 1){
          active[22]=1;
          ends[22]=1;
          tdone[22]=1;
        }
        //FINXME code
        if(biggest116598 == 0){
          S104283=0;
          active[22]=0;
          ends[22]=0;
          tdone[22]=1;
        }
        break;
      
    }
  }

  public void thread116562(int [] tdone, int [] ends){
        switch(S103955){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S103528){
          case 0 : 
            S103528=0;
            S103528=1;
            if(turnNozTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 337, column: 13
              S103514=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S103528=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
          case 1 : 
            if(!turnNozTrigger.getprestatus()){//sysj\plant.sysj line: 336, column: 10
              S103528=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              switch(S103514){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 338, column: 12
                    nozzlenum_thread_21 = nozzlenum_thread_21 + 1;//sysj\plant.sysj line: 339, column: 6
                    if(nozzlenum_thread_21 == 1){//sysj\plant.sysj line: 340, column: 9
                      noz1.setPresent();//sysj\plant.sysj line: 341, column: 7
                      currsigs.addElement(noz1);
                      System.out.println("Emitted noz1");
                      S103528=0;
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      if(nozzlenum_thread_21 == 2){//sysj\plant.sysj line: 342, column: 15
                        noz2.setPresent();//sysj\plant.sysj line: 343, column: 7
                        currsigs.addElement(noz2);
                        System.out.println("Emitted noz2");
                        S103528=0;
                        active[21]=1;
                        ends[21]=1;
                        tdone[21]=1;
                      }
                      else {
                        if(nozzlenum_thread_21 == 3){//sysj\plant.sysj line: 344, column: 15
                          noz3.setPresent();//sysj\plant.sysj line: 345, column: 7
                          currsigs.addElement(noz3);
                          System.out.println("Emitted noz3");
                          S103528=0;
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                        else {
                          noz4.setPresent();//sysj\plant.sysj line: 347, column: 7
                          currsigs.addElement(noz4);
                          System.out.println("Emitted noz4");
                          nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 348, column: 7
                          S103528=0;
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
                  S103528=0;
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

  public void thread116561(int [] tdone, int [] ends){
        switch(S103503){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S103432){
          case 0 : 
            S103432=0;
            S103432=1;
            if(dosUnitValveRetract.getprestatus() && enable.getprestatus() && valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 322, column: 12
              S103419=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S103432=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
          case 1 : 
            switch(S103419){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 323, column: 11
                  S103419=1;
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 325, column: 6
                  currsigs.addElement(dosUnitFilled);
                  System.out.println("Emitted dosUnitFilled");
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
                  S103432=0;
                  active[20]=1;
                  ends[20]=1;
                  tdone[20]=1;
                }
                else {
                  dosUnitFilled.setPresent();//sysj\plant.sysj line: 325, column: 6
                  currsigs.addElement(dosUnitFilled);
                  System.out.println("Emitted dosUnitFilled");
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

  public void thread116560(int [] tdone, int [] ends){
        switch(S103409){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S103408){
          case 0 : 
            if(dosUnitValveRetract.getprestatus() || dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 305, column: 9
              S103408=1;
              S103246=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              dosUnitEvac.setPresent();//sysj\plant.sysj line: 306, column: 4
              currsigs.addElement(dosUnitEvac);
              System.out.println("Emitted dosUnitEvac");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S103246){
              case 0 : 
                S103246=0;
                S103246=1;
                if(dosUnitValveExtend.getprestatus() && enable.getprestatus() && valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 310, column: 12
                  S103233=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S103246=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                break;
              
              case 1 : 
                switch(S103233){
                  case 0 : 
                    if(!enable.getprestatus()){//sysj\plant.sysj line: 311, column: 11
                      S103233=1;
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 313, column: 6
                      currsigs.addElement(dosUnitEvac);
                      System.out.println("Emitted dosUnitEvac");
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
                      S103246=0;
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    else {
                      dosUnitEvac.setPresent();//sysj\plant.sysj line: 313, column: 6
                      currsigs.addElement(dosUnitEvac);
                      System.out.println("Emitted dosUnitEvac");
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

  public void thread116559(int [] tdone, int [] ends){
        switch(S103219){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S103184){
          case 0 : 
            S103184=0;
            S103184=1;
            if(!cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 292, column: 12
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 294, column: 6
              currsigs.addElement(gripperZAxisLifted);
              System.out.println("Emitted gripperZAxisLifted");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              S103184=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
          case 1 : 
            if(cylPos5ZAxisExtend.getprestatus()){//sysj\plant.sysj line: 293, column: 11
              S103184=0;
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            else {
              gripperZAxisLifted.setPresent();//sysj\plant.sysj line: 294, column: 6
              currsigs.addElement(gripperZAxisLifted);
              System.out.println("Emitted gripperZAxisLifted");
              active[18]=1;
              ends[18]=1;
              tdone[18]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread116558(int [] tdone, int [] ends){
        switch(S103173){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S103102){
          case 0 : 
            S103102=0;
            S103102=1;
            if(gripperTurnRetract.getprestatus() && enable.getprestatus() && !gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 280, column: 12
              S103089=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
              S103102=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 1 : 
            switch(S103089){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 281, column: 11
                  S103089=1;
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 283, column: 6
                  currsigs.addElement(gripperTurnHomePos);
                  System.out.println("Emitted gripperTurnHomePos");
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
                  S103102=0;
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
                else {
                  gripperTurnHomePos.setPresent();//sysj\plant.sysj line: 283, column: 6
                  currsigs.addElement(gripperTurnHomePos);
                  System.out.println("Emitted gripperTurnHomePos");
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

  public void thread116557(int [] tdone, int [] ends){
        switch(S103079){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S103008){
          case 0 : 
            S103008=0;
            S103008=1;
            if(gripperTurnExtend.getprestatus() && enable.getprestatus() && !gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 268, column: 12
              S102995=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            else {
              S103008=0;
              active[16]=1;
              ends[16]=1;
              tdone[16]=1;
            }
            break;
          
          case 1 : 
            switch(S102995){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 269, column: 11
                  S102995=1;
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 271, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
                  System.out.println("Emitted gripperTurnFinalPos");
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
                  S103008=0;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  gripperTurnFinalPos.setPresent();//sysj\plant.sysj line: 271, column: 6
                  currsigs.addElement(gripperTurnFinalPos);
                  System.out.println("Emitted gripperTurnFinalPos");
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

  public void thread116556(int [] tdone, int [] ends){
        switch(S102985){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S102914){
          case 0 : 
            S102914=0;
            S102914=1;
            if(cylPos5ZAxisExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 256, column: 12
              S102901=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              S102914=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 1 : 
            switch(S102901){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 257, column: 11
                  S102901=1;
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 259, column: 6
                  currsigs.addElement(gripperZAxisLowered);
                  System.out.println("Emitted gripperZAxisLowered");
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
                  S102914=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  gripperZAxisLowered.setPresent();//sysj\plant.sysj line: 259, column: 6
                  currsigs.addElement(gripperZAxisLowered);
                  System.out.println("Emitted gripperZAxisLowered");
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

  public void thread116555(int [] tdone, int [] ends){
        switch(S102891){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S102645){
          case 0 : 
            S102645=0;
            S102645=1;
            if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 236, column: 12
              rand_thread_14 = (int)(Math.random() * 100);//sysj\plant.sysj line: 237, column: 5
              System.out.println(rand_thread_14);//sysj\plant.sysj line: 238, column: 5
              S102611=0;
              if(rand_thread_14 < chance_thread_14){//sysj\plant.sysj line: 239, column: 8
                capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 241, column: 8
                currsigs.addElement(capOnBottleAtPos1);
                System.out.println("Emitted capOnBottleAtPos1");
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S102611=1;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              S102645=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 1 : 
            switch(S102611){
              case 0 : 
                if(removeBottle.getprestatus()){//sysj\plant.sysj line: 240, column: 12
                  S102611=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  capOnBottleAtPos1.setPresent();//sysj\plant.sysj line: 241, column: 8
                  currsigs.addElement(capOnBottleAtPos1);
                  System.out.println("Emitted capOnBottleAtPos1");
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 245, column: 11
                  S102611=2;
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
                  S102645=0;
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

  public void thread116554(int [] tdone, int [] ends){
        switch(S102609){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S100956){
          case 0 : 
            S100956=0;
            S100956=1;
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 206, column: 12
              S100831=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              S100956=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
          case 1 : 
            switch(S100831){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 207, column: 11
                  numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 208, column: 5
                  S100831=1;
                  if(numTurns_thread_13 >= 2 && numTurns_thread_13 < 3){//sysj\plant.sysj line: 209, column: 8
                    S100861=0;
                    l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 210, column: 6
                    currsigs.addElement(l_putBottleAt2_1);
                    System.out.println("Emitted l_putBottleAt2_1");
                    tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 212, column: 7
                    currsigs.addElement(tableAlignedWithSensor);
                    System.out.println("Emitted tableAlignedWithSensor");
                    active[13]=1;
                    ends[13]=1;
                    tdone[13]=1;
                  }
                  else {
                    S100861=1;
                    if(numTurns_thread_13 >= 3 && numTurns_thread_13 < 4){//sysj\plant.sysj line: 214, column: 14
                      S100860=0;
                      l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 215, column: 6
                      currsigs.addElement(l_putBottleAt4_1);
                      System.out.println("Emitted l_putBottleAt4_1");
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 217, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      System.out.println("Emitted tableAlignedWithSensor");
                      active[13]=1;
                      ends[13]=1;
                      tdone[13]=1;
                    }
                    else {
                      S100860=1;
                      if(numTurns_thread_13 >= 4){//sysj\plant.sysj line: 219, column: 14
                        numTurns_thread_13 = 0;//sysj\plant.sysj line: 220, column: 6
                        l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 221, column: 6
                        currsigs.addElement(l_putBottleAt5_1);
                        System.out.println("Emitted l_putBottleAt5_1");
                        tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 223, column: 7
                        currsigs.addElement(tableAlignedWithSensor);
                        System.out.println("Emitted tableAlignedWithSensor");
                        active[13]=1;
                        ends[13]=1;
                        tdone[13]=1;
                      }
                      else {
                        S100956=0;
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
                switch(S100861){
                  case 0 : 
                    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                      S100956=0;
                      active[13]=1;
                      ends[13]=1;
                      tdone[13]=1;
                    }
                    else {
                      tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 212, column: 7
                      currsigs.addElement(tableAlignedWithSensor);
                      System.out.println("Emitted tableAlignedWithSensor");
                      active[13]=1;
                      ends[13]=1;
                      tdone[13]=1;
                    }
                    break;
                  
                  case 1 : 
                    switch(S100860){
                      case 0 : 
                        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 216, column: 12
                          S100956=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        else {
                          tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 217, column: 7
                          currsigs.addElement(tableAlignedWithSensor);
                          System.out.println("Emitted tableAlignedWithSensor");
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        break;
                      
                      case 1 : 
                        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 222, column: 12
                          S100956=0;
                          active[13]=1;
                          ends[13]=1;
                          tdone[13]=1;
                        }
                        else {
                          tableAlignedWithSensor.setPresent();//sysj\plant.sysj line: 223, column: 7
                          currsigs.addElement(tableAlignedWithSensor);
                          System.out.println("Emitted tableAlignedWithSensor");
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

  public void thread116553(int [] tdone, int [] ends){
        switch(S100829){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        switch(S100806){
          case 0 : 
            S100806=0;
            S100806=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 193, column: 12
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              S100806=0;
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
              S100806=0;
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

  public void thread116552(int [] tdone, int [] ends){
        switch(S100799){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        switch(S100734){
          case 0 : 
            S100734=0;
            S100734=1;
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 181, column: 12
              S100721=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              S100734=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos4.getprestatus())){//sysj\plant.sysj line: 182, column: 11
              S100734=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S100721){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 183, column: 12
                    S100721=1;
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

  public void thread116551(int [] tdone, int [] ends){
        switch(S100713){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S100648){
          case 0 : 
            S100648=0;
            S100648=1;
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 169, column: 12
              S100635=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S100648=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if((bottleAtPos5.getprestatus())){//sysj\plant.sysj line: 170, column: 11
              S100648=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S100635){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 171, column: 12
                    S100635=1;
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

  public void thread116550(int [] tdone, int [] ends){
        switch(S100627){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        switch(S100592){
          case 0 : 
            S100592=0;
            S100592=1;
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 158, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 160, column: 6
              currsigs.addElement(bottleAtPos5);
              System.out.println("Emitted bottleAtPos5");
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              S100592=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            break;
          
          case 1 : 
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 159, column: 11
              S100592=0;
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

  public void thread116549(int [] tdone, int [] ends){
        switch(S100581){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        switch(S100546){
          case 0 : 
            S100546=0;
            S100546=1;
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 147, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 149, column: 6
              currsigs.addElement(l_bottleAdded_1);
              System.out.println("Emitted l_bottleAdded_1");
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              S100546=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            break;
          
          case 1 : 
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 148, column: 11
              S100546=0;
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

  public void thread116548(int [] tdone, int [] ends){
        switch(S100535){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
        switch(S100503){
          case 0 : 
            S100503=0;
            S100503=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 136, column: 11
              S100503=2;
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
              S100503=0;
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

  public void thread116547(int [] tdone, int [] ends){
        switch(S100499){
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

  public void thread116546(int [] tdone, int [] ends){
        switch(S100437){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S100391){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 98, column: 10
              S100391=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S100373){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 100, column: 13
                    S100373=1;
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
                    S100373=2;
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
                    S100373=0;
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
              S100391=0;
              S100373=0;
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

  public void thread116545(int [] tdone, int [] ends){
        switch(S100369){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S100339){
          case 0 : 
            switch(S100334){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 78, column: 12
                  S100334=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 81, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 82, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 82, column: 7
                    System.out.println("Emitted capPos_1");
                    S100339=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S100339=1;
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
                S100339=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                    System.out.println("Emitted capPos_1");
                    S100334=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                    currsigs.addElement(WPgripped);
                    System.out.println("Emitted WPgripped");
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S100339=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S100339=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S100339=1;
            S100339=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
                System.out.println("Emitted capPos_1");
                S100334=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
                currsigs.addElement(WPgripped);
                System.out.println("Emitted WPgripped");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S100339=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S100339=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread116544(int [] tdone, int [] ends){
        switch(S100325){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S100279){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 62, column: 10
              S100279=1;
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
              S100279=2;
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
              S100279=3;
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
              S100279=0;
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

  public void thread116543(int [] tdone, int [] ends){
        switch(S100272){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S100226){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 49, column: 10
              S100226=1;
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
              S100226=2;
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
              S100226=3;
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
              S100226=0;
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

  public void thread116540(int [] tdone, int [] ends){
        S104281=1;
    if(noz4.getprestatus()){//sysj\plant.sysj line: 446, column: 25
      noz4E.setPresent();//sysj\plant.sysj line: 446, column: 31
      currsigs.addElement(noz4E);
      System.out.println("Emitted noz4E");
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

  public void thread116539(int [] tdone, int [] ends){
        S104273=1;
    if(noz3.getprestatus()){//sysj\plant.sysj line: 444, column: 25
      noz3E.setPresent();//sysj\plant.sysj line: 444, column: 31
      currsigs.addElement(noz3E);
      System.out.println("Emitted noz3E");
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

  public void thread116538(int [] tdone, int [] ends){
        S104265=1;
    if(noz2.getprestatus()){//sysj\plant.sysj line: 442, column: 25
      noz2E.setPresent();//sysj\plant.sysj line: 442, column: 31
      currsigs.addElement(noz2E);
      System.out.println("Emitted noz2E");
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

  public void thread116537(int [] tdone, int [] ends){
        S104257=1;
    if(noz1.getprestatus()){//sysj\plant.sysj line: 440, column: 25
      noz1E.setPresent();//sysj\plant.sysj line: 440, column: 31
      currsigs.addElement(noz1E);
      System.out.println("Emitted noz1E");
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

  public void thread116536(int [] tdone, int [] ends){
        S104249=1;
    if(capOnBottleAtPos1.getprestatus()){//sysj\plant.sysj line: 438, column: 25
      capOnBottleAtPos1E.setPresent();//sysj\plant.sysj line: 438, column: 44
      currsigs.addElement(capOnBottleAtPos1E);
      System.out.println("Emitted capOnBottleAtPos1E");
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

  public void thread116535(int [] tdone, int [] ends){
        S104241=1;
    if(selNoz4.getprestatus()){//sysj\plant.sysj line: 436, column: 25
      o_selNoz4.setPresent();//sysj\plant.sysj line: 436, column: 34
      currsigs.addElement(o_selNoz4);
      System.out.println("Emitted o_selNoz4");
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

  public void thread116534(int [] tdone, int [] ends){
        S104233=1;
    if(selNoz3.getprestatus()){//sysj\plant.sysj line: 434, column: 25
      o_selNoz3.setPresent();//sysj\plant.sysj line: 434, column: 34
      currsigs.addElement(o_selNoz3);
      System.out.println("Emitted o_selNoz3");
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

  public void thread116533(int [] tdone, int [] ends){
        S104225=1;
    if(selNoz2.getprestatus()){//sysj\plant.sysj line: 432, column: 25
      o_selNoz2.setPresent();//sysj\plant.sysj line: 432, column: 34
      currsigs.addElement(o_selNoz2);
      System.out.println("Emitted o_selNoz2");
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

  public void thread116532(int [] tdone, int [] ends){
        S104217=1;
    if(selNoz1.getprestatus()){//sysj\plant.sysj line: 430, column: 25
      o_selNoz1.setPresent();//sysj\plant.sysj line: 430, column: 34
      currsigs.addElement(o_selNoz1);
      System.out.println("Emitted o_selNoz1");
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

  public void thread116531(int [] tdone, int [] ends){
        S104209=1;
    if(dosUnitFilled.getprestatus()){//sysj\plant.sysj line: 427, column: 25
      dosUnitFilledE.setPresent();//sysj\plant.sysj line: 427, column: 40
      currsigs.addElement(dosUnitFilledE);
      System.out.println("Emitted dosUnitFilledE");
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

  public void thread116530(int [] tdone, int [] ends){
        S104201=1;
    if(dosUnitEvac.getprestatus()){//sysj\plant.sysj line: 425, column: 25
      dosUnitEvacE.setPresent();//sysj\plant.sysj line: 425, column: 38
      currsigs.addElement(dosUnitEvacE);
      System.out.println("Emitted dosUnitEvacE");
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

  public void thread116529(int [] tdone, int [] ends){
        S104193=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 423, column: 25
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 423, column: 39
      currsigs.addElement(bottleAtPos2E);
      System.out.println("Emitted bottleAtPos2E");
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

  public void thread116528(int [] tdone, int [] ends){
        S104185=1;
    if(dosUnitValveExtend.getprestatus()){//sysj\plant.sysj line: 421, column: 25
      dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 421, column: 45
      currsigs.addElement(dosUnitValveExtendE);
      System.out.println("Emitted dosUnitValveExtendE");
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

  public void thread116527(int [] tdone, int [] ends){
        S104177=1;
    if(dosUnitValveRetract.getprestatus()){//sysj\plant.sysj line: 419, column: 25
      dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 419, column: 46
      currsigs.addElement(dosUnitValveRetractE);
      System.out.println("Emitted dosUnitValveRetractE");
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

  public void thread116526(int [] tdone, int [] ends){
        S104169=1;
    if(valveInletOnOff.getprestatus()){//sysj\plant.sysj line: 417, column: 25
      valveInletOnOffE.setPresent();//sysj\plant.sysj line: 417, column: 42
      currsigs.addElement(valveInletOnOffE);
      System.out.println("Emitted valveInletOnOffE");
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

  public void thread116525(int [] tdone, int [] ends){
        S104161=1;
    if(valveInjectorOnOff.getprestatus()){//sysj\plant.sysj line: 415, column: 25
      valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 415, column: 45
      currsigs.addElement(valveInjectorOnOffE);
      System.out.println("Emitted valveInjectorOnOffE");
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

  public void thread116524(int [] tdone, int [] ends){
        S104153=1;
    if(cylClampBottleExtend.getprestatus()){//sysj\plant.sysj line: 412, column: 25
      cylClampBottleExtendE.setPresent();//sysj\plant.sysj line: 412, column: 47
      currsigs.addElement(cylClampBottleExtendE);
      System.out.println("Emitted cylClampBottleExtendE");
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

  public void thread116523(int [] tdone, int [] ends){
        S104145=1;
    if(capGripperPos5Extend.getprestatus()){//sysj\plant.sysj line: 410, column: 25
      capGripperPos5ExtendE.setPresent();//sysj\plant.sysj line: 410, column: 47
      currsigs.addElement(capGripperPos5ExtendE);
      System.out.println("Emitted capGripperPos5ExtendE");
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

  public void thread116522(int [] tdone, int [] ends){
        S104137=1;
    if(gripperTurnExtend.getprestatus()){//sysj\plant.sysj line: 408, column: 25
      gripperTurnExtendE.setPresent();//sysj\plant.sysj line: 408, column: 44
      currsigs.addElement(gripperTurnExtendE);
      System.out.println("Emitted gripperTurnExtendE");
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

  public void thread116521(int [] tdone, int [] ends){
        S104129=1;
    if(gripperTurnRetract.getprestatus()){//sysj\plant.sysj line: 406, column: 25
      gripperTurnRetractE.setPresent();//sysj\plant.sysj line: 406, column: 45
      currsigs.addElement(gripperTurnRetractE);
      System.out.println("Emitted gripperTurnRetractE");
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

  public void thread116520(int [] tdone, int [] ends){
        S104121=1;
    if(cylPos5ZaxisExtend.getprestatus()){//sysj\plant.sysj line: 404, column: 25
      cylPos5ZaxisExtendE.setPresent();//sysj\plant.sysj line: 404, column: 45
      currsigs.addElement(cylPos5ZaxisExtendE);
      System.out.println("Emitted cylPos5ZaxisExtendE");
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

  public void thread116519(int [] tdone, int [] ends){
        S104113=1;
    if(gripperZAxisLifted.getprestatus()){//sysj\plant.sysj line: 402, column: 25
      gripperZAxisLiftedE.setPresent();//sysj\plant.sysj line: 402, column: 45
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

  public void thread116518(int [] tdone, int [] ends){
        S104105=1;
    if(gripperTurnHomePos.getprestatus()){//sysj\plant.sysj line: 399, column: 25
      gripperTurnHomePosE.setPresent();//sysj\plant.sysj line: 399, column: 45
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

  public void thread116517(int [] tdone, int [] ends){
        S104097=1;
    if(gripperTurnFinalPos.getprestatus()){//sysj\plant.sysj line: 397, column: 25
      gripperTurnFinalPosE.setPresent();//sysj\plant.sysj line: 397, column: 46
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

  public void thread116516(int [] tdone, int [] ends){
        S104089=1;
    if(gripperZAxisLowered.getprestatus()){//sysj\plant.sysj line: 395, column: 25
      gripperZAxisLoweredE.setPresent();//sysj\plant.sysj line: 395, column: 46
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

  public void thread116515(int [] tdone, int [] ends){
        S104081=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 393, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 393, column: 38
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

  public void thread116514(int [] tdone, int [] ends){
        S104073=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 391, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 391, column: 38
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

  public void thread116513(int [] tdone, int [] ends){
        S104065=1;
    S104051=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 389, column: 24
      S104049=0;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
    else {
      S104051=1;
      active[29]=1;
      ends[29]=1;
      tdone[29]=1;
    }
  }

  public void thread116512(int [] tdone, int [] ends){
        S104045=1;
    S104019=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 379, column: 12
      S104017=0;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
    else {
      S104019=1;
      active[28]=1;
      ends[28]=1;
      tdone[28]=1;
    }
  }

  public void thread116511(int [] tdone, int [] ends){
        S104007=1;
    if(bottleAtPos5.getprestatus() || l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 376, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 376, column: 56
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

  public void thread116510(int [] tdone, int [] ends){
        S103999=1;
    S103985=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 374, column: 24
      S103983=0;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      S103985=1;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread116509(int [] tdone, int [] ends){
        S103979=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 372, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 372, column: 44
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

  public void thread116508(int [] tdone, int [] ends){
        S103971=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 370, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 370, column: 39
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

  public void thread116507(int [] tdone, int [] ends){
        S103963=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 368, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 368, column: 38
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

  public void thread116506(int [] tdone, int [] ends){
        S104283=1;
    thread116507(tdone,ends);
    thread116508(tdone,ends);
    thread116509(tdone,ends);
    thread116510(tdone,ends);
    thread116511(tdone,ends);
    thread116512(tdone,ends);
    thread116513(tdone,ends);
    thread116514(tdone,ends);
    thread116515(tdone,ends);
    thread116516(tdone,ends);
    thread116517(tdone,ends);
    thread116518(tdone,ends);
    thread116519(tdone,ends);
    thread116520(tdone,ends);
    thread116521(tdone,ends);
    thread116522(tdone,ends);
    thread116523(tdone,ends);
    thread116524(tdone,ends);
    thread116525(tdone,ends);
    thread116526(tdone,ends);
    thread116527(tdone,ends);
    thread116528(tdone,ends);
    thread116529(tdone,ends);
    thread116530(tdone,ends);
    thread116531(tdone,ends);
    thread116532(tdone,ends);
    thread116533(tdone,ends);
    thread116534(tdone,ends);
    thread116535(tdone,ends);
    thread116536(tdone,ends);
    thread116537(tdone,ends);
    thread116538(tdone,ends);
    thread116539(tdone,ends);
    thread116540(tdone,ends);
    int biggest116541 = 0;
    if(ends[23]>=biggest116541){
      biggest116541=ends[23];
    }
    if(ends[24]>=biggest116541){
      biggest116541=ends[24];
    }
    if(ends[25]>=biggest116541){
      biggest116541=ends[25];
    }
    if(ends[26]>=biggest116541){
      biggest116541=ends[26];
    }
    if(ends[27]>=biggest116541){
      biggest116541=ends[27];
    }
    if(ends[28]>=biggest116541){
      biggest116541=ends[28];
    }
    if(ends[29]>=biggest116541){
      biggest116541=ends[29];
    }
    if(ends[30]>=biggest116541){
      biggest116541=ends[30];
    }
    if(ends[31]>=biggest116541){
      biggest116541=ends[31];
    }
    if(ends[32]>=biggest116541){
      biggest116541=ends[32];
    }
    if(ends[33]>=biggest116541){
      biggest116541=ends[33];
    }
    if(ends[34]>=biggest116541){
      biggest116541=ends[34];
    }
    if(ends[35]>=biggest116541){
      biggest116541=ends[35];
    }
    if(ends[36]>=biggest116541){
      biggest116541=ends[36];
    }
    if(ends[37]>=biggest116541){
      biggest116541=ends[37];
    }
    if(ends[38]>=biggest116541){
      biggest116541=ends[38];
    }
    if(ends[39]>=biggest116541){
      biggest116541=ends[39];
    }
    if(ends[40]>=biggest116541){
      biggest116541=ends[40];
    }
    if(ends[41]>=biggest116541){
      biggest116541=ends[41];
    }
    if(ends[42]>=biggest116541){
      biggest116541=ends[42];
    }
    if(ends[43]>=biggest116541){
      biggest116541=ends[43];
    }
    if(ends[44]>=biggest116541){
      biggest116541=ends[44];
    }
    if(ends[45]>=biggest116541){
      biggest116541=ends[45];
    }
    if(ends[46]>=biggest116541){
      biggest116541=ends[46];
    }
    if(ends[47]>=biggest116541){
      biggest116541=ends[47];
    }
    if(ends[48]>=biggest116541){
      biggest116541=ends[48];
    }
    if(ends[49]>=biggest116541){
      biggest116541=ends[49];
    }
    if(ends[50]>=biggest116541){
      biggest116541=ends[50];
    }
    if(ends[51]>=biggest116541){
      biggest116541=ends[51];
    }
    if(ends[52]>=biggest116541){
      biggest116541=ends[52];
    }
    if(ends[53]>=biggest116541){
      biggest116541=ends[53];
    }
    if(ends[54]>=biggest116541){
      biggest116541=ends[54];
    }
    if(ends[55]>=biggest116541){
      biggest116541=ends[55];
    }
    if(ends[56]>=biggest116541){
      biggest116541=ends[56];
    }
    if(biggest116541 == 1){
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread116505(int [] tdone, int [] ends){
        S103955=1;
    nozzlenum_thread_21 = 0;//sysj\plant.sysj line: 333, column: 3
    S103528=0;
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread116504(int [] tdone, int [] ends){
        S103503=1;
    S103432=0;
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread116503(int [] tdone, int [] ends){
        S103409=1;
    S103408=0;
    dosUnitEvac.setPresent();//sysj\plant.sysj line: 306, column: 4
    currsigs.addElement(dosUnitEvac);
    System.out.println("Emitted dosUnitEvac");
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread116502(int [] tdone, int [] ends){
        S103219=1;
    S103184=0;
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread116501(int [] tdone, int [] ends){
        S103173=1;
    S103102=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread116500(int [] tdone, int [] ends){
        S103079=1;
    S103008=0;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread116499(int [] tdone, int [] ends){
        S102985=1;
    S102914=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread116498(int [] tdone, int [] ends){
        S102891=1;
    chance_thread_14 = 25;//sysj\plant.sysj line: 231, column: 3
        S102645=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread116497(int [] tdone, int [] ends){
        S102609=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 203, column: 3
    S100956=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread116496(int [] tdone, int [] ends){
        S100829=1;
    S100806=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread116495(int [] tdone, int [] ends){
        S100799=1;
    S100734=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread116494(int [] tdone, int [] ends){
        S100713=1;
    S100648=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread116493(int [] tdone, int [] ends){
        S100627=1;
    S100592=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread116492(int [] tdone, int [] ends){
        S100581=1;
    S100546=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread116491(int [] tdone, int [] ends){
        S100535=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 132, column: 3
    S100503=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread116490(int [] tdone, int [] ends){
        S100499=1;
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

  public void thread116489(int [] tdone, int [] ends){
        S100437=1;
    S100391=0;
    S100373=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread116488(int [] tdone, int [] ends){
        S100369=1;
    S100339=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 75, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 76, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 77, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 77, column: 6
        System.out.println("Emitted capPos_1");
        S100334=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 79, column: 7
        currsigs.addElement(WPgripped);
        System.out.println("Emitted WPgripped");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S100339=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S100339=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread116487(int [] tdone, int [] ends){
        S100325=1;
    S100279=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 63, column: 5
    currsigs.addElement(pusherRetracted);
    System.out.println("Emitted pusherRetracted");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread116486(int [] tdone, int [] ends){
        S100272=1;
    S100226=0;
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
      switch(S116484){
        case 0 : 
          S116484=0;
          break RUN;
        
        case 1 : 
          S116484=2;
          S116484=2;
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
          thread116486(tdone,ends);
          thread116487(tdone,ends);
          thread116488(tdone,ends);
          thread116489(tdone,ends);
          thread116490(tdone,ends);
          thread116491(tdone,ends);
          thread116492(tdone,ends);
          thread116493(tdone,ends);
          thread116494(tdone,ends);
          thread116495(tdone,ends);
          thread116496(tdone,ends);
          thread116497(tdone,ends);
          thread116498(tdone,ends);
          thread116499(tdone,ends);
          thread116500(tdone,ends);
          thread116501(tdone,ends);
          thread116502(tdone,ends);
          thread116503(tdone,ends);
          thread116504(tdone,ends);
          thread116505(tdone,ends);
          thread116506(tdone,ends);
          int biggest116542 = 0;
          if(ends[2]>=biggest116542){
            biggest116542=ends[2];
          }
          if(ends[3]>=biggest116542){
            biggest116542=ends[3];
          }
          if(ends[4]>=biggest116542){
            biggest116542=ends[4];
          }
          if(ends[5]>=biggest116542){
            biggest116542=ends[5];
          }
          if(ends[6]>=biggest116542){
            biggest116542=ends[6];
          }
          if(ends[7]>=biggest116542){
            biggest116542=ends[7];
          }
          if(ends[8]>=biggest116542){
            biggest116542=ends[8];
          }
          if(ends[9]>=biggest116542){
            biggest116542=ends[9];
          }
          if(ends[10]>=biggest116542){
            biggest116542=ends[10];
          }
          if(ends[11]>=biggest116542){
            biggest116542=ends[11];
          }
          if(ends[12]>=biggest116542){
            biggest116542=ends[12];
          }
          if(ends[13]>=biggest116542){
            biggest116542=ends[13];
          }
          if(ends[14]>=biggest116542){
            biggest116542=ends[14];
          }
          if(ends[15]>=biggest116542){
            biggest116542=ends[15];
          }
          if(ends[16]>=biggest116542){
            biggest116542=ends[16];
          }
          if(ends[17]>=biggest116542){
            biggest116542=ends[17];
          }
          if(ends[18]>=biggest116542){
            biggest116542=ends[18];
          }
          if(ends[19]>=biggest116542){
            biggest116542=ends[19];
          }
          if(ends[20]>=biggest116542){
            biggest116542=ends[20];
          }
          if(ends[21]>=biggest116542){
            biggest116542=ends[21];
          }
          if(ends[22]>=biggest116542){
            biggest116542=ends[22];
          }
          if(biggest116542 == 1){
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
          thread116543(tdone,ends);
          thread116544(tdone,ends);
          thread116545(tdone,ends);
          thread116546(tdone,ends);
          thread116547(tdone,ends);
          thread116548(tdone,ends);
          thread116549(tdone,ends);
          thread116550(tdone,ends);
          thread116551(tdone,ends);
          thread116552(tdone,ends);
          thread116553(tdone,ends);
          thread116554(tdone,ends);
          thread116555(tdone,ends);
          thread116556(tdone,ends);
          thread116557(tdone,ends);
          thread116558(tdone,ends);
          thread116559(tdone,ends);
          thread116560(tdone,ends);
          thread116561(tdone,ends);
          thread116562(tdone,ends);
          thread116563(tdone,ends);
          int biggest116599 = 0;
          if(ends[2]>=biggest116599){
            biggest116599=ends[2];
          }
          if(ends[3]>=biggest116599){
            biggest116599=ends[3];
          }
          if(ends[4]>=biggest116599){
            biggest116599=ends[4];
          }
          if(ends[5]>=biggest116599){
            biggest116599=ends[5];
          }
          if(ends[6]>=biggest116599){
            biggest116599=ends[6];
          }
          if(ends[7]>=biggest116599){
            biggest116599=ends[7];
          }
          if(ends[8]>=biggest116599){
            biggest116599=ends[8];
          }
          if(ends[9]>=biggest116599){
            biggest116599=ends[9];
          }
          if(ends[10]>=biggest116599){
            biggest116599=ends[10];
          }
          if(ends[11]>=biggest116599){
            biggest116599=ends[11];
          }
          if(ends[12]>=biggest116599){
            biggest116599=ends[12];
          }
          if(ends[13]>=biggest116599){
            biggest116599=ends[13];
          }
          if(ends[14]>=biggest116599){
            biggest116599=ends[14];
          }
          if(ends[15]>=biggest116599){
            biggest116599=ends[15];
          }
          if(ends[16]>=biggest116599){
            biggest116599=ends[16];
          }
          if(ends[17]>=biggest116599){
            biggest116599=ends[17];
          }
          if(ends[18]>=biggest116599){
            biggest116599=ends[18];
          }
          if(ends[19]>=biggest116599){
            biggest116599=ends[19];
          }
          if(ends[20]>=biggest116599){
            biggest116599=ends[20];
          }
          if(ends[21]>=biggest116599){
            biggest116599=ends[21];
          }
          if(ends[22]>=biggest116599){
            biggest116599=ends[22];
          }
          if(biggest116599 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest116599 == 0){
            S116484=0;
            active[1]=0;
            ends[1]=0;
            S116484=0;
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
