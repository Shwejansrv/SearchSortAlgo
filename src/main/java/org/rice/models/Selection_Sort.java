package org.rice.models;

import org.rice.entity.*;
import org.rice.entity.Linkedlist.Node;

public class Selection_Sort {
	public Comparison cmp = new Comparison();
	public Node swapNodes( Node head_ref, Node curr_node1,  Node curr_node2, Node prev_node) {  	    
	    head_ref = curr_node2;  
	    
	    prev_node.next = curr_node1;  	   
  
	    Node temp = curr_node2.next;  
	    curr_node2.next = curr_node1.next;  
	    curr_node1.next = temp;  
	    return head_ref; 
	}  
	   
	// sort the linked list using selection sort  
	public Node Sort( Node head) {  
 
	    if (head.next == null)  
	        return head;  
	   
	    Node minNode = head;  
	    Node prevMin = null;  
	    Node ptr;  
	   
	    for (ptr = head; ptr.next != null; ptr = ptr.next)   {  
	        if (ptr.next.data < minNode.data)   {  
	            minNode = ptr.next;  
	            prevMin = ptr;
	            cmp.counter++;
	        }  
	    }  

	    if (minNode != head) {  
	    	cmp.counter ++;
	        head = swapNodes(head, head, minNode, prevMin);  }
	 
	    head.next = Sort(head.next);  
	   
//	    System.out.println("Comparisons:" + cmp.counter);
	    return head;  
	}
	public static void main(String args[]) {
		Linkedlist list = new Linkedlist();
		list.InsertAtEnd(list, 5);
		list.InsertAtEnd(list, 10);
		list.InsertAtEnd(list, 2);
		list.InsertAtEnd(list, 3);
		list.InsertAtEnd(list, 30);
		list.printList(list);
		System.out.println("After Selection Sort");
		Selection_Sort sorty = new Selection_Sort();
		list.head = sorty.Sort(list.head);
		System.out.println("Comparisons :" + sorty.cmp.counter);
		list.printList(list);
	}
}
