package org.rice.models;

import org.rice.entity.Comparison;
import org.rice.entity.Linkedlist;
import org.rice.entity.Linkedlist.Node;

public class Linear_Search {
	public Comparison cmp = new Comparison();
	public boolean search(Linkedlist list,int x) {
		Node temp = list.head;
		int i;
		for(i=0;i<list.lengthList(list);i++) {
			cmp.counter++;
			if(temp.data == x) {
				return true;
			}
		temp = temp.next;
		}
		System.out.println("Element not found");
		return false;
	}
	
	public static void main(String args[]) {
		Linkedlist list = new Linkedlist();
		list.InsertAtEnd(list, 1);
		list.InsertAtEnd(list, 4);
		list.InsertAtEnd(list, 2);
		list.InsertAtEnd(list, 5);
		list.InsertAtEnd(list, 8);
		list.InsertAtEnd(list, 3);
		Linear_Search ls = new Linear_Search();
		boolean i = ls.search(list, 8);
		System.out.println(ls.cmp.counter);
		System.out.println(i);
	}
}
