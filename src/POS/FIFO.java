package POS;
import java.util.Queue;
import java.util.LinkedList;

public class FIFO {
	static Queue<Integer> fifo = new LinkedList<>();;
	
//	public FIFO() {
//		fifo = new LinkedList<>();
//	}
	
	public static boolean add(int arg0) {
		return fifo.add(arg0);
	}
	
	public static Integer poll() {
		return fifo.poll();
	}
	
	public static boolean isEmpty() {
		return fifo.isEmpty();
	}

	public static Integer peek() {
		return fifo.peek();
	}
	
	public static int size() {
		return fifo.size();
	}
}
