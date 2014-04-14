package April;

public class myStack<T> {

	myLinkedList<stackNode<T>> stack;
	
	

	public myStack() {
		this.stack = new myLinkedList<stackNode<T>>();
	}

	boolean empty() {
		return stack.empty();
	}

	stackNode<T> peek() {
		return stack.getLast();
	}

	stackNode<T> pop() {
		stackNode<T> node = stack.getLast();
		stack.removeLast();
		return node;
	}

	void push(T value) {
		stack.append(new stackNode<T>(value));
	}

	public static void main(String args[]) {
		myStack<Integer> stack = new myStack<Integer>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		System.out.println(stack.peek().value);
		System.out.println(stack.pop().value);
		System.out.println(stack.empty());
		System.out.println(stack.pop().value);
		System.out.println(stack.pop().value);
		System.out.println(stack.empty());
	}
}

class stackNode<T> {
	T value;

	stackNode(T value) {
		this.value = value;
	}
}