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
  private int S564 = 1;
  private int S121 = 1;
  private int S126 = 1;
  private int S131 = 1;
  private int S148 = 1;
  private int S153 = 1;
  private int S158 = 1;
  private int S163 = 1;
  private int S211 = 1;
  private int S216 = 1;
  private int S221 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread839(int [] tdone, int [] ends){
        switch(S221){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        gripperTurnRetract.setPresent();//sysj\controller.sysj line: 93, column: 5
        currsigs.addElement(gripperTurnRetract);
        System.out.println("Emitted gripperTurnRetract");
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread838(int [] tdone, int [] ends){
        switch(S216){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 89, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        System.out.println("Emitted cylPos5ZAxisExtend");
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread837(int [] tdone, int [] ends){
        switch(S211){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 85, column: 5
        currsigs.addElement(cylClampBottleExtend);
        System.out.println("Emitted cylClampBottleExtend");
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread835(int [] tdone, int [] ends){
        S221=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 93, column: 5
    currsigs.addElement(gripperTurnRetract);
    System.out.println("Emitted gripperTurnRetract");
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread834(int [] tdone, int [] ends){
        S216=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 89, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    System.out.println("Emitted cylPos5ZAxisExtend");
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread833(int [] tdone, int [] ends){
        S211=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 85, column: 5
    currsigs.addElement(cylClampBottleExtend);
    System.out.println("Emitted cylClampBottleExtend");
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread831(int [] tdone, int [] ends){
        switch(S163){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 79, column: 5
        currsigs.addElement(gripperTurnExtend);
        System.out.println("Emitted gripperTurnExtend");
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread830(int [] tdone, int [] ends){
        switch(S158){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 75, column: 5
        currsigs.addElement(capGripperPos5Extend);
        System.out.println("Emitted capGripperPos5Extend");
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread829(int [] tdone, int [] ends){
        switch(S153){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 71, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        System.out.println("Emitted cylPos5ZAxisExtend");
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread828(int [] tdone, int [] ends){
        switch(S148){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 67, column: 5
        currsigs.addElement(cylClampBottleExtend);
        System.out.println("Emitted cylClampBottleExtend");
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread826(int [] tdone, int [] ends){
        S221=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 93, column: 5
    currsigs.addElement(gripperTurnRetract);
    System.out.println("Emitted gripperTurnRetract");
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread825(int [] tdone, int [] ends){
        S216=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 89, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    System.out.println("Emitted cylPos5ZAxisExtend");
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread824(int [] tdone, int [] ends){
        S211=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 85, column: 5
    currsigs.addElement(cylClampBottleExtend);
    System.out.println("Emitted cylClampBottleExtend");
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread822(int [] tdone, int [] ends){
        S163=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 79, column: 5
    currsigs.addElement(gripperTurnExtend);
    System.out.println("Emitted gripperTurnExtend");
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread821(int [] tdone, int [] ends){
        S158=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 75, column: 5
    currsigs.addElement(capGripperPos5Extend);
    System.out.println("Emitted capGripperPos5Extend");
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread820(int [] tdone, int [] ends){
        S153=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 71, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    System.out.println("Emitted cylPos5ZAxisExtend");
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread819(int [] tdone, int [] ends){
        S148=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 67, column: 5
    currsigs.addElement(cylClampBottleExtend);
    System.out.println("Emitted cylClampBottleExtend");
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread817(int [] tdone, int [] ends){
        switch(S131){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 61, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        System.out.println("Emitted cylPos5ZAxisExtend");
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread816(int [] tdone, int [] ends){
        switch(S126){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 57, column: 5
        currsigs.addElement(cylClampBottleExtend);
        System.out.println("Emitted cylClampBottleExtend");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread814(int [] tdone, int [] ends){
        S163=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 79, column: 5
    currsigs.addElement(gripperTurnExtend);
    System.out.println("Emitted gripperTurnExtend");
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread813(int [] tdone, int [] ends){
        S158=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 75, column: 5
    currsigs.addElement(capGripperPos5Extend);
    System.out.println("Emitted capGripperPos5Extend");
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread812(int [] tdone, int [] ends){
        S153=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 71, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    System.out.println("Emitted cylPos5ZAxisExtend");
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread811(int [] tdone, int [] ends){
        S148=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 67, column: 5
    currsigs.addElement(cylClampBottleExtend);
    System.out.println("Emitted cylClampBottleExtend");
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread809(int [] tdone, int [] ends){
        S131=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 61, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    System.out.println("Emitted cylPos5ZAxisExtend");
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread808(int [] tdone, int [] ends){
        S126=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 57, column: 5
    currsigs.addElement(cylClampBottleExtend);
    System.out.println("Emitted cylClampBottleExtend");
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
      switch(S564){
        case 0 : 
          S564=0;
          break RUN;
        
        case 1 : 
          S564=2;
          S564=2;
          S121=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S121){
            case 0 : 
              S121=0;
              S121=1;
              active[3]=1;
              ends[3]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 54, column: 9
                S121=2;
                thread808(tdone,ends);
                thread809(tdone,ends);
                int biggest810 = 0;
                if(ends[4]>=biggest810){
                  biggest810=ends[4];
                }
                if(ends[5]>=biggest810){
                  biggest810=ends[5];
                }
                if(biggest810 == 1){
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
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 55, column: 9
                S121=3;
                thread811(tdone,ends);
                thread812(tdone,ends);
                thread813(tdone,ends);
                thread814(tdone,ends);
                int biggest815 = 0;
                if(ends[6]>=biggest815){
                  biggest815=ends[6];
                }
                if(ends[7]>=biggest815){
                  biggest815=ends[7];
                }
                if(ends[8]>=biggest815){
                  biggest815=ends[8];
                }
                if(ends[9]>=biggest815){
                  biggest815=ends[9];
                }
                if(biggest815 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread816(tdone,ends);
                thread817(tdone,ends);
                int biggest818 = 0;
                if(ends[4]>=biggest818){
                  biggest818=ends[4];
                }
                if(ends[5]>=biggest818){
                  biggest818=ends[5];
                }
                if(biggest818 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest818 == 0){
                  S121=3;
                  thread819(tdone,ends);
                  thread820(tdone,ends);
                  thread821(tdone,ends);
                  thread822(tdone,ends);
                  int biggest823 = 0;
                  if(ends[6]>=biggest823){
                    biggest823=ends[6];
                  }
                  if(ends[7]>=biggest823){
                    biggest823=ends[7];
                  }
                  if(ends[8]>=biggest823){
                    biggest823=ends[8];
                  }
                  if(ends[9]>=biggest823){
                    biggest823=ends[9];
                  }
                  if(biggest823 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 65, column: 9
                S121=4;
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
              }
              else {
                thread828(tdone,ends);
                thread829(tdone,ends);
                thread830(tdone,ends);
                thread831(tdone,ends);
                int biggest832 = 0;
                if(ends[6]>=biggest832){
                  biggest832=ends[6];
                }
                if(ends[7]>=biggest832){
                  biggest832=ends[7];
                }
                if(ends[8]>=biggest832){
                  biggest832=ends[8];
                }
                if(ends[9]>=biggest832){
                  biggest832=ends[9];
                }
                if(biggest832 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest832 == 0){
                  S121=4;
                  thread833(tdone,ends);
                  thread834(tdone,ends);
                  thread835(tdone,ends);
                  int biggest836 = 0;
                  if(ends[10]>=biggest836){
                    biggest836=ends[10];
                  }
                  if(ends[11]>=biggest836){
                    biggest836=ends[11];
                  }
                  if(ends[12]>=biggest836){
                    biggest836=ends[12];
                  }
                  if(biggest836 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 4 : 
              if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 83, column: 9
                S121=5;
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 98, column: 4
                currsigs.addElement(cylClampBottleExtend);
                System.out.println("Emitted cylClampBottleExtend");
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread837(tdone,ends);
                thread838(tdone,ends);
                thread839(tdone,ends);
                int biggest840 = 0;
                if(ends[10]>=biggest840){
                  biggest840=ends[10];
                }
                if(ends[11]>=biggest840){
                  biggest840=ends[11];
                }
                if(ends[12]>=biggest840){
                  biggest840=ends[12];
                }
                if(biggest840 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest840 == 0){
                  S121=5;
                  cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 98, column: 4
                  currsigs.addElement(cylClampBottleExtend);
                  System.out.println("Emitted cylClampBottleExtend");
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              if(gripperZAxisLifted.getprestatus()){//sysj\controller.sysj line: 97, column: 9
                S121=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 98, column: 4
                currsigs.addElement(cylClampBottleExtend);
                System.out.println("Emitted cylClampBottleExtend");
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
