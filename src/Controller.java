import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Controller extends ClockDomain{
  public Controller(String name){super(name);}
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
  public Signal request = new Signal("request", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal pusherExtendM = new Signal("pusherExtendM", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  private int i_mode_thread_1;//sysj\controller.sysj line: 10, column: 2
  private int S2389 = 1;
  private int S98 = 1;
  private int S2 = 1;
  private int S43 = 1;
  private int S48 = 1;
  private int S97 = 1;
  
  private int[] ends = new int[8];
  private int[] tdone = new int[8];
  
  public void thread2405(int [] tdone, int [] ends){
        active[7]=0;
    ends[7]=0;
    tdone[7]=1;
  }

  public void thread2404(int [] tdone, int [] ends){
        active[6]=0;
    ends[6]=0;
    tdone[6]=1;
  }

  public void thread2403(int [] tdone, int [] ends){
        active[5]=0;
    ends[5]=0;
    tdone[5]=1;
  }

  public void thread2402(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread2400(int [] tdone, int [] ends){
        if(armDestM.getprestatus()){//sysj\controller.sysj line: 72, column: 13
      armDest.setPresent();//sysj\controller.sysj line: 73, column: 6
      currsigs.addElement(armDest);
      System.out.println("Emitted armDest");
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
    else {
      active[7]=0;
      ends[7]=0;
      tdone[7]=1;
    }
  }

  public void thread2399(int [] tdone, int [] ends){
        if(armSourceM.getprestatus()){//sysj\controller.sysj line: 66, column: 13
      armSource.setPresent();//sysj\controller.sysj line: 67, column: 6
      currsigs.addElement(armSource);
      System.out.println("Emitted armSource");
      active[6]=0;
      ends[6]=0;
      tdone[6]=1;
    }
    else {
      active[6]=0;
      ends[6]=0;
      tdone[6]=1;
    }
  }

  public void thread2398(int [] tdone, int [] ends){
        if(vacOnM.getprestatus()){//sysj\controller.sysj line: 60, column: 13
      vacOn.setPresent();//sysj\controller.sysj line: 61, column: 6
      currsigs.addElement(vacOn);
      System.out.println("Emitted vacOn");
      active[5]=0;
      ends[5]=0;
      tdone[5]=1;
    }
    else {
      active[5]=0;
      ends[5]=0;
      tdone[5]=1;
    }
  }

  public void thread2397(int [] tdone, int [] ends){
        if(pusherExtendM.getprestatus()){//sysj\controller.sysj line: 54, column: 13
      pusherExtend.setPresent();//sysj\controller.sysj line: 55, column: 6
      currsigs.addElement(pusherExtend);
      System.out.println("Emitted pusherExtend");
      active[4]=0;
      ends[4]=0;
      tdone[4]=1;
    }
    else {
      active[4]=0;
      ends[4]=0;
      tdone[4]=1;
    }
  }

  public void thread2395(int [] tdone, int [] ends){
        switch(S48){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        armDest.setPresent();//sysj\controller.sysj line: 42, column: 24
        currsigs.addElement(armDest);
        System.out.println("Emitted armDest");
        active[3]=1;
        ends[3]=1;
        tdone[3]=1;
        break;
      
    }
  }

  public void thread2394(int [] tdone, int [] ends){
        switch(S43){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        vacOn.setPresent();//sysj\controller.sysj line: 42, column: 6
        currsigs.addElement(vacOn);
        System.out.println("Emitted vacOn");
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
        break;
      
    }
  }

  public void thread2392(int [] tdone, int [] ends){
        S48=1;
    armDest.setPresent();//sysj\controller.sysj line: 42, column: 24
    currsigs.addElement(armDest);
    System.out.println("Emitted armDest");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2391(int [] tdone, int [] ends){
        S43=1;
    vacOn.setPresent();//sysj\controller.sysj line: 42, column: 6
    currsigs.addElement(vacOn);
    System.out.println("Emitted vacOn");
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S2389){
        case 0 : 
          S2389=0;
          break RUN;
        
        case 1 : 
          S2389=2;
          S2389=2;
          i_mode_thread_1 = 0;//sysj\controller.sysj line: 10, column: 2
          try {//sysj\controller.sysj line: 13, column: 7
            i_mode_thread_1 = (int)(mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 14, column: 3
          }
          catch (Exception e) {//sysj\controller.sysj line: 15, column: 22
          }
          if(i_mode_thread_1 == 0){//sysj\controller.sysj line: 18, column: 5
            S98=0;
            S2=0;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          else {
            S98=1;
            S97=0;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          switch(S98){
            case 0 : 
              if(mode.getprestatus()){//sysj\controller.sysj line: 19, column: 9
                try {//sysj\controller.sysj line: 13, column: 7
                  i_mode_thread_1 = (int)(mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 14, column: 3
                }
                catch (Exception e) {//sysj\controller.sysj line: 15, column: 22
                }
                if(i_mode_thread_1 == 0){//sysj\controller.sysj line: 18, column: 5
                  S98=0;
                  S2=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S98=1;
                  S97=0;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                switch(S2){
                  case 0 : 
                    S2=0;
                    S2=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  
                  case 1 : 
                    if(!empty.getprestatus()){//sysj\controller.sysj line: 21, column: 10
                      S2=2;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 2 : 
                    if(request.getprestatus()){//sysj\controller.sysj line: 22, column: 10
                      S2=3;
                      armDest.setPresent();//sysj\controller.sysj line: 24, column: 5
                      currsigs.addElement(armDest);
                      System.out.println("Emitted armDest");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 3 : 
                    if(armAtDest.getprestatus()){//sysj\controller.sysj line: 23, column: 10
                      S2=4;
                      pusherExtend.setPresent();//sysj\controller.sysj line: 28, column: 5
                      currsigs.addElement(pusherExtend);
                      System.out.println("Emitted pusherExtend");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      armDest.setPresent();//sysj\controller.sysj line: 24, column: 5
                      currsigs.addElement(armDest);
                      System.out.println("Emitted armDest");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 4 : 
                    if(pusherExtended.getprestatus()){//sysj\controller.sysj line: 27, column: 10
                      S2=5;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      pusherExtend.setPresent();//sysj\controller.sysj line: 28, column: 5
                      currsigs.addElement(pusherExtend);
                      System.out.println("Emitted pusherExtend");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 5 : 
                    if(pusherRetracted.getprestatus()){//sysj\controller.sysj line: 31, column: 10
                      S2=6;
                      armSource.setPresent();//sysj\controller.sysj line: 34, column: 5
                      currsigs.addElement(armSource);
                      System.out.println("Emitted armSource");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 6 : 
                    if(armAtSource.getprestatus()){//sysj\controller.sysj line: 33, column: 10
                      S2=7;
                      vacOn.setPresent();//sysj\controller.sysj line: 38, column: 5
                      currsigs.addElement(vacOn);
                      System.out.println("Emitted vacOn");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      armSource.setPresent();//sysj\controller.sysj line: 34, column: 5
                      currsigs.addElement(armSource);
                      System.out.println("Emitted armSource");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 7 : 
                    if(WPgripped.getprestatus()){//sysj\controller.sysj line: 37, column: 10
                      S2=8;
                      thread2391(tdone,ends);
                      thread2392(tdone,ends);
                      int biggest2393 = 0;
                      if(ends[2]>=biggest2393){
                        biggest2393=ends[2];
                      }
                      if(ends[3]>=biggest2393){
                        biggest2393=ends[3];
                      }
                      if(biggest2393 == 1){
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      vacOn.setPresent();//sysj\controller.sysj line: 38, column: 5
                      currsigs.addElement(vacOn);
                      System.out.println("Emitted vacOn");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 8 : 
                    if(armAtDest.getprestatus()){//sysj\controller.sysj line: 41, column: 10
                      S2=9;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      thread2394(tdone,ends);
                      thread2395(tdone,ends);
                      int biggest2396 = 0;
                      if(ends[2]>=biggest2396){
                        biggest2396=ends[2];
                      }
                      if(ends[3]>=biggest2396){
                        biggest2396=ends[3];
                      }
                      if(biggest2396 == 1){
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      //FINXME code
                      if(biggest2396 == 0){
                        S2=9;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                  
                  case 9 : 
                    if(!WPgripped.getprestatus()){//sysj\controller.sysj line: 45, column: 10
                      S2=10;
                      armSource.setPresent();//sysj\controller.sysj line: 48, column: 5
                      currsigs.addElement(armSource);
                      System.out.println("Emitted armSource");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                  case 10 : 
                    if(armAtSource.getprestatus()){//sysj\controller.sysj line: 47, column: 10
                      try {//sysj\controller.sysj line: 13, column: 7
                        i_mode_thread_1 = (int)(mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 14, column: 3
                      }
                      catch (Exception e) {//sysj\controller.sysj line: 15, column: 22
                      }
                      if(i_mode_thread_1 == 0){//sysj\controller.sysj line: 18, column: 5
                        S98=0;
                        S2=0;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                      else {
                        S98=1;
                        S97=0;
                        active[1]=1;
                        ends[1]=1;
                        break RUN;
                      }
                    }
                    else {
                      armSource.setPresent();//sysj\controller.sysj line: 48, column: 5
                      currsigs.addElement(armSource);
                      System.out.println("Emitted armSource");
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  
                }
              }
              break;
            
            case 1 : 
              switch(S97){
                case 0 : 
                  S97=0;
                  S97=1;
                  thread2397(tdone,ends);
                  thread2398(tdone,ends);
                  thread2399(tdone,ends);
                  thread2400(tdone,ends);
                  int biggest2401 = 0;
                  if(ends[4]>=biggest2401){
                    biggest2401=ends[4];
                  }
                  if(ends[5]>=biggest2401){
                    biggest2401=ends[5];
                  }
                  if(ends[6]>=biggest2401){
                    biggest2401=ends[6];
                  }
                  if(ends[7]>=biggest2401){
                    biggest2401=ends[7];
                  }
                  //FINXME code
                  if(biggest2401 == 0){
                    try {//sysj\controller.sysj line: 13, column: 7
                      i_mode_thread_1 = (int)(mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 14, column: 3
                    }
                    catch (Exception e) {//sysj\controller.sysj line: 15, column: 22
                    }
                    if(i_mode_thread_1 == 0){//sysj\controller.sysj line: 18, column: 5
                      S98=0;
                      S2=0;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S98=1;
                      S97=0;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                
                case 1 : 
                  thread2402(tdone,ends);
                  thread2403(tdone,ends);
                  thread2404(tdone,ends);
                  thread2405(tdone,ends);
                  int biggest2406 = 0;
                  if(ends[4]>=biggest2406){
                    biggest2406=ends[4];
                  }
                  if(ends[5]>=biggest2406){
                    biggest2406=ends[5];
                  }
                  if(ends[6]>=biggest2406){
                    biggest2406=ends[6];
                  }
                  if(ends[7]>=biggest2406){
                    biggest2406=ends[7];
                  }
                  //FINXME code
                  if(biggest2406 == 0){
                    try {//sysj\controller.sysj line: 13, column: 7
                      i_mode_thread_1 = (int)(mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 14, column: 3
                    }
                    catch (Exception e) {//sysj\controller.sysj line: 15, column: 22
                    }
                    if(i_mode_thread_1 == 0){//sysj\controller.sysj line: 18, column: 5
                      S98=0;
                      S2=0;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S98=1;
                      S97=0;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                
              }
              break;
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          empty.gethook();
          request.gethook();
          mode.gethook();
          pusherExtendM.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
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
      request.setpreclear();
      mode.setpreclear();
      pusherExtendM.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
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
      dummyint = request.getStatus() ? request.setprepresent() : request.setpreclear();
      request.setpreval(request.getValue());
      request.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = pusherExtendM.getStatus() ? pusherExtendM.setprepresent() : pusherExtendM.setpreclear();
      pusherExtendM.setpreval(pusherExtendM.getValue());
      pusherExtendM.setClear();
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        empty.gethook();
        request.gethook();
        mode.gethook();
        pusherExtendM.gethook();
        vacOnM.gethook();
        armSourceM.gethook();
        armDestM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
