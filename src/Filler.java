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
  private Integer liquidval_thread_14;//sysj\controller.sysj line: 134, column: 3
  private int S2623 = 1;
  private int S1394 = 1;
  private int S652 = 1;
  private int S655 = 1;
  private int S675 = 1;
  private int S703 = 1;
  private int S741 = 1;
  private int S817 = 1;
  private int S2621 = 1;
  private int S1397 = 1;
  private int S1401 = 1;
  private int S1471 = 1;
  private int S1430 = 1;
  private int S1436 = 1;
  private int S1442 = 1;
  private int S1447 = 1;
  
  private int[] ends = new int[25];
  private int[] tdone = new int[25];
  
  public void thread2909(int [] tdone, int [] ends){
        switch(S1447){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 231, column: 6
        currsigs.addElement(dosUnitValveExtend);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
        break;
      
    }
  }

  public void thread2908(int [] tdone, int [] ends){
        switch(S1442){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 228, column: 6
        currsigs.addElement(valveInletOnOff);
        active[20]=1;
        ends[20]=1;
        tdone[20]=1;
        break;
      
    }
  }

  public void thread2906(int [] tdone, int [] ends){
        S1447=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 231, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread2905(int [] tdone, int [] ends){
        S1442=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 228, column: 6
    currsigs.addElement(valveInletOnOff);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2903(int [] tdone, int [] ends){
        switch(S1436){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 221, column: 7
        currsigs.addElement(dosUnitValveRetract);
        active[19]=1;
        ends[19]=1;
        tdone[19]=1;
        break;
      
    }
  }

  public void thread2902(int [] tdone, int [] ends){
        switch(S1430){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 217, column: 6
        currsigs.addElement(valveInjectorOnOff);
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread2900(int [] tdone, int [] ends){
        S1447=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 231, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread2899(int [] tdone, int [] ends){
        S1442=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 228, column: 6
    currsigs.addElement(valveInletOnOff);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2897(int [] tdone, int [] ends){
        S1436=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 220, column: 14
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 221, column: 7
      currsigs.addElement(dosUnitValveRetract);
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
    else {
      S1436=0;
      active[19]=0;
      ends[19]=0;
      tdone[19]=1;
    }
  }

  public void thread2896(int [] tdone, int [] ends){
        S1430=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 217, column: 6
    currsigs.addElement(valveInjectorOnOff);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2894(int [] tdone, int [] ends){
        active[17]=0;
    ends[17]=0;
    tdone[17]=1;
  }

  public void thread2893(int [] tdone, int [] ends){
        switch(S1401){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        if(!bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 204, column: 13
          S1401=0;
          active[16]=0;
          ends[16]=0;
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

  public void thread2891(int [] tdone, int [] ends){
        S1436=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 220, column: 14
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 221, column: 7
      currsigs.addElement(dosUnitValveRetract);
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
    else {
      S1436=0;
      active[19]=0;
      ends[19]=0;
      tdone[19]=1;
    }
  }

  public void thread2890(int [] tdone, int [] ends){
        S1430=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 217, column: 6
    currsigs.addElement(valveInjectorOnOff);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2888(int [] tdone, int [] ends){
        doneAtPos2_L_13.setPresent();//sysj\controller.sysj line: 208, column: 7
    currsigs.addElement(doneAtPos2_L_13);
    active[17]=0;
    ends[17]=0;
    tdone[17]=1;
  }

  public void thread2887(int [] tdone, int [] ends){
        S1401=1;
    doneAtPos2.setPresent();//sysj\controller.sysj line: 203, column: 7
    currsigs.addElement(doneAtPos2);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread2886(int [] tdone, int [] ends){
        switch(S2621){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        switch(S1397){
          case 0 : 
            S1397=0;
            S1397=1;
            active[15]=1;
            ends[15]=1;
            tdone[15]=1;
            break;
          
          case 1 : 
            if(doneAllLiquids_13.getprestatus() || nozzlePlaced_13.getprestatus()){//sysj\controller.sysj line: 199, column: 10
              S1397=2;
              if(doneAllLiquids_13.getprestatus()){//sysj\controller.sysj line: 200, column: 12
                System.out.println("-- 21");//sysj\controller.sysj line: 201, column: 5
                thread2887(tdone,ends);
                thread2888(tdone,ends);
                int biggest2889 = 0;
                if(ends[16]>=biggest2889){
                  biggest2889=ends[16];
                }
                if(ends[17]>=biggest2889){
                  biggest2889=ends[17];
                }
                if(biggest2889 == 1){
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                System.out.println("-- 19");//sysj\controller.sysj line: 212, column: 4
                S1397=3;
                if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 215, column: 12
                  S1471=0;
                  thread2890(tdone,ends);
                  thread2891(tdone,ends);
                  int biggest2892 = 0;
                  if(ends[18]>=biggest2892){
                    biggest2892=ends[18];
                  }
                  if(ends[19]>=biggest2892){
                    biggest2892=ends[19];
                  }
                  if(biggest2892 == 1){
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                }
                else {
                  S1397=0;
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
            }
            else {
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            break;
          
          case 2 : 
            thread2893(tdone,ends);
            thread2894(tdone,ends);
            int biggest2895 = 0;
            if(ends[16]>=biggest2895){
              biggest2895=ends[16];
            }
            if(ends[17]>=biggest2895){
              biggest2895=ends[17];
            }
            if(biggest2895 == 1){
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            //FINXME code
            if(biggest2895 == 0){
              System.out.println("-- 19");//sysj\controller.sysj line: 212, column: 4
              S1397=3;
              if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 215, column: 12
                S1471=0;
                thread2896(tdone,ends);
                thread2897(tdone,ends);
                int biggest2898 = 0;
                if(ends[18]>=biggest2898){
                  biggest2898=ends[18];
                }
                if(ends[19]>=biggest2898){
                  biggest2898=ends[19];
                }
                if(biggest2898 == 1){
                  active[15]=1;
                  ends[15]=1;
                  tdone[15]=1;
                }
              }
              else {
                S1397=0;
                active[15]=1;
                ends[15]=1;
                tdone[15]=1;
              }
            }
            break;
          
          case 3 : 
            if(!bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 214, column: 10
              S1397=0;
              active[15]=1;
              ends[15]=1;
              tdone[15]=1;
            }
            else {
              switch(S1471){
                case 0 : 
                  if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 216, column: 10
                    S1471=1;
                    thread2899(tdone,ends);
                    thread2900(tdone,ends);
                    int biggest2901 = 0;
                    if(ends[20]>=biggest2901){
                      biggest2901=ends[20];
                    }
                    if(ends[21]>=biggest2901){
                      biggest2901=ends[21];
                    }
                    if(biggest2901 == 1){
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                  }
                  else {
                    thread2902(tdone,ends);
                    thread2903(tdone,ends);
                    int biggest2904 = 0;
                    if(ends[18]>=biggest2904){
                      biggest2904=ends[18];
                    }
                    if(ends[19]>=biggest2904){
                      biggest2904=ends[19];
                    }
                    if(biggest2904 == 1){
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                    //FINXME code
                    if(biggest2904 == 0){
                      S1471=1;
                      thread2905(tdone,ends);
                      thread2906(tdone,ends);
                      int biggest2907 = 0;
                      if(ends[20]>=biggest2907){
                        biggest2907=ends[20];
                      }
                      if(ends[21]>=biggest2907){
                        biggest2907=ends[21];
                      }
                      if(biggest2907 == 1){
                        active[15]=1;
                        ends[15]=1;
                        tdone[15]=1;
                      }
                    }
                  }
                  break;
                
                case 1 : 
                  if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 227, column: 10
                    doneFilling_13.setPresent();//sysj\controller.sysj line: 235, column: 4
                    currsigs.addElement(doneFilling_13);
                    S1397=0;
                    active[15]=1;
                    ends[15]=1;
                    tdone[15]=1;
                  }
                  else {
                    thread2908(tdone,ends);
                    thread2909(tdone,ends);
                    int biggest2910 = 0;
                    if(ends[20]>=biggest2910){
                      biggest2910=ends[20];
                    }
                    if(ends[21]>=biggest2910){
                      biggest2910=ends[21];
                    }
                    if(biggest2910 == 1){
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                    //FINXME code
                    if(biggest2910 == 0){
                      doneFilling_13.setPresent();//sysj\controller.sysj line: 235, column: 4
                      currsigs.addElement(doneFilling_13);
                      S1397=0;
                      active[15]=1;
                      ends[15]=1;
                      tdone[15]=1;
                    }
                  }
                  break;
                
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2885(int [] tdone, int [] ends){
        switch(S1394){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S652){
          case 0 : 
            S652=0;
            S652=1;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 1 : 
            if(bottleAdded.getprestatus()){//sysj\controller.sysj line: 136, column: 9
              S652=2;
              requestliquid.setPresent();//sysj\controller.sysj line: 139, column: 5
              currsigs.addElement(requestliquid);
              S655=0;
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
            if(sentliquid.getprestatus()){//sysj\controller.sysj line: 137, column: 10
              liquidval_thread_14 = (int)(sentliquid.getpreval() == null ? null : ((Integer)sentliquid.getpreval()));//sysj\controller.sysj line: 146, column: 3
              System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 148, column: 3
              S652=3;
              if((liquidval_thread_14 & (1 << 0)) != 0){//sysj\controller.sysj line: 149, column: 7
                S675=0;
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 152, column: 7
                currsigs.addElement(turnNozTrigger);
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S652=4;
                if((liquidval_thread_14 & (1 << 1)) != 0){//sysj\controller.sysj line: 159, column: 7
                  S703=0;
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 161, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  System.out.println("-- 1");//sysj\controller.sysj line: 167, column: 4
                  S652=5;
                  if((liquidval_thread_14 & (1 << 2)) != 0){//sysj\controller.sysj line: 168, column: 7
                    System.out.println("-- 2");//sysj\controller.sysj line: 169, column: 5
                    S741=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 171, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    System.out.println("-- 5");//sysj\controller.sysj line: 179, column: 4
                    S652=6;
                    if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 180, column: 7
                      S817=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 182, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      System.out.println("-- 6");//sysj\controller.sysj line: 188, column: 4
                      S652=7;
                      doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 190, column: 5
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
              switch(S655){
                case 0 : 
                  S655=0;
                  S655=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                  break;
                
                case 1 : 
                  S655=1;
                  requestliquid.setPresent();//sysj\controller.sysj line: 139, column: 5
                  currsigs.addElement(requestliquid);
                  S655=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                  break;
                
              }
            }
            break;
          
          case 3 : 
            switch(S675){
              case 0 : 
                if(noz1.getprestatus()){//sysj\controller.sysj line: 151, column: 12
                  S675=1;
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 155, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 152, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 154, column: 12
                  S652=4;
                  if((liquidval_thread_14 & (1 << 1)) != 0){//sysj\controller.sysj line: 159, column: 7
                    S703=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 161, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    System.out.println("-- 1");//sysj\controller.sysj line: 167, column: 4
                    S652=5;
                    if((liquidval_thread_14 & (1 << 2)) != 0){//sysj\controller.sysj line: 168, column: 7
                      System.out.println("-- 2");//sysj\controller.sysj line: 169, column: 5
                      S741=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 171, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      System.out.println("-- 5");//sysj\controller.sysj line: 179, column: 4
                      S652=6;
                      if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 180, column: 7
                        S817=0;
                        turnNozTrigger.setPresent();//sysj\controller.sysj line: 182, column: 7
                        currsigs.addElement(turnNozTrigger);
                        active[14]=1;
                        ends[14]=1;
                        tdone[14]=1;
                      }
                      else {
                        System.out.println("-- 6");//sysj\controller.sysj line: 188, column: 4
                        S652=7;
                        doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 190, column: 5
                        currsigs.addElement(doneAllLiquids_13);
                        active[14]=1;
                        ends[14]=1;
                        tdone[14]=1;
                      }
                    }
                  }
                }
                else {
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 155, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 4 : 
            switch(S703){
              case 0 : 
                if(noz2.getprestatus()){//sysj\controller.sysj line: 160, column: 12
                  S703=1;
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 164, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 161, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 163, column: 12
                  System.out.println("-- 1");//sysj\controller.sysj line: 167, column: 4
                  S652=5;
                  if((liquidval_thread_14 & (1 << 2)) != 0){//sysj\controller.sysj line: 168, column: 7
                    System.out.println("-- 2");//sysj\controller.sysj line: 169, column: 5
                    S741=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 171, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    System.out.println("-- 5");//sysj\controller.sysj line: 179, column: 4
                    S652=6;
                    if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 180, column: 7
                      S817=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 182, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                    else {
                      System.out.println("-- 6");//sysj\controller.sysj line: 188, column: 4
                      S652=7;
                      doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 190, column: 5
                      currsigs.addElement(doneAllLiquids_13);
                      active[14]=1;
                      ends[14]=1;
                      tdone[14]=1;
                    }
                  }
                }
                else {
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 164, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 5 : 
            switch(S741){
              case 0 : 
                if(noz3.getprestatus()){//sysj\controller.sysj line: 170, column: 12
                  System.out.println("-- 3");//sysj\controller.sysj line: 173, column: 6
                  S741=1;
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 175, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 171, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 174, column: 12
                  System.out.println("-- 4");//sysj\controller.sysj line: 177, column: 6
                  System.out.println("-- 5");//sysj\controller.sysj line: 179, column: 4
                  S652=6;
                  if((liquidval_thread_14 & (1 << 3)) != 0){//sysj\controller.sysj line: 180, column: 7
                    S817=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 182, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                  else {
                    System.out.println("-- 6");//sysj\controller.sysj line: 188, column: 4
                    S652=7;
                    doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 190, column: 5
                    currsigs.addElement(doneAllLiquids_13);
                    active[14]=1;
                    ends[14]=1;
                    tdone[14]=1;
                  }
                }
                else {
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 175, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 6 : 
            switch(S817){
              case 0 : 
                if(noz4.getprestatus()){//sysj\controller.sysj line: 181, column: 12
                  S817=1;
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 185, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 182, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
              case 1 : 
                if(doneFilling_13.getprestatus()){//sysj\controller.sysj line: 184, column: 12
                  System.out.println("-- 6");//sysj\controller.sysj line: 188, column: 4
                  S652=7;
                  doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 190, column: 5
                  currsigs.addElement(doneAllLiquids_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  nozzlePlaced_13.setPresent();//sysj\controller.sysj line: 185, column: 7
                  currsigs.addElement(nozzlePlaced_13);
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                break;
              
            }
            break;
          
          case 7 : 
            if(doneAtPos2_L_13.getprestatus()){//sysj\controller.sysj line: 189, column: 10
              System.out.println("-- 7");//sysj\controller.sysj line: 192, column: 4
                            S652=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              doneAllLiquids_13.setPresent();//sysj\controller.sysj line: 190, column: 5
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

  public void thread2883(int [] tdone, int [] ends){
        S2621=1;
    S1397=0;
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2882(int [] tdone, int [] ends){
        S1394=1;
        S652=0;
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
      switch(S2623){
        case 0 : 
          S2623=0;
          break RUN;
        
        case 1 : 
          S2623=2;
          S2623=2;
          doneFilling_13.setClear();//sysj\controller.sysj line: 129, column: 2
          doneAllLiquids_13.setClear();//sysj\controller.sysj line: 129, column: 2
          nozzlePlaced_13.setClear();//sysj\controller.sysj line: 129, column: 2
          doneAtPos2_L_13.setClear();//sysj\controller.sysj line: 129, column: 2
          thread2882(tdone,ends);
          thread2883(tdone,ends);
          int biggest2884 = 0;
          if(ends[14]>=biggest2884){
            biggest2884=ends[14];
          }
          if(ends[15]>=biggest2884){
            biggest2884=ends[15];
          }
          if(biggest2884 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          doneFilling_13.setClear();//sysj\controller.sysj line: 129, column: 2
          doneAllLiquids_13.setClear();//sysj\controller.sysj line: 129, column: 2
          nozzlePlaced_13.setClear();//sysj\controller.sysj line: 129, column: 2
          doneAtPos2_L_13.setClear();//sysj\controller.sysj line: 129, column: 2
          thread2885(tdone,ends);
          thread2886(tdone,ends);
          int biggest2911 = 0;
          if(ends[14]>=biggest2911){
            biggest2911=ends[14];
          }
          if(ends[15]>=biggest2911){
            biggest2911=ends[15];
          }
          if(biggest2911 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2911 == 0){
            S2623=0;
            active[13]=0;
            ends[13]=0;
            S2623=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
