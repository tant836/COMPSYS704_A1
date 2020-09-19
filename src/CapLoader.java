import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class CapLoader extends ClockDomain{
  public CapLoader(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal empty = new Signal("empty", Signal.INPUT);
  public Signal bottleAtPos3 = new Signal("bottleAtPos3", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  public Signal doneAtPos3 = new Signal("doneAtPos3", Signal.OUTPUT);
  private int S2847 = 1;
  private int S2626 = 1;
  private int S2667 = 1;
  private int S2672 = 1;
  
  private int[] ends = new int[25];
  private int[] tdone = new int[25];
  
  public void thread2916(int [] tdone, int [] ends){
        switch(S2672){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj\controller.sysj line: 275, column: 24
        currsigs.addElement(armDest);
        active[24]=1;
        ends[24]=1;
        tdone[24]=1;
        break;
      
    }
  }

  public void thread2915(int [] tdone, int [] ends){
        switch(S2667){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj\controller.sysj line: 275, column: 6
        currsigs.addElement(vacOn);
        active[23]=1;
        ends[23]=1;
        tdone[23]=1;
        break;
      
    }
  }

  public void thread2913(int [] tdone, int [] ends){
        S2672=1;
    armDest.setPresent();//sysj\controller.sysj line: 275, column: 24
    currsigs.addElement(armDest);
    active[24]=1;
    ends[24]=1;
    tdone[24]=1;
  }

  public void thread2912(int [] tdone, int [] ends){
        S2667=1;
    vacOn.setPresent();//sysj\controller.sysj line: 275, column: 6
    currsigs.addElement(vacOn);
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2847){
        case 0 : 
          S2847=0;
          break RUN;
        
        case 1 : 
          S2847=2;
          S2847=2;
          S2626=0;
          active[22]=1;
          ends[22]=1;
          break RUN;
        
        case 2 : 
          switch(S2626){
            case 0 : 
              S2626=0;
              S2626=1;
              active[22]=1;
              ends[22]=1;
              break RUN;
            
            case 1 : 
              if(!empty.getprestatus()){//sysj\controller.sysj line: 254, column: 10
                S2626=2;
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
            case 2 : 
              if(bottleAtPos3.getprestatus()){//sysj\controller.sysj line: 255, column: 10
                S2626=3;
                armDest.setPresent();//sysj\controller.sysj line: 257, column: 5
                currsigs.addElement(armDest);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
            case 3 : 
              if(armAtDest.getprestatus()){//sysj\controller.sysj line: 256, column: 10
                S2626=4;
                pusherExtend.setPresent();//sysj\controller.sysj line: 261, column: 5
                currsigs.addElement(pusherExtend);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                armDest.setPresent();//sysj\controller.sysj line: 257, column: 5
                currsigs.addElement(armDest);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
            case 4 : 
              if(pusherExtended.getprestatus()){//sysj\controller.sysj line: 260, column: 10
                S2626=5;
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                pusherExtend.setPresent();//sysj\controller.sysj line: 261, column: 5
                currsigs.addElement(pusherExtend);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
            case 5 : 
              if(pusherRetracted.getprestatus()){//sysj\controller.sysj line: 264, column: 10
                S2626=6;
                armSource.setPresent();//sysj\controller.sysj line: 267, column: 5
                currsigs.addElement(armSource);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
            case 6 : 
              if(armAtSource.getprestatus()){//sysj\controller.sysj line: 266, column: 10
                S2626=7;
                vacOn.setPresent();//sysj\controller.sysj line: 271, column: 5
                currsigs.addElement(vacOn);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                armSource.setPresent();//sysj\controller.sysj line: 267, column: 5
                currsigs.addElement(armSource);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
            case 7 : 
              if(WPgripped.getprestatus()){//sysj\controller.sysj line: 270, column: 10
                S2626=8;
                thread2912(tdone,ends);
                thread2913(tdone,ends);
                int biggest2914 = 0;
                if(ends[23]>=biggest2914){
                  biggest2914=ends[23];
                }
                if(ends[24]>=biggest2914){
                  biggest2914=ends[24];
                }
                if(biggest2914 == 1){
                  active[22]=1;
                  ends[22]=1;
                  break RUN;
                }
              }
              else {
                vacOn.setPresent();//sysj\controller.sysj line: 271, column: 5
                currsigs.addElement(vacOn);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
            case 8 : 
              if(armAtDest.getprestatus()){//sysj\controller.sysj line: 274, column: 10
                S2626=9;
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                thread2915(tdone,ends);
                thread2916(tdone,ends);
                int biggest2917 = 0;
                if(ends[23]>=biggest2917){
                  biggest2917=ends[23];
                }
                if(ends[24]>=biggest2917){
                  biggest2917=ends[24];
                }
                if(biggest2917 == 1){
                  active[22]=1;
                  ends[22]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2917 == 0){
                  S2626=9;
                  active[22]=1;
                  ends[22]=1;
                  break RUN;
                }
              }
            
            case 9 : 
              if(!WPgripped.getprestatus()){//sysj\controller.sysj line: 278, column: 10
                S2626=10;
                armSource.setPresent();//sysj\controller.sysj line: 281, column: 5
                currsigs.addElement(armSource);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
            case 10 : 
              if(armAtSource.getprestatus()){//sysj\controller.sysj line: 280, column: 10
                doneAtPos3.setPresent();//sysj\controller.sysj line: 284, column: 4
                currsigs.addElement(doneAtPos3);
                S2626=11;
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                armSource.setPresent();//sysj\controller.sysj line: 281, column: 5
                currsigs.addElement(armSource);
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
            case 11 : 
              if(!bottleAtPos3.getprestatus()){//sysj\controller.sysj line: 285, column: 10
                S2626=0;
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
              else {
                active[22]=1;
                ends[22]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[22] != 0){
      int index = 22;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[22]!=0 || suspended[22]!=0 || active[22]!=1);
      else{
        if(!df){
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          empty.gethook();
          bottleAtPos3.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      bottleAtPos3.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      doneAtPos3.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = empty.getStatus() ? empty.setprepresent() : empty.setpreclear();
      empty.setpreval(empty.getValue());
      empty.setClear();
      dummyint = bottleAtPos3.getStatus() ? bottleAtPos3.setprepresent() : bottleAtPos3.setpreclear();
      bottleAtPos3.setpreval(bottleAtPos3.getValue());
      bottleAtPos3.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      doneAtPos3.sethook();
      doneAtPos3.setClear();
      if(paused[22]!=0 || suspended[22]!=0 || active[22]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        empty.gethook();
        bottleAtPos3.gethook();
      }
      runFinisher();
      if(active[22] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
