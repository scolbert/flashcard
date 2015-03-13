<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BrowseCards</title>
	
	<script>
		function setAnswer(answer) 
		{
			document.getElementById("answer").innerHTML = answer;
		}

		function selectCard(selection)
		{
			setAnswer(selection);
			
			if(selection === "by id selected"){
				document.getElementById("inputByFront").value="";
				document.getElementById("inputByAnswer").value="";
			}
			
			if(selection === "by front selected") {
				document.getElementById("inputById").value="";
				document.getElementById("inputByAnswer").value="";

			}
			
			if(selection === "by answer selected") {
				document.getElementById("inputByFront").value="";
				document.getElementById("inputById").value="";

			}




						
			<!-- oninput='document.getElementById("selectCardForm").submit()' -->
		}
	</script>
</head>
<body>
	<h1>Select a card to view and edit it</h1>
	<form id="selectCardForm">
		<datalist id="cardsById">
			<c:forEach var="card" items="${cards}">
				<option> ${card.getId()}</option>
			</c:forEach>
		</dataList>
		<datalist id="cardsByFront">
			<c:forEach var="card" items="${cards}">
				<option> ${card.getFront()}</option>
			</c:forEach>
		</dataList>
		<datalist id="cardsByAnswer">
			<c:forEach var="card" items="${cards}">
				<option> ${card.getAnswer()}</option>
			</c:forEach>
		</dataList>
		
		<label>Select Card By Id</label>
		<input id="inputById" oninput='selectCard("by id selected")' list='cardsById'/>
		<label>Select Card By Details</label>
		<input id="inputByFront" oninput='selectCard("by front selected")'  list="cardsByFront"/>
		<label>Select Card By Answer</label>
		<input id="inputByAnswer" oninput='selectCard("by answer selected")'  list="cardsByAnswer"/>
	</form>
	<hr/>
	<h1>Edit Fields</h1>
	
	<h3>CardId</h3>
	<p id='cardId'></p>
	
	<h3>Card Front</h3>
	<p id='cardFront'></p>
	
	<h3>Answer</h3>
	<p id='answer'></p>
	
</body>
</html>