// NAME: IntegerLinkedList.java
// PURPOSE:  make a implement of the interface InregerList
// AUTHOR:  Saige Liu V00812068
// DATE:  2014/2/07
// CREDITS: none -

public class IntegerLinkedList implements IntegerList
{
	private IntegerNode	head;
	private IntegerNode	tail;

	private	int		count;

	public IntegerLinkedList()
	{
		head = null;
		tail = null;
		count = 0;
	}

	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	 
	 //define whether it is empty
	 private boolean isEmpty() {
		if (this.head == null) return true;
		else return false;
	}
	
	
	public void addFront (int x){
		if(isEmpty()){
			IntegerNode front = new IntegerNode(x);
			head = front;
			tail= front;
		}else{
		IntegerNode front = new IntegerNode(x);
		front.setNext(head);
		head.setPrev(front);
		head = front;}
		}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 * 
	 * Examples:
	 * 
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */	
	public void addBack (int x){
		
		if(isEmpty()){
			IntegerNode back = new IntegerNode(x);
			head = back;
			tail = back;
		}else{
		IntegerNode back = new IntegerNode(x);
		back.setPrev(tail);
		tail.setNext(back);
		tail = back;
		}
		
	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size(){
		
		if (isEmpty()) return 0;

		int count = 1;
		IntegerNode curr = head;

		while ( curr.getNext() != null) {
			count++;
			curr = curr.getNext();
		}
		return count;
	}

	
	/* 
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 * 
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 * 
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos)
	{
			if (isEmpty()) return -1;

		IntegerNode curr = head;

		for (int i = 0; curr != null && i < pos; i++) {
			curr = curr.getNext();
		}

		if (curr == null) return -1;
		else return curr.getValue();

	}
	
	/* 
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear(){
		head= null;
		tail=null;
		count =0;
	}

	/* 
	 * PURPOSE:
	 *   Remove all instances of value from the list. 
	 * 
	 * PRECONDITIONS:
	 *	None.
	 * 
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value){ 
		//it the list is empty
		if(size()==0){
			clear();
		}
		IntegerNode temp= head; 
		while(temp!=null){
			if(temp.getValue()==value){
			//I try to use resursion to fix bugs but not necessary, right?
				 
				 //if the number is the head of the list 
				 if(head==temp){
					head=temp.next;
					/*temp.next=null;
					remove(value);*/
					temp=temp.next;
					
					//if the number if the tail of the list
					}else if(tail==temp){
					tail=temp.prev;
					temp.prev.next=null;
					temp.prev=null;
					/*remove(value);*/
					temp=temp.next;
					
					//if the number it in the middle of them. 
					}else {
					temp.prev.next=temp.next;
					temp.next.prev=temp.prev;
					/*temp.next=null;
					temp.prev=null;*/
					temp=temp.next;}
			}
				else{temp=temp.next;}
		}
	}


	public String toString(){
		String result = "";

		IntegerNode curr = head;
		if(isEmpty()){
			result="{}";
			return result;
		}

	
		if (! isEmpty() ) {
			result += curr.getValue();
		}

		while (curr.getNext() != null) {
			curr = curr.getNext();
			result +=","+curr.getValue();
		}

		return "{"+result+"}";
		
	}
}
