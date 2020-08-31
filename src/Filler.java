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
  private int S909 = 1;
  private int S670 = 1;
  private int S675 = 1;
  private int S681 = 1;
  private int S699 = 1;
  private int S704 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread957(int [] tdone, int [] ends){
        switch(S704){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 129, column: 5
        currsigs.addElement(dosUnitValveExtend);
        System.out.println("Emitted dosUnitValveExtend");
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread956(int [] tdone, int [] ends){
        switch(S699){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 126, column: 5
        currsigs.addElement(valveInletOnOff);
        System.out.println("Emitted valveInletOnOff");
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread954(int [] tdone, int [] ends){
        S704=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 129, column: 5
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread953(int [] tdone, int [] ends){
        S699=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 126, column: 5
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread951(int [] tdone, int [] ends){
        switch(S681){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 119, column: 6
        currsigs.addElement(dosUnitValveRetract);
        System.out.println("Emitted dosUnitValveRetract");
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread950(int [] tdone, int [] ends){
        switch(S675){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 115, column: 5
        currsigs.addElement(valveInjectorOnOff);
        System.out.println("Emitted valveInjectorOnOff");
        active[14]=1;
        ends[14]=1;
        tdone[14]=1;
        break;
      
    }
  }

  public void thread948(int [] tdone, int [] ends){
        S704=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 129, column: 5
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread947(int [] tdone, int [] ends){
        S699=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 126, column: 5
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[16]=1;
    ends[16]=1;
    tdone[16]=1;
  }

  public void thread945(int [] tdone, int [] ends){
        S681=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 118, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 119, column: 6
      currsigs.addElement(dosUnitValveRetract);
      System.out.println("Emitted dosUnitValveRetract");
      active[15]=1;
      ends[15]=1;
      tdone[15]=1;
    }
    else {
      S681=0;
      active[15]=0;
      ends[15]=0;
      tdone[15]=1;
    }
  }

  public void thread944(int [] tdone, int [] ends){
        S675=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 115, column: 5
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
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
      switch(S909){
        case 0 : 
          S909=0;
          break RUN;
        
        case 1 : 
          S909=2;
          S909=2;
          S670=0;
          active[13]=1;
          ends[13]=1;
          break RUN;
        
        case 2 : 
          switch(S670){
            case 0 : 
              S670=0;
              S670=1;
              active[13]=1;
              ends[13]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 113, column: 9
                S670=2;
                thread944(tdone,ends);
                thread945(tdone,ends);
                int biggest946 = 0;
                if(ends[14]>=biggest946){
                  biggest946=ends[14];
                }
                if(ends[15]>=biggest946){
                  biggest946=ends[15];
                }
                if(biggest946 == 1){
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
              if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 114, column: 9
                S670=3;
                thread947(tdone,ends);
                thread948(tdone,ends);
                int biggest949 = 0;
                if(ends[16]>=biggest949){
                  biggest949=ends[16];
                }
                if(ends[17]>=biggest949){
                  biggest949=ends[17];
                }
                if(biggest949 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
              }
              else {
                thread950(tdone,ends);
                thread951(tdone,ends);
                int biggest952 = 0;
                if(ends[14]>=biggest952){
                  biggest952=ends[14];
                }
                if(ends[15]>=biggest952){
                  biggest952=ends[15];
                }
                if(biggest952 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest952 == 0){
                  S670=3;
                  thread953(tdone,ends);
                  thread954(tdone,ends);
                  int biggest955 = 0;
                  if(ends[16]>=biggest955){
                    biggest955=ends[16];
                  }
                  if(ends[17]>=biggest955){
                    biggest955=ends[17];
                  }
                  if(biggest955 == 1){
                    active[13]=1;
                    ends[13]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 125, column: 9
                S670=0;
                active[13]=1;
                ends[13]=1;
                break RUN;
              }
              else {
                thread956(tdone,ends);
                thread957(tdone,ends);
                int biggest958 = 0;
                if(ends[16]>=biggest958){
                  biggest958=ends[16];
                }
                if(ends[17]>=biggest958){
                  biggest958=ends[17];
                }
                if(biggest958 == 1){
                  active[13]=1;
                  ends[13]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest958 == 0){
                  S670=0;
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
