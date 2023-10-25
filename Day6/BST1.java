class BST1{
	
	Node root;
	static class Node{
	int data;
	Node left, right;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	}
	
	BST1()
	{
		root = null;
	}
	
	BST1(int d)
	{
		root = new Node(d);//Root assign kar rahe hai
	}
	
	void printInorder(Node root)
	{
	if(root == null)
		return;
	printInorder(root.left);
	System.out.print(root.data+ " ");
	printInorder(root.right);
	
	}
	
	void printPreorder(Node root)
{
	if(root == null)
		return;
	
	System.out.print(root.data+ " ");
	printPreorder(root.left);
	printPreorder(root.right);
	
}

void printPostorder(Node root)
{
	if(root == null)
		return;
	
	
	printPostorder(root.left);
	printPostorder(root.right);
	System.out.print(root.data+ " ");
	
}
	void Inorder(){
		printInorder(root);
	}
	
	void Preorder(){
		printPreorder(root);
	}
	
	void Postorder(){
		printPostorder(root);
	}
	
	Node insertdata(Node root, int key)
	{
		if(root == null)
		{
			root = new Node(key);
			return root;
			
		}
		if(key <= root.data)
			root.left = insertdata(root.left, key);
		else
			root.right = insertdata(root.right, key);
		
		return root;
	}
	
	void insert(int key)
	{
		root = insertdata(root, key);
	}
	
	Node deletedata(Node root,int key)
	{
		if(root == null)
			return root;
		if(key < root.data)
			root.left = deletedata(root.left, key);
		else if(key > root.data)
			root.right = deletedata(root.right, key);
		else{
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			
			//case 3
			root.data = minvalue(root.right);
			
			root.right = deletedata(root.right, root.data);
		}
		return root;
	}
	
	
	int minvalue(Node root)
	{
		int x =root.data;
		while(root.left !=null)
		{
			x = root.left.data;
			root =root.left;
		}
		return x;
	}
	
	void delete(int key)
	{
		root =deletedata(root, key);
	}
	
	
	public static void main(String args[]){
		BST1 t1 = new BST1(10);
		t1.insert(8);
		t1.insert(25);
		t1.insert(5);
		t1.insert(9);
		t1.insert(22);
		t1.insert(42);
		t1.insert(2);
		
		
		System.out.println("Inorder");
		t1.Inorder();
		
		System.out.println();
		System.out.println("Preorder");
		t1.Preorder();
		
		
		System.out.println();
		System.out.println("Postorder");
		t1.Postorder();
		
		//case 1: Deletion with leaf node
		t1.delete(9);
		System.out.println();
		System.out.println("Inorder");
		t1.Inorder();
		
		//case 2: Deletion with sigle child node
		t1.delete(5);
		System.out.println();
		System.out.println("Inorder");
		t1.Inorder();
		
		//case 3: Deletion with two children
		t1.delete(25);
		System.out.println();
		System.out.println("Inorder");
		t1.Inorder();
		
		
		
	}
}