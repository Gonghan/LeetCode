package April;

public class myLinkedList<T> {

	Node<T> fakeHead;
	Node<T> fakeTail;

	public myLinkedList() {
		fakeHead = new Node<T>(null);
		fakeTail = new Node<T>(null);
		fakeHead.after = fakeTail;
		fakeTail.before = fakeHead;
	}

	boolean empty() {
		return fakeHead.after == fakeTail;
	}

	Node<T> append(T value) {
		Node<T> node = new Node<T>(value);
		node.before = fakeTail.before;
		fakeTail.before.after = node;
		node.after = fakeTail;
		fakeTail.before = node;
		return node;
	}

	void remove(Node<T> node) {
		node.before.after = node.after;
		node.after.before = node.before;
	}

	Node<T> addFirst(T value) {
		Node<T> node = new Node<T>(value);
		node.after.before = node;
		node.after = fakeHead.after;
		node.before = fakeHead;
		fakeHead.after = node;
		return node;
	}

	Node<T> addLast(T value) {
		return this.append(value);
	}

	Node<T> get(int index) {
		Node<T> tmp = fakeHead.after;
		for (int i = 0; i < index; i++) {
			tmp = tmp.after;
		}
		return tmp;
	}

	T getLast() {
		return fakeTail.before.value;
	}

	T getFirst() {
		return fakeHead.after.value;
	}

	void removeFirst() {
		remove(fakeHead.after);
	}

	void removeLast() {
		remove(fakeTail.before);
	}

	@Override
	public String toString() {
		String result = "List: ";
		Node<T> tmp = fakeHead.after;
		while (tmp != fakeTail) {
			result += "" + tmp.value + ", ";
			tmp = tmp.after;
		}
		return result;
	}

	public static void main(String args[]) {
		myLinkedList<Integer> list = new myLinkedList<Integer>();
		list.append(1);
		list.append(2);
		Node<Integer> tmp = list.append(3);
		list.append(4);
		list.append(3);
		list.append(4);
		list.append(29);
		System.out.println(list);
		list.remove(tmp);
		System.out.println(list);
		list.removeFirst();
		list.removeLast();
		System.out.println(list);
		System.out.println(list.get(3).value);
	}
}

class Node<T> {
	Node<T> before;
	Node<T> after;
	T value;

	public Node(T value) {
		this.value = value;
	}
}