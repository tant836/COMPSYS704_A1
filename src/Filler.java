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
  private Integer liquidval_thread_16;//sysj\controller.sysj line: 149, column: 4
  private int S1616 = 1;
  private int S1372 = 1;
  private int S632 = 1;
  private int S624 = 1;
  private int S638 = 1;
  private int S752 = 1;
  private int S655 = 1;
  private int S645 = 1;
  private int S662 = 1;
  private int S686 = 1;
  private int S718 = 1;
  private int S1614 = 1;
  private int S1375 = 1;
  private int S1380 = 1;
  private int S1386 = 1;
  private int S1404 = 1;
  private int S1409 = 1;
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void thread1675(int [] tdone, int [] ends){
        switch(S1409){
      case 0 : 
        active[21]=0;
        ends[21]=0;
        tdone[21]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 201, column: 6
        currsigs.addElement(dosUnitValveExtend);
        active[21]=1;
        ends[21]=1;
        tdone[21]=1;
        break;
      
    }
  }

  public void thread1674(int [] tdone, int [] ends){
        switch(S1404){
      case 0 : 
        active[20]=0;
        ends[20]=0;
        tdone[20]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 198, column: 6
        currsigs.addElement(valveInletOnOff);
        active[20]=1;
        ends[20]=1;
        tdone[20]=1;
        break;
      
    }
  }

  public void thread1672(int [] tdone, int [] ends){
        S1409=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 201, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread1671(int [] tdone, int [] ends){
        S1404=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 198, column: 6
    currsigs.addElement(valveInletOnOff);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread1669(int [] tdone, int [] ends){
        switch(S1386){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 191, column: 7
        currsigs.addElement(dosUnitValveRetract);
        active[19]=1;
        ends[19]=1;
        tdone[19]=1;
        break;
      
    }
  }

  public void thread1668(int [] tdone, int [] ends){
        switch(S1380){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 187, column: 6
        currsigs.addElement(valveInjectorOnOff);
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread1666(int [] tdone, int [] ends){
        S1409=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 201, column: 6
    currsigs.addElement(dosUnitValveExtend);
    active[21]=1;
    ends[21]=1;
    tdone[21]=1;
  }

  public void thread1665(int [] tdone, int [] ends){
        S1404=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 198, column: 6
    currsigs.addElement(valveInletOnOff);
    active[20]=1;
    ends[20]=1;
    tdone[20]=1;
  }

  public void thread1663(int [] tdone, int [] ends){
        S1386=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 190, column: 14
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 191, column: 7
      currsigs.addElement(dosUnitValveRetract);
      active[19]=1;
      ends[19]=1;
      tdone[19]=1;
    }
    else {
      S1386=0;
      active[19]=0;
      ends[19]=0;
      tdone[19]=1;
    }
  }

  public void thread1662(int [] tdone, int [] ends){
        S1380=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 187, column: 6
    currsigs.addElement(valveInjectorOnOff);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1661(int [] tdone, int [] ends){
        switch(S1614){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        switch(S1375){
          case 0 : 
            S1375=0;
            S1375=1;
            active[17]=1;
            ends[17]=1;
            tdone[17]=1;
            break;
          
          case 1 : 
            if(bottleAtPos2.getprestatus() && !turnNozTrigger.getprestatus()){//sysj\controller.sysj line: 185, column: 10
              S1375=2;
              thread1662(tdone,ends);
              thread1663(tdone,ends);
              int biggest1664 = 0;
              if(ends[18]>=biggest1664){
                biggest1664=ends[18];
              }
              if(ends[19]>=biggest1664){
                biggest1664=ends[19];
              }
              if(biggest1664 == 1){
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
            }
            else {
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            break;
          
          case 2 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 186, column: 10
              S1375=3;
              thread1665(tdone,ends);
              thread1666(tdone,ends);
              int biggest1667 = 0;
              if(ends[20]>=biggest1667){
                biggest1667=ends[20];
              }
              if(ends[21]>=biggest1667){
                biggest1667=ends[21];
              }
              if(biggest1667 == 1){
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
            }
            else {
              thread1668(tdone,ends);
              thread1669(tdone,ends);
              int biggest1670 = 0;
              if(ends[18]>=biggest1670){
                biggest1670=ends[18];
              }
              if(ends[19]>=biggest1670){
                biggest1670=ends[19];
              }
              if(biggest1670 == 1){
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
              //FINXME code
              if(biggest1670 == 0){
                S1375=3;
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
                  active[17]=1;
                  ends[17]=1;
                  tdone[17]=1;
                }
              }
            }
            break;
          
          case 3 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 197, column: 10
              doneAtPos2.setPresent();//sysj\controller.sysj line: 204, column: 4
              currsigs.addElement(doneAtPos2);
              S1375=0;
              active[17]=1;
              ends[17]=1;
              tdone[17]=1;
            }
            else {
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
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
              //FINXME code
              if(biggest1676 == 0){
                doneAtPos2.setPresent();//sysj\controller.sysj line: 204, column: 4
                currsigs.addElement(doneAtPos2);
                S1375=0;
                active[17]=1;
                ends[17]=1;
                tdone[17]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1659(int [] tdone, int [] ends){
        switch(S752){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        switch(S655){
          case 0 : 
            switch(S645){
              case 0 : 
                if(noz1.getprestatus()){//sysj\controller.sysj line: 152, column: 12
                  S645=1;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 153, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(noz1.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 155, column: 12
                  S655=1;
                  if((liquidval_thread_16 & (1 << 1)) != 0){//sysj\controller.sysj line: 157, column: 7
                    S662=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 160, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[16]=1;
                    ends[16]=1;
                    tdone[16]=1;
                  }
                  else {
                    S655=2;
                    if((liquidval_thread_16 & (1 << 2)) != 0){//sysj\controller.sysj line: 164, column: 7
                      S686=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 167, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[16]=1;
                      ends[16]=1;
                      tdone[16]=1;
                    }
                    else {
                      S655=3;
                      if((liquidval_thread_16 & (1 << 3)) != 0){//sysj\controller.sysj line: 171, column: 7
                        S718=0;
                        turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 7
                        currsigs.addElement(turnNozTrigger);
                        active[16]=1;
                        ends[16]=1;
                        tdone[16]=1;
                      }
                      else {
                        S752=0;
                        active[16]=0;
                        ends[16]=0;
                        tdone[16]=1;
                      }
                    }
                  }
                }
                else {
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            switch(S662){
              case 0 : 
                if(noz2.getprestatus()){//sysj\controller.sysj line: 159, column: 12
                  S662=1;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 160, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(noz2.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 162, column: 12
                  S655=2;
                  if((liquidval_thread_16 & (1 << 2)) != 0){//sysj\controller.sysj line: 164, column: 7
                    S686=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 167, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[16]=1;
                    ends[16]=1;
                    tdone[16]=1;
                  }
                  else {
                    S655=3;
                    if((liquidval_thread_16 & (1 << 3)) != 0){//sysj\controller.sysj line: 171, column: 7
                      S718=0;
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 7
                      currsigs.addElement(turnNozTrigger);
                      active[16]=1;
                      ends[16]=1;
                      tdone[16]=1;
                    }
                    else {
                      S752=0;
                      active[16]=0;
                      ends[16]=0;
                      tdone[16]=1;
                    }
                  }
                }
                else {
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
            }
            break;
          
          case 2 : 
            switch(S686){
              case 0 : 
                if(noz3.getprestatus()){//sysj\controller.sysj line: 166, column: 12
                  S686=1;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 167, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(noz3.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 169, column: 12
                  S655=3;
                  if((liquidval_thread_16 & (1 << 3)) != 0){//sysj\controller.sysj line: 171, column: 7
                    S718=0;
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 7
                    currsigs.addElement(turnNozTrigger);
                    active[16]=1;
                    ends[16]=1;
                    tdone[16]=1;
                  }
                  else {
                    S752=0;
                    active[16]=0;
                    ends[16]=0;
                    tdone[16]=1;
                  }
                }
                else {
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
            }
            break;
          
          case 3 : 
            switch(S718){
              case 0 : 
                if(noz4.getprestatus()){//sysj\controller.sysj line: 173, column: 12
                  S718=1;
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                else {
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 7
                  currsigs.addElement(turnNozTrigger);
                  active[16]=1;
                  ends[16]=1;
                  tdone[16]=1;
                }
                break;
              
              case 1 : 
                if(noz4.getprestatus() && dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 176, column: 12
                  S752=0;
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
            break;
          
        }
        break;
      
    }
  }

  public void thread1658(int [] tdone, int [] ends){
        switch(S638){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 143, column: 10
          S638=0;
          active[15]=0;
          ends[15]=0;
          tdone[15]=1;
        }
        else {
          nozBusy.setPresent();//sysj\controller.sysj line: 144, column: 5
          currsigs.addElement(nozBusy);
          active[15]=1;
          ends[15]=1;
          tdone[15]=1;
        }
        break;
      
    }
  }

  public void thread1656(int [] tdone, int [] ends){
        S752=1;
    liquidval_thread_16 = (int)(sentliquid.getpreval() == null ? null : ((Integer)sentliquid.getpreval()));//sysj\controller.sysj line: 149, column: 4
    S655=0;
    if((liquidval_thread_16 & (1 << 0)) != 0){//sysj\controller.sysj line: 150, column: 7
      S645=0;
      turnNozTrigger.setPresent();//sysj\controller.sysj line: 153, column: 7
      currsigs.addElement(turnNozTrigger);
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      S655=1;
      if((liquidval_thread_16 & (1 << 1)) != 0){//sysj\controller.sysj line: 157, column: 7
        S662=0;
        turnNozTrigger.setPresent();//sysj\controller.sysj line: 160, column: 7
        currsigs.addElement(turnNozTrigger);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
      }
      else {
        S655=2;
        if((liquidval_thread_16 & (1 << 2)) != 0){//sysj\controller.sysj line: 164, column: 7
          S686=0;
          turnNozTrigger.setPresent();//sysj\controller.sysj line: 167, column: 7
          currsigs.addElement(turnNozTrigger);
          active[16]=1;
          ends[16]=1;
          tdone[16]=1;
        }
        else {
          S655=3;
          if((liquidval_thread_16 & (1 << 3)) != 0){//sysj\controller.sysj line: 171, column: 7
            S718=0;
            turnNozTrigger.setPresent();//sysj\controller.sysj line: 174, column: 7
            currsigs.addElement(turnNozTrigger);
            active[16]=1;
            ends[16]=1;
            tdone[16]=1;
          }
          else {
            S752=0;
            active[16]=0;
            ends[16]=0;
            tdone[16]=1;
          }
        }
      }
    }
  }

  public void thread1655(int [] tdone, int [] ends){
        S638=1;
    nozBusy.setPresent();//sysj\controller.sysj line: 144, column: 5
    currsigs.addElement(nozBusy);
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread1654(int [] tdone, int [] ends){
        switch(S1372){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S632){
          case 0 : 
            S632=0;
            S632=1;
            requestliquid.setPresent();//sysj\controller.sysj line: 133, column: 5
            currsigs.addElement(requestliquid);
            S624=0;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 1 : 
            if(sentliquid.getprestatus()){//sysj\controller.sysj line: 131, column: 10
              System.out.println("receive liquidBuffer");//sysj\controller.sysj line: 140, column: 3
              S632=2;
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
              switch(S624){
                case 0 : 
                  S624=0;
                  S624=1;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                  break;
                
                case 1 : 
                  S624=1;
                  requestliquid.setPresent();//sysj\controller.sysj line: 133, column: 5
                  currsigs.addElement(requestliquid);
                  S624=0;
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                  break;
                
              }
            }
            break;
          
          case 2 : 
            thread1658(tdone,ends);
            thread1659(tdone,ends);
            int biggest1660 = 0;
            if(ends[15]>=biggest1660){
              biggest1660=ends[15];
            }
            if(ends[16]>=biggest1660){
              biggest1660=ends[16];
            }
            if(biggest1660 == 1){
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            //FINXME code
            if(biggest1660 == 0){
              S632=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1652(int [] tdone, int [] ends){
        S1614=1;
    S1375=0;
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread1651(int [] tdone, int [] ends){
        S1372=1;
    S632=0;
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
          if(ends[17]>=biggest1653){
            biggest1653=ends[17];
          }
          if(biggest1653 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          thread1654(tdone,ends);
          thread1661(tdone,ends);
          int biggest1677 = 0;
          if(ends[14]>=biggest1677){
            biggest1677=ends[14];
          }
          if(ends[17]>=biggest1677){
            biggest1677=ends[17];
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
