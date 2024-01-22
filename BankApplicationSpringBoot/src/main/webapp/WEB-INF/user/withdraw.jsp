<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Withdraw Form</title>
</head>
<body>

    <h2>Withdraw Form</h2>

    <form action="/account/withdraw" method="post">
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required>

        <!-- You can add more fields if needed -->

        <button type="submit">Withdraw</button>
    </form>

</body>
</html>
