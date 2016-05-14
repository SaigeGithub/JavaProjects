// NAME: LLStack.java
// PURPOSE:  implement the stack interface specified in stack.java using a linked list structure
// AUTHOR:  Saige Liu V00812068
// DATE:  2014/3/14
// CREDITS: none 

public class LLStack<T> implements Stack<T>{
	private Node<T> head;

	public LLStack() {
		this.head = null;
	}
    
	public boolean empty() {
		if (this.head == null) return true;
		else return false;
	}
	
	public int size() {

		if (empty()) return 0;

		//in this way to calculate count, i wont need to trace it everything time
		int count = 1;
		Node<T> curr = head;

		while ( curr.getNext() != null) {
			count++;
			curr = curr.getNext();
		}
		return count;
	}
	
	public void push (T o){
	
		Node<T> theNode = new Node<T>(o, head);
		head = theNode;
	
	}
	
	public T pop() throws StackEmptyException
	{
		if (empty()==true)
		{
			throw new StackEmptyException("Stack empty");
		}
			Node<T>temp= head;
			head=head.getNext();
			
	
		return temp.getItem();
	}
	
	
	public T peek() throws StackEmptyException
	{
		if (empty())
		{	throw new StackEmptyException("Stack empty");
		}
			Node<T> temp=head;
		return temp.getItem();
	}
	
		public void makeEmpty()
	{
		head=null;
	}

}