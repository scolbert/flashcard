<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Card</title>
</head>
<body>
	<form action="addCard" method="POST">
		<label>Context Cue: </label>
		<input type="text" name="contextCue"/><br/>
		
		<label>Seeking</label>
		<input type="text" name="seeking"/><br/>
		
		<label>Details</label>
		<textarea name="details" rows="10" cols="50"></textarea><br/>
		
		<label>Answer</label>
		<textarea name="answer" rows="10" cols="50"></textarea><br/>
		
		<input type="submit" value="Add Card"/>
	</form>
	<br/><br/>
	<div>Successfully submitted card # : ${id}</div>
</body>
</html>