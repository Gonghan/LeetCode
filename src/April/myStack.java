package April;

public class myStack<T> {

	myLinkedList<stackNode<T>>stack;
	
	
	
	boolean empty(){
		return stack.empty();
	}
	
	stackNode<T> peek(){
		return stack.getLast().value;
	}
	
	stackNode<T> pop(){
		stackNode<T> node =stack.getLast().value;
		stack.removeLast();
		return node;
	}
	
	void push(T value){
		stack.append(new stackNode<T>(value));
	}
	
	public static void main(String args[]){
		
	}
}

class stackNode<T>{
	T value;
	stackNode(T value){
		this.value=value;
	}
}