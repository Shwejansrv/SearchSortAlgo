package org.rice.models;

import org.rice.entity.Comparison;
import org.rice.entity.Linkedlist;

import org.rice.entity.Linkedlist.Node;

public class Merge_Sort {
	public Comparison cmp = new Comparison();
	public Linkedlist mergeTwoSortedLists(Linkedlist l1, Linkedlist l2) {
	      Linkedlist ml = new Linkedlist();

	      Node one = l1.head;
	      Node two = l2.head;
	      while (one != null && two != null) {
	        if (one.data < two.data) {
	          ml.InsertAtEnd(ml, one.data);
	          one = one.next;
	          
	        } else {
	          ml.InsertAtEnd(ml, two.data);
	          two = two.next;
	          
	        }
	        cmp.counter++;
	      }

	      while (one != null) {
	        ml.InsertAtEnd(ml,one.data);
	        one = one.next;
	      }

	      while (two != null) {
	        ml.InsertAtEnd(ml,two.data);
	        two = two.next;
	      }

	      return ml;
	    }

	    public Node midNode(Node head, Node tail) {
	      Node f = head;
	      Node s = head;

	      while (f != tail && f.next != tail) {
	        f = f.next.next;
	        s = s.next;
	      }

	      return s;
	    }

	    public Linkedlist mergeSort(Node head, Node tail) {
	      if (head == tail) {
	    	
	        Linkedlist br = new Linkedlist();
	        br.InsertAtEnd(br, head.data);
	        return br;
	      }

	      Node mid = midNode(head, tail);
	      Linkedlist fsh = mergeSort(head, mid);
	      Linkedlist ssh = mergeSort(mid.next, tail);
	      Linkedlist sl = mergeTwoSortedLists(fsh, ssh);
	      return sl;
	    }
	public static void main(String args[]) {
		Linkedlist list = new Linkedlist();
		list.InsertAtEnd(list, 5);
		list.InsertAtEnd(list, 6);
		list.InsertAtEnd(list, 2);
		list.InsertAtEnd(list, 1);
		list.InsertAtEnd(list, 8);
		list.InsertAtEnd(list, 5);
		list.InsertAtEnd(list, 100);
		list.InsertAtEnd(list, 99);
		list.InsertAtEnd(list, 88);
		list.printList(list);
		System.out.println("After Sort");
		Node temp = list.head;
		while(temp.next!=null) {temp=temp.next;}
		Merge_Sort Sorty = new Merge_Sort();
		list = Sorty.mergeSort(list.head,temp);
		list.printList(list);
		System.out.println("Comparisons : " + Sorty.cmp.counter);
	}
}
