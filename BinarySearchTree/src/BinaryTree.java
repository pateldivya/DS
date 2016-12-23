
public class BinaryTree {
	
	static Node root;
	
	public void addNewNode(int key, String name){
		
		Node newNode = new Node(key, name);
		if(root == null){
			root = newNode;
		}
		else{
			Node focusNode = root;
			Node parent;
			
			while(true){
				parent = focusNode;
				
				if(key < focusNode.key){
					focusNode = focusNode.leftChild;
					if(focusNode == null){
						parent.leftChild = newNode;
						return;
					}
					
				}
				else{
					focusNode = focusNode.rightChild;
					if(focusNode == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public static void inOrderedTraverseTree(Node focusNode){
		if(focusNode != null){
			
			inOrderedTraverseTree(focusNode.leftChild);
			System.out.println(focusNode.key);
			inOrderedTraverseTree(focusNode.rightChild);
		}
	}
	
	public void preOrderedTraverseTree(Node focusNode){
		if(focusNode != null){
			System.out.println(focusNode.key);
			preOrderedTraverseTree(focusNode.leftChild);
			preOrderedTraverseTree(focusNode.rightChild);
		}
	}
	
	public void postOrderedTraverseTree(Node focusNode){
		if(focusNode != null){
			postOrderedTraverseTree(focusNode.leftChild);
			postOrderedTraverseTree(focusNode.rightChild);
			System.out.println(focusNode.key);
		}
	}
	
	public Node searchNode(int key){
		Node focusNode = root;
		
		while(focusNode.key != key){
			if(key < focusNode.key){
				focusNode = focusNode.leftChild;
			}
			else{
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null){
				return null;
			}
		}
		return focusNode;
	}
	
	public static boolean deleteNode(int key){
		
		Node focusNode = root;
		Node parent = root;
		
		boolean isleft =true;
		
		while(focusNode.key != key){
			parent = focusNode;
			
			if(key < focusNode.key){
				isleft = true;
				focusNode = focusNode.leftChild;
				
			}
			else{
				isleft = false;
				focusNode = focusNode.rightChild;
			}
			if(focusNode == null){
				return false;
			}
		}
		
		if(focusNode.leftChild==null && focusNode.rightChild==null){
			if(focusNode==root){
				root=null;
				
			}
			else if(isleft){
				parent.leftChild=null;
			}
			else{
				parent.rightChild =null;
			}
		}
		else if(focusNode.rightChild == null){
			if(focusNode==root){
				root = focusNode.leftChild;
			}
			else if(isleft){
				parent.leftChild = focusNode.leftChild;
			}
			else{
				parent.rightChild = focusNode.leftChild;
			}
		}
		else if(focusNode.leftChild == null){
			if(focusNode==root){
				root = focusNode.rightChild;
			}
			else if(isleft){
				parent.leftChild = focusNode.rightChild;
			}
			else{
				parent.rightChild = focusNode.rightChild;
			}
		}
		else{
			Node replacementNode = getReplacementNode(focusNode);
			
			if(focusNode == root){
				root = replacementNode;
			}
			else if(isleft){
				parent.leftChild = replacementNode;
			}
			else{
				parent.rightChild = replacementNode;
			}
		}
		return true;
	}
	
	private static Node getReplacementNode(Node node) {
		// TODO Auto-generated method stub
		Node replacementNode = node;
		Node replacementParent = node;

		Node focusNode=node.rightChild;
		while(focusNode != null){
			replacementParent = replacementNode;
			replacementNode = focusNode;
			focusNode = focusNode.leftChild;
			
		}
		
		if(replacementNode != node.rightChild){
			replacementParent.leftChild = replacementNode.rightChild;
			replacementNode.rightChild = node.rightChild;
		}
		return replacementNode;
	}

	public static void main(String[] args){
		BinaryTree theTree = new BinaryTree();
		theTree.addNewNode(53, "a");
		theTree.addNewNode(29, "b");
		theTree.addNewNode(106, "c");
		theTree.addNewNode(12, "d");
		theTree.addNewNode(37, "e");
		theTree.addNewNode(79, "f");
		
		inOrderedTraverseTree(theTree.root);
		boolean status = deleteNode(37);
		System.out.println("After deletion" + status);
		inOrderedTraverseTree(theTree.root);
		//System.out.println("Key 12" + theTree.searchNode(12).key);
	
		
	}

}

class Node {
	 	int key;
	 	String name;
	 	
	 	Node leftChild;
	 	Node rightChild;
	 	
	 	Node(int key, String name){
	 		this.key = key;
	 		this.name = name;
	 	}
	 	public String toString(int key,String name){
	 		return  name + "has a key" + key ;
	 	}
}
