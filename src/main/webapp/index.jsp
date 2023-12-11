<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage!!</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/Controller" method="post">
<br/><br/><br/>
Enter Values : 
<br/>
<textarea name="values" rows="25" cols="100"></textarea>

<br/><br/><br/>
<label for="sort">Choose a Sorting Algorithm:</label>
<select id="sort" name="sortlist">
  <option value="quicksort">Quick Sort</option>
  <option value="mergesort">Merge Sort</option>
  <option value="heapsort">Heap Sort</option>
</select>
<br/><br/><br/>
<label for="simplesort">Choose another Sorting Algorithm:</label>
<select id="simplesort" name="simplesortlist">
  <option value="selectionsort">Selection Sort</option>
  <option value="insertionsort">Insertion Sort</option>
  <option value="bubblesort">Bubble Sort</option>
</select>
<br/><br/><br/>
Enter a number :<input type="number" name="searcher"/>
 <br/><br/><br/>
<input type="hidden" name="action" value="sortsearch"/>
<input type="submit" value="submit"/>
</form>
<br/>

</body>
</html>