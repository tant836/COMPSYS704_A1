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
  private int S1308 = 1;
  private int S793 = 1;
  private int S554 = 1;
  private int S559 = 1;
  private int S565 = 1;
  private int S583 = 1;
  private int S588 = 1;
  private int S1306 = 1;
  private int S796 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread1362(int [] tdone, int [] ends){
        switch(S1306){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        switch(S796){
          case 0 : 
            S796=0;
            S796=1;
            active[19]=1;
            ends[19]=1;
            tdone[19]=1;
            break;
          
          case 1 : 
            if(i_selNoz1.getprestatus() || i_selNoz2.getprestatus() || i_selNoz3.getprestatus() || i_selNoz4.getprestatus()){//sysj\controller.sysj line: 136, column: 9
              S796=2;
              if(i_selNoz1.getprestatus()){//sysj\controller.sysj line: 137, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 139, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S796=3;
                if(i_selNoz2.getprestatus()){//sysj\controller.sysj line: 142, column: 11
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 144, column: 5
                  currsigs.addElement(turnNozTrigger);
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S796=4;
                  if(i_selNoz3.getprestatus()){//sysj\controller.sysj line: 147, column: 11
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 149, column: 5
                    currsigs.addElement(turnNozTrigger);
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                  else {
                    S796=5;
                    if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 152, column: 11
                      turnNozTrigger.setPresent();//sysj\controller.sysj line: 154, column: 5
                      currsigs.addElement(turnNozTrigger);
                      active[19]=1;
                      ends[19]=1;
                      tdone[19]=1;
                    }
                    else {
                      S796=0;
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
            if(noz1.getprestatus()){//sysj\controller.sysj line: 138, column: 10
              S796=3;
              if(i_selNoz2.getprestatus()){//sysj\controller.sysj line: 142, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 144, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S796=4;
                if(i_selNoz3.getprestatus()){//sysj\controller.sysj line: 147, column: 11
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 149, column: 5
                  currsigs.addElement(turnNozTrigger);
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S796=5;
                  if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 152, column: 11
                    turnNozTrigger.setPresent();//sysj\controller.sysj line: 154, column: 5
                    currsigs.addElement(turnNozTrigger);
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                  else {
                    S796=0;
                    active[19]=1;
                    ends[19]=1;
                    tdone[19]=1;
                  }
                }
              }
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 139, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 3 : 
            if(noz2.getprestatus()){//sysj\controller.sysj line: 143, column: 10
              S796=4;
              if(i_selNoz3.getprestatus()){//sysj\controller.sysj line: 147, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 149, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S796=5;
                if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 152, column: 11
                  turnNozTrigger.setPresent();//sysj\controller.sysj line: 154, column: 5
                  currsigs.addElement(turnNozTrigger);
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
                else {
                  S796=0;
                  active[19]=1;
                  ends[19]=1;
                  tdone[19]=1;
                }
              }
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 144, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 4 : 
            if(noz3.getprestatus()){//sysj\controller.sysj line: 148, column: 10
              S796=5;
              if(i_selNoz4.getprestatus()){//sysj\controller.sysj line: 152, column: 11
                turnNozTrigger.setPresent();//sysj\controller.sysj line: 154, column: 5
                currsigs.addElement(turnNozTrigger);
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
              else {
                S796=0;
                active[19]=1;
                ends[19]=1;
                tdone[19]=1;
              }
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 149, column: 5
              currsigs.addElement(turnNozTrigger);
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            break;
          
          case 5 : 
            if(noz4.getprestatus()){//sysj\controller.sysj line: 153, column: 10
              S796=0;
              active[19]=1;
              ends[19]=1;
              tdone[19]=1;
            }
            else {
              turnNozTrigger.setPresent();//sysj\controller.sysj line: 154, column: 5
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

  public void thread1360(int [] tdone, int [] ends){
        switch(S588){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 129, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread1359(int [] tdone, int [] ends){
        switch(S583){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 126, column: 5
        currsigs.addElement(valveInletOnOff);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread1357(int [] tdone, int [] ends){
        S588=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 129, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1356(int [] tdone, int [] ends){
        S583=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 126, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread1354(int [] tdone, int [] ends){
        switch(S565){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 119, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread1353(int [] tdone, int [] ends){
        switch(S559){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 115, column: 5
        currsigs.addElement(valveInjectorOnOff);
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread1351(int [] tdone, int [] ends){
        S588=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 129, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread1350(int [] tdone, int [] ends){
        S583=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 126, column: 5
    currsigs.addElement(valveInletOnOff);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread1348(int [] tdone, int [] ends){
        S565=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 118, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 119, column: 6
      currsigs.addElement(dosUnitValveRetract);
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      S565=0;
      active[16]=0;
      ends[16]=0;
      tdone[16]=1;
    }
  }

  public void thread1347(int [] tdone, int [] ends){
        S559=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 115, column: 5
    currsigs.addElement(valveInjectorOnOff);
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread1346(int [] tdone, int [] ends){
        switch(S793){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S554){
          case 0 : 
            S554=0;
            S554=1;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 1 : 
            if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 113, column: 9
              S554=2;
              thread1347(tdone,ends);
              thread1348(tdone,ends);
              int biggest1349 = 0;
              if(ends[15]>=biggest1349){
                biggest1349=ends[15];
              }
              if(ends[16]>=biggest1349){
                biggest1349=ends[16];
              }
              if(biggest1349 == 1){
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
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 114, column: 9
              S554=3;
              thread1350(tdone,ends);
              thread1351(tdone,ends);
              int biggest1352 = 0;
              if(ends[17]>=biggest1352){
                biggest1352=ends[17];
              }
              if(ends[18]>=biggest1352){
                biggest1352=ends[18];
              }
              if(biggest1352 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              thread1353(tdone,ends);
              thread1354(tdone,ends);
              int biggest1355 = 0;
              if(ends[15]>=biggest1355){
                biggest1355=ends[15];
              }
              if(ends[16]>=biggest1355){
                biggest1355=ends[16];
              }
              if(biggest1355 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest1355 == 0){
                S554=3;
                thread1356(tdone,ends);
                thread1357(tdone,ends);
                int biggest1358 = 0;
                if(ends[17]>=biggest1358){
                  biggest1358=ends[17];
                }
                if(ends[18]>=biggest1358){
                  biggest1358=ends[18];
                }
                if(biggest1358 == 1){
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
            }
            break;
          
          case 3 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 125, column: 9
              S554=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              thread1359(tdone,ends);
              thread1360(tdone,ends);
              int biggest1361 = 0;
              if(ends[17]>=biggest1361){
                biggest1361=ends[17];
              }
              if(ends[18]>=biggest1361){
                biggest1361=ends[18];
              }
              if(biggest1361 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest1361 == 0){
                S554=0;
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

  public void thread1344(int [] tdone, int [] ends){
        S1306=1;
    S796=0;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread1343(int [] tdone, int [] ends){
        S793=1;
    S554=0;
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
      switch(S1308){
        case 0 : 
          S1308=0;
          break RUN;
        
        case 1 : 
          S1308=2;
          S1308=2;
          thread1343(tdone,ends);
          thread1344(tdone,ends);
          int biggest1345 = 0;
          if(ends[14]>=biggest1345){
            biggest1345=ends[14];
          }
          if(ends[19]>=biggest1345){
            biggest1345=ends[19];
          }
          if(biggest1345 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          thread1346(tdone,ends);
          thread1362(tdone,ends);
          int biggest1363 = 0;
          if(ends[14]>=biggest1363){
            biggest1363=ends[14];
          }
          if(ends[19]>=biggest1363){
            biggest1363=ends[19];
          }
          if(biggest1363 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1363 == 0){
            S1308=0;
            active[13]=0;
            ends[13]=0;
            S1308=0;
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
