package April;

public class myLinkedList {

	Node fakeHead;
	Node fakeTail;

	public myLinkedList() {
		fakeHead = new Node(-1);
		fakeTail = new Node(-1);
		fakeHead.after = fakeTail;
		fakeTail.before = fakeHead;
	}

	Node append(int value) {
		Node node = new Node(value);
		node.before = fakeTail.before;
		fakeTail.before.after = node;
		node.after = fakeTail;
		fakeTail.before = node;
		return node;
	}

	void remove(Node node) {
		node.before.after = node.after;
	}

	Node addFirst(int value) {
		Node node = new Node(value);
		node.after.before = node;
		node.after = fakeHead.after;
		node.before = fakeHead;
		fakeHead.after = node;
		return node;
	}

	Node addLast(int value) {
		return this.append(value);
	}

	Node get(int index) {
		Node tmp = fakeHead.after;
		for (int i = 0; i < index; i++) {
			tmp = tmp.after;
		}
		return tmp;
	}

	void removeFirst() {
		remove(fakeHead.after);
	}

	void removeLast() {
		remove(fakeTail.before);
	}

	public String toString() {
		String result = "List: ";
		Node tmp = fakeHead.after;
		while (tmp != fakeTail) {
			result += "" + tmp.value+", ";
			tmp = tmp.after;
		}
		return result;
	}

	public static void main(String args[]) {
		myLinkedList list = new myLinkedList();
		list.append(1);
		list.append(2);
		Node tmp = list.append(3);
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

class Node {
	Node before;
	Node after;
	int value;

	public Node(int value) {
		this.value = value;
	}
}