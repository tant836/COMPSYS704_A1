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
  public Signal motConveyorOn = new Signal("motConveyorOn", Signal.INPUT);
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
  private int S2561 = 1;
  private int S945 = 1;
  private int S899 = 1;
  private int S998 = 1;
  private int S952 = 1;
  private int S1042 = 1;
  private int S1012 = 1;
  private int S1007 = 1;
  private int S1110 = 1;
  private int S1064 = 1;
  private int S1046 = 1;
  private int S1172 = 1;
  private int S1187 = 1;
  private int S1201 = 1;
  private int S1216 = 1;
  private int S1230 = 1;
  private int S1244 = 1;
  private int S1258 = 1;
  private int S1308 = 1;
  private int S1266 = 1;
  private int S1274 = 1;
  private int S1282 = 1;
  private int S1290 = 1;
  private int S1298 = 1;
  private int S1306 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread2600(int [] tdone, int [] ends){
        switch(S1306){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\plant.sysj line: 191, column: 24
          emptyE.setPresent();//sysj\plant.sysj line: 191, column: 31
          currsigs.addElement(emptyE);
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

  public void thread2599(int [] tdone, int [] ends){
        switch(S1298){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\plant.sysj line: 189, column: 24
          armAtDestE.setPresent();//sysj\plant.sysj line: 189, column: 35
          currsigs.addElement(armAtDestE);
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

  public void thread2598(int [] tdone, int [] ends){
        switch(S1290){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\plant.sysj line: 187, column: 24
          armAtSourceE.setPresent();//sysj\plant.sysj line: 187, column: 37
          currsigs.addElement(armAtSourceE);
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

  public void thread2597(int [] tdone, int [] ends){
        switch(S1282){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\plant.sysj line: 185, column: 24
          WPgrippedE.setPresent();//sysj\plant.sysj line: 185, column: 35
          currsigs.addElement(WPgrippedE);
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
      
    }
  }

  public void thread2596(int [] tdone, int [] ends){
        switch(S1274){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 183, column: 24
          pusherExtendedE.setPresent();//sysj\plant.sysj line: 183, column: 40
          currsigs.addElement(pusherExtendedE);
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
  }

  public void thread2595(int [] tdone, int [] ends){
        switch(S1266){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 181, column: 24
          pusherRetractedE.setPresent();//sysj\plant.sysj line: 181, column: 41
          currsigs.addElement(pusherRetractedE);
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
  }

  public void thread2594(int [] tdone, int [] ends){
        switch(S1308){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        thread2595(tdone,ends);
        thread2596(tdone,ends);
        thread2597(tdone,ends);
        thread2598(tdone,ends);
        thread2599(tdone,ends);
        thread2600(tdone,ends);
        int biggest2601 = 0;
        if(ends[14]>=biggest2601){
          biggest2601=ends[14];
        }
        if(ends[15]>=biggest2601){
          biggest2601=ends[15];
        }
        if(ends[16]>=biggest2601){
          biggest2601=ends[16];
        }
        if(ends[17]>=biggest2601){
          biggest2601=ends[17];
        }
        if(ends[18]>=biggest2601){
          biggest2601=ends[18];
        }
        if(ends[19]>=biggest2601){
          biggest2601=ends[19];
        }
        if(biggest2601 == 1){
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        //FINXME code
        if(biggest2601 == 0){
          S1308=0;
          active[13]=0;
          ends[13]=0;
          tdone[13]=1;
        }
        break;
      
    }
  }

  public void thread2593(int [] tdone, int [] ends){
        switch(S1258){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(!dosUnitValveExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 172, column: 10
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 173, column: 5
          currsigs.addElement(dosUnitValveExtendE);
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        else {
          dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 173, column: 5
          currsigs.addElement(dosUnitValveExtendE);
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        break;
      
    }
  }

  public void thread2592(int [] tdone, int [] ends){
        switch(S1244){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(!dosUnitValveRetract.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 163, column: 10
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 164, column: 5
          currsigs.addElement(dosUnitValveRetractE);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 164, column: 5
          currsigs.addElement(dosUnitValveRetractE);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        break;
      
    }
  }

  public void thread2591(int [] tdone, int [] ends){
        switch(S1230){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(!valveInletOnOff.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 154, column: 10
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 155, column: 5
          currsigs.addElement(valveInletOnOffE);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          valveInletOnOffE.setPresent();//sysj\plant.sysj line: 155, column: 5
          currsigs.addElement(valveInletOnOffE);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread2590(int [] tdone, int [] ends){
        switch(S1216){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 143, column: 3
        if(!valveInjectorOnOff.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 145, column: 10
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 146, column: 5
          currsigs.addElement(valveInjectorOnOffE);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 146, column: 5
          currsigs.addElement(valveInjectorOnOffE);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread2589(int [] tdone, int [] ends){
        switch(S1201){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(!rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 133, column: 10
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 134, column: 5
          currsigs.addElement(rotaryTableTriggerE);
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 134, column: 5
          currsigs.addElement(rotaryTableTriggerE);
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread2588(int [] tdone, int [] ends){
        switch(S1187){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 121, column: 3
        if(!motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 123, column: 10
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 124, column: 5
          currsigs.addElement(motConveyorOnE);
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        else {
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 124, column: 5
          currsigs.addElement(motConveyorOnE);
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread2587(int [] tdone, int [] ends){
        switch(S1172){
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

  public void thread2586(int [] tdone, int [] ends){
        switch(S1110){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1064){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 87, column: 10
              S1064=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1046){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 89, column: 13
                    S1046=1;
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
                    S1046=2;
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
                    S1046=0;
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
              S1064=0;
              S1046=0;
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

  public void thread2585(int [] tdone, int [] ends){
        switch(S1042){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1012){
          case 0 : 
            switch(S1007){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 67, column: 12
                  S1007=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 70, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 71, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 71, column: 7
                    S1012=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1012=1;
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
                S1012=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 64, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 65, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 66, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 66, column: 6
                    S1007=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 68, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1012=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S1012=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1012=1;
            S1012=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 64, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 65, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 66, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 66, column: 6
                S1007=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 68, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S1012=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S1012=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2584(int [] tdone, int [] ends){
        switch(S998){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S952){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 51, column: 10
              S952=1;
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
              S952=2;
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
              S952=3;
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
              S952=0;
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

  public void thread2583(int [] tdone, int [] ends){
        switch(S945){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S899){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 38, column: 10
              S899=1;
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
              S899=2;
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
              S899=3;
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
              S899=0;
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

  public void thread2580(int [] tdone, int [] ends){
        S1306=1;
    if(empty.getprestatus()){//sysj\plant.sysj line: 191, column: 24
      emptyE.setPresent();//sysj\plant.sysj line: 191, column: 31
      currsigs.addElement(emptyE);
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

  public void thread2579(int [] tdone, int [] ends){
        S1298=1;
    if(armAtDest.getprestatus()){//sysj\plant.sysj line: 189, column: 24
      armAtDestE.setPresent();//sysj\plant.sysj line: 189, column: 35
      currsigs.addElement(armAtDestE);
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

  public void thread2578(int [] tdone, int [] ends){
        S1290=1;
    if(armAtSource.getprestatus()){//sysj\plant.sysj line: 187, column: 24
      armAtSourceE.setPresent();//sysj\plant.sysj line: 187, column: 37
      currsigs.addElement(armAtSourceE);
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

  public void thread2577(int [] tdone, int [] ends){
        S1282=1;
    if(WPgripped.getprestatus()){//sysj\plant.sysj line: 185, column: 24
      WPgrippedE.setPresent();//sysj\plant.sysj line: 185, column: 35
      currsigs.addElement(WPgrippedE);
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
  }

  public void thread2576(int [] tdone, int [] ends){
        S1274=1;
    if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 183, column: 24
      pusherExtendedE.setPresent();//sysj\plant.sysj line: 183, column: 40
      currsigs.addElement(pusherExtendedE);
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
    else {
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
  }

  public void thread2575(int [] tdone, int [] ends){
        S1266=1;
    if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 181, column: 24
      pusherRetractedE.setPresent();//sysj\plant.sysj line: 181, column: 41
      currsigs.addElement(pusherRetractedE);
      active[14]=1;
      ends[14]=1;
      tdone[14]=1;
    }
    else {
      active[14]=1;
      ends[14]=1;
      tdone[14]=1;
    }
  }

  public void thread2574(int [] tdone, int [] ends){
        S1308=1;
    thread2575(tdone,ends);
    thread2576(tdone,ends);
    thread2577(tdone,ends);
    thread2578(tdone,ends);
    thread2579(tdone,ends);
    thread2580(tdone,ends);
    int biggest2581 = 0;
    if(ends[14]>=biggest2581){
      biggest2581=ends[14];
    }
    if(ends[15]>=biggest2581){
      biggest2581=ends[15];
    }
    if(ends[16]>=biggest2581){
      biggest2581=ends[16];
    }
    if(ends[17]>=biggest2581){
      biggest2581=ends[17];
    }
    if(ends[18]>=biggest2581){
      biggest2581=ends[18];
    }
    if(ends[19]>=biggest2581){
      biggest2581=ends[19];
    }
    if(biggest2581 == 1){
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
  }

  public void thread2573(int [] tdone, int [] ends){
        S1258=1;
    dosUnitValveExtendE.setPresent();//sysj\plant.sysj line: 173, column: 5
    currsigs.addElement(dosUnitValveExtendE);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2572(int [] tdone, int [] ends){
        S1244=1;
    dosUnitValveRetractE.setPresent();//sysj\plant.sysj line: 164, column: 5
    currsigs.addElement(dosUnitValveRetractE);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2571(int [] tdone, int [] ends){
        S1230=1;
    valveInletOnOffE.setPresent();//sysj\plant.sysj line: 155, column: 5
    currsigs.addElement(valveInletOnOffE);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread2570(int [] tdone, int [] ends){
        S1216=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 143, column: 3
    valveInjectorOnOffE.setPresent();//sysj\plant.sysj line: 146, column: 5
    currsigs.addElement(valveInjectorOnOffE);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2569(int [] tdone, int [] ends){
        S1201=1;
    rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 134, column: 5
    currsigs.addElement(rotaryTableTriggerE);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2568(int [] tdone, int [] ends){
        S1187=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 121, column: 3
    motConveyorOnE.setPresent();//sysj\plant.sysj line: 124, column: 5
    currsigs.addElement(motConveyorOnE);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2567(int [] tdone, int [] ends){
        S1172=1;
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

  public void thread2566(int [] tdone, int [] ends){
        S1110=1;
    S1064=0;
    S1046=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2565(int [] tdone, int [] ends){
        S1042=1;
    S1012=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 64, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 65, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 66, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 66, column: 6
        S1007=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 68, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S1012=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S1012=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread2564(int [] tdone, int [] ends){
        S998=1;
    S952=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 52, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2563(int [] tdone, int [] ends){
        S945=1;
    S899=0;
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
      switch(S2561){
        case 0 : 
          S2561=0;
          break RUN;
        
        case 1 : 
          S2561=2;
          S2561=2;
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
          thread2563(tdone,ends);
          thread2564(tdone,ends);
          thread2565(tdone,ends);
          thread2566(tdone,ends);
          thread2567(tdone,ends);
          thread2568(tdone,ends);
          thread2569(tdone,ends);
          thread2570(tdone,ends);
          thread2571(tdone,ends);
          thread2572(tdone,ends);
          thread2573(tdone,ends);
          thread2574(tdone,ends);
          int biggest2582 = 0;
          if(ends[2]>=biggest2582){
            biggest2582=ends[2];
          }
          if(ends[3]>=biggest2582){
            biggest2582=ends[3];
          }
          if(ends[4]>=biggest2582){
            biggest2582=ends[4];
          }
          if(ends[5]>=biggest2582){
            biggest2582=ends[5];
          }
          if(ends[6]>=biggest2582){
            biggest2582=ends[6];
          }
          if(ends[7]>=biggest2582){
            biggest2582=ends[7];
          }
          if(ends[8]>=biggest2582){
            biggest2582=ends[8];
          }
          if(ends[9]>=biggest2582){
            biggest2582=ends[9];
          }
          if(ends[10]>=biggest2582){
            biggest2582=ends[10];
          }
          if(ends[11]>=biggest2582){
            biggest2582=ends[11];
          }
          if(ends[12]>=biggest2582){
            biggest2582=ends[12];
          }
          if(ends[13]>=biggest2582){
            biggest2582=ends[13];
          }
          if(biggest2582 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\plant.sysj line: 33, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 34, column: 2
          thread2583(tdone,ends);
          thread2584(tdone,ends);
          thread2585(tdone,ends);
          thread2586(tdone,ends);
          thread2587(tdone,ends);
          thread2588(tdone,ends);
          thread2589(tdone,ends);
          thread2590(tdone,ends);
          thread2591(tdone,ends);
          thread2592(tdone,ends);
          thread2593(tdone,ends);
          thread2594(tdone,ends);
          int biggest2602 = 0;
          if(ends[2]>=biggest2602){
            biggest2602=ends[2];
          }
          if(ends[3]>=biggest2602){
            biggest2602=ends[3];
          }
          if(ends[4]>=biggest2602){
            biggest2602=ends[4];
          }
          if(ends[5]>=biggest2602){
            biggest2602=ends[5];
          }
          if(ends[6]>=biggest2602){
            biggest2602=ends[6];
          }
          if(ends[7]>=biggest2602){
            biggest2602=ends[7];
          }
          if(ends[8]>=biggest2602){
            biggest2602=ends[8];
          }
          if(ends[9]>=biggest2602){
            biggest2602=ends[9];
          }
          if(ends[10]>=biggest2602){
            biggest2602=ends[10];
          }
          if(ends[11]>=biggest2602){
            biggest2602=ends[11];
          }
          if(ends[12]>=biggest2602){
            biggest2602=ends[12];
          }
          if(ends[13]>=biggest2602){
            biggest2602=ends[13];
          }
          if(biggest2602 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2602 == 0){
            S2561=0;
            active[1]=0;
            ends[1]=0;
            S2561=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          motConveyorOn.gethook();
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
      motConveyorOn.setpreclear();
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
      dummyint = motConveyorOn.getStatus() ? motConveyorOn.setprepresent() : motConveyorOn.setpreclear();
      motConveyorOn.setpreval(motConveyorOn.getValue());
      motConveyorOn.setClear();
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
        motConveyorOn.gethook();
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
