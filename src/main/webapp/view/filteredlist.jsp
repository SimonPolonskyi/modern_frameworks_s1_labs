<%-- 
    Document   : filteredlist
    Created on : Jan 29, 2023, 6:09:29 PM
    Author     : polonskiy
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Filtered List</title>
        <style>
            h1 {
                text-align: center;
            }

            page {
                width: 600px;
                margin:auto;
            }
            table {
                width: 400px;
                margin: 20px auto;
            }
            input [type=submit] {
                margin: auto;
            }
            .list, .list td, .list th {
                margin: auto;
                border:1px solid black;
                border-collapse: collapse;
                text-align: center;
            }
            .list td, .list th {
                padding: 10px;
            }
            table th {
                background-color: #deefff;
            }            
        </style>
    </head>
            <table class="list">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                </tr>
                <c:forEach var="student" items="${filtered}">
                    <tr>
                      
                        <td><c:out value="${student.getDoc().getId()}"/></td>
                        <td><c:out value="${student.getName()}"/></td>
                        <td><c:out value="${student.getSurname()}"/></td>
                    </tr>
                </c:forEach>
            </table>   
</html>
