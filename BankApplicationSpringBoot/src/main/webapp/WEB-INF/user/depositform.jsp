<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Deposit Form</title>
</head>
<body>

    <h2>Deposit Form</h2>

    <form action="/account/deposit" method="post">
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" required>

        <!-- You can add more fields if needed -->

        <button type="submit">Deposit</button>
    </form>

</body>
</html>
