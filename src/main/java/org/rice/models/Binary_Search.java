package org.rice.models;

import org.rice.entity.Comparison;
import org.rice.entity.Linkedlist;
import org.rice.entity.Linkedlist.Node;
import org.rice.models.Bubble_Sort;

public class Binary_Search {
	public Comparison cmp = new Comparison();
	public boolean binarySearch(Node head, int value)
    {
        Node start = head;
        Node last = null;
 
        do
        {
        	cmp.counter++;
            // Find Middle
            Node mid = middleNode(start, last);
 
            // If middle is empty
            if (mid == null)
                return false;
 
            // If value is present at middle
            if (mid.data == value)
                return true;
 
            // If value is less than mid
            else if (mid.data > value)
            {
              last = mid;
            }
 
            // If the value is more than mid.
            else
                 start = mid.next;
        } while (last == null || last != start);
 
        // value not present
        return false;
    }
	static Node middleNode(Node start, Node last)
    {
        if (start == null)
            return null;
 
        Node slow = start;
        Node fast = start.next;
 
        while (fast != last)
        {
            fast = fast.next;
            if (fast != last)
            {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
	public static void main(String args[]) {
		Linkedlist list = new Linkedlist();
		list.InsertAtEnd(list, 1);
		list.InsertAtEnd(list, 4);
		list.InsertAtEnd(list, 2);
		list.InsertAtEnd(list, 5);
		list.InsertAtEnd(list, 8);
		list.InsertAtEnd(list, 3);
		new Bubble_Sort().sort(list);
		Binary_Search bs = new Binary_Search();
		boolean val = bs.binarySearch(list.head, 10);
		System.out.println(bs.cmp.counter);
		System.out.println(val);
		
	}
}
