package Assign1;

public class LinkedNode<T> {
	private T data;  
    private LinkedNode<T> next;  
    
    public LinkedNode() {  
       this.data = null;  
        this.next = null;  
    }  
      
    public LinkedNode(T data) {  
        this.data = data;  
        this.next = null;  
    }

    public LinkedNode<T> getNext() {
    	return this.next;
    }

    public void setNext(LinkedNode<T> n) {
    	this.next = n;
    }

    public T getElement() {
    	return this.data;
    }

    public void setElement(T val) {
    	this.data = val;
    }
}

