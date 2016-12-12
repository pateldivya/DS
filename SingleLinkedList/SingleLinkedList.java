
public class SingleLinkedList {
	private Link head;
	
	public SingleLinkedList(){
		head = null;
	}
	
	public void insertData(int data){
		Link newNode = new Link(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void print(){
		if(head == null){
			System.out.println("No Data Inserted");
		} else {
			Link tempNode = head;
			while(tempNode != null){
				System.out.println(tempNode.data());
				tempNode = tempNode.next;
			}
		}
	}
	
	public void delete(){
		if(head == null){
			System.out.println("Cant delete the data");
		} else {
			head = head.next;
		}
	}
	
	public void deleteData(int data){
		if(head == null){
			System.out.println("No data in linked list");
		}
		else if(head.data() == data){
			head = head.next;
		}else {
			Link tempLink = head;
			while(tempLink.next.data() != data){
				tempLink = tempLink.next;
			}
			Link newNode = tempLink.next;
			tempLink.next = newNode.next;
		}
	}
	public void insertAsIWant(int node, int data){
		if(head == null){
			System.out.println("No data in linked list");
			//return 0;
		}
		else{
			Link tempLink = head;
			while(tempLink.data() != node ){
				tempLink = tempLink.next;
			}
			Link newNode = new Link(data);
			newNode.next = tempLink.next;
			tempLink.next = newNode;
		}	
		
	}
	public void updateValue(int node, int value){
		if(head == null){
			System.out.println("No data in linked list");
			//return 0;
		}
		else{
			Link tempLink = head;
			while(tempLink.data() != node ){
				tempLink = tempLink.next;
			}
			//Link newNode = new Link(value);
			tempLink.data = value;
		}
	}
	
	public static void main(String args[]){
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.insertData(5);
		linkedList.insertData(10);
		linkedList.insertData(7);
		linkedList.insertData(15);
		//linkedList.deleteData(15);
		linkedList.insertAsIWant(7, 20);
		linkedList.insertAsIWant(5, 30);
		linkedList.updateValue(5, 40);
		linkedList.print();
	}
}
