import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Capper extends ClockDomain{
  public Capper(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos4 = new Signal("bottleAtPos4", Signal.INPUT);
  public Signal gripperZAxisLowered = new Signal("gripperZAxisLowered", Signal.INPUT);
  public Signal gripperZAxisLifted = new Signal("gripperZAxisLifted", Signal.INPUT);
  public Signal gripperTurnHomePos = new Signal("gripperTurnHomePos", Signal.INPUT);
  public Signal gripperTurnFinalPos = new Signal("gripperTurnFinalPos", Signal.INPUT);
  public Signal cylPos5ZAxisExtend = new Signal("cylPos5ZAxisExtend", Signal.OUTPUT);
  public Signal gripperTurnRetract = new Signal("gripperTurnRetract", Signal.OUTPUT);
  public Signal gripperTurnExtend = new Signal("gripperTurnExtend", Signal.OUTPUT);
  public Signal capGripperPos5Extend = new Signal("capGripperPos5Extend", Signal.OUTPUT);
  public Signal cylClampBottleExtend = new Signal("cylClampBottleExtend", Signal.OUTPUT);
  private int S598 = 1;
  private int S155 = 1;
  private int S160 = 1;
  private int S165 = 1;
  private int S182 = 1;
  private int S187 = 1;
  private int S192 = 1;
  private int S197 = 1;
  private int S245 = 1;
  private int S250 = 1;
  private int S255 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread873(int [] tdone, int [] ends){
        switch(S255){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        gripperTurnRetract.setPresent();//sysj\controller.sysj line: 88, column: 5
        currsigs.addElement(gripperTurnRetract);
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread872(int [] tdone, int [] ends){
        switch(S250){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread871(int [] tdone, int [] ends){
        switch(S245){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread869(int [] tdone, int [] ends){
        S255=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread868(int [] tdone, int [] ends){
        S250=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread867(int [] tdone, int [] ends){
        S245=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread865(int [] tdone, int [] ends){
        switch(S197){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 74, column: 5
        currsigs.addElement(gripperTurnExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread864(int [] tdone, int [] ends){
        switch(S192){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 70, column: 5
        currsigs.addElement(capGripperPos5Extend);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread863(int [] tdone, int [] ends){
        switch(S187){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread862(int [] tdone, int [] ends){
        switch(S182){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 62, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread860(int [] tdone, int [] ends){
        S255=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread859(int [] tdone, int [] ends){
        S250=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread858(int [] tdone, int [] ends){
        S245=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread856(int [] tdone, int [] ends){
        S197=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 74, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread855(int [] tdone, int [] ends){
        S192=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 70, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread854(int [] tdone, int [] ends){
        S187=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread853(int [] tdone, int [] ends){
        S182=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 62, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread851(int [] tdone, int [] ends){
        switch(S165){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 56, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread850(int [] tdone, int [] ends){
        switch(S160){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 52, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread848(int [] tdone, int [] ends){
        S197=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 74, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread847(int [] tdone, int [] ends){
        S192=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 70, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread846(int [] tdone, int [] ends){
        S187=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread845(int [] tdone, int [] ends){
        S182=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 62, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread843(int [] tdone, int [] ends){
        S165=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 56, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread842(int [] tdone, int [] ends){
        S160=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 52, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[4]=1;
    ends[4]=1;
    tdone[4]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S598){
        case 0 : 
          S598=0;
          break RUN;
        
        case 1 : 
          S598=2;
          S598=2;
          S155=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S155){
            case 0 : 
              S155=0;
              S155=1;
              active[3]=1;
              ends[3]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 49, column: 9
                S155=2;
                thread842(tdone,ends);
                thread843(tdone,ends);
                int biggest844 = 0;
                if(ends[4]>=biggest844){
                  biggest844=ends[4];
                }
                if(ends[5]>=biggest844){
                  biggest844=ends[5];
                }
                if(biggest844 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 2 : 
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 50, column: 9
                S155=3;
                thread845(tdone,ends);
                thread846(tdone,ends);
                thread847(tdone,ends);
                thread848(tdone,ends);
                int biggest849 = 0;
                if(ends[6]>=biggest849){
                  biggest849=ends[6];
                }
                if(ends[7]>=biggest849){
                  biggest849=ends[7];
                }
                if(ends[8]>=biggest849){
                  biggest849=ends[8];
                }
                if(ends[9]>=biggest849){
                  biggest849=ends[9];
                }
                if(biggest849 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread850(tdone,ends);
                thread851(tdone,ends);
                int biggest852 = 0;
                if(ends[4]>=biggest852){
                  biggest852=ends[4];
                }
                if(ends[5]>=biggest852){
                  biggest852=ends[5];
                }
                if(biggest852 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest852 == 0){
                  S155=3;
                  thread853(tdone,ends);
                  thread854(tdone,ends);
                  thread855(tdone,ends);
                  thread856(tdone,ends);
                  int biggest857 = 0;
                  if(ends[6]>=biggest857){
                    biggest857=ends[6];
                  }
                  if(ends[7]>=biggest857){
                    biggest857=ends[7];
                  }
                  if(ends[8]>=biggest857){
                    biggest857=ends[8];
                  }
                  if(ends[9]>=biggest857){
                    biggest857=ends[9];
                  }
                  if(biggest857 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 60, column: 9
                S155=4;
                thread858(tdone,ends);
                thread859(tdone,ends);
                thread860(tdone,ends);
                int biggest861 = 0;
                if(ends[10]>=biggest861){
                  biggest861=ends[10];
                }
                if(ends[11]>=biggest861){
                  biggest861=ends[11];
                }
                if(ends[12]>=biggest861){
                  biggest861=ends[12];
                }
                if(biggest861 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread862(tdone,ends);
                thread863(tdone,ends);
                thread864(tdone,ends);
                thread865(tdone,ends);
                int biggest866 = 0;
                if(ends[6]>=biggest866){
                  biggest866=ends[6];
                }
                if(ends[7]>=biggest866){
                  biggest866=ends[7];
                }
                if(ends[8]>=biggest866){
                  biggest866=ends[8];
                }
                if(ends[9]>=biggest866){
                  biggest866=ends[9];
                }
                if(biggest866 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest866 == 0){
                  S155=4;
                  thread867(tdone,ends);
                  thread868(tdone,ends);
                  thread869(tdone,ends);
                  int biggest870 = 0;
                  if(ends[10]>=biggest870){
                    biggest870=ends[10];
                  }
                  if(ends[11]>=biggest870){
                    biggest870=ends[11];
                  }
                  if(ends[12]>=biggest870){
                    biggest870=ends[12];
                  }
                  if(biggest870 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 4 : 
              if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 78, column: 9
                S155=5;
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 93, column: 4
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread871(tdone,ends);
                thread872(tdone,ends);
                thread873(tdone,ends);
                int biggest874 = 0;
                if(ends[10]>=biggest874){
                  biggest874=ends[10];
                }
                if(ends[11]>=biggest874){
                  biggest874=ends[11];
                }
                if(ends[12]>=biggest874){
                  biggest874=ends[12];
                }
                if(biggest874 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest874 == 0){
                  S155=5;
                  cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 93, column: 4
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              if(gripperZAxisLifted.getprestatus()){//sysj\controller.sysj line: 92, column: 9
                S155=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 93, column: 4
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                break RUN;
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
    while(active[3] != 0){
      int index = 3;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        if(!df){
          bottleAtPos4.gethook();
          gripperZAxisLowered.gethook();
          gripperZAxisLifted.gethook();
          gripperTurnHomePos.gethook();
          gripperTurnFinalPos.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos4.setpreclear();
      gripperZAxisLowered.setpreclear();
      gripperZAxisLifted.setpreclear();
      gripperTurnHomePos.setpreclear();
      gripperTurnFinalPos.setpreclear();
      cylPos5ZAxisExtend.setpreclear();
      gripperTurnRetract.setpreclear();
      gripperTurnExtend.setpreclear();
      capGripperPos5Extend.setpreclear();
      cylClampBottleExtend.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos4.getStatus() ? bottleAtPos4.setprepresent() : bottleAtPos4.setpreclear();
      bottleAtPos4.setpreval(bottleAtPos4.getValue());
      bottleAtPos4.setClear();
      dummyint = gripperZAxisLowered.getStatus() ? gripperZAxisLowered.setprepresent() : gripperZAxisLowered.setpreclear();
      gripperZAxisLowered.setpreval(gripperZAxisLowered.getValue());
      gripperZAxisLowered.setClear();
      dummyint = gripperZAxisLifted.getStatus() ? gripperZAxisLifted.setprepresent() : gripperZAxisLifted.setpreclear();
      gripperZAxisLifted.setpreval(gripperZAxisLifted.getValue());
      gripperZAxisLifted.setClear();
      dummyint = gripperTurnHomePos.getStatus() ? gripperTurnHomePos.setprepresent() : gripperTurnHomePos.setpreclear();
      gripperTurnHomePos.setpreval(gripperTurnHomePos.getValue());
      gripperTurnHomePos.setClear();
      dummyint = gripperTurnFinalPos.getStatus() ? gripperTurnFinalPos.setprepresent() : gripperTurnFinalPos.setpreclear();
      gripperTurnFinalPos.setpreval(gripperTurnFinalPos.getValue());
      gripperTurnFinalPos.setClear();
      cylPos5ZAxisExtend.sethook();
      cylPos5ZAxisExtend.setClear();
      gripperTurnRetract.sethook();
      gripperTurnRetract.setClear();
      gripperTurnExtend.sethook();
      gripperTurnExtend.setClear();
      capGripperPos5Extend.sethook();
      capGripperPos5Extend.setClear();
      cylClampBottleExtend.sethook();
      cylClampBottleExtend.setClear();
      if(paused[3]!=0 || suspended[3]!=0 || active[3]!=1);
      else{
        bottleAtPos4.gethook();
        gripperZAxisLowered.gethook();
        gripperZAxisLifted.gethook();
        gripperTurnHomePos.gethook();
        gripperTurnFinalPos.gethook();
      }
      runFinisher();
      if(active[3] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
