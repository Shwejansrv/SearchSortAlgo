<%@page import="org.rice.entity.Linkedlist"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>
<%
PrintWriter ot  = response.getWriter();

ot.print("Results :");ot.print("<br/>");ot.print("<br/>");
ot.print(request.getParameter("sortlist").toUpperCase());
ot.print("<br/>");ot.print("<br/>");ot.print("<br/>");
int[] vals = (int[])request.getAttribute("vals");
if(vals!=null){
	int count3  = (int)request.getAttribute("comp");
	for(int i:vals){
		out.print(i);out.print(" ");
	}
	ot.print("<br/>");
	ot.print("Comparisons:" + count3);
}
%><%

Linkedlist list = (Linkedlist)request.getAttribute("list");
int count  = (int)request.getAttribute("comp");
if(list!=null){
	while(list.head!=null){
		ot.print(list.head.data);ot.print(" ");
		list.head = list.head.next;
	}
	ot.print("<br/>");ot.print("<br/>");ot.print("<br/>");
	ot.print("Comparisons:" + count);
}

ot.print("<br/>");ot.print("<br/>");ot.print("<br/>");
ot.print(request.getParameter("simplesortlist").toUpperCase());
ot.print("<br/>");ot.print("<br/>");ot.print("<br/>");
Linkedlist list2 = (Linkedlist)request.getAttribute("list2");
int count2  = (int)request.getAttribute("comp2");
if(list2!=null){
	while(list2.head!=null){
		ot.print(list2.head.data); ot.print(" ");
		list2.head = list2.head.next;
	}
	ot.print("<br/>");ot.print("<br/>");ot.print("<br/>");
	ot.print("Comparisons:"  + count2);
}
ot.print("<br/>");ot.print("<br/>");ot.print("<br/>");
boolean searchans = (boolean)request.getAttribute("searchans");
if(searchans){ot.print("Element : Found");}
else{
	ot.print("Element : Not found");
}
ot.print("<br/>");ot.print("<br/>");
%>
<% 
ot.print("Linear Search Comparisons : " + (int)request.getAttribute("linearcomps") );
ot.print("<br/>");ot.print("<br/>");ot.print("<br/>");
ot.print("Binary Search Comparisons : " + (int)request.getAttribute("binarycomps") );
ot.print("<br/>");ot.print("<br/>");ot.print("<br/>");
ot.print("Hash Search Comparisons : " + (int)request.getAttribute("hashcomps") ); %>
</body>
</html>