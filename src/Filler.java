import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Filler extends ClockDomain{
  public Filler(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal bottleAtPos2 = new Signal("bottleAtPos2", Signal.INPUT);
  public Signal dosUnitEvac = new Signal("dosUnitEvac", Signal.INPUT);
  public Signal dosUnitFilled = new Signal("dosUnitFilled", Signal.INPUT);
  public Signal noz1 = new Signal("noz1", Signal.INPUT);
  public Signal noz2 = new Signal("noz2", Signal.INPUT);
  public Signal noz3 = new Signal("noz3", Signal.INPUT);
  public Signal noz4 = new Signal("noz4", Signal.INPUT);
  public Signal i_selNoz1 = new Signal("i_selNoz1", Signal.INPUT);
  public Signal i_selNoz2 = new Signal("i_selNoz2", Signal.INPUT);
  public Signal i_selNoz3 = new Signal("i_selNoz3", Signal.INPUT);
  public Signal i_selNoz4 = new Signal("i_selNoz4", Signal.INPUT);
  public Signal valveInjectorOnOff = new Signal("valveInjectorOnOff", Signal.OUTPUT);
  public Signal valveInletOnOff = new Signal("valveInletOnOff", Signal.OUTPUT);
  public Signal dosUnitValveRetract = new Signal("dosUnitValveRetract", Signal.OUTPUT);
  public Signal dosUnitValveExtend = new Signal("dosUnitValveExtend", Signal.OUTPUT);
  public Signal turnNozTrigger = new Signal("turnNozTrigger", Signal.OUTPUT);
  private int S797 = 1;
  private int S793 = 1;
  private int S554 = 1;
  private int S559 = 1;
  private int S565 = 1;
  private int S583 = 1;
  private int S588 = 1;
  private int S795 = 1;
  
  private int[] ends = new int[20];
  private int[] tdone = new int[20];
  
  public void thread851(int [] tdone, int [] ends){
        switch(S795){
      case 0 : 
        active[19]=0;
        ends[19]=0;
        tdone[19]=1;
        break;
      
      case 1 : 
        active[19]=1;
        ends[19]=1;
        tdone[19]=1;
        break;
      
    }
  }

  public void thread849(int [] tdone, int [] ends){
        switch(S588){
      case 0 : 
        active[18]=0;
        ends[18]=0;
        tdone[18]=1;
        break;
      
      case 1 : 
        dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 129, column: 5
        currsigs.addElement(dosUnitValveExtend);
        System.out.println("Emitted dosUnitValveExtend");
        active[18]=1;
        ends[18]=1;
        tdone[18]=1;
        break;
      
    }
  }

  public void thread848(int [] tdone, int [] ends){
        switch(S583){
      case 0 : 
        active[17]=0;
        ends[17]=0;
        tdone[17]=1;
        break;
      
      case 1 : 
        valveInletOnOff.setPresent();//sysj\controller.sysj line: 126, column: 5
        currsigs.addElement(valveInletOnOff);
        System.out.println("Emitted valveInletOnOff");
        active[17]=1;
        ends[17]=1;
        tdone[17]=1;
        break;
      
    }
  }

  public void thread846(int [] tdone, int [] ends){
        S588=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 129, column: 5
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread845(int [] tdone, int [] ends){
        S583=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 126, column: 5
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread843(int [] tdone, int [] ends){
        switch(S565){
      case 0 : 
        active[16]=0;
        ends[16]=0;
        tdone[16]=1;
        break;
      
      case 1 : 
        dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 119, column: 6
        currsigs.addElement(dosUnitValveRetract);
        System.out.println("Emitted dosUnitValveRetract");
        active[16]=1;
        ends[16]=1;
        tdone[16]=1;
        break;
      
    }
  }

  public void thread842(int [] tdone, int [] ends){
        switch(S559){
      case 0 : 
        active[15]=0;
        ends[15]=0;
        tdone[15]=1;
        break;
      
      case 1 : 
        valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 115, column: 5
        currsigs.addElement(valveInjectorOnOff);
        System.out.println("Emitted valveInjectorOnOff");
        active[15]=1;
        ends[15]=1;
        tdone[15]=1;
        break;
      
    }
  }

  public void thread840(int [] tdone, int [] ends){
        S588=1;
    dosUnitValveExtend.setPresent();//sysj\controller.sysj line: 129, column: 5
    currsigs.addElement(dosUnitValveExtend);
    System.out.println("Emitted dosUnitValveExtend");
    active[18]=1;
    ends[18]=1;
    tdone[18]=1;
  }

  public void thread839(int [] tdone, int [] ends){
        S583=1;
    valveInletOnOff.setPresent();//sysj\controller.sysj line: 126, column: 5
    currsigs.addElement(valveInletOnOff);
    System.out.println("Emitted valveInletOnOff");
    active[17]=1;
    ends[17]=1;
    tdone[17]=1;
  }

  public void thread837(int [] tdone, int [] ends){
        S565=1;
    if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 118, column: 13
      dosUnitValveRetract.setPresent();//sysj\controller.sysj line: 119, column: 6
      currsigs.addElement(dosUnitValveRetract);
      System.out.println("Emitted dosUnitValveRetract");
      active[16]=1;
      ends[16]=1;
      tdone[16]=1;
    }
    else {
      S565=0;
      active[16]=0;
      ends[16]=0;
      tdone[16]=1;
    }
  }

  public void thread836(int [] tdone, int [] ends){
        S559=1;
    valveInjectorOnOff.setPresent();//sysj\controller.sysj line: 115, column: 5
    currsigs.addElement(valveInjectorOnOff);
    System.out.println("Emitted valveInjectorOnOff");
    active[15]=1;
    ends[15]=1;
    tdone[15]=1;
  }

  public void thread835(int [] tdone, int [] ends){
        switch(S793){
      case 0 : 
        active[14]=0;
        ends[14]=0;
        tdone[14]=1;
        break;
      
      case 1 : 
        switch(S554){
          case 0 : 
            S554=0;
            S554=1;
            active[14]=1;
            ends[14]=1;
            tdone[14]=1;
            break;
          
          case 1 : 
            if(bottleAtPos2.getprestatus()){//sysj\controller.sysj line: 113, column: 9
              S554=2;
              thread836(tdone,ends);
              thread837(tdone,ends);
              int biggest838 = 0;
              if(ends[15]>=biggest838){
                biggest838=ends[15];
              }
              if(ends[16]>=biggest838){
                biggest838=ends[16];
              }
              if(biggest838 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            break;
          
          case 2 : 
            if(dosUnitFilled.getprestatus()){//sysj\controller.sysj line: 114, column: 9
              S554=3;
              thread839(tdone,ends);
              thread840(tdone,ends);
              int biggest841 = 0;
              if(ends[17]>=biggest841){
                biggest841=ends[17];
              }
              if(ends[18]>=biggest841){
                biggest841=ends[18];
              }
              if(biggest841 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            else {
              thread842(tdone,ends);
              thread843(tdone,ends);
              int biggest844 = 0;
              if(ends[15]>=biggest844){
                biggest844=ends[15];
              }
              if(ends[16]>=biggest844){
                biggest844=ends[16];
              }
              if(biggest844 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest844 == 0){
                S554=3;
                thread845(tdone,ends);
                thread846(tdone,ends);
                int biggest847 = 0;
                if(ends[17]>=biggest847){
                  biggest847=ends[17];
                }
                if(ends[18]>=biggest847){
                  biggest847=ends[18];
                }
                if(biggest847 == 1){
                  active[14]=1;
                  ends[14]=1;
                  tdone[14]=1;
                }
              }
            }
            break;
          
          case 3 : 
            if(dosUnitEvac.getprestatus()){//sysj\controller.sysj line: 125, column: 9
              S554=0;
              active[14]=1;
              ends[14]=1;
              tdone[14]=1;
            }
            else {
              thread848(tdone,ends);
              thread849(tdone,ends);
              int biggest850 = 0;
              if(ends[17]>=biggest850){
                biggest850=ends[17];
              }
              if(ends[18]>=biggest850){
                biggest850=ends[18];
              }
              if(biggest850 == 1){
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
              //FINXME code
              if(biggest850 == 0){
                S554=0;
                active[14]=1;
                ends[14]=1;
                tdone[14]=1;
              }
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread833(int [] tdone, int [] ends){
        S795=1;
    active[19]=1;
    ends[19]=1;
    tdone[19]=1;
  }

  public void thread832(int [] tdone, int [] ends){
        S793=1;
    S554=0;
    active[14]=1;
    ends[14]=1;
    tdone[14]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S797){
        case 0 : 
          S797=0;
          break RUN;
        
        case 1 : 
          S797=2;
          S797=2;
          thread832(tdone,ends);
          thread833(tdone,ends);
          int biggest834 = 0;
          if(ends[14]>=biggest834){
            biggest834=ends[14];
          }
          if(ends[19]>=biggest834){
            biggest834=ends[19];
          }
          if(biggest834 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
        
        case 2 : 
          thread835(tdone,ends);
          thread851(tdone,ends);
          int biggest852 = 0;
          if(ends[14]>=biggest852){
            biggest852=ends[14];
          }
          if(ends[19]>=biggest852){
            biggest852=ends[19];
          }
          if(biggest852 == 1){
            active[13]=1;
            ends[13]=1;
            break RUN;
          }
          //FINXME code
          if(biggest852 == 0){
            S797=0;
            active[13]=0;
            ends[13]=0;
            S797=0;
            break RUN;
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
    while(active[13] != 0){
      int index = 13;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        if(!df){
          bottleAtPos2.gethook();
          dosUnitEvac.gethook();
          dosUnitFilled.gethook();
          noz1.gethook();
          noz2.gethook();
          noz3.gethook();
          noz4.gethook();
          i_selNoz1.gethook();
          i_selNoz2.gethook();
          i_selNoz3.gethook();
          i_selNoz4.gethook();
          df = true;
        }
        runClockDomain();
      }
      bottleAtPos2.setpreclear();
      dosUnitEvac.setpreclear();
      dosUnitFilled.setpreclear();
      noz1.setpreclear();
      noz2.setpreclear();
      noz3.setpreclear();
      noz4.setpreclear();
      i_selNoz1.setpreclear();
      i_selNoz2.setpreclear();
      i_selNoz3.setpreclear();
      i_selNoz4.setpreclear();
      valveInjectorOnOff.setpreclear();
      valveInletOnOff.setpreclear();
      dosUnitValveRetract.setpreclear();
      dosUnitValveExtend.setpreclear();
      turnNozTrigger.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = bottleAtPos2.getStatus() ? bottleAtPos2.setprepresent() : bottleAtPos2.setpreclear();
      bottleAtPos2.setpreval(bottleAtPos2.getValue());
      bottleAtPos2.setClear();
      dummyint = dosUnitEvac.getStatus() ? dosUnitEvac.setprepresent() : dosUnitEvac.setpreclear();
      dosUnitEvac.setpreval(dosUnitEvac.getValue());
      dosUnitEvac.setClear();
      dummyint = dosUnitFilled.getStatus() ? dosUnitFilled.setprepresent() : dosUnitFilled.setpreclear();
      dosUnitFilled.setpreval(dosUnitFilled.getValue());
      dosUnitFilled.setClear();
      dummyint = noz1.getStatus() ? noz1.setprepresent() : noz1.setpreclear();
      noz1.setpreval(noz1.getValue());
      noz1.setClear();
      dummyint = noz2.getStatus() ? noz2.setprepresent() : noz2.setpreclear();
      noz2.setpreval(noz2.getValue());
      noz2.setClear();
      dummyint = noz3.getStatus() ? noz3.setprepresent() : noz3.setpreclear();
      noz3.setpreval(noz3.getValue());
      noz3.setClear();
      dummyint = noz4.getStatus() ? noz4.setprepresent() : noz4.setpreclear();
      noz4.setpreval(noz4.getValue());
      noz4.setClear();
      dummyint = i_selNoz1.getStatus() ? i_selNoz1.setprepresent() : i_selNoz1.setpreclear();
      i_selNoz1.setpreval(i_selNoz1.getValue());
      i_selNoz1.setClear();
      dummyint = i_selNoz2.getStatus() ? i_selNoz2.setprepresent() : i_selNoz2.setpreclear();
      i_selNoz2.setpreval(i_selNoz2.getValue());
      i_selNoz2.setClear();
      dummyint = i_selNoz3.getStatus() ? i_selNoz3.setprepresent() : i_selNoz3.setpreclear();
      i_selNoz3.setpreval(i_selNoz3.getValue());
      i_selNoz3.setClear();
      dummyint = i_selNoz4.getStatus() ? i_selNoz4.setprepresent() : i_selNoz4.setpreclear();
      i_selNoz4.setpreval(i_selNoz4.getValue());
      i_selNoz4.setClear();
      valveInjectorOnOff.sethook();
      valveInjectorOnOff.setClear();
      valveInletOnOff.sethook();
      valveInletOnOff.setClear();
      dosUnitValveRetract.sethook();
      dosUnitValveRetract.setClear();
      dosUnitValveExtend.sethook();
      dosUnitValveExtend.setClear();
      turnNozTrigger.sethook();
      turnNozTrigger.setClear();
      if(paused[13]!=0 || suspended[13]!=0 || active[13]!=1);
      else{
        bottleAtPos2.gethook();
        dosUnitEvac.gethook();
        dosUnitFilled.gethook();
        noz1.gethook();
        noz2.gethook();
        noz3.gethook();
        noz4.gethook();
        i_selNoz1.gethook();
        i_selNoz2.gethook();
        i_selNoz3.gethook();
        i_selNoz4.gethook();
      }
      runFinisher();
      if(active[13] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
