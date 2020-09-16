import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

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
  public Signal bottleAdded = new Signal("bottleAdded", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  public Signal turnNozTrigger = new Signal("turnNozTrigger", Signal.OUTPUT);
  public Signal doneAtPos2 = new Signal("doneAtPos2", Signal.OUTPUT);
  public Signal nozBusy = new Signal("nozBusy", Signal.OUTPUT);
  public Signal requestliquid = new Signal("requestliquid", Signal.OUTPUT);
  private Signal doneFilling_13;
  private Signal doneAllLiquids_13;
  private Integer liquidval_thread_14;//sysj\controller.sysj line: 131, column: 3
  private int S1870 = 1;
  private int S1488 = 1;
  private int S626 = 1;
  private int S629 = 1;
  private int S643 = 1;
  private int S659 = 1;
  private int S683 = 1;
  private int S715 = 1;
  private int S1868 = 1;
  private int S1491 = 1;
  private int S1496 = 1;
  private int S1502 = 1;
  private int S1520 = 1;
  private int S1525 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread1923(int [] tdone, int [] ends){
        switch(S1525){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 195, column: 6
        currsigs.addElement(dosUnitValveExtend);
        active[19]=1;
        ends[19]=1;
        tdone[19]=1;
        break;
      
    }
  }

  public void thread1922(int [] tdone, int [] ends){
        switch(S1520){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 192, column: 6
        currsigs.addElement(valveInletOnOff);
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread1920(int [] tdone, int [] ends){
        S1525=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 195, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread1919(int [] tdone, int [] ends){
        S1520=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 192, column: 6
    currsigs.addElement(valveInletOnOff);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1917(int [] tdone, int [] ends){
        switch(S1502){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 185, column: 7
        currsigs.addElement(dosUnitValveRetract);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread1916(int [] tdone, int [] ends){
        switch(S1496){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 181, column: 6
        currsigs.addElement(valveInjectorOnOff);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread1914(int [] tdone, int [] ends){
        S1525=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 195, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread1913(int [] tdone, int [] ends){
        S1520=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 192, column: 6
    currsigs.addElement(valveInletOnOff);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1911(int [] tdone, int [] ends){
        S1502=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 184, column: 14
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 185, column: 7
      currsigs.addElement(dosUnitValveRetract);
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
    else {
      S1502=0;
      active[17]=0;
      ends[17]=0;
      tdone[17]=1;
    }
  }

  public void thread1910(int [] tdone, int [] ends){
        S1496=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 181, column: 6
    currsigs.addElement(valveInjectorOnOff);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread1909(int [] tdone, int [] ends){
        switch(S1868){
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
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
          case 1 : 
            if(bottleAtPos2.getprestatus() && !turnNozTrigger.getprestatus()){//sysj\controller.sysj line: 179, column: 10
              S1491=2;
              thread1910(tdone,ends);
              thread1911(tdone,ends);
              int biggest1912 = 0;
              if(ends[16]>=biggest1912){
                biggest1912=ends[16];
              }
              if(ends[17]>=biggest1912){
                biggest1912=ends[17];
              }
              if(biggest1912 == 1){
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 2 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 180, column: 10
              S1491=3;
              thread1913(tdone,ends);
              thread1914(tdone,ends);
              int biggest1915 = 0;
              if(ends[18]>=biggest1915){
                biggest1915=ends[18];
              }
              if(ends[19]>=biggest1915){
                biggest1915=ends[19];
              }
              if(biggest1915 == 1){
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              thread1916(tdone,ends);
              thread1917(tdone,ends);
              int biggest1918 = 0;
              if(ends[16]>=biggest1918){
                biggest1918=ends[16];
              }
              if(ends[17]>=biggest1918){
                biggest1918=ends[17];
              }
              if(biggest1918 == 1){
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              //FINXME code
              if(biggest1918 == 0){
                S1491=3;
                thread1919(tdone,ends);
                thread1920(tdone,ends);
                int biggest1921 = 0;
                if(ends[18]>=biggest1921){
                  biggest1921=ends[18];
                }
                if(ends[19]>=biggest1921){
                  biggest1921=ends[19];
                }
                if(biggest1921 == 1){
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
            }
            break;
          
          case 3 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 191, column: 10
              doneFilling_13.setPresent();//sysj\controller.sysj line: 199, column: 4
              currsigs.addElement(doneFilling_13);
              if(doneAllLiquids_13.getprestatus()){//sysj\controller.sysj line: 200, column: 12
                doneAtPos2.setPresent();//sysj\controller.sysj line: 201, column: 5
                currsigs.addElement(doneAtPos2);
                S1491=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              else {
                S1491=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              thread1922(tdone,ends);
              thread1923(tdone,ends);
              int biggest1924 = 0;
              if(ends[18]>=biggest1924){
                biggest1924=ends[18];
              }
              if(ends[19]>=biggest1924){
                biggest1924=ends[19];
              }
              if(biggest1924 == 1){
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
              //FINXME code
              if(biggest1924 == 0){
                doneFilling_13.setPresent();//sysj\controller.sysj line: 199, column: 4
                currsigs.addElement(doneFilling_13);
                if(doneAllLiquids_13.getprestatus()){//sysj\controller.sysj line: 200, column: 12
                  doneAtPos2.setPresent();//sysj\controller.sysj line: 201, column: 5
                  currsigs.addElement(doneAtPos2);
                  S1491=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  S1491=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1908(int [] tdone, int [] ends){
        switch(S1488){
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
            if(bottleAdded.getprestatus()){//sysj\controller.sysj line: 133, column: 9
              S626=2;
              requestliquid.setPresent();//sysj\controller.sysj line: 136, column: 5
              currsigs.addElement(requestliquid);
              S629=0;
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
            if(sentliquid.getprestatus()){//sysj\controller.sysj line: 134, column: 10
              liquidval_thread_14 = (int)(sentliquid.getpreval() == null ? null : ((Integer)sentliquid.getpreval()));//sysj\controller.sysj line: 143, column: 3
              System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 145, column: 3
              S626=3;
              if((liquidval_thread_14 & (1 << 0)) != 0){//sysj\controller.sysj line: 146, column: 7
                S643=0;
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 149, column: 7
                currsigs.addElement(turnNozTrigger);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S626=4;
                if((liquidval_thread_14 & (1 << 1)) != 0){//sysj\controller.sysj line: 154, column: 7
                  S659=0;
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 156, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  S626=5;
                  if((liquidval_thread_14 & (1 << 2)) != 0){//sysj\controller.sysj line: 160, column: 7
                    S683=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 162, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    S626=6;
                    if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 166, column: 7
                      S715=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 172, column: 4
                      currsigs.addElement(doneAllLiquids_13);
                                            S626=0;
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                  }
                }
              }
            }
            else {
              switch(S629){
                case 0 : 
                  S629=0;
                  S629=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                  break;
                
                case 1 : 
                  S629=1;
                  requestliquid.setPresent();//sysj\controller.sysj line: 136, column: 5
                  currsigs.addElement(requestliquid);
                  S629=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                  break;
                
              }
            }
            break;
          
          case 3 : 
            switch(S643){
              case 0 : 
                if(noz1.getprestatus()){//sysj\controller.sysj line: 148, column: 12
                  S643=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 149, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 151, column: 12
                  S626=4;
                  if((liquidval_thread_14 & (1 << 1)) != 0){//sysj\controller.sysj line: 154, column: 7
                    S659=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 156, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    S626=5;
                    if((liquidval_thread_14 & (1 << 2)) != 0){//sysj\controller.sysj line: 160, column: 7
                      S683=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 162, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      S626=6;
                      if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 166, column: 7
                        S715=0;
                        turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 7
                        currsigs.addElement(turnNozTrigger);
                        active[14]=1;
                        ends[14]=1;
                        tdone[14]=1;
                      }
                      else {
                        doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 172, column: 4
                        currsigs.addElement(doneAllLiquids_13);
                                                S626=0;
                        active[14]=1;
                        ends[14]=1;
                        tdone[14]=1;
                      }
                    }
                  }
                }
                else {
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 4 : 
            switch(S659){
              case 0 : 
                if(noz2.getprestatus()){//sysj\controller.sysj line: 155, column: 12
                  S659=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 156, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 158, column: 12
                  S626=5;
                  if((liquidval_thread_14 & (1 << 2)) != 0){//sysj\controller.sysj line: 160, column: 7
                    S683=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 162, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    S626=6;
                    if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 166, column: 7
                      S715=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 172, column: 4
                      currsigs.addElement(doneAllLiquids_13);
                                            S626=0;
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                  }
                }
                else {
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 5 : 
            switch(S683){
              case 0 : 
                if(noz3.getprestatus()){//sysj\controller.sysj line: 161, column: 12
                  S683=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 162, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 164, column: 12
                  S626=6;
                  if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 166, column: 7
                    S715=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 172, column: 4
                    currsigs.addElement(doneAllLiquids_13);
                                        S626=0;
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
              
            }
            break;
          
          case 6 : 
            switch(S715){
              case 0 : 
                if(noz4.getprestatus()){//sysj\controller.sysj line: 167, column: 12
                  S715=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 170, column: 12
                  doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 172, column: 4
                  currsigs.addElement(doneAllLiquids_13);
                                    S626=0;
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

  public void thread1906(int [] tdone, int [] ends){
        S1868=1;
    S1491=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread1905(int [] tdone, int [] ends){
        S1488=1;
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
      switch(S1870){
        case 0 : 
          S1870=0;
          break RUN;
        
        case 1 : 
          S1870=2;
          S1870=2;
          doneFilling_13.setClear();//sysj\controller.sysj line: 126, column: 2
          doneAllLiquids_13.setClear();//sysj\controller.sysj line: 126, column: 2
          thread1905(tdone,ends);
          thread1906(tdone,ends);
          int biggest1907 = 0;
          if(ends[14]>=biggest1907){
            biggest1907=ends[14];
          }
          if(ends[15]>=biggest1907){
            biggest1907=ends[15];
          }
          if(biggest1907 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          doneFilling_13.setClear();//sysj\controller.sysj line: 126, column: 2
          doneAllLiquids_13.setClear();//sysj\controller.sysj line: 126, column: 2
          thread1908(tdone,ends);
          thread1909(tdone,ends);
          int biggest1925 = 0;
          if(ends[14]>=biggest1925){
            biggest1925=ends[14];
          }
          if(ends[15]>=biggest1925){
            biggest1925=ends[15];
          }
          if(biggest1925 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1925 == 0){
            S1870=0;
            active[13]=0;
            ends[13]=0;
            S1870=0;
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
    doneFilling_13 = new Signal();
    doneAllLiquids_13 = new Signal();
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
          bottleAdded.gethook();
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
      bottleAdded.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      turnNozTrigger.setpreclear();
      doneAtPos2.setpreclear();
      nozBusy.setpreclear();
      requestliquid.setpreclear();
      doneFilling_13.setpreclear();
      doneAllLiquids_13.setpreclear();
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
      dummyint = bottleAdded.getStatus() ? bottleAdded.setprepresent() : bottleAdded.setpreclear();
      bottleAdded.setpreval(bottleAdded.getValue());
      bottleAdded.setClear();
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
      doneFilling_13.setClear();
      doneAllLiquids_13.setClear();
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
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
        bottleAdded.gethook();
      }
      runFinisher();
      if(active[13] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
