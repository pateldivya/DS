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
	
	public void deleteMultipleData(int data){
		Link ptr = head;
		while(ptr != null){
			if(ptr.data() == data){
				if(ptr == head){
					ptr = ptr.next;
					head = head.next;
					
				}
				
			}
			else if(ptr.next != null){
				
				if(ptr.next.data() == data){
					
					ptr.next = ptr.next.next;
					ptr = ptr.next;
				}	
				else{
					ptr = ptr.next;
				}
			
		
			}
			else{
				ptr = null;
			}
			
		}
	}
	
	public void swapNodes(int x, int y){
		if (x == y) return;
		 
        // Search for x (keep track of prevX and CurrX)
        Link prevX = null, currX = head;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }
 
        // Search for y (keep track of prevY and currY)
        Link prevY = null, currY = head;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }
 
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;
 
        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;
 
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;
 
        // Swap next pointers
        Link temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
	}
	
	public static void main(String args[]){
		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.insertData(5);
		linkedList.insertData(10);
		linkedList.insertData(7);
		linkedList.insertData(15);
		linkedList.deleteData(15);
		linkedList.insertAsIWant(7, 20);
		linkedList.insertAsIWant(5, 30);
		linkedList.updateValue(5, 40);
		linkedList.deleteMultipleData(7);
		linkedList.swapNodes(20,40);
		
		linkedList.print();
	}
}