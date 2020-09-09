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
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread1341(int [] tdone, int [] ends){
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

  public void thread1340(int [] tdone, int [] ends){
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

  public void thread1339(int [] tdone, int [] ends){
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

  public void thread1337(int [] tdone, int [] ends){
        S208=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 92, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread1336(int [] tdone, int [] ends){
        S203=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1335(int [] tdone, int [] ends){
        S198=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread1333(int [] tdone, int [] ends){
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

  public void thread1332(int [] tdone, int [] ends){
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

  public void thread1331(int [] tdone, int [] ends){
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

  public void thread1330(int [] tdone, int [] ends){
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

  public void thread1328(int [] tdone, int [] ends){
        S208=1;
    gripperTurnRetract.setPresent();//sysj\controller.sysj line: 92, column: 5
    currsigs.addElement(gripperTurnRetract);
    active[12]=1;
    ends[12]=1;
    tdone[12]=1;
  }

  public void thread1327(int [] tdone, int [] ends){
        S203=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 88, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[11]=1;
    ends[11]=1;
    tdone[11]=1;
  }

  public void thread1326(int [] tdone, int [] ends){
        S198=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 84, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[10]=1;
    ends[10]=1;
    tdone[10]=1;
  }

  public void thread1324(int [] tdone, int [] ends){
        S150=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 78, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1323(int [] tdone, int [] ends){
        S145=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 74, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1322(int [] tdone, int [] ends){
        S140=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 70, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1321(int [] tdone, int [] ends){
        S135=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1319(int [] tdone, int [] ends){
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

  public void thread1318(int [] tdone, int [] ends){
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

  public void thread1316(int [] tdone, int [] ends){
        S150=1;
    gripperTurnExtend.setPresent();//sysj\controller.sysj line: 78, column: 5
    currsigs.addElement(gripperTurnExtend);
    active[9]=1;
    ends[9]=1;
    tdone[9]=1;
  }

  public void thread1315(int [] tdone, int [] ends){
        S145=1;
    capGripperPos5Extend.setPresent();//sysj\controller.sysj line: 74, column: 5
    currsigs.addElement(capGripperPos5Extend);
    active[8]=1;
    ends[8]=1;
    tdone[8]=1;
  }

  public void thread1314(int [] tdone, int [] ends){
        S140=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 70, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[7]=1;
    ends[7]=1;
    tdone[7]=1;
  }

  public void thread1313(int [] tdone, int [] ends){
        S135=1;
    cylClampBottleExtend.setPresent();//sysj\controller.sysj line: 66, column: 5
    currsigs.addElement(cylClampBottleExtend);
    active[6]=1;
    ends[6]=1;
    tdone[6]=1;
  }

  public void thread1311(int [] tdone, int [] ends){
        S118=1;
    cylPos5ZAxisExtend.setPresent();//sysj\controller.sysj line: 60, column: 5
    currsigs.addElement(cylPos5ZAxisExtend);
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1310(int [] tdone, int [] ends){
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
                thread1310(tdone,ends);
                thread1311(tdone,ends);
                int biggest1312 = 0;
                if(ends[4]>=biggest1312){
                  biggest1312=ends[4];
                }
                if(ends[5]>=biggest1312){
                  biggest1312=ends[5];
                }
                if(biggest1312 == 1){
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
                thread1313(tdone,ends);
                thread1314(tdone,ends);
                thread1315(tdone,ends);
                thread1316(tdone,ends);
                int biggest1317 = 0;
                if(ends[6]>=biggest1317){
                  biggest1317=ends[6];
                }
                if(ends[7]>=biggest1317){
                  biggest1317=ends[7];
                }
                if(ends[8]>=biggest1317){
                  biggest1317=ends[8];
                }
                if(ends[9]>=biggest1317){
                  biggest1317=ends[9];
                }
                if(biggest1317 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread1318(tdone,ends);
                thread1319(tdone,ends);
                int biggest1320 = 0;
                if(ends[4]>=biggest1320){
                  biggest1320=ends[4];
                }
                if(ends[5]>=biggest1320){
                  biggest1320=ends[5];
                }
                if(biggest1320 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1320 == 0){
                  S108=3;
                  thread1321(tdone,ends);
                  thread1322(tdone,ends);
                  thread1323(tdone,ends);
                  thread1324(tdone,ends);
                  int biggest1325 = 0;
                  if(ends[6]>=biggest1325){
                    biggest1325=ends[6];
                  }
                  if(ends[7]>=biggest1325){
                    biggest1325=ends[7];
                  }
                  if(ends[8]>=biggest1325){
                    biggest1325=ends[8];
                  }
                  if(ends[9]>=biggest1325){
                    biggest1325=ends[9];
                  }
                  if(biggest1325 == 1){
                    active[3]=1;
                    ends[3]=1;
                    break RUN;
                  }
                }
              }
            
            case 3 : 
              if(gripperTurnFinalPos.getprestatus()){//sysj\controller.sysj line: 64, column: 9
                S108=4;
                thread1326(tdone,ends);
                thread1327(tdone,ends);
                thread1328(tdone,ends);
                int biggest1329 = 0;
                if(ends[10]>=biggest1329){
                  biggest1329=ends[10];
                }
                if(ends[11]>=biggest1329){
                  biggest1329=ends[11];
                }
                if(ends[12]>=biggest1329){
                  biggest1329=ends[12];
                }
                if(biggest1329 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
              }
              else {
                thread1330(tdone,ends);
                thread1331(tdone,ends);
                thread1332(tdone,ends);
                thread1333(tdone,ends);
                int biggest1334 = 0;
                if(ends[6]>=biggest1334){
                  biggest1334=ends[6];
                }
                if(ends[7]>=biggest1334){
                  biggest1334=ends[7];
                }
                if(ends[8]>=biggest1334){
                  biggest1334=ends[8];
                }
                if(ends[9]>=biggest1334){
                  biggest1334=ends[9];
                }
                if(biggest1334 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1334 == 0){
                  S108=4;
                  thread1335(tdone,ends);
                  thread1336(tdone,ends);
                  thread1337(tdone,ends);
                  int biggest1338 = 0;
                  if(ends[10]>=biggest1338){
                    biggest1338=ends[10];
                  }
                  if(ends[11]>=biggest1338){
                    biggest1338=ends[11];
                  }
                  if(ends[12]>=biggest1338){
                    biggest1338=ends[12];
                  }
                  if(biggest1338 == 1){
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
                thread1339(tdone,ends);
                thread1340(tdone,ends);
                thread1341(tdone,ends);
                int biggest1342 = 0;
                if(ends[10]>=biggest1342){
                  biggest1342=ends[10];
                }
                if(ends[11]>=biggest1342){
                  biggest1342=ends[11];
                }
                if(ends[12]>=biggest1342){
                  biggest1342=ends[12];
                }
                if(biggest1342 == 1){
                  active[3]=1;
                  ends[3]=1;
                  break RUN;
                }
                //FINXME code
                if(biggest1342 == 0){
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
