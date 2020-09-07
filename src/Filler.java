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
  private int S806 = 1;
  private int S567 = 1;
  private int S572 = 1;
  private int S578 = 1;
  private int S596 = 1;
  private int S601 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread854(int [] tdone, int [] ends){
        switch(S601){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 128, column: 5
        currsigs.addElement(dosUnitValveExtend);
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread853(int [] tdone, int [] ends){
        switch(S596){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 125, column: 5
        currsigs.addElement(valveInletOnOff);
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread851(int [] tdone, int [] ends){
        S601=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 128, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread850(int [] tdone, int [] ends){
        S596=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 125, column: 5
    currsigs.addElement(valveInletOnOff);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread848(int [] tdone, int [] ends){
        switch(S578){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 118, column: 6
        currsigs.addElement(dosUnitValveRetract);
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread847(int [] tdone, int [] ends){
        switch(S572){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 114, column: 5
        currsigs.addElement(valveInjectorOnOff);
        active[14]=1;
        ends[14]=1;
        tdone[14]=1;
        break;
      
    }
  }

  public void thread845(int [] tdone, int [] ends){
        S601=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 128, column: 5
    currsigs.addElement(dosUnitValveExtend);
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread844(int [] tdone, int [] ends){
        S596=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 125, column: 5
    currsigs.addElement(valveInletOnOff);
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread842(int [] tdone, int [] ends){
        S578=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 117, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 118, column: 6
      currsigs.addElement(dosUnitValveRetract);
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
    else {
      S578=0;
      active[15]=0;
      ends[15]=0;
      tdone[15]=1;
    }
  }

  public void thread841(int [] tdone, int [] ends){
        S572=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 114, column: 5
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
      switch(S806){
        case 0 : 
          S806=0;
          break RUN;
        
        case 1 : 
          S806=2;
          S806=2;
          S567=0;
          active[13]=1;
          ends[13]=1;
          break RUN;
        
        case 2 : 
          switch(S567){
            case 0 : 
              S567=0;
              S567=1;
              active[13]=1;
              ends[13]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 112, column: 9
                S567=2;
                thread841(tdone,ends);
                thread842(tdone,ends);
                int biggest843 = 0;
                if(ends[14]>=biggest843){
                  biggest843=ends[14];
                }
                if(ends[15]>=biggest843){
                  biggest843=ends[15];
                }
                if(biggest843 == 1){
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
              if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 113, column: 9
                S567=3;
                thread844(tdone,ends);
                thread845(tdone,ends);
                int biggest846 = 0;
                if(ends[16]>=biggest846){
                  biggest846=ends[16];
                }
                if(ends[17]>=biggest846){
                  biggest846=ends[17];
                }
                if(biggest846 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
              }
              else {
                thread847(tdone,ends);
                thread848(tdone,ends);
                int biggest849 = 0;
                if(ends[14]>=biggest849){
                  biggest849=ends[14];
                }
                if(ends[15]>=biggest849){
                  biggest849=ends[15];
                }
                if(biggest849 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest849 == 0){
                  S567=3;
                  thread850(tdone,ends);
                  thread851(tdone,ends);
                  int biggest852 = 0;
                  if(ends[16]>=biggest852){
                    biggest852=ends[16];
                  }
                  if(ends[17]>=biggest852){
                    biggest852=ends[17];
                  }
                  if(biggest852 == 1){
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 124, column: 9
                S567=0;
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
              else {
                thread853(tdone,ends);
                thread854(tdone,ends);
                int biggest855 = 0;
                if(ends[16]>=biggest855){
                  biggest855=ends[16];
                }
                if(ends[17]>=biggest855){
                  biggest855=ends[17];
                }
                if(biggest855 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest855 == 0){
                  S567=0;
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
