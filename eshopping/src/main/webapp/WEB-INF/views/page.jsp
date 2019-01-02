<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equix="X-UA-Compatible" content="IE_edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shopping at your place!- ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- DataTables Bootstrap CSS -->
<link href="${css}/dataTables.bootstrap.min.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">

		<!-- Navigation -->

		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">

			<!-- Load when user clicks Home -->
			<c:if test="${userClickHome ==  true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load when user clicks About -->
			<c:if test="${userClickAbout ==  true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load when user clicks Contact -->
			<c:if test="${userClickContact ==  true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load when user clicks AllProducts -->
			<c:if test="${userClickAllProducts ==  true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- load when user click show product -->
			<c:if test="${userClickShowProduct ==  true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>

		</div>
		<div>

			<!-- Footer -->

			<%@include file="./shared/footer.jsp"%>

			<!-- JS -->
			<script src="${js}/jquery.js"></script>

			<!-- Bootstrap core JavaScript -->
			<script src="${js}/bootstrap.min.js"></script>

			<!-- DATABASE PLUGIN -->
			<script src="${js}/jquery.dataTables.js"></script>

			<!-- DATATable Bootstrap JS -->
			<script src="${js}/dataTables.bootstrap.js"></script>

			<!-- myapp.js code -->
			<script src="${js}/myapp.js"></script>
		</div>
	</div>
</body>

</html>
