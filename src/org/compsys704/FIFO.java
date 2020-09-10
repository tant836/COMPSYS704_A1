package org.compsys704;
import java.util.Queue;
import java.util.LinkedList;

public class FIFO {
	Queue<Integer> fifo;
	
	public FIFO() {
		fifo = new LinkedList<>();
	}
	
	public boolean add(int arg0) {
		return fifo.add(arg0);
	}
	
	public Integer poll() {
		return fifo.poll();
	}
	
	public boolean isEmpty() {
		return fifo.isEmpty();
	}

}
