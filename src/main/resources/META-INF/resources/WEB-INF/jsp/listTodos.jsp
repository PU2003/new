<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
   <head>
      <title> List Todos Page </title>
   </head>
   <body>
      <div> Welcome to our website ${name}! </div>
      <div> Your Todos are </div>
      <table>
          <thead>
              <tr>
                 <th>id</th>
                 <th>Description</th>
                 <th>Target Date</th>
                 <th>Is Done?</th>
              </tr>
          </thead>
          <tbody>
              <c:forEach items="${todos}" var="todo">
                 <tr>
                    <td>${todo.id}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                 </tr>
              </c:ForEach>
          </tbody>
      </table>
   </body>
</html>