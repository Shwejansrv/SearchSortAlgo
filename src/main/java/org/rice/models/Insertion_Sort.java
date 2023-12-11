package org.rice.models;

import org.rice.entity.Comparison;
import org.rice.entity.Linkedlist;
import org.rice.entity.Linkedlist.Node;

public class Insertion_Sort {
	public Comparison cmp = new Comparison();
	Linkedlist ll = new Linkedlist();
	public Node insertionSortList(Node head) {
		  Node curr = head, next = null;
		  // l is a fake head
		  Linkedlist.Node l = ll.new Node(0);
		  
		  
		  while (curr != null) {
		    next = curr.next;
		    
		    Node p = l;
		    while (p.next != null && p.next.data < curr.data) {
		    	cmp.counter++;
		    	p = p.next;}
		    
		    // insert curr between p and p.next
		    curr.next = p.next;
		    p.next = curr;
		    curr = next;
		    
		  }
		  
		  return l.next;
		}
	public static void main(String args[]) {
		Linkedlist list = new Linkedlist();
		list.InsertAtEnd(list, 5);
		list.InsertAtEnd(list, 22);
		list.InsertAtEnd(list, 9);
		list.InsertAtEnd(list, 1);
		list.InsertAtEnd(list, 2);
		list.InsertAtEnd(list, 4);
		list.InsertAtEnd(list, 55);
		list.InsertAtEnd(list, 88);
		list.InsertAtEnd(list, 100);
		list.printList(list);
		System.out.println("After Sort");
		Insertion_Sort sorty = new Insertion_Sort();
		
		list.head = sorty.insertionSortList(list.head);
		System.out.println("Comparisons:" + sorty.cmp.counter);
		list.printList(list);
		
	}
}
