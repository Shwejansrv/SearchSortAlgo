package org.rice.models;

import org.rice.entity.Comparison;
import org.rice.entity.Linkedlist;
import org.rice.entity.Linkedlist.Node;

public class Bubble_Sort {
	public Comparison cmp = new  Comparison();
	public void sort(Linkedlist list) {
        if (list.lengthList(list) > 1) {
            for (int i = 0; i < list.lengthList(list); i++ ) {
                Node currentNode = list.head;
                Node after = list.head.next;
                for (int j = 0; j < list.lengthList(list) - 1; j++) {
                    if (currentNode.data > after.data) {
                    	cmp.counter++;
                        int temp = currentNode.data;
                        currentNode.data = after.data;
                        after.data = temp;
                    } 
                    currentNode = after;
                    after = after.next;                   
                } 
            }
        }
    }
	public static void main(String args[]){
		Linkedlist list = new Linkedlist();
		list.InsertAtEnd(list, 5);
		list.InsertAtEnd(list, 10);
		list.InsertAtEnd(list, 2);
		list.InsertAtEnd(list, 3);
		list.InsertAtEnd(list, 30);
		
		list.printList(list);
		System.out.println("After Sort");
		Bubble_Sort Sorty = new Bubble_Sort();
		Sorty.sort(list);
		System.out.println("Comparison" + Sorty.cmp.counter);
		list.printList(list);
	}
}
