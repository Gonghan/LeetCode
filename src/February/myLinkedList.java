package February;

public class myLinkedList {
	myNode first;
	myNode last;
	int size;

	public myLinkedList() {

	}

	myNode append(int key, int value) {
		myNode node = new myNode(key, value);
		
		return node;
	}

	void remove(myNode node) {
		
	}

	void removeFirst() {
		remove(first);
	}
}

class myNode {
	Node before;
	Node after;
	int key;
	int value;

	myNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
