<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>Todos</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../resources/css/main.css" />
</head>
<body>

	<div style="width: 100%;">
		<div class="line"></div>
		<div class="topLine">
			<div style="float: left;">
				<img src="images/todo.png" />
			</div>
			<div style="float: left;" class="headline">Todos</div>
			<div style="float: right;">
				<a href='<c:out value="${url}" />'><c:out value="${urlLinktext}" /></a>
			</div>
		</div>
	</div>

	<div style="clear: both;" />
	You have a total number of
	<c:out value="${todos.size()}" />
	Todos.

	<table>
		<tr>
			<th>Short description</th>
			<th>Long Description</th>
			<th>URL</th>
			<th>Done</th>
		</tr>

		<c:forEach items="todos" var="todo">
			<tr>
				<td>${todo.getShortDescription()}</td>
				<td>${todo.getLongDescription()}</td>
				<td>${todo.getUrl()}</td>
				<td><a class="done" href="done?id=${todo.getId()}">Done</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<hr />

	<div class="main">

		<div class="headline">New todo</div>

		<form action="new" method="post" accept-charset="utf-8">
			<table>
				<tr>
					<td><label for="summary">Summary</label>
					</td>
					<td><input type="text" name="summary" id="summary" size="65" />
					</td>
				</tr>
				<tr>
					<td valign="description"><label for="description">Description</label>
					</td>
					<td><textarea rows="4" cols="50" name="description"
							id="description"></textarea>
					</td>
				</tr>
				<tr>
					<td valign="top"><label for="url">URL</label>
					</td>
					<td><input type="url" name="url" id="url" size="65" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="Create" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>