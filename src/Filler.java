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
  private Signal finishfillorder_13;
  private Integer liquidval_thread_21;//sysj\controller.sysj line: 172, column: 5
  private int S2607 = 1;
  private int S1004 = 1;
  private int S627 = 1;
  private int S632 = 1;
  private int S638 = 1;
  private int S656 = 1;
  private int S661 = 1;
  private int S2605 = 1;
  private int S1013 = 1;
  private int S1020 = 1;
  private int S1015 = 1;
  private int S1063 = 1;
  private int S1177 = 1;
  private int S1064 = 1;
  private int S1071 = 1;
  private int S1087 = 1;
  private int S1111 = 1;
  private int S1143 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread7087(int [] tdone, int [] ends){
        switch(S1177){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S1064){
          case 0 : 
            switch(S1071){
              case 0 : 
                if(noz1.getprestatus()){//sysj\controller.sysj line: 176, column: 13
                  S1071=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 177, column: 8
                  currsigs.addElement(turnNozTrigger);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz1.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 179, column: 13
                  S1064=1;
                  if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 181, column: 8
                    S1087=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 184, column: 8
                    currsigs.addElement(turnNozTrigger);
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S1064=2;
                    if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 188, column: 8
                      S1111=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 191, column: 8
                      currsigs.addElement(turnNozTrigger);
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      S1064=3;
                      if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 195, column: 8
                        S1143=0;
                        turnNozTrigger.setPresent();//sysj\controller.sysj line: 198, column: 8
                        currsigs.addElement(turnNozTrigger);
                        active[21]=1;
                        ends[21]=1;
                        tdone[21]=1;
                      }
                      else {
                        finishfillorder_13.setPresent();//sysj\controller.sysj line: 202, column: 5
                        currsigs.addElement(finishfillorder_13);
                        S1177=0;
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
            switch(S1087){
              case 0 : 
                if(noz2.getprestatus()){//sysj\controller.sysj line: 183, column: 13
                  S1087=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 184, column: 8
                  currsigs.addElement(turnNozTrigger);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz2.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 186, column: 13
                  S1064=2;
                  if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 188, column: 8
                    S1111=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 191, column: 8
                    currsigs.addElement(turnNozTrigger);
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S1064=3;
                    if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 195, column: 8
                      S1143=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 198, column: 8
                      currsigs.addElement(turnNozTrigger);
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      finishfillorder_13.setPresent();//sysj\controller.sysj line: 202, column: 5
                      currsigs.addElement(finishfillorder_13);
                      S1177=0;
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
            switch(S1111){
              case 0 : 
                if(noz3.getprestatus()){//sysj\controller.sysj line: 190, column: 13
                  S1111=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 191, column: 8
                  currsigs.addElement(turnNozTrigger);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz3.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 193, column: 13
                  S1064=3;
                  if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 195, column: 8
                    S1143=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 198, column: 8
                    currsigs.addElement(turnNozTrigger);
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    finishfillorder_13.setPresent();//sysj\controller.sysj line: 202, column: 5
                    currsigs.addElement(finishfillorder_13);
                    S1177=0;
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
            switch(S1143){
              case 0 : 
                if(noz4.getprestatus()){//sysj\controller.sysj line: 197, column: 13
                  S1143=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 198, column: 8
                  currsigs.addElement(turnNozTrigger);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz4.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 200, column: 13
                  finishfillorder_13.setPresent();//sysj\controller.sysj line: 202, column: 5
                  currsigs.addElement(finishfillorder_13);
                  S1177=0;
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

  public void thread7086(int [] tdone, int [] ends){
        switch(S1063){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus() && finishfillorder_13.getprestatus()){//sysj\controller.sysj line: 166, column: 11
          S1063=0;
          active[20]=0;
          ends[20]=0;
          tdone[20]=1;
        }
        else {
          nozBusy.setPresent();//sysj\controller.sysj line: 167, column: 6
          currsigs.addElement(nozBusy);
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        break;
      
    }
  }

  public void thread7084(int [] tdone, int [] ends){
        S1177=1;
    liquidval_thread_21 = (int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue());//sysj\controller.sysj line: 172, column: 5
    System.out.println(liquidval_thread_21);//sysj\controller.sysj line: 173, column: 5
    S1064=0;
    if((liquidval_thread_21 & (1 << 0)) != 0){//sysj\controller.sysj line: 174, column: 8
      S1071=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 177, column: 8
      currsigs.addElement(turnNozTrigger);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S1064=1;
      if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 181, column: 8
        S1087=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 184, column: 8
        currsigs.addElement(turnNozTrigger);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S1064=2;
        if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 188, column: 8
          S1111=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 191, column: 8
          currsigs.addElement(turnNozTrigger);
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S1064=3;
          if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 195, column: 8
            S1143=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 198, column: 8
            currsigs.addElement(turnNozTrigger);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            finishfillorder_13.setPresent();//sysj\controller.sysj line: 202, column: 5
            currsigs.addElement(finishfillorder_13);
            S1177=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread7083(int [] tdone, int [] ends){
        S1063=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 167, column: 6
    currsigs.addElement(nozBusy);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread7081(int [] tdone, int [] ends){
        S1177=1;
    liquidval_thread_21 = (int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue());//sysj\controller.sysj line: 172, column: 5
    System.out.println(liquidval_thread_21);//sysj\controller.sysj line: 173, column: 5
    S1064=0;
    if((liquidval_thread_21 & (1 << 0)) != 0){//sysj\controller.sysj line: 174, column: 8
      S1071=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 177, column: 8
      currsigs.addElement(turnNozTrigger);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S1064=1;
      if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 181, column: 8
        S1087=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 184, column: 8
        currsigs.addElement(turnNozTrigger);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S1064=2;
        if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 188, column: 8
          S1111=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 191, column: 8
          currsigs.addElement(turnNozTrigger);
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S1064=3;
          if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 195, column: 8
            S1143=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 198, column: 8
            currsigs.addElement(turnNozTrigger);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            finishfillorder_13.setPresent();//sysj\controller.sysj line: 202, column: 5
            currsigs.addElement(finishfillorder_13);
            S1177=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread7080(int [] tdone, int [] ends){
        S1063=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 167, column: 6
    currsigs.addElement(nozBusy);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread7078(int [] tdone, int [] ends){
        S1177=1;
    liquidval_thread_21 = (int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue());//sysj\controller.sysj line: 172, column: 5
    System.out.println(liquidval_thread_21);//sysj\controller.sysj line: 173, column: 5
    S1064=0;
    if((liquidval_thread_21 & (1 << 0)) != 0){//sysj\controller.sysj line: 174, column: 8
      S1071=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 177, column: 8
      currsigs.addElement(turnNozTrigger);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S1064=1;
      if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 181, column: 8
        S1087=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 184, column: 8
        currsigs.addElement(turnNozTrigger);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S1064=2;
        if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 188, column: 8
          S1111=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 191, column: 8
          currsigs.addElement(turnNozTrigger);
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S1064=3;
          if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 195, column: 8
            S1143=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 198, column: 8
            currsigs.addElement(turnNozTrigger);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            finishfillorder_13.setPresent();//sysj\controller.sysj line: 202, column: 5
            currsigs.addElement(finishfillorder_13);
            S1177=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread7077(int [] tdone, int [] ends){
        S1063=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 167, column: 6
    currsigs.addElement(nozBusy);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread7075(int [] tdone, int [] ends){
        S1177=1;
    liquidval_thread_21 = (int)(liquidBuffer_in.getVal() == null ? 0 : ((Integer)liquidBuffer_in.getVal()).intValue());//sysj\controller.sysj line: 172, column: 5
    System.out.println(liquidval_thread_21);//sysj\controller.sysj line: 173, column: 5
    S1064=0;
    if((liquidval_thread_21 & (1 << 0)) != 0){//sysj\controller.sysj line: 174, column: 8
      S1071=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 177, column: 8
      currsigs.addElement(turnNozTrigger);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S1064=1;
      if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 181, column: 8
        S1087=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 184, column: 8
        currsigs.addElement(turnNozTrigger);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S1064=2;
        if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 188, column: 8
          S1111=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 191, column: 8
          currsigs.addElement(turnNozTrigger);
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S1064=3;
          if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 195, column: 8
            S1143=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 198, column: 8
            currsigs.addElement(turnNozTrigger);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            finishfillorder_13.setPresent();//sysj\controller.sysj line: 202, column: 5
            currsigs.addElement(finishfillorder_13);
            S1177=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread7074(int [] tdone, int [] ends){
        S1063=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 167, column: 6
    currsigs.addElement(nozBusy);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread7073(int [] tdone, int [] ends){
        switch(S2605){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S1013){
          case 0 : 
            S1013=0;
            S1013=1;
            requestliquid.setPresent();//sysj\controller.sysj line: 159, column: 4
            currsigs.addElement(requestliquid);
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 1 : 
            if(sentliquid.getprestatus()){//sysj\controller.sysj line: 158, column: 10
              S1013=2;
              S1020=0;
              if(!liquidBuffer_in.isPartnerPresent() || liquidBuffer_in.isPartnerPreempted()){//sysj\controller.sysj line: 162, column: 4
                liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 162, column: 4
                S1020=1;
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S1015=0;
                if(!liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 162, column: 4
                  liquidBuffer_in.setACK(true);//sysj\controller.sysj line: 162, column: 4
                  S1015=1;
                  if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 162, column: 4
                    liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 162, column: 4
                    ends[19]=2;
                    ;//sysj\controller.sysj line: 162, column: 4
                    System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 163, column: 4
                    S1013=3;
                    thread7074(tdone,ends);
                    thread7075(tdone,ends);
                    int biggest7076 = 0;
                    if(ends[20]>=biggest7076){
                      biggest7076=ends[20];
                    }
                    if(ends[21]>=biggest7076){
                      biggest7076=ends[21];
                    }
                    if(biggest7076 == 1){
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
              requestliquid.setPresent();//sysj\controller.sysj line: 159, column: 4
              currsigs.addElement(requestliquid);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 2 : 
            switch(S1020){
              case 0 : 
                if(!liquidBuffer_in.isPartnerPresent() || liquidBuffer_in.isPartnerPreempted()){//sysj\controller.sysj line: 162, column: 4
                  liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 162, column: 4
                  S1020=1;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  switch(S1015){
                    case 0 : 
                      if(!liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 162, column: 4
                        liquidBuffer_in.setACK(true);//sysj\controller.sysj line: 162, column: 4
                        S1015=1;
                        if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 162, column: 4
                          liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 162, column: 4
                          ends[19]=2;
                          ;//sysj\controller.sysj line: 162, column: 4
                          System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 163, column: 4
                          S1013=3;
                          thread7077(tdone,ends);
                          thread7078(tdone,ends);
                          int biggest7079 = 0;
                          if(ends[20]>=biggest7079){
                            biggest7079=ends[20];
                          }
                          if(ends[21]>=biggest7079){
                            biggest7079=ends[21];
                          }
                          if(biggest7079 == 1){
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
                      if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 162, column: 4
                        liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 162, column: 4
                        ends[19]=2;
                        ;//sysj\controller.sysj line: 162, column: 4
                        System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 163, column: 4
                        S1013=3;
                        thread7080(tdone,ends);
                        thread7081(tdone,ends);
                        int biggest7082 = 0;
                        if(ends[20]>=biggest7082){
                          biggest7082=ends[20];
                        }
                        if(ends[21]>=biggest7082){
                          biggest7082=ends[21];
                        }
                        if(biggest7082 == 1){
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
                S1020=1;
                S1020=0;
                if(!liquidBuffer_in.isPartnerPresent() || liquidBuffer_in.isPartnerPreempted()){//sysj\controller.sysj line: 162, column: 4
                  liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 162, column: 4
                  S1020=1;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S1015=0;
                  if(!liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 162, column: 4
                    liquidBuffer_in.setACK(true);//sysj\controller.sysj line: 162, column: 4
                    S1015=1;
                    if(liquidBuffer_in.isREQ()){//sysj\controller.sysj line: 162, column: 4
                      liquidBuffer_in.setACK(false);//sysj\controller.sysj line: 162, column: 4
                      ends[19]=2;
                      ;//sysj\controller.sysj line: 162, column: 4
                      System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 163, column: 4
                      S1013=3;
                      thread7083(tdone,ends);
                      thread7084(tdone,ends);
                      int biggest7085 = 0;
                      if(ends[20]>=biggest7085){
                        biggest7085=ends[20];
                      }
                      if(ends[21]>=biggest7085){
                        biggest7085=ends[21];
                      }
                      if(biggest7085 == 1){
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
            thread7086(tdone,ends);
            thread7087(tdone,ends);
            int biggest7088 = 0;
            if(ends[20]>=biggest7088){
              biggest7088=ends[20];
            }
            if(ends[21]>=biggest7088){
              biggest7088=ends[21];
            }
            if(biggest7088 == 1){
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            //FINXME code
            if(biggest7088 == 0){
              S1013=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread7071(int [] tdone, int [] ends){
        switch(S661){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 147, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread7070(int [] tdone, int [] ends){
        switch(S656){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 144, column: 5
        currsigs.addElement(valveInletOnOff);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread7068(int [] tdone, int [] ends){
        S661=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 147, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread7067(int [] tdone, int [] ends){
        S656=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 144, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread7065(int [] tdone, int [] ends){
        switch(S638){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 137, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread7064(int [] tdone, int [] ends){
        switch(S632){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 133, column: 5
        currsigs.addElement(valveInjectorOnOff);
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread7062(int [] tdone, int [] ends){
        S661=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 147, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread7061(int [] tdone, int [] ends){
        S656=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 144, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread7059(int [] tdone, int [] ends){
        S638=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 136, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 137, column: 6
      currsigs.addElement(dosUnitValveRetract);
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      S638=0;
      active[16]=0;
      ends[16]=0;
      tdone[16]=1;
    }
  }

  public void thread7058(int [] tdone, int [] ends){
        S632=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 133, column: 5
    currsigs.addElement(valveInjectorOnOff);
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread7057(int [] tdone, int [] ends){
        switch(S1004){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S627){
          case 0 : 
            S627=0;
            S627=1;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 1 : 
            if(bottleAtPos2.getprestatus() && !turnNozTrigger.getprestatus()){//sysj\controller.sysj line: 131, column: 9
              S627=2;
              thread7058(tdone,ends);
              thread7059(tdone,ends);
              int biggest7060 = 0;
              if(ends[15]>=biggest7060){
                biggest7060=ends[15];
              }
              if(ends[16]>=biggest7060){
                biggest7060=ends[16];
              }
              if(biggest7060 == 1){
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
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 132, column: 9
              S627=3;
              thread7061(tdone,ends);
              thread7062(tdone,ends);
              int biggest7063 = 0;
              if(ends[17]>=biggest7063){
                biggest7063=ends[17];
              }
              if(ends[18]>=biggest7063){
                biggest7063=ends[18];
              }
              if(biggest7063 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              thread7064(tdone,ends);
              thread7065(tdone,ends);
              int biggest7066 = 0;
              if(ends[15]>=biggest7066){
                biggest7066=ends[15];
              }
              if(ends[16]>=biggest7066){
                biggest7066=ends[16];
              }
              if(biggest7066 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest7066 == 0){
                S627=3;
                thread7067(tdone,ends);
                thread7068(tdone,ends);
                int biggest7069 = 0;
                if(ends[17]>=biggest7069){
                  biggest7069=ends[17];
                }
                if(ends[18]>=biggest7069){
                  biggest7069=ends[18];
                }
                if(biggest7069 == 1){
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
            }
            break;
          
          case 3 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 143, column: 9
              S627=4;
              if(dosUnitEvac.getprestatus() && finishfillorder_13.getprestatus()){//sysj\controller.sysj line: 150, column: 11
                doneAtPos2.setPresent();//sysj\controller.sysj line: 151, column: 3
                currsigs.addElement(doneAtPos2);
                S627=0;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              else {
                S627=0;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              thread7070(tdone,ends);
              thread7071(tdone,ends);
              int biggest7072 = 0;
              if(ends[17]>=biggest7072){
                biggest7072=ends[17];
              }
              if(ends[18]>=biggest7072){
                biggest7072=ends[18];
              }
              if(biggest7072 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest7072 == 0){
                S627=4;
                if(dosUnitEvac.getprestatus() && finishfillorder_13.getprestatus()){//sysj\controller.sysj line: 150, column: 11
                  doneAtPos2.setPresent();//sysj\controller.sysj line: 151, column: 3
                  currsigs.addElement(doneAtPos2);
                  S627=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
                else {
                  S627=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
            }
            break;
          
          case 4 : 
            S627=0;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
        }
        break;
      
    }
  }

  public void thread7055(int [] tdone, int [] ends){
        S2605=1;
    S1013=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread7054(int [] tdone, int [] ends){
        S1004=1;
    S627=0;
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
      switch(S2607){
        case 0 : 
          S2607=0;
          break RUN;
        
        case 1 : 
          S2607=2;
          S2607=2;
          finishfillorder_13.setClear();//sysj\controller.sysj line: 127, column: 2
          thread7054(tdone,ends);
          thread7055(tdone,ends);
          int biggest7056 = 0;
          if(ends[14]>=biggest7056){
            biggest7056=ends[14];
          }
          if(ends[19]>=biggest7056){
            biggest7056=ends[19];
          }
          if(biggest7056 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          finishfillorder_13.setClear();//sysj\controller.sysj line: 127, column: 2
          thread7057(tdone,ends);
          thread7073(tdone,ends);
          int biggest7089 = 0;
          if(ends[14]>=biggest7089){
            biggest7089=ends[14];
          }
          if(ends[19]>=biggest7089){
            biggest7089=ends[19];
          }
          if(biggest7089 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest7089 == 0){
            S2607=0;
            active[13]=0;
            ends[13]=0;
            S2607=0;
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
    finishfillorder_13 = new Signal();
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
      finishfillorder_13.setpreclear();
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
      finishfillorder_13.setClear();
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
