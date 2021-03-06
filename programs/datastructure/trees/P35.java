import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

class Node
{
	Node left;
	int data;
	Node right;
	
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
	
	//insert by iteration
	public void insert(int data)
	{
		if(node == null)
		{
			node = new Node(null,data,null);
		}
		else
		{
			Node temp = node;
			while(true)
			{
				if(data > temp.getData())
				{
					if(temp.right == null)
					{
						temp.right = new Node(null,data,null);
						return;
					}
					else
						temp = temp.right;
				}
				else
				{
					if(temp.left == null)
					{
						temp.left = new Node(null,data,null);
						return;
					}
					else
					{
						temp = temp.left;
					}
				}
			}
		}
	}
	
	//display , level order display
	public void display(Node node)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		while(!q.isEmpty())
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
	
	//Dont know if we can do in constant space. THis is not constant space.
	public void sum(Node node, int k)
	{
		Stack<Node> s = new Stack<Node>();
		Stack<Node> r = new Stack<Node>();
		Node temp = node;
		Node temp1 = node;
		while(true)
		{
			while(temp != null)
			{
				s.push(temp);
				temp = temp.left;
			}
			
			while(temp1 != null)
			{
				r.push(temp1);
				temp1 = temp1.right;
			}
			
			if(s.isEmpty() || r.isEmpty())
				break;
			temp = s.pop();
			temp1 = r.pop();
			
			if(temp.getData() > temp1.getData())
			{
				return;
			}
			
			if(temp.getData() + temp1.getData() == k )
			{
				System.out.println(temp.getData()+"\t"+temp1.getData());
				temp = temp.right;
				temp1 = temp1.left;
			}
			else if(temp.getData() + temp1.getData() < k)
			{
				temp = temp.right;
			}
			else
			{
				temp1 = temp1.left;
			}
		}
	}


	//ELSE we can do it in shorter way like this. very simple
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();

	public void shortWay(Node node, int k){
		if(node == null)
			return;
		if(map.containsKey(k-node.getData()))
			System.out.println(node.getData()+" "+(k-node.getData()));
		map.put(node.getData(),0);
		shortWay(node.left,k);
		shortWay(node.right,k);
	}
}


class P35
{
	public static void main(String[] args) 
	{
		Tree t = new Tree();
		t.insert(4);
		t.insert(2);
		t.insert(6);
		t.insert(1);
		t.insert(3);
		t.insert(5);
		t.insert(7);
		
		t.display(t.node);
		//t.sum(t.node, 9);
		t.shortWay(t.node,9);
		
		
	}
}

/*Algorithm 
 *
 * Say that we have a tree as described above. 
 * Now if we traverse in inorder way then we get 1,2,3,4,5,6,7
 * But if we traverse in reverse of inorder then we get 7,6,5,4,3,2,1
 * 
 * So we have like 
 *  a = 1,2,3,4,5,6,7
 *  b = 7,6,5,4,3,2,1
 *  
 *  Now we compare the sum of the number with the given k value.
 *  if the sum is equal then we print
 *  if the sum is less than k then we remove element from a and move to next element in a
 *  if the sum is greater than k then we remove element from b and move to next element in b
 *  
 *  But before that, if we see that any digit in a is greater than any digit in b, then we exit else we will be
 *  printing every nodes twice.
 *  
 *  For theoritical understanding you can check
 *  http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/

 	But the space is not constant here, as it takes O(n) space.
 	So if we can solve it in O(n) space, we can traverse BST and put all the elements in array(sorted)
 	or even use Hash to solve.
 	
 	ANOTHER APPROACH
 	Do a normal inorder traversal and put the nodes or values in stack and queue.
 	Once completed, pop out elements one at a time from Stack and Queue and compare
 	Or we can use hashmap or array etc...
 * 
 */
 
