<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <title> Java File Upload Servlet Example </title>
</head>
<body>
<form method="post" action="upload" enctype="multipart/form-data">
 <input type="file" name="file"/>
 <input type="submit" value="Upload"/>
 <br/>
 <a href="person">back</a>
</form>
</body>
</html>