package linkedlist;

// 클래스 구현 연습
public class Node<T> {
	public T data;
	public Node<T> link;

	public Node() {
	}

	public Node(T data) {
		this.data = data;
	}
}
