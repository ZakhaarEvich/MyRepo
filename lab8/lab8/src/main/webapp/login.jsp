<%--
  Created by IntelliJ IDEA.
  User: Zakhar Zakharenko
  Date: 18.04.2023
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
  <title>Login Page</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $(document).ready(function() {
      $("#loginForm").submit(function(event) {
        event.preventDefault();
        var formData = $(this).serialize();
          $.ajax({
          type: "POST",
          url: "login",
          data: formData,
          dataType: "json",
          success: function(response) {
            if (response.status === "success") {
              window.location.href = "home.jsp";
            } else {
              $("#errorMessage").text(response.message);
            }
          },
          error: function(xhr, status, error) {
            console.log(error);
          }
        });
      });
    });
  </script>
</head>
<body>
<h1>Login</h1>
<form id="loginForm" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br><br>
  <input type="submit" value="Login">
</form>
<div id="errorMessage" style="color: red;"></div>
</body>
</html>
