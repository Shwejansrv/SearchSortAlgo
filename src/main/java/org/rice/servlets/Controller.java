package org.rice.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.rice.entity.Values;
import org.rice.models.Binary_Search;
import org.rice.models.Bubble_Sort;
import org.rice.models.Hash_Search;
import org.rice.models.Heap_Sort;
import org.rice.models.Insertion_Sort;
import org.rice.models.Linear_Search;
import org.rice.models.Merge_Sort;
import org.rice.models.Quick_Sort;
import org.rice.models.Selection_Sort;
import org.rice.entity.Linkedlist;
import org.rice.entity.Linkedlist.Node;


@WebServlet("/Controller")
//@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String values;
		Part filePart;
		String fileName;
		String arr = null;
		Linkedlist list = null;
		Linkedlist listser = null;
		Linkedlist list2 = null;
		int searchval = 0;
		
		
		if(request.getParameter("values")!= ""){
			values = request.getParameter("values");
			System.out.println("Values :" +  values);
			arr = request.getParameter("values");
			list = new Values().preprocess(values);
//			list.printList(list);
			list2 = new Values().preprocess(values);
			listser = new Values().preprocess(values);
//			list2.printList(list2);
			System.out.println("printing" + request.getParameter("searcher"));
			searchval = Integer.parseInt(request.getParameter("searcher"));
			
		}
		else {
			
//			filePart = request.getPart("inputs");
//		    fileName = filePart.getSubmittedFileName();
//		    for (Part part : request.getParts()) {
//		      part.write("D:\\Java\\" + fileName);
//		    }
//		    System.out.println("Part" + filePart);
//		    System.out.println("Name"+ fileName);
			
		}
		

		String sortlist = request.getParameter("sortlist");
		String simplesortlist = request.getParameter("simplesortlist");
		String action = request.getParameter("action");
		Linear_Search ls = new Linear_Search();
		boolean searchans = ls.search(listser,searchval);
		int linearcomps = ls.cmp.counter;
		Binary_Search br = new Binary_Search();
		new Bubble_Sort().sort(listser);
		boolean brsearchans = br.binarySearch(listser.head,searchval);
		int binarycomps = br.cmp.counter;
		Hash_Search hs = new Hash_Search();
		boolean hssearchans = hs.search(listser);
		int hashcomps = 1;
		request.setAttribute("searchans",searchans);
		request.setAttribute("linearcomps",linearcomps);
		request.setAttribute("binarycomps",binarycomps);
		request.setAttribute("hashcomps",hashcomps);
		
		switch(sortlist) {
		case "quicksort":
			Quick_Sort qsort = new Quick_Sort();
			Node end = qsort.lastNode(list);
			qsort.sort(list.head, end);
			request.setAttribute("list", list);
			request.setAttribute("comp", qsort.cmp.counter);
			System.out.println("Comparison qsort :" + qsort.cmp.counter);
			break;
		case "mergesort":
			Node temp = list.head;
			while(temp.next!=null) {temp=temp.next;}
			Merge_Sort msort = new Merge_Sort();
			list = msort.mergeSort(list.head,temp);
			request.setAttribute("list", list);
			request.setAttribute("comp", msort.cmp.counter);
			System.out.println("Comparison msort : " + msort.cmp.counter);
			break;
		case "heapsort":
			int[] vals;
			vals = new Values().process(arr);
			Heap_Sort ob = new Heap_Sort();
		    ob.sort(vals);
		    System.out.println("Comparisons hsort : " + ob.cmp.counter);
			request.setAttribute("vals", vals);
			request.setAttribute("comp", ob.cmp.counter);
			break;
		}
		
		switch(simplesortlist) {
		case "selectionsort":
			Selection_Sort ssort = new Selection_Sort();
			list2.head = ssort.Sort(list2.head);
			System.out.println("Comparisons selsort:" + ssort.cmp.counter);
			request.setAttribute("list2", list2);
			request.setAttribute("comp2", ssort.cmp.counter);
			
			break;
		case "insertionsort":
			Insertion_Sort isort = new Insertion_Sort();
			list2.head = isort.insertionSortList(list.head);
			System.out.println("Comparisons isort : " + isort.cmp.counter);
			request.setAttribute("list2", list2);
			request.setAttribute("comp2", isort.cmp.counter);
			break;
		case "bubblesort":
			Bubble_Sort bsort = new Bubble_Sort();
			bsort.sort(list2);
			System.out.println("Comparison bsort : " + bsort.cmp.counter);
			request.setAttribute("list2", list2);
			request.setAttribute("comp2", bsort.cmp.counter);
			break;
		}
		
		switch(action) {
		case "sortsearch":
			request.getRequestDispatcher("result.jsp").forward(request,response);
		}
		
	}

}
