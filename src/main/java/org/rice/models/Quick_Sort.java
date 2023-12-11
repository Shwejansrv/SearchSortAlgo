package org.rice.models;

import org.rice.entity.Comparison;
import org.rice.entity.Linkedlist;
import org.rice.entity.Linkedlist.Node;

public class Quick_Sort {
	public Comparison cmp = new Comparison();
	public Node paritionLast(Node start, Node end)
    {
        if (start == end || start == null || end == null)
            return start;
 
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;
 
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.data < pivot) {
 
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
                curr = curr.next;
                
                cmp.counter ++;
            }
            start = start.next;
        }
 
        // Swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
 
        // Return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }
	
	
	public void sort(Node start, Node end)
    {
        if (start == null || start == end || start == end.next)
            return;
 
        // Split list and partition recurse
        Node pivot_prev = paritionLast(start, end);
        
        sort(start, pivot_prev);
 
        // If pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start) {
//        	cmp.counter++;
            sort(pivot_prev.next, end);}
 
        
        // If pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                 && pivot_prev.next != null) {
//        	cmp.counter++;
            sort(pivot_prev.next.next, end);}
    
    
    }
	public Node lastNode(Linkedlist list) {
		Node temp = list.head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		return temp;
	}
	public static void main(String args[]) {
		Linkedlist list = new Linkedlist();
		list.InsertAtEnd(list, 1);
		list.InsertAtEnd(list, 4);
		list.InsertAtEnd(list, 2);
		list.InsertAtEnd(list, 5);
		list.InsertAtEnd(list, 7);
		list.InsertAtEnd(list, 3);
		list.printList(list);
		System.out.println("After Sort");
		Quick_Sort sorty = new Quick_Sort();
		Node end = sorty.lastNode(list);
		sorty.sort(list.head, end);
		System.out.println("Comparison :" + sorty.cmp.counter);
		list.printList(list);
	}
}
