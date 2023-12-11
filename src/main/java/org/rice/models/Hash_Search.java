package org.rice.models;

import java.util.Hashtable;
import java.util.Map.Entry;

import org.rice.entity.Comparison;
import org.rice.entity.Linkedlist;

public class Hash_Search {
	public Comparison cmp = new Comparison();
	public boolean search(Linkedlist list) {
		Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
		for(int i=0;i<list.lengthList(list);i++) {
			ht.put(i+1, list.head.data);
			list.head = list.head.next;
		}
		ht.put(100, 16100);
        System.out.println(ht.size());
        System.out.println(ht.containsKey(100));
        System.out.println(ht.containsValue(16100));
        System.out.println(ht.get(3));
        ht.remove(4);
        System.out.println(ht.keys());
        System.out.println(ht.keySet());
        for(Entry<Integer, Integer> e : ht.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
		return false;
	}
	public static void main(String[] args) {
		Hash_Search sr = new Hash_Search();
		Linkedlist ls = new Linkedlist();
		ls.InsertAtEnd(ls, 10);
		ls.InsertAtEnd(ls, 9);
		ls.InsertAtEnd(ls, 3);
		ls.InsertAtEnd(ls, 8);
		ls.InsertAtEnd(ls, 7);
		sr.search(ls);
	}
}
