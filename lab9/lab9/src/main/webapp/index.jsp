<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MacValidation</title>
</head>
<body>
<h1>Проверка Mac-адреса</h1>

<form method="post" action="ValidateServlet">
    <label for="macAddress">Поле для ввода:</label>
    <input type="text" id="macAddress" name="macAddress" required>
    <button type="submit">Проверить</button>
</form>
</body>
</html>
