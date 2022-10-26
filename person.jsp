<%@ page import="com.example.lab5.ConnectionManager" %>
<%@ page import="com.example.lab5.models.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <title>Book store</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="login">Login</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Переключатель навигации">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="upload">upload</a>
        </li>
         <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="uploadAjax.jsp">uploadAjax</a>
                </li>
      </ul>
    </div>
  </div>
</nav>

<section>
 <% ConnectionManager.getConnection(); %>
 <jsp:useBean id="personDAO" scope="application"
class="com.example.demo1.dao.PeopleDAOImpl"/>
 <% for (Person person : personDAO.selectAllPeople()) {%>
 <p>book: <%= person.getName() %>, email <%= person.getEmail() %> - age <%=
book.getCountAge() %> |
 <a href="updatePerson?action=update&id=<%= person.getId() %>">update</a>
 </p>
  <button type="submit" onclick = <% personDAO.deletePerson(person); %> >Delete</button>
 <% } %>
 <a href="newperson.jsp">add new person</a>
</section>
</body>
</html>