package org.rice.entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Values {
	public Linkedlist preprocess(String values) {
		Linkedlist list = new Linkedlist();
        String[] val = values.split(" ");
        for(String i:val){
             list.InsertAtEnd(list,Integer.parseInt(i));
        }
		return list;
		
	}
	public int[] process(String arr) {
		
		String[] val = arr.split(" ");
		int vals[] = new int[val.length];
		for(int i=0;i<val.length;i++) {
			vals[i] = Integer.parseInt(val[i]); 
		}
		return vals;
		
	}
	public void processer() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("emp.txt"));
	}
}
