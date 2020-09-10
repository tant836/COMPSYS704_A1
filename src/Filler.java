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
  private int S1380 = 1;
  private int S865 = 1;
  private int S626 = 1;
  private int S631 = 1;
  private int S637 = 1;
  private int S655 = 1;
  private int S660 = 1;
  private int S1378 = 1;
  private int S868 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread1434(int [] tdone, int [] ends){
        switch(S1378){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S868){
          case 0 : 
            S868=0;
            S868=1;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 1 : 
            if(i_selNoz1.getprestatus() || i_selNoz2.getprestatus() || i_selNoz3.getprestatus() || i_selNoz4.getprestatus()){//sysj\controller.sysj line: 151, column: 9
              S868=2;
              if(i_selNoz1.getprestatus()){//sysj\controller.sysj line: 152, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 154, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S868=3;
                if(i_selNoz2.getprestatus()){//sysj\controller.sysj line: 157, column: 11
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 159, column: 5
                  currsigs.addElement(turnNozTrigger);
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S868=4;
                  if(i_selNoz3.getprestatus()){//sysj\controller.sysj line: 162, column: 11
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 164, column: 5
                    currsigs.addElement(turnNozTrigger);
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                  else {
                    S868=5;
                    if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 167, column: 11
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 169, column: 5
                      currsigs.addElement(turnNozTrigger);
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    else {
                      S868=0;
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
            if(noz1.getprestatus()){//sysj\controller.sysj line: 153, column: 10
              S868=3;
              if(i_selNoz2.getprestatus()){//sysj\controller.sysj line: 157, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 159, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S868=4;
                if(i_selNoz3.getprestatus()){//sysj\controller.sysj line: 162, column: 11
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 164, column: 5
                  currsigs.addElement(turnNozTrigger);
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S868=5;
                  if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 167, column: 11
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 169, column: 5
                    currsigs.addElement(turnNozTrigger);
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                  else {
                    S868=0;
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                }
              }
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 154, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 3 : 
            if(noz2.getprestatus()){//sysj\controller.sysj line: 158, column: 10
              S868=4;
              if(i_selNoz3.getprestatus()){//sysj\controller.sysj line: 162, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 164, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S868=5;
                if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 167, column: 11
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 169, column: 5
                  currsigs.addElement(turnNozTrigger);
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S868=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
              }
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 159, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 4 : 
            if(noz3.getprestatus()){//sysj\controller.sysj line: 163, column: 10
              S868=5;
              if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 167, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 169, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S868=0;
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 164, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 5 : 
            if(noz4.getprestatus()){//sysj\controller.sysj line: 168, column: 10
              S868=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 169, column: 5
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

  public void thread1432(int [] tdone, int [] ends){
        switch(S660){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 143, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread1431(int [] tdone, int [] ends){
        switch(S655){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 140, column: 5
        currsigs.addElement(valveInletOnOff);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread1429(int [] tdone, int [] ends){
        S660=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 143, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1428(int [] tdone, int [] ends){
        S655=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 140, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread1426(int [] tdone, int [] ends){
        switch(S637){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 133, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread1425(int [] tdone, int [] ends){
        switch(S631){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 129, column: 5
        currsigs.addElement(valveInjectorOnOff);
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread1423(int [] tdone, int [] ends){
        S660=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 143, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1422(int [] tdone, int [] ends){
        S655=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 140, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread1420(int [] tdone, int [] ends){
        S637=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 132, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 133, column: 6
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

  public void thread1419(int [] tdone, int [] ends){
        S631=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 129, column: 5
    currsigs.addElement(valveInjectorOnOff);
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread1418(int [] tdone, int [] ends){
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
            if(bottleAtPos2.getprestatus() && !turnNozTrigger.getprestatus()){//sysj\controller.sysj line: 127, column: 9
              S626=2;
              thread1419(tdone,ends);
              thread1420(tdone,ends);
              int biggest1421 = 0;
              if(ends[15]>=biggest1421){
                biggest1421=ends[15];
              }
              if(ends[16]>=biggest1421){
                biggest1421=ends[16];
              }
              if(biggest1421 == 1){
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
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 128, column: 9
              S626=3;
              thread1422(tdone,ends);
              thread1423(tdone,ends);
              int biggest1424 = 0;
              if(ends[17]>=biggest1424){
                biggest1424=ends[17];
              }
              if(ends[18]>=biggest1424){
                biggest1424=ends[18];
              }
              if(biggest1424 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              thread1425(tdone,ends);
              thread1426(tdone,ends);
              int biggest1427 = 0;
              if(ends[15]>=biggest1427){
                biggest1427=ends[15];
              }
              if(ends[16]>=biggest1427){
                biggest1427=ends[16];
              }
              if(biggest1427 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest1427 == 0){
                S626=3;
                thread1428(tdone,ends);
                thread1429(tdone,ends);
                int biggest1430 = 0;
                if(ends[17]>=biggest1430){
                  biggest1430=ends[17];
                }
                if(ends[18]>=biggest1430){
                  biggest1430=ends[18];
                }
                if(biggest1430 == 1){
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
            }
            break;
          
          case 3 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 139, column: 9
              doneAtPos2.setPresent();//sysj\controller.sysj line: 146, column: 3
              currsigs.addElement(doneAtPos2);
              S626=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              thread1431(tdone,ends);
              thread1432(tdone,ends);
              int biggest1433 = 0;
              if(ends[17]>=biggest1433){
                biggest1433=ends[17];
              }
              if(ends[18]>=biggest1433){
                biggest1433=ends[18];
              }
              if(biggest1433 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest1433 == 0){
                doneAtPos2.setPresent();//sysj\controller.sysj line: 146, column: 3
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

  public void thread1416(int [] tdone, int [] ends){
        S1378=1;
    S868=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread1415(int [] tdone, int [] ends){
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
      switch(S1380){
        case 0 : 
          S1380=0;
          break RUN;
        
        case 1 : 
          S1380=2;
          S1380=2;
          thread1415(tdone,ends);
          thread1416(tdone,ends);
          int biggest1417 = 0;
          if(ends[14]>=biggest1417){
            biggest1417=ends[14];
          }
          if(ends[19]>=biggest1417){
            biggest1417=ends[19];
          }
          if(biggest1417 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          thread1418(tdone,ends);
          thread1434(tdone,ends);
          int biggest1435 = 0;
          if(ends[14]>=biggest1435){
            biggest1435=ends[14];
          }
          if(ends[19]>=biggest1435){
            biggest1435=ends[19];
          }
          if(biggest1435 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1435 == 0){
            S1380=0;
            active[13]=0;
            ends[13]=0;
            S1380=0;
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
