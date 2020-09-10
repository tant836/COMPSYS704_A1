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
  private int S2345 = 1;
  private int S865 = 1;
  private int S626 = 1;
  private int S631 = 1;
  private int S637 = 1;
  private int S655 = 1;
  private int S660 = 1;
  private int S2343 = 1;
  private int S866 = 1;
  private int S1049 = 1;
  private int S873 = 1;
  private int S868 = 1;
  private int S894 = 1;
  private int S928 = 1;
  private int S926 = 1;
  private int S901 = 1;
  private int S925 = 1;
  private int S908 = 1;
  private int S924 = 1;
  private int S915 = 1;
  private int S922 = 1;
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void thread2413(int [] tdone, int [] ends){
        switch(S928){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S926){
          case 0 : 
            switch(S901){
              case 0 : 
                if(noz1.getprestatus()){//sysj\controller.sysj line: 167, column: 13
                  S901=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 8
                  currsigs.addElement(turnNozTrigger);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz1.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 170, column: 13
                  S928=0;
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
          
          case 1 : 
            switch(S925){
              case 0 : 
                switch(S908){
                  case 0 : 
                    if(noz2.getprestatus()){//sysj\controller.sysj line: 173, column: 13
                      S908=1;
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 8
                      currsigs.addElement(turnNozTrigger);
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    break;
                  
                  case 1 : 
                    if(noz2.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 176, column: 13
                      S928=0;
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
              
              case 1 : 
                switch(S924){
                  case 0 : 
                    switch(S915){
                      case 0 : 
                        if(noz3.getprestatus()){//sysj\controller.sysj line: 179, column: 13
                          S915=1;
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                        else {
                          turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
                          currsigs.addElement(turnNozTrigger);
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                        break;
                      
                      case 1 : 
                        if(noz3.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 182, column: 13
                          S928=0;
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
                  
                  case 1 : 
                    switch(S922){
                      case 0 : 
                        if(noz4.getprestatus()){//sysj\controller.sysj line: 185, column: 13
                          S922=1;
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                        else {
                          turnNozTrigger.setPresent();//sysj\controller.sysj line: 186, column: 8
                          currsigs.addElement(turnNozTrigger);
                          active[21]=1;
                          ends[21]=1;
                          tdone[21]=1;
                        }
                        break;
                      
                      case 1 : 
                        if(noz4.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 188, column: 13
                          S928=0;
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
            break;
          
        }
        break;
      
    }
  }

  public void thread2412(int [] tdone, int [] ends){
        switch(S894){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 159, column: 11
          S894=0;
          active[20]=0;
          ends[20]=0;
          tdone[20]=1;
        }
        else {
          nozBusy.setPresent();//sysj\controller.sysj line: 160, column: 6
          currsigs.addElement(nozBusy);
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        break;
      
    }
  }

  public void thread2410(int [] tdone, int [] ends){
        S928=1;
    if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 1){//sysj\controller.sysj line: 165, column: 8
      S926=0;
      S901=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 8
      currsigs.addElement(turnNozTrigger);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S926=1;
      if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 2){//sysj\controller.sysj line: 171, column: 14
        S925=0;
        S908=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 8
        currsigs.addElement(turnNozTrigger);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S925=1;
        if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 3){//sysj\controller.sysj line: 177, column: 14
          S924=0;
          S915=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
          currsigs.addElement(turnNozTrigger);
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S924=1;
          if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 4){//sysj\controller.sysj line: 183, column: 14
            S922=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 186, column: 8
            currsigs.addElement(turnNozTrigger);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            S928=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread2409(int [] tdone, int [] ends){
        S894=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 160, column: 6
    currsigs.addElement(nozBusy);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2407(int [] tdone, int [] ends){
        S928=1;
    if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 1){//sysj\controller.sysj line: 165, column: 8
      S926=0;
      S901=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 8
      currsigs.addElement(turnNozTrigger);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S926=1;
      if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 2){//sysj\controller.sysj line: 171, column: 14
        S925=0;
        S908=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 8
        currsigs.addElement(turnNozTrigger);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S925=1;
        if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 3){//sysj\controller.sysj line: 177, column: 14
          S924=0;
          S915=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
          currsigs.addElement(turnNozTrigger);
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S924=1;
          if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 4){//sysj\controller.sysj line: 183, column: 14
            S922=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 186, column: 8
            currsigs.addElement(turnNozTrigger);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            S928=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread2406(int [] tdone, int [] ends){
        S894=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 160, column: 6
    currsigs.addElement(nozBusy);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2404(int [] tdone, int [] ends){
        S928=1;
    if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 1){//sysj\controller.sysj line: 165, column: 8
      S926=0;
      S901=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 8
      currsigs.addElement(turnNozTrigger);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S926=1;
      if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 2){//sysj\controller.sysj line: 171, column: 14
        S925=0;
        S908=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 8
        currsigs.addElement(turnNozTrigger);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S925=1;
        if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 3){//sysj\controller.sysj line: 177, column: 14
          S924=0;
          S915=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
          currsigs.addElement(turnNozTrigger);
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S924=1;
          if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 4){//sysj\controller.sysj line: 183, column: 14
            S922=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 186, column: 8
            currsigs.addElement(turnNozTrigger);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            S928=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread2403(int [] tdone, int [] ends){
        S894=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 160, column: 6
    currsigs.addElement(nozBusy);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2401(int [] tdone, int [] ends){
        S928=1;
    if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 1){//sysj\controller.sysj line: 165, column: 8
      S926=0;
      S901=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 168, column: 8
      currsigs.addElement(turnNozTrigger);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S926=1;
      if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 2){//sysj\controller.sysj line: 171, column: 14
        S925=0;
        S908=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 8
        currsigs.addElement(turnNozTrigger);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S925=1;
        if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 3){//sysj\controller.sysj line: 177, column: 14
          S924=0;
          S915=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 180, column: 8
          currsigs.addElement(turnNozTrigger);
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S924=1;
          if((int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue()) == 4){//sysj\controller.sysj line: 183, column: 14
            S922=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 186, column: 8
            currsigs.addElement(turnNozTrigger);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            S928=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread2400(int [] tdone, int [] ends){
        S894=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 160, column: 6
    currsigs.addElement(nozBusy);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread2399(int [] tdone, int [] ends){
        switch(S2343){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S866){
          case 0 : 
            S866=0;
            requestliquid.setPresent();//sysj\controller.sysj line: 154, column: 3
            currsigs.addElement(requestliquid);
            S866=1;
            if(!sentliquid.getprestatus()){//sysj\controller.sysj line: 155, column: 11
              S1049=0;
              S873=0;
              if(!liquidBuffer_in.isPartnerPresent() || liquidBuffer_in.isPartnerPreempted()){//sysj\controller.sysj line: 156, column: 4
                liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 156, column: 4
                S873=1;
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S868=0;
                if(!liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 156, column: 4
                  liquidBuffer_in.setACK(true);//sysj\controller.sysj line: 156, column: 4
                  S868=1;
                  if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 156, column: 4
                    liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 156, column: 4
                    ends[19]=2;
                    ;//sysj\controller.sysj line: 156, column: 4
                    S1049=1;
                    thread2400(tdone,ends);
                    thread2401(tdone,ends);
                    int biggest2402 = 0;
                    if(ends[20]>=biggest2402){
                      biggest2402=ends[20];
                    }
                    if(ends[21]>=biggest2402){
                      biggest2402=ends[21];
                    }
                    if(biggest2402 == 1){
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
              S866=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 1 : 
            switch(S1049){
              case 0 : 
                switch(S873){
                  case 0 : 
                    if(!liquidBuffer_in.isPartnerPresent() || liquidBuffer_in.isPartnerPreempted()){//sysj\controller.sysj line: 156, column: 4
                      liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 156, column: 4
                      S873=1;
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    else {
                      switch(S868){
                        case 0 : 
                          if(!liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 156, column: 4
                            liquidBuffer_in.setACK(true);//sysj\controller.sysj line: 156, column: 4
                            S868=1;
                            if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 156, column: 4
                              liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 156, column: 4
                              ends[19]=2;
                              ;//sysj\controller.sysj line: 156, column: 4
                              S1049=1;
                              thread2403(tdone,ends);
                              thread2404(tdone,ends);
                              int biggest2405 = 0;
                              if(ends[20]>=biggest2405){
                                biggest2405=ends[20];
                              }
                              if(ends[21]>=biggest2405){
                                biggest2405=ends[21];
                              }
                              if(biggest2405 == 1){
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
                          if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 156, column: 4
                            liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 156, column: 4
                            ends[19]=2;
                            ;//sysj\controller.sysj line: 156, column: 4
                            S1049=1;
                            thread2406(tdone,ends);
                            thread2407(tdone,ends);
                            int biggest2408 = 0;
                            if(ends[20]>=biggest2408){
                              biggest2408=ends[20];
                            }
                            if(ends[21]>=biggest2408){
                              biggest2408=ends[21];
                            }
                            if(biggest2408 == 1){
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
                    S873=1;
                    S873=0;
                    if(!liquidBuffer_in.isPartnerPresent() || liquidBuffer_in.isPartnerPreempted()){//sysj\controller.sysj line: 156, column: 4
                      liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 156, column: 4
                      S873=1;
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    else {
                      S868=0;
                      if(!liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 156, column: 4
                        liquidBuffer_in.setACK(true);//sysj\controller.sysj line: 156, column: 4
                        S868=1;
                        if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 156, column: 4
                          liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 156, column: 4
                          ends[19]=2;
                          ;//sysj\controller.sysj line: 156, column: 4
                          S1049=1;
                          thread2409(tdone,ends);
                          thread2410(tdone,ends);
                          int biggest2411 = 0;
                          if(ends[20]>=biggest2411){
                            biggest2411=ends[20];
                          }
                          if(ends[21]>=biggest2411){
                            biggest2411=ends[21];
                          }
                          if(biggest2411 == 1){
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
              
              case 1 : 
                thread2412(tdone,ends);
                thread2413(tdone,ends);
                int biggest2414 = 0;
                if(ends[20]>=biggest2414){
                  biggest2414=ends[20];
                }
                if(ends[21]>=biggest2414){
                  biggest2414=ends[21];
                }
                if(biggest2414 == 1){
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                //FINXME code
                if(biggest2414 == 0){
                  S866=0;
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

  public void thread2397(int [] tdone, int [] ends){
        switch(S660){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 146, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread2396(int [] tdone, int [] ends){
        switch(S655){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 143, column: 5
        currsigs.addElement(valveInletOnOff);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread2394(int [] tdone, int [] ends){
        S660=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 146, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2393(int [] tdone, int [] ends){
        S655=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 143, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2391(int [] tdone, int [] ends){
        switch(S637){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 136, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread2390(int [] tdone, int [] ends){
        switch(S631){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 132, column: 5
        currsigs.addElement(valveInjectorOnOff);
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread2388(int [] tdone, int [] ends){
        S660=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 146, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread2387(int [] tdone, int [] ends){
        S655=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 143, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread2385(int [] tdone, int [] ends){
        S637=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 135, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 136, column: 6
      currsigs.addElement(dosUnitValveRetract);
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

  public void thread2384(int [] tdone, int [] ends){
        S631=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 132, column: 5
    currsigs.addElement(valveInjectorOnOff);
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread2383(int [] tdone, int [] ends){
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
              thread2384(tdone,ends);
              thread2385(tdone,ends);
              int biggest2386 = 0;
              if(ends[15]>=biggest2386){
                biggest2386=ends[15];
              }
              if(ends[16]>=biggest2386){
                biggest2386=ends[16];
              }
              if(biggest2386 == 1){
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
              thread2387(tdone,ends);
              thread2388(tdone,ends);
              int biggest2389 = 0;
              if(ends[17]>=biggest2389){
                biggest2389=ends[17];
              }
              if(ends[18]>=biggest2389){
                biggest2389=ends[18];
              }
              if(biggest2389 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              thread2390(tdone,ends);
              thread2391(tdone,ends);
              int biggest2392 = 0;
              if(ends[15]>=biggest2392){
                biggest2392=ends[15];
              }
              if(ends[16]>=biggest2392){
                biggest2392=ends[16];
              }
              if(biggest2392 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest2392 == 0){
                S626=3;
                thread2393(tdone,ends);
                thread2394(tdone,ends);
                int biggest2395 = 0;
                if(ends[17]>=biggest2395){
                  biggest2395=ends[17];
                }
                if(ends[18]>=biggest2395){
                  biggest2395=ends[18];
                }
                if(biggest2395 == 1){
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
              S626=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              thread2396(tdone,ends);
              thread2397(tdone,ends);
              int biggest2398 = 0;
              if(ends[17]>=biggest2398){
                biggest2398=ends[17];
              }
              if(ends[18]>=biggest2398){
                biggest2398=ends[18];
              }
              if(biggest2398 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest2398 == 0){
                doneAtPos2.setPresent();//sysj\controller.sysj line: 149, column: 3
                currsigs.addElement(doneAtPos2);
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

  public void thread2381(int [] tdone, int [] ends){
        S2343=1;
    S866=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread2380(int [] tdone, int [] ends){
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
      switch(S2345){
        case 0 : 
          S2345=0;
          break RUN;
        
        case 1 : 
          S2345=2;
          S2345=2;
          thread2380(tdone,ends);
          thread2381(tdone,ends);
          int biggest2382 = 0;
          if(ends[14]>=biggest2382){
            biggest2382=ends[14];
          }
          if(ends[19]>=biggest2382){
            biggest2382=ends[19];
          }
          if(biggest2382 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          thread2383(tdone,ends);
          thread2399(tdone,ends);
          int biggest2415 = 0;
          if(ends[14]>=biggest2415){
            biggest2415=ends[14];
          }
          if(ends[19]>=biggest2415){
            biggest2415=ends[19];
          }
          if(biggest2415 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2415 == 0){
            S2345=0;
            active[13]=0;
            ends[13]=0;
            S2345=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
