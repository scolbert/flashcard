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
		<input type="text" name="contextCue" value="Enter A Context Cue"/><br/>
		
		<label>Front</label>
		<textarea name="front" rows="20" cols="50"></textarea><br/>
		
		<label>Back</label>
		<textarea name="back" rows="20" cols="50"></textarea><br/>
		
		<input type="submit" value="Add Card"/>
	</form>
</body>
</html>