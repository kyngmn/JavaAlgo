package deque;

import java.util.Deque;
import java.util.LinkedList;

public class DequePrac {

	public static void main(String[] args) {
		Deque<Integer> dq = new LinkedList<>();

		dq.offer(2);
		dq.offer(5);
		dq.offerFirst(1);

		System.out.println(dq);
		System.out.println(dq.poll());
		System.out.println(dq.poll());
	}
}
