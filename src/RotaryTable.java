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
  public Signal capOnBottleAtPos1 = new Signal("capOnBottleAtPos1", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal doneAtPos2 = new Signal("doneAtPos2", Signal.INPUT);
  public Signal doneAtPos4 = new Signal("doneAtPos4", Signal.INPUT);
  public Signal rotaryTableTrigger = new Signal("rotaryTableTrigger", Signal.OUTPUT);
  private int S165 = 1;
  private int S67 = 1;
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S165){
        case 0 : 
          S165=0;
          break RUN;
        
        case 1 : 
          S165=2;
          S165=2;
          S67=0;
          active[2]=1;
          ends[2]=1;
          break RUN;
        
        case 2 : 
          switch(S67){
            case 0 : 
              S67=0;
              S67=1;
              active[2]=1;
              ends[2]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos1.getprestatus()){//sysj\controller.sysj line: 32, column: 9
                S67=2;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 2 : 
              if(!capOnBottleAtPos1.getprestatus()){//sysj\controller.sysj line: 33, column: 9
                S67=3;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 35, column: 4
                currsigs.addElement(rotaryTableTrigger);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 3 : 
              if(bottleAtPos5.getprestatus() || tableAlignedWithSensor.getprestatus()){//sysj\controller.sysj line: 34, column: 9
                S67=4;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 35, column: 4
                currsigs.addElement(rotaryTableTrigger);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 4 : 
              if(doneAtPos2.getprestatus()){//sysj\controller.sysj line: 37, column: 9
                S67=5;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 39, column: 4
                currsigs.addElement(rotaryTableTrigger);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 5 : 
              if(bottleAtPos5.getprestatus() || tableAlignedWithSensor.getprestatus()){//sysj\controller.sysj line: 38, column: 9
                S67=6;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 39, column: 4
                currsigs.addElement(rotaryTableTrigger);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 6 : 
              if(doneAtPos4.getprestatus()){//sysj\controller.sysj line: 41, column: 9
                S67=7;
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 43, column: 4
                currsigs.addElement(rotaryTableTrigger);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
            case 7 : 
              if(bottleAtPos5.getprestatus() || tableAlignedWithSensor.getprestatus()){//sysj\controller.sysj line: 42, column: 9
                S67=0;
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
              else {
                rotaryTableTrigger.setPresent();//sysj\controller.sysj line: 43, column: 4
                currsigs.addElement(rotaryTableTrigger);
                active[2]=1;
                ends[2]=1;
                break RUN;
              }
            
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
          capOnBottleAtPos1.gethook();
          bottleAtPos1.gethook();
          doneAtPos2.gethook();
          doneAtPos4.gethook();
          df = true;
        }
        runClockDomain();
      }
      tableAlignedWithSensor.setpreclear();
      bottleAtPos5.setpreclear();
      capOnBottleAtPos1.setpreclear();
      bottleAtPos1.setpreclear();
      doneAtPos2.setpreclear();
      doneAtPos4.setpreclear();
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
      dummyint = capOnBottleAtPos1.getStatus() ? capOnBottleAtPos1.setprepresent() : capOnBottleAtPos1.setpreclear();
      capOnBottleAtPos1.setpreval(capOnBottleAtPos1.getValue());
      capOnBottleAtPos1.setClear();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      dummyint = doneAtPos2.getStatus() ? doneAtPos2.setprepresent() : doneAtPos2.setpreclear();
      doneAtPos2.setpreval(doneAtPos2.getValue());
      doneAtPos2.setClear();
      dummyint = doneAtPos4.getStatus() ? doneAtPos4.setprepresent() : doneAtPos4.setpreclear();
      doneAtPos4.setpreval(doneAtPos4.getValue());
      doneAtPos4.setClear();
      rotaryTableTrigger.sethook();
      rotaryTableTrigger.setClear();
      if(paused[2]!=0 || suspended[2]!=0 || active[2]!=1);
      else{
        tableAlignedWithSensor.gethook();
        bottleAtPos5.gethook();
        capOnBottleAtPos1.gethook();
        bottleAtPos1.gethook();
        doneAtPos2.gethook();
        doneAtPos4.gethook();
      }
      runFinisher();
      if(active[2] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
