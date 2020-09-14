import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import org.compsys704.FIFO;//sysj\controller.sysj line: 1, column: 2

public class GUIReader extends ClockDomain{
  public GUIReader(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal placeOrder = new Signal("placeOrder", Signal.INPUT);
  public Signal liquid1 = new Signal("liquid1", Signal.INPUT);
  public Signal liquid2 = new Signal("liquid2", Signal.INPUT);
  public Signal liquid3 = new Signal("liquid3", Signal.INPUT);
  public Signal liquid4 = new Signal("liquid4", Signal.INPUT);
  public Signal requestliquid = new Signal("requestliquid", Signal.INPUT);
  public Signal sentliquid = new Signal("sentliquid", Signal.OUTPUT);
  public output_Channel liquidBuffer_o = new output_Channel();
  private Signal liq1_22;
  private Signal liq2_22;
  private Signal liq3_22;
  private Signal liq4_22;
  private Signal kill1_22;
  private Signal kill2_22;
  private Signal kill3_22;
  private Signal kill4_22;
  private FIFO fifo_thread_23;//sysj\controller.sysj line: 250, column: 3
  private Integer integer1_thread_23;//sysj\controller.sysj line: 281, column: 6
  private Integer liquidval_thread_23;//sysj\controller.sysj line: 252, column: 3
  private int S100130 = 1;
  private int S100048 = 1;
  private int S2477 = 1;
  private int S2525 = 1;
  private int S2520 = 1;
  private int S100068 = 1;
  private int S100054 = 1;
  private int S100088 = 1;
  private int S100074 = 1;
  private int S100108 = 1;
  private int S100094 = 1;
  private int S100128 = 1;
  private int S100114 = 1;
  
  private int[] ends = new int[28];
  private int[] tdone = new int[28];
  
  public void thread100211(int [] tdone, int [] ends){
        switch(S100128){
      case 0 : 
        active[27]=0;
        ends[27]=0;
        tdone[27]=1;
        break;
      
      case 1 : 
        switch(S100114){
          case 0 : 
            if(kill4_22.getprestatus()){//sysj\controller.sysj line: 297, column: 39
              S100114=1;
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              liq4_22.setPresent();//sysj\controller.sysj line: 297, column: 46
              currsigs.addElement(liq4_22);
              System.out.println("Emitted liq4_22");
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
          case 1 : 
            S100114=1;
            S100114=0;
            if(liquid4.getprestatus()){//sysj\controller.sysj line: 297, column: 24
              liq4_22.setPresent();//sysj\controller.sysj line: 297, column: 46
              currsigs.addElement(liq4_22);
              System.out.println("Emitted liq4_22");
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            else {
              S100114=1;
              active[27]=1;
              ends[27]=1;
              tdone[27]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread100210(int [] tdone, int [] ends){
        switch(S100108){
      case 0 : 
        active[26]=0;
        ends[26]=0;
        tdone[26]=1;
        break;
      
      case 1 : 
        switch(S100094){
          case 0 : 
            if(kill3_22.getprestatus()){//sysj\controller.sysj line: 295, column: 39
              S100094=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              liq3_22.setPresent();//sysj\controller.sysj line: 295, column: 46
              currsigs.addElement(liq3_22);
              System.out.println("Emitted liq3_22");
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
          case 1 : 
            S100094=1;
            S100094=0;
            if(liquid3.getprestatus()){//sysj\controller.sysj line: 295, column: 24
              liq3_22.setPresent();//sysj\controller.sysj line: 295, column: 46
              currsigs.addElement(liq3_22);
              System.out.println("Emitted liq3_22");
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            else {
              S100094=1;
              active[26]=1;
              ends[26]=1;
              tdone[26]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread100209(int [] tdone, int [] ends){
        switch(S100088){
      case 0 : 
        active[25]=0;
        ends[25]=0;
        tdone[25]=1;
        break;
      
      case 1 : 
        switch(S100074){
          case 0 : 
            if(kill2_22.getprestatus()){//sysj\controller.sysj line: 293, column: 39
              S100074=1;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              liq2_22.setPresent();//sysj\controller.sysj line: 293, column: 46
              currsigs.addElement(liq2_22);
              System.out.println("Emitted liq2_22");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
          case 1 : 
            S100074=1;
            S100074=0;
            if(liquid2.getprestatus()){//sysj\controller.sysj line: 293, column: 24
              liq2_22.setPresent();//sysj\controller.sysj line: 293, column: 46
              currsigs.addElement(liq2_22);
              System.out.println("Emitted liq2_22");
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            else {
              S100074=1;
              active[25]=1;
              ends[25]=1;
              tdone[25]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread100208(int [] tdone, int [] ends){
        switch(S100068){
      case 0 : 
        active[24]=0;
        ends[24]=0;
        tdone[24]=1;
        break;
      
      case 1 : 
        switch(S100054){
          case 0 : 
            if(kill1_22.getprestatus()){//sysj\controller.sysj line: 291, column: 39
              S100054=1;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              liq1_22.setPresent();//sysj\controller.sysj line: 291, column: 46
              currsigs.addElement(liq1_22);
              System.out.println("Emitted liq1_22");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
          case 1 : 
            S100054=1;
            S100054=0;
            if(liquid1.getprestatus()){//sysj\controller.sysj line: 291, column: 24
              liq1_22.setPresent();//sysj\controller.sysj line: 291, column: 46
              currsigs.addElement(liq1_22);
              System.out.println("Emitted liq1_22");
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            else {
              S100054=1;
              active[24]=1;
              ends[24]=1;
              tdone[24]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread100207(int [] tdone, int [] ends){
        switch(S100048){
      case 0 : 
        active[23]=0;
        ends[23]=0;
        tdone[23]=1;
        break;
      
      case 1 : 
        switch(S2477){
          case 0 : 
            S2477=0;
            if(placeOrder.getprestatus()){//sysj\controller.sysj line: 254, column: 11
              if(liq1_22.getprestatus()){//sysj\controller.sysj line: 256, column: 15
                liquidval_thread_23 += 1;//sysj\controller.sysj line: 258, column: 7
                kill1_22.setPresent();//sysj\controller.sysj line: 260, column: 6
                currsigs.addElement(kill1_22);
                System.out.println("Emitted kill1_22");
                if(liq2_22.getprestatus()){//sysj\controller.sysj line: 261, column: 15
                  liquidval_thread_23 += 2;//sysj\controller.sysj line: 263, column: 7
                  kill2_22.setPresent();//sysj\controller.sysj line: 265, column: 6
                  currsigs.addElement(kill2_22);
                  System.out.println("Emitted kill2_22");
                  if(liq3_22.getprestatus()){//sysj\controller.sysj line: 266, column: 15
                    liquidval_thread_23 += 4;//sysj\controller.sysj line: 267, column: 7
                    kill3_22.setPresent();//sysj\controller.sysj line: 269, column: 6
                    currsigs.addElement(kill3_22);
                    System.out.println("Emitted kill3_22");
                    if(liq4_22.getprestatus()){//sysj\controller.sysj line: 270, column: 15
                      liquidval_thread_23 += 8;//sysj\controller.sysj line: 272, column: 7
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                    else {
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                  }
                  else {
                    kill3_22.setPresent();//sysj\controller.sysj line: 269, column: 6
                    currsigs.addElement(kill3_22);
                    System.out.println("Emitted kill3_22");
                    if(liq4_22.getprestatus()){//sysj\controller.sysj line: 270, column: 15
                      liquidval_thread_23 += 8;//sysj\controller.sysj line: 272, column: 7
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                    else {
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                  }
                }
                else {
                  kill2_22.setPresent();//sysj\controller.sysj line: 265, column: 6
                  currsigs.addElement(kill2_22);
                  System.out.println("Emitted kill2_22");
                  if(liq3_22.getprestatus()){//sysj\controller.sysj line: 266, column: 15
                    liquidval_thread_23 += 4;//sysj\controller.sysj line: 267, column: 7
                    kill3_22.setPresent();//sysj\controller.sysj line: 269, column: 6
                    currsigs.addElement(kill3_22);
                    System.out.println("Emitted kill3_22");
                    if(liq4_22.getprestatus()){//sysj\controller.sysj line: 270, column: 15
                      liquidval_thread_23 += 8;//sysj\controller.sysj line: 272, column: 7
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                    else {
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                  }
                  else {
                    kill3_22.setPresent();//sysj\controller.sysj line: 269, column: 6
                    currsigs.addElement(kill3_22);
                    System.out.println("Emitted kill3_22");
                    if(liq4_22.getprestatus()){//sysj\controller.sysj line: 270, column: 15
                      liquidval_thread_23 += 8;//sysj\controller.sysj line: 272, column: 7
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                    else {
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                  }
                }
              }
              else {
                kill1_22.setPresent();//sysj\controller.sysj line: 260, column: 6
                currsigs.addElement(kill1_22);
                System.out.println("Emitted kill1_22");
                if(liq2_22.getprestatus()){//sysj\controller.sysj line: 261, column: 15
                  liquidval_thread_23 += 2;//sysj\controller.sysj line: 263, column: 7
                  kill2_22.setPresent();//sysj\controller.sysj line: 265, column: 6
                  currsigs.addElement(kill2_22);
                  System.out.println("Emitted kill2_22");
                  if(liq3_22.getprestatus()){//sysj\controller.sysj line: 266, column: 15
                    liquidval_thread_23 += 4;//sysj\controller.sysj line: 267, column: 7
                    kill3_22.setPresent();//sysj\controller.sysj line: 269, column: 6
                    currsigs.addElement(kill3_22);
                    System.out.println("Emitted kill3_22");
                    if(liq4_22.getprestatus()){//sysj\controller.sysj line: 270, column: 15
                      liquidval_thread_23 += 8;//sysj\controller.sysj line: 272, column: 7
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                    else {
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                  }
                  else {
                    kill3_22.setPresent();//sysj\controller.sysj line: 269, column: 6
                    currsigs.addElement(kill3_22);
                    System.out.println("Emitted kill3_22");
                    if(liq4_22.getprestatus()){//sysj\controller.sysj line: 270, column: 15
                      liquidval_thread_23 += 8;//sysj\controller.sysj line: 272, column: 7
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                    else {
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                  }
                }
                else {
                  kill2_22.setPresent();//sysj\controller.sysj line: 265, column: 6
                  currsigs.addElement(kill2_22);
                  System.out.println("Emitted kill2_22");
                  if(liq3_22.getprestatus()){//sysj\controller.sysj line: 266, column: 15
                    liquidval_thread_23 += 4;//sysj\controller.sysj line: 267, column: 7
                    kill3_22.setPresent();//sysj\controller.sysj line: 269, column: 6
                    currsigs.addElement(kill3_22);
                    System.out.println("Emitted kill3_22");
                    if(liq4_22.getprestatus()){//sysj\controller.sysj line: 270, column: 15
                      liquidval_thread_23 += 8;//sysj\controller.sysj line: 272, column: 7
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                    else {
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                  }
                  else {
                    kill3_22.setPresent();//sysj\controller.sysj line: 269, column: 6
                    currsigs.addElement(kill3_22);
                    System.out.println("Emitted kill3_22");
                    if(liq4_22.getprestatus()){//sysj\controller.sysj line: 270, column: 15
                      liquidval_thread_23 += 8;//sysj\controller.sysj line: 272, column: 7
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                    else {
                      kill4_22.setPresent();//sysj\controller.sysj line: 274, column: 6
                      currsigs.addElement(kill4_22);
                      System.out.println("Emitted kill4_22");
                      fifo_thread_23.add(liquidval_thread_23);//sysj\controller.sysj line: 275, column: 6
                      System.out.println(liquidval_thread_23);//sysj\controller.sysj line: 276, column: 6
                      S2477=1;
                      if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                        if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                          System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                          integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                          sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                          currsigs.addElement(sentliquid);
                          System.out.println("Emitted sentliquid");
                          S2525=0;
                          if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                            liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                            S2525=1;
                            active[23]=1;
                            ends[23]=1;
                            tdone[23]=1;
                          }
                          else {
                            S2520=0;
                            if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                              liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                              S2520=1;
                              if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                                liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                                ends[23]=2;
                                ;//sysj\controller.sysj line: 283, column: 6
                                System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                                S2477=0;
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                              else {
                                active[23]=1;
                                ends[23]=1;
                                tdone[23]=1;
                              }
                            }
                            else {
                              active[23]=1;
                              ends[23]=1;
                              tdone[23]=1;
                            }
                          }
                        }
                        else {
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                  }
                }
              }
            }
            else {
              S2477=1;
              if(requestliquid.getprestatus()){//sysj\controller.sysj line: 278, column: 12
                if(!fifo_thread_23.isEmpty()){//sysj\controller.sysj line: 279, column: 8
                  System.out.println("picked fifo");//sysj\controller.sysj line: 280, column: 6
                  integer1_thread_23 = fifo_thread_23.poll();//sysj\controller.sysj line: 281, column: 6
                  sentliquid.setPresent();//sysj\controller.sysj line: 282, column: 6
                  currsigs.addElement(sentliquid);
                  System.out.println("Emitted sentliquid");
                  S2525=0;
                  if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                    liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                    S2525=1;
                    active[23]=1;
                    ends[23]=1;
                    tdone[23]=1;
                  }
                  else {
                    S2520=0;
                    if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                      liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                      S2520=1;
                      if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                        liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                        ends[23]=2;
                        ;//sysj\controller.sysj line: 283, column: 6
                        System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                      else {
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                    }
                    else {
                      active[23]=1;
                      ends[23]=1;
                      tdone[23]=1;
                    }
                  }
                }
                else {
                  liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                  S2477=0;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
              }
              else {
                liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                S2477=0;
                active[23]=1;
                ends[23]=1;
                tdone[23]=1;
              }
            }
            break;
          
          case 1 : 
            switch(S2525){
              case 0 : 
                if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                  liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                  S2525=1;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  switch(S2520){
                    case 0 : 
                      if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                        liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                        S2520=1;
                        if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                          liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                          ends[23]=2;
                          ;//sysj\controller.sysj line: 283, column: 6
                          System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                          liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                          S2477=0;
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                        else {
                          active[23]=1;
                          ends[23]=1;
                          tdone[23]=1;
                        }
                      }
                      else {
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                      break;
                    
                    case 1 : 
                      if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                        liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                        ends[23]=2;
                        ;//sysj\controller.sysj line: 283, column: 6
                        System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                        liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                        S2477=0;
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                      else {
                        active[23]=1;
                        ends[23]=1;
                        tdone[23]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 1 : 
                S2525=1;
                S2525=0;
                if(!liquidBuffer_o.isPartnerPresent() || liquidBuffer_o.isPartnerPreempted()){//sysj\controller.sysj line: 283, column: 6
                  liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                  S2525=1;
                  active[23]=1;
                  ends[23]=1;
                  tdone[23]=1;
                }
                else {
                  S2520=0;
                  if(liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                    liquidBuffer_o.setVal(integer1_thread_23);//sysj\controller.sysj line: 283, column: 6
                    S2520=1;
                    if(!liquidBuffer_o.isACK()){//sysj\controller.sysj line: 283, column: 6
                      liquidBuffer_o.setREQ(false);//sysj\controller.sysj line: 283, column: 6
                      ends[23]=2;
                      ;//sysj\controller.sysj line: 283, column: 6
                      System.out.println(integer1_thread_23);//sysj\controller.sysj line: 284, column: 6
                      liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
                      S2477=0;
                      active[23]=1;
                      ends[23]=1;
                      tdone[23]=1;
                    }
                    else {
                      active[23]=1;
                      ends[23]=1;
                      tdone[23]=1;
                    }
                  }
                  else {
                    active[23]=1;
                    ends[23]=1;
                    tdone[23]=1;
                  }
                }
                break;
              
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread100205(int [] tdone, int [] ends){
        S100128=1;
    S100114=0;
    if(liquid4.getprestatus()){//sysj\controller.sysj line: 297, column: 24
      liq4_22.setPresent();//sysj\controller.sysj line: 297, column: 46
      currsigs.addElement(liq4_22);
      System.out.println("Emitted liq4_22");
      active[27]=1;
      ends[27]=1;
      tdone[27]=1;
    }
    else {
      S100114=1;
      active[27]=1;
      ends[27]=1;
      tdone[27]=1;
    }
  }

  public void thread100204(int [] tdone, int [] ends){
        S100108=1;
    S100094=0;
    if(liquid3.getprestatus()){//sysj\controller.sysj line: 295, column: 24
      liq3_22.setPresent();//sysj\controller.sysj line: 295, column: 46
      currsigs.addElement(liq3_22);
      System.out.println("Emitted liq3_22");
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
    else {
      S100094=1;
      active[26]=1;
      ends[26]=1;
      tdone[26]=1;
    }
  }

  public void thread100203(int [] tdone, int [] ends){
        S100088=1;
    S100074=0;
    if(liquid2.getprestatus()){//sysj\controller.sysj line: 293, column: 24
      liq2_22.setPresent();//sysj\controller.sysj line: 293, column: 46
      currsigs.addElement(liq2_22);
      System.out.println("Emitted liq2_22");
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
    else {
      S100074=1;
      active[25]=1;
      ends[25]=1;
      tdone[25]=1;
    }
  }

  public void thread100202(int [] tdone, int [] ends){
        S100068=1;
    S100054=0;
    if(liquid1.getprestatus()){//sysj\controller.sysj line: 291, column: 24
      liq1_22.setPresent();//sysj\controller.sysj line: 291, column: 46
      currsigs.addElement(liq1_22);
      System.out.println("Emitted liq1_22");
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
    else {
      S100054=1;
      active[24]=1;
      ends[24]=1;
      tdone[24]=1;
    }
  }

  public void thread100201(int [] tdone, int [] ends){
        S100048=1;
    fifo_thread_23 = new FIFO();//sysj\controller.sysj line: 250, column: 3
    liquidval_thread_23 = 0;//sysj\controller.sysj line: 252, column: 3
    S2477=0;
    active[23]=1;
    ends[23]=1;
    tdone[23]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S100130){
        case 0 : 
          S100130=0;
          break RUN;
        
        case 1 : 
          S100130=2;
          S100130=2;
          liq1_22.setClear();//sysj\controller.sysj line: 234, column: 2
          liq2_22.setClear();//sysj\controller.sysj line: 234, column: 2
          liq3_22.setClear();//sysj\controller.sysj line: 234, column: 2
          liq4_22.setClear();//sysj\controller.sysj line: 234, column: 2
          kill1_22.setClear();//sysj\controller.sysj line: 235, column: 2
          kill2_22.setClear();//sysj\controller.sysj line: 235, column: 2
          kill3_22.setClear();//sysj\controller.sysj line: 235, column: 2
          kill4_22.setClear();//sysj\controller.sysj line: 235, column: 2
          thread100201(tdone,ends);
          thread100202(tdone,ends);
          thread100203(tdone,ends);
          thread100204(tdone,ends);
          thread100205(tdone,ends);
          int biggest100206 = 0;
          if(ends[23]>=biggest100206){
            biggest100206=ends[23];
          }
          if(ends[24]>=biggest100206){
            biggest100206=ends[24];
          }
          if(ends[25]>=biggest100206){
            biggest100206=ends[25];
          }
          if(ends[26]>=biggest100206){
            biggest100206=ends[26];
          }
          if(ends[27]>=biggest100206){
            biggest100206=ends[27];
          }
          if(biggest100206 == 1){
            active[22]=1;
            ends[22]=1;
            break RUN;
          }
        
        case 2 : 
          liq1_22.setClear();//sysj\controller.sysj line: 234, column: 2
          liq2_22.setClear();//sysj\controller.sysj line: 234, column: 2
          liq3_22.setClear();//sysj\controller.sysj line: 234, column: 2
          liq4_22.setClear();//sysj\controller.sysj line: 234, column: 2
          kill1_22.setClear();//sysj\controller.sysj line: 235, column: 2
          kill2_22.setClear();//sysj\controller.sysj line: 235, column: 2
          kill3_22.setClear();//sysj\controller.sysj line: 235, column: 2
          kill4_22.setClear();//sysj\controller.sysj line: 235, column: 2
          thread100207(tdone,ends);
          thread100208(tdone,ends);
          thread100209(tdone,ends);
          thread100210(tdone,ends);
          thread100211(tdone,ends);
          int biggest100212 = 0;
          if(ends[23]>=biggest100212){
            biggest100212=ends[23];
          }
          if(ends[24]>=biggest100212){
            biggest100212=ends[24];
          }
          if(ends[25]>=biggest100212){
            biggest100212=ends[25];
          }
          if(ends[26]>=biggest100212){
            biggest100212=ends[26];
          }
          if(ends[27]>=biggest100212){
            biggest100212=ends[27];
          }
          if(biggest100212 == 1){
            active[22]=1;
            ends[22]=1;
            break RUN;
          }
          //FINXME code
          if(biggest100212 == 0){
            S100130=0;
            active[22]=0;
            ends[22]=0;
            S100130=0;
            break RUN;
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
    liq1_22 = new Signal();
    liq2_22 = new Signal();
    liq3_22 = new Signal();
    liq4_22 = new Signal();
    kill1_22 = new Signal();
    kill2_22 = new Signal();
    kill3_22 = new Signal();
    kill4_22 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[22] != 0){
      int index = 22;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[22]!=0 || suspended[22]!=0 || active[22]!=1);
      else{
        if(!df){
          liquidBuffer_o.gethook();
          placeOrder.gethook();
          liquid1.gethook();
          liquid2.gethook();
          liquid3.gethook();
          liquid4.gethook();
          requestliquid.gethook();
          df = true;
        }
        runClockDomain();
      }
      placeOrder.setpreclear();
      liquid1.setpreclear();
      liquid2.setpreclear();
      liquid3.setpreclear();
      liquid4.setpreclear();
      requestliquid.setpreclear();
      sentliquid.setpreclear();
      liq1_22.setpreclear();
      liq2_22.setpreclear();
      liq3_22.setpreclear();
      liq4_22.setpreclear();
      kill1_22.setpreclear();
      kill2_22.setpreclear();
      kill3_22.setpreclear();
      kill4_22.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = placeOrder.getStatus() ? placeOrder.setprepresent() : placeOrder.setpreclear();
      placeOrder.setpreval(placeOrder.getValue());
      placeOrder.setClear();
      dummyint = liquid1.getStatus() ? liquid1.setprepresent() : liquid1.setpreclear();
      liquid1.setpreval(liquid1.getValue());
      liquid1.setClear();
      dummyint = liquid2.getStatus() ? liquid2.setprepresent() : liquid2.setpreclear();
      liquid2.setpreval(liquid2.getValue());
      liquid2.setClear();
      dummyint = liquid3.getStatus() ? liquid3.setprepresent() : liquid3.setpreclear();
      liquid3.setpreval(liquid3.getValue());
      liquid3.setClear();
      dummyint = liquid4.getStatus() ? liquid4.setprepresent() : liquid4.setpreclear();
      liquid4.setpreval(liquid4.getValue());
      liquid4.setClear();
      dummyint = requestliquid.getStatus() ? requestliquid.setprepresent() : requestliquid.setpreclear();
      requestliquid.setpreval(requestliquid.getValue());
      requestliquid.setClear();
      sentliquid.sethook();
      sentliquid.setClear();
      liq1_22.setClear();
      liq2_22.setClear();
      liq3_22.setClear();
      liq4_22.setClear();
      kill1_22.setClear();
      kill2_22.setClear();
      kill3_22.setClear();
      kill4_22.setClear();
      liquidBuffer_o.sethook();
      if(paused[22]!=0 || suspended[22]!=0 || active[22]!=1);
      else{
        liquidBuffer_o.gethook();
        placeOrder.gethook();
        liquid1.gethook();
        liquid2.gethook();
        liquid3.gethook();
        liquid4.gethook();
        requestliquid.gethook();
      }
      runFinisher();
      if(active[22] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
