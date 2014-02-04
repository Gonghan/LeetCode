package February;

import java.util.HashMap;

public class LRUCache {
	// create a double-linked list
	private HashMap<Integer, Integer> map;
	private DoubleLinkedList list;
	private int cap;

	public LRUCache(int capacity) {
		map = new HashMap<Integer, Integer>();
		list = new DoubleLinkedList();
		cap = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			list.remove(new Integer(key));
			list.add(key);
			return map.get(key);
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {

		if (map.containsKey(key)) {
			map.put(key, value);
			list.remove(new Integer(key));
			list.add(key);
		} else {
			if (list.size() >= cap) {
				int old = list.get(0);
				map.remove(old);
				list.remove(0);
			}
			list.add(key);
			map.put(key, value);
		}
	}
}

class DoubleLinkedList {
	private int size;
	private Node head;
	private Node tail;
	private HashMap<Integer, Node> nodeMap;

	public DoubleLinkedList() {
		size = 0;
		nodeMap = new HashMap<Integer, Node>();
		head = null;
		tail = null;
	}

	public void remove(Integer key) {
		if (nodeMap.containsKey(key)) {
			Node tmp = nodeMap.get(key);
			if (tmp.prev == null) {
				head = tmp.next;
				head.prev = null;
			} else if (tmp.next == null) {
				tail = tmp.prev;
				tail.next = null;
			} else {
				tmp.prev.next = tmp.next;
			}
			size--;
		}
	}

	public void add(int i) {
		if (head == null) {
			head = new Node(i);
			nodeMap.put(i, head);
			tail = head;
		} else {
			tail.next = new Node(i);
			nodeMap.put(i, tail.next);
			tail = tail.next;
		}
		size++;
	}

	public int get(int i) {
		if (i == 0) {
			return head.val;
		}
		return -1;
	}

	public int size() {
		return size;
	}

}

class Node {
	public Node prev;
	public Node next;
	public int val;

	public Node(int v) {
		val = v;
		prev = null;
		next = null;
	}
}
