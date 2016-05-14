// NAME: HeapPriorityQuenue.java
// PURPOSE:  The heap will store objects that implement the Comparable interface
// AUTHOR:  Saige Liu V00812068
// DATE:  2014/4/4
// CREDITS: none 
 
public class HeapPriorityQueue implements PriorityQueue
{
	protected final static int DEFAULT_SIZE = 10000;
	
	
	protected Comparable storage[];

	
	protected int currentSize;
			

	public HeapPriorityQueue () 
	{
		this(DEFAULT_SIZE);
	}

	public HeapPriorityQueue(int size)
	{
		storage = new Comparable[size + 1];
		currentSize = 0;
	}
	
	
	public int size ()
	{
		return currentSize;
	}
	
	public boolean isEmpty ( )
	{
		return size() == 0;
	}
	
	//In a heap tree ,it will swap the one on the most right side with the one on the top
	public Comparable removeMin () throws HeapEmptyException
	{
		Comparable min = storage[1];
		storage[1] = storage[currentSize];
		storage[currentSize] = null;
		currentSize--;
		//use the bubbleDown to sort the heap
		bubbleDown();
		return min;
	}
	
	//I insert new number in the position 1 after the currentSize
	public void insert ( Comparable k  ) throws HeapFullException
	{
		currentSize++;
		storage[currentSize] = k;
		//use bubbleUp to re-sort the heap
		bubbleUp();
	}


	private void bubbleUp ( ) 
	{
		int index = currentSize;
		//In bubbleUp ,I sort the last element to the right position
		while (parent(index) >= 1 && storage[parent(index)].compareTo(storage[index]) > 0) {
			swapElement(index, parent(index));
			index = parent(index);
		}
	}

	
	private void bubbleDown() 
	{
		
		//In bubbleDown,I sort the one on the top to the right position
		int index = 1;
		//storage[1]is the one we want to begin with
		while (hasLeft(index)) {
			//now find the smaller one in leftchild and rightchild
			int smallerChild = leftChild(index);
			if(hasRight(index) && storage[leftChild(index)].compareTo(storage[rightChild(index)]) > 0) {
				smallerChild = rightChild(index);
			}
			//then compare with parent to see if need to swap
			if (storage[index].compareTo(storage[smallerChild]) > 0) {
				swapElement(index, smallerChild);
			} else {
				break;
			}
			index = smallerChild;
		}
	}	
	
	//use a temp to store the value we want to swap
	private void swapElement ( int p1, int p2 )
	{
		Comparable temp = storage[p1];
		storage [p1] = storage[p2];
		storage	[p2] = temp;
	}
	
	//because it is int, parent is always pos/2, if it is on pos 3 the answer is still one
	private int parent ( int pos )
	{
		return pos / 2; 
	}
	

	private int leftChild ( int pos )
	{
		return pos * 2; 
	}
	
	
	private int rightChild ( int pos )
	{	
		return pos * 2 + 1; 
	}
	
	
	private boolean hasLeft ( int pos )
	{
		return pos * 2 <= currentSize; 
	}

		
	private boolean hasRight ( int pos )
	{
		return pos * 2 + 1 <= currentSize; 
	}
}
