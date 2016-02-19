<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.employees.Employee"%>

<html>
    <head>
       <link rel="stylesheet" href="css/bootstrap.min.css"/>         
       <script src="js/bootstrap.min.js"></script>       
    </head>

    <body>          
        <div class="container">
            <h2>Employees</h2>
            <!--Search Form -->
            <form action="<%=request.getContextPath()%>/employee" method="get" id="seachEmployeeForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="employeeName" id="employeeName" class="form-control" required="true" placeholder="Type the Name or Last Name of the employee"/>                    
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
                <br></br>
                <br></br>
            </form>
            
            <!--Employees List-->
            <form action="<%=request.getContextPath()%>/employee" method="post" id="employeeForm" role="form" >              
               <%
    List<Employee> employeeList = (List<Employee>)request.getAttribute("employeeList");
%>
<input type="hidden" id="idEmployee" name="idEmployee">
<input type="hidden" id="action" name="action">
   
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Name</td>
                                    <td>Last name</td>
                                    <td>Birth date</td>
                                    <td>Role</td>
                                    <td>Department</td>
                                    <td>E-mail</td>                                 
                                </tr>
                            </thead>
                           
                             <% for(Employee e : employeeList) 
    {%>
     <tr class="info">

                                  

                                   <td>
  <a href="<%=request.getContextPath()%>/employee?idEmployee=<%=e.getId()%>&searchAction=searchById"><%=e.getId()%></a>
</td>   <td><%=e.getName()%></td>
<td><%= e.getLastName()%></td>
                                    <td><%= e.getBirthDate() %></td>
                                    <td><%= e.getRole() %></td>
                                    <td><%= e.getDepartment() %></td>
                                    <td><%= e.getEmail()%></td> 
                                    <td><a href="#" id="remove" 
   onclick="document.getElementById('idEmployee').value='<%=e.getId()%>';
            document.getElementById('action').value='remove';
            document.getElementById('employeeForm').submit();"> 
    <span class="glyphicon glyphicon-trash"/>
</a> </td>
                                </tr>
    <% }%>

                               
                                       
                        </table>  
                                     
                   
                        <br>           
                        <div class="alert alert-info">
                            No people found matching your search criteria
                        </div>
                              <c:if test="${not empty message}">                
    <div class="alert alert-success">
        ${message}
    </div>
</c:if>            
            </form>
            
            <form action ="jsp/new-employee.jsp">            
    <br></br>
    <button type="submit" class="btn btn-primary  btn-md">New employee</button> 
</form>
           
        </div>
    </body>
</html>