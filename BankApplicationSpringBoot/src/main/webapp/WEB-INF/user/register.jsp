<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create User</title>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>
    <div class="container">
        <div class="card">
            <h1>Create User</h1>
            <form action="/cust/register" method="post">

                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>

                <label for="mobileNumber">Mobile Number:</label>
                <input type="text" id="mobileNumber" name="mobileNumber" required>

                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>

                <label for="govtId">Government ID:</label>
                <input type="text" id="govtId" name="govtId" required>

                <button type="submit">Submit</button>
                <a href="/cust/login">Registered Before. Please Login!</a>
            </form>
        </div>
    </div>
</body>

</html>
