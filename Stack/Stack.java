import java.util.Scanner;

public class Stack {
	public static int stackarray[];
	static int  top=-1, stacksize=5;
	public static Scanner s;
	
	public static void main(String args[]){
		int operation,a;
		stackarray = new int[stacksize];
		 s = new Scanner(System.in);	
		System.out.println("1)push");
		System.out.println("2) pop");
		operation = s.nextInt();
		if(operation == 1){
			push();
		}
		else if(operation ==2){
			pop();
		}
		else{
			System.out.println("eneter proper choice");
		}
		
		
	}
	public static void push(){
		top = top+1;
		if(top>=stacksize){
			System.out.println("stack is full");
			System.out.println("1) push");
			System.out.println("2) Pop" );
			if(s.nextInt()==1){
				push();
			}
			else if(s.nextInt()==2){
				pop();
			}
		}
		else{
			System.out.println("Enter value");
			
			//top = top+1;
			
			stackarray[top]= s.nextInt();
			for(int i=0; i<=top;i++){
				System.out.println(stackarray[i]);
			}
			System.out.println("1) push");
			System.out.println("2) Pop" );
			if(s.nextInt()==1){
				push();
			}
			else if(s.nextInt()==2){
				pop();
			}
			
		}
	}
	public static  void pop(){
		top--;
		if(top==-1){
			System.out.println("stack is already empty");
			System.out.println("1) push");
			System.out.println("2) Pop" );
			if(s.nextInt()==1){
				push();
			}
			else if(s.nextInt()==2){
				pop();
			}
		}
		else{
			for(int i=0;i<=top;i++){
				System.out.println("00000");
				System.out.println(stackarray[i]);
			}
		
			System.out.println("1) push");
			System.out.println("2) Pop" );
			if(s.nextInt()==1){
				push();
			}
			else if(s.nextInt()==2){
				pop();
			}
		}
	}

}
