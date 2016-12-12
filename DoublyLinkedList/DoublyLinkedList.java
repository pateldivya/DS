package DoublyLinkedList;

public class DoublyLinkedList {
	private Link head;
	
	public DoublyLinkedList(){
		head = null;
	}
	public void insetDataFront(int data){
		if(head == null){
			head = new Link(null, data, null);
		}
		else{
			Link newLink = new Link(null, data, head);
			head.previous = newLink;
			head = newLink;
			
		}
		
	}
	public void insetDataAsWant(int data, int node){
		Link tempLink = head;
		while(tempLink.data != node){
			tempLink = tempLink.next;
			
		}
		Link newData = new Link(tempLink, data, tempLink.next);
		tempLink.next = newData;
		
	}
		
	
	public void deleteData(){
		if(head == null){
			System.out.println("no data exists");
		}
		else{
			head = head.next;
		}
	}
	public void print(){
		Link current = head;
		while(current !=null){
			System.out.println(current.data());
			current  = current.next;
		}
	}
	public static void main(String args[]){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insetDataFront(10);
		dll.insetDataFront(20);
		dll.insetDataFront(30);
		dll.insetDataAsWant(15, 20);
		//dll.deleteData();
		dll.print();
	}

}
