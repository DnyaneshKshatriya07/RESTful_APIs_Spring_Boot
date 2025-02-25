<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="./base.jsp"%>

<style>
body {
	background-color: #ffde22; /* Yellow Background */
}

h1 {
	color: #ff414e; /* Pink / Red Circle */
}

.form-control {
	background-color: #ffffff; /* White Layover */
	color: #ff414e; /* Pink / Red Circle */
}

/* Add margin between input fields and buttons */
.form-group {
	margin-bottom: 20px;
}
/* Adjust margin for buttons */
.btn {
	margin-right: 10px;
}
</style>

</head>
<body>
	<div class="container mt-3 container-shaded">
		<!-- Apply the container-shaded class here -->
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Fill the Product Details</h1>

				<form action="handle-product" method="post">
					<div class="form-group">
						<label for="name">Product name</label> <input type="text"
							id="name" class="form-control" name="name"
							placeholder="Enter the product name here"
							aria-desribedby="emailHelp">
					</div>

					<div class="form-group">
						<label for="description">Product Description</label>
						<textarea id="description" class="form-control" name="description"
							placeholder="Enter the product description here" rows="5"></textarea>
					</div>

					<div class="form-group">
						<label for="price">Product price</label> <input type="text"
							id="price" class="form-control" name="price"
							placeholder="Enter the product price here">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-outline-success">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
