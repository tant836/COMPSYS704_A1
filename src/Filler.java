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
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  private int S793 = 1;
  private int S554 = 1;
  private int S559 = 1;
  private int S565 = 1;
  private int S583 = 1;
  private int S588 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread841(int [] tdone, int [] ends){
        switch(S588){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 127, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread840(int [] tdone, int [] ends){
        switch(S583){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 124, column: 5
        currsigs.addElement(valveInletOnOff);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread838(int [] tdone, int [] ends){
        S588=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 127, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread837(int [] tdone, int [] ends){
        S583=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 124, column: 5
    currsigs.addElement(valveInletOnOff);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread835(int [] tdone, int [] ends){
        switch(S565){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 117, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread834(int [] tdone, int [] ends){
        switch(S559){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 113, column: 5
        currsigs.addElement(valveInjectorOnOff);
        active[14]=1;
        ends[14]=1;
        tdone[14]=1;
        break;
      
    }
  }

  public void thread832(int [] tdone, int [] ends){
        S588=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 127, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread831(int [] tdone, int [] ends){
        S583=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 124, column: 5
    currsigs.addElement(valveInletOnOff);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread829(int [] tdone, int [] ends){
        S565=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 116, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 117, column: 6
      currsigs.addElement(dosUnitValveRetract);
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
    else {
      S565=0;
      active[15]=0;
      ends[15]=0;
      tdone[15]=1;
    }
  }

  public void thread828(int [] tdone, int [] ends){
        S559=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 113, column: 5
    currsigs.addElement(valveInjectorOnOff);
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
      switch(S793){
        case 0 : 
          S793=0;
          break RUN;
        
        case 1 : 
          S793=2;
          S793=2;
          S554=0;
          active[13]=1;
          ends[13]=1;
          break RUN;
        
        case 2 : 
          switch(S554){
            case 0 : 
              S554=0;
              S554=1;
              active[13]=1;
              ends[13]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 111, column: 9
                S554=2;
                thread828(tdone,ends);
                thread829(tdone,ends);
                int biggest830 = 0;
                if(ends[14]>=biggest830){
                  biggest830=ends[14];
                }
                if(ends[15]>=biggest830){
                  biggest830=ends[15];
                }
                if(biggest830 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
              }
              else {
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
            
            case 2 : 
              if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 112, column: 9
                S554=3;
                thread831(tdone,ends);
                thread832(tdone,ends);
                int biggest833 = 0;
                if(ends[16]>=biggest833){
                  biggest833=ends[16];
                }
                if(ends[17]>=biggest833){
                  biggest833=ends[17];
                }
                if(biggest833 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
              }
              else {
                thread834(tdone,ends);
                thread835(tdone,ends);
                int biggest836 = 0;
                if(ends[14]>=biggest836){
                  biggest836=ends[14];
                }
                if(ends[15]>=biggest836){
                  biggest836=ends[15];
                }
                if(biggest836 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest836 == 0){
                  S554=3;
                  thread837(tdone,ends);
                  thread838(tdone,ends);
                  int biggest839 = 0;
                  if(ends[16]>=biggest839){
                    biggest839=ends[16];
                  }
                  if(ends[17]>=biggest839){
                    biggest839=ends[17];
                  }
                  if(biggest839 == 1){
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 123, column: 9
                S554=0;
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
              else {
                thread840(tdone,ends);
                thread841(tdone,ends);
                int biggest842 = 0;
                if(ends[16]>=biggest842){
                  biggest842=ends[16];
                }
                if(ends[17]>=biggest842){
                  biggest842=ends[17];
                }
                if(biggest842 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest842 == 0){
                  S554=0;
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
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
      valveInjectorOnOff.sethook();
      valveInjectorOnOff.setClear();
      valveInletOnOff.sethook();
      valveInletOnOff.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
      }
      runFinisher();
      if(active[13] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
