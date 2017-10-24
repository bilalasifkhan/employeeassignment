<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, shrink-to-fit=no, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Employee Portal Page - ${title}</title>

<script>
	window.menu = '${title}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Theme Readable CSS -->
<link href="${css}/bootstrap-theme-readable.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="${css}/simple-sidebar.css" rel="stylesheet">
<link href="${css}/myapp.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="./shared/sidebar.jsp"%>

		<!-- /#sidebar-wrapper -->


		<!-- Page Content -->
		<c:if test="${userClickHome == true}">
			<%@include file="./home.jsp"%>
		</c:if>

		<!-- Loads only when user clicks Find Employee -->
		<c:if test="${userClickFindEmployee == true}">
			<%@include file="./findEmployee.jsp"%>
		</c:if>

		<!-- Loads when requesting to find Employee -->
		<c:if test="${userClickFoundEmployees == false}">
			<div class="alert alert-dismissible alert-danger">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Oh snap!</strong> User Not found. Try submitting again.
			</div>
		</c:if>
		<c:if test="${userClickFoundEmployees == true}">
			<%@include file="./getEmployees.jsp"%>
		</c:if>
		
		
		<!-- Loads only when user clicks Add Employee -->
		<c:if test="${userClickAddEmployee == true}">
			<%@include file="./addEmployee.jsp"%>
		</c:if>
		
		<!-- Loads when Employee added -->
		<c:if test="${userClickEmployeeAdded == true}">
			<%@include file="./results.jsp"%>
		</c:if>

		
		<!-- Loads only when user clicks Delete Employee -->
		<c:if test="${userClickDeleteEmployee == true}">
			<%@include file="./deleteEmployee.jsp"%>
		</c:if>
		
		<!-- Loads when employee is being deleted -->
		<c:if test="${userClickEmployeeDeleted == false}">
			<div class="alert alert-dismissible alert-danger">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Oh snap!</strong> User Not found. Try again.
			</div>
		</c:if>
		<c:if test="${userClickEmployeeDeleted == true}">
			<%@include file="./resultsDelete.jsp"%>
		</c:if>
		
		
		
		<!-- Loads only when user clicks Update Employee -->
		<c:if test="${userClickUpdateEmployee == true}">
			<%@include file="./updateEmployee.jsp"%>
		</c:if>
		
		<!-- Loads when employee is being updated -->
		<c:if test="${userClickEmployeeUpdated == false}">
			<div class="alert alert-dismissible alert-danger">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Oh snap!</strong> User Not found. Try again.
			</div>
		</c:if>
		<c:if test="${userClickEmployeeUpdated == true}">
			<%@include file="./resultsUpdate.jsp"%>
		</c:if>
		
		
		<!-- Loads only when user clicks Promote Employee -->
		<c:if test="${userClickPromoteEmployee == true}">
			<%@include file="./promoteEmployee.jsp"%>
		</c:if>
		
		<!-- Loads when employee is being promoted -->
		<c:if test="${userClickEmployeePromoted == false}">
			<div class="alert alert-dismissible alert-danger">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>Oh snap!</strong> User Not found. Try again.
			</div>
		</c:if>
		<c:if test="${userClickEmployeePromoted == true}">
			<%@include file="./resultsPromote.jsp"%>
		</c:if>


		<!-- Loads only when user clicks List All Employees -->
		<c:if test="${userClickListAllEmployees == true}">
			<%@include file="./listAllEmployees.jsp"%>
		</c:if>


		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="${js}/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>

	<!-- Self Coded JavaScript file -->
	<script src="${js}/myapp.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>




</body>

</html>
