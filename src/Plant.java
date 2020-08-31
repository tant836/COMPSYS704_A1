import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Plant extends ClockDomain{
  public Plant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal empty = new Signal("empty", Signal.OUTPUT);
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal capPos_1;
  private int capcount_thread_6;//sysj\plant.sysj line: 85, column: 3
  private int S2217 = 1;
  private int S945 = 1;
  private int S899 = 1;
  private int S998 = 1;
  private int S952 = 1;
  private int S1042 = 1;
  private int S1012 = 1;
  private int S1007 = 1;
  private int S1110 = 1;
  private int S1064 = 1;
  private int S1046 = 1;
  private int S1172 = 1;
  private int S1222 = 1;
  private int S1180 = 1;
  private int S1188 = 1;
  private int S1196 = 1;
  private int S1204 = 1;
  private int S1212 = 1;
  private int S1220 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread2244(int [] tdone, int [] ends){
        switch(S1220){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\plant.sysj line: 113, column: 24
          emptyE.setPresent();//sysj\plant.sysj line: 113, column: 31
          currsigs.addElement(emptyE);
          System.out.println("Emitted emptyE");
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        else {
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        break;
      
    }
  }

  public void thread2243(int [] tdone, int [] ends){
        switch(S1212){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\plant.sysj line: 111, column: 24
          armAtDestE.setPresent();//sysj\plant.sysj line: 111, column: 35
          currsigs.addElement(armAtDestE);
          System.out.println("Emitted armAtDestE");
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        else {
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        break;
      
    }
  }

  public void thread2242(int [] tdone, int [] ends){
        switch(S1204){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\plant.sysj line: 109, column: 24
          armAtSourceE.setPresent();//sysj\plant.sysj line: 109, column: 37
          currsigs.addElement(armAtSourceE);
          System.out.println("Emitted armAtSourceE");
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        break;
      
    }
  }

  public void thread2241(int [] tdone, int [] ends){
        switch(S1196){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\plant.sysj line: 107, column: 24
          WPgrippedE.setPresent();//sysj\plant.sysj line: 107, column: 35
          currsigs.addElement(WPgrippedE);
          System.out.println("Emitted WPgrippedE");
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread2240(int [] tdone, int [] ends){
        switch(S1188){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 105, column: 24
          pusherExtendedE.setPresent();//sysj\plant.sysj line: 105, column: 40
          currsigs.addElement(pusherExtendedE);
          System.out.println("Emitted pusherExtendedE");
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread2239(int [] tdone, int [] ends){
        switch(S1180){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 103, column: 24
          pusherRetractedE.setPresent();//sysj\plant.sysj line: 103, column: 41
          currsigs.addElement(pusherRetractedE);
          System.out.println("Emitted pusherRetractedE");
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread2238(int [] tdone, int [] ends){
        switch(S1222){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread2239(tdone,ends);
        thread2240(tdone,ends);
        thread2241(tdone,ends);
        thread2242(tdone,ends);
        thread2243(tdone,ends);
        thread2244(tdone,ends);
        int biggest2245 = 0;
        if(ends[8]>=biggest2245){
          biggest2245=ends[8];
        }
        if(ends[9]>=biggest2245){
          biggest2245=ends[9];
        }
        if(ends[10]>=biggest2245){
          biggest2245=ends[10];
        }
        if(ends[11]>=biggest2245){
          biggest2245=ends[11];
        }
        if(ends[12]>=biggest2245){
          biggest2245=ends[12];
        }
        if(ends[13]>=biggest2245){
          biggest2245=ends[13];
        }
        if(biggest2245 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest2245 == 0){
          S1222=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread2237(int [] tdone, int [] ends){
        switch(S1172){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\plant.sysj line: 87, column: 12
          if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 88, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 89, column: 6
          }
          if(refill.getprestatus()){//sysj\plant.sysj line: 91, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 92, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 95, column: 8
              empty.setPresent();//sysj\plant.sysj line: 96, column: 6
              currsigs.addElement(empty);
              System.out.println("Emitted empty");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 95, column: 8
              empty.setPresent();//sysj\plant.sysj line: 96, column: 6
              currsigs.addElement(empty);
              System.out.println("Emitted empty");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        else {
          if(refill.getprestatus()){//sysj\plant.sysj line: 91, column: 12
            capcount_thread_6 = 5;//sysj\plant.sysj line: 92, column: 5
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 95, column: 8
              empty.setPresent();//sysj\plant.sysj line: 96, column: 6
              currsigs.addElement(empty);
              System.out.println("Emitted empty");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            if(capcount_thread_6 == 0){//sysj\plant.sysj line: 95, column: 8
              empty.setPresent();//sysj\plant.sysj line: 96, column: 6
              currsigs.addElement(empty);
              System.out.println("Emitted empty");
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread2236(int [] tdone, int [] ends){
        switch(S1110){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S1064){
          case 0 : 
            if(empty.getprestatus()){//sysj\plant.sysj line: 70, column: 10
              S1064=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S1046){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 72, column: 13
                    S1046=1;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 1 : 
                  if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 73, column: 13
                    capPos_1.setPresent();//sysj\plant.sysj line: 75, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 75, column: 7
                    System.out.println("Emitted capPos_1");
                    S1046=2;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 76, column: 13
                    capDec_1.setPresent();//sysj\plant.sysj line: 77, column: 7
                    currsigs.addElement(capDec_1);
                    System.out.println("Emitted capDec_1");
                    S1046=0;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
              }
            }
            break;
          
          case 1 : 
            if(refill.getprestatus()){//sysj\plant.sysj line: 80, column: 10
              S1064=0;
              S1046=0;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2235(int [] tdone, int [] ends){
        switch(S1042){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S1012){
          case 0 : 
            switch(S1007){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\plant.sysj line: 50, column: 12
                  S1007=1;
                  if(armAtSource.getprestatus()){//sysj\plant.sysj line: 53, column: 14
                    capPos_1.setPresent();//sysj\plant.sysj line: 54, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\plant.sysj line: 54, column: 7
                    System.out.println("Emitted capPos_1");
                    S1012=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1012=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\plant.sysj line: 51, column: 7
                  currsigs.addElement(WPgripped);
                  System.out.println("Emitted WPgripped");
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S1012=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 47, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 48, column: 8
                    capPos_1.setPresent();//sysj\plant.sysj line: 49, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\plant.sysj line: 49, column: 6
                    System.out.println("Emitted capPos_1");
                    S1007=0;
                    WPgripped.setPresent();//sysj\plant.sysj line: 51, column: 7
                    currsigs.addElement(WPgripped);
                    System.out.println("Emitted WPgripped");
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S1012=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S1012=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S1012=1;
            S1012=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 47, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 48, column: 8
                capPos_1.setPresent();//sysj\plant.sysj line: 49, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\plant.sysj line: 49, column: 6
                System.out.println("Emitted capPos_1");
                S1007=0;
                WPgripped.setPresent();//sysj\plant.sysj line: 51, column: 7
                currsigs.addElement(WPgripped);
                System.out.println("Emitted WPgripped");
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S1012=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S1012=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2234(int [] tdone, int [] ends){
        switch(S998){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S952){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 34, column: 10
              S952=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\plant.sysj line: 35, column: 5
              currsigs.addElement(pusherRetracted);
              System.out.println("Emitted pusherRetracted");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 37, column: 10
              S952=2;
              pusherExtended.setPresent();//sysj\plant.sysj line: 39, column: 5
              currsigs.addElement(pusherExtended);
              System.out.println("Emitted pusherExtended");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 38, column: 10
              S952=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\plant.sysj line: 39, column: 5
              currsigs.addElement(pusherExtended);
              System.out.println("Emitted pusherExtended");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 41, column: 10
              S952=0;
              pusherRetracted.setPresent();//sysj\plant.sysj line: 35, column: 5
              currsigs.addElement(pusherRetracted);
              System.out.println("Emitted pusherRetracted");
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2233(int [] tdone, int [] ends){
        switch(S945){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S899){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 21, column: 10
              S899=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\plant.sysj line: 22, column: 5
              currsigs.addElement(armAtDest);
              System.out.println("Emitted armAtDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 24, column: 10
              S899=2;
              armAtSource.setPresent();//sysj\plant.sysj line: 26, column: 5
              currsigs.addElement(armAtSource);
              System.out.println("Emitted armAtSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\plant.sysj line: 25, column: 10
              S899=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\plant.sysj line: 26, column: 5
              currsigs.addElement(armAtSource);
              System.out.println("Emitted armAtSource");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\plant.sysj line: 28, column: 10
              S899=0;
              armAtDest.setPresent();//sysj\plant.sysj line: 22, column: 5
              currsigs.addElement(armAtDest);
              System.out.println("Emitted armAtDest");
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread2230(int [] tdone, int [] ends){
        S1220=1;
    if(empty.getprestatus()){//sysj\plant.sysj line: 113, column: 24
      emptyE.setPresent();//sysj\plant.sysj line: 113, column: 31
      currsigs.addElement(emptyE);
      System.out.println("Emitted emptyE");
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
    else {
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
  }

  public void thread2229(int [] tdone, int [] ends){
        S1212=1;
    if(armAtDest.getprestatus()){//sysj\plant.sysj line: 111, column: 24
      armAtDestE.setPresent();//sysj\plant.sysj line: 111, column: 35
      currsigs.addElement(armAtDestE);
      System.out.println("Emitted armAtDestE");
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
    else {
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
  }

  public void thread2228(int [] tdone, int [] ends){
        S1204=1;
    if(armAtSource.getprestatus()){//sysj\plant.sysj line: 109, column: 24
      armAtSourceE.setPresent();//sysj\plant.sysj line: 109, column: 37
      currsigs.addElement(armAtSourceE);
      System.out.println("Emitted armAtSourceE");
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread2227(int [] tdone, int [] ends){
        S1196=1;
    if(WPgripped.getprestatus()){//sysj\plant.sysj line: 107, column: 24
      WPgrippedE.setPresent();//sysj\plant.sysj line: 107, column: 35
      currsigs.addElement(WPgrippedE);
      System.out.println("Emitted WPgrippedE");
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread2226(int [] tdone, int [] ends){
        S1188=1;
    if(pusherExtended.getprestatus()){//sysj\plant.sysj line: 105, column: 24
      pusherExtendedE.setPresent();//sysj\plant.sysj line: 105, column: 40
      currsigs.addElement(pusherExtendedE);
      System.out.println("Emitted pusherExtendedE");
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread2225(int [] tdone, int [] ends){
        S1180=1;
    if(pusherRetracted.getprestatus()){//sysj\plant.sysj line: 103, column: 24
      pusherRetractedE.setPresent();//sysj\plant.sysj line: 103, column: 41
      currsigs.addElement(pusherRetractedE);
      System.out.println("Emitted pusherRetractedE");
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread2224(int [] tdone, int [] ends){
        S1222=1;
    thread2225(tdone,ends);
    thread2226(tdone,ends);
    thread2227(tdone,ends);
    thread2228(tdone,ends);
    thread2229(tdone,ends);
    thread2230(tdone,ends);
    int biggest2231 = 0;
    if(ends[8]>=biggest2231){
      biggest2231=ends[8];
    }
    if(ends[9]>=biggest2231){
      biggest2231=ends[9];
    }
    if(ends[10]>=biggest2231){
      biggest2231=ends[10];
    }
    if(ends[11]>=biggest2231){
      biggest2231=ends[11];
    }
    if(ends[12]>=biggest2231){
      biggest2231=ends[12];
    }
    if(ends[13]>=biggest2231){
      biggest2231=ends[13];
    }
    if(biggest2231 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread2223(int [] tdone, int [] ends){
        S1172=1;
    capcount_thread_6 = 5;//sysj\plant.sysj line: 85, column: 3
    if(capDec_1.getprestatus()){//sysj\plant.sysj line: 87, column: 12
      if(capcount_thread_6 > 0) {//sysj\plant.sysj line: 88, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\plant.sysj line: 89, column: 6
      }
      if(refill.getprestatus()){//sysj\plant.sysj line: 91, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 92, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 95, column: 8
          empty.setPresent();//sysj\plant.sysj line: 96, column: 6
          currsigs.addElement(empty);
          System.out.println("Emitted empty");
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
      else {
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 95, column: 8
          empty.setPresent();//sysj\plant.sysj line: 96, column: 6
          currsigs.addElement(empty);
          System.out.println("Emitted empty");
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
    }
    else {
      if(refill.getprestatus()){//sysj\plant.sysj line: 91, column: 12
        capcount_thread_6 = 5;//sysj\plant.sysj line: 92, column: 5
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 95, column: 8
          empty.setPresent();//sysj\plant.sysj line: 96, column: 6
          currsigs.addElement(empty);
          System.out.println("Emitted empty");
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
      else {
        if(capcount_thread_6 == 0){//sysj\plant.sysj line: 95, column: 8
          empty.setPresent();//sysj\plant.sysj line: 96, column: 6
          currsigs.addElement(empty);
          System.out.println("Emitted empty");
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
    }
  }

  public void thread2222(int [] tdone, int [] ends){
        S1110=1;
    S1064=0;
    S1046=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread2221(int [] tdone, int [] ends){
        S1042=1;
    S1012=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\plant.sysj line: 47, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\plant.sysj line: 48, column: 8
        capPos_1.setPresent();//sysj\plant.sysj line: 49, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\plant.sysj line: 49, column: 6
        System.out.println("Emitted capPos_1");
        S1007=0;
        WPgripped.setPresent();//sysj\plant.sysj line: 51, column: 7
        currsigs.addElement(WPgripped);
        System.out.println("Emitted WPgripped");
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S1012=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S1012=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread2220(int [] tdone, int [] ends){
        S998=1;
    S952=0;
    pusherRetracted.setPresent();//sysj\plant.sysj line: 35, column: 5
    currsigs.addElement(pusherRetracted);
    System.out.println("Emitted pusherRetracted");
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread2219(int [] tdone, int [] ends){
        S945=1;
    S899=0;
    armAtDest.setPresent();//sysj\plant.sysj line: 22, column: 5
    currsigs.addElement(armAtDest);
    System.out.println("Emitted armAtDest");
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
      switch(S2217){
        case 0 : 
          S2217=0;
          break RUN;
        
        case 1 : 
          S2217=2;
          S2217=2;
          class GUI extends Object implements java.lang.Runnable {//sysj\plant.sysj line: 8, column: 1
            public void run() {//sysj\plant.sysj line: 10, column: 21
              org.compsys704.CapLoader.main(null);//sysj\plant.sysj line: 11, column: 4
            }
            GUI(){//sysj\plant.sysj line: 9, column: 42
            }
          }
          new Thread(new GUI()).start();//sysj\plant.sysj line: 14, column: 2
          capDec_1.setClear();//sysj\plant.sysj line: 16, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 17, column: 2
          capPos_1.setPresent();//sysj\plant.sysj line: 18, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\plant.sysj line: 18, column: 2
          System.out.println("Emitted capPos_1");
          thread2219(tdone,ends);
          thread2220(tdone,ends);
          thread2221(tdone,ends);
          thread2222(tdone,ends);
          thread2223(tdone,ends);
          thread2224(tdone,ends);
          int biggest2232 = 0;
          if(ends[2]>=biggest2232){
            biggest2232=ends[2];
          }
          if(ends[3]>=biggest2232){
            biggest2232=ends[3];
          }
          if(ends[4]>=biggest2232){
            biggest2232=ends[4];
          }
          if(ends[5]>=biggest2232){
            biggest2232=ends[5];
          }
          if(ends[6]>=biggest2232){
            biggest2232=ends[6];
          }
          if(ends[7]>=biggest2232){
            biggest2232=ends[7];
          }
          if(biggest2232 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\plant.sysj line: 16, column: 2
          capPos_1.setClear();//sysj\plant.sysj line: 17, column: 2
          thread2233(tdone,ends);
          thread2234(tdone,ends);
          thread2235(tdone,ends);
          thread2236(tdone,ends);
          thread2237(tdone,ends);
          thread2238(tdone,ends);
          int biggest2246 = 0;
          if(ends[2]>=biggest2246){
            biggest2246=ends[2];
          }
          if(ends[3]>=biggest2246){
            biggest2246=ends[3];
          }
          if(ends[4]>=biggest2246){
            biggest2246=ends[4];
          }
          if(ends[5]>=biggest2246){
            biggest2246=ends[5];
          }
          if(ends[6]>=biggest2246){
            biggest2246=ends[6];
          }
          if(ends[7]>=biggest2246){
            biggest2246=ends[7];
          }
          if(biggest2246 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest2246 == 0){
            S2217=0;
            active[1]=0;
            ends[1]=0;
            S2217=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    capDec_1 = new Signal();
    capPos_1 = new Signal();
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
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          enable.gethook();
          refill.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      enable.setpreclear();
      refill.setpreclear();
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      pusherRetractedE.setpreclear();
      pusherExtendedE.setpreclear();
      WPgrippedE.setpreclear();
      armAtSourceE.setpreclear();
      armAtDestE.setpreclear();
      emptyE.setpreclear();
      capDec_1.setpreclear();
      capPos_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherExtend.getStatus() ? pusherExtend.setprepresent() : pusherExtend.setpreclear();
      pusherExtend.setpreval(pusherExtend.getValue());
      pusherExtend.setClear();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      pusherRetracted.sethook();
      pusherRetracted.setClear();
      pusherExtended.sethook();
      pusherExtended.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      empty.sethook();
      empty.setClear();
      pusherRetractedE.sethook();
      pusherRetractedE.setClear();
      pusherExtendedE.sethook();
      pusherExtendedE.setClear();
      WPgrippedE.sethook();
      WPgrippedE.setClear();
      armAtSourceE.sethook();
      armAtSourceE.setClear();
      armAtDestE.sethook();
      armAtDestE.setClear();
      emptyE.sethook();
      emptyE.setClear();
      capDec_1.setClear();
      capPos_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        enable.gethook();
        refill.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
