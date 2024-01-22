<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navbar Example</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/contact.css">
    <script src="/js/index.js"></script>
</head>

<body data-spy="scroll" data-target=".navbar" data-offset="50">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">MyBank</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarNav" aria-controls="navbarNav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="#home">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
                <li class="nav-item"><a class="nav-link" href="#contact">Contact Us</a></li>
                <li class="nav-item"><a class="nav-link" href="/account/details">Account</a></li>
                <li class="nav-item"><a class="nav-link logout-btn" href="/cust/logout">Logout</a></li>
            </ul>
        </div>
    </nav>

    <div id="home" class="home"></div>

    <div id="about" class="about">
        <div>
            <h1>About MyBank</h1>
            <p>Welcome to MyBank, your trusted financial partner! Established
                with a vision to contribute to the growth of businesses, MyBank was
                founded with the principal objective of providing medium-term and
                long-term project financing to businesses in India.</p>
            <p>In its early years, MyBank focused on project finance,
                offering long-term funds to a diverse range of industrial projects.
                As India's financial sector underwent liberalization in the 1990s,
                MyBank transformed into a dynamic financial services provider.</p>
            <p>Adapting to the market-oriented economy, MyBank, along with
                its subsidiaries and group companies, now offers a comprehensive
                suite of financial products and services. From project finance to
                diversified banking solutions, we cater to a broad spectrum of
                clients.</p>
            <p>MyBank officially became a part of the financial landscape in
                1994 when ICICI Bank was incorporated as a part of the ICICI group.
                In 1999, we achieved a significant milestone by becoming the first
                Indian company and the initial bank or financial institution from
                non-Japan Asia to be listed on the New York Stock Exchange.</p>
            <p>As we continue to evolve, MyBank remains committed to
                providing innovative financial solutions, fostering economic growth,
                and being a reliable partner on your financial journey.</p>
        </div>
    </div>

    <div id="contact" class="contact">
        <div>
            <h2>Contact Us</h2>
            <form action="/cust/contact" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                <label for="subject">Subject:</label>
                <input type="text" id="subject" name="subject" required>
                <label for="message">Message:</label>
                <textarea id="message" name="message" required></textarea>
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
    
    <div class="footer">
        <p>&copy; 2024 MyBank. All rights reserved.</p>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>

</html>
