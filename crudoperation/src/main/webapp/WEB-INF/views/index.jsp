<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="./base.jsp"%>

<style>
/* Add yellow shading effect */
.table-shaded {
	background: linear-gradient(to top, #FFD700, #FFFF00);
}
</style>

</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>

				<table class="table table-bordered table-shaded">
					<!-- Apply the table-shaded class here -->

					<thead class="table table-dark">
						<tr class="text-center">
							<th scope="col">Id</th>
							<th scope="col">Product Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${product}" var="p">
							<tr class="text-center">
								<th scope="row">Id${p.pid}</th>
								<td>${p.name}</td>
								<td>${p.description}</td>
								<td class="font-weight-bold">&#x20B9; ${p.price}</td>
								<td class="text-center"><a href="delete/${p.pid}"><i
										class="fa-solid fa-trash text-danger" style="font-size: 25px"></i></a>
									<a href="update/${p.pid}"><i
										class="fa fa-pen-nib text-primary" style="font-size: 25px"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">Add
						Product</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
