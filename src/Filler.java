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
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  public Signal turnNozTrigger = new Signal("turnNozTrigger", Signal.OUTPUT);
  public Signal doneAtPos2 = new Signal("doneAtPos2", Signal.OUTPUT);
  public Signal nozBusy = new Signal("nozBusy", Signal.OUTPUT);
  public Signal requestliquid = new Signal("requestliquid", Signal.OUTPUT);
  private Integer liquidval_thread_21;//sysj\controller.sysj line: 175, column: 4
  private int S1616 = 1;
  private int S865 = 1;
  private int S626 = 1;
  private int S631 = 1;
  private int S637 = 1;
  private int S655 = 1;
  private int S660 = 1;
  private int S1614 = 1;
  private int S874 = 1;
  private int S866 = 1;
  private int S880 = 1;
  private int S994 = 1;
  private int S897 = 1;
  private int S887 = 1;
  private int S904 = 1;
  private int S928 = 1;
  private int S960 = 1;
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void thread1675(int [] tdone, int [] ends){
        switch(S994){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        switch(S897){
          case 0 : 
            switch(S887){
              case 0 : 
                if(noz1.getprestatus()){//sysj\controller.sysj line: 178, column: 12
                  S887=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 179, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz1.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 181, column: 12
                  S897=1;
                  if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 183, column: 7
                    S904=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 186, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S897=2;
                    if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 190, column: 7
                      S928=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 193, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      S897=3;
                      if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 197, column: 7
                        S960=0;
                        turnNozTrigger.setPresent();//sysj\controller.sysj line: 200, column: 7
                        currsigs.addElement(turnNozTrigger);
                        active[21]=1;
                        ends[21]=1;
                        tdone[21]=1;
                      }
                      else {
                        S994=0;
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
            switch(S904){
              case 0 : 
                if(noz2.getprestatus()){//sysj\controller.sysj line: 185, column: 12
                  S904=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 186, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz2.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 188, column: 12
                  S897=2;
                  if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 190, column: 7
                    S928=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 193, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S897=3;
                    if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 197, column: 7
                      S960=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 200, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[21]=1;
                      ends[21]=1;
                      tdone[21]=1;
                    }
                    else {
                      S994=0;
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
            switch(S928){
              case 0 : 
                if(noz3.getprestatus()){//sysj\controller.sysj line: 192, column: 12
                  S928=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 193, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz3.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 195, column: 12
                  S897=3;
                  if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 197, column: 7
                    S960=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 200, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[21]=1;
                    ends[21]=1;
                    tdone[21]=1;
                  }
                  else {
                    S994=0;
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
            switch(S960){
              case 0 : 
                if(noz4.getprestatus()){//sysj\controller.sysj line: 199, column: 12
                  S960=1;
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 200, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[21]=1;
                  ends[21]=1;
                  tdone[21]=1;
                }
                break;
              
              case 1 : 
                if(noz4.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 202, column: 12
                  S994=0;
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

  public void thread1674(int [] tdone, int [] ends){
        switch(S880){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 169, column: 10
          S880=0;
          active[20]=0;
          ends[20]=0;
          tdone[20]=1;
        }
        else {
          nozBusy.setPresent();//sysj\controller.sysj line: 170, column: 5
          currsigs.addElement(nozBusy);
          active[20]=1;
          ends[20]=1;
          tdone[20]=1;
        }
        break;
      
    }
  }

  public void thread1672(int [] tdone, int [] ends){
        S994=1;
    liquidval_thread_21 = (int)(sentliquid.getpreval() == null ? null : ((Integer)sentliquid.getpreval()));//sysj\controller.sysj line: 175, column: 4
    S897=0;
    if((liquidval_thread_21 & (1 << 0)) != 0){//sysj\controller.sysj line: 176, column: 7
      S887=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 179, column: 7
      currsigs.addElement(turnNozTrigger);
      active[21]=1;
      ends[21]=1;
      tdone[21]=1;
    }
    else {
      S897=1;
      if((liquidval_thread_21 & (1 << 1)) != 0){//sysj\controller.sysj line: 183, column: 7
        S904=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 186, column: 7
        currsigs.addElement(turnNozTrigger);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
      }
      else {
        S897=2;
        if((liquidval_thread_21 & (1 << 2)) != 0){//sysj\controller.sysj line: 190, column: 7
          S928=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 193, column: 7
          currsigs.addElement(turnNozTrigger);
          active[21]=1;
          ends[21]=1;
          tdone[21]=1;
        }
        else {
          S897=3;
          if((liquidval_thread_21 & (1 << 3)) != 0){//sysj\controller.sysj line: 197, column: 7
            S960=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 200, column: 7
            currsigs.addElement(turnNozTrigger);
            active[21]=1;
            ends[21]=1;
            tdone[21]=1;
          }
          else {
            S994=0;
            active[21]=0;
            ends[21]=0;
            tdone[21]=1;
          }
        }
      }
    }
  }

  public void thread1671(int [] tdone, int [] ends){
        S880=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 170, column: 5
    currsigs.addElement(nozBusy);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread1670(int [] tdone, int [] ends){
        switch(S1614){
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
            requestliquid.setPresent();//sysj\controller.sysj line: 159, column: 5
            currsigs.addElement(requestliquid);
            S866=0;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 1 : 
            if(sentliquid.getprestatus()){//sysj\controller.sysj line: 157, column: 10
              System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 166, column: 3
              S874=2;
              thread1671(tdone,ends);
              thread1672(tdone,ends);
              int biggest1673 = 0;
              if(ends[20]>=biggest1673){
                biggest1673=ends[20];
              }
              if(ends[21]>=biggest1673){
                biggest1673=ends[21];
              }
              if(biggest1673 == 1){
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
            }
            else {
              switch(S866){
                case 0 : 
                  S866=0;
                  S866=1;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                  break;
                
                case 1 : 
                  S866=1;
                  requestliquid.setPresent();//sysj\controller.sysj line: 159, column: 5
                  currsigs.addElement(requestliquid);
                  S866=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            thread1674(tdone,ends);
            thread1675(tdone,ends);
            int biggest1676 = 0;
            if(ends[20]>=biggest1676){
              biggest1676=ends[20];
            }
            if(ends[21]>=biggest1676){
              biggest1676=ends[21];
            }
            if(biggest1676 == 1){
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            //FINXME code
            if(biggest1676 == 0){
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

  public void thread1668(int [] tdone, int [] ends){
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

  public void thread1667(int [] tdone, int [] ends){
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

  public void thread1665(int [] tdone, int [] ends){
        S660=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 146, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1664(int [] tdone, int [] ends){
        S655=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 143, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread1662(int [] tdone, int [] ends){
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

  public void thread1661(int [] tdone, int [] ends){
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

  public void thread1659(int [] tdone, int [] ends){
        S660=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 146, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1658(int [] tdone, int [] ends){
        S655=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 143, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread1656(int [] tdone, int [] ends){
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

  public void thread1655(int [] tdone, int [] ends){
        S631=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 132, column: 5
    currsigs.addElement(valveInjectorOnOff);
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread1654(int [] tdone, int [] ends){
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
              thread1655(tdone,ends);
              thread1656(tdone,ends);
              int biggest1657 = 0;
              if(ends[15]>=biggest1657){
                biggest1657=ends[15];
              }
              if(ends[16]>=biggest1657){
                biggest1657=ends[16];
              }
              if(biggest1657 == 1){
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
              thread1658(tdone,ends);
              thread1659(tdone,ends);
              int biggest1660 = 0;
              if(ends[17]>=biggest1660){
                biggest1660=ends[17];
              }
              if(ends[18]>=biggest1660){
                biggest1660=ends[18];
              }
              if(biggest1660 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              thread1661(tdone,ends);
              thread1662(tdone,ends);
              int biggest1663 = 0;
              if(ends[15]>=biggest1663){
                biggest1663=ends[15];
              }
              if(ends[16]>=biggest1663){
                biggest1663=ends[16];
              }
              if(biggest1663 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest1663 == 0){
                S626=3;
                thread1664(tdone,ends);
                thread1665(tdone,ends);
                int biggest1666 = 0;
                if(ends[17]>=biggest1666){
                  biggest1666=ends[17];
                }
                if(ends[18]>=biggest1666){
                  biggest1666=ends[18];
                }
                if(biggest1666 == 1){
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
              thread1667(tdone,ends);
              thread1668(tdone,ends);
              int biggest1669 = 0;
              if(ends[17]>=biggest1669){
                biggest1669=ends[17];
              }
              if(ends[18]>=biggest1669){
                biggest1669=ends[18];
              }
              if(biggest1669 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest1669 == 0){
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

  public void thread1652(int [] tdone, int [] ends){
        S1614=1;
    S874=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread1651(int [] tdone, int [] ends){
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
      switch(S1616){
        case 0 : 
          S1616=0;
          break RUN;
        
        case 1 : 
          S1616=2;
          S1616=2;
          thread1651(tdone,ends);
          thread1652(tdone,ends);
          int biggest1653 = 0;
          if(ends[14]>=biggest1653){
            biggest1653=ends[14];
          }
          if(ends[19]>=biggest1653){
            biggest1653=ends[19];
          }
          if(biggest1653 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          thread1654(tdone,ends);
          thread1670(tdone,ends);
          int biggest1677 = 0;
          if(ends[14]>=biggest1677){
            biggest1677=ends[14];
          }
          if(ends[19]>=biggest1677){
            biggest1677=ends[19];
          }
          if(biggest1677 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1677 == 0){
            S1616=0;
            active[13]=0;
            ends[13]=0;
            S1616=0;
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
      }
      runFinisher();
      if(active[13] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
