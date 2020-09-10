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
  private int S611 = 1;
  private int S168 = 1;
  private int S173 = 1;
  private int S178 = 1;
  private int S195 = 1;
  private int S200 = 1;
  private int S205 = 1;
  private int S210 = 1;
  private int S258 = 1;
  private int S263 = 1;
  private int S268 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread1401(int [] tdone, int [] ends){
        switch(S268){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        gripperTurnRetract.setPresent();//sysj\controller.sysj line: 102, column: 5
        currsigs.addElement(gripperTurnRetract);
        active[12]=1;
        ends[12]=1;
        tdone[12]=1;
        break;
      
    }
  }

  public void thread1400(int [] tdone, int [] ends){
        switch(S263){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 98, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[11]=1;
        ends[11]=1;
        tdone[11]=1;
        break;
      
    }
  }

  public void thread1399(int [] tdone, int [] ends){
        switch(S258){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 94, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[10]=1;
        ends[10]=1;
        tdone[10]=1;
        break;
      
    }
  }

  public void thread1397(int [] tdone, int [] ends){
        S268=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 102, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread1396(int [] tdone, int [] ends){
        S263=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 98, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1395(int [] tdone, int [] ends){
        S258=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 94, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread1393(int [] tdone, int [] ends){
        switch(S210){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        gripperTurnExtend.setPresent();//sysj\controller.sysj line: 88, column: 5
        currsigs.addElement(gripperTurnExtend);
        active[9]=1;
        ends[9]=1;
        tdone[9]=1;
        break;
      
    }
  }

  public void thread1392(int [] tdone, int [] ends){
        switch(S205){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 84, column: 5
        currsigs.addElement(capGripperPos5Extend);
        active[8]=1;
        ends[8]=1;
        tdone[8]=1;
        break;
      
    }
  }

  public void thread1391(int [] tdone, int [] ends){
        switch(S200){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[7]=1;
        ends[7]=1;
        tdone[7]=1;
        break;
      
    }
  }

  public void thread1390(int [] tdone, int [] ends){
        switch(S195){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 76, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
        break;
      
    }
  }

  public void thread1388(int [] tdone, int [] ends){
        S268=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 102, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread1387(int [] tdone, int [] ends){
        S263=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 98, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1386(int [] tdone, int [] ends){
        S258=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 94, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread1384(int [] tdone, int [] ends){
        S210=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1383(int [] tdone, int [] ends){
        S205=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1382(int [] tdone, int [] ends){
        S200=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1381(int [] tdone, int [] ends){
        S195=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 76, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1379(int [] tdone, int [] ends){
        switch(S178){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 70, column: 5
        currsigs.addElement(cylPos5ZAxisExtend);
        active[5]=1;
        ends[5]=1;
        tdone[5]=1;
        break;
      
    }
  }

  public void thread1378(int [] tdone, int [] ends){
        switch(S173){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
        currsigs.addElement(cylClampBottleExtend);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
        break;
      
    }
  }

  public void thread1376(int [] tdone, int [] ends){
        S210=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1375(int [] tdone, int [] ends){
        S205=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1374(int [] tdone, int [] ends){
        S200=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 80, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1373(int [] tdone, int [] ends){
        S195=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 76, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1371(int [] tdone, int [] ends){
        S178=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 70, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1370(int [] tdone, int [] ends){
        S173=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
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
      switch(S611){
        case 0 : 
          S611=0;
          break RUN;
        
        case 1 : 
          S611=2;
          S611=2;
          S168=0;
          active[3]=1;
          ends[3]=1;
          break RUN;
        
        case 2 : 
          switch(S168){
            case 0 : 
              S168=0;
              S168=1;
              active[3]=1;
              ends[3]=1;
              break RUN;
            
            case 1 : 
              if(bottleAtPos4.getprestatus()){//sysj\controller.sysj line: 63, column: 9
                S168=2;
                thread1370(tdone,ends);
                thread1371(tdone,ends);
                int biggest1372 = 0;
                if(ends[4]>=biggest1372){
                  biggest1372=ends[4];
                }
                if(ends[5]>=biggest1372){
                  biggest1372=ends[5];
                }
                if(biggest1372 == 1){
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
              if(gripperZAxisLowered.getprestatus()){//sysj\controller.sysj line: 64, column: 9
                S168=3;
                thread1373(tdone,ends);
                thread1374(tdone,ends);
                thread1375(tdone,ends);
                thread1376(tdone,ends);
                int biggest1377 = 0;
                if(ends[6]>=biggest1377){
                  biggest1377=ends[6];
                }
                if(ends[7]>=biggest1377){
                  biggest1377=ends[7];
                }
                if(ends[8]>=biggest1377){
                  biggest1377=ends[8];
                }
                if(ends[9]>=biggest1377){
                  biggest1377=ends[9];
                }
                if(biggest1377 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread1378(tdone,ends);
                thread1379(tdone,ends);
                int biggest1380 = 0;
                if(ends[4]>=biggest1380){
                  biggest1380=ends[4];
                }
                if(ends[5]>=biggest1380){
                  biggest1380=ends[5];
                }
                if(biggest1380 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1380 == 0){
                  S168=3;
                  thread1381(tdone,ends);
                  thread1382(tdone,ends);
                  thread1383(tdone,ends);
                  thread1384(tdone,ends);
                  int biggest1385 = 0;
                  if(ends[6]>=biggest1385){
                    biggest1385=ends[6];
                  }
                  if(ends[7]>=biggest1385){
                    biggest1385=ends[7];
                  }
                  if(ends[8]>=biggest1385){
                    biggest1385=ends[8];
                  }
                  if(ends[9]>=biggest1385){
                    biggest1385=ends[9];
                  }
                  if(biggest1385 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 74, column: 9
                S168=4;
                thread1386(tdone,ends);
                thread1387(tdone,ends);
                thread1388(tdone,ends);
                int biggest1389 = 0;
                if(ends[10]>=biggest1389){
                  biggest1389=ends[10];
                }
                if(ends[11]>=biggest1389){
                  biggest1389=ends[11];
                }
                if(ends[12]>=biggest1389){
                  biggest1389=ends[12];
                }
                if(biggest1389 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread1390(tdone,ends);
                thread1391(tdone,ends);
                thread1392(tdone,ends);
                thread1393(tdone,ends);
                int biggest1394 = 0;
                if(ends[6]>=biggest1394){
                  biggest1394=ends[6];
                }
                if(ends[7]>=biggest1394){
                  biggest1394=ends[7];
                }
                if(ends[8]>=biggest1394){
                  biggest1394=ends[8];
                }
                if(ends[9]>=biggest1394){
                  biggest1394=ends[9];
                }
                if(biggest1394 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1394 == 0){
                  S168=4;
                  thread1395(tdone,ends);
                  thread1396(tdone,ends);
                  thread1397(tdone,ends);
                  int biggest1398 = 0;
                  if(ends[10]>=biggest1398){
                    biggest1398=ends[10];
                  }
                  if(ends[11]>=biggest1398){
                    biggest1398=ends[11];
                  }
                  if(ends[12]>=biggest1398){
                    biggest1398=ends[12];
                  }
                  if(biggest1398 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 4 : 
              if(gripperTurnHomePos.getprestatus()){//sysj\controller.sysj line: 92, column: 9
                S168=5;
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 107, column: 4
                currsigs.addElement(cylClampBottleExtend);
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                thread1399(tdone,ends);
                thread1400(tdone,ends);
                thread1401(tdone,ends);
                int biggest1402 = 0;
                if(ends[10]>=biggest1402){
                  biggest1402=ends[10];
                }
                if(ends[11]>=biggest1402){
                  biggest1402=ends[11];
                }
                if(ends[12]>=biggest1402){
                  biggest1402=ends[12];
                }
                if(biggest1402 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1402 == 0){
                  S168=5;
                  cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 107, column: 4
                  currsigs.addElement(cylClampBottleExtend);
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
            
            case 5 : 
              if(gripperZAxisLifted.getprestatus()){//sysj\controller.sysj line: 106, column: 9
                doneAtPos4.setPresent();//sysj\controller.sysj line: 110, column: 3
                currsigs.addElement(doneAtPos4);
                S168=0;
                active[3]=1;
                ends[3]=1;
                break RUN;
              }
              else {
                cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 107, column: 4
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
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
