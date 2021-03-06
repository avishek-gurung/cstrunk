import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node
{
	Node left;
	Node right;
	int data;
	
	Node(Node left, int data, Node right)
	{
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	public int getData()
	{
		return data;
	}
}

class Tree
{
	Node node;
	
	//insert
	public void insert(int data)
	{
		if(node == null)
		{
			node = new Node(null,data,null);
		}
		else
		{
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			while(q.peek() != null)
			{
				Node temp = q.remove();
				if(temp.left == null)
				{
					temp.left = new Node(null,data,null);
					return;
				}
				else
				{
					q.add(temp.left);
				}
				
				if(temp.right == null)
				{
					temp.right = new Node(null,data,null);
					return;
				}
				else
				{
					q.add(temp.right);
				}
			}
			
		}
	}
	
	public void display()
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(q.peek() != null)
		{
			Node temp = q.remove();
			System.out.print(temp.getData()+" --> ");
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
		System.out.println();
	}
	
	public int height_recursive(Node node)
	{
		if(node == null)
			return 0;
		
		int left_height = height_recursive(node.left);
		int right_height = height_recursive(node.right);
		if(left_height > right_height)
			return left_height+1;
		else
			return right_height+1;
	}
	
	public int height_iteration(Node node)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		int level = 1;
		
		while(!q.isEmpty())
		{
			Node temp = q.remove();
			if(temp == null)
			{
				if(!q.isEmpty())
				{
					q.add(null);
					level++;
				}
			}
			else
			{
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
		}
		return level;
	}
}

class P5
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.insert(1);
		t.insert(2);
		t.insert(3);
		t.insert(4);
		t.insert(5);
		t.insert(6);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		t.insert(7);
		
		t.display();
		System.out.println("Height of a tree: "+t.height_recursive(t.node));
		System.out.println("Height of a tree: "+t.height_iteration(t.node));

	}
}














 
