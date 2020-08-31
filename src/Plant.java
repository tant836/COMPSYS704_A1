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
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.INPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.INPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.INPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.INPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.INPUT);
  public Signal motConveyorOn = new Signal("motConveyorOn", Signal.INPUT);
  public Signal bottleAdded = new Signal("bottleAdded", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.INPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.INPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.INPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.INPUT);
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
  public Signal motConveyorOnE = new Signal("motConveyorOnE", Signal.OUTPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  public Signal bottleAtPos1E = new Signal("bottleAtPos1E", Signal.OUTPUT);
  public Signal rotaryTableTriggerE = new Signal("rotaryTableTriggerE", Signal.OUTPUT);
  public Signal valveInjectorOnOffE = new Signal("valveInjectorOnOffE", Signal.OUTPUT);
  public Signal valveInletOnOffE = new Signal("valveInletOnOffE", Signal.OUTPUT);
  public Signal dosUnitValveRetractE = new Signal("dosUnitValveRetractE", Signal.OUTPUT);
  public Signal dosUnitValveExtendE = new Signal("dosUnitValveExtendE", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal capPos_1;
  private Signal s_motConveyorOn_1;
  private Signal s_valveInjectorOnOff_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 102, column: 3
  private int S3262 = 1;
  private int S1014 = 1;
  private int S968 = 1;
  private int S1067 = 1;
  private int S1021 = 1;
  private int S1111 = 1;
  private int S1081 = 1;
  private int S1076 = 1;
  private int S1179 = 1;
  private int S1133 = 1;
  private int S1115 = 1;
  private int S1241 = 1;
  private int S1319 = 1;
  private int S1267 = 1;
  private int S1247 = 1;
  private int S1254 = 1;
  private int S1365 = 1;
  private int S1330 = 1;
  private int S1394 = 1;
  private int S1374 = 1;
  private int S1424 = 1;
  private int S1404 = 1;
  private int S1453 = 1;
  private int S1433 = 1;
  private int S1482 = 1;
  private int S1462 = 1;
  private int S1511 = 1;
  private int S1491 = 1;
  private int S1535 = 1;
  private int S1519 = 1;
  private int S1533 = 1;
  private int S1523 = 1;
  
  private int[] ends = new int[19];
  private int[] tdone = new int[19];
  
  public void thread3301(int [] tdone, int [] ends){
        switch(S1533){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        switch(S1523){
          case 0 : 
            rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 222, column: 16
            currsigs.addElement(rotaryTableTriggerE);
            active[18]=1;
            ends[18]=1;
            tdone[18]=1;
            break;
          
          case 1 : 
            S1523=1;
            S1523=0;
            rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 222, column: 16
            currsigs.addElement(rotaryTableTriggerE);
            active[18]=1;
            ends[18]=1;
            tdone[18]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread3300(int [] tdone, int [] ends){
        switch(S1519){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 220, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 220, column: 38
          currsigs.addElement(bottleAtPos1E);
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
      
    }
  }

  public void thread3299(int [] tdone, int [] ends){
        switch(S1535){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        thread3300(tdone,ends);
        thread3301(tdone,ends);
        int biggest3302 = 0;
        if(ends[17]>=biggest3302){
          biggest3302=ends[17];
        }
        if(ends[18]>=biggest3302){
          biggest3302=ends[18];
        }
        if(biggest3302 == 1){
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        //FINXME code
        if(biggest3302 == 0){
          S1535=0;
          active[16]=0;
          ends[16]=0;
          tdone[16]=1;
        }
        break;
      
    }
  }

  public void thread3298(int [] tdone, int [] ends){
        switch(S1511){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1491){
          case 0 : 
            S1491=0;
            S1491=1;
            dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 200, column: 5
            currsigs.addElement(dosUnitValveExtendE);
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
          case 1 : 
            if(!dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 199, column: 10
              S1491=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 200, column: 5
              currsigs.addElement(dosUnitValveExtendE);
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3297(int [] tdone, int [] ends){
        switch(S1482){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S1462){
          case 0 : 
            S1462=0;
            S1462=1;
            dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 190, column: 5
            currsigs.addElement(dosUnitValveRetractE);
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 1 : 
            if(!dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 189, column: 10
              S1462=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 190, column: 5
              currsigs.addElement(dosUnitValveRetractE);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3296(int [] tdone, int [] ends){
        switch(S1453){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        switch(S1433){
          case 0 : 
            S1433=0;
            S1433=1;
            valveInletOnOffE.setPresent();//sysj\plant.sysj line: 180, column: 5
            currsigs.addElement(valveInletOnOffE);
            active[13]=1;
            ends[13]=1;
            tdone[13]=1;
            break;
          
          case 1 : 
            if(!valveInletOnOff.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 179, column: 10
              S1433=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              valveInletOnOffE.setPresent();//sysj\plant.sysj line: 180, column: 5
              currsigs.addElement(valveInletOnOffE);
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3295(int [] tdone, int [] ends){
        switch(S1424){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 166, column: 3
        switch(S1404){
          case 0 : 
            S1404=0;
            S1404=1;
            valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 170, column: 5
            currsigs.addElement(valveInjectorOnOffE);
            active[12]=1;
            ends[12]=1;
            tdone[12]=1;
            break;
          
          case 1 : 
            if(!valveInjectorOnOff.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 169, column: 10
              S1404=0;
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            else {
              valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 170, column: 5
              currsigs.addElement(valveInjectorOnOffE);
              active[12]=1;
              ends[12]=1;
              tdone[12]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3294(int [] tdone, int [] ends){
        switch(S1394){
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
            rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 157, column: 5
            currsigs.addElement(rotaryTableTriggerE);
            active[11]=1;
            ends[11]=1;
            tdone[11]=1;
            break;
          
          case 1 : 
            if(!rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 156, column: 10
              S1374=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 157, column: 5
              currsigs.addElement(rotaryTableTriggerE);
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3293(int [] tdone, int [] ends){
        switch(S1365){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1330){
          case 0 : 
            S1330=0;
            S1330=1;
            if(motConveyorOn.getprestatus() && bottleAdded.getprestatus()){//sysj\plant.sysj line: 143, column: 12
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 145, column: 6
              currsigs.addElement(bottleAtPos1);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S1330=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 144, column: 11
              S1330=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 145, column: 6
              currsigs.addElement(bottleAtPos1);
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3291(int [] tdone, int [] ends){
        switch(S1254){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 132, column: 12
          S1254=0;
          active[9]=0;
          ends[9]=0;
          tdone[9]=1;
        }
        else {
          bottleAtPos1.setPresent();//sysj\plant.sysj line: 133, column: 7
          currsigs.addElement(bottleAtPos1);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread3290(int [] tdone, int [] ends){
        switch(S1247){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        motConveyorOnE.setPresent();//sysj\plant.sysj line: 126, column: 5
        currsigs.addElement(motConveyorOnE);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread3288(int [] tdone, int [] ends){
        S1254=1;
    if(bottleAdded.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 131, column: 13
      bottleAtPos1.setPresent();//sysj\plant.sysj line: 133, column: 7
      currsigs.addElement(bottleAtPos1);
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      S1254=0;
      active[9]=0;
      ends[9]=0;
      tdone[9]=1;
    }
  }

  public void thread3287(int [] tdone, int [] ends){
        S1247=1;
    motConveyorOnE.setPresent();//sysj\plant.sysj line: 126, column: 5
    currsigs.addElement(motConveyorOnE);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread3286(int [] tdone, int [] ends){
        switch(S1319){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 121, column: 3
        switch(S1267){
          case 0 : 
            S1267=0;
            S1267=1;
            thread3287(tdone,ends);
            thread3288(tdone,ends);
            int biggest3289 = 0;
            if(ends[8]>=biggest3289){
              biggest3289=ends[8];
            }
            if(ends[9]>=biggest3289){
              biggest3289=ends[9];
            }
            if(biggest3289 == 1){
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
          case 1 : 
            thread3290(tdone,ends);
            thread3291(tdone,ends);
            int biggest3292 = 0;
            if(ends[8]>=biggest3292){
              biggest3292=ends[8];
            }
            if(ends[9]>=biggest3292){
              biggest3292=ends[9];
            }
            if(biggest3292 == 1){
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            //FINXME code
            if(biggest3292 == 0){
              S1267=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3285(int [] tdone, int [] ends){
        switch(S1241){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 104, column: 12
          if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 105, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 106, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 108, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 109, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 112, column: 8
              empty.setPresent();//sysj\plant.sysj line: 113, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 112, column: 8
              empty.setPresent();//sysj\plant.sysj line: 113, column: 6
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
          if(refill.getprestatus()){//sysj\plant.sysj line: 108, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 109, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 112, column: 8
              empty.setPresent();//sysj\plant.sysj line: 113, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 112, column: 8
              empty.setPresent();//sysj\plant.sysj line: 113, column: 6
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

  public void thread3284(int [] tdone, int [] ends){
        switch(S1179){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1133){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 87, column: 10
              S1133=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1115){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 89, column: 13
                    S1115=1;
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
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 90, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 92, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 92, column: 7
                    S1115=2;
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
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 93, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 94, column: 7
                    currsigs.addElement(capDec_1);
                    S1115=0;
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
            if(refill.getprestatus()){//sysj\plant.sysj line: 97, column: 10
              S1133=0;
              S1115=0;
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

  public void thread3283(int [] tdone, int [] ends){
        switch(S1111){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1081){
          case 0 : 
            switch(S1076){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 67, column: 12
                  S1076=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 70, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 71, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 71, column: 7
                    S1081=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1081=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\plant.sysj line: 68, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S1081=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 64, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 65, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 66, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 66, column: 6
                    S1076=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 68, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1081=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S1081=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1081=1;
            S1081=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 64, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 65, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 66, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 66, column: 6
                S1076=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 68, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S1081=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S1081=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3282(int [] tdone, int [] ends){
        switch(S1067){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S1021){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 51, column: 10
              S1021=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 52, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 54, column: 10
              S1021=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 56, column: 5
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
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 55, column: 10
              S1021=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 56, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 58, column: 10
              S1021=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 52, column: 5
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

  public void thread3281(int [] tdone, int [] ends){
        switch(S1014){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S968){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 38, column: 10
              S968=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 39, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 41, column: 10
              S968=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 43, column: 5
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 42, column: 10
              S968=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 43, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 45, column: 10
              S968=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 39, column: 5
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

  public void thread3278(int [] tdone, int [] ends){
        S1533=1;
    S1523=0;
    rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 222, column: 16
    currsigs.addElement(rotaryTableTriggerE);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread3277(int [] tdone, int [] ends){
        S1519=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 220, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 220, column: 38
      currsigs.addElement(bottleAtPos1E);
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
    else {
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
  }

  public void thread3276(int [] tdone, int [] ends){
        S1535=1;
    thread3277(tdone,ends);
    thread3278(tdone,ends);
    int biggest3279 = 0;
    if(ends[17]>=biggest3279){
      biggest3279=ends[17];
    }
    if(ends[18]>=biggest3279){
      biggest3279=ends[18];
    }
    if(biggest3279 == 1){
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
  }

  public void thread3275(int [] tdone, int [] ends){
        S1511=1;
    S1491=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread3274(int [] tdone, int [] ends){
        S1482=1;
    S1462=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread3273(int [] tdone, int [] ends){
        S1453=1;
    S1433=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread3272(int [] tdone, int [] ends){
        S1424=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 166, column: 3
    S1404=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread3271(int [] tdone, int [] ends){
        S1394=1;
    S1374=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread3270(int [] tdone, int [] ends){
        S1365=1;
    S1330=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread3269(int [] tdone, int [] ends){
        S1319=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 121, column: 3
    S1267=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3268(int [] tdone, int [] ends){
        S1241=1;
    capcount_thread_6 = 5;//sysj\plant.sysj line: 102, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 104, column: 12
      if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 105, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 106, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 108, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 109, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 112, column: 8
          empty.setPresent();//sysj\plant.sysj line: 113, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 112, column: 8
          empty.setPresent();//sysj\plant.sysj line: 113, column: 6
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
      if(refill.getprestatus()){//sysj\plant.sysj line: 108, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 109, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 112, column: 8
          empty.setPresent();//sysj\plant.sysj line: 113, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 112, column: 8
          empty.setPresent();//sysj\plant.sysj line: 113, column: 6
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

  public void thread3267(int [] tdone, int [] ends){
        S1179=1;
    S1133=0;
    S1115=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3266(int [] tdone, int [] ends){
        S1111=1;
    S1081=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 64, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 65, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 66, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 66, column: 6
        S1076=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 68, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S1081=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S1081=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread3265(int [] tdone, int [] ends){
        S1067=1;
    S1021=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 52, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3264(int [] tdone, int [] ends){
        S1014=1;
    S968=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 39, column: 5
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
      switch(S3262){
        case 0 : 
          S3262=0;
          break RUN;
        
        case 1 : 
          S3262=2;
          S3262=2;
          class GUI extends Object implements java.lang.Runnable {//sysj\plant.sysj line: 25, column: 1
            public void run() {//sysj\plant.sysj line: 27, column: 21
              org.compsys704.CapLoader.main(null);//sysj\plant.sysj line: 28, column: 4
            }
            GUI(){//sysj\plant.sysj line: 26, column: 42
            }
          }
          new Thread(new GUI()).start();//sysj\plant.sysj line: 31, column: 2
          capDec_1.setClear();//sysj\plant.sysj line: 33, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 34, column: 2
          capPos_1.setPresent();//sysj\plant.sysj line: 35, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\plant.sysj line: 35, column: 2
          thread3264(tdone,ends);
          thread3265(tdone,ends);
          thread3266(tdone,ends);
          thread3267(tdone,ends);
          thread3268(tdone,ends);
          thread3269(tdone,ends);
          thread3270(tdone,ends);
          thread3271(tdone,ends);
          thread3272(tdone,ends);
          thread3273(tdone,ends);
          thread3274(tdone,ends);
          thread3275(tdone,ends);
          thread3276(tdone,ends);
          int biggest3280 = 0;
          if(ends[2]>=biggest3280){
            biggest3280=ends[2];
          }
          if(ends[3]>=biggest3280){
            biggest3280=ends[3];
          }
          if(ends[4]>=biggest3280){
            biggest3280=ends[4];
          }
          if(ends[5]>=biggest3280){
            biggest3280=ends[5];
          }
          if(ends[6]>=biggest3280){
            biggest3280=ends[6];
          }
          if(ends[7]>=biggest3280){
            biggest3280=ends[7];
          }
          if(ends[10]>=biggest3280){
            biggest3280=ends[10];
          }
          if(ends[11]>=biggest3280){
            biggest3280=ends[11];
          }
          if(ends[12]>=biggest3280){
            biggest3280=ends[12];
          }
          if(ends[13]>=biggest3280){
            biggest3280=ends[13];
          }
          if(ends[14]>=biggest3280){
            biggest3280=ends[14];
          }
          if(ends[15]>=biggest3280){
            biggest3280=ends[15];
          }
          if(ends[16]>=biggest3280){
            biggest3280=ends[16];
          }
          if(biggest3280 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\plant.sysj line: 33, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 34, column: 2
          thread3281(tdone,ends);
          thread3282(tdone,ends);
          thread3283(tdone,ends);
          thread3284(tdone,ends);
          thread3285(tdone,ends);
          thread3286(tdone,ends);
          thread3293(tdone,ends);
          thread3294(tdone,ends);
          thread3295(tdone,ends);
          thread3296(tdone,ends);
          thread3297(tdone,ends);
          thread3298(tdone,ends);
          thread3299(tdone,ends);
          int biggest3303 = 0;
          if(ends[2]>=biggest3303){
            biggest3303=ends[2];
          }
          if(ends[3]>=biggest3303){
            biggest3303=ends[3];
          }
          if(ends[4]>=biggest3303){
            biggest3303=ends[4];
          }
          if(ends[5]>=biggest3303){
            biggest3303=ends[5];
          }
          if(ends[6]>=biggest3303){
            biggest3303=ends[6];
          }
          if(ends[7]>=biggest3303){
            biggest3303=ends[7];
          }
          if(ends[10]>=biggest3303){
            biggest3303=ends[10];
          }
          if(ends[11]>=biggest3303){
            biggest3303=ends[11];
          }
          if(ends[12]>=biggest3303){
            biggest3303=ends[12];
          }
          if(ends[13]>=biggest3303){
            biggest3303=ends[13];
          }
          if(ends[14]>=biggest3303){
            biggest3303=ends[14];
          }
          if(ends[15]>=biggest3303){
            biggest3303=ends[15];
          }
          if(ends[16]>=biggest3303){
            biggest3303=ends[16];
          }
          if(biggest3303 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3303 == 0){
            S3262=0;
            active[1]=0;
            ends[1]=0;
            S3262=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    capDec_1 = new Signal();
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
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          cylPos5ZAxisExtend.gethook();
          gripperTurnRetract.gethook();
          gripperTurnExtend.gethook();
          capGripperPos5Extend.gethook();
          cylClampBottleExtend.gethook();
          motConveyorOn.gethook();
          bottleAdded.gethook();
          rotaryTableTrigger.gethook();
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
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      motConveyorOn.setpreclear();
      bottleAdded.setpreclear();
      rotaryTableTrigger.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
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
      motConveyorOnE.setpreclear();
      bottleAtPos1.setpreclear();
      bottleAtPos1E.setpreclear();
      rotaryTableTriggerE.setpreclear();
      valveInjectorOnOffE.setpreclear();
      valveInletOnOffE.setpreclear();
      dosUnitValveRetractE.setpreclear();
      dosUnitValveExtendE.setpreclear();
      capDec_1.setpreclear();
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
      dummyint = motConveyorOn.getStatus() ? motConveyorOn.setprepresent() : motConveyorOn.setpreclear();
      motConveyorOn.setpreval(motConveyorOn.getValue());
      motConveyorOn.setClear();
      dummyint = bottleAdded.getStatus() ? bottleAdded.setprepresent() : bottleAdded.setpreclear();
      bottleAdded.setpreval(bottleAdded.getValue());
      bottleAdded.setClear();
      dummyint = rotaryTableTrigger.getStatus() ? rotaryTableTrigger.setprepresent() : rotaryTableTrigger.setpreclear();
      rotaryTableTrigger.setpreval(rotaryTableTrigger.getValue());
      rotaryTableTrigger.setClear();
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
      motConveyorOnE.sethook();
      motConveyorOnE.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      bottleAtPos1E.sethook();
      bottleAtPos1E.setClear();
      rotaryTableTriggerE.sethook();
      rotaryTableTriggerE.setClear();
      valveInjectorOnOffE.sethook();
      valveInjectorOnOffE.setClear();
      valveInletOnOffE.sethook();
      valveInletOnOffE.setClear();
      dosUnitValveRetractE.sethook();
      dosUnitValveRetractE.setClear();
      dosUnitValveExtendE.sethook();
      dosUnitValveExtendE.setClear();
      capDec_1.setClear();
      capPos_1.setClear();
      s_motConveyorOn_1.setClear();
      s_valveInjectorOnOff_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        enable.gethook();
        refill.gethook();
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        cylPos5ZAxisExtend.gethook();
        gripperTurnRetract.gethook();
        gripperTurnExtend.gethook();
        capGripperPos5Extend.gethook();
        cylClampBottleExtend.gethook();
        motConveyorOn.gethook();
        bottleAdded.gethook();
        rotaryTableTrigger.gethook();
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
