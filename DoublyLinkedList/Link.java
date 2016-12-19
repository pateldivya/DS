package DoublyLinkedList;

public class Link {
	public Link next;
	public int data;
	public Link previous;
	
	public Link(int data){
		this.data = data;
		next = null;
		previous = null;
	}
	
	public Link(Link previous, int data, Link next){
		this.previous = previous;
		this.data = data;
		this.next = next;
	}
	
	public int data(){
		return data;
	}
}
