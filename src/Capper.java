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
  public Signal doneAtPos4 = new Signal("doneAtPos4", Signal.OUTPUT);
  private int S647 = 1;
  private int S198 = 1;
  private int S203 = 1;
  private int S208 = 1;
  private int S225 = 1;
  private int S230 = 1;
  private int S235 = 1;
  private int S240 = 1;
  private int S288 = 1;
  private int S293 = 1;
  private int S298 = 1;
  
  private int[] ends = new int[25];
  private int[] tdone = new int[25];
  
  public void thread2880(int [] tdone, int [] ends){
        switch(S298){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        gripperTurnRetract.setPresent();//sysj\controller.sysj line: 106, column: 5
        currsigs.addElement(gripperTurnRetract);
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread2879(int [] tdone, int [] ends){
        switch(S293){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 102, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread2878(int [] tdone, int [] ends){
        switch(S288){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 98, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread2876(int [] tdone, int [] ends){
        S298=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 106, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2875(int [] tdone, int [] ends){
        S293=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 102, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2874(int [] tdone, int [] ends){
        S288=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 98, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread2872(int [] tdone, int [] ends){
        switch(S240){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 92, column: 5
        currsigs.addElement(gripperTurnExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread2871(int [] tdone, int [] ends){
        switch(S235){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 88, column: 5
        currsigs.addElement(capGripperPos5Extend);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread2870(int [] tdone, int [] ends){
        switch(S230){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread2869(int [] tdone, int [] ends){
        switch(S225){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread2867(int [] tdone, int [] ends){
        S298=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 106, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread2866(int [] tdone, int [] ends){
        S293=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 102, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread2865(int [] tdone, int [] ends){
        S288=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 98, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread2863(int [] tdone, int [] ends){
        S240=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 92, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2862(int [] tdone, int [] ends){
        S235=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2861(int [] tdone, int [] ends){
        S230=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2860(int [] tdone, int [] ends){
        S225=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2858(int [] tdone, int [] ends){
        switch(S208){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 74, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread2857(int [] tdone, int [] ends){
        switch(S203){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 70, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread2855(int [] tdone, int [] ends){
        S240=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 92, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread2854(int [] tdone, int [] ends){
        S235=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread2853(int [] tdone, int [] ends){
        S230=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread2852(int [] tdone, int [] ends){
        S225=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread2850(int [] tdone, int [] ends){
        S208=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 74, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2849(int [] tdone, int [] ends){
        S203=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 70, column: 5
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
      switch(S647){
        case 0 : 
          S647=0;
          break RUN;
        
        case 1 : 
          S647=2;
          S647=2;
          S198=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S198){
            case 0 : 
              S198=0;
              S198=1;
              active[3]=1;
              ends[3]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 67, column: 9
                S198=2;
                thread2849(tdone,ends);
                thread2850(tdone,ends);
                int biggest2851 = 0;
                if(ends[4]>=biggest2851){
                  biggest2851=ends[4];
                }
                if(ends[5]>=biggest2851){
                  biggest2851=ends[5];
                }
                if(biggest2851 == 1){
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
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 68, column: 9
                S198=3;
                thread2852(tdone,ends);
                thread2853(tdone,ends);
                thread2854(tdone,ends);
                thread2855(tdone,ends);
                int biggest2856 = 0;
                if(ends[6]>=biggest2856){
                  biggest2856=ends[6];
                }
                if(ends[7]>=biggest2856){
                  biggest2856=ends[7];
                }
                if(ends[8]>=biggest2856){
                  biggest2856=ends[8];
                }
                if(ends[9]>=biggest2856){
                  biggest2856=ends[9];
                }
                if(biggest2856 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread2857(tdone,ends);
                thread2858(tdone,ends);
                int biggest2859 = 0;
                if(ends[4]>=biggest2859){
                  biggest2859=ends[4];
                }
                if(ends[5]>=biggest2859){
                  biggest2859=ends[5];
                }
                if(biggest2859 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2859 == 0){
                  S198=3;
                  thread2860(tdone,ends);
                  thread2861(tdone,ends);
                  thread2862(tdone,ends);
                  thread2863(tdone,ends);
                  int biggest2864 = 0;
                  if(ends[6]>=biggest2864){
                    biggest2864=ends[6];
                  }
                  if(ends[7]>=biggest2864){
                    biggest2864=ends[7];
                  }
                  if(ends[8]>=biggest2864){
                    biggest2864=ends[8];
                  }
                  if(ends[9]>=biggest2864){
                    biggest2864=ends[9];
                  }
                  if(biggest2864 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 78, column: 9
                S198=4;
                thread2865(tdone,ends);
                thread2866(tdone,ends);
                thread2867(tdone,ends);
                int biggest2868 = 0;
                if(ends[10]>=biggest2868){
                  biggest2868=ends[10];
                }
                if(ends[11]>=biggest2868){
                  biggest2868=ends[11];
                }
                if(ends[12]>=biggest2868){
                  biggest2868=ends[12];
                }
                if(biggest2868 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread2869(tdone,ends);
                thread2870(tdone,ends);
                thread2871(tdone,ends);
                thread2872(tdone,ends);
                int biggest2873 = 0;
                if(ends[6]>=biggest2873){
                  biggest2873=ends[6];
                }
                if(ends[7]>=biggest2873){
                  biggest2873=ends[7];
                }
                if(ends[8]>=biggest2873){
                  biggest2873=ends[8];
                }
                if(ends[9]>=biggest2873){
                  biggest2873=ends[9];
                }
                if(biggest2873 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2873 == 0){
                  S198=4;
                  thread2874(tdone,ends);
                  thread2875(tdone,ends);
                  thread2876(tdone,ends);
                  int biggest2877 = 0;
                  if(ends[10]>=biggest2877){
                    biggest2877=ends[10];
                  }
                  if(ends[11]>=biggest2877){
                    biggest2877=ends[11];
                  }
                  if(ends[12]>=biggest2877){
                    biggest2877=ends[12];
                  }
                  if(biggest2877 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 4 : 
              if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 96, column: 9
                S198=5;
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 111, column: 4
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread2878(tdone,ends);
                thread2879(tdone,ends);
                thread2880(tdone,ends);
                int biggest2881 = 0;
                if(ends[10]>=biggest2881){
                  biggest2881=ends[10];
                }
                if(ends[11]>=biggest2881){
                  biggest2881=ends[11];
                }
                if(ends[12]>=biggest2881){
                  biggest2881=ends[12];
                }
                if(biggest2881 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest2881 == 0){
                  S198=5;
                  cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 111, column: 4
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              if(gripperZAxisLifted.getprestatus()){//sysj\controller.sysj line: 110, column: 9
                doneAtPos4.setPresent();//sysj\controller.sysj line: 114, column: 3
                currsigs.addElement(doneAtPos4);
                S198=6;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 111, column: 4
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
            
            case 6 : 
              if(!bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 115, column: 9
                S198=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                active[3]=1;
                ends[3]=1;
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
      doneAtPos4.setpreclear();
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
      doneAtPos4.sethook();
      doneAtPos4.setClear();
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
