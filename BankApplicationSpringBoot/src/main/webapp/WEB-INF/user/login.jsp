<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create User</title>
    <link rel="stylesheet" href="/css/login.css">
</head>

<body>
    <div class="container">
        <div class="card">
            <h1>Login</h1>
            <img src="/images/backgroundimage.png" alt="Login Image">
            <form action="/cust/login" method="post">

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>

                <button type="submit">Login</button>
                <a href="/cust/register">Not Registered. Please Register!</a>
            </form>
        </div>
    </div>
</body>

</html>
