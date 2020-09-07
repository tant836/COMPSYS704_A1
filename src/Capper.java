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
  private int S551 = 1;
  private int S108 = 1;
  private int S113 = 1;
  private int S118 = 1;
  private int S135 = 1;
  private int S140 = 1;
  private int S145 = 1;
  private int S150 = 1;
  private int S198 = 1;
  private int S203 = 1;
  private int S208 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread826(int [] tdone, int [] ends){
        switch(S208){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        gripperTurnRetract.setPresent();//sysj\controller.sysj line: 92, column: 5
        currsigs.addElement(gripperTurnRetract);
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread825(int [] tdone, int [] ends){
        switch(S203){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 88, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread824(int [] tdone, int [] ends){
        switch(S198){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread822(int [] tdone, int [] ends){
        S208=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 92, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread821(int [] tdone, int [] ends){
        S203=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread820(int [] tdone, int [] ends){
        S198=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread818(int [] tdone, int [] ends){
        switch(S150){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 78, column: 5
        currsigs.addElement(gripperTurnExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread817(int [] tdone, int [] ends){
        switch(S145){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 74, column: 5
        currsigs.addElement(capGripperPos5Extend);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread816(int [] tdone, int [] ends){
        switch(S140){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 70, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread815(int [] tdone, int [] ends){
        switch(S135){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread813(int [] tdone, int [] ends){
        S208=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 92, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread812(int [] tdone, int [] ends){
        S203=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread811(int [] tdone, int [] ends){
        S198=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread809(int [] tdone, int [] ends){
        S150=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 78, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread808(int [] tdone, int [] ends){
        S145=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 74, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread807(int [] tdone, int [] ends){
        S140=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 70, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread806(int [] tdone, int [] ends){
        S135=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread804(int [] tdone, int [] ends){
        switch(S118){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 60, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread803(int [] tdone, int [] ends){
        switch(S113){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 56, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread801(int [] tdone, int [] ends){
        S150=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 78, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread800(int [] tdone, int [] ends){
        S145=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 74, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread799(int [] tdone, int [] ends){
        S140=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 70, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread798(int [] tdone, int [] ends){
        S135=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread796(int [] tdone, int [] ends){
        S118=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 60, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread795(int [] tdone, int [] ends){
        S113=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 56, column: 5
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
      switch(S551){
        case 0 : 
          S551=0;
          break RUN;
        
        case 1 : 
          S551=2;
          S551=2;
          S108=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S108){
            case 0 : 
              S108=0;
              S108=1;
              active[3]=1;
              ends[3]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 53, column: 9
                S108=2;
                thread795(tdone,ends);
                thread796(tdone,ends);
                int biggest797 = 0;
                if(ends[4]>=biggest797){
                  biggest797=ends[4];
                }
                if(ends[5]>=biggest797){
                  biggest797=ends[5];
                }
                if(biggest797 == 1){
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
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 54, column: 9
                S108=3;
                thread798(tdone,ends);
                thread799(tdone,ends);
                thread800(tdone,ends);
                thread801(tdone,ends);
                int biggest802 = 0;
                if(ends[6]>=biggest802){
                  biggest802=ends[6];
                }
                if(ends[7]>=biggest802){
                  biggest802=ends[7];
                }
                if(ends[8]>=biggest802){
                  biggest802=ends[8];
                }
                if(ends[9]>=biggest802){
                  biggest802=ends[9];
                }
                if(biggest802 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread803(tdone,ends);
                thread804(tdone,ends);
                int biggest805 = 0;
                if(ends[4]>=biggest805){
                  biggest805=ends[4];
                }
                if(ends[5]>=biggest805){
                  biggest805=ends[5];
                }
                if(biggest805 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest805 == 0){
                  S108=3;
                  thread806(tdone,ends);
                  thread807(tdone,ends);
                  thread808(tdone,ends);
                  thread809(tdone,ends);
                  int biggest810 = 0;
                  if(ends[6]>=biggest810){
                    biggest810=ends[6];
                  }
                  if(ends[7]>=biggest810){
                    biggest810=ends[7];
                  }
                  if(ends[8]>=biggest810){
                    biggest810=ends[8];
                  }
                  if(ends[9]>=biggest810){
                    biggest810=ends[9];
                  }
                  if(biggest810 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 64, column: 9
                S108=4;
                thread811(tdone,ends);
                thread812(tdone,ends);
                thread813(tdone,ends);
                int biggest814 = 0;
                if(ends[10]>=biggest814){
                  biggest814=ends[10];
                }
                if(ends[11]>=biggest814){
                  biggest814=ends[11];
                }
                if(ends[12]>=biggest814){
                  biggest814=ends[12];
                }
                if(biggest814 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread815(tdone,ends);
                thread816(tdone,ends);
                thread817(tdone,ends);
                thread818(tdone,ends);
                int biggest819 = 0;
                if(ends[6]>=biggest819){
                  biggest819=ends[6];
                }
                if(ends[7]>=biggest819){
                  biggest819=ends[7];
                }
                if(ends[8]>=biggest819){
                  biggest819=ends[8];
                }
                if(ends[9]>=biggest819){
                  biggest819=ends[9];
                }
                if(biggest819 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest819 == 0){
                  S108=4;
                  thread820(tdone,ends);
                  thread821(tdone,ends);
                  thread822(tdone,ends);
                  int biggest823 = 0;
                  if(ends[10]>=biggest823){
                    biggest823=ends[10];
                  }
                  if(ends[11]>=biggest823){
                    biggest823=ends[11];
                  }
                  if(ends[12]>=biggest823){
                    biggest823=ends[12];
                  }
                  if(biggest823 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 4 : 
              if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 82, column: 9
                S108=5;
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 97, column: 4
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread824(tdone,ends);
                thread825(tdone,ends);
                thread826(tdone,ends);
                int biggest827 = 0;
                if(ends[10]>=biggest827){
                  biggest827=ends[10];
                }
                if(ends[11]>=biggest827){
                  biggest827=ends[11];
                }
                if(ends[12]>=biggest827){
                  biggest827=ends[12];
                }
                if(biggest827 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest827 == 0){
                  S108=5;
                  cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 97, column: 4
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              if(gripperZAxisLifted.getprestatus()){//sysj\controller.sysj line: 96, column: 9
                S108=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 97, column: 4
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
