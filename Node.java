// NAME: Node.java
// PURPOSE:  it is a Node for my linked list implementation 
// AUTHOR:  Saige Liu V00812068
// DATE:  2014/3/14
// CREDITS: none 

public class Node<T> {
	//it is private so that I use Node.getItem()every time
	  private T item;
	  private Node<T> next;


	  public Node() {
		  this.next = null;
	  }

	  public Node(T newItem) {
		  this.item = newItem;
		  this.next = null;
	  }

	  public Node(T newItem, Node<T> newNext) {
	  		  this.item = newItem;
	  		  this.next = newNext;
	  }

	  public T getItem() {
		  return this.item;
	  }

	  public void setItem(T newItem) {
		  this.item = newItem;
	  }

	  public Node<T> getNext() {
		  return this.next;
	  }

	  public void setNext( Node<T> newNext) {
		  this.next = newNext;
	  }
	  //T is useful, but it sometimes confused me,should I use T or int or integer? :/
}
