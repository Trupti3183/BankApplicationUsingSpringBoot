<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.techm.mvc.model.Account"%>
<%@ page import="java.util.Optional"%>
<%
// Retrieve the Account object from the request
Account account = (Account) request.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Balance</title>
 <link rel="stylesheet" type="text/css" href="/css/details.css">
</head>
<body>
	<h2>Account Balance</h2>

	 <%
    // Check if the account is not null
    if (account != null) {
        // Retrieve values from the account object
        Long userId = (account.getUser() != null) ? account.getUser().getId() : null;
        String accountNumber = account.getAccountNumber();
        Double balance = account.getBalance();
    %>

    <p>User ID: <%=userId%></p>
    <p>Account Number: <%=accountNumber%></p>
    <p>Balance: $<%=balance%></p>

    <%
    } else {
    %>
    <p>Account not found or invalid user ID.</p>
    <%
    }
    %>
	<div class="action-buttons">
		<a href="/account/deposit"><button>Deposit</button></a> <a
			href="/account/withdraw"><button>Withdraw</button></a>
			<a href="/cust/home"><button>Back</button></a>
	</div>
</body>
</html>
