import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Filer extends ClockDomain{
  public Filer(String name){super(name);}
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
  private int S840 = 1;
  private int S601 = 1;
  private int S606 = 1;
  private int S612 = 1;
  private int S630 = 1;
  private int S635 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread888(int [] tdone, int [] ends){
        switch(S635){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 123, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread887(int [] tdone, int [] ends){
        switch(S630){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 120, column: 5
        currsigs.addElement(valveInletOnOff);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread885(int [] tdone, int [] ends){
        S635=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 123, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread884(int [] tdone, int [] ends){
        S630=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 120, column: 5
    currsigs.addElement(valveInletOnOff);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread882(int [] tdone, int [] ends){
        switch(S612){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 113, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread881(int [] tdone, int [] ends){
        switch(S606){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 109, column: 5
        currsigs.addElement(valveInjectorOnOff);
        active[14]=1;
        ends[14]=1;
        tdone[14]=1;
        break;
      
    }
  }

  public void thread879(int [] tdone, int [] ends){
        S635=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 123, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread878(int [] tdone, int [] ends){
        S630=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 120, column: 5
    currsigs.addElement(valveInletOnOff);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread876(int [] tdone, int [] ends){
        S612=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 112, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 113, column: 6
      currsigs.addElement(dosUnitValveRetract);
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
    else {
      S612=0;
      active[15]=0;
      ends[15]=0;
      tdone[15]=1;
    }
  }

  public void thread875(int [] tdone, int [] ends){
        S606=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 109, column: 5
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
      switch(S840){
        case 0 : 
          S840=0;
          break RUN;
        
        case 1 : 
          S840=2;
          S840=2;
          S601=0;
          active[13]=1;
          ends[13]=1;
          break RUN;
        
        case 2 : 
          switch(S601){
            case 0 : 
              S601=0;
              S601=1;
              active[13]=1;
              ends[13]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 107, column: 9
                S601=2;
                thread875(tdone,ends);
                thread876(tdone,ends);
                int biggest877 = 0;
                if(ends[14]>=biggest877){
                  biggest877=ends[14];
                }
                if(ends[15]>=biggest877){
                  biggest877=ends[15];
                }
                if(biggest877 == 1){
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
              if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 108, column: 9
                S601=3;
                thread878(tdone,ends);
                thread879(tdone,ends);
                int biggest880 = 0;
                if(ends[16]>=biggest880){
                  biggest880=ends[16];
                }
                if(ends[17]>=biggest880){
                  biggest880=ends[17];
                }
                if(biggest880 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
              }
              else {
                thread881(tdone,ends);
                thread882(tdone,ends);
                int biggest883 = 0;
                if(ends[14]>=biggest883){
                  biggest883=ends[14];
                }
                if(ends[15]>=biggest883){
                  biggest883=ends[15];
                }
                if(biggest883 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest883 == 0){
                  S601=3;
                  thread884(tdone,ends);
                  thread885(tdone,ends);
                  int biggest886 = 0;
                  if(ends[16]>=biggest886){
                    biggest886=ends[16];
                  }
                  if(ends[17]>=biggest886){
                    biggest886=ends[17];
                  }
                  if(biggest886 == 1){
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 119, column: 9
                S601=0;
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
              else {
                thread887(tdone,ends);
                thread888(tdone,ends);
                int biggest889 = 0;
                if(ends[16]>=biggest889){
                  biggest889=ends[16];
                }
                if(ends[17]>=biggest889){
                  biggest889=ends[17];
                }
                if(biggest889 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest889 == 0){
                  S601=0;
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
