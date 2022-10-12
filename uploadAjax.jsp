<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <title> Java Ajax File Upload Example </title>
</head>
<body>
<input id="ajaxfile" type="file"/> <br/>
<button onclick="uploadFile()"> Upload </button>
<script>
 async function uploadFile() {
 let formData = new FormData();
 formData.append("file", ajaxfile.files[0]);
 await fetch('upload', {
 method: "POST",
 body: formData
 });
 alert('The file upload with Ajax and Java was a success!');
 }
</script>
<br/>
<a href="person">back</a>
</body>
</html>
