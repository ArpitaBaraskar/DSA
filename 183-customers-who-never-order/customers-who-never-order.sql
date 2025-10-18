SELECT Customers.name AS Customers
FROM Customers
LEFT JOIN Orders
On Customers.id = Orders.customerId
Where Orders.customerId is null

