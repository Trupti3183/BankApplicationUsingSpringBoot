<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.techm.mvc.model.Account" %>
<%@ page import="java.util.Optional" %>
<%
// Retrieve the Account object from the request
Account account = (Account) request.getAttribute("account");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Balance</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            color: #4CAF50;
        }

        p {
            margin: 10px 0;
        }

        .container {
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
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
        <p class="error">Account not found or invalid user ID.</p>
        <%
        }
        %>
    </div>
</body>
</html>
