import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import org.compsys704.FIFO;//sysj\controller.sysj line: 1, column: 2

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
  private int S623 = 1;
  private int S180 = 1;
  private int S185 = 1;
  private int S190 = 1;
  private int S207 = 1;
  private int S212 = 1;
  private int S217 = 1;
  private int S222 = 1;
  private int S270 = 1;
  private int S275 = 1;
  private int S280 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread7052(int [] tdone, int [] ends){
        switch(S280){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        gripperTurnRetract.setPresent();//sysj\controller.sysj line: 105, column: 5
        currsigs.addElement(gripperTurnRetract);
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread7051(int [] tdone, int [] ends){
        switch(S275){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 101, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread7050(int [] tdone, int [] ends){
        switch(S270){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 97, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread7048(int [] tdone, int [] ends){
        S280=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 105, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread7047(int [] tdone, int [] ends){
        S275=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 101, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread7046(int [] tdone, int [] ends){
        S270=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 97, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread7044(int [] tdone, int [] ends){
        switch(S222){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 91, column: 5
        currsigs.addElement(gripperTurnExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread7043(int [] tdone, int [] ends){
        switch(S217){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 87, column: 5
        currsigs.addElement(capGripperPos5Extend);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread7042(int [] tdone, int [] ends){
        switch(S212){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 83, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread7041(int [] tdone, int [] ends){
        switch(S207){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 79, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread7039(int [] tdone, int [] ends){
        S280=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 105, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread7038(int [] tdone, int [] ends){
        S275=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 101, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread7037(int [] tdone, int [] ends){
        S270=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 97, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread7035(int [] tdone, int [] ends){
        S222=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 91, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread7034(int [] tdone, int [] ends){
        S217=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 87, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread7033(int [] tdone, int [] ends){
        S212=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 83, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread7032(int [] tdone, int [] ends){
        S207=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 79, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread7030(int [] tdone, int [] ends){
        switch(S190){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 73, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread7029(int [] tdone, int [] ends){
        switch(S185){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 69, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread7027(int [] tdone, int [] ends){
        S222=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 91, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread7026(int [] tdone, int [] ends){
        S217=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 87, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread7025(int [] tdone, int [] ends){
        S212=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 83, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread7024(int [] tdone, int [] ends){
        S207=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 79, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread7022(int [] tdone, int [] ends){
        S190=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 73, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread7021(int [] tdone, int [] ends){
        S185=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 69, column: 5
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
      switch(S623){
        case 0 : 
          S623=0;
          break RUN;
        
        case 1 : 
          S623=2;
          S623=2;
          S180=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S180){
            case 0 : 
              S180=0;
              S180=1;
              active[3]=1;
              ends[3]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 66, column: 9
                S180=2;
                thread7021(tdone,ends);
                thread7022(tdone,ends);
                int biggest7023 = 0;
                if(ends[4]>=biggest7023){
                  biggest7023=ends[4];
                }
                if(ends[5]>=biggest7023){
                  biggest7023=ends[5];
                }
                if(biggest7023 == 1){
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
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 67, column: 9
                S180=3;
                thread7024(tdone,ends);
                thread7025(tdone,ends);
                thread7026(tdone,ends);
                thread7027(tdone,ends);
                int biggest7028 = 0;
                if(ends[6]>=biggest7028){
                  biggest7028=ends[6];
                }
                if(ends[7]>=biggest7028){
                  biggest7028=ends[7];
                }
                if(ends[8]>=biggest7028){
                  biggest7028=ends[8];
                }
                if(ends[9]>=biggest7028){
                  biggest7028=ends[9];
                }
                if(biggest7028 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread7029(tdone,ends);
                thread7030(tdone,ends);
                int biggest7031 = 0;
                if(ends[4]>=biggest7031){
                  biggest7031=ends[4];
                }
                if(ends[5]>=biggest7031){
                  biggest7031=ends[5];
                }
                if(biggest7031 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest7031 == 0){
                  S180=3;
                  thread7032(tdone,ends);
                  thread7033(tdone,ends);
                  thread7034(tdone,ends);
                  thread7035(tdone,ends);
                  int biggest7036 = 0;
                  if(ends[6]>=biggest7036){
                    biggest7036=ends[6];
                  }
                  if(ends[7]>=biggest7036){
                    biggest7036=ends[7];
                  }
                  if(ends[8]>=biggest7036){
                    biggest7036=ends[8];
                  }
                  if(ends[9]>=biggest7036){
                    biggest7036=ends[9];
                  }
                  if(biggest7036 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 77, column: 9
                S180=4;
                thread7037(tdone,ends);
                thread7038(tdone,ends);
                thread7039(tdone,ends);
                int biggest7040 = 0;
                if(ends[10]>=biggest7040){
                  biggest7040=ends[10];
                }
                if(ends[11]>=biggest7040){
                  biggest7040=ends[11];
                }
                if(ends[12]>=biggest7040){
                  biggest7040=ends[12];
                }
                if(biggest7040 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread7041(tdone,ends);
                thread7042(tdone,ends);
                thread7043(tdone,ends);
                thread7044(tdone,ends);
                int biggest7045 = 0;
                if(ends[6]>=biggest7045){
                  biggest7045=ends[6];
                }
                if(ends[7]>=biggest7045){
                  biggest7045=ends[7];
                }
                if(ends[8]>=biggest7045){
                  biggest7045=ends[8];
                }
                if(ends[9]>=biggest7045){
                  biggest7045=ends[9];
                }
                if(biggest7045 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest7045 == 0){
                  S180=4;
                  thread7046(tdone,ends);
                  thread7047(tdone,ends);
                  thread7048(tdone,ends);
                  int biggest7049 = 0;
                  if(ends[10]>=biggest7049){
                    biggest7049=ends[10];
                  }
                  if(ends[11]>=biggest7049){
                    biggest7049=ends[11];
                  }
                  if(ends[12]>=biggest7049){
                    biggest7049=ends[12];
                  }
                  if(biggest7049 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 4 : 
              if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 95, column: 9
                S180=5;
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 110, column: 4
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread7050(tdone,ends);
                thread7051(tdone,ends);
                thread7052(tdone,ends);
                int biggest7053 = 0;
                if(ends[10]>=biggest7053){
                  biggest7053=ends[10];
                }
                if(ends[11]>=biggest7053){
                  biggest7053=ends[11];
                }
                if(ends[12]>=biggest7053){
                  biggest7053=ends[12];
                }
                if(biggest7053 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest7053 == 0){
                  S180=5;
                  cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 110, column: 4
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              if(gripperZAxisLifted.getprestatus()){//sysj\controller.sysj line: 109, column: 9
                doneAtPos4.setPresent();//sysj\controller.sysj line: 113, column: 3
                currsigs.addElement(doneAtPos4);
                S180=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 110, column: 4
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
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
