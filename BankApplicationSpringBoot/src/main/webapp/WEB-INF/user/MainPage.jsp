<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SwiftBank</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Kalnia:wght@600&display=swap');

        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }

        header {
            background-color: #005c99;
            color: white;
            text-align: center;
            padding: 1rem;
        }

        h1 {
            font-family: 'Kalnia', serif;
            font-size: 30px;
        }

        main {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }

        .card-container {
            position: relative;
            margin-bottom: 20px;
        }

        .card-container img {
            width: 100%;
            height: auto;
        }

        .buttons-container {
            display: flex;
            justify-content: space-around;
        }

        .cta-button {
            padding: 10px 20px;
            background-color: #005c99;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
        }

        .cta-button:hover {
            background-color: #004080;
        }
    </style>
</head>

<body>

    <header>
        <h1>MyBank</h1>
    </header>

    <main>
        <h2>Welcome to MyBank</h2>

        <div class="card-container">
            <img src="images/image1.jpg" alt="Card Image">
        </div>

        <div class="buttons-container">
            <a href="/cust/login" class="cta-button">Login</a>
            <a href="/cust/register" class="cta-button">Sign Up</a>
        </div>
    </main>

</body>

</html>
