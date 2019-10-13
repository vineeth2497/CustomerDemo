
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details Page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<form:form action="getCustomerRecords.html" method="POST"
			modelAttribute="dateRangeBean">
			<table border="2">
				<tr>
					<th>From Date:</th>
					<td><form:input path="fromDate" /></td>
					<th>To Date:</th>
					<td><form:input path="toDate" /></td>
				</tr>

			</table>
			<br>
			<br>
			<br>
			<br>
			<input type="submit" value="Fetch Details">
		</form:form>


		<c:if test="${not empty customer}">
			<br>
			<br>
			<br>
			<br>
			<table border="2">
				<tr>
					<th>CustomerID</th>
					<th>Customer Name</th>
					<th>Bill</th>
					<th>Billing Date</th>
				</tr>

				<c:forEach var="itr" items="${ customer}">
					<tr>
						<td><c:out value="${itr.customerId}"></c:out></td>
						<td><c:out value="${itr.customerName}"></c:out></td>
						<td><fmt:formatNumber value="${itr.bill}" type="currency"
								currencySymbol="INR."></fmt:formatNumber></td>
						<td><fmt:formatDate value="${itr.billingDate}" type="date"
								pattern="dd-MMM-yyyy" />
					</tr>
				</c:forEach>

			</table>
		</c:if>
		<br> <br> <a href="index.jsp">Home</a>
	</center>
</body>
</html>