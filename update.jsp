<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <title>Update person</title>
</head>
<body>
<section>
 <jsp:useBean id="person" scope="request"
class="com.example.demo1.models.Person"/>
 <form method="post" action="updatePerson"/>
 <input type="hidden" name="id" value="<%= person.getId() %>"/>
 <p>name: <input type="text" name="name" value="<%= person.getName() %>"
placeholder="<%= person.getName() %>"/></p>
 <p>author: <input type="text" name="email" value="<%= person.getEmail()
%>" placeholder="<%= person.getEmail() %>"/></p>
 <p>pages: <input type="number" name="age" value="<%=
book.getCountPages() %>" placeholder="<%= person.getCountAge() %>"/></p>
 <button type="submit">Save</button>
 </form>
</section>
</body>
</html>
