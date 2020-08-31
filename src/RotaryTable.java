import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class RotaryTable extends ClockDomain{
  public RotaryTable(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal tableAlignedWithSensor = new Signal("tableAlignedWithSensor", Signal.INPUT);
  public Signal bottleAtPos5 = new Signal("bottleAtPos5", Signal.INPUT);
  public Signal capsonBottleAtPos1 = new Signal("capsonBottleAtPos1", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  private int S152 = 1;
  private int S81 = 1;
  private int S68 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S152){
        case 0 : 
          S152=0;
          break RUN;
        
        case 1 : 
          S152=2;
          S152=2;
          S81=0;
          active[2]=1;
          ends[2]=1;
          break RUN;
        
        case 2 : 
          switch(S81){
            case 0 : 
              S81=0;
              S81=1;
              if(capsonBottleAtPos1.getprestatus()){//sysj\controller.sysj line: 28, column: 11
                S68=0;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                S81=0;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 1 : 
              switch(S68){
                case 0 : 
                  if(!bottleAtPos5.getprestatus()){//sysj\controller.sysj line: 29, column: 10
                    S68=1;
                    rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 31, column: 5
                    currsigs.addElement(rotaryTableTrigger);
                    System.out.println("Emitted rotaryTableTrigger");
                    active[2]=1;
                    ends[2]=1;
                    break RUN;
                  }
                  else {
                    active[2]=1;
                    ends[2]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(tableAlignedWithSensor.getprestatus()){//sysj\controller.sysj line: 30, column: 10
                    S81=0;
                    active[2]=1;
                    ends[2]=1;
                    break RUN;
                  }
                  else {
                    rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 31, column: 5
                    currsigs.addElement(rotaryTableTrigger);
                    System.out.println("Emitted rotaryTableTrigger");
                    active[2]=1;
                    ends[2]=1;
                    break RUN;
                  }
                
              }
              break;
            
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
    while(active[2] != 0){
      int index = 2;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        if(!df){
          tableAlignedWithSensor.gethook();
          bottleAtPos5.gethook();
          capsonBottleAtPos1.gethook();
          df = true;
        }
        runClockDomain();
      }
      tableAlignedWithSensor.setpreclear();
      bottleAtPos5.setpreclear();
      capsonBottleAtPos1.setpreclear();
      rotaryTableTrigger.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = tableAlignedWithSensor.getStatus() ? tableAlignedWithSensor.setprepresent() : tableAlignedWithSensor.setpreclear();
      tableAlignedWithSensor.setpreval(tableAlignedWithSensor.getValue());
      tableAlignedWithSensor.setClear();
      dummyint = bottleAtPos5.getStatus() ? bottleAtPos5.setprepresent() : bottleAtPos5.setpreclear();
      bottleAtPos5.setpreval(bottleAtPos5.getValue());
      bottleAtPos5.setClear();
      dummyint = capsonBottleAtPos1.getStatus() ? capsonBottleAtPos1.setprepresent() : capsonBottleAtPos1.setpreclear();
      capsonBottleAtPos1.setpreval(capsonBottleAtPos1.getValue());
      capsonBottleAtPos1.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        tableAlignedWithSensor.gethook();
        bottleAtPos5.gethook();
        capsonBottleAtPos1.gethook();
      }
      runFinisher();
      if(active[2] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
