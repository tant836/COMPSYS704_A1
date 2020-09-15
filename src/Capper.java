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
  
  private int[] ends = new int[22];
  private int[] tdone = new int[22];
  
  public void thread1649(int [] tdone, int [] ends){
        switch(S280){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        gripperTurnRetract.setPresent();//sysj\controller.sysj line: 104, column: 5
        currsigs.addElement(gripperTurnRetract);
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread1648(int [] tdone, int [] ends){
        switch(S275){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 100, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread1647(int [] tdone, int [] ends){
        switch(S270){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 96, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread1645(int [] tdone, int [] ends){
        S280=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 104, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread1644(int [] tdone, int [] ends){
        S275=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 100, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1643(int [] tdone, int [] ends){
        S270=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 96, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread1641(int [] tdone, int [] ends){
        switch(S222){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 90, column: 5
        currsigs.addElement(gripperTurnExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread1640(int [] tdone, int [] ends){
        switch(S217){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 86, column: 5
        currsigs.addElement(capGripperPos5Extend);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread1639(int [] tdone, int [] ends){
        switch(S212){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 82, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread1638(int [] tdone, int [] ends){
        switch(S207){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 78, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread1636(int [] tdone, int [] ends){
        S280=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 104, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread1635(int [] tdone, int [] ends){
        S275=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 100, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1634(int [] tdone, int [] ends){
        S270=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 96, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread1632(int [] tdone, int [] ends){
        S222=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 90, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1631(int [] tdone, int [] ends){
        S217=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 86, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1630(int [] tdone, int [] ends){
        S212=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 82, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1629(int [] tdone, int [] ends){
        S207=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 78, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1627(int [] tdone, int [] ends){
        switch(S190){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 72, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread1626(int [] tdone, int [] ends){
        switch(S185){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 68, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread1624(int [] tdone, int [] ends){
        S222=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 90, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1623(int [] tdone, int [] ends){
        S217=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 86, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1622(int [] tdone, int [] ends){
        S212=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 82, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1621(int [] tdone, int [] ends){
        S207=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 78, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1619(int [] tdone, int [] ends){
        S190=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 72, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1618(int [] tdone, int [] ends){
        S185=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 68, column: 5
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
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 65, column: 9
                S180=2;
                thread1618(tdone,ends);
                thread1619(tdone,ends);
                int biggest1620 = 0;
                if(ends[4]>=biggest1620){
                  biggest1620=ends[4];
                }
                if(ends[5]>=biggest1620){
                  biggest1620=ends[5];
                }
                if(biggest1620 == 1){
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
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 66, column: 9
                S180=3;
                thread1621(tdone,ends);
                thread1622(tdone,ends);
                thread1623(tdone,ends);
                thread1624(tdone,ends);
                int biggest1625 = 0;
                if(ends[6]>=biggest1625){
                  biggest1625=ends[6];
                }
                if(ends[7]>=biggest1625){
                  biggest1625=ends[7];
                }
                if(ends[8]>=biggest1625){
                  biggest1625=ends[8];
                }
                if(ends[9]>=biggest1625){
                  biggest1625=ends[9];
                }
                if(biggest1625 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread1626(tdone,ends);
                thread1627(tdone,ends);
                int biggest1628 = 0;
                if(ends[4]>=biggest1628){
                  biggest1628=ends[4];
                }
                if(ends[5]>=biggest1628){
                  biggest1628=ends[5];
                }
                if(biggest1628 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1628 == 0){
                  S180=3;
                  thread1629(tdone,ends);
                  thread1630(tdone,ends);
                  thread1631(tdone,ends);
                  thread1632(tdone,ends);
                  int biggest1633 = 0;
                  if(ends[6]>=biggest1633){
                    biggest1633=ends[6];
                  }
                  if(ends[7]>=biggest1633){
                    biggest1633=ends[7];
                  }
                  if(ends[8]>=biggest1633){
                    biggest1633=ends[8];
                  }
                  if(ends[9]>=biggest1633){
                    biggest1633=ends[9];
                  }
                  if(biggest1633 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 76, column: 9
                S180=4;
                thread1634(tdone,ends);
                thread1635(tdone,ends);
                thread1636(tdone,ends);
                int biggest1637 = 0;
                if(ends[10]>=biggest1637){
                  biggest1637=ends[10];
                }
                if(ends[11]>=biggest1637){
                  biggest1637=ends[11];
                }
                if(ends[12]>=biggest1637){
                  biggest1637=ends[12];
                }
                if(biggest1637 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread1638(tdone,ends);
                thread1639(tdone,ends);
                thread1640(tdone,ends);
                thread1641(tdone,ends);
                int biggest1642 = 0;
                if(ends[6]>=biggest1642){
                  biggest1642=ends[6];
                }
                if(ends[7]>=biggest1642){
                  biggest1642=ends[7];
                }
                if(ends[8]>=biggest1642){
                  biggest1642=ends[8];
                }
                if(ends[9]>=biggest1642){
                  biggest1642=ends[9];
                }
                if(biggest1642 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1642 == 0){
                  S180=4;
                  thread1643(tdone,ends);
                  thread1644(tdone,ends);
                  thread1645(tdone,ends);
                  int biggest1646 = 0;
                  if(ends[10]>=biggest1646){
                    biggest1646=ends[10];
                  }
                  if(ends[11]>=biggest1646){
                    biggest1646=ends[11];
                  }
                  if(ends[12]>=biggest1646){
                    biggest1646=ends[12];
                  }
                  if(biggest1646 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 4 : 
              if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 94, column: 9
                S180=5;
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 109, column: 4
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread1647(tdone,ends);
                thread1648(tdone,ends);
                thread1649(tdone,ends);
                int biggest1650 = 0;
                if(ends[10]>=biggest1650){
                  biggest1650=ends[10];
                }
                if(ends[11]>=biggest1650){
                  biggest1650=ends[11];
                }
                if(ends[12]>=biggest1650){
                  biggest1650=ends[12];
                }
                if(biggest1650 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1650 == 0){
                  S180=5;
                  cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 109, column: 4
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              if(gripperZAxisLifted.getprestatus()){//sysj\controller.sysj line: 108, column: 9
                doneAtPos4.setPresent();//sysj\controller.sysj line: 112, column: 3
                currsigs.addElement(doneAtPos4);
                S180=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 109, column: 4
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
