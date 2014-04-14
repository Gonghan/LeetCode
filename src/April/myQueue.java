package April;

public class myQueue<T> {

	myLinkedList<T> queue;

	public myQueue() {
		queue = new myLinkedList<T>();
	}

	void offer(T t) {
		queue.append(t);
	}

	T peek() {
		return queue.getFirst();
	}

	T poll() {
		T t = queue.getFirst();
		queue.removeFirst();
		return t;
	}

	boolean empty() {
		return queue.empty();
	}

	@Override
	public String toString() {
		return queue.toString();
	}

	public static void main(String args[]) {
		myQueue<Integer> queue = new myQueue<Integer>();
		queue.offer(1);
		System.out.println(queue);
		queue.offer(2);
		System.out.println(queue);
		queue.offer(3);
		System.out.println(queue);
		queue.offer(4);
		System.out.println(queue);
		queue.peek();
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		System.out.println(queue.empty());
		queue.poll();
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		queue.poll();
		System.out.println(queue);
		System.out.println(queue.empty());
	}
}
