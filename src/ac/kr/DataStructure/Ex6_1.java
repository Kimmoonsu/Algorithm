package ac.kr.DataStructure;

import java.util.Scanner;

public class Ex6_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList L = new LinkedList();
		System.out.println("====LinkedList====");
		for (int i = 0 ; i < 5; i ++)
			L.insertLastNode(i+1);
		L.printList();
		ListNode pre = L.searchNode(2);
		if (pre == null)
			System.out.println("검색 데이터 없음");
		else
		{
			L.insertMiddleNode(pre, 3);
			L.printList();
		}
		System.out.println("==================");
	}
	
}
class LinkedList
{
	private ListNode head;
	public LinkedList()
	{
		head = null;
	}
	public void insertMiddleNode(ListNode pre, int data)
	{
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}
	public void insertLastNode(int data)
	{
		ListNode newNode = new ListNode(data);
		if (head == null)
		{
			this.head = newNode;
		}
		else
		{
			ListNode temp = head;
			while(temp.link != null)
			{
				temp = temp.link;
			}
			temp.link = newNode;
		}
	}
	public ListNode searchNode(int data)
	{
		ListNode temp = this.head;
		while(temp != null)
		{
			if (data == temp.getData())
				return temp;
			else 
				temp = temp.link;
		}
		return temp;
	}
	public void printList()
	{
		ListNode temp = this.head;
		System.out.print("L = (");
		while(temp != null)
		{
			System.out.print(temp.getData());
			temp = temp.link;
			if(temp != null)
				System.out.print(", ");
		}
		System.out.println(")");
	}
}
class ListNode
{
	private int data;
	public ListNode link;
	public ListNode()
	{
		this.data = 0;
		this.link = null;
	}
	public ListNode(int data)
	{
		this.data = data;
		this.link = null;
	}
	public ListNode(int data, ListNode link)
	{
		this.data = data;
		this.link = link;
	}
	public int getData()
	{
		return this.data;
	}
}