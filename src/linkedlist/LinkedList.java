package linkedlist;

public class LinkedList<T> {
	// first X
	// head
	private Node<T> head;
	private int size;

	public LinkedList() {
	}

	public Node<T> get(int idx) {
		if (idx < 0 || idx >= size) {
			return null;
		}
		// i = 0;
		Node<T> res = head;

		// if idx = 0
		// loop돌기전: res.link -> head.link
		// 0: res.link -> second.link
		// 1: res.link -> third.link
		for (int i = 0; i < idx; i++) {
			res = res.link;
		}
		return res;
	}

	public void addFirst(T data) {
		Node<T> node = new Node<>(data);
		node.link = head;
		head = node;
		size++;
	}
}
