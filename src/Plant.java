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
  public Signal putBottleAt5_FV = new Signal("putBottleAt5_FV", Signal.INPUT);
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
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.OUTPUT);
  public Signal bottleAtPos5_RT = new Signal("bottleAtPos5_RT", Signal.OUTPUT);
  public Signal bottleLeftPos5 = new Signal("bottleLeftPos5", Signal.OUTPUT);
  public Signal bottleAtPos5E = new Signal("bottleAtPos5E", Signal.OUTPUT);
  public Signal bottleLeftPos5E = new Signal("bottleLeftPos5E", Signal.OUTPUT);
  public Signal rotaryTableTriggerE = new Signal("rotaryTableTriggerE", Signal.OUTPUT);
  public Signal bottleAtPos1_RT = new Signal("bottleAtPos1_RT", Signal.OUTPUT);
  public Signal valveInjectorOnOffE = new Signal("valveInjectorOnOffE", Signal.OUTPUT);
  public Signal valveInletOnOffE = new Signal("valveInletOnOffE", Signal.OUTPUT);
  public Signal dosUnitValveRetractE = new Signal("dosUnitValveRetractE", Signal.OUTPUT);
  public Signal dosUnitValveExtendE = new Signal("dosUnitValveExtendE", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal l_bottleAdded_1;
  private Signal capPos_1;
  private Signal s_motConveyorOn_1;
  private Signal s_valveInjectorOnOff_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 103, column: 3
  private int S3177 = 1;
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
  private int S1326 = 1;
  private int S1286 = 1;
  private int S1275 = 1;
  private int S1328 = 1;
  private int S1331 = 1;
  private int S1333 = 1;
  private int S1335 = 1;
  private int S1337 = 1;
  private int S1437 = 1;
  private int S1345 = 1;
  private int S1353 = 1;
  private int S1361 = 1;
  private int S1381 = 1;
  private int S1367 = 1;
  private int S1365 = 1;
  private int S1401 = 1;
  private int S1387 = 1;
  private int S1385 = 1;
  private int S1415 = 1;
  private int S1405 = 1;
  private int S1435 = 1;
  private int S1421 = 1;
  private int S1419 = 1;
  
  private int[] ends = new int[24];
  private int[] tdone = new int[24];
  
  public void thread3224(int [] tdone, int [] ends){
        switch(S1435){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S1421){
          case 0 : 
            switch(S1419){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 245, column: 54
                  S1419=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 245, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 245, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  System.out.println("Emitted bottleAtPos5_RT");
                  S1421=1;
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
            break;
          
          case 1 : 
            S1421=1;
            S1421=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 245, column: 24
              S1419=0;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            else {
              S1421=1;
              active[23]=1;
              ends[23]=1;
              tdone[23]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3223(int [] tdone, int [] ends){
        switch(S1415){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S1405){
          case 0 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 243, column: 56
              bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 243, column: 66
              currsigs.addElement(bottleLeftPos5E);
              System.out.println("Emitted bottleLeftPos5E");
              S1405=1;
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
            S1405=1;
            S1405=0;
            if(bottleLeftPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 243, column: 24
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S1405=1;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3222(int [] tdone, int [] ends){
        switch(S1401){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S1387){
          case 0 : 
            switch(S1385){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 241, column: 54
                  S1385=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 241, column: 71
                  bottleAtPos5E.setPresent();//sysj\plant.sysj line: 241, column: 80
                  currsigs.addElement(bottleAtPos5E);
                  System.out.println("Emitted bottleAtPos5E");
                  S1387=1;
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
              
            }
            break;
          
          case 1 : 
            S1387=1;
            S1387=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 241, column: 24
              S1385=0;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            else {
              S1387=1;
              active[21]=1;
              ends[21]=1;
              tdone[21]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3221(int [] tdone, int [] ends){
        switch(S1381){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        switch(S1367){
          case 0 : 
            switch(S1365){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 239, column: 54
                  S1365=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 239, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 239, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  System.out.println("Emitted bottleAtPos1_RT");
                  S1367=1;
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
              
            }
            break;
          
          case 1 : 
            S1367=1;
            S1367=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 239, column: 24
              S1365=0;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            else {
              S1367=1;
              active[20]=1;
              ends[20]=1;
              tdone[20]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3220(int [] tdone, int [] ends){
        switch(S1361){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 237, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 237, column: 44
          currsigs.addElement(rotaryTableTriggerE);
          System.out.println("Emitted rotaryTableTriggerE");
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
      
    }
  }

  public void thread3219(int [] tdone, int [] ends){
        switch(S1353){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 235, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 235, column: 39
          currsigs.addElement(motConveyorOnE);
          System.out.println("Emitted motConveyorOnE");
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
      
    }
  }

  public void thread3218(int [] tdone, int [] ends){
        switch(S1345){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 233, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 233, column: 38
          currsigs.addElement(bottleAtPos1E);
          System.out.println("Emitted bottleAtPos1E");
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

  public void thread3217(int [] tdone, int [] ends){
        switch(S1437){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        thread3218(tdone,ends);
        thread3219(tdone,ends);
        thread3220(tdone,ends);
        thread3221(tdone,ends);
        thread3222(tdone,ends);
        thread3223(tdone,ends);
        thread3224(tdone,ends);
        int biggest3225 = 0;
        if(ends[17]>=biggest3225){
          biggest3225=ends[17];
        }
        if(ends[18]>=biggest3225){
          biggest3225=ends[18];
        }
        if(ends[19]>=biggest3225){
          biggest3225=ends[19];
        }
        if(ends[20]>=biggest3225){
          biggest3225=ends[20];
        }
        if(ends[21]>=biggest3225){
          biggest3225=ends[21];
        }
        if(ends[22]>=biggest3225){
          biggest3225=ends[22];
        }
        if(ends[23]>=biggest3225){
          biggest3225=ends[23];
        }
        if(biggest3225 == 1){
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        //FINXME code
        if(biggest3225 == 0){
          S1437=0;
          active[16]=0;
          ends[16]=0;
          tdone[16]=1;
        }
        break;
      
    }
  }

  public void thread3216(int [] tdone, int [] ends){
        switch(S1337){
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

  public void thread3215(int [] tdone, int [] ends){
        switch(S1335){
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

  public void thread3214(int [] tdone, int [] ends){
        switch(S1333){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        active[13]=1;
        ends[13]=1;
        tdone[13]=1;
        break;
      
    }
  }

  public void thread3213(int [] tdone, int [] ends){
        switch(S1331){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 181, column: 3
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread3212(int [] tdone, int [] ends){
        switch(S1328){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread3211(int [] tdone, int [] ends){
        switch(S1326){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        switch(S1286){
          case 0 : 
            S1286=0;
            S1286=1;
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 159, column: 12
              S1275=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              S1286=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            break;
          
          case 1 : 
            switch(S1275){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 160, column: 11
                  S1275=1;
                  bottleLeftPos5.setPresent();//sysj\plant.sysj line: 161, column: 5
                  currsigs.addElement(bottleLeftPos5);
                  System.out.println("Emitted bottleLeftPos5");
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
                bottleLeftPos5.setPresent();//sysj\plant.sysj line: 161, column: 5
                currsigs.addElement(bottleLeftPos5);
                System.out.println("Emitted bottleLeftPos5");
                active[10]=1;
                ends[10]=1;
                tdone[10]=1;
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread3210(int [] tdone, int [] ends){
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
            if(putBottleAt5_FV.getprestatus()){//sysj\plant.sysj line: 148, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 150, column: 6
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
            if((enable.getprestatus() && !putBottleAt5_FV.getprestatus()) || bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 149, column: 11
              S1232=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 150, column: 6
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

  public void thread3209(int [] tdone, int [] ends){
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
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 137, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 139, column: 6
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
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 138, column: 11
              S1186=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 139, column: 6
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

  public void thread3208(int [] tdone, int [] ends){
        switch(S1175){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 122, column: 3
        switch(S1143){
          case 0 : 
            S1143=0;
            S1143=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 126, column: 11
              S1143=2;
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 128, column: 6
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
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 127, column: 11
              S1143=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 128, column: 6
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

  public void thread3207(int [] tdone, int [] ends){
        switch(S1139){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 105, column: 12
          if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 106, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 107, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 109, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 110, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 113, column: 8
              empty.setPresent();//sysj\plant.sysj line: 114, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 113, column: 8
              empty.setPresent();//sysj\plant.sysj line: 114, column: 6
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
          if(refill.getprestatus()){//sysj\plant.sysj line: 109, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 110, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 113, column: 8
              empty.setPresent();//sysj\plant.sysj line: 114, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 113, column: 8
              empty.setPresent();//sysj\plant.sysj line: 114, column: 6
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

  public void thread3206(int [] tdone, int [] ends){
        switch(S1077){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1031){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 88, column: 10
              S1031=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1013){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 90, column: 13
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
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 91, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 93, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 93, column: 7
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
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 94, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 95, column: 7
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
            if(refill.getprestatus()){//sysj\plant.sysj line: 98, column: 10
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

  public void thread3205(int [] tdone, int [] ends){
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
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 68, column: 12
                  S974=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 71, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 72, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 72, column: 7
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
                  WPgripped.setPresent();//sysj\plant.sysj line: 69, column: 7
                  currsigs.addElement(WPgripped);
                  System.out.println("Emitted WPgripped");
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S979=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 65, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 66, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 67, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 67, column: 6
                    System.out.println("Emitted capPos_1");
                    S974=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 69, column: 7
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
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 65, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 66, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 67, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 67, column: 6
                System.out.println("Emitted capPos_1");
                S974=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 69, column: 7
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

  public void thread3204(int [] tdone, int [] ends){
        switch(S965){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S919){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 52, column: 10
              S919=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 53, column: 5
              currsigs.addElement(pusherRetracted);
              System.out.println("Emitted pusherRetracted");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 55, column: 10
              S919=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 57, column: 5
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
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 56, column: 10
              S919=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 57, column: 5
              currsigs.addElement(pusherExtended);
              System.out.println("Emitted pusherExtended");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 59, column: 10
              S919=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 53, column: 5
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

  public void thread3203(int [] tdone, int [] ends){
        switch(S912){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S866){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 39, column: 10
              S866=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 40, column: 5
              currsigs.addElement(armAtDest);
              System.out.println("Emitted armAtDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 42, column: 10
              S866=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 44, column: 5
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 43, column: 10
              S866=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 44, column: 5
              currsigs.addElement(armAtSource);
              System.out.println("Emitted armAtSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 46, column: 10
              S866=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 40, column: 5
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

  public void thread3200(int [] tdone, int [] ends){
        S1435=1;
    S1421=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 245, column: 24
      S1419=0;
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
    else {
      S1421=1;
      active[23]=1;
      ends[23]=1;
      tdone[23]=1;
    }
  }

  public void thread3199(int [] tdone, int [] ends){
        S1415=1;
    S1405=0;
    if(bottleLeftPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 243, column: 24
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
    else {
      S1405=1;
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread3198(int [] tdone, int [] ends){
        S1401=1;
    S1387=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 241, column: 24
      S1385=0;
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S1387=1;
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
  }

  public void thread3197(int [] tdone, int [] ends){
        S1381=1;
    S1367=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 239, column: 24
      S1365=0;
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
    else {
      S1367=1;
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
  }

  public void thread3196(int [] tdone, int [] ends){
        S1361=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 237, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 237, column: 44
      currsigs.addElement(rotaryTableTriggerE);
      System.out.println("Emitted rotaryTableTriggerE");
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
    else {
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
  }

  public void thread3195(int [] tdone, int [] ends){
        S1353=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 235, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 235, column: 39
      currsigs.addElement(motConveyorOnE);
      System.out.println("Emitted motConveyorOnE");
      active[18]=1;
      ends[18]=1;
      tdone[18]=1;
    }
    else {
      active[18]=1;
      ends[18]=1;
      tdone[18]=1;
    }
  }

  public void thread3194(int [] tdone, int [] ends){
        S1345=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 233, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 233, column: 38
      currsigs.addElement(bottleAtPos1E);
      System.out.println("Emitted bottleAtPos1E");
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

  public void thread3193(int [] tdone, int [] ends){
        S1437=1;
    thread3194(tdone,ends);
    thread3195(tdone,ends);
    thread3196(tdone,ends);
    thread3197(tdone,ends);
    thread3198(tdone,ends);
    thread3199(tdone,ends);
    thread3200(tdone,ends);
    int biggest3201 = 0;
    if(ends[17]>=biggest3201){
      biggest3201=ends[17];
    }
    if(ends[18]>=biggest3201){
      biggest3201=ends[18];
    }
    if(ends[19]>=biggest3201){
      biggest3201=ends[19];
    }
    if(ends[20]>=biggest3201){
      biggest3201=ends[20];
    }
    if(ends[21]>=biggest3201){
      biggest3201=ends[21];
    }
    if(ends[22]>=biggest3201){
      biggest3201=ends[22];
    }
    if(ends[23]>=biggest3201){
      biggest3201=ends[23];
    }
    if(biggest3201 == 1){
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
  }

  public void thread3192(int [] tdone, int [] ends){
        S1337=1;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread3191(int [] tdone, int [] ends){
        S1335=1;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread3190(int [] tdone, int [] ends){
        S1333=1;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread3189(int [] tdone, int [] ends){
        S1331=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 181, column: 3
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread3188(int [] tdone, int [] ends){
        S1328=1;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread3187(int [] tdone, int [] ends){
        S1326=1;
    S1286=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread3186(int [] tdone, int [] ends){
        S1267=1;
    S1232=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread3185(int [] tdone, int [] ends){
        S1221=1;
    S1186=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread3184(int [] tdone, int [] ends){
        S1175=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 122, column: 3
    S1143=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread3183(int [] tdone, int [] ends){
        S1139=1;
    capcount_thread_6 = 5;//sysj\plant.sysj line: 103, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 105, column: 12
      if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 106, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 107, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 109, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 110, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 113, column: 8
          empty.setPresent();//sysj\plant.sysj line: 114, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 113, column: 8
          empty.setPresent();//sysj\plant.sysj line: 114, column: 6
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
      if(refill.getprestatus()){//sysj\plant.sysj line: 109, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 110, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 113, column: 8
          empty.setPresent();//sysj\plant.sysj line: 114, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 113, column: 8
          empty.setPresent();//sysj\plant.sysj line: 114, column: 6
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

  public void thread3182(int [] tdone, int [] ends){
        S1077=1;
    S1031=0;
    S1013=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread3181(int [] tdone, int [] ends){
        S1009=1;
    S979=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 65, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 66, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 67, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 67, column: 6
        System.out.println("Emitted capPos_1");
        S974=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 69, column: 7
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

  public void thread3180(int [] tdone, int [] ends){
        S965=1;
    S919=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 53, column: 5
    currsigs.addElement(pusherRetracted);
    System.out.println("Emitted pusherRetracted");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread3179(int [] tdone, int [] ends){
        S912=1;
    S866=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 40, column: 5
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
      switch(S3177){
        case 0 : 
          S3177=0;
          break RUN;
        
        case 1 : 
          S3177=2;
          S3177=2;
          class GUI extends Object implements java.lang.Runnable {//sysj\plant.sysj line: 25, column: 1
            public void run() {//sysj\plant.sysj line: 27, column: 21
              org.compsys704.CapLoader.main(null);//sysj\plant.sysj line: 28, column: 4
            }
            GUI(){//sysj\plant.sysj line: 26, column: 42
            }
          }
          new Thread(new GUI()).start();//sysj\plant.sysj line: 31, column: 2
          capDec_1.setClear();//sysj\plant.sysj line: 33, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 34, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 35, column: 2
          capPos_1.setPresent();//sysj\plant.sysj line: 36, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\plant.sysj line: 36, column: 2
          System.out.println("Emitted capPos_1");
          thread3179(tdone,ends);
          thread3180(tdone,ends);
          thread3181(tdone,ends);
          thread3182(tdone,ends);
          thread3183(tdone,ends);
          thread3184(tdone,ends);
          thread3185(tdone,ends);
          thread3186(tdone,ends);
          thread3187(tdone,ends);
          thread3188(tdone,ends);
          thread3189(tdone,ends);
          thread3190(tdone,ends);
          thread3191(tdone,ends);
          thread3192(tdone,ends);
          thread3193(tdone,ends);
          int biggest3202 = 0;
          if(ends[2]>=biggest3202){
            biggest3202=ends[2];
          }
          if(ends[3]>=biggest3202){
            biggest3202=ends[3];
          }
          if(ends[4]>=biggest3202){
            biggest3202=ends[4];
          }
          if(ends[5]>=biggest3202){
            biggest3202=ends[5];
          }
          if(ends[6]>=biggest3202){
            biggest3202=ends[6];
          }
          if(ends[7]>=biggest3202){
            biggest3202=ends[7];
          }
          if(ends[8]>=biggest3202){
            biggest3202=ends[8];
          }
          if(ends[9]>=biggest3202){
            biggest3202=ends[9];
          }
          if(ends[10]>=biggest3202){
            biggest3202=ends[10];
          }
          if(ends[11]>=biggest3202){
            biggest3202=ends[11];
          }
          if(ends[12]>=biggest3202){
            biggest3202=ends[12];
          }
          if(ends[13]>=biggest3202){
            biggest3202=ends[13];
          }
          if(ends[14]>=biggest3202){
            biggest3202=ends[14];
          }
          if(ends[15]>=biggest3202){
            biggest3202=ends[15];
          }
          if(ends[16]>=biggest3202){
            biggest3202=ends[16];
          }
          if(biggest3202 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\plant.sysj line: 33, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 34, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 35, column: 2
          thread3203(tdone,ends);
          thread3204(tdone,ends);
          thread3205(tdone,ends);
          thread3206(tdone,ends);
          thread3207(tdone,ends);
          thread3208(tdone,ends);
          thread3209(tdone,ends);
          thread3210(tdone,ends);
          thread3211(tdone,ends);
          thread3212(tdone,ends);
          thread3213(tdone,ends);
          thread3214(tdone,ends);
          thread3215(tdone,ends);
          thread3216(tdone,ends);
          thread3217(tdone,ends);
          int biggest3226 = 0;
          if(ends[2]>=biggest3226){
            biggest3226=ends[2];
          }
          if(ends[3]>=biggest3226){
            biggest3226=ends[3];
          }
          if(ends[4]>=biggest3226){
            biggest3226=ends[4];
          }
          if(ends[5]>=biggest3226){
            biggest3226=ends[5];
          }
          if(ends[6]>=biggest3226){
            biggest3226=ends[6];
          }
          if(ends[7]>=biggest3226){
            biggest3226=ends[7];
          }
          if(ends[8]>=biggest3226){
            biggest3226=ends[8];
          }
          if(ends[9]>=biggest3226){
            biggest3226=ends[9];
          }
          if(ends[10]>=biggest3226){
            biggest3226=ends[10];
          }
          if(ends[11]>=biggest3226){
            biggest3226=ends[11];
          }
          if(ends[12]>=biggest3226){
            biggest3226=ends[12];
          }
          if(ends[13]>=biggest3226){
            biggest3226=ends[13];
          }
          if(ends[14]>=biggest3226){
            biggest3226=ends[14];
          }
          if(ends[15]>=biggest3226){
            biggest3226=ends[15];
          }
          if(ends[16]>=biggest3226){
            biggest3226=ends[16];
          }
          if(biggest3226 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest3226 == 0){
            S3177=0;
            active[1]=0;
            ends[1]=0;
            S3177=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    capDec_1 = new Signal();
    l_bottleAdded_1 = new Signal();
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
          putBottleAt5_FV.gethook();
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
      putBottleAt5_FV.setpreclear();
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
      bottleAtPos5.setpreclear();
      bottleAtPos5_RT.setpreclear();
      bottleLeftPos5.setpreclear();
      bottleAtPos5E.setpreclear();
      bottleLeftPos5E.setpreclear();
      rotaryTableTriggerE.setpreclear();
      bottleAtPos1_RT.setpreclear();
      valveInjectorOnOffE.setpreclear();
      valveInletOnOffE.setpreclear();
      dosUnitValveRetractE.setpreclear();
      dosUnitValveExtendE.setpreclear();
      capDec_1.setpreclear();
      l_bottleAdded_1.setpreclear();
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
      dummyint = putBottleAt5_FV.getStatus() ? putBottleAt5_FV.setprepresent() : putBottleAt5_FV.setpreclear();
      putBottleAt5_FV.setpreval(putBottleAt5_FV.getValue());
      putBottleAt5_FV.setClear();
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
      rotaryTableTriggerE.sethook();
      rotaryTableTriggerE.setClear();
      bottleAtPos1_RT.sethook();
      bottleAtPos1_RT.setClear();
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
        putBottleAt5_FV.gethook();
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
