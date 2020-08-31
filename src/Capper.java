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
  private int S667 = 1;
  private int S224 = 1;
  private int S229 = 1;
  private int S234 = 1;
  private int S251 = 1;
  private int S256 = 1;
  private int S261 = 1;
  private int S266 = 1;
  private int S314 = 1;
  private int S319 = 1;
  private int S324 = 1;
  
  private int[] ends = new int[18];
  private int[] tdone = new int[18];
  
  public void thread942(int [] tdone, int [] ends){
        switch(S324){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        gripperTurnRetract.setPresent();//sysj\controller.sysj line: 94, column: 5
        currsigs.addElement(gripperTurnRetract);
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread941(int [] tdone, int [] ends){
        switch(S319){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 90, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread940(int [] tdone, int [] ends){
        switch(S314){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 86, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread938(int [] tdone, int [] ends){
        S324=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 94, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread937(int [] tdone, int [] ends){
        S319=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 90, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread936(int [] tdone, int [] ends){
        S314=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 86, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread934(int [] tdone, int [] ends){
        switch(S266){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
        currsigs.addElement(gripperTurnExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread933(int [] tdone, int [] ends){
        switch(S261){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 76, column: 5
        currsigs.addElement(capGripperPos5Extend);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread932(int [] tdone, int [] ends){
        switch(S256){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 72, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread931(int [] tdone, int [] ends){
        switch(S251){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 68, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread929(int [] tdone, int [] ends){
        S324=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 94, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread928(int [] tdone, int [] ends){
        S319=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 90, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread927(int [] tdone, int [] ends){
        S314=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 86, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread925(int [] tdone, int [] ends){
        S266=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread924(int [] tdone, int [] ends){
        S261=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 76, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread923(int [] tdone, int [] ends){
        S256=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 72, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread922(int [] tdone, int [] ends){
        S251=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 68, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread920(int [] tdone, int [] ends){
        switch(S234){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 62, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread919(int [] tdone, int [] ends){
        switch(S229){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 58, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread917(int [] tdone, int [] ends){
        S266=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread916(int [] tdone, int [] ends){
        S261=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 76, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread915(int [] tdone, int [] ends){
        S256=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 72, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread914(int [] tdone, int [] ends){
        S251=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 68, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread912(int [] tdone, int [] ends){
        S234=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 62, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread911(int [] tdone, int [] ends){
        S229=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 58, column: 5
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
      switch(S667){
        case 0 : 
          S667=0;
          break RUN;
        
        case 1 : 
          S667=2;
          S667=2;
          S224=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S224){
            case 0 : 
              S224=0;
              S224=1;
              active[3]=1;
              ends[3]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 55, column: 9
                S224=2;
                thread911(tdone,ends);
                thread912(tdone,ends);
                int biggest913 = 0;
                if(ends[4]>=biggest913){
                  biggest913=ends[4];
                }
                if(ends[5]>=biggest913){
                  biggest913=ends[5];
                }
                if(biggest913 == 1){
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
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 56, column: 9
                S224=3;
                thread914(tdone,ends);
                thread915(tdone,ends);
                thread916(tdone,ends);
                thread917(tdone,ends);
                int biggest918 = 0;
                if(ends[6]>=biggest918){
                  biggest918=ends[6];
                }
                if(ends[7]>=biggest918){
                  biggest918=ends[7];
                }
                if(ends[8]>=biggest918){
                  biggest918=ends[8];
                }
                if(ends[9]>=biggest918){
                  biggest918=ends[9];
                }
                if(biggest918 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread919(tdone,ends);
                thread920(tdone,ends);
                int biggest921 = 0;
                if(ends[4]>=biggest921){
                  biggest921=ends[4];
                }
                if(ends[5]>=biggest921){
                  biggest921=ends[5];
                }
                if(biggest921 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest921 == 0){
                  S224=3;
                  thread922(tdone,ends);
                  thread923(tdone,ends);
                  thread924(tdone,ends);
                  thread925(tdone,ends);
                  int biggest926 = 0;
                  if(ends[6]>=biggest926){
                    biggest926=ends[6];
                  }
                  if(ends[7]>=biggest926){
                    biggest926=ends[7];
                  }
                  if(ends[8]>=biggest926){
                    biggest926=ends[8];
                  }
                  if(ends[9]>=biggest926){
                    biggest926=ends[9];
                  }
                  if(biggest926 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 66, column: 9
                S224=4;
                thread927(tdone,ends);
                thread928(tdone,ends);
                thread929(tdone,ends);
                int biggest930 = 0;
                if(ends[10]>=biggest930){
                  biggest930=ends[10];
                }
                if(ends[11]>=biggest930){
                  biggest930=ends[11];
                }
                if(ends[12]>=biggest930){
                  biggest930=ends[12];
                }
                if(biggest930 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread931(tdone,ends);
                thread932(tdone,ends);
                thread933(tdone,ends);
                thread934(tdone,ends);
                int biggest935 = 0;
                if(ends[6]>=biggest935){
                  biggest935=ends[6];
                }
                if(ends[7]>=biggest935){
                  biggest935=ends[7];
                }
                if(ends[8]>=biggest935){
                  biggest935=ends[8];
                }
                if(ends[9]>=biggest935){
                  biggest935=ends[9];
                }
                if(biggest935 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest935 == 0){
                  S224=4;
                  thread936(tdone,ends);
                  thread937(tdone,ends);
                  thread938(tdone,ends);
                  int biggest939 = 0;
                  if(ends[10]>=biggest939){
                    biggest939=ends[10];
                  }
                  if(ends[11]>=biggest939){
                    biggest939=ends[11];
                  }
                  if(ends[12]>=biggest939){
                    biggest939=ends[12];
                  }
                  if(biggest939 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 4 : 
              if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 84, column: 9
                S224=5;
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 99, column: 4
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread940(tdone,ends);
                thread941(tdone,ends);
                thread942(tdone,ends);
                int biggest943 = 0;
                if(ends[10]>=biggest943){
                  biggest943=ends[10];
                }
                if(ends[11]>=biggest943){
                  biggest943=ends[11];
                }
                if(ends[12]>=biggest943){
                  biggest943=ends[12];
                }
                if(biggest943 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest943 == 0){
                  S224=5;
                  cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 99, column: 4
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              if(gripperZAxisLifted.getprestatus()){//sysj\controller.sysj line: 98, column: 9
                S224=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 99, column: 4
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
