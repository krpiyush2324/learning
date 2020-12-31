package linklist;

public class LinkListCreatDisplayDemo {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public LinkListCreatDisplayDemo insert(LinkListCreatDisplayDemo list, int data) {

		// create new Node
		Node newNode = new Node(data);
		newNode.next = null;

		// if linked list is empty
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node last = list.head;

			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}

	// function to display the linked list
	public static void Display(LinkListCreatDisplayDemo list) {
		Node currentNode = list.head;

		// Traverse through the linkedlist

		while (currentNode != null) {

			// print the node
			System.out.println(currentNode.data + " ");

			// go to the next node
			currentNode = currentNode.next;
		}
	}

	// Recursive function for display linkedlist

	public void display(Node list) {

		if (list != null) {
			System.out.print(list.data + " ");
			display(list.next);
		}
	}

	// function to count the value in linkedlist
	public static int count(LinkListCreatDisplayDemo list) {
		int count = 0;

		Node temp = list.head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;

	}

	public static int countRecursive(Node head) {

		if (head != null) {
			return countRecursive(head.next) + 1;
		}
		return 0;
	}

	// function to sum the element in linked list

	public static int sum(LinkListCreatDisplayDemo list) {

		int sum = 0;

		Node temp = list.head;
		while (temp != null) {
			sum = sum + temp.data;
			temp = temp.next;
		}
		return sum;
	}

	public static int sumRecursive(Node node) {

		if (node != null) {
			return sumRecursive(node.next) + node.data;
		}
		return 0;
	}

	// Maximun element in the list

	public static int max(LinkListCreatDisplayDemo list) {

		int max = -32768;
		Node node = list.head;
		while (node != null) {
			if (node.data > max)
				max = node.data;
			node = node.next;
		}
		return max;
	}

	// searching list

	public static Node linearSearch(LinkListCreatDisplayDemo list, int key) {

		Node temp = list.head;
		while (temp != null) {
			if (temp.data == key)
				return temp;
			temp = temp.next;
		}
		return null;
	}

	// improved search
	public static boolean improvedSearch(LinkListCreatDisplayDemo list, int key) {

		System.out.println(list.head);
		System.out.println(list.head.next);
		Node temp = list.head;
		Node q = null;
		while (temp != null) {
			if (temp.data == key) {
				q.next = temp.next;
				temp.next = list.head;
				list.head = temp;
				return true;
			}
			q = temp;
			temp = temp.next;
		}
		return false;
	}

	public static void insertAtPostion(LinkListCreatDisplayDemo list, int pos, int ele) {

		Node p;
		Node temp;
		if (pos == 0) {
			Node node = new Node(ele);
			node.next = list.head;
			list.head = node;
		} else if (pos > 0) {

			temp = list.head;
			for (int i = 0; i < pos - 1; i++) {
				temp = temp.next;
			}
			if (temp != null) {
				Node node = new Node(ele);
				node.next = temp.next;
				temp.next = node;
			}
		}
	}

// insert always at the last node
	public static void insertLast(LinkListCreatDisplayDemo list, int data) {

		Node last;
		Node node = new Node(data);
		node.next = null;

		if (list.head == null) {
			list.head = last = node;
		} else {
			last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = node;
		}

	}

	//insert node in sorted list
//	public static void sortedInsert(LinkListCreatDisplayDemo list ,int x) {
//		Node temp =list.head;
//		Node q=null;
//		Node node  =new  Node(x);
//		node.next=null;
//		if(temp.next==null) {
//			temp =node;
//		}else {
//			while(temp.next!=null && temp.data<x) {
//				q=temp.next;
//				temp =temp.next;
//			}
//			if(temp.next == list.head) {
//				temp.next = list.head;
//				list.head=node;
//			}
//			else {
//				node.next = q.next;
//				q.next =node;
//			}
//		}
//	}
	
	//Reversing a list by reversing linked
	
	public static void reverseListByLink(LinkListCreatDisplayDemo list) {
		
		Node p =list.head;
		Node q=null;
		Node r= null;
		
		while(p!=null) {
			r=q;
			q=p;
			p =p.next;
			q.next=r;
		}
		list.head=q;
	}
	// Driver code
	public static void main(String[] args) {
		/* Start with the empty list. */
		LinkListCreatDisplayDemo list = new LinkListCreatDisplayDemo();

		// Insert the values
		for (int i = 1; i < 10; i++) {
			list = list.insert(list, i);
		}
		// Print the LinkedList
		// Display(list);
		list.display(list.head);

		// count the value in linkedlist

		//System.out.println("\n number of value in linklist " + countRecursive(list.head));

//		int sum = sumRecursive(list.head);
//		System.out.println("sum is " + sum);
//		System.out.println("max" + max(list));
//		System.out.println("search " + improvedSearch(list, 7));
//		list.display(list.head);
//		System.out.println();
//		insertAtPostion(list, 9, 10);
//		list.display(list.head);
//		System.out.println();
//		insertLast(list, 12);
//		list.display(list.head);
//		System.out.println();
	//	sortedInsert(list,11);
	//	list.display(list.head);
		System.out.println();
		reverseListByLink(list);
		list.display(list.head);
	}
}
