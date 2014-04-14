package February;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String args[]) {
		LRUCache l = new LRUCache(3);
		l.set(2, 2);
		l.set(3, 3);
		l.set(2, 4);
		System.out.println(l.get(2));
	}

	Map<Integer, Node> map;
	LinkedList list;
	int capacity;

	public LRUCache(int capacity) {
		map = new HashMap<>();
		list = new LinkedList();
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			return map.get(key).value;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			list.remove(node);
			Node newnode = list.insert(key, value);
			map.put(key, newnode);
		} else if (list.size < capacity) {
			Node node = list.insert(key, value);
			map.put(key, node);
		} else {
			Node node = map.get(key);
			list.remove(node);
			map.remove(node.key);
			Node newnode = list.insert(key, value);
			map.put(key, newnode);
		}
	}
}

class Node {
	Node before;
	Node after;
	int key;
	int value;

	Node(int key, int value) {
		before = null;
		after = null;
		this.key = key;
		this.value = value;
	}
}

class LinkedList {
	Node head, last;
	int size;

	LinkedList() {
		size = 0;
		head = null;
		last = null;
	}

	Node insert(int key, int value) {
		size++;
		if (head == null) {
			head = new Node(key, value);
			last = head;
			return head;
		} else {
			Node tmp = new Node(key, value);
			last.after = tmp;
			tmp.before = last;
			last = tmp;
			return tmp;
		}
	}

	void removeHead() {
		remove(head);
	}

	void remove(Node node) {
		size--;
		if (node == head) {
			node.after.before = null;
			head = node.after;
		} else if (node == last) {
			last = last.before;
			last.after = null;
		} else {
			node.before.after = node.after;
		}
	}

	void update(Node node, int value) {
		node.value = value;
	}
}

//
// public class LRUCache {
// // create a double-linked list
// private HashMap<Integer, Integer> map;
// private DoubleLinkedList list;
// private int cap;
//
// public LRUCache(int capacity) {
// map = new HashMap<Integer, Integer>();
// list = new DoubleLinkedList();
// cap = capacity;
// }
//
// public int get(int key) {
// if (map.containsKey(key)) {
// list.remove(new Integer(key));
// list.add(key);
// return map.get(key);
// } else {
// return -1;
// }
// }
//
// public void set(int key, int value) {
//
// if (map.containsKey(key)) {
// map.put(key, value);
// list.remove(new Integer(key));
// list.add(key);
// } else {
// if (list.size() >= cap) {
// int old = list.get(0);
// map.remove(old);
// list.remove(0);
// }
// list.add(key);
// map.put(key, value);
// }
// }
// }
//
// class DoubleLinkedList {
// private int size;
// private Node head;
// private Node tail;
// private HashMap<Integer, Node> nodeMap;
//
// public DoubleLinkedList() {
// size = 0;
// nodeMap = new HashMap<Integer, Node>();
// head = null;
// tail = null;
// }
//
// public void remove(Integer key) {
// if (nodeMap.containsKey(key)) {
// Node tmp = nodeMap.get(key);
// if (tmp.prev == null) {
// head = tmp.next;
// head.prev = null;
// } else if (tmp.next == null) {
// tail = tmp.prev;
// tail.next = null;
// } else {
// tmp.prev.next = tmp.next;
// }
// size--;
// }
// }
//
// public void add(int i) {
// if (head == null) {
// head = new Node(i);
// nodeMap.put(i, head);
// tail = head;
// } else {
// tail.next = new Node(i);
// nodeMap.put(i, tail.next);
// tail = tail.next;
// }
// size++;
// }
//
// public int get(int i) {
// if (i == 0) {
// return head.val;
// }
// return -1;
// }
//
// public int size() {
// return size;
// }
//
// }
//
// class Node {
// public Node prev;
// public Node next;
// public int val;
//
// public Node(int v) {
// val = v;
// prev = null;
// next = null;
// }
// }
