<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="table-responsive">
			<a href="/create" class="link-secondary">Add a new
				product</a>
			<div class="row">
				<div class="col-md-8">
					<h4>Product List</h4>
				</div>
				<div class="col-md-4">
					<form action="/search" method="get">
						<div class="input-group mb-3">
							<input type="text" class="form-control" name="searchText"
								placeholder="Search product" aria-label="Search product"
								aria-describedby="basic-addon2"> 
								<button id="basic-addon2" class="input-group-text" type="submit">Search</button>								
						</div>
					</form>
				</div>
			</div>
<table class="table table-responsive">
<thead>
	<tr>
		<th>Id</th>
		<th>Product Name</th>
		<th>Quantity</th>
		<th>Price</th>
		<th>Remarks</th>
		<th>Action</th>
	</tr>
</thead>

<tbody>
	<c:forEach var="p" items="${data.productList}">
	<tr>
		<td>${p.id}</td>
		<td>${p.name}</td>
		<td>${p.quantity}</td>
		<td>${p.price}</td>
		<td>${p.remarks}</td>
		<td>
			<a href="/edit/${p.id}">Edit</a> |
			<a href="/delete/${p.id}">Delete</a>
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</div>
</div>

</body>
</html>