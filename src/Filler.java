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
  private int S1368 = 1;
  private int S853 = 1;
  private int S614 = 1;
  private int S619 = 1;
  private int S625 = 1;
  private int S643 = 1;
  private int S648 = 1;
  private int S1366 = 1;
  private int S856 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread1422(int [] tdone, int [] ends){
        switch(S1366){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S856){
          case 0 : 
            S856=0;
            S856=1;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 1 : 
            if(i_selNoz1.getprestatus() || i_selNoz2.getprestatus() || i_selNoz3.getprestatus() || i_selNoz4.getprestatus()){//sysj\controller.sysj line: 149, column: 9
              S856=2;
              if(i_selNoz1.getprestatus()){//sysj\controller.sysj line: 150, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 152, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S856=3;
                if(i_selNoz2.getprestatus()){//sysj\controller.sysj line: 155, column: 11
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 157, column: 5
                  currsigs.addElement(turnNozTrigger);
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S856=4;
                  if(i_selNoz3.getprestatus()){//sysj\controller.sysj line: 160, column: 11
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 162, column: 5
                    currsigs.addElement(turnNozTrigger);
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                  else {
                    S856=5;
                    if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 165, column: 11
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 167, column: 5
                      currsigs.addElement(turnNozTrigger);
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    else {
                      S856=0;
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                  }
                }
              }
            }
            else {
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 2 : 
            if(noz1.getprestatus()){//sysj\controller.sysj line: 151, column: 10
              S856=3;
              if(i_selNoz2.getprestatus()){//sysj\controller.sysj line: 155, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 157, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S856=4;
                if(i_selNoz3.getprestatus()){//sysj\controller.sysj line: 160, column: 11
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 162, column: 5
                  currsigs.addElement(turnNozTrigger);
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S856=5;
                  if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 165, column: 11
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 167, column: 5
                    currsigs.addElement(turnNozTrigger);
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                  else {
                    S856=0;
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                }
              }
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 152, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 3 : 
            if(noz2.getprestatus()){//sysj\controller.sysj line: 156, column: 10
              S856=4;
              if(i_selNoz3.getprestatus()){//sysj\controller.sysj line: 160, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 162, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S856=5;
                if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 165, column: 11
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 167, column: 5
                  currsigs.addElement(turnNozTrigger);
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S856=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
              }
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 157, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 4 : 
            if(noz3.getprestatus()){//sysj\controller.sysj line: 161, column: 10
              S856=5;
              if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 165, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 167, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S856=0;
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 162, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 5 : 
            if(noz4.getprestatus()){//sysj\controller.sysj line: 166, column: 10
              S856=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 167, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1420(int [] tdone, int [] ends){
        switch(S648){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 141, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread1419(int [] tdone, int [] ends){
        switch(S643){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 138, column: 5
        currsigs.addElement(valveInletOnOff);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread1417(int [] tdone, int [] ends){
        S648=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 141, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1416(int [] tdone, int [] ends){
        S643=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 138, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread1414(int [] tdone, int [] ends){
        switch(S625){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 131, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread1413(int [] tdone, int [] ends){
        switch(S619){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 127, column: 5
        currsigs.addElement(valveInjectorOnOff);
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread1411(int [] tdone, int [] ends){
        S648=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 141, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1410(int [] tdone, int [] ends){
        S643=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 138, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread1408(int [] tdone, int [] ends){
        S625=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 130, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 131, column: 6
      currsigs.addElement(dosUnitValveRetract);
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      S625=0;
      active[16]=0;
      ends[16]=0;
      tdone[16]=1;
    }
  }

  public void thread1407(int [] tdone, int [] ends){
        S619=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 127, column: 5
    currsigs.addElement(valveInjectorOnOff);
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread1406(int [] tdone, int [] ends){
        switch(S853){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S614){
          case 0 : 
            S614=0;
            S614=1;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 1 : 
            if(bottleAtPos2.getprestatus() && !turnNozTrigger.getprestatus()){//sysj\controller.sysj line: 125, column: 9
              S614=2;
              thread1407(tdone,ends);
              thread1408(tdone,ends);
              int biggest1409 = 0;
              if(ends[15]>=biggest1409){
                biggest1409=ends[15];
              }
              if(ends[16]>=biggest1409){
                biggest1409=ends[16];
              }
              if(biggest1409 == 1){
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
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 126, column: 9
              S614=3;
              thread1410(tdone,ends);
              thread1411(tdone,ends);
              int biggest1412 = 0;
              if(ends[17]>=biggest1412){
                biggest1412=ends[17];
              }
              if(ends[18]>=biggest1412){
                biggest1412=ends[18];
              }
              if(biggest1412 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              thread1413(tdone,ends);
              thread1414(tdone,ends);
              int biggest1415 = 0;
              if(ends[15]>=biggest1415){
                biggest1415=ends[15];
              }
              if(ends[16]>=biggest1415){
                biggest1415=ends[16];
              }
              if(biggest1415 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest1415 == 0){
                S614=3;
                thread1416(tdone,ends);
                thread1417(tdone,ends);
                int biggest1418 = 0;
                if(ends[17]>=biggest1418){
                  biggest1418=ends[17];
                }
                if(ends[18]>=biggest1418){
                  biggest1418=ends[18];
                }
                if(biggest1418 == 1){
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
            }
            break;
          
          case 3 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 137, column: 9
              doneAtPos2.setPresent();//sysj\controller.sysj line: 144, column: 3
              currsigs.addElement(doneAtPos2);
              S614=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              thread1419(tdone,ends);
              thread1420(tdone,ends);
              int biggest1421 = 0;
              if(ends[17]>=biggest1421){
                biggest1421=ends[17];
              }
              if(ends[18]>=biggest1421){
                biggest1421=ends[18];
              }
              if(biggest1421 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest1421 == 0){
                doneAtPos2.setPresent();//sysj\controller.sysj line: 144, column: 3
                currsigs.addElement(doneAtPos2);
                S614=0;
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

  public void thread1404(int [] tdone, int [] ends){
        S1366=1;
    S856=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread1403(int [] tdone, int [] ends){
        S853=1;
    S614=0;
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
      switch(S1368){
        case 0 : 
          S1368=0;
          break RUN;
        
        case 1 : 
          S1368=2;
          S1368=2;
          thread1403(tdone,ends);
          thread1404(tdone,ends);
          int biggest1405 = 0;
          if(ends[14]>=biggest1405){
            biggest1405=ends[14];
          }
          if(ends[19]>=biggest1405){
            biggest1405=ends[19];
          }
          if(biggest1405 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          thread1406(tdone,ends);
          thread1422(tdone,ends);
          int biggest1423 = 0;
          if(ends[14]>=biggest1423){
            biggest1423=ends[14];
          }
          if(ends[19]>=biggest1423){
            biggest1423=ends[19];
          }
          if(biggest1423 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1423 == 0){
            S1368=0;
            active[13]=0;
            ends[13]=0;
            S1368=0;
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
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
        noz1.gethook();
        noz2.gethook();
        noz3.gethook();
        noz4.gethook();
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
