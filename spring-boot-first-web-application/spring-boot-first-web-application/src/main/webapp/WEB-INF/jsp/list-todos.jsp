<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title> Todo's for ${name} </title>
</head>

<body>

<H1>Your todos </H1>
<table>
	<caption>Your todos are </caption>
	<thead>
		<tr>
			<th></th>
			<th></th>
			<th></th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${todos}" var="todo">
		<tr>
			<th>${todo.desc}</th>
			<th>${todo.targetDate}</th>
			<th>${todo.done}</th>
		</tr>
		
		</c:forEach>
		
	
	</tbody>
	

Here are the list of ${name}'s todos:
${todos}
your name is ${name}
<BR/>
<a href="/add-todo"> Add a todo</a>


</body>
</html>