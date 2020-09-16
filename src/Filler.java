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
  private Signal nozzlePlaced_13;
  private Signal doneAtPos2_L_13;
  private Integer liquidval_thread_14;//sysj\controller.sysj line: 131, column: 3
  private int S2250 = 1;
  private int S1370 = 1;
  private int S628 = 1;
  private int S631 = 1;
  private int S651 = 1;
  private int S679 = 1;
  private int S717 = 1;
  private int S793 = 1;
  private int S2248 = 1;
  private int S1371 = 1;
  private int S1421 = 1;
  private int S1380 = 1;
  private int S1386 = 1;
  private int S1392 = 1;
  private int S1397 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread2306(int [] tdone, int [] ends){
        switch(S1397){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 219, column: 6
        currsigs.addElement(dosUnitValveExtend);
        active[19]=1;
        ends[19]=1;
        tdone[19]=1;
        break;
      
    }
  }

  public void thread2305(int [] tdone, int [] ends){
        switch(S1392){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 216, column: 6
        currsigs.addElement(valveInletOnOff);
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread2303(int [] tdone, int [] ends){
        S1397=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 219, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2302(int [] tdone, int [] ends){
        S1392=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 216, column: 6
    currsigs.addElement(valveInletOnOff);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2300(int [] tdone, int [] ends){
        switch(S1386){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 209, column: 7
        currsigs.addElement(dosUnitValveRetract);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread2299(int [] tdone, int [] ends){
        switch(S1380){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 205, column: 6
        currsigs.addElement(valveInjectorOnOff);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread2297(int [] tdone, int [] ends){
        S1397=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 219, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2296(int [] tdone, int [] ends){
        S1392=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 216, column: 6
    currsigs.addElement(valveInletOnOff);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2294(int [] tdone, int [] ends){
        S1386=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 208, column: 14
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 209, column: 7
      currsigs.addElement(dosUnitValveRetract);
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
    else {
      S1386=0;
      active[17]=0;
      ends[17]=0;
      tdone[17]=1;
    }
  }

  public void thread2293(int [] tdone, int [] ends){
        S1380=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 205, column: 6
    currsigs.addElement(valveInjectorOnOff);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2291(int [] tdone, int [] ends){
        S1386=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 208, column: 14
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 209, column: 7
      currsigs.addElement(dosUnitValveRetract);
      active[17]=1;
      ends[17]=1;
      tdone[17]=1;
    }
    else {
      S1386=0;
      active[17]=0;
      ends[17]=0;
      tdone[17]=1;
    }
  }

  public void thread2290(int [] tdone, int [] ends){
        S1380=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 205, column: 6
    currsigs.addElement(valveInjectorOnOff);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2289(int [] tdone, int [] ends){
        switch(S2248){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1371){
          case 0 : 
            S1371=0;
            System.out.println("-- 11");//sysj\controller.sysj line: 196, column: 4
            if(doneAllLiquids_13.getprestatus()){//sysj\controller.sysj line: 197, column: 12
              System.out.println("-- 8");//sysj\controller.sysj line: 198, column: 5
              doneAtPos2.setPresent();//sysj\controller.sysj line: 199, column: 5
              currsigs.addElement(doneAtPos2);
              doneAtPos2_L_13.setPresent();//sysj\controller.sysj line: 200, column: 5
              currsigs.addElement(doneAtPos2_L_13);
              System.out.println("-- 9");//sysj\controller.sysj line: 201, column: 5
              S1371=1;
              if(bottleAtPos2.getprestatus() && nozzlePlaced_13.getprestatus()){//sysj\controller.sysj line: 203, column: 12
                S1421=0;
                thread2290(tdone,ends);
                thread2291(tdone,ends);
                int biggest2292 = 0;
                if(ends[16]>=biggest2292){
                  biggest2292=ends[16];
                }
                if(ends[17]>=biggest2292){
                  biggest2292=ends[17];
                }
                if(biggest2292 == 1){
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                S1371=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            else {
              S1371=1;
              if(bottleAtPos2.getprestatus() && nozzlePlaced_13.getprestatus()){//sysj\controller.sysj line: 203, column: 12
                S1421=0;
                thread2293(tdone,ends);
                thread2294(tdone,ends);
                int biggest2295 = 0;
                if(ends[16]>=biggest2295){
                  biggest2295=ends[16];
                }
                if(ends[17]>=biggest2295){
                  biggest2295=ends[17];
                }
                if(biggest2295 == 1){
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                S1371=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            break;
          
          case 1 : 
            switch(S1421){
              case 0 : 
                if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 204, column: 10
                  S1421=1;
                  thread2296(tdone,ends);
                  thread2297(tdone,ends);
                  int biggest2298 = 0;
                  if(ends[18]>=biggest2298){
                    biggest2298=ends[18];
                  }
                  if(ends[19]>=biggest2298){
                    biggest2298=ends[19];
                  }
                  if(biggest2298 == 1){
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                }
                else {
                  thread2299(tdone,ends);
                  thread2300(tdone,ends);
                  int biggest2301 = 0;
                  if(ends[16]>=biggest2301){
                    biggest2301=ends[16];
                  }
                  if(ends[17]>=biggest2301){
                    biggest2301=ends[17];
                  }
                  if(biggest2301 == 1){
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  //FINXME code
                  if(biggest2301 == 0){
                    S1421=1;
                    thread2302(tdone,ends);
                    thread2303(tdone,ends);
                    int biggest2304 = 0;
                    if(ends[18]>=biggest2304){
                      biggest2304=ends[18];
                    }
                    if(ends[19]>=biggest2304){
                      biggest2304=ends[19];
                    }
                    if(biggest2304 == 1){
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                  }
                }
                break;
              
              case 1 : 
                if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 215, column: 10
                  doneFilling_13.setPresent();//sysj\controller.sysj line: 223, column: 4
                  currsigs.addElement(doneFilling_13);
                  System.out.println("-- 10");//sysj\controller.sysj line: 225, column: 4
                  S1371=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
                else {
                  thread2305(tdone,ends);
                  thread2306(tdone,ends);
                  int biggest2307 = 0;
                  if(ends[18]>=biggest2307){
                    biggest2307=ends[18];
                  }
                  if(ends[19]>=biggest2307){
                    biggest2307=ends[19];
                  }
                  if(biggest2307 == 1){
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  //FINXME code
                  if(biggest2307 == 0){
                    doneFilling_13.setPresent();//sysj\controller.sysj line: 223, column: 4
                    currsigs.addElement(doneFilling_13);
                    System.out.println("-- 10");//sysj\controller.sysj line: 225, column: 4
                    S1371=0;
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2288(int [] tdone, int [] ends){
        switch(S1370){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S628){
          case 0 : 
            S628=0;
            S628=1;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 1 : 
            if(bottleAdded.getprestatus()){//sysj\controller.sysj line: 133, column: 9
              S628=2;
              requestliquid.setPresent();//sysj\controller.sysj line: 136, column: 5
              currsigs.addElement(requestliquid);
              S631=0;
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
              S628=3;
              if((liquidval_thread_14 & (1 << 0)) != 0){//sysj\controller.sysj line: 146, column: 7
                S651=0;
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 149, column: 7
                currsigs.addElement(turnNozTrigger);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S628=4;
                if((liquidval_thread_14 & (1 << 1)) != 0){//sysj\controller.sysj line: 156, column: 7
                  S679=0;
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 158, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  System.out.println("-- 1");//sysj\controller.sysj line: 164, column: 4
                  S628=5;
                  if((liquidval_thread_14 & (1 << 2)) != 0){//sysj\controller.sysj line: 165, column: 7
                    System.out.println("-- 2");//sysj\controller.sysj line: 166, column: 5
                    S717=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    System.out.println("-- 5");//sysj\controller.sysj line: 176, column: 4
                    S628=6;
                    if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 177, column: 7
                      S793=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 179, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      System.out.println("-- 6");//sysj\controller.sysj line: 185, column: 4
                      S628=7;
                      doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 187, column: 5
                      currsigs.addElement(doneAllLiquids_13);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                  }
                }
              }
            }
            else {
              switch(S631){
                case 0 : 
                  S631=0;
                  S631=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                  break;
                
                case 1 : 
                  S631=1;
                  requestliquid.setPresent();//sysj\controller.sysj line: 136, column: 5
                  currsigs.addElement(requestliquid);
                  S631=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                  break;
                
              }
            }
            break;
          
          case 3 : 
            switch(S651){
              case 0 : 
                if(noz1.getprestatus()){//sysj\controller.sysj line: 148, column: 12
                  S651=1;
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 152, column: 7
                  currsigs.addElement(nozzlePlaced_13);
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
                  S628=4;
                  if((liquidval_thread_14 & (1 << 1)) != 0){//sysj\controller.sysj line: 156, column: 7
                    S679=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 158, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    System.out.println("-- 1");//sysj\controller.sysj line: 164, column: 4
                    S628=5;
                    if((liquidval_thread_14 & (1 << 2)) != 0){//sysj\controller.sysj line: 165, column: 7
                      System.out.println("-- 2");//sysj\controller.sysj line: 166, column: 5
                      S717=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      System.out.println("-- 5");//sysj\controller.sysj line: 176, column: 4
                      S628=6;
                      if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 177, column: 7
                        S793=0;
                        turnNozTrigger.setPresent();//sysj\controller.sysj line: 179, column: 7
                        currsigs.addElement(turnNozTrigger);
                        active[14]=1;
                        ends[14]=1;
                        tdone[14]=1;
                      }
                      else {
                        System.out.println("-- 6");//sysj\controller.sysj line: 185, column: 4
                        S628=7;
                        doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 187, column: 5
                        currsigs.addElement(doneAllLiquids_13);
                        active[14]=1;
                        ends[14]=1;
                        tdone[14]=1;
                      }
                    }
                  }
                }
                else {
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 152, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 4 : 
            switch(S679){
              case 0 : 
                if(noz2.getprestatus()){//sysj\controller.sysj line: 157, column: 12
                  S679=1;
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 161, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 158, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 160, column: 12
                  System.out.println("-- 1");//sysj\controller.sysj line: 164, column: 4
                  S628=5;
                  if((liquidval_thread_14 & (1 << 2)) != 0){//sysj\controller.sysj line: 165, column: 7
                    System.out.println("-- 2");//sysj\controller.sysj line: 166, column: 5
                    S717=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    System.out.println("-- 5");//sysj\controller.sysj line: 176, column: 4
                    S628=6;
                    if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 177, column: 7
                      S793=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 179, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      System.out.println("-- 6");//sysj\controller.sysj line: 185, column: 4
                      S628=7;
                      doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 187, column: 5
                      currsigs.addElement(doneAllLiquids_13);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                  }
                }
                else {
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 161, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 5 : 
            switch(S717){
              case 0 : 
                if(noz3.getprestatus()){//sysj\controller.sysj line: 167, column: 12
                  System.out.println("-- 3");//sysj\controller.sysj line: 170, column: 6
                  S717=1;
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 172, column: 7
                  currsigs.addElement(nozzlePlaced_13);
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
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 171, column: 12
                  System.out.println("-- 4");//sysj\controller.sysj line: 174, column: 6
                  System.out.println("-- 5");//sysj\controller.sysj line: 176, column: 4
                  S628=6;
                  if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 177, column: 7
                    S793=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 179, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    System.out.println("-- 6");//sysj\controller.sysj line: 185, column: 4
                    S628=7;
                    doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 187, column: 5
                    currsigs.addElement(doneAllLiquids_13);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                }
                else {
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 172, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 6 : 
            switch(S793){
              case 0 : 
                if(noz4.getprestatus()){//sysj\controller.sysj line: 178, column: 12
                  S793=1;
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 182, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 179, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 181, column: 12
                  System.out.println("-- 6");//sysj\controller.sysj line: 185, column: 4
                  S628=7;
                  doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 187, column: 5
                  currsigs.addElement(doneAllLiquids_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 182, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 7 : 
            if(doneAtPos2_L_13.getprestatus()){//sysj\controller.sysj line: 186, column: 10
              System.out.println("-- 7");//sysj\controller.sysj line: 189, column: 4
                            S628=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 187, column: 5
              currsigs.addElement(doneAllLiquids_13);
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2286(int [] tdone, int [] ends){
        S2248=1;
    S1371=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2285(int [] tdone, int [] ends){
        S1370=1;
        S628=0;
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
      switch(S2250){
        case 0 : 
          S2250=0;
          break RUN;
        
        case 1 : 
          S2250=2;
          S2250=2;
          doneFilling_13.setClear();//sysj\controller.sysj line: 126, column: 2
          doneAllLiquids_13.setClear();//sysj\controller.sysj line: 126, column: 2
          nozzlePlaced_13.setClear();//sysj\controller.sysj line: 126, column: 2
          doneAtPos2_L_13.setClear();//sysj\controller.sysj line: 126, column: 2
          thread2285(tdone,ends);
          thread2286(tdone,ends);
          int biggest2287 = 0;
          if(ends[14]>=biggest2287){
            biggest2287=ends[14];
          }
          if(ends[15]>=biggest2287){
            biggest2287=ends[15];
          }
          if(biggest2287 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          doneFilling_13.setClear();//sysj\controller.sysj line: 126, column: 2
          doneAllLiquids_13.setClear();//sysj\controller.sysj line: 126, column: 2
          nozzlePlaced_13.setClear();//sysj\controller.sysj line: 126, column: 2
          doneAtPos2_L_13.setClear();//sysj\controller.sysj line: 126, column: 2
          thread2288(tdone,ends);
          thread2289(tdone,ends);
          int biggest2308 = 0;
          if(ends[14]>=biggest2308){
            biggest2308=ends[14];
          }
          if(ends[15]>=biggest2308){
            biggest2308=ends[15];
          }
          if(biggest2308 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2308 == 0){
            S2250=0;
            active[13]=0;
            ends[13]=0;
            S2250=0;
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
    nozzlePlaced_13 = new Signal();
    doneAtPos2_L_13 = new Signal();
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
      nozzlePlaced_13.setpreclear();
      doneAtPos2_L_13.setpreclear();
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
      nozzlePlaced_13.setClear();
      doneAtPos2_L_13.setClear();
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
