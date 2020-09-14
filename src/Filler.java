import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import org.compsys704.FIFO;//sysj\controller.sysj line: 1, column: 2

public class Filler extends ClockDomain{
  public Filler(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.INPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.INPUT);
  public Signal noz1 = new Signal("noz1", Signal.INPUT);
  public Signal noz2 = new Signal("noz2", Signal.INPUT);
  public Signal noz3 = new Signal("noz3", Signal.INPUT);
  public Signal noz4 = new Signal("noz4", Signal.INPUT);
  public Signal sentliquid = new Signal("sentliquid", Signal.INPUT);
  public Signal i_selNoz1 = new Signal("i_selNoz1", Signal.INPUT);
  public Signal i_selNoz2 = new Signal("i_selNoz2", Signal.INPUT);
  public Signal i_selNoz3 = new Signal("i_selNoz3", Signal.INPUT);
  public Signal i_selNoz4 = new Signal("i_selNoz4", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  public Signal turnNozTrigger = new Signal("turnNozTrigger", Signal.OUTPUT);
  public Signal doneAtPos2 = new Signal("doneAtPos2", Signal.OUTPUT);
  public Signal nozBusy = new Signal("nozBusy", Signal.OUTPUT);
  public Signal requestliquid = new Signal("requestliquid", Signal.OUTPUT);
  public input_Channel liquidBuffer_in = new input_Channel();
  private Integer liquidval_thread_21;//sysj\controller.sysj line: 169, column: 5
  private int S2468 = 1;
  private int S865 = 1;
  private int S626 = 1;
  private int S631 = 1;
  private int S637 = 1;
  private int S655 = 1;
  private int S660 = 1;
  private int S2466 = 1;
  private int S874 = 1;
  private int S881 = 1;
  private int S876 = 1;
  private int S924 = 1;
  private int S1038 = 1;
  private int S941 = 1;
  private int S931 = 1;
  private int S948 = 1;
  private int S972 = 1;
  private int S1004 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread100198(int [] tdone, int [] ends){
        switch(S1038){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S941){
          case 0 : 
            switch(S931){
              case 0 : 
                if(noz1.getprestatus()){//sysj\controller.sysj line: 172, column: 13
                  S931=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 173, column: 8
                  currsigs.addElement(turnNozTrigger);
                  System.out.println("Emitted turnNozTrigger");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz1.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 175, column: 13
                  S941=1;
                  if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 177, column: 8
                    S948=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
                    currsigs.addElement(turnNozTrigger);
                    System.out.println("Emitted turnNozTrigger");
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S941=2;
                    if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 184, column: 8
                      S972=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 187, column: 8
                      currsigs.addElement(turnNozTrigger);
                      System.out.println("Emitted turnNozTrigger");
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      S941=3;
                      if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 191, column: 8
                        S1004=0;
                        turnNozTrigger.setPresent();//sysj\controller.sysj line: 194, column: 8
                        currsigs.addElement(turnNozTrigger);
                        System.out.println("Emitted turnNozTrigger");
                        active[21]=1;
                        ends[21]=1;
                        tdone[21]=1;
                      }
                      else {
                        S1038=0;
                        active[21]=0;
                        ends[21]=0;
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
              
            }
            break;
          
          case 1 : 
            switch(S948){
              case 0 : 
                if(noz2.getprestatus()){//sysj\controller.sysj line: 179, column: 13
                  S948=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
                  currsigs.addElement(turnNozTrigger);
                  System.out.println("Emitted turnNozTrigger");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz2.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 182, column: 13
                  S941=2;
                  if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 184, column: 8
                    S972=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 187, column: 8
                    currsigs.addElement(turnNozTrigger);
                    System.out.println("Emitted turnNozTrigger");
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S941=3;
                    if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 191, column: 8
                      S1004=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 194, column: 8
                      currsigs.addElement(turnNozTrigger);
                      System.out.println("Emitted turnNozTrigger");
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      S1038=0;
                      active[21]=0;
                      ends[21]=0;
                      tdone[21]=1;
                    }
                  }
                }
                else {
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            switch(S972){
              case 0 : 
                if(noz3.getprestatus()){//sysj\controller.sysj line: 186, column: 13
                  S972=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 187, column: 8
                  currsigs.addElement(turnNozTrigger);
                  System.out.println("Emitted turnNozTrigger");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz3.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 189, column: 13
                  S941=3;
                  if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 191, column: 8
                    S1004=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 194, column: 8
                    currsigs.addElement(turnNozTrigger);
                    System.out.println("Emitted turnNozTrigger");
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S1038=0;
                    active[21]=0;
                    ends[21]=0;
                    tdone[21]=1;
                  }
                }
                else {
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
            }
            break;
          
          case 3 : 
            switch(S1004){
              case 0 : 
                if(noz4.getprestatus()){//sysj\controller.sysj line: 193, column: 13
                  S1004=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 194, column: 8
                  currsigs.addElement(turnNozTrigger);
                  System.out.println("Emitted turnNozTrigger");
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz4.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 196, column: 13
                  S1038=0;
                  active[21]=0;
                  ends[21]=0;
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
          
        }
        break;
      
    }
  }

  public void thread100197(int [] tdone, int [] ends){
        switch(S924){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 163, column: 11
          S924=0;
          active[20]=0;
          ends[20]=0;
          tdone[20]=1;
        }
        else {
          nozBusy.setPresent();//sysj\controller.sysj line: 164, column: 6
          currsigs.addElement(nozBusy);
          System.out.println("Emitted nozBusy");
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        break;
      
    }
  }

  public void thread100195(int [] tdone, int [] ends){
        S1038=1;
    liquidval_thread_21 = (int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue());//sysj\controller.sysj line: 169, column: 5
    S941=0;
    if((liquidval_thread_21 & (1 << 0)) != 0){//sysj\controller.sysj line: 170, column: 8
      S931=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 173, column: 8
      currsigs.addElement(turnNozTrigger);
      System.out.println("Emitted turnNozTrigger");
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S941=1;
      if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 177, column: 8
        S948=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
        currsigs.addElement(turnNozTrigger);
        System.out.println("Emitted turnNozTrigger");
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S941=2;
        if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 184, column: 8
          S972=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 187, column: 8
          currsigs.addElement(turnNozTrigger);
          System.out.println("Emitted turnNozTrigger");
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S941=3;
          if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 191, column: 8
            S1004=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 194, column: 8
            currsigs.addElement(turnNozTrigger);
            System.out.println("Emitted turnNozTrigger");
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            S1038=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread100194(int [] tdone, int [] ends){
        S924=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 164, column: 6
    currsigs.addElement(nozBusy);
    System.out.println("Emitted nozBusy");
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread100192(int [] tdone, int [] ends){
        S1038=1;
    liquidval_thread_21 = (int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue());//sysj\controller.sysj line: 169, column: 5
    S941=0;
    if((liquidval_thread_21 & (1 << 0)) != 0){//sysj\controller.sysj line: 170, column: 8
      S931=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 173, column: 8
      currsigs.addElement(turnNozTrigger);
      System.out.println("Emitted turnNozTrigger");
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S941=1;
      if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 177, column: 8
        S948=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
        currsigs.addElement(turnNozTrigger);
        System.out.println("Emitted turnNozTrigger");
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S941=2;
        if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 184, column: 8
          S972=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 187, column: 8
          currsigs.addElement(turnNozTrigger);
          System.out.println("Emitted turnNozTrigger");
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S941=3;
          if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 191, column: 8
            S1004=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 194, column: 8
            currsigs.addElement(turnNozTrigger);
            System.out.println("Emitted turnNozTrigger");
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            S1038=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread100191(int [] tdone, int [] ends){
        S924=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 164, column: 6
    currsigs.addElement(nozBusy);
    System.out.println("Emitted nozBusy");
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread100189(int [] tdone, int [] ends){
        S1038=1;
    liquidval_thread_21 = (int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue());//sysj\controller.sysj line: 169, column: 5
    S941=0;
    if((liquidval_thread_21 & (1 << 0)) != 0){//sysj\controller.sysj line: 170, column: 8
      S931=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 173, column: 8
      currsigs.addElement(turnNozTrigger);
      System.out.println("Emitted turnNozTrigger");
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S941=1;
      if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 177, column: 8
        S948=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
        currsigs.addElement(turnNozTrigger);
        System.out.println("Emitted turnNozTrigger");
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S941=2;
        if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 184, column: 8
          S972=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 187, column: 8
          currsigs.addElement(turnNozTrigger);
          System.out.println("Emitted turnNozTrigger");
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S941=3;
          if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 191, column: 8
            S1004=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 194, column: 8
            currsigs.addElement(turnNozTrigger);
            System.out.println("Emitted turnNozTrigger");
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            S1038=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread100188(int [] tdone, int [] ends){
        S924=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 164, column: 6
    currsigs.addElement(nozBusy);
    System.out.println("Emitted nozBusy");
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread100186(int [] tdone, int [] ends){
        S1038=1;
    liquidval_thread_21 = (int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue());//sysj\controller.sysj line: 169, column: 5
    S941=0;
    if((liquidval_thread_21 & (1 << 0)) != 0){//sysj\controller.sysj line: 170, column: 8
      S931=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 173, column: 8
      currsigs.addElement(turnNozTrigger);
      System.out.println("Emitted turnNozTrigger");
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S941=1;
      if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 177, column: 8
        S948=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
        currsigs.addElement(turnNozTrigger);
        System.out.println("Emitted turnNozTrigger");
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S941=2;
        if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 184, column: 8
          S972=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 187, column: 8
          currsigs.addElement(turnNozTrigger);
          System.out.println("Emitted turnNozTrigger");
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S941=3;
          if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 191, column: 8
            S1004=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 194, column: 8
            currsigs.addElement(turnNozTrigger);
            System.out.println("Emitted turnNozTrigger");
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            S1038=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread100185(int [] tdone, int [] ends){
        S924=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 164, column: 6
    currsigs.addElement(nozBusy);
    System.out.println("Emitted nozBusy");
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread100184(int [] tdone, int [] ends){
        switch(S2466){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S874){
          case 0 : 
            S874=0;
            S874=1;
            requestliquid.setPresent();//sysj\controller.sysj line: 156, column: 4
            currsigs.addElement(requestliquid);
            System.out.println("Emitted requestliquid");
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 1 : 
            if(sentliquid.getprestatus()){//sysj\controller.sysj line: 155, column: 10
              S874=2;
              S881=0;
              if(!liquidBuffer_in.isPartnerPresent() || liquidBuffer_in.isPartnerPreempted()){//sysj\controller.sysj line: 159, column: 4
                liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 159, column: 4
                S881=1;
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S876=0;
                if(!liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 159, column: 4
                  liquidBuffer_in.setACK(true);//sysj\controller.sysj line: 159, column: 4
                  S876=1;
                  if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 159, column: 4
                    liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 159, column: 4
                    ends[19]=2;
                    ;//sysj\controller.sysj line: 159, column: 4
                    System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 160, column: 4
                    S874=3;
                    thread100185(tdone,ends);
                    thread100186(tdone,ends);
                    int biggest100187 = 0;
                    if(ends[20]>=biggest100187){
                      biggest100187=ends[20];
                    }
                    if(ends[21]>=biggest100187){
                      biggest100187=ends[21];
                    }
                    if(biggest100187 == 1){
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                  }
                  else {
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                }
                else {
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
              }
            }
            else {
              requestliquid.setPresent();//sysj\controller.sysj line: 156, column: 4
              currsigs.addElement(requestliquid);
              System.out.println("Emitted requestliquid");
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 2 : 
            switch(S881){
              case 0 : 
                if(!liquidBuffer_in.isPartnerPresent() || liquidBuffer_in.isPartnerPreempted()){//sysj\controller.sysj line: 159, column: 4
                  liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 159, column: 4
                  S881=1;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  switch(S876){
                    case 0 : 
                      if(!liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 159, column: 4
                        liquidBuffer_in.setACK(true);//sysj\controller.sysj line: 159, column: 4
                        S876=1;
                        if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 159, column: 4
                          liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 159, column: 4
                          ends[19]=2;
                          ;//sysj\controller.sysj line: 159, column: 4
                          System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 160, column: 4
                          S874=3;
                          thread100188(tdone,ends);
                          thread100189(tdone,ends);
                          int biggest100190 = 0;
                          if(ends[20]>=biggest100190){
                            biggest100190=ends[20];
                          }
                          if(ends[21]>=biggest100190){
                            biggest100190=ends[21];
                          }
                          if(biggest100190 == 1){
                            active[19]=1;
                            ends[19]=1;
                            tdone[19]=1;
                          }
                        }
                        else {
                          active[19]=1;
                          ends[19]=1;
                          tdone[19]=1;
                        }
                      }
                      else {
                        active[19]=1;
                        ends[19]=1;
                        tdone[19]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 159, column: 4
                        liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 159, column: 4
                        ends[19]=2;
                        ;//sysj\controller.sysj line: 159, column: 4
                        System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 160, column: 4
                        S874=3;
                        thread100191(tdone,ends);
                        thread100192(tdone,ends);
                        int biggest100193 = 0;
                        if(ends[20]>=biggest100193){
                          biggest100193=ends[20];
                        }
                        if(ends[21]>=biggest100193){
                          biggest100193=ends[21];
                        }
                        if(biggest100193 == 1){
                          active[19]=1;
                          ends[19]=1;
                          tdone[19]=1;
                        }
                      }
                      else {
                        active[19]=1;
                        ends[19]=1;
                        tdone[19]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S881=1;
                S881=0;
                if(!liquidBuffer_in.isPartnerPresent() || liquidBuffer_in.isPartnerPreempted()){//sysj\controller.sysj line: 159, column: 4
                  liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 159, column: 4
                  S881=1;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S876=0;
                  if(!liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 159, column: 4
                    liquidBuffer_in.setACK(true);//sysj\controller.sysj line: 159, column: 4
                    S876=1;
                    if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 159, column: 4
                      liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 159, column: 4
                      ends[19]=2;
                      ;//sysj\controller.sysj line: 159, column: 4
                      System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 160, column: 4
                      S874=3;
                      thread100194(tdone,ends);
                      thread100195(tdone,ends);
                      int biggest100196 = 0;
                      if(ends[20]>=biggest100196){
                        biggest100196=ends[20];
                      }
                      if(ends[21]>=biggest100196){
                        biggest100196=ends[21];
                      }
                      if(biggest100196 == 1){
                        active[19]=1;
                        ends[19]=1;
                        tdone[19]=1;
                      }
                    }
                    else {
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                  }
                  else {
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                }
                break;
              
            }
            break;
          
          case 3 : 
            thread100197(tdone,ends);
            thread100198(tdone,ends);
            int biggest100199 = 0;
            if(ends[20]>=biggest100199){
              biggest100199=ends[20];
            }
            if(ends[21]>=biggest100199){
              biggest100199=ends[21];
            }
            if(biggest100199 == 1){
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            //FINXME code
            if(biggest100199 == 0){
              S874=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread100182(int [] tdone, int [] ends){
        switch(S660){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 146, column: 5
        currsigs.addElement(dosUnitValveExtend);
        System.out.println("Emitted dosUnitValveExtend");
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread100181(int [] tdone, int [] ends){
        switch(S655){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 143, column: 5
        currsigs.addElement(valveInletOnOff);
        System.out.println("Emitted valveInletOnOff");
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread100179(int [] tdone, int [] ends){
        S660=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 146, column: 5
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread100178(int [] tdone, int [] ends){
        S655=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 143, column: 5
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread100176(int [] tdone, int [] ends){
        switch(S637){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 136, column: 6
        currsigs.addElement(dosUnitValveRetract);
        System.out.println("Emitted dosUnitValveRetract");
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread100175(int [] tdone, int [] ends){
        switch(S631){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 132, column: 5
        currsigs.addElement(valveInjectorOnOff);
        System.out.println("Emitted valveInjectorOnOff");
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread100173(int [] tdone, int [] ends){
        S660=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 146, column: 5
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread100172(int [] tdone, int [] ends){
        S655=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 143, column: 5
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread100170(int [] tdone, int [] ends){
        S637=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 135, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 136, column: 6
      currsigs.addElement(dosUnitValveRetract);
      System.out.println("Emitted dosUnitValveRetract");
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      S637=0;
      active[16]=0;
      ends[16]=0;
      tdone[16]=1;
    }
  }

  public void thread100169(int [] tdone, int [] ends){
        S631=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 132, column: 5
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread100168(int [] tdone, int [] ends){
        switch(S865){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S626){
          case 0 : 
            S626=0;
            S626=1;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 1 : 
            if(bottleAtPos2.getprestatus() && !turnNozTrigger.getprestatus()){//sysj\controller.sysj line: 130, column: 9
              S626=2;
              thread100169(tdone,ends);
              thread100170(tdone,ends);
              int biggest100171 = 0;
              if(ends[15]>=biggest100171){
                biggest100171=ends[15];
              }
              if(ends[16]>=biggest100171){
                biggest100171=ends[16];
              }
              if(biggest100171 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 2 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 131, column: 9
              S626=3;
              thread100172(tdone,ends);
              thread100173(tdone,ends);
              int biggest100174 = 0;
              if(ends[17]>=biggest100174){
                biggest100174=ends[17];
              }
              if(ends[18]>=biggest100174){
                biggest100174=ends[18];
              }
              if(biggest100174 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              thread100175(tdone,ends);
              thread100176(tdone,ends);
              int biggest100177 = 0;
              if(ends[15]>=biggest100177){
                biggest100177=ends[15];
              }
              if(ends[16]>=biggest100177){
                biggest100177=ends[16];
              }
              if(biggest100177 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest100177 == 0){
                S626=3;
                thread100178(tdone,ends);
                thread100179(tdone,ends);
                int biggest100180 = 0;
                if(ends[17]>=biggest100180){
                  biggest100180=ends[17];
                }
                if(ends[18]>=biggest100180){
                  biggest100180=ends[18];
                }
                if(biggest100180 == 1){
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
            }
            break;
          
          case 3 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 142, column: 9
              doneAtPos2.setPresent();//sysj\controller.sysj line: 149, column: 3
              currsigs.addElement(doneAtPos2);
              System.out.println("Emitted doneAtPos2");
              S626=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              thread100181(tdone,ends);
              thread100182(tdone,ends);
              int biggest100183 = 0;
              if(ends[17]>=biggest100183){
                biggest100183=ends[17];
              }
              if(ends[18]>=biggest100183){
                biggest100183=ends[18];
              }
              if(biggest100183 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest100183 == 0){
                doneAtPos2.setPresent();//sysj\controller.sysj line: 149, column: 3
                currsigs.addElement(doneAtPos2);
                System.out.println("Emitted doneAtPos2");
                S626=0;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread100166(int [] tdone, int [] ends){
        S2466=1;
    S874=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread100165(int [] tdone, int [] ends){
        S865=1;
    S626=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2468){
        case 0 : 
          S2468=0;
          break RUN;
        
        case 1 : 
          S2468=2;
          S2468=2;
          thread100165(tdone,ends);
          thread100166(tdone,ends);
          int biggest100167 = 0;
          if(ends[14]>=biggest100167){
            biggest100167=ends[14];
          }
          if(ends[19]>=biggest100167){
            biggest100167=ends[19];
          }
          if(biggest100167 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          thread100168(tdone,ends);
          thread100184(tdone,ends);
          int biggest100200 = 0;
          if(ends[14]>=biggest100200){
            biggest100200=ends[14];
          }
          if(ends[19]>=biggest100200){
            biggest100200=ends[19];
          }
          if(biggest100200 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest100200 == 0){
            S2468=0;
            active[13]=0;
            ends[13]=0;
            S2468=0;
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
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[13] != 0){
      int index = 13;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        if(!df){
          liquidBuffer_in.gethook();
          bottleAtPos2.gethook();
          dosUnitEvac.gethook();
          dosUnitFilled.gethook();
          noz1.gethook();
          noz2.gethook();
          noz3.gethook();
          noz4.gethook();
          sentliquid.gethook();
          i_selNoz1.gethook();
          i_selNoz2.gethook();
          i_selNoz3.gethook();
          i_selNoz4.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      noz1.setpreclear();
      noz2.setpreclear();
      noz3.setpreclear();
      noz4.setpreclear();
      sentliquid.setpreclear();
      i_selNoz1.setpreclear();
      i_selNoz2.setpreclear();
      i_selNoz3.setpreclear();
      i_selNoz4.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      turnNozTrigger.setpreclear();
      doneAtPos2.setpreclear();
      nozBusy.setpreclear();
      requestliquid.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos2.getStatus() ? bottleAtPos2.setprepresent() : bottleAtPos2.setpreclear();
      bottleAtPos2.setpreval(bottleAtPos2.getValue());
      bottleAtPos2.setClear();
      dummyint = dosUnitEvac.getStatus() ? dosUnitEvac.setprepresent() : dosUnitEvac.setpreclear();
      dosUnitEvac.setpreval(dosUnitEvac.getValue());
      dosUnitEvac.setClear();
      dummyint = dosUnitFilled.getStatus() ? dosUnitFilled.setprepresent() : dosUnitFilled.setpreclear();
      dosUnitFilled.setpreval(dosUnitFilled.getValue());
      dosUnitFilled.setClear();
      dummyint = noz1.getStatus() ? noz1.setprepresent() : noz1.setpreclear();
      noz1.setpreval(noz1.getValue());
      noz1.setClear();
      dummyint = noz2.getStatus() ? noz2.setprepresent() : noz2.setpreclear();
      noz2.setpreval(noz2.getValue());
      noz2.setClear();
      dummyint = noz3.getStatus() ? noz3.setprepresent() : noz3.setpreclear();
      noz3.setpreval(noz3.getValue());
      noz3.setClear();
      dummyint = noz4.getStatus() ? noz4.setprepresent() : noz4.setpreclear();
      noz4.setpreval(noz4.getValue());
      noz4.setClear();
      dummyint = sentliquid.getStatus() ? sentliquid.setprepresent() : sentliquid.setpreclear();
      sentliquid.setpreval(sentliquid.getValue());
      sentliquid.setClear();
      dummyint = i_selNoz1.getStatus() ? i_selNoz1.setprepresent() : i_selNoz1.setpreclear();
      i_selNoz1.setpreval(i_selNoz1.getValue());
      i_selNoz1.setClear();
      dummyint = i_selNoz2.getStatus() ? i_selNoz2.setprepresent() : i_selNoz2.setpreclear();
      i_selNoz2.setpreval(i_selNoz2.getValue());
      i_selNoz2.setClear();
      dummyint = i_selNoz3.getStatus() ? i_selNoz3.setprepresent() : i_selNoz3.setpreclear();
      i_selNoz3.setpreval(i_selNoz3.getValue());
      i_selNoz3.setClear();
      dummyint = i_selNoz4.getStatus() ? i_selNoz4.setprepresent() : i_selNoz4.setpreclear();
      i_selNoz4.setpreval(i_selNoz4.getValue());
      i_selNoz4.setClear();
      valveInjectorOnOff.sethook();
      valveInjectorOnOff.setClear();
      valveInletOnOff.sethook();
      valveInletOnOff.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      turnNozTrigger.sethook();
      turnNozTrigger.setClear();
      doneAtPos2.sethook();
      doneAtPos2.setClear();
      nozBusy.sethook();
      nozBusy.setClear();
      requestliquid.sethook();
      requestliquid.setClear();
      liquidBuffer_in.sethook();
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        liquidBuffer_in.gethook();
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
        noz1.gethook();
        noz2.gethook();
        noz3.gethook();
        noz4.gethook();
        sentliquid.gethook();
        i_selNoz1.gethook();
        i_selNoz2.gethook();
        i_selNoz3.gethook();
        i_selNoz4.gethook();
      }
      runFinisher();
      if(active[13] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
