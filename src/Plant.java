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
  public Signal bottleAtPos2E = new Signal("bottleAtPos2E", Signal.OUTPUT);
  public Signal bottleAtPos4E = new Signal("bottleAtPos4E", Signal.OUTPUT);
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.OUTPUT);
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.OUTPUT);
  public Signal rotaryTableTriggerE = new Signal("rotaryTableTriggerE", Signal.OUTPUT);
  public Signal bottleAtPos1_RT = new Signal("bottleAtPos1_RT", Signal.OUTPUT);
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
  private int capcount_thread_6;//sysj\plant.sysj line: 104, column: 3
  private int numTurns_thread_13;//sysj\plant.sysj line: 194, column: 3
  private int S8091 = 1;
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
  private int S2667 = 1;
  private int S2547 = 1;
  private int S2555 = 1;
  private int S2563 = 1;
  private int S2583 = 1;
  private int S2569 = 1;
  private int S2567 = 1;
  private int S2591 = 1;
  private int S2629 = 1;
  private int S2603 = 1;
  private int S2601 = 1;
  private int S2649 = 1;
  private int S2635 = 1;
  private int S2633 = 1;
  private int S2657 = 1;
  private int S2665 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread8146(int [] tdone, int [] ends){
        switch(S2665){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 299, column: 24
          bottleAtPos2E.setPresent();//sysj\plant.sysj line: 299, column: 38
          currsigs.addElement(bottleAtPos2E);
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

  public void thread8145(int [] tdone, int [] ends){
        switch(S2657){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 297, column: 24
          bottleAtPos4E.setPresent();//sysj\plant.sysj line: 297, column: 38
          currsigs.addElement(bottleAtPos4E);
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

  public void thread8144(int [] tdone, int [] ends){
        switch(S2649){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S2635){
          case 0 : 
            switch(S2633){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 295, column: 54
                  S2633=1;
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
              
              case 1 : 
                if(enable.getprestatus()){//sysj\plant.sysj line: 295, column: 71
                  bottleAtPos5_RT.setPresent();//sysj\plant.sysj line: 295, column: 80
                  currsigs.addElement(bottleAtPos5_RT);
                  S2635=1;
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
            break;
          
          case 1 : 
            S2635=1;
            S2635=0;
            if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 295, column: 24
              S2633=0;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S2635=1;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread8143(int [] tdone, int [] ends){
        switch(S2629){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S2603){
          case 0 : 
            switch(S2601){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 286, column: 11
                  S2601=1;
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 288, column: 6
                  currsigs.addElement(bottleLeftPos5E);
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 287, column: 11
                  S2603=1;
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                else {
                  bottleLeftPos5E.setPresent();//sysj\plant.sysj line: 288, column: 6
                  currsigs.addElement(bottleLeftPos5E);
                  active[24]=1;
                  ends[24]=1;
                  tdone[24]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S2603=1;
            S2603=0;
            if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 285, column: 12
              S2601=0;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S2603=1;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread8142(int [] tdone, int [] ends){
        switch(S2591){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        if(bottleAtPos5.getprestatus()){//sysj\plant.sysj line: 282, column: 24
          bottleAtPos5E.setPresent();//sysj\plant.sysj line: 282, column: 38
          currsigs.addElement(bottleAtPos5E);
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

  public void thread8141(int [] tdone, int [] ends){
        switch(S2583){
      case 0 : 
        active[22]=0;
        ends[22]=0;
        tdone[22]=1;
        break;
      
      case 1 : 
        switch(S2569){
          case 0 : 
            switch(S2567){
              case 0 : 
                if(!enable.getprestatus()){//sysj\plant.sysj line: 280, column: 54
                  S2567=1;
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
                if(enable.getprestatus()){//sysj\plant.sysj line: 280, column: 71
                  bottleAtPos1_RT.setPresent();//sysj\plant.sysj line: 280, column: 80
                  currsigs.addElement(bottleAtPos1_RT);
                  S2569=1;
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
              
            }
            break;
          
          case 1 : 
            S2569=1;
            S2569=0;
            if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 280, column: 24
              S2567=0;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            else {
              S2569=1;
              active[22]=1;
              ends[22]=1;
              tdone[22]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread8140(int [] tdone, int [] ends){
        switch(S2563){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 278, column: 24
          rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 278, column: 44
          currsigs.addElement(rotaryTableTriggerE);
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
  }

  public void thread8139(int [] tdone, int [] ends){
        switch(S2555){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 276, column: 24
          motConveyorOnE.setPresent();//sysj\plant.sysj line: 276, column: 39
          currsigs.addElement(motConveyorOnE);
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
  }

  public void thread8138(int [] tdone, int [] ends){
        switch(S2547){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 274, column: 24
          bottleAtPos1E.setPresent();//sysj\plant.sysj line: 274, column: 38
          currsigs.addElement(bottleAtPos1E);
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

  public void thread8137(int [] tdone, int [] ends){
        switch(S2667){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        thread8138(tdone,ends);
        thread8139(tdone,ends);
        thread8140(tdone,ends);
        thread8141(tdone,ends);
        thread8142(tdone,ends);
        thread8143(tdone,ends);
        thread8144(tdone,ends);
        thread8145(tdone,ends);
        thread8146(tdone,ends);
        int biggest8147 = 0;
        if(ends[19]>=biggest8147){
          biggest8147=ends[19];
        }
        if(ends[20]>=biggest8147){
          biggest8147=ends[20];
        }
        if(ends[21]>=biggest8147){
          biggest8147=ends[21];
        }
        if(ends[22]>=biggest8147){
          biggest8147=ends[22];
        }
        if(ends[23]>=biggest8147){
          biggest8147=ends[23];
        }
        if(ends[24]>=biggest8147){
          biggest8147=ends[24];
        }
        if(ends[25]>=biggest8147){
          biggest8147=ends[25];
        }
        if(ends[26]>=biggest8147){
          biggest8147=ends[26];
        }
        if(ends[27]>=biggest8147){
          biggest8147=ends[27];
        }
        if(biggest8147 == 1){
          active[18]=1;
          ends[18]=1;
          tdone[18]=1;
        }
        //FINXME code
        if(biggest8147 == 0){
          S2667=0;
          active[18]=0;
          ends[18]=0;
          tdone[18]=1;
        }
        break;
      
    }
  }

  public void thread8136(int [] tdone, int [] ends){
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

  public void thread8135(int [] tdone, int [] ends){
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

  public void thread8134(int [] tdone, int [] ends){
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

  public void thread8133(int [] tdone, int [] ends){
        switch(S2533){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 222, column: 3
        active[14]=1;
        ends[14]=1;
        tdone[14]=1;
        break;
      
    }
  }

  public void thread8132(int [] tdone, int [] ends){
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
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 198, column: 13
              S1483=0;
              active[13]=1;
              ends[13]=1;
              tdone[13]=1;
            }
            else {
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 212, column: 5
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
            if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 197, column: 10
              if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                numTurns_thread_13 = 0;//sysj\plant.sysj line: 212, column: 5
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
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 199, column: 12
                    numTurns_thread_13 = numTurns_thread_13 + 1;//sysj\plant.sysj line: 200, column: 6
                    if(numTurns_thread_13 == 2){//sysj\plant.sysj line: 201, column: 9
                      l_putBottleAt2_1.setPresent();//sysj\plant.sysj line: 202, column: 7
                      currsigs.addElement(l_putBottleAt2_1);
                      if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                        numTurns_thread_13 = 0;//sysj\plant.sysj line: 212, column: 5
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
                      if(numTurns_thread_13 == 3){//sysj\plant.sysj line: 203, column: 15
                        l_putBottleAt4_1.setPresent();//sysj\plant.sysj line: 204, column: 7
                        currsigs.addElement(l_putBottleAt4_1);
                        if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 212, column: 5
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
                        if(numTurns_thread_13 == 4){//sysj\plant.sysj line: 205, column: 15
                          numTurns_thread_13 = 0;//sysj\plant.sysj line: 206, column: 7
                          l_putBottleAt5_1.setPresent();//sysj\plant.sysj line: 207, column: 7
                          currsigs.addElement(l_putBottleAt5_1);
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 212, column: 5
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
                          if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                            numTurns_thread_13 = 0;//sysj\plant.sysj line: 212, column: 5
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
                  if(!rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 211, column: 12
                    numTurns_thread_13 = 0;//sysj\plant.sysj line: 212, column: 5
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

  public void thread8131(int [] tdone, int [] ends){
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
            if(bottleAtPos5.getprestatus() && motConveyorOn.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 184, column: 12
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
            if(!enable.getprestatus()){//sysj\plant.sysj line: 185, column: 11
              bottleLeftPos5.setPresent();//sysj\plant.sysj line: 186, column: 5
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

  public void thread8130(int [] tdone, int [] ends){
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
            if(l_putBottleAt2_1.getprestatus()){//sysj\plant.sysj line: 172, column: 12
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
            if((enable.getprestatus() && !l_putBottleAt2_1.getprestatus())){//sysj\plant.sysj line: 173, column: 11
              S1377=0;
              active[11]=1;
              ends[11]=1;
              tdone[11]=1;
            }
            else {
              switch(S1364){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 174, column: 12
                    S1364=1;
                    bottleAtPos2.setPresent();//sysj\plant.sysj line: 175, column: 6
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
                  bottleAtPos2.setPresent();//sysj\plant.sysj line: 175, column: 6
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

  public void thread8129(int [] tdone, int [] ends){
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
            if(l_putBottleAt4_1.getprestatus()){//sysj\plant.sysj line: 160, column: 12
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
            if((enable.getprestatus() && !l_putBottleAt4_1.getprestatus())){//sysj\plant.sysj line: 161, column: 11
              S1291=0;
              active[10]=1;
              ends[10]=1;
              tdone[10]=1;
            }
            else {
              switch(S1278){
                case 0 : 
                  if(!enable.getprestatus()){//sysj\plant.sysj line: 162, column: 12
                    S1278=1;
                    bottleAtPos4.setPresent();//sysj\plant.sysj line: 163, column: 6
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
                  bottleAtPos4.setPresent();//sysj\plant.sysj line: 163, column: 6
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

  public void thread8128(int [] tdone, int [] ends){
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
            if(l_putBottleAt5_1.getprestatus()){//sysj\plant.sysj line: 149, column: 12
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 151, column: 6
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
            if((enable.getprestatus() && !l_putBottleAt5_1.getprestatus()) || bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 150, column: 11
              S1235=0;
              active[9]=1;
              ends[9]=1;
              tdone[9]=1;
            }
            else {
              bottleAtPos5.setPresent();//sysj\plant.sysj line: 151, column: 6
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

  public void thread8127(int [] tdone, int [] ends){
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
            if(bottleAdded.getprestatus()){//sysj\plant.sysj line: 138, column: 12
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 140, column: 6
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
            if(enable.getprestatus() && !bottleAdded.getprestatus()){//sysj\plant.sysj line: 139, column: 11
              S1189=0;
              active[8]=1;
              ends[8]=1;
              tdone[8]=1;
            }
            else {
              l_bottleAdded_1.setPresent();//sysj\plant.sysj line: 140, column: 6
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

  public void thread8126(int [] tdone, int [] ends){
        switch(S1178){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 123, column: 3
        switch(S1146){
          case 0 : 
            S1146=0;
            S1146=1;
            active[7]=1;
            ends[7]=1;
            tdone[7]=1;
            break;
          
          case 1 : 
            if(l_bottleAdded_1.getprestatus() && enable.getprestatus() && motConveyorOn.getprestatus()){//sysj\plant.sysj line: 127, column: 11
              S1146=2;
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 129, column: 6
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
            if(rotaryTableTrigger.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 128, column: 11
              S1146=0;
              active[7]=1;
              ends[7]=1;
              tdone[7]=1;
            }
            else {
              bottleAtPos1.setPresent();//sysj\plant.sysj line: 129, column: 6
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

  public void thread8125(int [] tdone, int [] ends){
        switch(S1142){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 106, column: 12
          if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 107, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 108, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 110, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 111, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 114, column: 8
              empty.setPresent();//sysj\plant.sysj line: 115, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 114, column: 8
              empty.setPresent();//sysj\plant.sysj line: 115, column: 6
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
          if(refill.getprestatus()){//sysj\plant.sysj line: 110, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 111, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 114, column: 8
              empty.setPresent();//sysj\plant.sysj line: 115, column: 6
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
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 114, column: 8
              empty.setPresent();//sysj\plant.sysj line: 115, column: 6
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

  public void thread8124(int [] tdone, int [] ends){
        switch(S1080){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1034){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 89, column: 10
              S1034=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1016){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 91, column: 13
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
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 92, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 94, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 94, column: 7
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
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 95, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 96, column: 7
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
            if(refill.getprestatus()){//sysj\plant.sysj line: 99, column: 10
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

  public void thread8123(int [] tdone, int [] ends){
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
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 69, column: 12
                  S977=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 72, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 73, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 73, column: 7
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
                  WPgripped.setPresent();//sysj\plant.sysj line: 70, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S982=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 66, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 67, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 68, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 68, column: 6
                    S977=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 70, column: 7
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
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 66, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 67, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 68, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 68, column: 6
                S977=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 70, column: 7
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

  public void thread8122(int [] tdone, int [] ends){
        switch(S968){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S922){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 53, column: 10
              S922=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 54, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 56, column: 10
              S922=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 58, column: 5
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
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 57, column: 10
              S922=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 58, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 60, column: 10
              S922=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 54, column: 5
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

  public void thread8121(int [] tdone, int [] ends){
        switch(S915){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S869){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 40, column: 10
              S869=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 41, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 43, column: 10
              S869=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 45, column: 5
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 44, column: 10
              S869=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 45, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 47, column: 10
              S869=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 41, column: 5
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

  public void thread8118(int [] tdone, int [] ends){
        S2665=1;
    if(bottleAtPos2.getprestatus()){//sysj\plant.sysj line: 299, column: 24
      bottleAtPos2E.setPresent();//sysj\plant.sysj line: 299, column: 38
      currsigs.addElement(bottleAtPos2E);
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

  public void thread8117(int [] tdone, int [] ends){
        S2657=1;
    if(bottleAtPos4.getprestatus()){//sysj\plant.sysj line: 297, column: 24
      bottleAtPos4E.setPresent();//sysj\plant.sysj line: 297, column: 38
      currsigs.addElement(bottleAtPos4E);
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

  public void thread8116(int [] tdone, int [] ends){
        S2649=1;
    S2635=0;
    if(bottleAtPos5.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 295, column: 24
      S2633=0;
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
    else {
      S2635=1;
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
  }

  public void thread8115(int [] tdone, int [] ends){
        S2629=1;
    S2603=0;
    if(bottleLeftPos5.getprestatus()){//sysj\plant.sysj line: 285, column: 12
      S2601=0;
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
    else {
      S2603=1;
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
  }

  public void thread8114(int [] tdone, int [] ends){
        S2591=1;
    if(bottleAtPos5.getprestatus()){//sysj\plant.sysj line: 282, column: 24
      bottleAtPos5E.setPresent();//sysj\plant.sysj line: 282, column: 38
      currsigs.addElement(bottleAtPos5E);
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

  public void thread8113(int [] tdone, int [] ends){
        S2583=1;
    S2569=0;
    if(bottleAtPos1.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 280, column: 24
      S2567=0;
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
    else {
      S2569=1;
      active[22]=1;
      ends[22]=1;
      tdone[22]=1;
    }
  }

  public void thread8112(int [] tdone, int [] ends){
        S2563=1;
    if(rotaryTableTrigger.getprestatus()){//sysj\plant.sysj line: 278, column: 24
      rotaryTableTriggerE.setPresent();//sysj\plant.sysj line: 278, column: 44
      currsigs.addElement(rotaryTableTriggerE);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
  }

  public void thread8111(int [] tdone, int [] ends){
        S2555=1;
    if(motConveyorOn.getprestatus()){//sysj\plant.sysj line: 276, column: 24
      motConveyorOnE.setPresent();//sysj\plant.sysj line: 276, column: 39
      currsigs.addElement(motConveyorOnE);
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
    else {
      active[20]=1;
      ends[20]=1;
      tdone[20]=1;
    }
  }

  public void thread8110(int [] tdone, int [] ends){
        S2547=1;
    if(bottleAtPos1.getprestatus()){//sysj\plant.sysj line: 274, column: 24
      bottleAtPos1E.setPresent();//sysj\plant.sysj line: 274, column: 38
      currsigs.addElement(bottleAtPos1E);
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

  public void thread8109(int [] tdone, int [] ends){
        S2667=1;
    thread8110(tdone,ends);
    thread8111(tdone,ends);
    thread8112(tdone,ends);
    thread8113(tdone,ends);
    thread8114(tdone,ends);
    thread8115(tdone,ends);
    thread8116(tdone,ends);
    thread8117(tdone,ends);
    thread8118(tdone,ends);
    int biggest8119 = 0;
    if(ends[19]>=biggest8119){
      biggest8119=ends[19];
    }
    if(ends[20]>=biggest8119){
      biggest8119=ends[20];
    }
    if(ends[21]>=biggest8119){
      biggest8119=ends[21];
    }
    if(ends[22]>=biggest8119){
      biggest8119=ends[22];
    }
    if(ends[23]>=biggest8119){
      biggest8119=ends[23];
    }
    if(ends[24]>=biggest8119){
      biggest8119=ends[24];
    }
    if(ends[25]>=biggest8119){
      biggest8119=ends[25];
    }
    if(ends[26]>=biggest8119){
      biggest8119=ends[26];
    }
    if(ends[27]>=biggest8119){
      biggest8119=ends[27];
    }
    if(biggest8119 == 1){
      active[18]=1;
      ends[18]=1;
      tdone[18]=1;
    }
  }

  public void thread8108(int [] tdone, int [] ends){
        S2539=1;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread8107(int [] tdone, int [] ends){
        S2537=1;
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread8106(int [] tdone, int [] ends){
        S2535=1;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread8105(int [] tdone, int [] ends){
        S2533=1;
    s_valveInjectorOnOff_1.setClear();//sysj\plant.sysj line: 222, column: 3
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void thread8104(int [] tdone, int [] ends){
        S2530=1;
    numTurns_thread_13 = 0;//sysj\plant.sysj line: 194, column: 3
    S1497=0;
    active[13]=1;
    ends[13]=1;
    tdone[13]=1;
  }

  public void thread8103(int [] tdone, int [] ends){
        S1472=1;
    S1449=0;
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread8102(int [] tdone, int [] ends){
        S1442=1;
    S1377=0;
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread8101(int [] tdone, int [] ends){
        S1356=1;
    S1291=0;
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread8100(int [] tdone, int [] ends){
        S1270=1;
    S1235=0;
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread8099(int [] tdone, int [] ends){
        S1224=1;
    S1189=0;
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread8098(int [] tdone, int [] ends){
        S1178=1;
    s_motConveyorOn_1.setClear();//sysj\plant.sysj line: 123, column: 3
    S1146=0;
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread8097(int [] tdone, int [] ends){
        S1142=1;
    capcount_thread_6 = 5;//sysj\plant.sysj line: 104, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 106, column: 12
      if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 107, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 108, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 110, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 111, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 114, column: 8
          empty.setPresent();//sysj\plant.sysj line: 115, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 114, column: 8
          empty.setPresent();//sysj\plant.sysj line: 115, column: 6
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
      if(refill.getprestatus()){//sysj\plant.sysj line: 110, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 111, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 114, column: 8
          empty.setPresent();//sysj\plant.sysj line: 115, column: 6
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
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 114, column: 8
          empty.setPresent();//sysj\plant.sysj line: 115, column: 6
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

  public void thread8096(int [] tdone, int [] ends){
        S1080=1;
    S1034=0;
    S1016=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread8095(int [] tdone, int [] ends){
        S1012=1;
    S982=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 66, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 67, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 68, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 68, column: 6
        S977=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 70, column: 7
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

  public void thread8094(int [] tdone, int [] ends){
        S968=1;
    S922=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 54, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread8093(int [] tdone, int [] ends){
        S915=1;
    S869=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 41, column: 5
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
      switch(S8091){
        case 0 : 
          S8091=0;
          break RUN;
        
        case 1 : 
          S8091=2;
          S8091=2;
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
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 35, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 35, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 35, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 36, column: 2
          capPos_1.setPresent();//sysj\plant.sysj line: 37, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\plant.sysj line: 37, column: 2
          thread8093(tdone,ends);
          thread8094(tdone,ends);
          thread8095(tdone,ends);
          thread8096(tdone,ends);
          thread8097(tdone,ends);
          thread8098(tdone,ends);
          thread8099(tdone,ends);
          thread8100(tdone,ends);
          thread8101(tdone,ends);
          thread8102(tdone,ends);
          thread8103(tdone,ends);
          thread8104(tdone,ends);
          thread8105(tdone,ends);
          thread8106(tdone,ends);
          thread8107(tdone,ends);
          thread8108(tdone,ends);
          thread8109(tdone,ends);
          int biggest8120 = 0;
          if(ends[2]>=biggest8120){
            biggest8120=ends[2];
          }
          if(ends[3]>=biggest8120){
            biggest8120=ends[3];
          }
          if(ends[4]>=biggest8120){
            biggest8120=ends[4];
          }
          if(ends[5]>=biggest8120){
            biggest8120=ends[5];
          }
          if(ends[6]>=biggest8120){
            biggest8120=ends[6];
          }
          if(ends[7]>=biggest8120){
            biggest8120=ends[7];
          }
          if(ends[8]>=biggest8120){
            biggest8120=ends[8];
          }
          if(ends[9]>=biggest8120){
            biggest8120=ends[9];
          }
          if(ends[10]>=biggest8120){
            biggest8120=ends[10];
          }
          if(ends[11]>=biggest8120){
            biggest8120=ends[11];
          }
          if(ends[12]>=biggest8120){
            biggest8120=ends[12];
          }
          if(ends[13]>=biggest8120){
            biggest8120=ends[13];
          }
          if(ends[14]>=biggest8120){
            biggest8120=ends[14];
          }
          if(ends[15]>=biggest8120){
            biggest8120=ends[15];
          }
          if(ends[16]>=biggest8120){
            biggest8120=ends[16];
          }
          if(ends[17]>=biggest8120){
            biggest8120=ends[17];
          }
          if(ends[18]>=biggest8120){
            biggest8120=ends[18];
          }
          if(biggest8120 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\plant.sysj line: 33, column: 2
          l_bottleAdded_1.setClear();//sysj\plant.sysj line: 34, column: 2
          l_putBottleAt5_1.setClear();//sysj\plant.sysj line: 35, column: 2
          l_putBottleAt4_1.setClear();//sysj\plant.sysj line: 35, column: 2
          l_putBottleAt2_1.setClear();//sysj\plant.sysj line: 35, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 36, column: 2
          thread8121(tdone,ends);
          thread8122(tdone,ends);
          thread8123(tdone,ends);
          thread8124(tdone,ends);
          thread8125(tdone,ends);
          thread8126(tdone,ends);
          thread8127(tdone,ends);
          thread8128(tdone,ends);
          thread8129(tdone,ends);
          thread8130(tdone,ends);
          thread8131(tdone,ends);
          thread8132(tdone,ends);
          thread8133(tdone,ends);
          thread8134(tdone,ends);
          thread8135(tdone,ends);
          thread8136(tdone,ends);
          thread8137(tdone,ends);
          int biggest8148 = 0;
          if(ends[2]>=biggest8148){
            biggest8148=ends[2];
          }
          if(ends[3]>=biggest8148){
            biggest8148=ends[3];
          }
          if(ends[4]>=biggest8148){
            biggest8148=ends[4];
          }
          if(ends[5]>=biggest8148){
            biggest8148=ends[5];
          }
          if(ends[6]>=biggest8148){
            biggest8148=ends[6];
          }
          if(ends[7]>=biggest8148){
            biggest8148=ends[7];
          }
          if(ends[8]>=biggest8148){
            biggest8148=ends[8];
          }
          if(ends[9]>=biggest8148){
            biggest8148=ends[9];
          }
          if(ends[10]>=biggest8148){
            biggest8148=ends[10];
          }
          if(ends[11]>=biggest8148){
            biggest8148=ends[11];
          }
          if(ends[12]>=biggest8148){
            biggest8148=ends[12];
          }
          if(ends[13]>=biggest8148){
            biggest8148=ends[13];
          }
          if(ends[14]>=biggest8148){
            biggest8148=ends[14];
          }
          if(ends[15]>=biggest8148){
            biggest8148=ends[15];
          }
          if(ends[16]>=biggest8148){
            biggest8148=ends[16];
          }
          if(ends[17]>=biggest8148){
            biggest8148=ends[17];
          }
          if(ends[18]>=biggest8148){
            biggest8148=ends[18];
          }
          if(biggest8148 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest8148 == 0){
            S8091=0;
            active[1]=0;
            ends[1]=0;
            S8091=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
      bottleAtPos2E.setpreclear();
      bottleAtPos4E.setpreclear();
      bottleAtPos2.setpreclear();
      bottleAtPos4.setpreclear();
      rotaryTableTriggerE.setpreclear();
      bottleAtPos1_RT.setpreclear();
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
