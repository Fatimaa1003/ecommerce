<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Your Shopping Cart</h1>
        <table>
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <!-- Example static content, replace with dynamic data -->
                <tr>
                    <td>Product 1</td>
                    <td>2</td>
                    <td>$10.00</td>
                    <td>$20.00</td>
                </tr>
                <tr>
                    <td>Product 2</td>
                    <td>1</td>
                    <td>$15.00</td>
                    <td>$15.00</td>
                </tr>
                <!-- End static content -->
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3">Total</td>
                    <td>$35.00</td>
                </tr>
            </tfoot>
        </table>
        <form action="checkout" method="post">
            <button type="submit">Checkout</button>
        </form>
        <a href="welcome.jsp">Back to Welcome Page</a>
    </div>
</body>
</html>
